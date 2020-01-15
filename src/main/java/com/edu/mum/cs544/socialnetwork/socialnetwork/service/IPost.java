package com.edu.mum.cs544.socialnetwork.socialnetwork.service;



import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.Post;
import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.Tag;
import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.User;

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
