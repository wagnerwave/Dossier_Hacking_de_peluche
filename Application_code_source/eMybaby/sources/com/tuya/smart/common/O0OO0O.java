package com.tuya.smart.common;

import a.e.a.a.r.a;
import android.text.TextUtils;
import com.tuya.sdk.timer.bean.DpTimerBean;
import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshDevice;
import com.tuya.smart.android.blemesh.bean.DpsParseBean;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.bluemesh.IAddGroupCallback;
import com.tuya.smart.sdk.api.bluemesh.IAddSubDevCallback;
import com.tuya.smart.sdk.api.bluemesh.IMeshDevListener;
import com.tuya.smart.sdk.api.bluemesh.ITuyaBlueMesh;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class O0OO0O implements ITuyaBlueMeshDevice {
    public static final String O000000o = "TuyaBlueMeshDevice";
    public final ITuyaBlueMesh O00000Oo;
    public final O0Oo0o0 O00000o = new O0Oo0o0();
    public final String O00000o0;
    public final O0OOO00 O00000oO = new O0OOO00();
    public O0OOO0O O00000oo;
    public IMeshDevListener O0000O0o;
    public Timer O0000OOo = new Timer();

    public O0OO0O(String str) {
        this.O00000o0 = str;
        this.O00000Oo = new O000OO00(str);
    }

    public void addGroup(String str, String str2, String str3, IAddGroupCallback iAddGroupCallback) {
        String O000000o2 = OO00o00.O000000o(str2);
        o00o0o00oo O00000Oo2 = O0O0o00.O000000o().O00000Oo(this.O00000o0);
        if (O00000Oo2 != null) {
            this.O00000oO.O000000o(O00000Oo2, O000000o2, str3, (IResultCallback) null);
        }
        if (isCloudOnline()) {
            this.O00000Oo.publishRawData(this.O00000oO.O00000Oo(a.c(O000000o2), str3), (IResultCallback) null);
        }
        this.O00000Oo.addGroup(str, O000000o2, str3, iAddGroupCallback);
    }

    public void addSubDev(String str, String str2, String str3, String str4, String str5, IAddSubDevCallback iAddSubDevCallback) {
        this.O00000Oo.addSubDev(str, str2, str3, str4, str5, iAddSubDevCallback);
    }

    public void addSubDev(String str, String str2, String str3, String str4, String str5, String str6, String str7, IAddSubDevCallback iAddSubDevCallback) {
        this.O00000Oo.addSubDev(str, str2, str3, str4, str5, str6, str7, iAddSubDevCallback);
    }

    public void broadcastDps(String str, String str2, IResultCallback iResultCallback) {
        String O000000o2 = OO00o00.O000000o(str);
        if (isCloudOnline()) {
            this.O00000Oo.broadcastDps(O000000o2, str2, iResultCallback);
        } else if (iResultCallback != null) {
            iResultCallback.onError("13006", "mesh_off_line");
        }
    }

    public void getDataByDpIds(String str, List<Integer> list, IResultCallback iResultCallback) {
        this.O00000Oo.getDataByDpIds(str, list, iResultCallback);
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
        String O000000o2 = OO00o00.O000000o(str2);
        o00o0o00oo O00000Oo2 = O0O0o00.O000000o().O00000Oo(this.O00000o0);
        if (O00000Oo2 != null) {
            DpsParseBean O00000Oo3 = OO00o00.O00000Oo(str3, O000000o2);
            if (O00000Oo3 != null) {
                this.O00000o.O000000o(O00000Oo2, str, O000000o2, O00000Oo3, iResultCallback);
                return;
            }
        } else if (isCloudOnline()) {
            Object O00000o02 = OO00o00.O00000o0(str3, O000000o2);
            if (O00000o02 != null) {
                if (O00000o02 instanceof String) {
                    this.O00000Oo.multicastDps(str, O000000o2, (String) O00000o02, iResultCallback);
                    return;
                } else if (O00000o02 instanceof DpsParseBean) {
                    this.O00000Oo.publishRawData(this.O00000o.O000000o(O000000o2, str, (DpsParseBean) O00000o02), iResultCallback);
                    return;
                } else {
                    return;
                }
            }
        } else if (iResultCallback != null) {
            iResultCallback.onError("13006", "mesh_off_line");
            return;
        } else {
            return;
        }
        iResultCallback.onError("11001", "this device not support publish");
    }

    public void onDestroy() {
        ITuyaBlueMesh iTuyaBlueMesh = this.O00000Oo;
        if (iTuyaBlueMesh != null) {
            iTuyaBlueMesh.onDestroy();
        }
        Timer timer = this.O0000OOo;
        if (timer != null) {
            timer.cancel();
        }
    }

    public void publishDps(String str, String str2, DpsParseBean dpsParseBean, final IResultCallback iResultCallback) {
        String O000000o2 = OO00o00.O000000o(str);
        DeviceBean meshSubDevBeanByNodeId = this.O00000Oo.getMeshSubDevBeanByNodeId(str2);
        if (meshSubDevBeanByNodeId == null) {
            iResultCallback.onError("11002", "device is remove");
            return;
        }
        o00o0o00oo O00000Oo2 = O0O0o00.O000000o().O00000Oo(this.O00000o0);
        if (O00000Oo2 == null || !meshSubDevBeanByNodeId.getIsLocalOnline().booleanValue()) {
            if (isCloudOnline()) {
                this.O00000Oo.publishRawData(this.O00000o.O000000o(O000000o2, str2, dpsParseBean), new IResultCallback() {
                    public void onError(String str, String str2) {
                        L.e(O0OO0O.O000000o, "publishRawData error " + str + "   " + str2);
                        IResultCallback iResultCallback = iResultCallback;
                        if (iResultCallback != null) {
                            iResultCallback.onError(str, str2);
                        }
                    }

                    public void onSuccess() {
                        L.d(O0OO0O.O000000o, "publishRawData onSuccess ");
                        IResultCallback iResultCallback = iResultCallback;
                        if (iResultCallback != null) {
                            iResultCallback.onSuccess();
                        }
                    }
                });
            } else if (iResultCallback != null) {
                iResultCallback.onError("13006", "mesh_off_line");
            }
        } else if (dpsParseBean != null) {
            this.O00000o.O000000o(O00000Oo2, str2, O000000o2, dpsParseBean, iResultCallback);
        }
    }

    public void publishDps(String str, String str2, String str3, IResultCallback iResultCallback) {
        String O000000o2 = OO00o00.O000000o(str2);
        DeviceBean meshSubDevBeanByNodeId = this.O00000Oo.getMeshSubDevBeanByNodeId(str);
        if (meshSubDevBeanByNodeId == null) {
            iResultCallback.onError("11002", "device is remove");
            return;
        }
        o00o0o00oo O00000Oo2 = O0O0o00.O000000o().O00000Oo(this.O00000o0);
        if (O00000Oo2 != null && meshSubDevBeanByNodeId.getIsLocalOnline().booleanValue()) {
            DpsParseBean O000000o3 = OO00o00.O000000o(str3, O000000o2);
            if (O000000o3 != null) {
                this.O00000o.O000000o(O00000Oo2, str, O000000o2, O000000o3, iResultCallback);
                return;
            }
        } else if (isCloudOnline()) {
            Object O00000o02 = OO00o00.O00000o0(str3, O000000o2);
            if (O00000o02 != null) {
                if (O00000o02 instanceof String) {
                    this.O00000Oo.publishDps(str, O000000o2, (String) O00000o02, iResultCallback);
                    return;
                } else if (O00000o02 instanceof DpsParseBean) {
                    this.O00000Oo.publishRawData(this.O00000o.O000000o(O000000o2, str, (DpsParseBean) O00000o02), iResultCallback);
                    return;
                } else {
                    return;
                }
            }
        } else if (iResultCallback != null) {
            iResultCallback.onError("13006", "mesh_off_line");
            return;
        } else {
            return;
        }
        iResultCallback.onError("11001", "this device not support publish");
    }

    public void publishRawData(byte[] bArr, IResultCallback iResultCallback) {
        this.O00000Oo.publishRawData(bArr, iResultCallback);
    }

    public void queryAllOnLineStatusByLocal(IResultCallback iResultCallback) {
        o00o0o00oo O00000Oo2 = O0O0o00.O000000o().O00000Oo(this.O00000o0);
        StringBuilder n = a.a.a.a.a.n("queryAllOnLineStatusByLocal ");
        n.append(this.O00000o0);
        n.append(DpTimerBean.FILL);
        n.append(O00000Oo2);
        L.e(O000000o, n.toString());
        if (O00000Oo2 != null) {
            this.O00000o.O00000Oo(O00000Oo2, iResultCallback);
        }
    }

    public void queryAllStatusByLocal(final IResultCallback iResultCallback) {
        o00o0o00oo O00000Oo2 = O0O0o00.O000000o().O00000Oo(this.O00000o0);
        if (O00000Oo2 != null) {
            this.O00000o.O000000o(O00000Oo2, iResultCallback);
        } else if (isCloudOnline()) {
            this.O00000Oo.publishRawData(this.O00000o.O000000o(1025), new IResultCallback() {
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
            });
        } else if (iResultCallback != null) {
            iResultCallback.onError("13006", "mesh_off_line");
        }
    }

    public void querySubDevStatusByLocal(String str, final String str2, IResultCallback iResultCallback) {
        final String O000000o2 = OO00o00.O000000o(str);
        DeviceBean meshSubDevBeanByNodeId = this.O00000Oo.getMeshSubDevBeanByNodeId(str2);
        if (meshSubDevBeanByNodeId != null) {
            o00o0o00oo O00000Oo2 = O0O0o00.O000000o().O00000Oo(this.O00000o0);
            List<DpsParseBean> O00000Oo3 = OO00o00.O00000Oo(O000000o2).O00000Oo();
            if (O00000Oo3 != null && !O00000Oo3.isEmpty()) {
                if (O00000Oo2 != null && meshSubDevBeanByNodeId.getIsLocalOnline().booleanValue()) {
                    StringBuilder n = a.a.a.a.a.n("call ready:");
                    n.append(System.currentTimeMillis());
                    n.append(DpTimerBean.FILL);
                    L.e(O000000o, n.toString());
                    for (int i = 0; i < O00000Oo3.size(); i++) {
                        final DpsParseBean dpsParseBean = O00000Oo3.get(i);
                        final o00o0o00oo o00o0o00oo = O00000Oo2;
                        final String str3 = str2;
                        final String str4 = O000000o2;
                        this.O0000OOo.schedule(new TimerTask() {
                            public void run() {
                                StringBuilder n = a.a.a.a.a.n("call:");
                                n.append(System.currentTimeMillis());
                                n.append(DpTimerBean.FILL);
                                L.e(O0OO0O.O000000o, n.toString());
                                O0OO0O.this.O00000o.O000000o(o00o0o00oo, str3, str4, dpsParseBean, (IResultCallback) null);
                            }
                        }, (long) (i * 350));
                    }
                    if (iResultCallback == null) {
                        return;
                    }
                } else if (isCloudOnline()) {
                    for (int i2 = 0; i2 < O00000Oo3.size(); i2++) {
                        final DpsParseBean dpsParseBean2 = O00000Oo3.get(i2);
                        this.O0000OOo.schedule(new TimerTask() {
                            public void run() {
                                StringBuilder n = a.a.a.a.a.n("call:");
                                n.append(System.currentTimeMillis());
                                n.append(DpTimerBean.FILL);
                                L.e(O0OO0O.O000000o, n.toString());
                                O0OO0O.this.O00000Oo.publishRawData(O0OO0O.this.O00000o.O000000o(O000000o2, str2, dpsParseBean2), new IResultCallback() {
                                    public void onError(String str, String str2) {
                                        L.e(O0OO0O.O000000o, "publishRawData error " + str + "   " + str2);
                                    }

                                    public void onSuccess() {
                                        L.d(O0OO0O.O000000o, "publishRawData onSuccess ");
                                    }
                                });
                            }
                        }, (long) (i2 * 500));
                    }
                    if (iResultCallback == null) {
                        return;
                    }
                } else if (iResultCallback != null) {
                    iResultCallback.onError("10202", "device is offline");
                    return;
                } else {
                    return;
                }
                iResultCallback.onSuccess();
            } else if (iResultCallback != null) {
                iResultCallback.onSuccess();
            }
        } else if (iResultCallback != null) {
            iResultCallback.onError("11002", "device is remove");
        }
    }

    public void registerMeshDevListener(IMeshDevListener iMeshDevListener) {
        if (this.O00000oo == null) {
            this.O00000oo = O0OOO0O.O000000o(this.O00000o0);
        }
        this.O0000O0o = iMeshDevListener;
        this.O00000oo.O000000o(iMeshDevListener);
    }

    public void removeMesh(IResultCallback iResultCallback) {
        this.O00000Oo.removeMesh(iResultCallback);
    }

    public void removeMeshSubDev(final String str, final IResultCallback iResultCallback) {
        final DeviceBean meshSubDevBean = getMeshSubDevBean(str);
        if (meshSubDevBean == null) {
            this.O00000Oo.removeMeshSubDev(str, iResultCallback);
            return;
        }
        String O000000o2 = OO00o00.O000000o(meshSubDevBean.getCategory());
        o00o0o00oo O00000Oo2 = O0O0o00.O000000o().O00000Oo(this.O00000o0);
        if (O00000Oo2 != null && meshSubDevBean.getIsLocalOnline().booleanValue()) {
            this.O00000o.O000000o(O00000Oo2, O000000o2, meshSubDevBean.getNodeId(), new IResultCallback() {
                public void onError(String str, String str2) {
                    IResultCallback iResultCallback = iResultCallback;
                    if (iResultCallback != null) {
                        iResultCallback.onError(str, str2);
                    }
                }

                public void onSuccess() {
                    O0O0o00.O000000o().O00000o(O0OO0O.this.O00000o0, meshSubDevBean.getNodeId());
                    O0OO0O.this.O00000Oo.removeMeshSubDev(meshSubDevBean.getDevId(), iResultCallback);
                }
            });
        } else if (!this.O00000Oo.isCloudOnline() || TextUtils.isEmpty(this.O00000o0)) {
            this.O00000Oo.removeMeshSubDev(str, iResultCallback);
        } else {
            this.O00000Oo.publishRawData(this.O00000o.O000000o(a.c(O000000o2), meshSubDevBean.getNodeId()), new IResultCallback() {
                public void onError(String str, String str2) {
                    IResultCallback iResultCallback = iResultCallback;
                    if (iResultCallback != null) {
                        iResultCallback.onError(str, str2);
                    }
                }

                public void onSuccess() {
                    O0OO0O.this.O00000Oo.removeMeshSubDev(str, iResultCallback);
                }
            });
        }
    }

    public void renameMesh(String str, IResultCallback iResultCallback) {
        this.O00000Oo.renameMesh(str, iResultCallback);
    }

    public void renameMeshSubDev(String str, String str2, IResultCallback iResultCallback) {
        this.O00000Oo.renameMeshSubDev(str, str2, iResultCallback);
    }

    public void unRegisterMeshDevListener() {
        O0OOO0O o0ooo0o = this.O00000oo;
        if (o0ooo0o != null) {
            o0ooo0o.O00000Oo(this.O0000O0o);
        }
    }
}
