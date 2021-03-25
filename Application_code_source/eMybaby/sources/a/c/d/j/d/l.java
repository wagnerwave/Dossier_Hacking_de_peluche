package a.c.d.j.d;

import android.widget.CompoundButton;
import com.cuatroochenta.miniland.humidificador.device.DeviceControlActivity;
import com.tuya.smart.common.oOO0O0O0;
import java.util.HashMap;
import java.util.Map;

public class l implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceControlActivity f261a;

    public l(DeviceControlActivity deviceControlActivity) {
        this.f261a = deviceControlActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.f261a.z.setVisibility(0);
            Map<String, Object> dps = this.f261a.n.f270d.getDps();
            HashMap hashMap = new HashMap();
            if (!((Boolean) dps.get("1")).booleanValue()) {
                hashMap.put("1", Boolean.TRUE);
            }
            hashMap.put("6", String.valueOf(2));
            hashMap.put("2", "manual");
            this.f261a.n.b(oOO0O0O0.O0000oO0, hashMap);
            return;
        }
        this.f261a.u("2", "humidity");
        this.f261a.z.setVisibility(8);
    }
}
