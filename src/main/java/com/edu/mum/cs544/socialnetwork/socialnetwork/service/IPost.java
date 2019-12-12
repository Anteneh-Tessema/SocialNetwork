package com.edu.mum.cs544.socialnetwork.socialnetwork.service;

import com.mum.project.socialnetwork.socialnetwork.domain.Post;
import com.mum.project.socialnetwork.socialnetwork.domain.Tag;
import com.mum.project.socialnetwork.socialnetwork.domain.User;

import java.util.List;

public interface IPost {
	
	String createPost(Post post);
	
	String deletepost(Post post);
	
	List<Post> userPosts(User user);
	
	List<Post> allHomePost(User user);
	
	List<Post> personalAndShared(User user);
	
	Post findOne(String id);
	
	
	List<Post> tagPosts(Tag tag);

}
