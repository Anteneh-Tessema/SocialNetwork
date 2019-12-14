package com.mum.project.socialnetwork.socialnetwork; 

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import org.apache.tomcat.jni.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mum.project.socialnetwork.socialnetwork.domain.Post;
import com.mum.project.socialnetwork.socialnetwork.implementation.PostService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SocialnetworkApplicationPostsTests {
	@Test
	public void contextLoads() {
	}

	@Autowired
	private PostService postsDao;

	@Test
	public void testCreatePost() {

		Post post = new Post();

		post.setId("12345");
		post.setDeleted(false);
		post.setDescription("Test comment");
		post.setRecordedDate(LocalDateTime.of(2019, Month.APRIL, 29, 19, 30, 40));

//		postsDao.createPost(post);
		assertEquals("12345", post.getId());
		assertEquals(false, post.isDeleted());
		assertEquals("Test comment", post.getDescription());
		assertEquals(LocalDateTime.of(2019, Month.APRIL, 29, 19, 30, 40), post.getRecordedDate());
	}

	@Test
	public void testDelete() {

		Post post = new Post();
		assertEquals("Exception happened , please try again", postsDao.deletepost(post));

		assertFalse(postsDao.deletepost(post).equals(post));

//			post.setId("123");
//			post.setDescription("post description");
//			assertEquals("Record is successfully deleted",postsDao.deletepost(post));

//		post.getDescription();
//		post.getId();

	}

}
