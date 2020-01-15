package com.edu.mum.cs544.socialnetwork.socialnetwork.dao;


import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserDao extends GenericDao<User>{
	
	
	public List<User> allUsers(){
		return allObejcts().stream().filter(x -> !x.isDeleted())
				 		    .collect(Collectors.toList());
	}

}
