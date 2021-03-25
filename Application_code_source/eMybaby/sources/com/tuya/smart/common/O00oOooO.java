package com.tuya.smart.common;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.tuya.smart.android.base.ApiParams;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.interior.enums.BizParentTypeEnum;
import com.tuya.smart.sdk.bean.BlueMeshGroupBean;
import com.tuya.smart.sdk.bean.BlueMeshRelationDevBean;
import com.tuya.smart.sdk.bean.BlueMeshRoomBean;
import com.tuya.smart.sdk.bean.BlueMeshSubDevBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class O00oOooO extends Business {
    public static final String O000000o = "tuya.m.device.relations.selected.save";
    public static final String O00000Oo = "tuya.m.device.relation.add";
    public static final String O00000o0 = "tuya.m.device.relation.delete";

    public static O00OOOo O000000o(Map<String, Object> map) {
        O00OOOo o00OOOo = new O00OOOo();
        for (Map.Entry next : map.entrySet()) {
            if (TextUtils.equals((CharSequence) next.getKey(), String.valueOf(BizParentTypeEnum.DEVICE.getType()))) {
                ArrayList arrayList = new ArrayList();
                for (BlueMeshRelationDevBean next2 : JSON.parseArray(JSON.toJSONString(next.getValue()), BlueMeshRelationDevBean.class)) {
                    BlueMeshSubDevBean blueMeshSubDevBean = new BlueMeshSubDevBean();
                    blueMeshSubDevBean.setDevId(next2.getId());
                    blueMeshSubDevBean.setName(next2.getName());
                    blueMeshSubDevBean.setNodeId(next2.getNodeId());
                    arrayList.add(blueMeshSubDevBean);
                }
                o00OOOo.O000000o((List<BlueMeshSubDevBean>) arrayList);
            } else if (TextUtils.equals((CharSequence) next.getKey(), String.valueOf(BizParentTypeEnum.GROUP.getType()))) {
                o00OOOo.O00000Oo(JSON.parseArray(JSON.toJSONString(next.getValue()), BlueMeshGroupBean.class));
            } else if (TextUtils.equals((CharSequence) next.getKey(), String.valueOf(BizParentTypeEnum.ROOM.getType()))) {
                o00OOOo.O00000o0(JSON.parseArray(JSON.toJSONString(next.getValue()), BlueMeshRoomBean.class));
            }
        }
        return o00OOOo;
    }

    public void O000000o(Object obj, int i, Business.ResultListener<Map<String, Object>> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.device.relation.entity.list", "1.0");
        apiParams.putPostData("parentId", obj);
        apiParams.putPostData("parentType", Integer.valueOf(i));
        asyncHashMap(apiParams, Object.class, resultListener);
    }

    public void O000000o(Object obj, int i, Object obj2, int i2, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.device.relation.add", "1.0");
        apiParams.putPostData("bizId", obj);
        apiParams.putPostData("bizType", Integer.valueOf(i));
        apiParams.putPostData("parentId", obj2);
        apiParams.putPostData("parentType", Integer.valueOf(i2));
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O000000o(Object obj, BizParentTypeEnum bizParentTypeEnum, Object obj2, BizParentTypeEnum bizParentTypeEnum2, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.device.relations.selected.save", "1.0");
        apiParams.putPostData("bizIds", obj);
        apiParams.putPostData("bizType", Integer.valueOf(bizParentTypeEnum.getType()));
        apiParams.putPostData("parentId", obj2);
        apiParams.putPostData("parentType", Integer.valueOf(bizParentTypeEnum2.getType()));
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O00000Oo(Object obj, int i, Object obj2, int i2, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.device.relation.delete", "1.0");
        apiParams.putPostData("bizId", obj);
        apiParams.putPostData("bizType", Integer.valueOf(i));
        apiParams.putPostData("parentId", obj2);
        apiParams.putPostData("parentType", Integer.valueOf(i2));
        asyncRequest(apiParams, Boolean.class, resultListener);
    }
}
