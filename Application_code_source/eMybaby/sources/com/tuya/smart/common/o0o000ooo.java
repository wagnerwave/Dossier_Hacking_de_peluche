package com.tuya.smart.common;

import a.a.a.a.a;
import androidx.core.app.NotificationCompat;
import com.alibaba.fastjson.JSON;
import com.tuya.sdk.home.bean.RoomResponseBean;
import com.tuya.smart.android.base.ApiParams;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.TuyaApiParams;
import com.tuya.smart.home.sdk.bean.RoomBean;
import java.util.ArrayList;
import java.util.List;

public class o0o000ooo extends Business {
    public static final String O000000o = "tuya.m.room.list";
    public static final String O00000Oo = "tuya.m.room.add";
    public static final String O00000o = "tuya.m.room.dismiss";
    public static final String O00000o0 = "tuya.m.room.update";
    public static final String O00000oO = "tuya.m.room.sort";

    public void O000000o(long j, Business.ResultListener<ArrayList<RoomResponseBean>> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.room.list", "2.0");
        apiParams.putPostData(TuyaApiParams.KEY_GID, Long.valueOf(j));
        asyncArrayList(apiParams, RoomResponseBean.class, resultListener);
    }

    public void O000000o(long j, String str, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.room.update", "1.0");
        apiParams.putPostData("roomId", Long.valueOf(j));
        apiParams.putPostData("name", str);
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O000000o(RoomBean roomBean, long j, Business.ResultListener<RoomResponseBean> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.room.add", "2.0");
        apiParams.putPostData("name", roomBean.getName());
        if (roomBean.getBackground() != null) {
            apiParams.putPostData(NotificationCompat.WearableExtender.KEY_BACKGROUND, roomBean.getBackground());
        }
        apiParams.putPostData(TuyaApiParams.KEY_GID, Long.valueOf(j));
        asyncRequest(apiParams, RoomResponseBean.class, resultListener);
    }

    public void O000000o(List<Long> list, Business.ResultListener<ArrayList<RoomResponseBean>> resultListener) {
        asyncArrayList(a.D(O00000oO, "1.0", "ids", JSON.toJSON(list).toString()), RoomResponseBean.class, resultListener);
    }

    public void O00000Oo(long j, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.room.dismiss", "1.0");
        apiParams.putPostData("roomId", Long.valueOf(j));
        asyncRequest(apiParams, Boolean.class, resultListener);
    }
}
