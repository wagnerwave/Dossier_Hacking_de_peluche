package com.tuya.smart.sdk.api;

import com.tuya.smart.sdk.bean.feedback.FeedbackMsgBean;
import java.util.List;

public interface ITuyaFeedbackMag {
    void addMsg(String str, String str2, ITuyaDataCallback<FeedbackMsgBean> iTuyaDataCallback);

    void getMsgList(ITuyaDataCallback<List<FeedbackMsgBean>> iTuyaDataCallback);
}
