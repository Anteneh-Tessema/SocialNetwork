package com.edu.mum.cs544.socialnetwork.socialnetwork.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Following extends RelationShip{
	
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	
	public Following() {
		this.id = UUID.randomUUID().toString();
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	

}
