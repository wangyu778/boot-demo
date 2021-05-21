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

    @ExcelProperty(value = "正文内容", index = 1)
    private String nickName;

    @ExcelProperty(value = "地点名", index = 2)
    private String locName;

    @ExcelProperty(value = "账号Id", index = 3)
    private String accountId;

    @ExcelProperty(value = "消息Id", index = 4)
    private String assetId;

    @ExcelProperty(value = "经度", index = 5)
    private String lon;

    @ExcelProperty(value = "纬度", index = 6)
    private String lat;

    @ExcelProperty(value = "区", index = 7)
    private String area;

}
