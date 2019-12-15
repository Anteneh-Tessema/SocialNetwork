package com.edu.mum.cs544.socialnetwork.socialnetwork;

import com.edu.mum.cs544.socialnetwork.socialnetwork.service.impl.CommentService;
import com.edu.mum.cs544.socialnetwork.socialnetwork.service.impl.LikeService;
import com.edu.mum.cs544.socialnetwork.socialnetwork.service.impl.PostService;
import com.edu.mum.cs544.socialnetwork.socialnetwork.service.impl.ShareService;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

//@EnableWebSecurity
@Configuration
@SpringBootApplication
@EnableJpaAuditing
public class SocialnetworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialnetworkApplication.class, args);
    }
    @Bean
    public SessionFactory sessionFactory(HibernateEntityManagerFactory h) {
        return h.getSessionFactory();

    }

    @Bean
    public CommentService commentservice() {
        return new CommentService();
    }

    @Bean
    public LikeService likeService() {
        return new LikeService();
    }

    @Bean
    public ShareService shareService() {
        return new ShareService();
    }

    @Bean
    public PostService postService() {
        return new PostService();
    }




}
