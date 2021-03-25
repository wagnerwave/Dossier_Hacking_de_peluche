package com.google.android.gms.common.api;

import a.c.a.f.b;
import a.d.a.a.e.k.i;
import a.d.a.a.e.k.n;
import a.d.a.a.e.m.o;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.tuya.smart.android.network.http.BusinessResponse;
import java.util.Arrays;

public final class Status extends AbstractSafeParcelable implements i, ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new n();

    /* renamed from: e  reason: collision with root package name */
    public static final Status f4205e = new Status(0);
    public static final Status f = new Status(14);
    public static final Status g = new Status(8);
    public static final Status h = new Status(15);
    public static final Status i = new Status(16);

    /* renamed from: a  reason: collision with root package name */
    public final int f4206a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4207b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final String f4208c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final PendingIntent f4209d;

    public Status(int i2) {
        this(1, i2, (String) null, (PendingIntent) null);
    }

    public Status(int i2, int i3, @Nullable String str, @Nullable PendingIntent pendingIntent) {
        this.f4206a = i2;
        this.f4207b = i3;
        this.f4208c = str;
        this.f4209d = pendingIntent;
    }

    public Status(int i2, @Nullable String str) {
        this(1, i2, str, (PendingIntent) null);
    }

    public final boolean e() {
        return this.f4207b <= 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f4206a == status.f4206a && this.f4207b == status.f4207b && b.B(this.f4208c, status.f4208c) && b.B(this.f4209d, status.f4209d);
    }

    public final Status getStatus() {
        return this;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f4206a), Integer.valueOf(this.f4207b), this.f4208c, this.f4209d});
    }

    public final String toString() {
        o y0 = b.y0(this);
        String str = this.f4208c;
        if (str == null) {
            int i2 = this.f4207b;
            switch (i2) {
                case -1:
                    str = "SUCCESS_CACHE";
                    break;
                case 0:
                    str = BusinessResponse.RESULT_SUCCESS;
                    break;
                case 2:
                    str = "SERVICE_VERSION_UPDATE_REQUIRED";
                    break;
                case 3:
                    str = "SERVICE_DISABLED";
                    break;
                case 4:
                    str = "SIGN_IN_REQUIRED";
                    break;
                case 5:
                    str = "INVALID_ACCOUNT";
                    break;
                case 6:
                    str = "RESOLUTION_REQUIRED";
                    break;
                case 7:
                    str = "NETWORK_ERROR";
                    break;
                case 8:
                    str = "INTERNAL_ERROR";
                    break;
                case 10:
                    str = "DEVELOPER_ERROR";
                    break;
                case 13:
                    str = "ERROR";
                    break;
                case 14:
                    str = "INTERRUPTED";
                    break;
                case 15:
                    str = BusinessResponse.RESULT_TIMEOUT;
                    break;
                case 16:
                    str = "CANCELED";
                    break;
                case 17:
                    str = "API_NOT_CONNECTED";
                    break;
                case 18:
                    str = "DEAD_CLIENT";
                    break;
                default:
                    StringBuilder sb = new StringBuilder(32);
                    sb.append("unknown status code: ");
                    sb.append(i2);
                    str = sb.toString();
                    break;
            }
        }
        y0.a("statusCode", str);
        y0.a("resolution", this.f4209d);
        return y0.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int b2 = b.b(parcel);
        b.E0(parcel, 1, this.f4207b);
        b.H0(parcel, 2, this.f4208c, false);
        b.G0(parcel, 3, this.f4209d, i2, false);
        b.E0(parcel, 1000, this.f4206a);
        b.u1(parcel, b2);
    }
}
