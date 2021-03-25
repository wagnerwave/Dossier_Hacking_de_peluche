package com.google.android.gms.common.api;

import a.c.a.f.b;
import a.d.a.a.e.k.m;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new m();

    /* renamed from: a  reason: collision with root package name */
    public final int f4203a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4204b;

    public Scope(int i, String str) {
        b.i(str, "scopeUri must not be null or empty");
        this.f4203a = i;
        this.f4204b = str;
    }

    public Scope(String str) {
        b.i(str, "scopeUri must not be null or empty");
        this.f4203a = 1;
        this.f4204b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f4204b.equals(((Scope) obj).f4204b);
    }

    public final int hashCode() {
        return this.f4204b.hashCode();
    }

    public final String toString() {
        return this.f4204b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int b2 = b.b(parcel);
        b.E0(parcel, 1, this.f4203a);
        b.H0(parcel, 2, this.f4204b, false);
        b.u1(parcel, b2);
    }
}
