package com.tuya.smart.common;

import android.app.Activity;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class o000000o0 {
    public final Executor O000000o;
    public final Constructor<?> O00000Oo;
    public final Object O00000o;
    public final oOOO00o0 O00000o0;

    public static class O000000o {
        public Executor O000000o;
        public Class<?> O00000Oo;
        public oOOO00o0 O00000o0;

        public O000000o() {
        }

        public O000000o O000000o(oOOO00o0 oooo00o0) {
            this.O00000o0 = oooo00o0;
            return this;
        }

        public O000000o O000000o(Class<?> cls) {
            this.O00000Oo = cls;
            return this;
        }

        public O000000o O000000o(Executor executor) {
            this.O000000o = executor;
            return this;
        }

        public o000000o0 O000000o() {
            return O000000o((Object) null);
        }

        public o000000o0 O000000o(Activity activity) {
            return O000000o((Object) activity.getClass());
        }

        public o000000o0 O000000o(Object obj) {
            if (this.O00000o0 == null) {
                this.O00000o0 = oOOO00o0.O000000o();
            }
            if (this.O000000o == null) {
                this.O000000o = Executors.newCachedThreadPool();
            }
            if (this.O00000Oo == null) {
                this.O00000Oo = o00000o00.class;
            }
            return new o000000o0(this.O000000o, this.O00000o0, this.O00000Oo, obj);
        }
    }

    public interface O00000Oo {
        void O000000o();
    }

    public o000000o0(Executor executor, oOOO00o0 oooo00o0, Class<?> cls, Object obj) {
        this.O000000o = executor;
        this.O00000o0 = oooo00o0;
        this.O00000o = obj;
        try {
            this.O00000Oo = cls.getConstructor(new Class[]{Throwable.class});
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException("Failure event class must have a constructor with one parameter of type Throwable", e2);
        }
    }

    public static O000000o O000000o() {
        return new O000000o();
    }

    public static o000000o0 O00000Oo() {
        return new O000000o().O000000o();
    }

    public void O000000o(final O00000Oo o00000Oo) {
        this.O000000o.execute(new Runnable() {
            public void run() {
                try {
                    o00000Oo.O000000o();
                } catch (Exception e2) {
                    try {
                        Object newInstance = o000000o0.this.O00000Oo.newInstance(new Object[]{e2});
                        if (newInstance instanceof o000000oo) {
                            ((o000000oo) newInstance).O000000o(o000000o0.this.O00000o);
                        }
                        o000000o0.this.O00000o0.O00000oO(newInstance);
                    } catch (Exception e3) {
                        Log.e(oOOO00o0.O000000o, "Original exception:", e2);
                        throw new RuntimeException("Could not create failure event", e3);
                    }
                }
            }
        });
    }
}
