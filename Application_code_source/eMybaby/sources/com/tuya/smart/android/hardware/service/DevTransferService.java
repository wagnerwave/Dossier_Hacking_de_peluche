package com.tuya.smart.android.hardware.service;

import a.a.a.a.a;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.tuya.sdk.hardware.bean.HResponse;
import com.tuya.smart.android.common.utils.HexUtil;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.TuyaConcurrentList;
import com.tuya.smart.android.device.TuyaNetworkInterface;
import com.tuya.smart.android.device.callback.LinkCloseCallback;
import com.tuya.smart.android.device.callback.ReadResponseDataCallback;
import com.tuya.smart.android.hardware.ITransferAidlInterface;
import com.tuya.smart.android.hardware.ITransferServiceAidlInterface;
import com.tuya.smart.android.hardware.bean.HgwBean;
import com.tuya.smart.android.hardware.bean.TuyaFrame;
import com.tuya.smart.common.o000o0ooo;
import com.tuya.smart.common.o000oo000;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DevTransferService extends Service {
    public static final String SERVICE_VERSION = "2.5";
    public static final String TAG = "DevTransferService";
    public Map<String, HgwBean> liveGw;
    public ReentrantReadWriteLock lock;
    public Map<String, HgwBean> mTCPConnectMap;
    public TuyaConcurrentList<ITransferAidlInterface> mTransfer;
    public ITransferServiceAidlInterface.Stub mTransferServiceAidlInterface = new ITransferServiceAidlInterface.Stub() {
        public void addGw(HgwBean hgwBean) {
            DevTransferService.this.addDev(hgwBean);
        }

        public void closeService() {
            L.d(DevTransferService.TAG, "closeService");
            ArrayList arrayList = new ArrayList(DevTransferService.this.mTransfer.getList());
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ITransferAidlInterface iTransferAidlInterface = (ITransferAidlInterface) it.next();
                try {
                    L.d(DevTransferService.TAG, "closeService" + iTransferAidlInterface.getAppId());
                    iTransferAidlInterface.closeService();
                } catch (RemoteException e2) {
                    L.e(DevTransferService.TAG, e2.getMessage());
                    arrayList2.add(iTransferAidlInterface);
                }
            }
            DevTransferService.this.mTransfer.removeAll(arrayList2);
        }

        public boolean controlByBinary(String str, int i, byte[] bArr) {
            return DevTransferService.this.controlByBinary(str, i, bArr);
        }

        public void deleteGw(String str) {
            DevTransferService.this.deleteDev(str);
        }

        public HgwBean getGw(String str) {
            if (DevTransferService.this.liveGw == null || !DevTransferService.this.liveGw.containsKey(str)) {
                return null;
            }
            return (HgwBean) DevTransferService.this.liveGw.get(str);
        }

        public String getServiceVersion() {
            return DevTransferService.SERVICE_VERSION;
        }

        public List<HgwBean> queryGw() {
            if (L.getLogStatus()) {
                L.d(DevTransferService.TAG, JSON.toJSONString(DevTransferService.this.liveGw));
            }
            if (DevTransferService.this.liveGw == null) {
                return null;
            }
            return new ArrayList(DevTransferService.this.liveGw.values());
        }

        public void registerCallback(ITransferAidlInterface iTransferAidlInterface) {
            DevTransferService.this.mTransfer.add(iTransferAidlInterface);
        }

        public void unRegisterCallback(final String str) {
            final ArrayList arrayList = new ArrayList();
            DevTransferService.this.mTransfer.query(new TuyaConcurrentList.QueryListCallback<ITransferAidlInterface>() {
                public void query(ITransferAidlInterface iTransferAidlInterface) {
                    try {
                        if (TextUtils.equals(str, iTransferAidlInterface.getAppId())) {
                            arrayList.add(iTransferAidlInterface);
                        }
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
            });
            DevTransferService.this.mTransfer.removeAll(arrayList);
        }
    };
    public Map<String, HgwBean> offlineGw;

    /* JADX INFO: finally extract failed */
    private void buildConnect(final HgwBean hgwBean) {
        int connectDevice = TuyaNetworkInterface.connectDevice(hgwBean.getGwId());
        StringBuilder sb = new StringBuilder();
        if (connectDevice <= 0) {
            sb.append("gw connect failure");
            sb.append(hgwBean.getGwId());
            sb.append(" connectResult: ");
            sb.append(connectDevice);
            L.e(TAG, sb.toString());
            onGwOnlineChanged(hgwBean.gwId, false);
            return;
        }
        sb.append("connectResult: ");
        sb.append(connectDevice);
        L.d(TAG, sb.toString());
        try {
            this.lock.writeLock().lock();
            this.mTCPConnectMap.put(hgwBean.getGwId(), hgwBean);
            this.lock.writeLock().unlock();
            onGwOnlineChanged(hgwBean.getGwId(), true);
            TuyaNetworkInterface.getInstance().addReadResDataCallback(hgwBean.getGwId(), new ReadResponseDataCallback() {
                public void OnResponseDataCallback(String str, TuyaFrame tuyaFrame) {
                    HResponse hResponse = new HResponse();
                    hResponse.setCode(tuyaFrame.code);
                    hResponse.setDataBinary(tuyaFrame.data);
                    hResponse.setDevId(hgwBean.getGwId());
                    hResponse.setSeq(tuyaFrame.seq);
                    hResponse.setType(tuyaFrame.type);
                    hResponse.setVersion(hgwBean.getVersion());
                    DevTransferService.this.onResult(hResponse);
                }
            });
            TuyaNetworkInterface.getInstance().addLinkCloseCallback(hgwBean.getGwId(), new LinkCloseCallback() {
                public void OnLinkCloseCallback(String str) {
                    DevTransferService.this.onGwOnlineChanged(hgwBean.getGwId(), false);
                }
            });
        } catch (Throwable th) {
            this.lock.writeLock().unlock();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public void onGwOnlineChanged(String str, boolean z) {
        L.d(TAG, "onGwOnlineChanged: " + str + " status: " + z);
        if (!z) {
            if (this.liveGw.containsKey(str)) {
                final HgwBean hgwBean = this.liveGw.get(str);
                this.liveGw.remove(str);
                this.mTransfer.query(new TuyaConcurrentList.QueryListCallback<ITransferAidlInterface>() {
                    public void query(ITransferAidlInterface iTransferAidlInterface) {
                        try {
                            iTransferAidlInterface.gwOff(hgwBean);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            } else {
                this.offlineGw.remove(str);
            }
            if (this.mTCPConnectMap.containsKey(str)) {
                try {
                    this.lock.writeLock().lock();
                    this.mTCPConnectMap.remove(str);
                } finally {
                    this.lock.writeLock().unlock();
                }
            }
        } else if (this.offlineGw.containsKey(str)) {
            final HgwBean hgwBean2 = this.offlineGw.get(str);
            this.liveGw.put(str, hgwBean2);
            this.offlineGw.remove(str);
            this.mTransfer.query(new TuyaConcurrentList.QueryListCallback<ITransferAidlInterface>() {
                public void query(ITransferAidlInterface iTransferAidlInterface) {
                    try {
                        iTransferAidlInterface.gwOn(hgwBean2);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void onResult(final HResponse hResponse) {
        if (L.getLogStatus()) {
            StringBuilder n = a.n("HResponse:  ");
            n.append(JSON.toJSONString(hResponse));
            L.d(TAG, n.toString());
        }
        this.mTransfer.query(new TuyaConcurrentList.QueryListCallback<ITransferAidlInterface>() {
            public void query(ITransferAidlInterface iTransferAidlInterface) {
                try {
                    iTransferAidlInterface.responseByBinary(hResponse.getDevId(), hResponse.getVersion(), hResponse.getType(), hResponse.getSeq(), hResponse.getCode(), hResponse.getDataBinary());
                } catch (Exception e2) {
                    L.e(DevTransferService.TAG, e2.getMessage());
                }
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void addDev(com.tuya.smart.android.hardware.bean.HgwBean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.Map<java.lang.String, com.tuya.smart.android.hardware.bean.HgwBean> r0 = r3.offlineGw     // Catch:{ all -> 0x006f }
            if (r0 == 0) goto L_0x002d
            java.util.Map<java.lang.String, com.tuya.smart.android.hardware.bean.HgwBean> r0 = r3.offlineGw     // Catch:{ all -> 0x006f }
            java.lang.String r1 = r4.getGwId()     // Catch:{ all -> 0x006f }
            boolean r0 = r0.containsKey(r1)     // Catch:{ all -> 0x006f }
            if (r0 == 0) goto L_0x002d
            java.lang.String r0 = "DevTransferService"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x006f }
            r1.<init>()     // Catch:{ all -> 0x006f }
            java.lang.String r2 = "addDev failure: "
            r1.append(r2)     // Catch:{ all -> 0x006f }
            java.lang.String r4 = r4.getGwId()     // Catch:{ all -> 0x006f }
            r1.append(r4)     // Catch:{ all -> 0x006f }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x006f }
            com.tuya.smart.android.common.utils.L.e(r0, r4)     // Catch:{ all -> 0x006f }
            monitor-exit(r3)
            return
        L_0x002d:
            java.util.Map<java.lang.String, com.tuya.smart.android.hardware.bean.HgwBean> r0 = r3.liveGw     // Catch:{ all -> 0x006f }
            if (r0 == 0) goto L_0x006d
            java.util.Map<java.lang.String, com.tuya.smart.android.hardware.bean.HgwBean> r0 = r3.liveGw     // Catch:{ all -> 0x006f }
            java.lang.String r1 = r4.getGwId()     // Catch:{ all -> 0x006f }
            boolean r0 = r0.containsKey(r1)     // Catch:{ all -> 0x006f }
            if (r0 != 0) goto L_0x006d
            java.util.Map<java.lang.String, com.tuya.smart.android.hardware.bean.HgwBean> r0 = r3.mTCPConnectMap     // Catch:{ all -> 0x006f }
            int r0 = r0.size()     // Catch:{ all -> 0x006f }
            r1 = 100
            if (r0 >= r1) goto L_0x006d
            java.lang.String r0 = "DevTransferService"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x006f }
            r1.<init>()     // Catch:{ all -> 0x006f }
            java.lang.String r2 = "addDev: "
            r1.append(r2)     // Catch:{ all -> 0x006f }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x006f }
            r1.append(r2)     // Catch:{ all -> 0x006f }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x006f }
            com.tuya.smart.android.common.utils.L.d(r0, r1)     // Catch:{ all -> 0x006f }
            java.util.Map<java.lang.String, com.tuya.smart.android.hardware.bean.HgwBean> r0 = r3.offlineGw     // Catch:{ all -> 0x006f }
            java.lang.String r1 = r4.getGwId()     // Catch:{ all -> 0x006f }
            r0.put(r1, r4)     // Catch:{ all -> 0x006f }
            r3.buildConnect(r4)     // Catch:{ all -> 0x006f }
        L_0x006d:
            monitor-exit(r3)
            return
        L_0x006f:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.android.hardware.service.DevTransferService.addDev(com.tuya.smart.android.hardware.bean.HgwBean):void");
    }

    public boolean controlByBinary(String str, int i, byte[] bArr) {
        Map<String, HgwBean> map = this.liveGw;
        if (map == null || this.mTCPConnectMap == null || !map.containsKey(str) || !this.mTCPConnectMap.containsKey(str)) {
            L.e(TAG, "dev is not online");
            return false;
        }
        if (L.getLogStatus()) {
            L.d(TAG, "control=;devId=" + str + ";type=" + i + ";data=" + HexUtil.bytesToHexString(bArr));
        }
        int sendBytes = TuyaNetworkInterface.sendBytes(bArr, bArr.length, i, str);
        L.d(TAG, "sendBytes: " + sendBytes);
        if (sendBytes == 1) {
            a.v("remove devId: ", str, TAG);
            onGwOnlineChanged(str, false);
        }
        return sendBytes == 0;
    }

    /* JADX INFO: finally extract failed */
    public synchronized void deleteDev(String str) {
        if (this.liveGw != null && this.liveGw.containsKey(str)) {
            L.d(TAG, "removeDev: " + str);
            TuyaNetworkInterface.getInstance().removeLinkCloseCallback(str);
            this.liveGw.remove(str);
            if (this.mTCPConnectMap.containsKey(str)) {
                try {
                    this.lock.writeLock().lock();
                    this.mTCPConnectMap.remove(str);
                    this.lock.writeLock().unlock();
                } catch (Throwable th) {
                    this.lock.writeLock().unlock();
                    throw th;
                }
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return this.mTransferServiceAidlInterface;
    }

    public void onCreate() {
        super.onCreate();
        L.d(TAG, "GwTransferService onCreate");
        this.liveGw = new ConcurrentHashMap(5);
        this.offlineGw = new ConcurrentHashMap(5);
        this.mTCPConnectMap = new HashMap(5);
        this.lock = new ReentrantReadWriteLock(true);
        this.mTransfer = new TuyaConcurrentList<>();
    }

    public void onDestroy() {
        L.d(TAG, "onDestroy");
        super.onDestroy();
        if (this.mTCPConnectMap != null) {
            try {
                this.lock.writeLock().lock();
                if (!this.mTCPConnectMap.isEmpty()) {
                    for (Map.Entry next : this.mTCPConnectMap.entrySet()) {
                        TuyaNetworkInterface.getInstance().removeLinkCloseCallback((String) next.getKey());
                        TuyaNetworkInterface.getInstance().reomveReadResDataCallback((String) next.getKey());
                    }
                    this.mTCPConnectMap.clear();
                }
            } finally {
                this.lock.writeLock().unlock();
            }
        }
        TuyaNetworkInterface.closeAllConnection();
        Map<String, HgwBean> map = this.liveGw;
        if (map != null) {
            map.clear();
        }
        Map<String, HgwBean> map2 = this.offlineGw;
        if (map2 != null) {
            map2.clear();
        }
        stopForeground(true);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        L.d(TAG, "flags: " + i);
        if (intent == null) {
            L.d(TAG, "startCommand null");
            startForeground(o000oo000.O000000o().O00000o0(), o000oo000.O000000o().O00000Oo());
            return 2;
        }
        if (!intent.getBooleanExtra(o000o0ooo.O000000o, true) && Build.VERSION.SDK_INT >= 26) {
            L.d(TAG, "start Foreground Notification");
            startForeground(o000oo000.O000000o().O00000o0(), o000oo000.O000000o().O00000Oo());
        }
        return 2;
    }
}
