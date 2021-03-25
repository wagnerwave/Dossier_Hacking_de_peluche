package com.tuya.smart.android.common.utils;

import java.util.HashMap;

public class TuyaCache {
    public HashMap<String, Object> mHashMap;

    public static class Holder {
        public static TuyaCache tuyaCache = new TuyaCache();
    }

    public TuyaCache() {
        this.mHashMap = new HashMap<>(16);
    }

    public static TuyaCache getInstance() {
        return Holder.tuyaCache;
    }

    public Object getKey(String str) {
        return this.mHashMap.get(str);
    }

    public void onDestroy() {
        this.mHashMap.clear();
    }

    public void putKey(String str, Object obj) {
        this.mHashMap.put(str, obj);
    }
}
