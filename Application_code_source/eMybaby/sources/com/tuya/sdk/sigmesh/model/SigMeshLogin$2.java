package com.tuya.sdk.sigmesh.model;

import a.e.a.a.o.j.a;
import com.inuker.bluetooth.library.model.BleGattProfile;
import com.inuker.bluetooth.library.model.BleGattService;
import com.tuya.sdk.timer.bean.DpTimerBean;
import com.tuya.smart.android.blemesh.bean.MeshClientStatusEnum;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.common.o00oo0o0o0;
import com.tuya.smart.common.ooooo0o0o;
import java.util.UUID;

public class SigMeshLogin$2 implements a {
    public final /* synthetic */ ooooo0o0o this$0;
    public final /* synthetic */ String val$macAddress;

    public SigMeshLogin$2(ooooo0o0o ooooo0o0o, String str) {
        this.this$0 = ooooo0o0o;
        this.val$macAddress = str;
    }

    public void onResponse(int i, BleGattProfile bleGattProfile) {
        StringBuilder o = a.a.a.a.a.o("connect code: ", i, "   ");
        o.append(this.val$macAddress);
        o.append(DpTimerBean.FILL);
        o.append(this);
        L.e(ooooo0o0o.O0000Oo, o.toString());
        boolean unused = this.this$0.O0000oO0 = false;
        if (i != 0) {
            this.this$0.O000000o(MeshClientStatusEnum.INIT);
            this.this$0.resultError(ooooo0o0o.O00000o, o00oo0o0o0.O0000OOo, "connect failure");
            return;
        }
        for (int i2 = 0; i2 < bleGattProfile.a().size(); i2++) {
            BleGattService bleGattService = bleGattProfile.a().get(i2);
            UUID g = bleGattService.g();
            StringBuilder n = a.a.a.a.a.n("serviceUid: ");
            n.append(g.toString());
            L.e(ooooo0o0o.O0000Oo, n.toString());
            for (int i3 = 0; i3 < bleGattService.f().size(); i3++) {
                UUID uuid = bleGattService.f().get(i3).f4325a.getUuid();
                StringBuilder n2 = a.a.a.a.a.n("characterUid: ");
                n2.append(uuid.toString());
                L.d(ooooo0o0o.O0000Oo, n2.toString());
            }
        }
    }
}
