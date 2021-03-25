package a.c.d.j.e.g;

import a.c.d.j.b.d.e;
import com.tuya.smart.home.sdk.bean.HomeBean;
import com.tuya.smart.home.sdk.callback.ITuyaHomeResultCallback;

public class a implements ITuyaHomeResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f285a;

    public a(b bVar) {
        this.f285a = bVar;
    }

    public void onError(String str, String str2) {
        a.c.d.j.e.d.a aVar = this.f285a.f287b;
        if (aVar != null) {
            ((e) aVar).q();
        }
    }

    public void onSuccess(HomeBean homeBean) {
        a.c.d.j.e.d.a aVar = this.f285a.f287b;
        if (aVar != null) {
            ((e) aVar).q();
        }
    }
}
