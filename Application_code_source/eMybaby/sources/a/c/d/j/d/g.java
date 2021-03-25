package a.c.d.j.d;

import android.content.DialogInterface;
import com.cuatroochenta.miniland.humidificador.device.DeviceControlActivity;

public class g implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceControlActivity f256a;

    public g(DeviceControlActivity deviceControlActivity) {
        this.f256a = deviceControlActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f256a.finish();
    }
}
