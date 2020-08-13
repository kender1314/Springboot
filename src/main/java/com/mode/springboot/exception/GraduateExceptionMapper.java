package com.mode.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author hejiang
 * @Version 1.0.0 RELEASE
 * @Date 2020-01-20 9:36
 * @Description:
 */
@ControllerAdvice
public class GraduateExceptionMapper {

    /**
     * HttpStatus = 500
     *
     * @param ex Exception
     * @return code and message
     */
    @ExceptionHandler(value = {ExecutionException.class})
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Map<String, Object> redirectExceptionHandler(Exception ex) {
        Map<String, Object> map = new HashMap<>(16);
        ExecutionException exception = (ExecutionException) ex;
        map.put("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
        map.put("msg", exception.getErrMsg());
        return map;
    }


}
