package com.edu.mum.cs544.socialnetwork.socialnetwork.service;

import com.mum.project.socialnetwork.socialnetwork.domain.Comment;
import com.mum.project.socialnetwork.socialnetwork.domain.Post;

import java.util.List;

public interface ICommentService {
	
	String addComment(Comment comment);
	
	String updateComment(Comment comment);
	
	String deleteComment(Comment comment);
	
	List<Comment> postComments(Post post);

}
