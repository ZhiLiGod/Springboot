package com.zhi.springboot.springboot2.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.zhi.springboot.springboot2.pojo.User;

@Repository
public interface UserDao extends PagingAndSortingRepository<User, String> {
	public User findByUserId(String userId) throws Exception;
	public User findByUsername(String username) throws Exception;
}
