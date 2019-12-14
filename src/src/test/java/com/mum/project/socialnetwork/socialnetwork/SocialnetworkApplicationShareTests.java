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

import com.mum.project.socialnetwork.socialnetwork.dao.ShareDao;
import com.mum.project.socialnetwork.socialnetwork.domain.Post;
import com.mum.project.socialnetwork.socialnetwork.domain.Share;
import com.mum.project.socialnetwork.socialnetwork.domain.User;
import com.mum.project.socialnetwork.socialnetwork.implementation.ShareService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SocialnetworkApplicationShareTests {
	@Test
	public void contextLoads() {
	} 
	@Autowired
	private ShareService shareService;
	@Test
	public void createShareTest() { 
		Share share = new Share();
		 
		User user = new User();
		user.setId("123");
		user.setBirthDate(LocalDate.of(2005, 10, 10)); 
		user.setEmailAddress("test@gmail.com");
		user.setFirstName("FName");
		user.setGender("MALE");
		user.setLastName("LName");
		user.setPassword("test");
		user.setPhoneNumber("210-123-1234");
		user.setRecordedDate(LocalDateTime.of(2019, Month.APRIL, 29, 19, 30, 40));
  
		  
		
		Post post = new Post();

		post.setId("12345"); 
		post.setDescription("Test comment");
		post.setRecordedDate(LocalDateTime.of(2019, Month.APRIL, 29, 19, 30, 40));
 
		share.setId("8753");
		share.setPost(post);
		share.setAddedBy(user);
		 share.setRecordeDate(LocalDateTime.of(2019, Month.APRIL, 29, 19, 30, 40));
		
		assertEquals("12345", share.getPost().getId());
		assertEquals("Test comment", share.getPost().getDescription());
		assertEquals(LocalDateTime.of(2019, Month.APRIL, 29, 19, 30, 40), share.getPost().getRecordedDate());
		
		  
		assertEquals("FName", share.getAddedBy().getFirstName());
		assertEquals("LName", share.getAddedBy().getLastName());
		assertEquals(LocalDate.of(2005, 10, 10), share.getAddedBy().getBirthDate());
		assertEquals("MALE", share.getAddedBy().getGender());
		assertEquals("test", share.getAddedBy().getPassword());
		assertEquals("210-123-1234", share.getAddedBy().getPhoneNumber());
		assertEquals("test@gmail.com", share.getAddedBy().getEmailAddress());
	
		
		assertEquals("8753", share.getId()); 
		assertEquals(LocalDateTime.of(2019, Month.APRIL, 29, 19, 30, 40), share.getRecordeDate());
		 
		assertEquals(user, share.getAddedBy()); 
		
		assertEquals(post, share.getPost());
		
	}  
	 
	@Test
	public void deleteShareTest() {
		Share share = new Share();
		 
    
		
//		assertTrue (shareService.removeShare(share).equals(share)); 

        assertFalse(shareService.removeShare(share).equals(share)); 

        
	}
}
