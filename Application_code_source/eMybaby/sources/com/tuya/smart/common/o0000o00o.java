package com.tuya.smart.common;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.tuya.smart.android.base.utils.PreferencesUtil;
import com.tuya.smart.android.common.utils.SafeHandler;
import com.tuya.smart.android.mvp.model.BaseModel;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import com.tuya.smart.sdk.bean.feedback.FeedbackMsgBean;
import com.tuya.smart.sdk.bean.feedback.FeedbackMsgListBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class o0000o00o extends BaseModel {
    public static final int O000000o = 1000;
    public oo00o0o00 O00000Oo;
    public String O00000o;
    public int O00000o0;
    public int O00000oO;
    public String O00000oo = (this.O00000o + this.O00000oO);

    public o0000o00o(Context context, SafeHandler safeHandler, String str, int i) {
        super(context, safeHandler);
        this.O00000o = str;
        this.O00000oO = i;
        O00000o0();
        this.O00000Oo = new oo00o0o00();
    }

    public static HashMap<String, Integer> O000000o() {
        String string = PreferencesUtil.getString(PreferencesUtil.FEEDBACK_UPDATE_TIME);
        return !TextUtils.isEmpty(string) ? (HashMap) JSON.parseObject(string, Map.class) : new HashMap<>();
    }

    /* access modifiers changed from: private */
    public void O000000o(int i) {
        HashMap<String, Integer> O000000o2 = O000000o();
        O000000o2.put(this.O00000oo, Integer.valueOf(i));
        PreferencesUtil.set(PreferencesUtil.FEEDBACK_UPDATE_TIME, JSON.toJSONString(O000000o2));
    }

    private void O00000o0() {
        Integer num;
        String string = PreferencesUtil.getString(PreferencesUtil.FEEDBACK_UPDATE_TIME);
        if (TextUtils.isEmpty(string) || (num = (Integer) ((HashMap) JSON.parseObject(string, Map.class)).get(this.O00000oo)) == null) {
            this.O00000o0 = 0;
        } else {
            this.O00000o0 = num.intValue();
        }
    }

    public void O000000o(final ITuyaDataCallback<List<FeedbackMsgBean>> iTuyaDataCallback) {
        this.O00000Oo.O000000o(this.O00000o0, 1000, this.O00000o, this.O00000oO, (Business.ResultListener<FeedbackMsgListBean>) new Business.ResultListener<FeedbackMsgListBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, FeedbackMsgListBean feedbackMsgListBean, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, final FeedbackMsgListBean feedbackMsgListBean, String str) {
                AsyncTask.execute(new Runnable() {
                    public void run() {
                        ArrayList<FeedbackMsgBean> list = feedbackMsgListBean.getList();
                        if (list != null && list.size() > 0) {
                            o00000ooo.O000000o(o0000o00o.this.O00000o, o0000o00o.this.O00000oO, list);
                        }
                        int unused = o0000o00o.this.O00000o0 = feedbackMsgListBean.getLastTime();
                        o0000o00o o0000o00o = o0000o00o.this;
                        o0000o00o.O000000o(o0000o00o.O00000o0);
                        final ArrayList<FeedbackMsgBean> O00000Oo2 = o0000o00o.this.O00000Oo();
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                                if (iTuyaDataCallback != null) {
                                    iTuyaDataCallback.onSuccess(O00000Oo2);
                                }
                            }
                        });
                    }
                });
            }
        });
    }

    public void O000000o(String str, String str2, final ITuyaDataCallback<FeedbackMsgBean> iTuyaDataCallback) {
        this.O00000Oo.O000000o(str, str2, this.O00000o, this.O00000oO, (Business.ResultListener<FeedbackMsgBean>) new Business.ResultListener<FeedbackMsgBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, FeedbackMsgBean feedbackMsgBean, String str) {
                iTuyaDataCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, FeedbackMsgBean feedbackMsgBean, String str) {
                iTuyaDataCallback.onSuccess(feedbackMsgBean);
            }
        });
    }

    public ArrayList<FeedbackMsgBean> O00000Oo() {
        return o00000ooo.O000000o(this.O00000o, this.O00000oO);
    }

    public void onDestroy() {
        this.O00000Oo.cancelAll();
    }
}
