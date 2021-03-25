package e.a.a.g0.f;

import a.e.a.a.r.b;
import java.security.SecureRandom;

public final class g implements f {

    /* renamed from: a  reason: collision with root package name */
    public static final SecureRandom f4952a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f4953b;

    static {
        SecureRandom secureRandom;
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
        } catch (Exception unused) {
            secureRandom = null;
        }
        f4952a = secureRandom;
        byte[] r = b.r("NTLMSSP", "ASCII");
        byte[] bArr = new byte[(r.length + 1)];
        f4953b = bArr;
        System.arraycopy(r, 0, bArr, 0, r.length);
        f4953b[r.length] = 0;
    }
}
