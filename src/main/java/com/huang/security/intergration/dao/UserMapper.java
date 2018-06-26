package com.huang.security.intergration.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.huang.security.model.User;

@Mapper
public interface UserMapper
{
    User login(@Param("email") String email, @Param("password") String password);

    User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    User findUserByEmail(@Param("email") String email);
}
