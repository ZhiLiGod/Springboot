package com.zhi.springboot.springboot2.controller;

import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhi.springboot.springboot2.pojo.User;
import com.zhi.springboot.springboot2.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/user/{userId}")
	public User findUser(@PathVariable("userId") String userId) throws Exception{
		User user = userService.findByUserId(userId);	
		return user;
	}
	
	@RequestMapping("/users/{page}")
	public List<User> findAll(@PathVariable("page") String page) throws Exception{
		System.out.println(page);
		Sort sort = new Sort(Sort.Direction.DESC, "userId");
		Pageable pageable = new PageRequest(Integer.parseInt(page), 2, sort);
		Page<User> pages = userService.findAllUsers(pageable);	
		return pages.getContent();
	}
	
	@RequestMapping("/add")
	public void addUser() throws Exception{
		User newUser = new User();
		newUser.setAge(10);
		newUser.setDOB(new Date());
		newUser.setUsername("Kevin Kirwan");
		userService.addUser(newUser);
	}
}
