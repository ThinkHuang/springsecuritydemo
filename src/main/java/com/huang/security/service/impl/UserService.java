package com.huang.security.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huang.security.intergration.dao.UserMapper;
import com.huang.security.model.User;
import com.huang.security.service.IUserService;

@Service
public class UserService implements IUserService
{

    @Resource
    private UserMapper userMapper;
    
    public User findUserByEmail(String username)
    {
        return userMapper.findUserByEmail(username);
    }

}
