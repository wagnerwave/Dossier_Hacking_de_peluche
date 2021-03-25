package com.tuya.smart.common;

import a.a.a.a.a;
import com.tuya.sdk.home.cache.TuyaHomeRelationCacheManager;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.home.sdk.api.ITuyaHome;
import com.tuya.smart.home.sdk.api.ITuyaHomeDeviceStatusListener;
import com.tuya.smart.home.sdk.api.ITuyaHomeStatusListener;
import com.tuya.smart.home.sdk.api.IWarningMsgListener;
import com.tuya.smart.home.sdk.bean.DeviceAndGroupInHomeBean;
import com.tuya.smart.home.sdk.bean.HomeBean;
import com.tuya.smart.home.sdk.bean.RoomBean;
import com.tuya.smart.home.sdk.callback.ITuyaGetRoomListCallback;
import com.tuya.smart.home.sdk.callback.ITuyaHomeResultCallback;
import com.tuya.smart.home.sdk.callback.ITuyaResultCallback;
import com.tuya.smart.home.sdk.callback.ITuyaRoomResultCallback;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.bluemesh.IBlueMeshCreateCallback;
import com.tuya.smart.sdk.api.bluemesh.ISigMeshCreateCallback;
import com.tuya.smart.sdk.bean.BlueMeshBean;
import com.tuya.smart.sdk.bean.CloudZigbeeGroupCreateBean;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.GroupBean;
import com.tuya.smart.sdk.bean.GroupDeviceBean;
import com.tuya.smart.sdk.bean.SigMeshBean;
import java.util.ArrayList;
import java.util.List;

public class o0o0oo00o implements ITuyaHome {
    public static final String O000000o = "TuyaHome";
    public static final String O00000o = "m/ug/";
    public static final String O00000oO = "smart/mb/in/";
    public final long O00000Oo;
    public o0o00ooo0 O00000o0;

    public o0o0oo00o(long j) {
        this.O00000Oo = j;
        if (j != 0) {
            this.O00000o0 = new o0o00ooo0(j);
            return;
        }
        throw new RuntimeException("homeId can't be 0");
    }

    public void addRoom(String str, ITuyaRoomResultCallback iTuyaRoomResultCallback) {
        this.O00000o0.O000000o(str, iTuyaRoomResultCallback);
    }

    public void bindNewConfigDevs(List<String> list, IResultCallback iResultCallback) {
        this.O00000o0.O00000o0(list, iResultCallback);
    }

    public void createBlueMesh(String str, final ITuyaResultCallback<BlueMeshBean> iTuyaResultCallback) {
        final o0o000oooo o0o000oooo = (o0o000oooo) Oo0.O000000o(o0o000oooo.class);
        if (o0o000oooo != null) {
            o0o000oooo.O000000o().createBlueMesh(this.O00000Oo, str, new IBlueMeshCreateCallback() {
                public void onError(String str, String str2) {
                    ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                    if (iTuyaResultCallback != null) {
                        iTuyaResultCallback.onError(str, str2);
                    }
                }

                public void onSuccess(BlueMeshBean blueMeshBean) {
                    List blueMeshList = o0o000oooo.O000000o().getBlueMeshList();
                    if (blueMeshList == null) {
                        blueMeshList = new ArrayList();
                    }
                    blueMeshList.add(blueMeshBean);
                    o0o000oooo.O000000o().updateBuleMesh(blueMeshList);
                    TuyaHomeRelationCacheManager.O000000o().addMeshToHome(o0o0oo00o.this.O00000Oo, blueMeshBean.getMeshId());
                    ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                    if (iTuyaResultCallback != null) {
                        iTuyaResultCallback.onSuccess(blueMeshBean);
                    }
                }
            });
        } else {
            L.e(O000000o, "iTuyaBlueMeshPlugin == null");
        }
    }

    public void createGroup(String str, String str2, List<String> list, ITuyaResultCallback<Long> iTuyaResultCallback) {
        this.O00000o0.O000000o(str, str2, list, iTuyaResultCallback);
    }

    public void createSigMesh(final ITuyaResultCallback<SigMeshBean> iTuyaResultCallback) {
        final o0o000oooo o0o000oooo = (o0o000oooo) Oo0.O000000o(o0o000oooo.class);
        if (o0o000oooo != null) {
            o0o000oooo.O00000Oo().createSigMesh(this.O00000Oo, new ISigMeshCreateCallback() {
                public void onError(String str, String str2) {
                    ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                    if (iTuyaResultCallback != null) {
                        iTuyaResultCallback.onError(str, str2);
                    }
                }

                public void onSuccess(SigMeshBean sigMeshBean) {
                    List sigMeshList = o0o000oooo.O00000Oo().getSigMeshList();
                    if (sigMeshList == null) {
                        sigMeshList = new ArrayList();
                    }
                    sigMeshList.add(sigMeshBean);
                    o0o000oooo.O00000Oo().updateSigMesh(sigMeshList);
                    TuyaHomeRelationCacheManager.O000000o().addMeshToHome(o0o0oo00o.this.O00000Oo, sigMeshBean.getMeshId());
                    ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                    if (iTuyaResultCallback != null) {
                        iTuyaResultCallback.onSuccess(sigMeshBean);
                    }
                }
            });
        } else {
            L.e(O000000o, "iTuyaBlueMeshPlugin == null");
        }
    }

