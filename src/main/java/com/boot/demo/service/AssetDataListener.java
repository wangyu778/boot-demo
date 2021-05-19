package com.boot.demo.service;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.boot.demo.entity.dto.ContentDTO;
import com.boot.demo.entity.dto.ExcelDTO;
import com.boot.demo.util.SmartHttpUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wy
 * @Date: 2021/5/17 19:40
 * @Description:
 */
@Slf4j
@Component
public class AssetDataListener extends AnalysisEventListener<ContentDTO> {

    List<ContentDTO> list = new ArrayList<ContentDTO>(10);

    public List<ContentDTO> getList() {
        return list;
    }

    @SneakyThrows
    @Override
    public void invoke(ContentDTO data, AnalysisContext context) {
        log.info("[读取数据] - 成功{}",data);
        list.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("[读取数据所有] - 完成");
    }

}
