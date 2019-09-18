/**
 * Copyright (C), 2018-2019
 * FileName: UserService
 * Author:   WXG
 * Date:     2019/9/18 15:23
 * Description: 目标类
 */
package com.ai.aop.aspectj.annotation;

import org.springframework.stereotype.Service;

/**
 * @Auther: wxg
 * @Date: 2019/9/18 15:23
 * @Description: 目标类:
 */
@Service
public class UserServiceImpl implements UserService {
    public void addUser() {
        System.out.println("add User");
    }
    public void updateUser() {
        int i = 0/0;
        System.out.println("update User");
    }
    public void deleteUser() {
        System.out.println("delete User");
    }
}
