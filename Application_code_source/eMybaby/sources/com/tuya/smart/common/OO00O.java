package com.tuya.smart.common;

import a.e.a.a.a;
import a.e.a.a.o.h.b;
import android.os.AsyncTask;
import android.os.Message;
import android.text.TextUtils;
import com.tutk.IOTC.AVFrame;
import com.tuya.sdk.bluemesh.mesh.presenter.TuyaBlueMeshConnectImpl$1;
import com.tuya.smart.android.blemesh.bean.MeshClientStatusEnum;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.android.common.utils.HexUtil;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.mvp.bean.Result;
import com.tuya.smart.android.mvp.presenter.BasePresenter;
import com.tuya.smart.common.O0OO00O;
import com.tuya.smart.common.o00o0oo0o0;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.bean.BlueMeshBean;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.ArrayList;
import java.util.List;

public class OO00O extends BasePresenter implements O0Oo0 {
    public static final int O000000o = 1;
    public static final String O00000Oo = "TuyaBlueMeshConnectImpl";
    public static final int O00000o = 4181;
    public static final int O00000o0 = 2;
    public a O00000oO = o00o0o0o00.O000000o().O00000Oo();
    public o00o0o00oo O00000oo;
    public O0OO00O.O000000o O0000O0o;
    public o00o0oo0o0 O0000OOo;
    public boolean O0000Oo;
    public O0o00 O0000Oo0;
    public long O0000OoO = -1;
    public SearchDeviceBean O0000Ooo;
    public b O0000o0 = new TuyaBlueMeshConnectImpl$1(this);
    public boolean O0000o00;

    private void O000000o(final SearchDeviceBean searchDeviceBean) {
        o00o0oo0o0 o00o0oo0o0 = new o00o0oo0o0(searchDeviceBean.getMacAdress(), searchDeviceBean.getSessionKey(), new o00o0oo0o0.O000000o() {
            public void O000000o() {
            }

            public void O000000o(String str, String str2) {
                if (OO00O.this.O0000O0o != null) {
                    OO00O.this.O0000O0o.O000000o(str, str2);
                }
                if (OO00O.this.O00000oo != null) {
                    String O00000Oo2 = OO00O.this.O00000oo.O00000Oo();
                    if (!TextUtils.isEmpty(O00000Oo2)) {
                        OO00O.this.O00000oO.d(O00000Oo2);
                    }
                }
            }

            public void O000000o(final byte[] bArr) {
                AsyncTask.execute(new Runnable() {
                    public void run() {
                        AnonymousClass1 r0 = AnonymousClass1.this;
                        OO00O.this.O000000o(bArr, searchDeviceBean.getVendorId());
                    }
                });
            }

            public void O00000Oo() {
                OO00O.this.O00000Oo(searchDeviceBean);
            }
        });
        this.O0000OOo = o00o0oo0o0;
        o00o0oo0o0.O000000o();
        this.O0000OOo.O00000o();
    }

    /* access modifiers changed from: private */
    public void O000000o(byte[] bArr, int i) {
        L.d(O00000Oo, "onCommandNotify");
        if (bArr != null && bArr.length >= 20) {
            byte b2 = bArr[7] & AVFrame.FRM_STATE_UNKOWN;
            String format = String.format("%04x", new Object[]{Integer.valueOf(((bArr[8] & AVFrame.FRM_STATE_UNKOWN) << 8) + (bArr[9] & AVFrame.FRM_STATE_UNKOWN))});
            byte[] bArr2 = new byte[10];
            System.arraycopy(bArr, 10, bArr2, 0, 10);
            StringBuilder sb = new StringBuilder();
            sb.append("pcc:");
            sb.append(format);
            sb.append("  opcode: ");
            byte b3 = (byte) b2;
            sb.append(HexUtil.bytesToHexString(new byte[]{b3}));
            sb.append(" params: ");
            sb.append(o00oo0o00o.O00000Oo(bArr2, ":"));
            L.d(O00000Oo, sb.toString());
            OO000o.O000000o(this.O00000oo.getMeshId(), b3, bArr2, bArr, format);
        }
    }

