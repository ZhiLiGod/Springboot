package com.zhi.springboot.springboot2.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="userdetail")
public class User implements Serializable {
	
	private static final long serialVersionUID = -1L;
	
	@Id
	@GenericGenerator(name="uuidGenerator", strategy="uuid")
	@GeneratedValue(generator="uuidGenerator")
	@Column(name="user_id")
	private String userId;
	@Column(name="uname", length=5)
	@NotEmpty(message="username is null")
	private String username;
	@Column(name="age", length=3)
	@DecimalMax("100")
	private int age;
	@Column(name="birthday")
	@Temporal(TemporalType.DATE)
	private Date DOB;
	
	public User(){}
	public User(String name, int age){
		this.username = name;
		this.age = age;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", age="
				+ age + ", DOB=" + DOB + "]";
	}
	
	
	
	
}
