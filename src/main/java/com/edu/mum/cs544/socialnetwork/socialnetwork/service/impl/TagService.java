package com.edu.mum.cs544.socialnetwork.socialnetwork.service.impl;


import com.edu.mum.cs544.socialnetwork.socialnetwork.dao.TagDao;
import com.edu.mum.cs544.socialnetwork.socialnetwork.domain.Tag;
import com.edu.mum.cs544.socialnetwork.socialnetwork.service.IPost;
import com.edu.mum.cs544.socialnetwork.socialnetwork.service.ITag;
import com.edu.mum.cs544.socialnetwork.socialnetwork.utility.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@Transactional
public class TagService implements ITag {
	
	@Autowired
	private TagDao tagdao;
	
	@Autowired
	private IPost postService;

	@Override
	public String newTag(Tag tag) {
		try {
			tag.setTitle(tag.getTitle().toUpperCase());
		   tagdao.create(tag);
		   return Messages.save;
		}catch (Exception e) {
			return Messages.expectation;
		}
	}

	@Override
	public Tag findOne(String name) {
	 return tagdao.allTags().stream().filter(x -> x.getTitle().equalsIgnoreCase(name)).findAny().orElse(null);
	}

	@Override
	public String delete(Tag tag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tag> allTags() {
		return tagdao.allTags().stream().filter(x -> !x.isDeleted()).collect(Collectors.toList());
	}

	

	@Override
	public Tag findById(String id) {
		return tagdao.findOne(id);
	}
	
	@Override
	public Map<Tag, Integer> tagPosts() {
		Map<Tag, Integer> map = new HashMap<>();
		for(Tag tag: allTags()) {
			map.put(tag, postService.tagPosts(tag).size());
		}
		return map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
				                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
	}

}
