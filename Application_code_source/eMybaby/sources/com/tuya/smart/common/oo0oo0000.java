package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Handler;
import android.os.Message;
import com.tuya.sdk.sigmesh.bean.TuyaSigMeshBean;
import com.tuya.smart.android.blemesh.api.ITuyaSigMeshClient;
import com.tuya.smart.android.blemesh.bean.MeshClientStatusEnum;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.common.oo0oo000o;
import com.tuya.smart.sdk.bean.SigMeshBean;

public final class oo0oo0000 implements ITuyaSigMeshClient {
    public static final String O000000o = "TuyaBlueMeshClient huohuo";
    public static final int O00000Oo = 1;
    public static final long O00000o0 = 500;
    public boolean O00000o;
    public long O00000oO;
    public SigMeshBean O00000oo;
    public Handler O0000O0o;

    public static class O000000o {
        public static oo0oo0000 O000000o = new oo0oo0000();
    }

    public oo0oo0000() {
        this.O00000oO = -1;
        this.O0000O0o = new Handler(new Handler.Callback() {
            public boolean handleMessage(Message message) {
                if (!oo0oo0000.this.O00000o) {
                    return true;
                }
                if (message.what != 1) {
                    return false;
                }
                oo0oo0000.this.O00000Oo();
                return false;
            }
        });
    }

    public static oo0oo0000 O000000o() {
        return O000000o.O000000o;
    }

    /* access modifiers changed from: private */
    public void O00000Oo() {
        L.d("TuyaBlueMeshClient huohuo", "startConnect");
        if (this.O00000oo == null) {
            L.e("TuyaBlueMeshClient huohuo", "startConnect fail mBlueMeshBean is null");
        } else {
            oo0oo000o.O00000oO().O000000o(this.O00000oo, this.O00000oO, new oo0oo000o.O000000o() {
                public void O000000o(TuyaSigMeshBean tuyaSigMeshBean) {
                    StringBuilder n = a.n("onSuccess: ");
                    n.append(tuyaSigMeshBean.getMeshId());
                    L.d("TuyaBlueMeshClient huohuo", n.toString());
                }

                public void O000000o(String str, String str2) {
                    L.d("TuyaBlueMeshClient huohuo", "onError:  errorCode: " + str + " error: " + str2);
                }
            });
        }
    }

    public void destroyMesh(String str) {
        O0OOOo0.O000000o().O00000Oo(str);
    }

    public MeshClientStatusEnum getStatus() {
        return oo0oo000o.O00000oO().O00000o();
    }

    public void initMesh(String str) {
        O0OOOo0.O000000o().O000000o(str);
    }

    public void initMesh(String str, boolean z) {
        O0OOOo0.O000000o().O000000o(str, z);
    }

    public synchronized void startClient(SigMeshBean sigMeshBean) {
        L.d("TuyaBlueMeshClient huohuo", "startClient : " + this.O00000o);
        startClient(sigMeshBean, -1);
    }

    public synchronized void startClient(SigMeshBean sigMeshBean, long j) {
        this.O00000oO = j;
        this.O00000oo = sigMeshBean;
        if (!this.O00000o) {
            this.O00000o = true;
            this.O0000O0o.sendEmptyMessageDelayed(1, 500);
        } else {
            startSearch();
        }
    }

    public void startSearch() {
        if (this.O00000o) {
            oo0oo000o.O00000oO().O00000Oo();
        }
    }

    public void stopClient() {
        L.d("TuyaBlueMeshClient huohuo", "stopClient");
        this.O00000o = false;
        this.O0000O0o.removeMessages(1);
        oo0oo000o.O00000oO().O000000o();
    }

    public void stopSearch() {
        L.d("TuyaBlueMeshClient huohuo", "mesh stopSearch");
        oo0oo000o.O00000oO().O00000o0();
    }
}
