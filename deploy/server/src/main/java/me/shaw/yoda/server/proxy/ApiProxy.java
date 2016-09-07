package me.shaw.yoda.server.proxy;

import me.shaw.yoda.common.exception.ServiceException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by yes on 11/8/16.
 */
@Aspect
@Component
public class ApiProxy {
    public static final Log logger = LogFactory.getLog(ApiProxy.class);

    @Pointcut(value = "execution(* me.shaw.yoda..*.*(..))")
    public void recordLog(){

    }

    @Around(value = "recordLog()")
    public Object handleRuntimeException(ProceedingJoinPoint jp) throws Throwable {
        try {
            return jp.proceed();
        } catch (Exception e) {
            logger.error(jp.getSignature().getDeclaringType()+"$"+jp.getSignature()+"调用失败!参数:"+ Arrays.toString(jp.getArgs()),e);
            if(e instanceof ServiceException) {
                throw e;
            } else {
                throw new ServiceException("System_Error","系统异常");
            }
        }
    }
}
