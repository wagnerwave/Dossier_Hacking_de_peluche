package com.tuya.sdk.bluemesh.mesh.utils;

import a.a.a.a.a;
import android.os.Handler;
import android.os.Message;
import com.tuya.sdk.timer.bean.DpTimerBean;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.common.O000OOOo;
import com.tuya.smart.common.O000OOo0;
import com.tuya.smart.common.O0Oo00;
import com.tuya.smart.common.o00oo0o0o0;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.IResultCallback;

public class BlueMeshCallback implements O000OOOo, O0Oo00 {
    public static final String O000000o = "BlueMeshCallback";
    public static final long O00000oo = 3000;
    public static final int O0000O0o = 101;
    public String O00000Oo;
    public CommandType O00000o;
    public IResultCallback O00000o0;
    public Handler O00000oO = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 101) {
                if (BlueMeshCallback.this.O00000o0 != null) {
                    BlueMeshCallback.this.O00000o0.onError(o00oo0o0o0.O0000o0, "TIME_OUT");
                }
                BlueMeshCallback.this.O000000o();
            }
        }
    };

    public enum CommandType {
        GROUP
    }

    public BlueMeshCallback(String str, CommandType commandType, IResultCallback iResultCallback) {
        this.O00000Oo = str;
        this.O00000o0 = iResultCallback;
        this.O00000o = commandType;
        TuyaSdk.getEventBus().register(this);
        O00000Oo();
    }

    private void O00000Oo() {
        this.O00000oO.sendEmptyMessageDelayed(101, 3000);
    }

    public void O000000o() {
        TuyaSdk.getEventBus().unregister(this);
    }

    public void onEvent(O000OOo0 o000OOo0) {
        StringBuilder n = a.n("receive BlueMeshGroupUpdateEventModel1 ");
        n.append(this.O00000Oo);
        n.append(DpTimerBean.FILL);
        n.append(o000OOo0.O000000o());
        L.d("BlueMeshCallback", n.toString());
        if (this.O00000Oo.equals(o000OOo0.O000000o()) && this.O00000o.equals(CommandType.GROUP)) {
            this.O00000oO.removeMessages(101);
            if (o000OOo0.O00000Oo()) {
                IResultCallback iResultCallback = this.O00000o0;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            } else {
                IResultCallback iResultCallback2 = this.O00000o0;
                if (iResultCallback2 != null) {
                    iResultCallback2.onError(o000OOo0.O00000o(), o000OOo0.O00000o0());
                }
            }
            O000000o();
        }
    }
}
