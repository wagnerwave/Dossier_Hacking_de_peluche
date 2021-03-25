package com.tuya.smart.mqtt;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.SparseArray;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.tuya.smart.mqtt.bean.ParcelableMqttMessage;
import e.b.a.a.a.b;
import e.b.a.a.a.c;
import e.b.a.a.a.d;
import e.b.a.a.a.e;
import e.b.a.a.a.f;
import e.b.a.a.a.g;
import e.b.a.a.a.i;
import e.b.a.a.a.j;
import e.b.a.a.a.k;
import e.b.a.a.a.l;
import e.b.a.a.a.o;
import e.b.a.a.a.s;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public class MqttAndroidClient extends BroadcastReceiver implements d {
    public static final int BIND_SERVICE_FLAG = 0;
    public static final String SERVICE_NAME = "com.tuya.smart.mqtt.MqttService";
    public static final ExecutorService pool = Executors.newCachedThreadPool();
    public volatile boolean bindedService;
    public i callback;
    public String clientHandle;
    public final String clientId;
    public l connectOptions;
    public g connectToken;
    public final Ack messageAck;
    public MqttService mqttService;
    public Context myContext;
    public k persistence;
    public volatile boolean receiverRegistered;
    public final String serverURI;
    public final MyServiceConnection serviceConnection;
    public final SparseArray<g> tokenMap;
    public int tokenNumber;
    public MqttTraceHandler traceCallback;
    public boolean traceEnabled;

    public enum Ack {
        AUTO_ACK,
        MANUAL_ACK
    }

    public final class MyServiceConnection implements ServiceConnection {
        public MyServiceConnection() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MqttService unused = MqttAndroidClient.this.mqttService = ((MqttServiceBinder) iBinder).getService();
            boolean unused2 = MqttAndroidClient.this.bindedService = true;
            MqttAndroidClient.this.doConnect();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (MqttAndroidClient.this.callback != null) {
                MqttAndroidClient.this.callback.connectionLost(new Throwable("service disconnected"));
            }
            MqttService unused = MqttAndroidClient.this.mqttService = null;
        }
    }

    public MqttAndroidClient(Context context, String str, String str2) {
        this(context, str, str2, (k) null, Ack.AUTO_ACK);
    }

    public MqttAndroidClient(Context context, String str, String str2, Ack ack) {
        this(context, str, str2, (k) null, ack);
    }

    public MqttAndroidClient(Context context, String str, String str2, k kVar) {
        this(context, str, str2, kVar, Ack.AUTO_ACK);
    }

    public MqttAndroidClient(Context context, String str, String str2, k kVar, Ack ack) {
        this.serviceConnection = new MyServiceConnection();
        this.tokenMap = new SparseArray<>();
        this.tokenNumber = 0;
        this.persistence = null;
        this.traceEnabled = false;
        this.receiverRegistered = false;
        this.bindedService = false;
        this.myContext = context;
        this.serverURI = str;
        this.clientId = str2;
        this.persistence = kVar;
        this.messageAck = ack;
    }

    private void connectAction(Bundle bundle) {
        g gVar = this.connectToken;
        removeMqttToken(bundle);
        simpleAction(gVar, bundle);
    }

    private void connectExtendedAction(Bundle bundle) {
        if (this.callback instanceof j) {
            ((j) this.callback).connectComplete(bundle.getBoolean(MqttServiceConstants.CALLBACK_RECONNECT, false), bundle.getString(MqttServiceConstants.CALLBACK_SERVER_URI));
        }
    }

    private void connectionLostAction(Bundle bundle) {
        if (this.callback != null) {
            this.callback.connectionLost((Exception) bundle.getSerializable(MqttServiceConstants.CALLBACK_EXCEPTION));
        }
    }

    private void disconnected(Bundle bundle) {
        this.clientHandle = null;
        g removeMqttToken = removeMqttToken(bundle);
        if (removeMqttToken != null) {
            ((MqttTokenAndroid) removeMqttToken).notifyComplete();
        }
        i iVar = this.callback;
        if (iVar != null) {
            iVar.connectionLost((Throwable) null);
        }
    }

    /* access modifiers changed from: private */
    public void doConnect() {
        MqttService mqttService2 = this.mqttService;
        if (mqttService2 != null) {
            if (this.clientHandle == null) {
                this.clientHandle = mqttService2.getClient(this.serverURI, this.clientId, this.myContext.getApplicationInfo().packageName, this.persistence);
            }
            this.mqttService.setTraceEnabled(this.traceEnabled);
            this.mqttService.setTraceCallbackId(this.clientHandle);
            try {
                this.mqttService.connect(this.clientHandle, this.connectOptions, (String) null, storeToken(this.connectToken));
            } catch (Exception e2) {
                c actionCallback = this.connectToken.getActionCallback();
                if (actionCallback != null) {
                    actionCallback.onFailure(this.connectToken, e2);
                }
            }
        }
    }

    private synchronized g getMqttToken(Bundle bundle) {
        return this.tokenMap.get(Integer.parseInt(bundle.getString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN)));
    }

    private boolean isAppForeground(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (!(activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null || runningAppProcesses.isEmpty())) {
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next.processName.equals(context.getPackageName()) && next.importance == 100) {
                    return true;
                }
            }
        }
        return false;
    }

    private void messageArrivedAction(Bundle bundle) {
        if (this.mqttService != null && this.callback != null) {
            String string = bundle.getString(MqttServiceConstants.CALLBACK_MESSAGE_ID);
            String string2 = bundle.getString(MqttServiceConstants.CALLBACK_DESTINATION_NAME);
            ParcelableMqttMessage parcelableMqttMessage = (ParcelableMqttMessage) bundle.getParcelable(MqttServiceConstants.CALLBACK_MESSAGE_PARCEL);
            try {
                if (this.messageAck == Ack.AUTO_ACK) {
                    this.callback.messageArrived(string2, parcelableMqttMessage);
                    this.mqttService.acknowledgeMessageArrival(this.clientHandle, string);
                    return;
                }
                parcelableMqttMessage.messageId = string;
                this.callback.messageArrived(string2, parcelableMqttMessage);
            } catch (Exception unused) {
            }
        }
    }

    private void messageDeliveredAction(Bundle bundle) {
        g removeMqttToken = removeMqttToken(bundle);
        if (removeMqttToken != null && this.callback != null && ((Status) bundle.getSerializable(MqttServiceConstants.CALLBACK_STATUS)) == Status.OK && (removeMqttToken instanceof e)) {
            this.callback.deliveryComplete((e) removeMqttToken);
        }
    }

    /* access modifiers changed from: private */
    public void registerReceiver(BroadcastReceiver broadcastReceiver) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MqttServiceConstants.CALLBACK_TO_ACTIVITY);
        LocalBroadcastManager.getInstance(this.myContext).registerReceiver(broadcastReceiver, intentFilter);
        this.receiverRegistered = true;
    }

    private synchronized g removeMqttToken(Bundle bundle) {
        String string = bundle.getString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN);
        if (string == null) {
            return null;
        }
        int parseInt = Integer.parseInt(string);
        g gVar = this.tokenMap.get(parseInt);
        this.tokenMap.delete(parseInt);
        return gVar;
    }

    private void sendAction(Bundle bundle) {
        simpleAction(getMqttToken(bundle), bundle);
    }

    private void simpleAction(g gVar, Bundle bundle) {
        if (gVar == null) {
            MqttService mqttService2 = this.mqttService;
            if (mqttService2 != null) {
                mqttService2.traceError("MqttService", "simpleAction : token is null");
            }
        } else if (((Status) bundle.getSerializable(MqttServiceConstants.CALLBACK_STATUS)) == Status.OK) {
            ((MqttTokenAndroid) gVar).notifyComplete();
        } else {
            ((MqttTokenAndroid) gVar).notifyFailure((Exception) bundle.getSerializable(MqttServiceConstants.CALLBACK_EXCEPTION));
        }
    }

    private synchronized String storeToken(g gVar) {
        int i;
        this.tokenMap.put(this.tokenNumber, gVar);
        i = this.tokenNumber;
        this.tokenNumber = i + 1;
        return Integer.toString(i);
    }

    private void subscribeAction(Bundle bundle) {
        simpleAction(removeMqttToken(bundle), bundle);
    }

    private void traceAction(Bundle bundle) {
        if (this.traceCallback != null) {
            String string = bundle.getString(MqttServiceConstants.CALLBACK_TRACE_SEVERITY);
            String string2 = bundle.getString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE);
            String string3 = bundle.getString(MqttServiceConstants.CALLBACK_TRACE_TAG);
            if ("debug".equals(string)) {
                this.traceCallback.traceDebug(string3, string2);
            } else if (MqttServiceConstants.TRACE_ERROR.equals(string)) {
                this.traceCallback.traceError(string3, string2);
            } else {
                this.traceCallback.traceException(string3, string2, (Exception) bundle.getSerializable(MqttServiceConstants.CALLBACK_EXCEPTION));
            }
        }
    }

    private void unSubscribeAction(Bundle bundle) {
        simpleAction(removeMqttToken(bundle), bundle);
    }

    public boolean acknowledgeMessage(String str) {
        return this.messageAck == Ack.MANUAL_ACK && this.mqttService.acknowledgeMessageArrival(this.clientHandle, str) == Status.OK;
    }

    public void close() {
        MqttService mqttService2 = this.mqttService;
        if (mqttService2 != null) {
            if (this.clientHandle == null) {
                this.clientHandle = mqttService2.getClient(this.serverURI, this.clientId, this.myContext.getApplicationInfo().packageName, this.persistence);
            }
            this.mqttService.close(this.clientHandle);
        }
    }

    public g connect() {
        return connect((Object) null, (c) null);
    }

    public g connect(l lVar) {
        return connect(lVar, (Object) null, (c) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e.b.a.a.a.g connect(e.b.a.a.a.l r4, java.lang.Object r5, e.b.a.a.a.c r6) {
        /*
            r3 = this;
            com.tuya.smart.mqtt.MqttTokenAndroid r0 = new com.tuya.smart.mqtt.MqttTokenAndroid
            r0.<init>(r3, r5, r6)
            r3.connectOptions = r4
            r3.connectToken = r0
            com.tuya.smart.mqtt.MqttService r4 = r3.mqttService
            if (r4 != 0) goto L_0x0085
            android.content.Context r4 = r3.myContext
            boolean r4 = r3.isAppForeground(r4)
            r5 = 1
            r4 = r4 ^ r5
            com.tuya.smart.mqtt.MqttServiceNotification r1 = com.tuya.smart.mqtt.MqttServiceNotification.getInstance()
            android.app.Notification r1 = r1.getNotification()
            if (r1 != 0) goto L_0x002e
            if (r4 == 0) goto L_0x002e
            if (r6 == 0) goto L_0x008f
            java.lang.Throwable r4 = new java.lang.Throwable
            java.lang.String r5 = "background start service failure"
            r4.<init>(r5)
            r6.onFailure(r0, r4)
            goto L_0x008f
        L_0x002e:
            android.content.Intent r6 = new android.content.Intent
            r6.<init>()
            android.content.Context r1 = r3.myContext
            java.lang.String r2 = "com.tuya.smart.mqtt.MqttService"
            r6.setClassName(r1, r2)
            java.lang.String r1 = "MqttAndroidClient"
            java.lang.String r2 = "intent_service_foreground"
            if (r4 == 0) goto L_0x0056
            java.lang.String r4 = "app In background"
            android.util.Log.d(r1, r4)
            r4 = 0
            r6.putExtra(r2, r4)
            int r4 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r4 < r1) goto L_0x005e
            android.content.Context r4 = r3.myContext
            android.content.ComponentName r4 = r4.startForegroundService(r6)
            goto L_0x0064
        L_0x0056:
            r6.putExtra(r2, r5)
            java.lang.String r4 = "app In foreground"
            android.util.Log.d(r1, r4)
        L_0x005e:
            android.content.Context r4 = r3.myContext
            android.content.ComponentName r4 = r4.startService(r6)
        L_0x0064:
            if (r4 != 0) goto L_0x0076
            e.b.a.a.a.c r4 = r0.getActionCallback()
            if (r4 == 0) goto L_0x0076
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "cannot start service com.tuya.smart.mqtt.MqttService"
            r1.<init>(r2)
            r4.onFailure(r0, r1)
        L_0x0076:
            android.content.Context r4 = r3.myContext
            com.tuya.smart.mqtt.MqttAndroidClient$MyServiceConnection r1 = r3.serviceConnection
            r4.bindService(r6, r1, r5)
            boolean r4 = r3.receiverRegistered
            if (r4 != 0) goto L_0x008f
            r3.registerReceiver(r3)
            goto L_0x008f
        L_0x0085:
            java.util.concurrent.ExecutorService r4 = pool
            com.tuya.smart.mqtt.MqttAndroidClient$1 r5 = new com.tuya.smart.mqtt.MqttAndroidClient$1
            r5.<init>()
            r4.execute(r5)
        L_0x008f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.mqtt.MqttAndroidClient.connect(e.b.a.a.a.l, java.lang.Object, e.b.a.a.a.c):e.b.a.a.a.g");
    }

    public g connect(Object obj, c cVar) {
        return connect(new l(), obj, cVar);
    }

    public void deleteBufferedMessage(int i) {
        this.mqttService.deleteBufferedMessage(this.clientHandle, i);
    }

    public g disconnect() {
        if (this.mqttService == null) {
            return null;
        }
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, (Object) null, (c) null);
        this.mqttService.disconnect(this.clientHandle, (String) null, storeToken(mqttTokenAndroid));
        return mqttTokenAndroid;
    }

    public g disconnect(long j) {
        if (this.mqttService == null) {
            return null;
        }
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, (Object) null, (c) null);
        this.mqttService.disconnect(this.clientHandle, j, (String) null, storeToken(mqttTokenAndroid));
        return mqttTokenAndroid;
    }

    public g disconnect(long j, Object obj, c cVar) {
        if (this.mqttService == null) {
            return null;
        }
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, obj, cVar);
        this.mqttService.disconnect(this.clientHandle, j, (String) null, storeToken(mqttTokenAndroid));
        return mqttTokenAndroid;
    }

    public g disconnect(Object obj, c cVar) {
        if (this.mqttService == null) {
            return null;
        }
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, obj, cVar);
        this.mqttService.disconnect(this.clientHandle, (String) null, storeToken(mqttTokenAndroid));
        return mqttTokenAndroid;
    }

    public void disconnectForcibly() {
        throw new UnsupportedOperationException();
    }

    public void disconnectForcibly(long j) {
        throw new UnsupportedOperationException();
    }

    public void disconnectForcibly(long j, long j2) {
        throw new UnsupportedOperationException();
    }

    public o getBufferedMessage(int i) {
        return this.mqttService.getBufferedMessage(this.clientHandle, i);
    }

    public int getBufferedMessageCount() {
        return this.mqttService.getBufferedMessageCount(this.clientHandle);
    }

    public String getClientId() {
        return this.clientId;
    }

    public e[] getPendingDeliveryTokens() {
        return this.mqttService.getPendingDeliveryTokens(this.clientHandle);
    }

    public SSLSocketFactory getSSLSocketFactory(InputStream inputStream, String str) {
        try {
            KeyStore instance = KeyStore.getInstance("BKS");
            instance.load(inputStream, str.toCharArray());
            TrustManagerFactory instance2 = TrustManagerFactory.getInstance("X509");
            instance2.init(instance);
            TrustManager[] trustManagers = instance2.getTrustManagers();
            SSLContext instance3 = SSLContext.getInstance("TLSv1");
            instance3.init((KeyManager[]) null, trustManagers, (SecureRandom) null);
            return instance3.getSocketFactory();
        } catch (IOException | KeyManagementException | KeyStoreException | NoSuchAlgorithmException | CertificateException e2) {
            throw new s(e2);
        }
    }

    public String getServerURI() {
        return this.serverURI;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.mqttService;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isConnected() {
        /*
            r2 = this;
            java.lang.String r0 = r2.clientHandle
            if (r0 == 0) goto L_0x0010
            com.tuya.smart.mqtt.MqttService r1 = r2.mqttService
            if (r1 == 0) goto L_0x0010
            boolean r0 = r1.isConnected(r0)
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.mqtt.MqttAndroidClient.isConnected():boolean");
    }

    public void messageArrivedComplete(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    public void onReceive(Context context, Intent intent) {
        String string;
        Bundle extras = intent.getExtras();
        if (extras != null && (string = extras.getString(MqttServiceConstants.CALLBACK_CLIENT_HANDLE)) != null && string.equals(this.clientHandle)) {
            String string2 = extras.getString(MqttServiceConstants.CALLBACK_ACTION);
            if (MqttServiceConstants.CONNECT_ACTION.equals(string2)) {
                connectAction(extras);
            } else if (MqttServiceConstants.CONNECT_EXTENDED_ACTION.equals(string2)) {
                connectExtendedAction(extras);
            } else if (MqttServiceConstants.MESSAGE_ARRIVED_ACTION.equals(string2)) {
                messageArrivedAction(extras);
            } else if (MqttServiceConstants.SUBSCRIBE_ACTION.equals(string2)) {
                subscribeAction(extras);
            } else if (MqttServiceConstants.UNSUBSCRIBE_ACTION.equals(string2)) {
                unSubscribeAction(extras);
            } else if (MqttServiceConstants.SEND_ACTION.equals(string2)) {
                sendAction(extras);
            } else if (MqttServiceConstants.MESSAGE_DELIVERED_ACTION.equals(string2)) {
                messageDeliveredAction(extras);
            } else if (MqttServiceConstants.ON_CONNECTION_LOST_ACTION.equals(string2)) {
                connectionLostAction(extras);
            } else if (MqttServiceConstants.DISCONNECT_ACTION.equals(string2)) {
                disconnected(extras);
            } else if (MqttServiceConstants.TRACE_ACTION.equals(string2)) {
                traceAction(extras);
            } else {
                MqttService mqttService2 = this.mqttService;
                if (mqttService2 != null) {
                    mqttService2.traceError("MqttService", "Callback action doesn't exist.");
                }
            }
        }
    }

    public e publish(String str, o oVar) {
        return publish(str, oVar, (Object) null, (c) null);
    }

    public e publish(String str, o oVar, Object obj, c cVar) {
        MqttDeliveryTokenAndroid mqttDeliveryTokenAndroid = new MqttDeliveryTokenAndroid(this, obj, cVar, oVar);
        mqttDeliveryTokenAndroid.setDelegate(this.mqttService.publish(this.clientHandle, str, oVar, (String) null, storeToken(mqttDeliveryTokenAndroid)));
        return mqttDeliveryTokenAndroid;
    }

    public e publish(String str, byte[] bArr, int i, boolean z) {
        return publish(str, bArr, i, z, (Object) null, (c) null);
    }

    public e publish(String str, byte[] bArr, int i, boolean z, Object obj, c cVar) {
        o oVar = new o(bArr);
        oVar.setQos(i);
        oVar.setRetained(z);
        MqttDeliveryTokenAndroid mqttDeliveryTokenAndroid = new MqttDeliveryTokenAndroid(this, obj, cVar, oVar);
        String storeToken = storeToken(mqttDeliveryTokenAndroid);
        mqttDeliveryTokenAndroid.setDelegate(this.mqttService.publish(this.clientHandle, str, bArr, i, z, (String) null, storeToken));
        return mqttDeliveryTokenAndroid;
    }

    public void registerResources(Context context) {
        if (context != null) {
            this.myContext = context;
            if (!this.receiverRegistered) {
                registerReceiver(this);
            }
        }
    }

    public void setBufferOpts(b bVar) {
        this.mqttService.setBufferOpts(this.clientHandle, bVar);
    }

    public void setCallback(i iVar) {
        this.callback = iVar;
    }

    public void setManualAcks(boolean z) {
        throw new UnsupportedOperationException();
    }

    public void setTraceCallback(MqttTraceHandler mqttTraceHandler) {
        this.traceCallback = mqttTraceHandler;
    }

    public void setTraceEnabled(boolean z) {
        this.traceEnabled = z;
        MqttService mqttService2 = this.mqttService;
        if (mqttService2 != null) {
            mqttService2.setTraceEnabled(z);
        }
    }

    public g subscribe(String str, int i) {
        return subscribe(str, i, (Object) null, (c) null);
    }

    public g subscribe(String str, int i, f fVar) {
        return subscribe(str, i, (Object) null, (c) null, fVar);
    }

    public g subscribe(String str, int i, Object obj, c cVar) {
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, obj, cVar, new String[]{str});
        this.mqttService.subscribe(this.clientHandle, str, i, (String) null, storeToken(mqttTokenAndroid));
        return mqttTokenAndroid;
    }

    public g subscribe(String str, int i, Object obj, c cVar, f fVar) {
        return subscribe(new String[]{str}, new int[]{i}, obj, cVar, new f[]{fVar});
    }

    public g subscribe(String[] strArr, int[] iArr) {
        return subscribe(strArr, iArr, (Object) null, (c) null);
    }

    public g subscribe(String[] strArr, int[] iArr, Object obj, c cVar) {
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, obj, cVar, strArr);
        this.mqttService.subscribe(this.clientHandle, strArr, iArr, (String) null, storeToken(mqttTokenAndroid));
        return mqttTokenAndroid;
    }

    public g subscribe(String[] strArr, int[] iArr, Object obj, c cVar, f[] fVarArr) {
        this.mqttService.subscribe(this.clientHandle, strArr, iArr, (String) null, storeToken(new MqttTokenAndroid(this, obj, cVar, strArr)), fVarArr);
        return null;
    }

    public g subscribe(String[] strArr, int[] iArr, f[] fVarArr) {
        return subscribe(strArr, iArr, (Object) null, (c) null, fVarArr);
    }

    public void unregisterResources() {
        if (this.myContext != null && this.receiverRegistered) {
            synchronized (this) {
                LocalBroadcastManager.getInstance(this.myContext).unregisterReceiver(this);
                this.receiverRegistered = false;
            }
            if (this.bindedService) {
                try {
                    this.myContext.unbindService(this.serviceConnection);
                    this.bindedService = false;
                } catch (IllegalArgumentException unused) {
                }
            }
        }
    }

    public g unsubscribe(String str) {
        return unsubscribe(str, (Object) null, (c) null);
    }

    public g unsubscribe(String str, Object obj, c cVar) {
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, obj, cVar);
        this.mqttService.unsubscribe(this.clientHandle, str, (String) null, storeToken(mqttTokenAndroid));
        return mqttTokenAndroid;
    }

    public g unsubscribe(String[] strArr) {
        return unsubscribe(strArr, (Object) null, (c) null);
    }

    public g unsubscribe(String[] strArr, Object obj, c cVar) {
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, obj, cVar);
        this.mqttService.unsubscribe(this.clientHandle, strArr, (String) null, storeToken(mqttTokenAndroid));
        return mqttTokenAndroid;
    }
}
