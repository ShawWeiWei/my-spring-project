package me.shaw.yoda.spring.aop;

/**
 * Created by yes on 5/8/16.
 */
public interface ClassFilter {
    boolean matches(Class<?> targetClass);
}
