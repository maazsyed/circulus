/*
Created by: Maaz Syed
Date: 4/15/2016 12:24pm
*/
package net.projectGroup2.dao;
import java.util.List;
import net.projectGroup2.model.*;

public interface ViewCommentsDAO{    
       public List<Comments> viewComments(String userName, String title);
       public Long viewVotes(String userName, String title, String vote);
       public Long viewReactions(String userName, String title, String reaction);
       public Long viewPollSelections(String userName, String title, Long pollSelection);
}