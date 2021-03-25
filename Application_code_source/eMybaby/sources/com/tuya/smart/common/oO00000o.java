package com.tuya.smart.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.tuya.smart.android.base.TuyaSmartSdk;
import com.tuya.smart.android.device.bean.GroupDeviceRespBean;
import com.tuya.smart.android.mvp.model.BaseModel;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.home.sdk.api.ITuyaGroupModel;
import com.tuya.smart.home.sdk.callback.ITuyaResultCallback;
import com.tuya.smart.interior.device.bean.GroupRespBean;
import com.tuya.smart.interior.enums.BizParentTypeEnum;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.bean.CloudZigbeeGroupCreateBean;
import com.tuya.smart.sdk.bean.GroupBean;
import com.tuya.smart.sdk.bean.GroupDeviceBean;
import com.tuya.smart.sdk.enums.TYDevicePublishModeEnum;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class oO00000o extends BaseModel implements ITuyaGroupModel {
    public static final String O000000o = "GroupModel";
    public static ITuyaGroupModel O00000Oo;
    public final o0 O00000o;
    public final long O00000o0;
    public o0000 O00000oO;

    public oO00000o() {
        super(TuyaSmartSdk.getApplication());
        this.O00000o0 = -1;
        this.O00000oO = new o0000();
        this.O00000o = new o0();
    }

    public oO00000o(long j) {
        super(TuyaSmartSdk.getApplication());
        this.O00000o0 = j;
        this.O00000oO = new o0000();
        this.O00000o = new o0();
    }

    public void O000000o(long j, String str, IResultCallback iResultCallback) {
        O000000o(j, str, TYDevicePublishModeEnum.TYDevicePublishModeAuto, iResultCallback);
    }

    public void O000000o(long j, String str, TYDevicePublishModeEnum tYDevicePublishModeEnum, final IResultCallback iResultCallback) {
        GroupBean groupBean = oO0OO000.O000000o().getGroupBean(j);
        if (groupBean != null) {
            LinkedHashMap linkedHashMap = (LinkedHashMap) JSON.parseObject(str, new TypeReference<LinkedHashMap<String, Object>>() {
            }, new Feature[0]);
            if (oOO0OO0O.O000000o(groupBean.getProductId(), (LinkedHashMap<String, Object>) linkedHashMap)) {
                String O000000o2 = oOO0OO0O.O000000o(groupBean.getProductId(), str, (LinkedHashMap<String, Object>) linkedHashMap);
                o0o0o0ooo0 o0o0o0ooo0 = new o0o0o0ooo0();
                o0o0o0ooo0.O00000o0(O000000o2);
                this.O00000oO.O000000o(this.O00000o0, o0o0o0ooo0, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
                    /* renamed from: O000000o */
                    public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                        IResultCallback iResultCallback = iResultCallback;
                        if (iResultCallback != null) {
                            iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                        }
                    }

                    /* renamed from: O00000Oo */
                    public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                        IResultCallback iResultCallback = iResultCallback;
                        if (iResultCallback != null) {
                            iResultCallback.onSuccess();
                        }
                    }
                });
            } else if (iResultCallback != null) {
                iResultCallback.onError("11001", "DP data error");
            }
        } else if (iResultCallback != null) {
            iResultCallback.onError("1001", "group isn't exist");
        }
    }

    public void O000000o(final IResultCallback iResultCallback) {
        this.O00000oO.O000000o(this.O00000o0, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O000000o(String str, final IResultCallback iResultCallback) {
        this.O00000oO.O000000o(this.O00000o0, str, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O000000o(List<String> list, final IResultCallback iResultCallback) {
        this.O00000o.O00000o(list, BizParentTypeEnum.DEVICE, Long.valueOf(this.O00000o0), BizParentTypeEnum.GROUP, new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O00000Oo(String str, final IResultCallback iResultCallback) {
        this.O00000o.O000000o((Object) str, BizParentTypeEnum.DEVICE, (Object) Long.valueOf(this.O00000o0), BizParentTypeEnum.GROUP, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O00000o0(String str, final IResultCallback iResultCallback) {
        this.O00000o.O00000Oo(str, BizParentTypeEnum.DEVICE, Long.valueOf(this.O00000o0), BizParentTypeEnum.GROUP, new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void createNewGroup(long j, String str, String str2, List<String> list, ITuyaResultCallback<Long> iTuyaResultCallback) {
        final ITuyaResultCallback<Long> iTuyaResultCallback2 = iTuyaResultCallback;
        final long j2 = j;
        final List<String> list2 = list;
        this.O00000oO.O000000o(j, str, str2, list, (Business.ResultListener<GroupRespBean>) new Business.ResultListener<GroupRespBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, GroupRespBean groupRespBean, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback2;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, GroupRespBean groupRespBean, String str) {
                if (groupRespBean != null) {
                    groupRespBean.setResptime(businessResponse.getT());
                    o0O000Oo.O000000o().O00000Oo(groupRespBean);
                    o0o00o0o0o o0o00o0o0o = (o0o00o0o0o) Oo0.O000000o(o0o00o0o0o.class);
                    if (o0o00o0o0o != null) {
                        o0o00o0o0o.O00000o0().addGroupToHome(j2, groupRespBean.getId());
                        o0o00o0o0o.O00000o0().updateDeviceList(groupRespBean.getId(), list2);
                    }
                    o0O0O00O.O00000o0();
                    ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback2;
                    if (iTuyaResultCallback != null) {
                        iTuyaResultCallback.onSuccess(Long.valueOf(groupRespBean.getId()));
                    }
                }
            }
        });
    }

    public void createZigbeeEmptyGroup(String str, final long j, String str2, int i, String str3, final ITuyaResultCallback<CloudZigbeeGroupCreateBean> iTuyaResultCallback) {
        this.O00000oO.O000000o(str, j, str2, i, str3, new Business.ResultListener<GroupRespBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, GroupRespBean groupRespBean, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, GroupRespBean groupRespBean, String str) {
                if (groupRespBean != null) {
                    groupRespBean.setResptime(businessResponse.getT());
                    o0O000Oo.O000000o().O00000Oo(groupRespBean);
                    o0o00o0o0o o0o00o0o0o = (o0o00o0o0o) Oo0.O000000o(o0o00o0o0o.class);
                    if (o0o00o0o0o != null) {
                        o0o00o0o0o.O00000o0().addGroupToHome(j, groupRespBean.getId());
                    }
                    o0O0O00O.O00000o0();
                    CloudZigbeeGroupCreateBean cloudZigbeeGroupCreateBean = new CloudZigbeeGroupCreateBean();
                    cloudZigbeeGroupCreateBean.setGroupId(groupRespBean.getId());
                    cloudZigbeeGroupCreateBean.setLocalId(groupRespBean.getLocalId());
                    ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                    if (iTuyaResultCallback != null) {
                        iTuyaResultCallback.onSuccess(cloudZigbeeGroupCreateBean);
                    }
                }
            }
        });
    }

    public void getGroupDeviceList(long j, long j2, String str, final ITuyaResultCallback<List<GroupDeviceBean>> iTuyaResultCallback) {
        this.O00000oO.O000000o(j, j2, str, (Business.ResultListener<ArrayList<GroupDeviceRespBean>>) new Business.ResultListener<ArrayList<GroupDeviceRespBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<GroupDeviceRespBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<GroupDeviceRespBean> arrayList, String str) {
                if (iTuyaResultCallback != null) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<GroupDeviceRespBean> it = arrayList.iterator();
                    while (it.hasNext()) {
                        GroupDeviceBean O000000o2 = oOO0OOo0.O000000o(it.next());
                        if (O000000o2 != null) {
                            arrayList2.add(O000000o2);
                        }
                    }
                    iTuyaResultCallback.onSuccess(arrayList2);
                }
            }
        });
    }

    public void getZigbeeGroupDeviceList(long j, long j2, String str, String str2, final ITuyaResultCallback<List<GroupDeviceBean>> iTuyaResultCallback) {
        this.O00000oO.O000000o(j, j2, str, str2, (Business.ResultListener<ArrayList<GroupDeviceRespBean>>) new Business.ResultListener<ArrayList<GroupDeviceRespBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<GroupDeviceRespBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<GroupDeviceRespBean> arrayList, String str) {
                if (iTuyaResultCallback != null) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<GroupDeviceRespBean> it = arrayList.iterator();
                    while (it.hasNext()) {
                        GroupDeviceBean O000000o2 = oOO0OOo0.O000000o(it.next());
                        if (O000000o2 != null) {
                            arrayList2.add(O000000o2);
                        }
                    }
                    iTuyaResultCallback.onSuccess(arrayList2);
                }
            }
        });
    }

    public void onDestroy() {
        this.O00000oO.onDestroy();
        this.O00000o.onDestroy();
    }
}
