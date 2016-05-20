package net.projectGroup2.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import java.util.List;

//import net.projectGroup2.model.Posts;
//import net.projectGroup2.model.Users;
import net.projectGroup2.model.*;

@Repository("createpostDAO")
public class CreatePostDAOImpl implements CreatePostDAO{

	  @Resource(name="sessionFactory")
      protected SessionFactory sessionFactory;

      public void setSessionFactory(SessionFactory sessionFactory) {
             this.sessionFactory = sessionFactory;
      }
     
      protected Session getSession(){
             return sessionFactory.openSession();
      }

	@Override
	public boolean newPost(String userName, String Title, String Content) {
		if ((userName.isEmpty())||(Title.isEmpty())||(Content.isEmpty())) return false;
		System.out.println("Creating new user..");
		System.out.println(userName);
		System.out.println(Title);
		System.out.println(Content);
		Session session = sessionFactory.openSession();
		System.out.println(userName);
		System.out.println(Title);
		System.out.println(Content);
		System.out.println("Creating new user..1");
		session.beginTransaction();
		System.out.println("Creating new user..2");
		Posts posts = new Posts();
		System.out.println("Creating new user..3");
		posts.setUserName(userName);
		System.out.println("Creating new user..4");
		posts.setContent(Content);
		System.out.println("Creating new user..5");
		posts.setTitle(Title);
		System.out.println("Creating new user..6");
		session.save(posts);
		System.out.println("Creating new user..7");
		session.getTransaction().commit();
		System.out.println(userName);
		System.out.println(Title);
		System.out.println(Content);
		System.out.println("Creating new user..8");
		session.close();
		System.out.println("Creating new user..9");
		
		return true;
	}
      
}