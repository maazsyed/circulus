package net.projectGroup2.service;
/*
Created by: Maaz Syed and Venkat Sambandhan

*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.projectGroup2.dao.*;


@Service("createpostservice")
public class CreatePostServiceImpl implements CreatePostService {

	 @Autowired
	 private CreatePostDAO createpostDAO;

	   public void setCreatePostDAO(CreatePostDAO createpostDAO) {
              this.createpostDAO = createpostDAO;
       }
      
     
	//@Override
	public boolean newPost(String userName, String Title, String Content) {
		System.out.println("In Service class...New Post");
		return createpostDAO.newPost(userName, Title, Content);
	}
}