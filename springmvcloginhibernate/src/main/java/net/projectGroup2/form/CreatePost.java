package net.projectGroup2.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class CreatePost {
	
	/*@NotEmpty
	@Size(min = 1, max = 50)
	private String userName;*/
	@NotEmpty
	@Size(min = 1, max = 20)
	private String password;
	
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	@NotEmpty
	private String title;
	private String content;
	private String tags;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	

	/*public void setUserName(String userName) {
		System.out.println("33333333");
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}*/
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
}