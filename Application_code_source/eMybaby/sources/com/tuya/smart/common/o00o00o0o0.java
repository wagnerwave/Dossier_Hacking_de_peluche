package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.tuya.smart.android.base.ApiParams;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.android.sweeper.bean.CloudConfigBean;
import com.tuya.smart.android.sweeper.bean.PathConfig;
import com.tuya.smart.android.sweeper.bean.SweeperHistory;
import com.tuya.smart.android.sweeper.bean.SweeperPathBean;
import com.tuya.smart.common.o00o00o0oo;
import com.tuya.smart.home.sdk.callback.ITuyaResultCallback;
import java.util.List;

public class o00o00o0o0 extends Business {
    public static final String O000000o = "tuya.m.dev.storage.config.get";
    public static final String O00000Oo = "tuya.m.dev.common.file.list";
    public static final String O00000o = "tuya.m.common.file.all.delete";
    public static final String O00000o0 = "tuya.m.common.file.delete";
    public static final String O00000oO = "/route/rou.bin";
    public static final String O00000oo = "/layout/lay.bin";

    public void O000000o(String str, long j, int i, int i2, long j2, long j3, Business.ResultListener<SweeperHistory> resultListener) {
        ApiParams apiParams = new ApiParams(O00000Oo, "1.0");
        apiParams.setSessionRequire(true);
        apiParams.setGid(j);
        apiParams.putPostData("devId", str);
        apiParams.putPostData("fileType", "pic");
        apiParams.putPostData("limit", Integer.valueOf(i));
        apiParams.putPostData("offset", Integer.valueOf(i2));
        if (!(j2 == -1 || j3 == -1)) {
            apiParams.putPostData("startTime", Long.valueOf(j2));
            apiParams.putPostData("endTime", Long.valueOf(j3));
        }
        asyncRequest(apiParams, SweeperHistory.class, resultListener);
    }

    public void O000000o(String str, Business.ResultListener<CloudConfigBean> resultListener) {
        ApiParams F = a.F(O000000o, "1.0", true, "type", "Common");
        F.putPostData("devId", str);
        asyncRequest(F, CloudConfigBean.class, resultListener);
    }

    public void O000000o(String str, final ITuyaResultCallback<SweeperPathBean> iTuyaResultCallback) {
        if (iTuyaResultCallback != null) {
            O000000o(str, (Business.ResultListener<CloudConfigBean>) new Business.ResultListener<CloudConfigBean>() {
                /* renamed from: O000000o */
                public void onFailure(BusinessResponse businessResponse, CloudConfigBean cloudConfigBean, String str) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }

                /* renamed from: O00000Oo */
                public void onSuccess(BusinessResponse businessResponse, CloudConfigBean cloudConfigBean, String str) {
                    if (cloudConfigBean == null) {
                        iTuyaResultCallback.onError(o00o00o0oo.O000000o.O000000o, "cloudConfigBean empty");
                        return;
                    }
                    PathConfig pathConfig = cloudConfigBean.getPathConfig();
                    if (pathConfig == null || TextUtils.isEmpty(pathConfig.getCommon())) {
                        iTuyaResultCallback.onError(o00o00o0oo.O000000o.O000000o, "pathConfig empty");
                        return;
                    }
                    SweeperPathBean sweeperPathBean = new SweeperPathBean();
                    sweeperPathBean.setMapPath(pathConfig.getCommon() + o00o00o0o0.O00000oo);
                    sweeperPathBean.setRoutePath(pathConfig.getCommon() + o00o00o0o0.O00000oO);
                    iTuyaResultCallback.onSuccess(sweeperPathBean);
                }
            });
        }
    }

    public void O000000o(String str, List<String> list, Business.ResultListener<Boolean> resultListener) {
        ApiParams F = a.F(O00000o0, "1.0", true, "devId", str);
        F.putPostData("fileIds", (list == null || list.isEmpty()) ? "" : JSON.toJSONString(list));
        asyncRequestBoolean(F, resultListener);
    }

    public void O00000Oo(String str, Business.ResultListener<Boolean> resultListener) {
        ApiParams F = a.F(O00000o, "1.0", true, "devId", str);
        F.putPostData("fileType", "pic");
        asyncRequestBoolean(F, resultListener);
    }
}
