package net.projectGroup2.dao;
/*
Created by: Maaz Syed and Venkat Sambandhan

*/
import net.projectGroup2.model.*;

public interface LoginDAO{    
       public boolean checkLogin(String userName, String userPassword);
}