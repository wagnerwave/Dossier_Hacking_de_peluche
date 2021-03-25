package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Message;
import com.tuya.sdk.timer.bean.DpTimerBean;
import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshOta;
import com.tuya.smart.android.blemesh.api.MeshUpgradeListener;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.android.blemesh.builder.TuyaBlueMeshOtaBuilder;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.SafeHandler;
import com.tuya.smart.android.mvp.bean.Result;
import com.tuya.smart.android.mvp.presenter.BasePresenter;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.common.o00o0oo0oo;

public class OO0oO extends BasePresenter implements ITuyaBlueMeshOta, o00o0oo0oo.O000000o {
    public static final String O000000o = "TuyaBlueMeshOtaImpl";
    public static final int O0000o00 = 61441;
    public O0o00 O00000Oo;
    public String O00000o;
    public String O00000o0;
    public String O00000oO;
    public byte[] O00000oo;
    public MeshUpgradeListener O0000O0o;
    public o00o0o00oo O0000OOo;
    public String O0000Oo;
    public o00o0oo0oo O0000Oo0;
    public boolean O0000OoO = false;
    public int O0000Ooo = 4;
    public final int O0000o0 = 30000;

    public OO0oO(TuyaBlueMeshOtaBuilder tuyaBlueMeshOtaBuilder) {
        this.O00000o0 = tuyaBlueMeshOtaBuilder.getMeshId();
        this.O00000o = tuyaBlueMeshOtaBuilder.getNodeId();
        this.O00000oo = tuyaBlueMeshOtaBuilder.getData();
        this.O0000O0o = tuyaBlueMeshOtaBuilder.getTuyaBlueMeshActivatorListener();
        this.O0000Oo = tuyaBlueMeshOtaBuilder.getVersion();
        this.O00000oO = tuyaBlueMeshOtaBuilder.getDevId();
        this.O0000OOo = O0O0o00.O000000o().O00000Oo(this.O00000o0);
    }

    private void O00000Oo() {
        this.O0000Oo0.O000000o();
    }

    private void O00000Oo(int i) {
        L.d(O000000o, "initConnect meshAddress:" + i);
        this.O00000Oo = new O0o00(this.O0000OOo, i, this.mHandler);
    }

