/*
Created by: Maaz Syed
Date: 4/23/2016
*/
package net.projectGroup2.dao;
import net.projectGroup2.model.*;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import java.util.List;

@Repository("informationDAO")
public class InformationDAOImpl implements InformationDAO{
     
			 
       @Resource(name="sessionFactory")
       protected SessionFactory sessionFactory;

       public void setSessionFactory(SessionFactory sessionFactory) {
              this.sessionFactory = sessionFactory;
       }
      
       protected Session getSession(){
              return sessionFactory.openSession();
       }

       public List<Users> getUserInformation(String userName){
			System.out.println("In getUserInformation");
			Session session = sessionFactory.openSession();
			boolean userFound = false;
			//Query using Hibernate Query Language
			String SQL_QUERY =" from Users as o where o.userName=?";
			Query query = session.createQuery(SQL_QUERY);
			query.setParameter(0,userName);
			List list = query.list();

			/* if ((list != null) && (list.size() > 0)) {
				//System.out.println(list);
				userFound= true;
			} */

			session.close();
			return list;              
       }
	   
	   public List<Tags> getUserTags(String userName){
			System.out.println("In getUserTags");
			Session session = sessionFactory.openSession();
			boolean userFound = false;
			//Query using Hibernate Query Language
			String SQL_QUERY =" from Tags as o where o.userName=?";
			Query query = session.createQuery(SQL_QUERY);
			query.setParameter(0,userName);
			List list = query.list();

			/* if ((list != null) && (list.size() > 0)) {
				//System.out.println(list);
				userFound= true;
			} */

			session.close();
			return list;  
	   }
	   
	   public List<Votes> getUserVotes(String userName){
		   	System.out.println("In getUserVotes");
			Session session = sessionFactory.openSession();
			boolean userFound = false;
			//Query using Hibernate Query Language
			String SQL_QUERY =" from Votes as o where o.userName=?";
			Query query = session.createQuery(SQL_QUERY);
			query.setParameter(0,userName);
			List list = query.list();

			/* if ((list != null) && (list.size() > 0)) {
				//System.out.println(list);
				userFound= true;
			} */

			session.close();
			return list;  

	   }
}