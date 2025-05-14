package com.example.ss8.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    // Không dùng root config (ví dụ như security hoặc dataSource), nên để null
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }
    // Dùng WebConfig để cấu hình Spring MVC
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfig.class };
    }
    // Gắn DispatcherServlet xử lý mọi request '/'
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
