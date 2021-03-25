package a.d.a.a.e;

import java.lang.ref.WeakReference;

public abstract class x extends v {

    /* renamed from: c  reason: collision with root package name */
    public static final WeakReference<byte[]> f1453c = new WeakReference<>((Object) null);

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<byte[]> f1454b = f1453c;

    public x(byte[] bArr) {
        super(bArr);
    }

    public abstract byte[] V();

    public final byte[] g() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.f1454b.get();
            if (bArr == null) {
                bArr = V();
                this.f1454b = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }
}
