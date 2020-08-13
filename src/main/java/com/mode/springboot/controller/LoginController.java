package com.mode.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.mode.springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam Map<String, Object> params){
        JSONObject res = new JSONObject();
        res.put("data", loginService.login(params));
        return new ModelAndView("/views/index", res);
    }
}
