package com.edu.mum.cs544.socialnetwork.socialnetwork.service.impl;


import com.edu.mum.cs544.socialnetwork.socialnetwork.dao.ShareDao;
import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.Post;
import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.Share;
import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.User;
import com.edu.mum.cs544.socialnetwork.socialnetwork.service.IShare;
import com.edu.mum.cs544.socialnetwork.socialnetwork.utility.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ShareService implements IShare {
	
	@Autowired
	private ShareDao shareDao;

	@Override
	public String newShare(Share share) {
		try {
			shareDao.create(share);
			return Messages.save;
		} catch (Exception e) {
			e.printStackTrace();
			return Messages.expectation;
		}
	}

	@Override
	public String removeShare(Share share) {
		try {
			share.setDeleted(true);
			shareDao.update(share);
			return Messages.update;
		} catch (Exception e) {
			return Messages.expectation;
		}
	}

	@Override
	public List<Share> postShares(Post post) {
		return shareDao.allObejcts().stream()
									.filter(x -> x.getPost().equals(post))
									.collect(Collectors.toList());
	}

	@Override
	public boolean checkShared(User user, Post post) {
		return postShares(post).stream().anyMatch(x -> x.getSharedBy().equals(user));
	}

	

}
