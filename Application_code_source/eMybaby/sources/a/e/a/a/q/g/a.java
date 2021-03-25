package a.e.a.a.q.g;

import a.e.a.a.q.e;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.inuker.bluetooth.library.search.SearchResult;

public class a extends e {

    /* renamed from: c  reason: collision with root package name */
    public c f3289c;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static a f3290a = new a((C0077a) null);
    }

    public class c extends BroadcastReceiver {
        public c(C0077a aVar) {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.bluetooth.device.action.FOUND")) {
                SearchResult searchResult = new SearchResult((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE"), intent.getShortExtra("android.bluetooth.device.extra.RSSI", Short.MIN_VALUE), (byte[]) null);
                a.e.a.a.q.i.a aVar = a.this.f3288b;
                if (aVar != null) {
                    aVar.onDeviceFounded(searchResult);
                }
            }
        }
    }

    public a(C0077a aVar) {
        this.f3287a = a.c.a.f.b.D();
    }

    public void a() {
        c cVar = this.f3289c;
        if (cVar != null) {
            a.c.a.f.b.E().unregisterReceiver(cVar);
            this.f3289c = null;
        }
        if (this.f3287a.isDiscovering()) {
            this.f3287a.cancelDiscovery();
        }
        super.a();
    }

    public void b(a.e.a.a.q.i.a aVar) {
        this.f3288b = aVar;
        if (aVar != null) {
            aVar.onSearchStarted();
        }
        if (this.f3289c == null) {
            c cVar = new c((C0077a) null);
            this.f3289c = cVar;
            a.c.a.f.b.E().registerReceiver(cVar, new IntentFilter("android.bluetooth.device.action.FOUND"));
        }
        if (this.f3287a.isDiscovering()) {
            this.f3287a.cancelDiscovery();
        }
        this.f3287a.startDiscovery();
    }

    public void c() {
        c cVar = this.f3289c;
        if (cVar != null) {
            a.c.a.f.b.E().unregisterReceiver(cVar);
            this.f3289c = null;
        }
        if (this.f3287a.isDiscovering()) {
            this.f3287a.cancelDiscovery();
        }
        super.c();
    }
}
