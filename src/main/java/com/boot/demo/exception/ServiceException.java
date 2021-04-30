package com.boot.demo.exception;

import com.boot.demo.common.ServiceExceptionEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: wy
 * @Date: 2021/4/28 19:34
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
public final class ServiceException extends RuntimeException {

    /**
     * 错误码
     */
    private final Integer code;

    public ServiceException(ServiceExceptionEnum serviceExceptionEnum) {
        // 使用父类的 message 字段
        super(serviceExceptionEnum.getMessage());
        // 设置错误码
        this.code = serviceExceptionEnum.getCode();
    }

}
