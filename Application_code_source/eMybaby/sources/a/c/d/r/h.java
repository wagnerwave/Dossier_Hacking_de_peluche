package a.c.d.r;

import a.c.a.f.e;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.sozpic.miniland.R;
import com.tuya.smart.android.common.utils.StorageUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.ProviderException;
import java.util.Calendar;

public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public CharSequence[] f792a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f793b;

    /* renamed from: c  reason: collision with root package name */
    public Fragment f794c;

    /* renamed from: d  reason: collision with root package name */
    public String f795d;

    /* renamed from: e  reason: collision with root package name */
    public File f796e;
    public b f;
    public int g = 1024;
    public int h;

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == 0) {
                h.this.k();
            } else if (i == 1) {
                h.this.b();
            }
            dialogInterface.dismiss();
        }
    }

    public interface b {
        void c(String str);

        void i();
    }

    public h(@NonNull Activity activity, b bVar, Bundle bundle) {
        this.f793b = activity;
        this.f = bVar;
        m();
        p(bundle);
        d();
    }

    public h(@NonNull Fragment fragment, b bVar, Bundle bundle) {
        this.f794c = fragment;
        this.f = null;
        m();
        p(bundle);
        d();
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00be A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap q(java.lang.String r13, int r14) {
        /*
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
            r0.<init>()
            r1 = 2
            r0.inSampleSize = r1
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeFile(r13, r0)
            android.media.ExifInterface r0 = new android.media.ExifInterface
            r0.<init>(r13)
            java.lang.String r13 = "Orientation"
            r1 = 0
            int r13 = r0.getAttributeInt(r13, r1)
            r0 = 3
            r3 = 0
            if (r13 == r0) goto L_0x002b
            r0 = 6
            if (r13 == r0) goto L_0x0028
            r0 = 8
            if (r13 == r0) goto L_0x0025
            r13 = 0
            goto L_0x002d
        L_0x0025:
            r13 = 1132920832(0x43870000, float:270.0)
            goto L_0x002d
        L_0x0028:
            r13 = 1119092736(0x42b40000, float:90.0)
            goto L_0x002d
        L_0x002b:
            r13 = 1127481344(0x43340000, float:180.0)
        L_0x002d:
            int r0 = r2.getWidth()
            int r4 = r2.getHeight()
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r7 = -1
            if (r0 >= r4) goto L_0x0060
            int r0 = r2.getHeight()
            if (r0 <= r14) goto L_0x0083
            int r0 = r2.getWidth()
            double r8 = (double) r0
            java.lang.Double.isNaN(r8)
            double r8 = r8 * r5
            int r0 = r2.getHeight()
            double r10 = (double) r0
            java.lang.Double.isNaN(r10)
            double r8 = r8 / r10
            double r8 = r8 * r5
            double r4 = (double) r14
            java.lang.Double.isNaN(r4)
            double r8 = r8 * r4
            int r0 = (int) r8
            r12 = r0
            r0 = r14
            r14 = r12
            goto L_0x0085
        L_0x0060:
            int r0 = r2.getWidth()
            if (r0 <= r14) goto L_0x0083
            int r0 = r2.getHeight()
            double r8 = (double) r0
            java.lang.Double.isNaN(r8)
            double r8 = r8 * r5
            int r0 = r2.getWidth()
            double r10 = (double) r0
            java.lang.Double.isNaN(r10)
            double r8 = r8 / r10
            double r8 = r8 * r5
            double r4 = (double) r14
            java.lang.Double.isNaN(r4)
            double r8 = r8 * r4
            int r0 = (int) r8
            goto L_0x0085
        L_0x0083:
            r14 = -1
            r0 = -1
        L_0x0085:
            android.graphics.Matrix r8 = new android.graphics.Matrix
            r8.<init>()
            r4 = 1
            if (r14 == r7) goto L_0x00a1
            if (r0 == r7) goto L_0x00a1
            float r14 = (float) r14
            int r1 = r2.getWidth()
            float r1 = (float) r1
            float r14 = r14 / r1
            float r0 = (float) r0
            int r1 = r2.getHeight()
            float r1 = (float) r1
            float r0 = r0 / r1
            r8.postScale(r14, r0)
            r1 = 1
        L_0x00a1:
            int r14 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r14 == 0) goto L_0x00a9
            r8.postRotate(r13)
            goto L_0x00aa
        L_0x00a9:
            r4 = r1
        L_0x00aa:
            if (r4 == 0) goto L_0x00be
            r3 = 0
            r4 = 0
            int r5 = r2.getWidth()
            int r6 = r2.getHeight()
            r13 = 1
            r7 = r8
            r8 = r13
            android.graphics.Bitmap r13 = android.graphics.Bitmap.createBitmap(r2, r3, r4, r5, r6, r7, r8)
            return r13
        L_0x00be:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.c.d.r.h.q(java.lang.String, int):android.graphics.Bitmap");
    }

    public void a() {
        if (ContextCompat.checkSelfPermission(h(), StorageUtil.EXTERNAL_STORAGE_PERMISSION) != 0) {
            Activity activity = this.f793b;
            if (activity != null) {
                ActivityCompat.requestPermissions(activity, new String[]{StorageUtil.EXTERNAL_STORAGE_PERMISSION}, 200);
                return;
            }
            this.f794c.requestPermissions(new String[]{StorageUtil.EXTERNAL_STORAGE_PERMISSION}, 200);
            return;
        }
        r();
    }

    public final void b() {
        if (ContextCompat.checkSelfPermission(h(), "android.permission.CAMERA") != 0) {
            Activity activity = this.f793b;
            if (activity != null) {
                ActivityCompat.requestPermissions(activity, new String[]{"android.permission.CAMERA"}, 201);
                return;
            }
            this.f794c.requestPermissions(new String[]{"android.permission.CAMERA"}, 201);
            return;
        }
        s();
    }

    public final void d() {
        boolean z = false;
        if (h() != null) {
            PackageManager packageManager = h().getPackageManager();
            try {
                int i = packageManager.getApplicationInfo(h().getPackageName(), 0).targetSdkVersion;
                this.h = i;
                if (i < 24 || packageManager.resolveContentProvider(l(), 0) != null) {
                    z = true;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (!z) {
            throw new ProviderException("You have extend FileProvider and declare it on Manifest:\n<application>\n        ...\n        <provider\n            android:authorities=\"${applicationId}.com.cuatroochenta.commons.provider\"\n            android:exported=\"false\"\n            android:name=\"android.support.v4.content.FileProvider\"\n            android:grantUriPermissions=\"true\">\n            <meta-data\n                android:name=\"android.support.FILE_PROVIDER_PATHS\"\n                android:resource=\"@xml/external_files\"/>\n        </provider>\n");
        }
    }

    public void e(boolean z) {
        if (!a.c.a.d.a.j(this.f795d)) {
            try {
                Bitmap q = q(this.f795d, this.g);
                if (q != null) {
                    String absolutePath = z ? this.f795d : new File(j(), f("jpg")).getAbsolutePath();
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(absolutePath));
                    q.compress(Bitmap.CompressFormat.JPEG, 70, bufferedOutputStream);
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    e.b(String.format("Tamaño de la imagen salvada w: %s, h: %s", new Object[]{Integer.valueOf(q.getWidth()), Integer.valueOf(q.getHeight())}));
                    if (this.f != null) {
                        this.f.c(absolutePath);
                        return;
                    }
                    return;
                }
                throw new Exception("Bitmap resized is null");
            } catch (Exception e2) {
                e2.printStackTrace();
                b bVar = this.f;
                if (bVar != null) {
                    bVar.i();
                }
            }
        }
    }

    public String f(String str) {
        if (a.c.a.d.a.j(str)) {
            str = "jpg";
        }
        Calendar instance = Calendar.getInstance();
        return "image_" + instance.get(1) + (instance.get(2) + 1) + instance.get(5) + instance.get(10) + instance.get(12) + instance.get(13) + "." + str;
    }

    public abstract String g();

    @Nullable
    public final Context h() {
        Activity activity = this.f793b;
        if (activity != null) {
            return activity;
        }
        Fragment fragment = this.f794c;
        if (fragment != null) {
            return fragment.getContext();
        }
        return null;
    }

    public File j() {
        if (this.f796e == null) {
            this.f796e = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "/eMyBaby");
            StringBuilder n = a.a.a.a.a.n("Creando directorio para galeria:");
            n.append(this.f796e.getAbsolutePath());
            e.b(n.toString());
            if (!this.f796e.exists() && !this.f796e.mkdirs()) {
                throw new RuntimeException("Error al crear el directorio de galeria");
            }
        }
        return this.f796e;
    }

    public void k() {
        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        Activity activity = this.f793b;
        if (activity != null) {
            activity.startActivityForResult(Intent.createChooser(intent, g()), 2001);
            return;
        }
        Fragment fragment = this.f794c;
        if (fragment != null) {
            fragment.startActivityForResult(Intent.createChooser(intent, g()), 2001);
        }
    }

    public String l() {
        return h().getApplicationContext().getPackageName() + ".com.cuatroochenta.commons.provider";
    }

    public final void m() {
        CharSequence[] charSequenceArr = new CharSequence[2];
        this.f792a = charSequenceArr;
        charSequenceArr[0] = a.c.a.d.a.h(R.string.TR_IMAGEN_DE_GALERIA);
        this.f792a[1] = a.c.a.d.a.h(R.string.TR_TOMAR_FOTO);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r3v5, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r3v6, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0084 A[Catch:{ all -> 0x009e }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008b A[SYNTHETIC, Splitter:B:42:0x008b] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0095 A[SYNTHETIC, Splitter:B:47:0x0095] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a1 A[SYNTHETIC, Splitter:B:53:0x00a1] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ab A[SYNTHETIC, Splitter:B:58:0x00ab] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean n(int r7, int r8, android.content.Intent r9) {
        /*
            r6 = this;
            r0 = -1
            r1 = 1
            r2 = 0
            r3 = 2001(0x7d1, float:2.804E-42)
            if (r7 != r3) goto L_0x00fd
            if (r8 != r0) goto L_0x00fc
            if (r9 == 0) goto L_0x00fc
            android.net.Uri r7 = r9.getData()
            if (r7 == 0) goto L_0x00fc
            java.lang.String r8 = r7.getScheme()
            java.lang.String r9 = "content"
            boolean r8 = r9.equals(r8)
            r3 = 0
            if (r8 == 0) goto L_0x00b4
            android.content.Context r8 = r6.h()     // Catch:{ Exception -> 0x007b, all -> 0x0078 }
            android.content.ContentResolver r8 = r8.getContentResolver()     // Catch:{ Exception -> 0x007b, all -> 0x0078 }
            java.io.InputStream r9 = r8.openInputStream(r7)     // Catch:{ Exception -> 0x007b, all -> 0x0078 }
            java.lang.String r7 = r8.getType(r7)     // Catch:{ Exception -> 0x0074, all -> 0x0070 }
            android.webkit.MimeTypeMap r8 = android.webkit.MimeTypeMap.getSingleton()     // Catch:{ Exception -> 0x0074, all -> 0x0070 }
            java.lang.String r7 = r8.getExtensionFromMimeType(r7)     // Catch:{ Exception -> 0x0074, all -> 0x0070 }
            java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x0074, all -> 0x0070 }
            java.io.File r4 = r6.j()     // Catch:{ Exception -> 0x0074, all -> 0x0070 }
            java.lang.String r7 = r6.f(r7)     // Catch:{ Exception -> 0x0074, all -> 0x0070 }
            r8.<init>(r4, r7)     // Catch:{ Exception -> 0x0074, all -> 0x0070 }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0074, all -> 0x0070 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x0074, all -> 0x0070 }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x006e, all -> 0x006c }
        L_0x004c:
            int r4 = r9.read(r3)     // Catch:{ Exception -> 0x006e, all -> 0x006c }
            if (r4 == r0) goto L_0x0056
            r7.write(r3, r2, r4)     // Catch:{ Exception -> 0x006e, all -> 0x006c }
            goto L_0x004c
        L_0x0056:
            java.lang.String r8 = r8.getAbsolutePath()     // Catch:{ Exception -> 0x006e, all -> 0x006c }
            r6.f795d = r8     // Catch:{ Exception -> 0x006e, all -> 0x006c }
            r6.e(r1)     // Catch:{ Exception -> 0x006e, all -> 0x006c }
            r9.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x0067
        L_0x0063:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0067:
            r7.close()     // Catch:{ IOException -> 0x0099 }
            goto L_0x00fc
        L_0x006c:
            r8 = move-exception
            goto L_0x0072
        L_0x006e:
            r8 = move-exception
            goto L_0x0076
        L_0x0070:
            r8 = move-exception
            r7 = r3
        L_0x0072:
            r3 = r9
            goto L_0x009f
        L_0x0074:
            r8 = move-exception
            r7 = r3
        L_0x0076:
            r3 = r9
            goto L_0x007d
        L_0x0078:
            r8 = move-exception
            r7 = r3
            goto L_0x009f
        L_0x007b:
            r8 = move-exception
            r7 = r3
        L_0x007d:
            r8.printStackTrace()     // Catch:{ all -> 0x009e }
            a.c.d.r.h$b r8 = r6.f     // Catch:{ all -> 0x009e }
            if (r8 == 0) goto L_0x0089
            a.c.d.r.h$b r8 = r6.f     // Catch:{ all -> 0x009e }
            r8.i()     // Catch:{ all -> 0x009e }
        L_0x0089:
            if (r3 == 0) goto L_0x0093
            r3.close()     // Catch:{ IOException -> 0x008f }
            goto L_0x0093
        L_0x008f:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0093:
            if (r7 == 0) goto L_0x00fc
            r7.close()     // Catch:{ IOException -> 0x0099 }
            goto L_0x00fc
        L_0x0099:
            r7 = move-exception
            r7.printStackTrace()
            goto L_0x00fc
        L_0x009e:
            r8 = move-exception
        L_0x009f:
            if (r3 == 0) goto L_0x00a9
            r3.close()     // Catch:{ IOException -> 0x00a5 }
            goto L_0x00a9
        L_0x00a5:
            r9 = move-exception
            r9.printStackTrace()
        L_0x00a9:
            if (r7 == 0) goto L_0x00b3
            r7.close()     // Catch:{ IOException -> 0x00af }
            goto L_0x00b3
        L_0x00af:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00b3:
            throw r8
        L_0x00b4:
            android.content.Context r8 = r6.h()
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 19
            if (r0 < r4) goto L_0x00c0
            r0 = 1
            goto L_0x00c1
        L_0x00c0:
            r0 = 0
        L_0x00c1:
            if (r0 == 0) goto L_0x00d8
            java.util.List r0 = r7.getPathSegments()
            int r4 = r0.size()
            r5 = 2
            if (r4 >= r5) goto L_0x00cf
            goto L_0x00d8
        L_0x00cf:
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r4 = "document"
            r4.equals(r0)
        L_0x00d8:
            java.lang.String r0 = r7.getScheme()
            boolean r9 = r9.equalsIgnoreCase(r0)
            if (r9 == 0) goto L_0x00e7
            java.lang.String r3 = a.c.a.f.b.F(r8, r7, r3, r3)
            goto L_0x00f7
        L_0x00e7:
            java.lang.String r8 = r7.getScheme()
            java.lang.String r9 = "file"
            boolean r8 = r9.equalsIgnoreCase(r8)
            if (r8 == 0) goto L_0x00f7
            java.lang.String r3 = r7.getPath()
        L_0x00f7:
            r6.f795d = r3
            r6.e(r2)
        L_0x00fc:
            return r1
        L_0x00fd:
            r9 = 2000(0x7d0, float:2.803E-42)
            if (r7 != r9) goto L_0x010f
            if (r8 != r0) goto L_0x010f
            java.lang.String r7 = r6.f795d
            boolean r7 = a.c.a.d.a.j(r7)
            if (r7 != 0) goto L_0x010e
            r6.e(r1)
        L_0x010e:
            return r1
        L_0x010f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.c.d.r.h.n(int, int, android.content.Intent):boolean");
    }

    public boolean o(int i, @NonNull int[] iArr) {
        if (i == 200) {
            if (iArr.length > 0 && iArr[0] == 0) {
                r();
            }
            return true;
        } else if (i != 201) {
            return false;
        } else {
            if (iArr.length > 0 && iArr[0] == 0) {
                s();
            }
            return true;
        }
    }

    public void p(Bundle bundle) {
        if (bundle != null && bundle.containsKey("KEY_PHOTOMANAGER_ABSOLUTE_PATH")) {
            this.f795d = bundle.getString("KEY_PHOTOMANAGER_ABSOLUTE_PATH");
            StringBuilder n = a.a.a.a.a.n("PhotoManager - Absolute Path Restored->");
            n.append(this.f795d);
            e.b(n.toString());
        }
    }

    public void r() {
        AlertDialog.Builder builder = new AlertDialog.Builder(h());
        builder.setTitle(g());
        builder.setSingleChoiceItems(this.f792a, -1, new a());
        builder.show();
    }

    public void s() {
        File file = new File(j(), f("jpg"));
        this.f795d = file.getAbsolutePath();
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (Build.VERSION.SDK_INT >= 21) {
            intent.putExtra("output", FileProvider.getUriForFile(h(), l(), file));
            intent.addFlags(2);
            intent.addFlags(1);
        } else {
            intent.putExtra("output", Uri.fromFile(file));
        }
        Activity activity = this.f793b;
        if (activity != null) {
            activity.startActivityForResult(intent, RecyclerView.MAX_SCROLL_DURATION);
            return;
        }
        Fragment fragment = this.f794c;
        if (fragment != null) {
            fragment.startActivityForResult(intent, RecyclerView.MAX_SCROLL_DURATION);
        }
    }
}
