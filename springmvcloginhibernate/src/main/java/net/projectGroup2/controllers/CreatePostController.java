package net.projectGroup2.controllers;

import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.projectGroup2.form.CreatePost;
import net.projectGroup2.form.Information;
import net.projectGroup2.form.LoginForm;
import net.projectGroup2.form.Registration;
import net.projectGroup2.form.ViewPosts;
import net.projectGroup2.model.Posts;
import net.projectGroup2.model.Tags;
import net.projectGroup2.service.InformationService;
/*import net.projectGroup2.service.CreatePostService;*/
import net.projectGroup2.service.RegistrationService;
/*import net.projectGroup2.service.CreatePostService;*/

@Controller
@RequestMapping("createpost.html")
public class CreatePostController {
//	@Autowired
//	private CreatePostValidation createpostValidation;

	/*@Autowired
	public CreatePostService createpostservice;*/

	@Autowired
	InformationService informationservice;

	/*public void setCreatePostValidation(
			CreatePostValidation createpostValidation) {
		this.createpostValidation = createpostValidation;
	}*/

	  @Resource(name="sessionFactory")
      protected SessionFactory sessionFactory;

      public void setSessionFactory(SessionFactory sessionFactory) {
             this.sessionFactory = sessionFactory;
      }
     
      protected Session getSession(){
             return sessionFactory.openSession();
      }

      public static String postname;
      

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		//session.setAttribute("username", "maaz");
		//session.removeAttribute("username");
		if (session.getAttribute("username") == null){
			LoginForm loginForm = new LoginForm();
			model.put("loginForm", loginForm);
			return "loginform";
		}
		
		System.out.println("11111111");
		Information information = new Information();
		CreatePost createPost = new CreatePost();
		ViewPosts viewPosts = new ViewPosts();
		
		viewPosts.setUserName((String) session.getAttribute("username"));
		information.setviewTagResult(informationservice.getUserTags(viewPosts.getUserName()));
		
		Iterator<Tags> posts = information.viewTagResult.iterator();
		System.out.println("List of tags:");
		while(posts.hasNext()){
			System.out.print(posts.next().getTag()+" ");
		}
		
		System.out.println("22222222");
		model.put("information", information);
		model.put("createpost", createPost);
		model.put("viewposts", viewPosts);
		return "createpost";
	}
	
	
	
	// Process the form.
		@RequestMapping(method = RequestMethod.POST)
			public String processPost(@Valid CreatePost createpost,
				BindingResult result, HttpServletRequest request) {
			System.out.println("Hello.....");
			System.out.println(createpost.getContent());
			System.out.println(createpost.getTitle());
			if ((createpost.getContent().isEmpty())||(createpost.getTitle().isEmpty())){
				String redirectUrl = "http://localhost:8080/springmvclogin/forms/viewposts.html";
		        return "redirect:" + redirectUrl;
			}
		/*	System.out.println(createpost.getUserName());*/
			/*boolean userExists = createpostservice.newPost(createpost.getUserName(),createpost.getTitle(), createpost.getContent());*/
			
			HttpSession session = request.getSession();
			/*session.setAttribute("test1", loginForm.getUserName());*/
			postname = (String) session.getAttribute("username");
			System.out.println(postname);
		/*	System.out.println("Creating new user..");
			System.out.println(userName);
			System.out.println(Title);
			System.out.println(Content);*/
			Session session1 = sessionFactory.openSession();
			System.out.println("Creating new user..1");
			session1.beginTransaction();
			System.out.println("Creating new user..2");
			Posts posts = new Posts();
			System.out.println("Creating new user..3");
			/*HttpSession session1 = request.getSession();
			postname = (String) session1.getAttribute("test1");*/
			posts.setUserName(postname);
			System.out.println("Creating new user..4");
			posts.setContent(createpost.getContent());
			System.out.println("Creating new user..5");
			posts.setTitle(createpost.getTitle());
			System.out.println("Creating new user..6");
			posts.setTags(createpost.getTags());
			session1.save(posts);
			System.out.println("Creating new user..7");
			session1.getTransaction().commit();
			/*System.out.println(userName);
			System.out.println(Title);
			System.out.println(Content);*/
			System.out.println("Creating new user..8");
			session1.close();
			System.out.println("Creating new user..9");
			
			
			
			// set custom Validation by user
//			createpostValidation.validate(createpost, result);
//				return "registrationform";
//			}
			String redirectUrl = "http://localhost:8080/springmvclogin/forms/viewposts.html";
	        return "redirect:" + redirectUrl;
			/*return "createpost";*/
		}
}