package com.iambstha.aop.annotate;

import com.iambstha.aop.entity.Activity;
import com.iambstha.aop.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Aspect
@Component
@RequiredArgsConstructor
public class LogActivityAspect {

    @Autowired
    private final ActivityService activityService;

    @Pointcut("@annotation(com.iambstha.aop.annotate.LogActivity)")
    private void LogActivity(){
        System.out.println("Test 1");
    }

    @Before("LogActivity() && @annotation(logActivity)")
    public void doBefore(JoinPoint joinPoint, LogActivity logActivity) throws Throwable{
        Object[] args = joinPoint.getArgs();
        Activity activity = new Activity();
        activity.setRemark(logActivity.remark());
        activity.setCreatedTs(new Timestamp(System.currentTimeMillis()));
        activity.setCreatedBy(null);
        activityService.process(activity,args);
    }

    @After("LogActivity()")
    public void doAfter(JoinPoint joinPoint){
        System.out.println("Test 3");
    }

    @AfterReturning(pointcut="LogActivity()", returning="result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        System.out.println("Test 4");
    }
}
