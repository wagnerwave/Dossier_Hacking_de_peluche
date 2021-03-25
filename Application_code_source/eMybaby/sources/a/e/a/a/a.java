package a.e.a.a;

import a.e.a.a.o.j.c;
import a.e.a.a.o.j.d;
import a.e.a.a.o.j.e;
import a.e.a.a.o.j.h;
import a.e.a.a.o.j.i;
import a.e.a.a.r.b;
import android.content.Context;
import android.util.Log;
import com.inuker.bluetooth.library.connect.options.BleConnectOptions;
import com.inuker.bluetooth.library.search.SearchRequest;
import java.util.UUID;

public class a implements j {

    /* renamed from: a  reason: collision with root package name */
    public j f3191a;

    public a(Context context) {
        if (context != null) {
            this.f3191a = b.s(context);
            return;
        }
        throw new NullPointerException("Context null");
    }

    public void a(String str, UUID uuid, UUID uuid2, byte[] bArr, i iVar) {
        Log.v("miio-bluetooth", b.o("write character for %s: service = %s, character = %s, value = %s", str, uuid, uuid2, a.e.a.a.r.a.b(bArr)));
        this.f3191a.a(str, uuid, uuid2, bArr, (i) b.D(iVar));
    }

    public void b(String str, a.e.a.a.o.h.a aVar) {
        this.f3191a.b(str, aVar);
    }

    public void c(String str, UUID uuid, UUID uuid2, h hVar) {
        Log.v("miio-bluetooth", b.o("unnotify %s: service = %s, character = %s", str, uuid, uuid2));
        this.f3191a.c(str, uuid, uuid2, (h) b.D(hVar));
    }

    public void d(String str) {
        Log.v("miio-bluetooth", b.o("disconnect %s", str));
        this.f3191a.d(str);
    }

    public void e(String str, int i, c cVar) {
        Log.v("miio-bluetooth", b.o("configMtu %s: mtu = %s ", str, Integer.valueOf(i)));
        this.f3191a.e(str, i, (c) b.D(cVar));
    }

    public void f(String str) {
        this.f3191a.f(str);
    }

    public void g(String str, a.e.a.a.o.j.a aVar) {
        this.f3191a.g(str, aVar);
    }

    public void h(String str, UUID uuid, UUID uuid2, byte[] bArr, i iVar) {
        Log.v("miio-bluetooth", b.o("writeNoRsp %s: service = %s, character = %s, value = %s", str, uuid, uuid2, a.e.a.a.r.a.b(bArr)));
        this.f3191a.h(str, uuid, uuid2, bArr, (i) b.D(iVar));
    }

    public void i(a.e.a.a.o.h.b bVar) {
        this.f3191a.i(bVar);
    }

    public void j(String str, UUID uuid, UUID uuid2, d dVar) {
        Log.v("miio-bluetooth", b.o("notify %s: service = %s, character = %s", str, uuid, uuid2));
        this.f3191a.j(str, uuid, uuid2, (d) b.D(dVar));
    }

    public void k(String str, UUID uuid, UUID uuid2, e eVar) {
        Log.v("miio-bluetooth", b.o("read character for %s: service = %s, character = %s", str, uuid, uuid2));
        this.f3191a.k(str, uuid, uuid2, (e) b.D(eVar));
    }

    public void l(String str, a.e.a.a.o.h.a aVar) {
        this.f3191a.l(str, aVar);
    }

    public void m(SearchRequest searchRequest, a.e.a.a.q.i.b bVar) {
        Log.v("miio-bluetooth", b.o("search %s", searchRequest));
        this.f3191a.m(searchRequest, (a.e.a.a.q.i.b) b.D(bVar));
    }

    public void n(a.e.a.a.o.h.b bVar) {
        this.f3191a.n(bVar);
    }

    public void o(String str, BleConnectOptions bleConnectOptions, a.e.a.a.o.j.a aVar) {
        Log.v("miio-bluetooth", b.o("connect %s", str));
        this.f3191a.o(str, bleConnectOptions, (a.e.a.a.o.j.a) b.D(aVar));
    }

    public void stopSearch() {
        Log.v("miio-bluetooth", b.o("stopSearch", new Object[0]));
        this.f3191a.stopSearch();
    }
}
