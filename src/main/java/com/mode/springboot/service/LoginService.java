package com.mode.springboot.service;

import com.alibaba.fastjson.JSONObject;
import com.mode.springboot.entity.User;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
public interface LoginService extends BaseService{
    /**
     * 用户登录
     * @param params 账号密码
     * @return 用户信息
     */
    User login(JSONObject params);
}
