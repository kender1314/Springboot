package com.mode.springboot.dao;

import com.github.pagehelper.PageInfo;
import com.mode.springboot.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
@Repository
public interface UserDao {

    public PageInfo<User> findAll();

    public User login(@Param("userName")String name, @Param("password")String password);
}
