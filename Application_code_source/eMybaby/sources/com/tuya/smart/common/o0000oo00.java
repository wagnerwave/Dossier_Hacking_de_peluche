package com.tuya.smart.common;

import com.tuya.smart.android.base.TuyaSmartSdk;
import com.tuya.smart.android.common.utils.SafeHandler;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import com.tuya.smart.sdk.api.ITuyaFeedbackMag;
import com.tuya.smart.sdk.bean.feedback.FeedbackMsgBean;
import java.util.List;

public class o0000oo00 implements ITuyaFeedbackMag {
    public o0000o00o O000000o;

    public o0000oo00(String str, int i) {
        this.O000000o = new o0000o00o(TuyaSmartSdk.getApplication(), (SafeHandler) null, str, i);
    }

    public void addMsg(String str, String str2, ITuyaDataCallback<FeedbackMsgBean> iTuyaDataCallback) {
        this.O000000o.O000000o(str, str2, iTuyaDataCallback);
    }

    public void getMsgList(ITuyaDataCallback<List<FeedbackMsgBean>> iTuyaDataCallback) {
        this.O000000o.O000000o(iTuyaDataCallback);
    }
}
