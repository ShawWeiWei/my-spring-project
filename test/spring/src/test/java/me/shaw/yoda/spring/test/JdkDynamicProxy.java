package me.shaw.yoda.spring.test;

import me.shaw.yoda.spring.aop.AdvisedSupport;
import me.shaw.yoda.spring.aop.Cglib2AopProxy;
import me.shaw.yoda.spring.aop.JdkDynamicAopProxy;
import me.shaw.yoda.spring.aop.TargetSource;
import org.junit.Test;

/**
 * Created by yes on 5/8/16.
 */
public class JdkDynamicProxy {
    @Test
    public void testJdkDynamic() {
        HelloWorldService helloWorldService = new HelloWorldServiceImpl();
        TargetSource targetSource = new TargetSource(helloWorldService,HelloWorldServiceImpl.class,new Class<?>[]{HelloWorldService.class});

        AdvisedSupport support = new AdvisedSupport();
        support.setTargetSource(targetSource);
        SimpleMethodInceptor methodInceptor = new SimpleMethodInceptor();
        support.setMethodInterceptor(methodInceptor);
        support.setMethodMatcher(new TrueMethodMatcher());
        JdkDynamicAopProxy jdkDynamicProxy = new JdkDynamicAopProxy(support);

        HelloWorldService helloWorldServiceProxy = (HelloWorldService)jdkDynamicProxy.getProxy();

        helloWorldServiceProxy.helloWorld();

    }

    @Test
    public void testCglibDynamic() {
        HelloWorldService helloWorldService = new HelloWorldServiceImpl();
        TargetSource targetSource = new TargetSource(helloWorldService,HelloWorldServiceImpl.class,new Class<?>[]{HelloWorldService.class});

        AdvisedSupport support = new AdvisedSupport();
        support.setTargetSource(targetSource);
        SimpleMethodInceptor methodInceptor = new SimpleMethodInceptor();
        support.setMethodInterceptor(methodInceptor);
        support.setMethodMatcher(new TrueMethodMatcher());
        Cglib2AopProxy jdkDynamicProxy = new Cglib2AopProxy(support);

        HelloWorldService helloWorldServiceProxy = (HelloWorldService)jdkDynamicProxy.getProxy();

        helloWorldServiceProxy.helloWorld();

    }
}
