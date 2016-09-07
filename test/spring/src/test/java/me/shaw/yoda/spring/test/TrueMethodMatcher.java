package me.shaw.yoda.spring.test;

import me.shaw.yoda.spring.aop.MethodMatcher;

import java.lang.reflect.Method;

/**
 * Created by yes on 5/8/16.
 */
public class TrueMethodMatcher implements MethodMatcher {

    public boolean matches(Method method, Class<?> targetClass) {
        return true;
    }
}
