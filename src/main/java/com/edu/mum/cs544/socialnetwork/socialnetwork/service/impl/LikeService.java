package com.edu.mum.cs544.socialnetwork.socialnetwork.service.impl;

import com.mum.project.socialnetwork.socialnetwork.dao.LikeDao;
import com.mum.project.socialnetwork.socialnetwork.domain.Post;
import com.mum.project.socialnetwork.socialnetwork.domain.PostLikes;
import com.mum.project.socialnetwork.socialnetwork.domain.User;
import com.mum.project.socialnetwork.socialnetwork.serviceinterface.ILike;
import com.mum.project.socialnetwork.socialnetwork.utility.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LikeService implements ILike {

	@Autowired
	private LikeDao likeDao;

	@Override
	public String addLike(PostLikes like) {
		try {
			likeDao.create(like);
			return Messages.save;
		} catch (Exception e) {
			return Messages.expectation;
		}
	}

	@Override
	public List<PostLikes> postLikes(Post post) {
		return likeDao.allLikes().stream()
				                 .filter(x -> x.getPost().equals(post))
				                 .collect(Collectors.toList());
	}

	@Override
	public boolean findLike(User user,Post post) {
		return postLikes(post).stream().anyMatch(x -> x.getAddedBy().equals(user));
	}

}
