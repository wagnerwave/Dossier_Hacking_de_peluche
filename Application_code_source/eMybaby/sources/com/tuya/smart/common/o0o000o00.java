package com.tuya.smart.common;

import a.a.a.a.a;
import com.alibaba.fastjson.JSON;
import com.tuya.sdk.home.bean.DeviceSortResponseBean;
import com.tuya.sdk.home.bean.RoomDeviceResponseBean;
import com.tuya.smart.android.base.ApiParams;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.TuyaApiParams;
import com.tuya.smart.home.sdk.bean.DeviceAndGroupInHomeBean;
import com.tuya.smart.home.sdk.bean.DeviceAndGroupInRoomBean;
import com.tuya.smart.home.sdk.bean.UniversalBean;
import com.tuya.smart.interior.enums.BizParentTypeEnum;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class o0o000o00 extends Business {
    public static final String O000000o = "tuya.m.my.group.device.sort.list.update";
    public static final String O00000Oo = "tuya.m.device.relation.add";
    public static final String O00000o = "tuya.m.device.relation.save";
    public static final String O00000o0 = "tuya.m.device.relation.delete";
    public static final String O00000oO = "tuya.m.device.relations.selected.save";
    public static final String O00000oo = "tuya.m.device.relation.list";
    public static final String O0000O0o = "tuya.m.device.relation.sort";

    public void O000000o(Object obj, BizParentTypeEnum bizParentTypeEnum, Business.ResultListener<Map<String, Object>> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.device.relation.entity.list", "1.0");
        apiParams.putPostData("parentId", obj);
        apiParams.putPostData("parentType", Integer.valueOf(bizParentTypeEnum.getType()));
        asyncHashMap(apiParams, Object.class, resultListener);
    }

    public void O000000o(Object obj, BizParentTypeEnum bizParentTypeEnum, Object obj2, BizParentTypeEnum bizParentTypeEnum2, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.device.relation.add", "1.0");
        apiParams.putPostData("bizId", obj);
        apiParams.putPostData("bizType", Integer.valueOf(bizParentTypeEnum.getType()));
        apiParams.putPostData("parentId", obj2);
        apiParams.putPostData("parentType", Integer.valueOf(bizParentTypeEnum2.getType()));
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O000000o(Object obj, BizParentTypeEnum bizParentTypeEnum, List<DeviceAndGroupInRoomBean> list, boolean z, Business.ResultListener<ArrayList<UniversalBean>> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.device.relations.selected.save", "2.0");
        apiParams.putPostData("bizs", list);
        apiParams.putPostData("parentId", obj);
        apiParams.putPostData("parentType", Integer.valueOf(bizParentTypeEnum.getType()));
        apiParams.putPostData("onlyParent", Boolean.valueOf(z));
        asyncArrayList(apiParams, UniversalBean.class, resultListener);
    }

    public void O000000o(Object obj, Object obj2, Business.ResultListener<ArrayList<DeviceAndGroupInRoomBean>> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.device.relation.list", "1.0");
        apiParams.putPostData("parentId", obj);
        apiParams.putPostData("parentType", obj2);
        asyncArrayList(apiParams, DeviceAndGroupInRoomBean.class, resultListener);
    }

    public void O000000o(Object obj, Object obj2, BizParentTypeEnum bizParentTypeEnum, Business.ResultListener<ArrayList<RoomDeviceResponseBean>> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.device.relation.sort", "1.0");
        apiParams.putPostData("bizs", obj);
        apiParams.putPostData("parentId", obj2);
        apiParams.putPostData("parentType", Integer.valueOf(bizParentTypeEnum.getType()));
        asyncArrayList(apiParams, RoomDeviceResponseBean.class, resultListener);
    }

    public void O000000o(String str, List<DeviceAndGroupInHomeBean> list, Business.ResultListener<ArrayList<DeviceSortResponseBean>> resultListener) {
        ApiParams D = a.D(O000000o, "1.0", TuyaApiParams.KEY_GID, str);
        D.putPostData("displayContent", JSON.toJSONString(list));
        asyncArrayList(D, DeviceSortResponseBean.class, resultListener);
    }

    public void O00000Oo(Object obj, BizParentTypeEnum bizParentTypeEnum, Object obj2, BizParentTypeEnum bizParentTypeEnum2, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.device.relation.delete", "1.0");
        apiParams.putPostData("bizId", obj);
        apiParams.putPostData("bizType", Integer.valueOf(bizParentTypeEnum.getType()));
        apiParams.putPostData("parentId", obj2);
        apiParams.putPostData("parentType", Integer.valueOf(bizParentTypeEnum2.getType()));
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O00000o(Object obj, BizParentTypeEnum bizParentTypeEnum, Object obj2, BizParentTypeEnum bizParentTypeEnum2, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.device.relations.selected.save", "1.0");
        apiParams.putPostData("bizIds", obj);
        apiParams.putPostData("bizType", Integer.valueOf(bizParentTypeEnum.getType()));
        apiParams.putPostData("parentId", obj2);
        apiParams.putPostData("parentType", Integer.valueOf(bizParentTypeEnum2.getType()));
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O00000o0(Object obj, BizParentTypeEnum bizParentTypeEnum, Object obj2, BizParentTypeEnum bizParentTypeEnum2, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.device.relation.save", "1.0");
        apiParams.putPostData("bizId", obj);
        apiParams.putPostData("bizType", Integer.valueOf(bizParentTypeEnum.getType()));
        apiParams.putPostData("parentId", obj2);
        apiParams.putPostData("parentType", Integer.valueOf(bizParentTypeEnum2.getType()));
        asyncRequest(apiParams, Boolean.class, resultListener);
    }
}
