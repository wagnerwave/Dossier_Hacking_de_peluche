package com.tuya.smart.mqtt;

import a.a.a.a.a;
import android.annotation.SuppressLint;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.tuya.smart.common.o000o0ooo;
import e.b.a.a.a.b;
import e.b.a.a.a.e;
import e.b.a.a.a.f;
import e.b.a.a.a.k;
import e.b.a.a.a.l;
import e.b.a.a.a.o;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SuppressLint({"Registered"})
public class MqttService extends Service implements MqttTraceHandler {
    public static final String TAG = "MqttService";
    public volatile boolean backgroundDataEnabled = true;
    public BackgroundDataPreferenceReceiver backgroundDataPreferenceMonitor;
    public Map<String, MqttConnection> connections = new ConcurrentHashMap();
    public MessageStore messageStore;
    public MqttServiceBinder mqttServiceBinder;
    public NetworkConnectionIntentReceiver networkConnectionMonitor;
    public String traceCallbackId;
    public boolean traceEnabled = false;

    public class BackgroundDataPreferenceReceiver extends BroadcastReceiver {
        public BackgroundDataPreferenceReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) MqttService.this.getSystemService("connectivity");
            MqttService.this.traceDebug("MqttService", "Reconnect since BroadcastReceiver.");
            if (connectivityManager != null) {
                if (!connectivityManager.getBackgroundDataSetting()) {
                    boolean unused = MqttService.this.backgroundDataEnabled = false;
                    MqttService.this.notifyClientsOffline();
                } else if (!MqttService.this.backgroundDataEnabled) {
                    boolean unused2 = MqttService.this.backgroundDataEnabled = true;
                    MqttService.this.reconnect();
                }
            }
        }
    }

    public class NetworkConnectionIntentReceiver extends BroadcastReceiver {
        public NetworkConnectionIntentReceiver() {
        }

        @SuppressLint({"Wakelock"})
        public void onReceive(Context context, Intent intent) {
            MqttService.this.traceDebug("MqttService", "Internal network status receive.");
            PowerManager powerManager = (PowerManager) MqttService.this.getSystemService("power");
            if (powerManager != null) {
                PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, "MQTT");
                newWakeLock.acquire(600000);
                MqttService.this.traceDebug("MqttService", "Reconnect for Network recovery.");
                if (MqttService.this.isOnline()) {
                    MqttService.this.traceDebug("MqttService", "Online,reconnect.");
                    MqttService.this.reconnect();
                } else {
                    MqttService.this.notifyClientsOffline();
                }
                newWakeLock.release();
            }
        }
    }

    private MqttConnection getConnection(String str) {
        MqttConnection mqttConnection = this.connections.get(str);
        if (mqttConnection != null) {
            return mqttConnection;
        }
        throw new IllegalArgumentException("Invalid ClientHandle");
    }

    /* access modifiers changed from: private */
    public void notifyClientsOffline() {
        for (MqttConnection offline : this.connections.values()) {
            offline.offline();
        }
    }

    private void registerBroadcastReceivers() {
        if (this.networkConnectionMonitor == null) {
            NetworkConnectionIntentReceiver networkConnectionIntentReceiver = new NetworkConnectionIntentReceiver();
            this.networkConnectionMonitor = networkConnectionIntentReceiver;
            registerReceiver(networkConnectionIntentReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    private void traceCallback(String str, String str2, String str3) {
        if (this.traceCallbackId != null && this.traceEnabled) {
            Bundle bundle = new Bundle();
            bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.TRACE_ACTION);
            bundle.putString(MqttServiceConstants.CALLBACK_TRACE_SEVERITY, str);
            bundle.putString(MqttServiceConstants.CALLBACK_TRACE_TAG, str2);
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, str3);
            callbackToActivity(this.traceCallbackId, Status.ERROR, bundle);
        }
    }

    private void unregisterBroadcastReceivers() {
        NetworkConnectionIntentReceiver networkConnectionIntentReceiver = this.networkConnectionMonitor;
        if (networkConnectionIntentReceiver != null) {
            unregisterReceiver(networkConnectionIntentReceiver);
            this.networkConnectionMonitor = null;
        }
    }

    public Status acknowledgeMessageArrival(String str, String str2) {
        return this.messageStore.discardArrived(str, str2) ? Status.OK : Status.ERROR;
    }

    public void callbackToActivity(String str, Status status, Bundle bundle) {
        Intent intent = new Intent(MqttServiceConstants.CALLBACK_TO_ACTIVITY);
        if (str != null) {
            intent.putExtra(MqttServiceConstants.CALLBACK_CLIENT_HANDLE, str);
        }
        intent.putExtra(MqttServiceConstants.CALLBACK_STATUS, status);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    public void close(String str) {
        getConnection(str).close();
    }

    public void connect(String str, l lVar, String str2, String str3) {
        getConnection(str).connect(lVar, (String) null, str3);
    }

    public void deleteBufferedMessage(String str, int i) {
        getConnection(str).deleteBufferedMessage(i);
    }

    public void disconnect(String str, long j, String str2, String str3) {
        getConnection(str).disconnect(j, str2, str3);
        this.connections.remove(str);
        stopSelf();
    }

    public void disconnect(String str, String str2, String str3) {
        getConnection(str).disconnect(str2, str3);
        this.connections.remove(str);
        stopSelf();
    }

    public o getBufferedMessage(String str, int i) {
        return getConnection(str).getBufferedMessage(i);
    }

    public int getBufferedMessageCount(String str) {
        return getConnection(str).getBufferedMessageCount();
    }

    public String getClient(String str, String str2, String str3, k kVar) {
        String str4 = str + ":" + str2 + ":" + str3;
        if (!this.connections.containsKey(str4)) {
            this.connections.put(str4, new MqttConnection(this, str, str2, kVar, str4));
        }
        return str4;
    }

    public e[] getPendingDeliveryTokens(String str) {
        return getConnection(str).getPendingDeliveryTokens();
    }

    public boolean isConnected(String str) {
        return getConnection(str).isConnected();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
        r0 = r0.getActiveNetworkInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isOnline() {
        /*
            r3 = this;
            java.lang.String r0 = "connectivity"
            java.lang.Object r0 = r3.getSystemService(r0)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            r1 = 0
            if (r0 != 0) goto L_0x000c
            return r1
        L_0x000c:
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()
            if (r0 == 0) goto L_0x0024
            boolean r2 = r0.isAvailable()
            if (r2 == 0) goto L_0x0024
            boolean r0 = r0.isConnected()
            if (r0 == 0) goto L_0x0024
            boolean r0 = r3.backgroundDataEnabled
            if (r0 == 0) goto L_0x0024
            r0 = 1
            return r0
        L_0x0024:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.mqtt.MqttService.isOnline():boolean");
    }

    public boolean isTraceEnabled() {
        return this.traceEnabled;
    }

    public IBinder onBind(Intent intent) {
        this.mqttServiceBinder.setActivityToken(intent.getStringExtra(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN));
        return this.mqttServiceBinder;
    }

    public void onCreate() {
        super.onCreate();
        this.mqttServiceBinder = new MqttServiceBinder(this);
        this.messageStore = new DatabaseMessageStore(this, this);
    }

    public void onDestroy() {
        for (MqttConnection disconnect : this.connections.values()) {
            disconnect.disconnect((String) null, (String) null);
        }
        if (this.mqttServiceBinder != null) {
            this.mqttServiceBinder = null;
        }
        unregisterBroadcastReceivers();
        MessageStore messageStore2 = this.messageStore;
        if (messageStore2 != null) {
            messageStore2.close();
        }
        super.onDestroy();
        stopForeground(true);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        registerBroadcastReceivers();
        if (intent == null) {
            startForeground(MqttServiceNotification.getInstance().getNotificationId(), MqttServiceNotification.getInstance().getNotification());
            return 2;
        }
        if (!intent.getBooleanExtra(o000o0ooo.O000000o, true) && Build.VERSION.SDK_INT >= 26) {
            Log.d("MqttService", "start Foreground Notification");
            startForeground(MqttServiceNotification.getInstance().getNotificationId(), MqttServiceNotification.getInstance().getNotification());
        }
        return 2;
    }

    public e publish(String str, String str2, o oVar, String str3, String str4) {
        return getConnection(str).publish(str2, oVar, str3, str4);
    }

    public e publish(String str, String str2, byte[] bArr, int i, boolean z, String str3, String str4) {
        return getConnection(str).publish(str2, bArr, i, z, str3, str4);
    }

    public void reconnect() {
        StringBuilder n = a.n("Reconnect to server, client size=");
        n.append(this.connections.size());
        traceDebug("MqttService", n.toString());
        for (MqttConnection next : this.connections.values()) {
            traceDebug("Reconnect Client:", next.getClientId() + '/' + next.getServerURI());
            if (isOnline()) {
                next.reconnect();
            }
        }
    }

    public void setBufferOpts(String str, b bVar) {
        getConnection(str).setBufferOpts(bVar);
    }

    public void setTraceCallbackId(String str) {
        this.traceCallbackId = str;
    }

    public void setTraceEnabled(boolean z) {
        this.traceEnabled = z;
    }

    public void subscribe(String str, String str2, int i, String str3, String str4) {
        getConnection(str).subscribe(str2, i, str3, str4);
    }

    public void subscribe(String str, String[] strArr, int[] iArr, String str2, String str3) {
        getConnection(str).subscribe(strArr, iArr, str2, str3);
    }

    public void subscribe(String str, String[] strArr, int[] iArr, String str2, String str3, f[] fVarArr) {
        getConnection(str).subscribe(strArr, iArr, str2, str3, fVarArr);
    }

    public void traceDebug(String str, String str2) {
        traceCallback("debug", str, str2);
    }

    public void traceError(String str, String str2) {
        traceCallback(MqttServiceConstants.TRACE_ERROR, str, str2);
    }

    public void traceException(String str, String str2, Exception exc) {
        if (this.traceCallbackId != null) {
            Bundle bundle = new Bundle();
            bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.TRACE_ACTION);
            bundle.putString(MqttServiceConstants.CALLBACK_TRACE_SEVERITY, MqttServiceConstants.TRACE_EXCEPTION);
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, str2);
            bundle.putSerializable(MqttServiceConstants.CALLBACK_EXCEPTION, exc);
            bundle.putString(MqttServiceConstants.CALLBACK_TRACE_TAG, str);
            callbackToActivity(this.traceCallbackId, Status.ERROR, bundle);
        }
    }

    public void unsubscribe(String str, String str2, String str3, String str4) {
        getConnection(str).unsubscribe(str2, str3, str4);
    }

    public void unsubscribe(String str, String[] strArr, String str2, String str3) {
        getConnection(str).unsubscribe(strArr, str2, str3);
    }
}
