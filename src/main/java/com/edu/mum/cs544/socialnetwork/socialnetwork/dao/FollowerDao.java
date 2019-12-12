package com.edu.mum.cs544.socialnetwork.socialnetwork.dao;

import com.mum.project.socialnetwork.socialnetwork.domain.Follower;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FollowerDao extends GenericDao<Follower>{
	
	public List<Follower> allFollowers(){
		return allObejcts().stream()
				           .filter(i -> !i.isDeleted())
				           .map(y -> y)
				           .collect(Collectors.toList());
	}

}
