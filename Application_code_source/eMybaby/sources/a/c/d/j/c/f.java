package a.c.d.j.c;

import a.c.a.d.a;
import a.c.a.f.b;
import com.cuatroochenta.miniland.humidificador.config.ECBindActivity;
import com.sozpic.miniland.R;
import com.tuya.smart.home.sdk.TuyaHomeSdk;
import com.tuya.smart.home.sdk.builder.ActivatorBuilder;
import com.tuya.smart.sdk.api.ITuyaActivatorGetToken;
import com.tuya.smart.sdk.enums.ActivatorModelEnum;

public class f implements ITuyaActivatorGetToken {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f232a;

    public f(g gVar) {
        this.f232a = gVar;
    }

    public void onFailure(String str, String str2) {
        b.J();
        g gVar = this.f232a;
        if (gVar.f235c == 1) {
            ECBindActivity eCBindActivity = (ECBindActivity) gVar.f234b;
            eCBindActivity.u();
            eCBindActivity.q.setText(a.h(R.string.TR_NO_NETWORK_CONNECTION));
        }
    }

    public void onSuccess(String str) {
        b.J();
        g gVar = this.f232a;
        int i = gVar.f235c;
        if (i == 1) {
            c cVar = gVar.f;
            String str2 = gVar.h;
            String str3 = gVar.g;
            if (cVar != null) {
                cVar.f229b = ActivatorModelEnum.TY_EZ;
                cVar.f228a = TuyaHomeSdk.getActivatorInstance().newMultiActivator(new ActivatorBuilder().setSsid(str2).setContext(cVar.mContext).setPassword(str3).setActivatorModel(ActivatorModelEnum.TY_EZ).setTimeOut(100).setToken(str).setListener(new a(cVar)));
                gVar.a();
                return;
            }
            throw null;
        } else if (i == 0) {
            c cVar2 = gVar.f;
            String str4 = gVar.h;
            String str5 = gVar.g;
            if (cVar2 != null) {
                cVar2.f229b = ActivatorModelEnum.TY_AP;
                cVar2.f228a = TuyaHomeSdk.getActivatorInstance().newActivator(new ActivatorBuilder().setSsid(str4).setContext(cVar2.mContext).setPassword(str5).setActivatorModel(ActivatorModelEnum.TY_AP).setTimeOut(100).setToken(str).setListener(new b(cVar2)));
                return;
            }
            throw null;
        }
    }
}
