package a.e.a.a.q.h;

import a.e.a.a.q.e;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.inuker.bluetooth.library.search.SearchResult;

public class a extends e {

    /* renamed from: c  reason: collision with root package name */
    public final BluetoothAdapter.LeScanCallback f3292c = new C0078a();

    /* renamed from: a.e.a.a.q.h.a$a  reason: collision with other inner class name */
    public class C0078a implements BluetoothAdapter.LeScanCallback {
        public C0078a() {
        }

        public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            a aVar = a.this;
            SearchResult searchResult = new SearchResult(bluetoothDevice, i, bArr);
            a.e.a.a.q.i.a aVar2 = aVar.f3288b;
            if (aVar2 != null) {
                aVar2.onDeviceFounded(searchResult);
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static a f3294a = new a((C0078a) null);
    }

    public a(C0078a aVar) {
        this.f3287a = a.c.a.f.b.D();
    }

    @TargetApi(18)
    public void a() {
        this.f3287a.stopLeScan(this.f3292c);
        super.a();
    }

    @TargetApi(18)
    public void b(a.e.a.a.q.i.a aVar) {
        this.f3288b = aVar;
        if (aVar != null) {
            aVar.onSearchStarted();
        }
        this.f3287a.startLeScan(this.f3292c);
    }

    @TargetApi(18)
    public void c() {
        try {
            this.f3287a.stopLeScan(this.f3292c);
        } catch (Exception e2) {
            a.c.a.f.b.z(e2);
        }
        super.c();
    }
}
