/*
Created by: Maaz Syed
Date: 4/13/2016 12:41am
*/
package net.projectGroup2.service;
import java.util.List;
import net.projectGroup2.model.*;

public interface ViewPostsService{    
       public List<Posts> viewPosts(String userName);
       public List<Posts> viewPosts(String userName, String userPassword);
       public List<Posts> searchPosts(String userName, String userPassword);
       public List<Posts> searchPostsByTag(String userName, String userPassword);
       public List<Polls> viewPolls(String userName, String userPassword);
	   public List<Polls> searchPolls(String userName, String userPassword);
	   public List<Polls> searchPollsByTag(String userName, String userPassword);
       public List<Posts> viewTrends();
}