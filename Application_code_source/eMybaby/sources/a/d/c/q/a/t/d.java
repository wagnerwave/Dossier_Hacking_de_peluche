package a.d.c.q.a.t;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;

public final class d implements Camera.PreviewCallback {

    /* renamed from: d  reason: collision with root package name */
    public static final String f2960d = d.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public final b f2961a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f2962b;

    /* renamed from: c  reason: collision with root package name */
    public int f2963c;

    public d(b bVar) {
        this.f2961a = bVar;
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Point point = this.f2961a.f2954c;
        Handler handler = this.f2962b;
        if (handler != null) {
            handler.obtainMessage(this.f2963c, point.x, point.y, bArr).sendToTarget();
            this.f2962b = null;
            return;
        }
        Log.d(f2960d, "Got preview callback, but no handler for it");
    }
}
