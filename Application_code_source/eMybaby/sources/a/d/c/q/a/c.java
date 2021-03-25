package a.d.c.q.a;

import a.d.c.l;
import a.d.c.m;
import a.d.c.q.a.t.d;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.client.android.ViewfinderView;
import java.util.Collection;
import java.util.Map;

public final class c extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final CaptureActivity f2910a;

    /* renamed from: b  reason: collision with root package name */
    public final f f2911b;

    /* renamed from: c  reason: collision with root package name */
    public a f2912c = a.SUCCESS;

    /* renamed from: d  reason: collision with root package name */
    public final a.d.c.q.a.t.c f2913d;

    public enum a {
        PREVIEW,
        SUCCESS,
        DONE
    }

    static {
        Class<c> cls = c.class;
    }

    public c(CaptureActivity captureActivity, Collection<a.d.c.a> collection, String str, a.d.c.q.a.t.c cVar) {
        this.f2910a = captureActivity;
        f fVar = new f(captureActivity, collection, str, new s(captureActivity.f4309d));
        this.f2911b = fVar;
        fVar.start();
        this.f2913d = cVar;
        Camera camera = cVar.f2957c;
        if (camera != null && !cVar.g) {
            camera.startPreview();
            cVar.g = true;
        }
        a();
    }

    public final void a() {
        if (this.f2912c == a.SUCCESS) {
            this.f2912c = a.PREVIEW;
            a.d.c.q.a.t.c cVar = this.f2913d;
            Handler a2 = this.f2911b.a();
            int i = n.decode;
            Camera camera = cVar.f2957c;
            if (camera != null && cVar.g) {
                d dVar = cVar.k;
                dVar.f2962b = a2;
                dVar.f2963c = i;
                camera.setOneShotPreviewCallback(dVar);
            }
            this.f2913d.d(this, n.auto_focus);
            ViewfinderView viewfinderView = this.f2910a.f4309d;
            Bitmap bitmap = viewfinderView.f4314c;
            viewfinderView.f4314c = null;
            if (bitmap != null) {
                bitmap.recycle();
            }
            viewfinderView.invalidate();
        }
    }

    public void handleMessage(Message message) {
        a aVar = a.PREVIEW;
        int i = message.what;
        int i2 = n.auto_focus;
        if (i == i2) {
            if (this.f2912c == aVar) {
                this.f2913d.d(this, i2);
            }
        } else if (i == n.restart_preview) {
            a();
        } else if (i == n.decode_succeeded) {
            this.f2912c = a.SUCCESS;
            Bundle data = message.getData();
            Bitmap bitmap = data == null ? null : (Bitmap) data.getParcelable("barcode_bitmap");
            CaptureActivity captureActivity = this.f2910a;
            l lVar = (l) message.obj;
            captureActivity.m.b();
            captureActivity.g = lVar;
            ViewfinderView viewfinderView = captureActivity.f4309d;
            viewfinderView.f4314c = bitmap;
            viewfinderView.invalidate();
            if (captureActivity.i == i.NATIVE_APP_INTENT) {
                Intent intent = new Intent(captureActivity.getIntent().getAction());
                intent.addFlags(524288);
                intent.putExtra("SCAN_RESULT", lVar.f2875a);
                intent.putExtra("SCAN_RESULT_FORMAT", lVar.f2878d.toString());
                byte[] bArr = lVar.f2876b;
                if (bArr != null && bArr.length > 0) {
                    intent.putExtra("SCAN_RESULT_BYTES", bArr);
                }
                Map<m, Object> map = lVar.f2879e;
                if (map != null) {
                    Integer num = (Integer) map.get(m.ORIENTATION);
                    if (num != null) {
                        intent.putExtra("SCAN_RESULT_ORIENTATION", num.intValue());
                    }
                    String str = (String) map.get(m.ERROR_CORRECTION_LEVEL);
                    if (str != null) {
                        intent.putExtra("SCAN_RESULT_ERROR_CORRECTION_LEVEL", str);
                    }
                    Iterable<byte[]> iterable = (Iterable) map.get(m.BYTE_SEGMENTS);
                    if (iterable != null) {
                        int i3 = 0;
                        for (byte[] putExtra : iterable) {
                            intent.putExtra("SCAN_RESULT_BYTE_SEGMENTS_" + i3, putExtra);
                            i3++;
                        }
                    }
                }
                Message obtain = Message.obtain(captureActivity.f4307b, n.return_scan_result, intent);
                long longExtra = captureActivity.getIntent().getLongExtra("RESULT_DISPLAY_DURATION_MS", 1500);
                if (longExtra > 0) {
                    captureActivity.f4307b.sendMessageDelayed(obtain, longExtra);
                } else {
                    captureActivity.f4307b.sendMessage(obtain);
                }
            }
        } else if (i == n.decode_failed) {
            this.f2912c = aVar;
            a.d.c.q.a.t.c cVar = this.f2913d;
            Handler a2 = this.f2911b.a();
            int i4 = n.decode;
            Camera camera = cVar.f2957c;
            if (camera != null && cVar.g) {
                d dVar = cVar.k;
                dVar.f2962b = a2;
                dVar.f2963c = i4;
                camera.setOneShotPreviewCallback(dVar);
            }
        } else if (i == n.return_scan_result) {
            this.f2910a.setResult(-1, (Intent) message.obj);
            this.f2910a.finish();
        } else if (i == n.launch_product_query) {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse((String) message.obj));
            intent2.addFlags(524288);
            this.f2910a.startActivity(intent2);
        }
    }
}
