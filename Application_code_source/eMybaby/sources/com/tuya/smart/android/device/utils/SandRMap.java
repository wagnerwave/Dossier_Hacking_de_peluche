package com.tuya.smart.android.device.utils;

import com.tuya.smart.common.o0oo00o00o;
import java.util.HashMap;

public class SandRMap {
    public static volatile SandRMap ourInstance;
    public HashMap<String, o0oo00o00o> mSandRHashMap = new HashMap<>(10);

    public static SandRMap getInstance() {
        if (ourInstance == null) {
            synchronized (SandRMap.class) {
                ourInstance = new SandRMap();
            }
        }
        return ourInstance;
    }

    public o0oo00o00o get(String str) {
        return this.mSandRHashMap.get(str);
    }

    public void onDestroy() {
        this.mSandRHashMap.clear();
        ourInstance = null;
    }

    public void put(String str, o0oo00o00o o0oo00o00o) {
        this.mSandRHashMap.put(str, o0oo00o00o);
    }
}
