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
import com.mum.project.socialnetwork.socialnetwork.domain.User;
import com.mum.project.socialnetwork.socialnetwork.implementation.LikeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SocialnetworkApplicationLikeServiceTest {
	@Test
	public void contextLoads() {
	}

	@Autowired
	private LikeService likeService;

	@Test
	public void createAddLike() {
		 
		User user = new User();

		user.setId("123");
		user.setBirthDate(LocalDate.of(2005, 10, 10));
		user.setDeleted(false);
		user.setEmailAddress("test@gmail.com");
		user.setFirstName("FName");
		user.setGender("MALE");
		user.setLastName("LName");
		user.setPassword("test");
		user.setPhoneNumber("210-123-1234");
		user.setRecordedDate(LocalDateTime.of(2019, Month.APRIL, 29, 19, 30, 40));
  
		Post p = new Post();
		p.getId();
		p.setDescription("abdu");
		p.setId("123");
		p.setUser(user);

		PostLikes like = new PostLikes();

		like.setPost(p);
		like.setAddedBy(user);

		like.setAddedBy(user);
		like.setId("1234");
		like.setPost(p);
		like.setRecordeDate(LocalDateTime.of(2019, Month.APRIL, 29, 19, 30, 40));

		// likeService.addLike(like);
//		
//		assertEquals(p,likeService.postLikes(p));
		// assertTrue(likeService.addLike(like).equals(like));

		assertEquals("abdu", like.getPost().getDescription());
		assertEquals("123", like.getPost().getId());
		
		assertEquals(user, like.getPost().getUser());
		assertEquals("FName", like.getAddedBy().getFirstName());
		assertEquals("LName", like.getAddedBy().getLastName());
		assertEquals(LocalDate.of(2005, 10, 10), like.getAddedBy().getBirthDate());
		assertEquals("MALE", like.getAddedBy().getGender());
		assertEquals("test", like.getAddedBy().getPassword());
		assertEquals("210-123-1234", like.getAddedBy().getPhoneNumber());
		assertEquals("test@gmail.com", like.getAddedBy().getEmailAddress());
		
		assertEquals("1234", like.getId());
		assertEquals(user, like.getAddedBy());
		assertEquals(LocalDateTime.of(2019, Month.APRIL, 29, 19, 30, 40), like.getRecordeDate());
		assertEquals(p, like.getPost());
		
		
		assertFalse(likeService.addLike(like).equals(like));
	}

}
