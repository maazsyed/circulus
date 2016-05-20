/*
Created by: Sandeep Kathula Edited by: Maaz Syed
Date: 4/24/2016 7:17pm
*/
package net.projectGroup2.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//import net.projectGroup2.model.Posts;
//import net.projectGroup2.model.Users;
import net.projectGroup2.model.*;

@Repository("createcommentDAO")
public class CreateCommentDAOImpl implements CreateCommentDAO{

	  @Resource(name="sessionFactory")
      protected SessionFactory sessionFactory;

      public void setSessionFactory(SessionFactory sessionFactory) {
             this.sessionFactory = sessionFactory;
      }
     
      protected Session getSession(){
             return sessionFactory.openSession();
      }

	@Override
	public boolean newComment(Long postId, String userName, String Content) {
		System.out.println("Creating new user..");
		System.out.println(userName);
		System.out.println(postId);
		System.out.println(Content);
		
		if (Content.isEmpty()) return false;
		
		Session session = sessionFactory.openSession();
		System.out.println("Creating new user..1");
		session.beginTransaction();
		System.out.println("Creating new user..2");
		Comments comments = new Comments();
		System.out.println("Creating new user..3");
		comments.setUserName(userName);
		System.out.println("Creating new user..4");
		comments.setComment(Content);
		System.out.println("Creating new user..5 "+postId);
		comments.setPostId(postId);
		System.out.println("Creating new user..6 "+comments.getPostId());
		session.save(comments);
		System.out.println("Creating new user..7");
		session.getTransaction().commit();
		System.out.println(userName);
		System.out.println(postId.intValue());
		System.out.println(Content);
		System.out.println("Creating new user..8");
		session.close();
		System.out.println("Creating new user..9");
		
		return true;
	}
	
	@Override
	public boolean newVote(Long postId, String userName, String Vote) {
		System.out.println("Creating new user..");
		System.out.println(userName);
		System.out.println(postId);
		System.out.println(Vote);
		Session session = sessionFactory.openSession();
		
		String SQL_QUERY = "from Votes p where post_id =? and user_name =? order by p.timestamp desc";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0,postId);
		query.setParameter(1,userName);
		List list = query.list();
		
		if ((list != null) && (list.size() > 0)) {
			//System.out.println(list);
			//userFound= true;
			return false;
		}
		
		System.out.println("Creating new user..1");
		session.beginTransaction();
		System.out.println("Creating new user..2");
		Votes votes = new Votes();
		System.out.println("Creating new user..3");
		votes.setUserName(userName);
		System.out.println("Creating new user..4");
		votes.setVote(Vote);
		System.out.println("Creating new user..5 "+postId);
		votes.setPostId(postId);
		System.out.println("Creating new user..6 "+votes.getPostId());
		session.save(votes);
		System.out.println("Creating new user..7");
		session.getTransaction().commit();
		/*System.out.println(userName);
		System.out.println(postId.intValue());
		System.out.println(Content);*/
		System.out.println("Creating new user..8");
		session.close();
		System.out.println("Creating new user..9");
		
		return true;
	}
	
	@Override
	public boolean newReaction(Long postId, String userName, String Reaction) {
		System.out.println("Creating new user..");
		System.out.println(userName);
		System.out.println(postId);
		//System.out.println(Vote);
		Session session = sessionFactory.openSession();
		
		String SQL_QUERY = "from Reactions p where post_id =? and user_name =? order by p.timestamp desc";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0,postId);
		query.setParameter(1,userName);
		List list = query.list();
		
		if ((list != null) && (list.size() > 0)) {
			//System.out.println(list);
			//userFound= true;
			return false;
		}
		
		System.out.println("Creating new user..1");
		session.beginTransaction();
		System.out.println("Creating new user..2");
		Reactions reactions = new Reactions();
		System.out.println("Creating new user..3");
		reactions.setUserName(userName);
		System.out.println("Creating new user..4");
		reactions.setPostId(postId);
		System.out.println("Creating new user..6 "+reactions.getPostId());
		
		/* Iterator<String> react = Reaction.iterator();
		do{ */
			reactions.setReaction(Reaction);
			System.out.println("Creating new user..5 "+postId);
			
			session.save(reactions);
			System.out.println("Creating new user..7");
			session.getTransaction().commit();
		/* }while(react.hasNext()); */
		
		
		/*System.out.println(userName);
		System.out.println(postId.intValue());
		System.out.println(Content);*/
		System.out.println("Creating new user..8");
		session.close();
		System.out.println("Creating new user..9");
		
		return true;
	} 
	
	public boolean newPollSelection(Long postId, String userName, Long option){
		System.out.println("Creating new user..");
		System.out.println(userName);
		System.out.println(postId);
		System.out.println(option);
		Session session = sessionFactory.openSession();
		
		String SQL_QUERY = "from Pollresponse p where post_id =? and user_name =? order by p.timestamp desc";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0,postId);
		query.setParameter(1,userName);
		List list = query.list();
		
		if ((list != null) && (list.size() > 0)) {
			//System.out.println(list);
			//userFound= true;
			return false;
		}
		
		System.out.println("Creating new user..1");
		session.beginTransaction();
		System.out.println("Creating new user..2");
		Pollresponse pollselections = new Pollresponse();
		System.out.println("Creating new user..3");
		pollselections.setUserName(userName);
		System.out.println("Creating new user..4");
		pollselections.setOption(option);
		System.out.println("Creating new user..5 "+postId);
		pollselections.setPostId(postId);
		System.out.println("Creating new user..6 "+pollselections.getPostId());
		session.save(pollselections);
		System.out.println("Creating new user..7");
		session.getTransaction().commit();
		System.out.println(userName);
		System.out.println(postId.intValue());
		System.out.println(option);
		System.out.println("Creating new user..8");
		session.close();
		System.out.println("Creating new user..9");
		
		return true;
	}
}