package com.mum.project.socialnetwork.socialnetwork.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Friend extends RelationShip{
	
	
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	private String id;
	
	
	public Friend() {
		this.id = UUID.randomUUID().toString();
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	

}
