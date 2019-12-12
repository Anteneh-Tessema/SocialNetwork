package com.edu.mum.cs544.socialnetwork.socialnetwork.service;

import com.mum.project.socialnetwork.socialnetwork.domain.Following;
import com.mum.project.socialnetwork.socialnetwork.domain.User;

import java.util.List;

public interface IFollowing {
	
	String follow(Following following);
	
	String unfollowUser(Following following);
	
	List<User> following(User user);
	
	List<Following> realFollowing(User user);
	
	List<User> suggestedUsers(User user);
	
	Following findOne(String id);

}
