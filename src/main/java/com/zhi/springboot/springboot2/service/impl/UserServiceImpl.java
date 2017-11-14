package com.zhi.springboot.springboot2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhi.springboot.springboot2.dao.UserDao;
import com.zhi.springboot.springboot2.pojo.User;
import com.zhi.springboot.springboot2.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User findByUserId(String userId) throws Exception {
		return userDao.findByUserId(userId);
	}

	@Override
	public User findByUsername(String username) throws Exception {
		
		return userDao.findByUsername(username);
	}
	
	@Override
	public List<User> findAll() throws Exception {
		return (List<User>) userDao.findAll();
	}
	
	@Override
	public void addUser(User user) throws Exception {
		userDao.save(user);
	}
}
