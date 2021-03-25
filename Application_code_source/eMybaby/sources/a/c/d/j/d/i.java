package a.c.d.j.d;

import android.view.View;
import com.cuatroochenta.miniland.humidificador.device.DeviceControlActivity;

public class i implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceControlActivity f258a;

    public i(DeviceControlActivity deviceControlActivity) {
        this.f258a = deviceControlActivity;
    }

    public void onClick(View view) {
        DeviceControlActivity deviceControlActivity = this.f258a;
        deviceControlActivity.u("105", Boolean.valueOf(!deviceControlActivity.o));
    }
}
