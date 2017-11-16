package com.zhi.springboot.springboot2.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhi.springboot.springboot2.pojo.User;

@Controller
public class HelloController {
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	//@ResponseBody
	public String hello(Model model) throws Exception{
		User user1 = new User();
		user1.setAge(10);
		user1.setUsername("user1");
		user1.setDOB(new Date());
		User user2 = new User();
		user2.setAge(80);
		user2.setUsername("user2");
		user2.setDOB(new Date());
		User user3 = new User();
		user3.setAge(30);
		user3.setUsername("user3");
		user3.setDOB(new Date());
		List<User> users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		model.addAttribute("users", users);
		model.addAttribute("name", "Json");
		
		return "hello";
	}
	
}
