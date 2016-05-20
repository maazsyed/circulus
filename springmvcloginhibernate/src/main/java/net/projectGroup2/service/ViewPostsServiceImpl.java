/*
Created by: Maaz Syed
Date: 4/13/2016 12:41am
*/
package net.projectGroup2.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.projectGroup2.dao.*;
import net.projectGroup2.model.Polls;
import net.projectGroup2.model.Posts;


@Service("viewpostsservice")
public class ViewPostsServiceImpl implements ViewPostsService {

	 @Autowired
	 private ViewPostsDAO viewpostsDAO;

	   public void setViewPostsDAO(ViewPostsDAO viewpostsDAO) {
              this.viewpostsDAO = viewpostsDAO;
       }
      
       public List<Posts> viewPosts(String userName){
              System.out.println("In Service class...viewPosts");
              return viewpostsDAO.viewPosts(userName);
       }
       
       public List<Posts> viewPosts(String userName, String title){
           System.out.println("In Service class...viewPosts");
           return viewpostsDAO.viewPosts(userName, title, "");
    }
       
       public List<Posts> searchPosts(String userName, String title){
           System.out.println("In Service class...viewUserPosts");
           return viewpostsDAO.viewPosts(userName, title, "user");
       }
       
       public List<Posts> searchPostsByTag(String userName, String title){
           System.out.println("In Service class...viewTagPosts");
           return viewpostsDAO.viewPosts(userName, title, "tag");
       }
       
       public List<Polls> viewPolls(String userName, String title){
           System.out.println("In Service class...viewPolls");
           return viewpostsDAO.viewPolls(userName, title, "");
       }
	   
	   public List<Polls> searchPolls(String userName, String title){
           System.out.println("In Service class...viewUserPolls");
           return viewpostsDAO.viewPolls(userName, title, "user");
       }
	   
	   public List<Polls> searchPollsByTag(String userName, String title){
           System.out.println("In Service class...viewTagPolls");
           return viewpostsDAO.viewPolls(userName, title, "tag");
       }
       
       public List<Posts> viewTrends(){
           System.out.println("In Service class...viewTrends");
           return viewpostsDAO.viewTrends();
       }
}