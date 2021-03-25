package a.c.d.j.c;

import com.tuya.smart.sdk.api.ITuyaSmartActivatorListener;
import com.tuya.smart.sdk.bean.DeviceBean;

public class a implements ITuyaSmartActivatorListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f226a;

    public a(c cVar) {
        this.f226a = cVar;
    }

    public void onActiveSuccess(DeviceBean deviceBean) {
        this.f226a.resultSuccess(3, deviceBean);
    }

    public void onError(String str, String str2) {
        if (((str.hashCode() == 1507427 && str.equals("1004")) ? (char) 0 : 65535) != 0) {
            this.f226a.resultError(2, str, str2);
        } else {
            this.f226a.resultError(6, "wifiError", str2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onStep(java.lang.String r4, java.lang.Object r5) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = 1
            r2 = -1543301630(0xffffffffa4031602, float:-2.8424738E-17)
            if (r0 == r2) goto L_0x001a
            r2 = -107723446(0xfffffffff994454a, float:-9.623316E34)
            if (r0 == r2) goto L_0x0010
            goto L_0x0024
        L_0x0010:
            java.lang.String r0 = "device_bind_success"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0024
            r4 = 0
            goto L_0x0025
        L_0x001a:
            java.lang.String r0 = "device_find"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0024
            r4 = 1
            goto L_0x0025
        L_0x0024:
            r4 = -1
        L_0x0025:
            if (r4 == 0) goto L_0x002e
            if (r4 == r1) goto L_0x002a
            goto L_0x0035
        L_0x002a:
            a.c.d.j.c.c r4 = r3.f226a
            r0 = 7
            goto L_0x0032
        L_0x002e:
            a.c.d.j.c.c r4 = r3.f226a
            r0 = 8
        L_0x0032:
            r4.resultSuccess(r0, r5)
        L_0x0035:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.c.d.j.c.a.onStep(java.lang.String, java.lang.Object):void");
    }
}
