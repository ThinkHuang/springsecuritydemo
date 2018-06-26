package com.huang.security.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorPageConfig
{

    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer()
    {
        return new MyCsutomizer();
    }
    
    class MyCsutomizer implements EmbeddedServletContainerCustomizer
    {

        public void customize(ConfigurableEmbeddedServletContainer container)
        {
            container.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/403"));
        }
    }
}
