package a.c.d.j.b.e;

import android.content.DialogInterface;
import com.tuya.smart.sdk.bean.DeviceBean;

public class d implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceBean f197a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f198b;

    public d(b bVar, DeviceBean deviceBean) {
        this.f198b = bVar;
        this.f197a = deviceBean;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            b.a(this.f198b, this.f197a);
        }
    }
}
