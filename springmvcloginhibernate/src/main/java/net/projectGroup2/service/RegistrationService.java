package net.projectGroup2.service;
import java.util.ArrayList;

/*
Created by: Maaz Syed and Venkat Sambandhan

*/
import net.projectGroup2.model.*;

public interface RegistrationService{    
       public boolean newUser(String userName, String userPassword, ArrayList<String> tags, String string, String email);
       
}