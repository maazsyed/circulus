/*Created by: Maaz Syed
Date: 4/15/2016 12:19pm*/
package net.projectGroup2.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class CreateComment {
	
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
	private String react;
	
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
	public String getReact() {
		return react;
	}
	public void setReact(String react) {
		this.react = react;
	}
}