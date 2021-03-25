package a.c.d.j.d;

import android.widget.CompoundButton;
import com.cuatroochenta.miniland.humidificador.device.DeviceControlActivity;
import com.tuya.smart.common.oOO0O0O0;

public class k implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceControlActivity f260a;

    public k(DeviceControlActivity deviceControlActivity) {
        this.f260a = deviceControlActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f260a.n.a("102", z ? oOO0O0O0.O0000oO0 : "1");
    }
}
