package com.google.android.gms.common;

import a.c.a.f.b;
import a.d.a.a.e.m.o;
import a.d.a.a.e.t;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new t();

    /* renamed from: a  reason: collision with root package name */
    public final String f4195a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public final int f4196b;

    /* renamed from: c  reason: collision with root package name */
    public final long f4197c;

    public Feature(String str, int i, long j) {
        this.f4195a = str;
        this.f4196b = i;
        this.f4197c = j;
    }

    public long e() {
        long j = this.f4197c;
        return j == -1 ? (long) this.f4196b : j;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            String str = this.f4195a;
            if (((str == null || !str.equals(feature.f4195a)) && (this.f4195a != null || feature.f4195a != null)) || e() != feature.e()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4195a, Long.valueOf(e())});
    }

    public String toString() {
        o y0 = b.y0(this);
        y0.a("name", this.f4195a);
        y0.a("version", Long.valueOf(e()));
        return y0.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int b2 = b.b(parcel);
        b.H0(parcel, 1, this.f4195a, false);
        b.E0(parcel, 2, this.f4196b);
        b.F0(parcel, 3, e());
        b.u1(parcel, b2);
    }
}
