package com.example.demo;

import com.example.demo.security.CustomFilterInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    private CustomFilterInterceptor customFilterInterceptor;

    @Bean
    public FilterRegistrationBean apiUnsecureFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(customFilterInterceptor);
        registration.setEnabled(true);
        registration.addUrlPatterns("/course/*", "/action/*", "/student/listAll", "/student/{id}");
        return registration;
    }

}
