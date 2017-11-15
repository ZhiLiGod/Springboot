package com.zhi.springboot.springboot2.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import com.zhi.springboot.springboot2.dao.SysUserDao;
import com.zhi.springboot.springboot2.pojo.SysUser;
import com.zhi.springboot.springboot2.service.AuthService;
import com.zhi.springboot.springboot2.util.JwtTokenUtil;

@Service
public class AuthServiceImpl implements AuthService {
	
	private AuthenticationManager authenticationManager;  
    private UserDetailsService userDetailsService;  
    private JwtTokenUtil jwtTokenUtil; 
    private SysUserDao sysUserDao;
    @Value("${jwt.tokenHead}")  
    private String tokenHead;
    @Autowired  
    public AuthServiceImpl(  
            AuthenticationManager authenticationManager,  
            UserDetailsService userDetailsService,  
            JwtTokenUtil jwtTokenUtil,  
            SysUserDao sysUserDao) {  
        this.authenticationManager = authenticationManager;  
        this.userDetailsService = userDetailsService;  
        this.jwtTokenUtil = jwtTokenUtil;  
        this.sysUserDao = sysUserDao;  
    }
    
    
	@Override
	public SysUser register(SysUser userToAdd){
		final String username = userToAdd.getUsername();
		if(sysUserDao.findByUsername(username) != null){
			return null;
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		final String password = userToAdd.getPassword();
		userToAdd.setPassword(encoder.encode(password));
		userToAdd.setLastPasswordResetDate(new Date());
		return sysUserDao.save(userToAdd);
	}

	@Override
	public String login(String username, String password){
		UsernamePasswordAuthenticationToken uptoken = 
				new UsernamePasswordAuthenticationToken(username, password);
		final Authentication authentication = 
				authenticationManager.authenticate(uptoken);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		final String token = jwtTokenUtil.generateToken(userDetails);
		return token;
	}

	@Override
	public String refresh(String oldToken){
		final String token = oldToken.substring(tokenHead.length());
		String username = jwtTokenUtil.getUsernameFromToken(token);
		SysUser user = (SysUser) userDetailsService.loadUserByUsername(username);
		if(jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())){
			return jwtTokenUtil.refreshToken(token);
		}
		return null;
	}
	
}
