package com.tuya.smart.common;

import com.tuya.sdk.eventbus.EventBusException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class oOOO0oOO {
    public static final ExecutorService O0000Oo0 = Executors.newCachedThreadPool();
    public boolean O000000o = true;
    public boolean O00000Oo = true;
    public boolean O00000o = true;
    public boolean O00000o0 = true;
    public boolean O00000oO;
    public boolean O00000oo = true;
    public ExecutorService O0000O0o = O0000Oo0;
    public List<Class<?>> O0000OOo;

    public oOOO00o0 O000000o() {
        oOOO00o0 oooo00o0;
        synchronized (oOOO00o0.class) {
            if (oOOO00o0.O00000Oo == null) {
                oOOO00o0.O00000Oo = O00000Oo();
                oooo00o0 = oOOO00o0.O00000Oo;
            } else {
                throw new EventBusException("Default instance already exists. It may be only set once before it's used the first time to ensure consistent behavior.");
            }
        }
        return oooo00o0;
    }

    public oOOO0oOO O000000o(Class<?> cls) {
        if (this.O0000OOo == null) {
            this.O0000OOo = new ArrayList();
        }
        this.O0000OOo.add(cls);
        return this;
    }

    public oOOO0oOO O000000o(ExecutorService executorService) {
        this.O0000O0o = executorService;
        return this;
    }

    public oOOO0oOO O000000o(boolean z) {
        this.O000000o = z;
        return this;
    }

    public oOOO00o0 O00000Oo() {
        return new oOOO00o0(this);
    }

    public oOOO0oOO O00000Oo(boolean z) {
        this.O00000Oo = z;
        return this;
    }

    public oOOO0oOO O00000o(boolean z) {
        this.O00000o = z;
        return this;
    }

    public oOOO0oOO O00000o0(boolean z) {
        this.O00000o0 = z;
        return this;
    }

    public oOOO0oOO O00000oO(boolean z) {
        this.O00000oO = z;
        return this;
    }

    public oOOO0oOO O00000oo(boolean z) {
        this.O00000oo = z;
        return this;
    }
}
