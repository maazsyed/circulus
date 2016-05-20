/*
Created by: Sandeep Kathula Edited by: Maaz Syed
*/
package net.projectGroup2.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.projectGroup2.dao.*;


@Service("createpollservice")
public class CreatePollServiceImpl implements CreatePollService {

	 @Autowired
	 private CreatePollDAO createpollDAO;

	   public void setCreatePollDAO(CreatePollDAO createpollDAO) {
              this.createpollDAO = createpollDAO;
       }
      
     
	//@Override
	public boolean newPoll(String userName, String Title, String Tag, String Question, 
 		   String Option1, String Option2, String Option3, String Option4) {
		System.out.println("In Service class...New Poll");
		return createpollDAO.newPoll(userName, Title, Tag, Question, Option1, Option2, Option3, Option4);
	}
}