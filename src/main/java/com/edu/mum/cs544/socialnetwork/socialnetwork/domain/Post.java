package com.mum.project.socialnetwork.socialnetwork.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Post implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	private String description;
	
	private LocalDateTime recordedDate;
	
	private boolean deleted;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private User sharedBy;
	
	@ManyToOne
	private Tag tag;
	
	
	public Post() {
		id = UUID.randomUUID().toString();
		this.recordedDate = LocalDateTime.now();
		this.deleted = Boolean.FALSE;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDateTime getRecordedDate() {
		return recordedDate;
	}


	public void setRecordedDate(LocalDateTime recordedDate) {
		this.recordedDate = recordedDate;
	}


	public boolean isDeleted() {
		return deleted;
	}


	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	


	public User getSharedBy() {
		return sharedBy;
	}
	
	


	public Tag getTag() {
		return tag;
	}


	public void setTag(Tag tag) {
		this.tag = tag;
	}


	public void setSharedBy(User sharedBy) {
		this.sharedBy = sharedBy;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
