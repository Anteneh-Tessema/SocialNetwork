package com.edu.mum.cs544.socialnetwork.socialnetwork.dao;


import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.Comment;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CommentDao extends GenericDao<Comment>{
	
	
	public List<Comment> allComments(){
		return allObejcts().stream().filter(x -> !x.isDeleted())
				.map(z -> z)
				.sorted((Comparator.comparing(Comment::getRecordeDate)))
				.collect(Collectors.toList());
	}

}
