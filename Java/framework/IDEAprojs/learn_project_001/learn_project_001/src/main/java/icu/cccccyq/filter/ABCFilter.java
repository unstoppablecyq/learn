package icu.cccccyq.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author cccccyq
 */

//@WebFilter(urlPatterns = "/*")
public class ABCFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    /**
     ** 暴露过滤器
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("before1");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("after1");
    }

    /**
     * @author cccccyq
     * destory
     */
    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}