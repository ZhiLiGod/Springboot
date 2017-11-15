package com.zhi.springboot.springboot2.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration//替代xml配置
public class WebAppConfigurer extends WebMvcConfigurerAdapter {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new ErrorInterceptor()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//没登陆的全部跳转到login
		registry.addViewController("/login").setViewName("login");
		//super.addViewControllers(registry);
	}
}
