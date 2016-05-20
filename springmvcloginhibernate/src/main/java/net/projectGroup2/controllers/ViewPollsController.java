/*Created by: Maaz Syed
Date: 4/19/2016 3:08am*/
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

import net.projectGroup2.form.CreatePost;
import net.projectGroup2.form.LoginForm;
import net.projectGroup2.form.Registration;
import net.projectGroup2.form.ViewPollSelections;
import net.projectGroup2.form.ViewPolls;
import net.projectGroup2.form.ViewPosts;
import net.projectGroup2.model.Polls;
import net.projectGroup2.model.Posts;
import net.projectGroup2.service.CreateCommentService;
import net.projectGroup2.service.CreatePostService;
import net.projectGroup2.service.RegistrationService;
import net.projectGroup2.service.ViewCommentsService;
/*import net.projectGroup2.service.CreatePostService;*/
import net.projectGroup2.service.ViewPostsService;

@Controller
@RequestMapping("viewpolls.html")
public class ViewPollsController {
	// @Autowired
	// private CreatePostValidation createpostValidation;

	@Autowired
	public ViewPostsService viewpostsservice;

	@Autowired
	CreatePostService createpostservice;
	
	@Autowired
	public CreateCommentService createcommentservice;
	
	@Autowired
	public ViewCommentsService viewcommentsservice;

	/*
	 * public void setCreatePostValidation( CreatePostValidation
	 * createpostValidation) { this.createpostValidation = createpostValidation;
	 * }
	 */

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(HttpServletRequest request, Map model) {
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null){
			LoginForm loginForm = new LoginForm();
			model.put("loginForm", loginForm);
			return "loginform";
		}
		
		System.out.println("33333");
		ViewPosts viewPosts = new ViewPosts();
		ViewPolls viewPolls = new ViewPolls();
		ViewPollSelections viewPollSelections = new ViewPollSelections();
		
		// viewPosts.setUserName(user.getUserName());
		viewPolls.setUserName((String) session.getAttribute("username"));
		System.out.println("*****" + viewPolls.getUserName());
		
		if (!((request.getParameter("param1"))==null)){
			session.setAttribute("title",request.getParameter("param1"));
			session.setAttribute("titleOwner",request.getParameter("param2"));
			session.setAttribute("option",request.getParameter("param3"));
			session.setAttribute("post_id",request.getParameter("param4"));
			viewPolls.setviewResult(viewpostsservice.viewPolls(viewPolls.getUserName(), ""));
		} else {
			viewPolls.setviewResult(viewpostsservice.viewPolls(viewPolls.getUserName(), ""));
		}

		System.out.println("44444");
		// List<Posts> viewResult = viewpostsservice.viewPosts();
		//viewPolls.setviewResult(viewpostsservice.viewPolls(viewPolls.getUserName(), ""));
		viewPosts.setviewTrend(viewpostsservice.viewTrends());
		// Iterator<Posts> posts = viewResult.iterator();
		
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
		
		//session.setAttribute("post_id",viewPosts.getviewResult().get(0).getId());
		
		//createComments.setPostId((Long) session.getAttribute("post_id"));
		//System.out.println(createpost.getUserName());
		//boolean userExists = createpostservice.newPost(createpost.getUserName(),createpost.getTitle(), createpost.getContent());
		
		//boolean viewResult = viewpostsservice.viewPosts();
		if (!((request.getParameter("param1"))==null)){
			 boolean viewResult = createcommentservice.newPollSelection(Long.parseLong((String) session.getAttribute("post_id")),
					 (String)session.getAttribute("username"),Long.parseLong((String)session.getAttribute("option")));
		}
		
		Iterator<Polls> polls = viewPolls.viewResult.iterator();
		while(polls.hasNext()){
			Polls poll = polls.next();
			String titleOwner = poll.getUserName();
			String title = poll.getTitle();
			/*viewPolls.setOption1Count(viewcommentsservice.viewPollSelections((String)session.getAttribute("titleOwner"),(String)session.getAttribute("title"),(long) 1));
			viewPolls.setOption2Count(viewcommentsservice.viewPollSelections((String)session.getAttribute("titleOwner"),(String)session.getAttribute("title"),(long) 2));
			viewPolls.setOption3Count(viewcommentsservice.viewPollSelections((String)session.getAttribute("titleOwner"),(String)session.getAttribute("title"),(long) 3));
			viewPolls.setOption4Count(viewcommentsservice.viewPollSelections((String)session.getAttribute("titleOwner"),(String)session.getAttribute("title"),(long) 4));*/
			viewPolls.setOption1Count(viewcommentsservice.viewPollSelections(titleOwner, title,(long) 1));
			viewPolls.setOption2Count(viewcommentsservice.viewPollSelections(titleOwner, title,(long) 2));
			viewPolls.setOption3Count(viewcommentsservice.viewPollSelections(titleOwner, title,(long) 3));
			viewPolls.setOption4Count(viewcommentsservice.viewPollSelections(titleOwner, title,(long) 4));
			System.out.println(viewPolls.getOption4Count().get(0).longValue());
			System.out.println(viewPolls.getOption1Count().get(0).longValue());
			System.out.println(viewPolls.getOption2Count().get(0).longValue());
			System.out.println(viewPolls.getOption3Count().get(0).longValue());
		}
		
