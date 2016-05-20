/*Created by: Maaz Syed
Date: 4/23/2016 3:02am*/
package net.projectGroup2.form;
import java.util.Iterator;
import java.util.List;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

import net.projectGroup2.model.Posts;
import net.projectGroup2.model.Tags;
import net.projectGroup2.model.Users;
public class Information {
	@NotEmpty
	@Size(min = 1, max = 50)
	private String userName;
	@NotEmpty
	@Size(min = 1, max = 20)
	private String biography;
	
	private Long votes;
	
	public List<Users> viewResult;
	public void setviewResult(List<Users> viewResult) {
		this.viewResult = viewResult;
	}
	
	public List<Users> getviewResult() {
		return viewResult;
	}
	
	public List<Tags> viewTagResult;
	public void setviewTagResult(List<Tags> viewTagResult) {
		this.viewTagResult = viewTagResult;
	}
	
	public List<Tags> getviewTagResult() {
		return viewTagResult;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}
	public String getBiography() {
		return biography;
	}

	/**
	 * @return the votes
	 */
	public Long getVotes() {
		return votes;
	}

	/**
	 * @param votes the votes to set
	 */
	public void setVotes(Long votes) {
		this.votes = votes;
	}
}
