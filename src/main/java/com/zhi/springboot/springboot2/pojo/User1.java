package com.zhi.springboot.springboot2.pojo;

import java.io.Serializable;

public class User1 implements Serializable {
	private static final long serialVersionUID = -1L;

    private String username;
    private Integer age;

    public User1(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
    
    
}