    private void O00000o0() {
        this.O0000Oo0.O000000o(new O00o0() {
            public void O000000o(String str) {
                StringBuilder q = a.q("requestFirmware:", str, "  mVersion：");
                q.append(OO0oO.this.O0000Oo);
                L.e(OO0oO.O000000o, q.toString());
                if (str.equals(OO0oO.this.O0000Oo)) {
                    new O0OOo().O000000o(OO0oO.this.O00000oO, OO0oO.this.O0000Oo, new Business.ResultListener<Boolean>() {
                        /* renamed from: O000000o */
                        public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                            OO0oO.this.O0000O0o.onFail(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                            if (OO0oO.this.O00000Oo != null) {
                                OO0oO.this.O00000Oo.onDestroy();
                                O0o00 unused = OO0oO.this.O00000Oo = null;
                            }
                        }

                        /* renamed from: O00000Oo */
                        public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                            OO0oO.this.O0000O0o.onUpgradeSuccess();
                            if (OO0oO.this.O00000Oo != null) {
                                OO0oO.this.O00000Oo.onDestroy();
                                O0o00 unused = OO0oO.this.O00000Oo = null;
                            }
                        }
                    });
                } else {
                    OO0oO.this.O0000O0o.onFail("-1", "version not equal");
                }
            }

            public void O000000o(String str, String str2) {
                OO0oO.this.O0000O0o.onFail(str, str2);
            }
        });
    }

    public void O000000o() {
        L.e(O000000o, "ota send success");
        this.O0000O0o.onSendSuccess();
        this.O00000Oo.O00000o0();
        this.mHandler.postDelayed(new Runnable() {
            public void run() {
                L.d(OO0oO.O000000o, "reStartConnect");
                boolean unused = OO0oO.this.O0000OoO = true;
                int unused2 = OO0oO.this.O0000Ooo = 4;
                OO0oO.this.O00000Oo.O00000Oo();
            }
        }, 2000);
    }

    public void O000000o(int i) {
        this.O0000O0o.onUpgrade(i);
    }

    public void O000000o(SearchDeviceBean searchDeviceBean) {
        this.O0000Oo0 = new o00oo0000o().O00000Oo(this.O00000oo).O00000Oo(searchDeviceBean.getMacAdress()).O000000o(searchDeviceBean.getSessionKey()).O000000o((o00o0oo0oo.O000000o) this).O0000OOo();
    }

    public void O000000o(String str, String str2) {
        this.O0000O0o.onFail(str, str2);
    }

    public boolean handleMessage(Message message) {
        MeshUpgradeListener meshUpgradeListener;
        String str;
        String str2;
        SafeHandler safeHandler;
        long j;
        Runnable runnable;
        StringBuilder n = a.n("handleMessage:");
        n.append(message.what);
        L.e(O000000o, n.toString());
        int i = message.what;
        if (i != 241) {
            if (i != 61441) {
                switch (i) {
                    case O0o00.O00000o0:
                    case O0o00.O00000o:
                        break;
                    case O0o00.O00000oO:
                        L.d(O000000o, "login_success");
                        this.mHandler.removeMessages(O0000o00);
                        if (this.O0000OoO) {
                            L.d(O000000o, "reconnect login_success");
                            O00000o0();
                            return false;
                        }
                        O000000o((SearchDeviceBean) ((Result) message.obj).getObj());
                        O00000Oo();
                        return false;
                    default:
                        return false;
                }
            } else {
                L.e(O000000o, "ota search time out");
                this.mHandler.removeMessages(O0000o00);
                meshUpgradeListener = this.O0000O0o;
                str2 = o00oo0o0o0.O0000Oo;
                str = "search time out";
                meshUpgradeListener.onFail(str2, str);
                return false;
            }
        }
        if (this.O0000Ooo > 0) {
            this.O00000Oo.O00000o0();
            if (this.O0000OoO) {
                safeHandler = this.mHandler;
                runnable = new Runnable() {
                    public void run() {
                        OO0oO.this.O00000Oo.O00000Oo();
                    }
                };
                j = 3000;
            } else {
                safeHandler = this.mHandler;
                runnable = new Runnable() {
                    public void run() {
                        OO0oO.this.O00000Oo.O000000o();
                    }
                };
                j = 1500;
            }
            safeHandler.postDelayed(runnable, j);
            this.O0000Ooo--;
            return false;
        }
        this.mHandler.removeMessages(O0000o00);
        meshUpgradeListener = this.O0000O0o;
        str2 = String.valueOf(O0o00.O00000o);
        str = "connect fail";
        meshUpgradeListener.onFail(str2, str);
        return false;
    }

    public void onDestroy() {
        O0o00 o0o00 = this.O00000Oo;
        if (o0o00 != null) {
            o0o00.onDestroy();
            this.O00000Oo = null;
        }
        o00o0oo0oo o00o0oo0oo = this.O0000Oo0;
        if (o00o0oo0oo != null) {
            o00o0oo0oo.O0000Oo();
        }
        this.O0000OoO = false;
    }

    public void startOta() {
        if (this.O0000OOo == null) {
            this.O0000O0o.onFail(o00oo0o0o0.O0000Oo, "BlueMeshBean is null , please connect");
            return;
        }
        StringBuilder n = a.n("startOta   mac:");
        n.append(O0OO00O.O000000o().O0000O0o());
        n.append(DpTimerBean.FILL);
        n.append(this.O0000OOo.O00000Oo());
        L.e(O000000o, n.toString());
        O00000Oo(a.e.a.a.r.a.c(this.O00000o));
        O0O0o0.O000000o().stopClient();
        this.mHandler.postDelayed(new Runnable() {
            public void run() {
                OO0oO.this.O00000Oo.O000000o();
                OO0oO.this.mHandler.sendEmptyMessageDelayed(OO0oO.O0000o00, 30000);
            }
        }, 1000);
    }

    public void stopOta() {
    }
}
