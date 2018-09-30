package com.mariusz.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Before("com.mariusz.springdemo.aspect.CRMAspectExpressions.forWorkFlow()")
    private void beforeWorkFlow(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().toShortString();
        myLogger.info("=====>> in @Before: calling method: " + methodName);

        Object[] args = joinPoint.getArgs();
        for (Object tempArg : args) {
            myLogger.info("=====>> ARGUMENT: " + tempArg);
        }
    }

    @AfterReturning(
            pointcut = "com.mariusz.springdemo.aspect.CRMAspectExpressions.forWorkFlow()",
            returning = "result"
    )
    private void afterReturningWorkFlow(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().toShortString();
        myLogger.info("=====>> in @AfterReturning: from method: " + methodName);// + " -> Returning: " + result);

        myLogger.info("=====>> result: " + result);
    }
}
