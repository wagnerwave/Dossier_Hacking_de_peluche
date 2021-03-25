package a.c.d.j.f.b;

import com.tuya.smart.android.user.api.ILoginCallback;
import com.tuya.smart.android.user.bean.User;
import com.tuya.smart.home.sdk.TuyaHomeSdk;
import com.tuya.smart.sdk.api.ITuyaUser;

public class a implements ILoginCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f288a;

    public a(b bVar) {
        this.f288a = bVar;
    }

    public void onError(String str, String str2) {
        ITuyaUser userInstance = TuyaHomeSdk.getUserInstance();
        b bVar = this.f288a;
        userInstance.registerAccountWithUid(bVar.f291c, a.c.d.j.a.f164a, "123456yuiop", bVar.f292d);
    }

    public void onSuccess(User user) {
        this.f288a.mHandler.sendEmptyMessage(15);
    }
}
