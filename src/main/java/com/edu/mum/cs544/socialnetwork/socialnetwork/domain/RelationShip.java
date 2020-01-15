package com.edu.mum.cs544.socialnetwork.socialnetwork.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;


@MappedSuperclass
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class RelationShip implements Serializable{

	private static final long serialVersionUID = 1L;

	//source user
	@ManyToOne
	private User sourceUser;
	
	//actingUser
	@ManyToOne
	private User actingUser;
	
	private LocalDateTime recordDate;
	
	private boolean deleted;
	
	
	public RelationShip() {
		this.recordDate = LocalDateTime.now();
		this.deleted = Boolean.FALSE;
	}
	public boolean isDeleted() {
		return deleted;
	}


}
