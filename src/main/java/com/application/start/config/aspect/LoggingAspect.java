package com.application.start.config.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.logging.Logger;


@Aspect
@Configuration
@EnableAspectJAutoProxy
public class LoggingAspect {
    private Logger appLogs=Logger.getLogger(getClass().getName());
    @Pointcut(value = "execution(* com.application.start.dao.*.*(..))")
    public void pointCutForDAO(){}
    @Before(value = "pointCutForDAO()")
    public void anyMethodExecution(JoinPoint joinPoint){
        MethodSignature methodSignature= (MethodSignature) joinPoint.getSignature();
        appLogs.info("Executing method: "+methodSignature);
        Object[] objects=joinPoint.getArgs();
        for (Object object:objects){
            appLogs.info("Method Args: "+object);
        }
    }
    @After(value = "pointCutForDAO()")
    public void afterDAOMethod(){
        appLogs.info("completed executing the method");
    }
    @Pointcut(value = "execution(* com.application.start.dao.UserDAO.getUser(..))")
    public void getUserPointCut(){}
//    @AfterReturning(pointcut = "getUserPointCut()",returning = "idUser")
//    public void getUserAfterReturning(JoinPoint joinPoint, IdUser idUser){
//        System.out.println("After returning access: "+ idUser.toString());
//    }
//    @AfterThrowing(pointcut = "getUserPointCut()",throwing = "theExep")
//    public void getUserAfterThrowing(JoinPoint joinPoint,Throwable theExep){
//        System.out.println("The exception is: "+theExep);
//    }

    @Around("getUserPointCut()")
    public Object aroundAdvicePractice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        Object result=null;
        try{
            long start=System.currentTimeMillis();
            result=proceedingJoinPoint.proceed();
            long end=System.currentTimeMillis();
            appLogs.info("Total execution time: "+(end-start)+" milliseconds");
        }catch (Exception exp){
            appLogs.info("Exception Occured:"+exp);
            throw exp;
        }
        return result;
    }
}
