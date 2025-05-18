package com.example.ss10.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration // Đánh dấu class này là file cấu hình Spring
@EnableWebMvc  // Bật Spring MVC (tương đương <mvc:annotation-driven/>)
@ComponentScan(basePackages = {"com.example.ss10.controller", "com.example.ss10.service", "com.example.ss10.repository"}) // Quét package controller
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();

        // Folder chứa các view
        resolver.setPrefix("/WEB-INF/views/");

        // Đuôi của các view file
        resolver.setSuffix(".jsp");

        return resolver;
    }
    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dcunbzpkh",      // Tên cloud (trong tài khoản Cloudinary)
                "api_key", "939658138784662",            // API key được cấp bởi Cloudinary
                "api_secret", "6Ds7dmgAr8Z8it1nWYL5-6y0LGU",      // API secret tương ứng để xác thực
                "secure", true                        // Bật chế độ truyền tải HTTPS (nên luôn để true)
        ));
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("utf-8");
        resolver.setMaxUploadSize(5 * 1024 * 1024); // 5MB
        return resolver;
    }
}
