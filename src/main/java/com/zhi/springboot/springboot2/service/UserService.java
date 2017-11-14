package com.zhi.springboot.springboot2.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhi.springboot.springboot2.pojo.User;


public interface UserService {
	
	@Transactional
	public User findByUserId(String userId) throws Exception;
	
	@Transactional
	public User findByUsername(String username) throws Exception;
	
	@Transactional
	public List<User> findAll() throws Exception;
	
	@Transactional
	public void addUser(User user) throws Exception;
	
}
