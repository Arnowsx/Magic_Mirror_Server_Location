package com.jeesite.modules.function.service;

import com.baidu.aip.speech.AipSpeech;
import com.jeesite.modules.function.enums.ServerEnum;

/**
 * created by Arnowsx on 2019/4/12
 */
public interface RecognitionService {

    String getResultText();

    AipSpeech getAipSpeech();

    ServerEnum recognizeVoice(byte[] outByte);
}
