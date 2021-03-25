package com.tuya.smart.common;

import android.content.Context;
import android.text.TextUtils;
import com.tuya.smart.android.common.utils.TuyaUtil;
import com.tuya.smart.android.device.api.IGetDataPointStatCallback;
import com.tuya.smart.android.device.api.IPropertyCallback;
import com.tuya.smart.android.device.bean.DataPointStatBean;
import com.tuya.smart.android.device.enums.DataPointTypeEnum;
import com.tuya.smart.android.mvp.model.BaseModel;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.home.sdk.api.IDevModel;
import com.tuya.smart.interior.device.bean.DeviceRespBean;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.List;
import java.util.Map;

public class oO000OOO extends BaseModel implements IDevModel {
    public static final String O000000o = "DevModel";
    public final oO0OOo0o O00000Oo;
    public String O00000o;
    public o000 O00000o0 = new o000();

    public oO000OOO(Context context, String str) {
        super(context);
        this.O00000o = str;
        this.O00000Oo = new oO0OoOO0(context, str);
    }

    private boolean O000000o() {
        return oO0OO000.O000000o().getDeviceBean(this.O00000o) == null;
    }

    public void O000000o(IPropertyCallback<Map> iPropertyCallback) {
        String str = this.O00000o;
        getDeviceProperty(str, str, iPropertyCallback);
    }

    public void O000000o(IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(iResultCallback);
    }

    public void O000000o(String str, IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(str, 0, iResultCallback);
    }

    public void O000000o(String str, ITuyaDataCallback<List<DeviceBean>> iTuyaDataCallback) {
        oOo0oooO.O000000o().O000000o(str, iTuyaDataCallback);
    }

    public void O000000o(String str, String str2, IResultCallback iResultCallback) {
        String str3 = this.O00000o;
        saveDeviceProperty(str3, str3, str, str2, iResultCallback);
    }

