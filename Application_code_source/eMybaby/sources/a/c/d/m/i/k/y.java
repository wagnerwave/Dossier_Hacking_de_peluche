package a.c.d.m.i.k;

import a.c.a.f.b;
import a.c.d.r.i;
import a.c.d.r.j;
import a.c.d.s.e.d.c.b.a;
import android.view.View;
import java.util.Calendar;

public class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f668a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ z f669b;

    public y(z zVar, a aVar) {
        this.f669b = zVar;
        this.f668a = aVar;
    }

    public void run() {
        this.f669b.f670a.dismiss();
        if (this.f668a.f42a.booleanValue()) {
            this.f669b.f672c.s();
            this.f669b.f672c.n.dismiss();
            s sVar = this.f669b.f672c;
            sVar.t = false;
            sVar.r.setTitle(i.d(Calendar.getInstance().getTime()));
            z zVar = this.f669b;
            zVar.f672c.r.setValue((float) zVar.f671b.intValue());
            this.f669b.f672c.r.setIdCrecimiento(this.f668a.f1023c);
            s sVar2 = this.f669b.f672c;
            sVar2.r.setStringDate(j.g.format(sVar2.q.getTime()));
            s sVar3 = this.f669b.f672c;
            sVar3.q = null;
            sVar3.m.notifyDataSetChanged();
            s sVar4 = this.f669b.f672c;
            View view = sVar4.s;
            if (view != null) {
                view.setBackgroundResource(sVar4.p());
            }
            this.f669b.f672c.y();
            return;
        }
        b.j0(this.f669b.f672c.getActivity(), this.f668a.f43b);
    }
}
