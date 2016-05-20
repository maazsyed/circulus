package net.projectGroup2.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pictures")
@SuppressWarnings("serial")
public class Pictures implements Serializable{
	
	@Column(name = "profile_pic")
	String pic;
	
	@Id
	@GeneratedValue
	@Column(name = "image_id")
	String image_id;
	
	@Column(name = "user_name")
	String userName;
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getImage_id() {
		return image_id;
	}
	
	public void setImage_id(String image_id) {
		this.image_id = image_id;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Timestamp getTimestamp1() {
		return timestamp1;
	}

	public void setTimestamp1(Timestamp timestamp1) {
		this.timestamp1 = timestamp1;
	}


	@Column(name = "timestamp")
	Timestamp timestamp1;
	
}

