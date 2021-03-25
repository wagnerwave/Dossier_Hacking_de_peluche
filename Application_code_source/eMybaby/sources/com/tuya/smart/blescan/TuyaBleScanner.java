package com.tuya.smart.blescan;

import a.a.a.a.a;
import a.c.a.f.b;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.inuker.bluetooth.library.search.SearchRequest;
import com.inuker.bluetooth.library.search.SearchTask;
import com.tuya.smart.blescan.utils.SafeHandler;
import com.tuya.smart.blescan.utils.ScanLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

public class TuyaBleScanner implements Handler.Callback, ITuyaBleScanner, LeScanResponse {
    public static final String TAG = "TuyaBleScanner";
    public static final int TIME_OUT_SCAN = -1;
    public static final long WAIT_TIME = 2000;
    public static volatile TuyaBleScanner mTuyaBleScanner;
    public BleScanner iBleScanner;
    public long lastStopTime = 0;
    public SafeHandler mHandler;
    public final CopyOnWriteArrayList<ScanRequest> requestList;

    public TuyaBleScanner(Context context) {
        this.iBleScanner = new BleScanner(context);
        this.requestList = new CopyOnWriteArrayList<>();
        this.mHandler = new SafeHandler(Looper.getMainLooper(), (Handler.Callback) this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:1:0x000b A[LOOP:0: B:1:0x000b->B:4:0x001b, LOOP_START, PHI: r1 
      PHI: (r1v1 boolean) = (r1v0 boolean), (r1v5 boolean) binds: [B:0:0x0000, B:4:0x001b] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean cacheFilter(com.tuya.smart.blescan.ScanRequest r4) {
        /*
            r3 = this;
            com.tuya.smart.blescan.ScanCache r0 = com.tuya.smart.blescan.ScanCache.INSTANCE
            java.util.List r0 = r0.getCacheBeanList()
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L_0x000b:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x001d
            java.lang.Object r1 = r0.next()
            com.tuya.smart.blescan.ScanLeBean r1 = (com.tuya.smart.blescan.ScanLeBean) r1
            boolean r1 = r3.filterRequestTask(r4, r1)
            if (r1 == 0) goto L_0x000b
        L_0x001d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.blescan.TuyaBleScanner.cacheFilter(com.tuya.smart.blescan.ScanRequest):boolean");
    }

    private void clearAllRequest() {
        this.mHandler.removeCallbacksAndMessages((Object) null);
        notifyRequestForStop();
    }

    private boolean filterRequestTask(ScanRequest scanRequest, ScanLeBean scanLeBean) {
        if (scanRequest.getScanFilter() == null) {
            scanRequest.getResponse().onDeviceFounded(scanLeBean);
            return false;
        } else if (!scanRequest.getScanFilter().filter(scanLeBean)) {
            return false;
        } else {
            ScanCache.INSTANCE.add(scanLeBean);
            boolean filterOnly = scanRequest.getScanFilter().filterOnly(scanLeBean);
            scanRequest.getResponse().onDeviceFounded(scanLeBean);
            if (!filterOnly) {
                return false;
            }
            scanRequest.getResponse().onScanStop();
            return true;
        }
    }

    private SearchRequest getDefaultSearchRequest() {
        ArrayList arrayList = new ArrayList();
        if (b.P()) {
            SearchTask searchTask = new SearchTask();
            searchTask.f4339a = 2;
            searchTask.f4340b = -1;
            arrayList.add(searchTask);
        }
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.f4335a = arrayList;
        return searchRequest;
    }

    public static ITuyaBleScanner newInstance(Context context) {
        if (mTuyaBleScanner == null) {
            synchronized (TuyaBleScanner.class) {
                if (mTuyaBleScanner == null) {
                    if (context instanceof Activity) {
                        context = context.getApplicationContext();
                    }
                    mTuyaBleScanner = new TuyaBleScanner(context);
                }
            }
        }
        return mTuyaBleScanner;
    }

    private void notifyDeviceResponse(ScanLeBean scanLeBean) {
        Iterator<ScanRequest> it = this.requestList.iterator();
        while (it.hasNext()) {
            ScanRequest next = it.next();
            if (filterRequestTask(next, scanLeBean)) {
                this.requestList.remove(next);
                this.mHandler.removeMessages(0, next);
                if (this.requestList.size() == 0) {
                    stopScan();
                }
            }
        }
    }

    private synchronized void notifyRequestForStop() {
        ArrayList arrayList = new ArrayList(this.requestList);
        this.requestList.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ScanRequest) it.next()).getResponse().onScanCancel();
        }
        arrayList.clear();
    }

    private synchronized void removeOneRequest(ScanRequest scanRequest, boolean z) {
        if (z) {
            scanRequest.getResponse().onScanStop();
        } else {
            scanRequest.getResponse().onScanCancel();
        }
        this.requestList.remove(scanRequest);
        if (this.requestList.size() == 0) {
            stopScan();
        }
    }

    private void start(ScanRequest scanRequest) {
        this.requestList.add(scanRequest);
        scanRequest.getResponse().onScanStart();
        Message message = new Message();
        message.obj = scanRequest;
        message.what = 0;
        this.mHandler.sendMessageDelayed(message, scanRequest.getDuration());
    }

    /* access modifiers changed from: private */
    public void startRequest(ScanRequest scanRequest) {
        start(scanRequest);
        ScanLog.i(TAG, "addScanRequest: request = " + scanRequest + ", time = " + scanRequest.getDuration() + ",size = " + this.requestList.size());
        this.iBleScanner.startLeScan(getDefaultSearchRequest(), this);
    }

    public void addScanRequest(final ScanRequest scanRequest) {
        if (scanRequest != null) {
            if (this.requestList.contains(scanRequest)) {
                ScanLog.e(TAG, "addScanRequest: already have the task , request = " + scanRequest);
                return;
            }
            if (scanRequest.getType() == FilterTypeEnum.CLEAR) {
                clearAllRequest();
            } else if (scanRequest.getType() == FilterTypeEnum.CACHE && cacheFilter(scanRequest)) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.lastStopTime;
            if (currentTimeMillis < 2000) {
                new Timer().schedule(new TimerTask() {
                    public void run() {
                        TuyaBleScanner.this.startRequest(scanRequest);
                    }
                }, 2000 - currentTimeMillis);
            } else {
                startRequest(scanRequest);
            }
        }
    }

    public void clearCache() {
        ScanCache.INSTANCE.removeAll();
    }

    public boolean handleMessage(Message message) {
        StringBuilder n = a.n("handleMessage: msg.what = ");
        n.append(message.what);
        n.append(", msg.obj = ");
        n.append(message.obj);
        n.append(",size = ");
        n.append(this.requestList.size());
        ScanLog.d(TAG, n.toString());
        removeOneRequest((ScanRequest) message.obj, true);
        StringBuilder n2 = a.n("handleMessage2: msg.what = ");
        n2.append(message.what);
        n2.append(", msg.obj = ");
        n2.append(message.obj);
        n2.append(",remain size = ");
        n2.append(this.requestList.size());
        ScanLog.d(TAG, n2.toString());
        return false;
    }

    public void onDeviceFounded(ScanLeBean scanLeBean) {
        notifyDeviceResponse(scanLeBean);
    }

    public void onScanCancel() {
        ScanLog.d(TAG, "master onScanCancel() called");
        clearAllRequest();
    }

    public void onScanStart() {
        ScanLog.d(TAG, "master onScanStart() called");
    }

    public void onScanStop() {
        ScanLog.d(TAG, "master onScanStop() called");
        clearAllRequest();
    }

    public void removeScanRequest(ScanRequest scanRequest) {
        ScanLog.d(TAG, "remove request " + scanRequest);
        if (scanRequest != null && this.requestList.contains(scanRequest)) {
            this.mHandler.removeMessages(0, scanRequest);
            removeOneRequest(scanRequest, false);
        }
    }

    public void stopScan() {
        Log.e(TAG, "stopScan: ");
        this.lastStopTime = System.currentTimeMillis();
        this.iBleScanner.stopLeScan();
    }
}
