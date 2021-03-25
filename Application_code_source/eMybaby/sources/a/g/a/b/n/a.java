package a.g.a.b.n;

import a.g.a.b.d;
import a.g.a.b.l.b;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import com.tuya.smart.common.o00000oo0;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;

public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3444a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3445b = 5000;

    /* renamed from: c  reason: collision with root package name */
    public final int f3446c = 20000;

    public a(Context context) {
        this.f3444a = context.getApplicationContext();
    }

    public InputStream a(URI uri, Object obj) {
        String scheme = uri.getScheme();
        if ("http".equals(scheme) || "https".equals(scheme)) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) uri.toURL().openConnection();
            if (d.e().f() != null) {
                httpURLConnection.setRequestProperty("User-Agent", d.e().f());
            }
            httpURLConnection.setConnectTimeout(this.f3445b);
            httpURLConnection.setReadTimeout(this.f3446c);
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                return new b(httpURLConnection.getInputStream(), 8192);
            }
            if (responseCode == 302) {
                URI create = URI.create(httpURLConnection.getHeaderField("Location"));
                httpURLConnection.disconnect();
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) create.toURL().openConnection();
                if (d.e().f() != null) {
                    httpURLConnection2.setRequestProperty("User-Agent", d.e().f());
                }
                httpURLConnection2.setConnectTimeout(this.f3445b);
                httpURLConnection2.setReadTimeout(this.f3446c);
                return new b(httpURLConnection2.getInputStream(), 8192);
            }
            StringBuilder n = a.a.a.a.a.n("Image not found at ");
            n.append(uri.toURL());
            throw new IOException(n.toString());
        } else if ("file".equals(scheme)) {
            return new BufferedInputStream(uri.toURL().openStream(), 8192);
        } else {
            if (o00000oo0.O00000o0.equals(scheme)) {
                return this.f3444a.getContentResolver().openInputStream(Uri.parse(uri.toString()));
            }
            if ("assets".equals(scheme)) {
                return this.f3444a.getAssets().open(uri.toString().substring(9));
            } else if ("drawable".equals(scheme)) {
                Bitmap bitmap = ((BitmapDrawable) this.f3444a.getResources().getDrawable(Integer.parseInt(uri.toString().substring(11)))).getBitmap();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            } else {
                throw new UnsupportedOperationException(String.format("UIL doesn't support scheme [%s] by default. You should implement this support byself", new Object[]{uri.getScheme()}));
            }
        }
    }
}
