package a.i.a;

import android.content.Context;
import android.net.Uri;
import com.tuya.smart.common.o00000oo0;

public class o extends g {

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f3635b = {"orientation"};

    public enum a {
        MICRO(3, 96, 96),
        MINI(1, 512, 384),
        FULL(2, -1, -1);
        

        /* renamed from: a  reason: collision with root package name */
        public final int f3638a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3639b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3640c;

        /* access modifiers changed from: public */
        a(int i, int i2, int i3) {
            this.f3638a = i;
            this.f3639b = i2;
            this.f3640c = i3;
        }
    }

    public o(Context context) {
        super(context);
    }

    public boolean c(w wVar) {
        Uri uri = wVar.f3680d;
        return o00000oo0.O00000o0.equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        if (r3 != null) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003e, code lost:
        if (r3 != null) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0043, code lost:
        r10 = 0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a.i.a.y.a f(a.i.a.w r18, int r19) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            a.i.a.o$a r8 = a.i.a.o.a.FULL
            a.i.a.t$d r9 = a.i.a.t.d.DISK
            android.content.Context r2 = r1.f3606a
            android.content.ContentResolver r7 = r2.getContentResolver()
            android.net.Uri r11 = r0.f3680d
            r2 = 0
            r6 = 0
            java.lang.String[] r12 = f3635b     // Catch:{ RuntimeException -> 0x003d, all -> 0x0036 }
            r13 = 0
            r14 = 0
            r15 = 0
            r10 = r7
            android.database.Cursor r3 = r10.query(r11, r12, r13, r14, r15)     // Catch:{ RuntimeException -> 0x003d, all -> 0x0036 }
            if (r3 == 0) goto L_0x0033
            boolean r4 = r3.moveToFirst()     // Catch:{ RuntimeException -> 0x0031, all -> 0x002e }
            if (r4 != 0) goto L_0x0025
            goto L_0x0033
        L_0x0025:
            int r4 = r3.getInt(r2)     // Catch:{ RuntimeException -> 0x0031, all -> 0x002e }
            r3.close()
            r10 = r4
            goto L_0x0044
        L_0x002e:
            r0 = move-exception
            r6 = r3
            goto L_0x0037
        L_0x0031:
            goto L_0x003e
        L_0x0033:
            if (r3 == 0) goto L_0x0043
            goto L_0x0040
        L_0x0036:
            r0 = move-exception
        L_0x0037:
            if (r6 == 0) goto L_0x003c
            r6.close()
        L_0x003c:
            throw r0
        L_0x003d:
            r3 = r6
        L_0x003e:
            if (r3 == 0) goto L_0x0043
        L_0x0040:
            r3.close()
        L_0x0043:
            r10 = 0
        L_0x0044:
            android.net.Uri r3 = r0.f3680d
            java.lang.String r3 = r7.getType(r3)
            r11 = 1
            if (r3 == 0) goto L_0x0057
            java.lang.String r4 = "video/"
            boolean r3 = r3.startsWith(r4)
            if (r3 == 0) goto L_0x0057
            r12 = 1
            goto L_0x0058
        L_0x0057:
            r12 = 0
        L_0x0058:
            boolean r2 = r18.a()
            if (r2 == 0) goto L_0x00d2
            int r2 = r0.h
            int r3 = r0.i
            a.i.a.o$a r4 = a.i.a.o.a.MICRO
            int r5 = r4.f3639b
            if (r2 > r5) goto L_0x006e
            int r5 = r4.f3640c
            if (r3 > r5) goto L_0x006e
        L_0x006c:
            r13 = r4
            goto L_0x007a
        L_0x006e:
            a.i.a.o$a r4 = a.i.a.o.a.MINI
            int r5 = r4.f3639b
            if (r2 > r5) goto L_0x0079
            int r2 = r4.f3640c
            if (r3 > r2) goto L_0x0079
            goto L_0x006c
        L_0x0079:
            r13 = r8
        L_0x007a:
            if (r12 != 0) goto L_0x0090
            if (r13 != r8) goto L_0x0090
            a.i.a.y$a r2 = new a.i.a.y$a
            android.content.Context r3 = r1.f3606a
            android.content.ContentResolver r3 = r3.getContentResolver()
            android.net.Uri r0 = r0.f3680d
            java.io.InputStream r0 = r3.openInputStream(r0)
            r2.<init>(r6, r0, r9, r10)
            return r2
        L_0x0090:
            android.net.Uri r2 = r0.f3680d
            long r14 = android.content.ContentUris.parseId(r2)
            android.graphics.BitmapFactory$Options r5 = a.i.a.y.d(r18)
            r5.inJustDecodeBounds = r11
            int r2 = r0.h
            int r3 = r0.i
            int r4 = r13.f3639b
            int r6 = r13.f3640c
            r16 = r5
            r5 = r6
            r11 = 0
            r6 = r16
            r11 = r7
            r7 = r18
            a.i.a.y.a(r2, r3, r4, r5, r6, r7)
            if (r12 == 0) goto L_0x00c1
            if (r13 != r8) goto L_0x00b8
            r3 = r16
            r2 = 1
            goto L_0x00bc
        L_0x00b8:
            int r2 = r13.f3638a
            r3 = r16
        L_0x00bc:
            android.graphics.Bitmap r2 = android.provider.MediaStore.Video.Thumbnails.getThumbnail(r11, r14, r2, r3)
            goto L_0x00c9
        L_0x00c1:
            r3 = r16
            int r2 = r13.f3638a
            android.graphics.Bitmap r2 = android.provider.MediaStore.Images.Thumbnails.getThumbnail(r11, r14, r2, r3)
        L_0x00c9:
            if (r2 == 0) goto L_0x00d2
            a.i.a.y$a r0 = new a.i.a.y$a
            r3 = 0
            r0.<init>(r2, r3, r9, r10)
            return r0
        L_0x00d2:
            a.i.a.y$a r2 = new a.i.a.y$a
            android.content.Context r3 = r1.f3606a
            android.content.ContentResolver r3 = r3.getContentResolver()
            android.net.Uri r0 = r0.f3680d
            java.io.InputStream r0 = r3.openInputStream(r0)
            r3 = 0
            r2.<init>(r3, r0, r9, r10)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.i.a.o.f(a.i.a.w, int):a.i.a.y$a");
    }
}
