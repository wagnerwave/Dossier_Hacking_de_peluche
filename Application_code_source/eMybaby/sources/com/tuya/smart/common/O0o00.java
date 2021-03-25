package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.inuker.bluetooth.library.connect.options.BleConnectOptions;
import com.tuya.sdk.bluemesh.mesh.model.MeshLogin$2;
import com.tuya.sdk.bluemesh.mesh.model.MeshLogin$4;
import com.tuya.sdk.timer.bean.DpTimerBean;
import com.tuya.smart.android.blemesh.bean.MeshClientStatusEnum;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.SafeHandler;
import com.tuya.smart.android.mvp.model.BaseModel;
import com.tuya.smart.common.OoO0o;
import com.tuya.smart.common.o00o0oo00o;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.bean.BlueMeshBean;
import okhttp3.internal.platform.AndroidPlatform;

public class O0o00 extends BaseModel {
    public static final int O000000o = 241;
    public static final int O00000Oo = 243;
    public static final int O00000o = 245;
    public static final int O00000o0 = 244;
    public static final int O00000oO = 246;
    public static final int O00000oo = 247;
    public static final int O0000O0o = 248;
    public static final String O0000Oo0 = "MeshLogin";
    public OoO0o.O000000o O0000OOo = new OoO0o.O000000o() {
        public void O000000o() {
            O0o00.this.O000000o(MeshClientStatusEnum.INIT);
            O0o00 o0o00 = O0o00.this;
            o0o00.resultSuccess(O0o00.O0000O0o, o0o00.O0000o00);
        }

        public void O000000o(SearchDeviceBean searchDeviceBean) {
            if (searchDeviceBean != null) {
                StringBuilder n = a.n("found blueMesh ");
                n.append(searchDeviceBean.getMacAdress());
                n.append("   status:");
                n.append(O0o00.this.O0000o);
                L.e(O0o00.O0000Oo0, n.toString());
                if (O0o00.this.O0000o == MeshClientStatusEnum.SEARCH) {
                    O0o00.this.O000000o(MeshClientStatusEnum.CONNECTING);
                    O0o00 o0o00 = O0o00.this;
                    o0o00.O000000o(o0o00.O0000o00, searchDeviceBean);
                    return;
                }
                return;
            }
            L.d(O0o00.O0000Oo0, "searchDeviceBean null");
            O0o00 o0o002 = O0o00.this;
            o0o002.resultSuccess(O0o00.O000000o, o0o002.O0000o00);
        }

        public void O00000Oo() {
            L.d(O0o00.O0000Oo0, "searchDeviceBean onSearchNothing");
            O0o00.this.O000000o(MeshClientStatusEnum.INIT);
            O0o00 o0o00 = O0o00.this;
            o0o00.resultSuccess(O0o00.O000000o, o0o00.O0000o00);
        }
    };
    public int O0000Oo = -1;
    public final OoO0o O0000OoO;
    public a.e.a.a.a O0000Ooo;
    public MeshClientStatusEnum O0000o;
    public o00o0oo00o O0000o0;
    public o00o0o00oo O0000o00;
    public o00o0o00oo O0000o0O;
    public SearchDeviceBean O0000o0o;
    public a.e.a.a.o.h.a O0000oO = new MeshLogin$4(this);
    public boolean O0000oO0;

    public O0o00(BlueMeshBean blueMeshBean, int i, SafeHandler safeHandler) {
        super(TuyaSdk.getApplication(), safeHandler);
        this.O0000o00 = new o00o0o00oo(blueMeshBean);
        this.O0000Oo = i;
        this.O0000Ooo = o00o0o0o00.O000000o().O00000Oo();
        this.O0000OoO = new OoO0o();
        this.O0000o = MeshClientStatusEnum.INIT;
    }

    public O0o00(BlueMeshBean blueMeshBean, SafeHandler safeHandler) {
        super(TuyaSdk.getApplication(), safeHandler);
        this.O0000o00 = new o00o0o00oo(blueMeshBean);
        StringBuilder n = a.n("mesh login code: ");
        n.append(this.O0000o00.getCode());
        L.d(O0000Oo0, n.toString());
        this.O0000Ooo = o00o0o0o00.O000000o().O00000Oo();
        this.O0000OoO = new OoO0o();
        this.O0000o = MeshClientStatusEnum.INIT;
    }

    private void O000000o(int i) {
        StringBuilder o = a.o("startSearch: ", i, " mSearching:");
        o.append(this.O0000o);
        L.e(O0000Oo0, o.toString());
        MeshClientStatusEnum meshClientStatusEnum = this.O0000o;
        if (meshClientStatusEnum == MeshClientStatusEnum.INIT && meshClientStatusEnum != MeshClientStatusEnum.SEARCH) {
            L.d(O0000Oo0, "startSearch");
            O000000o(MeshClientStatusEnum.SEARCH);
            this.O0000OoO.O000000o(this.O0000o00, i, this.O0000OOo);
        }
    }

