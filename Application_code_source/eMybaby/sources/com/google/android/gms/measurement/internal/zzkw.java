package com.google.android.gms.measurement.internal;

import a.c.a.f.b;
import a.d.a.a.i.b.u9;
import a.d.a.a.i.b.w9;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class zzkw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzkw> CREATOR = new u9();

    /* renamed from: a  reason: collision with root package name */
    public final int f4280a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4281b;

    /* renamed from: c  reason: collision with root package name */
    public final long f4282c;

    /* renamed from: d  reason: collision with root package name */
    public final Long f4283d;

    /* renamed from: e  reason: collision with root package name */
    public final String f4284e;
    public final String f;
    public final Double g;

    public zzkw(int i, String str, long j, Long l, Float f2, String str2, String str3, Double d2) {
        this.f4280a = i;
        this.f4281b = str;
        this.f4282c = j;
        this.f4283d = l;
        if (i == 1) {
            this.g = f2 != null ? Double.valueOf(f2.doubleValue()) : null;
        } else {
            this.g = d2;
        }
        this.f4284e = str2;
        this.f = str3;
    }

    public zzkw(w9 w9Var) {
        this(w9Var.f2608c, w9Var.f2609d, w9Var.f2610e, w9Var.f2607b);
    }

    public zzkw(String str, long j, Object obj, String str2) {
        b.h(str);
        this.f4280a = 2;
        this.f4281b = str;
        this.f4282c = j;
        this.f = str2;
        if (obj == null) {
            this.f4283d = null;
            this.g = null;
            this.f4284e = null;
        } else if (obj instanceof Long) {
            this.f4283d = (Long) obj;
            this.g = null;
            this.f4284e = null;
        } else if (obj instanceof String) {
            this.f4283d = null;
            this.g = null;
            this.f4284e = (String) obj;
        } else if (obj instanceof Double) {
            this.f4283d = null;
            this.g = (Double) obj;
            this.f4284e = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    public final Object e() {
        Long l = this.f4283d;
        if (l != null) {
            return l;
        }
        Double d2 = this.g;
        if (d2 != null) {
            return d2;
        }
        String str = this.f4284e;
        if (str != null) {
            return str;
        }
        return null;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int b2 = b.b(parcel);
        b.E0(parcel, 1, this.f4280a);
        b.H0(parcel, 2, this.f4281b, false);
        b.F0(parcel, 3, this.f4282c);
        Long l = this.f4283d;
        if (l != null) {
            b.v1(parcel, 4, 8);
            parcel.writeLong(l.longValue());
        }
        b.H0(parcel, 6, this.f4284e, false);
        b.H0(parcel, 7, this.f, false);
        Double d2 = this.g;
        if (d2 != null) {
            b.v1(parcel, 8, 8);
            parcel.writeDouble(d2.doubleValue());
        }
        b.u1(parcel, b2);
    }
}
