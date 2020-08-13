package com.mode.springboot.autoconfigure.configuration;

import com.mode.springboot.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
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
@Slf4j
public class UserInterceptor implements HandlerInterceptor {

    /**
     * ��������֮ǰ���е��ã�Controller��������֮ǰ��
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            return true;
        }
        response.sendRedirect(request.getContextPath() + "/toLogin");
        return false;
    }

    /**
     * ������֮����е��ã���������ͼ����Ⱦ֮ǰ��Controller��������֮��
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
    }

    /**
     * �������������֮�󱻵��ã�Ҳ������DispatcherServlet ��Ⱦ�˶�Ӧ����ͼ֮��ִ�У���Ҫ�����ڽ�����Դ��������
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
    }
}
