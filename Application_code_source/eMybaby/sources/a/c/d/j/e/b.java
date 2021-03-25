package a.c.d.j.e;

import com.tuya.smart.home.sdk.bean.HomeBean;
import com.tuya.smart.home.sdk.callback.ITuyaHomeResultCallback;

public class b implements ITuyaHomeResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ITuyaHomeResultCallback f281a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f282b;

    public b(c cVar, ITuyaHomeResultCallback iTuyaHomeResultCallback) {
        this.f282b = cVar;
        this.f281a = iTuyaHomeResultCallback;
    }

    public void onError(String str, String str2) {
        this.f281a.onError(str, str2);
    }

    public void onSuccess(HomeBean homeBean) {
        this.f282b.c(homeBean);
        this.f281a.onSuccess(homeBean);
    }
}
