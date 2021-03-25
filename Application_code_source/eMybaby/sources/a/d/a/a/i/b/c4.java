package a.d.a.a.i.b;

import a.a.a.a.a;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.measurement.internal.zzam;
import com.google.android.gms.measurement.internal.zzar;

public final class c4 {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public String f2119a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public String f2120b;

    /* renamed from: c  reason: collision with root package name */
    public long f2121c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public Bundle f2122d;

    public c4(@NonNull String str, @NonNull String str2, @Nullable Bundle bundle, long j) {
        this.f2119a = str;
        this.f2120b = str2;
        this.f2122d = bundle;
        this.f2121c = j;
    }

    public static c4 b(zzar zzar) {
        return new c4(zzar.f4276a, zzar.f4278c, zzar.f4277b.h(), zzar.f4279d);
    }

    public final zzar a() {
        return new zzar(this.f2119a, new zzam(new Bundle(this.f2122d)), this.f2120b, this.f2121c);
    }

    public final String toString() {
        String str = this.f2120b;
        String str2 = this.f2119a;
        String valueOf = String.valueOf(this.f2122d);
        StringBuilder sb = new StringBuilder(valueOf.length() + String.valueOf(str2).length() + String.valueOf(str).length() + 21);
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        return a.m(sb, ",params=", valueOf);
    }
}
