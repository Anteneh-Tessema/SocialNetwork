package com.edu.mum.cs544.socialnetwork.socialnetwork.service;

import com.mum.project.socialnetwork.socialnetwork.domain.Post;
import com.mum.project.socialnetwork.socialnetwork.domain.Share;
import com.mum.project.socialnetwork.socialnetwork.domain.User;

import java.util.List;

public interface IShare {
	
	String newShare(Share share);
	
	String removeShare(Share share);
	
	List<Share> postShares(Post post);
	
	boolean checkShared(User user, Post post);
	
	

}
