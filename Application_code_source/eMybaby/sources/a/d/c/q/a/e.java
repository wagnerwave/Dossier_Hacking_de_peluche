package a.d.c.q.a;

import a.a.a.a.a;
import a.d.c.h;
import a.d.c.k;
import a.d.c.l;
import a.d.c.q.a.t.c;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.core.view.ViewCompat;
import com.google.zxing.client.android.CaptureActivity;
import com.tutk.IOTC.AVFrame;
import java.util.Map;

public final class e extends Handler {

    /* renamed from: d  reason: collision with root package name */
    public static final String f2923d = e.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public final CaptureActivity f2924a;

    /* renamed from: b  reason: collision with root package name */
    public final h f2925b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2926c = true;

    public e(CaptureActivity captureActivity, Map<a.d.c.e, Object> map) {
        h hVar = new h();
        this.f2925b = hVar;
        hVar.c(map);
        this.f2924a = captureActivity;
    }

    public void handleMessage(Message message) {
        Message message2;
        if (this.f2926c) {
            int i = message.what;
            if (i == n.decode) {
                byte[] bArr = (byte[]) message.obj;
                int i2 = message.arg1;
                int i3 = message.arg2;
                long currentTimeMillis = System.currentTimeMillis();
                c cVar = this.f2924a.f4306a;
                Rect b2 = cVar.b();
                l lVar = null;
                j jVar = b2 == null ? null : new j(bArr, i2, i3, b2.left, b2.top, b2.width(), b2.height(), cVar.h);
                if (jVar != null) {
                    a.d.c.c cVar2 = new a.d.c.c(new a.d.c.r.h(jVar));
                    try {
                        h hVar = this.f2925b;
                        if (hVar.f2873b == null) {
                            hVar.c((Map<a.d.c.e, ?>) null);
                        }
                        lVar = hVar.b(cVar2);
                    } catch (k unused) {
                    } catch (Throwable th) {
                        this.f2925b.reset();
                        throw th;
                    }
                    this.f2925b.reset();
                }
                c cVar3 = this.f2924a.f4307b;
                if (lVar != null) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    String str = f2923d;
                    StringBuilder n = a.n("Found barcode in ");
                    n.append(currentTimeMillis2 - currentTimeMillis);
                    n.append(" ms");
                    Log.d(str, n.toString());
                    if (cVar3 != null) {
                        message2 = Message.obtain(cVar3, n.decode_succeeded, lVar);
                        Bundle bundle = new Bundle();
                        int i4 = jVar.f2870a;
                        int i5 = jVar.f2871b;
                        int[] iArr = new int[(i4 * i5)];
                        byte[] bArr2 = jVar.f2942c;
                        int i6 = (jVar.g * jVar.f2943d) + jVar.f;
                        for (int i7 = 0; i7 < i5; i7++) {
                            int i8 = i7 * i4;
                            for (int i9 = 0; i9 < i4; i9++) {
                                iArr[i8 + i9] = ((bArr2[i6 + i9] & AVFrame.FRM_STATE_UNKOWN) * 65793) | ViewCompat.MEASURED_STATE_MASK;
                            }
                            i6 += jVar.f2943d;
                        }
                        Bitmap createBitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
                        createBitmap.setPixels(iArr, 0, i4, 0, 0, i4, i5);
                        bundle.putParcelable("barcode_bitmap", createBitmap);
                        message2.setData(bundle);
                    } else {
                        return;
                    }
                } else if (cVar3 != null) {
                    message2 = Message.obtain(cVar3, n.decode_failed);
                } else {
                    return;
                }
                message2.sendToTarget();
            } else if (i == n.quit) {
                this.f2926c = false;
                Looper.myLooper().quit();
            }
        }
    }
}
