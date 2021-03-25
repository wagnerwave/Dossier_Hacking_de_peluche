package com.tuya.smart.mqtt;

import e.b.a.a.a.c;
import e.b.a.a.a.d;
import e.b.a.a.a.g;
import e.b.a.a.a.n;
import e.b.a.a.a.u.t.u;

public class MqttTokenAndroid implements g {
    public MqttAndroidClient client;
    public g delegate;
    public volatile boolean isComplete;
    public volatile n lastException;
    public c listener;
    public n pendingException;
    public String[] topics;
    public Object userContext;
    public Object waitObject;

    public MqttTokenAndroid(MqttAndroidClient mqttAndroidClient, Object obj, c cVar) {
        this(mqttAndroidClient, obj, cVar, (String[]) null);
    }

    public MqttTokenAndroid(MqttAndroidClient mqttAndroidClient, Object obj, c cVar, String[] strArr) {
        this.waitObject = new Object();
        this.client = mqttAndroidClient;
        this.userContext = obj;
        this.listener = cVar;
        this.topics = strArr;
    }

    public c getActionCallback() {
        return this.listener;
    }

    public d getClient() {
        return this.client;
    }

    public n getException() {
        return this.lastException;
    }

    public int[] getGrantedQos() {
        return this.delegate.getGrantedQos();
    }

    public int getMessageId() {
        g gVar = this.delegate;
        if (gVar != null) {
            return gVar.getMessageId();
        }
        return 0;
    }

    public u getResponse() {
        return this.delegate.getResponse();
    }

    public boolean getSessionPresent() {
        return this.delegate.getSessionPresent();
    }

    public String[] getTopics() {
        return this.topics;
    }

    public Object getUserContext() {
        return this.userContext;
    }

    public boolean isComplete() {
        return this.isComplete;
    }

    public void notifyComplete() {
        synchronized (this.waitObject) {
            this.isComplete = true;
            this.waitObject.notifyAll();
            if (this.listener != null) {
                this.listener.onSuccess(this);
            }
        }
    }

    public void notifyFailure(Throwable th) {
        synchronized (this.waitObject) {
            this.isComplete = true;
            this.pendingException = th instanceof n ? (n) th : new n(th);
            this.waitObject.notifyAll();
            if (th instanceof n) {
                this.lastException = (n) th;
            }
            if (this.listener != null) {
                this.listener.onFailure(this, th);
            }
        }
    }

    public void setActionCallback(c cVar) {
        this.listener = cVar;
    }

    public void setComplete(boolean z) {
        this.isComplete = z;
    }

    public void setDelegate(g gVar) {
        this.delegate = gVar;
    }

    public void setException(n nVar) {
        this.lastException = nVar;
    }

    public void setUserContext(Object obj) {
        this.userContext = obj;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000b */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0011  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0010 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void waitForCompletion() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.waitObject
            monitor-enter(r0)
            java.lang.Object r1 = r2.waitObject     // Catch:{ InterruptedException -> 0x000b }
            r1.wait()     // Catch:{ InterruptedException -> 0x000b }
            goto L_0x000b
        L_0x0009:
            r1 = move-exception
            goto L_0x0012
        L_0x000b:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            e.b.a.a.a.n r0 = r2.pendingException
            if (r0 != 0) goto L_0x0011
            return
        L_0x0011:
            throw r0
        L_0x0012:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.mqtt.MqttTokenAndroid.waitForCompletion():void");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000b */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0018  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x000f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void waitForCompletion(long r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.waitObject
            monitor-enter(r0)
            java.lang.Object r1 = r2.waitObject     // Catch:{ InterruptedException -> 0x000b }
            r1.wait(r3)     // Catch:{ InterruptedException -> 0x000b }
            goto L_0x000b
        L_0x0009:
            r3 = move-exception
            goto L_0x0020
        L_0x000b:
            boolean r3 = r2.isComplete     // Catch:{ all -> 0x0009 }
            if (r3 == 0) goto L_0x0018
            e.b.a.a.a.n r3 = r2.pendingException     // Catch:{ all -> 0x0009 }
            if (r3 != 0) goto L_0x0015
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return
        L_0x0015:
            e.b.a.a.a.n r3 = r2.pendingException     // Catch:{ all -> 0x0009 }
            throw r3     // Catch:{ all -> 0x0009 }
        L_0x0018:
            e.b.a.a.a.n r3 = new e.b.a.a.a.n     // Catch:{ all -> 0x0009 }
            r4 = 32000(0x7d00, float:4.4842E-41)
            r3.<init>((int) r4)     // Catch:{ all -> 0x0009 }
            throw r3     // Catch:{ all -> 0x0009 }
        L_0x0020:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.mqtt.MqttTokenAndroid.waitForCompletion(long):void");
    }
}
