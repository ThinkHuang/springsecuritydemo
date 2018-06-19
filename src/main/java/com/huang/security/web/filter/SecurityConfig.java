package com.huang.security.web.filter;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
@EnableWebSecurity//启用web安全性
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
   
    @Autowired
    DataSource dataSource;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
//        auth
//            .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER")//添加用户名称(username)为user，密码为password，并设置角色为USER
//                .and()
//                .withUser("admin").password("password").roles("USER", "ADMIN");//添加用户admin，密码为password，设置角色为USER和ADMIN
        // roles方法会为用户默认添加ROLE_前缀
        // 入下是等价方法
//        auth
//            .inMemoryAuthentication()
//                .withUser("user").password("password").authorities("ROLE_USER")
//                .and()
//                .withUser("admin").password("password").authorities("ROLE_USER", "ROLE_ADMIN");
        
        // 基于数据库表的认证
//        auth
//            .jdbcAuthentication()
//                .dataSource(dataSource)
//                    .usersByUsernameQuery(
//                            "select username, password, true from Spitter where username=?")
//                    .authoritiesByUsernameQuery(
//                            "select username, 'ROLE_USER' from Spitter where username=?")
//                    .passwordEncoder(new StandardPasswordEncoder("53cr3t"));// 加密密码然后和数据库进行匹配
        
        // 基于LDAP的认证
        auth
            .ldapAuthentication()
                .userSearchFilter("(uid={0})")
                .groupSearchFilter("member={0}");
    }
}
