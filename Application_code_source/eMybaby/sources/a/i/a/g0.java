package a.i.a;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.StatFs;
import android.util.Log;
import androidx.appcompat.widget.ActivityChooserModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public final class g0 {

    /* renamed from: a  reason: collision with root package name */
    public static final StringBuilder f3607a = new StringBuilder();

    public static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            sendMessageDelayed(obtainMessage(), 1000);
        }
    }

    public static class b extends Thread {
        public b(Runnable runnable) {
            super(runnable);
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    public static class c implements ThreadFactory {
        public Thread newThread(Runnable runnable) {
            return new b(runnable);
        }
    }

    public static long a(File file) {
        long j;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            j = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 50;
        } catch (IllegalArgumentException unused) {
            j = 5242880;
        }
        return Math.max(Math.min(j, 52428800), 5242880);
    }

    public static int b(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        boolean z = (context.getApplicationInfo().flags & 1048576) != 0;
        int memoryClass = activityManager.getMemoryClass();
        if (z) {
            memoryClass = activityManager.getLargeMemoryClass();
        }
        return (memoryClass * 1048576) / 7;
    }

    public static void c() {
        if (!(Looper.getMainLooper().getThread() == Thread.currentThread())) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    public static <T> T d(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static void e(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static File f(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static j g(Context context) {
        try {
            Class.forName("com.squareup.okhttp.OkHttpClient");
            File f = f(context);
            return new s(f, a(f));
        } catch (ClassNotFoundException unused) {
            return new f0(context);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String h(a.i.a.w r6) {
        /*
            java.lang.StringBuilder r0 = f3607a
            java.lang.String r1 = r6.f
            r2 = 50
            if (r1 == 0) goto L_0x0013
            int r1 = r1.length()
            int r1 = r1 + r2
            r0.ensureCapacity(r1)
            java.lang.String r1 = r6.f
            goto L_0x0023
        L_0x0013:
            android.net.Uri r1 = r6.f3680d
            if (r1 == 0) goto L_0x0027
            java.lang.String r1 = r1.toString()
            int r3 = r1.length()
            int r3 = r3 + r2
            r0.ensureCapacity(r3)
        L_0x0023:
            r0.append(r1)
            goto L_0x002f
        L_0x0027:
            r0.ensureCapacity(r2)
            int r1 = r6.f3681e
            r0.append(r1)
        L_0x002f:
            r1 = 10
            r0.append(r1)
            float r2 = r6.m
            r3 = 0
            r4 = 120(0x78, float:1.68E-43)
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0060
            java.lang.String r2 = "rotation:"
            r0.append(r2)
            float r2 = r6.m
            r0.append(r2)
            boolean r2 = r6.p
            if (r2 == 0) goto L_0x005d
            r2 = 64
            r0.append(r2)
            float r2 = r6.n
            r0.append(r2)
            r0.append(r4)
            float r2 = r6.o
            r0.append(r2)
        L_0x005d:
            r0.append(r1)
        L_0x0060:
            boolean r2 = r6.a()
            if (r2 == 0) goto L_0x007b
            java.lang.String r2 = "resize:"
            r0.append(r2)
            int r2 = r6.h
            r0.append(r2)
            r0.append(r4)
            int r2 = r6.i
            r0.append(r2)
            r0.append(r1)
        L_0x007b:
            boolean r2 = r6.j
            if (r2 == 0) goto L_0x0082
            java.lang.String r2 = "centerCrop"
            goto L_0x0088
        L_0x0082:
            boolean r2 = r6.k
            if (r2 == 0) goto L_0x008e
            java.lang.String r2 = "centerInside"
        L_0x0088:
            r0.append(r2)
            r0.append(r1)
        L_0x008e:
            java.util.List<a.i.a.e0> r2 = r6.g
            r3 = 0
            if (r2 == 0) goto L_0x00af
            int r2 = r2.size()
            r4 = 0
        L_0x0098:
            if (r4 >= r2) goto L_0x00af
            java.util.List<a.i.a.e0> r5 = r6.g
            java.lang.Object r5 = r5.get(r4)
            a.i.a.e0 r5 = (a.i.a.e0) r5
            java.lang.String r5 = r5.b()
            r0.append(r5)
            r0.append(r1)
            int r4 = r4 + 1
            goto L_0x0098
        L_0x00af:
            java.lang.String r6 = r0.toString()
            java.lang.StringBuilder r0 = f3607a
            r0.setLength(r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: a.i.a.g0.h(a.i.a.w):java.lang.String");
    }

    public static void i(Looper looper) {
        a aVar = new a(looper);
        aVar.sendMessageDelayed(aVar.obtainMessage(), 1000);
    }

    public static int j(Bitmap bitmap) {
        int byteCount = bitmap.getByteCount();
        if (byteCount >= 0) {
            return byteCount;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    public static String k(c cVar) {
        return l(cVar, "");
    }

    public static String l(c cVar, String str) {
        StringBuilder sb = new StringBuilder(str);
        a aVar = cVar.k;
        if (aVar != null) {
            sb.append(aVar.f3572b.b());
        }
        List<a> list = cVar.l;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i > 0 || aVar != null) {
                    sb.append(", ");
                }
                sb.append(list.get(i).f3572b.b());
            }
        }
        return sb.toString();
    }

    public static Resources m(Context context, w wVar) {
        Uri uri;
        if (wVar.f3681e != 0 || (uri = wVar.f3680d) == null) {
            return context.getResources();
        }
        String authority = uri.getAuthority();
        if (authority != null) {
            try {
                return context.getPackageManager().getResourcesForApplication(authority);
            } catch (PackageManager.NameNotFoundException unused) {
                StringBuilder n = a.a.a.a.a.n("Unable to obtain resources for package: ");
                n.append(wVar.f3680d);
                throw new FileNotFoundException(n.toString());
            }
        } else {
            StringBuilder n2 = a.a.a.a.a.n("No package provided: ");
            n2.append(wVar.f3680d);
            throw new FileNotFoundException(n2.toString());
        }
    }

    public static <T> T n(Context context, String str) {
        return context.getSystemService(str);
    }

    public static boolean o(InputStream inputStream) {
        byte[] bArr = new byte[12];
        return inputStream.read(bArr, 0, 12) == 12 && "RIFF".equals(new String(bArr, 0, 4, "US-ASCII")) && "WEBP".equals(new String(bArr, 8, 4, "US-ASCII"));
    }

    public static void p(String str, String str2, String str3, String str4) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", new Object[]{str, str2, str3, str4}));
    }
}
