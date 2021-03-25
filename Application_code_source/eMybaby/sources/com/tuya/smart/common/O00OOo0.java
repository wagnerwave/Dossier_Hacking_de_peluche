package com.tuya.smart.common;

import java.util.HashMap;

public class O00OOo0 {
    public static volatile O00OOo0 O000000o;
    public HashMap<String, o0oo00o00o> O00000Oo = new HashMap<>(10);

    public static O00OOo0 O000000o() {
        if (O000000o == null) {
            synchronized (O00OOo0.class) {
                O000000o = new O00OOo0();
            }
        }
        return O000000o;
    }

    public o0oo00o00o O000000o(String str) {
        return this.O00000Oo.get(str);
    }

    public void O000000o(String str, o0oo00o00o o0oo00o00o) {
        this.O00000Oo.put(str, o0oo00o00o);
    }

    public void O00000Oo() {
        this.O00000Oo.clear();
        O000000o = null;
    }
}
