package net.projectGroup2.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.projectGroup2.dao.LoginDAO;
import net.projectGroup2.dao.RegistrationDAO;

@Service("registrationService")
public class RegistrationServiceImpl implements RegistrationService {

	 @Autowired
	 private RegistrationDAO registrationDAO;

	   public void setRegistrationDAO(LoginDAO registration) {
              this.registrationDAO = registrationDAO;
       }
      
       public boolean newUser(String userName, String userPassword, ArrayList<String> tags, String biography, String email){
              System.out.println("New user1..");
              return registrationDAO.newUser(userName, userPassword, tags, biography, email);
       }
}