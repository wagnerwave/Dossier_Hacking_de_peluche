package com.tuya.smart.common;

import a.a.a.a.a;
import com.tuya.smart.android.base.ApiParams;
import com.tuya.smart.android.base.DataBytesApiParams;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.home.sdk.bean.SpeechGuideBean;
import com.tuya.smart.home.sdk.bean.SpeechPhraseBean;
import com.tuya.smart.home.sdk.bean.VoiceCommandBean;
import java.util.ArrayList;

public class o0O00000 extends Business {
    public static final String O000000o = "ok";
    public static final String O00000Oo = "tuya.ai.speech.appHelper.asr";
    public static final String O00000o = "tuya.ai.speech.appHelper.dm";
    public static final String O00000o0 = "tuya.m.voice.control";
    public static final String O00000oO = "tuya.m.voice.dic.guidelist";
    public static final String O00000oo = "tuya.m.voice.dic.list";

    public void O000000o(long j, String str, Business.ResultListener<VoiceCommandBean> resultListener) {
        ApiParams apiParams = new ApiParams(O00000o, "1.0");
        apiParams.setGid(j);
        apiParams.putPostData("ai_type", "dm");
        apiParams.putPostData("source", oO0OO00o.O00000oo);
        apiParams.putPostData("text", str);
        apiParams.putPostData("home_id", Long.valueOf(j));
        asyncRequest(apiParams, VoiceCommandBean.class, resultListener);
    }

    public void O000000o(long j, String str, String str2, String str3, String str4, byte[] bArr, String str5, String str6, String str7, Business.ResultListener<String> resultListener) {
        DataBytesApiParams dataBytesApiParams = new DataBytesApiParams(O00000Oo, "1.0");
        dataBytesApiParams.putPostData("audio_type", str);
        dataBytesApiParams.putPostData("sample_rate", str2);
        dataBytesApiParams.putPostData("audio_type", str);
        dataBytesApiParams.putPostData("audio_channel", str3);
        dataBytesApiParams.putPostData("sample_bytes", str4);
        dataBytesApiParams.putPostData("ai_type", str5);
        dataBytesApiParams.setSessionRequire(true);
        dataBytesApiParams.putPostData("source", str6);
        dataBytesApiParams.putPostData("audio_sign", str7);
        dataBytesApiParams.setDataBytes(bArr);
        dataBytesApiParams.setGid(j);
        asyncRequest(dataBytesApiParams, String.class, resultListener);
    }

    public void O000000o(Business.ResultListener<ArrayList<SpeechPhraseBean>> resultListener) {
        asyncArrayList(a.E(O00000oo, "1.0", true), SpeechPhraseBean.class, resultListener);
    }

    public void O000000o(String str, Business.ResultListener<String> resultListener) {
        ApiParams apiParams = new ApiParams(O00000o0, "2.0");
        apiParams.putPostData(oOO0O0O0.O0000Ooo, str);
        apiParams.setSessionRequire(true);
        asyncRequest(apiParams, String.class, resultListener);
    }

    public void O00000Oo(Business.ResultListener<SpeechGuideBean> resultListener) {
        asyncRequest(a.E(O00000oO, "1.0", true), SpeechGuideBean.class, resultListener);
    }
}
