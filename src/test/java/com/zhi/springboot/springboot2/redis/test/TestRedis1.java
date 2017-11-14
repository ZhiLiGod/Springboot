package com.zhi.springboot.springboot2.redis.test;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhi.springboot.springboot2.Springboot2Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Springboot2Application.class)
public class TestRedis1 {
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Test
	public void test() throws Exception{
		stringRedisTemplate.opsForValue().set("aaa", "111");
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
	}
	
}
