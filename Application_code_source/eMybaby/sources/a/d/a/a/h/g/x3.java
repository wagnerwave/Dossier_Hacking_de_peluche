package a.d.a.a.h.g;

import a.c.a.d.a;
import com.tutk.IOTC.AVFrame;
import com.tuya.smart.common.o0ooo00oo;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class x3<K, V> extends r3<K, V> {
    public static final r3<Object, Object> g = new x3((Object) null, new Object[0], 0);

    /* renamed from: d  reason: collision with root package name */
    public final transient Object f2023d;

    /* renamed from: e  reason: collision with root package name */
    public final transient Object[] f2024e;
    public final transient int f;

    public x3(Object obj, Object[] objArr, int i) {
        this.f2023d = obj;
        this.f2024e = objArr;
        this.f = i;
    }

    public static IllegalArgumentException a(Object obj, Object obj2, Object[] objArr, int i) {
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        String valueOf3 = String.valueOf(objArr[i]);
        String valueOf4 = String.valueOf(objArr[i ^ 1]);
        StringBuilder sb = new StringBuilder(valueOf4.length() + valueOf3.length() + valueOf2.length() + valueOf.length() + 39);
        sb.append("Multiple entries with same key: ");
        sb.append(valueOf);
        sb.append(o0ooo00oo.O0000Oo0);
        sb.append(valueOf2);
        sb.append(" and ");
        sb.append(valueOf3);
        sb.append(o0ooo00oo.O0000Oo0);
        sb.append(valueOf4);
        return new IllegalArgumentException(sb.toString());
    }

    @NullableDecl
    public final V get(@NullableDecl Object obj) {
        Object obj2 = this.f2023d;
        V[] vArr = this.f2024e;
        int i = this.f;
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (vArr[0].equals(obj)) {
                return vArr[1];
            }
            return null;
        } else if (obj2 == null) {
            return null;
        } else {
            if (obj2 instanceof byte[]) {
                byte[] bArr = (byte[]) obj2;
                int length = bArr.length - 1;
                int r = a.r(obj.hashCode());
                while (true) {
                    int i2 = r & length;
                    byte b2 = bArr[i2] & AVFrame.FRM_STATE_UNKOWN;
                    if (b2 == 255) {
                        return null;
                    }
                    if (vArr[b2].equals(obj)) {
                        return vArr[b2 ^ 1];
                    }
                    r = i2 + 1;
                }
            } else if (obj2 instanceof short[]) {
                short[] sArr = (short[]) obj2;
                int length2 = sArr.length - 1;
                int r2 = a.r(obj.hashCode());
                while (true) {
                    int i3 = r2 & length2;
                    short s = sArr[i3] & 65535;
                    if (s == 65535) {
                        return null;
                    }
                    if (vArr[s].equals(obj)) {
                        return vArr[s ^ 1];
                    }
                    r2 = i3 + 1;
                }
            } else {
                int[] iArr = (int[]) obj2;
                int length3 = iArr.length - 1;
                int r3 = a.r(obj.hashCode());
                while (true) {
                    int i4 = r3 & length3;
                    int i5 = iArr[i4];
                    if (i5 == -1) {
                        return null;
                    }
                    if (vArr[i5].equals(obj)) {
                        return vArr[i5 ^ 1];
                    }
                    r3 = i4 + 1;
                }
            }
        }
    }

    public final int size() {
        return this.f;
    }
}
