package com.huang.security.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User
{
    private Integer id;
    
    private String name;
    
    private String email;
    
    private String password;
    
    private Date dob;
    
    private Set<Role> roles = new HashSet<Role>(0);
    
    public Integer getId()
    {
        return this.id;
    }
    
    public void setId(Integer id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getEmail()
    {
        return this.email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getPassword()
    {
        return this.password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public Date getDob()
    {
        return this.dob;
    }
    
    public void setDob(Date dob)
    {
        this.dob = dob;
    }
    
    public Set<Role> getRoles()
    {
        return roles;
    }
    
    public void setRoles(Set<Role> roles)
    {
        this.roles = roles;
    }
}
