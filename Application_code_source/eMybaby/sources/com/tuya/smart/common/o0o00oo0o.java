package com.tuya.smart.common;

import a.a.a.a.a;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tuya.sdk.home.bean.DeviceSortResponseBean;
import com.tuya.sdk.home.bean.HomeResponseBean;
import com.tuya.sdk.home.bean.TuyaListDataBean;
import com.tuya.sdk.home.cache.TuyaHomeRelationCacheManager;
import com.tuya.smart.android.base.utils.PreferencesUtil;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.mvp.model.BaseModel;
import com.tuya.smart.home.sdk.bean.HomeBean;
import com.tuya.smart.interior.device.bean.DeviceRespBean;
import com.tuya.smart.interior.device.bean.GroupRespBean;
import com.tuya.smart.interior.enums.BizParentTypeEnum;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.bean.BlueMeshBean;
import com.tuya.smart.sdk.bean.ProductBean;
import com.tuya.smart.sdk.bean.SigMeshBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class o0o00oo0o extends BaseModel {
    public static final String O000000o = "s_home_list";
    public static final String O00000Oo = "s_home_data";
    public static final String O00000o0 = "HomeCacheModel";
    public static final String O00000oO = "m/ug/";
    public o0o000o0o O00000o = new o0o000o0o();
    public Handler O00000oo = new Handler(Looper.getMainLooper());

    public o0o00oo0o(Context context) {
        super(context);
    }

    private void O000000o() {
        TuyaHomeRelationCacheManager.O000000o().clearRelation();
    }

    private void O000000o(long j, JSONArray jSONArray) {
        if (jSONArray != null) {
            for (JSONObject jSONObject : (JSONObject[]) jSONArray.toArray(new JSONObject[0])) {
                for (JSONObject jSONObject2 : (JSONObject[]) jSONObject.getJSONObject("children").getJSONArray(String.valueOf(BizParentTypeEnum.ROOM.getType())).toArray(new JSONObject[0])) {
                    TuyaHomeRelationCacheManager.O000000o().addRoomToHome(j, jSONObject2.getLong("id").longValue());
                }
            }
        }
    }

    private void O000000o(long j, JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray(String.valueOf(BizParentTypeEnum.DEVICE.getType()));
        if (jSONArray != null) {
            for (JSONObject jSONObject2 : (JSONObject[]) jSONArray.toArray(new JSONObject[0])) {
                String string = jSONObject2.getString("id");
                int intValue = jSONObject2.getInteger("displayOrder").intValue();
                o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
                if (o0o00o00o0 != null) {
                    DeviceRespBean devRespBean = o0o00o00o0.O0000OOo().getDevRespBean(string);
                    if (devRespBean != null) {
                        devRespBean.setDisplayOrder(intValue);
                    } else {
                        L.e(O00000o0, "deviceRespBean ==null " + string);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void O000000o(final long j, final TuyaListDataBean tuyaListDataBean) {
        AsyncTask.execute(new Runnable() {
            public void run() {
                try {
                    String string = PreferencesUtil.getString(o0o00oo0o.O000000o);
                    ArrayList arrayList = new ArrayList();
                    if (!TextUtils.isEmpty(string)) {
                        List<HomeResponseBean> parseArray = JSON.parseArray(string, HomeResponseBean.class);
                        Iterator<HomeResponseBean> it = parseArray.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            HomeResponseBean next = it.next();
                            if (next.getGid() == tuyaListDataBean.getHomeResponseBean().getGid()) {
                                parseArray.remove(next);
                                break;
                            }
                        }
                        parseArray.add(tuyaListDataBean.getHomeResponseBean());
                    } else {
                        arrayList.add(tuyaListDataBean.getHomeResponseBean());
                        PreferencesUtil.set(o0o00oo0o.O000000o, JSON.toJSONString(arrayList));
                    }
                    PreferencesUtil.set(o0o00oo0o.O00000Oo + j, JSON.toJSONString(tuyaListDataBean));
                    L.d(o0o00oo0o.O00000o0, "saveLocalCache Success");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    private void O000000o(JSONArray jSONArray) {
        GroupRespBean O00000o02;
        if (jSONArray != null) {
            o0o00o00oo o0o00o00oo = (o0o00o00oo) Oo0.O000000o(o0o00o00oo.class);
            for (JSONObject jSONObject : (JSONObject[]) jSONArray.toArray(new JSONObject[0])) {
                String string = jSONObject.getString("id");
                JSONArray jSONArray2 = jSONObject.getJSONObject("children").getJSONArray(String.valueOf(BizParentTypeEnum.GROUP.getType()));
                if (jSONArray2 != null) {
                    for (JSONObject jSONObject2 : (JSONObject[]) jSONArray2.toArray(new JSONObject[0])) {
                        long longValue = jSONObject2.getLong("id").longValue();
                        TuyaHomeRelationCacheManager.O000000o().addGroupToMesh(string, longValue);
                        if (!(o0o00o00oo == null || (O00000o02 = o0o00o00oo.O000000o().O00000o0(longValue)) == null)) {
                            O00000o02.setLocalId(jSONObject2.getString("localId"));
                            O00000o02.setMeshId(jSONObject2.getString("meshId"));
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void O000000o(TuyaListDataBean tuyaListDataBean) {
        List<DeviceSortResponseBean> deviceSortResponseBeans = tuyaListDataBean.getDeviceSortResponseBeans();
        if (deviceSortResponseBeans != null) {
            o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
            o0o00o00oo o0o00o00oo = (o0o00o00oo) Oo0.O000000o(o0o00o00oo.class);
            for (DeviceSortResponseBean next : deviceSortResponseBeans) {
                if (o0o00o00oo != null && next.getBizType() == BizParentTypeEnum.GROUP.getType()) {
                    GroupRespBean O00000o02 = o0o00o00oo.O000000o().O00000o0(Long.valueOf(next.getBizId()).longValue());
                    if (O00000o02 != null) {
                        O00000o02.setHomeDisplayOrder(next.getHomeDisplayOrder());
                        O00000o02.setDisplayOrder(next.getDisplayOrder());
                    }
                    if (!"-1".endsWith(next.getRoomId())) {
                        TuyaHomeRelationCacheManager.O000000o().addGroupToRoom(Long.valueOf(next.getRoomId()).longValue(), Long.valueOf(next.getBizId()).longValue());
                    }
                } else if (o0o00o00o0 != null && next.getBizType() == BizParentTypeEnum.DEVICE.getType()) {
                    DeviceRespBean devRespBean = o0o00o00o0.O0000OOo().getDevRespBean(next.getBizId());
                    if (devRespBean != null) {
                        devRespBean.setHomeDisplayOrder(next.getHomeDisplayOrder());
                        devRespBean.setDisplayOrder(next.getDisplayOrder());
                    }
                    if (!next.getRoomId().endsWith("-1")) {
                        TuyaHomeRelationCacheManager.O000000o().addDevToRoom(Long.valueOf(next.getRoomId()).longValue(), next.getBizId());
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void O000000o(final TuyaListDataBean tuyaListDataBean, final o0o0oo000<HomeBean> o0o0oo000) {
        AsyncTask.execute(new Runnable() {
            public void run() {
                final HomeBean homeBean = null;
                try {
                    o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
                    o0o00o00oo o0o00o00oo = (o0o00o00oo) Oo0.O000000o(o0o00o00oo.class);
                    o0o000oooo o0o000oooo = (o0o000oooo) Oo0.O000000o(o0o000oooo.class);
                    if (!(tuyaListDataBean.getProductBeen() == null || o0o00o00o0 == null)) {
                        o0o00o00o0.O0000o00().addProductList(tuyaListDataBean.getProductBeen());
                    }
                    if (!(tuyaListDataBean.getDeviceRespShareList() == null || tuyaListDataBean.getDeviceRespShareList().size() <= 0 || o0o00o00o0 == null)) {
                        for (DeviceRespBean isShare : tuyaListDataBean.getDeviceRespShareList()) {
                            isShare.setIsShare(true);
                        }
                        o0o00o00o0.O0000o00().addDevList(tuyaListDataBean.getDeviceRespShareList());
                    }
                    if (!(tuyaListDataBean.getGroupRespShareList() == null || tuyaListDataBean.getGroupRespShareList().size() <= 0 || o0o00o00oo == null)) {
                        for (GroupRespBean share : tuyaListDataBean.getGroupRespShareList()) {
                            share.setShare(true);
                        }
                        o0o00o00oo.O000000o().O00000Oo(tuyaListDataBean.getGroupRespShareList());
                    }
                    if (!(tuyaListDataBean.getDeviceRespBeen() == null || o0o00o00o0 == null)) {
                        o0o00o00o0.O0000o00().addDevList(tuyaListDataBean.getDeviceRespBeen());
                    }
                    if (!(tuyaListDataBean.getGroupBeen() == null || o0o00o00oo == null)) {
                        o0o00o00oo.O000000o().O00000Oo(tuyaListDataBean.getGroupBeen());
                    }
                    if (!(tuyaListDataBean.getMeshBeen() == null || o0o000oooo == null)) {
                        o0o000oooo.O000000o().updateBuleMesh(tuyaListDataBean.getMeshBeen());
                    }
                    if (!(tuyaListDataBean.getSigMeshBeen() == null || o0o000oooo == null)) {
                        o0o000oooo.O00000Oo().updateSigMesh(tuyaListDataBean.getSigMeshBeen());
                    }
                    HomeBean O000000o2 = o0o0oooo0.O000000o(tuyaListDataBean.getHomeResponseBean());
                    o0o00o0o0.O000000o().O000000o(O000000o2.getRooms());
                    TuyaHomeRelationCacheManager.O000000o().putHomeBean(O000000o2);
                    o0o00oo0o.this.O00000Oo(O000000o2.getHomeId(), tuyaListDataBean);
                    if (!TextUtils.isEmpty(tuyaListDataBean.getRelation())) {
                        try {
                            L.d(o0o00oo0o.O00000o0, "data: " + tuyaListDataBean.getRelation());
                            o0o00oo0o.this.O000000o(tuyaListDataBean.getRelation(), O000000o2.getHomeId(), tuyaListDataBean);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    homeBean = TuyaHomeRelationCacheManager.O000000o().getHomeBean(O000000o2.getHomeId());
                    o0o00oo0o.this.O000000o(tuyaListDataBean);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                o0o00oo0o.this.O00000oo.post(new Runnable() {
                    public void run() {
                        HomeBean homeBean = homeBean;
                        if (homeBean != null) {
                            o0o0oo000 o0o0oo000 = o0o0oo000;
                            if (o0o0oo000 != null) {
                                o0o0oo000.O000000o(homeBean);
                                return;
                            }
                            return;
                        }
                        o0o0oo000 o0o0oo0002 = o0o0oo000;
                        if (o0o0oo0002 != null) {
                            o0o0oo0002.O000000o("failure", "code");
                        }
                    }
                });
            }
        });
    }

    private void O000000o(Long l, JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray(String.valueOf(BizParentTypeEnum.DEVICE.getType()));
        if (jSONArray != null) {
            for (JSONObject jSONObject2 : (JSONObject[]) jSONArray.toArray(new JSONObject[0])) {
                String string = jSONObject2.getString("id");
                jSONObject2.getInteger("displayOrder").intValue();
                TuyaHomeRelationCacheManager.O000000o().addDevToGroup(l.longValue(), string);
            }
        }
    }

    /* access modifiers changed from: private */
    public void O000000o(String str, long j, TuyaListDataBean tuyaListDataBean) {
        int i;
        JSONObject[] jSONObjectArr;
        int i2;
        JSONObject[] jSONObjectArr2;
        long j2 = j;
        o0o00o00oo o0o00o00oo = (o0o00o00oo) Oo0.O000000o(o0o00o00oo.class);
        JSONObject parseObject = JSON.parseObject(str);
        O000000o(j2, parseObject.getJSONArray(String.valueOf(BizParentTypeEnum.LOCATION.getType())));
        O000000o(parseObject.getJSONArray(String.valueOf(BizParentTypeEnum.MESH.getType())));
        JSONArray jSONArray = parseObject.getJSONArray(String.valueOf(BizParentTypeEnum.ROOM.getType()));
        int i3 = 0;
        if (jSONArray != null) {
            JSONObject[] jSONObjectArr3 = (JSONObject[]) jSONArray.toArray(new JSONObject[0]);
            int length = jSONObjectArr3.length;
            int i4 = 0;
            while (i4 < length) {
                JSONObject jSONObject = jSONObjectArr3[i4];
                Long l = jSONObject.getLong("id");
                if (l != null) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("children");
                    JSONArray jSONArray2 = jSONObject2.getJSONArray(String.valueOf(BizParentTypeEnum.GROUP.getType()));
                    if (!(jSONArray2 == null || tuyaListDataBean.getGroupBeen() == null)) {
                        JSONObject[] jSONObjectArr4 = (JSONObject[]) jSONArray2.toArray(new JSONObject[i3]);
                        int length2 = jSONObjectArr4.length;
                        while (i3 < length2) {
                            JSONObject[] jSONObjectArr5 = jSONObjectArr3;
                            JSONObject jSONObject3 = jSONObjectArr4[i3];
                            Long l2 = jSONObject3.getLong("id");
                            int i5 = length;
                            if (o0o00o00oo != null) {
                                jSONObjectArr2 = jSONObjectArr4;
                                i2 = length2;
                                GroupRespBean O00000o02 = o0o00o00oo.O000000o().O00000o0(l2.longValue());
                                if (!(O00000o02 == null || jSONObject3.getString("localId") == null)) {
                                    O00000o02.setLocalId(jSONObject3.getString("localId"));
                                }
                            } else {
                                jSONObjectArr2 = jSONObjectArr4;
                                i2 = length2;
                            }
                            i3++;
                            jSONObjectArr3 = jSONObjectArr5;
                            length = i5;
                            jSONObjectArr4 = jSONObjectArr2;
                            length2 = i2;
                        }
                    }
                    jSONObjectArr = jSONObjectArr3;
                    i = length;
                    O000000o(l.longValue(), jSONObject2);
                } else {
                    jSONObjectArr = jSONObjectArr3;
                    i = length;
                }
                i4++;
                jSONObjectArr3 = jSONObjectArr;
                length = i;
                i3 = 0;
            }
        }
        JSONArray jSONArray3 = parseObject.getJSONArray(String.valueOf(BizParentTypeEnum.GROUP.getType()));
        if (jSONArray3 != null) {
            for (JSONObject jSONObject4 : (JSONObject[]) jSONArray3.toArray(new JSONObject[0])) {
                Long l3 = jSONObject4.getLong("id");
                if (l3 != null) {
                    JSONObject jSONObject5 = jSONObject4.getJSONObject("children");
                    TuyaHomeRelationCacheManager.O000000o().addGroupToHome(j2, l3.longValue());
                    if (o0o00o00oo != null) {
                        GroupRespBean O00000o03 = o0o00o00oo.O000000o().O00000o0(l3.longValue());
                        if (!(O00000o03 == null || jSONObject4.getString("localId") == null)) {
                            O00000o03.setLocalId(jSONObject4.getString("localId"));
                        }
                        O000000o(l3, jSONObject5);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void O00000Oo(long j, TuyaListDataBean tuyaListDataBean) {
        DeviceRespBean devRespBean;
        if (tuyaListDataBean.getMeshBeen() != null && tuyaListDataBean.getMeshBeen().size() > 0) {
            for (BlueMeshBean meshId : tuyaListDataBean.getMeshBeen()) {
                TuyaHomeRelationCacheManager.O000000o().addMeshToHome(j, meshId.getMeshId());
            }
        }
        if (tuyaListDataBean.getSigMeshBeen() != null && tuyaListDataBean.getSigMeshBeen().size() > 0) {
            for (SigMeshBean meshId2 : tuyaListDataBean.getSigMeshBeen()) {
                TuyaHomeRelationCacheManager.O000000o().addMeshToHome(j, meshId2.getMeshId());
            }
        }
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        if (tuyaListDataBean.getDeviceRespBeen() != null && tuyaListDataBean.getDeviceRespBeen().size() > 0) {
            for (DeviceRespBean next : tuyaListDataBean.getDeviceRespBeen()) {
                TuyaHomeRelationCacheManager.O000000o().addDevToHome(j, next.getDevId());
                if (!TextUtils.isEmpty(next.getMeshId())) {
                    TuyaHomeRelationCacheManager.O000000o().addDevToMesh(next.getMeshId(), next.getDevId());
                    if (!(o0o00o00o0 == null || (devRespBean = o0o00o00o0.O0000OOo().getDevRespBean(next.getMeshId())) == null || TextUtils.isEmpty(devRespBean.getMeshId()))) {
                        TuyaHomeRelationCacheManager.O000000o().addDevToMesh(devRespBean.getMeshId(), next.getDevId());
                    }
                }
            }
        }
        TuyaHomeRelationCacheManager.O000000o().resetShareNode();
        if (tuyaListDataBean.getDeviceRespShareList() != null && tuyaListDataBean.getDeviceRespShareList().size() > 0) {
            for (DeviceRespBean devId : tuyaListDataBean.getDeviceRespShareList()) {
                TuyaHomeRelationCacheManager.O000000o().addShareDevToPersonal(devId.getDevId());
            }
        }
        if (tuyaListDataBean.getGroupRespShareList() != null && tuyaListDataBean.getGroupRespShareList().size() > 0) {
            for (GroupRespBean id : tuyaListDataBean.getGroupRespShareList()) {
                TuyaHomeRelationCacheManager.O000000o().addShareGroupToPersonal(id.getId());
            }
        }
        if (tuyaListDataBean.getGroupBeen() != null && tuyaListDataBean.getGroupBeen().size() > 0) {
            for (GroupRespBean id2 : tuyaListDataBean.getGroupBeen()) {
                TuyaHomeRelationCacheManager.O000000o().addGroupToHome(j, id2.getId());
            }
        }
    }

    public void O000000o(long j, final o0o0oo000<Boolean> o0o0oo000) {
        this.O00000o.O000000o(j, (o0o0oo000<TuyaListDataBean>) new o0o0oo000<TuyaListDataBean>() {
            public void O000000o(TuyaListDataBean tuyaListDataBean) {
                if (tuyaListDataBean != null) {
                    o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
                    if (!(tuyaListDataBean.getProductBeen() == null || o0o00o00o0 == null)) {
                        o0o00o00o0.O0000o00().addProductList(tuyaListDataBean.getProductBeen());
                    }
                    if (!(tuyaListDataBean.getDeviceRespBeen() == null || o0o00o00o0 == null)) {
                        o0o00o00o0.O0000o00().addDevList(tuyaListDataBean.getDeviceRespBeen());
                    }
                    o0o0oo000 o0o0oo000 = o0o0oo000;
                    if (o0o0oo000 != null) {
                        o0o0oo000.O000000o(Boolean.TRUE);
                        return;
                    }
                    return;
                }
                o0o0oo000 o0o0oo0002 = o0o0oo000;
                if (o0o0oo0002 != null) {
                    o0o0oo0002.O000000o("10011", "data is error");
                }
            }

            public void O000000o(String str, String str2) {
                o0o0oo000 o0o0oo000 = o0o0oo000;
                if (o0o0oo000 != null) {
                    o0o0oo000.O000000o(str, str2);
                }
            }
        });
    }

    public void O000000o(long j, List<DeviceRespBean> list, List<ProductBean> list2) {
        String string = PreferencesUtil.getString(O00000Oo + j);
        if (!TextUtils.isEmpty(string)) {
            if (L.getLogStatus()) {
                a.v("cache data: ", string, O00000o0);
            }
            TuyaListDataBean tuyaListDataBean = (TuyaListDataBean) JSON.parseObject(string, TuyaListDataBean.class);
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            for (DeviceRespBean next : list) {
                for (DeviceRespBean next2 : tuyaListDataBean.getDeviceRespBeen()) {
                    if (TextUtils.equals(next2.getDevId(), next.getDevId())) {
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(next2);
                    }
                }
            }
            if (arrayList2 != null) {
                tuyaListDataBean.getDeviceRespBeen().removeAll(arrayList2);
            }
            tuyaListDataBean.getDeviceRespBeen().addAll(list);
            for (ProductBean next3 : list2) {
                for (ProductBean next4 : tuyaListDataBean.getProductBeen()) {
                    if (TextUtils.equals(next4.getId(), next3.getId())) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(next4);
                    }
                }
            }
            if (arrayList != null) {
                tuyaListDataBean.getProductBeen().removeAll(arrayList);
            }
            tuyaListDataBean.getProductBeen().addAll(list2);
            O000000o(j, tuyaListDataBean);
        }
    }

    public void O00000Oo(final long j, final o0o0oo000<HomeBean> o0o0oo000) {
        o0o00o0oo0 o0o00o0oo0 = (o0o00o0oo0) Oo0.O000000o(o0o00o0oo0.class);
        if (o0o00o0oo0 != null) {
            o0oo0oo000 O000000o2 = o0o00o0oo0.O000000o();
            O000000o2.O00000Oo("m/ug/" + j, (IResultCallback) null);
        }
        this.O00000o.O00000Oo(j, new o0o0oo000<TuyaListDataBean>() {
            public void O000000o(TuyaListDataBean tuyaListDataBean) {
                L.d(o0o00oo0o.O00000o0, "getHomeDetailInfo Success");
                o0o00oo0o.this.O000000o(tuyaListDataBean, (o0o0oo000<HomeBean>) o0o0oo000);
                o0o00oo0o.this.O000000o(j, tuyaListDataBean);
            }

            public void O000000o(String str, String str2) {
                if (TextUtils.equals(str, o0O00O0o.O00000o)) {
                    o0o00oo00.O000000o(j);
                }
                o0o0oo000 o0o0oo000 = o0o0oo000;
                if (o0o0oo000 != null) {
                    o0o0oo000.O000000o(str, str2);
                }
            }
        });
    }

    public void O00000o0(long j, final o0o0oo000<HomeBean> o0o0oo000) {
        String string = PreferencesUtil.getString(O00000Oo + j);
        if (!TextUtils.isEmpty(string)) {
            if (L.getLogStatus()) {
                a.v("cache data: ", string, O00000o0);
            }
            O000000o((TuyaListDataBean) JSON.parseObject(string, TuyaListDataBean.class), (o0o0oo000<HomeBean>) new o0o0oo000<HomeBean>() {
                public void O000000o(HomeBean homeBean) {
                    o0o0oo000 o0o0oo000 = o0o0oo000;
                    if (o0o0oo000 != null) {
                        o0o0oo000.O000000o(homeBean);
                    }
                }

                public void O000000o(String str, String str2) {
                    o0o0oo000 o0o0oo000 = o0o0oo000;
                    if (o0o0oo000 != null) {
                        o0o0oo000.O000000o("get_home_cache_failure", str2);
                    }
                }
            });
            return;
        }
        o0o0oo000.O000000o(new HomeBean());
    }

    public void onDestroy() {
        this.O00000o.onDestroy();
    }
}
