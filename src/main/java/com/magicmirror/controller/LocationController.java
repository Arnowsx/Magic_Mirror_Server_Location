package com.magicmirror.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;


/**
 * created by Arnowsx on 2019/4/19
 */
@Controller
@RequestMapping("/location")
public class LocationController {

    //private static final String KEY = "YVrahWGguESbKivh8osAKrjBND3KB9M9";
    private static final String KEY = "a825e9940a5fa17b57bf4f1b74cd8e21";

    private static final String OUTPUT = "JSON";


    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
            // System.out.println("同时 从这里也能看出 即便return了，仍然会执行finally的！");
        }
    }

    @RequestMapping(value = "/ip", method = RequestMethod.GET)
    @ResponseBody
    public String Location() throws IOException, JSONException {
        //String url = "http://api.map.baidu.com/location/ip?ak="+KEY;
        String url = "https://restapi.amap.com/v3/ip?" + "key=" + KEY + "&output=" + OUTPUT;
        JSONObject json = readJsonFromUrl(url);
        System.out.println(json.toString());
        String city = "威海";
        String code = "371000";
        if("1" == json.getString("status")) {
            city = json.getString("city");
            code = json.getString("adcode");
        }
        System.out.println(city+code);
        JSONObject jsonSend = new JSONObject();
        jsonSend.put("code", code);
        jsonSend.put("city", city);
        //String cityCode = (String) ((JSONObject) json.get("content")).getJSONObject("address_detail").get("city_code");
        return jsonSend.toString();
    }
}
