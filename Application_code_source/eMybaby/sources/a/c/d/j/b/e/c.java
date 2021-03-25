package a.c.d.j.b.e;

import a.c.a.f.b;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiManager;
import com.cuatroochenta.miniland.humidificador.config.AddDeviceTipActivity;

public class c implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WifiManager f195a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f196b;

    public c(b bVar, WifiManager wifiManager) {
        this.f196b = bVar;
        this.f195a = wifiManager;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.f195a.setWifiEnabled(true);
            Activity activity = this.f196b.f190a;
            Intent intent = new Intent();
            intent.setClass(activity, AddDeviceTipActivity.class);
            b.w0(activity, intent, 3, false);
        }
    }
}
