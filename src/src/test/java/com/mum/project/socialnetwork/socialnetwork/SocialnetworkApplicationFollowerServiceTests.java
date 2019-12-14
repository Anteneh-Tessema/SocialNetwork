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
import com.mum.project.socialnetwork.socialnetwork.domain.RelationShip;
import com.mum.project.socialnetwork.socialnetwork.domain.User;
import com.mum.project.socialnetwork.socialnetwork.implementation.FollowerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SocialnetworkApplicationFollowerServiceTests {
	@Test
	public void contextLoads() { 
	}
	@Autowired
	private FollowerService followerService;
	 
	@Test
	public void TestCreateFollwer() {
		Follower follower = new Follower();
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
		follower.setActingUser(user);
		assertEquals("FName", follower.getActingUser().getFirstName());
		assertEquals("LName", follower.getActingUser().getLastName());
		assertEquals("test@gmail.com", follower.getActingUser().getEmailAddress());
		assertEquals("MALE", follower.getActingUser().getGender());
		assertEquals("210-123-1234", follower.getActingUser().getPhoneNumber());
		assertEquals("test", follower.getActingUser().getPassword());
		assertEquals(LocalDateTime.of(2019, Month.APRIL, 29, 19, 30, 40), follower.getActingUser().getRecordedDate());
		assertEquals(LocalDate.of(2005, 10, 10), follower.getActingUser().getBirthDate());
		 
		 
	 
	}
}
