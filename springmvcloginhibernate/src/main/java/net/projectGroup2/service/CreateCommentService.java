/*
Created by: Maaz Syed
Date: 4/17/2016 5:35pm
*/
package net.projectGroup2.service;
import java.util.ArrayList;
import net.projectGroup2.model.*;

public interface CreateCommentService{    
       public boolean newComment(Long postId, String userName, String Content) ;
	   public boolean newVote(Long postId, String userName, String Vote) ;
	   public boolean newReaction(Long postId, String userName, String Reaction) ;
	   public boolean newPollSelection(Long postId, String userName, Long option) ;
}