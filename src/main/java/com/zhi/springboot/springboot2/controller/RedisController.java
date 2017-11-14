package com.zhi.springboot.springboot2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhi.springboot.springboot2.pojo.User;
import com.zhi.springboot.springboot2.pojo.User1;

@RestController
public class RedisController {
	@Autowired
    private StringRedisTemplate stringRedisTemplate;

	@Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/hello")
    public String index() {

        User1 user = new User1("超人", 20);
        redisTemplate.opsForValue().set(user.getUsername(), user);

        user = new User1("蝙蝠侠", 30);
        redisTemplate.opsForValue().set(user.getUsername(), user);

        user = new User1("蜘蛛侠", 40);
        redisTemplate.opsForValue().set(user.getUsername(), user);
        User1 user1 = (User1) redisTemplate.opsForValue().get("超人");
        System.out.println(user1.getAge());
        System.out.println(((User1)redisTemplate.opsForValue().get("蝙蝠侠")).getAge().longValue());
        System.out.println(((User1)redisTemplate.opsForValue().get("蜘蛛侠")).getAge());

        return "Hello World";
    }
}
