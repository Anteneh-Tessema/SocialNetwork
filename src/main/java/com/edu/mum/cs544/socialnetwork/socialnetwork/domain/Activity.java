package com.mum.project.socialnetwork.socialnetwork.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class Activity implements Serializable{
	
	
	
	private static final long serialVersionUID = 1L;

	private LocalDateTime recordeDate;
	
	private boolean  deleted;
	
	@ManyToOne
	private Post post;
	
	@ManyToOne
	private User addedBy;
	
	
	public Activity() {
		this.recordeDate = LocalDateTime.now();
		this.deleted = Boolean.FALSE;
	}


	public User getAddedBy() {
		return addedBy;
	}


	public void setAddedBy(User addedBy) {
		this.addedBy = addedBy;
	}


	public LocalDateTime getRecordeDate() {
		return recordeDate;
	}


	public void setRecordeDate(LocalDateTime recordeDate) {
		this.recordeDate = recordeDate;
	}


	public boolean isDeleted() {
		return deleted;
	}


	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}


	public Post getPost() {
		return post;
	}


	public void setPost(Post post) {
		this.post = post;
	}
	
	
	

}
