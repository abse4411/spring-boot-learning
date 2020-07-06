package com.boss.learning.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class WebLog {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.boss.learning.controller.*.*(..))")
    private void pointcut(){}

//    @Before("pointcut()")
//    public void before(JoinPoint joinpoint){
//        String className = joinpoint.getSignature().getDeclaringTypeName();
//        String methodName = joinpoint.getSignature().getName();
//        List<Object> argList= Arrays.asList(joinpoint.getArgs());
//        logger.info("Before executing {}.{}({})",className,methodName,argList);
//    }
//
//    @AfterReturning(value = "pointcut()",returning = "result")
//    public void before(JoinPoint joinpoint,Object result){
//        String className = joinpoint.getSignature().getDeclaringTypeName();
//        String methodName = joinpoint.getSignature().getName();
//        List<Object> argList= Arrays.asList(joinpoint.getArgs());
//        logger.info("Return result:{} after executing {}.{}({})",result,className,methodName,argList);
//    }

    @Around("pointcut()")
    public Object aroud(ProceedingJoinPoint joinpoint) throws Throwable {
        String className = joinpoint.getSignature().getDeclaringTypeName();
        String methodName = joinpoint.getSignature().getName();
        List<Object> argList= Arrays.asList(joinpoint.getArgs());
        logger.info("Before executing {}.{}({})",className,methodName,argList);
        long startTime=System.currentTimeMillis();
        Object result=joinpoint.proceed();
        long duration=System.currentTimeMillis()-startTime;
        logger.info("Return result:{} after executing {}.{}({}) in {}ms",
            result,
            className,
            methodName,
            argList,
            duration);

        return result;
    }
}
