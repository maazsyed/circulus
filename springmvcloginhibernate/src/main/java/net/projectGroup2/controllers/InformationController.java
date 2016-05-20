/*Created by: Maaz Syed
Date: 4/23/2016 1:50am*/
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
import net.projectGroup2.form.Information;
import net.projectGroup2.form.LoginForm;
import net.projectGroup2.form.Registration;
import net.projectGroup2.form.ViewPosts;
import net.projectGroup2.model.Posts;
import net.projectGroup2.model.Tags;
import net.projectGroup2.service.CreatePostService;
import net.projectGroup2.service.InformationService;
import net.projectGroup2.service.RegistrationService;
import net.projectGroup2.service.ViewCommentsService;
/*import net.projectGroup2.service.CreatePostService;*/
import net.projectGroup2.service.ViewPostsService;

@Controller
@RequestMapping("viewinfo.html")
public class InformationController {
	// @Autowired
	// private CreatePostValidation createpostValidation;

	@Autowired
	public ViewPostsService viewpostsservice;

	@Autowired
	CreatePostService createpostservice;
	
	@Autowired
	InformationService informationservice;
	
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
		Information information = new Information();

		// viewPosts.setUserName(user.getUserName());
		viewPosts.setUserName((String) session.getAttribute("username"));
		System.out.println("*****" + viewPosts.getUserName());

		System.out.println("44444");
		// List<Posts> viewResult = viewpostsservice.viewPosts();
		viewPosts.setviewResult(viewpostsservice.viewPosts(viewPosts.getUserName()));
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
		Iterator<Posts> postss = viewPosts.getviewTrend().iterator();
		while(postss.hasNext()){
			Posts pos = postss.next();
			long current = ti.getTime();
			long old = pos.getTimestamp().getTime();
			System.out.println(current+" - "+old+" = "+(current - old));
			if ((current - old)>172800000){
				rem.add(pos.getId());
			}
			//172800000
		}
		
		List<Long> ind = new ArrayList<Long>();
		postss = viewPosts.getviewTrend().iterator();
		int i = -1;
		while(postss.hasNext()){
			i++;
			Posts pos = postss.next();
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
		
		information.setviewResult(informationservice.getUserInformation(viewPosts.getUserName()));
		information.setviewTagResult(informationservice.getUserTags(viewPosts.getUserName()));
		// Iterator<Posts> posts = viewResult.iterator();
		/*
		 * Iterator<Posts> posts = viewPosts.viewResult.iterator();
		 * while(posts.hasNext()){
		 * System.out.println(posts.next().getUserName()); }
		 * System.out.println(viewPosts.getUserName());
		 */
		
		System.out.println("Username:");
		System.out.println(information.getviewResult().iterator().next().getUserName());
		System.out.println("Biography:");
		System.out.println(information.getviewResult().iterator().next().getBiography());
		
		Iterator<Tags> posts = information.viewTagResult.iterator();
		System.out.println("List of tags:");
		while(posts.hasNext()){
			System.out.print(posts.next().getTag()+" ");
		}
		
		Iterator<Posts> postsss = viewPosts.viewResult.iterator();
		Long count = (long) 0;
		int iteration = 0;
		while(postsss.hasNext()){
			iteration++;
			Posts p = postsss.next();
			//System.out.println(p.getUserName()+" "+p.getTitle());
			count += (long) viewcommentsservice.viewVotes(p.getUserName(),p.getTitle(),"up");
		}
		
		System.out.println("no of point: "+count);
		System.out.println("no of posts: "+iteration);
		
		model.put("viewposts", viewPosts);
		model.put("information", information);
		System.out.println("55555");
		System.out.println("66666");
		return "viewinfo";
	}

	// Process the form.
	@RequestMapping(method = RequestMethod.POST)
	public String processPost(@Valid ViewPosts viewPosts,  BindingResult result, HttpServletRequest request,
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
		//ViewPosts viewPosts = new ViewPosts();

		viewPosts.setUserName((String) session.getAttribute("username"));
		System.out.println("*****" + viewPosts.getUserName());

		System.out.println("44444 "+viewPosts.getOption());
		if (!(viewPosts.getSearch().isEmpty())){
			if (viewPosts.getOption().equalsIgnoreCase("title")){
				viewPosts.setviewResult(viewpostsservice.viewPosts("", viewPosts.getSearch()));
			} else if (viewPosts.getOption().equalsIgnoreCase("user")){
				viewPosts.setviewResult(viewpostsservice.searchPosts(viewPosts.getSearch(),""));
			} else if (viewPosts.getOption().equalsIgnoreCase("tag")){
				viewPosts.setviewResult(viewpostsservice.searchPostsByTag("", viewPosts.getSearch()));
			} else {
				viewPosts.setviewResult(viewpostsservice.viewPosts(viewPosts.getUserName(), ""));
			}
		} else {
			viewPosts.setviewResult(viewpostsservice.viewPosts(viewPosts.getUserName(), ""));
		}
		viewPosts.setviewTrend(viewpostsservice.viewTrends());
		model.put("viewposts", viewPosts);

		// set custom Validation by user
		// createpostValidation.validate(createpost, result);
		// return "registrationform";
		// }
		// return "registrationsuccess";
		return "viewposts";
	}
}