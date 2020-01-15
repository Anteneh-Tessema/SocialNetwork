package com.edu.mum.cs544.socialnetwork.socialnetwork.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Tag implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	private String title;
	
	private String posts;
	
	private boolean deleted;
	
	private LocalDateTime recordedDate;
	
	public Tag() {
		id = UUID.randomUUID().toString();
		this.deleted = Boolean.FALSE;
		this.recordedDate = LocalDateTime.now();
	}
	public boolean isDeleted() {
		return deleted;
	}

}
