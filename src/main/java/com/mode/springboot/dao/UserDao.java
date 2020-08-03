package com.mode.springboot.dao;

import com.github.pagehelper.PageInfo;
import com.mode.springboot.entity.User;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
public interface UserDao {
    public PageInfo<User> findAll();
}
