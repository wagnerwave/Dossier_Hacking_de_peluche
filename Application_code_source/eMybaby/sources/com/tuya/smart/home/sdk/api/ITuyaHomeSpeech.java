package com.tuya.smart.home.sdk.api;

import com.tuya.smart.home.sdk.bean.SpeechGuideBean;
import com.tuya.smart.home.sdk.bean.SpeechPhraseBean;
import com.tuya.smart.home.sdk.bean.VoiceCommandBean;
import com.tuya.smart.home.sdk.callback.ITuyaResultCallback;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import java.util.ArrayList;

public interface ITuyaHomeSpeech {
    void convertToTextWithAudioData(byte[] bArr, String str, String str2, long j, ITuyaResultCallback<String> iTuyaResultCallback);

    void executeCommandWithSpeechText(String str, long j, ITuyaDataCallback<VoiceCommandBean> iTuyaDataCallback);

    void getVoiceGuideTipList(ITuyaDataCallback<SpeechGuideBean> iTuyaDataCallback);

    void getVoicePhraseTipList(ITuyaDataCallback<ArrayList<SpeechPhraseBean>> iTuyaDataCallback);
}
