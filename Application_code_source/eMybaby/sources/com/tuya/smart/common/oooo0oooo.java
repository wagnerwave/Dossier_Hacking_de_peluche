package com.tuya.smart.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tuya.sdk.sigmesh.bean.TuyaSigMeshBean;
import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshGroup;
import com.tuya.smart.android.blemesh.callback.ILocalQueryGroupDevCallback;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.home.sdk.api.IDevModel;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.IGroupListener;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.ITuyaGroup;
import com.tuya.smart.sdk.api.bluemesh.ITuyaBlueMesh;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.GroupBean;
import com.tuya.smart.sdk.enums.TYDevicePublishModeEnum;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class oooo0oooo implements ITuyaBlueMeshGroup {
    public static final int O000000o = 0;
    public static final int O00000Oo = 1;
    public static final String O00000o = "TuyaSigMeshGroup";
    public static final int O00000o0 = 0;
    public static final int O00000oO = 1002;
    public String O00000oo;
    public ITuyaGroup O0000O0o;
    public GroupBean O0000OOo;
    public ITuyaBlueMesh O0000Oo;
    public String O0000Oo0;
    public ooooo0000 O0000OoO;
    public IResultCallback O0000Ooo;
    public Map<String, IDevModel> O0000o0 = new HashMap();
    public List<String> O0000o00;
    public Handler O0000o0O = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 1002 || oooo0oooo.this.O0000Ooo == null) {
                return false;
            }
            oooo0oooo.this.O0000Ooo.onError(o00oo0o0o0.O0000o0, "time out");
            IResultCallback unused = oooo0oooo.this.O0000Ooo = null;
            oooo0oooo.this.O0000o00.clear();
            return false;
        }
    });
    public o0o0o00000<o0o0oo000o> O0000o0o = new o0o0o00000<o0o0oo000o>() {
        /* renamed from: O000000o */
        public synchronized void onResult(o0o0oo000o o0o0oo000o) {
            Class cls = o0o00o00o0.class;
            synchronized (this) {
                DeviceBean deviceBean = Oo0.O000000o(cls) != null ? ((o0o00o00o0) Oo0.O000000o(cls)).O0000OOo().getDeviceBean(o0o0oo000o.O000000o()) : null;
                if (deviceBean != null && TextUtils.equals(oooo0oooo.this.O0000Oo0, deviceBean.getParentId())) {
                    List<Integer> O00000o = o0o0oo000o.O00000o();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    HashMap hashMap = new HashMap();
                    if (O00000o != null && O00000o.size() == oooo0oooo.this.O0000o00.size()) {
                        for (int i = 0; i < oooo0oooo.this.O0000o00.size(); i++) {
                            String str = (String) oooo0oooo.this.O0000o00.get(i);
                            int intValue = O00000o.get(i).intValue();
                            if (intValue == 0) {
                                arrayList.add(str);
                            } else {
                                arrayList2.add(str);
                                hashMap.put(str, Integer.valueOf(intValue));
                            }
                        }
                        if (arrayList.size() > 0 && oooo0oooo.this.O0000Ooo != null) {
                            oooo0oooo.this.O0000Ooo.onSuccess();
                            IResultCallback unused = oooo0oooo.this.O0000Ooo = null;
                        }
                    }
                    L.i("HHHHH", "WHAT_CONTROL_TIME_OUT...REMOVE...");
                    oooo0oooo.this.O0000o0O.removeMessages(1002);
                    IResultCallback unused2 = oooo0oooo.this.O0000Ooo = null;
                    oooo0oooo.this.O0000o00.clear();
                }
            }
        }
    };

    public oooo0oooo(long j) {
        Class cls = o0o00o00o0.class;
        GroupBean groupBean = ((o0o00o00o0) Oo0.O000000o(cls)).O0000OOo().getGroupBean(j);
        if (groupBean == null) {
            L.e(O00000o, j + "is not exist");
            return;
        }
        this.O0000O0o = ((o0o00o00o0) Oo0.O000000o(cls)).O000000o(groupBean.getId());
        this.O0000Oo = new O000OO00(groupBean.getMeshId());
        this.O00000oo = groupBean.getLocalId();
        String meshId = groupBean.getMeshId();
        this.O0000Oo0 = meshId;
        this.O0000OOo = groupBean;
        this.O0000OoO = new ooooo0000(meshId);
        this.O0000o00 = new ArrayList();
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(cls);
        if (o0o00o00o0 != null) {
            o0o00o00o0.O0000o00().registerDeviceMqttListener(o0o0oo000o.class, this.O0000o0o);
        }
    }

    private void O000000o(IDevModel iDevModel, final List<String> list, boolean z, final IResultCallback iResultCallback) {
        AnonymousClass6 r0 = new IResultCallback() {
            public void onError(String str, String str2) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(str, str2);
                }
            }

            public void onSuccess() {
                IResultCallback unused = oooo0oooo.this.O0000Ooo = iResultCallback;
                oooo0oooo.this.O0000o00.clear();
                oooo0oooo.this.O0000o00.addAll(list);
                oooo0oooo.this.O0000o0O.sendEmptyMessageDelayed(1002, (long) ((list.size() * 6000) + 9000));
            }
        };
        if (z) {
            iDevModel.addZigBeeGroup(list, this.O00000oo, r0);
        } else {
            iDevModel.removeZigBeeGroup(list, this.O00000oo, r0);
        }
    }

    private IDevModel O00000Oo(DeviceBean deviceBean) {
        Class cls = o0o00o00o0.class;
        if (deviceBean == null) {
            return null;
        }
        IDevModel iDevModel = this.O0000o0.get(deviceBean.getDevId());
        if (iDevModel != null || Oo0.O000000o(cls) == null || TextUtils.isEmpty(deviceBean.getParentId())) {
            return iDevModel;
        }
        IDevModel O000000o2 = ((o0o00o00o0) Oo0.O000000o(cls)).O000000o(TuyaSdk.getApplication(), deviceBean.getParentId());
        this.O0000o0.put(deviceBean.getDevId(), O000000o2);
        return O000000o2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        r0 = ((com.tuya.smart.common.o0o00o00o0) com.tuya.smart.common.Oo0.O000000o(r0)).O0000OOo().getDeviceBean(r4.getParentId());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean O000000o(com.tuya.smart.sdk.bean.DeviceBean r4) {
        /*
            r3 = this;
            java.lang.Class<com.tuya.smart.common.o0o00o00o0> r0 = com.tuya.smart.common.o0o00o00o0.class
            java.lang.Object r1 = com.tuya.smart.common.Oo0.O000000o(r0)
            r2 = 0
            if (r1 == 0) goto L_0x0035
            java.lang.String r1 = r4.getParentId()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0035
            java.lang.Object r0 = com.tuya.smart.common.Oo0.O000000o(r0)
            com.tuya.smart.common.o0o00o00o0 r0 = (com.tuya.smart.common.o0o00o00o0) r0
            com.tuya.smart.home.sdk.api.ITuyaHomeDataManager r0 = r0.O0000OOo()
            java.lang.String r1 = r4.getParentId()
            com.tuya.smart.sdk.bean.DeviceBean r0 = r0.getDeviceBean(r1)
            if (r0 == 0) goto L_0x0035
            boolean r0 = r0.isCloudOnline()
            if (r0 == 0) goto L_0x0035
            boolean r4 = r4.isCloudOnline()
            if (r4 == 0) goto L_0x0035
            r4 = 1
            r2 = 1
        L_0x0035:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.oooo0oooo.O000000o(com.tuya.smart.sdk.bean.DeviceBean):boolean");
    }

    public void addDevice(final String str, final IResultCallback iResultCallback) {
        DeviceBean meshSubDevBean = this.O0000Oo.getMeshSubDevBean(str);
        if (meshSubDevBean != null) {
            AnonymousClass5 r1 = new IResultCallback() {
                public void onError(String str, String str2) {
                    IResultCallback iResultCallback = iResultCallback;
                    if (iResultCallback != null) {
                        iResultCallback.onError(str, str2);
                    }
                }

                public void onSuccess() {
                    oooo0oooo.this.O0000O0o.addDevice(str, iResultCallback);
                }
            };
            TuyaSigMeshBean O00000o2 = O0O0o00.O000000o().O00000o(this.O0000Oo0);
            if (O00000o2 == null || O00000o2.getProvisionedMeshNode() == null || !meshSubDevBean.getIsLocalOnline().booleanValue()) {
                if (O000000o(meshSubDevBean)) {
                    IDevModel O00000Oo2 = O00000Oo(meshSubDevBean);
                    if (O00000Oo2 != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(meshSubDevBean.getNodeId());
                        O000000o(O00000Oo2, arrayList, true, r1);
                        return;
                    } else if (iResultCallback == null) {
                        return;
                    }
                } else if (iResultCallback == null) {
                    return;
                }
                iResultCallback.onError("13006", "mesh_off_line");
                return;
            }
            this.O0000OoO.O000000o(str, this.O00000oo, (IResultCallback) r1);
        } else if (iResultCallback != null) {
            iResultCallback.onError("11002", "device is remove");
        }
    }

    public void dismissGroup(final IResultCallback iResultCallback) {
        List<DeviceBean> groupDeviceList = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O0000OOo().getGroupDeviceList(this.O0000OOo.getId());
        final AnonymousClass3 r1 = new IResultCallback() {
            public void onError(String str, String str2) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(str, str2);
                }
            }

            public void onSuccess() {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        };
        if (O0O0o00.O000000o().O00000o(this.O0000Oo0) != null) {
            this.O0000OoO.O000000o(this.O00000oo, groupDeviceList, (IResultCallback) new IResultCallback() {
                public void onError(String str, String str2) {
                    IResultCallback iResultCallback = iResultCallback;
                    if (iResultCallback != null) {
                        iResultCallback.onError(str, str2);
                    }
                }

                public void onSuccess() {
                    oooo0oooo.this.O0000O0o.dismissGroup(r1);
                }
            });
        } else {
            this.O0000O0o.dismissGroup(r1);
        }
    }

    public void onDestroy() {
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        if (o0o00o00o0 != null) {
            o0o00o00o0.O0000o00().unRegisterDeviceMqttListener(o0o0oo000o.class, this.O0000o0o);
        }
    }

    public void publishDps(String str, IResultCallback iResultCallback) {
    }

    public void publishDps(String str, TYDevicePublishModeEnum tYDevicePublishModeEnum, IResultCallback iResultCallback) {
    }

    public void queryDeviceInGroupByLocal(ILocalQueryGroupDevCallback iLocalQueryGroupDevCallback) {
    }

    public void queryGroupStatus(IResultCallback iResultCallback) {
    }

    public void registerGroupListener(IGroupListener iGroupListener) {
    }

    public void removeDevice(final String str, final IResultCallback iResultCallback) {
        DeviceBean meshSubDevBean = this.O0000Oo.getMeshSubDevBean(str);
        if (meshSubDevBean != null) {
            AnonymousClass7 r1 = new IResultCallback() {
                public void onError(String str, String str2) {
                    IResultCallback iResultCallback = iResultCallback;
                    if (iResultCallback != null) {
                        iResultCallback.onError(str, str2);
                    }
                }

                public void onSuccess() {
                    oooo0oooo.this.O0000O0o.removeDevice(str, iResultCallback);
                }
            };
            TuyaSigMeshBean O00000o2 = O0O0o00.O000000o().O00000o(this.O0000Oo0);
            if (O00000o2 == null || O00000o2.getProvisionedMeshNode() == null || !meshSubDevBean.getIsLocalOnline().booleanValue()) {
                if (O000000o(meshSubDevBean)) {
                    IDevModel O00000Oo2 = O00000Oo(meshSubDevBean);
                    if (O00000Oo2 != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(meshSubDevBean.getNodeId());
                        O000000o(O00000Oo2, arrayList, false, r1);
                        return;
                    } else if (iResultCallback == null) {
                        return;
                    }
                } else if (iResultCallback == null) {
                    return;
                }
                iResultCallback.onError("13006", "mesh_off_line");
                return;
            }
            this.O0000OoO.O00000Oo(str, this.O00000oo, r1);
        } else if (iResultCallback != null) {
            iResultCallback.onError("11002", "device is remove");
        }
    }

    public void renameGroup(String str, IResultCallback iResultCallback) {
        this.O0000O0o.renameGroup(str, iResultCallback);
    }

    public void unRegisterGroupListener() {
    }

    public void updateDeviceList(List<String> list, IResultCallback iResultCallback) {
    }
}
