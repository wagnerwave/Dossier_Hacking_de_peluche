package a.d.a.a.e.k.l;

import a.a.a.a.a;
import a.d.a.a.h.e.d;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public final class s0 extends Fragment implements i {

    /* renamed from: d  reason: collision with root package name */
    public static WeakHashMap<Activity, WeakReference<s0>> f1325d = new WeakHashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public Map<String, LifecycleCallback> f1326a = new ArrayMap();

    /* renamed from: b  reason: collision with root package name */
    public int f1327b = 0;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f1328c;

    public final void b(String str, @NonNull LifecycleCallback lifecycleCallback) {
        if (!this.f1326a.containsKey(str)) {
            this.f1326a.put(str, lifecycleCallback);
            if (this.f1327b > 0) {
                new d(Looper.getMainLooper()).post(new t0(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        throw new IllegalArgumentException(a.d(str.length() + 59, "LifecycleCallback with tag ", str, " already added to this fragment."));
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback a2 : this.f1326a.values()) {
            a2.a();
        }
    }

    public final <T extends LifecycleCallback> T j(String str, Class<T> cls) {
        return (LifecycleCallback) cls.cast(this.f1326a.get(str));
    }

    public final Activity k() {
        return getActivity();
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (LifecycleCallback c2 : this.f1326a.values()) {
            c2.c(i, i2, intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1327b = 1;
        this.f1328c = bundle;
        for (Map.Entry next : this.f1326a.entrySet()) {
            ((LifecycleCallback) next.getValue()).d(bundle != null ? bundle.getBundle((String) next.getKey()) : null);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f1327b = 5;
        for (LifecycleCallback lifecycleCallback : this.f1326a.values()) {
            if (lifecycleCallback == null) {
                throw null;
            }
        }
    }

    public final void onResume() {
        super.onResume();
        this.f1327b = 3;
        for (LifecycleCallback e2 : this.f1326a.values()) {
            e2.e();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry next : this.f1326a.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) next.getValue()).f(bundle2);
                bundle.putBundle((String) next.getKey(), bundle2);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        this.f1327b = 2;
        for (LifecycleCallback g : this.f1326a.values()) {
            g.g();
        }
    }

    public final void onStop() {
        super.onStop();
        this.f1327b = 4;
        for (LifecycleCallback h : this.f1326a.values()) {
            h.h();
        }
    }
}
