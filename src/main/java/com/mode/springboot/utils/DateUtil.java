package com.mode.springboot.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
public class DateUtil {
    private static final String YYYY_MM_DD = "yyyy-MM-dd";
    private static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    private static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static Date parse(String date) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        return sdf.parse(date);
    }

    public static String format1(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        return sdf.format(date);
    }

    public static String format2(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
        return sdf.format(date);
    }

    public static String format3(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDDHHMMSS);
        return sdf.format(date);
    }
}
