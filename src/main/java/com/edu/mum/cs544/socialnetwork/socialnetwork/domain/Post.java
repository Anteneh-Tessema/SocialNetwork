package com.edu.mum.cs544.socialnetwork.socialnetwork.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@Data
@EqualsAndHashCode
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

}
