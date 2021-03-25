package com.tuya.smart.sdk.api;

import com.tuya.smart.sdk.bean.feedback.FeedbackBean;
import com.tuya.smart.sdk.bean.feedback.FeedbackMsgBean;
import com.tuya.smart.sdk.bean.feedback.FeedbackTypeRespBean;
import java.util.List;

public interface ITuyaFeedbackManager {
    void addFeedback(String str, String str2, String str3, int i, ITuyaDataCallback<FeedbackMsgBean> iTuyaDataCallback);

    void getFeedbackList(ITuyaDataCallback<List<FeedbackBean>> iTuyaDataCallback);

    void getFeedbackType(ITuyaDataCallback<List<FeedbackTypeRespBean>> iTuyaDataCallback);
}
