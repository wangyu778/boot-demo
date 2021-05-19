package com.boot.demo.task;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.boot.demo.entity.dto.ContentDTO;
import com.boot.demo.entity.dto.CountExcelDTO;
import com.boot.demo.service.AssetDataListener;
import com.boot.demo.service.CountAssetDataListener;
import com.boot.demo.thread.LocationInfoTask;
import com.boot.demo.util.Point;
import com.boot.demo.util.SmartHttpUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.*;

/**
 * @Author: wy
 * @Date: 2021/5/17 19:07
 * @Description:
 */
@SpringBootTest
@Slf4j
public class CountExcel {

    @Test
    public void countExcel1() throws Exception {

        AssetDataListener assetDataListener = new AssetDataListener();
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read("D://facebook数据.xlsx", ContentDTO.class, assetDataListener).sheet().doRead();
        List<ContentDTO> contentDTOList = assetDataListener.getList();


        //中西区
        List<String> CentralAndWestDistrictLonList = new ArrayList<>(10);
        List<String> CentralAndWestDistrictLatList = new ArrayList<>(10);
        //东区
        List<String> EasternDistrictLonList = new ArrayList<>(10);
        List<String> EasternDistrictLatList = new ArrayList<>(10);
        //南区
        List<String> SouthernDistrictLonList = new ArrayList<>(10);
        List<String> SouthernDistrictLatList = new ArrayList<>(10);
        //湾仔区
        List<String> WanChaiDistrictLonList = new ArrayList<>(10);
        List<String> WanChaiDistrictLatList = new ArrayList<>(10);
        //九龙城区
        List<String> KowloonCityDistrictLonList = new ArrayList<>(10);
        List<String> KowloonCityDistrictLatList = new ArrayList<>(10);
        //观塘区
        List<String> KwunTongDistrictLonList = new ArrayList<>(10);
        List<String> KwunTongDistrictLatList = new ArrayList<>(10);
        //深水埗区
        List<String> ShamShuiPoDistrictLonList = new ArrayList<>(10);
        List<String> ShamShuiPoDistrictLatList = new ArrayList<>(10);
        //黄大仙区
        List<String> WongTaiSinDistrictLonList = new ArrayList<>(10);
        List<String> WongTaiSinDistrictLatList = new ArrayList<>(10);
        //油尖旺区
        List<String> YauTsimMongDistrictLonList = new ArrayList<>(10);
        List<String> YauTsimMongDistrictLatList = new ArrayList<>(10);
        //离岛区
        List<String> IslandDistrictLonList = new ArrayList<>(10);
        List<String> IslandDistrictLatList = new ArrayList<>(10);
        //葵青区
        List<String> KwaiTsingDistrictLonList = new ArrayList<>(10);
        List<String> KwaiTsingDistrictLatList = new ArrayList<>(10);
        //北区
        List<String> NorthDistrictLonList = new ArrayList<>(10);
        List<String> NorthDistrictLatList = new ArrayList<>(10);
        //西贡区
        List<String> SaiKungDistrictLonList = new ArrayList<>(10);
        List<String> SaiKungDistrictLatList = new ArrayList<>(10);
        //沙田区
        List<String> ShaTinDistrictLonList = new ArrayList<>(10);
        List<String> ShaTinDistrictLatList = new ArrayList<>(10);
        //大埔区
        List<String> TaiPoDistrictLonList = new ArrayList<>(10);
        List<String> TaiPoDistrictLatList = new ArrayList<>(10);
        //荃湾区
        List<String> TsuenWanDistrictLonList = new ArrayList<>(10);
        List<String> TsuenWanDistrictLatList = new ArrayList<>(10);
        //屯门区
        List<String> TuenMunDistrictLonList = new ArrayList<>(10);
        List<String> TuenMunDistrictLatList = new ArrayList<>(10);
        //元朗区
        List<String> YuenLongDistrictLonList = new ArrayList<>(10);
        List<String> YuenLongDistrictLatList = new ArrayList<>(10);

        //遍历行
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("D://边界.txt"))));
        String lineTxt = null;
        int lineIndex = 1;
        while ((lineTxt = br.readLine()) != null) {
            String[] latAndLonStrArr = lineTxt.split(";");
            for (String latAndLonStr : latAndLonStrArr) {
                String[] latAndLonArr = latAndLonStr.split(",");
                switch (lineIndex){
                    case 1:CentralAndWestDistrictLonList.add(latAndLonArr[0]); //中西区
                            CentralAndWestDistrictLatList.add(latAndLonArr[1]);break;
                    case 2:EasternDistrictLonList.add(latAndLonArr[0]); //东区
                            EasternDistrictLatList.add(latAndLonArr[1]);break;
                    case 3:SouthernDistrictLonList.add(latAndLonArr[0]); //南区
                        SouthernDistrictLatList.add(latAndLonArr[1]);break;
                    case 4:WanChaiDistrictLonList.add(latAndLonArr[0]); //湾仔区
                        WanChaiDistrictLatList.add(latAndLonArr[1]);break;
                    case 5:KowloonCityDistrictLonList.add(latAndLonArr[0]); //九龙城区
                        KowloonCityDistrictLatList.add(latAndLonArr[1]);break;
                    case 6:KwunTongDistrictLonList.add(latAndLonArr[0]); //观塘区
                        KwunTongDistrictLatList.add(latAndLonArr[1]);break;
                    case 7:ShamShuiPoDistrictLonList.add(latAndLonArr[0]); //深水埗区
                        ShamShuiPoDistrictLatList.add(latAndLonArr[1]);break;
                    case 8:WongTaiSinDistrictLonList.add(latAndLonArr[0]); //黄大仙区
                        WongTaiSinDistrictLatList.add(latAndLonArr[1]);break;
                    case 9:YauTsimMongDistrictLonList.add(latAndLonArr[0]); //油尖旺区
                        YauTsimMongDistrictLatList.add(latAndLonArr[1]);break;
                    case 10:IslandDistrictLonList.add(latAndLonArr[0]); //离岛区
                        IslandDistrictLatList.add(latAndLonArr[1]);break;
                    case 11:KwaiTsingDistrictLonList.add(latAndLonArr[0]); //葵青区
                        KwaiTsingDistrictLatList.add(latAndLonArr[1]);break;
                    case 12:NorthDistrictLonList.add(latAndLonArr[0]); //北区
                        NorthDistrictLatList.add(latAndLonArr[1]);break;
                    case 13:SaiKungDistrictLonList.add(latAndLonArr[0]); //西贡区
                        SaiKungDistrictLatList.add(latAndLonArr[1]);break;
                    case 14:ShaTinDistrictLonList.add(latAndLonArr[0]); //沙田区
                        ShaTinDistrictLatList.add(latAndLonArr[1]);break;
                    case 15:TaiPoDistrictLonList.add(latAndLonArr[0]); //大埔区
                        TaiPoDistrictLatList.add(latAndLonArr[1]);break;
                    case 16:TsuenWanDistrictLonList.add(latAndLonArr[0]); //荃湾区
                        TsuenWanDistrictLatList.add(latAndLonArr[1]);break;
                    case 17:TuenMunDistrictLonList.add(latAndLonArr[0]); //屯门区
                        TuenMunDistrictLatList.add(latAndLonArr[1]);break;
                    case 18:YuenLongDistrictLonList.add(latAndLonArr[0]); //元朗区
                        YuenLongDistrictLatList.add(latAndLonArr[1]);break;
                    default:break;
                }
            }
            lineIndex++;
        }
        System.out.println(lineIndex);
        Point point = new Point();
        for (ContentDTO contentDTO : contentDTOList) {
            if(point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  CentralAndWestDistrictLonList, CentralAndWestDistrictLatList)){
                contentDTO.setArea("中西区");
            }else if(point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  EasternDistrictLonList, EasternDistrictLatList)){
                contentDTO.setArea("东区");
            }else if(point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  SouthernDistrictLonList, SouthernDistrictLatList)){
                contentDTO.setArea("南区");
            }else if(point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  WanChaiDistrictLonList, WanChaiDistrictLatList)){
                contentDTO.setArea("湾仔区");
            }else if(point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  KowloonCityDistrictLonList, KowloonCityDistrictLatList)){
                contentDTO.setArea("九龙城区");
            }else if(point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  KwunTongDistrictLonList, KwunTongDistrictLatList)){
                contentDTO.setArea("观塘区");
            }else if(point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  ShamShuiPoDistrictLonList, ShamShuiPoDistrictLatList)){
                contentDTO.setArea("深水埗区");
            }else if(point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  WongTaiSinDistrictLonList, WongTaiSinDistrictLatList)){
                contentDTO.setArea("黄大仙区");
            }else if(point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  YauTsimMongDistrictLonList, YauTsimMongDistrictLatList)){
                contentDTO.setArea("油尖旺区");
            }else if(point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  IslandDistrictLonList, IslandDistrictLatList)){
                contentDTO.setArea("离岛区");
            }else if(point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  KwaiTsingDistrictLonList, KwaiTsingDistrictLatList)){
                contentDTO.setArea("葵青区");
            }else if(point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  NorthDistrictLonList, NorthDistrictLatList)){
                contentDTO.setArea("北区");
            }else if(point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  SaiKungDistrictLonList, SaiKungDistrictLatList)){
                contentDTO.setArea("西贡区");
            }else if(point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  ShaTinDistrictLonList, ShaTinDistrictLatList)){
                contentDTO.setArea("沙田区");
            }else if(point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  TaiPoDistrictLonList, TaiPoDistrictLatList)){
                contentDTO.setArea("大埔区");
            }else if(point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  TsuenWanDistrictLonList, TsuenWanDistrictLatList)){
                contentDTO.setArea("荃湾区");
            }else if(point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  TuenMunDistrictLonList, TuenMunDistrictLatList)){
                contentDTO.setArea("屯门区");
            }else if(point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  YuenLongDistrictLonList, YuenLongDistrictLatList)){
                contentDTO.setArea("元朗区");
            }
        }

        EasyExcel.write("D://facebook边界结果.xlsx", ContentDTO.class).sheet("sheet1").doWrite(contentDTOList);

    }

    public void getList( String lineTxt, List<String> latList, List<String> lonList){
        String[] latAndLonStrArr = lineTxt.split(";");
        for (String latAndLonStr : latAndLonStrArr) {
            String[] latAndLonArr = latAndLonStr.split(",");
            latList.add(latAndLonArr[0]);
            lonList.add(latAndLonArr[1]);
        }
    }



    @Test
    public void countExcel2() throws Exception {

        AssetDataListener assetDataListener = new AssetDataListener();
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read("D://test2.xlsx", ContentDTO.class, assetDataListener).sheet().doRead();
        List<ContentDTO> contentDTOList = assetDataListener.getList();
        int size = 100;
        int more = contentDTOList.size()/size + 1;
        List<ContentDTO> writeList = new ArrayList<>(10000);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(more, more, 0,
                TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        List<Future<List<ContentDTO>>> results = new LinkedList<Future< List<ContentDTO>>>();
        for (int i = 1; i <= more; i++) {
            LocationInfoTask locationInfoTask = new LocationInfoTask(contentDTOList, i, size);
            //调用submit可以获得线程的返回值
            Future<List<ContentDTO>> result = executor.submit(locationInfoTask);
            results.add(result);
        }
        executor.shutdown();
        for (Future<List<ContentDTO>> result : results) {
            writeList.addAll(result.get());
        }
        EasyExcel.write("D://数据.xlsx", ContentDTO.class).sheet("sheet1").doWrite(writeList);

    }



    @Test
    public void countExcel() throws Exception {

        EasyExcel.read("D://边界结果.xlsx", ContentDTO.class, new CountAssetDataListener()).sheet().doRead();

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
