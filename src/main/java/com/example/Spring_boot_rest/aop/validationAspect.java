package com.example.Spring_boot_rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class validationAspect {
    private  static final Logger LOGGER= LoggerFactory.getLogger(validationAspect.class);

    @Around("execution(* com.example.Spring_boot_rest.service.JobService.getJob(..)) && args(postid)/7")
    public Object validateAndUpdate(ProceedingJoinPoint jp ,int postId) throws Throwable {

        if(postId<0){
            LOGGER.info("Psot is negative ,updating it");
            postId=-postId;
            LOGGER.info("new Value "+postId);
        }
          Object obj=jp.proceed(new Object[]{postId});
        return obj;
    }
}
