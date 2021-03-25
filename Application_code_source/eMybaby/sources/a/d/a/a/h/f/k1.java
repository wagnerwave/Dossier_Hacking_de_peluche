package a.d.a.a.h.f;

import a.d.a.a.b.e;
import com.tuya.smart.android.network.TuyaApiParams;
import java.util.HashMap;

public final class k1 extends e<k1> {

    /* renamed from: a  reason: collision with root package name */
    public String f1521a;

    /* renamed from: b  reason: collision with root package name */
    public String f1522b;

    /* renamed from: c  reason: collision with root package name */
    public String f1523c;

    /* renamed from: d  reason: collision with root package name */
    public String f1524d;

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("appName", this.f1521a);
        hashMap.put(TuyaApiParams.KEY_APP_VERSION, this.f1522b);
        hashMap.put("appId", this.f1523c);
        hashMap.put("appInstallerId", this.f1524d);
        return e.a(hashMap, 0);
    }
}
