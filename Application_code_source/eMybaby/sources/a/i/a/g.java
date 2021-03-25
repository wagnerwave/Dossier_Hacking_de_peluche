package a.i.a;

import a.i.a.t;
import a.i.a.y;
import android.content.Context;
import com.tuya.smart.common.o00000oo0;

public class g extends y {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3606a;

    public g(Context context) {
        this.f3606a = context;
    }

    public boolean c(w wVar) {
        return o00000oo0.O00000o0.equals(wVar.f3680d.getScheme());
    }

    public y.a f(w wVar, int i) {
        return new y.a(this.f3606a.getContentResolver().openInputStream(wVar.f3680d), t.d.DISK);
    }
}
