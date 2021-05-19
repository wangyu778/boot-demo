package com.boot.demo.interceptor;

import com.alibaba.fastjson.JSON;
import com.boot.demo.common.CommonResult;
import com.boot.demo.entity.dto.SystemAccessLogCreateDTO;
import com.boot.demo.util.CommonWebUtil;
import com.boot.demo.util.HttpUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 访问日志拦截器
 * @author Bl
 */
public class AccessLogInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${spring.application.name}")
    private String applicationName;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 记录当前时间
        CommonWebUtil.setAccessStartTime(request, new Date());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        SystemAccessLogCreateDTO accessLog = new SystemAccessLogCreateDTO();
        try {
            // 初始化 accessLog
            initAccessLog(accessLog, request);
            // 执行插入 accessLog
            addAccessLog(accessLog);
            // TODO 提升：暂时不考虑 ELK 的方案。而是基于 MySQL 存储。如果访问日志比较多，需要定期归档。
        } catch (Throwable th) {
            logger.error("[afterCompletion][插入访问日志({}) 发生异常({})", JSON.toJSONString(accessLog), ExceptionUtils.getRootCauseMessage(th));
        }
    }

    private void initAccessLog(SystemAccessLogCreateDTO accessLog, HttpServletRequest request) {
        // 设置账号编号 假设
        accessLog.setUserId(1);
        //假设type 为1
        accessLog.setUserType(1);
        // 设置访问结果
        CommonResult<Object> result = CommonResult.success("假设成功");
        if (result != null) {
            accessLog.setErrorCode(result.getCode()).setErrorMessage(result.getMessage());
        } else {
            // 在访问非 onemall 系统提供的 API 时，会存在没有 CommonResult 的情况。例如说，Swagger 提供的接口
            accessLog.setErrorCode(0).setErrorMessage("");
        }
        // 设置其它字段
        accessLog.setApplicationName(applicationName)
                // TODO 提升：如果想要优化，可以使用 Swagger 的 @ApiOperation 注解。
                .setUri(request.getRequestURI())
                .setQueryString(HttpUtil.buildQueryString(request))
                .setMethod(request.getMethod())
                .setUserAgent(HttpUtil.getUserAgent(request))
                .setIp(HttpUtil.getIp(request))
                .setResponseTime((int) (System.currentTimeMillis() - accessLog.getStartTime().getTime()));
    }

    /**
     * 异步入库
     * @param accessLog 日志
     */
    @Async
    public void addAccessLog(SystemAccessLogCreateDTO accessLog) {
        try {
            System.out.println("入库");
        } catch (Throwable th) {
            logger.error("[addAccessLog][插入访问日志({}) 发生异常({})", JSON.toJSONString(accessLog), ExceptionUtils.getRootCauseMessage(th));
        }
    }

}
