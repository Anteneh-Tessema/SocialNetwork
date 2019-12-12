package com.edu.mum.cs544.socialnetwork.socialnetwork.service;

import com.mum.project.socialnetwork.socialnetwork.domain.User;

public interface IUser {
	
	String createAccount(User user);
	
	String updateAccount(User user);
	
	String deleteAccount(User user);
	
	User findByUsername(String username);
	
	User findOne(String id);
	

}
