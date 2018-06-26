package com.huang.security.service;

import com.huang.security.model.User;

public interface IUserService
{
    User findUserByEmail(String username);
}
