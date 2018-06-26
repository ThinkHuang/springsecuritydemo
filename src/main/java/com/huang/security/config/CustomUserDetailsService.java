package com.huang.security.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.huang.security.model.SecurityUser;
import com.huang.security.model.User;
import com.huang.security.service.IUserService;
import com.huang.security.util.Tools;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
    
    @Autowired
    private IUserService userService;
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userService.findUserByEmail(username);
        if(Tools.isEmpty(user))
        {
            throw new UsernameNotFoundException("UserName " + username + " not found");
        }
        // SecurityUser实现UserDetails并将User的Email映射为username
        SecurityUser securityUser = new SecurityUser(user);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return securityUser; 
    }
    
}
