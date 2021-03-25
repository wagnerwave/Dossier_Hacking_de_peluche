package okhttp3;

import a.a.a.a.a;
import okhttp3.internal.Util;

public final class Challenge {
    public final String realm;
    public final String scheme;

    public Challenge(String str, String str2) {
        this.scheme = str;
        this.realm = str2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Challenge) {
            Challenge challenge = (Challenge) obj;
            return Util.equal(this.scheme, challenge.scheme) && Util.equal(this.realm, challenge.realm);
        }
    }

    public int hashCode() {
        String str = this.realm;
        int i = 0;
        int hashCode = (899 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.scheme;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String realm() {
        return this.realm;
    }

    public String scheme() {
        return this.scheme;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.scheme);
        sb.append(" realm=\"");
        return a.m(sb, this.realm, "\"");
    }
}
