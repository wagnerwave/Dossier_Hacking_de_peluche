package com.tuya.smart.common;

import a.a.a.a.a;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.SigMeshBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class oooo00oo0 implements oooo00o0o {
    public Map<String, SigMeshBean> O000000o;
    public ReadWriteLock O00000Oo;

    public static class O000000o {
        public static oooo00oo0 O000000o = new oooo00oo0();
    }

    public oooo00oo0() {
        this.O00000Oo = new ReentrantReadWriteLock(true);
        this.O000000o = new ConcurrentHashMap(5);
    }

    private void O000000o(Map<String, SigMeshBean> map) {
        this.O00000Oo.writeLock().lock();
        try {
            this.O000000o.clear();
            this.O000000o.putAll(map);
        } finally {
            this.O00000Oo.writeLock().unlock();
        }
    }

    private synchronized void O00000Oo(List<SigMeshBean> list) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(list.size());
        for (SigMeshBean next : list) {
            O00000oO(next.getMeshId());
            concurrentHashMap.put(next.getMeshId(), next);
        }
        O000000o((Map<String, SigMeshBean>) concurrentHashMap);
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

    public static oooo00oo0 O00000o0() {
        return O000000o.O000000o;
    }

    private void O00000oO(String str) {
        o0o00o0oo0 o0o00o0oo0 = (o0o00o0oo0) Oo0.O000000o(o0o00o0oo0.class);
        if (o0o00o0oo0 != null) {
            o0oo0oo000 O000000o2 = o0o00o0oo0.O000000o();
            O000000o2.O00000Oo("smart/mb/in/" + str, (IResultCallback) null);
            o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
            if (o0o00o00o0 != null) {
                for (DeviceBean next : o0o00o00o0.O0000OOo().getMeshDeviceList(str)) {
                    if (next.isBleMeshWifi()) {
                        o0oo0oo000 O000000o3 = o0o00o0oo0.O000000o();
                        StringBuilder n = a.n("smart/mb/in/");
                        n.append(next.getDevId());
                        O000000o3.O00000Oo(n.toString(), (IResultCallback) null);
                    }
                }
            }
        }
    }

    public SigMeshBean O000000o(String str) {
        return this.O000000o.get(str);
    }

    public List<SigMeshBean> O000000o() {
        this.O00000Oo.readLock().lock();
        try {
            return new ArrayList(this.O000000o.values());
        } finally {
            this.O00000Oo.readLock().unlock();
        }
    }

    public void O000000o(int i, String str) {
        oooo00ooo.O000000o().O000000o(i, str);
    }

    /* JADX INFO: finally extract failed */
    public void O000000o(SigMeshBean sigMeshBean) {
        if (sigMeshBean != null) {
            O00000oO(sigMeshBean.getMeshId());
            this.O00000Oo.writeLock().lock();
            try {
                this.O000000o.put(sigMeshBean.getMeshId(), sigMeshBean);
                this.O00000Oo.writeLock().unlock();
                oooo00ooo.O000000o().O000000o(sigMeshBean);
            } catch (Throwable th) {
                this.O00000Oo.writeLock().unlock();
                throw th;
            }
        }
    }

    public void O000000o(List<SigMeshBean> list) {
        O00000Oo(list);
    }

    public void O00000Oo() {
        O00000o();
    }

    public void O00000Oo(int i, String str) {
        oooo00ooo.O000000o().O00000Oo(i, str);
    }

    /* JADX INFO: finally extract failed */
    public void O00000Oo(String str) {
        this.O00000Oo.writeLock().lock();
        try {
            this.O000000o.remove(str);
            this.O00000Oo.writeLock().unlock();
            oooo00ooo.O000000o().O00000o0(str);
        } catch (Throwable th) {
            this.O00000Oo.writeLock().unlock();
            throw th;
        }
    }

    public int O00000o(String str) {
        return oooo00ooo.O000000o().O00000Oo(str);
    }

    public int O00000o0(String str) {
        return oooo00ooo.O000000o().O000000o(str);
    }
}
