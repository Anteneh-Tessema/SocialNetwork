package com.edu.mum.cs544.socialnetwork.socialnetwork.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
public class Follower extends RelationShip{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private String id;
	
	public Follower() {
//		this.id = UUID.randomUUID().toString();
	}

	
	

}
