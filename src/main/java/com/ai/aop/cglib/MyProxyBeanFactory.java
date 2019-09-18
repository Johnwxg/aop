/**
 * Copyright (C), 2018-2019
 * FileName: MyProxyBeanFactory
 * Author:   WXG
 * Date:     2019/9/17 18:03
 * Description: CGLIB字节码增强动态代理
 */
package com.ai.aop.cglib;

import com.ai.aop.jdk.MyAspect;
import com.ai.aop.jdk.UserService;
import com.ai.aop.jdk.impl.UserServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Auther: wxg
 * @Date: 2019/9/17 18:03
 * @Description: CGLIB字节码增强动态代理
 *
 * cglib动态生成一个代理类的子类, 子类重写代理类的所有不是final的方法,
 * 在子类中采用方法拦截技术拦截所有父类的方法调用, 顺势织入切面逻辑, 实现AOP, 它比JDK动态代理要快
 * CGLIB动态代理使用Enhancer基于继承的方式，底层采用ASM字节码生成框架，使用字节码技术生成代理类，比使用Java反射效率要高。
 */
public class MyProxyBeanFactory {
    public static UserService createService(){
        final UserService userService = new UserServiceImpl();
        final MyAspect myAspect = new MyAspect();

        //从spring3.2以后，spring框架本身不在需要cglib这个jar包了，因为cjlib.jar已经被spring项目的jar包集成进去。
        /*Enhancer是一个非常重要的类，它允许为非接口类型创建一个JAVA代理，
            Enhancer动态的创建给定类的子类并且拦截代理类的所有的方法，
            和JDK动态代理不一样的是不管是接口还是类它都能正常工作。*/
        //创建代理
        Enhancer enhancer = new Enhancer();
        //确定父类
        enhancer.setSuperclass(userService.getClass());
        //向代理对象的方法中织入切面代码,设置代理方法，需要用接口MethodInterceptor的实现类，重写intercept方法
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws
                    Throwable {
                myAspect.before();
                Object obj = methodProxy.invokeSuper(proxy,args); //执行代理类（子类）的父类方法（父类就是目标类）
                myAspect.after();
                return obj;
            }
        });
        //使用enhancer创建代理对象
        return (UserService) enhancer.create();
    }
}
