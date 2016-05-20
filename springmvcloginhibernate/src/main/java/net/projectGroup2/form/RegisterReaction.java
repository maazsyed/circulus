/*Created by: Maaz Syed
Date: 4/15/2016 12:19pm*/
package net.projectGroup2.form;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class RegisterReaction {
	
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
	private Long upCount;
	private Long downCount;
	private Long happyCount;
	private Long angryCount;
	private Long sadCount;
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

	public Long getUpCount() {
		return upCount;
	}

	public void setUpCount(Long upCount) {
		this.upCount = upCount;
	}

	/**
	 * @return the downCount
	 */
	public Long getDownCount() {
		return downCount;
	}

	/**
	 * @param downCount the downCount to set
	 */
	public void setDownCount(Long downCount) {
		this.downCount = downCount;
	}

	/**
	 * @return the happyCount
	 */
	public Long getHappyCount() {
		return happyCount;
	}

	/**
	 * @param happyCount the happyCount to set
	 */
	public void setHappyCount(Long happyCount) {
		this.happyCount = happyCount;
	}

	/**
	 * @return the angryCount
	 */
	public Long getAngryCount() {
		return angryCount;
	}

	/**
	 * @param angryCount the angryCount to set
	 */
	public void setAngryCount(Long angryCount) {
		this.angryCount = angryCount;
	}

	/**
	 * @return the sadCount
	 */
	public Long getSadCount() {
		return sadCount;
	}

	/**
	 * @param sadCount the sadCount to set
	 */
	public void setSadCount(Long sadCount) {
		this.sadCount = sadCount;
	}
}