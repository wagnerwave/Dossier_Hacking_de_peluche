package a.c.a.f;

import a.c.d.r.c;
import a.c.d.r.d;
import a.c.d.r.j;
import a.d.a.a.e.g;
import a.d.a.a.e.k.h;
import a.d.a.a.e.m.o;
import a.d.a.a.e.m.r0;
import a.d.a.a.e.m.t.a;
import a.d.a.a.h.g.a6;
import a.d.a.a.h.g.b6;
import a.d.a.a.h.g.f6;
import a.d.a.a.h.g.i6;
import a.d.a.a.h.g.k7;
import a.d.a.a.h.g.k8;
import a.d.a.a.h.g.q8;
import a.d.a.a.h.g.v1;
import a.d.a.a.h.g.v4;
import a.d.a.a.h.g.v7;
import a.d.a.a.h.g.w4;
import a.d.a.a.h.g.y5;
import a.d.a.a.i.b.ja;
import a.d.a.a.i.b.x3;
import a.d.a.a.l.f;
import a.d.a.a.l.k;
import a.d.a.a.l.p;
import a.d.a.a.l.q;
import a.d.b.g.d;
import a.d.b.m.e;
import a.e.a.a.i;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.Process;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompatJellybean;
import androidx.core.app.Person;
import androidx.core.internal.view.SupportMenu;
import com.cuatroochenta.miniland.emybuddy.BuddyPlayerActivity;
import com.cuatroochenta.miniland.model.Song;
import com.cuatroochenta.miniland.player.PlayerNotifyService;
import com.cuatroochenta.miniland.player.PlayerService;
import com.google.android.gms.common.api.Status;
import com.sozpic.miniland.R;
import com.tutk.IOTC.AVFrame;
import com.tuya.smart.android.device.bean.StringSchemaBean;
import com.tuya.smart.android.device.utils.WiFiUtil;
import com.tuya.smart.home.sdk.bean.scene.ConditionExtraInfoBean;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.spongycastle.math.ec.Tnaf;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.KotlinVersion;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static Dialog f32a;

    /* renamed from: b  reason: collision with root package name */
    public static Toast f33b;

    /* renamed from: c  reason: collision with root package name */
    public static Toast f34c;

    /* renamed from: d  reason: collision with root package name */
    public static Boolean f35d;

    /* renamed from: e  reason: collision with root package name */
    public static Boolean f36e;
    public static Boolean f;
    public static ja g;
    public static BluetoothManager h;
    public static BluetoothAdapter i;

    public static void A(Parcel parcel, int i2) {
        if (parcel.dataPosition() != i2) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Overread allowed size end=");
            sb.append(i2);
            throw new a(sb.toString(), parcel);
        }
    }

    public static int A0(Parcel parcel) {
        int readInt = parcel.readInt();
        int d0 = d0(parcel, readInt);
        int dataPosition = parcel.dataPosition();
        if ((65535 & readInt) != 20293) {
            String valueOf = String.valueOf(Integer.toHexString(readInt));
            throw new a(valueOf.length() != 0 ? "Expected object header. Got 0x".concat(valueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i2 = d0 + dataPosition;
        if (i2 >= dataPosition && i2 <= parcel.dataSize()) {
            return i2;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("Size read is invalid start=");
        sb.append(dataPosition);
        sb.append(" end=");
        sb.append(i2);
        throw new a(sb.toString(), parcel);
    }

    public static int A1(byte[] bArr, int i2, v4 v4Var) {
        int U0 = U0(bArr, i2, v4Var);
        int i3 = v4Var.f1981a;
        if (i3 < 0) {
            throw i6.b();
        } else if (i3 > bArr.length - U0) {
            throw i6.a();
        } else if (i3 == 0) {
            v4Var.f1983c = w4.f2000b;
            return U0;
        } else {
            v4Var.f1983c = w4.l(bArr, U0, i3);
            return U0 + i3;
        }
    }

    public static boolean B(@Nullable Object obj, @Nullable Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void B0(Parcel parcel, int i2, boolean z) {
        v1(parcel, i2, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static boolean B1(byte b2) {
        return b2 > -65;
    }

    @NonNull
    public static a.d.a.a.e.k.b C(@NonNull Status status) {
        return status.f4209d != null ? new h(status) : new a.d.a.a.e.k.b(status);
    }

    public static void C0(Parcel parcel, int i2, Bundle bundle, boolean z) {
        if (bundle != null) {
            int P0 = P0(parcel, i2);
            parcel.writeBundle(bundle);
            u1(parcel, P0);
        } else if (z) {
            v1(parcel, i2, 0);
        }
    }

    public static BluetoothAdapter D() {
        if (i == null) {
            i = BluetoothAdapter.getDefaultAdapter();
        }
        return i;
    }

    public static void D0(Parcel parcel, int i2, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int P0 = P0(parcel, i2);
            parcel.writeStrongBinder(iBinder);
            u1(parcel, P0);
        } else if (z) {
            v1(parcel, i2, 0);
        }
    }

    public static Context E() {
        return i.a().f3230a;
    }

    public static void E0(Parcel parcel, int i2, int i3) {
        v1(parcel, i2, 4);
        parcel.writeInt(i3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String F(android.content.Context r6, android.net.Uri r7, java.lang.String r8, java.lang.String[] r9) {
        /*
            r8 = 1
            java.lang.String[] r2 = new java.lang.String[r8]
            r8 = 0
            java.lang.String r9 = "_data"
            r2[r8] = r9
            r8 = 0
            android.content.ContentResolver r0 = r6.getContentResolver()     // Catch:{ all -> 0x0032 }
            r5 = 0
            r3 = 0
            r4 = 0
            r1 = r7
            android.database.Cursor r6 = r0.query(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0032 }
            if (r6 == 0) goto L_0x002c
            boolean r7 = r6.moveToFirst()     // Catch:{ all -> 0x0029 }
            if (r7 == 0) goto L_0x002c
            int r7 = r6.getColumnIndexOrThrow(r9)     // Catch:{ all -> 0x0029 }
            java.lang.String r7 = r6.getString(r7)     // Catch:{ all -> 0x0029 }
            r6.close()
            return r7
        L_0x0029:
            r7 = move-exception
            r8 = r6
            goto L_0x0034
        L_0x002c:
            if (r6 == 0) goto L_0x0031
            r6.close()
        L_0x0031:
            return r8
        L_0x0032:
            r6 = move-exception
            r7 = r6
        L_0x0034:
            if (r8 == 0) goto L_0x0039
            r8.close()
        L_0x0039:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: a.c.a.f.b.F(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static void F0(Parcel parcel, int i2, long j) {
        v1(parcel, i2, 8);
        parcel.writeLong(j);
    }

    public static String G(PowerManager.WakeLock wakeLock, String str) {
        String valueOf = String.valueOf(String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(wakeLock))));
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        String valueOf2 = String.valueOf(str);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public static void G0(Parcel parcel, int i2, Parcelable parcelable, int i3, boolean z) {
        if (parcelable != null) {
            int P0 = P0(parcel, i2);
            parcelable.writeToParcel(parcel, i3);
            u1(parcel, P0);
        } else if (z) {
            v1(parcel, i2, 0);
        }
    }

    public static int H(int i2) {
        return (int) TypedValue.applyDimension(1, (float) i2, a.c.a.a.f.getResources().getDisplayMetrics());
    }

    public static void H0(Parcel parcel, int i2, String str, boolean z) {
        if (str != null) {
            int P0 = P0(parcel, i2);
            parcel.writeString(str);
            u1(parcel, P0);
        } else if (z) {
            v1(parcel, i2, 0);
        }
    }

    public static int I(int[] iArr, int i2, boolean z) {
        int[] iArr2 = iArr;
        int i3 = i2;
        int i4 = 0;
        for (int i5 : iArr2) {
            i4 += i5;
        }
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int i9 = r2 - 1;
            if (i6 >= i9) {
                return i7;
            }
            int i10 = 1 << i6;
            i8 |= i10;
            int i11 = 1;
            while (i11 < iArr2[i6]) {
                int i12 = i4 - i11;
                int i13 = r2 - i6;
                int i14 = i13 - 2;
                int p = p(i12 - 1, i14);
                if (z && i8 == 0) {
                    int i15 = i13 - 1;
                    if (i12 - i15 >= i15) {
                        p -= p(i12 - i13, i14);
                    }
                }
                if (i13 - 1 > 1) {
                    int i16 = i12 - i14;
                    int i17 = 0;
                    while (i16 > i3) {
                        i17 += p((i12 - i16) - 1, i13 - 3);
                        i16--;
                        int[] iArr3 = iArr;
                    }
                    p -= (i9 - i6) * i17;
                } else if (i12 > i3) {
                    p--;
                }
                i7 += p;
                i11++;
                i8 &= i10 ^ -1;
                iArr2 = iArr;
            }
            i4 -= i11;
            i6++;
            iArr2 = iArr;
        }
    }

    public static <T extends Parcelable> void I0(Parcel parcel, int i2, T[] tArr, int i3, boolean z) {
        if (tArr != null) {
            int P0 = P0(parcel, i2);
            parcel.writeInt(r7);
            for (T t : tArr) {
                if (t == null) {
                    parcel.writeInt(0);
                } else {
                    j1(parcel, t, i3);
                }
            }
            u1(parcel, P0);
        } else if (z) {
            v1(parcel, i2, 0);
        }
    }

    public static void J() {
        Dialog dialog = f32a;
        if (!(dialog == null || dialog.getContext() == null)) {
            f32a.hide();
            try {
                f32a.dismiss();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        f32a = null;
    }

    public static <T extends Parcelable> void J0(Parcel parcel, int i2, List<T> list, boolean z) {
        if (list != null) {
            int P0 = P0(parcel, i2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                Parcelable parcelable = (Parcelable) list.get(i3);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    j1(parcel, parcelable, 0);
                }
            }
            u1(parcel, P0);
        } else if (z) {
            v1(parcel, i2, 0);
        }
    }

    public static int K(float f2, float f3, float f4) {
        return Math.round(((1.0f - f4) * f3) + (f2 * f4));
    }

    public static int K0(int i2, int i3) {
        if (i3 <= 1073741823) {
            return Math.min(Math.max(i2, i3), 1073741823);
        }
        throw new IllegalArgumentException(a.c.a.d.a.x("min (%s) must be less than or equal to max (%s)", Integer.valueOf(i3), 1073741823));
    }

    public static boolean L() {
        String str = "";
        if (TextUtils.isEmpty(str)) {
            str = "SmartLife";
        }
        String lowerCase = WiFiUtil.getCurrentSSID((Context) TuyaSdk.getApplication()).toLowerCase();
        return !TextUtils.isEmpty(lowerCase) && (lowerCase.startsWith(str.toLowerCase()) || lowerCase.startsWith("TuyaSmart".toLowerCase()) || lowerCase.contains("-TLinkAP-".toLowerCase()));
    }

    public static int L0(int i2, byte[] bArr, int i3, int i4, v4 v4Var) {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 == 0) {
                return r1(bArr, i3, v4Var);
            }
            if (i5 == 1) {
                return i3 + 8;
            }
            if (i5 == 2) {
                return U0(bArr, i3, v4Var) + v4Var.f1981a;
            }
            if (i5 == 3) {
                int i6 = (i2 & -8) | 4;
                int i7 = 0;
                while (i3 < i4) {
                    i3 = U0(bArr, i3, v4Var);
                    i7 = v4Var.f1981a;
                    if (i7 == i6) {
                        break;
                    }
                    i3 = L0(i7, bArr, i3, i4, v4Var);
                }
                if (i3 <= i4 && i7 == i6) {
                    return i3;
                }
                throw i6.e();
            } else if (i5 == 5) {
                return i3 + 4;
            } else {
                throw i6.c();
            }
        } else {
            throw i6.c();
        }
    }

    public static boolean M() {
        return Build.VERSION.SDK_INT >= 18;
    }

    public static int M0(int i2, byte[] bArr, int i3, int i4, f6<?> f6Var, v4 v4Var) {
        b6 b6Var = (b6) f6Var;
        int U0 = U0(bArr, i3, v4Var);
        while (true) {
            b6Var.h(v4Var.f1981a);
            if (U0 >= i4) {
                break;
            }
            int U02 = U0(bArr, U0, v4Var);
            if (i2 != v4Var.f1981a) {
                break;
            }
            U0 = U0(bArr, U02, v4Var);
        }
        return U0;
    }

    public static boolean N() {
        return Build.VERSION.SDK_INT >= 20;
    }

    public static int N0(int i2, byte[] bArr, int i3, int i4, k8 k8Var, v4 v4Var) {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 == 0) {
                int r1 = r1(bArr, i3, v4Var);
                k8Var.a(i2, Long.valueOf(v4Var.f1982b));
                return r1;
            } else if (i5 == 1) {
                k8Var.a(i2, Long.valueOf(s1(bArr, i3)));
                return i3 + 8;
            } else if (i5 == 2) {
                int U0 = U0(bArr, i3, v4Var);
                int i6 = v4Var.f1981a;
                if (i6 < 0) {
                    throw i6.b();
                } else if (i6 <= bArr.length - U0) {
                    k8Var.a(i2, i6 == 0 ? w4.f2000b : w4.l(bArr, U0, i6));
                    return U0 + i6;
                } else {
                    throw i6.a();
                }
            } else if (i5 == 3) {
                k8 c2 = k8.c();
                int i7 = (i2 & -8) | 4;
                int i8 = 0;
                while (true) {
                    if (i3 >= i4) {
                        break;
                    }
                    int U02 = U0(bArr, i3, v4Var);
                    int i9 = v4Var.f1981a;
                    i8 = i9;
                    if (i9 == i7) {
                        i3 = U02;
                        break;
                    }
                    int N0 = N0(i8, bArr, U02, i4, c2, v4Var);
                    i8 = i9;
                    i3 = N0;
                }
                if (i3 > i4 || i8 != i7) {
                    throw i6.e();
                }
                k8Var.a(i2, c2);
                return i3;
            } else if (i5 == 5) {
                k8Var.a(i2, Integer.valueOf(T0(bArr, i3)));
                return i3 + 4;
            } else {
                throw i6.c();
            }
        } else {
            throw i6.c();
        }
    }

    public static boolean O() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static int O0(int i2, byte[] bArr, int i3, v4 v4Var) {
        int i4;
        int i5;
        int i6 = i2 & 127;
        int i7 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            i4 = b2 << 7;
        } else {
            int i8 = i6 | ((b2 & Byte.MAX_VALUE) << 7);
            int i9 = i7 + 1;
            byte b3 = bArr[i7];
            if (b3 >= 0) {
                i5 = b3 << 14;
            } else {
                i6 = i8 | ((b3 & Byte.MAX_VALUE) << 14);
                i7 = i9 + 1;
                byte b4 = bArr[i9];
                if (b4 >= 0) {
                    i4 = b4 << 21;
                } else {
                    i8 = i6 | ((b4 & Byte.MAX_VALUE) << 21);
                    i9 = i7 + 1;
                    byte b5 = bArr[i7];
                    if (b5 >= 0) {
                        i5 = b5 << 28;
                    } else {
                        int i10 = i8 | ((b5 & Byte.MAX_VALUE) << 28);
                        while (true) {
                            int i11 = i9 + 1;
                            if (bArr[i9] >= 0) {
                                v4Var.f1981a = i10;
                                return i11;
                            }
                            i9 = i11;
                        }
                    }
                }
            }
            v4Var.f1981a = i8 | i5;
            return i9;
        }
        v4Var.f1981a = i6 | i4;
        return i7;
    }

    public static boolean P() {
        return Build.VERSION.SDK_INT >= 18 && E() != null && E().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public static int P0(Parcel parcel, int i2) {
        parcel.writeInt(i2 | SupportMenu.CATEGORY_MASK);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static boolean Q() {
        BluetoothAdapter D = D();
        return (D != null ? D.getState() : 0) == 12;
    }

    public static int Q0(v7<?> v7Var, int i2, byte[] bArr, int i3, int i4, f6<?> f6Var, v4 v4Var) {
        int S0 = S0(v7Var, bArr, i3, i4, v4Var);
        while (true) {
            f6Var.add(v4Var.f1983c);
            if (S0 >= i4) {
                break;
            }
            int U0 = U0(bArr, S0, v4Var);
            if (i2 != v4Var.f1981a) {
                break;
            }
            S0 = S0(v7Var, bArr, U0, i4, v4Var);
        }
        return S0;
    }

    public static boolean R(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static int R0(v7 v7Var, byte[] bArr, int i2, int i3, int i4, v4 v4Var) {
        k7 k7Var = (k7) v7Var;
        Object b2 = k7Var.k.b(k7Var.f1780e);
        int m = k7Var.m(b2, bArr, i2, i3, i4, v4Var);
        k7Var.e(b2);
        v4Var.f1983c = b2;
        return m;
    }

    public static boolean S(List<?> list) {
        return list == null || list.size() <= 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int S0(a.d.a.a.h.g.v7 r6, byte[] r7, int r8, int r9, a.d.a.a.h.g.v4 r10) {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = O0(r8, r7, r0, r10)
            int r8 = r10.f1981a
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.a()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.g(r1, r2, r3, r4, r5)
            r6.e(r9)
            r10.f1983c = r9
            return r8
        L_0x0025:
            a.d.a.a.h.g.i6 r6 = a.d.a.a.h.g.i6.a()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: a.c.a.f.b.S0(a.d.a.a.h.g.v7, byte[], int, int, a.d.a.a.h.g.v4):int");
    }

    public static boolean T(Context context, int i2) {
        if (!z0(context, i2, "com.google.android.gms")) {
            return false;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.google.android.gms", 64);
            a.d.a.a.e.h a2 = a.d.a.a.e.h.a(context);
            if (a2 == null) {
                throw null;
            } else if (packageInfo == null) {
                return false;
            } else {
                if (!a.d.a.a.e.h.d(packageInfo, false)) {
                    if (!a.d.a.a.e.h.d(packageInfo, true)) {
                        return false;
                    }
                    if (!g.d(a2.f1247a)) {
                        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
                        return false;
                    }
                }
                return true;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            if (Log.isLoggable("UidVerifier", 3)) {
                Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
            }
            return false;
        }
    }

    public static int T0(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & AVFrame.FRM_STATE_UNKOWN) << 24) | (bArr[i2] & AVFrame.FRM_STATE_UNKOWN) | ((bArr[i2 + 1] & AVFrame.FRM_STATE_UNKOWN) << 8) | ((bArr[i2 + 2] & AVFrame.FRM_STATE_UNKOWN) << Tnaf.POW_2_WIDTH);
    }

    public static boolean U(Context context) {
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getRunningServices(Integer.MAX_VALUE)) {
            if (PlayerService.class.getName().equals(runningServiceInfo.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public static int U0(byte[] bArr, int i2, v4 v4Var) {
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 < 0) {
            return O0(b2, bArr, i3, v4Var);
        }
        v4Var.f1981a = b2;
        return i3;
    }

    @TargetApi(20)
    public static boolean V(Context context) {
        if (f35d == null) {
            f35d = Boolean.valueOf(N() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return f35d.booleanValue();
    }

    public static int V0(byte[] bArr, int i2, f6<?> f6Var, v4 v4Var) {
        b6 b6Var = (b6) f6Var;
        int U0 = U0(bArr, i2, v4Var);
        int i3 = v4Var.f1981a + U0;
        while (U0 < i3) {
            U0 = U0(bArr, U0, v4Var);
            b6Var.h(v4Var.f1981a);
        }
        if (U0 == i3) {
            return U0;
        }
        throw i6.a();
    }

    @TargetApi(26)
    public static boolean W(Context context) {
        if (V(context)) {
            if (Build.VERSION.SDK_INT >= 24) {
                if (f36e == null) {
                    f36e = Boolean.valueOf((Build.VERSION.SDK_INT >= 21) && context.getPackageManager().hasSystemFeature("cn.google"));
                }
                if (!f36e.booleanValue() || O()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static <T> T W0(@NonNull Bundle bundle, String str, Class<T> cls, T t) {
        T t2 = bundle.get(str);
        if (t2 == null) {
            return t;
        }
        if (cls.isAssignableFrom(t2.getClass())) {
            return t2;
        }
        throw new IllegalStateException(String.format("Invalid conditional user property field type. '%s' expected [%s] but was [%s]", new Object[]{str, cls.getCanonicalName(), t2.getClass().getCanonicalName()}));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.io.FileInputStream} */
    /* JADX WARNING: type inference failed for: r5v1, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:13|14|15|16|17|35) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002a */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003c A[SYNTHETIC, Splitter:B:26:0x003c] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0043 A[SYNTHETIC, Splitter:B:30:0x0043] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void X(java.io.File r4, java.io.File r5) {
        /*
            boolean r0 = r4.renameTo(r5)
            if (r0 != 0) goto L_0x0047
            java.io.File r0 = r5.getParentFile()
            r0.mkdirs()
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0038 }
            r1.<init>(r4)     // Catch:{ all -> 0x0038 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x0034 }
            r2.<init>(r5)     // Catch:{ all -> 0x0034 }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ all -> 0x0031 }
        L_0x001c:
            int r0 = r1.read(r5)     // Catch:{ all -> 0x0031 }
            if (r0 <= 0) goto L_0x0027
            r3 = 0
            r2.write(r5, r3, r0)     // Catch:{ all -> 0x0031 }
            goto L_0x001c
        L_0x0027:
            r1.close()     // Catch:{ Exception -> 0x002a }
        L_0x002a:
            r2.close()     // Catch:{ Exception -> 0x002d }
        L_0x002d:
            r4.delete()
            goto L_0x0047
        L_0x0031:
            r4 = move-exception
            r0 = r2
            goto L_0x0035
        L_0x0034:
            r4 = move-exception
        L_0x0035:
            r5 = r0
            r0 = r1
            goto L_0x003a
        L_0x0038:
            r4 = move-exception
            r5 = r0
        L_0x003a:
            if (r0 == 0) goto L_0x0041
            r0.close()     // Catch:{ Exception -> 0x0040 }
            goto L_0x0041
        L_0x0040:
        L_0x0041:
            if (r5 == 0) goto L_0x0046
            r5.close()     // Catch:{ Exception -> 0x0046 }
        L_0x0046:
            throw r4
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.c.a.f.b.X(java.io.File, java.io.File):void");
    }

    public static <V> V X0(v1<V> v1Var) {
        long clearCallingIdentity;
        try {
            return v1Var.a();
        } catch (SecurityException unused) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            V a2 = v1Var.a();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return a2;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }

    public static void Y(Activity activity, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (i2 == 0) {
            i3 = R.anim.slide_in_right;
            i4 = R.anim.slide_out_left;
        } else if (i2 == 1) {
            i3 = R.anim.slide_in_left;
            i4 = R.anim.slide_out_right;
        } else if (i2 == 2) {
            i3 = R.anim.easein;
            i4 = R.anim.easeout;
        } else {
            int i7 = R.anim.slide_none_medium_time;
            if (i2 == 3) {
                i5 = R.anim.slide_bottom_to_top;
            } else {
                if (i2 == 4) {
                    i6 = R.anim.slide_top_to_bottom;
                } else {
                    i7 = R.anim.slide_none;
                    if (i2 == 5) {
                        i5 = R.anim.popup_scale_in;
                    } else if (i2 == 6) {
                        i6 = R.anim.popup_scale_out;
                    } else if (i2 != -1) {
                        i3 = R.anim.magnify_fade_in;
                        i4 = R.anim.fade_out;
                    } else {
                        return;
                    }
                }
                activity.overridePendingTransition(i7, i6);
                return;
            }
            activity.overridePendingTransition(i5, i7);
            return;
        }
        activity.overridePendingTransition(i3, i4);
    }

    public static Object Y0(Object obj, int i2) {
        if (obj != null) {
            return obj;
        }
        StringBuilder sb = new StringBuilder(20);
        sb.append("at index ");
        sb.append(i2);
        throw new NullPointerException(sb.toString());
    }

    public static boolean Z(Parcel parcel, int i2) {
        i1(parcel, i2, 4);
        return parcel.readInt() != 0;
    }

    public static String Z0(Context context, String str) {
        try {
            k(context);
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier(str, StringSchemaBean.type, resources.getResourcePackageName(a.d.a.a.e.i.common_google_play_services_unknown_issue));
            if (identifier == 0) {
                return null;
            }
            return resources.getString(identifier);
        } catch (Resources.NotFoundException unused) {
        }
    }

    public static <TResult> TResult a(@NonNull p<TResult> pVar, long j, @NonNull TimeUnit timeUnit) {
        boolean z;
        j("Must not be called on the main application thread");
        l(pVar, "Task must not be null");
        l(timeUnit, "TimeUnit must not be null");
        synchronized (pVar.f2708a) {
            z = pVar.f2710c;
        }
        if (z) {
            return t1(pVar);
        }
        a.d.a.a.l.g gVar = new a.d.a.a.l.g((q) null);
        pVar.f2709b.a(new k(f.f2690a, gVar));
        pVar.f();
        pVar.f2709b.a(new a.d.a.a.l.i(f.f2690a, gVar));
        pVar.f();
        pVar.f2709b.a(new a.d.a.a.l.h(f.f2690a, gVar));
        pVar.f();
        if (gVar.f2691a.await(j, timeUnit)) {
            return t1(pVar);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    public static IBinder a0(Parcel parcel, int i2) {
        int d0 = d0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (d0 == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + d0);
        return readStrongBinder;
    }

    public static String a1(w4 w4Var) {
        String str;
        StringBuilder sb = new StringBuilder(w4Var.d());
        for (int i2 = 0; i2 < w4Var.d(); i2++) {
            int c2 = w4Var.c(i2);
            if (c2 == 34) {
                str = "\\\"";
            } else if (c2 == 39) {
                str = "\\'";
            } else if (c2 != 92) {
                switch (c2) {
                    case 7:
                        str = "\\a";
                        break;
                    case 8:
                        str = "\\b";
                        break;
                    case 9:
                        str = "\\t";
                        break;
                    case 10:
                        str = "\\n";
                        break;
                    case 11:
                        str = "\\v";
                        break;
                    case 12:
                        str = "\\f";
                        break;
                    case 13:
                        str = "\\r";
                        break;
                    default:
                        if (c2 < 32 || c2 > 126) {
                            sb.append('\\');
                            sb.append((char) (((c2 >>> 6) & 3) + 48));
                            sb.append((char) (((c2 >>> 3) & 7) + 48));
                            c2 = (c2 & 7) + 48;
                        }
                        sb.append((char) c2);
                        continue;
                }
            } else {
                str = "\\\\";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public static int b(Parcel parcel) {
        return P0(parcel, 20293);
    }

    public static int b0(Parcel parcel, int i2) {
        i1(parcel, i2, 4);
        return parcel.readInt();
    }

    public static final String b1(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    public static String c(String str) {
        byte[] bytes = str.getBytes();
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(bytes);
            return String.format("%032x", new Object[]{new BigInteger(1, MessageDigest.getInstance("MD5").digest(bytes))});
        } catch (NoSuchAlgorithmException e2) {
            throw new Error("invalid JRE: have not 'MD5' impl.", e2);
        }
    }

    public static long c0(Parcel parcel, int i2) {
        i1(parcel, i2, 8);
        return parcel.readLong();
    }

    @Nullable
    public static String c1(String str, String[] strArr, String[] strArr2) {
        k(strArr);
        k(strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i2 = 0; i2 < min; i2++) {
            String str2 = strArr[i2];
            if ((str == null && str2 == null) ? true : str == null ? false : str.equals(str2)) {
                return strArr2[i2];
            }
        }
        return null;
    }

    public static void d(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static int d0(Parcel parcel, int i2) {
        return (i2 & SupportMenu.CATEGORY_MASK) != -65536 ? (i2 >> 16) & 65535 : parcel.readInt();
    }

    @WorkerThread
    public static Set<String> d1(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        Cursor rawQuery = sQLiteDatabase.rawQuery(a.a.a.a.a.d(String.valueOf(str).length() + 22, "SELECT * FROM ", str, " LIMIT 0"), (String[]) null);
        try {
            Collections.addAll(hashSet, rawQuery.getColumnNames());
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    public static void e(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void e0(Context context, int i2) {
        if (U(context)) {
            Intent intent = new Intent(context, PlayerService.class);
            intent.putExtra("EXTRA_KEY_REMOVE_PLAYLIST_SONG", i2);
            context.startService(intent);
        }
    }

    public static void e1(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i2) {
        if (!B1(b3)) {
            if ((((b3 + 112) + (b2 << 28)) >> 30) == 0 && !B1(b4) && !B1(b5)) {
                byte b6 = ((b2 & 7) << 18) | ((b3 & 63) << 12) | ((b4 & 63) << 6) | (b5 & 63);
                cArr[i2] = (char) ((b6 >>> 10) + 55232);
                cArr[i2 + 1] = (char) ((b6 & AVFrame.FRM_STATE_UNKOWN) + 56320);
                return;
            }
        }
        throw i6.f();
    }

    public static void f(Handler handler) {
        String name = Looper.myLooper() != null ? Looper.myLooper().getThread().getName() : "null current looper";
        String name2 = handler.getLooper().getThread().getName();
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + String.valueOf(name2).length() + 36);
        sb.append("Must be called on ");
        sb.append(name2);
        sb.append(" thread, but got ");
        sb.append(name);
        sb.append(".");
        String sb2 = sb.toString();
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException(sb2);
        }
    }

    public static ArrayList<Song> f0(Context context) {
        ArrayList<Song> arrayList = new ArrayList<>();
        ArrayList<String> k = a.c.d.a.l().k();
        if (k == null) {
            k = new ArrayList<>();
        }
        Cursor query = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, (String[]) null, (String) null, (String[]) null, (String) null);
        if (query == null) {
            Toast.makeText(context, a.c.a.d.a.h(R.string.TR_ERROR_RETRIEVING_SONGS_INFO), 0).show();
        } else if (query.moveToFirst()) {
            int columnIndex = query.getColumnIndex(NotificationCompatJellybean.KEY_TITLE);
            int columnIndex2 = query.getColumnIndex("_id");
            int columnIndex3 = query.getColumnIndex(ConditionExtraInfoBean.CAL_TYPE_DURATION);
            do {
                long j = query.getLong(columnIndex2);
                String string = query.getString(columnIndex);
                long j2 = query.getLong(columnIndex3);
                Song song = new Song(Song.DEVICE_TYPE, ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, j));
                song.setId(String.valueOf(j));
                song.setTitle(string);
                song.setDuration(((int) j2) / 1000);
                song.setFavourite(k.contains(song.getId()));
                arrayList.add(song);
            } while (query.moveToNext());
        }
        return arrayList;
    }

    public static void f1(byte b2, byte b3, byte b4, char[] cArr, int i2) {
        if (B1(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || B1(b4)))) {
            throw i6.f();
        }
        cArr[i2] = (char) (((b2 & 15) << 12) | ((b3 & 63) << 6) | (b4 & 63));
    }

    public static void g(String str) {
        if (!(Looper.getMainLooper() == Looper.myLooper())) {
            throw new IllegalStateException(str);
        }
    }

    public static final void g0(Context context, int i2) {
        if (U(context)) {
            Intent intent = new Intent(context, PlayerService.class);
            intent.putExtra("EXTRA_PLAYER_NOTIFY_OPTION", i2);
            context.startService(intent);
        }
    }

    public static void g1(byte b2, byte b3, char[] cArr, int i2) {
        if (b2 < -62 || B1(b3)) {
            throw i6.f();
        }
        cArr[i2] = (char) (((b2 & 31) << 6) | (b3 & 63));
    }

    public static String h(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException("Given String is empty or null");
    }

    public static void h0(Context context, String str, String str2) {
        if (!a.c.a.d.a.j(str)) {
            new AlertDialog.Builder(context).setIcon(17301543).setMessage(str).setPositiveButton(str2, (DialogInterface.OnClickListener) null).show();
        }
    }

    public static void h1(@NonNull Bundle bundle, @NonNull Object obj) {
        if (obj instanceof Double) {
            bundle.putDouble("value", ((Double) obj).doubleValue());
        } else if (obj instanceof Long) {
            bundle.putLong("value", ((Long) obj).longValue());
        } else {
            bundle.putString("value", obj.toString());
        }
    }

    public static String i(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    public static void i0(Activity activity, String str, String str2) {
        if (!a.c.a.d.a.j(str)) {
            new AlertDialog.Builder(activity).setIcon(17301543).setMessage(str).setPositiveButton(str2, new c(activity)).show();
        }
    }

    public static void i1(Parcel parcel, int i2, int i3) {
        int d0 = d0(parcel, i2);
        if (d0 != i3) {
            String hexString = Integer.toHexString(d0);
            StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
            sb.append("Expected size ");
            sb.append(i3);
            sb.append(" got ");
            sb.append(d0);
            sb.append(" (0x");
            sb.append(hexString);
            sb.append(")");
            throw new a(sb.toString(), parcel);
        }
    }

    public static void j(String str) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static void j0(Context context, String str) {
        if (!((Activity) context).isFinishing()) {
            new AlertDialog.Builder(context).setTitle((CharSequence) a.c.a.d.a.h(R.string.TR_INFORMATION)).setMessage((CharSequence) str).setPositiveButton((CharSequence) a.c.a.d.a.h(R.string.TR_OK), (DialogInterface.OnClickListener) new c()).show();
        }
    }

    public static <T extends Parcelable> void j1(Parcel parcel, T t, int i2) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i2);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    @NonNull
    public static <T> T k(@Nullable T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException("null reference");
    }

    public static void k0(Activity activity, String str) {
        if (!activity.isFinishing()) {
            new AlertDialog.Builder(activity).setTitle((CharSequence) a.c.a.d.a.h(R.string.TR_INFORMATION)).setMessage((CharSequence) str).setCancelable(false).setPositiveButton((CharSequence) a.c.a.d.a.h(R.string.TR_OK), (DialogInterface.OnClickListener) new d(activity)).show();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01e3, code lost:
        if (((java.lang.Boolean) r4).booleanValue() == false) goto L_0x0244;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01f1, code lost:
        if (((java.lang.Integer) r4).intValue() == 0) goto L_0x0244;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0202, code lost:
        if (((java.lang.Float) r4).floatValue() == 0.0f) goto L_0x0244;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0214, code lost:
        if (((java.lang.Double) r4).doubleValue() == 0.0d) goto L_0x0244;
     */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x024a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void k1(a.d.a.a.h.g.i7 r13, java.lang.StringBuilder r14, int r15) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.util.TreeSet r2 = new java.util.TreeSet
            r2.<init>()
            java.lang.Class r3 = r13.getClass()
            java.lang.reflect.Method[] r3 = r3.getDeclaredMethods()
            int r4 = r3.length
            r5 = 0
            r6 = 0
        L_0x001a:
            java.lang.String r7 = "get"
            if (r6 >= r4) goto L_0x0049
            r8 = r3[r6]
            java.lang.String r9 = r8.getName()
            r1.put(r9, r8)
            java.lang.Class[] r9 = r8.getParameterTypes()
            int r9 = r9.length
            if (r9 != 0) goto L_0x0046
            java.lang.String r9 = r8.getName()
            r0.put(r9, r8)
            java.lang.String r9 = r8.getName()
            boolean r7 = r9.startsWith(r7)
            if (r7 == 0) goto L_0x0046
            java.lang.String r7 = r8.getName()
            r2.add(r7)
        L_0x0046:
            int r6 = r6 + 1
            goto L_0x001a
        L_0x0049:
            java.util.Iterator r2 = r2.iterator()
        L_0x004d:
            boolean r3 = r2.hasNext()
            r4 = 3
            if (r3 == 0) goto L_0x0263
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            boolean r6 = r3.startsWith(r7)
            if (r6 == 0) goto L_0x0065
            java.lang.String r6 = r3.substring(r4)
            goto L_0x0066
        L_0x0065:
            r6 = r3
        L_0x0066:
            java.lang.String r8 = "List"
            boolean r9 = r6.endsWith(r8)
            r10 = 1
            if (r9 == 0) goto L_0x00c8
            java.lang.String r9 = "OrBuilderList"
            boolean r9 = r6.endsWith(r9)
            if (r9 != 0) goto L_0x00c8
            boolean r8 = r6.equals(r8)
            if (r8 != 0) goto L_0x00c8
            java.lang.String r8 = r6.substring(r5, r10)
            java.lang.String r8 = r8.toLowerCase()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            int r9 = r6.length()
            int r9 = r9 + -4
            java.lang.String r9 = r6.substring(r10, r9)
            java.lang.String r9 = java.lang.String.valueOf(r9)
            int r11 = r9.length()
            if (r11 == 0) goto L_0x00a2
            java.lang.String r8 = r8.concat(r9)
            goto L_0x00a8
        L_0x00a2:
            java.lang.String r9 = new java.lang.String
            r9.<init>(r8)
            r8 = r9
        L_0x00a8:
            java.lang.Object r9 = r0.get(r3)
            java.lang.reflect.Method r9 = (java.lang.reflect.Method) r9
            if (r9 == 0) goto L_0x00c8
            java.lang.Class r11 = r9.getReturnType()
            java.lang.Class<java.util.List> r12 = java.util.List.class
            boolean r11 = r11.equals(r12)
            if (r11 == 0) goto L_0x00c8
            java.lang.String r3 = b1(r8)
            java.lang.Object[] r4 = new java.lang.Object[r5]
            java.lang.Object r4 = a.d.a.a.h.g.y5.o(r9, r13, r4)
            goto L_0x025e
        L_0x00c8:
            java.lang.String r8 = "Map"
            boolean r9 = r6.endsWith(r8)
            if (r9 == 0) goto L_0x0134
            boolean r8 = r6.equals(r8)
            if (r8 != 0) goto L_0x0134
            java.lang.String r8 = r6.substring(r5, r10)
            java.lang.String r8 = r8.toLowerCase()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            int r9 = r6.length()
            int r9 = r9 - r4
            java.lang.String r4 = r6.substring(r10, r9)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r9 = r4.length()
            if (r9 == 0) goto L_0x00fa
            java.lang.String r4 = r8.concat(r4)
            goto L_0x00ff
        L_0x00fa:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r8)
        L_0x00ff:
            java.lang.Object r3 = r0.get(r3)
            java.lang.reflect.Method r3 = (java.lang.reflect.Method) r3
            if (r3 == 0) goto L_0x0134
            java.lang.Class r8 = r3.getReturnType()
            java.lang.Class<java.util.Map> r9 = java.util.Map.class
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x0134
            java.lang.Class<java.lang.Deprecated> r8 = java.lang.Deprecated.class
            boolean r8 = r3.isAnnotationPresent(r8)
            if (r8 != 0) goto L_0x0134
            int r8 = r3.getModifiers()
            boolean r8 = java.lang.reflect.Modifier.isPublic(r8)
            if (r8 == 0) goto L_0x0134
            java.lang.String r4 = b1(r4)
            java.lang.Object[] r6 = new java.lang.Object[r5]
            java.lang.Object r3 = a.d.a.a.h.g.y5.o(r3, r13, r6)
            o1(r14, r15, r4, r3)
            goto L_0x004d
        L_0x0134:
            java.lang.String r3 = "set"
            int r4 = r6.length()
            if (r4 == 0) goto L_0x0141
            java.lang.String r3 = r3.concat(r6)
            goto L_0x0147
        L_0x0141:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r3)
            r3 = r4
        L_0x0147:
            java.lang.Object r3 = r1.get(r3)
            java.lang.reflect.Method r3 = (java.lang.reflect.Method) r3
            if (r3 == 0) goto L_0x004d
            java.lang.String r3 = "Bytes"
            boolean r3 = r6.endsWith(r3)
            if (r3 == 0) goto L_0x017b
            int r3 = r6.length()
            int r3 = r3 + -5
            java.lang.String r3 = r6.substring(r5, r3)
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r4 = r3.length()
            if (r4 == 0) goto L_0x0170
            java.lang.String r3 = r7.concat(r3)
            goto L_0x0175
        L_0x0170:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r7)
        L_0x0175:
            boolean r3 = r0.containsKey(r3)
            if (r3 != 0) goto L_0x004d
        L_0x017b:
            java.lang.String r3 = r6.substring(r5, r10)
            java.lang.String r3 = r3.toLowerCase()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = r6.substring(r10)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r8 = r4.length()
            if (r8 == 0) goto L_0x019a
            java.lang.String r3 = r3.concat(r4)
            goto L_0x01a0
        L_0x019a:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r3)
            r3 = r4
        L_0x01a0:
            int r4 = r6.length()
            if (r4 == 0) goto L_0x01ab
            java.lang.String r4 = r7.concat(r6)
            goto L_0x01b0
        L_0x01ab:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r7)
        L_0x01b0:
            java.lang.Object r4 = r0.get(r4)
            java.lang.reflect.Method r4 = (java.lang.reflect.Method) r4
            java.lang.String r8 = "has"
            int r9 = r6.length()
            if (r9 == 0) goto L_0x01c3
            java.lang.String r6 = r8.concat(r6)
            goto L_0x01c8
        L_0x01c3:
            java.lang.String r6 = new java.lang.String
            r6.<init>(r8)
        L_0x01c8:
            java.lang.Object r6 = r0.get(r6)
            java.lang.reflect.Method r6 = (java.lang.reflect.Method) r6
            if (r4 == 0) goto L_0x004d
            java.lang.Object[] r8 = new java.lang.Object[r5]
            java.lang.Object r4 = a.d.a.a.h.g.y5.o(r4, r13, r8)
            if (r6 != 0) goto L_0x024c
            boolean r6 = r4 instanceof java.lang.Boolean
            if (r6 == 0) goto L_0x01e6
            r6 = r4
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L_0x0246
            goto L_0x0244
        L_0x01e6:
            boolean r6 = r4 instanceof java.lang.Integer
            if (r6 == 0) goto L_0x01f4
            r6 = r4
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            if (r6 != 0) goto L_0x0246
            goto L_0x0244
        L_0x01f4:
            boolean r6 = r4 instanceof java.lang.Float
            if (r6 == 0) goto L_0x0205
            r6 = r4
            java.lang.Float r6 = (java.lang.Float) r6
            float r6 = r6.floatValue()
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 != 0) goto L_0x0246
            goto L_0x0244
        L_0x0205:
            boolean r6 = r4 instanceof java.lang.Double
            if (r6 == 0) goto L_0x0217
            r6 = r4
            java.lang.Double r6 = (java.lang.Double) r6
            double r8 = r6.doubleValue()
            r11 = 0
            int r6 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r6 != 0) goto L_0x0246
            goto L_0x0244
        L_0x0217:
            boolean r6 = r4 instanceof java.lang.String
            if (r6 == 0) goto L_0x021e
            java.lang.String r6 = ""
            goto L_0x0224
        L_0x021e:
            boolean r6 = r4 instanceof a.d.a.a.h.g.w4
            if (r6 == 0) goto L_0x0229
            a.d.a.a.h.g.w4 r6 = a.d.a.a.h.g.w4.f2000b
        L_0x0224:
            boolean r6 = r4.equals(r6)
            goto L_0x0247
        L_0x0229:
            boolean r6 = r4 instanceof a.d.a.a.h.g.i7
            if (r6 == 0) goto L_0x0237
            r6 = r4
            a.d.a.a.h.g.i7 r6 = (a.d.a.a.h.g.i7) r6
            a.d.a.a.h.g.i7 r6 = r6.h()
            if (r4 != r6) goto L_0x0246
            goto L_0x0244
        L_0x0237:
            boolean r6 = r4 instanceof java.lang.Enum
            if (r6 == 0) goto L_0x0246
            r6 = r4
            java.lang.Enum r6 = (java.lang.Enum) r6
            int r6 = r6.ordinal()
            if (r6 != 0) goto L_0x0246
        L_0x0244:
            r6 = 1
            goto L_0x0247
        L_0x0246:
            r6 = 0
        L_0x0247:
            if (r6 != 0) goto L_0x024a
            goto L_0x0258
        L_0x024a:
            r10 = 0
            goto L_0x0258
        L_0x024c:
            java.lang.Object[] r8 = new java.lang.Object[r5]
            java.lang.Object r6 = a.d.a.a.h.g.y5.o(r6, r13, r8)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r10 = r6.booleanValue()
        L_0x0258:
            if (r10 == 0) goto L_0x004d
            java.lang.String r3 = b1(r3)
        L_0x025e:
            o1(r14, r15, r3, r4)
            goto L_0x004d
        L_0x0263:
            boolean r0 = r13 instanceof a.d.a.a.h.g.y5.d
            if (r0 == 0) goto L_0x0289
            r0 = r13
            a.d.a.a.h.g.y5$d r0 = (a.d.a.a.h.g.y5.d) r0
            a.d.a.a.h.g.r5<a.d.a.a.h.g.y5$c> r0 = r0.zzc
            java.util.Iterator r0 = r0.k()
            boolean r1 = r0.hasNext()
            if (r1 != 0) goto L_0x0277
            goto L_0x0289
        L_0x0277:
            java.lang.Object r13 = r0.next()
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13
            java.lang.Object r13 = r13.getKey()
            a.d.a.a.h.g.y5$c r13 = (a.d.a.a.h.g.y5.c) r13
            java.lang.NoSuchMethodError r13 = new java.lang.NoSuchMethodError
            r13.<init>()
            throw r13
        L_0x0289:
            a.d.a.a.h.g.y5 r13 = (a.d.a.a.h.g.y5) r13
            a.d.a.a.h.g.k8 r13 = r13.zzb
            if (r13 == 0) goto L_0x02a6
        L_0x028f:
            int r0 = r13.f1781a
            if (r5 >= r0) goto L_0x02a6
            int[] r0 = r13.f1782b
            r0 = r0[r5]
            int r0 = r0 >>> r4
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.Object[] r1 = r13.f1783c
            r1 = r1[r5]
            o1(r14, r15, r0, r1)
            int r5 = r5 + 1
            goto L_0x028f
        L_0x02a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.c.a.f.b.k1(a.d.a.a.h.g.i7, java.lang.StringBuilder, int):void");
    }

    @NonNull
    public static <T> T l(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void l0(Context context, String str, String str2) {
        if (!a.c.a.d.a.j(str)) {
            new AlertDialog.Builder(context).setIcon(17301659).setMessage(str).setPositiveButton(str2, (DialogInterface.OnClickListener) null).show();
        }
    }

    public static void l1(x3 x3Var, SQLiteDatabase sQLiteDatabase) {
        if (x3Var != null) {
            File file = new File(sQLiteDatabase.getPath());
            if (!file.setReadable(false, false)) {
                x3Var.i.a("Failed to turn off database read permission");
            }
            if (!file.setWritable(false, false)) {
                x3Var.i.a("Failed to turn off database write permission");
            }
            if (!file.setReadable(true, true)) {
                x3Var.i.a("Failed to turn on database read permission for owner");
            }
            if (!file.setWritable(true, true)) {
                x3Var.i.a("Failed to turn on database write permission for owner");
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Monitor must not be null");
    }

    public static <T> T m(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static void m0(Context context, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener) {
        if (!a.c.a.d.a.j(str2)) {
            new AlertDialog.Builder(context).setIcon(17301659).setTitle((CharSequence) null).setMessage(str2).setPositiveButton(str3, onClickListener).setNegativeButton(str4, (DialogInterface.OnClickListener) null).setCancelable(false).show();
        }
    }

    @WorkerThread
    public static void m1(x3 x3Var, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) {
        boolean z;
        if (x3Var != null) {
            Cursor cursor = null;
            try {
                Cursor query = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, (String) null, (String) null, (String) null);
                z = query.moveToFirst();
                query.close();
            } catch (SQLiteException e2) {
                x3Var.i.c("Error querying for table", str, e2);
                if (cursor != null) {
                    cursor.close();
                }
                z = false;
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
            if (!z) {
                sQLiteDatabase.execSQL(str2);
            }
            try {
                Set<String> d1 = d1(sQLiteDatabase, str);
                String[] split = str3.split(",");
                int length = split.length;
                int i2 = 0;
                while (i2 < length) {
                    String str4 = split[i2];
                    if (((HashSet) d1).remove(str4)) {
                        i2++;
                    } else {
                        StringBuilder sb = new StringBuilder(str.length() + 35 + String.valueOf(str4).length());
                        sb.append("Table ");
                        sb.append(str);
                        sb.append(" is missing required column: ");
                        sb.append(str4);
                        throw new SQLiteException(sb.toString());
                    }
                }
                if (strArr != null) {
                    for (int i3 = 0; i3 < strArr.length; i3 += 2) {
                        if (!((HashSet) d1).remove(strArr[i3])) {
                            sQLiteDatabase.execSQL(strArr[i3 + 1]);
                        }
                    }
                }
                if (!((HashSet) d1).isEmpty()) {
                    x3Var.i.c("Table has extra columns. table, columns", str, TextUtils.join(", ", d1));
                }
            } catch (SQLiteException e3) {
                x3Var.f.b("Failed to verify columns on table that was just created", str);
                throw e3;
            }
        } else {
            throw new IllegalArgumentException("Monitor must not be null");
        }
    }

    public static void n(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void n0(Context context, int i2) {
        String h2 = a.c.a.d.a.h(i2);
        boolean z = false;
        if (f32a == null) {
            a.c.d.j.b.f.c cVar = new a.c.d.j.b.f.c();
            Dialog dialog = new Dialog(context, 2131886384);
            dialog.setContentView(R.layout.ty_progress_dialog_h);
            if (!TextUtils.isEmpty("")) {
                ((TextView) dialog.findViewById(R.id.progress_dialog_message)).setText("");
            }
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setOnCancelListener(cVar);
            f32a = dialog;
        }
        if (!TextUtils.isEmpty(h2)) {
            ((TextView) f32a.findViewById(R.id.progress_dialog_message)).setText(h2);
        }
        Dialog dialog2 = f32a;
        if (dialog2 != null) {
            z = dialog2.isShowing();
        }
        if (!z) {
            f32a.show();
        }
    }

    public static void n1(Object obj, Object obj2) {
        if (obj == null) {
            String valueOf = String.valueOf(obj2);
            StringBuilder sb = new StringBuilder(valueOf.length() + 24);
            sb.append("null key in entry: null=");
            sb.append(valueOf);
            throw new NullPointerException(sb.toString());
        } else if (obj2 == null) {
            String valueOf2 = String.valueOf(obj);
            throw new NullPointerException(a.a.a.a.a.d(valueOf2.length() + 26, "null value in entry: ", valueOf2, "=null"));
        }
    }

    public static void o(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void o0(Context context, String str) {
        p0(context, str, a.c.a.d.a.h(R.string.TR_OK), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null);
    }

    public static final void o1(StringBuilder sb, int i2, String str, Object obj) {
        if (obj instanceof List) {
            for (Object o1 : (List) obj) {
                o1(sb, i2, str, o1);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry o12 : ((Map) obj).entrySet()) {
                o1(sb, i2, str, o12);
            }
        } else {
            sb.append(10);
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(a1(w4.h((String) obj)));
                sb.append('\"');
            } else if (obj instanceof w4) {
                sb.append(": \"");
                sb.append(a1((w4) obj));
                sb.append('\"');
            } else if (obj instanceof y5) {
                sb.append(" {");
                k1((y5) obj, sb, i2 + 2);
                sb.append("\n");
                while (i3 < i2) {
                    sb.append(' ');
                    i3++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i5 = i2 + 2;
                o1(sb, i5, Person.KEY_KEY, entry.getKey());
                o1(sb, i5, "value", entry.getValue());
                sb.append("\n");
                while (i3 < i2) {
                    sb.append(' ');
                    i3++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }

    public static int p(int i2, int i3) {
        int i4 = i2 - i3;
        if (i4 > i3) {
            int i5 = i4;
            i4 = i3;
            i3 = i5;
        }
        int i6 = 1;
        int i7 = 1;
        while (i2 > i3) {
            i6 *= i2;
            if (i7 <= i4) {
                i6 /= i7;
                i7++;
            }
            i2--;
        }
        while (i7 <= i4) {
            i6 /= i7;
            i7++;
        }
        return i6;
    }

    public static void p0(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener, String str3, DialogInterface.OnClickListener onClickListener2) {
        if (!((Activity) context).isFinishing()) {
            new AlertDialog.Builder(context).setTitle((CharSequence) a.c.a.d.a.h(R.string.TR_INFORMATION)).setMessage((CharSequence) str).setPositiveButton((CharSequence) str2, onClickListener).setNegativeButton((CharSequence) str3, onClickListener2).show();
        }
    }

    public static boolean p1(byte b2) {
        return b2 >= 0;
    }

    public static a.d.b.g.d<?> q(String str, String str2) {
        a.d.b.m.a aVar = new a.d.b.m.a(str, str2);
        d.b<e> a2 = a.d.b.g.d.a(e.class);
        a2.f2745d = 1;
        a2.c(new a.d.b.g.c(aVar));
        return a2.b();
    }

    public static synchronized void q0(Context context, int i2) {
        synchronized (b.class) {
            r0(context, a.c.a.d.a.h(i2));
        }
    }

    public static void q1(Parcel parcel, int i2, int i3) {
        if (i2 != i3) {
            String hexString = Integer.toHexString(i2);
            StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
            sb.append("Expected size ");
            sb.append(i3);
            sb.append(" got ");
            sb.append(i2);
            sb.append(" (0x");
            sb.append(hexString);
            sb.append(")");
            throw new a(sb.toString(), parcel);
        }
    }

    public static Bundle r(Parcel parcel, int i2) {
        int d0 = d0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (d0 == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + d0);
        return readBundle;
    }

    public static synchronized void r0(Context context, String str) {
        synchronized (b.class) {
            if (f33b == null) {
                f33b = Toast.makeText(context, "", 1);
            }
            f33b.setText(str);
            f33b.show();
        }
    }

    public static int r1(byte[] bArr, int i2, v4 v4Var) {
        int i3 = i2 + 1;
        long j = (long) bArr[i2];
        if (j >= 0) {
            v4Var.f1982b = j;
            return i3;
        }
        int i4 = i3 + 1;
        byte b2 = bArr[i3];
        long j2 = (j & 127) | (((long) (b2 & Byte.MAX_VALUE)) << 7);
        int i5 = 7;
        while (b2 < 0) {
            int i6 = i4 + 1;
            byte b3 = bArr[i4];
            i5 += 7;
            j2 |= ((long) (b3 & Byte.MAX_VALUE)) << i5;
            int i7 = i6;
            b2 = b3;
            i4 = i7;
        }
        v4Var.f1982b = j2;
        return i4;
    }

    public static <T extends Parcelable> T s(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int d0 = d0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (d0 == 0) {
            return null;
        }
        T t = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + d0);
        return t;
    }

    public static void s0(Context context, Intent intent) {
        String str;
        int i2;
        Context context2 = context;
        Intent intent2 = intent;
        if (U(context)) {
            String stringExtra = intent2.getStringExtra("EXTRA_KEY_PLAYLIST_TYPE");
            intent2.getIntExtra("EXTRA_KEY_PLAYER_STATUS_CODE", -1);
            intent2.getIntExtra("EXTRA_KEY_INFO_CURRENT_TRACK", -1);
            int intExtra = intent2.getIntExtra("EXTRA_KEY_INFO_CURRENT_POSITION", -1);
            boolean booleanExtra = intent2.getBooleanExtra("EXTRA_KEY_INFO_IS_PLAYING", false);
            int intExtra2 = intent2.getIntExtra("EXTRA_KEY_INFO_TRACK_DURATION", -1);
            Intent intent3 = new Intent(context2, BuddyPlayerActivity.class);
            intent3.putExtra("KEY_INTENT_PLAYER_SECTION", stringExtra);
            PendingIntent activity = PendingIntent.getActivity(context2, 0, intent3, 134217728);
            Intent intent4 = new Intent(context2, PlayerNotifyService.class);
            intent4.putExtra("EXTRA_PLAYER_NOTIFY_OPTION", 5);
            PendingIntent service = PendingIntent.getService(context2, 1, intent4, 134217728);
            Intent intent5 = new Intent(context2, PlayerNotifyService.class);
            intent5.putExtra("EXTRA_PLAYER_NOTIFY_OPTION", 0);
            PendingIntent service2 = PendingIntent.getService(context2, 2, intent5, 134217728);
            Intent intent6 = new Intent(context2, PlayerNotifyService.class);
            intent6.putExtra("EXTRA_PLAYER_NOTIFY_OPTION", 3);
            PendingIntent.getService(context2, 3, intent6, 134217728);
            Intent intent7 = new Intent(context2, PlayerNotifyService.class);
            intent7.putExtra("EXTRA_PLAYER_NOTIFY_OPTION", 4);
            PendingIntent service3 = PendingIntent.getService(context2, 4, intent7, 134217728);
            NotificationCompat.Builder contentIntent = new NotificationCompat.Builder(context2, "CHANNEL_ID").setSmallIcon(R.mipmap.ic_launcher).setContentTitle(context2.getString(R.string.app_name)).setContentIntent(activity);
            if (Build.MANUFACTURER.equals("HUAWEI")) {
                if (booleanExtra) {
                    i2 = R.drawable.ic_action_pause;
                    str = a.c.a.d.a.h(R.string.TR_PAUSE);
                } else {
                    i2 = R.drawable.ic_action_play;
                    str = a.c.a.d.a.h(R.string.TR_PLAY);
                }
                contentIntent.addAction(i2, str, service2);
                contentIntent.addAction(R.drawable.ic_action_stop, a.c.a.d.a.h(R.string.TR_STOP), service);
                contentIntent.addAction(R.drawable.ic_action_next, a.c.a.d.a.h(R.string.TR_NEXT), service3);
            } else {
                contentIntent.addAction(0, booleanExtra ? a.c.a.d.a.h(R.string.TR_PAUSE) : a.c.a.d.a.h(R.string.TR_PLAY), service2);
                contentIntent.addAction(0, a.c.a.d.a.h(R.string.TR_STOP), service);
                contentIntent.addAction(0, a.c.a.d.a.h(R.string.TR_NEXT), service3);
            }
            contentIntent.setProgress(intExtra2, intExtra, false);
            NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
            bigTextStyle.setBigContentTitle(j.b().e(stringExtra));
            contentIntent.setContentTitle(j.b().e(stringExtra));
            contentIntent.setContentText(a.c.a.d.a.g(intent2.getStringExtra("EXTRA_KEY_INFO_CURRENT_SONG_NAME")));
            bigTextStyle.bigText(a.c.a.d.a.g(intent2.getStringExtra("EXTRA_KEY_INFO_CURRENT_SONG_NAME")));
            bigTextStyle.setSummaryText(a.c.a.d.a.e(intExtra) + " - " + a.c.a.d.a.e(intExtra2));
            contentIntent.setStyle(bigTextStyle);
            contentIntent.setPriority(2);
            contentIntent.setOngoing(true);
            Notification build = contentIntent.build();
            NotificationManager notificationManager = (NotificationManager) context2.getSystemService("notification");
            a.c.a.d.a.o(notificationManager);
            notificationManager.notify(480480, build);
            return;
        }
        ((NotificationManager) context2.getSystemService("notification")).cancel(480480);
    }

    public static long s1(byte[] bArr, int i2) {
        return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
    }

    public static String t(Parcel parcel, int i2) {
        int d0 = d0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (d0 == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + d0);
        return readString;
    }

    public static void t0(Context context, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        String h2 = a.c.a.d.a.h(R.string.TR_TIP);
        a.c.d.j.b.f.b bVar = new a.c.d.j.b.f.b(onClickListener);
        AlertDialog.Builder builder = new AlertDialog.Builder(context, 2131886312);
        builder.setNegativeButton((CharSequence) a.c.a.d.a.h(R.string.TR_CANCEL), (DialogInterface.OnClickListener) bVar);
        builder.setPositiveButton((CharSequence) a.c.a.d.a.h(R.string.TR_CONFIRM), (DialogInterface.OnClickListener) bVar);
        builder.setTitle((CharSequence) h2);
        builder.setMessage(charSequence);
        builder.setCancelable(false);
        builder.create().show();
    }

    public static <TResult> TResult t1(p<TResult> pVar) {
        Exception exc;
        if (pVar.c()) {
            return pVar.a();
        }
        synchronized (pVar.f2708a) {
            exc = pVar.f2712e;
        }
        throw new ExecutionException(exc);
    }

    public static ArrayList<String> u(Parcel parcel, int i2) {
        int d0 = d0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (d0 == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + d0);
        return createStringArrayList;
    }

    public static String u0(long j) {
        float f2 = (float) j;
        if (f2 > 1048576.0f) {
            return String.format("%.02fMB", new Object[]{Float.valueOf(f2 / 1048576.0f)});
        }
        Object[] objArr = new Object[1];
        if (f2 > 1024.0f) {
            objArr[0] = Float.valueOf(f2 / 1024.0f);
            return String.format("%.02fKB", objArr);
        }
        objArr[0] = Float.valueOf(f2);
        return String.format("%.02fbytes", objArr);
    }

    public static void u1(Parcel parcel, int i2) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i2 - 4);
        parcel.writeInt(dataPosition - i2);
        parcel.setDataPosition(dataPosition);
    }

    public static <T> T[] v(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int d0 = d0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (d0 == 0) {
            return null;
        }
        T[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + d0);
        return createTypedArray;
    }

    public static void v0(Parcel parcel, int i2) {
        parcel.setDataPosition(parcel.dataPosition() + d0(parcel, i2));
    }

    public static void v1(Parcel parcel, int i2, int i3) {
        if (i3 >= 65535) {
            parcel.writeInt(i2 | SupportMenu.CATEGORY_MASK);
            parcel.writeInt(i3);
            return;
        }
        parcel.writeInt(i2 | (i3 << 16));
    }

    public static <T> ArrayList<T> w(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int d0 = d0(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (d0 == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + d0);
        return createTypedArrayList;
    }

    public static void w0(Activity activity, Intent intent, int i2, boolean z) {
        if (activity != null) {
            activity.startActivity(intent);
            if (z) {
                activity.finish();
            }
            Y(activity, i2);
        }
    }

    public static double w1(byte[] bArr, int i2) {
        return Double.longBitsToDouble(s1(bArr, i2));
    }

    public static androidx.appcompat.app.AlertDialog x(Context context, String str, CharSequence charSequence, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, 2131886312);
        if (!TextUtils.isEmpty(str2)) {
            builder.setPositiveButton((CharSequence) str2, onClickListener);
        }
        if (!TextUtils.isEmpty(str3)) {
            builder.setNegativeButton((CharSequence) str3, onClickListener);
        }
        if (!TextUtils.isEmpty((CharSequence) null)) {
            builder.setNeutralButton((CharSequence) null, onClickListener);
        }
        if (!TextUtils.isEmpty(str)) {
            builder.setTitle((CharSequence) str);
        }
        builder.setMessage(charSequence);
        return builder.create();
    }

    public static final void x0(Context context) {
        if (U(context)) {
            context.stopService(new Intent(context, PlayerService.class));
        }
    }

    public static int x1(byte[] bArr, int i2, v4 v4Var) {
        int U0 = U0(bArr, i2, v4Var);
        int i3 = v4Var.f1981a;
        if (i3 < 0) {
            throw i6.b();
        } else if (i3 == 0) {
            v4Var.f1983c = "";
            return U0;
        } else {
            v4Var.f1983c = new String(bArr, U0, i3, a6.f1596a);
            return U0 + i3;
        }
    }

    @Nullable
    public static String y() {
        try {
            return KotlinVersion.CURRENT.toString();
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }

    public static o y0(Object obj) {
        return new o(obj, (r0) null);
    }

    public static float y1(byte[] bArr, int i2) {
        return Float.intBitsToFloat(T0(bArr, i2));
    }

    public static void z(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        while (th != null) {
            th.printStackTrace(printWriter);
            th = th.getCause();
        }
        String obj = stringWriter.toString();
        printWriter.close();
        Log.e("miio-bluetooth", obj);
    }

    @TargetApi(19)
    public static boolean z0(Context context, int i2, String str) {
        a.d.a.a.e.r.b a2 = a.d.a.a.e.r.c.a(context);
        if (a2 != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                try {
                    ((AppOpsManager) a2.f1443a.getSystemService("appops")).checkPackage(i2, str);
                } catch (SecurityException unused) {
                    return false;
                }
            } else {
                String[] packagesForUid = a2.f1443a.getPackageManager().getPackagesForUid(i2);
                if (str == null || packagesForUid == null) {
                    return false;
                }
                int i3 = 0;
                while (i3 < packagesForUid.length) {
                    if (!str.equals(packagesForUid[i3])) {
                        i3++;
                    }
                }
                return false;
            }
            return true;
        }
        throw null;
    }

    public static int z1(byte[] bArr, int i2, v4 v4Var) {
        int U0 = U0(bArr, i2, v4Var);
        int i3 = v4Var.f1981a;
        if (i3 < 0) {
            throw i6.b();
        } else if (i3 == 0) {
            v4Var.f1983c = "";
            return U0;
        } else {
            v4Var.f1983c = q8.f1900a.c(bArr, U0, i3);
            return U0 + i3;
        }
    }
}
