package com.magicmirror.utils;

import org.json.JSONException;
import net.sf.json.JSONObject;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.List;

/**
 * created by Arnowsx on 2019/4/20
 */
public class ChatUtil {

    String reply = "对不起我没听清~";
    private static String APIKEY = "5066ca2fbe5b41d980e6e06eb32220a5";
    private static String URL = "http://openapi.tuling123.com/openapi/api/v2";
    private static String USER_ID = "424191";

    public String getReqMes(String text) {
        // 请求json，里面包含reqType，perception，userInfo
        JSONObject reqJson = new JSONObject();
        int reqType = 0;
        // 输入类型:0-文本(默认)、1-图片、2-音频
        reqJson.put("reqType",reqType);
        JSONObject perception = new JSONObject();
        // 输入的文本信息
        JSONObject inputText = new JSONObject();
//        String info = null;
//        try {
//            info = URLEncoder.encode(text,"utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        System.out.println("input text=" + text);
        inputText.put("text",text);

        perception.put("inputText",inputText);
//        // 输入的图片信息
//        JSONObject inputImage = new JSONObject();
//        inputImage.put("url","");
//        perception.put("inputImage",inputImage);
//        // 个人信息，里面包含location
//        JSONObject selfInfo = new JSONObject();
//        // 包含city，province，street
//        JSONObject location = new JSONObject();
//        location.put("city","");
//        location.put("province","");
//        location.put("street","");
//        selfInfo.put("location",location);
//        perception.put("selfInfo",selfInfo);
        // 用户信息
        JSONObject userInfo = new JSONObject();
        userInfo.put("apiKey",APIKEY);
        userInfo.put("userId",USER_ID);

        reqJson.put("perception",perception);
        reqJson.put("userInfo",userInfo);
        return reqJson.toString();
    }

    public String tulinPost(String reqMes){
        String status = "";
        String responseStr = "";
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            URL realUrl = new URL(URL);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            HttpURLConnection httpUrlConnection = (HttpURLConnection) conn;
            // 设置请求属性
            httpUrlConnection.setRequestProperty("Content-Type", "application/json;Charset=UTF-8");
            httpUrlConnection.setRequestProperty("x-adviewrtb-version", "2.1");
            // 发送POST请求必须设置如下两行
            httpUrlConnection.setDoOutput(true);
            httpUrlConnection.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(httpUrlConnection.getOutputStream());
            // 发送请求参数
            out.write(reqMes);
            // flush输出流的缓冲
            out.flush();
            httpUrlConnection.connect();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream(),"utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                responseStr += line;
            }
            status = new Integer(httpUrlConnection.getResponseCode()).toString();
            System.out.println("status=============="+status);
            System.out.println("response=============="+responseStr);
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) { out.close();}
                if (in != null) {in.close();}
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return responseStr;
    }

    public String getResultMes(String tulinPostStr){
        String result = "机器人返回失败";
        JSONObject thesultStr = JSONObject.fromObject(tulinPostStr);

        List<Object> results = (List<Object>) thesultStr.get("results");

        JSONObject resultObj = JSONObject.fromObject(results.get(0));

        JSONObject values = JSONObject.fromObject(resultObj.get("values"));

        result = values.getString("text");

        return result;
    }

    public String chatWithTurling(String text) {
        String reqStr = getReqMes(text);
        String respStr = tulinPost(reqStr);
        if(getResultMes(respStr)!=""){
            reply = getResultMes(respStr);
        }
        return reply;
    }
}
