/*
Created by: Maaz Syed
Date: 4/17/2016 5:32pm
*/
package net.projectGroup2.service;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.projectGroup2.dao.*;


@Service("createcommentservice")
public class CreateCommentServiceImpl implements CreateCommentService {

	 @Autowired
	 private CreateCommentDAO createcommentDAO;

	   public void setCreateCommentDAO(CreateCommentDAO createcommentDAO) {
              this.createcommentDAO = createcommentDAO;
       }
      
     
	//@Override
	public boolean newComment(Long postId, String userName, String Content) {
		System.out.println("In Service class...New Comment");
		return createcommentDAO.newComment(postId, userName, Content);
	}
	
	//@Override
	public boolean newVote(Long postId, String userName, String Vote) {
		System.out.println("In Service class...New Vote");
		return createcommentDAO.newVote(postId, userName, Vote);
	}
	
	//@Override
	public boolean newReaction(Long postId, String userName, String Reaction) {
		System.out.println("In Service class...New Reaction");
		return createcommentDAO.newReaction(postId, userName, Reaction);
	}
	
	public boolean newPollSelection(Long postId, String userName, Long option) {
		System.out.println("In Service class...New Poll Selection");
		return createcommentDAO.newPollSelection(postId, userName, option);
	}
}