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
import org.springframework.util.ObjectUtils;

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

        String fileName = "fb区域";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read("D://"+fileName+".xlsx", ContentDTO.class, assetDataListener).sheet().doRead();
        List<ContentDTO> contentDTOList = assetDataListener.getList();

        //中西区 1
        List<String> CentralAndWestDistrictLonList = new ArrayList<>(10);
        List<String> CentralAndWestDistrictLatList = new ArrayList<>(10);
        List<String> CentralAndWestDistrictLonList2 = new ArrayList<>(10);
        List<String> CentralAndWestDistrictLatList2 = new ArrayList<>(10);
        List<String> CentralAndWestDistrictLonList3 = new ArrayList<>(10);
        List<String> CentralAndWestDistrictLatList3 = new ArrayList<>(10);
        //东区 2
        List<String> EasternDistrictLonList = new ArrayList<>(10);
        List<String> EasternDistrictLatList = new ArrayList<>(10);
        //南区 3
        List<String> SouthernDistrictLonList = new ArrayList<>(10);
        List<String> SouthernDistrictLatList = new ArrayList<>(10);
        List<String> SouthernDistrictLonList2 = new ArrayList<>(10);
        List<String> SouthernDistrictLatList2 = new ArrayList<>(10);
        List<String> SouthernDistrictLonList3 = new ArrayList<>(10);
        List<String> SouthernDistrictLatList3 = new ArrayList<>(10);
        //湾仔区 4
        List<String> WanChaiDistrictLonList = new ArrayList<>(10);
        List<String> WanChaiDistrictLatList = new ArrayList<>(10);
        //九龙城区 5
        List<String> KowloonCityDistrictLonList = new ArrayList<>(10);
        List<String> KowloonCityDistrictLatList = new ArrayList<>(10);
        //观塘区 6
        List<String> KwunTongDistrictLonList = new ArrayList<>(10);
        List<String> KwunTongDistrictLatList = new ArrayList<>(10);
        //深水埗区 7
        List<String> ShamShuiPoDistrictLonList = new ArrayList<>(10);
        List<String> ShamShuiPoDistrictLatList = new ArrayList<>(10);
        //黄大仙区 8
        List<String> WongTaiSinDistrictLonList = new ArrayList<>(10);
        List<String> WongTaiSinDistrictLatList = new ArrayList<>(10);
        //油尖旺区 9
        List<String> YauTsimMongDistrictLonList = new ArrayList<>(10);
        List<String> YauTsimMongDistrictLatList = new ArrayList<>(10);
        //离岛区 10
        List<String> IslandDistrictLonList = new ArrayList<>(10);
        List<String> IslandDistrictLatList = new ArrayList<>(10);
        List<String> IslandDistrictLonList2 = new ArrayList<>(10);
        List<String> IslandDistrictLatList2 = new ArrayList<>(10);
        List<String> IslandDistrictLonList3 = new ArrayList<>(10);
        List<String> IslandDistrictLatList3 = new ArrayList<>(10);
        //葵青区 11
        List<String> KwaiTsingDistrictLonList = new ArrayList<>(10);
        List<String> KwaiTsingDistrictLatList = new ArrayList<>(10);
        //北区 12
        List<String> NorthDistrictLonList = new ArrayList<>(10);
        List<String> NorthDistrictLatList = new ArrayList<>(10);
        List<String> NorthDistrictLonList2 = new ArrayList<>(10);
        List<String> NorthDistrictLatList2 = new ArrayList<>(10);
        List<String> NorthDistrictLonList3 = new ArrayList<>(10);
        List<String> NorthDistrictLatList3 = new ArrayList<>(10);
        //西贡区 13
        List<String> SaiKungDistrictLonList = new ArrayList<>(10);
        List<String> SaiKungDistrictLatList = new ArrayList<>(10);
        List<String> SaiKungDistrictLonList2 = new ArrayList<>(10);
        List<String> SaiKungDistrictLatList2 = new ArrayList<>(10);
        List<String> SaiKungDistrictLonList3 = new ArrayList<>(10);
        List<String> SaiKungDistrictLatList3 = new ArrayList<>(10);
        //沙田区 14
        List<String> ShaTinDistrictLonList = new ArrayList<>(10);
        List<String> ShaTinDistrictLatList = new ArrayList<>(10);
        //大埔区 15
        List<String> TaiPoDistrictLonList = new ArrayList<>(10);
        List<String> TaiPoDistrictLatList = new ArrayList<>(10);
        List<String> TaiPoDistrictLonList2 = new ArrayList<>(10);
        List<String> TaiPoDistrictLatList2 = new ArrayList<>(10);
        List<String> TaiPoDistrictLonList3 = new ArrayList<>(10);
        List<String> TaiPoDistrictLatList3 = new ArrayList<>(10);
        //荃湾区 16
        List<String> TsuenWanDistrictLonList = new ArrayList<>(10);
        List<String> TsuenWanDistrictLatList = new ArrayList<>(10);
        //屯门区 17
        List<String> TuenMunDistrictLonList = new ArrayList<>(10);
        List<String> TuenMunDistrictLatList = new ArrayList<>(10);
        List<String> TuenMunDistrictLonList2 = new ArrayList<>(10);
        List<String> TuenMunDistrictLatList2 = new ArrayList<>(10);
        List<String> TuenMunDistrictLonList3 = new ArrayList<>(10);
        List<String> TuenMunDistrictLatList3 = new ArrayList<>(10);
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
                    case 2:CentralAndWestDistrictLonList2.add(latAndLonArr[0]); //中西区
                        CentralAndWestDistrictLatList2.add(latAndLonArr[1]);break;
                    case 3:CentralAndWestDistrictLonList3.add(latAndLonArr[0]); //中西区
                        CentralAndWestDistrictLatList3.add(latAndLonArr[1]);break;
                    case 4:EasternDistrictLonList.add(latAndLonArr[0]); //东区
                            EasternDistrictLatList.add(latAndLonArr[1]);break;
                    case 5:SouthernDistrictLonList.add(latAndLonArr[0]); //南区
                        SouthernDistrictLatList.add(latAndLonArr[1]);break;
                    case 6:SouthernDistrictLonList2.add(latAndLonArr[0]); //南区
                        SouthernDistrictLatList2.add(latAndLonArr[1]);break;
                    case 7:SouthernDistrictLonList3.add(latAndLonArr[0]); //南区
                        SouthernDistrictLatList3.add(latAndLonArr[1]);break;
                    case 8:WanChaiDistrictLonList.add(latAndLonArr[0]); //湾仔区
                        WanChaiDistrictLatList.add(latAndLonArr[1]);break;
                    case 9:KowloonCityDistrictLonList.add(latAndLonArr[0]); //九龙城区
                        KowloonCityDistrictLatList.add(latAndLonArr[1]);break;
                    case 10:KwunTongDistrictLonList.add(latAndLonArr[0]); //观塘区
                        KwunTongDistrictLatList.add(latAndLonArr[1]);break;
                    case 11:ShamShuiPoDistrictLonList.add(latAndLonArr[0]); //深水埗区
                        ShamShuiPoDistrictLatList.add(latAndLonArr[1]);break;
                    case 12:WongTaiSinDistrictLonList.add(latAndLonArr[0]); //黄大仙区
                        WongTaiSinDistrictLatList.add(latAndLonArr[1]);break;
                    case 13:YauTsimMongDistrictLonList.add(latAndLonArr[0]); //油尖旺区
                        YauTsimMongDistrictLatList.add(latAndLonArr[1]);break;
                    case 14:IslandDistrictLonList.add(latAndLonArr[0]); //离岛区
                        IslandDistrictLatList.add(latAndLonArr[1]);break;
                    case 15:IslandDistrictLonList2.add(latAndLonArr[0]); //离岛区
                        IslandDistrictLatList2.add(latAndLonArr[1]);break;
                    case 16:IslandDistrictLonList3.add(latAndLonArr[0]); //离岛区
                        IslandDistrictLatList3.add(latAndLonArr[1]);break;
                    case 17:KwaiTsingDistrictLonList.add(latAndLonArr[0]); //葵青区
                        KwaiTsingDistrictLatList.add(latAndLonArr[1]);break;
                    case 18:NorthDistrictLonList.add(latAndLonArr[0]); //北区
                        NorthDistrictLatList.add(latAndLonArr[1]);break;
                    case 19:NorthDistrictLonList2.add(latAndLonArr[0]); //北区
                        NorthDistrictLatList2.add(latAndLonArr[1]);break;
                    case 20:NorthDistrictLonList3.add(latAndLonArr[0]); //北区
                        NorthDistrictLatList3.add(latAndLonArr[1]);break;
                    case 21:SaiKungDistrictLonList.add(latAndLonArr[0]); //西贡区
                        SaiKungDistrictLatList.add(latAndLonArr[1]);break;
                    case 22:SaiKungDistrictLonList2.add(latAndLonArr[0]); //西贡区
                        SaiKungDistrictLatList2.add(latAndLonArr[1]);break;
                    case 23:SaiKungDistrictLonList3.add(latAndLonArr[0]); //西贡区
                        SaiKungDistrictLatList3.add(latAndLonArr[1]);break;
                    case 24:ShaTinDistrictLonList.add(latAndLonArr[0]); //沙田区
                        ShaTinDistrictLatList.add(latAndLonArr[1]);break;
                    case 25:TaiPoDistrictLonList.add(latAndLonArr[0]); //大埔区
                        TaiPoDistrictLatList.add(latAndLonArr[1]);break;
                    case 26:TaiPoDistrictLonList2.add(latAndLonArr[0]); //大埔区
                        TaiPoDistrictLatList2.add(latAndLonArr[1]);break;
                    case 27:TaiPoDistrictLonList3.add(latAndLonArr[0]); //大埔区
                        TaiPoDistrictLatList3.add(latAndLonArr[1]);break;
                    case 28:TsuenWanDistrictLonList.add(latAndLonArr[0]); //荃湾区
                        TsuenWanDistrictLatList.add(latAndLonArr[1]);break;
                    case 29:TuenMunDistrictLonList.add(latAndLonArr[0]); //屯门区
                        TuenMunDistrictLatList.add(latAndLonArr[1]);break;
                    case 30:TuenMunDistrictLonList2.add(latAndLonArr[0]); //屯门区
                        TuenMunDistrictLatList2.add(latAndLonArr[1]);break;
                    case 31:TuenMunDistrictLonList3.add(latAndLonArr[0]); //屯门区
                        TuenMunDistrictLatList3.add(latAndLonArr[1]);break;
                    case 32:YuenLongDistrictLonList.add(latAndLonArr[0]); //元朗区
                        YuenLongDistrictLatList.add(latAndLonArr[1]);break;
                    default:break;
                }
            }
            lineIndex++;
        }
        System.out.println(lineIndex);
        Point point = new Point();
        for (ContentDTO contentDTO : contentDTOList) {
            if(point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  CentralAndWestDistrictLonList, CentralAndWestDistrictLatList) ||
                    point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  CentralAndWestDistrictLonList2, CentralAndWestDistrictLatList2) ||
                    point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  CentralAndWestDistrictLonList3, CentralAndWestDistrictLatList3)){
                contentDTO.setArea("中西区");
            }else if(point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  EasternDistrictLonList, EasternDistrictLatList)){
                contentDTO.setArea("东区");
            }else if(point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  SouthernDistrictLonList, SouthernDistrictLatList) ||
                    point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  SouthernDistrictLonList2, SouthernDistrictLatList2) ||
                    point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  SouthernDistrictLonList3, SouthernDistrictLatList3) ){
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
            }else if(point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  IslandDistrictLonList, IslandDistrictLatList) ||
                    point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  IslandDistrictLonList2, IslandDistrictLatList2) ||
                    point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  IslandDistrictLonList3, IslandDistrictLatList3)){
                contentDTO.setArea("离岛区");
            }else if(point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  KwaiTsingDistrictLonList, KwaiTsingDistrictLatList)){
                contentDTO.setArea("葵青区");
            }else if(point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  NorthDistrictLonList, NorthDistrictLatList) ||
                    point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  NorthDistrictLonList2, NorthDistrictLatList2) ||
                    point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  NorthDistrictLonList3, NorthDistrictLatList3)){
                contentDTO.setArea("北区");
            }else if(point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  SaiKungDistrictLonList, SaiKungDistrictLatList) ||
                    point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  SaiKungDistrictLonList2, SaiKungDistrictLatList2) ||
                    point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  SaiKungDistrictLonList3, SaiKungDistrictLatList3)){
                contentDTO.setArea("西贡区");
            }else if(point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  ShaTinDistrictLonList, ShaTinDistrictLatList)){
                contentDTO.setArea("沙田区");
            }else if(point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  TaiPoDistrictLonList, TaiPoDistrictLatList) ||
                    point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  TaiPoDistrictLonList2, TaiPoDistrictLatList2) ||
                    point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  TaiPoDistrictLonList3, TaiPoDistrictLatList3)){
                contentDTO.setArea("大埔区");
            }else if(point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  TsuenWanDistrictLonList, TsuenWanDistrictLatList)){
                contentDTO.setArea("荃湾区");
            }else if(point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  TuenMunDistrictLonList, TuenMunDistrictLatList) ||
                    point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  TuenMunDistrictLonList2, TuenMunDistrictLatList2) ||
                    point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  TuenMunDistrictLonList3, TuenMunDistrictLatList3)){
                contentDTO.setArea("屯门区");
            }else if(point.isPointInPolygon(Double.parseDouble(contentDTO.getLon()), Double.parseDouble(contentDTO.getLat()),  YuenLongDistrictLonList, YuenLongDistrictLatList)){
                contentDTO.setArea("元朗区");
            } else {
                contentDTO.setArea(getArea(contentDTO.getLocName()));
            }
        }

        EasyExcel.write("D://"+fileName+"区域统计.xlsx", ContentDTO.class).sheet("sheet1").doWrite(contentDTOList);

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

        HashMap<String, Object> hashMap = new HashMap<>(16);
        hashMap.put("test",1);

