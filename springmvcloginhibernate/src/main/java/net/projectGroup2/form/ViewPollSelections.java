/*Created by: Maaz Syed
Date: 4/13/2016 12:41am*/
package net.projectGroup2.form;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ViewPollSelections {
	
	@NotEmpty
	@Size(min = 1, max = 50)
	private String userName;
	@NotEmpty
	@Size(min = 1, max = 20)
	private String password;
	@NotEmpty
	private String title;
	private String comment;
	private Long post_id;
	private Long option1Count;
	private Long option2Count;
	private Long option3Count;
	private Long option4Count;
	/*private List<String> reactions = new ArrayList<String>();*/
	
	private String reactions;

	public String getReactions() {
		return reactions;
	}

	public void setReactions(String reactions) {
		this.reactions = reactions;
	}
	/*@NotEmpty
	@Size(min = 1, max = 500)
	private String title;
	
	@NotEmpty
	@Size(min = 1, max = 500)
	private String content;*/
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	

	public void setUserName(String userName) {
		System.out.println("33333333");
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	
	public void setPostId(Long post_id) {
		this.post_id = post_id;
	}
	public Long getPostId() {
		return post_id;
	}
	/* public String getReact() {
		return react;
	}
	public void setReact(String react) {
		this.react = react;
	} */
	/*public List<String> getReactions() {
		return reactions;
	}
	public void setReactions(String reactions) {
		this.reactions.add(reactions);
	}*/

	/**
	 * @return the option1Count
	 */
	public Long getOption1Count() {
		return option1Count;
	}

	/**
	 * @param option1Count the option1Count to set
	 */
	public void setOption1Count(Long option1Count) {
		this.option1Count = option1Count;
	}

	/**
	 * @return the option2Count
	 */
	public Long getOption2Count() {
		return option2Count;
	}

	/**
	 * @param option2Count the option2Count to set
	 */
	public void setOption2Count(Long option2Count) {
		this.option2Count = option2Count;
	}

	/**
	 * @return the option3Count
	 */
	public Long getOption3Count() {
		return option3Count;
	}

	/**
	 * @param option3Count the option3Count to set
	 */
	public void setOption3Count(Long option3Count) {
		this.option3Count = option3Count;
	}

	/**
	 * @return the option4Count
	 */
	public Long getOption4Count() {
		return option4Count;
	}

	/**
	 * @param option4Count the option4Count to set
	 */
	public void setOption4Count(Long option4Count) {
		this.option4Count = option4Count;
	}

	
}