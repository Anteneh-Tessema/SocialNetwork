package com.edu.mum.cs544.socialnetwork.socialnetwork.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
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

	@ManyToMany(cascade = CascadeType.ALL,fetch= FetchType.EAGER)
	@JoinTable(name="user_role",joinColumns = {@JoinColumn(name = "user_id")},inverseJoinColumns = {@JoinColumn(name = "role_id")})
	private Set<Role> role;

	public User() {
		id = UUID.randomUUID().toString();
		this.deleted = Boolean.FALSE;
		this.recordedDate = LocalDateTime.now();
	}
	public boolean isDeleted() {
		return deleted;
	}

}
