package a.c.c;

import java.io.File;

public class b {

    /* renamed from: c  reason: collision with root package name */
    public static b f44c;

    /* renamed from: d  reason: collision with root package name */
    public static a f45d = a.CONTEXT_CACHE_DIR;

    /* renamed from: a  reason: collision with root package name */
    public File f46a;

    /* renamed from: b  reason: collision with root package name */
    public c f47b;

    public enum a {
        CONTEXT_CACHE_DIR,
        SDCARD_DATA_DIR,
        SDCARD_ANDROID_DATA_DIR,
        SDCARD_ANDROID_DATA_FILE_DIR,
        DEVICE_DOWNLOAD_DIR,
        CUSTOM_DIR
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public b() {
        /*
            r4 = this;
            r4.<init>()
            a.c.c.b$a r0 = f45d
            a.c.c.b$a r1 = a.c.c.b.a.CONTEXT_CACHE_DIR
            java.lang.String r2 = "mdf_files"
            if (r0 != r1) goto L_0x001b
            a.c.a.a r0 = a.c.a.a.f
            android.content.Context r0 = r0.getApplicationContext()
            java.io.File r1 = new java.io.File
            java.io.File r0 = r0.getCacheDir()
            r1.<init>(r0, r2)
            goto L_0x0070
        L_0x001b:
            a.c.c.b$a r0 = f45d
            a.c.c.b$a r1 = a.c.c.b.a.SDCARD_ANDROID_DATA_FILE_DIR
            if (r0 != r1) goto L_0x002e
            a.c.a.a r0 = a.c.a.a.f
            r1 = 0
            java.io.File r0 = r0.getExternalFilesDir(r1)
            java.io.File r1 = new java.io.File
            r1.<init>(r0, r2)
            goto L_0x0070
        L_0x002e:
            a.c.c.b$a r0 = f45d
            a.c.c.b$a r1 = a.c.c.b.a.SDCARD_ANDROID_DATA_DIR
            if (r0 != r1) goto L_0x0050
            java.io.File r0 = new java.io.File
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r3 = "Android/data"
            r0.<init>(r1, r3)
            java.io.File r1 = new java.io.File
            a.c.a.a r3 = a.c.a.a.f
            java.lang.String r3 = r3.getPackageName()
            r1.<init>(r0, r3)
            java.io.File r0 = new java.io.File
            r0.<init>(r1, r2)
            goto L_0x008e
        L_0x0050:
            a.c.c.b$a r0 = f45d
            a.c.c.b$a r1 = a.c.c.b.a.DEVICE_DOWNLOAD_DIR
            if (r0 != r1) goto L_0x005d
            java.lang.String r0 = android.os.Environment.DIRECTORY_DOWNLOADS
            java.io.File r0 = android.os.Environment.getExternalStoragePublicDirectory(r0)
            goto L_0x008e
        L_0x005d:
            a.c.c.b$a r0 = f45d
            a.c.c.b$a r1 = a.c.c.b.a.CUSTOM_DIR
            if (r0 != r1) goto L_0x0073
            java.lang.String r0 = ""
            boolean r1 = a.c.a.d.a.j(r0)
            if (r1 != 0) goto L_0x0073
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
        L_0x0070:
            r4.f46a = r1
            goto L_0x0090
        L_0x0073:
            java.io.File r0 = new java.io.File
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r3 = "data"
            r0.<init>(r1, r3)
            java.io.File r1 = new java.io.File
            a.c.a.a r3 = a.c.a.a.f
            java.lang.String r3 = r3.getPackageName()
            r1.<init>(r0, r3)
            java.io.File r0 = new java.io.File
            r0.<init>(r1, r2)
        L_0x008e:
            r4.f46a = r0
        L_0x0090:
            java.io.File r0 = r4.f46a
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x00a9
            java.io.File r0 = r4.f46a
            boolean r0 = r0.mkdirs()
            if (r0 == 0) goto L_0x00a1
            goto L_0x00a9
        L_0x00a1:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "Error al crear la caché"
            r0.<init>(r1)
            throw r0
        L_0x00a9:
            java.io.File r0 = new java.io.File
            java.io.File r1 = r4.f46a
            java.lang.String r2 = ".nomedia"
            r0.<init>(r1, r2)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x00c0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00c0 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x00c0 }
            r1.close()     // Catch:{ Exception -> 0x00c0 }
        L_0x00c0:
            a.c.c.c r0 = new a.c.c.c
            r0.<init>()
            r4.f47b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.c.c.b.<init>():void");
    }

    public static b c() {
        if (f44c == null) {
            f44c = new b();
        }
        return f44c;
    }

    public File a() {
        return this.f46a;
    }

    public File b(String str) {
        return new File(this.f46a, this.f47b.b(str));
    }

    public void d(c cVar) {
        this.f47b = cVar;
    }
}
