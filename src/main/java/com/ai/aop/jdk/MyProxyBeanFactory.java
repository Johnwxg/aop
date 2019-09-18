/**
 * Copyright (C), 2018-2019
 * FileName: MyProxyBeanFactory
 * Author:   WXG
 * Date:     2019/9/17 17:06
 * Description: 静态代理对象工厂
 */
package com.ai.aop.jdk;

import com.ai.aop.jdk.impl.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import  java.lang.reflect.Proxy;

/**
 * @Auther: wxg
 * @Date: 2019/9/17 17:06
 * @Description: 静态代理对象工厂
 */
public class MyProxyBeanFactory {
    public static UserService createService(){
        final UserService userService = new UserServiceImpl();
        final MyAspect myAspect = new MyAspect();

        //通过userService获得代理对象
        UserService proxyService = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),userService
                .getClass().getInterfaces(), new InvocationHandler(){
            //Proxy代理对象, method代理类的目标方法, args目标方法参数
            public Object invoke(Object proxy, Method method, Object[] args)throws Throwable{
                //织入横向代码
                myAspect.before();
                //执行代理类的方法
                Object obj = method.invoke(userService,args);

                myAspect.after();
                //返回执行代理方法的返回值
                return obj;
            }
        });
        return  proxyService;
    }
}
