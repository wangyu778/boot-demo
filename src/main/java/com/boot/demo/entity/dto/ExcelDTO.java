package com.boot.demo.entity.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;

/**
 * @Author: wy
 * @Date: 2021/5/17 16:29
 * @Description:
 */
@Data
public class ExcelDTO {

    @ExcelProperty(value = "日期", index = 0)
    private String date;

    @ExcelProperty(value = "中西区", index = 1)
    private Integer loc1;

    @ExcelProperty(value = "九龙城区", index = 2)
    private Integer loc2;

    @ExcelProperty(value = "元朗区", index = 3)
    private Integer loc3;

    @ExcelProperty(value = "屯门区", index = 4)
    private Integer loc4;

    @ExcelProperty(value = "沙田区", index = 5)
    private Integer loc5;

    @ExcelProperty(value = "油尖旺区", index = 6)
    private Integer loc6;

    @ExcelProperty(value = "湾仔区", index = 7)
    private Integer loc7;

    @ExcelProperty(value = "离岛区", index = 8)
    private Integer loc8;

    @ExcelProperty(value = "西贡区", index = 9)
    private Integer loc9;

    @ExcelProperty(value = "观塘区", index = 10)
    private Integer loc10;

    @ExcelProperty(value = "黄大仙区", index = 11)
    private Integer loc11;

    @ExcelProperty(value = " ", index = 12)
    private Integer loc12;

}
