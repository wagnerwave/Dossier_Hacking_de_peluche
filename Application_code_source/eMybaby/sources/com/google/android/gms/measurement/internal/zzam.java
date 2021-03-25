package com.google.android.gms.measurement.internal;

import a.c.a.f.b;
import a.d.a.a.i.b.m;
import a.d.a.a.i.b.n;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Iterator;

public final class zzam extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzam> CREATOR = new m();

    /* renamed from: a  reason: collision with root package name */
    public final Bundle f4275a;

    public zzam(Bundle bundle) {
        this.f4275a = bundle;
    }

    public final Object e(String str) {
        return this.f4275a.get(str);
    }

    public final Bundle h() {
        return new Bundle(this.f4275a);
    }

    public final Iterator<String> iterator() {
        return new n(this);
    }

    public final Long l(String str) {
        return Long.valueOf(this.f4275a.getLong(str));
    }

    public final Double m(String str) {
        return Double.valueOf(this.f4275a.getDouble(str));
    }

    public final String n(String str) {
        return this.f4275a.getString(str);
    }

    public final String toString() {
        return this.f4275a.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int b2 = b.b(parcel);
        b.C0(parcel, 2, h(), false);
        b.u1(parcel, b2);
    }
}
