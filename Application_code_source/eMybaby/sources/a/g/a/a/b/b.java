package a.g.a.a.b;

import android.graphics.Bitmap;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class b<K, V> extends a<K, V> {

    /* renamed from: b  reason: collision with root package name */
    public final int f3347b;

    /* renamed from: c  reason: collision with root package name */
    public int f3348c = 0;

    /* renamed from: d  reason: collision with root package name */
    public final List<V> f3349d = Collections.synchronizedList(new LinkedList());

    public b(int i) {
        this.f3347b = i;
        if (i > 16777216) {
            a.e.a.a.r.b.f0("You set too large memory cache size (more than %1$d Mb)", 16);
        }
    }

    public abstract int b(V v);

    public void clear() {
        this.f3349d.clear();
        this.f3348c = 0;
        this.f3346a.clear();
    }

    public boolean put(K k, V v) {
        boolean z;
        Bitmap bitmap;
        int b2 = b(v);
        int i = this.f3347b;
        if (b2 < i) {
            while (this.f3348c + b2 > i) {
                a.g.a.a.b.d.b bVar = (a.g.a.a.b.d.b) this;
                Set<Map.Entry<Bitmap, Integer>> entrySet = bVar.f3352e.entrySet();
                synchronized (bVar.f3352e) {
                    bitmap = null;
                    Integer num = null;
                    for (Map.Entry next : entrySet) {
                        if (bitmap == null) {
                            bitmap = (Bitmap) next.getKey();
                            num = (Integer) next.getValue();
                        } else {
                            Integer num2 = (Integer) next.getValue();
                            if (num2.intValue() < num.intValue()) {
                                bitmap = (Bitmap) next.getKey();
                                num = num2;
                            }
                        }
                    }
                }
                bVar.f3352e.remove(bitmap);
                if (this.f3349d.remove(bitmap)) {
                    this.f3348c -= b(bitmap);
                }
            }
            this.f3349d.add(v);
            this.f3348c += b2;
            z = true;
        } else {
            z = false;
        }
        this.f3346a.put(k, a(v));
        return z;
    }

    public void remove(K k) {
        Object obj = super.get(k);
        if (obj != null && this.f3349d.remove(obj)) {
            this.f3348c -= b(obj);
        }
        this.f3346a.remove(k);
    }
}
