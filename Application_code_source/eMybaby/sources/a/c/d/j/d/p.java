package a.c.d.j.d;

import android.view.View;
import com.cuatroochenta.miniland.humidificador.device.DeviceControlActivity;
import com.cuatroochenta.miniland.humidificador.test.widget.NumberPicker;
import com.tuya.smart.android.device.bean.SchemaBean;

public class p implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceControlActivity f266a;

    public p(DeviceControlActivity deviceControlActivity) {
        this.f266a = deviceControlActivity;
    }

    public void onClick(View view) {
        SchemaBean schemaBean;
        DeviceControlActivity deviceControlActivity = this.f266a;
        NumberPicker numberPicker = deviceControlActivity.H;
        if (numberPicker.getValue() > 0 && (schemaBean = deviceControlActivity.n.f270d.getSchemaMap().get("13")) != null) {
            deviceControlActivity.u(schemaBean.getId(), deviceControlActivity.F.get(numberPicker.getValue()));
            deviceControlActivity.B.setVisibility(8);
        }
    }
}
