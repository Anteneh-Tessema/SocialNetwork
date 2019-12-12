package com.edu.mum.cs544.socialnetwork.socialnetwork.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;


@MappedSuperclass
@Data
@AllArgsConstructor
@EqualsAndHashCode
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
	public boolean isDeleted() {
		return deleted;
	}


}
