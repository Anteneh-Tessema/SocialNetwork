package com.edu.mum.cs544.socialnetwork.socialnetwork.service.impl;


import com.edu.mum.cs544.socialnetwork.socialnetwork.dao.FollowingDao;
import com.edu.mum.cs544.socialnetwork.socialnetwork.dao.UserDao;
import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.Following;
import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.User;
import com.edu.mum.cs544.socialnetwork.socialnetwork.service.IFollowing;
import com.edu.mum.cs544.socialnetwork.socialnetwork.utility.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FollowingService implements IFollowing {
	
	@Autowired
	private FollowingDao followingDao;
	
	@Autowired
	private UserDao userDao;

	@Override
	public String follow(Following following) {
		try {
			followingDao.create(following);
			return Messages.save;
		} catch (Exception e) {
			return Messages.expectation;
		}
	}

	@Override
	public List<User> following(User user) {
		return followingDao.allFollowings().stream()
				           .filter(x -> x.getActingUser().equals(user))
				           .map(u -> u.getSourceUser())
				           .collect(Collectors.toList());
	}

	@Override
	public List<User> suggestedUsers(User user) {
		return userDao.allUsers().stream().filter(x -> !following(user).contains(x))
										  .filter(y -> !y.equals(user))
										  .collect(Collectors.toList());
	}

	@Override
	public List<Following> realFollowing(User user) {
		return followingDao.allFollowings().stream().filter(x -> x.getActingUser().equals(user)).collect(Collectors.toList());
	}

	@Override
	public String unfollowUser(Following following) {
		try {
			following.setDeleted(true);
			followingDao.update(following);
			return Messages.success;
		} catch (Exception e) {
			return Messages.expectation;
		}
	}

	@Override
	public Following findOne(String id) {
		return followingDao.findOne(id);
	}

}
