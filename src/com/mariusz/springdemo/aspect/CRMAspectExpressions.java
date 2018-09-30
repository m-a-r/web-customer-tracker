package com.mariusz.springdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CRMAspectExpressions {

    @Pointcut("execution(* com.mariusz.springdemo.controller.*.*(..))")
    public void forControllerPackage() {}

    @Pointcut("execution(* com.mariusz.springdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* com.mariusz.springdemo.service.*.*(..))")
    public void forServicePackage() {}

    @Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
    public void forWorkFlow() {}
}
