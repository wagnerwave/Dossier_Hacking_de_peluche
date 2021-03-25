package com.tuya.smart.common;

import java.util.ArrayList;
import java.util.List;

public final class oOOO0o00 {
    public static final List<oOOO0o00> O00000o = new ArrayList();
    public Object O000000o;
    public o0000000o O00000Oo;
    public oOOO0o00 O00000o0;

    public oOOO0o00(Object obj, o0000000o o0000000o) {
        this.O000000o = obj;
        this.O00000Oo = o0000000o;
    }

    public static oOOO0o00 O000000o(o0000000o o0000000o, Object obj) {
        synchronized (O00000o) {
            int size = O00000o.size();
            if (size <= 0) {
                return new oOOO0o00(obj, o0000000o);
            }
            oOOO0o00 remove = O00000o.remove(size - 1);
            remove.O000000o = obj;
            remove.O00000Oo = o0000000o;
            remove.O00000o0 = null;
            return remove;
        }
    }

    public static void O000000o(oOOO0o00 oooo0o00) {
        oooo0o00.O000000o = null;
        oooo0o00.O00000Oo = null;
        oooo0o00.O00000o0 = null;
        synchronized (O00000o) {
            if (O00000o.size() < 10000) {
                O00000o.add(oooo0o00);
            }
        }
    }
}
