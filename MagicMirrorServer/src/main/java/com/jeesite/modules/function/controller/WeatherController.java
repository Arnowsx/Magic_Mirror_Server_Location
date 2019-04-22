package com.jeesite.modules.function.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * created by Arnowsx on 2019/4/19
 */
@Controller
@RequestMapping("/weather")
public class WeatherController {

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

    @RequestMapping(value = "/city", method = RequestMethod.POST)
    @ResponseBody
    public String Weather(String cityCode) throws Exception {
        System.out.println("citycode = " + cityCode);
        //String cityCode = "371000";
        String url = "https://restapi.amap.com/v3/weather/weatherInfo?key="
                + KEY + "&city=" + cityCode + "&extensions=base" + "&output=JSON";
        JSONObject json = readJsonFromUrl(url);
        JSONObject jsonSend = json.getJSONArray("lives").getJSONObject(0);
        System.out.println(jsonSend.toString());
        return jsonSend.toString();
    }
}
