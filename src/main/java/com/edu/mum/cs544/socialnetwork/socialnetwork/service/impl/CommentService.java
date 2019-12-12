package com.edu.mum.cs544.socialnetwork.socialnetwork.service.impl;


import com.edu.mum.cs544.socialnetwork.socialnetwork.dao.CommentDao;
import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.Comment;
import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.Post;
import com.edu.mum.cs544.socialnetwork.socialnetwork.service.ICommentService;
import com.edu.mum.cs544.socialnetwork.socialnetwork.utility.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CommentService implements ICommentService {
	
	@Autowired
	private CommentDao commentDao;

	@Override
	public String addComment(Comment comment) {
		try {
			commentDao.create(comment);
			return Messages.save;
		} catch (Exception e) {
			return Messages.expectation;
		}
	}

	@Override
	public String updateComment(Comment comment) {
		try {
			commentDao.update(comment);
			return Messages.update;
		} catch (Exception e) {
			return Messages.expectation;
		}
	}

	@Override
	public String deleteComment(Comment comment) {
		try {
			commentDao.delete(comment);
			return Messages.delete;
		} catch (Exception e) {
			return Messages.expectation;
		}
	}

	@Override
	public List<Comment> postComments(Post post) {
		return commentDao.allComments().stream()
				         .filter(x -> x.getPost().equals(post)).limit(4)
				         .collect(Collectors.toList());
	}

	

}
