package com.mum.project.socialnetwork.socialnetwork;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mum.project.socialnetwork.socialnetwork.dao.CommentDao;
import com.mum.project.socialnetwork.socialnetwork.domain.Comment;
import com.mum.project.socialnetwork.socialnetwork.domain.Post;
import com.mum.project.socialnetwork.socialnetwork.domain.PostLikes;
import com.mum.project.socialnetwork.socialnetwork.domain.User;
import com.mum.project.socialnetwork.socialnetwork.implementation.CommentService;
import com.mum.project.socialnetwork.socialnetwork.implementation.LikeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SocialnetworkApplicationCommentServiceTest {
	@Test
	public void contextLoads() {
	}

	@Autowired
	private CommentService commentService;
	@Autowired
	private CommentDao commentDao; 

	 
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

		
		Post post = new Post();   
		post.setId("12345");
//		post.setDeleted(false);
		post.setUser(user);
		post.setDescription("Test a comment");
		post.setRecordedDate(LocalDateTime.of(2019, Month.APRIL,29, 19, 30, 40));
		
		Comment comment = new Comment();
		comment.setContent("Abdulo");
		comment.setId("345-etiopia");
		comment.setRecordeDate(LocalDateTime.of(2019, Month.APRIL,29, 19, 30, 40));
		comment.setPost(post);
		
		comment.setAddedBy(user);
		 
	    assertEquals("Abdulo", comment.getContent());
	    assertEquals("345-etiopia", comment.getId());
	    assertEquals(LocalDateTime.of(2019, Month.APRIL,29, 19, 30, 40), comment.getRecordeDate());
	   
	    assertEquals(user, comment.getAddedBy());
	    assertEquals(post, comment.getPost());
	     
	    assertEquals("Test a comment", comment.getPost().getDescription());
	    assertEquals("12345", comment.getPost().getId());
	    assertEquals(LocalDateTime.of(2019, Month.APRIL,29, 19, 30, 40), comment.getPost().getRecordedDate());
	    assertEquals(user, comment.getPost().getUser());
		
		 

		assertEquals("FName", comment.getAddedBy().getFirstName());
		assertEquals("LName", comment.getAddedBy().getLastName());
		assertEquals(LocalDate.of(2005, 10, 10), comment.getAddedBy().getBirthDate());
		assertEquals("MALE", comment.getAddedBy().getGender());
		assertEquals("test", comment.getAddedBy().getPassword());
		assertEquals("210-123-1234", comment.getAddedBy().getPhoneNumber());
		assertEquals("test@gmail.com", comment.getAddedBy().getEmailAddress());
		
	}
	/*

	@Test
		public void updateComment() {
		Comment comment = new Comment();
		comment.setContent("Abdulo");
		comment.setId("345-etiopia");
		Post p = new Post();
		p.setDescription("Election aux etats unis");
		comment.setPost(p);
		comment.setRecordeDate(LocalDateTime.of(2019, Month.APRIL,29, 19, 30, 40));
		User use = new User();
		use.setId("AD-Wanda");
		comment.setAddedBy(use);
		assertNotNull(comment);
//		commentDao.updateComment(comment);
	    assertEquals("Abdulo",comment.getContent());
	    assertEquals("345-etiopia",comment.getId());
	    assertEquals(LocalDateTime.of(2019, Month.APRIL,29, 19, 30, 40),comment.getRecordeDate());
	    assertEquals("Election aux etats unis",comment.getPost().getDescription());
	    assertEquals("AD-Wanda",comment.getAddedBy().getId());
	}
	*/
	@Test 
	public void deleteComment() {
		Comment comment = new Comment();
	 
		//assertEquals(comment,commentDao);
		//assertTrue(commentDao.deleteComment(comment).equals(comment));
		assertFalse (commentService.deleteComment(comment).equals(comment));
	}
	
	
	/*@Test
	public void listComment() {
		Post p = new Post();
		//p.setDescription("Election aux etats unis");
		Comment comment = new Comment();
		//comment.getPost();
//		commentDao.postComments(p);
	   assertEquals(commentDao, comment);
	   // assertTrue (commentDao.postComments(p).equals(comment));

       // assertFalse(commentDao.postComments(p).equals(comment));
	   
	}*/

}
