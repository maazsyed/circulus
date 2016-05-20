/*
Created by: Sandeep Kathula Edited by: Maaz Syed 
*/
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

@Repository("createpollDAO")
public class CreatePollDAOImpl implements CreatePollDAO{

	  @Resource(name="sessionFactory")
      protected SessionFactory sessionFactory;

      public void setSessionFactory(SessionFactory sessionFactory) {
             this.sessionFactory = sessionFactory;
      }
     
      protected Session getSession(){
             return sessionFactory.openSession();
      }

	@Override
	public boolean newPoll(String userName, String Title, String Tag, String Question, 
 		   String Option1, String Option2, String Option3, String Option4) {
		System.out.println(userName);
		System.out.println(Title);
		System.out.println(Tag);
		System.out.println(Question);
		System.out.println(Option1);
		System.out.println(Option2);
		System.out.println(Option3);
		System.out.println(Option4);
		if ((userName.isEmpty())||(Title.isEmpty())||(Tag.isEmpty())||
				(Question.isEmpty())||(Option1.isEmpty())||(Option2.isEmpty())||
				(Option3.isEmpty())||(Option4.isEmpty())) return false;
		
		System.out.println("Creating new user..");
		System.out.println(userName);
		System.out.println(Title);
		Session session = sessionFactory.openSession();
		System.out.println(userName);
		System.out.println(Title);
		System.out.println("Creating new user..1");
		session.beginTransaction();
		System.out.println("Creating new user..2");
		Polls polls = new Polls();
		System.out.println("Creating new user..3");
		polls.setUserName(userName);
		System.out.println("Creating new user..4");
		polls.setTitle(Title);
		System.out.println("Creating new user..5");
		polls.setTags(Tag);
		System.out.println("Creating new user..6");
		polls.setQuestion(Question);
		polls.setOption1(Option1);
		polls.setOption2(Option2);
		polls.setOption3(Option3);
		polls.setOption4(Option4);
		session.save(polls);
		System.out.println("Creating new user..7");
		session.getTransaction().commit();
		System.out.println(userName);
		System.out.println(Title);
		System.out.println("Creating new user..8");
		session.close();
		System.out.println("Creating new user..9");
		
		return true;
	}
      
}