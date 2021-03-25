package com.tuya.smart.common;

import a.a.a.a.a;
import android.content.Context;
import android.text.TextUtils;
import com.tuya.smart.android.common.utils.SafeHandler;
import com.tuya.smart.android.mvp.model.BaseModel;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.interior.device.bean.DeviceRespBean;
import com.tuya.smart.interior.device.bean.GroupRespBean;
import com.tuya.smart.interior.enums.BizParentTypeEnum;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import com.tuya.smart.sdk.api.bluemesh.IAddGroupCallback;
import com.tuya.smart.sdk.api.bluemesh.IAddRoomCallback;
import com.tuya.smart.sdk.api.bluemesh.IAddSubDevCallback;
import com.tuya.smart.sdk.api.bluemesh.IBlueMeshCreateCallback;
import com.tuya.smart.sdk.api.bluemesh.IGetMeshRoomAndGroupListCallback;
import com.tuya.smart.sdk.api.bluemesh.ISigMeshCreateCallback;
import com.tuya.smart.sdk.bean.BlueMeshBean;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.SigMeshBean;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class O0000OOo extends BaseModel implements O0000Oo {
    public static final String O00000oO = "BlueMeshModel";
    public final O0000O0o O000000o;
    public final O000O00o O00000Oo;
    public O00oOooO O00000o = new O00oOooO();
    public O00000o O00000o0;

    public O0000OOo(Context context, SafeHandler safeHandler) {
        super(context, safeHandler);
        O000000o();
        this.O000000o = new O0000O0o(context);
        this.O00000Oo = new O000O00o();
    }

    public void O000000o() {
        this.O00000o0 = new O00000o();
    }

    public void O000000o(long j, final ISigMeshCreateCallback iSigMeshCreateCallback) {
        this.O00000o0.O000000o(j, (Business.ResultListener<SigMeshBean>) new Business.ResultListener<SigMeshBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, SigMeshBean sigMeshBean, String str) {
                ISigMeshCreateCallback iSigMeshCreateCallback = iSigMeshCreateCallback;
                if (iSigMeshCreateCallback != null) {
                    iSigMeshCreateCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, SigMeshBean sigMeshBean, String str) {
                O000O0o0.O000000o().O000000o((BlueMeshBean) sigMeshBean);
                ISigMeshCreateCallback iSigMeshCreateCallback = iSigMeshCreateCallback;
                if (iSigMeshCreateCallback != null) {
                    iSigMeshCreateCallback.onSuccess(sigMeshBean);
                }
            }
        });
    }

    public void O000000o(long j, String str, final IBlueMeshCreateCallback iBlueMeshCreateCallback) {
        this.O00000o0.O000000o(j, str, (Business.ResultListener<BlueMeshBean>) new Business.ResultListener<BlueMeshBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, BlueMeshBean blueMeshBean, String str) {
                IBlueMeshCreateCallback iBlueMeshCreateCallback = iBlueMeshCreateCallback;
                if (iBlueMeshCreateCallback != null) {
                    iBlueMeshCreateCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, BlueMeshBean blueMeshBean, String str) {
                O000O0o0.O000000o().O000000o(blueMeshBean);
                IBlueMeshCreateCallback iBlueMeshCreateCallback = iBlueMeshCreateCallback;
                if (iBlueMeshCreateCallback != null) {
                    iBlueMeshCreateCallback.onSuccess(blueMeshBean);
                }
            }
        });
    }

    public void O000000o(String str, int i, final IGetMeshRoomAndGroupListCallback iGetMeshRoomAndGroupListCallback) {
        this.O00000o.O000000o(str, i, new Business.ResultListener<Map<String, Object>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Map<String, Object> map, String str) {
                IGetMeshRoomAndGroupListCallback iGetMeshRoomAndGroupListCallback = iGetMeshRoomAndGroupListCallback;
                if (iGetMeshRoomAndGroupListCallback != null) {
                    iGetMeshRoomAndGroupListCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Map<String, Object> map, String str) {
                if (iGetMeshRoomAndGroupListCallback != null) {
                    O00OOOo O000000o2 = O00oOooO.O000000o(map);
                    iGetMeshRoomAndGroupListCallback.onSuccess(O000000o2.O00000o0(), O000000o2.O00000Oo());
                }
            }
        });
    }

    public void O000000o(final String str, final IResultCallback iResultCallback) {
        this.O00000o0.O000000o(str, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                if (bool.booleanValue()) {
                    if (ooooo00oo.O000000o().getSigMeshBean(str) != null) {
                        oooo0o000.O000000o().O00000Oo(str);
                    } else {
                        O000O0o0.O000000o().O00000Oo(str);
                    }
                    IResultCallback iResultCallback = iResultCallback;
                    if (iResultCallback != null) {
                        iResultCallback.onSuccess();
                        return;
                    }
                    return;
                }
                IResultCallback iResultCallback2 = iResultCallback;
                if (iResultCallback2 != null) {
                    iResultCallback2.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }
        });
    }

    public void O000000o(String str, String str2, int i, final IAddRoomCallback iAddRoomCallback) {
        this.O00000Oo.O000000o(str, str2, i, new Business.ResultListener<Long>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Long l, String str) {
                IAddRoomCallback iAddRoomCallback = iAddRoomCallback;
                if (iAddRoomCallback != null) {
                    iAddRoomCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Long l, String str) {
                IAddRoomCallback iAddRoomCallback = iAddRoomCallback;
                if (iAddRoomCallback != null) {
                    iAddRoomCallback.onSuccess(l.longValue());
                }
            }
        });
    }

    public void O000000o(final String str, final String str2, final IResultCallback iResultCallback) {
        this.O00000o0.O000000o(str, str2, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                if (bool.booleanValue()) {
                    BlueMeshBean O000000o2 = O000O0o0.O000000o().O000000o(str);
                    if (O000000o2 != null) {
                        O000000o2.setName(str2);
                    }
                    IResultCallback iResultCallback = iResultCallback;
                    if (iResultCallback != null) {
                        iResultCallback.onSuccess();
                        return;
                    }
                    return;
                }
                IResultCallback iResultCallback2 = iResultCallback;
                if (iResultCallback2 != null) {
                    iResultCallback2.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }
        });
    }

    public void O000000o(String str, String str2, File file, IResultCallback iResultCallback) {
    }

    public void O000000o(String str, String str2, String str3, int i, String str4, int i2, IAddGroupCallback iAddGroupCallback) {
        final IAddGroupCallback iAddGroupCallback2 = iAddGroupCallback;
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        this.O00000o0.O000000o(str2, str, str3, BizParentTypeEnum.MESH.getType(), str4, i2, (Business.ResultListener<GroupRespBean>) new Business.ResultListener<GroupRespBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, GroupRespBean groupRespBean, String str) {
                IAddGroupCallback iAddGroupCallback = iAddGroupCallback2;
                if (iAddGroupCallback != null) {
                    iAddGroupCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, GroupRespBean groupRespBean, String str) {
                groupRespBean.setResptime(businessResponse.getT());
                groupRespBean.setName(str5);
                groupRespBean.setLocalId(str6);
                groupRespBean.setMeshId(str7);
                groupRespBean.setCategory(str8);
                o0o00o0o0o o0o00o0o0o = (o0o00o0o0o) Oo0.O000000o(o0o00o0o0o.class);
                if (o0o00o0o0o != null) {
                    o0o00o0o0o.O00000o().O000000o(str7, groupRespBean);
                }
                IAddGroupCallback iAddGroupCallback = iAddGroupCallback2;
                if (iAddGroupCallback != null) {
                    iAddGroupCallback.onSuccess(groupRespBean.getId());
                }
            }
        });
    }

    public void O000000o(String str, String str2, String str3, int i, String str4, IAddGroupCallback iAddGroupCallback) {
        final IAddGroupCallback iAddGroupCallback2 = iAddGroupCallback;
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        this.O00000o0.O000000o(str2, str, str3, BizParentTypeEnum.MESH.getType(), str4, (Business.ResultListener<Long>) new Business.ResultListener<Long>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Long l, String str) {
                IAddGroupCallback iAddGroupCallback = iAddGroupCallback2;
                if (iAddGroupCallback != null) {
                    iAddGroupCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Long l, String str) {
                GroupRespBean groupRespBean = new GroupRespBean();
                groupRespBean.setResptime(businessResponse.getT());
                groupRespBean.setId(l.longValue());
                groupRespBean.setName(str5);
                groupRespBean.setLocalId(str6);
                groupRespBean.setMeshId(str7);
                groupRespBean.setCategory(str8);
                o0o00o0o0o o0o00o0o0o = (o0o00o0o0o) Oo0.O000000o(o0o00o0o0o.class);
                if (o0o00o0o0o != null) {
                    o0o00o0o0o.O00000o().O000000o(str7, groupRespBean);
                }
                IAddGroupCallback iAddGroupCallback = iAddGroupCallback2;
                if (iAddGroupCallback != null) {
                    iAddGroupCallback.onSuccess(l.longValue());
                }
            }
        });
    }

    public void O000000o(String str, final String str2, final String str3, final IResultCallback iResultCallback) {
        this.O00000o0.O000000o(str, str2, str3, new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                if (bool.booleanValue()) {
                    DeviceRespBean O00000o02 = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O0000OoO().O00000o0(str2);
                    if (O00000o02 != null) {
                        O00000o02.setName(str3);
                    }
                    IResultCallback iResultCallback = iResultCallback;
                    if (iResultCallback != null) {
                        iResultCallback.onSuccess();
                        return;
                    }
                    return;
                }
                IResultCallback iResultCallback2 = iResultCallback;
                if (iResultCallback2 != null) {
                    iResultCallback2.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }
        });
    }

    public void O000000o(String str, String str2, String str3, String str4, int i, IResultCallback iResultCallback) {
        BlueMeshBean O000000o2 = O000O0o0.O000000o().O000000o(str);
        if (O000000o2 != null) {
            if (!TextUtils.isEmpty(str2)) {
                DeviceBean O00000o02 = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O0000OoO().O00000o0(str, str2);
                if (O00000o02 == null) {
                    if (iResultCallback != null) {
                        iResultCallback.onError("13003", "ble sub dev is not exist");
                        return;
                    }
                    return;
                } else if (!O00000o02.getIsOnline().booleanValue()) {
                    if (iResultCallback != null) {
                        iResultCallback.onError(o00oo0o0o0.O000O00o, "device is offline");
                        return;
                    }
                    return;
                }
            }
            this.O000000o.O000000o(str, str4, O000000o2.getLocalKey(), str3, str2, O000000o2.getPv(), i, iResultCallback);
        } else if (iResultCallback != null) {
            iResultCallback.onError("13003", "ble mesh is not exist");
        }
    }

    public void O000000o(String str, String str2, String str3, String str4, String str5, IAddSubDevCallback iAddSubDevCallback) {
        final IAddSubDevCallback iAddSubDevCallback2 = iAddSubDevCallback;
        final String str6 = str5;
        final String str7 = str3;
        final String str8 = str4;
        final String str9 = str;
        this.O00000o0.O000000o(str, str2, str3, str4, str5, (Business.ResultListener<DeviceRespBean>) new Business.ResultListener<DeviceRespBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, DeviceRespBean deviceRespBean, String str) {
                IAddSubDevCallback iAddSubDevCallback = iAddSubDevCallback2;
                if (iAddSubDevCallback != null) {
                    iAddSubDevCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, DeviceRespBean deviceRespBean, String str) {
                deviceRespBean.setDps(new LinkedHashMap());
                DeviceRespBean.DevModule devModule = new DeviceRespBean.DevModule();
                devModule.setIsOnline(true);
                devModule.setVerSw(str6);
                DeviceRespBean.ModuleMap moduleMap = new DeviceRespBean.ModuleMap();
                moduleMap.setBluetooth(devModule);
                deviceRespBean.setModuleMap(moduleMap);
                deviceRespBean.setNodeId(str7);
                deviceRespBean.setProductId(str8);
                deviceRespBean.setMeshId(str9);
                deviceRespBean.setResptime(businessResponse.getT());
                o0o0o000oo O0000Ooo = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O0000Ooo();
                ArrayList arrayList = new ArrayList();
                arrayList.add(deviceRespBean);
                O0000Ooo.O000000o((List<DeviceRespBean>) arrayList, (ITuyaDataCallback<List<DeviceBean>>) new ITuyaDataCallback<List<DeviceBean>>() {
                    /* renamed from: O000000o */
                    public void onSuccess(List<DeviceBean> list) {
                        if (iAddSubDevCallback2 != null && list != null && list.size() > 0) {
                            iAddSubDevCallback2.onSuccess(list.get(0));
                        }
                    }

                    public void onError(String str, String str2) {
                        IAddSubDevCallback iAddSubDevCallback = iAddSubDevCallback2;
                        if (iAddSubDevCallback != null) {
                            iAddSubDevCallback.onError(str, str2);
                        }
                    }
                });
            }
        });
    }

    public void O000000o(String str, String str2, String str3, String str4, String str5, String str6, IAddSubDevCallback iAddSubDevCallback) {
        final IAddSubDevCallback iAddSubDevCallback2 = iAddSubDevCallback;
        final String str7 = str6;
        final String str8 = str3;
        final String str9 = str5;
        final String str10 = str;
        this.O00000o0.O000000o(str, str2, str3, str4, str5, str6, (Business.ResultListener<DeviceRespBean>) new Business.ResultListener<DeviceRespBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, DeviceRespBean deviceRespBean, String str) {
                IAddSubDevCallback iAddSubDevCallback = iAddSubDevCallback2;
                if (iAddSubDevCallback != null) {
                    iAddSubDevCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, DeviceRespBean deviceRespBean, String str) {
                deviceRespBean.setDps(new LinkedHashMap());
                DeviceRespBean.DevModule devModule = new DeviceRespBean.DevModule();
                devModule.setIsOnline(true);
                devModule.setVerSw(str7);
                DeviceRespBean.ModuleMap moduleMap = new DeviceRespBean.ModuleMap();
                moduleMap.setBluetooth(devModule);
                deviceRespBean.setModuleMap(moduleMap);
                deviceRespBean.setNodeId(str8);
                deviceRespBean.setProductId(str9);
                deviceRespBean.setMeshId(str10);
                deviceRespBean.setResptime(businessResponse.getT());
                o0o0o000oo O0000Ooo = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O0000Ooo();
                ArrayList arrayList = new ArrayList();
                arrayList.add(deviceRespBean);
                O0000Ooo.O000000o((List<DeviceRespBean>) arrayList, (ITuyaDataCallback<List<DeviceBean>>) new ITuyaDataCallback<List<DeviceBean>>() {
                    /* renamed from: O000000o */
                    public void onSuccess(List<DeviceBean> list) {
                        if (iAddSubDevCallback2 != null && list != null && list.size() > 0) {
                            iAddSubDevCallback2.onSuccess(list.get(0));
                        }
                    }

                    public void onError(String str, String str2) {
                        IAddSubDevCallback iAddSubDevCallback = iAddSubDevCallback2;
                        if (iAddSubDevCallback != null) {
                            iAddSubDevCallback.onError(str, str2);
                        }
                    }
                });
            }
        });
    }

    public void O000000o(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, IAddSubDevCallback iAddSubDevCallback) {
        final IAddSubDevCallback iAddSubDevCallback2 = iAddSubDevCallback;
        final String str9 = str5;
        final String str10 = str3;
        final String str11 = str4;
        final String str12 = str;
        this.O00000o0.O000000o(str, str2, str3, str4, str5, str6, str7, str8, new Business.ResultListener<DeviceRespBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, DeviceRespBean deviceRespBean, String str) {
                IAddSubDevCallback iAddSubDevCallback = iAddSubDevCallback2;
                if (iAddSubDevCallback != null) {
                    iAddSubDevCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, DeviceRespBean deviceRespBean, String str) {
                deviceRespBean.setDps(new LinkedHashMap());
                DeviceRespBean.DevModule devModule = new DeviceRespBean.DevModule();
                devModule.setIsOnline(true);
                devModule.setVerSw(str9);
                DeviceRespBean.ModuleMap moduleMap = new DeviceRespBean.ModuleMap();
                moduleMap.setBluetooth(devModule);
                deviceRespBean.setModuleMap(moduleMap);
                deviceRespBean.setNodeId(str10);
                if (TextUtils.isEmpty(deviceRespBean.getProductId())) {
                    deviceRespBean.setProductId(str11);
                }
                deviceRespBean.setMeshId(str12);
                deviceRespBean.setResptime(businessResponse.getT());
                o0o0o000oo O0000Ooo = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O0000Ooo();
                ArrayList arrayList = new ArrayList();
                arrayList.add(deviceRespBean);
                O0000Ooo.O000000o((List<DeviceRespBean>) arrayList, (ITuyaDataCallback<List<DeviceBean>>) new ITuyaDataCallback<List<DeviceBean>>() {
                    /* renamed from: O000000o */
                    public void onSuccess(List<DeviceBean> list) {
                        StringBuilder n = a.n("getSchemaBean :");
                        n.append(list.size());
                        o00oo0oo00.O00000Oo(O0000OOo.O00000oO, n.toString());
                        if (iAddSubDevCallback2 != null && list.size() > 0) {
                            iAddSubDevCallback2.onSuccess(list.get(0));
                        }
                    }

                    public void onError(String str, String str2) {
                        IAddSubDevCallback iAddSubDevCallback = iAddSubDevCallback2;
                        if (iAddSubDevCallback != null) {
                            iAddSubDevCallback.onError(str, str2);
                        }
                    }
                });
            }
        });
    }

    public void O000000o(String str, String str2, List<Integer> list, IResultCallback iResultCallback) {
        BlueMeshBean O000000o2 = O000O0o0.O000000o().O000000o(str);
        if (O000000o2 != null) {
            DeviceBean O00000o02 = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O0000OoO().O00000o0(str, str2);
            if (O00000o02 != null) {
                Boolean isOnline = O00000o02.getIsOnline();
                if (isOnline != null && isOnline.booleanValue()) {
                    this.O000000o.O000000o(str, O00000o02.getPv(), O000000o2.getLocalKey(), str2, list, iResultCallback);
                } else if (iResultCallback != null) {
                    iResultCallback.onError(o00oo0o0o0.O000O00o, "device is offline");
                }
            } else if (iResultCallback != null) {
                iResultCallback.onError("13003", "ble sub dev is not exist");
            }
        } else if (iResultCallback != null) {
            iResultCallback.onError("13003", "ble mesh is not exist");
        }
    }

    public void O000000o(String str, byte[] bArr, IResultCallback iResultCallback) {
        BlueMeshBean O000000o2 = O000O0o0.O000000o().O000000o(str);
        if (O000000o2 != null) {
            this.O000000o.O000000o(str, O000000o2.getLocalKey(), bArr, O000000o2.getPv(), iResultCallback);
        } else if (iResultCallback != null) {
            iResultCallback.onError("13003", "ble mesh is not exist");
        }
    }

    public void O00000Oo(final String str, String str2, final IResultCallback iResultCallback) {
        o00oo0oo00.O000000o("SubDevCache", "dismissMeshSubDev");
        this.O00000o0.O00000Oo(str, str2, new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                if (bool.booleanValue()) {
                    ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O0000OoO().O000000o(str);
                    IResultCallback iResultCallback = iResultCallback;
                    if (iResultCallback != null) {
                        iResultCallback.onSuccess();
                        return;
                    }
                    return;
                }
                IResultCallback iResultCallback2 = iResultCallback;
                if (iResultCallback2 != null) {
                    iResultCallback2.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }
        });
    }

    public void O00000Oo(String str, String str2, String str3, String str4, int i, IResultCallback iResultCallback) {
        BlueMeshBean O000000o2 = O000O0o0.O000000o().O000000o(str);
        if (O000000o2 != null) {
            this.O000000o.O000000o(str, str4, O000000o2.getLocalKey(), str3, str2, O000000o2.getPv(), i, iResultCallback);
        } else if (iResultCallback != null) {
            iResultCallback.onError("13003", "ble mesh is not exist");
        }
    }

    public void onDestroy() {
        this.O00000o0.onDestroy();
        this.O00000Oo.onDestroy();
        this.O00000o.onDestroy();
    }
}
