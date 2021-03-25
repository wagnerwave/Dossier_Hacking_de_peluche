package a.c.d.j.d;

import android.view.View;
import android.widget.ImageView;
import com.cuatroochenta.miniland.humidificador.device.DeviceControlActivity;
import com.sozpic.miniland.R;
import com.tuya.smart.common.OO000o0;

public class m implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceControlActivity f262a;

    public m(DeviceControlActivity deviceControlActivity) {
        this.f262a = deviceControlActivity;
    }

    public void onClick(View view) {
        ImageView imageView;
        int i;
        DeviceControlActivity deviceControlActivity = this.f262a;
        int i2 = deviceControlActivity.D;
        if (i2 == 2) {
            deviceControlActivity.u("6", OO000o0.O00000o);
            imageView = this.f262a.C;
            i = R.drawable.ic_fog_3;
        } else if (i2 != 3) {
            deviceControlActivity.u("6", "2");
            imageView = this.f262a.C;
            i = R.drawable.ic_fog_2;
        } else {
            deviceControlActivity.u("6", "1");
            imageView = this.f262a.C;
            i = R.drawable.ic_fog_1;
        }
        imageView.setImageResource(i);
    }
}
