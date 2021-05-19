package com.boot.demo.entity.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Author: wy
 * @Date: 2021/5/17 19:31
 * @Description:
 */
@Data
public class CountExcelDTO {

    @ExcelProperty(value = "账号Id", index = 0)
    private String accountId;

    @ExcelProperty(value = "中西区", index = 1)
    private Integer loc1 = 0;

    @ExcelProperty(value = "东区", index = 2)
    private Integer loc2 = 0;

    @ExcelProperty(value = "南区", index = 3)
    private Integer loc3 = 0;

    @ExcelProperty(value = "湾仔区", index = 4)
    private Integer loc4 = 0;

    @ExcelProperty(value = "九龙城区", index = 5)
    private Integer loc5 = 0;

    @ExcelProperty(value = "观塘区", index = 6)
    private Integer loc6 = 0;

    @ExcelProperty(value = "深水埗区", index = 7)
    private Integer loc7 = 0;

    @ExcelProperty(value = "黄大仙区", index = 8)
    private Integer loc8 = 0;

    @ExcelProperty(value = "油尖旺区", index = 9)
    private Integer loc9 = 0;

    @ExcelProperty(value = "离岛区", index = 10)
    private Integer loc10 = 0;

    @ExcelProperty(value = "葵青区", index = 11)
    private Integer loc11 = 0;

    @ExcelProperty(value = "北区", index = 12)
    private Integer loc12 = 0;

    @ExcelProperty(value = "西贡区", index = 13)
    private Integer loc13 = 0;

    @ExcelProperty(value = "沙田区", index = 14)
    private Integer loc14 = 0;

    @ExcelProperty(value = "大埔区", index = 15)
    private Integer loc15 = 0;

    @ExcelProperty(value = "荃湾区", index = 16)
    private Integer loc16 = 0;

    @ExcelProperty(value = "屯门区", index = 17)
    private Integer loc17 = 0;

    @ExcelProperty(value = "元朗区", index = 18)
    private Integer loc18 = 0;


}
