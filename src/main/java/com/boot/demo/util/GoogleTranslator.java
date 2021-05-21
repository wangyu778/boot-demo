package com.boot.demo.util;

import com.alibaba.fastjson.JSONArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collections;

/**
 * @Author: wy
 * @Date: 2021/5/20 16:00
 * @Description:
 */
public class GoogleTranslator {

    public String translate(String langFrom, String langTo,
                            String word) throws Exception {

        String url = "https://translate.googleapis.com/translate_a/single?" +
                "client=gtx&" +
                "sl=" + langFrom +
                "&tl=" + langTo +
                "&dt=t&q=" + URLEncoder.encode(word, "UTF-8");

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        String returnStr = "";
        JSONArray parse = (JSONArray) JSONArray.parse(response.toString());
        JSONArray parse2 = (JSONArray) JSONArray.parse(parse.getString(0));
        for (int i = 0; i < parse2.size(); i++) {
            JSONArray parse3 = (JSONArray) JSONArray.parse(parse2.getString(i));
            returnStr = returnStr+parse3.getString(0);
        }
        return returnStr;
    }


}
