package com.tuya.sdk.home.cache;

import android.text.TextUtils;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.common.Oo0;
import com.tuya.smart.common.o0o000oooo;
import com.tuya.smart.common.o0o00o000;
import com.tuya.smart.common.o0o00o00o0;
import com.tuya.smart.common.o0o00o00oo;
import com.tuya.smart.common.o0o00o0o0;
import com.tuya.smart.home.sdk.api.IHomeCacheManager;
import com.tuya.smart.home.sdk.bean.DeviceAndGroupInRoomBean;
import com.tuya.smart.home.sdk.bean.HomeBean;
import com.tuya.smart.home.sdk.bean.RoomBean;
import com.tuya.smart.sdk.bean.BlueMeshBean;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.GroupBean;
import com.tuya.smart.sdk.bean.SigMeshBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TuyaHomeRelationCacheManager implements IHomeCacheManager {
    public static final String O000000o = "TuyaHomeRelationCacheManager";
    public static volatile TuyaHomeRelationCacheManager O00000Oo;
    public O000000o O00000o = O00000Oo();
    public ReadWriteLock O00000o0 = new ReentrantReadWriteLock(true);
    public O000000o O00000oO = new O000000o(HomeDataType.PERSONAL.getType(), "myRelation");

    public enum HomeDataType {
        PERSONAL(-1),
        SHARED(-2),
        HOME(2),
        MESH(3),
        ROOM(4),
        GROUP(5),
        DEVICE(6);
        
        public int type;

        /* access modifiers changed from: public */
        HomeDataType(int i) {
            this.type = i;
        }

        public static HomeDataType to(int i) {
            for (HomeDataType homeDataType : values()) {
                if (homeDataType.type == i) {
                    return homeDataType;
                }
            }
            return null;
        }

        public int getType() {
            return this.type;
        }

        public void setType(int i) {
            this.type = i;
        }
    }

    public static class O000000o {
        public int O000000o;
        public String O00000Oo;
        public List<O000000o> O00000o0;

        public O000000o(int i, String str) {
            this.O00000o0 = new ArrayList();
            this.O000000o = i;
            this.O00000Oo = str;
        }
    }

    private O000000o O000000o(long j) {
        return new O000000o(HomeDataType.GROUP.getType(), String.valueOf(j));
    }

    private O000000o O000000o(String str) {
        return new O000000o(HomeDataType.DEVICE.getType(), str);
    }

    public static IHomeCacheManager O000000o() {
        if (O00000Oo == null) {
            synchronized (TuyaHomeRelationCacheManager.class) {
                if (O00000Oo == null) {
                    O00000Oo = new TuyaHomeRelationCacheManager();
                }
            }
        }
        return O00000Oo;
    }

    private String O000000o(long j, long j2) {
        O000000o O00000Oo2 = O00000Oo(j);
        for (O000000o o000000o : this.O00000oO.O00000o0) {
            if (O00000Oo(O00000Oo2, o000000o)) {
                for (O000000o o000000o2 : o000000o.O00000o0) {
                    if (o000000o2.O000000o == HomeDataType.ROOM.getType()) {
                        for (O000000o O00000Oo3 : o000000o2.O00000o0) {
                            String O00000Oo4 = O00000Oo3.O00000Oo;
                            if (O00000Oo4.equals(j2 + "")) {
                                return o000000o2.O00000Oo;
                            }
                        }
                        continue;
                    }
                }
                continue;
            }
        }
        return "";
    }

    private String O000000o(long j, String str) {
        O000000o O00000Oo2 = O00000Oo(j);
        for (O000000o o000000o : this.O00000oO.O00000o0) {
            if (O00000Oo(O00000Oo2, o000000o)) {
                for (O000000o o000000o2 : o000000o.O00000o0) {
                    if (o000000o2.O000000o == HomeDataType.ROOM.getType()) {
                        for (O000000o O00000Oo3 : o000000o2.O00000o0) {
                            if (O00000Oo3.O00000Oo.equals(str)) {
                                return o000000o2.O00000Oo;
                            }
                        }
                        continue;
                    }
                }
                continue;
            }
        }
        return "";
    }

    private void O000000o(O000000o o000000o) {
        for (O000000o O000000o2 : o000000o.O00000o0) {
            O000000o(O000000o2);
        }
        o000000o.O00000o0.clear();
    }

    private void O000000o(O000000o o000000o, HomeDataType homeDataType, O000000o o000000o2) {
        try {
            this.O00000o0.writeLock().lock();
            O00000o0(o000000o, homeDataType, o000000o2);
        } finally {
            this.O00000o0.writeLock().unlock();
        }
    }

    private void O000000o(O000000o o000000o, O000000o o000000o2) {
        if (o000000o != null) {
            Iterator it = o000000o.O00000o0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                O000000o o000000o3 = (O000000o) it.next();
                if (O00000Oo(o000000o3, o000000o2)) {
                    o000000o.O00000o0.remove(o000000o3);
                    break;
                }
            }
            for (O000000o O000000o2 : o000000o.O00000o0) {
                O000000o(O000000o2, o000000o2);
            }
        }
    }

    private void O000000o(O000000o o000000o, O000000o o000000o2, O000000o o000000o3) {
        if (o000000o != null) {
            for (O000000o O000000o2 : o000000o.O00000o0) {
                O000000o(O000000o2, o000000o2, o000000o3);
            }
            if (O00000Oo(o000000o, o000000o2)) {
                Iterator it = o000000o.O00000o0.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    O000000o o000000o4 = (O000000o) it.next();
                    if (O00000Oo(o000000o4, o000000o3)) {
                        o000000o.O00000o0.remove(o000000o4);
                        break;
                    }
                }
                o000000o.O00000o0.add(o000000o3);
            }
        }
    }

    private void O000000o(O000000o o000000o, RoomBean roomBean) {
        o0o00o00oo o0o00o00oo;
        GroupBean O000000o2;
        DeviceBean deviceBean;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (O000000o o000000o2 : o000000o.O00000o0) {
            if (o000000o2.O000000o == HomeDataType.DEVICE.getType()) {
                o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
                if (!(o0o00o00o0 == null || (deviceBean = o0o00o00o0.O0000OOo().getDeviceBean(o000000o2.O00000Oo)) == null)) {
                    arrayList.add(deviceBean);
                }
            } else if (!(o000000o2.O000000o != HomeDataType.GROUP.getType() || (o0o00o00oo = (o0o00o00oo) Oo0.O000000o(o0o00o00oo.class)) == null || (O000000o2 = o0o00o00oo.O000000o().O000000o(Long.parseLong(o000000o2.O00000Oo))) == null)) {
                O000000o(o000000o, O000000o2);
                arrayList2.add(O000000o2);
            }
        }
        roomBean.setGroupList(arrayList2);
        roomBean.setDeviceList(arrayList);
    }

    private void O000000o(O000000o o000000o, GroupBean groupBean) {
        o0o00o00o0 o0o00o00o0;
        DeviceBean deviceBean;
        ArrayList arrayList = new ArrayList();
        for (O000000o o000000o2 : o000000o.O00000o0) {
            if (!(o000000o2.O000000o != HomeDataType.DEVICE.getType() || (o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)) == null || (deviceBean = o0o00o00o0.O0000OOo().getDeviceBean(o000000o2.O00000Oo)) == null)) {
                arrayList.add(deviceBean);
            }
        }
        groupBean.setDeviceBeans(arrayList);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002d, code lost:
        r5 = (r5 = r2.O0000OOo().getDeviceBean(r5)).getProductBean();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean O000000o(com.tuya.smart.sdk.bean.DeviceBean r5) {
        /*
            r4 = this;
            com.tuya.smart.sdk.bean.ProductBean r0 = r5.getProductBean()
            int r0 = r0.getCapability()
            r1 = 1
            r2 = 8192(0x2000, float:1.14794E-41)
            if (r0 == r2) goto L_0x000e
            return r1
        L_0x000e:
            r0 = 0
            java.lang.String r5 = r5.getMeshId()
            java.lang.Class<com.tuya.smart.common.o0o00o00o0> r2 = com.tuya.smart.common.o0o00o00o0.class
            java.lang.Object r2 = com.tuya.smart.common.Oo0.O000000o(r2)
            com.tuya.smart.common.o0o00o00o0 r2 = (com.tuya.smart.common.o0o00o00o0) r2
            if (r2 == 0) goto L_0x003a
            boolean r3 = android.text.TextUtils.isEmpty(r5)
            if (r3 != 0) goto L_0x003a
            com.tuya.smart.home.sdk.api.ITuyaHomeDataManager r2 = r2.O0000OOo()
            com.tuya.smart.sdk.bean.DeviceBean r5 = r2.getDeviceBean(r5)
            if (r5 == 0) goto L_0x003a
            com.tuya.smart.sdk.bean.ProductBean r5 = r5.getProductBean()
            if (r5 == 0) goto L_0x003a
            boolean r5 = r5.isInfraredSubDevDisplayInList()
            if (r5 == 0) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r1 = 0
        L_0x003b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.sdk.home.cache.TuyaHomeRelationCacheManager.O000000o(com.tuya.smart.sdk.bean.DeviceBean):boolean");
    }

    private O000000o O00000Oo() {
        return new O000000o(HomeDataType.SHARED.getType(), "1");
    }

    private O000000o O00000Oo(long j) {
        return new O000000o(HomeDataType.HOME.getType(), String.valueOf(j));
    }

    private O000000o O00000Oo(O000000o o000000o, HomeDataType homeDataType, O000000o o000000o2) {
        try {
            this.O00000o0.readLock().lock();
            return O00000o(o000000o, homeDataType, o000000o2);
        } finally {
            this.O00000o0.readLock().unlock();
        }
    }

    private O000000o O00000Oo(String str) {
        return new O000000o(HomeDataType.MESH.getType(), str);
    }

    private List<RoomBean> O00000Oo(O000000o o000000o) {
        RoomBean O000000o2;
        ArrayList arrayList = new ArrayList();
        try {
            this.O00000o0.writeLock().lock();
            O000000o O00000oo = O00000oo(this.O00000oO, o000000o);
            if (O00000oo.O00000o0 == null) {
                return new ArrayList();
            }
            for (O000000o o000000o2 : O00000oo.O00000o0) {
                if (o000000o2.O000000o == HomeDataType.ROOM.getType() && (O000000o2 = o0o00o0o0.O000000o().O000000o(Long.valueOf(Long.parseLong(o000000o2.O00000Oo)))) != null) {
                    arrayList.add(O000000o2);
                }
            }
            this.O00000o0.writeLock().unlock();
            return arrayList;
        } finally {
            this.O00000o0.writeLock().unlock();
        }
    }

    private void O00000Oo(O000000o o000000o, O000000o o000000o2, O000000o o000000o3) {
        if (o000000o != null) {
            if (O00000Oo(o000000o, o000000o2)) {
                Iterator it = o000000o.O00000o0.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    O000000o o000000o4 = (O000000o) it.next();
                    if (O00000Oo(o000000o4, o000000o3)) {
                        o000000o.O00000o0.remove(o000000o4);
                        break;
                    }
                }
            }
            for (O000000o O00000Oo2 : o000000o.O00000o0) {
                O00000Oo(O00000Oo2, o000000o2, o000000o3);
            }
        }
    }

    private boolean O00000Oo(O000000o o000000o, O000000o o000000o2) {
        return o000000o.O000000o == o000000o2.O000000o && TextUtils.equals(o000000o.O00000Oo, o000000o2.O00000Oo);
    }

    private O000000o O00000o(O000000o o000000o, HomeDataType homeDataType, O000000o o000000o2) {
        if (o000000o == null) {
            return null;
        }
        if (o000000o.O000000o == homeDataType.getType()) {
            for (O000000o O00000Oo2 : o000000o.O00000o0) {
                if (O00000Oo(O00000Oo2, o000000o2)) {
                    return o000000o;
                }
            }
        } else {
            for (O000000o O00000o2 : o000000o.O00000o0) {
                O000000o O00000o3 = O00000o(O00000o2, homeDataType, o000000o2);
                if (O00000o3 != null) {
                    return O00000o3;
                }
            }
        }
        return null;
    }

    private HomeBean O00000o(long j) {
        o0o000oooo o0o000oooo;
        GroupBean O000000o2;
        DeviceBean deviceBean;
        HomeBean O000000o3 = o0o00o000.O000000o().O000000o(j);
        List<DeviceBean> shareDeviceList = getShareDeviceList();
        List<GroupBean> shareGroupList = getShareGroupList();
        if (O000000o3 != null) {
            O000000o O00000Oo2 = O00000Oo(j);
            Iterator it = this.O00000oO.O00000o0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                O000000o o000000o = (O000000o) it.next();
                if (O00000Oo(O00000Oo2, o000000o)) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList arrayList5 = new ArrayList();
                    for (O000000o o000000o2 : o000000o.O00000o0) {
                        if (o000000o2.O000000o == HomeDataType.DEVICE.getType()) {
                            o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
                            if (!(o0o00o00o0 == null || (deviceBean = o0o00o00o0.O0000OOo().getDeviceBean(o000000o2.O00000Oo)) == null || deviceBean.getProductBean() == null || !O000000o(deviceBean))) {
                                arrayList.add(deviceBean);
                            }
                        } else if (o000000o2.O000000o == HomeDataType.GROUP.getType()) {
                            o0o00o00oo o0o00o00oo = (o0o00o00oo) Oo0.O000000o(o0o00o00oo.class);
                            if (!(o0o00o00oo == null || (O000000o2 = o0o00o00oo.O000000o().O000000o(Long.parseLong(o000000o2.O00000Oo))) == null)) {
                                O000000o(o000000o2, O000000o2);
                                arrayList2.add(O000000o2);
                            }
                        } else if (o000000o2.O000000o == HomeDataType.ROOM.getType()) {
                            RoomBean O000000o4 = o0o00o0o0.O000000o().O000000o(Long.valueOf(o000000o2.O00000Oo));
                            if (O000000o4 != null) {
                                O000000o(o000000o2, O000000o4);
                                arrayList3.add(O000000o4);
                            }
                        } else if (o000000o2.O000000o == HomeDataType.MESH.getType() && (o0o000oooo = (o0o000oooo) Oo0.O000000o(o0o000oooo.class)) != null) {
                            BlueMeshBean blueMeshBean = o0o000oooo.O000000o().getBlueMeshBean(o000000o2.O00000Oo);
                            if (blueMeshBean != null) {
                                arrayList4.add(blueMeshBean);
                            } else {
                                SigMeshBean sigMeshBean = o0o000oooo.O00000Oo().getSigMeshBean(o000000o2.O00000Oo);
                                if (sigMeshBean != null) {
                                    arrayList5.add(sigMeshBean);
                                }
                            }
                        }
                    }
                    O000000o3.setDeviceList(arrayList);
                    O000000o3.setSharedDeviceList(shareDeviceList);
                    O000000o3.setGroupList(arrayList2);
                    O000000o3.setRooms(arrayList3);
                    O000000o3.setMeshList(arrayList4);
                    O000000o3.setSigMeshList(arrayList5);
                    O000000o3.setSharedGroupList(shareGroupList);
                }
            }
        }
        return O000000o3;
    }

    private List<DeviceBean> O00000o(O000000o o000000o) {
        o0o00o00o0 o0o00o00o0;
        DeviceBean deviceBean;
        ArrayList arrayList = new ArrayList();
        try {
            this.O00000o0.writeLock().lock();
            O000000o O00000oo = O00000oo(this.O00000oO, o000000o);
            if (O00000oo != null) {
                if (O00000oo.O00000o0 != null) {
                    for (O000000o o000000o2 : O00000oo.O00000o0) {
                        if (!(o000000o2.O000000o != HomeDataType.DEVICE.getType() || (o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)) == null || (deviceBean = o0o00o00o0.O0000OOo().getDeviceBean(o000000o2.O00000Oo)) == null)) {
                            arrayList.add(deviceBean);
                        }
                    }
                    this.O00000o0.writeLock().unlock();
                    return arrayList;
                }
            }
            return arrayList;
        } finally {
            this.O00000o0.writeLock().unlock();
        }
    }

    private void O00000o(O000000o o000000o, O000000o o000000o2) {
        try {
            this.O00000o0.writeLock().lock();
            O0000Oo0(o000000o, o000000o2);
        } finally {
            this.O00000o0.writeLock().unlock();
        }
    }

    private void O00000o(O000000o o000000o, O000000o o000000o2, O000000o o000000o3) {
        try {
            this.O00000o0.writeLock().lock();
            O00000Oo(o000000o, o000000o2, o000000o3);
        } finally {
            this.O00000o0.writeLock().unlock();
        }
    }

    private O000000o O00000o0(long j) {
        return new O000000o(HomeDataType.ROOM.getType(), String.valueOf(j));
    }

    private List<GroupBean> O00000o0(O000000o o000000o) {
        GroupBean groupBean;
        ArrayList arrayList = new ArrayList();
        try {
            this.O00000o0.writeLock().lock();
            O000000o O00000oo = O00000oo(this.O00000oO, o000000o);
            if (O00000oo != null) {
                if (O00000oo.O00000o0 != null) {
                    for (O000000o o000000o2 : O00000oo.O00000o0) {
                        if (o000000o2.O000000o == HomeDataType.GROUP.getType() && (groupBean = getGroupBean(Long.valueOf(o000000o2.O00000Oo).longValue())) != null) {
                            arrayList.add(groupBean);
                        }
                    }
                    this.O00000o0.writeLock().unlock();
                    return arrayList;
                }
            }
            return new ArrayList();
        } finally {
            this.O00000o0.writeLock().unlock();
        }
    }

    private void O00000o0(O000000o o000000o, HomeDataType homeDataType, O000000o o000000o2) {
        if (o000000o.O000000o == homeDataType.getType()) {
            for (O000000o o000000o3 : o000000o.O00000o0) {
                if (O00000Oo(o000000o3, o000000o2)) {
                    o000000o.O00000o0.remove(o000000o3);
                    return;
                }
            }
            return;
        }
        for (O000000o O00000o02 : o000000o.O00000o0) {
            O00000o0(O00000o02, homeDataType, o000000o2);
        }
    }

    private void O00000o0(O000000o o000000o, O000000o o000000o2) {
        try {
            this.O00000o0.writeLock().lock();
            O000000o(o000000o, o000000o2);
        } finally {
            this.O00000o0.writeLock().unlock();
        }
    }

    private void O00000o0(O000000o o000000o, O000000o o000000o2, O000000o o000000o3) {
        try {
            this.O00000o0.writeLock().lock();
            O000000o(o000000o, o000000o2, o000000o3);
        } finally {
            this.O00000o0.writeLock().unlock();
        }
    }

    private O000000o O00000oO(O000000o o000000o, O000000o o000000o2) {
        try {
            this.O00000o0.readLock().lock();
            return O0000OOo(o000000o, o000000o2);
        } finally {
            this.O00000o0.readLock().unlock();
        }
    }

    private O000000o O00000oo(O000000o o000000o, O000000o o000000o2) {
        try {
            this.O00000o0.writeLock().lock();
            return O0000O0o(o000000o, o000000o2);
        } finally {
            this.O00000o0.writeLock().unlock();
        }
    }

    private O000000o O0000O0o(O000000o o000000o, O000000o o000000o2) {
        if (O00000Oo(o000000o, o000000o2)) {
            return o000000o;
        }
        for (O000000o O0000O0o : o000000o.O00000o0) {
            O000000o O0000O0o2 = O0000O0o(O0000O0o, o000000o2);
            if (O0000O0o2 != null) {
                return O0000O0o2;
            }
        }
        return null;
    }

    private O000000o O0000OOo(O000000o o000000o, O000000o o000000o2) {
        if (o000000o == null) {
            return null;
        }
        for (O000000o o000000o3 : o000000o.O00000o0) {
            if (O00000Oo(o000000o3, o000000o2)) {
                return o000000o;
            }
            O000000o O0000OOo = O0000OOo(o000000o3, o000000o2);
            if (O0000OOo != null) {
                return O0000OOo;
            }
        }
        return null;
    }

    private void O0000Oo0(O000000o o000000o, O000000o o000000o2) {
        if (o000000o != null) {
            boolean z = false;
            Iterator it = o000000o.O00000o0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                O000000o o000000o3 = (O000000o) it.next();
                if (O00000Oo(o000000o3, o000000o2)) {
                    z = true;
                    o000000o.O00000o0.remove(o000000o3);
                    break;
                }
            }
            for (O000000o O0000Oo0 : o000000o.O00000o0) {
                O0000Oo0(O0000Oo0, o000000o2);
            }
            if (z) {
                o000000o.O00000o0.add(o000000o2);
            }
        }
    }

    public void addDevListToRoom(long j, List<String> list) {
        for (String addDevToRoom : list) {
            addDevToRoom(j, addDevToRoom);
        }
    }

    public void addDevToGroup(long j, String str) {
        try {
            this.O00000o0.writeLock().lock();
            O00000o0(this.O00000oO, O000000o(j), O000000o(str));
        } finally {
            this.O00000o0.writeLock().unlock();
        }
    }

    public void addDevToHome(long j, String str) {
        O00000o0(this.O00000oO, O00000Oo(j), O000000o(str));
    }

    public void addDevToMesh(String str, String str2) {
        O00000o0(this.O00000oO, O00000Oo(str), O000000o(str2));
    }

    public void addDevToRoom(long j, String str) {
        O00000o0(this.O00000oO, O00000o0(j), O000000o(str));
    }

    public void addGroupListToRoom(long j, List<Long> list) {
        for (Long next : list) {
            addGroupToRoom(next.longValue(), next.longValue());
        }
    }

    public void addGroupToHome(long j, long j2) {
        O00000o0(this.O00000oO, O00000Oo(j), O000000o(j2));
    }

    public void addGroupToMesh(String str, long j) {
        O000000o O00000oo = O00000oo(this.O00000oO, O000000o(j));
        if (O00000oo != null) {
            O00000o0(this.O00000oO, O00000Oo(str), O00000oo);
        }
    }

    public void addGroupToRoom(long j, long j2) {
        O000000o O00000oo = O00000oo(this.O00000oO, O000000o(j2));
        if (O00000oo != null) {
            O00000o0(this.O00000oO, O00000o0(j), O00000oo);
        }
    }

    public void addMeshToHome(long j, String str) {
        O00000o0(this.O00000oO, O00000Oo(j), O00000Oo(str));
    }

    public void addRoomToHome(long j, long j2) {
        try {
            this.O00000o0.writeLock().lock();
            O00000o0(this.O00000oO, O00000Oo(j), O00000o0(j2));
        } finally {
            this.O00000o0.writeLock().unlock();
        }
    }

    public void addRoomToHome(long j, RoomBean roomBean) {
        if (roomBean != null) {
            o0o00o0o0.O000000o().O000000o(Long.valueOf(roomBean.getRoomId()), roomBean);
            addRoomToHome(j, roomBean.getRoomId());
        }
    }

    public void addShareDevToPersonal(String str) {
        O00000o0(this.O00000oO, this.O00000o, O000000o(str));
    }

    public void addShareGroupToPersonal(long j) {
        O00000o0(this.O00000oO, this.O00000o, O000000o(j));
    }

    public void clearRelation() {
        O000000o(this.O00000oO);
    }

    public List<DeviceBean> getDevList(long j) {
        return O00000o(O00000Oo(j));
    }

    public GroupBean getGroupBean(long j) {
        o0o00o00oo o0o00o00oo = (o0o00o00oo) Oo0.O000000o(o0o00o00oo.class);
        if (o0o00o00oo != null) {
            GroupBean O000000o2 = o0o00o00oo.O000000o().O000000o(j);
            if (O000000o2 == null) {
                return null;
            }
            O000000o2.setDeviceBeans(O00000o(O000000o(j)));
            return O000000o2;
        }
        L.e(O000000o, "ITuyaGroupPlugin = null");
        return null;
    }

    public List<GroupBean> getGroupList(long j) {
        return O00000o0(O00000Oo(j));
    }

    public HomeBean getHomeBean(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.O00000o0.readLock().lock();
            HomeBean O00000o2 = O00000o(j);
            L.d(O000000o, "getHomeBean time :" + String.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return O00000o2;
        } finally {
            this.O00000o0.readLock().unlock();
        }
    }

    public long getHomeIdByDevId(String str) {
        O000000o O00000Oo2 = O00000Oo(this.O00000oO, HomeDataType.HOME, O000000o(str));
        if (O00000Oo2 != null) {
            return Long.valueOf(O00000Oo2.O00000Oo).longValue();
        }
        return -1;
    }

    public long getHomeIdByGroupId(long j) {
        O000000o O00000Oo2 = O00000Oo(this.O00000oO, HomeDataType.HOME, O000000o(j));
        if (O00000Oo2 != null) {
            return Long.valueOf(O00000Oo2.O00000Oo).longValue();
        }
        return -1;
    }

    public long getHomeIdByMeshId(String str) {
        O000000o O00000oO2 = O00000oO(this.O00000oO, O00000Oo(str));
        if (O00000oO2 != null) {
            return Long.parseLong(O00000oO2.O00000Oo);
        }
        return -1;
    }

    public List<RoomBean> getHomeRoomList(long j) {
        return O00000Oo(O00000Oo(j));
    }

    public List<DeviceBean> getMeshDeviceList(String str) {
        return O00000o(O00000Oo(str));
    }

    public List<GroupBean> getMeshGroupList(String str) {
        return O00000o0(O00000Oo(str));
    }

    public RoomBean getRoomBeanByGroup(long j) {
        O000000o O00000Oo2 = O00000Oo(this.O00000oO, HomeDataType.ROOM, O000000o(j));
        if (O00000Oo2 != null) {
            return o0o00o0o0.O000000o().O000000o(Long.valueOf(O00000Oo2.O00000Oo));
        }
        return null;
    }

    public RoomBean getRoomBeanByGroup(long j, long j2) {
        try {
            this.O00000o0.readLock().lock();
            String O000000o2 = O000000o(j, j2);
            return TextUtils.isEmpty(O000000o2) ? null : o0o00o0o0.O000000o().O000000o(Long.valueOf(O000000o2));
        } finally {
            this.O00000o0.readLock().unlock();
        }
    }

    public RoomBean getRoomBeanByRoomId(long j) {
        return o0o00o0o0.O000000o().O000000o(Long.valueOf(j));
    }

    public RoomBean getRoomBeanBydevice(long j, String str) {
        try {
            this.O00000o0.readLock().lock();
            String O000000o2 = O000000o(j, str);
            return TextUtils.isEmpty(O000000o2) ? null : o0o00o0o0.O000000o().O000000o(Long.valueOf(O000000o2));
        } finally {
            this.O00000o0.readLock().unlock();
        }
    }

    public RoomBean getRoomBeanBydevice(String str) {
        O000000o O00000Oo2 = O00000Oo(this.O00000oO, HomeDataType.ROOM, O000000o(str));
        if (O00000Oo2 != null) {
            return o0o00o0o0.O000000o().O000000o(Long.valueOf(O00000Oo2.O00000Oo));
        }
        return null;
    }

    public List<DeviceBean> getRoomDeviceList(long j) {
        return O00000o(O00000o0(j));
    }

    public List<GroupBean> getRoomGroupList(long j) {
        return O00000o0(O00000o0(j));
    }

    @Deprecated
    public List<DeviceBean> getShareDeviceList() {
        o0o00o00o0 o0o00o00o0;
        DeviceBean deviceBean;
        ArrayList arrayList = new ArrayList();
        for (O000000o o000000o : this.O00000o.O00000o0) {
            if (o000000o.O000000o == HomeDataType.DEVICE.getType() && (o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)) != null && (deviceBean = o0o00o00o0.O0000OOo().getDeviceBean(o000000o.O00000Oo)) != null && deviceBean.getIsShare().booleanValue()) {
                arrayList.add(deviceBean);
            }
        }
        return arrayList;
    }

    @Deprecated
    public List<GroupBean> getShareGroupList() {
        o0o00o00oo o0o00o00oo;
        GroupBean O000000o2;
        ArrayList arrayList = new ArrayList();
        for (O000000o o000000o : this.O00000o.O00000o0) {
            if (!(o000000o.O000000o != HomeDataType.GROUP.getType() || (o0o00o00oo = (o0o00o00oo) Oo0.O000000o(o0o00o00oo.class)) == null || (O000000o2 = o0o00o00oo.O000000o().O000000o(Long.parseLong(o000000o.O00000Oo))) == null)) {
                arrayList.add(O000000o2);
            }
        }
        return arrayList;
    }

    public void onDestroy() {
        try {
            this.O00000o0.writeLock().lock();
            O000000o(this.O00000oO);
        } finally {
            this.O00000o0.writeLock().unlock();
        }
    }

    public void putHomeBean(long j) {
        O000000o o000000o = this.O00000oO;
        O00000o0(o000000o, o000000o, O00000Oo(j));
    }

    public void putHomeBean(HomeBean homeBean) {
        o0o00o000.O000000o().O000000o(homeBean.getHomeId(), homeBean);
        putHomeBean(homeBean.getHomeId());
    }

    public void removeDevFromGroup(long j, String str) {
        O00000o(this.O00000oO, O000000o(j), O000000o(str));
    }

    public void removeDevFromRoom(long j, String str) {
        O00000o(this.O00000oO, O00000o0(j), O000000o(str));
    }

    public void removeDevFromRoom(String str) {
        O000000o(this.O00000oO, HomeDataType.ROOM, O000000o(str));
    }

    public void removeDevice(String str) {
        O00000o0(this.O00000oO, O000000o(str));
    }

    public void removeGroup(long j) {
        o0o00o00oo o0o00o00oo = (o0o00o00oo) Oo0.O000000o(o0o00o00oo.class);
        if (o0o00o00oo != null) {
            o0o00o00oo.O000000o().O00000Oo(j);
            O00000o0(this.O00000oO, O000000o(j));
            return;
        }
        L.e(O000000o, "iTuyaGroupPlugin = null");
    }

    public void removeGroupFromRoom(long j) {
        O000000o(this.O00000oO, HomeDataType.ROOM, O000000o(j));
    }

    public void removeGroupFromRoom(long j, long j2) {
        O00000o(this.O00000oO, O00000o0(j), O000000o(j2));
    }

    public void removeHome(long j) {
        o0o00o000.O000000o().O00000Oo(j);
        O00000o0(this.O00000oO, O00000Oo(j));
    }

    public void removeMesh(String str) {
        O00000o0(this.O00000oO, O00000Oo(str));
    }

    public void removeRoom(long j) {
        o0o00o0o0.O000000o().O000000o(j);
        O00000o0(this.O00000oO, O00000o0(j));
    }

    public void removeShareDevice(String str) {
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        if (o0o00o00o0 != null) {
            o0o00o00o0.O0000o00().removeDevCache(str);
        }
        O00000o0(this.O00000o, O000000o(str));
    }

    public void removeShareGroup(long j) {
        o0o00o00oo o0o00o00oo = (o0o00o00oo) Oo0.O000000o(o0o00o00oo.class);
        if (o0o00o00oo != null) {
            o0o00o00oo.O000000o().O00000Oo(j);
        }
        O00000o0(this.O00000o, O000000o(j));
    }

    public void replaceDevGroupToRoom(List<DeviceAndGroupInRoomBean> list, long j) {
        O000000o O0000O0o;
        O000000o O00000o02 = O00000o0(j);
        for (DeviceAndGroupInRoomBean next : list) {
            if (next.getType() == HomeDataType.GROUP.getType()) {
                long parseLong = Long.parseLong(next.getId());
                removeGroupFromRoom(parseLong);
                O0000O0o = O0000O0o(this.O00000oO, O000000o(parseLong));
                if (O0000O0o == null) {
                }
            } else if (next.getType() == HomeDataType.DEVICE.getType()) {
                removeDevFromRoom(next.getId());
                O0000O0o = O0000O0o(this.O00000oO, O000000o(next.getId()));
                if (O0000O0o == null) {
                }
            }
            O00000o02.O00000o0.add(O0000O0o);
        }
        O00000o(this.O00000oO, O00000o02);
    }

    public void resetShareNode() {
        O000000o O00000Oo2 = O00000Oo();
        this.O00000o = O00000Oo2;
        O000000o o000000o = this.O00000oO;
        O00000o0(o000000o, o000000o, O00000Oo2);
    }

    public void updateDeviceList(long j, List<String> list) {
        O000000o O000000o2 = O000000o(j);
        for (String O000000o3 : list) {
            O000000o2.O00000o0.add(O000000o(O000000o3));
        }
        O00000o(this.O00000oO, O000000o2);
    }
}
