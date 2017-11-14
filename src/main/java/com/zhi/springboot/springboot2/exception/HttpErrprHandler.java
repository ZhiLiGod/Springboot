package com.zhi.springboot.springboot2.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpErrprHandler implements ErrorController {
	
	private final static String ERROR_PATH = "/error";
	
	@RequestMapping(value=ERROR_PATH)
	public String errorHtml(HttpServletRequest req){
		return "This is a 404";
	}
	
	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}
	
}
