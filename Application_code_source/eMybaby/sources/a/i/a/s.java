package a.i.a;

import a.i.a.j;
import android.net.Uri;
import androidx.appcompat.widget.TooltipCompatHandler;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.tuya.smart.common.oooo000oo;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class s implements j {

    /* renamed from: a  reason: collision with root package name */
    public final OkHttpClient f3652a;

    public s(File file, long j) {
        OkHttpClient b2 = b();
        this.f3652a = b2;
        try {
            b2.setCache(new Cache(file, j));
        } catch (IOException unused) {
        }
    }

    public static OkHttpClient b() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(TooltipCompatHandler.HOVER_HIDE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
        okHttpClient.setReadTimeout(oooo000oo.O0000ooo, TimeUnit.MILLISECONDS);
        okHttpClient.setWriteTimeout(oooo000oo.O0000ooo, TimeUnit.MILLISECONDS);
        return okHttpClient;
    }

    public j.a a(Uri uri, int i) {
        CacheControl cacheControl;
        boolean z = false;
        if (i == 0) {
            cacheControl = null;
        } else if (q.f(i)) {
            cacheControl = CacheControl.FORCE_CACHE;
        } else {
            CacheControl.Builder builder = new CacheControl.Builder();
            if (!((q.NO_CACHE.f3649a & i) == 0)) {
                builder.noCache();
            }
            if (!((q.NO_STORE.f3649a & i) == 0)) {
                builder.noStore();
            }
            cacheControl = builder.build();
        }
        Request.Builder url = new Request.Builder().url(uri.toString());
        if (cacheControl != null) {
            url.cacheControl(cacheControl);
        }
        Response execute = this.f3652a.newCall(url.build()).execute();
        int code = execute.code();
        if (code < 300) {
            if (execute.cacheResponse() != null) {
                z = true;
            }
            ResponseBody body = execute.body();
            return new j.a(body.byteStream(), z, body.contentLength());
        }
        execute.body().close();
        throw new j.b(code + " " + execute.message(), i, code);
    }
}
