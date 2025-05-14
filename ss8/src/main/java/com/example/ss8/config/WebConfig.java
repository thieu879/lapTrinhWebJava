package com.example.ss8.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration // Đánh dấu class này là file cấu hình Spring
@EnableWebMvc  // Bật Spring MVC (tương đương <mvc:annotation-driven/>)
@ComponentScan(basePackages = {"com.example.ss8.controller", "com.example.ss8.dao", "com.example.ss8.service"}) // Quét package controller
public class WebConfig implements WebMvcConfigurer {

    // Khai báo ViewResolver để Spring tìm đúng file JSP
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();

        // Folder chứa các view
        resolver.setPrefix("/WEB-INF/views/");

        // Đuôi của các view file
        resolver.setSuffix(".jsp");

        return resolver;
    }
}
