package me.shaw.yoda.spring.aop;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by yes on 5/8/16.
 */
public class JdkDynamicAopProxy extends AbstractAopProxy implements InvocationHandler {
    public JdkDynamicAopProxy(AdvisedSupport support) {
        super(support);
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(getClass().getClassLoader(), support.getTargetSource().getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable{
        if(support.getMethodMatcher()!=null&&support.getMethodMatcher().matches(method,support.getTargetSource().getTarget().getClass())){
            return support.getMethodInterceptor().invoke(new ReflectiveMethodInvocation(support.getTargetSource().getTarget(), method, args));
        } else {
            return method.invoke(support.getTargetSource().getTarget(), args);
        }
    }
}
