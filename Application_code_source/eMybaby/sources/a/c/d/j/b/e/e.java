package a.c.d.j.b.e;

import a.c.a.f.b;
import com.tuya.smart.sdk.api.IResultCallback;

public class e implements IResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f199a;

    public e(b bVar) {
        this.f199a = bVar;
    }

    public void onError(String str, String str2) {
        b.J();
        b.r0(this.f199a.f190a, str2);
    }

    public void onSuccess() {
        this.f199a.c();
        b.J();
    }
}
