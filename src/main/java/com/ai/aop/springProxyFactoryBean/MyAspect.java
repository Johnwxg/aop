/**
 * Copyright (C), 2018-2019
 * FileName: MyAspect
 * Author:   WXG
 * Date:     2019/9/18 10:35
 * Description: 切面类
 */
package com.ai.aop.springProxyFactoryBean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Auther: wxg
 * @Date: 2019/9/18 10:35
 * @Description: 切面类
 */
public class MyAspect implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("before");
        //手动执行目标方法
        Object obj = methodInvocation.proceed();
        System.out.println("after");
        //返回目标方法执行的返回值
        return obj;
    }
}
