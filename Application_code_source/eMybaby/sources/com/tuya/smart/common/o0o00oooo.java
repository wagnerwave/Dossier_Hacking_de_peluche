package com.tuya.smart.common;

import android.content.Context;
import com.tuya.sdk.home.bean.HomeResponseBean;
import com.tuya.smart.android.common.utils.SafeHandler;
import com.tuya.smart.android.mvp.model.BaseModel;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.home.sdk.bean.HomeBean;
import com.tuya.smart.home.sdk.bean.RoomBean;
import com.tuya.smart.home.sdk.callback.ITuyaGetHomeListCallback;
import com.tuya.smart.home.sdk.callback.ITuyaHomeResultCallback;
import java.util.ArrayList;
import java.util.List;

public class o0o00oooo extends BaseModel implements o0o0o00o0 {
    public o0o0000oo O000000o = new o0o0000oo();

    public o0o00oooo(Context context, SafeHandler safeHandler) {
        super(context, safeHandler);
    }

    public void O000000o(final ITuyaGetHomeListCallback iTuyaGetHomeListCallback) {
        this.O000000o.O000000o(new Business.ResultListener<ArrayList<HomeResponseBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<HomeResponseBean> arrayList, String str) {
                ITuyaGetHomeListCallback iTuyaGetHomeListCallback = iTuyaGetHomeListCallback;
                if (iTuyaGetHomeListCallback != null) {
                    iTuyaGetHomeListCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<HomeResponseBean> arrayList, String str) {
                ITuyaGetHomeListCallback iTuyaGetHomeListCallback = iTuyaGetHomeListCallback;
                if (iTuyaGetHomeListCallback != null) {
                    iTuyaGetHomeListCallback.onSuccess(o0o0oooo0.O000000o((List<HomeResponseBean>) arrayList));
                }
            }
        });
    }

    public void O000000o(String str, double d2, double d3, String str2, List<String> list, final ITuyaHomeResultCallback iTuyaHomeResultCallback) {
        final HomeBean homeBean = new HomeBean();
        homeBean.setName(str);
        homeBean.setGeoName(str2);
        homeBean.setLat(d3);
        homeBean.setLon(d2);
        ArrayList arrayList = new ArrayList();
        for (String name : list) {
            RoomBean roomBean = new RoomBean();
            roomBean.setName(name);
            arrayList.add(roomBean);
        }
        homeBean.setRooms(arrayList);
        this.O000000o.O000000o(homeBean, list, (Business.ResultListener<HomeResponseBean>) new Business.ResultListener<HomeResponseBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, HomeResponseBean homeResponseBean, String str) {
                ITuyaHomeResultCallback iTuyaHomeResultCallback = iTuyaHomeResultCallback;
                if (iTuyaHomeResultCallback != null) {
                    iTuyaHomeResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, HomeResponseBean homeResponseBean, String str) {
                o0o00oo00.O00000Oo(homeResponseBean.getGid());
                if (iTuyaHomeResultCallback != null) {
                    homeBean.setHomeId(homeResponseBean.getGid());
                    iTuyaHomeResultCallback.onSuccess(homeBean);
                }
            }
        });
    }

    public void onDestroy() {
        this.O000000o.onDestroy();
    }
}
