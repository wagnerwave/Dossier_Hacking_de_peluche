package a.i.a;

import a.i.a.t;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import java.io.InputStream;

public abstract class y {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final t.d f3692a;

        /* renamed from: b  reason: collision with root package name */
        public final Bitmap f3693b;

        /* renamed from: c  reason: collision with root package name */
        public final InputStream f3694c;

        /* renamed from: d  reason: collision with root package name */
        public final int f3695d;

        public a(Bitmap bitmap, InputStream inputStream, t.d dVar, int i) {
            boolean z = true;
            if ((inputStream == null ? false : z) ^ (bitmap != null)) {
                this.f3693b = bitmap;
                this.f3694c = inputStream;
                g0.d(dVar, "loadedFrom == null");
                this.f3692a = dVar;
                this.f3695d = i;
                return;
            }
            throw new AssertionError();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public a(InputStream inputStream, t.d dVar) {
            this((Bitmap) null, inputStream, dVar, 0);
            g0.d(inputStream, "stream == null");
        }
    }

    public static void a(int i, int i2, int i3, int i4, BitmapFactory.Options options, w wVar) {
        int i5;
        double d2;
        if (i4 > i2 || i3 > i) {
            if (i2 == 0) {
                d2 = (double) (((float) i3) / ((float) i));
            } else if (i == 0) {
                d2 = (double) (((float) i4) / ((float) i2));
            } else {
                int floor = (int) Math.floor((double) (((float) i4) / ((float) i2)));
                int floor2 = (int) Math.floor((double) (((float) i3) / ((float) i)));
                i5 = wVar.k ? Math.max(floor, floor2) : Math.min(floor, floor2);
            }
            i5 = (int) Math.floor(d2);
        } else {
            i5 = 1;
        }
        options.inSampleSize = i5;
        options.inJustDecodeBounds = false;
    }

    public static void b(int i, int i2, BitmapFactory.Options options, w wVar) {
        a(i, i2, options.outWidth, options.outHeight, options, wVar);
    }

    public static BitmapFactory.Options d(w wVar) {
        boolean a2 = wVar.a();
        boolean z = wVar.q != null;
        BitmapFactory.Options options = null;
        if (a2 || z) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = a2;
            if (z) {
                options.inPreferredConfig = wVar.q;
            }
        }
        return options;
    }

    public abstract boolean c(w wVar);

    public int e() {
        return 0;
    }

    public abstract a f(w wVar, int i);

    public boolean g(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    public boolean h() {
        return false;
    }
}
