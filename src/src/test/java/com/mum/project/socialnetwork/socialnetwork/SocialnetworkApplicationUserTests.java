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

import com.mum.project.socialnetwork.socialnetwork.domain.User;
import com.mum.project.socialnetwork.socialnetwork.implementation.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SocialnetworkApplicationUserTests {
	@Test
	public void contextLoads() {
	}

	@Autowired 
	private UserService userService;
  
	@Test
	public void createUserTest() {
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
  
//		 userService.createAccount(user); 

		assertEquals("FName", user.getFirstName());
		assertEquals("LName", user.getLastName());
		assertEquals("test@gmail.com", user.getEmailAddress());
		assertEquals("MALE", user.getGender());
		assertEquals("210-123-1234", user.getPhoneNumber());
		assertEquals("test", user.getPassword());
		assertEquals(LocalDateTime.of(2019, Month.APRIL, 29, 19, 30, 40), user.getRecordedDate());
		assertEquals(LocalDate.of(2005, 10, 10), user.getBirthDate());
	} 

	@Test
	public void updateUserTest() {
		User user = new User();
		user.setRecordedDate(LocalDateTime.of(2019, Month.APRIL, 29, 19, 30, 40));
		user.setGender("Male");
		
		// us.getId(); 
//		userService.updateAccount(user);
		// assertEquals(us,userService.updateAccount(us));

		// assertTrue (userService.updateAccount(us).equals(us));

		assertFalse(userService.updateAccount(user).equals(user));
	}

	@Test
	public void deleteTestUse() {
		User us = new User();
		us.getFirstName();
		us.getEmailAddress();
		// assertEquals(us,userService.deleteAccount(us));
		assertFalse(userService.deleteAccount(us).equals(us));
	}
}
