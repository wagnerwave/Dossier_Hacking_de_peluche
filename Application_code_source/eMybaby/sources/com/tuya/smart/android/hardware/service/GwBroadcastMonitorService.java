package com.tuya.smart.android.hardware.service;

import a.a.a.a.a;
import android.app.Service;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.appcompat.widget.TooltipCompatHandler;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.NetworkUtil;
import com.tuya.smart.android.common.utils.TuyaUtil;
import com.tuya.smart.android.device.TuyaNetworkInterface;
import com.tuya.smart.android.device.callback.PackageCallback;
import com.tuya.smart.android.hardware.IUDPBroadcastAidlInterface;
import com.tuya.smart.android.hardware.IUDPMonitorAidlInterface;
import com.tuya.smart.android.hardware.bean.HgwBean;
import com.tuya.smart.common.o000o0o0o;
import com.tuya.smart.common.o000o0ooo;
import com.tuya.smart.common.o000oo000;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class GwBroadcastMonitorService extends Service implements Handler.Callback, PackageCallback {
    public static final long PERIOD = 5000;
    public static final String TAG = "GwBroadcastMonitorService";
    public static final String mVersion = "3.0";
    public AtomicBoolean finished;
    public Map<String, HgwBean> gwMap;
    public Handler handler;
    public Object lock = new Object();
    public IUDPBroadcastAidlInterface.Stub mCallback = new IUDPBroadcastAidlInterface.Stub() {
        public void closeService() {
            synchronized (GwBroadcastMonitorService.this.mMonitor) {
                ArrayList arrayList = new ArrayList();
                for (IUDPMonitorAidlInterface iUDPMonitorAidlInterface : GwBroadcastMonitorService.this.mMonitor) {
                    try {
                        iUDPMonitorAidlInterface.closeService();
                    } catch (RemoteException e2) {
                        L.e(GwBroadcastMonitorService.TAG, e2.getMessage());
                        arrayList.add(iUDPMonitorAidlInterface);
                    }
                }
                GwBroadcastMonitorService.this.mMonitor.removeAll(arrayList);
            }
            L.d(GwBroadcastMonitorService.TAG, "closeService");
            Intent access$300 = GwBroadcastMonitorService.this.getIntent();
            if (access$300 != null) {
                GwBroadcastMonitorService.this.stopService(access$300);
            }
        }

        public String getServiceVersion() {
            return GwBroadcastMonitorService.mVersion;
        }

        public void registerCallback(IUDPMonitorAidlInterface iUDPMonitorAidlInterface) {
            synchronized (GwBroadcastMonitorService.this.mMonitor) {
                GwBroadcastMonitorService.this.mMonitor.add(iUDPMonitorAidlInterface);
            }
        }

        public void start() {
            GwBroadcastMonitorService.this.buildUDPReceiver();
        }

        public void stop() {
            GwBroadcastMonitorService.this.releaseUDPReceiver();
        }

        public void unRegisterCallback(String str) {
            synchronized (GwBroadcastMonitorService.this.mMonitor) {
                for (int i = 0; i < GwBroadcastMonitorService.this.mMonitor.size(); i++) {
                    if (TextUtils.equals(str, ((IUDPMonitorAidlInterface) GwBroadcastMonitorService.this.mMonitor.get(i)).getAppId())) {
                        GwBroadcastMonitorService.this.mMonitor.remove(i);
                    }
                }
            }
        }
    };
    public ExecutorService mExecutorService;
    public volatile boolean mListener;
    public List<IUDPMonitorAidlInterface> mMonitor;
    public Timer mTimer;
    public TuyaNetworkInterface tuyaNetworkInterface;
    public WifiManager.MulticastLock wifiLock;

    public class UpdateTimerTask extends TimerTask {
        public UpdateTimerTask() {
        }

        public void run() {
            L.d(GwBroadcastMonitorService.TAG, "UpdateTimerTask running");
            if (!Thread.interrupted()) {
                L.d(GwBroadcastMonitorService.TAG, "Thread not interrupted");
                if (!GwBroadcastMonitorService.this.finished.get() && GwBroadcastMonitorService.this.gwMap != null) {
                    StringBuilder n = a.n("+++++");
                    n.append(GwBroadcastMonitorService.this.gwMap.size());
                    L.d(GwBroadcastMonitorService.TAG, n.toString());
                    Iterator it = GwBroadcastMonitorService.this.gwMap.entrySet().iterator();
                    while (it.hasNext()) {
                        if (System.currentTimeMillis() - ((HgwBean) ((Map.Entry) it.next()).getValue()).getLastSeenTime() > 5000) {
                            it.remove();
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    synchronized (GwBroadcastMonitorService.this.mMonitor) {
                        ArrayList arrayList2 = new ArrayList(GwBroadcastMonitorService.this.gwMap.values());
                        for (IUDPMonitorAidlInterface iUDPMonitorAidlInterface : GwBroadcastMonitorService.this.mMonitor) {
                            try {
                                iUDPMonitorAidlInterface.update(arrayList2);
                            } catch (RemoteException e2) {
                                arrayList.add(iUDPMonitorAidlInterface);
                                e2.printStackTrace();
                            }
                        }
                        GwBroadcastMonitorService.this.mMonitor.removeAll(arrayList);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void buildUDPReceiver() {
        L.d(TAG, "buildUDPReceiver");
        if (!this.mListener) {
            this.mListener = true;
            WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(NetworkUtil.CONN_TYPE_WIFI);
            if (wifiManager != null) {
                WifiManager.MulticastLock createMulticastLock = wifiManager.createMulticastLock("localWifi");
                this.wifiLock = createMulticastLock;
                createMulticastLock.acquire();
            }
            this.tuyaNetworkInterface = TuyaNetworkInterface.getInstance();
            L.d(TAG, "UDPReceiver running");
            this.tuyaNetworkInterface.addPackageCallback(this);
            TuyaNetworkInterface.setSecurityContent(TuyaUtil.getAssetsData(getApplicationContext(), "fixed_key.bmp", "soisiwoejre".getBytes()));
            TuyaNetworkInterface.enableDebug(L.getLogStatus());
            this.finished.set(false);
            TuyaNetworkInterface.listenUDP(o000o0o0o.O000000o);
            TuyaNetworkInterface.listenUDP(o000o0o0o.O00000Oo);
        }
    }

    /* access modifiers changed from: private */
    public Intent getIntent() {
        Intent intent = new Intent();
        intent.setAction(o000o0o0o.O0000Oo);
        intent.addCategory("tuya");
        return TuyaUtil.getExplicitIntent(this, intent, GwBroadcastMonitorService.class.getName());
    }

    /* access modifiers changed from: private */
    public void releaseUDPReceiver() {
        if (this.mListener) {
            this.mListener = false;
            WifiManager.MulticastLock multicastLock = this.wifiLock;
            if (multicastLock != null) {
                multicastLock.release();
            }
            if (this.tuyaNetworkInterface != null) {
                TuyaNetworkInterface.shutDownUDPListen();
                this.tuyaNetworkInterface = null;
            }
            this.finished.set(true);
        }
    }

    public void getGWBean(HgwBean hgwBean) {
        if (L.getLogStatus()) {
            L.log2(TAG, hgwBean.toString());
        }
        if (this.gwMap != null) {
            hgwBean.setLastSeenTime(System.currentTimeMillis());
            this.gwMap.put(hgwBean.getGwId(), hgwBean);
        }
    }

    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        buildUDPReceiver();
        return false;
    }

    public IBinder onBind(Intent intent) {
        return this.mCallback;
    }

    public void onCreate() {
        super.onCreate();
        this.gwMap = new ConcurrentHashMap(5);
        this.mMonitor = new ArrayList();
        this.mExecutorService = Executors.newSingleThreadExecutor();
        this.finished = new AtomicBoolean(false);
        this.handler = new Handler(this);
        buildUDPReceiver();
        L.d(TAG, "onCreate");
    }

    public void onDestroy() {
        super.onDestroy();
        L.d(TAG, "onDestroy");
        synchronized (this.lock) {
            if (this.handler != null) {
                this.handler.removeMessages(1);
                this.handler = null;
            }
        }
        releaseUDPReceiver();
        ExecutorService executorService = this.mExecutorService;
        if (executorService != null) {
            executorService.shutdownNow();
            this.mExecutorService = null;
        }
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
        Map<String, HgwBean> map = this.gwMap;
        if (map != null) {
            map.clear();
        }
        synchronized (this.mMonitor) {
            this.mMonitor.clear();
        }
        stopForeground(true);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        L.d(TAG, "flags: " + i);
        if (intent == null) {
            try {
                L.d(TAG, "start Foreground Notification with intent == null");
                startForeground(o000oo000.O000000o().O00000o0(), o000oo000.O000000o().O00000Oo());
                return 2;
            } catch (Exception e2) {
                e2.printStackTrace();
                stopSelf();
            }
        } else {
            if (!intent.getBooleanExtra(o000o0ooo.O000000o, true) && Build.VERSION.SDK_INT >= 26) {
                L.d(TAG, "start Foreground Notification" + o000oo000.O000000o().O00000Oo());
                startForeground(o000oo000.O000000o().O00000o0(), o000oo000.O000000o().O00000Oo());
            }
            buildUDPReceiver();
            Timer timer = new Timer();
            this.mTimer = timer;
            timer.scheduleAtFixedRate(new UpdateTimerTask(), TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS, 5000);
            return 2;
        }
    }
}
