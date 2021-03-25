package a.c.d.j.d;

import a.c.a.d.a;
import android.view.View;
import com.cuatroochenta.miniland.humidificador.device.DeviceControlActivity;
import com.sozpic.miniland.R;

public class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceControlActivity f257a;

    public h(DeviceControlActivity deviceControlActivity) {
        this.f257a = deviceControlActivity;
    }

    public void onClick(View view) {
        DeviceControlActivity deviceControlActivity = this.f257a;
        deviceControlActivity.n.a("1", Boolean.valueOf(!deviceControlActivity.g.getText().toString().equals(a.h(R.string.TR_POWER_OFF))));
    }
}
