package com.edu.mum.cs544.socialnetwork.socialnetwork.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
@AllArgsConstructor
@Data
@EqualsAndHashCode
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

}
