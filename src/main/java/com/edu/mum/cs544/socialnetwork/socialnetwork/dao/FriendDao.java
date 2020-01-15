package com.edu.mum.cs544.socialnetwork.socialnetwork.dao;

import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.Friend;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FriendDao extends GenericDao<Friend>{
	
	public List<Friend> allFriends(){
		return allObejcts().stream()
		           .filter(i -> !i.isDeleted())
		           .map(y -> y)
		           .collect(Collectors.toList());
	}

}
