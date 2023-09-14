package icu.cccccyq.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author cccccyq
 */
//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {

    @Override//初始化,就调用一次
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
        System.out.println("初始化");

    }

    @Override//拦截请求之后调用,调用多次
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截到了");
        System.out.println("放行前test");
        //放行
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("放行后test");
    }

    @Override//销毁,就调用一次
    public void destroy() {
//        Filter.super.destroy();
        System.out.println("销毁了");
    }
}