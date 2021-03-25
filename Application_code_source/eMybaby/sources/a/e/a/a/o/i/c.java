package a.e.a.a.o.i;

import a.e.a.a.o.h.i;
import a.e.a.a.o.j.b;
import com.inuker.bluetooth.library.model.BleGattProfile;

public class c extends k implements i {
    public c(b bVar) {
        super(bVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        G();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0013, code lost:
        if (k() == false) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        if (k() == false) goto L_0x001c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void F() {
        /*
            r3 = this;
            int r0 = r3.o()
            r1 = -1
            if (r0 == 0) goto L_0x0024
            r2 = 2
            if (r0 == r2) goto L_0x0016
            r2 = 19
            if (r0 == r2) goto L_0x000f
            goto L_0x0024
        L_0x000f:
            boolean r0 = r3.k()
            if (r0 != 0) goto L_0x0020
            goto L_0x001c
        L_0x0016:
            boolean r0 = r3.k()
            if (r0 != 0) goto L_0x0020
        L_0x001c:
            r3.D(r1)
            goto L_0x0027
        L_0x0020:
            r3.G()
            goto L_0x0027
        L_0x0024:
            r3.D(r1)
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.a.a.o.i.c.F():void");
    }

    public void n(int i, BleGattProfile bleGattProfile) {
        H();
        if (i == 0) {
            BleGattProfile m = m();
            if (m != null) {
                this.f3251b.putParcelable("extra.gatt.profile", m);
            }
            D(0);
            return;
        }
        D(-1);
    }
}
