package com.huang.security.model;

public class Role
{
    private Integer id;
    
    private User User;
    
    private String name;
    
    public Integer getId()
    {
        return id;
    }
    
    public void setId(Integer id)
    {
        this.id = id;
    }
    
    public User getUser()
    {
        return User;
    }
    
    public void setUser(User user)
    {
        User = user;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
}
