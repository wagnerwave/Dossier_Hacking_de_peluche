package a.e.a.a.q;

import a.e.a.a.q.g.a;
import a.e.a.a.q.h.a;
import a.e.a.a.r.b;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.os.EnvironmentCompat;
import com.inuker.bluetooth.library.search.SearchTask;

public class d implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public int f3283a;

    /* renamed from: b  reason: collision with root package name */
    public int f3284b;

    /* renamed from: c  reason: collision with root package name */
    public e f3285c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f3286d = new Handler(Looper.myLooper(), this);

    public d(SearchTask searchTask) {
        this.f3283a = searchTask.f4339a;
        this.f3284b = searchTask.f4340b;
    }

    public final e a() {
        e eVar;
        if (this.f3285c == null) {
            int i = this.f3283a;
            if (i == 1) {
                eVar = a.b.f3290a;
            } else if (i == 2) {
                eVar = a.b.f3294a;
            } else {
                throw new IllegalStateException(b.o("unknown search type %d", Integer.valueOf(i)));
            }
            this.f3285c = eVar;
        }
        return this.f3285c;
    }

    public boolean handleMessage(Message message) {
        if (message.what != 34) {
            return true;
        }
        a().c();
        return true;
    }

    public String toString() {
        String str;
        String str2;
        if (this.f3283a == 2) {
            str = "Ble";
        } else {
            str = this.f3283a == 1 ? "classic" : EnvironmentCompat.MEDIA_UNKNOWN;
        }
        int i = this.f3284b;
        Object[] objArr = new Object[2];
        if (i >= 1000) {
            objArr[0] = str;
            objArr[1] = Integer.valueOf(i / 1000);
            str2 = "%s search (%ds)";
        } else {
            objArr[0] = str;
            double d2 = (double) i;
            Double.isNaN(d2);
            Double.isNaN(d2);
            objArr[1] = Double.valueOf((d2 * 1.0d) / 1000.0d);
            str2 = "%s search (%.1fs)";
        }
        return b.o(str2, objArr);
    }
}
