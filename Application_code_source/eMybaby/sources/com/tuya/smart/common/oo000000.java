package com.tuya.smart.common;

import com.tuya.sdk.eventbus.ThreadMode;
import java.lang.reflect.Method;

public final class oo000000 {
    public final Method O000000o;
    public final ThreadMode O00000Oo;
    public String O00000o;
    public final Class<?> O00000o0;

    public oo000000(Method method, ThreadMode threadMode, Class<?> cls) {
        this.O000000o = method;
        this.O00000Oo = threadMode;
        this.O00000o0 = cls;
    }

    private synchronized void O000000o() {
        if (this.O00000o == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.O000000o.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.O000000o.getName());
            sb.append('(');
            sb.append(this.O00000o0.getName());
            this.O00000o = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof oo000000)) {
            return false;
        }
        O000000o();
        oo000000 oo000000 = (oo000000) obj;
        oo000000.O000000o();
        return this.O00000o.equals(oo000000.O00000o);
    }

    public int hashCode() {
        return this.O000000o.hashCode();
    }
}
