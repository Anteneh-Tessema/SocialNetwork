package com.edu.mum.cs544.socialnetwork.socialnetwork.service;

import com.mum.project.socialnetwork.socialnetwork.domain.Tag;

import java.util.List;
import java.util.Map;

public interface ITag {
	
	
	String newTag(Tag tag);
	
	Tag findOne(String name);
	
	String delete(Tag tag);
	
	List<Tag> allTags();
	
	
	Map<Tag, Integer> tagPosts();
	
	Tag findById(String id);

}
