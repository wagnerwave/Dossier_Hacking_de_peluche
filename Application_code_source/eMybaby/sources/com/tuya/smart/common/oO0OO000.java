package com.tuya.smart.common;

import com.tuya.smart.android.device.bean.SchemaBean;
import com.tuya.smart.home.sdk.api.ITuyaHomeDataManager;
import com.tuya.smart.home.sdk.bean.HomeBean;
import com.tuya.smart.home.sdk.bean.RoomBean;
import com.tuya.smart.interior.device.bean.DeviceRespBean;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import com.tuya.smart.sdk.api.ITuyaSearchDeviceListener;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.GroupBean;
import com.tuya.smart.sdk.bean.ProductBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class oO0OO000 implements ITuyaHomeDataManager {
    public static volatile oO0OO000 O000000o;
    public o0o00o0o0o O00000Oo = ((o0o00o0o0o) Oo0.O000000o(o0o00o0o0o.class));

    public static ITuyaHomeDataManager O000000o() {
        if (O000000o == null) {
            synchronized (oO0OO000.class) {
                if (O000000o == null) {
                    O000000o = new oO0OO000();
                }
            }
        }
        return O000000o;
    }

    public void addDevRespList(List<DeviceRespBean> list) {
        oOo0oooO.O000000o().addDevList(list);
    }

    public void addProductList(List<ProductBean> list) {
        oOo0oooO.O000000o().addProductList(list);
    }

    public void discoveredLanDevice(ITuyaSearchDeviceListener iTuyaSearchDeviceListener) {
        oOo0oooO.O000000o().discoveredLanDevice(iTuyaSearchDeviceListener);
    }

    public DeviceRespBean getDevRespBean(String str) {
        return oO00O0o0.O000000o().O00000o0(str);
    }

    public List<DeviceRespBean> getDevRespBeanList() {
        return oO00O0o0.O000000o().O00000o();
    }

    public DeviceBean getDeviceBean(String str) {
        return oOo0oooO.O000000o().getDev(str);
    }

    public RoomBean getDeviceRoomBean(String str) {
        o0o00o0o0o o0o00o0o0o = this.O00000Oo;
        if (o0o00o0o0o != null) {
            return o0o00o0o0o.O00000o0().getRoomBeanBydevice(str);
        }
        return null;
    }

    public Object getDp(String str, String str2) {
        return oOo0oooO.O000000o().getDp(str, str2);
    }

    public Map<String, Object> getDps(String str) {
        return oOo0oooO.O000000o().getDps(str);
    }

    public GroupBean getGroupBean(long j) {
        o0o00o0o0o o0o00o0o0o = this.O00000Oo;
        if (o0o00o0o0o != null) {
            return o0o00o0o0o.O00000o0().getGroupBean(j);
        }
        return null;
    }

    public List<DeviceBean> getGroupDeviceList(long j) {
        o0o00o0o0o o0o00o0o0o = this.O00000Oo;
        if (o0o00o0o0o == null) {
            return null;
        }
        GroupBean groupBean = o0o00o0o0o.O00000o0().getGroupBean(j);
        return groupBean.getDeviceBeans() == null ? new ArrayList() : groupBean.getDeviceBeans();
    }

    public RoomBean getGroupRoomBean(long j) {
        o0o00o0o0o o0o00o0o0o = this.O00000Oo;
        if (o0o00o0o0o != null) {
            return o0o00o0o0o.O00000o0().getRoomBeanByGroup(j);
        }
        return null;
    }

    public HomeBean getHomeBean(long j) {
        o0o00o0o0o o0o00o0o0o = this.O00000Oo;
        if (o0o00o0o0o != null) {
            return o0o00o0o0o.O00000o0().getHomeBean(j);
        }
        return null;
    }

    public List<DeviceBean> getHomeDeviceList(long j) {
        o0o00o0o0o o0o00o0o0o = this.O00000Oo;
        if (o0o00o0o0o != null) {
            return o0o00o0o0o.O00000o0().getDevList(j);
        }
        return null;
    }

    public List<GroupBean> getHomeGroupList(long j) {
        o0o00o0o0o o0o00o0o0o = this.O00000Oo;
        if (o0o00o0o0o != null) {
            return o0o00o0o0o.O00000o0().getGroupList(j);
        }
        return null;
    }

    public List<RoomBean> getHomeRoomList(long j) {
        o0o00o0o0o o0o00o0o0o = this.O00000Oo;
        if (o0o00o0o0o != null) {
            return o0o00o0o0o.O00000o0().getHomeRoomList(j);
        }
        return null;
    }

    public List<DeviceBean> getMeshDeviceList(String str) {
        o0o00o0o0o o0o00o0o0o = this.O00000Oo;
        if (o0o00o0o0o != null) {
            return o0o00o0o0o.O00000o0().getMeshDeviceList(str);
        }
        return null;
    }

    public List<GroupBean> getMeshGroupList(String str) {
        o0o00o0o0o o0o00o0o0o = this.O00000Oo;
        if (o0o00o0o0o != null) {
            return o0o00o0o0o.O00000o0().getMeshGroupList(str);
        }
        return null;
    }

    public ProductBean getProductBean(String str) {
        return oO0O00Oo.O000000o().O000000o(str);
    }

    public RoomBean getRoomBean(long j) {
        o0o00o0o0o o0o00o0o0o = this.O00000Oo;
        if (o0o00o0o0o == null) {
            return null;
        }
        RoomBean roomBeanByRoomId = o0o00o0o0o.O00000o0().getRoomBeanByRoomId(j);
        roomBeanByRoomId.setDeviceList(this.O00000Oo.O00000o0().getRoomDeviceList(j));
        roomBeanByRoomId.setGroupList(this.O00000Oo.O00000o0().getRoomGroupList(j));
        return roomBeanByRoomId;
    }

    public List<DeviceBean> getRoomDeviceList(long j) {
        o0o00o0o0o o0o00o0o0o = this.O00000Oo;
        if (o0o00o0o0o != null) {
            return o0o00o0o0o.O00000o0().getRoomDeviceList(j);
        }
        return null;
    }

    public List<GroupBean> getRoomGroupList(long j) {
        o0o00o0o0o o0o00o0o0o = this.O00000Oo;
        if (o0o00o0o0o != null) {
            return o0o00o0o0o.O00000o0().getRoomGroupList(j);
        }
        return null;
    }

    public Map<String, SchemaBean> getSchema(String str) {
        return oOo0oooO.O000000o().getSchema(str);
    }

    public void getSubDevList(String str, ITuyaDataCallback<List<DeviceBean>> iTuyaDataCallback) {
        oOo0oooO.O000000o().O000000o(str, iTuyaDataCallback);
    }

    public DeviceRespBean getSubDevRespBean(String str, String str2) {
        return oO00O0o0.O000000o().O000000o(str, str2);
    }

    public List<DeviceBean> getSubDeviceBean(String str) {
        return oOo0oooO.O000000o().O00000Oo(str);
    }

    public DeviceBean getSubDeviceBeanByNodeId(String str, String str2) {
        return oOo0oooO.O000000o().getSubDeviceBeanByNodeId(str, str2);
    }

    public void queryDev(String str, ITuyaDataCallback<DeviceBean> iTuyaDataCallback) {
        oOo0oooO.O000000o().queryDev(str, iTuyaDataCallback);
    }

    public void querySubDev(String str, String str2, ITuyaDataCallback<DeviceBean> iTuyaDataCallback) {
        oOo0oooO.O000000o().querySubDev(str, str2, iTuyaDataCallback);
    }

    public void unRegisterDiscoveredLanDeviceListener(ITuyaSearchDeviceListener iTuyaSearchDeviceListener) {
        oOo0oooO.O000000o().unRegisterDiscoveredLanDeviceListener(iTuyaSearchDeviceListener);
    }
}
