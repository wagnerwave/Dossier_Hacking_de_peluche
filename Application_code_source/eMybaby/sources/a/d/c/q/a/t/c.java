package a.d.c.q.a.t;

import a.a.a.a.a;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import java.io.IOException;
import java.util.Iterator;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2955a;

    /* renamed from: b  reason: collision with root package name */
    public final b f2956b;

    /* renamed from: c  reason: collision with root package name */
    public Camera f2957c;

    /* renamed from: d  reason: collision with root package name */
    public Rect f2958d;

    /* renamed from: e  reason: collision with root package name */
    public Rect f2959e;
    public boolean f;
    public boolean g;
    public boolean h;
    public int i;
    public int j;
    public final d k = new d(this.f2956b);
    public final a l = new a();

    public c(Context context) {
        this.f2955a = context;
        this.f2956b = new b(context);
    }

    public Rect a() {
        if (this.f2958d == null) {
            if (this.f2957c == null) {
                return null;
            }
            Point point = this.f2956b.f2953b;
            int i2 = (point.x * 3) / 4;
            int i3 = 240;
            if (i2 < 240) {
                i2 = 240;
            } else if (i2 > 600) {
                i2 = 600;
            }
            int i4 = (point.y * 3) / 4;
            if (i4 >= 240) {
                i3 = i4 > 400 ? 400 : i4;
            }
            int i5 = (point.x - i2) / 2;
            int i6 = (point.y - i3) / 2;
            this.f2958d = new Rect(i5, i6, i2 + i5, i3 + i6);
            StringBuilder n = a.n("Calculated framing rect: ");
            n.append(this.f2958d);
            Log.d("c", n.toString());
        }
        return this.f2958d;
    }

    public Rect b() {
        if (this.f2959e == null) {
            Rect a2 = a();
            if (a2 == null) {
                return null;
            }
            Rect rect = new Rect(a2);
            b bVar = this.f2956b;
            Point point = bVar.f2954c;
            Point point2 = bVar.f2953b;
            int i2 = rect.left;
            int i3 = point.x;
            int i4 = point2.x;
            rect.left = (i2 * i3) / i4;
            rect.right = (rect.right * i3) / i4;
            int i5 = rect.top;
            int i6 = point.y;
            int i7 = point2.y;
            rect.top = (i5 * i6) / i7;
            rect.bottom = (rect.bottom * i6) / i7;
            this.f2959e = rect;
        }
        return this.f2959e;
    }

    public void c(SurfaceHolder surfaceHolder) {
        String str;
        int i2;
        int i3;
        Camera camera = this.f2957c;
        if (camera == null) {
            if (Camera.getNumberOfCameras() > 1) {
                i3 = 0;
                for (int i4 = 0; i4 < Camera.getNumberOfCameras(); i4++) {
                    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                    Camera.getCameraInfo(i4, cameraInfo);
                    if (cameraInfo.facing == 0) {
                        i3 = i4;
                    }
                }
            } else {
                i3 = 0;
            }
            camera = Camera.open(i3);
            if (camera != null) {
                this.f2957c = camera;
            } else {
                throw new IOException();
            }
        }
        camera.setPreviewDisplay(surfaceHolder);
        if (!this.f) {
            this.f = true;
            b bVar = this.f2956b;
            if (bVar != null) {
                Camera.Parameters parameters = camera.getParameters();
                Display defaultDisplay = ((WindowManager) bVar.f2952a.getSystemService("window")).getDefaultDisplay();
                int width = defaultDisplay.getWidth();
                int height = defaultDisplay.getHeight();
                if (width < height) {
                    Log.i("CameraConfiguration", "Display reports portrait orientation; assuming this is incorrect");
                    int i5 = width;
                    width = height;
                    height = i5;
                }
                bVar.f2953b = new Point(width, height);
                StringBuilder n = a.n("Screen resolution: ");
                n.append(bVar.f2953b);
                Log.i("CameraConfiguration", n.toString());
                Point point = bVar.f2953b;
                Iterator<Camera.Size> it = parameters.getSupportedPreviewSizes().iterator();
                int i6 = Integer.MAX_VALUE;
                Point point2 = null;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Camera.Size next = it.next();
                    int i7 = next.height;
                    int i8 = next.width;
                    int i9 = i7 * i8;
                    if (i9 >= 76800 && i9 <= 384000) {
                        int abs = Math.abs((point.x * i7) - (point.y * i8));
                        if (abs == 0) {
                            point2 = new Point(i8, i7);
                            break;
                        } else if (abs < i6) {
                            point2 = new Point(i8, i7);
                            i6 = abs;
                        }
                    }
                }
                if (point2 == null) {
                    Camera.Size previewSize = parameters.getPreviewSize();
                    point2 = new Point(previewSize.width, previewSize.height);
                }
                bVar.f2954c = point2;
                StringBuilder n2 = a.n("Camera resolution: ");
                n2.append(bVar.f2954c);
                Log.i("CameraConfiguration", n2.toString());
                int i10 = this.i;
                if (i10 > 0 && (i2 = this.j) > 0) {
                    e(i10, i2);
                    this.i = 0;
                    this.j = 0;
                }
            } else {
                throw null;
            }
        }
        b bVar2 = this.f2956b;
        if (bVar2 != null) {
            Camera.Parameters parameters2 = camera.getParameters();
            if (parameters2 == null) {
                Log.w("CameraConfiguration", "Device error: no camera parameters are available. Proceeding without configuration.");
            } else {
                if (PreferenceManager.getDefaultSharedPreferences(bVar2.f2952a).getBoolean("preferences_front_light", false)) {
                    str = b.a(parameters2.getSupportedFlashModes(), "torch", "on");
                } else {
                    str = b.a(parameters2.getSupportedFlashModes(), "off");
                }
                if (str != null) {
                    parameters2.setFlashMode(str);
                }
                String a2 = b.a(parameters2.getSupportedFocusModes(), "auto", "macro");
                if (a2 != null) {
                    parameters2.setFocusMode(a2);
                }
                Point point3 = bVar2.f2954c;
                parameters2.setPreviewSize(point3.x, point3.y);
                camera.setParameters(parameters2);
            }
            this.h = PreferenceManager.getDefaultSharedPreferences(this.f2955a).getBoolean("preferences_reverse_image", false);
            return;
        }
        throw null;
    }

    public void d(Handler handler, int i2) {
        Camera camera = this.f2957c;
        if (camera != null && this.g) {
            a aVar = this.l;
            aVar.f2950a = handler;
            aVar.f2951b = i2;
            try {
                camera.autoFocus(aVar);
            } catch (RuntimeException e2) {
                Log.w("c", "Unexpected exception while focusing", e2);
            }
        }
    }

    public void e(int i2, int i3) {
        if (this.f) {
            Point point = this.f2956b.f2953b;
            int i4 = point.x;
            if (i2 > i4) {
                i2 = i4;
            }
            int i5 = point.y;
            if (i3 > i5) {
                i3 = i5;
            }
            int i6 = (point.x - i2) / 2;
            int i7 = (point.y - i3) / 2;
            this.f2958d = new Rect(i6, i7, i2 + i6, i3 + i7);
            StringBuilder n = a.n("Calculated manual framing rect: ");
            n.append(this.f2958d);
            Log.d("c", n.toString());
            this.f2959e = null;
            return;
        }
        this.i = i2;
        this.j = i3;
    }
}
