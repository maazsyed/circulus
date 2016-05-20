/*
Created by: Maaz Syed
Date: 4/17/2016 5:37pm
*/
package net.projectGroup2.dao;
import java.util.ArrayList;
import net.projectGroup2.model.*;

public interface CreateCommentDAO{    
       public boolean newComment(Long postId, String userName, String Content);
	   public boolean newVote(Long postId, String userName, String Vote);
	   public boolean newReaction(Long postId, String userName, String Reaction);
	   public boolean newPollSelection(Long postId, String userName, Long option) ;
}