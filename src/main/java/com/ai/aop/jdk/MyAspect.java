/**
 * Copyright (C), 2018-2019
 * FileName: MyAspect
 * Author:   WXG
 * Date:     2019/9/17 17:05
 * Description: 切面, 增强连接点
 */
package com.ai.aop.jdk;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @Auther: wxg
 * @Date: 2019/9/17 17:05
 * @Description: 切面, 增强连接点
 */
public class MyAspect {
    public void before(){
        System.out.println("before");
    }
    public void after(){
        System.out.println("after");
    }


}
