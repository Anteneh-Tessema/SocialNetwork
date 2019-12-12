package com.edu.mum.cs544.socialnetwork.socialnetwork.dao;


import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.PostLikes;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class LikeDao extends GenericDao<PostLikes>{
	
	public List<PostLikes> allLikes(){
		return allObejcts().stream()
		           .filter(i -> !i.isDeleted())
		           .map(y -> y)
		           .collect(Collectors.toList());
	}

}
