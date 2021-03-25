package com.tuya.sdk.sigmesh.action;

import a.a.a.a.a;
import a.e.a.a.o.j.d;
import com.tuya.smart.common.O00OOo;
import com.tuya.smart.common.o00oo0o00o;
import com.tuya.smart.common.o00oo0oo00;
import com.tuya.smart.common.ooo0oo0o0;
import java.util.UUID;

public class SigMeshNotificationAction$2 implements d {
    public final /* synthetic */ ooo0oo0o0 this$0;

    public SigMeshNotificationAction$2(ooo0oo0o0 ooo0oo0o0) {
        this.this$0 = ooo0oo0o0;
    }

    public void onNotify(UUID uuid, UUID uuid2, byte[] bArr) {
        StringBuilder n = a.n("ota service: ");
        n.append(uuid.toString());
        n.append("character: ");
        n.append(uuid2.toString());
        o00oo0oo00.O000000o("NotificationAction", n.toString());
        o00oo0oo00.O000000o("NotificationAction", "ota origin:" + o00oo0o00o.O00000Oo(bArr, ":"));
        if (this.this$0.O00000oO != null) {
            this.this$0.O00000oO.O000000o(bArr);
        }
    }

    public void onResponse(int i) {
        o00oo0oo00.O000000o("NotificationAction", "code: " + i);
        if (i == 0) {
            this.this$0.O00000oO.O000000o(this.this$0.O0000Oo0);
        } else {
            this.this$0.O00000oO.O000000o(O00OOo.O000OoOO, "onNotify unEnable");
        }
    }
}
