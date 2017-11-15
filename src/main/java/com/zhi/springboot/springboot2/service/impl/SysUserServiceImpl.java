package com.zhi.springboot.springboot2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.zhi.springboot.springboot2.dao.SysUserDao;
import com.zhi.springboot.springboot2.pojo.SysUser;

public class SysUserServiceImpl implements UserDetailsService {
	
	@Autowired
	private SysUserDao sysUserDao;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		SysUser user = sysUserDao.findByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("User name not found!");
		}
		System.out.println("username: " + username);
		System.out.println("_username: " + user.getUsername()
				+ "_password: " + user.getPassword());
		return user;
	}
}
