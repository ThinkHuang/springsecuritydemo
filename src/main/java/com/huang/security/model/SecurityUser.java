package com.huang.security.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.huang.security.util.Tools;

public class SecurityUser extends User implements UserDetails
{
    
    private static final long serialVersionUID = 1L;
    
    public SecurityUser(User user)
    {
        if (user != null)
        {
            this.setId(user.getId());
            this.setName(user.getName());
            this.setEmail(user.getEmail());
            this.setPassword(user.getPassword());
            this.setDob(user.getDob());
            this.setRoles(user.getRoles());
        }
    }
    
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        Set<Role> useRoles = this.getRoles();
        if(Tools.isNotEmpty(useRoles))
        {
            for (Role role : useRoles)
            {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
                authorities.add(authority);
            }
        }
        return authorities;
    }
    
    public String getUsername()
    {
        return null;
    }
    
    public boolean isAccountNonExpired()
    {
        return false;
    }
    
    public boolean isAccountNonLocked()
    {
        return false;
    }
    
    public boolean isCredentialsNonExpired()
    {
        return false;
    }
    
    public boolean isEnabled()
    {
        return false;
    }
    
}
