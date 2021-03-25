package a.d.c.q.a.t;

import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;

public final class a implements Camera.AutoFocusCallback {

    /* renamed from: c  reason: collision with root package name */
    public static final String f2949c = a.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public Handler f2950a;

    /* renamed from: b  reason: collision with root package name */
    public int f2951b;

    public void onAutoFocus(boolean z, Camera camera) {
        Handler handler = this.f2950a;
        if (handler != null) {
            this.f2950a.sendMessageDelayed(handler.obtainMessage(this.f2951b, Boolean.valueOf(z)), 1500);
            this.f2950a = null;
            return;
        }
        Log.d(f2949c, "Got auto-focus callback, but no handler for it");
    }
}
