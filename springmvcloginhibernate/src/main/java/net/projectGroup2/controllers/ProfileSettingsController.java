package net.projectGroup2.controllers;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.projectGroup2.form.CreatePost;
import net.projectGroup2.form.LoginForm;
import net.projectGroup2.form.ProfileSettings;
import net.projectGroup2.form.Registration;
import net.projectGroup2.model.Tags;
import net.projectGroup2.model.Users;
/*import net.projectGroup2.service.CreatePostService;*/
import net.projectGroup2.service.RegistrationService;
/*import net.projectGroup2.service.CreatePostService;*/




@Controller
@RequestMapping("profilesettings.html")
public class ProfileSettingsController {
	
    @Resource(name="sessionFactory")
    protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
           this.sessionFactory = sessionFactory;
    }
   
    protected Session getSession(){
           return sessionFactory.openSession();
    }
    
	public static String loginname;
	
	/*@Autowired
	private CreatePostValidation createpostValidation;*/

	/*@Autowired
	public ProfileSettingsService psservice;*/


	/*public void setCreatePostValidation(
			CreatePostValidation createpostValidation) {
		this.createpostValidation = createpostValidation;
	}*/


	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null){
			LoginForm loginForm = new LoginForm();
			model.put("loginForm", loginForm);
			return "loginform";
		}
		System.out.println("11111111");
		/*CreatePost createPost = new CreatePost();*/
		ProfileSettings profilesettings = new ProfileSettings();
		System.out.println("22222222");
		System.out.println("eeeeeee");
		model.put("profilesettings", profilesettings);
		System.out.println("fffff");
		return "profilesettings";
	}
	
	
	/* Process the form.*/
		@RequestMapping(method = RequestMethod.POST)
			public String changeSettings(@Valid ProfileSettings profilesettings,
				BindingResult result, HttpServletRequest request) {
			HttpSession session = request.getSession();
			loginname = (String) session.getAttribute("test1");
			System.out.println(loginname);
			/*System.out.println("Hello.....");
			System.out.println(ps.getContent());
			System.out.println(ps.getTitle());
			System.out.println(ps.getUserName());*/
			System.out.println("99999999999");
			/*boolean userExists = psservice.changeSettings(profilesettings.getUserName(),profilesettings.getPassword());*/
			
			
			
			System.out.println("3333333333");
			
			
			
			Session session1 = sessionFactory.openSession();
			session1.beginTransaction();
			Users users = new Users();
			Tags tags = new Tags();
		/*	String pc = "select profile_pic from Pictures p where timestamp =  (SELECT MAX( timestamp ) FROM Pictures )";
			Query query = session.createQuery(pc);
			List list = query.list();
			System.out.println("aaaaaaaaaa"+list.iterator().next().toString());*/
			
		
			System.out.println("00000000");
			
			
			String hql = "UPDATE Users set user_name = :userName1, user_password = :user_password1 "  + 
		             "WHERE user_name = :name";
		Query query1 = session1.createQuery(hql);
		query1.setParameter("userName1",profilesettings.getUserName());
		System.out.println();
		/*query1.setString("name","chiku");*/
		query1.setParameter("user_password1",profilesettings.getPassword());
		query1.setParameter("name",loginname);
		System.out.println();
		/*String userName1 = "chiks";*/
		/*query1.setParameter("test1",userName1);*/
		/*query1.setParameter("employee_id", 10);*/
		int result1 = query1.executeUpdate();
		System.out.println("111111111");
		/*String hql1 = "UPDATE Users set user_password = :user_password1 "  + 
	            "WHERE user_password = :pwd";
		Query query2 = session.createQuery(hql1);*/
		/*query2.setString("pwd","chiku");
		query2.setString("user_password1","chiks");
		
		int result1 = query2.executeUpdate();
		*/
		/*System.out.println("Rows affected: " + result1);*/
		
		/*query1 = session.createQuery(SQL_QUERY);*/
		/*List list = query.list();*/
		
		/*users.setPic_name(pc);*/
		
		/*String hql2 = "UPDATE Tags set user_name = :userName1"  + 
	            "WHERE user_name = :name";
		
		Query query2 = session.createQuery(hql2);
		query2.setParameter("userName1",userName);
		System.out.println();
		query1.setParameter("userName1",userName);
		query2.setParameter("user_password1",password);
		query2.setString("name","chiku");
		int result1 = query2.executeUpdate();*/
	/*	System.out.println(result1);*/
		session1.save(users);
		/*session.save(tags);*/
		session1.getTransaction().commit();
		session1.close();
		
		System.out.println("22222222");
		
		
		
		
		
		
		
			// set custom Validation by user
//			createpostValidation.validate(createpost, result);
//				return "registrationform";
//			}
		/*	String redirectUrl = "http://localhost:8080/springmvclogin/forms/viewposts.html";
	        return "redirect:" + redirectUrl;*/
			return "loginsuccess";
		}
}