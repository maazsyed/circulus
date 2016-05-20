/*Created by: Maaz Syed
Date: 4/15/2016 12:19pm*/
package net.projectGroup2.form;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import net.projectGroup2.model.Comments;

public class ViewComments {
	
	@NotEmpty
	@Size(min = 1, max = 50)
	private String userName;
	@NotEmpty
	@Size(min = 1, max = 20)
	private String password;
	@NotEmpty
	private String title;
	private String content;
	private String comment;
	private Timestamp timestamp;
	
	/*@NotEmpty
	@Size(min = 1, max = 500)
	private String title;
	
	@NotEmpty
	@Size(min = 1, max = 500)
	private String content;*/
	
	public List<Comments> viewResult;
	public Iterator<Comments> comments;
	public void setviewResult(List<Comments> viewResult) {
		this.viewResult = viewResult;
		comments = viewResult.iterator();
	}
	
	public List<Comments> getviewResult() {
		return viewResult;
	}
	
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
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
}