package com.edu.mum.cs544.socialnetwork.socialnetwork.service.impl;


import com.edu.mum.cs544.socialnetwork.socialnetwork.dao.FollowerDao;
import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.Follower;
import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.User;
import com.edu.mum.cs544.socialnetwork.socialnetwork.service.IFollower;
import com.edu.mum.cs544.socialnetwork.socialnetwork.utility.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FollowerService implements IFollower {
	
	@Autowired
	private FollowerDao followerDao;

	@Override
	public String addFollower(Follower follower) {
		try {
			followerDao.create(follower);
			return Messages.save;
		} catch (Exception e) {
			return Messages.expectation;
		}
	}

	@Override
	public List<Follower> followers(User actorUser) {
		return followerDao.allFollowers().stream()
				          .filter(x -> x.getActingUser().equals(actorUser))
				          .collect(Collectors.toList());
	}

}
