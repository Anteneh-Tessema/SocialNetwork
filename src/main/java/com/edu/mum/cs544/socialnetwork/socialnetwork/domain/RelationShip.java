package com.mum.project.socialnetwork.socialnetwork.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
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


	public User getSourceUser() {
		return sourceUser;
	}


	public void setSourceUser(User sourceUser) {
		this.sourceUser = sourceUser;
	}


	public User getActingUser() {
		return actingUser;
	}


	public void setActingUser(User actingUser) {
		this.actingUser = actingUser;
	}


	public LocalDateTime getRecordDate() {
		return recordDate;
	}


	public void setRecordDate(LocalDateTime recordDate) {
		this.recordDate = recordDate;
	}


	public boolean isDeleted() {
		return deleted;
	}


	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	
	
	

}
