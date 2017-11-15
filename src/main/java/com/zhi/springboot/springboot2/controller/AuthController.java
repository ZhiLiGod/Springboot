package com.zhi.springboot.springboot2.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;

import com.zhi.springboot.springboot2.pojo.SysUser;
import com.zhi.springboot.springboot2.service.AuthService;
import com.zhi.springboot.springboot2.service.JwtAuthenticationResponse;

@RestController
public class AuthController {
	
	@Value("${jwt.header}")  
    private String tokenHeader;  
  
    @Autowired  
    private AuthService authService; 
    
    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)  
    public ResponseEntity<?> createAuthenticationToken(  
            String username,String password  
    ) throws AuthenticationException{  
        //  @RequestBody JwtAuthenticationRequest authenticationRequest  
        final String token = authService.login(username,password);  
        // Return the token  
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));  
    } 
    
    @RequestMapping(value="/auth/refresh", method=RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(  
            HttpServletRequest request) throws AuthenticationException{  
        String token = request.getHeader(tokenHeader);  
        String refreshedToken = authService.refresh(token);  
        if(refreshedToken == null) {  
            return ResponseEntity.badRequest().body(null);  
        } else {  
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));  
        }     
    }  
    
    @RequestMapping(value = "${jwt.route.authentication.register}", method = RequestMethod.POST)  
    public SysUser register(@RequestBody SysUser addedUser) 
    		throws AuthenticationException{  
        return authService.register(addedUser);  
    }  
	
}
