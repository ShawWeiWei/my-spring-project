package me.shaw.yoda.spring.aop;

/**
 * Created by yes on 5/8/16.
 */
public class TargetSource {
    Object target;
    Class<?> targetClass;
    Class<?>[] interfaces;


    public TargetSource(Object target,Class<?> targetClass,  Class<?>[] interfaces) {
        this.target = target;
        this.targetClass = targetClass;
        this.interfaces = interfaces;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public Class<?>[] getInterfaces() {
        return interfaces;
    }

    public Object getTarget() {
        return target;
    }
}
