package com.qiao.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    @Override  //初始化方法
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init初始化方法执行了");
        //Filter.super.init(filterConfig);
    }

    @Override //拦截到请求后调用，调用多次
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截到了请求");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override //销毁方法
    public void destroy() {
        System.out.println("destory销毁方法执行了");
        // Filter.super.destroy();
    }
}
