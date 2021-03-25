package a.d.a.a.e.m;

import a.c.a.f.b;

public final class h {
    public h(String str) {
        b.l(str, "log tag cannot be null");
        Object[] objArr = {str, 23};
        if (!(str.length() <= 23)) {
            throw new IllegalArgumentException(String.format("tag \"%s\" is longer than the %d character maximum", objArr));
        }
    }
}