    /* access modifiers changed from: private */
    public void O000000o(MeshClientStatusEnum meshClientStatusEnum) {
        this.O0000o = meshClientStatusEnum;
    }

    /* access modifiers changed from: private */
    public void O000000o(o00o0o00oo o00o0o00oo, SearchDeviceBean searchDeviceBean) {
        this.O0000o0O = o00o0o00oo;
        this.O0000o0o = searchDeviceBean;
        O000000o(searchDeviceBean.getMacAdress());
    }

    private void O000000o(String str) {
        BleConnectOptions.b bVar = new BleConnectOptions.b();
        bVar.f4321a = 3;
        bVar.f4323c = AndroidPlatform.MAX_LOG_LENGTH;
        bVar.f4322b = 2;
        bVar.f4324d = RecyclerView.MAX_SCROLL_DURATION;
        this.O0000oO0 = true;
        this.O0000Ooo.o(str, new BleConnectOptions(bVar), new MeshLogin$2(this, str));
        L.e(O0000Oo0, "registerConnectStatusListener:" + str + DpTimerBean.FILL + this.O0000oO);
        a.e.a.a.a aVar = this.O0000Ooo;
        aVar.f3191a.l(str, this.O0000oO);
    }

    /* access modifiers changed from: private */
    public void O00000Oo(o00o0o00oo o00o0o00oo, final SearchDeviceBean searchDeviceBean) {
        o00o0oo00o o00o0oo00o = new o00o0oo00o(o00ooo0000.O000000o(o00o0o00oo.getCode(), 16), o00ooo0000.O000000o(o00o0o00oo.getPassword(), 16), new o00o0oo00o.O000000o() {
            public void O000000o(String str, String str2) {
                L.d(O0o00.O0000Oo0, "Login onFailure  " + str + DpTimerBean.FILL + str2);
                O0o00.this.O000000o(MeshClientStatusEnum.INIT);
                O0o00.this.resultError(O0o00.O00000o0, str, str2);
            }

            public void O000000o(byte[] bArr) {
                L.d(O0o00.O0000Oo0, "Login onSuccess");
                O0o00.this.O000000o(MeshClientStatusEnum.CONNECTED);
                searchDeviceBean.setSessionKey(bArr);
                O0o00 o0o00 = O0o00.this;
                o00o0o00oo unused = o0o00.O0000o00 = o00oo0ooo0.O000000o(o0o00.O0000o00, searchDeviceBean);
                O0o00.this.resultSuccess(O0o00.O00000oO, searchDeviceBean);
            }
        });
        this.O0000o0 = o00o0oo00o;
        o00o0oo00o.O000000o(searchDeviceBean.getMacAdress());
    }

    /* access modifiers changed from: private */
    public void O00000Oo(String str) {
        if (this.O0000oO != null) {
            StringBuilder q = a.q("unregisterConnectStatusListener:", str, "   Listener:");
            q.append(this.O0000oO);
            L.e(O0000Oo0, q.toString());
            a.e.a.a.a aVar = this.O0000Ooo;
            aVar.f3191a.b(str, this.O0000oO);
        }
    }

    public void O000000o() {
        O000000o(this.O0000Oo);
    }

    public void O00000Oo() {
        L.d(O0000Oo0, "reLogin");
        if (this.O0000o0o == null || this.O0000o0O == null) {
            L.d(O0000Oo0, "reLogin fail macAddress null");
            return;
        }
        O000000o(MeshClientStatusEnum.CONNECTING);
        O000000o(this.O0000o0o.getMacAdress());
    }

    public void O00000o() {
        if (this.O0000o == MeshClientStatusEnum.SEARCH) {
            O000000o(MeshClientStatusEnum.INIT);
        }
        OoO0o ooO0o = this.O0000OoO;
        if (ooO0o != null) {
            ooO0o.O00000Oo();
        }
    }

    public void O00000o0() {
        L.d(O0000Oo0, "stopConnect  mMeshLogin:" + this);
        O000000o(MeshClientStatusEnum.INIT);
        OoO0o ooO0o = this.O0000OoO;
        if (ooO0o != null) {
            ooO0o.O000000o();
        }
        SearchDeviceBean searchDeviceBean = this.O0000o0o;
        if (searchDeviceBean != null) {
            String macAdress = searchDeviceBean.getMacAdress();
            L.d(O0000Oo0, "stopConnect  macAdress:" + macAdress);
            if (!TextUtils.isEmpty(macAdress)) {
                a.v("disconnect:", macAdress, O0000Oo0);
                this.O0000Ooo.d(macAdress);
            }
        }
        if (this.O0000o0 != null) {
            L.d(O0000Oo0, "mLoginAction  cancel");
            this.O0000o0.O00000Oo();
            this.O0000o0 = null;
        }
    }

    public MeshClientStatusEnum O00000oO() {
        return this.O0000o;
    }

    public void onDestroy() {
        O00000o0();
    }
}
