package com.edu.mum.cs544.socialnetwork.socialnetwork.dao;

import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.Share;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ShareDao extends GenericDao<Share>{
	
	public List<Share> allShares(){
		return allObejcts().stream()
		           .filter(i -> !i.isDeleted())
		           .map(y -> y)
		           .collect(Collectors.toList());
	}

}
