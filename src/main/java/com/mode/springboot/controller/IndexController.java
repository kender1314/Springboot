package com.mode.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.mode.springboot.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "/views/index";
    }

    /**
     * 返回方式一
     *
     * @return ModelAndView
     */
    @RequestMapping(value = "/index1", method = RequestMethod.GET)
    public ModelAndView index1() {
        Map<String, String> map = new HashMap<>(10);
        map.put("user", "jiang.he");
        return new ModelAndView("/views/index", map);
    }

    /**
     * 返回方式二
     * ResponseEntity
     *
     * @return ResponseEntity
     */
    @RequestMapping(value = "/index2", method = RequestMethod.GET)
    public ResponseEntity<?> index2() {
        JSONObject jsonObject = getJsonObject();
        return new ResponseEntity<>(jsonObject.get("data"), HttpStatus.valueOf(jsonObject.getIntValue("code")));
    }

    /**
     * 返回方式三
     * Map<String, Object>
     *
     * @return
     */
    @RequestMapping(value = "/index3", method = RequestMethod.GET)
    public Map<String, Object> index3() {
        Map<String, Object> map = new HashMap<>();
        JSONObject jsonObject = getJsonObject();
        map.put("data", jsonObject.get("data"));
        map.put("code", jsonObject.get("code"));
        return map;
    }

    private JSONObject getJsonObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", "这是一个data测试！");
        jsonObject.put("code", "这是一个code测试！");
        return jsonObject;
    }


}
