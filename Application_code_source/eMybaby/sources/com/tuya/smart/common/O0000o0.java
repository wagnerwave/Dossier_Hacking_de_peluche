package com.tuya.smart.common;

import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.bean.BlueMeshBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class O0000o0 implements O0000o00 {
    public Map<String, BlueMeshBean> O000000o;
    public ReadWriteLock O00000Oo;

    public static class O000000o {
        public static O0000o0 O000000o = new O0000o0();
    }

    public O0000o0() {
        this.O00000Oo = new ReentrantReadWriteLock(true);
        this.O000000o = new ConcurrentHashMap(5);
    }

    private void O000000o(Map<String, BlueMeshBean> map) {
        this.O00000Oo.writeLock().lock();
        try {
            this.O000000o.clear();
            this.O000000o.putAll(map);
        } finally {
            this.O00000Oo.writeLock().unlock();
        }
    }

    private synchronized void O00000Oo(List<BlueMeshBean> list) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(list.size());
        for (BlueMeshBean next : list) {
            O00000o0(next.getMeshId());
            concurrentHashMap.put(next.getMeshId(), next);
        }
        O000000o((Map<String, BlueMeshBean>) concurrentHashMap);
    }

    private void O00000o() {
        if (!this.O000000o.isEmpty()) {
            this.O00000Oo.writeLock().lock();
            try {
                this.O000000o.clear();
            } finally {
                this.O00000Oo.writeLock().unlock();
            }
        }
    }

    public static O0000o0 O00000o0() {
        return O000000o.O000000o;
    }

    private void O00000o0(String str) {
        o0o00o0oo0 o0o00o0oo0 = (o0o00o0oo0) Oo0.O000000o(o0o00o0oo0.class);
        if (o0o00o0oo0 != null) {
            o0oo0oo000 O000000o2 = o0o00o0oo0.O000000o();
            O000000o2.O00000Oo("smart/mb/in/" + str, (IResultCallback) null);
        }
    }

    public BlueMeshBean O000000o(String str) {
        return this.O000000o.get(str);
    }

    public List<BlueMeshBean> O000000o() {
        this.O00000Oo.readLock().lock();
        try {
            return new ArrayList(this.O000000o.values());
        } finally {
            this.O00000Oo.readLock().unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public void O000000o(BlueMeshBean blueMeshBean) {
        if (blueMeshBean != null) {
            O00000o0(blueMeshBean.getMeshId());
            this.O00000Oo.writeLock().lock();
            try {
                this.O000000o.put(blueMeshBean.getMeshId(), blueMeshBean);
                this.O00000Oo.writeLock().unlock();
                O0000Oo0.O000000o().O000000o(blueMeshBean);
            } catch (Throwable th) {
                this.O00000Oo.writeLock().unlock();
                throw th;
            }
        }
    }

    public void O000000o(List<BlueMeshBean> list) {
        O00000Oo(list);
    }

    public void O00000Oo() {
        O00000o();
    }

    /* JADX INFO: finally extract failed */
    public void O00000Oo(String str) {
        this.O00000Oo.writeLock().lock();
        try {
            this.O000000o.remove(str);
            this.O00000Oo.writeLock().unlock();
            O0000Oo0.O000000o().O000000o(str);
        } catch (Throwable th) {
            this.O00000Oo.writeLock().unlock();
            throw th;
        }
    }
}
