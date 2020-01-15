package com.edu.mum.cs544.socialnetwork.socialnetwork.service;


import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.Follower;
import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.User;

import java.util.List;

public interface IFollower {
	
	String addFollower(Follower follower);
	
	List<Follower> followers(User actorUser);

}
