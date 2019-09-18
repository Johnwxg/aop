/**
 * Copyright (C), 2018-2019
 * FileName: UserServiceImpl
 * Author:   WXG
 * Date:     2019/9/17 17:05
 * Description:
 */
package com.ai.aop.jdk.impl;

import com.ai.aop.jdk.UserService;

/**
 * @Auther: wxg
 * @Date: 2019/9/17 17:05
 * @Description:
 */
public class UserServiceImpl implements UserService {

    public void addUser() {
        System.out.println("add User");
    }
    public void updateUser() {
        System.out.println("update User");
    }
    public void deleteUser() {
        System.out.println("delete User");
    }
}
