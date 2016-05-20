/*package net.projectGroup2.dao;


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

@Repository("ProfileSettingsDAO")
public class ProfileSettingsDAOImpl implements ProfileSettingsDAO{
     
			 
       @Resource(name="sessionFactory")
       protected SessionFactory sessionFactory;

       public void setSessionFactory(SessionFactory sessionFactory) {
              this.sessionFactory = sessionFactory;
       }
      
       protected Session getSession(){
              return sessionFactory.openSession();
       }
   
	@Override
	public boolean changeSettings(String userName, String password) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Users users = new Users();
		Tags tags = new Tags();
		String pc = "select profile_pic from Pictures p where timestamp =  (SELECT MAX( timestamp ) FROM Pictures )";
		Query query = session.createQuery(pc);
		List list = query.list();
		System.out.println("aaaaaaaaaa"+list.iterator().next().toString());
		
	
		System.out.println("00000000");
		
		
		String hql = "UPDATE Users set user_name = :userName1, user_password = :user_password1 "  + 
	             "WHERE user_name = :name";
	Query query1 = session.createQuery(hql);
	query1.setParameter("userName1",userName);
	System.out.println();
	query1.setString("name","chiku");
	query1.setParameter("user_password1",password);
	query1.setParameter("name","chiku");
	System.out.println();
	String userName1 = "chiks";
	query1.setParameter("test1",userName1);
	query1.setParameter("employee_id", 10);
	int result = query1.executeUpdate();
	System.out.println("111111111");
	String hql1 = "UPDATE Users set user_password = :user_password1 "  + 
            "WHERE user_password = :pwd";
	Query query2 = session.createQuery(hql1);
	query2.setString("pwd","chiku");
	query2.setString("user_password1","chiks");
	
	int result1 = query2.executeUpdate();
	
	System.out.println("Rows affected: " + result1);
	
	query1 = session.createQuery(SQL_QUERY);
	List list = query.list();
	
	users.setPic_name(pc);
	
	String hql2 = "UPDATE Tags set user_name = :userName1"  + 
            "WHERE user_name = :name";
	
	Query query2 = session.createQuery(hql2);
	query2.setParameter("userName1",userName);
	System.out.println();
	query1.setParameter("userName1",userName);
	query2.setParameter("user_password1",password);
	query2.setString("name","chiku");
	int result1 = query2.executeUpdate();
	System.out.println(result1);
	session.save(users);
	session.save(tags);
	session.getTransaction().commit();
	session.close();
	
	System.out.println("22222222");
		
		return false;
	} 
}






*/