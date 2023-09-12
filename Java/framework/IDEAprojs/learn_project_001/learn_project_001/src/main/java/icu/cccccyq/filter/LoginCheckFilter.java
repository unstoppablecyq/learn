package icu.cccccyq.filter;

import com.alibaba.fastjson.JSONObject;
import icu.cccccyq.pojo.Result;
import icu.cccccyq.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cccccyq
 */
@Slf4j
//@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        /*获取请求url*/
        String url = req.getRequestURI().toString();
        log.info("请求url:{}",url);
        /*判断是否login*/
        if (url.contains("login")){
            log.info("登录,放行");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        /*获取令牌token*/
        String jwt = req.getHeader("token");
        /*判断令牌*/
        if (StringUtils.hasLength(jwt)){
            log.info("token is empty");
            Result error = Result.error("NOT_LOGIN");
            //转换成json格式返回-->fastJSON
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }
        /*解析token*/
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {//jwt解析失败
            e.printStackTrace();
            log.info("解析失败");
            String notLogin = JSONObject.toJSONString(Result.error("NOT_LOGIN"));
            resp.getWriter().write(notLogin);
            return;
        }

        /*放行*/
        log.info("合法，放行");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}