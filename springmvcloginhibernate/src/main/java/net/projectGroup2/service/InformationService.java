/*
Created by: Maaz Syed
Date: 4/23/2016 2:10am
*/
package net.projectGroup2.service;
import java.util.List;
import net.projectGroup2.model.*;

public interface InformationService{    
       public List<Users> getUserInformation(String userName);
	   public List<Tags> getUserTags(String userName);
	   public List<Votes> getUserVotes(String userName);
}