package me.shaw.yoda.spring.aop;

/**
 * Created by yes on 5/8/16.
 */
public abstract class AbstractAopProxy implements AopProxy {
    protected AdvisedSupport support;

    public AbstractAopProxy(AdvisedSupport support) {
        this.support = support;
    }
}
