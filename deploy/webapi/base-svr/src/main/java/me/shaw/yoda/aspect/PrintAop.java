package me.shaw.yoda.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * Created by yes on 9/5/16.
 */
@Component
@Aspect
public class PrintAop {
    public static final Log logger = LogFactory.getLog(PrintAop.class);

    @Pointcut(value = "@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void recordLog(){

    }

    @Before(value = "recordLog()")
    public void printBefore(JoinPoint jp){
        logger.info("Before "+(MethodSignature)jp.getSignature());
    }

    @After(value = "recordLog()")
    public void printAfter(JoinPoint joinPoint) {
        logger.info("After " + joinPoint.getSignature());
    }
}
