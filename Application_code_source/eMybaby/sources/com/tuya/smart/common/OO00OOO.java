package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tuya.sdk.timer.bean.DpTimerBean;
import com.tuya.smart.android.blemesh.callback.ILocalQueryGroupDevCallback;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.sdk.TuyaSdk;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class OO00OOO implements O000OOo, O0Oo00 {
    public static final String O000000o = "BlueMeshCallback";
    public static final long O00000oo = 3000;
    public static final int O0000O0o = 101;
    public String O00000Oo;
    public Set<String> O00000o;
    public ILocalQueryGroupDevCallback O00000o0;
    public Handler O00000oO = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 101) {
                if (OO00OOO.this.O00000o0 != null) {
                    OO00OOO.this.O00000o0.onSuccess(new ArrayList(OO00OOO.this.O00000o));
                }
                OO00OOO.this.O000000o();
            }
        }
    };

    public OO00OOO(String str, ILocalQueryGroupDevCallback iLocalQueryGroupDevCallback) {
        this.O00000Oo = str;
        this.O00000o0 = iLocalQueryGroupDevCallback;
        this.O00000o = new HashSet();
        TuyaSdk.getEventBus().register(this);
        O00000Oo();
    }

    private void O00000Oo() {
        this.O00000oO.sendEmptyMessageDelayed(101, 3000);
    }

    public void O000000o() {
        TuyaSdk.getEventBus().unregister(this);
    }

    public void onEvent(O000Oo0 o000Oo0) {
        StringBuilder n = a.n("receive BlueMeshQueryGroupDevEventModel ");
        n.append(this.O00000Oo);
        n.append(DpTimerBean.FILL);
        n.append(o000Oo0.O00000Oo());
        n.append(DpTimerBean.FILL);
        n.append(o000Oo0.O000000o());
        L.d("BlueMeshCallback", n.toString());
        if (this.O00000Oo.equals(o000Oo0.O00000Oo()) && !TextUtils.isEmpty(o000Oo0.O000000o())) {
            this.O00000o.add(o000Oo0.O000000o());
        }
    }
}
