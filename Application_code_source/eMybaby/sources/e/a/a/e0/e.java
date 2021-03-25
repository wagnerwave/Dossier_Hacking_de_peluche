package e.a.a.e0;

import a.a.a.a.a;
import java.util.Locale;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f4897a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4898b;

    /* renamed from: c  reason: collision with root package name */
    public final String f4899c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f4900d;

    public e(String str, int i, String str2, boolean z) {
        if (str == null) {
            throw new IllegalArgumentException("Host of origin may not be null");
        } else if (str.trim().length() == 0) {
            throw new IllegalArgumentException("Host of origin may not be blank");
        } else if (i < 0) {
            throw new IllegalArgumentException(a.h("Invalid port: ", i));
        } else if (str2 != null) {
            this.f4897a = str.toLowerCase(Locale.ENGLISH);
            this.f4898b = i;
            if (str2.trim().length() != 0) {
                this.f4899c = str2;
            } else {
                this.f4899c = "/";
            }
            this.f4900d = z;
        } else {
            throw new IllegalArgumentException("Path of origin may not be null.");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        if (this.f4900d) {
            sb.append("(secure)");
        }
        sb.append(this.f4897a);
        sb.append(':');
        sb.append(Integer.toString(this.f4898b));
        sb.append(this.f4899c);
        sb.append(']');
        return sb.toString();
    }
}
