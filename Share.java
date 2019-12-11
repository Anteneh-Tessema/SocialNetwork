package com.mum.project.socialnetwork.socialnetwork.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Share extends Activity{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	@ManyToOne
	private User sharedBy;
	
	private String comment;
	
	public Share() {
		this.id = UUID.randomUUID().toString();
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getSharedBy() {
		return sharedBy;
	}

	public void setSharedBy(User sharedBy) {
		this.sharedBy = sharedBy;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	

}
