/*Created by: Maaz Syed
Date: 4/15/2016 11:57am*/
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

import net.projectGroup2.form.CreateComment;
import net.projectGroup2.form.CreatePost;
import net.projectGroup2.form.LoginForm;
import net.projectGroup2.form.RegisterReaction;
import net.projectGroup2.form.Registration;
import net.projectGroup2.form.ViewComments;
import net.projectGroup2.form.ViewPosts;
import net.projectGroup2.model.Comments;
import net.projectGroup2.model.Posts;
import net.projectGroup2.service.CreateCommentService;
import net.projectGroup2.service.CreatePostService;
import net.projectGroup2.service.RegistrationService;
import net.projectGroup2.service.ViewCommentsService;
/*import net.projectGroup2.service.CreatePostService;*/
import net.projectGroup2.service.ViewPostsService;

@Controller
@RequestMapping("viewcomments.html")
public class ViewCommentsController {
//	@Autowired
//	private CreatePostValidation createpostValidation;

	@Autowired
	public ViewPostsService viewpostsservice;
	
	@Autowired
	public ViewCommentsService viewcommentsservice;
	
	@Autowired
	public CreateCommentService createcommentservice;


	@RequestMapping(method = RequestMethod.GET)
	public String showForm(HttpServletRequest request, Map model) {
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null){
			LoginForm loginForm = new LoginForm();
			model.put("loginForm", loginForm);
			return "loginform";
		}
		//System.out.println("PARAM1: "+request.getParameter("param1"));
		
		if (!((request.getParameter("param1"))==null)){
			session.setAttribute("title",request.getParameter("param1"));
			session.setAttribute("titleOwner",request.getParameter("param2"));
		}
		
		System.out.println("3333");
		ViewPosts viewPosts = new ViewPosts();
		CreateComment createComments = new CreateComment();
		viewPosts.setUserName((String)session.getAttribute("username"));
		
		ViewComments viewComments = new ViewComments();
		RegisterReaction registerReactions = new RegisterReaction();
		/*registerReactions.setReactions("happy");
		registerReactions.setReactions("sad");
		registerReactions.setReactions("angry");*/
		System.out.println("4444");
		
		//List<Posts> viewResult = viewpostsservice.viewPosts();
		viewPosts.setviewResult(viewpostsservice.viewPosts((String)session.getAttribute("titleOwner"),(String)session.getAttribute("title")));
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
		
		session.setAttribute("post_id",viewPosts.getviewResult().get(0).getId());
		
		
		viewComments.setviewResult(viewcommentsservice.viewComments((String)session.getAttribute("titleOwner"),(String)session.getAttribute("title")));
		registerReactions.setUpCount(viewcommentsservice.viewVotes((String)session.getAttribute("titleOwner"),(String)session.getAttribute("title"),"up"));
		registerReactions.setDownCount(viewcommentsservice.viewVotes((String)session.getAttribute("titleOwner"),(String)session.getAttribute("title"),"down"));
		registerReactions.setHappyCount(viewcommentsservice.viewReactions((String)session.getAttribute("titleOwner"),(String)session.getAttribute("title"),"happy"));
		registerReactions.setAngryCount(viewcommentsservice.viewReactions((String)session.getAttribute("titleOwner"),(String)session.getAttribute("title"),"angry"));
		registerReactions.setSadCount(viewcommentsservice.viewReactions((String)session.getAttribute("titleOwner"),(String)session.getAttribute("title"),"sad"));
		//Iterator<Posts> posts = viewResult.iterator();
		Iterator<Comments> comments = viewComments.viewResult.iterator();
		while(comments.hasNext()){
			System.out.println(comments.next().getUserName());
		}
		
		System.out.println(viewComments.getUserName());
		model.put("viewcomments", viewComments);
		model.put("viewposts", viewPosts);
		model.put("createcomments", createComments);
		model.put("registerreactions", registerReactions);
		System.out.println("5555");
		System.out.println("6666");
		return "viewcomments";
	}
	
	
	
	// Process the form.
		@RequestMapping(method = RequestMethod.POST)
			public String processPost(@Valid CreateComment createComments,
				BindingResult result, HttpServletRequest request) {
			System.out.println("Ciao.....");
			HttpSession session = request.getSession();
			System.out.println(createComments.getComment());
			System.out.println(session.getAttribute("post_id"));
			createComments.setPostId((Long) session.getAttribute("post_id"));
			//System.out.println(createpost.getUserName());
			//boolean userExists = createpostservice.newPost(createpost.getUserName(),createpost.getTitle(), createpost.getContent());
			
			//boolean viewResult = viewpostsservice.viewPosts();
			boolean viewResult = createcommentservice.newComment
					((Long)session.getAttribute("post_id"),(String)session.getAttribute("username"),(String)createComments.getComment());
			
			// set custom Validation by user
//			createpostValidation.validate(createpost, result);
//				return "registrationform";
//			}
			return "redirect: viewcomments.html";
		}
}