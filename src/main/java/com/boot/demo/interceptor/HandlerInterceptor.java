package com.boot.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: wy
 * @Date: 2021/4/28 20:12
 * @Description:
 */
public interface HandlerInterceptor {

    /**
     * 实现handler的前置处理逻辑，当返回为true时，继续后续handler的执行
     * @param request request
     * @param response response
     * @param handler handler
     * @return 如果是false，则不会继续向下执行
     * @throws Exception exception
     */
    default boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        return true;
    }

    /**
     * 实现handler的后置处理逻辑， 例如在视图 View 在渲染之前，做一些处理
     * @param request request
     * @param response response
     * @param handler handler
     * @param modelAndView 视图渲染
     * @throws Exception exception
     */
    default void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                            @Nullable ModelAndView modelAndView) throws Exception {
    }

    /**
     * 整个handler执行完成后，并且拦截器链都执行晚前置和后置的拦截逻辑后，实现请求完成后的处理逻辑
     * 例如: 释放资源，清理认证拦截器产生的threadLocal线程变量，避免污染下一个使用到该线程的骑牛
     * 或者记录error日志，不过现在用全局异常处理，这么做的少
     * @param request request
     * @param response response
     * @param handler handler
     * @param ex ex
     * @throws Exception exception
     */
    default void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                 @Nullable Exception ex) throws Exception {
    }

}
