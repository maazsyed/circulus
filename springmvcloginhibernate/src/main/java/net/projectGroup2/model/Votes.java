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
@Table(name = "votes")
@SuppressWarnings("serial")
public class Votes implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name = "id", length = 11 )
	private Long id;
	
	@Column(name = "post_id", length = 11 )
	private Long post_id;
	
	@Column(name = "user_name")
	String userName;

	@Column(name = "timestamp")
	Timestamp timestamp;
	
	@Column(name = "vote")
	String vote;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getPostId() {
		return post_id;
	}

	public void setPostId(Long post_id) {
		this.post_id = post_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getVote() {
		return vote;
	}

	public void setVote(String vote) {
		this.vote = vote;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

}