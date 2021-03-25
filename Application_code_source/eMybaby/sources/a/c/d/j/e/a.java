package a.c.d.j.e;

import a.c.a.f.b;
import com.tuya.smart.home.sdk.bean.HomeBean;
import com.tuya.smart.home.sdk.callback.ITuyaGetHomeListCallback;
import java.util.List;

public class a implements ITuyaGetHomeListCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ITuyaGetHomeListCallback f279a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f280b;

    public a(c cVar, ITuyaGetHomeListCallback iTuyaGetHomeListCallback) {
        this.f280b = cVar;
        this.f279a = iTuyaGetHomeListCallback;
    }

    public void onError(String str, String str2) {
        this.f279a.onError(str, str2);
    }

    public void onSuccess(List<HomeBean> list) {
        if (!b.R(list) && this.f280b.a() == null) {
            this.f280b.c(list.get(0));
        }
        this.f279a.onSuccess(list);
    }
}
