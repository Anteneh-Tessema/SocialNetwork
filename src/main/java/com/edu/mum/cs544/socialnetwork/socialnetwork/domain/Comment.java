package com.mum.project.socialnetwork.socialnetwork.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
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
