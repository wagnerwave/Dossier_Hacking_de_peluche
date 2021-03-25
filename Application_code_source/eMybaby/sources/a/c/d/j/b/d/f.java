package a.c.d.j.b.d;

import a.c.a.d.a;
import a.c.d.j.b.e.b;
import a.c.d.j.b.e.c;
import android.app.Activity;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.view.View;
import com.cuatroochenta.miniland.humidificador.config.AddDeviceTipActivity;
import com.sozpic.miniland.R;
import com.tuya.smart.android.common.utils.NetworkUtil;

public class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f184a;

    public f(e eVar) {
        this.f184a = eVar;
    }

    public void onClick(View view) {
        b bVar = this.f184a.f178b;
        WifiManager wifiManager = (WifiManager) bVar.f190a.getApplicationContext().getSystemService(NetworkUtil.CONN_TYPE_WIFI);
        if (!wifiManager.isWifiEnabled()) {
            a.c.a.f.b.t0(bVar.f190a, a.h(R.string.TR_START_WIFI), new c(bVar, wifiManager));
            return;
        }
        Activity activity = bVar.f190a;
        Intent intent = new Intent();
        intent.setClass(activity, AddDeviceTipActivity.class);
        a.c.a.f.b.w0(activity, intent, 3, false);
    }
}
