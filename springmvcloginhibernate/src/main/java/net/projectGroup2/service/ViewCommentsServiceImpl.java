/*
Created by: Maaz Syed
Date: 4/15/2016 12:21pm
*/
package net.projectGroup2.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.projectGroup2.dao.*;
import net.projectGroup2.model.Comments;


@Service("viewcommentsservice")
public class ViewCommentsServiceImpl implements ViewCommentsService {

	 @Autowired
	 private ViewCommentsDAO viewcommentsDAO;

	   public void setViewCommentsDAO(ViewCommentsDAO viewcommentsDAO) {
              this.viewcommentsDAO = viewcommentsDAO;
       }
      
       public List<Comments> viewComments(String userName, String title){
              System.out.println("In Service class...viewComments");
              return viewcommentsDAO.viewComments(userName, title);
       }
       public Long viewVotes(String userName, String title, String vote){
    	   System.out.println("In Service class...viewVotes");
           return viewcommentsDAO.viewVotes(userName, title, vote);
       }
       public Long viewReactions(String userName, String title, String reaction){
    	   System.out.println("In Service class...viewReactions");
           return viewcommentsDAO.viewReactions(userName, title, reaction);
       }
       public Long viewPollSelections(String userName, String title, Long pollSelection){
    	   System.out.println("In Service class...viewPollSelections");
           return viewcommentsDAO.viewPollSelections(userName, title, pollSelection);
       }
}