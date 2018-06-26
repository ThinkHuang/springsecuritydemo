package com.huang.security.web.controller;

import javax.annotation.Resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.huang.security.facade.IUserFacade;

@RestController
public class IndexController
{
    
    @Resource
    private IUserFacade userFacade;
    
    @RequestMapping("/home")
    public String home()
    {
        return "home";
        
    }
    
    @PreAuthorize("hasRole('user')")
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String toAdmin()
    {
        
        return "helloAdmin";
    }
    
    @RequestMapping("/hello")
    public String hello()
    {
        
        return "hello";
        
    }
    
    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }
    
    @RequestMapping("/")
    public String root()
    {
        return "index";
        
    }
    
    @RequestMapping("/403")
    public String error()
    {
        return "403";
    }
}
