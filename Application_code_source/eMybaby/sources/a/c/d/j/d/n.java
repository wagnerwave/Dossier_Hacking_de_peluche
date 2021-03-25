package a.c.d.j.d;

import android.widget.CompoundButton;
import com.cuatroochenta.miniland.humidificador.device.DeviceControlActivity;
import com.tuya.smart.common.oOO0O0O0;
import java.util.HashMap;
import java.util.Map;

public class n implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceControlActivity f263a;

    public n(DeviceControlActivity deviceControlActivity) {
        this.f263a = deviceControlActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.f263a.u("2", "humidity");
            this.f263a.A.setVisibility(0);
            return;
        }
        this.f263a.A.setVisibility(8);
        Map<String, Object> dps = this.f263a.n.f270d.getDps();
        HashMap hashMap = new HashMap();
        if (!((Boolean) dps.get("1")).booleanValue()) {
            hashMap.put("1", Boolean.TRUE);
        }
        hashMap.put("6", String.valueOf(2));
        hashMap.put("2", "manual");
        this.f263a.n.b(oOO0O0O0.O0000oO0, hashMap);
    }
}
