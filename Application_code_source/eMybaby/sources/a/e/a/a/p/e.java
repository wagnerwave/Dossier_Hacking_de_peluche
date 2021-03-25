package a.e.a.a.p;

import a.c.a.f.b;
import a.e.a.a.p.i.g;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class e extends BroadcastReceiver implements Handler.Callback, g {

    /* renamed from: e  reason: collision with root package name */
    public static g f3263e;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, List<g>> f3264a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public Handler f3265b = new Handler(Looper.getMainLooper(), this);

    /* renamed from: c  reason: collision with root package name */
    public h f3266c;

    /* renamed from: d  reason: collision with root package name */
    public a[] f3267d;

    public class a implements h {
        public a() {
        }
    }

    public e() {
        a aVar = new a();
        this.f3266c = aVar;
        f fVar = new f(aVar);
        this.f3267d = new a[]{fVar, new d(this.f3266c), new c(this.f3266c), new b(this.f3266c)};
        IntentFilter intentFilter = new IntentFilter();
        for (a a2 : this.f3267d) {
            for (String addAction : a2.a()) {
                intentFilter.addAction(addAction);
            }
        }
        b.E().registerReceiver(this, intentFilter);
    }

    public static g a() {
        if (f3263e == null) {
            synchronized (e.class) {
                if (f3263e == null) {
                    f3263e = new e();
                }
            }
        }
        return f3263e;
    }

    public boolean handleMessage(Message message) {
        g gVar;
        if (message.what == 1 && (gVar = (g) message.obj) != null) {
            List list = this.f3264a.get(gVar.a());
            if (list == null) {
                list = new LinkedList();
                this.f3264a.put(gVar.a(), list);
            }
            list.add(gVar);
        }
        return true;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                Log.v("miio-bluetooth", a.e.a.a.r.b.o("BluetoothReceiver onReceive: %s", action));
                a[] aVarArr = this.f3267d;
                int length = aVarArr.length;
                int i = 0;
                while (i < length) {
                    a aVar = aVarArr[i];
                    List<String> a2 = aVar.a();
                    if (!((b.S(a2) || TextUtils.isEmpty(action)) ? false : a2.contains(action)) || !aVar.c(context, intent)) {
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
