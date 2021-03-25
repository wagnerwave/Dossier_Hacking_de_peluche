package a.d.a.a.e;

import androidx.annotation.NonNull;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
public class c0 {

    /* renamed from: d  reason: collision with root package name */
    public static final c0 f1234d = new c0(true, (String) null, (Throwable) null);

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1235a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1236b;

    /* renamed from: c  reason: collision with root package name */
    public final Throwable f1237c;

    public c0(boolean z, @Nullable String str, @Nullable Throwable th) {
        this.f1235a = z;
        this.f1236b = str;
        this.f1237c = th;
    }

    public static c0 b(@NonNull String str) {
        return new c0(false, str, (Throwable) null);
    }

    @Nullable
    public String a() {
        return this.f1236b;
    }
}
