package com.edu.mum.cs544.socialnetwork.socialnetwork.dao;

import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.Following;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FollowingDao extends GenericDao<Following>{
	
	public List<Following> allFollowings(){
		return allObejcts().stream()
		           .filter(i -> !i.isDeleted())
		           .map(y -> y)
		           .collect(Collectors.toList());
	}

}
