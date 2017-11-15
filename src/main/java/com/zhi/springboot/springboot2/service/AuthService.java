package com.zhi.springboot.springboot2.service;

import com.zhi.springboot.springboot2.pojo.SysUser;

public interface AuthService {
	public SysUser register(SysUser userToAdd);
	public String login(String username, String password);
	public String refresh(String oldToken);
}
