package com.edu.mum.cs544.socialnetwork.socialnetwork.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	private String firstName;
	
	private String lastName;
	
	private String gender;
	
	private LocalDate birthDate;
	
	private String emailAddress;
	
	private String phoneNumber;
	
	private boolean deleted;
	
	private LocalDateTime recordedDate;
	
	private String password;

	public User() {
		id = UUID.randomUUID().toString();
		this.deleted = Boolean.FALSE;
		this.recordedDate = LocalDateTime.now();
	}
	public boolean isDeleted() {
		return deleted;
	}

}
