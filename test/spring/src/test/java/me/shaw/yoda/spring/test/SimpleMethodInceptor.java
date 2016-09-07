package me.shaw.yoda.spring.test;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by yes on 5/8/16.
 */
public class SimpleMethodInceptor implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable{
        System.out.println("Before proceed!");
        Object obj = methodInvocation.proceed();
        System.out.println("After proceed!");
        return obj;
    }
}
