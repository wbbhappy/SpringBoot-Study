package com.lanhuigu.springboot.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.lanhuigu.springboot.filter.LanhuiguFilter;
import com.lanhuigu.springboot.interceptor.LanhuiguInterceptor;
import com.lanhuigu.springboot.servlet.LanhuiguServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.thymeleaf.spring4.SpringTemplateEngine;
//import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
//import org.thymeleaf.spring4.view.ThymeleafViewResolver;
//import org.thymeleaf.templateresolver.ITemplateResolver;

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

    /*
     * spring boot中如何使用fastjson框架，而不是使用默认jackson框架解析json数据
     */
    // ###########################方法一##########################
    /*
     * 覆盖方法configureMessageConverters
     */
//     @Override
//     public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//         super.configureMessageConverters(converters);
//         /*
//         * 1、需要先定义一个converters转换消息的对象
//         * 2、添加fastjson的配置信息，比如: 是否需要格式化返回的json数据
//         * 3、在converter中添加配置信息
//         * 4、将converter添加到converters信息中
//         */
//         // 1、需要先定义一个converters转换消息的对象
//         FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//
//         // 2、添加fastjson的配置信息，比如: 是否需要格式化返回的json数据
//         FastJsonConfig fastJsonConfig = new FastJsonConfig();
//         fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//
//         // 3、在converter中添加配置信息
//         fastConverter.setFastJsonConfig(fastJsonConfig);
//
//         // 4、将converter添加到converters信息中
//         converters.add(fastConverter);
//     }
    // ###########################方法二##########################
    /*
     * 注入bean:HttpMessageConverters
     */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        // 1、需要先定义一个converters转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

        // 2、添加fastjson的配置信息，比如: 是否需要格式化返回的json数据
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

        // 3、在converter中添加配置信息
        fastConverter.setFastJsonConfig(fastJsonConfig);

        // 4、将converter赋值给HttpMessageConverter
        HttpMessageConverter<?> converter = fastConverter;

        // 5、返回HttpMessageConverters对象
        return new HttpMessageConverters(converter);
    }

//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/");
//        resolver.setSuffix(".jsp");
//        resolver.setViewNames("/*");
//        resolver.setOrder(2);
//        return resolver;
//    }
//
//    @Bean
//    public ITemplateResolver templateResolver() {
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//        templateResolver.setTemplateMode("HTML5");
//        templateResolver.setPrefix("classpath:/templates/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setCharacterEncoding("utf-8");
//        templateResolver.setCacheable(false);
//        return templateResolver;
//    }
//
//    @Bean
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//        return templateEngine;
//    }
//
//    @Bean
//    public ThymeleafViewResolver viewResolverThymeLeaf() {
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//        viewResolver.setTemplateEngine(templateEngine());
//        viewResolver.setCharacterEncoding("utf-8");
//        viewResolver.setViewNames(new String[]{"thymeleaf/*"});
//        viewResolver.setOrder(1);
//        return viewResolver;
//    }

}
