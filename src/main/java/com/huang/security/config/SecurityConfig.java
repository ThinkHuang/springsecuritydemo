package com.huang.security.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Resource
    private AccessDeniedHandler accessDeniedHandler;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/css/**", "/js/**", "/fonts/**").permitAll() // 允许访问的资源路径
            .antMatchers("/", "home", "/about").permitAll() // 运行访问这三个路由
            .antMatchers("/admin/**").hasAnyRole("ADMIN") // 该资源路径只允许ROLE_ADMIN角色访问
            .antMatchers("/user/**").hasAnyRole("USER") // 该资源路径只允许ROLE_USER角色访问
            .anyRequest().authenticated() // 其余所有的路径都需要权限认证
            .and()
            .formLogin()
            .loginPage("/login")// 确认登陆路径为/login
            .permitAll() // 登陆路径不需要权限认证
            .and()
            .logout()// 退出系统不需要权限认证
            .permitAll()
            .and()
            .exceptionHandling().accessDeniedHandler(accessDeniedHandler);// 自定义异常处理
    }
    
    
    @Autowired
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception
    {
        // 在内存中维护用户user和role，并分配其角色分别为USER和ROLE
        auth.inMemoryAuthentication()
            .withUser("user").password("user").roles("USER")
            .and()
            .withUser("role").password("role").roles("ROLE");
    }
}
