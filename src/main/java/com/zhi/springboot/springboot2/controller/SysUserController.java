package com.zhi.springboot.springboot2.controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhi.springboot.springboot2.pojo.Msg;

@Controller
public class SysUserController {
	
	@RequestMapping("/")
	public String index(Model model){
		Msg msg = new Msg("Title", "Content"
				, "Extra Info (only for admin)");
		model.addAttribute("msg", msg);
		return "index";
	}
	
	
	@PreAuthorize("hasAuthority('ROLE_USER')")  
    @RequestMapping(value="/admin/test1")  
    @ResponseBody  
    public String adminTest1() {  
        return "ROLE_USER";  
    }  
      
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")  
    @RequestMapping("/admin/test2")  
    @ResponseBody  
    public String adminTest2() {  
        return "ROLE_ADMIN";  
    }  
}
