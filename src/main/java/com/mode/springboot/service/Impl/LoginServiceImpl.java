package com.mode.springboot.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.mode.springboot.dao.UserDao;
import com.mode.springboot.entity.User;
import com.mode.springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserDao userDao;

    @Override
    public User login(Map<String, Object> params) {
        Object name = params.get("username");
        Object password = params.get("password");
        if (name != null&& password != null) {
            return userDao.login(name.toString(), password.toString());
        }
        return null;
    }
}
