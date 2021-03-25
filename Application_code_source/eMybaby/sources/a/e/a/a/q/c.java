package a.e.a.a.q;

import a.e.a.a.r.b;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.inuker.bluetooth.library.search.SearchRequest;
import com.inuker.bluetooth.library.search.SearchResult;
import com.inuker.bluetooth.library.search.SearchTask;
import java.util.ArrayList;
import java.util.List;

public class c implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public List<d> f3277a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public a.e.a.a.q.i.a f3278b;

    /* renamed from: c  reason: collision with root package name */
    public d f3279c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f3280d;

    public class a implements a.e.a.a.q.i.a {

        /* renamed from: a  reason: collision with root package name */
        public d f3281a;

        public a(d dVar) {
            this.f3281a = dVar;
        }

        public void onDeviceFounded(SearchResult searchResult) {
            c.this.f3280d.obtainMessage(18, searchResult).sendToTarget();
        }

        public void onSearchCanceled() {
            Log.v("miio-bluetooth", b.o("%s onSearchCanceled", this.f3281a));
        }

        public void onSearchStarted() {
            Log.v("miio-bluetooth", b.o("%s onSearchStarted", this.f3281a));
        }

        public void onSearchStopped() {
            Log.v("miio-bluetooth", b.o("%s onSearchStopped", this.f3281a));
            c.this.f3280d.sendEmptyMessageDelayed(17, 100);
        }
    }

    public c(SearchRequest searchRequest) {
        for (SearchTask dVar : searchRequest.f4335a) {
            this.f3277a.add(new d(dVar));
        }
        this.f3280d = new Handler(Looper.myLooper(), this);
    }

    public void a() {
        d dVar = this.f3279c;
        if (dVar != null) {
            dVar.f3286d.removeCallbacksAndMessages((Object) null);
            dVar.a().a();
            this.f3279c = null;
        }
        this.f3277a.clear();
        a.e.a.a.q.i.a aVar = this.f3278b;
        if (aVar != null) {
            aVar.onSearchCanceled();
        }
        this.f3278b = null;
    }

    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i != 17) {
            if (i != 18) {
                return true;
            }
            SearchResult searchResult = (SearchResult) message.obj;
            a.e.a.a.q.i.a aVar = this.f3278b;
            if (aVar == null) {
                return true;
            }
            aVar.onDeviceFounded(searchResult);
            return true;
        } else if (this.f3277a.size() > 0) {
            d remove = this.f3277a.remove(0);
            this.f3279c = remove;
            remove.a().b(new a(remove));
            int i2 = remove.f3284b;
            if (i2 == -1) {
                return true;
            }
            remove.f3286d.sendEmptyMessageDelayed(34, (long) i2);
            return true;
        } else {
            this.f3279c = null;
            a.e.a.a.q.i.a aVar2 = this.f3278b;
            if (aVar2 == null) {
                return true;
            }
            aVar2.onSearchStopped();
            return true;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (d dVar : this.f3277a) {
            sb.append(dVar.toString() + ", ");
        }
        return sb.toString();
    }
}
