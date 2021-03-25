package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import android.util.LongSparseArray;
import com.tuya.sdk.home.cache.TuyaHomeRelationCacheManager;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.home.sdk.api.ITuyaHomeChangeListener;
import com.tuya.smart.home.sdk.api.ITuyaHomeDeviceStatusListener;
import com.tuya.smart.home.sdk.api.ITuyaHomeStatusListener;
import com.tuya.smart.home.sdk.api.IWarningMsgListener;
import com.tuya.smart.home.sdk.bean.HomeBean;
import com.tuya.smart.home.sdk.callback.ITuyaHomeResultCallback;
import com.tuya.smart.home.sdk.callback.ITuyaResultCallback;
import com.tuya.smart.interior.device.bean.DeviceRespBean;
import com.tuya.smart.interior.device.bean.GroupRespBean;
import com.tuya.smart.interior.event.DeviceUpdateEvent;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.GroupBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class o0o0ooo0o implements o0o00o0oo, o0o0o00000, o0o0o00o00, o0o0o00o0o, o0o0o00ooo, o0oo0oo00o, DeviceUpdateEvent {
    public static final String O000000o = "TuyaReleationListenerManager";
    public static volatile o0o0ooo0o O0000OOo;
    public LongSparseArray<o0o0ooo0oo> O00000Oo = new LongSparseArray<>();
    public LongSparseArray<List<ITuyaHomeDeviceStatusListener>> O00000o = new LongSparseArray<>();
    public LongSparseArray<List<ITuyaHomeStatusListener>> O00000o0 = new LongSparseArray<>();
    public IWarningMsgListener O00000oO;
    public volatile boolean O00000oo;
    public CopyOnWriteArrayList<ITuyaHomeChangeListener> O0000O0o = new CopyOnWriteArrayList<>();
    public o0o00o0oo0 O0000Oo = ((o0o00o0oo0) Oo0.O000000o(o0o00o0oo0.class));
    public o0o00o00o0 O0000Oo0 = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class));
    public ITuyaDataCallback<List<DeviceBean>> O0000OoO = new ITuyaDataCallback<List<DeviceBean>>() {
        /* renamed from: O000000o */
        public void onSuccess(List<DeviceBean> list) {
            StringBuilder n = a.n("sharedDevList: ");
            n.append(list.size());
            n.append(list.toString());
            L.d(o0o0ooo0o.O000000o, n.toString());
            if (o0o0ooo0o.this.O0000O0o != null && o0o0ooo0o.this.O0000O0o.size() > 0) {
                Iterator it = o0o0ooo0o.this.O0000O0o.iterator();
                while (it.hasNext()) {
                    ((ITuyaHomeChangeListener) it.next()).onSharedDeviceList(list);
                }
            }
        }

        public void onError(String str, String str2) {
        }
    };
    public ITuyaDataCallback<List<GroupBean>> O0000Ooo = new ITuyaDataCallback<List<GroupBean>>() {
        /* renamed from: O000000o */
        public void onSuccess(List<GroupBean> list) {
            if (o0o0ooo0o.this.O0000O0o != null && o0o0ooo0o.this.O0000O0o.size() > 0) {
                Iterator it = o0o0ooo0o.this.O0000O0o.iterator();
                while (it.hasNext()) {
                    ((ITuyaHomeChangeListener) it.next()).onSharedGroupList(list);
                }
            }
        }

        public void onError(String str, String str2) {
        }
    };

    private void O000000o(o0o0ooo00o o0o0ooo00o) {
        TuyaHomeRelationCacheManager.O000000o().addMeshToHome(o0o0ooo00o.O000000o(), o0o0ooo00o.O00000Oo());
        List<ITuyaHomeStatusListener> O00000Oo2 = O00000Oo(o0o0ooo00o.O000000o());
        if (O00000Oo2 != null && O00000Oo2.size() > 0) {
            for (ITuyaHomeStatusListener onMeshAdded : O00000Oo2) {
                onMeshAdded.onMeshAdded(o0o0ooo00o.O00000Oo());
            }
        }
    }

    private void O000000o(o0o0ooo0o0 o0o0ooo0o0) {
        L.d(O000000o, "deviceUpdateEventModel");
        long O00000Oo2 = o0o0ooo0o0.O00000Oo();
        if (o0o0ooo0o0.O00000o0() == 1) {
            if (O00000Oo2 > 0) {
                StringBuilder n = a.n("groupId: ");
                n.append(o0o0ooo0o0.O000000o());
                n.append(" homeId: ");
                n.append(O00000Oo2);
                L.d(O000000o, n.toString());
                if (TuyaHomeRelationCacheManager.O000000o().getHomeIdByGroupId(o0o0ooo0o0.O000000o()) != O00000Oo2) {
                    L.d(O000000o, "devId is home , need not add the relation again");
                    TuyaHomeRelationCacheManager.O000000o().addGroupToHome(O00000Oo2, o0o0ooo0o0.O000000o());
                }
            }
            List<ITuyaHomeStatusListener> O00000Oo3 = O00000Oo(O00000Oo2);
            if (O00000Oo3 != null && O00000Oo3.size() > 0) {
                for (ITuyaHomeStatusListener onGroupAdded : O00000Oo3) {
                    onGroupAdded.onGroupAdded(o0o0ooo0o0.O000000o());
                }
            }
        } else if (o0o0ooo0o0.O00000o0() == 0) {
            L.d(O000000o, "device del homeId: " + O00000Oo2 + " groupId: " + o0o0ooo0o0.O000000o());
            TuyaHomeRelationCacheManager.O000000o().removeGroup(o0o0ooo0o0.O000000o());
            List<ITuyaHomeStatusListener> O00000Oo4 = O00000Oo(O00000Oo2);
            if (O00000Oo4 != null && O00000Oo4.size() > 0) {
                for (ITuyaHomeStatusListener onGroupRemoved : O00000Oo4) {
                    onGroupRemoved.onGroupRemoved(o0o0ooo0o0.O000000o());
                }
            }
        }
    }

    private void O000000o(o0oo0000oo o0oo0000oo) {
        IWarningMsgListener iWarningMsgListener = this.O00000oO;
        if (iWarningMsgListener != null) {
            iWarningMsgListener.onWarnMessageArrived(o0oo0000oo.O000000o());
        }
    }

    private void O000000o(final ITuyaHomeChangeListener iTuyaHomeChangeListener, final o0o0ooo0oo o0o0ooo0oo) {
        if (!TextUtils.isEmpty(o0o0ooo0oo.O00000o0())) {
            new o0o0oo00o(o0o0ooo0oo.O000000o()).getHomeDetail(new ITuyaHomeResultCallback() {
                public void onError(String str, String str2) {
                }

                public void onSuccess(HomeBean homeBean) {
                    if (homeBean.getHomeStatus() == 1) {
                        iTuyaHomeChangeListener.onHomeInvite(o0o0ooo0oo.O000000o(), o0o0ooo0oo.O00000o0());
                    }
                }
            });
        }
    }

    private boolean O000000o(o0o0ooo0oo o0o0ooo0oo) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = false;
        int i = 0;
        while (i < this.O00000Oo.size() && !(z = O000000o(this.O00000Oo.valueAt(i), this.O00000Oo.keyAt(i), o0o0ooo0oo, currentTimeMillis))) {
            i++;
        }
        if (!z) {
            this.O00000Oo.put(currentTimeMillis, o0o0ooo0oo);
        }
        return z;
    }

    public static boolean O000000o(o0o0ooo0oo o0o0ooo0oo, long j, o0o0ooo0oo o0o0ooo0oo2, long j2) {
        return o0o0ooo0oo.O000000o() == o0o0ooo0oo2.O000000o() && o0o0ooo0oo.O00000Oo() == o0o0ooo0oo2.O00000Oo() && j2 - j < 1000;
    }

    public static o0o0ooo0o O00000Oo() {
        if (O0000OOo == null) {
            synchronized (o0o0ooo0o.class) {
                if (O0000OOo == null) {
                    O0000OOo = new o0o0ooo0o();
                }
            }
        }
        return O0000OOo;
    }

    private List<ITuyaHomeStatusListener> O00000Oo(long j) {
        return this.O00000o0.get(j);
    }

    private void O00000Oo(o0o0ooo0oo o0o0ooo0oo) {
        if (!O000000o(o0o0ooo0oo)) {
            if (o0o0ooo0oo.O00000Oo() == 0) {
                TuyaHomeRelationCacheManager.O000000o().removeHome(o0o0ooo0oo.O000000o());
                CopyOnWriteArrayList<ITuyaHomeChangeListener> copyOnWriteArrayList = this.O0000O0o;
                if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                    Iterator<ITuyaHomeChangeListener> it = this.O0000O0o.iterator();
                    while (it.hasNext()) {
                        it.next().onHomeRemoved(o0o0ooo0oo.O000000o());
                    }
                }
            } else if (o0o0ooo0oo.O00000Oo() == 1) {
                CopyOnWriteArrayList<ITuyaHomeChangeListener> copyOnWriteArrayList2 = this.O0000O0o;
                if (copyOnWriteArrayList2 != null && copyOnWriteArrayList2.size() > 0) {
                    Iterator<ITuyaHomeChangeListener> it2 = this.O0000O0o.iterator();
                    while (it2.hasNext()) {
                        ITuyaHomeChangeListener next = it2.next();
                        next.onHomeAdded(o0o0ooo0oo.O000000o());
                        O000000o(next, o0o0ooo0oo);
                    }
                }
            } else if (o0o0ooo0oo.O00000Oo() == 2) {
                HomeBean O000000o2 = o0o00o000.O000000o().O000000o(o0o0ooo0oo.O000000o());
                if (O000000o2 != null) {
                    O000000o2.setName(o0o0ooo0oo.O00000o0());
                }
                CopyOnWriteArrayList<ITuyaHomeChangeListener> copyOnWriteArrayList3 = this.O0000O0o;
                if (copyOnWriteArrayList3 != null && copyOnWriteArrayList3.size() > 0) {
                    Iterator<ITuyaHomeChangeListener> it3 = this.O0000O0o.iterator();
                    while (it3.hasNext()) {
                        it3.next().onHomeInfoChanged(o0o0ooo0oo.O000000o());
                    }
                }
            }
        }
    }

    private List<ITuyaHomeDeviceStatusListener> O00000o0(long j) {
        return this.O00000o.get(j);
    }

    private void O00000oO() {
        o0o00o0ooo o0o00o0ooo = (o0o00o0ooo) Oo0.O000000o(o0o00o0ooo.class);
        if (o0o00o0ooo != null) {
            o0o00o0ooo.O000000o(new ITuyaResultCallback<List<DeviceRespBean>>() {
                /* renamed from: O000000o */
                public void onSuccess(List<DeviceRespBean> list) {
                    Iterator<DeviceBean> it = TuyaHomeRelationCacheManager.O000000o().getShareDeviceList().iterator();
                    while (true) {
                        boolean z = true;
                        if (!it.hasNext()) {
                            break;
                        }
                        String devId = it.next().getDevId();
                        Iterator<DeviceRespBean> it2 = list.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (TextUtils.equals(devId, it2.next().getDevId())) {
                                    break;
                                }
                            } else {
                                z = false;
                                break;
                            }
                        }
                        if (!z) {
                            TuyaHomeRelationCacheManager.O000000o().removeShareDevice(devId);
                        }
                    }
                    Iterator<DeviceRespBean> it3 = list.iterator();
                    while (it3.hasNext()) {
                        DeviceRespBean next = it3.next();
                        DeviceBean dev = o0o0ooo0o.this.O0000Oo0.O0000o00().getDev(next.getDevId());
                        if (dev == null || dev.getIsShare().booleanValue()) {
                            next.setIsShare(true);
                            TuyaHomeRelationCacheManager.O000000o().addShareDevToPersonal(next.getDevId());
                        } else {
                            it3.remove();
                        }
                    }
                    o0o0ooo0o.this.O0000Oo0.O0000o00().getSchema(list, o0o0ooo0o.this.O0000OoO);
                }

                public void onError(String str, String str2) {
                    L.e(o0o0ooo0o.O000000o, "ShareListChangedEventModel dev: code:" + str + " msg:" + str2);
                }
            });
        }
        if (o0o00o0ooo != null) {
            o0o00o0ooo.O00000Oo(new ITuyaResultCallback<List<GroupRespBean>>() {
                /* renamed from: O000000o */
                public void onSuccess(List<GroupRespBean> list) {
                    Iterator<GroupBean> it = TuyaHomeRelationCacheManager.O000000o().getShareGroupList().iterator();
                    while (true) {
                        boolean z = true;
                        if (!it.hasNext()) {
                            break;
                        }
                        long id = it.next().getId();
                        Iterator<GroupRespBean> it2 = list.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (id == it2.next().getId()) {
                                    break;
                                }
                            } else {
                                z = false;
                                break;
                            }
                        }
                        if (!z) {
                            TuyaHomeRelationCacheManager.O000000o().removeShareGroup(id);
                        }
                    }
                    Iterator<GroupRespBean> it3 = list.iterator();
                    while (it3.hasNext()) {
                        GroupRespBean next = it3.next();
                        GroupBean groupBean = o0o0ooo0o.this.O0000Oo0.O0000o00().getGroupBean(next.getId());
                        if (groupBean == null || groupBean.isShare()) {
                            next.setShare(true);
                            TuyaHomeRelationCacheManager.O000000o().addShareGroupToPersonal(next.getId());
                        } else {
                            it3.remove();
                        }
                    }
                    o0o0ooo0o.this.O0000Oo0.O0000o00().getGroupSchema(list, o0o0ooo0o.this.O0000Ooo);
                }

                public void onError(String str, String str2) {
                    L.e(o0o0ooo0o.O000000o, "ShareListChangedEventModel group: code:" + str + " msg:" + str2);
                }
            });
        }
    }

    public void O000000o() {
        CopyOnWriteArrayList<ITuyaHomeChangeListener> copyOnWriteArrayList = this.O0000O0o;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<ITuyaHomeChangeListener> it = this.O0000O0o.iterator();
            while (it.hasNext()) {
                L.d(O000000o, "onConnectSuccess");
                it.next().onServerConnectSuccess();
            }
        }
    }

    public void O000000o(long j) {
        this.O00000o0.remove(j);
    }

    public void O000000o(long j, ITuyaHomeDeviceStatusListener iTuyaHomeDeviceStatusListener) {
        List list;
        O00000o0();
        synchronized (this) {
            list = this.O00000o.get(j);
            if (list == null) {
                list = new ArrayList();
                this.O00000o.put(j, list);
            }
        }
        list.add(iTuyaHomeDeviceStatusListener);
    }

    public void O000000o(long j, ITuyaHomeStatusListener iTuyaHomeStatusListener) {
        List list;
        O00000o0();
        synchronized (this) {
            list = this.O00000o0.get(j);
            if (list == null) {
                list = new ArrayList();
                this.O00000o0.put(j, list);
            }
        }
        list.add(iTuyaHomeStatusListener);
    }

    public void O000000o(long j, IWarningMsgListener iWarningMsgListener) {
        O00000o0();
        this.O00000oO = iWarningMsgListener;
    }

    public void O000000o(ITuyaHomeChangeListener iTuyaHomeChangeListener) {
        CopyOnWriteArrayList<ITuyaHomeChangeListener> copyOnWriteArrayList;
        O00000o0();
        if (iTuyaHomeChangeListener != null && (copyOnWriteArrayList = this.O0000O0o) != null && !copyOnWriteArrayList.contains(iTuyaHomeChangeListener)) {
            this.O0000O0o.add(iTuyaHomeChangeListener);
        }
    }

    public void O000000o(String str) {
        List<ITuyaHomeDeviceStatusListener> O00000o02 = O00000o0(TuyaHomeRelationCacheManager.O000000o().getHomeIdByDevId(str));
        if (O00000o02 != null && O00000o02.size() > 0) {
            for (ITuyaHomeDeviceStatusListener onDeviceInfoUpdate : O00000o02) {
                onDeviceInfoUpdate.onDeviceInfoUpdate(str);
            }
        }
    }

    public void O000000o(String str, String str2) {
    }

    public void O000000o(String str, String str2, boolean z) {
        List<ITuyaHomeDeviceStatusListener> O00000o02;
        CopyOnWriteArrayList<ITuyaHomeChangeListener> copyOnWriteArrayList = this.O0000O0o;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0 && (O00000o02 = O00000o0(TuyaHomeRelationCacheManager.O000000o().getHomeIdByDevId(str))) != null && O00000o02.size() > 0) {
            for (ITuyaHomeDeviceStatusListener onDeviceDpUpdate : O00000o02) {
                onDeviceDpUpdate.onDeviceDpUpdate(str, str2);
            }
        }
    }

    public void O000000o(String str, boolean z) {
        List<ITuyaHomeDeviceStatusListener> O00000o02 = O00000o0(TuyaHomeRelationCacheManager.O000000o().getHomeIdByDevId(str));
        if (O00000o02 != null && O00000o02.size() > 0) {
            for (ITuyaHomeDeviceStatusListener onDeviceStatusChanged : O00000o02) {
                onDeviceStatusChanged.onDeviceStatusChanged(str, z);
            }
        }
    }

    public void O00000Oo(long j, ITuyaHomeDeviceStatusListener iTuyaHomeDeviceStatusListener) {
        synchronized (this) {
            List<ITuyaHomeDeviceStatusListener> O00000o02 = O00000o0(j);
            if (O00000o02 != null && O00000o02.size() > 0) {
                O00000o02.remove(iTuyaHomeDeviceStatusListener);
            }
        }
    }

    public void O00000Oo(long j, ITuyaHomeStatusListener iTuyaHomeStatusListener) {
        synchronized (this) {
            List<ITuyaHomeStatusListener> O00000Oo2 = O00000Oo(j);
            if (O00000Oo2 != null && O00000Oo2.size() > 0) {
                O00000Oo2.remove(iTuyaHomeStatusListener);
            }
        }
    }

    public void O00000Oo(long j, IWarningMsgListener iWarningMsgListener) {
        this.O00000oO = null;
    }

    public void O00000Oo(ITuyaHomeChangeListener iTuyaHomeChangeListener) {
        CopyOnWriteArrayList<ITuyaHomeChangeListener> copyOnWriteArrayList;
        if (iTuyaHomeChangeListener != null && (copyOnWriteArrayList = this.O0000O0o) != null && !copyOnWriteArrayList.isEmpty()) {
            this.O0000O0o.remove(iTuyaHomeChangeListener);
        }
    }

    public void O00000o() {
        L.d(O000000o, "onDestroy");
        if (this.O00000oo) {
            this.O00000oo = false;
            this.O00000o0.clear();
            this.O00000o.clear();
            this.O00000Oo.clear();
            this.O0000O0o.clear();
            TuyaSdk.getEventBus().unregister(this);
            o0o00o00o0 o0o00o00o0 = this.O0000Oo0;
            if (o0o00o00o0 != null) {
                o0o00o00o0.O0000o00().unRegisterDeviceMqttListener(o0o0ooo00o.class, this);
                this.O0000Oo0.O0000o00().unRegisterDeviceMqttListener(o0o0ooo0o0.class, this);
                this.O0000Oo0.O0000o00().unRegisterDeviceMqttListener(o0o0o0oooo.class, this);
                this.O0000Oo0.O0000o00().unRegisterDeviceMqttListener(o0o0ooo0oo.class, this);
                this.O0000Oo0.O0000o00().unRegisterDeviceMqttListener(o0oo0000oo.class, this);
                this.O0000Oo0.O0000o00().unRegisterDeviceDpUpdateListener(this);
                this.O0000Oo0.O0000o00().unRegisterDeviceInfoChangeListener(this);
                this.O0000Oo0.O0000o00().unRegisterDeviceOnlineStatusListener(this);
            }
            o0o00o0oo0 o0o00o0oo0 = this.O0000Oo;
            if (o0o00o0oo0 != null) {
                o0o00o0oo0.O000000o().O00000Oo((o0oo0oo00o) this);
            }
        }
    }

    public void O00000o0() {
        L.d(O000000o, "onStart");
        if (!this.O00000oo) {
            this.O00000oo = true;
            TuyaSdk.getEventBus().register(this);
            o0o00o00o0 o0o00o00o0 = this.O0000Oo0;
            if (o0o00o00o0 != null) {
                o0o00o00o0.O0000o00().registerDeviceMqttListener(o0o0ooo00o.class, this);
                this.O0000Oo0.O0000o00().registerDeviceMqttListener(o0o0ooo0o0.class, this);
                this.O0000Oo0.O0000o00().registerDeviceMqttListener(o0o0o0oooo.class, this);
                this.O0000Oo0.O0000o00().registerDeviceMqttListener(o0o0ooo0oo.class, this);
                this.O0000Oo0.O0000o00().registerDeviceMqttListener(o0oo0000oo.class, this);
                this.O0000Oo0.O0000o00().registerDeviceDpUpdateListener(this);
                this.O0000Oo0.O0000o00().registerDeviceInfoChangeListener(this);
                this.O0000Oo0.O0000o00().registerDeviceOnlineStatusListener(this);
            }
            o0o00o0oo0 o0o00o0oo0 = this.O0000Oo;
            if (o0o00o0oo0 != null) {
                o0o00o0oo0.O000000o().O000000o((o0oo0oo00o) this);
            }
        }
    }

    public void onEventMainThread(o0o0ooo0oo o0o0ooo0oo) {
        O00000Oo(o0o0ooo0oo);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onEventMainThread(com.tuya.smart.interior.event.DeviceUpdateEventModel r9) {
        /*
            r8 = this;
            java.lang.String r0 = "TuyaReleationListenerManager"
            java.lang.String r1 = "deviceUpdateEventModel"
            com.tuya.smart.android.common.utils.L.d(r0, r1)
            long r1 = r9.getHomeId()
            int r3 = r9.getMode()
            java.lang.String r4 = " devId: "
            r5 = 0
            if (r3 != 0) goto L_0x0162
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x004b
            java.lang.String r3 = "devId: "
            java.lang.StringBuilder r3 = a.a.a.a.a.n(r3)
            java.lang.String r4 = r9.getDevId()
            r3.append(r4)
            java.lang.String r4 = " homeId: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            com.tuya.smart.android.common.utils.L.d(r0, r3)
            com.tuya.smart.home.sdk.api.IHomeCacheManager r3 = com.tuya.sdk.home.cache.TuyaHomeRelationCacheManager.O000000o()
            java.lang.String r4 = r9.getDevId()
            long r3 = r3.getHomeIdByDevId(r4)
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x0133
            java.lang.String r9 = "devId is home , need not add the relation again"
            com.tuya.smart.android.common.utils.L.d(r0, r9)
            return
        L_0x004b:
            java.lang.String r3 = r9.getMeshId()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x013e
            com.tuya.smart.common.o0o00o00o0 r1 = r8.O0000Oo0
            com.tuya.smart.common.o0o0o0000o r1 = r1.O0000OoO()
            java.lang.String r2 = r9.getMeshId()
            com.tuya.smart.sdk.bean.DeviceBean r1 = r1.O00000Oo((java.lang.String) r2)
            if (r1 == 0) goto L_0x00ae
            com.tuya.smart.home.sdk.api.IHomeCacheManager r2 = com.tuya.sdk.home.cache.TuyaHomeRelationCacheManager.O000000o()
            java.lang.String r3 = r1.getDevId()
            long r2 = r2.getHomeIdByDevId(r3)
            java.lang.String r5 = r1.getMeshId()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0099
            com.tuya.smart.home.sdk.api.IHomeCacheManager r5 = com.tuya.sdk.home.cache.TuyaHomeRelationCacheManager.O000000o()
            java.lang.String r6 = r1.getMeshId()
            java.lang.String r7 = r9.getDevId()
            r5.addDevToMesh(r6, r7)
            com.tuya.smart.home.sdk.api.IHomeCacheManager r5 = com.tuya.sdk.home.cache.TuyaHomeRelationCacheManager.O000000o()
            java.lang.String r1 = r1.getDevId()
            java.lang.String r6 = r9.getDevId()
            r5.addDevToMesh(r1, r6)
        L_0x0099:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "zigbee homeId: "
            r1.append(r5)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.tuya.smart.android.common.utils.L.d(r0, r1)
            goto L_0x0114
        L_0x00ae:
            com.tuya.smart.home.sdk.api.IHomeCacheManager r1 = com.tuya.sdk.home.cache.TuyaHomeRelationCacheManager.O000000o()
            java.lang.String r2 = r9.getMeshId()
            long r2 = r1.getHomeIdByMeshId(r2)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "mesh homeId: "
            r1.append(r5)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.tuya.smart.android.common.utils.L.d(r0, r1)
            com.tuya.smart.home.sdk.api.IHomeCacheManager r1 = com.tuya.sdk.home.cache.TuyaHomeRelationCacheManager.O000000o()
            java.lang.String r5 = r9.getMeshId()
            java.lang.String r6 = r9.getDevId()
            r1.addDevToMesh(r5, r6)
            com.tuya.smart.common.o0o00o00o0 r1 = r8.O0000Oo0
            com.tuya.smart.common.o0o0o0000o r1 = r1.O0000OoO()
            java.lang.String r5 = r9.getDevId()
            com.tuya.smart.sdk.bean.DeviceBean r1 = r1.O00000Oo((java.lang.String) r5)
            if (r1 == 0) goto L_0x0114
            java.lang.String r5 = r1.getParentId()
            java.lang.String r6 = r9.getMeshId()
            boolean r5 = android.text.TextUtils.equals(r5, r6)
            if (r5 != 0) goto L_0x0114
            java.lang.String r5 = r1.getParentId()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0114
            com.tuya.smart.home.sdk.api.IHomeCacheManager r5 = com.tuya.sdk.home.cache.TuyaHomeRelationCacheManager.O000000o()
            java.lang.String r6 = r1.getParentId()
            java.lang.String r1 = r1.getDevId()
            r5.addDevToMesh(r6, r1)
        L_0x0114:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "device add homeId: "
            r1.append(r5)
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r9.getDevId()
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            com.tuya.smart.android.common.utils.L.d(r0, r1)
            r1 = r2
        L_0x0133:
            com.tuya.smart.home.sdk.api.IHomeCacheManager r0 = com.tuya.sdk.home.cache.TuyaHomeRelationCacheManager.O000000o()
            java.lang.String r3 = r9.getDevId()
            r0.addDevToHome(r1, r3)
        L_0x013e:
            java.util.List r0 = r8.O00000Oo((long) r1)
            if (r0 == 0) goto L_0x0201
            int r1 = r0.size()
            if (r1 <= 0) goto L_0x0201
            java.util.Iterator r0 = r0.iterator()
        L_0x014e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0201
            java.lang.Object r1 = r0.next()
            com.tuya.smart.home.sdk.api.ITuyaHomeStatusListener r1 = (com.tuya.smart.home.sdk.api.ITuyaHomeStatusListener) r1
            java.lang.String r2 = r9.getDevId()
            r1.onDeviceAdded(r2)
            goto L_0x014e
        L_0x0162:
            int r3 = r9.getMode()
            r7 = 1
            if (r3 != r7) goto L_0x0201
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 > 0) goto L_0x01b4
            java.lang.String r3 = r9.getMeshId()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x01b4
            com.tuya.smart.common.o0o00o00o0 r1 = r8.O0000Oo0
            com.tuya.smart.common.o0o0o0000o r1 = r1.O0000OoO()
            java.lang.String r2 = r9.getMeshId()
            com.tuya.smart.sdk.bean.DeviceBean r1 = r1.O00000Oo((java.lang.String) r2)
            if (r1 == 0) goto L_0x01a8
            com.tuya.smart.home.sdk.api.IHomeCacheManager r1 = com.tuya.sdk.home.cache.TuyaHomeRelationCacheManager.O000000o()
            java.lang.String r2 = r9.getMeshId()
            long r1 = r1.getHomeIdByDevId(r2)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "del: zigbee homeId: "
            r3.append(r5)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            com.tuya.smart.android.common.utils.L.d(r0, r3)
            goto L_0x01b4
        L_0x01a8:
            com.tuya.smart.home.sdk.api.IHomeCacheManager r1 = com.tuya.sdk.home.cache.TuyaHomeRelationCacheManager.O000000o()
            java.lang.String r2 = r9.getMeshId()
            long r1 = r1.getHomeIdByMeshId(r2)
        L_0x01b4:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "device del homeId: "
            r3.append(r5)
            r3.append(r1)
            r3.append(r4)
            java.lang.String r4 = r9.getDevId()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.tuya.smart.android.common.utils.L.d(r0, r3)
            com.tuya.smart.home.sdk.api.IHomeCacheManager r0 = com.tuya.sdk.home.cache.TuyaHomeRelationCacheManager.O000000o()
            java.lang.String r3 = r9.getDevId()
            r0.removeDevice(r3)
            java.util.List r0 = r8.O00000Oo((long) r1)
            if (r0 == 0) goto L_0x0201
            int r1 = r0.size()
            if (r1 <= 0) goto L_0x0201
            java.util.Iterator r0 = r0.iterator()
        L_0x01ed:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0201
            java.lang.Object r1 = r0.next()
            com.tuya.smart.home.sdk.api.ITuyaHomeStatusListener r1 = (com.tuya.smart.home.sdk.api.ITuyaHomeStatusListener) r1
            java.lang.String r2 = r9.getDevId()
            r1.onDeviceRemoved(r2)
            goto L_0x01ed
        L_0x0201:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.o0o0ooo0o.onEventMainThread(com.tuya.smart.interior.event.DeviceUpdateEventModel):void");
    }

    public void onResult(Object obj) {
        if (obj instanceof o0o0ooo00o) {
            O000000o((o0o0ooo00o) obj);
        } else if (obj instanceof o0o0ooo0o0) {
            O000000o((o0o0ooo0o0) obj);
        } else if (obj instanceof o0o0ooo0oo) {
            O00000Oo((o0o0ooo0oo) obj);
        } else if (obj instanceof o0o0o0oooo) {
            O00000oO();
        } else if (obj instanceof o0oo0000oo) {
            O000000o((o0oo0000oo) obj);
        }
    }
}
