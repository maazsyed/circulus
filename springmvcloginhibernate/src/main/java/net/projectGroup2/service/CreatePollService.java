/*
Created by: Sandeep Kathula Edited by: Maaz Syed
*/
package net.projectGroup2.service;
import net.projectGroup2.model.*;

public interface CreatePollService{    
       public boolean newPoll(String userName, String Title, String Tag, String Question, 
    		   String Option1, String Option2, String Option3, String Option4);
}