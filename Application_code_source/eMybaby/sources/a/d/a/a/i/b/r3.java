package a.d.a.a.i.b;

import a.d.a.a.h.g.a;
import a.d.a.a.h.g.u;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.measurement.internal.zzar;
import com.google.android.gms.measurement.internal.zzkw;
import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzw;
import java.util.ArrayList;
import java.util.List;

public final class r3 extends a implements p3 {
    public r3(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final void A(zzar zzar, zzn zzn) {
        Parcel e2 = e();
        u.c(e2, zzar);
        u.c(e2, zzn);
        h(1, e2);
    }

    public final String G(zzn zzn) {
        Parcel e2 = e();
        u.c(e2, zzn);
        Parcel g = g(11, e2);
        String readString = g.readString();
        g.recycle();
        return readString;
    }

    public final void H(Bundle bundle, zzn zzn) {
        Parcel e2 = e();
        u.c(e2, bundle);
        u.c(e2, zzn);
        h(19, e2);
    }

    public final void N(long j, String str, String str2, String str3) {
        Parcel e2 = e();
        e2.writeLong(j);
        e2.writeString(str);
        e2.writeString(str2);
        e2.writeString(str3);
        h(10, e2);
    }

    public final void P(zzn zzn) {
        Parcel e2 = e();
        u.c(e2, zzn);
        h(18, e2);
    }

    public final List<zzw> Q(String str, String str2, String str3) {
        Parcel e2 = e();
        e2.writeString(str);
        e2.writeString(str2);
        e2.writeString(str3);
        Parcel g = g(17, e2);
        ArrayList<zzw> createTypedArrayList = g.createTypedArrayList(zzw.CREATOR);
        g.recycle();
        return createTypedArrayList;
    }

    public final void R(zzar zzar, String str, String str2) {
        Parcel e2 = e();
        u.c(e2, zzar);
        e2.writeString(str);
        e2.writeString(str2);
        h(5, e2);
    }

    public final List<zzw> S(String str, String str2, zzn zzn) {
        Parcel e2 = e();
        e2.writeString(str);
        e2.writeString(str2);
        u.c(e2, zzn);
        Parcel g = g(16, e2);
        ArrayList<zzw> createTypedArrayList = g.createTypedArrayList(zzw.CREATOR);
        g.recycle();
        return createTypedArrayList;
    }

    public final List<zzkw> j(String str, String str2, boolean z, zzn zzn) {
        Parcel e2 = e();
        e2.writeString(str);
        e2.writeString(str2);
        u.d(e2, z);
        u.c(e2, zzn);
        Parcel g = g(14, e2);
        ArrayList<zzkw> createTypedArrayList = g.createTypedArrayList(zzkw.CREATOR);
        g.recycle();
        return createTypedArrayList;
    }

    public final List<zzkw> k(zzn zzn, boolean z) {
        Parcel e2 = e();
        u.c(e2, zzn);
        e2.writeInt(z ? 1 : 0);
        Parcel g = g(7, e2);
        ArrayList<zzkw> createTypedArrayList = g.createTypedArrayList(zzkw.CREATOR);
        g.recycle();
        return createTypedArrayList;
    }

    public final void l(zzw zzw, zzn zzn) {
        Parcel e2 = e();
        u.c(e2, zzw);
        u.c(e2, zzn);
        h(12, e2);
    }

    public final void m(zzn zzn) {
        Parcel e2 = e();
        u.c(e2, zzn);
        h(4, e2);
    }

    public final void n(zzn zzn) {
        Parcel e2 = e();
        u.c(e2, zzn);
        h(20, e2);
    }

    public final void r(zzw zzw) {
        Parcel e2 = e();
        u.c(e2, zzw);
        h(13, e2);
    }

    public final void u(zzkw zzkw, zzn zzn) {
        Parcel e2 = e();
        u.c(e2, zzkw);
        u.c(e2, zzn);
        h(2, e2);
    }

    public final void w(zzn zzn) {
        Parcel e2 = e();
        u.c(e2, zzn);
        h(6, e2);
    }

    public final List<zzkw> y(String str, String str2, String str3, boolean z) {
        Parcel e2 = e();
        e2.writeString(str);
        e2.writeString(str2);
        e2.writeString(str3);
        u.d(e2, z);
        Parcel g = g(15, e2);
        ArrayList<zzkw> createTypedArrayList = g.createTypedArrayList(zzkw.CREATOR);
        g.recycle();
        return createTypedArrayList;
    }

    public final byte[] z(zzar zzar, String str) {
        Parcel e2 = e();
        u.c(e2, zzar);
        e2.writeString(str);
        Parcel g = g(9, e2);
        byte[] createByteArray = g.createByteArray();
        g.recycle();
        return createByteArray;
    }
}
