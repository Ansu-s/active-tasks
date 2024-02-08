package com.example.springfiler;

import jakarta.servlet.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static java.lang.System.out;

@SpringBootApplication
public class SpringFilter {

    public static void main(String[] args) {
        SpringApplication.run(SpringFilter.class, args);
    }

    @RestController
    public static class WebController {

        @GetMapping("/")
        public String home() {
            return  "home page you requests are watched";
        }
    }

    @Component
    @Order(1)
    public static class Filter1 implements Filter {

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            Filter.super.init(filterConfig);
        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                throws IOException, ServletException {
            out.println("Filter1 - Header set to server name");
            String id = request.getRequestId();
            out.println(id);

            out.println("Header id -> "+ id);
            chain.doFilter(request, response);
            out.println("Filter1 - it is First filer of response");
        }


    }

    @Component
    @Order(2)
    public static class Filter2 implements Filter {

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                throws IOException, ServletException {
            out.println("Filter2 - Pre filer processing using chain");
            chain.doFilter(request, response);
            out.println("Filter2 - It is the post response");
        }
    }

    @Bean
    public FilterRegistrationBean<Filter1> firstFilterRegistrationBean() {
        FilterRegistrationBean<Filter1> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new Filter1());
        registrationBean.addUrlPatterns("/**");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<Filter2> secondFilterRegistrationBean() {
        FilterRegistrationBean<Filter2> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new Filter2());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
