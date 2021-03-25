package e.a.a.g0.i;

import e.a.a.e0.a;
import e.a.a.e0.m;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class c implements m, a, Cloneable, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final String f5059a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f5060b;

    /* renamed from: c  reason: collision with root package name */
    public String f5061c;

    /* renamed from: d  reason: collision with root package name */
    public String f5062d;

    /* renamed from: e  reason: collision with root package name */
    public Date f5063e;
    public String f;
    public boolean g;
    public int h;

    public c(String str, String str2) {
        if (str != null) {
            this.f5059a = str;
            this.f5060b = new HashMap();
            this.f5061c = str2;
            return;
        }
        throw new IllegalArgumentException("Name may not be null");
    }

    public String b(String str) {
        return this.f5060b.get(str);
    }

    public boolean c() {
        return this.g;
    }

    public Object clone() {
        c cVar = (c) super.clone();
        cVar.f5060b = new HashMap(this.f5060b);
        return cVar;
    }

    public int d() {
        return this.h;
    }

    public boolean e(String str) {
        return this.f5060b.get(str) != null;
    }

    public boolean f(Date date) {
        if (date != null) {
            Date date2 = this.f5063e;
            return date2 != null && date2.getTime() <= date.getTime();
        }
        throw new IllegalArgumentException("Date may not be null");
    }

    public String g() {
        return this.f;
    }

    public String getName() {
        return this.f5059a;
    }

    public String getValue() {
        return this.f5061c;
    }

    public String h() {
        return this.f5062d;
    }

    public int[] j() {
        return null;
    }

    public void m(String str) {
        this.f5062d = str != null ? str.toLowerCase(Locale.ENGLISH) : null;
    }

    public String toString() {
        StringBuilder n = a.a.a.a.a.n("[version: ");
        n.append(Integer.toString(this.h));
        n.append("]");
        n.append("[name: ");
        n.append(this.f5059a);
        n.append("]");
        n.append("[value: ");
        n.append(this.f5061c);
        n.append("]");
        n.append("[domain: ");
        n.append(this.f5062d);
        n.append("]");
        n.append("[path: ");
        n.append(this.f);
        n.append("]");
        n.append("[expiry: ");
        n.append(this.f5063e);
        n.append("]");
        return n.toString();
    }
}
