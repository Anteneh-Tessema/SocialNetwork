package com.edu.mum.cs544.socialnetwork.socialnetwork.controller;


import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.*;
import com.edu.mum.cs544.socialnetwork.socialnetwork.service.*;
import com.edu.mum.cs544.socialnetwork.socialnetwork.utility.Md5;
import com.edu.mum.cs544.socialnetwork.socialnetwork.utility.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@RestController
public class ActionRequest {

	@Autowired
	private IUser userService;

	@Autowired
	private IPost postService;

	@Autowired
	private ICommentService commentService;

	@Autowired
	private ILike likeService;

	@Autowired
	private IFollowing followingService;

	@Autowired
	private IFollower followerService;

	@Autowired
	private IShare shareService;

	@Autowired
	private ITag tagService;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@SuppressWarnings("null")
	@RequestMapping(value = "formSubmission/{option}", method = RequestMethod.POST)
	public String submitAction(@PathVariable("option") String option, @RequestParam Map<String, String> map,
			HttpSession session) {
		String result = "";
		try {
			if (option.equals("createAccount")) {
				User user = userService.findByUsername(map.get("username"));
				if (user != null) {
					result = Messages.account_exist;
				} else {
					user = new User();
					user.setFirstName(map.get("names"));
					user.setEmailAddress(map.get("email"));
					user.setGender(map.get("gender"));
					System.out.println(map.get("dob"));
					user.setBirthDate(LocalDate.parse(map.get("dob"), formatter));
					user.setPassword(Md5.md5(map.get("password")));
					result = userService.createAccount(user);
				}
			} else if (option.equals("addPost")) {
				User user = (User) session.getAttribute("user");
				Post post = new Post();
				post.setDescription(map.get("description"));
				Tag tagDetails = new Tag();
				if (post.getDescription().contains("#")) {
					String tag = post.getDescription();
					int startIndex = tag.indexOf("#");
					String subs = tag.substring(startIndex, tag.length());

					String tagContent = subs.split(" ")[0];
					tagDetails = tagService.findOne(tagContent);
					System.out.println("content result" + tagDetails);
					if (tagDetails == null) {
						tagDetails = new Tag();
						tagDetails.setTitle(tagContent);
						tagService.newTag(tagDetails);
					}
					// String pattern = "<a
					// href=\"tagDetails_"+tagDetails.getId()+"\">"+tagContent+"</a>";
					// post.setDescription(post.getDescription().replaceFirst(tagContent, pattern));
					post.setTag(tagDetails);
				}
				post.setUser(user);
				result = postService.createPost(post);
			} else if (option.equals("login")) {
				User user = userService.findByUsername(map.get("username"));
				if (user != null) {
					if (user.getPassword().equals(Md5.md5(map.get("password")))) {
						session.setAttribute("user", user);
						result = Messages.access_approved;
					} else {
						result = Messages.invalid_password;
					}
				} else {
					result = Messages.account_not_found;
				}
			} else if (option.contains("addComment")) {
				Post post = postService.findOne(option.split("_")[1]);
				Comment comment = new Comment();
				comment.setAddedBy((User) session.getAttribute("user"));
				comment.setContent(map.get("content"));
				comment.setPost(post);
				result = commentService.addComment(comment);
			} else if (option.contains("likePost")) {
				User user = (User) session.getAttribute("user");
				Post post = postService.findOne(option.split("_")[1]);
				if (likeService.findLike(user, post) == false) {
					PostLikes postLike = new PostLikes();
					postLike.setAddedBy(user);
					postLike.setPost(post);
					return likeService.addLike(postLike);
				} else {
					return "Sorry sir, you already liked this post";
				}
			} else if (option.equals("followUser")) {
				User sourceUser = (User) session.getAttribute("user");
				User destinationUser = userService.findByUsername(map.get("username"));
				Following following = new Following();
				following.setActingUser(sourceUser);
				following.setSourceUser(destinationUser);
				Follower follower = new Follower();
				follower.setActingUser(destinationUser);
				follower.setSourceUser(sourceUser);
				followerService.addFollower(follower);
				return followingService.follow(following);
			} else if (option.equals("unfollowUser")) {
				Following following = followingService.findOne(map.get("userId"));
				return followingService.unfollowUser(following);
			} else if (option.equals("sharePost")) {
				User sharedBy = (User) session.getAttribute("user");
				Post post = postService.findOne(map.get("postId"));
				if (shareService.checkShared(sharedBy, post) == false) {
					if (!post.getUser().equals(sharedBy)) {

						// instance to be used for creating new post and map it as share
						Post sharedPost = new Post();
						Share share = new Share();

						sharedPost.setDescription(post.getDescription());
						sharedPost.setSharedBy(sharedBy);
						sharedPost.setUser(post.getUser());

						postService.createPost(sharedPost);

						share.setAddedBy(post.getUser());
						share.setComment("");
						share.setPost(post);
						share.setSharedBy(sharedBy);

						return shareService.newShare(share);
					} else {
						return "Sorry sir this is your own post";
					}
				} else {
					return "Sorry sir, you already shared this post";
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			result = Messages.expectation;
		}
		return result;
	}

}
