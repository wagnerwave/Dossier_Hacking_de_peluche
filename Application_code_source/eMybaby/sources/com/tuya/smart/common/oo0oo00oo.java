package com.tuya.smart.common;

import a.a.a.a.a;
import com.inuker.bluetooth.library.model.BleGattService;
import com.tuya.sdk.sigmesh.bean.TuyaSigMeshBean;
import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshOta;
import com.tuya.smart.android.blemesh.api.MeshUpgradeListener;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.android.blemesh.builder.TuyaBlueMeshOtaBuilder;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.mvp.presenter.BasePresenter;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.common.o00o0oo0oo;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.List;
import java.util.UUID;

public class oo0oo00oo extends BasePresenter implements ITuyaBlueMeshOta, o00o0oo0oo.O000000o {
    public static final String O000000o = "TuyaSigMeshOtaImpl";
    public O00o O00000Oo = new O00o() {
        public void O000000o(SearchDeviceBean searchDeviceBean, String str) {
        }

        public void O000000o(SearchDeviceBean searchDeviceBean, String str, String str2) {
            oo0oo00oo.this.O0000O0o.onFail(String.valueOf(O0o00.O00000o), "connect fail");
        }

        public void O000000o(SearchDeviceBean searchDeviceBean, boolean z) {
            L.d(oo0oo00oo.O000000o, "login_success");
            boolean unused = oo0oo00oo.this.O0000o00 = z;
            SearchDeviceBean unused2 = oo0oo00oo.this.O0000o0 = searchDeviceBean;
            if (z) {
                L.d(oo0oo00oo.O000000o, "reconnect login_success");
                oo0oo00oo.this.mHandler.postDelayed(new Runnable() {
                    public void run() {
                        oo0oo00oo.this.O00000o();
                    }
                }, 1000);
            }
        }

        public void O000000o(List<BleGattService> list) {
            int i = 0;
            while (true) {
                if (i >= list.size()) {
                    break;
                }
                UUID g = list.get(i).g();
                StringBuilder n = a.n("serviceUid: ");
                n.append(g.toString());
                L.e(oo0oo00oo.O000000o, n.toString());
                if (g.equals(o00o00o000.O0000OoO)) {
                    L.e(oo0oo00oo.O000000o, "found new ota service");
                    boolean unused = oo0oo00oo.this.O0000Ooo = true;
                    break;
                }
                i++;
            }
            oo0oo00oo.this.mHandler.postDelayed(new Runnable() {
                public void run() {
                    if (!oo0oo00oo.this.O0000o00) {
                        oo0oo00oo oo0oo00oo = oo0oo00oo.this;
                        oo0oo00oo.O000000o(oo0oo00oo.O0000o0);
                        oo0oo00oo.this.O00000o0();
                    }
                }
            }, 500);
        }
    };
    public String O00000o;
    public oooo0o0o0 O00000o0;
    public String O00000oO;
    public byte[] O00000oo;
    public MeshUpgradeListener O0000O0o;
    public TuyaSigMeshBean O0000OOo;
    public String O0000Oo;
    public o00o0oo0oo O0000Oo0;
    public String O0000OoO;
    public boolean O0000Ooo = false;
    public SearchDeviceBean O0000o0;
    public boolean O0000o00 = false;

    public oo0oo00oo(TuyaBlueMeshOtaBuilder tuyaBlueMeshOtaBuilder) {
        this.O00000o = tuyaBlueMeshOtaBuilder.getMeshId();
        this.O00000oo = tuyaBlueMeshOtaBuilder.getData();
        this.O0000O0o = tuyaBlueMeshOtaBuilder.getTuyaBlueMeshActivatorListener();
        this.O0000Oo = tuyaBlueMeshOtaBuilder.getVersion();
        this.O00000oO = tuyaBlueMeshOtaBuilder.getDevId();
        this.O0000OoO = tuyaBlueMeshOtaBuilder.getMac();
        O00000Oo();
        this.O0000OOo = O0O0o00.O000000o().O00000o(this.O00000o);
    }

    private void O00000Oo() {
        String str;
        if (this.O0000OoO.length() == 12) {
            int i = 0;
            String str2 = "";
            while (i < this.O0000OoO.length()) {
                int i2 = i + 2;
                int length = this.O0000OoO.length();
                StringBuilder n = a.n(str2);
                if (i2 == length) {
                    str = this.O0000OoO.substring(i, i2);
                } else {
                    n.append(this.O0000OoO.substring(i, i2));
                    str = ":";
                }
                n.append(str);
                str2 = n.toString();
                i = i2;
            }
            this.O0000OoO = str2.toUpperCase();
        }
    }