		/*Iterator<Polls> posts = viewPolls.viewResult.iterator();
		while(posts.hasNext()){
		System.out.println(posts.next().getUserName()); 
		
		}*/
		//System.out.println(viewPosts.getUserName());
		 
		model.put("viewposts", viewPosts);
		model.put("viewpolls", viewPolls);
		//model.put("viewpollselections", viewPollSelections);
		System.out.println("55555");
		System.out.println("66666");
		return "viewpolls";
	}

	// Process the form.
	@RequestMapping(method = RequestMethod.POST)
	public String processPost(@Valid ViewPolls viewPolls, BindingResult result, HttpServletRequest request,
			Map model) {
		System.out.println("Ciao.....");
		// System.out.println(createpost.getContent());
		// System.out.println(createpost.getTitle());
		// System.out.println(createpost.getUserName());

		// boolean userExists =
		// createpostservice.newPost(createpost.getUserName(),createpost.getTitle(),
		// createpost.getContent());
		// boolean viewResult = viewpostsservice.viewPosts();

		HttpSession session = request.getSession();
		System.out.println("33333");
		ViewPosts viewPosts = new ViewPosts();

		//viewPosts.setUserName((String) session.getAttribute("username"));
		viewPolls.setUserName((String) session.getAttribute("username"));
		System.out.println("*****" + viewPolls.getUserName());

		System.out.println("44444");
		if (!(viewPolls.getSearch().isEmpty())){
			if (viewPolls.getOption().equalsIgnoreCase("title")){
				viewPolls.setviewResult(viewpostsservice.viewPolls("", viewPolls.getSearch()));
			} else if (viewPolls.getOption().equalsIgnoreCase("user")){
				viewPolls.setviewResult(viewpostsservice.searchPolls(viewPolls.getSearch(),""));
			} else if (viewPolls.getOption().equalsIgnoreCase("tag")){
				viewPolls.setviewResult(viewpostsservice.searchPollsByTag("", viewPolls.getSearch()));
			} else {
				viewPolls.setviewResult(viewpostsservice.viewPolls(viewPolls.getUserName(), ""));
			}
		} else {
			viewPolls.setviewResult(viewpostsservice.viewPolls(viewPolls.getUserName(), ""));
		}
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
		
		Iterator<Polls> polls = viewPolls.viewResult.iterator();
		while(polls.hasNext()){
			Polls poll = polls.next();
			String titleOwner = poll.getUserName();
			String title = poll.getTitle();
			/*viewPolls.setOption1Count(viewcommentsservice.viewPollSelections((String)session.getAttribute("titleOwner"),(String)session.getAttribute("title"),(long) 1));
			viewPolls.setOption2Count(viewcommentsservice.viewPollSelections((String)session.getAttribute("titleOwner"),(String)session.getAttribute("title"),(long) 2));
			viewPolls.setOption3Count(viewcommentsservice.viewPollSelections((String)session.getAttribute("titleOwner"),(String)session.getAttribute("title"),(long) 3));
			viewPolls.setOption4Count(viewcommentsservice.viewPollSelections((String)session.getAttribute("titleOwner"),(String)session.getAttribute("title"),(long) 4));*/
			viewPolls.setOption1Count(viewcommentsservice.viewPollSelections(titleOwner, title,(long) 1));
			viewPolls.setOption2Count(viewcommentsservice.viewPollSelections(titleOwner, title,(long) 2));
			viewPolls.setOption3Count(viewcommentsservice.viewPollSelections(titleOwner, title,(long) 3));
			viewPolls.setOption4Count(viewcommentsservice.viewPollSelections(titleOwner, title,(long) 4));
			System.out.println(viewPolls.getOption4Count().get(0).longValue());
			System.out.println(viewPolls.getOption1Count().get(0).longValue());
			System.out.println(viewPolls.getOption2Count().get(0).longValue());
			System.out.println(viewPolls.getOption3Count().get(0).longValue());
		}
		
		model.put("viewposts", viewPosts);
		model.put("viewpolls", viewPolls);
		
		// set custom Validation by user
		// createpostValidation.validate(createpost, result);
		// return "registrationform";
		// }
		// return "registrationsuccess";
		return "viewpolls";
	}
}