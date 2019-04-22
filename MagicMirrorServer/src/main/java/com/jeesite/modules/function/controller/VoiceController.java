package com.jeesite.modules.function.controller;

import com.jeesite.modules.function.enums.ServerEnum;
import com.jeesite.modules.function.service.Impl.IsOrderServiceImp;
import com.jeesite.modules.function.service.RecognitionService;
import com.jeesite.modules.function.util.ChatUtil;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;
import java.io.UnsupportedEncodingException;

/**
 * created by Arnowsx on 2019/4/13
 */
@Controller
@RequestMapping("/")
public class VoiceController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RecognitionService recognitionService;

    public String toUTF_8(String str) throws UnsupportedEncodingException {
        return new String(str.getBytes("utf-8") , "utf-8");
    }
    private ServerEnum state;
    String reply;

    //返回json数据
    //result_code:0-failed.1-success
    // voiceText：——
    @RequestMapping(value = "/recognition", method = RequestMethod.POST)
    @ResponseBody
    public String RecognitionVoice(@RequestParam("file") MultipartFile file){
        //byte[] bytes = json.getString("voiceBinary").getBytes();
        //System.out.println(json.getString("voiceBinary"));

        JSONObject jsonObject = new JSONObject();
        //System.out.println(str);
        try {
            byte[] bytes = file.getBytes();
            System.out.println("bytes:" + bytes.length);

            state = recognitionService.recognizeVoice(bytes);
            String voiceText = recognitionService.getResultText();

            IsOrderServiceImp justice = new IsOrderServiceImp();
            ServerEnum serverEnum = justice.IsOrder(voiceText);

            System.out.println("subtext = " + voiceText);
            if(-1 == state.getState()){
                jsonObject.put("result_code", "-1");
                jsonObject.put("err_msg", "数据库错误");
                jsonObject.put("user", voiceText);
                reply = "数据库错误！";
                jsonObject.put("reply", reply);
            } else if(-3 == state.getState()) {
                jsonObject.put("result_code", "-3");
                jsonObject.put("err_msg", "二进制异常");
                jsonObject.put("user", voiceText);
                reply = "传输错误！";
                jsonObject.put("reply", reply);
            } else if(1 == state.getState()) {
                ChatUtil chatUtil = new ChatUtil();
                if(serverEnum == ServerEnum.IS_WEATHER){
                    String city = new LocationController().Location();
                    JSONObject cityJson = new JSONObject(city);
                    city = cityJson.getString("city");
                    System.out.println("city:"+city);
                    String weatherOrder = city+"天气";
                    reply = chatUtil.chatWithTurling(weatherOrder);
                    System.out.println("reply:"+reply);
                }else {
                    reply = chatUtil.chatWithTurling(voiceText);
                }
                jsonObject.put("result_code", "1");
                jsonObject.put("err_msg", "成功");
                jsonObject.put("user", voiceText);
                jsonObject.put("reply", reply);
            } else {
                int stateCode = state.getState();
                String stateStr = state.getStateInfo();
                reply = stateStr;
                jsonObject.put("result_code", String.valueOf(stateCode));
                jsonObject.put("err_msg", stateStr);
                jsonObject.put("user", voiceText);
                jsonObject.put("reply", reply);
            }
            System.out.println("result_code= " + jsonObject.get("result_code").toString());
        } catch (Exception e){
            System.out.println(e.toString());
        }

        return jsonObject.toString();
    }

    @RequestMapping(value = "/123", method = RequestMethod.GET)
    @ResponseBody
    public String test(){
        return "123.jsp";
    }
}
