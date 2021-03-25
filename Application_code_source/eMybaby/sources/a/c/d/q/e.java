package a.c.d.q;

import com.sozpic.miniland.ListadoTermometroActivity;

public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Float f778a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f779b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b f780c;

    public e(b bVar, Float f, int i) {
        this.f780c = bVar;
        this.f778a = f;
        this.f779b = i;
    }

    public void run() {
        a aVar = this.f780c.f770e;
        if (aVar != null) {
            float floatValue = this.f778a.floatValue();
            boolean z = true;
            if ((this.f779b & 1) != 0) {
                z = false;
            }
            ListadoTermometroActivity listadoTermometroActivity = (ListadoTermometroActivity) aVar;
            if (z) {
                listadoTermometroActivity.r = floatValue;
                listadoTermometroActivity.q = ((floatValue * 9.0f) / 5.0f) + 32.0f;
            } else {
                listadoTermometroActivity.q = floatValue;
                listadoTermometroActivity.r = ((floatValue - 32.0f) * 5.0f) / 9.0f;
            }
            listadoTermometroActivity.m.setVisibility(8);
            listadoTermometroActivity.B();
            listadoTermometroActivity.v();
        }
    }
}
