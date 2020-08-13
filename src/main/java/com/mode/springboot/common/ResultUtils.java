package com.mode.springboot.common;

/**
 * @Author hejiang
 * @Version 1.0.0 RELEASE
 * @Date 2020/4/2 10:10
 * @Description:
 */
public class ResultUtils {

    /**
     * 操作成功
     * @param data
     * @return
     */
    public static Result<Object> success(Object data) {
        Result<Object> result = new Result<Object>();
        result.setCode(CommonCode.HAND_SUCCESS.getCode());
        result.setMsg(CommonCode.HAND_SUCCESS.getMessage());
        result.setData(data);

        return result;
    }

    /**
     * 程序错误
     * @return
     */
    public static Result<Object> internalerror() {
        Result<Object> result = new Result<Object>();
        result.setCode(CommonCode.INTERNAL_ERROR.getCode());
        result.setMsg(CommonCode.INTERNAL_ERROR.getMessage());
        return result;
    }

    /**
     *参数错误
     * @return
     */
    public static Result<Object> paramerror() {
        Result<Object> result = new Result<Object>();
        result.setCode(CommonCode.PARAM_ERROR.getCode());
        result.setMsg(CommonCode.PARAM_ERROR.getMessage());
        return result;
    }

    /**
     * url不存在
     * @return
     */
    public static Result<Object> urlnotexists() {
        Result<Object> result = new Result<Object>();
        result.setCode(CommonCode.URL_NOT_EXISTS.getCode());
        result.setMsg(CommonCode.URL_NOT_EXISTS.getMessage());
        return result;
    }

    /**
     * 登录过期
     * @return
     */
    public static Result<Object> unloginerror() {
        Result<Object> result = new Result<Object>();
        result.setCode(CommonCode.UNLOGIN_ERROR.getCode());
        result.setMsg(CommonCode.UNLOGIN_ERROR.getMessage());
        return result;
    }

    /**
     * 权限不足
     * @return
     */
    public static Result<Object> authforbidden() {
        Result<Object> result = new Result<Object>();
        result.setCode(CommonCode.AUTH_FORBIDDEN.getCode());
        result.setMsg(CommonCode.AUTH_FORBIDDEN.getMessage());
        return result;
    }

    /**
     * 服务繁忙
     * @return
     */
    public static Result<Object> serviceerror() {
        Result<Object> result = new Result<Object>();
        result.setCode(CommonCode.SERVICE_ERROR.getCode());
        result.setMsg(CommonCode.SERVICE_ERROR.getMessage());
        return result;
    }

    /**
     * 管理员信息错误
     * @return
     */
    public static Result<Object> managerInfoError() {
        Result<Object> result = new Result<Object>();
        result.setCode(CommonCode.MANAGER_INFO_ERROR.getCode());
        result.setMsg(CommonCode.MANAGER_INFO_ERROR.getMessage());
        return result;
    }

    /**
     * 请求方法错误
     * @return
     */
    public static Result<Object> requestMethodError() {
        Result<Object> result = new Result<Object>();
        result.setCode(CommonCode.REQUEST_METHOD_ERROR.getCode());
        result.setMsg(CommonCode.REQUEST_METHOD_ERROR.getMessage());
        return result;
    }

    /**
     * 参数缺失
     * @return
     */
    public static Result<Object> paramLossError() {
        Result<Object> result = new Result<Object>();
        result.setCode(CommonCode.PARAM_LOSS_ERROR.getCode());
        result.setMsg(CommonCode.PARAM_LOSS_ERROR.getMessage());
        return result;
    }


    /**
     * 登录失败
     * @return
     */
    public static Result<Object> loginFailed() {
        Result<Object> result = new Result<Object>();
        result.setCode(CommonCode.LOGIN_FAILED.getCode());
        result.setMsg(CommonCode.LOGIN_FAILED.getMessage());
        return result;
    }


    /**
     * 用户名已存在
     * @return
     */
    public static Result<Object> usernameExist() {
        Result<Object> result = new Result<Object>();
        result.setCode(CommonCode.USERNAME_EXIST.getCode());
        result.setMsg(CommonCode.USERNAME_EXIST.getMessage());
        return result;
    }



}
