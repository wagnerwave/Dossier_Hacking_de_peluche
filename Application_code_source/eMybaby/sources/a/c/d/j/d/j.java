package a.c.d.j.d;

import android.widget.CompoundButton;
import com.cuatroochenta.miniland.humidificador.device.DeviceControlActivity;

public class j implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceControlActivity f259a;

    public j(DeviceControlActivity deviceControlActivity) {
        this.f259a = deviceControlActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f259a.u("106", Boolean.valueOf(!z));
    }
}
