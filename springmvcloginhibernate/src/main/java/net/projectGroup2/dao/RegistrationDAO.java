package net.projectGroup2.dao;

import java.util.ArrayList;

import net.projectGroup2.model.*;

public interface RegistrationDAO{    
       public boolean newUser(String userName, String userPassword, ArrayList<String> tags, String biography, String email);
}