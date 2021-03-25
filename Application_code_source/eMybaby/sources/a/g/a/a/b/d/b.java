package a.g.a.a.b.d;

import android.graphics.Bitmap;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class b extends a.g.a.a.b.b<String, Bitmap> {

    /* renamed from: e  reason: collision with root package name */
    public final Map<Bitmap, Integer> f3352e = Collections.synchronizedMap(new HashMap());

    public b(int i) {
        super(i);
    }

    public Reference a(Object obj) {
        return new WeakReference((Bitmap) obj);
    }

    public int b(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        return bitmap.getHeight() * bitmap.getRowBytes();
    }

    public void clear() {
        this.f3352e.clear();
        super.clear();
    }

    public Object get(Object obj) {
        Integer num;
        Bitmap bitmap = (Bitmap) super.get((String) obj);
        if (!(bitmap == null || (num = this.f3352e.get(bitmap)) == null)) {
            this.f3352e.put(bitmap, Integer.valueOf(num.intValue() + 1));
        }
        return bitmap;
    }

    public boolean put(Object obj, Object obj2) {
        Bitmap bitmap = (Bitmap) obj2;
        if (!super.put((String) obj, bitmap)) {
            return false;
        }
        this.f3352e.put(bitmap, 0);
        return true;
    }

    public void remove(Object obj) {
        String str = (String) obj;
        Bitmap bitmap = (Bitmap) super.get(str);
        if (bitmap != null) {
            this.f3352e.remove(bitmap);
        }
        super.remove(str);
    }
}
