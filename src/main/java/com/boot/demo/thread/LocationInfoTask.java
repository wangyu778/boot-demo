package com.boot.demo.thread;

import com.alibaba.excel.EasyExcel;
import com.boot.demo.entity.dto.ContentDTO;
import com.boot.demo.util.SmartHttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @Author: wy
 * @Date: 2021/5/18 15:52
 * @Description: 根据定位信息获取该经纬度属于那个香港18区的位置
 */
@Slf4j
public class LocationInfoTask implements Callable<List<ContentDTO>> {

    private List<ContentDTO> contentDTOList;

    private int index;

    private int size;

    public LocationInfoTask(List<ContentDTO> contentDTOList, int index, int size){
        this.contentDTOList = contentDTOList;
        this.index = index;
        this.size = size;
    }

    @Override
    public List<ContentDTO> call() throws Exception {
        int i = 1;
        List<ContentDTO> contentDTOS = contentDTOList.subList((index - 1) * size, index * size);
        for (ContentDTO contentDTO : contentDTOS) {
            String area = SmartHttpUtil.sendGet("https://gmaps.bluelightwit.com/maps/api/geocode/json?latlng=" + contentDTO.getLat() + "," + contentDTO.getLon() + "&language=CN&key=AIzaSyAHpYY-T-DeTdrEyBqQtfa6sR8YMfCKo4k", null, null);
            if(StringUtils.isNotBlank(area)){
                contentDTO.setArea(getArea(area));
            }
            log.info("[请求香港18区位置, 编号{}] - {}/{}}", index, i++, size);
        }
        return contentDTOS;
    }

    public String getArea(String area){
        if(area.toLowerCase().contains("Central and West District".toLowerCase()) || area.contains("Central And Western District")) {return "中西区";}
        if(area.toLowerCase().contains("Eastern District".toLowerCase())  || area.contains("东区")) {return "东区";}
        if(area.toLowerCase().contains("Southern District".toLowerCase()) || area.contains("南区")) {return "南区";}
        if(area.toLowerCase().contains("Wan Chai District".toLowerCase()) || area.contains("Wan Chai")) {return "湾仔区";}
        if(area.toLowerCase().contains("Kowloon City District".toLowerCase()) || area.contains("Kowloon City")) {return "九龙城区";}
        if(area.toLowerCase().contains("Kwun Tong District".toLowerCase()) || area.contains("Kwun Tong")) {return "观塘区";}
        if(area.toLowerCase().contains("Sham Shui Po District".toLowerCase()) || area.contains("Sham Shui Po")) {return "深水埗区";}
        if(area.toLowerCase().contains("Wong Tai Sin District".toLowerCase()) || area.contains("Wong Tai Sin")) {return "黄大仙区";}
        if(area.toLowerCase().contains("Yau Tsim Mong District".toLowerCase()) || area.contains("Yau Tsim Mong")) {return "油尖旺区";}
        if(area.toLowerCase().contains("Island District".toLowerCase()) || area.contains("Island")) {return "离岛区";}
        if(area.toLowerCase().contains("Kwai Tsing District".toLowerCase()) || area.contains("Kwai Tsing")) {return "葵青区";}
        if(area.toLowerCase().contains("North District".toLowerCase()) || area.contains("北区")) {return "北区";}
        if(area.toLowerCase().contains("Sai Kung District".toLowerCase()) || area.contains("Sai Kung")) {return "西贡区";}
        if(area.toLowerCase().contains("Sha Tin District".toLowerCase()) || area.contains("Sha Tin")) {return "沙田区";}
        if(area.toLowerCase().contains("Tai Po District".toLowerCase()) || area.contains("Tai Po")) {return "大埔区";}
        if(area.toLowerCase().contains("Tsuen Wan District".toLowerCase()) || area.contains("Tsuen Wan")) {return "荃湾区";}
        if(area.toLowerCase().contains("Tuen Mun District".toLowerCase()) || area.contains("Tuen Mun")) {return "屯门区";}
        if(area.toLowerCase().contains("Yuen Long District".toLowerCase()) || area.contains("Yuen Long")) {return "元朗区";}
        return "";
    }

}
