package com.mum.project.socialnetwork.socialnetwork;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mum.project.socialnetwork.socialnetwork.domain.Post;
import com.mum.project.socialnetwork.socialnetwork.domain.PostLikes;
import com.mum.project.socialnetwork.socialnetwork.domain.Tag;
import com.mum.project.socialnetwork.socialnetwork.domain.User;
import com.mum.project.socialnetwork.socialnetwork.implementation.LikeService;
import com.mum.project.socialnetwork.socialnetwork.implementation.TagService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SocialnetworkApplicationTagServiceTest {
	@Test
	public void contextLoads() {
	}

	@Autowired
	private TagService tagService;

	@Test
	public void createTag() { 
	 
		Tag tag = new Tag();

		tag.setPosts("Post content");
		tag.setId("1234");
		tag.setTitle("title");
		tag.setRecordedDate(LocalDateTime.of(2019, Month.APRIL, 29, 19, 30, 40));
		 
		// likeService.addLike(like);
//		
//		assertEquals(p,likeService.postLikes(p));
		// assertTrue(likeService.addLike(like).equals(like));

		assertEquals("Post content", tag.getPosts());
		assertEquals("1234", tag.getId());
		assertEquals("title", tag.getTitle());
		assertEquals(LocalDateTime.of(2019, Month.APRIL, 29, 19, 30, 40), tag.getRecordedDate());
		 
		
		
		assertFalse(tagService.newTag(tag).equals(tag));
	}

}
