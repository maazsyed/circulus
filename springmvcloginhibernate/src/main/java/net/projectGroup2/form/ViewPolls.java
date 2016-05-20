/*Created by: Maaz Syed
Date: 4/13/2016 12:41am*/
package net.projectGroup2.form;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import net.projectGroup2.model.Polls;
import net.projectGroup2.model.Posts;

public class ViewPolls {
	
	@NotEmpty
	@Size(min = 1, max = 50)
	private String userName;
	@NotEmpty
	@Size(min = 1, max = 20)
	private String password;
	@NotEmpty
	private String title;
	private String tag;
	private String question;
	private String option;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String search;
	private List<Long> option1Count = new ArrayList<>();
	private List<Long> option2Count = new ArrayList<>();
	private List<Long> option3Count = new ArrayList<>();
	private List<Long> option4Count = new ArrayList<>();
	
	/*@NotEmpty
	@Size(min = 1, max = 500)
	private String title;
	
	@NotEmpty
	@Size(min = 1, max = 500)
	private String content;*/
	
	public List<Polls> viewResult;
	public List<Polls> viewTrend;
	public Iterator<Polls> posts;
	public void setviewResult(List<Polls> viewResult) {
		this.viewResult = viewResult;
		posts = viewResult.iterator();
	}
	
	public void setviewTrend(List<Polls> viewTrend) {
		this.viewTrend = viewTrend;
		posts = viewTrend.iterator();
	}
	
	public List<Polls> getviewResult() {
		return viewResult;
	}
	
	public List<Polls> getviewTrend() {
		return viewTrend;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the option2
	 */
	public String getOption2() {
		return option2;
	}

	/**
	 * @param option2 the option2 to set
	 */
	public void setOption2(String option2) {
		this.option2 = option2;
	}

	/**
	 * @return the option1
	 */
	public String getOption1() {
		return option1;
	}

	/**
	 * @param option1 the option1 to set
	 */
	public void setOption1(String option1) {
		this.option1 = option1;
	}

	/**
	 * @return the option3
	 */
	public String getOption3() {
		return option3;
	}

	/**
	 * @param option3 the option3 to set
	 */
	public void setOption3(String option3) {
		this.option3 = option3;
	}

	/**
	 * @return the option4
	 */
	public String getOption4() {
		return option4;
	}

	/**
	 * @param option4 the option4 to set
	 */
	public void setOption4(String option4) {
		this.option4 = option4;
	}

	/**
	 * @return the option2Count
	 */
	public List<Long> getOption2Count() {
		return option2Count;
	}

	/**
	 * @param option2Count the option2Count to set
	 */
	public void setOption2Count(Long option2Count) {
		this.option2Count.add(option2Count);
	}

	/**
	 * @return the option1Count
	 */
	public List<Long> getOption1Count() {
		return option1Count;
	}

	/**
	 * @param option1Count the option1Count to set
	 */
	public void setOption1Count(Long option1Count) {
		this.option1Count.add(option1Count);
	}

	/**
	 * @return the option3Count
	 */
	public List<Long> getOption3Count() {
		return option3Count;
	}

	/**
	 * @param option3Count the option3Count to set
	 */
	public void setOption3Count(Long option3Count) {
		this.option3Count.add(option3Count);
	}

	/**
	 * @return the option4Count
	 */
	public List<Long> getOption4Count() {
		return option4Count;
	}

	/**
	 * @param option4Count the option4Count to set
	 */
	public void setOption4Count(Long option4Count) {
		this.option4Count.add(option4Count);
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