    /* access modifiers changed from: private */
    public void O00000Oo(SearchDeviceBean searchDeviceBean) {
        int meshAddress = searchDeviceBean.getMeshAddress();
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.valueOf(meshAddress));
        O0000o.O000000o(this.O00000oo.getMeshId(), "", (List<String>) arrayList, (List<String>) null);
        this.mHandler.sendEmptyMessageDelayed(2, 0);
        O0OO00O.O000000o o000000o = this.O0000O0o;
        if (o000000o != null) {
            o000000o.O000000o(this.O00000oo);
        }
    }

    private void O0000OOo() {
        L.d(O00000Oo, "afterDisConnect  change status");
        String meshId = this.O00000oo.getMeshId();
        O0O0o00.O000000o().O000000o(meshId);
        List<DeviceBean> meshSubDevList = new O0OO0O(meshId).getMeshSubDevList();
        if (meshSubDevList != null) {
            ArrayList arrayList = new ArrayList();
            for (DeviceBean next : meshSubDevList) {
                next.setLocalOnline(Boolean.FALSE);
                O0O0o00.O000000o().O00000Oo(meshId, next.getNodeId());
                arrayList.add(next.getNodeId());
            }
            O0000o.O000000o(meshId, (List<String>) null, arrayList);
        }
    }

    private void O0000Oo() {
        StringBuilder n = a.a.a.a.a.n("limitSearchTime  ");
        n.append(this.O0000OoO);
        L.d(O00000Oo, n.toString());
        if (this.O0000OoO != -1) {
            this.mHandler.removeMessages(O00000o);
            this.mHandler.sendEmptyMessageDelayed(O00000o, this.O0000OoO);
        }
    }

    /* access modifiers changed from: private */
    public void O0000Oo0() {
        StringBuilder n = a.a.a.a.a.n("startSearchForLimit  ");
        n.append(this.O0000OoO);
        L.d(O00000Oo, n.toString());
        O0000Oo();
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 2000);
    }

    public void O000000o(BlueMeshBean blueMeshBean, long j, O0OO00O.O000000o o000000o) {
        this.O0000OoO = j;
        this.O0000O0o = o000000o;
        this.O0000Oo = false;
        this.O0000o00 = false;
        this.O00000oo = new o00o0o00oo(blueMeshBean);
        O0o00 o0o00 = this.O0000Oo0;
        if (o0o00 != null) {
            o0o00.onDestroy();
            this.O0000Oo0 = null;
        }
        O0o00 o0o002 = new O0o00(blueMeshBean, this.mHandler);
        this.O0000Oo0 = o0o002;
        o0o002.O000000o();
        O0000Oo();
        a aVar = this.O00000oO;
        aVar.f3191a.n(this.O0000o0);
    }

    public void O000000o(BlueMeshBean blueMeshBean, O0OO00O.O000000o o000000o) {
        O000000o(blueMeshBean, -1, o000000o);
    }

    public boolean O000000o() {
        O0o00 o0o00 = this.O0000Oo0;
        return o0o00 != null && o0o00.O00000oO() == MeshClientStatusEnum.CONNECTED;
    }

    public void O00000Oo() {
        this.O0000Oo = true;
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        o00o0oo0o0 o00o0oo0o0 = this.O0000OOo;
        if (o00o0oo0o0 != null) {
            o00o0oo0o0.O00000o0();
        }
        O0o00 o0o00 = this.O0000Oo0;
        if (o0o00 != null) {
            o0o00.O00000o0();
        }
        if (this.O00000oo != null) {
            O0O0o00.O000000o().O00000oO(this.O00000oo.getMeshId());
            String O00000Oo2 = this.O00000oo.O00000Oo();
            if (!TextUtils.isEmpty(O00000Oo2)) {
                this.O00000oO.d(O00000Oo2);
            }
        }
        b bVar = this.O0000o0;
        if (bVar != null) {
            this.O00000oO.f3191a.i(bVar);
        }
    }

    public void O00000o() {
        this.O0000o00 = true;
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(O00000o);
        if (this.O0000Oo0 != null) {
            L.d(O00000Oo, "stopSearch");
            this.O0000Oo0.O00000o();
        }
    }

    public void O00000o0() {
        this.O0000o00 = false;
        O0o00 o0o00 = this.O0000Oo0;
        if (o0o00 == null || o0o00.O00000oO() != MeshClientStatusEnum.INIT) {
            O0o00 o0o002 = this.O0000Oo0;
            if (o0o002 != null && o0o002.O00000oO() == MeshClientStatusEnum.SEARCH) {
                O0000Oo();
                return;
            }
            return;
        }
        L.d(O00000Oo, "startSearch");
        O0000Oo0();
    }

    public MeshClientStatusEnum O00000oO() {
        O0o00 o0o00 = this.O0000Oo0;
        return o0o00 != null ? o0o00.O00000oO() : MeshClientStatusEnum.INIT;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.O0000Ooo;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String O00000oo() {
        /*
            r1 = this;
            boolean r0 = r1.O000000o()
            if (r0 == 0) goto L_0x0013
            com.tuya.smart.android.blemesh.bean.SearchDeviceBean r0 = r1.O0000Ooo
            if (r0 == 0) goto L_0x0013
            int r0 = r0.getMeshAddress()
            java.lang.String r0 = a.e.a.a.r.a.d(r0)
            return r0
        L_0x0013:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.OO00O.O00000oo():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.O0000Ooo;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String O0000O0o() {
        /*
            r1 = this;
            boolean r0 = r1.O000000o()
            if (r0 == 0) goto L_0x000f
            com.tuya.smart.android.blemesh.bean.SearchDeviceBean r0 = r1.O0000Ooo
            if (r0 == 0) goto L_0x000f
            java.lang.String r0 = r0.getMacAdress()
            return r0
        L_0x000f:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.OO00O.O0000O0o():java.lang.String");
    }

    public boolean handleMessage(Message message) {
        if (message.what == 243) {
            O0000OOo();
        }
        if (this.O0000Oo) {
            return true;
        }
        int i = message.what;
        if (i == 1) {
            L.d(O00000Oo, "start_search");
            if (this.O00000oO == null) {
                throw null;
            } else if (!a.c.a.f.b.Q() || this.O0000o00) {
                L.d(O00000Oo, "bluetoothClosed or stopSearch");
                return false;
            } else {
                O0o00 o0o00 = this.O0000Oo0;
                if (o0o00 == null) {
                    return false;
                }
                o0o00.O000000o();
                return false;
            }
        } else if (i == 2) {
            L.d(O00000Oo, "query color");
            new O0OO0O(this.O00000oo.getMeshId()).queryAllStatusByLocal((IResultCallback) null);
            return false;
        } else if (i == 241) {
            L.d(O00000Oo, "search_failure");
            if (this.O0000o00) {
                return false;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, 1000);
            return false;
        } else if (i != 4181) {
            switch (i) {
                case 243:
                    L.d(O00000Oo, "connect_disconnect");
                    O0o00 o0o002 = this.O0000Oo0;
                    if (o0o002 != null) {
                        o0o002.O00000o0();
                        break;
                    }
                    break;
                case O0o00.O00000o0:
                case O0o00.O00000o:
                    this.O0000Oo0.O00000o0();
                    L.d(O00000Oo, "login failure or connect failure");
                    break;
                case O0o00.O00000oO:
                    this.O0000Ooo = (SearchDeviceBean) ((Result) message.obj).getObj();
                    StringBuilder n = a.a.a.a.a.n("connect success :");
                    n.append(this.O0000Ooo.getVendorId());
                    L.d(O00000Oo, n.toString());
                    this.O00000oo = o00oo0ooo0.O000000o(this.O00000oo, this.O0000Ooo);
                    O000000o(this.O0000Ooo);
                    return false;
                default:
                    return false;
            }
            O0000Oo0();
            return false;
        } else {
            this.mHandler.removeMessages(1);
            if (this.O0000Oo0 == null) {
                return false;
            }
            L.e(O00000Oo, "timeLimit stopSearch");
            this.O0000Oo0.O00000o();
            return false;
        }
    }
}
