package com.edu.mum.cs544.socialnetwork.socialnetwork.controller;


import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.Post;
import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.Tag;
import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.User;
import com.edu.mum.cs544.socialnetwork.socialnetwork.service.*;
import com.edu.mum.cs544.socialnetwork.socialnetwork.service.impl.AdvertisementService;
import com.edu.mum.cs544.socialnetwork.socialnetwork.utility.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class Access {

	@Autowired
	AdvertisementService advertisementService;

	@Autowired
	private IPost postService;

	@Autowired
	private IFollowing followingService;

	@Autowired
	private IFollower followerService;

	@Autowired
	private IUser userService;
	
	@Autowired
	private ITag tagService;

	@GetMapping(value = {"/"})
	public String homePage(){
		return "welcomepage";
	}
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String landingPage() {
		return "login";
	}

	@RequestMapping(value = "{option}", method = RequestMethod.GET)
	public String accessPage(@PathVariable("option") String option, ModelMap model, HttpSession session) {
		String result = "";
		try {
			User user = (User) session.getAttribute("user");
			if (option.equals("home")) {
				model.addAttribute("posts", postService.allHomePost(user));
				model.addAttribute("suggestions", followingService.suggestedUsers(user));
				model.addAttribute("followers", followerService.followers(user).size());
				model.addAttribute("followings", followingService.following(user).size());
				model.addAttribute("tags", tagService.tagPosts());
				model.addAttribute("advert", advertisementService.getAllAdvertisementList());
				result = "back-End/client/home";
			} else if (option.equals("logout")) {
				session.removeAttribute("user");
				return "redirect:/";
			} else if (option.equals("myfollowers")) {
				model.addAttribute("myFollowers", followerService.followers(user));
				model.addAttribute("suggestions", followingService.suggestedUsers(user));
				model.addAttribute("followings", followingService.following(user).size());
				result = "back-End/client/followers";
			} else if (option.equals("myfollowings")) {
				model.addAttribute("myFollowings", followingService.realFollowing(user));
				model.addAttribute("suggestions", followingService.suggestedUsers(user));
				model.addAttribute("followers", followerService.followers(user).size());
				result = "back-End/client/followings";
			} else if (option.equals("personalWall")) {
				List<Post> posts = postService.personalAndShared(user);
				model.addAttribute("posts", posts);
				model.addAttribute("user", user);
				model.addAttribute("suggestions", followingService.suggestedUsers(user));
				model.addAttribute("followers", followerService.followers(user).size());
				model.addAttribute("followings", followingService.following(user).size());
				return "back-End/client/wall";
			} else if (option.contains("userWall")) {
				System.out.println("emailAddress:"+option.split("_")[1]);
				User access = userService.findOne(option.split("_")[1]);
				System.out.println("username :"+access.getFirstName());
				List<Post> posts = postService.personalAndShared(access);
				model.addAttribute("posts", posts);
				model.addAttribute("user", access);
				model.addAttribute("suggestions", followingService.suggestedUsers(user));
				model.addAttribute("followers", followerService.followers(user).size());
				model.addAttribute("followings", followingService.following(user).size());
				return "back-End/client/wall";
			}else if(option.contains("tagPosts")) {
				Tag tag = tagService.findById(option.split("_")[1]);
				Map<Tag, Integer> tags = tagService.tagPosts();
				List<Post> tagposts = postService.tagPosts(tag);
				tags.remove(tag);
				model.addAttribute("tags", tags);
				model.addAttribute("tag", tag);
				model.addAttribute("posts", tagposts);
				model.addAttribute("suggestions", followingService.suggestedUsers(user));
				model.addAttribute("myFollowers", followerService.followers(user));

				model.addAttribute("followings", followingService.following(user).size());
				return "back-End/client/tagPosts";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = Messages.UNKNOWN_PAGE;
		}
		return result;
	}

}
