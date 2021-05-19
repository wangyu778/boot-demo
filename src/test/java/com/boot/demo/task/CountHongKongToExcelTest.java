package com.boot.demo.task;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteWorkbook;
import com.boot.demo.entity.dto.ExcelDTO;
import com.boot.demo.mapper.UserMapper;
import com.boot.demo.util.DateFunction;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;


import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;


/**
 * @Author: wy
 * @Date: 2021/5/17 15:31
 * @Description:
 */
@SpringBootTest
@Slf4j
public class CountHongKongToExcelTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void easExcelTest() throws IllegalAccessException {
        String fileName = "D://" + System.currentTimeMillis() + ".xlsx";
        EasyExcel.write(fileName, ExcelDTO.class).sheet("sheet1").doWrite(getContent());
    }

    public List<ExcelDTO> getContent() throws IllegalAccessException {
        String[] titleRow = {"日期", "中西区", "九龙城区", "元朗区", "屯门区", "沙田区", "油尖旺区", "湾仔区", "离岛区",
                "西贡区", "观塘区", "黄大仙区", ""};
        List<ExcelDTO> contentList = new ArrayList<>();
        long startDate = 1577808000000L;
        long endDate = 1609430400000L;
        while (startDate < endDate){
            log.info("[按天统计各区数据] - 统计时间 {}" ,DateFunction.formatDate2Sting(new Date(startDate)));
            ExcelDTO excelDTO = new ExcelDTO();
            excelDTO.setDate(DateFunction.formatDate3Sting(new Date(startDate)));
            Class clazz = excelDTO.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (int i = 1; i < fields.length; i++) {
                Field field = fields[i];
                field.setAccessible(true);
                String sql = "area = '" + ("".equals(titleRow[i]) ? " " : titleRow[i])  + "' and publishDate >= '" + DateFunction.formatDate2Sting(new Date(startDate)) +
                        "' and publishDate < '" + DateFunction.formatDate2Sting(new Date(startDate+86400000L)) + "'";
                int count = userMapper.exportHongKong(sql);
                field.set(excelDTO , count);
            }
            contentList.add(excelDTO);
            startDate = startDate + 86400000L;
        }
        return contentList;
    }


}
