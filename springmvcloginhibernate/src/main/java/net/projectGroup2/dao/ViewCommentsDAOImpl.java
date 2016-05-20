/*
Created by: Maaz Syed
Date: 4/15/2016 12:25pm
*/
package net.projectGroup2.dao;
import net.projectGroup2.form.ViewPosts;
import net.projectGroup2.form.ViewComments;
import net.projectGroup2.model.*;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;

import java.util.Iterator;
import java.util.List;

@Repository("viewcommentsDAO")
public class ViewCommentsDAOImpl implements ViewCommentsDAO{
     
			 
       @Resource(name="sessionFactory")
       protected SessionFactory sessionFactory;

       public void setSessionFactory(SessionFactory sessionFactory) {
              this.sessionFactory = sessionFactory;
       }
      
       protected Session getSession(){
              return sessionFactory.openSession();
       }

       public List<Comments> viewComments(String userName, String title){
			System.out.println("In View comments");
			Session session = sessionFactory.openSession();
			boolean userFound = false;
			//Query using Hibernate Query Language
			String SQL_QUERY = "from Posts p where user_name =? and title =? order by p.timestamp desc";
			Query query = session.createQuery(SQL_QUERY);
			query.setParameter(0,userName);
			query.setParameter(1,title);
			List list = query.list();
			Iterator<Posts> posts = list.iterator();
			/*while(posts.hasNext()){
				System.out.println(posts.next().getId());
			}*/
			long id = posts.next().getId();
			
			SQL_QUERY = "from Comments p where post_id =? order by p.timestamp desc";
			query = session.createQuery(SQL_QUERY);
			query.setParameter(0,id);
			list = query.list();

			/*if ((list != null) && (list.size() > 0)) {
				//System.out.println(list);
				userFound= true;
			}*/

			session.close();
			return list;              
       }
       
       public Long viewVotes(String userName, String title, String vote){
    	   System.out.println("In View votes");
			Session session = sessionFactory.openSession();
			boolean userFound = false;
			//Query using Hibernate Query Language
			String SQL_QUERY = "from Posts p where user_name =? and title =? order by p.timestamp desc";
			Query query = session.createQuery(SQL_QUERY);
			query.setParameter(0,userName);
			query.setParameter(1,title);
			List list = query.list();
			Iterator<Posts> posts = list.iterator();
			/*while(posts.hasNext()){
				System.out.println(posts.next().getId());
			}*/
			long id = posts.next().getId();
			
			SQL_QUERY = "select count(p.vote) from Votes p where p.post_id =? and p.vote =?";
			query = session.createQuery(SQL_QUERY);
			query.setParameter(0,id);
			query.setParameter(1,vote);
			list = query.list();

			session.close();
			Long v = (Long)list.iterator().next();
			return v;   
       }
       public Long viewReactions(String userName, String title, String reaction){
    	   System.out.println("In View votes");
			Session session = sessionFactory.openSession();
			boolean userFound = false;
			//Query using Hibernate Query Language
			String SQL_QUERY = "from Posts p where user_name =? and title =? order by p.timestamp desc";
			Query query = session.createQuery(SQL_QUERY);
			query.setParameter(0,userName);
			query.setParameter(1,title);
			List list = query.list();
			Iterator<Posts> posts = list.iterator();
			/*while(posts.hasNext()){
				System.out.println(posts.next().getId());
			}*/
			long id = posts.next().getId();
			
			SQL_QUERY = "select count(p.reaction) from Reactions p where p.post_id =? and p.reaction =?";
			query = session.createQuery(SQL_QUERY);
			query.setParameter(0,id);
			query.setParameter(1,reaction);
			list = query.list();

			session.close();
			Long v = (Long)list.iterator().next();
			return v; 
       }
       public Long viewPollSelections(String userName, String title, Long pollSelection){
    	   System.out.println("In View votes");
			Session session = sessionFactory.openSession();
			boolean userFound = false;
			//Query using Hibernate Query Language
			String SQL_QUERY = "from Polls p where user_name =? and title =? order by p.timestamp desc";
			Query query = session.createQuery(SQL_QUERY);
			query.setParameter(0,userName);
			query.setParameter(1,title);
			List list = query.list();
			Iterator<Polls> posts = list.iterator();
			/*while(posts.hasNext()){
				System.out.println(posts.next().getId());
			}*/
			while(posts.hasNext()){
				long id = posts.next().getId();
				SQL_QUERY = "select count(p.option) from Pollresponse p where p.post_id =? and p.option =?";
				query = session.createQuery(SQL_QUERY);
				query.setParameter(0,id);
				query.setParameter(1,pollSelection);
				list = query.list();
				Long v = (Long)list.iterator().next();
				session.close();
				return v;
			}
			
			session.close();
			return (long) 0;

			
       }
}