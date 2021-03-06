package com.edu.mum.cs544.socialnetwork.socialnetwork.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Comment extends Activity{

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	private String content;
	
	
	public Comment() {
		this.id = UUID.randomUUID().toString();
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	

}
