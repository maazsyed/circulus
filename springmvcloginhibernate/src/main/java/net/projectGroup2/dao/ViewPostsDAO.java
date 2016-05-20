/*
Created by: Maaz Syed
Date: 4/13/2016 12:49am
*/
package net.projectGroup2.dao;
import java.util.List;
import net.projectGroup2.model.*;

public interface ViewPostsDAO{    
       public List<Posts> viewPosts(String userName);
       public List<Posts> viewPosts(String userName, String title, String search);
       public List<Polls> viewPolls(String userName, String title, String search);
       public List<Posts> viewTrends();
}