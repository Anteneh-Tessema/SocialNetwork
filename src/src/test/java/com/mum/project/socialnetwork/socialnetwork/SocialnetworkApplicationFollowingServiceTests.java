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

import com.mum.project.socialnetwork.socialnetwork.domain.Follower;
import com.mum.project.socialnetwork.socialnetwork.domain.Following;
import com.mum.project.socialnetwork.socialnetwork.domain.User;
import com.mum.project.socialnetwork.socialnetwork.implementation.FollowingService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SocialnetworkApplicationFollowingServiceTests {
	@Test
	public void contextLoads() {
	}
	@Autowired
	private FollowingService followingService;
	
	@Test
	public void TestCreateFollwing() {
		
		
		Following following = new Following();
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
		 
			//	followerService.addFollower(follower);  
		following.setActingUser(user);
		assertEquals("FName", following.getActingUser().getFirstName());
		assertEquals("LName", following.getActingUser().getLastName());
		assertEquals("test@gmail.com", following.getActingUser().getEmailAddress());
		assertEquals("MALE", following.getActingUser().getGender());
		assertEquals("210-123-1234", following.getActingUser().getPhoneNumber());
		assertEquals("test", following.getActingUser().getPassword());
		assertEquals(LocalDateTime.of(2019, Month.APRIL, 29, 19, 30, 40), following.getActingUser().getRecordedDate());
		assertEquals(LocalDate.of(2005, 10, 10), following.getActingUser().getBirthDate());
		 
		 /*
		Following follow = new Following();
		follow.setRecordDate(LocalDateTime.of(2019, Month.APRIL,29, 19, 30, 40));
		follow.setId("Medor-1234");
		//followingService.follow(follow);
		
		assertEquals(LocalDateTime.of(2019, Month.APRIL,29, 19, 30, 40),follow.getRecordDate());
		assertEquals("Medor-1234",follow.getId());*/
		
		
	}
}
