/**
 * Copyright (C), 2018-2019
 * FileName: MyAspect
 * Author:   WXG
 * Date:     2019/9/18 15:21
 * Description: 基于注解的通知类型开发流程
 */
package com.ai.aop.aspectj.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Auther: wxg
 * @Date: 2019/9/18 15:21
 * @Description: 基于注解的通知类型，切面类
 */

//获得切面类Bean
@Component
//声明切面类
@Aspect
public class MyAspect {
    //直接设置切入点, 不使用自定义的公共切入点
//    @Before("execution(* com.f_aop.aspectJFinalAnnotation.UserServiceImpl.*(..))")
//    public void myBefore(JoinPoint jPoint){
//        System.out.println("前置通知"+jPoint.getSignature().getName());
//    }

//    设置切入点, 通过returning获得返回值
//    @AfterReturning(value="myPointCut()", returning="ret)
//    public void myAfterReturning(JoinPoint jPoint, Object ret){
//        System.out.println("后置通知"+jPoint.getSignature().getName()+"--"+ret);
//    }

    @Pointcut("execution(* com.ai.aop.aspectj.annotation.UserServiceImpl.*(..))")
    private Object myPointCut(){
        //配置空方法,用于声明公共切入点
        return null;
    }

    @Around("myPointCut()")
    public Object myAround(ProceedingJoinPoint joinPoint)throws Throwable{
        System.out.println("前置通知");
        //手动执行目标方法
        Object obj = joinPoint.proceed();
        //环绕通知与抛出异常通知的测试结果:
        //前置通知
        //抛出异常通知/ by zero
        //最终通知
        System.out.println("后置通知");
        return obj;
    }

    @AfterThrowing(value = "myPointCut()", throwing = "e")
    public void myAfterThrowing(JoinPoint joinPoint, Throwable e){
        System.out.println("异常通知:"+e.getMessage());
    }

    @After(value = "myPointCut()")
    public void myAfter(JoinPoint joinPoint){
        System.out.println("最终通知");
    }
}