//        String fileName = "fb区域";
//
//        EasyExcel.read("D://"+fileName+"区域统计.xlsx", ContentDTO.class, new CountAssetDataListener()).sheet().doRead();

    }


    public String getArea(String area){
        if(!ObjectUtils.isEmpty(area)){
            if(area.toLowerCase().contains("Central and West District".toLowerCase()) || area.contains("Central And Western District") || area.contains("中西區")) {return "中西区";}
            if(area.toLowerCase().contains("Eastern District".toLowerCase())  || area.contains("东区") || area.contains("東區")) {return "东区";}
            if(area.toLowerCase().contains("Southern District".toLowerCase()) || area.contains("南区") || area.contains("南區")) {return "南区";}
            if(area.toLowerCase().contains("Wan Chai District".toLowerCase()) || area.contains("Wan Chai") || area.contains("湾仔") || area.contains("灣仔")) {return "湾仔区";}
            if(area.toLowerCase().contains("Kowloon City District".toLowerCase()) || area.contains("Kowloon City") || area.contains("九龙城")) {return "九龙城区";}
            if(area.toLowerCase().contains("Kwun Tong District".toLowerCase()) || area.contains("Kwun Tong") || area.contains("观塘")) {return "观塘区";}
            if(area.toLowerCase().contains("Sham Shui Po District".toLowerCase()) || area.contains("Sham Shui Po") || area.contains("深水埗")) {return "深水埗区";}
            if(area.toLowerCase().contains("Wong Tai Sin District".toLowerCase()) || area.contains("Wong Tai Sin") || area.contains("黄大仙")) {return "黄大仙区";}
            if(area.toLowerCase().contains("Yau Tsim Mong District".toLowerCase()) || area.contains("Yau Tsim Mong") ||  area.contains("油尖旺")) {return "油尖旺区";}
            if(area.toLowerCase().contains("Island District".toLowerCase()) || area.toLowerCase().contains("Island".toLowerCase()) || area.contains("離島")) {return "离岛区";}
            if(area.toLowerCase().contains("Kwai Tsing District".toLowerCase()) || area.contains("Kwai Tsing")) {return "葵青区";}
            if(area.toLowerCase().contains("North District".toLowerCase()) || area.contains("北区") || area.contains("北區")) {return "北区";}
            if(area.toLowerCase().contains("Sai Kung District".toLowerCase()) || area.contains("Sai Kung") || area.contains("西貢")) {return "西贡区";}
            if(area.toLowerCase().contains("Sha Tin District".toLowerCase()) || area.contains("Sha Tin") || area.contains("沙田")) {return "沙田区";}
            if(area.toLowerCase().contains("Tai Po District".toLowerCase()) || area.contains("Tai Po") || area.contains("大埔")) {return "大埔区";}
            if(area.toLowerCase().contains("Tsuen Wan District".toLowerCase()) || area.contains("Tsuen Wan")) {return "荃湾区";}
            if(area.toLowerCase().contains("Tuen Mun District".toLowerCase()) || area.contains("Tuen Mun") || area.contains("屯门") || area.contains("屯門") ) {return "屯门区";}
            if(area.toLowerCase().contains("Yuen Long District".toLowerCase()) || area.contains("Yuen Long")) {return "元朗区";}
        }
        return "";
    }

}
