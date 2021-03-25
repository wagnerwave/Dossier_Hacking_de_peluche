package com.tuya.smart.common;

import a.e.a.a.a;
import a.e.a.a.o.h.b;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tuya.sdk.sigmesh.bean.AccessMessage;
import com.tuya.sdk.sigmesh.bean.ControlMessage;
import com.tuya.sdk.sigmesh.bean.Message;
import com.tuya.sdk.sigmesh.bean.TuyaSigMeshBean;
import com.tuya.sdk.sigmesh.presenter.TuyaSigMeshConnectImpl$1;
import com.tuya.sdk.sigmesh.util.ExtendedInvalidCipherTextException;
import com.tuya.smart.android.blemesh.bean.MeshClientStatusEnum;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.mvp.bean.Result;
import com.tuya.smart.android.mvp.presenter.BasePresenter;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.common.o00o0o0o0o;
import com.tuya.smart.common.oo0oo000o;
import com.tuya.smart.common.ooo00oo0o;
import com.tuya.smart.common.ooo0oo0o0;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.bluemesh.ITuyaBlueMesh;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.SigMeshBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class o000000o0o extends BasePresenter implements O0Oo {
    public static final int O000000o = 273;
    public static final int O00000o = 546;
    public static final String O00000o0 = "TuyaSigMeshConnectImpl";
    public static final int O00000oO = 69717;
    public int O00000Oo = 1;
    public a O00000oo = o00o0o0o00.O000000o().O00000Oo();
    public TuyaSigMeshBean O0000O0o;
    public ooooo0o0o O0000OOo;
    public oo0oo000o.O000000o O0000Oo;
    public String O0000Oo0;
    public boolean O0000OoO;
    public long O0000Ooo = -1;
    public o000oo0000 O0000o = oo0o0oooo.O000000o().O0000OoO();
    public ooo0oo0o0 O0000o0;
    public SearchDeviceBean O0000o00;
    public ITuyaBlueMesh O0000o0O;
    public ooooo0oo0 O0000o0o = new ooooo0oo0(TuyaSdk.getApplication(), this.O0000o);
    public b O0000oO = new TuyaSigMeshConnectImpl$1(this);
    public boolean O0000oO0;

    /* access modifiers changed from: private */
    public void O000000o(int i) {
        oo0o0oooo.O000000o().O000000o(this.O0000O0o.getProvisionedMeshNode(), this.O0000O0o.getMeshkey(), this.O0000O0o.getName(), o000oo0o0o.O000000o(i), new o000oo00o0() {
            public void O000000o(ControlMessage controlMessage) {
            }

            public byte[] O000000o(byte[] bArr) {
                int O00000Oo = o000oo0o0o.O00000Oo(bArr);
                DeviceBean meshSubDevBeanByNodeId = o000000o0o.this.O0000o0O.getMeshSubDevBeanByNodeId(String.format("%04x", new Object[]{Integer.valueOf(O00000Oo)}));
                if (meshSubDevBeanByNodeId != null) {
                    return o00o0000oo.O000000o(meshSubDevBeanByNodeId.getDevKey());
                }
                return null;
            }
        });
    }

    private void O000000o(final SearchDeviceBean searchDeviceBean) {
        this.O0000o0 = new ooo0oo0o0(searchDeviceBean.getMacAdress(), new ooo0oo0o0.O000000o() {
            public void O000000o(String str) {
                o000000o0o.this.O00000Oo(searchDeviceBean);
            }

            public void O000000o(String str, String str2) {
                if (o000000o0o.this.O0000OOo == null || o000000o0o.this.O0000OOo.O00000oo() == MeshClientStatusEnum.CONNECTED) {
                    o000000o0o o000000o0o = o000000o0o.this;
                    if (o000000o0o.O00000Oo > 0) {
                        L.e(o000000o0o.O00000o0, "try enable notify");
                        o000000o0o o000000o0o2 = o000000o0o.this;
                        o000000o0o2.O00000Oo--;
                        o000000o0o2.O0000OOo.O00000o();
                        o000000o0o.this.mHandler.postDelayed(new Runnable() {
                            public void run() {
                                o000000o0o.this.O0000OOo.O000000o((o00o0o0o0o.O000000o) new o00o0o0o0o.O000000o() {
                                    public void O000000o(String str, String str2) {
                                        if (o000000o0o.this.O0000Oo != null) {
                                            o000000o0o.this.O0000Oo.O000000o(str, str2);
                                        }
                                        o000000o0o.this.O0000Oo0();
                                    }

                                    public void O00000Oo() {
                                        o000000o0o.this.O0000o0.O00000o0();
                                    }
                                });
                            }
                        }, 2000);
                        return;
                    }
                    if (o000000o0o.O0000Oo != null) {
                        o000000o0o.this.O0000Oo.O000000o(str, str2);
                    }
                    o000000o0o.this.O0000Oo0();
                    return;
                }
                L.e(o000000o0o.O00000o0, "login status not connected ,do not handle notify error");
            }

            public void O000000o(final byte[] bArr) {
                AsyncTask.execute(new Runnable() {
                    public void run() {
                        o000000o0o.this.O000000o(bArr);
                    }
                });
            }

            public void O00000Oo() {
            }
        });
        this.mHandler.postDelayed(new Runnable() {
            public void run() {
                o000000o0o.this.O0000o0.O00000o0();
            }
        }, 200);
    }

    private void O000000o(final Business.ResultListener<Integer> resultListener) {
        new O0OOo().O00000Oo(this.O0000O0o.getMeshId(), new Business.ResultListener<Integer>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Integer num, String str) {
                L.d(o000000o0o.O00000o0, "getProvisionerAddress fail random");
                resultListener.onSuccess(businessResponse, Integer.valueOf(new Random().nextInt(8191) + 24576), str);
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Integer num, String str) {
                resultListener.onSuccess(businessResponse, num, str);
            }
        });
    }

    private void O000000o(o000o0ooo0 o000o0ooo0) {
        o000000000 O000000o2 = o0000000o0.O000000o(o000o0ooo0);
        if (O000000o2 != null) {
            String O000000o3 = O000000o2.O000000o(this.O0000O0o.getMeshId(), o000o0ooo0);
            String format = String.format("%04x", new Object[]{Integer.valueOf(o000o0ooo0.O0000oOO() & 65528)});
            if (!TextUtils.isEmpty(O000000o3)) {
                DeviceBean subDeviceBeanByNodeId = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O0000OOo().getSubDeviceBeanByNodeId(this.O0000O0o.getMeshId(), format);
                if (subDeviceBeanByNodeId == null || TextUtils.equals(o0000000o0.O00000o0(subDeviceBeanByNodeId.getCategory()), "01") || !(o000o0ooo0 instanceof o0000o00o0)) {
                    O0000o.O000000o(this.O0000O0o.getMeshId(), format, (String) null, -2, O000000o3);
                } else {
                    L.d(O00000o0, "vendor device only change status");
                }
            }
            if (o000o0ooo0 instanceof o0000o00o0) {
                ooooo0o00.O000000o().O000000o(this.O0000O0o.getMeshId(), format, true);
                ArrayList arrayList = new ArrayList();
                arrayList.add(format);
                a.a.a.a.a.v("online: ", format, O00000o0);
                O0000o.O000000o(this.O0000O0o.getMeshId(), arrayList, (List<String>) null);
            }
        }
        if (o000o0ooo0 != null) {
            O0000o.O000000o(o000o0ooo0);
        } else {
            L.e(O00000o0, "not match accessMessage");
        }
    }

    private void O000000o(final IResultCallback iResultCallback) {
        int O00000o2 = oooo0o000.O000000o().O00000o(this.O0000Oo0);
        if (O00000o2 == 0) {
            new O0OOo().O00000Oo(this.O0000Oo0, new Business.ResultListener<Integer>() {
                /* renamed from: O000000o */
                public void onFailure(BusinessResponse businessResponse, Integer num, String str) {
                    L.d(o000000o0o.O00000o0, "getProvisionerAddress fail random");
                    Integer valueOf = Integer.valueOf(new Random().nextInt(8191) + 24576);
                    oooo0o000.O000000o().O00000Oo(valueOf.intValue(), o000000o0o.this.O0000Oo0);
                    o000000o0o.this.O000000o(valueOf.intValue());
                }

                /* renamed from: O00000Oo */
                public void onSuccess(BusinessResponse businessResponse, Integer num, String str) {
                    L.d(o000000o0o.O00000o0, "getProvisionerAddress success " + num);
                    oooo0o000.O000000o().O00000Oo(num.intValue(), o000000o0o.this.O0000Oo0);
                    o000000o0o.this.O000000o(num.intValue());
                    o000000o0o.this.mHandler.post(new Runnable() {
                        public void run() {
                            iResultCallback.onSuccess();
                        }
                    });
                }
            });
            return;
        }
        O000000o(O00000o2);
        iResultCallback.onSuccess();
    }

    /* access modifiers changed from: private */
    public synchronized void O000000o(byte[] bArr) {
        String str;
        String str2;
        String str3;
        String str4;
        L.d(O00000o0, "onCommandNotify");
        if (bArr != null) {
            if (bArr[0] == 0) {
                try {
                    Message O00000o2 = this.O0000o.O00000o(bArr);
                    if (O00000o2 == null) {
                        str3 = O00000o0;
                        str4 = "Message reassembly may not be completed yet!";
                    } else if (O00000o2 instanceof ControlMessage) {
                        this.O0000o0o.O000000o((ControlMessage) O00000o2, oo0o0oooo.O000000o().O0000O0o());
                    } else {
                        o000o0ooo0 O000000o2 = this.O0000o0o.O000000o((AccessMessage) O00000o2);
                        if (O000000o2 != null) {
                            O000000o(O000000o2);
                        } else {
                            str3 = O00000o0;
                            str4 = "parse access message is fail";
                        }
                    }
                    L.d(str3, str4);
                } catch (ExtendedInvalidCipherTextException e2) {
                    str = O00000o0;
                    str2 = "Decryption failed in " + e2.getTag() + " : " + e2.getMessage();
                    L.e(str, str2);
                } catch (IllegalArgumentException e3) {
                    str = O00000o0;
                    str2 = "IllegalArgumentException " + e3.getMessage();
                    L.e(str, str2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void O00000Oo(SearchDeviceBean searchDeviceBean) {
        O0O0o00.O000000o().O000000o(this.O0000O0o.getMeshId(), this.O0000O0o);
        final DeviceBean meshSubDevBeanByMac = this.O0000o0O.getMeshSubDevBeanByMac(o00oo00ooo.O00000Oo(searchDeviceBean.getMacAdress()));
        O000000o((IResultCallback) new IResultCallback() {
            public void onError(String str, String str2) {
            }

            public void onSuccess() {
                oo0o0oooo.O000000o().O00000o0(oooo0o000.O000000o().O00000o0(o000000o0o.this.O0000Oo0) + 1000);
                DeviceBean deviceBean = meshSubDevBeanByMac;
                if (deviceBean != null) {
                    String nodeId = deviceBean.getNodeId();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(String.valueOf(nodeId));
                    ooooo0o00.O000000o().O000000o(o000000o0o.this.O0000O0o.getMeshId(), nodeId, true);
                    O0000o.O000000o(o000000o0o.this.O0000O0o.getMeshId(), arrayList, (List<String>) null);
                    L.d(o000000o0o.O00000o0, "sendEmptyMessageDelayed WHAT_QUREY_STATE");
                    o000000o0o.this.mHandler.sendEmptyMessageDelayed(o000000o0o.O00000o, 500);
                    if (o000000o0o.this.O0000Oo != null) {
                        o000000o0o.this.O0000Oo.O000000o(o000000o0o.this.O0000O0o);
                    }
                }
            }
        });
    }

    private void O00000o0(SearchDeviceBean searchDeviceBean) {
        new ooo00oo0o(searchDeviceBean.getMacAdress(), o00o0000o0.O000000o, new ooo00oo0o.O000000o() {
            public void O000000o(Integer num) {
                L.d(o000000o0o.O00000o0, "mtuConfig success  mtu:" + num);
                oo0o0oooo.O000000o().O000000o(num.intValue());
            }

            public void O000000o(String str, String str2) {
                a.a.a.a.a.v("mtuConfig fail ", str, o000000o0o.O00000o0);
            }
        }).O000000o();
    }

    private void O0000OOo() {
        L.d(O00000o0, "afterDisConnect  change status");
        String meshId = this.O0000O0o.getMeshId();
        O0O0o00.O000000o().O00000o0(meshId);
        List<DeviceBean> meshSubDevList = new oo0oo00o0(meshId).getMeshSubDevList();
        if (meshSubDevList != null) {
            ArrayList arrayList = new ArrayList();
            for (DeviceBean next : meshSubDevList) {
                next.setLocalOnline(Boolean.FALSE);
                ooooo0o00.O000000o().O000000o(meshId, next.getNodeId(), false);
                arrayList.add(next.getNodeId());
            }
            O0000o.O000000o(meshId, (List<String>) null, arrayList);
        }
    }

    /* access modifiers changed from: private */
    public void O0000Oo() {
        StringBuilder n = a.a.a.a.a.n("startSearchForLimit  ");
        n.append(this.O0000Ooo);
        L.d(O00000o0, n.toString());
        O0000OoO();
        this.mHandler.removeMessages(273);
        this.mHandler.sendEmptyMessageDelayed(273, 2000);
    }

    /* access modifiers changed from: private */
    public void O0000Oo0() {
        this.O00000Oo = 1;
        ooooo0o0o ooooo0o0o = this.O0000OOo;
        if (ooooo0o0o != null) {
            ooooo0o0o.O00000o0();
        }
    }

    private void O0000OoO() {
        StringBuilder n = a.a.a.a.a.n("limitSearchTime  ");
        n.append(this.O0000Ooo);
        L.d(O00000o0, n.toString());
        if (this.O0000Ooo != -1) {
            this.mHandler.removeMessages(O00000oO);
            this.mHandler.sendEmptyMessageDelayed(O00000oO, this.O0000Ooo);
        }
    }

    public void O000000o() {
        this.O0000OoO = true;
        this.O00000Oo = 1;
        this.mHandler.removeMessages(273);
        ooo0oo0o0 ooo0oo0o0 = this.O0000o0;
        if (ooo0oo0o0 != null) {
            ooo0oo0o0.O00000oO();
        }
        O0000Oo0();
        if (this.O0000O0o != null) {
            O0O0o00.O000000o().O00000oO(this.O0000O0o.getMeshId());
            String macAdress = this.O0000O0o.getMacAdress();
            if (!TextUtils.isEmpty(macAdress)) {
                this.O00000oo.d(macAdress);
            }
        }
        b bVar = this.O0000oO;
        if (bVar != null) {
            this.O00000oo.f3191a.i(bVar);
        }
    }

    public void O000000o(SigMeshBean sigMeshBean, oo0oo000o.O000000o o000000o) {
        O000000o(sigMeshBean, -1, o000000o);
    }

    public void O00000Oo() {
        this.O0000oO0 = false;
        ooooo0o0o ooooo0o0o = this.O0000OOo;
        if (ooooo0o0o == null || ooooo0o0o.O00000oo() != MeshClientStatusEnum.INIT) {
            ooooo0o0o ooooo0o0o2 = this.O0000OOo;
            if (ooooo0o0o2 != null && ooooo0o0o2.O00000oo() == MeshClientStatusEnum.SEARCH) {
                O0000OoO();
                return;
            }
            return;
        }
        L.d(O00000o0, "startSearch");
        O0000Oo();
    }

    public MeshClientStatusEnum O00000o() {
        ooooo0o0o ooooo0o0o = this.O0000OOo;
        return ooooo0o0o != null ? ooooo0o0o.O00000oo() : MeshClientStatusEnum.INIT;
    }

    public void O00000o0() {
        this.O0000oO0 = true;
        this.mHandler.removeMessages(273);
        this.mHandler.removeMessages(O00000oO);
        if (this.O0000OOo != null) {
            L.d(O00000o0, "stopSearch");
            this.O0000OOo.O00000oO();
        }
    }

    public boolean O00000oO() {
        ooooo0o0o ooooo0o0o = this.O0000OOo;
        return ooooo0o0o != null && ooooo0o0o.O00000oo() == MeshClientStatusEnum.CONNECTED;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.O0000o00;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String O00000oo() {
        /*
            r1 = this;
            boolean r0 = r1.O00000oO()
            if (r0 == 0) goto L_0x0013
            com.tuya.smart.android.blemesh.bean.SearchDeviceBean r0 = r1.O0000o00
            if (r0 == 0) goto L_0x0013
            int r0 = r0.getMeshAddress()
            java.lang.String r0 = a.e.a.a.r.a.d(r0)
            return r0
        L_0x0013:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.o000000o0o.O00000oo():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.O0000o00;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String O0000O0o() {
        /*
            r1 = this;
            boolean r0 = r1.O00000oO()
            if (r0 == 0) goto L_0x000f
            com.tuya.smart.android.blemesh.bean.SearchDeviceBean r0 = r1.O0000o00
            if (r0 == 0) goto L_0x000f
            java.lang.String r0 = r0.getMacAdress()
            return r0
        L_0x000f:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.o000000o0o.O0000O0o():java.lang.String");
    }

    public boolean handleMessage(android.os.Message message) {
        if (message.what == 4083) {
            O0000OOo();
        }
        if (this.O0000OoO) {
            return true;
        }
        int i = message.what;
        if (i == 273) {
            L.d(O00000o0, "start_search");
            if (this.O00000oo == null) {
                throw null;
            } else if (!a.c.a.f.b.Q() || this.O0000oO0) {
                L.d(O00000o0, "bluetoothClosed or stopSearch");
                return false;
            } else {
                ooooo0o0o ooooo0o0o = this.O0000OOo;
                if (ooooo0o0o == null) {
                    return false;
                }
                ooooo0o0o.O000000o();
                return false;
            }
        } else if (i == 546) {
            L.d(O00000o0, "query state");
            new oo0oo00o0(this.O0000O0o.getMeshId()).queryAllOnLineStatusByLocal((IResultCallback) null);
            return false;
        } else if (i == 4081) {
            L.d(O00000o0, "search_failure");
            if (this.O0000oO0) {
                return false;
            }
            this.mHandler.removeMessages(273);
            this.mHandler.sendEmptyMessageDelayed(273, 1000);
            return false;
        } else if (i != 69717) {
            switch (i) {
                case ooooo0o0o.O00000Oo /*4083*/:
                    L.d(O00000o0, "connect_disconnect");
                    O0000Oo0();
                    break;
                case ooooo0o0o.O00000o0 /*4084*/:
                case ooooo0o0o.O00000o /*4085*/:
                    O0000Oo0();
                    L.d(O00000o0, "login failure or connect failure");
                    break;
                case ooooo0o0o.O00000oO /*4086*/:
                    this.O0000o00 = (SearchDeviceBean) ((Result) message.obj).getObj();
                    StringBuilder n = a.a.a.a.a.n("connect success :");
                    n.append(this.O0000o00.getVendorId());
                    L.d(O00000o0, n.toString());
                    this.O0000O0o = o00oo0ooo0.O000000o(this.O0000O0o, this.O0000o00, this.O0000o0O.getMeshSubDevBeanByMac(o00oo00ooo.O00000Oo(this.O0000o00.getMacAdress())));
                    O000000o(this.O0000o00);
                    O00000o0(this.O0000o00);
                    return false;
                default:
                    return false;
            }
            O0000Oo();
            return false;
        } else {
            this.mHandler.removeMessages(273);
            if (this.O0000OOo == null) {
                return false;
            }
            L.e(O00000o0, "timeLimit stopSearch");
            this.O0000OOo.O00000oO();
            return false;
        }
    }

    public void O000000o(SigMeshBean sigMeshBean, long j, oo0oo000o.O000000o o000000o) {
        this.O0000Ooo = j;
        this.O0000Oo = o000000o;
        this.O0000OoO = false;
        this.O0000oO0 = false;
        TuyaSigMeshBean tuyaSigMeshBean = new TuyaSigMeshBean(sigMeshBean);
        this.O0000O0o = tuyaSigMeshBean;
        this.O0000Oo0 = tuyaSigMeshBean.getMeshId();
        this.O0000o0O = new O000OO00(this.O0000O0o.getMeshId());
        ooooo0o0o ooooo0o0o = this.O0000OOo;
        if (ooooo0o0o != null) {
            ooooo0o0o.onDestroy();
            this.O0000OOo = null;
        }
        ooooo0o0o ooooo0o0o2 = new ooooo0o0o(sigMeshBean, this.mHandler);
        this.O0000OOo = ooooo0o0o2;
        ooooo0o0o2.O000000o();
        O0000OoO();
        a aVar = this.O00000oo;
        aVar.f3191a.n(this.O0000oO);
    }
}
