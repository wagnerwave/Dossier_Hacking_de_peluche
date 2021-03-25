package a.d.b.k;

import android.util.Log;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final FileChannel f2786a;

    /* renamed from: b  reason: collision with root package name */
    public final FileLock f2787b;

    public a(FileChannel fileChannel, FileLock fileLock) {
        this.f2786a = fileChannel;
        this.f2787b = fileLock;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038 A[SYNTHETIC, Splitter:B:15:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003f A[SYNTHETIC, Splitter:B:19:0x003f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static a.d.b.k.a a(android.content.Context r4, java.lang.String r5) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x002b, Error -> 0x0029 }
            java.io.File r4 = r4.getFilesDir()     // Catch:{ IOException -> 0x002b, Error -> 0x0029 }
            r1.<init>(r4, r5)     // Catch:{ IOException -> 0x002b, Error -> 0x0029 }
            java.io.RandomAccessFile r4 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x002b, Error -> 0x0029 }
            java.lang.String r5 = "rw"
            r4.<init>(r1, r5)     // Catch:{ IOException -> 0x002b, Error -> 0x0029 }
            java.nio.channels.FileChannel r4 = r4.getChannel()     // Catch:{ IOException -> 0x002b, Error -> 0x0029 }
            java.nio.channels.FileLock r5 = r4.lock()     // Catch:{ IOException -> 0x0025, Error -> 0x0023 }
            a.d.b.k.a r1 = new a.d.b.k.a     // Catch:{ IOException -> 0x0021, Error -> 0x001f }
            r1.<init>(r4, r5)     // Catch:{ IOException -> 0x0021, Error -> 0x001f }
            return r1
        L_0x001f:
            r1 = move-exception
            goto L_0x002f
        L_0x0021:
            r1 = move-exception
            goto L_0x002f
        L_0x0023:
            r5 = move-exception
            goto L_0x0026
        L_0x0025:
            r5 = move-exception
        L_0x0026:
            r1 = r5
            r5 = r0
            goto L_0x002f
        L_0x0029:
            r4 = move-exception
            goto L_0x002c
        L_0x002b:
            r4 = move-exception
        L_0x002c:
            r1 = r4
            r4 = r0
            r5 = r4
        L_0x002f:
            java.lang.String r2 = "CrossProcessLock"
            java.lang.String r3 = "encountered error while creating and acquiring the lock, ignoring"
            android.util.Log.e(r2, r3, r1)
            if (r5 == 0) goto L_0x003d
            r5.release()     // Catch:{ IOException -> 0x003c }
            goto L_0x003d
        L_0x003c:
        L_0x003d:
            if (r4 == 0) goto L_0x0042
            r4.close()     // Catch:{ IOException -> 0x0042 }
        L_0x0042:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.b.k.a.a(android.content.Context, java.lang.String):a.d.b.k.a");
    }

    public void b() {
        try {
            this.f2787b.release();
            this.f2786a.close();
        } catch (IOException e2) {
            Log.e("CrossProcessLock", "encountered error while releasing, ignoring", e2);
        }
    }
}
