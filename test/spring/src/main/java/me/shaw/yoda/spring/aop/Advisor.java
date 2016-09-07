package me.shaw.yoda.spring.aop;

import org.aopalliance.aop.Advice;

/**
 * Created by yes on 5/8/16.
 */
public interface Advisor {
    Advice getAdvice();
}
