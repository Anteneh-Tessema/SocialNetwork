package com.edu.mum.cs544.socialnetwork.socialnetwork.dao;


import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostDao extends GenericDao<Post>{

	public List<Post> allPosts(){
		return allObejcts().stream()
		           .filter(i -> !i.isDeleted())
		           .map(y -> y)
		           .sorted((Comparator.comparing(Post::getRecordedDate)))
		           .collect(Collectors.toList());
	}

}
