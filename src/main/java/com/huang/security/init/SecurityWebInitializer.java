package com.huang.security.init;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * 功能类似于在web.xml中配置
 * <filter>
 *      <filter-name>springSecurityFilterChain</filter-name>
 *      <filter-class>
 *          org.springframework.web.filter.DelegatingFilterProxy
 *      </filter-class>
 * </filter>
 * @author huangyejun
 * @description：AbstractSecurityWebApplicationInitializer实现了WebApplicationInitializer
 * spring会发现它并用它在web容器中注册DelegatingFilterProxy
 * 所有的请求都会被DelegatingFilterProxy拦截，然后经过校验后发往应用程序
 */
public class SecurityWebInitializer extends AbstractSecurityWebApplicationInitializer
{

}
