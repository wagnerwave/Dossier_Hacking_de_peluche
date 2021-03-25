package a.d.a.a.e;

import a.d.a.a.e.q.a;
import a.d.a.a.e.q.d;
import com.tutk.IOTC.AVFrame;
import java.util.concurrent.Callable;

public final /* synthetic */ class w implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1450a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1451b;

    /* renamed from: c  reason: collision with root package name */
    public final v f1452c;

    public w(boolean z, String str, v vVar) {
        this.f1450a = z;
        this.f1451b = str;
        this.f1452c = vVar;
    }

    public final Object call() {
        boolean z = this.f1450a;
        String str = this.f1451b;
        v vVar = this.f1452c;
        Object[] objArr = new Object[5];
        objArr[0] = !z && u.c(str, vVar, true, false).f1235a ? "debug cert rejected" : "not whitelisted";
        objArr[1] = str;
        byte[] digest = a.a("SHA-1").digest(vVar.g());
        char[] cArr = new char[(digest.length << 1)];
        int i = 0;
        for (byte b2 : digest) {
            byte b3 = b2 & AVFrame.FRM_STATE_UNKOWN;
            int i2 = i + 1;
            char[] cArr2 = d.f1431b;
            cArr[i] = cArr2[b3 >>> 4];
            i = i2 + 1;
            cArr[i2] = cArr2[b3 & 15];
        }
        objArr[2] = new String(cArr);
        objArr[3] = Boolean.valueOf(z);
        objArr[4] = "12451009.false";
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", objArr);
    }
}
