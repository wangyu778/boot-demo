package com.boot.demo.service;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.boot.demo.entity.dto.ContentDTO;
import com.boot.demo.entity.dto.CountExcelDTO;
import com.boot.demo.entity.dto.ExcelDTO;
import com.boot.demo.util.SmartHttpUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wy
 * @Date: 2021/5/17 19:40
 * @Description:
 */
@Slf4j
@Component
public class CountAssetDataListener extends AnalysisEventListener<ContentDTO> {

    List<CountExcelDTO> contentList = new ArrayList<CountExcelDTO>(10);

    Map<String, Object> accountIdMap = new HashMap<>(16);

    @SneakyThrows
    @Override
    public void invoke(ContentDTO data, AnalysisContext context) {
        if(ObjectUtils.isEmpty(accountIdMap.get(data.getAccountId()))){
            accountIdMap.put(data.getAccountId(), true);
        }
        setAreaCount(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        EasyExcel.write("D://twitter统计结果.xlsx", CountExcelDTO.class).sheet("sheet1").doWrite(contentList);
    }

    public CountExcelDTO getCountExcelDTO(ContentDTO data){
        for (CountExcelDTO countExcelDTO : contentList) {
            if(data.getAccountId().equals(countExcelDTO.getAccountId())){
                return countExcelDTO;
            }
        }
        CountExcelDTO countExcelDTO = new CountExcelDTO();
        countExcelDTO.setAccountId(data.getAccountId());
        contentList.add(countExcelDTO);
        return countExcelDTO;
    }

    public void setAreaCount(ContentDTO data){
        CountExcelDTO countExcelDTO = getCountExcelDTO(data);
        String area = data.getArea();
        if(!ObjectUtils.isEmpty(area)){
            switch (area){
                case "中西区": countExcelDTO.setLoc1(1+countExcelDTO.getLoc1());break;
                case "东区": countExcelDTO.setLoc2(1+countExcelDTO.getLoc2());break;
                case "南区": countExcelDTO.setLoc3(1+countExcelDTO.getLoc3());break;
                case "湾仔区": countExcelDTO.setLoc4(1+countExcelDTO.getLoc4());break;
                case "九龙城区": countExcelDTO.setLoc5(1+countExcelDTO.getLoc5());break;
                case "观塘区": countExcelDTO.setLoc6(1+countExcelDTO.getLoc6());break;
                case "深水埗区": countExcelDTO.setLoc7(1+countExcelDTO.getLoc7());break;
                case "黄大仙区": countExcelDTO.setLoc8(1+countExcelDTO.getLoc8());break;
                case "油尖旺区": countExcelDTO.setLoc9(1+countExcelDTO.getLoc9());break;
                case "离岛区": countExcelDTO.setLoc10(1+countExcelDTO.getLoc10());break;
                case "葵青区": countExcelDTO.setLoc11(1+countExcelDTO.getLoc11());break;
                case "北区": countExcelDTO.setLoc12(1+countExcelDTO.getLoc12());break;
                case "西贡区": countExcelDTO.setLoc13(1+countExcelDTO.getLoc13());break;
                case "沙田区": countExcelDTO.setLoc14(1+countExcelDTO.getLoc14());break;
                case "大埔区": countExcelDTO.setLoc15(1+countExcelDTO.getLoc15());break;
                case "荃湾区": countExcelDTO.setLoc16(1+countExcelDTO.getLoc16());break;
                case "屯门区": countExcelDTO.setLoc16(1+countExcelDTO.getLoc17());break;
                case "元朗区": countExcelDTO.setLoc16(1+countExcelDTO.getLoc18());break;
                default:break;
            }
        }

    }

    public List<CountExcelDTO> getContentList() {
        return contentList;
    }

    public void setContentList(List<CountExcelDTO> contentList) {
        this.contentList = contentList;
    }

    public Map<String, Object> getAccountIdMap() {
        return accountIdMap;
    }

    public void setAccountIdMap(Map<String, Object> accountIdMap) {
        this.accountIdMap = accountIdMap;
    }
}
