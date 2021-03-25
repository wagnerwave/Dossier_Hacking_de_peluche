package a.c.d.d;

import a.c.a.d.a;
import a.c.d.d.d;
import android.app.Activity;
import android.widget.Toast;
import com.sozpic.miniland.R;

public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a.c.d.s.g.c f59a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f60b;

    public c(d dVar, a.c.d.s.g.c cVar) {
        this.f60b = dVar;
        this.f59a = cVar;
    }

    public void run() {
        String str;
        this.f60b.i.dismiss();
        a.c.d.s.g.c cVar = this.f59a;
        if (cVar.f1149a) {
            Toast.makeText(this.f60b.m, a.h(R.string.TR_UPLOAD_PHOTO_OK), 0).show();
            d dVar = this.f60b;
            d.a aVar = dVar.j;
            if (aVar != null) {
                aVar.l(dVar.f795d);
                return;
            }
            return;
        }
        Activity activity = this.f60b.m;
        if (!a.j(cVar.f1150b)) {
            str = this.f59a.f1150b;
        } else {
            str = a.h(R.string.TR_UPLOAD_PHOTO_KO);
        }
        Toast.makeText(activity, str, 0).show();
    }
}
