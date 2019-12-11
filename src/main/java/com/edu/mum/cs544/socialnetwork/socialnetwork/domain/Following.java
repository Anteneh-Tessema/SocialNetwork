package com.edu.mum.cs544.socialnetwork.socialnetwork.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Following extends RelationShip{
	
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private String id;
	
	
	public Following() {
		this.id = UUID.randomUUID().toString();
	}

}
