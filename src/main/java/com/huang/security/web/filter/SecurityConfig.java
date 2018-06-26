package com.huang.security.web.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import com.huang.security.config.CustomUserDetailsService;

@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启security注解
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
   
//    @Autowired
//    DataSource dataSource;
    
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception
    {
        return super.authenticationManager();
    }
    
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
//        auth
//            .ldapAuthentication()
//                .userSearchFilter("(uid={0})")
//                .groupSearchFilter("member={0}");
        
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception 
    {
        http.authorizeRequests()
            .antMatchers("/", "home").permitAll()//允许所有用户访问"/" 和 "home"
            .anyRequest().authenticated()//其余所有地址都需要验证权限
            .and()
            .formLogin()
            .loginPage("/login")//指定登录页为/login
            .defaultSuccessUrl("/hello")//登录成功后默认跳转到"/hello"
            .permitAll()
            .and()
            .logout()
            .logoutSuccessUrl("/home")// 退出登录后，默认URL是"/home"
            .permitAll();
    };
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
    {
        auth
            .userDetailsService(userDetailsService())
            .passwordEncoder(passwordEncoder());
    }
    
    public Md5PasswordEncoder passwordEncoder()
    {
        return new Md5PasswordEncoder();
    }
    
    @Bean
    public CustomUserDetailsService customUserDetailsService()
    {
        return new CustomUserDetailsService();
    }
}
