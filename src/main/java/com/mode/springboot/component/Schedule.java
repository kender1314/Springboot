package com.mode.springboot.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
@Component
public class Schedule {

    //代表每一秒执行一次任务
    @Scheduled(fixedRate=1000)
    public void coinInfo(){
//        ws.sendCoinInfo();
    }
}
