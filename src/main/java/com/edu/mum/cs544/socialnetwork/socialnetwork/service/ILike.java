package com.edu.mum.cs544.socialnetwork.socialnetwork.service;



import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.Post;
import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.PostLikes;
import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.User;

import java.util.List;

public interface ILike {
	
	String addLike(PostLikes like);
	
	List<PostLikes> postLikes(Post post);
	
	boolean findLike(User user, Post post);

}
