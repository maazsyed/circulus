/*
Created by: Maaz Syed
Date: 4/23/2016 2:24am
*/
package net.projectGroup2.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.projectGroup2.dao.*;
import net.projectGroup2.model.Tags;
import net.projectGroup2.model.Users;
import net.projectGroup2.model.Votes;


@Service("informationService")
public class InformationServiceImpl implements InformationService {

	 @Autowired
	 private InformationDAO informationDAO;

	   public void setInformationDAO(InformationDAO informationDAO) {
              this.informationDAO = informationDAO;
       }
	   
	   public List<Users> getUserInformation(String userName){
		   System.out.println("In Service class...Get User Information");
              return informationDAO.getUserInformation(userName);
	   }
	   
	   public List<Tags> getUserTags(String userName){
		   System.out.println("In Service class...Get User Tags");
              return informationDAO.getUserTags(userName);
	   }
	   
	   public List<Votes> getUserVotes(String userName){
		   System.out.println("In Service class...Get User Votes");
              return informationDAO.getUserVotes(userName);
	   }
}