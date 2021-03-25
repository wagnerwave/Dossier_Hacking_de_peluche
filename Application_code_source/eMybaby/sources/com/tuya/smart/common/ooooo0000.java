package com.tuya.smart.common;

import com.tuya.sdk.sigmesh.bean.ProvisionedMeshNode;
import com.tuya.sdk.sigmesh.bean.TuyaSigMeshBean;
import com.tuya.smart.common.o00o0o0o0o;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.bluemesh.ITuyaBlueMesh;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.ArrayList;
import java.util.List;

public class ooooo0000 implements oooo0ooo0 {
    public ITuyaBlueMesh O000000o;
    public String O00000Oo;

    public ooooo0000(String str) {
        this.O000000o = new O000OO00(str);
        this.O00000Oo = str;
    }

    private void O000000o(DeviceBean deviceBean, String str, IResultCallback iResultCallback) {
        if (deviceBean != null) {
            TuyaSigMeshBean O00000o = O0O0o00.O000000o().O00000o(this.O00000Oo);
            if (O00000o != null && O00000o.getProvisionedMeshNode() != null && deviceBean.getIsLocalOnline().booleanValue()) {
                O000000o(deviceBean.getNodeId(), deviceBean.getDevKey(), O00000o, O000000o(o000oo0o0o.O000000o(deviceBean.getNodeId()), o000oo0o0o.O000000o(str)), 0, iResultCallback);
            } else if (iResultCallback != null) {
                iResultCallback.onError("13006", "mesh_off_line");
            }
        } else if (iResultCallback != null) {
            iResultCallback.onError("11002", "device is remove");
        }
    }

    /* access modifiers changed from: private */
    public void O000000o(String str, String str2, TuyaSigMeshBean tuyaSigMeshBean, List<oo0oo0oo0> list, int i, IResultCallback iResultCallback) {
        if (i < list.size()) {
            byte[] O000000o2 = o000oo0o0o.O000000o(str);
            byte[] O00000o0 = oo0o0oooo.O000000o().O00000o0();
            ProvisionedMeshNode provisionedMeshNode = tuyaSigMeshBean.getProvisionedMeshNode();
            o000oo0000 O0000OoO = oo0o0oooo.O000000o().O0000OoO();
            byte[] O000000o3 = o00o0000oo.O000000o(str2);
            oo0oo0oo0 oo0oo0oo0 = list.get(i);
            final String str3 = str;
            final oo0oo0oo0 oo0oo0oo02 = oo0oo0oo0;
            final IResultCallback iResultCallback2 = iResultCallback;
            final String str4 = str2;
            final TuyaSigMeshBean tuyaSigMeshBean2 = tuyaSigMeshBean;
            final List<oo0oo0oo0> list2 = list;
            final int i2 = i;
            oo0oo0oo0.O000000o(provisionedMeshNode.getNodeMac(), O0000OoO, O00000o0, O000000o2, O000000o3, new o00o0o0o0o.O000000o() {
                public void O000000o(String str, String str2) {
                    IResultCallback iResultCallback = iResultCallback2;
                    if (iResultCallback != null) {
                        iResultCallback.onError(str, str2);
                    }
                }

                public void O00000Oo() {
                    new oooo0o00o(str3, oo0oo0oo02.O00000o0(), new IResultCallback() {
                        public void onError(String str, String str2) {
                            IResultCallback iResultCallback = iResultCallback2;
                            if (iResultCallback != null) {
                                iResultCallback.onError(str, str2);
                            }
                        }

                        public void onSuccess() {
                            AnonymousClass1 r0 = AnonymousClass1.this;
                            ooooo0000.this.O000000o(str3, str4, tuyaSigMeshBean2, list2, i2 + 1, iResultCallback2);
                        }
                    });
                }
            });
            oooo0o000.O000000o().O000000o(oo0o0oooo.O000000o().O0000OOo(), this.O00000Oo);
        } else if (iResultCallback != null) {
            iResultCallback.onSuccess();
        }
    }

    public List<oo0oo0oo0> O000000o(byte[] bArr, byte[] bArr2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new oo0ooo0o0(bArr, bArr2, 4096));
        arrayList.add(new oo0ooo0o0(bArr, bArr2, 4864));
        arrayList.add(new oo0ooo0o0(bArr, bArr2, 4870));
        arrayList.add(new oo0ooo0o0(bArr, bArr2, 4871));
        arrayList.add(new oo0ooo0o0(bArr, bArr2, 4867));
        arrayList.add(new oo0ooo0o0(bArr, bArr2, oooooo000.O0000Oo0));
        return arrayList;
    }

    public void O000000o() {
        ITuyaBlueMesh iTuyaBlueMesh = this.O000000o;
        if (iTuyaBlueMesh != null) {
            iTuyaBlueMesh.onDestroy();
        }
    }

    public void O000000o(String str, String str2, IResultCallback iResultCallback) {
        DeviceBean meshSubDevBean = this.O000000o.getMeshSubDevBean(str);
        if (meshSubDevBean != null) {
            TuyaSigMeshBean O00000o = O0O0o00.O000000o().O00000o(this.O00000Oo);
            if (O00000o != null && O00000o.getProvisionedMeshNode() != null && meshSubDevBean.getIsLocalOnline().booleanValue()) {
                O000000o(meshSubDevBean.getNodeId(), meshSubDevBean.getDevKey(), O00000o, O00000Oo(o000oo0o0o.O000000o(meshSubDevBean.getNodeId()), o000oo0o0o.O000000o(str2)), 0, iResultCallback);
            } else if (iResultCallback != null) {
                iResultCallback.onError("13006", "mesh_off_line");
            }
        } else if (iResultCallback != null) {
            iResultCallback.onError("11002", "device is remove");
        }
    }

    public void O000000o(String str, List<DeviceBean> list, IResultCallback iResultCallback) {
        for (DeviceBean O000000o2 : list) {
            O000000o(O000000o2, str, (IResultCallback) null);
        }
        iResultCallback.onSuccess();
    }

    public List<oo0oo0oo0> O00000Oo(byte[] bArr, byte[] bArr2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new oo0ooo00o(bArr, bArr2, 4096));
        arrayList.add(new oo0ooo00o(bArr, bArr2, 4864));
        arrayList.add(new oo0ooo00o(bArr, bArr2, 4870));
        arrayList.add(new oo0ooo00o(bArr, bArr2, 4871));
        arrayList.add(new oo0ooo00o(bArr, bArr2, 4867));
        arrayList.add(new oo0ooo00o(bArr, bArr2, oooooo000.O0000Oo0));
        return arrayList;
    }

    public void O00000Oo(String str, String str2, IResultCallback iResultCallback) {
        O000000o(this.O000000o.getMeshSubDevBean(str), str2, iResultCallback);
    }
}
