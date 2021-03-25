package com.google.android.gms.common;

import a.c.a.f.b;
import a.d.a.a.e.m.o;
import a.d.a.a.e.s;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.tuya.smart.android.network.http.BusinessResponse;
import java.util.Arrays;

public final class ConnectionResult extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new s();

    /* renamed from: e  reason: collision with root package name */
    public static final ConnectionResult f4190e = new ConnectionResult(0);

    /* renamed from: a  reason: collision with root package name */
    public final int f4191a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4192b;

    /* renamed from: c  reason: collision with root package name */
    public final PendingIntent f4193c;

    /* renamed from: d  reason: collision with root package name */
    public final String f4194d;

    public ConnectionResult(int i) {
        this.f4191a = 1;
        this.f4192b = i;
        this.f4193c = null;
        this.f4194d = null;
    }

    public ConnectionResult(int i, int i2, PendingIntent pendingIntent, String str) {
        this.f4191a = i;
        this.f4192b = i2;
        this.f4193c = pendingIntent;
        this.f4194d = str;
    }

    public static String l(int i) {
        if (i == 99) {
            return "UNFINISHED";
        }
        if (i == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i) {
            case -1:
                return BusinessResponse.RESULT_UNKNOWN;
            case 0:
                return BusinessResponse.RESULT_SUCCESS;
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return BusinessResponse.RESULT_TIMEOUT;
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    default:
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("UNKNOWN_ERROR_CODE(");
                        sb.append(i);
                        sb.append(")");
                        return sb.toString();
                }
        }
    }

    public final boolean e() {
        return (this.f4192b == 0 || this.f4193c == null) ? false : true;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f4192b == connectionResult.f4192b && b.B(this.f4193c, connectionResult.f4193c) && b.B(this.f4194d, connectionResult.f4194d);
    }

    public final boolean h() {
        return this.f4192b == 0;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f4192b), this.f4193c, this.f4194d});
    }

    public final String toString() {
        o y0 = b.y0(this);
        y0.a("statusCode", l(this.f4192b));
        y0.a("resolution", this.f4193c);
        y0.a("message", this.f4194d);
        return y0.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int b2 = b.b(parcel);
        b.E0(parcel, 1, this.f4191a);
        b.E0(parcel, 2, this.f4192b);
        b.G0(parcel, 3, this.f4193c, i, false);
        b.H0(parcel, 4, this.f4194d, false);
        b.u1(parcel, b2);
    }

    public ConnectionResult(int i, @Nullable PendingIntent pendingIntent) {
        this.f4191a = 1;
        this.f4192b = i;
        this.f4193c = pendingIntent;
        this.f4194d = null;
    }

    public ConnectionResult(int i, @Nullable PendingIntent pendingIntent, String str) {
        this.f4191a = 1;
        this.f4192b = i;
        this.f4193c = null;
        this.f4194d = str;
    }
}
