package com.tuya.smart.mqtt;

import a.a.a.a.a;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import com.tuya.smart.common.OO000o0;
import com.tuya.smart.mqtt.MessageStore;
import com.tuya.smart.mqtt.bean.ParcelableMqttMessage;
import e.b.a.a.a.b;
import e.b.a.a.a.c;
import e.b.a.a.a.e;
import e.b.a.a.a.f;
import e.b.a.a.a.g;
import e.b.a.a.a.h;
import e.b.a.a.a.j;
import e.b.a.a.a.k;
import e.b.a.a.a.l;
import e.b.a.a.a.n;
import e.b.a.a.a.o;
import e.b.a.a.a.q;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MqttConnection implements j {
    public static final String NOT_CONNECTED = "not connected";
    public static final String TAG = "MqttConnection";
    public AlarmPingSender alarmPingSender = null;
    public b bufferOpts = null;
    public boolean cleanSession = true;
    public String clientHandle;
    public String clientId;
    public l connectOptions;
    public volatile boolean disconnected = true;
    public volatile boolean isConnecting = false;
    public h myClient = null;
    public k persistence = null;
    public String reconnectActivityToken = null;
    public Map<e, String> savedActivityTokens = new HashMap();
    public Map<e, String> savedInvocationContexts = new HashMap();
    public Map<e, o> savedSentMessages = new HashMap();
    public Map<e, String> savedTopics = new HashMap();
    public String serverURI;
    public MqttService service = null;
    public String wakeLockTag = null;
    public PowerManager.WakeLock wakelock = null;

    public class MqttConnectionListener implements c {
        public final Bundle resultBundle;

        public MqttConnectionListener(Bundle bundle) {
            this.resultBundle = bundle;
        }

        public void onFailure(g gVar, Throwable th) {
            this.resultBundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, th.getLocalizedMessage());
            this.resultBundle.putSerializable(MqttServiceConstants.CALLBACK_EXCEPTION, th);
            MqttConnection.this.service.callbackToActivity(MqttConnection.this.clientHandle, Status.ERROR, this.resultBundle);
        }

        public void onSuccess(g gVar) {
            MqttConnection.this.service.callbackToActivity(MqttConnection.this.clientHandle, Status.OK, this.resultBundle);
        }
    }

    public class MqttSubscribeListener implements c {
        public final Bundle resultBundle;

        public MqttSubscribeListener(Bundle bundle) {
            this.resultBundle = bundle;
        }

        private boolean containError(int[] iArr) {
            for (int i : iArr) {
                if (i == 128) {
                    return true;
                }
            }
            return false;
        }

        public void onFailure(g gVar, Throwable th) {
            this.resultBundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, th.getLocalizedMessage());
            this.resultBundle.putSerializable(MqttServiceConstants.CALLBACK_EXCEPTION, th);
            MqttConnection.this.service.callbackToActivity(MqttConnection.this.clientHandle, Status.ERROR, this.resultBundle);
        }

        public void onSuccess(g gVar) {
            int[] grantedQos = gVar.getGrantedQos();
            if (grantedQos.length <= 0 || !containError(grantedQos)) {
                MqttConnection.this.service.callbackToActivity(MqttConnection.this.clientHandle, Status.OK, this.resultBundle);
            } else {
                MqttConnection.this.handleException(this.resultBundle, new n(128));
            }
        }
    }

    public MqttConnection(MqttService mqttService, String str, String str2, k kVar, String str3) {
        this.serverURI = str;
        this.service = mqttService;
        this.clientId = str2;
        this.persistence = kVar;
        this.clientHandle = str3;
        StringBuilder sb = new StringBuilder();
        sb.append(MqttConnection.class.getCanonicalName());
        sb.append(" ");
        sb.append(str2);
        sb.append(" ");
        this.wakeLockTag = a.m(sb, "on host ", str);
    }

    private void acquireWakeLock() {
        if (this.wakelock == null) {
            PowerManager powerManager = (PowerManager) this.service.getSystemService("power");
            if (powerManager != null) {
                this.wakelock = powerManager.newWakeLock(1, this.wakeLockTag);
            } else {
                return;
            }
        }
        this.wakelock.acquire(600000);
    }

    private void deliverBacklog() {
        Iterator<MessageStore.StoredMessage> allArrivedMessages = this.service.messageStore.getAllArrivedMessages(this.clientHandle);
        while (allArrivedMessages.hasNext()) {
            MessageStore.StoredMessage next = allArrivedMessages.next();
            Bundle messageToBundle = messageToBundle(next.getMessageId(), next.getTopic(), next.getMessage());
            messageToBundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.MESSAGE_ARRIVED_ACTION);
            this.service.callbackToActivity(this.clientHandle, Status.OK, messageToBundle);
        }
    }

    /* access modifiers changed from: private */
    public void doAfterConnectFail(Bundle bundle) {
        acquireWakeLock();
        this.disconnected = true;
        setConnectingState(false);
        this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
        releaseWakeLock();
    }

    /* access modifiers changed from: private */
    public void doAfterConnectSuccess(Bundle bundle) {
        acquireWakeLock();
        this.service.callbackToActivity(this.clientHandle, Status.OK, bundle);
        deliverBacklog();
        setConnectingState(false);
        this.disconnected = false;
        releaseWakeLock();
    }

    /* access modifiers changed from: private */
    public void handleException(Bundle bundle, Exception exc) {
        bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, exc.getLocalizedMessage());
        bundle.putSerializable(MqttServiceConstants.CALLBACK_EXCEPTION, exc);
        this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
    }

    private Bundle messageToBundle(String str, String str2, o oVar) {
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_MESSAGE_ID, str);
        bundle.putString(MqttServiceConstants.CALLBACK_DESTINATION_NAME, str2);
        bundle.putParcelable(MqttServiceConstants.CALLBACK_MESSAGE_PARCEL, new ParcelableMqttMessage(oVar));
        return bundle;
    }

    private void releaseWakeLock() {
        PowerManager.WakeLock wakeLock = this.wakelock;
        if (wakeLock != null && wakeLock.isHeld()) {
            this.wakelock.release();
        }
    }

    private synchronized void setConnectingState(boolean z) {
        this.isConnecting = z;
    }

    private void storeSendDetails(String str, o oVar, e eVar, String str2, String str3) {
        this.savedTopics.put(eVar, str);
        this.savedSentMessages.put(eVar, oVar);
        this.savedActivityTokens.put(eVar, str3);
        this.savedInvocationContexts.put(eVar, str2);
    }

    public void close() {
        this.service.traceDebug(TAG, "close()");
        try {
            if (this.myClient != null) {
                h hVar = this.myClient;
                if (hVar != null) {
                    h.k.h("e.b.a.a.a.h", "close", OO000o0.O0000o0o);
                    hVar.f5208c.a(false);
                    h.k.h("e.b.a.a.a.h", "close", OO000o0.O0000o);
                    return;
                }
                throw null;
            }
        } catch (n e2) {
            handleException(new Bundle(), e2);
        }
    }

    public void connect(l lVar, String str, String str2) {
        h hVar;
        this.connectOptions = lVar;
        this.reconnectActivityToken = str2;
        if (lVar != null) {
            this.cleanSession = lVar.j;
        }
        if (this.connectOptions.j) {
            this.service.messageStore.clearArrivedMessages(this.clientHandle);
        }
        MqttService mqttService = this.service;
        StringBuilder n = a.n("Connecting {");
        n.append(this.serverURI);
        n.append("} as {");
        n.append(this.clientId);
        n.append("}");
        mqttService.traceDebug(TAG, n.toString());
        final Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str2);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.CONNECT_ACTION);
        try {
            if (this.persistence == null) {
                File dir = this.service.getDir(TAG, 0);
                if (dir == null) {
                    bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, "Error! No external and internal storage available");
                    bundle.putSerializable(MqttServiceConstants.CALLBACK_EXCEPTION, new q());
                    this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
                    return;
                }
                this.persistence = new TuyaMqttFilePersistence(dir.getAbsolutePath());
            }
            AnonymousClass1 r0 = new MqttConnectionListener(bundle) {
                public void onFailure(g gVar, Throwable th) {
                    bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, th.getLocalizedMessage());
                    bundle.putSerializable(MqttServiceConstants.CALLBACK_EXCEPTION, th);
                    MqttService access$200 = MqttConnection.this.service;
                    StringBuilder n = a.n("connect fail, call connect to reconnect.reason:");
                    n.append(th.getMessage());
                    access$200.traceError(MqttConnection.TAG, n.toString());
                    MqttConnection.this.doAfterConnectFail(bundle);
                }

                public void onSuccess(g gVar) {
                    MqttConnection.this.doAfterConnectSuccess(bundle);
                    MqttConnection.this.service.traceDebug(MqttConnection.TAG, "connect success!");
                }
            };
            if (this.myClient == null) {
                this.alarmPingSender = new AlarmPingSender(this.service);
                h hVar2 = new h(this.serverURI, this.clientId, this.persistence, this.alarmPingSender);
                this.myClient = hVar2;
                hVar2.f5210e = this;
                hVar2.f5208c.f.f5246a = this;
                this.service.traceDebug(TAG, "Do Real connect!");
                setConnectingState(true);
                hVar = this.myClient;
            } else if (this.isConnecting) {
                this.service.traceDebug(TAG, "myClient != null and the client is connecting. Connect return directly.");
                MqttService mqttService2 = this.service;
                mqttService2.traceDebug(TAG, "Connect return:isConnecting:" + this.isConnecting + ".disconnected:" + this.disconnected);
                return;
            } else if (!this.disconnected) {
                this.service.traceDebug(TAG, "myClient != null and the client is connected and notify!");
                doAfterConnectSuccess(bundle);
                return;
            } else {
                this.service.traceDebug(TAG, "myClient != null and the client is not connected");
                this.service.traceDebug(TAG, "Do Real connect!");
                setConnectingState(true);
                hVar = this.myClient;
            }
            hVar.c(this.connectOptions, str, r0);
        } catch (Exception e2) {
            MqttService mqttService3 = this.service;
            StringBuilder n2 = a.n("Exception occurred attempting to connect: ");
            n2.append(e2.getMessage());
            mqttService3.traceError(TAG, n2.toString());
            setConnectingState(false);
            handleException(bundle, e2);
        }
    }

    public void connectComplete(boolean z, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.CONNECT_EXTENDED_ACTION);
        bundle.putBoolean(MqttServiceConstants.CALLBACK_RECONNECT, z);
        bundle.putString(MqttServiceConstants.CALLBACK_SERVER_URI, str);
        this.service.callbackToActivity(this.clientHandle, Status.OK, bundle);
    }

    public void connectionLost(Throwable th) {
        MqttService mqttService = this.service;
        StringBuilder n = a.n("connectionLost(");
        n.append(th.getMessage());
        n.append(")");
        mqttService.traceDebug(TAG, n.toString());
        this.disconnected = true;
        try {
            if (!this.connectOptions.n) {
                this.myClient.d(30000, (Object) null, new c() {
                    public void onFailure(g gVar, Throwable th) {
                    }

                    public void onSuccess(g gVar) {
                    }
                });
            } else {
                this.alarmPingSender.schedule(100);
            }
        } catch (Exception unused) {
        }
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.ON_CONNECTION_LOST_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, th.getMessage());
        if (th instanceof n) {
            bundle.putSerializable(MqttServiceConstants.CALLBACK_EXCEPTION, th);
        }
        bundle.putString(MqttServiceConstants.CALLBACK_EXCEPTION_STACK, Log.getStackTraceString(th));
        this.service.callbackToActivity(this.clientHandle, Status.OK, bundle);
        releaseWakeLock();
    }

    public void deleteBufferedMessage(int i) {
        e.b.a.a.a.u.h hVar = this.myClient.f5208c.p;
        synchronized (hVar.f5273c) {
            hVar.f5272b.remove(i);
        }
    }

    public void deliveryComplete(e eVar) {
        MqttService mqttService = this.service;
        mqttService.traceDebug(TAG, "deliveryComplete(" + eVar + ")");
        o remove = this.savedSentMessages.remove(eVar);
        if (remove != null) {
            String remove2 = this.savedActivityTokens.remove(eVar);
            String remove3 = this.savedInvocationContexts.remove(eVar);
            Bundle messageToBundle = messageToBundle((String) null, this.savedTopics.remove(eVar), remove);
            if (remove2 != null) {
                messageToBundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.SEND_ACTION);
                messageToBundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, remove2);
                messageToBundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, remove3);
                this.service.callbackToActivity(this.clientHandle, Status.OK, messageToBundle);
            }
            messageToBundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.MESSAGE_DELIVERED_ACTION);
            this.service.callbackToActivity(this.clientHandle, Status.OK, messageToBundle);
        }
    }

    public void disconnect(long j, String str, String str2) {
        this.service.traceDebug(TAG, "disconnect()");
        this.disconnected = true;
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str2);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.DISCONNECT_ACTION);
        h hVar = this.myClient;
        if (hVar == null || !hVar.f()) {
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
            this.service.traceError(MqttServiceConstants.DISCONNECT_ACTION, NOT_CONNECTED);
            this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
        } else {
            try {
                this.myClient.d(j, str, new MqttConnectionListener(bundle));
            } catch (Exception e2) {
                handleException(bundle, e2);
            }
        }
        l lVar = this.connectOptions;
        if (lVar != null && lVar.j) {
            this.service.messageStore.clearArrivedMessages(this.clientHandle);
        }
        releaseWakeLock();
    }

    public o getBufferedMessage(int i) {
        return ((e.b.a.a.a.u.t.o) this.myClient.f5208c.p.a(i).f5204a).f5333e;
    }

    public int getBufferedMessageCount() {
        return this.myClient.f5208c.p.b();
    }

    public String getClientHandle() {
        return this.clientHandle;
    }

    public String getClientId() {
        return this.clientId;
    }

    public l getConnectOptions() {
        return this.connectOptions;
    }

    public e[] getPendingDeliveryTokens() {
        return this.myClient.f5208c.k.c();
    }

    public String getServerURI() {
        return this.serverURI;
    }

    public boolean isConnected() {
        h hVar = this.myClient;
        return hVar != null && hVar.f();
    }

    public void messageArrived(String str, o oVar) {
        MqttService mqttService = this.service;
        StringBuilder q = a.q("messageArrived(", str, ",{");
        q.append(oVar.toString());
        q.append("})");
        mqttService.traceDebug(TAG, q.toString());
        String storeArrived = this.service.messageStore.storeArrived(this.clientHandle, str, oVar);
        Bundle messageToBundle = messageToBundle(storeArrived, str, oVar);
        messageToBundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.MESSAGE_ARRIVED_ACTION);
        messageToBundle.putString(MqttServiceConstants.CALLBACK_MESSAGE_ID, storeArrived);
        this.service.callbackToActivity(this.clientHandle, Status.OK, messageToBundle);
    }

    public void offline() {
        if (!this.disconnected && !this.cleanSession) {
            connectionLost(new Exception("Android offline"));
        }
    }

    public e publish(String str, o oVar, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.SEND_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str3);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str2);
        h hVar = this.myClient;
        e eVar = null;
        if (hVar == null || !hVar.f()) {
            h hVar2 = this.myClient;
            Log.i(TAG, "Client is not connected, so not sending message");
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
            this.service.traceError(MqttServiceConstants.SEND_ACTION, NOT_CONNECTED);
            this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
            return null;
        }
        try {
            eVar = this.myClient.g(str, oVar, str2, new MqttConnectionListener(bundle));
            storeSendDetails(str, oVar, eVar, str2, str3);
            return eVar;
        } catch (Exception e2) {
            handleException(bundle, e2);
            return eVar;
        }
    }

    public e publish(String str, byte[] bArr, int i, boolean z, String str2, String str3) {
        byte[] bArr2 = bArr;
        int i2 = i;
        boolean z2 = z;
        String str4 = str2;
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.SEND_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str3);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str4);
        h hVar = this.myClient;
        if (hVar == null || !hVar.f()) {
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
            this.service.traceError(MqttServiceConstants.SEND_ACTION, NOT_CONNECTED);
            this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
            return null;
        }
        MqttConnectionListener mqttConnectionListener = new MqttConnectionListener(bundle);
        try {
            o oVar = new o(bArr);
            oVar.setQos(i);
            oVar.setRetained(z2);
            h hVar2 = this.myClient;
            if (hVar2 != null) {
                o oVar2 = new o(bArr);
                oVar2.setQos(i);
                oVar2.setRetained(z2);
                String str5 = str;
                e g = hVar2.g(str, oVar2, str4, mqttConnectionListener);
                storeSendDetails(str, oVar, g, str2, str3);
                return g;
            }
            throw null;
        } catch (Exception e2) {
            handleException(bundle, e2);
            return null;
        }
    }

    public synchronized void reconnect() {
        final Bundle bundle;
        if (this.myClient == null) {
            this.service.traceError(TAG, "Reconnect myClient = null. Will not do reconnect");
        } else if (this.isConnecting) {
            this.service.traceDebug(TAG, "The client is connecting. Reconnect return directly.");
        } else if (!this.service.isOnline()) {
            this.service.traceDebug(TAG, "The network is not reachable. Will not do reconnect");
        } else if (this.connectOptions.n) {
            Log.i(TAG, "Requesting Automatic reconnect using New Java AC");
            bundle = new Bundle();
            bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, this.reconnectActivityToken);
            bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, (String) null);
            bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.CONNECT_ACTION);
            try {
                this.myClient.h();
            } catch (n e2) {
                e = e2;
                Log.e(TAG, "Exception occurred attempting to reconnect: " + e.getMessage());
                setConnectingState(false);
                handleException(bundle, e);
            }
        } else if (this.disconnected && !this.cleanSession) {
            this.service.traceDebug(TAG, "Do Real Reconnect!");
            bundle = new Bundle();
            bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, this.reconnectActivityToken);
            bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, (String) null);
            bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.CONNECT_ACTION);
            try {
                this.myClient.c(this.connectOptions, (Object) null, new MqttConnectionListener(bundle) {
                    public void onFailure(g gVar, Throwable th) {
                        bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, th.getLocalizedMessage());
                        bundle.putSerializable(MqttServiceConstants.CALLBACK_EXCEPTION, th);
                        MqttConnection.this.service.callbackToActivity(MqttConnection.this.clientHandle, Status.ERROR, bundle);
                        MqttConnection.this.doAfterConnectFail(bundle);
                    }

                    public void onSuccess(g gVar) {
                        MqttConnection.this.service.traceDebug(MqttConnection.TAG, "Reconnect Success!");
                        MqttConnection.this.service.traceDebug(MqttConnection.TAG, "DeliverBacklog when reconnect.");
                        MqttConnection.this.doAfterConnectSuccess(bundle);
                    }
                });
                setConnectingState(true);
            } catch (n e3) {
                e = e3;
                MqttService mqttService = this.service;
                mqttService.traceError(TAG, "Cannot reconnect to remote server." + e.getMessage());
                setConnectingState(false);
            } catch (Exception e4) {
                MqttService mqttService2 = this.service;
                mqttService2.traceError(TAG, "Cannot reconnect to remote server." + e4.getMessage());
                setConnectingState(false);
                handleException(bundle, new n(6, e4.getCause()));
            }
        }
    }

    public void setBufferOpts(b bVar) {
        this.bufferOpts = bVar;
        this.myClient.f5208c.p = new e.b.a.a.a.u.h();
    }

    public void setClientHandle(String str) {
        this.clientHandle = str;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public void setConnectOptions(l lVar) {
        this.connectOptions = lVar;
    }

    public void setServerURI(String str) {
        this.serverURI = str;
    }

    public void subscribe(String str, int i, String str2, String str3) {
        MqttService mqttService = this.service;
        mqttService.traceDebug(TAG, "subscribe({" + str + "}," + i + ",{" + str2 + "}, {" + str3 + "}");
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.SUBSCRIBE_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str3);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str2);
        h hVar = this.myClient;
        if (hVar == null || !hVar.f()) {
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
            this.service.traceError(MqttServiceConstants.SUBSCRIBE_ACTION, NOT_CONNECTED);
            this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
            return;
        }
        try {
            h hVar2 = this.myClient;
            MqttSubscribeListener mqttSubscribeListener = new MqttSubscribeListener(bundle);
            if (hVar2 != null) {
                hVar2.j(new String[]{str}, new int[]{i}, str2, mqttSubscribeListener);
                return;
            }
            throw null;
        } catch (Exception e2) {
            handleException(bundle, e2);
        }
    }

    public void subscribe(String[] strArr, int[] iArr, String str, String str2) {
        MqttService mqttService = this.service;
        StringBuilder n = a.n("subscribe({");
        n.append(Arrays.toString(strArr));
        n.append("},");
        n.append(Arrays.toString(iArr));
        n.append(",{");
        n.append(str);
        n.append("}, {");
        n.append(str2);
        n.append("}");
        mqttService.traceDebug(TAG, n.toString());
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.SUBSCRIBE_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str2);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str);
        h hVar = this.myClient;
        if (hVar == null || !hVar.f()) {
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
            this.service.traceError(MqttServiceConstants.SUBSCRIBE_ACTION, NOT_CONNECTED);
            this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
            return;
        }
        try {
            this.myClient.j(strArr, iArr, str, new MqttSubscribeListener(bundle));
        } catch (Exception e2) {
            handleException(bundle, e2);
        }
    }

    public void subscribe(String[] strArr, int[] iArr, String str, String str2, f[] fVarArr) {
        MqttService mqttService = this.service;
        StringBuilder n = a.n("subscribe({");
        n.append(Arrays.toString(strArr));
        n.append("},");
        n.append(Arrays.toString(iArr));
        n.append(",{");
        n.append(str);
        n.append("}, {");
        n.append(str2);
        n.append("}");
        mqttService.traceDebug(TAG, n.toString());
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.SUBSCRIBE_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str2);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str);
        h hVar = this.myClient;
        if (hVar == null || !hVar.f()) {
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
            this.service.traceError(MqttServiceConstants.SUBSCRIBE_ACTION, NOT_CONNECTED);
            this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
            return;
        }
        new MqttConnectionListener(bundle);
        try {
            this.myClient.k(strArr, iArr, fVarArr);
        } catch (Exception e2) {
            handleException(bundle, e2);
        }
    }

    public void unsubscribe(String str, String str2, String str3) {
        MqttService mqttService = this.service;
        mqttService.traceDebug(TAG, "unsubscribe({" + str + "},{" + str2 + "}, {" + str3 + "})");
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.UNSUBSCRIBE_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str3);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str2);
        h hVar = this.myClient;
        if (hVar == null || !hVar.f()) {
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
            this.service.traceError(MqttServiceConstants.SUBSCRIBE_ACTION, NOT_CONNECTED);
            this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
            return;
        }
        MqttConnectionListener mqttConnectionListener = new MqttConnectionListener(bundle);
        try {
            h hVar2 = this.myClient;
            if (hVar2 != null) {
                hVar2.l(new String[]{str}, str2, mqttConnectionListener);
                return;
            }
            throw null;
        } catch (Exception e2) {
            handleException(bundle, e2);
        }
    }

    public void unsubscribe(String[] strArr, String str, String str2) {
        MqttService mqttService = this.service;
        StringBuilder n = a.n("unsubscribe({");
        n.append(Arrays.toString(strArr));
        n.append("},{");
        n.append(str);
        n.append("}, {");
        n.append(str2);
        n.append("})");
        mqttService.traceDebug(TAG, n.toString());
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.UNSUBSCRIBE_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str2);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str);
        h hVar = this.myClient;
        if (hVar == null || !hVar.f()) {
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
            this.service.traceError(MqttServiceConstants.SUBSCRIBE_ACTION, NOT_CONNECTED);
            this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
            return;
        }
        try {
            this.myClient.l(strArr, str, new MqttConnectionListener(bundle));
        } catch (Exception e2) {
            handleException(bundle, e2);
        }
    }

    public void disconnect(String str, String str2) {
        this.service.traceDebug(TAG, "disconnect()");
        this.disconnected = true;
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str2);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.DISCONNECT_ACTION);
        h hVar = this.myClient;
        if (hVar == null || !hVar.f()) {
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
            this.service.traceError(MqttServiceConstants.DISCONNECT_ACTION, NOT_CONNECTED);
            this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
        } else {
            try {
                this.myClient.d(30000, str, new MqttConnectionListener(bundle));
            } catch (Exception e2) {
                handleException(bundle, e2);
            }
        }
        l lVar = this.connectOptions;
        if (lVar != null && lVar.j) {
            this.service.messageStore.clearArrivedMessages(this.clientHandle);
        }
        releaseWakeLock();
    }
}
