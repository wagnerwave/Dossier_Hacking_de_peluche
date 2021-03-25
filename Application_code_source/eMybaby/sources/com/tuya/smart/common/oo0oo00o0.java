package com.tuya.smart.common;

import a.e.a.a.r.a;
import android.text.TextUtils;
import com.tuya.sdk.sigmesh.bean.ProvisionedMeshNode;
import com.tuya.sdk.sigmesh.bean.TuyaSigMeshBean;
import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshDevice;
import com.tuya.smart.android.blemesh.bean.DpsParseBean;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.common.o00o0o0o0o;
import com.tuya.smart.home.sdk.api.IDevModel;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.bluemesh.IAddGroupCallback;
import com.tuya.smart.sdk.api.bluemesh.IAddSubDevCallback;
import com.tuya.smart.sdk.api.bluemesh.IMeshDevListener;
import com.tuya.smart.sdk.api.bluemesh.ITuyaBlueMesh;
import com.tuya.smart.sdk.api.bluemesh.ITuyaMeshGroup;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.GroupBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class oo0oo00o0 implements ITuyaBlueMeshDevice {
    public static final String O000000o = "TuyaSigMeshDevice";
    public final ITuyaBlueMesh O00000Oo;
    public Timer O00000o;
    public final String O00000o0;
    public O0OOO0O O00000oO;
    public IMeshDevListener O00000oo;
    public ooooo0000 O0000O0o;
    public Map<String, IDevModel> O0000OOo = new HashMap();
    public Map<String, ITuyaMeshGroup> O0000Oo0 = new HashMap();

    public oo0oo00o0(String str) {
        this.O00000o0 = str;
        this.O00000Oo = new O000OO00(str);
        this.O0000O0o = new ooooo0000(str);
        this.O00000o = new Timer();
    }

    private GroupBean O000000o(String str) {
        for (GroupBean next : ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O0000OOo().getMeshGroupList(this.O00000o0)) {
            if (TextUtils.equals(str, next.getLocalId())) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void O000000o(DeviceBean deviceBean, IResultCallback iResultCallback) {
        IDevModel iDevModel;
        Class cls = o0o00o00o0.class;
        if (TextUtils.isEmpty(deviceBean.getParentId())) {
            iDevModel = O00000Oo(deviceBean.getDevId());
            if (iDevModel == null) {
                return;
            }
        } else if (Oo0.O000000o(cls) == null) {
            return;
        } else {
            if (((o0o00o00o0) Oo0.O000000o(cls)).O0000OOo().getDeviceBean(deviceBean.getParentId()) != null || deviceBean.isBleMeshWifi() || TextUtils.isEmpty(deviceBean.getParentId())) {
                iDevModel = O00000Oo(deviceBean.getDevId());
                if (iDevModel == null) {
                    return;
                }
            } else {
                this.O00000Oo.removeMeshSubDev(deviceBean.getDevId(), iResultCallback);
                return;
            }
        }
        iDevModel.removeDevice(iResultCallback);
    }

    private void O000000o(DeviceBean deviceBean, String str, IResultCallback iResultCallback) {
        Class cls = o0o00o00o0.class;
        IDevModel iDevModel = this.O0000OOo.get(deviceBean.getDevId());
        if (iDevModel == null && Oo0.O000000o(cls) != null) {
            iDevModel = ((o0o00o00o0) Oo0.O000000o(cls)).O000000o(TuyaSdk.getApplication(), deviceBean.getDevId());
            this.O0000OOo.put(deviceBean.getDevId(), iDevModel);
        }
        if (iDevModel != null) {
            iDevModel.send(str, iResultCallback);
        }
    }

    private void O000000o(String str, String str2, String str3, boolean z, IResultCallback iResultCallback) {
        String str4;
        String str5;
        DeviceBean meshSubDevBeanByNodeId = this.O00000Oo.getMeshSubDevBeanByNodeId(str);
        if (meshSubDevBeanByNodeId == null) {
            iResultCallback.onError("11002", "device is remove");
            return;
        }
        TuyaSigMeshBean O00000o2 = O0O0o00.O000000o().O00000o(this.O00000o0);
        if (O00000o2 != null && O00000o2.getProvisionedMeshNode() != null && meshSubDevBeanByNodeId.getIsLocalOnline().booleanValue()) {
            List<ooo0o0o00> O000000o2 = o0000000o0.O000000o(str2).O000000o(str3, meshSubDevBeanByNodeId.getSchemaMap(), true);
            if (!O000000o2.isEmpty()) {
                O000000o(O000000o2, O00000o2, O00000o2.getMeshkey(), str, z, iResultCallback);
                return;
            }
            str5 = "11001";
            str4 = "this device not support publish";
        } else if (O000O0o.O000000o().getMeshDeviceCloudStatus(this.O00000o0, meshSubDevBeanByNodeId.getDevId())) {
            O000000o(meshSubDevBeanByNodeId, str3, iResultCallback);
            return;
        } else if (iResultCallback != null) {
            str5 = "13006";
            str4 = "mesh_off_line";
        } else {
            return;
        }
        iResultCallback.onError(str5, str4);
    }

    private void O000000o(List<ooo0o0o00> list, TuyaSigMeshBean tuyaSigMeshBean, String str, String str2, boolean z, IResultCallback iResultCallback) {
        ProvisionedMeshNode provisionedMeshNode = tuyaSigMeshBean.getProvisionedMeshNode();
        byte[] O00000o02 = oo0o0oooo.O000000o().O00000o0();
        o000oo0000 O0000OoO = oo0o0oooo.O000000o().O0000OoO();
        for (int i = 0; i < list.size(); i++) {
            final ooo0o0o00 ooo0o0o00 = list.get(i);
            final String str3 = str;
            final IResultCallback iResultCallback2 = iResultCallback;
            final String str4 = str2;
            final ProvisionedMeshNode provisionedMeshNode2 = provisionedMeshNode;
            final o000oo0000 o000oo0000 = O0000OoO;
            final byte[] bArr = O00000o02;
            final boolean z2 = z;
            this.O00000o.schedule(new TimerTask() {
                public void run() {
                    if (TextUtils.isEmpty(str3)) {
                        L.e(oo0oo00o0.O000000o, "key is empty");
                        IResultCallback iResultCallback = iResultCallback2;
                        if (iResultCallback != null) {
                            iResultCallback.onError("11001", "key is empty!!");
                            return;
                        }
                        return;
                    }
                    ooo0o0o00 ooo0o0o00 = ooo0o0o00;
                    if (ooo0o0o00 instanceof oo0oooo0o) {
                        final oo0oooo0o oo0oooo0o = (oo0oooo0o) ooo0o0o00;
                        oo0oooo0o.O000000o(provisionedMeshNode2.getNodeMac(), str3, o000oo0000, bArr, o000oo0o0o.O000000o(oo0oooo0o.O000000o() + a.c(str4)), new o00o0o0o0o.O000000o() {
                            public void O000000o(String str, String str2) {
                                IResultCallback iResultCallback = iResultCallback2;
                                if (iResultCallback != null) {
                                    iResultCallback.onError(str, str2);
                                }
                            }

                            public void O00000Oo() {
                                AnonymousClass1 r0 = AnonymousClass1.this;
                                if (z2) {
                                    new oooo0o00o(str4, oo0oooo0o.O0000O0o(), iResultCallback2);
                                    return;
                                }
                                IResultCallback iResultCallback = iResultCallback2;
                                if (iResultCallback != null) {
                                    iResultCallback.onSuccess();
                                }
                            }
                        });
                    } else if (ooo0o0o00 instanceof oo0oo0oo0) {
                        final oo0oo0oo0 oo0oo0oo0 = (oo0oo0oo0) ooo0o0o00;
                        byte[] O000000o2 = o000oo0o0o.O000000o(a.c(str4));
                        byte[] O000000o3 = o00o0000oo.O000000o(str3);
                        StringBuilder n = a.a.a.a.a.n("do ConfigMessageAction device key:");
                        n.append(str3);
                        L.d(oo0oo00o0.O000000o, n.toString());
                        oo0oo0oo0.O000000o(provisionedMeshNode2.getNodeMac(), o000oo0000, bArr, O000000o2, O000000o3, new o00o0o0o0o.O000000o() {
                            public void O000000o(String str, String str2) {
                                IResultCallback iResultCallback = iResultCallback2;
                                if (iResultCallback != null) {
                                    iResultCallback.onError(str, str2);
                                }
                            }

                            public void O00000Oo() {
                                AnonymousClass1 r0 = AnonymousClass1.this;
                                if (z2) {
                                    new oooo0o00o(str4, oo0oo0oo0.O00000o0(), iResultCallback2);
                                    return;
                                }
                                IResultCallback iResultCallback = iResultCallback2;
                                if (iResultCallback != null) {
                                    iResultCallback.onSuccess();
                                }
                            }
                        });
                    }
                    oooo0o000.O000000o().O000000o(oo0o0oooo.O000000o().O0000OOo(), oo0oo00o0.this.O00000o0);
                }
            }, (long) (i * 350));
        }
    }

    private boolean O000000o(List<DeviceBean> list) {
        for (DeviceBean isLocalOnline : list) {
            if (!isLocalOnline.getIsLocalOnline().booleanValue()) {
                return false;
            }
        }
        return true;
    }

    private IDevModel O00000Oo(String str) {
        Class cls = o0o00o00o0.class;
        IDevModel iDevModel = this.O0000OOo.get(str);
        if (iDevModel != null || Oo0.O000000o(cls) == null) {
            return iDevModel;
        }
        IDevModel O000000o2 = ((o0o00o00o0) Oo0.O000000o(cls)).O000000o(TuyaSdk.getApplication(), str);
        this.O0000OOo.put(str, O000000o2);
        return O000000o2;
    }

    private Map<String, DeviceBean> O00000Oo(List<DeviceBean> list) {
        HashMap hashMap = new HashMap();
        for (DeviceBean next : list) {
            if (O000O0o.O000000o().getMeshDeviceCloudStatus(this.O00000o0, next.getDevId())) {
                hashMap.put(next.getParentId(), next);
            }
        }
        return hashMap;
    }

    public void addGroup(String str, String str2, String str3, IAddGroupCallback iAddGroupCallback) {
        Class cls = o0o00o00o0.class;
        TuyaSigMeshBean O00000o2 = O0O0o00.O000000o().O00000o(this.O00000o0);
        if (!(O00000o2 == null || O00000o2.getProvisionedMeshNode() == null)) {
            GroupBean groupBean = null;
            for (GroupBean next : ((o0o00o00o0) Oo0.O000000o(cls)).O0000OOo().getMeshGroupList(this.O00000o0)) {
                if (TextUtils.equals(next.getLocalId(), str3)) {
                    groupBean = next;
                }
            }
            if (groupBean != null) {
                this.O0000O0o.O000000o(str3, ((o0o00o00o0) Oo0.O000000o(cls)).O0000OOo().getGroupDeviceList(groupBean.getId()), (IResultCallback) null);
            }
        }
        this.O00000Oo.addGroup(str, str2, str3, iAddGroupCallback);
    }

    public void addSubDev(String str, String str2, String str3, String str4, String str5, IAddSubDevCallback iAddSubDevCallback) {
        this.O00000Oo.addSubDev(str, str2, str3, str4, str5, iAddSubDevCallback);
    }

    public void addSubDev(String str, String str2, String str3, String str4, String str5, String str6, String str7, IAddSubDevCallback iAddSubDevCallback) {
        this.O00000Oo.addSubDev(str, str2, str3, str4, str5, str6, str7, iAddSubDevCallback);
    }

    public void broadcastDps(String str, String str2, IResultCallback iResultCallback) {
    }

    public void getDataByDpIds(String str, List<Integer> list, IResultCallback iResultCallback) {
    }

    public DeviceBean getMeshSubDevBean(String str) {
        return this.O00000Oo.getMeshSubDevBean(str);
    }

    public DeviceBean getMeshSubDevBeanByMac(String str) {
        return this.O00000Oo.getMeshSubDevBeanByMac(str);
    }

    public DeviceBean getMeshSubDevBeanByNodeId(String str) {
        return this.O00000Oo.getMeshSubDevBeanByNodeId(str);
    }

    public List<DeviceBean> getMeshSubDevList() {
        return this.O00000Oo.getMeshSubDevList();
    }

    public boolean isCloudOnline() {
        return this.O00000Oo.isCloudOnline();
    }

    public void multicastDps(String str, String str2, String str3, IResultCallback iResultCallback) {
        String str4;
        String str5;
        String str6 = str3;
        IResultCallback iResultCallback2 = iResultCallback;
        Class cls = o0o00o00oo.class;
        GroupBean O000000o2 = O000000o(str);
        if (O000000o2 != null || iResultCallback2 == null) {
            List<DeviceBean> deviceBeans = O000000o2.getDeviceBeans();
            if ((deviceBeans == null || deviceBeans.isEmpty()) && iResultCallback2 != null) {
                str4 = o00oo0o0o0.O00oOooO;
                str5 = "group is rempty";
            } else {
                DeviceBean deviceBean = deviceBeans.get(0);
                TuyaSigMeshBean O00000o2 = O0O0o00.O000000o().O00000o(this.O00000o0);
                if (!(O00000o2 == null || O00000o2.getProvisionedMeshNode() == null)) {
                    List<ooo0o0o00> O000000o3 = o0000000o0.O000000o(str2).O000000o(str3, deviceBean.getSchemaMap(), false);
                    if (!O000000o3.isEmpty()) {
                        O000000o(O000000o3, O00000o2, O00000o2.getMeshkey(), str, false, iResultCallback);
                    } else {
                        iResultCallback2.onError("11001", "this device not support publish");
                    }
                }
                if (!O000000o(deviceBeans)) {
                    for (Map.Entry next : O00000Oo(deviceBeans).entrySet()) {
                        String str7 = (String) next.getKey();
                        DeviceBean deviceBean2 = (DeviceBean) next.getValue();
                        ITuyaMeshGroup iTuyaMeshGroup = this.O0000Oo0.get(str7);
                        if (iTuyaMeshGroup == null && Oo0.O000000o(cls) != null) {
                            iTuyaMeshGroup = ((o0o00o00oo) Oo0.O000000o(cls)).O000000o(str7);
                            this.O0000Oo0.put(str7, iTuyaMeshGroup);
                        }
                        if (iTuyaMeshGroup != null) {
                            String str8 = str;
                            iTuyaMeshGroup.publishDps(str3, deviceBean2.getNodeId(), str, iResultCallback2);
                        } else {
                            String str9 = str;
                        }
                    }
                    return;
                }
                return;
            }
        } else {
            str4 = "11002";
            str5 = "group is remove";
        }
        iResultCallback2.onError(str4, str5);
    }

    public void onDestroy() {
        ITuyaBlueMesh iTuyaBlueMesh = this.O00000Oo;
        if (iTuyaBlueMesh != null) {
            iTuyaBlueMesh.onDestroy();
        }
        Timer timer = this.O00000o;
        if (timer != null) {
            timer.cancel();
        }
    }

    @Deprecated
    public void publishDps(String str, String str2, DpsParseBean dpsParseBean, IResultCallback iResultCallback) {
    }

    public void publishDps(String str, String str2, String str3, IResultCallback iResultCallback) {
        O000000o(str, str2, str3, true, iResultCallback);
    }

    public void publishRawData(byte[] bArr, IResultCallback iResultCallback) {
    }

    public void queryAllOnLineStatusByLocal(IResultCallback iResultCallback) {
        StringBuilder n = a.a.a.a.a.n("queryAllOnLineStatusByLocal ");
        n.append(this.O00000o0);
        L.e(O000000o, n.toString());
        List<ooo0o0o00> O00000Oo2 = o0000000o0.O000000o("").O00000Oo();
        TuyaSigMeshBean O00000o2 = O0O0o00.O000000o().O00000o(this.O00000o0);
        if (O00000o2 != null && O00000o2.getProvisionedMeshNode() != null && !O00000Oo2.isEmpty()) {
            O000000o(O00000Oo2, O00000o2, O00000o2.getMeshkey(), "FFFF", false, iResultCallback);
        }
    }

    public void queryAllStatusByLocal(IResultCallback iResultCallback) {
    }

    public void querySubDevStatusByLocal(String str, String str2, IResultCallback iResultCallback) {
        String str3;
        String str4;
        DeviceBean meshSubDevBeanByNodeId = this.O00000Oo.getMeshSubDevBeanByNodeId(str2);
        if (meshSubDevBeanByNodeId != null) {
            TuyaSigMeshBean O00000o2 = O0O0o00.O000000o().O00000o(this.O00000o0);
            if (O00000o2 != null && O00000o2.getProvisionedMeshNode() != null && meshSubDevBeanByNodeId.getIsLocalOnline().booleanValue()) {
                List<ooo0o0o00> O000000o2 = o0000000o0.O000000o(str).O000000o();
                if (!O000000o2.isEmpty()) {
                    O000000o(O000000o2, O00000o2, O00000o2.getMeshkey(), str2, false, iResultCallback);
                    return;
                } else if (iResultCallback != null) {
                    str4 = "11001";
                    str3 = "this device not support publish";
                } else {
                    return;
                }
            } else if (iResultCallback != null) {
                str4 = "13006";
                str3 = "mesh_off_line";
            } else {
                return;
            }
            iResultCallback.onError(str4, str3);
        } else if (iResultCallback != null) {
            iResultCallback.onError("11002", "device is remove");
        }
    }

    public void registerMeshDevListener(IMeshDevListener iMeshDevListener) {
        if (this.O00000oO == null) {
            this.O00000oO = O0OOO0O.O000000o(this.O00000o0);
        }
        this.O00000oo = iMeshDevListener;
        this.O00000oO.O000000o(iMeshDevListener);
    }

    public void removeMesh(IResultCallback iResultCallback) {
        this.O00000Oo.removeMesh(iResultCallback);
    }

    public void removeMeshSubDev(String str, final IResultCallback iResultCallback) {
        final DeviceBean meshSubDevBean = getMeshSubDevBean(str);
        if (meshSubDevBean == null) {
            this.O00000Oo.removeMeshSubDev(str, iResultCallback);
            return;
        }
        TuyaSigMeshBean O00000o2 = O0O0o00.O000000o().O00000o(this.O00000o0);
        if (O00000o2 == null || O00000o2.getProvisionedMeshNode() == null || !meshSubDevBean.getIsLocalOnline().booleanValue() || meshSubDevBean.isBleMeshWifi()) {
            O000000o(meshSubDevBean, iResultCallback);
            return;
        }
        oo0oooo00 oo0oooo00 = new oo0oooo00();
        ArrayList arrayList = new ArrayList();
        arrayList.add(oo0oooo00);
        O000000o(arrayList, O00000o2, meshSubDevBean.getDevKey(), meshSubDevBean.getNodeId(), true, new IResultCallback() {
            public void onError(String str, String str2) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(str, str2);
                }
            }

            public void onSuccess() {
                O0O0o00.O000000o().O00000o(oo0oo00o0.this.O00000o0, meshSubDevBean.getNodeId());
                oo0oo00o0.this.O000000o(meshSubDevBean, iResultCallback);
            }
        });
    }

    public void renameMesh(String str, IResultCallback iResultCallback) {
        this.O00000Oo.renameMesh(str, iResultCallback);
    }

    public void renameMeshSubDev(String str, String str2, IResultCallback iResultCallback) {
        this.O00000Oo.renameMeshSubDev(str, str2, iResultCallback);
    }

    public void unRegisterMeshDevListener() {
        O0OOO0O o0ooo0o = this.O00000oO;
        if (o0ooo0o != null) {
            o0ooo0o.O00000Oo(this.O00000oo);
        }
    }
}
