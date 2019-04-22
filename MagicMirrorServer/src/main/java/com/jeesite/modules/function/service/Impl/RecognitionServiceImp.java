package com.jeesite.modules.function.service.Impl;

import com.baidu.aip.speech.AipSpeech;
import com.jeesite.modules.function.dao.VoiceRecordDao;
import com.jeesite.modules.function.entity.VoiceRecord;
import com.jeesite.modules.function.enums.ServerEnum;
import com.jeesite.modules.function.service.RecognitionService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by Arnowsx on 2019/4/12
 */
@Service
public class RecognitionServiceImp implements RecognitionService {

    @Autowired
    private VoiceRecordDao voiceRecordDao;

    public static final String APP_ID = "14298467";
    public static final String API_KEY = "usLubkma4NwPKG7pcbr0nEo0";
    public static final String SECRET_KEY = "Q1sQqGt6EyDXzepp4E4G3PH8lAIStqNG";

    private static String resultText;
    private byte[] outByte;
    private int deviceId=1;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public int getVoiceType() {
        return voiceType;
    }

    public void setVoiceType(int voiceType) {
        this.voiceType = voiceType;
    }

    private int voiceType=1;

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public byte[] getOutByte() {
        return outByte;
    }

    public void setOutByte(byte[] outByte) {
        this.outByte = outByte;
    }

    private AipSpeech aipSpeech = getAipSpeech();

    @Override
    public String getResultText() {
        return resultText;
    }

    @Override
    public ServerEnum recognizeVoice(byte[] outByte) {
        this.outByte = outByte;

        // 对语音二进制数据进行识别
        if(outByte.length>0){
            byte[] data = outByte.clone();
            //readFileByBytes仅为获取二进制数据示例
            //data = Util.readFileByBytes(path);
            JSONObject asrRes2 = aipSpeech.asr(data, "pcm", 16000, null);
            System.out.println(asrRes2);
            if(asrRes2.getString("err_msg").equals("success.")){
                VoiceRecord voiceRecord = new VoiceRecord();
                voiceRecord.setDeviceId(deviceId);
                voiceRecord.setVoiceType(voiceType);
                voiceRecord.setVoiceFileBlob(data);
                resultText = asrRes2.getJSONArray("result").get(0).toString();
                voiceRecord.setVoiceText(resultText);
                voiceRecordDao.insert(voiceRecord);
            } else{
                if(asrRes2.getString("err_no").equals("3301")){
                    return ServerEnum.QUALITY_ERROR;
                }else{
                    logger.info("sql err");
                    return ServerEnum.SQLERROR;
                }
            }
            return ServerEnum.SUCCESS;
        } else {
            logger.error("outByte empty");
            return ServerEnum.EMPTYBYTES;
        }
    }

    @Override
    public AipSpeech getAipSpeech(){
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        // System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        return client;
    }
}
