package com.mode.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.mode.springboot.entity.User;
import com.mode.springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public User login(@RequestBody JSONObject params){
        return loginService.login(params);
    }
}
