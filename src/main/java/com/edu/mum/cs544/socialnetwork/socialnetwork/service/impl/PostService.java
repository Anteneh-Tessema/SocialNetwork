package com.edu.mum.cs544.socialnetwork.socialnetwork.service.impl;

import com.mum.project.socialnetwork.socialnetwork.dao.PostDao;
import com.mum.project.socialnetwork.socialnetwork.domain.Post;
import com.mum.project.socialnetwork.socialnetwork.domain.Tag;
import com.mum.project.socialnetwork.socialnetwork.domain.User;
import com.mum.project.socialnetwork.socialnetwork.serviceinterface.IFollowing;
import com.mum.project.socialnetwork.socialnetwork.serviceinterface.IPost;
import com.mum.project.socialnetwork.socialnetwork.serviceinterface.IShare;
import com.mum.project.socialnetwork.socialnetwork.utility.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class PostService implements IPost {

	@Autowired
	private PostDao postDao;

	@Autowired
	private IFollowing followingService;
	
	@Autowired
	private IShare shareService;

	@Override
	public String createPost(Post post) {
		try {
			postDao.create(post);
			return Messages.save;
		} catch (Exception e) {
			e.printStackTrace();
			return Messages.expectation;
		}
	}

	@Override
	public String deletepost(Post post) {
		try {
			post.setDeleted(true);
			postDao.update(post);
			return Messages.delete;
		} catch (Exception e) {
			return Messages.expectation;
		}
	}

	@Override
	public List<Post> userPosts(User user) {
		return postDao.allPosts().stream().filter(x -> x.getUser().equals(user)).collect(Collectors.toList());
	}

	@Override
	public List<Post> allHomePost(User user) {
		Stream<Post> userPosts = userPosts(user).stream().sorted(Comparator.comparing(Post::getRecordedDate));
		Stream<Post> followPosts = followingService.following(user).stream().flatMap(x -> userPosts(x).stream()).map(y -> y).sorted(Comparator.comparing(Post::getRecordedDate));
		return Stream.concat(userPosts, followPosts).sorted(Comparator.comparing(Post::getRecordedDate).reversed()).collect(Collectors.toList());

	}

	@Override
	public Post findOne(String id) {
		return postDao.findOne(id);
	}

	@Override
	public List<Post> personalAndShared(User user) {
		Stream<Post> posted = postDao.allPosts().stream().filter(x -> x.getUser().equals(user) && x.getSharedBy() == null);	
		Stream<Post> sharedPost = postDao.allPosts().stream().filter(x -> x.getSharedBy() != null && x.getSharedBy().equals(user));
		
		return Stream.concat(posted, sharedPost).collect(Collectors.toList());
		
	}

	@Override
	public List<Post> tagPosts(Tag tag) {
		return postDao.allPosts().stream().filter(x -> x.getTag() != null)
										  .filter(x -> x.getTag().equals(tag))
										  .collect(Collectors.toList());
	}

}
