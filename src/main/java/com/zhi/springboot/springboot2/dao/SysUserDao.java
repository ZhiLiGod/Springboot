package com.zhi.springboot.springboot2.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.zhi.springboot.springboot2.pojo.SysUser;

public interface SysUserDao extends PagingAndSortingRepository<SysUser, Long> {
	
	@Transactional
	public SysUser findByUsername(String username);
}
