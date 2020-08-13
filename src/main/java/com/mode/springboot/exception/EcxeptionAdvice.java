package com.mode.springboot.exception;


import com.mode.springboot.common.Result;
import com.mode.springboot.common.ResultUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @Author hejiang
 * @Version 1.0.0 RELEASE
 * @Date 2020/4/2 10:10
 * @Description:
 */
@ControllerAdvice
public class EcxeptionAdvice{
    /**
     * 程序内部错误
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<Object> exception(Exception e) {
        e.printStackTrace();
        return ResultUtils.internalerror();
    }

    /**
     * url不存在
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public Result<Object> handlerNotFoundException(NoHandlerFoundException e) {
        e.printStackTrace();
        return ResultUtils.urlnotexists();
    }

    /**
     * 参数转换错误，归类为参数错误
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public Result methodargumenttypemismatchexception(MethodArgumentTypeMismatchException e){
        e.printStackTrace();
        return ResultUtils.paramerror();
    }

    /**
     * 请求方式错误
     * @param e
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public Result httprequestmethodnotsupportedexception(HttpRequestMethodNotSupportedException e){
        e.printStackTrace();
        return ResultUtils.requestMethodError();
    }

    @ExceptionHandler(UnsatisfiedServletRequestParameterException.class)
    @ResponseBody
    public Result unsatisfiedservletrequestparameterexception(UnsatisfiedServletRequestParameterException e){
        e.printStackTrace();
        return ResultUtils.paramLossError();
    }

    @ExceptionHandler(NotLoginException.class)
    @ResponseBody
    public Result notloginexception(NotLoginException e){
        e.printStackTrace();
        return ResultUtils.unloginerror();
    }
}
