package com.lanhuigu.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 过滤器
 *
 * @auther: yihonglei
 * @date: 2019-06-02 16:31
 */
public class LanhuiguFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        // 过滤器里面做拦截操作等等
        System.out.println("LanhuiguFilter的doFilter方法");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
