/**
 * Copyright (C), 2018-2019
 * FileName: MyAspect
 * Author:   WXG
 * Date:     2019/9/18 14:15
 * Description: 切面类
 */
package com.ai.aop.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Auther: wxg
 * @Date: 2019/9/18 14:15
 * @Description: 切面类
 */
public class MyAspect {

      //  测试前置通知与后置通知
//    public void myBefore(JoinPoint jPoint){
//        System.out.println("前置通知"+jPoint.getSignature().getName());
//    }
//
//    public void myAfterReturning(JoinPoint jPoint, Object ret){
//        System.out.println("后置通知"+jPoint.getSignature().getName()+"--"+ret);
//    }

    public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable{
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

    public void myAfterThrowing(JoinPoint joinPoint, Throwable e){
        System.out.println("异常通知:"+e.getMessage());
    }

    public void myAfter(JoinPoint joinPoint){
        System.out.println("最终通知");
    }


}
