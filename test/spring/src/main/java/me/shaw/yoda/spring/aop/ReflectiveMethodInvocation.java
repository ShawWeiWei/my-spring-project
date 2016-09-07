package me.shaw.yoda.spring.aop;

import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
 * Created by yes on 5/8/16.
 */
public class ReflectiveMethodInvocation implements MethodInvocation {
    protected Object target;
    protected Method method;
    protected Object[] arguments;

    public ReflectiveMethodInvocation(Object target, Method method, Object[] arguments) {
        this.target = target;
        this.method = method;
        this.arguments = arguments;
    }

    public Method getMethod() {
        return method;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public Object getThis() {
        return target;
    }

    public Object proceed() throws Throwable {
        return method.invoke(target, arguments);
    }

    public AccessibleObject getStaticPart() {
        return method;
    }
}
