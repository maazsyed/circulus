package net.projectGroup2.dao;
/*
Created by: Maaz Syed and Venkat Sambandhan

*/
import net.projectGroup2.model.*;

public interface CreatePostDAO{    
       public boolean newPost(String userName, String Title, String Content);
}