package me.shaw.yoda.spring.aop;

import java.lang.reflect.Method;

/**
 * Created by yes on 5/8/16.
 */
public interface MethodMatcher {
    boolean matches(Method method, Class<?> targetClass);
}
