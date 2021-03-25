package com.tuya.smart.common;

import a.a.a.a.a;
import com.tuya.smart.android.base.ApiParams;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.sdk.bean.BlueMeshRoomBean;
import java.util.ArrayList;

public class O000O00o extends Business {
    public static final String O000000o = "tuya.m.room.add";
    public static final String O00000Oo = "tuya.m.room.update";
    public static final String O00000o = "tuya.m.room.list";
    public static final String O00000o0 = "tuya.m.room.dismiss";

    public void O000000o(long j, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.room.dismiss", "1.0");
        apiParams.putPostData("roomId", Long.valueOf(j));
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O000000o(Business.ResultListener<ArrayList<BlueMeshRoomBean>> resultListener) {
        asyncArrayList(new ApiParams("tuya.m.room.list", "1.0"), BlueMeshRoomBean.class, resultListener);
    }

    public void O000000o(String str, long j, Business.ResultListener<Boolean> resultListener) {
        ApiParams D = a.D("tuya.m.room.update", "1.0", "name", str);
        D.putPostData("roomId", Long.valueOf(j));
        asyncRequest(D, Boolean.class, resultListener);
    }

    public void O000000o(String str, String str2, int i, Business.ResultListener<Long> resultListener) {
        ApiParams D = a.D("tuya.m.room.add", "1.0", "name", str);
        D.putPostData("parentId", str2);
        D.putPostData("parentType", Integer.valueOf(i));
        asyncRequest(D, Long.class, resultListener);
    }
}
