package icu.cccccyq.aop;

import com.alibaba.fastjson.JSONObject;
import icu.cccccyq.mapper.OperateLogMapper;
import icu.cccccyq.pojo.OperateLog;
import icu.cccccyq.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author cccccyq
 */
@Slf4j
@Component
@Aspect
public class LogAspect {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(icu.cccccyq.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {

        //ID-请求中当中的JWT令牌并解析
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(jwt);
        Integer operateUser = (Integer) claims.get("id");

        //操作时间
        LocalDateTime operateTime = LocalDateTime.now();

        //操作类类名
        String className = joinPoint.getTarget().getClass().getName();

        //方法名
        String methodName = joinPoint.getSignature().getName();

        //传入参数
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);

        long begin = System.currentTimeMillis();
        //调用原始目标方法
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();

        //返回值
        String returnValue = JSONObject.toJSONString(result);

        //执行操作的时间
        Long costTime = end - begin;

        //记录
        OperateLog operateLog = new OperateLog(null,operateUser,operateTime, className, methodName, methodParams, returnValue, costTime);
        operateLogMapper.insert(operateLog);
        log.info("记录操作日志：{}", operateLog);
        return result;
    }
}