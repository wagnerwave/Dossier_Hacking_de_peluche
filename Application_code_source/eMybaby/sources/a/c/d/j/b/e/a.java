package a.c.d.j.b.e;

import a.c.a.f.b;
import android.content.DialogInterface;
import com.sozpic.miniland.R;
import com.tuya.smart.sdk.bean.DeviceBean;

public class a implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f186a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DeviceBean f187b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b f188c;

    /* renamed from: a.c.d.j.b.e.a$a  reason: collision with other inner class name */
    public class C0010a implements DialogInterface.OnClickListener {
        public C0010a() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == -1) {
                a aVar = a.this;
                b.a(aVar.f188c, aVar.f187b);
            }
        }
    }

    public a(b bVar, boolean z, DeviceBean deviceBean) {
        this.f188c = bVar;
        this.f186a = z;
        this.f187b = deviceBean;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1 && !this.f186a) {
            b.t0(this.f188c.f190a, a.c.a.d.a.h(R.string.TR_DEVICE_CONFIRM_REMOVE), new C0010a());
        }
    }
}
