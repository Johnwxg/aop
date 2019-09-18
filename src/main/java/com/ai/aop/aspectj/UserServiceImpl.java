/**
 * Copyright (C), 2018-2019
 * FileName: UserServiceImpl
 * Author:   WXG
 * Date:     2019/9/18 14:14
 * Description: 目标类实现
 */
package com.ai.aop.aspectj;

import java.io.IOException;

/**
 * @Auther: wxg
 * @Date: 2019/9/18 14:14
 * @Description: 目标类实现
 */
public class UserServiceImpl implements UserService {

    @Override
    public void addUser() {
        System.out.println("新增");
    }

    @Override
    public void updateUser() {
        int i = 0/0;
        System.out.println("更新");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除");

    }
}
