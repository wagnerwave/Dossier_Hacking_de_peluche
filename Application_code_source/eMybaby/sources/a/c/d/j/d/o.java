package a.c.d.j.d;

import android.widget.CompoundButton;
import com.cuatroochenta.miniland.humidificador.device.DeviceControlActivity;
import com.tuya.smart.android.device.bean.SchemaBean;
import com.tuya.smart.common.oOO0O0O0;

public class o implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceControlActivity f264a;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            o.this.f264a.J.fullScroll(130);
        }
    }

    public o(DeviceControlActivity deviceControlActivity) {
        this.f264a = deviceControlActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        DeviceControlActivity deviceControlActivity = this.f264a;
        if (z) {
            deviceControlActivity.B.setVisibility(0);
            this.f264a.H.setValue(0);
            this.f264a.J.postDelayed(new a(), 200);
            return;
        }
        deviceControlActivity.B.setVisibility(8);
        SchemaBean schemaBean = this.f264a.n.f270d.getSchemaMap().get("13");
        if (schemaBean != null) {
            this.f264a.u(schemaBean.getId(), oOO0O0O0.O0000oO0);
        }
    }
}
