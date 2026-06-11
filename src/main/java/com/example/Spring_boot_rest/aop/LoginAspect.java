package com.example.Spring_boot_rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginAspect {

    private  static final Logger LOGGER= LoggerFactory.getLogger(LoginAspect.class);

//     return type,class name,method name,arguments
//    @Before("execution(* com.example.Spring_boot_rest.service.JobService.*(..))")

    @Before("execution(* com.example.Spring_boot_rest.service.JobService.getJob(..))  || execution(* com.example.Spring_boot_rest.service.JobService.updateJob(..)) ")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method called" + jp.getSignature().getName());
    }
    @After("execution(* com.example.Spring_boot_rest.service.JobService.getJob(..))  || execution(* com.example.Spring_boot_rest.service.JobService.updateJob(..)) ")
    public void logMethodCallExecuted(JoinPoint jp){
        LOGGER.info("Method Executed " + jp.getSignature().getName());
    }
}
