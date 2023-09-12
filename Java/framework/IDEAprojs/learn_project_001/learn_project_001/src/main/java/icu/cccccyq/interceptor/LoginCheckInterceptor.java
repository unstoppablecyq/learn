package icu.cccccyq.interceptor;

import com.alibaba.fastjson.JSONObject;
import icu.cccccyq.pojo.Result;
import icu.cccccyq.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cccccyq
 */
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override//返回true:放行；返回false,不放行
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {

        /*获取请求url*/
        String url = req.getRequestURI().toString();
        log.info("请求url:{}",url);
        /*判断是否login*/
        if (url.contains("login")){
            log.info("登录,放行");
            return true;
        }
        /*获取令牌token*/
        String jwt = req.getHeader("token");
        /*判断令牌*/
        if (!StringUtils.hasLength(jwt)){
            log.info("token is empty");
            Result error = Result.error("NOT_LOGIN");
            //转换成json格式返回-->fastJSON
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return false;
        }
        /*解析token*/
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {//jwt解析失败
            e.printStackTrace();
            log.info("解析失败");
            String notLogin = JSONObject.toJSONString(Result.error("NOT_LOGIN"));
            resp.getWriter().write(notLogin);
            return false;
        }

        /*放行*/
        log.info("合法，放行");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("posthandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("after");
    }
}