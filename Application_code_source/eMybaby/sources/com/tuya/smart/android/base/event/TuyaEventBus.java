package com.tuya.smart.android.base.event;

import com.tuya.smart.common.oOOO00o0;
import java.util.concurrent.ExecutorService;

public class TuyaEventBus {
    public oOOO00o0 eventBus;
    public boolean mDebug;

    public TuyaEventBus(boolean z, ExecutorService executorService) {
        this.mDebug = z;
        this.eventBus = oOOO00o0.O00000Oo().O000000o(executorService).O00000o(this.mDebug).O00000oo(false).O00000Oo();
    }

    public void post(Object obj) {
        this.eventBus.O00000oO(obj);
    }

    public void register(Object obj) {
        if (!this.eventBus.O00000o0(obj)) {
            this.eventBus.O000000o(obj);
        }
    }

    public void register(Object obj, int i) {
        if (!this.eventBus.O00000o0(obj)) {
            this.eventBus.O000000o(obj, i);
        }
    }

    public void registerSticky(Object obj) {
        if (!this.eventBus.O00000o0(obj)) {
            this.eventBus.O00000Oo(obj);
        }
    }

    public void registerSticky(Object obj, int i) {
        if (!this.eventBus.O00000o0(obj)) {
            this.eventBus.O00000Oo(obj, i);
        }
    }

    public synchronized void unregister(Object obj) {
        if (obj != null) {
            if (this.eventBus.O00000o0(obj)) {
                this.eventBus.O00000o(obj);
            }
        }
    }
}