    public void createZigbeeGroup(String str, String str2, int i, String str3, ITuyaResultCallback<CloudZigbeeGroupCreateBean> iTuyaResultCallback) {
        this.O00000o0.O000000o(str, str2, i, str3, iTuyaResultCallback);
    }

    public void dismissHome(IResultCallback iResultCallback) {
        this.O00000o0.O000000o(iResultCallback);
    }

    public HomeBean getHomeBean() {
        return this.O00000o0.O000000o();
    }

    public void getHomeDetail(ITuyaHomeResultCallback iTuyaHomeResultCallback) {
        this.O00000o0.O000000o(iTuyaHomeResultCallback);
    }

    public void getHomeLocalCache(ITuyaHomeResultCallback iTuyaHomeResultCallback) {
        this.O00000o0.O00000Oo(iTuyaHomeResultCallback);
    }

    public void onDestroy() {
        this.O00000o0.onDestroy();
        o0o000oooo o0o000oooo = (o0o000oooo) Oo0.O000000o(o0o000oooo.class);
        if (o0o000oooo != null) {
            o0o000oooo.O000000o().onDestroy();
            o0o000oooo.O00000Oo().onDestroy();
        }
    }

    public void queryDeviceListToAddGroup(long j, String str, ITuyaResultCallback<List<GroupDeviceBean>> iTuyaResultCallback) {
        this.O00000o0.O000000o(j, str, iTuyaResultCallback);
    }

    public List<RoomBean> queryRoomInfoByDevice(List<DeviceBean> list) {
        return this.O00000o0.O000000o(list);
    }

    public List<RoomBean> queryRoomInfoByGroup(List<GroupBean> list) {
        return this.O00000o0.O00000Oo(list);
    }

    public void queryRoomList(ITuyaGetRoomListCallback iTuyaGetRoomListCallback) {
        this.O00000o0.O000000o(iTuyaGetRoomListCallback);
    }

    public void queryZigbeeDeviceListToAddGroup(long j, String str, String str2, ITuyaResultCallback<List<GroupDeviceBean>> iTuyaResultCallback) {
        this.O00000o0.O000000o(j, str, str2, iTuyaResultCallback);
    }

    public void registerHomeDeviceStatusListener(ITuyaHomeDeviceStatusListener iTuyaHomeDeviceStatusListener) {
        o0o0ooo0o.O00000Oo().O000000o(this.O00000Oo, iTuyaHomeDeviceStatusListener);
    }

    public void registerHomeStatusListener(ITuyaHomeStatusListener iTuyaHomeStatusListener) {
        o0o0ooo0o.O00000Oo().O000000o(this.O00000Oo, iTuyaHomeStatusListener);
    }

    public void registerProductWarnListener(IWarningMsgListener iWarningMsgListener) {
        o0o0ooo0o.O00000Oo().O000000o(this.O00000Oo, iWarningMsgListener);
    }

    public void removeRoom(long j, IResultCallback iResultCallback) {
        this.O00000o0.O000000o(j, iResultCallback);
    }

    public void sortDevInHome(String str, List<DeviceAndGroupInHomeBean> list, IResultCallback iResultCallback) {
        this.O00000o0.O000000o(str, list, iResultCallback);
    }

    public void sortHome(List<Long> list, IResultCallback iResultCallback) {
        this.O00000o0.O000000o(list, iResultCallback);
    }

    public void sortRoom(List<Long> list, IResultCallback iResultCallback) {
        this.O00000o0.O00000Oo(list, iResultCallback);
    }

    public void unRegisterHomeDeviceStatusListener(ITuyaHomeDeviceStatusListener iTuyaHomeDeviceStatusListener) {
        o0o0ooo0o.O00000Oo().O00000Oo(this.O00000Oo, iTuyaHomeDeviceStatusListener);
    }

    public void unRegisterHomeStatusListener(ITuyaHomeStatusListener iTuyaHomeStatusListener) {
        o0o0ooo0o.O00000Oo().O00000Oo(this.O00000Oo, iTuyaHomeStatusListener);
    }

    public void unRegisterProductWarnListener(IWarningMsgListener iWarningMsgListener) {
        o0o0ooo0o.O00000Oo().O00000Oo(this.O00000Oo, iWarningMsgListener);
    }

    public void unSubscribeTopics(List<String> list) {
        o0o00o0oo0 o0o00o0oo0 = (o0o00o0oo0) Oo0.O000000o(o0o00o0oo0.class);
        L.d(O000000o, " unSubscribeTopics " + o0o00o0oo0);
        if (o0o00o0oo0 != null) {
            o0oo0oo000 O000000o2 = o0o00o0oo0.O000000o();
            StringBuilder n = a.n("m/ug/");
            n.append(this.O00000Oo);
            O000000o2.O000000o(n.toString(), (IResultCallback) null);
            L.d(O000000o, " unSubscribeTopics " + list);
            if (list != null) {
                for (String str : list) {
                    o0oo0oo000 O000000o3 = o0o00o0oo0.O000000o();
                    O000000o3.O000000o("smart/mb/in/" + str, (IResultCallback) null);
                }
            }
        }
    }

    public void updateHome(String str, double d2, double d3, String str2, IResultCallback iResultCallback) {
        this.O00000o0.O000000o(str, d2, d3, str2, iResultCallback);
    }

    public void updateHome(String str, double d2, double d3, String str2, List<String> list, boolean z, IResultCallback iResultCallback) {
        this.O00000o0.O000000o(str, d2, d3, str2, list, z, iResultCallback);
    }
}
