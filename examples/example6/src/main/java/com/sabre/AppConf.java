package com.sabre;

import com.lyncode.jtwig.mvc.JtwigViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;

/**
 * Created by Michal
 * 2014-11-18.
 */
@Configuration
public class AppConf {
    @Bean
    public ViewResolver viewResolver() {
        JtwigViewResolver viewResolver = new JtwigViewResolver();
        viewResolver.setPrefix("classpath:views/");
        viewResolver.setSuffix(".twig");
        return viewResolver;
    }
}