    /* access modifiers changed from: private */
    public void O00000o() {
        this.O0000Oo0.O000000o(new O00o0() {
            public void O000000o(String str) {
                StringBuilder q = a.q("requestFirmware:", str, "  mVersion：");
                q.append(oo0oo00oo.this.O0000Oo);
                L.e(oo0oo00oo.O000000o, q.toString());
                if (str.equals(oo0oo00oo.this.O0000Oo)) {
                    new O0OOo().O000000o(oo0oo00oo.this.O00000oO, oo0oo00oo.this.O0000Oo, new Business.ResultListener<Boolean>() {
                        /* renamed from: O000000o */
                        public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                            oo0oo00oo.this.O0000O0o.onFail(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                            if (oo0oo00oo.this.O00000o0 != null) {
                                oo0oo00oo.this.O00000o0.O00000o();
                                oooo0o0o0 unused = oo0oo00oo.this.O00000o0 = null;
                            }
                        }

                        /* renamed from: O00000Oo */
                        public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                            oo0oo00oo.this.O0000O0o.onUpgradeSuccess();
                            if (oo0oo00oo.this.O00000o0 != null) {
                                oo0oo00oo.this.O00000o0.O00000o();
                                oooo0o0o0 unused = oo0oo00oo.this.O00000o0 = null;
                            }
                        }
                    });
                } else {
                    oo0oo00oo.this.O0000O0o.onFail("-1", "version not equal");
                }
            }

            public void O000000o(String str, String str2) {
                oo0oo00oo.this.O0000O0o.onFail(str, str2);
                if (oo0oo00oo.this.O00000o0 != null) {
                    oo0oo00oo.this.O00000o0.O00000o();
                    oooo0o0o0 unused = oo0oo00oo.this.O00000o0 = null;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void O00000o0() {
        this.O0000Oo0.O000000o();
    }

    public void O000000o() {
        L.e(O000000o, "ota send success");
        this.O0000O0o.onSendSuccess();
        this.O00000o0.O00000o0();
        this.mHandler.postDelayed(new Runnable() {
            public void run() {
                L.d(oo0oo00oo.O000000o, "reStartConnect");
                oo0oo00oo.this.O00000o0.O00000Oo();
            }
        }, 12000);
    }

    public void O000000o(int i) {
        this.O0000O0o.onUpgrade(i);
    }

    public void O000000o(SearchDeviceBean searchDeviceBean) {
        int i;
        String str;
        DeviceBean deviceBean;
        Class cls = o0o00o00o0.class;
        String str2 = "";
        if (Oo0.O000000o(cls) == null || (deviceBean = ((o0o00o00o0) Oo0.O000000o(cls)).O0000OOo().getDeviceBean(this.O00000oO)) == null) {
            i = 0;
            str = str2;
        } else {
            i = a.e.a.a.r.a.c(deviceBean.getNodeId());
            str2 = deviceBean.getDevKey();
            str = deviceBean.getProductId();
        }
        o00oo0000o O000000o2 = new o00oo0000o().O00000Oo(this.O00000oo).O00000Oo(searchDeviceBean.getMacAdress()).O000000o(searchDeviceBean.getSessionKey()).O000000o(i).O000000o(str2).O00000o0(str).O000000o((o00o0oo0oo.O000000o) this);
        this.O0000Oo0 = this.O0000Ooo ? new ooo0oo0oo(O000000o2) : new ooo0ooo00(O000000o2);
    }

    public void O000000o(String str, String str2) {
        this.O0000O0o.onFail(str, str2);
    }

    public void onDestroy() {
        oooo0o0o0 oooo0o0o0 = this.O00000o0;
        if (oooo0o0o0 != null) {
            oooo0o0o0.O00000o();
            this.O00000o0 = null;
        }
        o00o0oo0oo o00o0oo0oo = this.O0000Oo0;
        if (o00o0oo0oo != null) {
            o00o0oo0oo.O0000Oo();
        }
    }

    public void startOta() {
        if (this.O0000OOo == null) {
            this.O0000O0o.onFail(o00oo0o0o0.O0000Oo, "BlueMeshBean is null , please connect");
            return;
        }
        this.O00000o0 = new oooo0o0o0(this.O00000Oo);
        this.O0000o00 = false;
        this.O0000Ooo = false;
        oo0oo0000.O000000o().stopClient();
        this.mHandler.postDelayed(new Runnable() {
            public void run() {
                SearchDeviceBean searchDeviceBean = new SearchDeviceBean();
                searchDeviceBean.setMacAdress(oo0oo00oo.this.O0000OoO);
                oo0oo00oo.this.O00000o0.O000000o(searchDeviceBean);
            }
        }, 3000);
    }

    public void stopOta() {
    }
}
