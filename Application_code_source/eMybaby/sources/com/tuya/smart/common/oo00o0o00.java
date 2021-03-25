package com.tuya.smart.common;

import a.a.a.a.a;
import com.tuya.smart.android.base.ApiParams;
import com.tuya.smart.android.hardware.service.GwBroadcastMonitorService;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.sdk.bean.feedback.FeedbackBean;
import com.tuya.smart.sdk.bean.feedback.FeedbackMsgBean;
import com.tuya.smart.sdk.bean.feedback.FeedbackMsgListBean;
import com.tuya.smart.sdk.bean.feedback.FeedbackTypeRespBean;
import com.tuya.smart.sdk.bean.message.MessageBean;
import com.tuya.smart.sdk.bean.message.MessageListBean;
import java.util.ArrayList;

public class oo00o0o00 extends Business {
    public static final String O000000o = "s.m.feedback.dialog.add";
    public static final String O00000Oo = "s.m.feedback.reply.query";
    public static final String O00000o = "s.m.feedback.typelist";
    public static final String O00000o0 = "s.m.feedback.dialog.list";
    public static final String O00000oO = "s.m.feedback.talklist";

    public void O000000o(int i, int i2, int i3, Business.ResultListener<MessageListBean> resultListener) {
        ApiParams E = a.E("tuya.m.msg.list", "4.0", true);
        E.putPostData("offset", Integer.valueOf(i));
        E.putPostData("limit", Integer.valueOf(i2));
        E.putPostData("msgType", Integer.valueOf(i3));
        asyncRequest(E, MessageListBean.class, resultListener);
    }

    public void O000000o(int i, int i2, int i3, String str, Business.ResultListener<MessageListBean> resultListener) {
        ApiParams F = a.F("tuya.m.msg.list", "5.0", true, "msgSrcId", str);
        F.putPostData("offset", Integer.valueOf(i));
        F.putPostData("limit", Integer.valueOf(i2));
        F.putPostData("msgType", Integer.valueOf(i3));
        asyncRequest(F, MessageListBean.class, resultListener);
    }

    public void O000000o(int i, int i2, long j, long j2, Business.ResultListener<MessageListBean> resultListener) {
        ApiParams E = a.E("tuya.m.msg.list", GwBroadcastMonitorService.mVersion, true);
        E.putPostData("offset", Integer.valueOf(i));
        E.putPostData("limit", Integer.valueOf(i2));
        if (j > 0 && j2 > 0) {
            E.putPostData("startTime", Long.valueOf(j));
            E.putPostData("endTime", Long.valueOf(j2));
        }
        asyncRequest(E, MessageListBean.class, resultListener);
    }

    public void O000000o(int i, int i2, String str, int i3, Business.ResultListener<FeedbackMsgListBean> resultListener) {
        ApiParams apiParams = new ApiParams(O00000o0, "1.0");
        apiParams.setSessionRequire(true);
        apiParams.setLocationRequire(true);
        apiParams.putPostData(o00000oo0.O00000o, Integer.valueOf(i));
        apiParams.putPostData("limit", Integer.valueOf(i2));
        apiParams.putPostData(o00000oo0.O00000oo, str);
        apiParams.putPostData(o00000oo0.O0000O0o, Integer.valueOf(i3));
        asyncRequest(apiParams, FeedbackMsgListBean.class, resultListener);
    }

    public void O000000o(Business.ResultListener<ArrayList<FeedbackTypeRespBean>> resultListener) {
        asyncArrayList(a.E(O00000o, "1.0", true), FeedbackTypeRespBean.class, resultListener);
    }

    public void O000000o(String str, Business.ResultListener<Boolean> resultListener) {
        asyncRequest(a.F("tuya.m.msg.remove", "1.0", true, "ids", str), Boolean.class, resultListener);
    }

    public void O000000o(String str, String str2, int i, Business.ResultListener<FeedbackMsgBean> resultListener) {
        ApiParams apiParams = new ApiParams(O000000o, "1.0");
        apiParams.setSessionRequire(true);
        apiParams.setLocationRequire(true);
        apiParams.putPostData(o00000oo0.O00000oo, str2);
        apiParams.putPostData(o00000oo0.O0000O0o, Integer.valueOf(i));
        apiParams.putPostData(o00000oo0.O00000o0, str);
        asyncRequest(apiParams, FeedbackMsgBean.class, resultListener);
    }

    public void O000000o(String str, String str2, String str3, int i, Business.ResultListener<FeedbackMsgBean> resultListener) {
        ApiParams apiParams = new ApiParams(O000000o, "2.0");
        apiParams.setSessionRequire(true);
        apiParams.setLocationRequire(true);
        apiParams.putPostData(o00000oo0.O00000oo, str3);
        apiParams.putPostData(o00000oo0.O0000O0o, Integer.valueOf(i));
        apiParams.putPostData(o00000oo0.O00000o0, str);
        apiParams.putPostData("contact", str2);
        asyncRequest(apiParams, FeedbackMsgBean.class, resultListener);
    }

    public void O00000Oo(int i, int i2, int i3, String str, Business.ResultListener<MessageListBean> resultListener) {
        ApiParams F = a.F("tuya.m.msg.list", "5.1", true, "msgSrcId", str);
        F.putPostData("offset", Integer.valueOf(i));
        F.putPostData("limit", Integer.valueOf(i2));
        F.putPostData("msgType", Integer.valueOf(i3));
        asyncRequest(F, MessageListBean.class, resultListener);
    }

    public void O00000Oo(Business.ResultListener<ArrayList<FeedbackBean>> resultListener) {
        asyncArrayList(a.E(O00000oO, "1.0", true), FeedbackBean.class, resultListener);
    }

    public void O00000o(Business.ResultListener<Integer> resultListener) {
        asyncRequest(a.E("tuya.m.msg.maxtime", "1.0", true), Integer.class, resultListener);
    }

    public void O00000o0(Business.ResultListener<ArrayList<MessageBean>> resultListener) {
        asyncArrayList(a.E("tuya.m.msg.list", "2.0", true), MessageBean.class, resultListener);
    }

    public void O00000oO(Business.ResultListener<Long> resultListener) {
        asyncRequest(a.E("tuya.m.msg.maxtime", "1.0", true), Long.class, resultListener);
    }
}
