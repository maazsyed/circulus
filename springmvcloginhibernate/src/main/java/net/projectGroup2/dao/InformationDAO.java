/*
Created by: Maaz Syed
Date: 4/23/2016 2:29am
*/
package net.projectGroup2.dao;
import java.util.List;
import net.projectGroup2.model.*;

public interface InformationDAO{
	   public List<Users> getUserInformation(String userName);
	   public List<Tags> getUserTags(String userName);
	   public List<Votes> getUserVotes(String userName);
}