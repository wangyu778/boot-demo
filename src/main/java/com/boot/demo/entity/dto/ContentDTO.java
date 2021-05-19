package com.boot.demo.entity.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Author: wy
 * @Date: 2021/5/17 19:31
 * @Description:
 */
@Data
public class ContentDTO {

    @ExcelProperty(value = "发布时间", index = 0)
    private String publishDate;

    @ExcelProperty(value = "账号Id", index = 1)
    private String accountId;

    @ExcelProperty(value = "经度", index = 2)
    private String lon;

    @ExcelProperty(value = "纬度", index = 3)
    private String lat;

    @ExcelProperty(value = "区", index = 4)
    private String area;

}