    public void O00000Oo(final IResultCallback iResultCallback) {
        if (O000000o()) {
            iResultCallback.onError("11002", "device is removed");
        } else {
            this.O00000o0.O00000o0(this.O00000o, new Business.ResultListener<Boolean>() {
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
    }

    public void O00000Oo(String str, String str2, IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(this.O00000o, str, str2, 0, iResultCallback);
    }

    public void addZigBeeGroup(List<String> list, String str, IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(list, str, iResultCallback);
    }

    public void addZigBeeScene(List<String> list, String str, String str2, IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(list, str, str2, iResultCallback);
    }

    public void autoConfigExecute(String str, String str2, String str3, long j, IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(str, str2, str3, j, iResultCallback);
    }

    public void broadcastSend(String str, IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(this.O00000o, "", str, 1, iResultCallback);
    }

    public void gatewayRouterConfigExecute(int i, String str, String str2, long j, IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(i, str, str2, j, iResultCallback);
    }

    public void getDataPointStat(DataPointTypeEnum dataPointTypeEnum, long j, int i, String str, String str2, IGetDataPointStatCallback iGetDataPointStatCallback) {
        int i2;
        final IGetDataPointStatCallback iGetDataPointStatCallback2 = iGetDataPointStatCallback;
        if (O000000o()) {
            iGetDataPointStatCallback2.onError("11002", "device is removed");
            return;
        }
        String formatDate = TuyaUtil.formatDate(j, "yyyy-MM-dd HH:mm:ss");
        if (formatDate != null) {
            String substring = formatDate.substring(0, 4);
            String substring2 = formatDate.substring(5, 7);
            String substring3 = formatDate.substring(8, 10);
            String substring4 = formatDate.substring(11, 13);
            try {
                i2 = Integer.valueOf(str).intValue();
            } catch (Exception unused) {
                i2 = 0;
            }
            o000 o000 = this.O00000o0;
            String str3 = this.O00000o;
            o000.O000000o(str3, str3, dataPointTypeEnum, substring, substring2, substring3, substring4, i, i2, str2, new Business.ResultListener<DataPointStatBean>() {
                /* renamed from: O000000o */
                public void onFailure(BusinessResponse businessResponse, DataPointStatBean dataPointStatBean, String str) {
                    IGetDataPointStatCallback iGetDataPointStatCallback = iGetDataPointStatCallback2;
                    if (iGetDataPointStatCallback != null) {
                        iGetDataPointStatCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                    }
                }

                /* renamed from: O00000Oo */
                public void onSuccess(BusinessResponse businessResponse, DataPointStatBean dataPointStatBean, String str) {
                    IGetDataPointStatCallback iGetDataPointStatCallback = iGetDataPointStatCallback2;
                    if (iGetDataPointStatCallback != null) {
                        iGetDataPointStatCallback.onSuccess(dataPointStatBean);
                    }
                }
            });
        } else if (iGetDataPointStatCallback2 != null) {
            iGetDataPointStatCallback2.onError(BusinessResponse.RESULT_TIME_ERROR, BusinessResponse.RESULT_TIME_ERROR);
        }
    }

    public void getDeviceProperty(String str, String str2, final IPropertyCallback<Map> iPropertyCallback) {
        if (O000000o()) {
            iPropertyCallback.onError("11002", "device is removed");
        } else {
            this.O00000o0.O00000o(str, str2, new Business.ResultListener<Map>() {
                /* renamed from: O000000o */
                public void onFailure(BusinessResponse businessResponse, Map map, String str) {
                    IPropertyCallback iPropertyCallback = iPropertyCallback;
                    if (iPropertyCallback != null) {
                        iPropertyCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                    }
                }

                /* renamed from: O00000Oo */
                public void onSuccess(BusinessResponse businessResponse, Map map, String str) {
                    IPropertyCallback iPropertyCallback = iPropertyCallback;
                    if (iPropertyCallback != null) {
                        iPropertyCallback.onSuccess(map);
                    }
                }
            });
        }
    }

    public void getDp(String str, IResultCallback iResultCallback) {
        this.O00000Oo.O00000o(str, iResultCallback);
    }

    public void getDpList(List<String> list, IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(list, iResultCallback);
    }

    public void getInitiativeQueryDpsInfo(String str, List<String> list, List<Integer> list2, IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(str, list, list2, iResultCallback);
    }

    public void intranetControl(String str, IResultCallback iResultCallback) {
        this.O00000Oo.O00000o0(str, iResultCallback);
    }

    public boolean isIntranetControl() {
        return oO0OO000.O000000o().getDeviceBean(this.O00000o).getIsLocalOnline().booleanValue();
    }

    public void localSceneExecute(String str, String str2, IResultCallback iResultCallback) {
        oO0O0o0o.O000000o(this.O00000o, str, str2, iResultCallback);
    }

    public void localSceneExecuteNew(String str, IResultCallback iResultCallback) {
        oO0O0o0o.O00000Oo(this.O00000o, str, iResultCallback);
    }

    public void multicastSend(String str, String str2, IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(this.O00000o, str, str2, 2, iResultCallback);
    }

    public void onDestroy() {
        this.O00000o0.cancelAll();
        this.O00000Oo.onDestroy();
    }

    public void query(String str, IResultCallback iResultCallback) {
        this.O00000Oo.O00000oO(str, iResultCallback);
    }

    public void removeDevice(final IResultCallback iResultCallback) {
        if (O000000o()) {
            iResultCallback.onError("11002", "device is removed");
            return;
        }
        DeviceBean deviceBean = oO0OO000.O000000o().getDeviceBean(this.O00000o);
        if (deviceBean != null) {
            String meshId = deviceBean.getMeshId();
            if (deviceBean.isSigMesh()) {
                meshId = deviceBean.isBleMeshWifi() ? "" : deviceBean.getParentId();
            }
            if (!TextUtils.isEmpty(deviceBean.getNodeId()) && !TextUtils.isEmpty(meshId)) {
                this.O00000o0.O00000oo(meshId, this.O00000o, new Business.ResultListener<Boolean>() {
                    /* renamed from: O000000o */
                    public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                        IResultCallback iResultCallback = iResultCallback;
                        if (iResultCallback != null) {
                            iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                        }
                    }

                    /* renamed from: O00000Oo */
                    public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                        oOo0oooO.O000000o().removeDevCache(oO000OOO.this.O00000o);
                        IResultCallback iResultCallback = iResultCallback;
                        if (iResultCallback != null) {
                            iResultCallback.onSuccess();
                        }
                    }
                });
                return;
            }
        }
        if (deviceBean == null || !deviceBean.getIsShare().booleanValue()) {
            this.O00000o0.O000000o(this.O00000o, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
                /* renamed from: O000000o */
                public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                    IResultCallback iResultCallback = iResultCallback;
                    if (iResultCallback != null) {
                        iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                    }
                }

                /* renamed from: O00000Oo */
                public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                    oOo0oooO.O000000o().removeDevCache(oO000OOO.this.O00000o);
                    IResultCallback iResultCallback = iResultCallback;
                    if (iResultCallback != null) {
                        iResultCallback.onSuccess();
                    }
                }
            });
        } else if (iResultCallback != null) {
            iResultCallback.onError("107", "Deny permission with device can't be shared");
        }
    }

    public void removeZigBeeGroup(List<String> list, String str, IResultCallback iResultCallback) {
        this.O00000Oo.O00000Oo(list, str, iResultCallback);
    }

    public void removeZigBeeScene(List<String> list, String str, String str2, IResultCallback iResultCallback) {
        this.O00000Oo.O00000Oo(list, str, str2, iResultCallback);
    }

    public void renameGw(String str, final String str2, final IResultCallback iResultCallback) {
        if (O000000o()) {
            iResultCallback.onError("11002", "device is removed");
        } else {
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
                    DeviceRespBean O00000o02 = oO00O0o0.O000000o().O00000o0(oO000OOO.this.O00000o);
                    if (O00000o02 != null) {
                        O00000o02.setName(str2);
                    }
                    IResultCallback iResultCallback = iResultCallback;
                    if (iResultCallback != null) {
                        iResultCallback.onSuccess();
                    }
                }
            });
        }
    }

    public void renameSubDevName(String str, String str2, String str3, final IResultCallback iResultCallback) {
        this.O00000o0.O000000o(str, str2, str3, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
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

    public void saveDeviceProperty(String str, String str2, String str3, String str4, final IResultCallback iResultCallback) {
        if (O000000o()) {
            iResultCallback.onError("11002", "device is removed");
            return;
        }
        this.O00000o0.O000000o(str, str2, str3, str4, new Business.ResultListener<Boolean>() {
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

    public void sceneExecuteMqtt(String str, IResultCallback iResultCallback) {
        this.O00000Oo.O00000oo(str, iResultCallback);
    }

    public void send(String str, IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(str, iResultCallback);
    }

    public void sendDpsByApi(String str, String str2, final IResultCallback iResultCallback) {
        this.O00000o0.O0000O0o(str, str2, new Business.ResultListener<Boolean>() {
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

    public void sendScene(String str, IResultCallback iResultCallback) {
        this.O00000Oo.O00000Oo(str, iResultCallback);
    }
}
