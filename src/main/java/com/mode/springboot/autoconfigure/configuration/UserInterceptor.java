package com.mode.springboot.autoconfigure.configuration;

import com.mode.springboot.autoconfigure.configure.CommonProperties;
import com.mode.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/8/13 22:59
 * @Description:
 */
public class UserInterceptor implements HandlerInterceptor {

    private final CommonProperties commonProperties;

    public UserInterceptor(CommonProperties commonProperties) {
        this.commonProperties = commonProperties;
    }

    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (commonProperties.isInterceptor()) {
            User user = (User) request.getSession().getAttribute("user");
            if (user != null) {
                return true;
            }
            response.sendRedirect(request.getContextPath() + "/toLogin");
            return false;
        }
        return true;
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
    }
}