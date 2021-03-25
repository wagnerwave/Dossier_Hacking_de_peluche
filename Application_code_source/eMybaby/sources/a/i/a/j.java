package a.i.a;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

public interface j {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final InputStream f3619a;

        /* renamed from: b  reason: collision with root package name */
        public final Bitmap f3620b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f3621c;

        /* renamed from: d  reason: collision with root package name */
        public final long f3622d;

        public a(InputStream inputStream, boolean z, long j) {
            if (inputStream != null) {
                this.f3619a = inputStream;
                this.f3620b = null;
                this.f3621c = z;
                this.f3622d = j;
                return;
            }
            throw new IllegalArgumentException("Stream may not be null.");
        }
    }

    public static class b extends IOException {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f3623a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3624b;

        public b(String str, int i, int i2) {
            super(str);
            this.f3623a = q.f(i);
            this.f3624b = i2;
        }
    }

    a a(Uri uri, int i);
}
