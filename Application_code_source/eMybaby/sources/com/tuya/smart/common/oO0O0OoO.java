package com.tuya.smart.common;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.tuya.smart.android.device.bean.GroupDeviceRespBean;
import com.tuya.smart.android.device.bean.SchemaBean;
import com.tuya.smart.android.hardware.bean.HgwBean;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.interior.device.bean.DeviceRespBean;
import com.tuya.smart.interior.device.bean.GroupRespBean;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.GroupBean;
import com.tuya.smart.sdk.bean.ProductBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class oO0O0OoO implements o0o0o000oo {
    public static final String O000000o = "DeviceDataManager";
    public o00000 O00000Oo = new o00000();
    public o0000 O00000o0 = new o0000();

    /* access modifiers changed from: private */
    public void O00000o(List<GroupRespBean> list, ITuyaDataCallback<List<GroupBean>> iTuyaDataCallback) {
        o0O000Oo.O000000o().O00000Oo(list);
        ArrayList arrayList = new ArrayList();
        for (GroupRespBean id : list) {
            arrayList.add(o0O000Oo.O000000o().O000000o(id.getId()));
        }
        if (iTuyaDataCallback != null) {
            iTuyaDataCallback.onSuccess(arrayList);
        }
    }

    /* access modifiers changed from: private */
    public void O00000o0(List<DeviceRespBean> list, ITuyaDataCallback<List<DeviceBean>> iTuyaDataCallback) {
        oO00O0o0.O000000o().O00000Oo(list);
        ArrayList arrayList = new ArrayList();
        for (DeviceRespBean devId : list) {
            arrayList.add(oO00O0o0.O000000o().O00000Oo(devId.getDevId()));
        }
        if (iTuyaDataCallback != null) {
            iTuyaDataCallback.onSuccess(arrayList);
        }
    }

    public void O000000o() {
        this.O00000Oo.onDestroy();
        this.O00000o0.onDestroy();
    }

    public void O000000o(DeviceRespBean deviceRespBean, final ITuyaDataCallback<DeviceBean> iTuyaDataCallback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(deviceRespBean);
        O000000o((List<DeviceRespBean>) arrayList, (ITuyaDataCallback<List<DeviceBean>>) new ITuyaDataCallback<List<DeviceBean>>() {
            /* renamed from: O000000o */
            public void onSuccess(List<DeviceBean> list) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onSuccess(list.get(0));
                }
            }

            public void onError(String str, String str2) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onError(str, str2);
                }
            }
        });
    }

    public void O000000o(final GroupBean groupBean, final ITuyaDataCallback<GroupBean> iTuyaDataCallback) {
        if (groupBean.getType() == 0) {
            this.O00000o0.O000000o(-1, groupBean.getId(), groupBean.getProductId(), (Business.ResultListener<ArrayList<GroupDeviceRespBean>>) new Business.ResultListener<ArrayList<GroupDeviceRespBean>>() {
                /* renamed from: O000000o */
                public void onFailure(BusinessResponse businessResponse, ArrayList<GroupDeviceRespBean> arrayList, String str) {
                    ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                    if (iTuyaDataCallback != null) {
                        iTuyaDataCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                    }
                }

                /* renamed from: O00000Oo */
                public void onSuccess(BusinessResponse businessResponse, ArrayList<GroupDeviceRespBean> arrayList, String str) {
                    if (iTuyaDataCallback != null) {
                        o0o00o0o0o o0o00o0o0o = (o0o00o0o0o) Oo0.O000000o(o0o00o0o0o.class);
                        Iterator<GroupDeviceRespBean> it = arrayList.iterator();
                        while (it.hasNext()) {
                            GroupDeviceRespBean next = it.next();
                            if (o0o00o0o0o != null && next.isChecked()) {
                                o0o00o0o0o.O00000o0().addDevToGroup(groupBean.getId(), next.getDevId());
                            }
                        }
                        iTuyaDataCallback.onSuccess(groupBean);
                    }
                }
            });
        } else if (groupBean.getType() == 2) {
            this.O00000o0.O000000o(-1, groupBean.getId(), groupBean.getProductId(), groupBean.getMeshId(), (Business.ResultListener<ArrayList<GroupDeviceRespBean>>) new Business.ResultListener<ArrayList<GroupDeviceRespBean>>() {
                /* renamed from: O000000o */
                public void onFailure(BusinessResponse businessResponse, ArrayList<GroupDeviceRespBean> arrayList, String str) {
                    ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                    if (iTuyaDataCallback != null) {
                        iTuyaDataCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                    }
                }

                /* renamed from: O00000Oo */
                public void onSuccess(BusinessResponse businessResponse, ArrayList<GroupDeviceRespBean> arrayList, String str) {
                    if (iTuyaDataCallback != null) {
                        o0o00o0o0o o0o00o0o0o = (o0o00o0o0o) Oo0.O000000o(o0o00o0o0o.class);
                        Iterator<GroupDeviceRespBean> it = arrayList.iterator();
                        while (it.hasNext()) {
                            GroupDeviceRespBean next = it.next();
                            if (o0o00o0o0o != null && next.isChecked()) {
                                o0o00o0o0o.O00000o0().addDevToGroup(groupBean.getId(), next.getDevId());
                            }
                        }
                        iTuyaDataCallback.onSuccess(groupBean);
                    }
                }
            });
        } else {
            iTuyaDataCallback.onSuccess(groupBean);
        }
    }

    public void O000000o(Long l, final ITuyaDataCallback<GroupBean> iTuyaDataCallback) {
        this.O00000o0.O000000o(l, (Business.ResultListener<GroupRespBean>) new Business.ResultListener<GroupRespBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, GroupRespBean groupRespBean, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, GroupRespBean groupRespBean, String str) {
                ArrayList arrayList = new ArrayList();
                groupRespBean.setResptime(businessResponse.getT());
                arrayList.add(groupRespBean);
                oO0O0OoO.this.O00000Oo((List<GroupRespBean>) arrayList, (ITuyaDataCallback<List<GroupBean>>) new ITuyaDataCallback<List<GroupBean>>() {
                    /* renamed from: O000000o */
                    public void onSuccess(List<GroupBean> list) {
                        ITuyaDataCallback iTuyaDataCallback;
                        if (iTuyaDataCallback == null || list.size() <= 0) {
                            iTuyaDataCallback = iTuyaDataCallback;
                            if (iTuyaDataCallback == null) {
                                return;
                            }
                        } else if (list.get(0) == null) {
                            iTuyaDataCallback = iTuyaDataCallback;
                        } else {
                            oO0O0OoO.this.O000000o(list.get(0), (ITuyaDataCallback<GroupBean>) iTuyaDataCallback);
                            return;
                        }
                        iTuyaDataCallback.onError("group", "group is null");
                    }

                    public void onError(String str, String str2) {
                        ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                        if (iTuyaDataCallback != null) {
                            iTuyaDataCallback.onError(str, str2);
                        }
                    }
                });
            }
        });
    }

    public void O000000o(String str, final ITuyaDataCallback<DeviceBean> iTuyaDataCallback) {
        DeviceBean O00000Oo2 = oO00O0o0.O000000o().O00000Oo(str);
        if (O00000Oo2 == null || TextUtils.isEmpty(O00000Oo2.getNodeId()) || TextUtils.isEmpty(O00000Oo2.getMeshId())) {
            this.O00000Oo.O00000Oo(str, new Business.ResultListener<DeviceRespBean>() {
                /* renamed from: O000000o */
                public void onFailure(BusinessResponse businessResponse, DeviceRespBean deviceRespBean, String str) {
                    ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                    if (iTuyaDataCallback != null) {
                        iTuyaDataCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                    }
                }

                /* renamed from: O00000Oo */
                public void onSuccess(BusinessResponse businessResponse, DeviceRespBean deviceRespBean, String str) {
                    deviceRespBean.setResptime(businessResponse.getT());
                    oO0O0OoO.this.O000000o(deviceRespBean, (ITuyaDataCallback<DeviceBean>) iTuyaDataCallback);
                }
            });
        } else {
            O000000o(O00000Oo2.getMeshId(), str, iTuyaDataCallback);
        }
    }

    public void O000000o(String str, String str2) {
        this.O00000Oo.O00000Oo(str2);
        this.O00000Oo.O000000o(str);
    }

    public void O000000o(final String str, String str2, final ITuyaDataCallback<DeviceBean> iTuyaDataCallback) {
        this.O00000Oo.O000000o(str, str2, new Business.ResultListener<DeviceRespBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, DeviceRespBean deviceRespBean, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, DeviceRespBean deviceRespBean, String str) {
                deviceRespBean.setMeshId(str);
                deviceRespBean.setResptime(businessResponse.getT());
                oO0O0OoO.this.O000000o(deviceRespBean, (ITuyaDataCallback<DeviceBean>) iTuyaDataCallback);
            }
        });
    }

    public void O000000o(final List<DeviceRespBean> list, final ITuyaDataCallback<List<DeviceBean>> iTuyaDataCallback) {
        ArrayList arrayList = new ArrayList();
        for (DeviceRespBean next : list) {
            if (oO0O00Oo.O000000o().O000000o(next.getProductId()) == null) {
                arrayList.add(next.getProductId());
            }
        }
        if (arrayList.isEmpty()) {
            O00000o0(list, iTuyaDataCallback);
        } else {
            this.O00000Oo.O000000o((List<String>) arrayList, (Business.ResultListener<ArrayList<ProductBean>>) new Business.ResultListener<ArrayList<ProductBean>>() {
                /* renamed from: O000000o */
                public void onFailure(BusinessResponse businessResponse, ArrayList<ProductBean> arrayList, String str) {
                    ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                    if (iTuyaDataCallback != null) {
                        iTuyaDataCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                    }
                }

                /* renamed from: O00000Oo */
                public void onSuccess(BusinessResponse businessResponse, ArrayList<ProductBean> arrayList, String str) {
                    oO0O00Oo.O000000o().O00000Oo(arrayList);
                    oO0O0OoO.this.O00000o0(list, iTuyaDataCallback);
                }
            });
        }
    }

    public boolean O000000o(HgwBean hgwBean) {
        return oO00O0o0.O000000o().O000000o(hgwBean);
    }

    public boolean O000000o(String str) {
        return oO00O0o0.O000000o().O000000o(str);
    }

    public Object O00000Oo(String str, String str2) {
        Map<String, Object> O00000o02 = O00000o0(str);
        if (O00000o02 == null) {
            return null;
        }
        return O00000o02.get(str2);
    }

    public List<DeviceBean> O00000Oo() {
        return oO00O0o0.O000000o().O00000o0();
    }

    public Map<String, SchemaBean> O00000Oo(String str) {
        ProductBean O000000o2;
        ProductBean.SchemaInfo schemaInfo;
        DeviceRespBean O00000o02 = oO00O0o0.O000000o().O00000o0(str);
        if (O00000o02 == null || (O000000o2 = oO0O00Oo.O000000o().O000000o(O00000o02.getProductId())) == null || (schemaInfo = O000000o2.getSchemaInfo()) == null) {
            return null;
        }
        return schemaInfo.getSchemaMap();
    }

    public void O00000Oo(final String str, final ITuyaDataCallback<List<DeviceBean>> iTuyaDataCallback) {
        this.O00000Oo.O000000o(str, (Business.ResultListener<ArrayList<DeviceRespBean>>) new Business.ResultListener<ArrayList<DeviceRespBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<DeviceRespBean> arrayList, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<DeviceRespBean> arrayList, String str) {
                if (iTuyaDataCallback != null) {
                    Iterator<DeviceRespBean> it = arrayList.iterator();
                    while (it.hasNext()) {
                        DeviceRespBean next = it.next();
                        next.setMeshId(str);
                        next.setResptime(businessResponse.getT());
                    }
                    oO0O0OoO.this.O000000o((List<DeviceRespBean>) arrayList, (ITuyaDataCallback<List<DeviceBean>>) iTuyaDataCallback);
                }
            }
        });
    }

    public void O00000Oo(final List<GroupRespBean> list, final ITuyaDataCallback<List<GroupBean>> iTuyaDataCallback) {
        ArrayList arrayList = new ArrayList();
        for (GroupRespBean next : list) {
            if (oO0O00Oo.O000000o().O000000o(next.getProductId()) == null) {
                arrayList.add(next.getProductId());
            }
        }
        if (arrayList.isEmpty()) {
            O00000o(list, iTuyaDataCallback);
        } else {
            this.O00000Oo.O000000o((List<String>) arrayList, (Business.ResultListener<ArrayList<ProductBean>>) new Business.ResultListener<ArrayList<ProductBean>>() {
                /* renamed from: O000000o */
                public void onFailure(BusinessResponse businessResponse, ArrayList<ProductBean> arrayList, String str) {
                    ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                    if (iTuyaDataCallback != null) {
                        iTuyaDataCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                    }
                }

                /* renamed from: O00000Oo */
                public void onSuccess(BusinessResponse businessResponse, ArrayList<ProductBean> arrayList, String str) {
                    oO0O00Oo.O000000o().O00000Oo(arrayList);
                    oO0O0OoO.this.O00000o(list, iTuyaDataCallback);
                }
            });
        }
    }

    public DeviceBean O00000o(String str) {
        return oO00O0o0.O000000o().O00000Oo(str);
    }

    public Map<String, Object> O00000o0(String str) {
        DeviceRespBean O00000o02 = oO00O0o0.O000000o().O00000o0(str);
        if (O00000o02 == null) {
            return null;
        }
        return O00000o02.getDps();
    }

    public void O00000oO(final String str) {
        this.O00000Oo.O00000o0(str, new Business.ResultListener<Object>() {
            public void onFailure(BusinessResponse businessResponse, Object obj, String str) {
            }

            public void onSuccess(BusinessResponse businessResponse, Object obj, String str) {
                String str2 = str;
                oO0O0Oo0.O000000o(str2, str2, JSON.toJSONString(obj), true);
            }
        });
    }
}
