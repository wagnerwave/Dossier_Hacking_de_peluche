package com.tuya.sdk.tuyamesh.blemesh.action;

import a.a.a.a.a;
import a.e.a.a.o.j.d;
import com.tuya.smart.common.o00o0oo0o0;
import com.tuya.smart.common.o00oo0o00o;
import com.tuya.smart.common.o00oo0oo00;
import java.util.UUID;

public class NotificationAction$1 implements d {
    public final /* synthetic */ o00o0oo0o0 this$0;

    public NotificationAction$1(o00o0oo0o0 o00o0oo0o0) {
        this.this$0 = o00o0oo0o0;
    }

    public void onNotify(UUID uuid, UUID uuid2, byte[] bArr) {
        StringBuilder n = a.n("service: ");
        n.append(uuid.toString());
        n.append("character: ");
        n.append(uuid2.toString());
        n.append(o00oo0o00o.O00000Oo(bArr, ":"));
        o00oo0oo00.O000000o("NotificationAction", n.toString());
        this.this$0.O000000o(uuid, uuid2, bArr);
    }

    public void onResponse(int i) {
        o00oo0oo00.O000000o("NotificationAction", "code: " + i);
        if (i == 0) {
            this.this$0.O00000o0.O000000o();
        } else {
            this.this$0.O00000o0.O000000o(String.valueOf(i), "onNotify unEnable");
        }
    }
}
