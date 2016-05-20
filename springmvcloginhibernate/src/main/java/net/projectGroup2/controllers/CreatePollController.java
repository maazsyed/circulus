/*Created by: Maaz Syed
Date: 4/13/2016 12:41am*/
package net.projectGroup2.controllers;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.projectGroup2.form.CreatePoll;
import net.projectGroup2.form.CreatePost;
import net.projectGroup2.form.Information;
import net.projectGroup2.form.LoginForm;
import net.projectGroup2.form.Registration;
import net.projectGroup2.form.ViewPolls;
import net.projectGroup2.form.ViewPosts;
import net.projectGroup2.model.Posts;
import net.projectGroup2.service.CreatePollService;
import net.projectGroup2.service.CreatePostService;
import net.projectGroup2.service.InformationService;
import net.projectGroup2.service.RegistrationService;
/*import net.projectGroup2.service.CreatePostService;*/
import net.projectGroup2.service.ViewPostsService;

@Controller
@RequestMapping("createpoll.html")
public class CreatePollController {
//	@Autowired
//	private CreatePostValidation createpostValidation;

	@Autowired
	public ViewPostsService viewpostsservice;
	
	@Autowired
	public CreatePollService createpollsservice;
	
	@Autowired
	InformationService informationservice;
	


	/*public void setCreatePostValidation(
			CreatePostValidation createpostValidation) {
		this.createpostValidation = createpostValidation;
	}*/


	@RequestMapping(method = RequestMethod.GET)
	public String showForm(HttpServletRequest request, Map model) {
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null){
			LoginForm loginForm = new LoginForm();
			model.put("loginForm", loginForm);
			return "loginform";
		}
		System.out.println("33333");
		Information information = new Information();
		ViewPosts viewPosts = new ViewPosts();
		CreatePoll createPoll = new CreatePoll();
		ViewPolls viewPolls = new ViewPolls();
		
		//viewPosts.setUserName(user.getUserName());
		viewPosts.setUserName((String)session.getAttribute("username"));
		information.setviewTagResult(informationservice.getUserTags(viewPosts.getUserName()));
		System.out.println("*****"+viewPosts.getUserName());
		
		System.out.println("44444");
		//List<Posts> viewResult = viewpostsservice.viewPosts();
		viewPosts.setviewResult(viewpostsservice.viewPosts(viewPosts.getUserName(),""));
		viewPosts.setviewTrend(viewpostsservice.viewTrends());
		
		java.util.Date date = new java.util.Date();
		System.out.println(new Timestamp(date.getTime()));
		Timestamp ti = new Timestamp(date.getTime());
		
		/*long millisIn48Hours = 1000 * 60 * 60 * 48;
		Date timestamp = new Date(0);//use the date you have, parse it using SimpleDateFormat if needed.
		Date hours48ago = new Date(new Date(millisIn48Hours).getTime() - millisIn48Hours);

		if (timestamp.before(hours48ago)) {
		    //48 hours has passed.
		}*/
		List<Long> rem = new ArrayList<Long>();
		Iterator<Posts> posts = viewPosts.getviewTrend().iterator();
		while(posts.hasNext()){
			Posts pos = posts.next();
			long current = ti.getTime();
			long old = pos.getTimestamp().getTime();
			System.out.println(current+" - "+old+" = "+(current - old));
			if ((current - old)>172800000){
				rem.add(pos.getId());
			}
			//172800000
		}
		
		List<Long> ind = new ArrayList<Long>();
		posts = viewPosts.getviewTrend().iterator();
		int i = -1;
		while(posts.hasNext()){
			i++;
			Posts pos = posts.next();
			if(rem.contains(pos.getId())){
				System.out.println(i);
				ind.add((long) i);
			}
		}
		int j = -1;
		for (long index: ind){
			j++;
			index-=j;
			System.out.println(index);
			viewPosts.viewTrend.remove((int) index);
		}
		
		//Iterator<Posts> posts = viewResult.iterator();
		/*Iterator<Posts> posts = viewPosts.viewResult.iterator();
		while(posts.hasNext()){
			System.out.println(posts.next().getUserName());
		}
		System.out.println(viewPosts.getUserName());*/
		model.put("information", information);
		model.put("createpoll", createPoll);
		model.put("viewposts", viewPosts);
		model.put("viewpolls", viewPolls);
		System.out.println("55555");
		System.out.println("66666");
		return "createpoll";
	}
	
	
	
	// Process the form.
		@RequestMapping(method = RequestMethod.POST)
			public String processPost(@Valid CreatePoll createPoll,
				BindingResult result, HttpServletRequest request, Map model) {
			HttpSession session = request.getSession();
			System.out.println("Ciao.....");
			//System.out.println(createpost.getContent());
			//System.out.println(createpost.getTitle());
			//System.out.println(createpost.getUserName());
			//boolean userExists = createpostservice.newPost(createpost.getUserName(),createpost.getTitle(), createpost.getContent());
			//boolean viewResult = viewpostsservice.viewPosts();
			createpollsservice.newPoll
			((String)session.getAttribute("username"), createPoll.getTitle(), createPoll.getTag(),
					createPoll.getQuestion(), createPoll.getOption1(), createPoll.getOption2(),
					createPoll.getOption3(), createPoll.getOption4());
			
			// set custom Validation by user
//			createpostValidation.validate(createpost, result);
//				return "registrationform";
//			}
			ViewPolls viewPolls = new ViewPolls();
			ViewPosts viewPosts = new ViewPosts();
			
			viewPosts.setUserName((String)session.getAttribute("username"));
			
			viewPosts.setviewResult(viewpostsservice.viewPosts(viewPosts.getUserName(),""));
			viewPosts.setviewTrend(viewpostsservice.viewTrends());
			
			java.util.Date date = new java.util.Date();
			System.out.println(new Timestamp(date.getTime()));
			Timestamp ti = new Timestamp(date.getTime());
			
			/*long millisIn48Hours = 1000 * 60 * 60 * 48;
			Date timestamp = new Date(0);//use the date you have, parse it using SimpleDateFormat if needed.
			Date hours48ago = new Date(new Date(millisIn48Hours).getTime() - millisIn48Hours);

			if (timestamp.before(hours48ago)) {
			    //48 hours has passed.
			}*/
			List<Long> rem = new ArrayList<Long>();
			Iterator<Posts> posts = viewPosts.getviewTrend().iterator();
			while(posts.hasNext()){
				Posts pos = posts.next();
				long current = ti.getTime();
				long old = pos.getTimestamp().getTime();
				System.out.println(current+" - "+old+" = "+(current - old));
				if ((current - old)>172800000){
					rem.add(pos.getId());
				}
				//172800000
			}
			
			List<Long> ind = new ArrayList<Long>();
			posts = viewPosts.getviewTrend().iterator();
			int i = -1;
			while(posts.hasNext()){
				i++;
				Posts pos = posts.next();
				if(rem.contains(pos.getId())){
					System.out.println(i);
					ind.add((long) i);
				}
			}
			int j = -1;
			for (long index: ind){
				j++;
				index-=j;
				System.out.println(index);
				viewPosts.viewTrend.remove((int) index);
			}
			
			model.put("viewpolls", viewPolls);
			model.put("viewposts", viewPosts);
			model.put("createpoll", createPoll);
			return "createpoll";
		}
}