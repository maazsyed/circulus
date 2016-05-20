/*package net.projectGroup2.service;

Created by: Maaz Syed and Venkat Sambandhan


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.projectGroup2.dao.*;


@Service("psservice")
public class ProfileSettingsServiceImpl implements ProfileSettingsService {

	 @Autowired
	 private ProfileSettingsDAO profilesettingsDAO;

	   public void setCreatePostDAO(CreatePostDAO createpostDAO) {
              this.createpostDAO = createpostDAO;
       }
      
     
	//@Override
	public boolean newPost(String userName, String Title, String Content) {
		System.out.println("In Service class...New Post");
		return createpostDAO.newPost(userName, Title, Content);
	}

	@Override
	public boolean changeSettings(String userName, String password) {
		// TODO Auto-generated method stub
		return profilesettingsDAO.changeSettings(userName, password);
	}
}*/