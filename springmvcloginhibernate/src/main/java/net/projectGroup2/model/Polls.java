/*Created by: Maaz Syed
Date: 4/18/2016 10:53am*/
package net.projectGroup2.model;

import java.io.Serializable;

import java.util.List;
import java.sql.Timestamp;

import javax.persistence.Basic;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.persistence.Embeddable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "polls")
@SuppressWarnings("serial")
public class Polls implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name = "id", length = 11 )
	private Long id;
	
	@Column(name = "user_name")
	String userName;

	@Column(name = "title")
	String title;
	
	@Column(name = "question")
	String question;
	
	@Column(name = "timestamp")
	Timestamp timestamp;
	
	@Column(name = "tag")
	String tag;
	
	@Column(name = "option1")
	String option1;
	
	@Column(name = "option2")
	String option2;
	
	@Column(name = "option3")
	String option3;
	
	@Column(name = "option4")
	String option4;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getTags() {
		return tag;
	}

	public void setTags(String tag) {
		this.tag = tag;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}
	
	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}
	
	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}
	
	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}
}