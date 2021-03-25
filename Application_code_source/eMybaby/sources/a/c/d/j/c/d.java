package a.c.d.j.c;

import android.content.Intent;
import android.view.View;
import com.cuatroochenta.miniland.humidificador.config.ECBindActivity;

public class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ECBindActivity f230a;

    public d(ECBindActivity eCBindActivity) {
        this.f230a = eCBindActivity;
    }

    public void onClick(View view) {
        Intent intent = new Intent("android.settings.WIFI_SETTINGS");
        if (intent.resolveActivity(this.f230a.getPackageManager()) == null) {
            intent = new Intent("android.settings.WIFI_SETTINGS");
            if (intent.resolveActivity(this.f230a.getPackageManager()) == null) {
                return;
            }
        }
        this.f230a.startActivity(intent);
    }
}
