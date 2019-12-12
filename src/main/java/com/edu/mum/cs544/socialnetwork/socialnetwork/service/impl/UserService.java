package com.edu.mum.cs544.socialnetwork.socialnetwork.service.impl;

import com.mum.project.socialnetwork.socialnetwork.dao.UserDao;
import com.mum.project.socialnetwork.socialnetwork.domain.User;
import com.mum.project.socialnetwork.socialnetwork.serviceinterface.IUser;
import com.mum.project.socialnetwork.socialnetwork.utility.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class UserService implements IUser{
	
	@Autowired
	private UserDao userDao;

	@Override
	public String createAccount(User user) {
		try {
			userDao.create(user);
			return Messages.save;
		} catch (Exception e) {
			e.printStackTrace();
			return Messages.expectation;
		}
	}

	@Override
	public String updateAccount(User user) {
		try{
			userDao.update(user);
			return Messages.update;
		}catch (Exception e) {
			return Messages.expectation;
		}
	}

	@Override
	public String deleteAccount(User user) {
		try {
			user.setDeleted(true);
			userDao.update(user);
			return Messages.delete;
		} catch (Exception e) {
			return Messages.expectation;
		}
	}

	@Override
	public User findByUsername(String username) {
		 return userDao.allUsers().stream().filter(x -> x.getEmailAddress().equals(username)).findAny().orElse(null);
	}

	@Override
	public User findOne(String id) {
		return userDao.findOne(id);
	}

}
