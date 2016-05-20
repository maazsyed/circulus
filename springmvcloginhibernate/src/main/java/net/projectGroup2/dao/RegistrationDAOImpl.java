package net.projectGroup2.dao;


import net.projectGroup2.model.*;

 import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

@Repository("RegistrationDAO")
public class RegistrationDAOImpl implements RegistrationDAO{
     
			 
       @Resource(name="sessionFactory")
       protected SessionFactory sessionFactory;

       public void setSessionFactory(SessionFactory sessionFactory) {
              this.sessionFactory = sessionFactory;
       }
      
       protected Session getSession(){
              return sessionFactory.openSession();
       }

   
       
    
	 public boolean newUser(String userName, String userPassword, ArrayList<String> tags, String biography, String email) 
	 {
		

		Session session = sessionFactory.openSession();
		
		String SQL_QUERY =" from Users as o where o.userName=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0,userName);
		List list = query.list();

		if ((list != null) && (list.size() > 0)) {
			//System.out.println(list);
			session.close();
			return false;
		}
		
		session.beginTransaction();
		Users users = new Users();
		/*String pc = "select profile_pic from Pictures p where timestamp =  (SELECT MAX( timestamp ) FROM Pictures )";
		 * */
		/*String pc = "SELECT MAX( timestamp ) FROM Pictures";
		Query query = session.createQuery(pc);
		List list = query.list();*/
		/*System.out.println("aaaaaaaaaa"+list.iterator().next().toString());*/
		users.setUserName(userName);
		users.setUserPassword(userPassword);
		users.setBiography(biography);
		users.setEmail(email);
	/*	users.setPic_name(pc);*/
		session.save(users);
		session.getTransaction().commit();
		session.close();
		
 System.out.println(userName);
		 
		 System.out.println("22222");
		 for(int i = 0; i < tags.size(); i++) {   
			    System.out.print(tags.get(i));
			}  
		 
		 /*ArrayList to Array Conversion */
			
		System.out.println(3333333);
		System.out.println("Creating new user1..");
		
		Tags tags1 = new Tags();
		System.out.println("ssssss");
		/*tags1.setUserName(userName);*/
		
		System.out.println("tttttttt");
		String array[] = new String[tags.size()];              
		for(int j =0;j<tags.size();j++){
		  array[j] = tags.get(j);
		  System.out.println(array[j]);
		}
		
		/*Displaying Array elements*/
		for(int j = 0; j < array.length; j++) {
			Session session1 = sessionFactory.openSession();
			session1.beginTransaction();
		/*	Posts posts = new Posts();*/
			/*posts.setUserName(userName);*/
			tags1.setUserName(userName);
			tags1.setTag(array[j]);
			System.out.println("ddddd");
			System.out.println(j);
			/*tags1.setTags(array[j]);*/
			System.out.println("ccccc");
			/*tags1.setUserName(userName);*/
			System.out.println(array[j]);
			
			/*users.setTags(array[j]);*/
			System.out.println("wwww");
			
		/*	session.save(posts);*/
			session1.save(tags1);
			session1.getTransaction().commit();
			session1.close();
			
		}
		
		System.out.println("qqqqqq");
		
		
		System.out.println("44444444");
	
		return true;
	} 
}






