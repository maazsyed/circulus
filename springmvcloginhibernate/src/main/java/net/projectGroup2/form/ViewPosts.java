/*Created by: Maaz Syed
Date: 4/13/2016 12:41am*/
package net.projectGroup2.form;
import java.util.Iterator;
import java.util.List;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import net.projectGroup2.model.Posts;

public class ViewPosts {
	
	@NotEmpty
	@Size(min = 1, max = 50)
	private String userName;
	@NotEmpty
	@Size(min = 1, max = 20)
	private String password;
	@NotEmpty
	private String title;
	private String content;
	private String option;
	private String search;
	
	/*@NotEmpty
	@Size(min = 1, max = 500)
	private String title;
	
	@NotEmpty
	@Size(min = 1, max = 500)
	private String content;*/
	
	public List<Posts> viewResult;
	public List<Posts> viewTrend;
	public Iterator<Posts> posts;
	public void setviewResult(List<Posts> viewResult) {
		this.viewResult = viewResult;
		posts = viewResult.iterator();
	}
	
	public void setviewTrend(List<Posts> viewTrend) {
		this.viewTrend = viewTrend;
		posts = viewTrend.iterator();
	}
	
	public List<Posts> getviewResult() {
		return viewResult;
	}
	
	public List<Posts> getviewTrend() {
		return viewTrend;
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

	/**
	 * @return the option
	 */
	public String getOption() {
		return option;
	}

	/**
	 * @param option the option to set
	 */
	public void setOption(String option) {
		this.option = option;
	}

	/**
	 * @return the search
	 */
	public String getSearch() {
		return search;
	}

	/**
	 * @param search the search to set
	 */
	public void setSearch(String search) {
		this.search = search;
	}
}