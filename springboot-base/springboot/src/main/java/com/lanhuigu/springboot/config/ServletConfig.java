package com.lanhuigu.springboot.config;

import com.lanhuigu.springboot.filter.LanhuiguFilter;
import com.lanhuigu.springboot.interceptor.LanhuiguInterceptor;
import com.lanhuigu.springboot.servlet.LanhuiguServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * ServletConfig控制
 *
 * @auther: yihonglei
 * @date: 2019-06-02 16:19
 */
@Configuration
public class ServletConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private LanhuiguInterceptor lanhuiguInterceptor;

    /**
     * 注册过滤器(Filter)
     */
    @Bean
    public FilterRegistrationBean lanhuiguFilterBean() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new LanhuiguFilter());
        registration.addUrlPatterns("/*");

        return registration;
    }

    /**
     * 注册拦截器(Interceptor)
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(lanhuiguInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/index.html", "/");
    }

    /**
     * 注册Servlet
     */
    @Bean
    public ServletRegistrationBean lanhuiguServletBean() {
        ServletRegistrationBean registration = new ServletRegistrationBean();
        registration.setServlet(new LanhuiguServlet());
        registration.addUrlMappings("/lanhuiguServlet");

        return registration;
    }

}
