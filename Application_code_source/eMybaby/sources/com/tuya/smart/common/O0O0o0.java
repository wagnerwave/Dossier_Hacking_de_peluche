package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Handler;
import android.os.Message;
import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshClient;
import com.tuya.smart.android.blemesh.bean.MeshClientStatusEnum;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.common.O0OO00O;
import com.tuya.smart.sdk.bean.BlueMeshBean;

public final class O0O0o0 implements ITuyaBlueMeshClient {
    public static final String O000000o = "TuyaBlueMeshClient huohuo";
    public static final int O00000Oo = 1;
    public static final long O00000o0 = 500;
    public boolean O00000o;
    public long O00000oO;
    public BlueMeshBean O00000oo;
    public Handler O0000O0o;

    public static class O000000o {
        public static O0O0o0 O000000o = new O0O0o0();
    }

    public O0O0o0() {
        this.O00000oO = -1;
        this.O0000O0o = new Handler(new Handler.Callback() {
            public boolean handleMessage(Message message) {
                if (!O0O0o0.this.O00000o) {
                    return true;
                }
                if (message.what != 1) {
                    return false;
                }
                O0O0o0.this.O00000Oo();
                return false;
            }
        });
    }

    public static O0O0o0 O000000o() {
        return O000000o.O000000o;
    }

    /* access modifiers changed from: private */
    public void O00000Oo() {
        L.d("TuyaBlueMeshClient huohuo", "startConnect");
        if (this.O00000oo == null) {
            L.e("TuyaBlueMeshClient huohuo", "startConnect fail mBlueMeshBean is null");
        } else {
            O0OO00O.O000000o().O000000o(this.O00000oo, this.O00000oO, new O0OO00O.O000000o() {
                public void O000000o(o00o0o00oo o00o0o00oo) {
                    StringBuilder n = a.n("onSuccess: ");
                    n.append(o00o0o00oo.getMeshId());
                    L.d("TuyaBlueMeshClient huohuo", n.toString());
                    O0O0o00.O000000o().O000000o(o00o0o00oo.getMeshId(), o00o0o00oo);
                }

                public void O000000o(String str, String str2) {
                    L.d("TuyaBlueMeshClient huohuo", "onError:  errorCode: " + str + " error: " + str2);
                }
            });
        }
    }

    public void destroyMesh() {
        O0OOOo0.O000000o().O00000Oo();
    }

    public void destroyMesh(String str) {
        O0OOOo0.O000000o().O00000Oo(str);
    }

    public MeshClientStatusEnum getStatus() {
        return O0OO00O.O000000o().O00000oO();
    }

    public void initMesh(String str) {
        O0OOOo0.O000000o().O000000o(str);
    }

    public void initMesh(String str, boolean z) {
        O0OOOo0.O000000o().O000000o(str, z);
    }

    public void startClient(BlueMeshBean blueMeshBean) {
        StringBuilder n = a.n("startClient : ");
        n.append(this.O00000o);
        L.d("TuyaBlueMeshClient huohuo", n.toString());
        startClient(blueMeshBean, -1);
    }

    public void startClient(BlueMeshBean blueMeshBean, long j) {
        this.O00000oO = j;
        this.O00000oo = blueMeshBean;
        if (!this.O00000o) {
            this.O00000o = true;
            this.O0000O0o.sendEmptyMessageDelayed(1, 500);
            return;
        }
        startSearch();
    }

    public void startSearch() {
        if (this.O00000o) {
            O0OO00O.O000000o().O00000o0();
        }
    }

    public void stopClient() {
        L.d("TuyaBlueMeshClient huohuo", "stopClient");
        this.O00000o = false;
        this.O0000O0o.removeMessages(1);
        O0OO00O.O000000o().O00000Oo();
    }

    public void stopSearch() {
        L.d("TuyaBlueMeshClient huohuo", "mesh stopSearch");
        O0OO00O.O000000o().O00000o();
    }
}
