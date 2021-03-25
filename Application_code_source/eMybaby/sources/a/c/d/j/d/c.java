package a.c.d.j.d;

import com.cuatroochenta.miniland.humidificador.device.DeviceControlActivity;
import com.cuatroochenta.miniland.humidificador.test.widget.NumberPicker;

public class c implements NumberPicker.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceControlActivity f253a;

    public c(DeviceControlActivity deviceControlActivity) {
        this.f253a = deviceControlActivity;
    }

    public void a(NumberPicker numberPicker, int i) {
        DeviceControlActivity deviceControlActivity = this.f253a;
        deviceControlActivity.I = i;
        DeviceControlActivity.s(deviceControlActivity, numberPicker);
    }
}
