package com.tuya.smart.common;

import a.a.a.a.a;
import android.content.Context;
import com.tuya.sdk.mqttmanager.model.Connection;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.mqtt.MqttAndroidClient;
import com.tuya.smart.mqtt.MqttServiceNotification;
import e.b.a.a.a.c;
import e.b.a.a.a.g;
import e.b.a.a.a.i;
import e.b.a.a.a.n;
import e.b.a.a.a.s;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.LogManager;

public class o0ooo000o implements o0oo0oo0o {
    public static final String O000000o = "MqttModel";
    public final o0oo0oooo O00000Oo;
    public Connection O00000o;
    public i O00000o0;
    public AtomicBoolean O00000oO = new AtomicBoolean(false);
    public o0oo0o0oo O00000oo;
    public o0oo0oo00 O0000O0o;
    public c O0000OOo;

    public o0ooo000o(o0oo0oooo o0oo0oooo) {
        this.O00000Oo = o0oo0oooo;
        this.O0000O0o = o0oo0oooo.O00000Oo();
        this.O00000o0 = o0oo0oooo.O00000o0();
        this.O00000oo = o0oo0oooo.O00000oo();
        this.O0000OOo = o0oo0oooo.O00000o();
        O00000o();
        MqttServiceNotification.getInstance().setNotification(o0oo0oooo.O0000Oo0(), o0oo0oooo.O0000OOo());
    }

    private MqttAndroidClient O000000o(Context context, String str, String str2) {
        return new MqttAndroidClient(context, str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01da, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0113 A[Catch:{ s -> 0x00bd, FileNotFoundException -> 0x00a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01d3 A[Catch:{ s -> 0x00bd, FileNotFoundException -> 0x00a1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void O00000o() {
        /*
            r20 = this;
            r1 = r20
            monitor-enter(r20)
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.O00000oO     // Catch:{ all -> 0x01db }
            boolean r0 = r0.get()     // Catch:{ all -> 0x01db }
            if (r0 == 0) goto L_0x000d
            monitor-exit(r20)
            return
        L_0x000d:
            e.b.a.a.a.l r2 = new e.b.a.a.a.l     // Catch:{ all -> 0x01db }
            r2.<init>()     // Catch:{ all -> 0x01db }
            com.tuya.smart.common.o0oo0oooo r0 = r1.O00000Oo     // Catch:{ all -> 0x01db }
            com.tuya.sdk.mqttmanager.bean.MqttConfigBean r3 = r0.O00000oO()     // Catch:{ all -> 0x01db }
            java.lang.String r6 = r3.getClientId()     // Catch:{ all -> 0x01db }
            java.lang.String r0 = "{\"clientId\":\"%s\",\"deviceType\":\"ANDROID\",\"message\":\"\",\"userName\":\"%s\"}"
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x01db }
            r12 = 0
            r4[r12] = r6     // Catch:{ all -> 0x01db }
            java.lang.String r5 = r3.getUserName()     // Catch:{ all -> 0x01db }
            r13 = 1
            r4[r13] = r5     // Catch:{ all -> 0x01db }
            java.lang.String r14 = java.lang.String.format(r0, r4)     // Catch:{ all -> 0x01db }
            com.tuya.smart.common.o0oo0oo00 r0 = r1.O0000O0o     // Catch:{ all -> 0x01db }
            java.lang.String r15 = r0.O00000Oo()     // Catch:{ all -> 0x01db }
            com.tuya.smart.common.o0oo0oo00 r0 = r1.O0000O0o     // Catch:{ all -> 0x01db }
            java.lang.String r16 = r0.O00000o0()     // Catch:{ all -> 0x01db }
            boolean r0 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x01db }
            if (r0 != 0) goto L_0x01d9
            boolean r0 = android.text.TextUtils.isEmpty(r16)     // Catch:{ all -> 0x01db }
            if (r0 == 0) goto L_0x0049
            goto L_0x01d9
        L_0x0049:
            boolean r0 = r3.isSsl()     // Catch:{ all -> 0x01db }
            if (r0 == 0) goto L_0x0052
            java.lang.String r0 = "ssl://"
            goto L_0x0054
        L_0x0052:
            java.lang.String r0 = "tcp://"
        L_0x0054:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01db }
            r4.<init>()     // Catch:{ all -> 0x01db }
            r4.append(r0)     // Catch:{ all -> 0x01db }
            java.lang.String r0 = r3.getServerUrl()     // Catch:{ all -> 0x01db }
            r4.append(r0)     // Catch:{ all -> 0x01db }
            java.lang.String r0 = ":"
            r4.append(r0)     // Catch:{ all -> 0x01db }
            int r0 = r3.getPort()     // Catch:{ all -> 0x01db }
            r4.append(r0)     // Catch:{ all -> 0x01db }
            java.lang.String r11 = r4.toString()     // Catch:{ all -> 0x01db }
            com.tuya.smart.common.o0oo0oooo r0 = r1.O00000Oo     // Catch:{ all -> 0x01db }
            android.content.Context r0 = r0.O000000o()     // Catch:{ all -> 0x01db }
            com.tuya.smart.mqtt.MqttAndroidClient r10 = r1.O000000o((android.content.Context) r0, (java.lang.String) r11, (java.lang.String) r6)     // Catch:{ all -> 0x01db }
            boolean r0 = r3.isSsl()     // Catch:{ all -> 0x01db }
            if (r0 == 0) goto L_0x00d6
            java.lang.String r0 = r3.getSslKey()     // Catch:{ s -> 0x00bd, FileNotFoundException -> 0x00a1 }
            if (r0 == 0) goto L_0x00d6
            java.lang.String r4 = ""
            boolean r4 = r0.equalsIgnoreCase(r4)     // Catch:{ s -> 0x00bd, FileNotFoundException -> 0x00a1 }
            if (r4 != 0) goto L_0x00d6
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ s -> 0x00bd, FileNotFoundException -> 0x00a1 }
            r4.<init>(r0)     // Catch:{ s -> 0x00bd, FileNotFoundException -> 0x00a1 }
            java.lang.String r0 = r3.getSslPassword()     // Catch:{ s -> 0x00bd, FileNotFoundException -> 0x00a1 }
            javax.net.ssl.SSLSocketFactory r0 = r10.getSSLSocketFactory(r4, r0)     // Catch:{ s -> 0x00bd, FileNotFoundException -> 0x00a1 }
            r2.g = r0     // Catch:{ s -> 0x00bd, FileNotFoundException -> 0x00a1 }
            goto L_0x00d6
        L_0x00a1:
            r0 = move-exception
            java.lang.String r4 = "MqttModel"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01db }
            r5.<init>()     // Catch:{ all -> 0x01db }
            java.lang.String r7 = "MqttException Occured: SSL Key file not found"
            r5.append(r7)     // Catch:{ all -> 0x01db }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x01db }
            r5.append(r0)     // Catch:{ all -> 0x01db }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x01db }
        L_0x00b9:
            com.tuya.smart.android.common.utils.L.e(r4, r0)     // Catch:{ all -> 0x01db }
            goto L_0x00d6
        L_0x00bd:
            r0 = move-exception
            java.lang.String r4 = "MqttModel"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01db }
            r5.<init>()     // Catch:{ all -> 0x01db }
            java.lang.String r7 = "MqttException Occured: "
            r5.append(r7)     // Catch:{ all -> 0x01db }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x01db }
            r5.append(r0)     // Catch:{ all -> 0x01db }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x01db }
            goto L_0x00b9
        L_0x00d6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01db }
            r0.<init>()     // Catch:{ all -> 0x01db }
            r0.append(r11)     // Catch:{ all -> 0x01db }
            r0.append(r6)     // Catch:{ all -> 0x01db }
            java.lang.String r5 = r0.toString()     // Catch:{ all -> 0x01db }
            com.tuya.sdk.mqttmanager.model.Connection r0 = new com.tuya.sdk.mqttmanager.model.Connection     // Catch:{ all -> 0x01db }
            int r8 = r3.getPort()     // Catch:{ all -> 0x01db }
            com.tuya.smart.common.o0oo0oooo r4 = r1.O00000Oo     // Catch:{ all -> 0x01db }
            android.content.Context r9 = r4.O000000o()     // Catch:{ all -> 0x01db }
            boolean r17 = r3.isSsl()     // Catch:{ all -> 0x01db }
            r4 = r0
            r7 = r11
            r18 = r10
            r19 = r11
            r11 = r17
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x01db }
            r1.O00000o = r0     // Catch:{ all -> 0x01db }
            com.tuya.sdk.mqttmanager.model.Connection$ConnectionStatus r4 = com.tuya.sdk.mqttmanager.model.Connection.ConnectionStatus.CONNECTING     // Catch:{ all -> 0x01db }
            r0.O000000o((com.tuya.sdk.mqttmanager.model.Connection.ConnectionStatus) r4)     // Catch:{ all -> 0x01db }
            boolean r0 = r3.isCleanSession()     // Catch:{ all -> 0x01db }
            r2.j = r0     // Catch:{ all -> 0x01db }
            int r0 = r3.getTimeOut()     // Catch:{ all -> 0x01db }
            if (r0 < 0) goto L_0x01d3
            r2.k = r0     // Catch:{ all -> 0x01db }
            int r0 = r3.getKeepAlive()     // Catch:{ all -> 0x01db }
            if (r0 < 0) goto L_0x01cd
            r2.f5216a = r0     // Catch:{ all -> 0x01db }
            int r0 = r3.getMaxInflight()     // Catch:{ all -> 0x01db }
            if (r0 < 0) goto L_0x01c7
            r2.f5217b = r0     // Catch:{ all -> 0x01db }
            java.lang.String[] r0 = new java.lang.String[r13]     // Catch:{ all -> 0x01db }
            r0[r12] = r19     // Catch:{ all -> 0x01db }
        L_0x0129:
            if (r12 < r13) goto L_0x01ba
            r2.l = r0     // Catch:{ all -> 0x01db }
            boolean r0 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x01db }
            if (r0 != 0) goto L_0x014a
            if (r15 == 0) goto L_0x0148
            java.lang.String r0 = r15.trim()     // Catch:{ all -> 0x01db }
            java.lang.String r4 = ""
            boolean r0 = r0.equals(r4)     // Catch:{ all -> 0x01db }
            if (r0 != 0) goto L_0x0142
            goto L_0x0148
        L_0x0142:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x01db }
            r0.<init>()     // Catch:{ all -> 0x01db }
            throw r0     // Catch:{ all -> 0x01db }
        L_0x0148:
            r2.f5220e = r15     // Catch:{ all -> 0x01db }
        L_0x014a:
            boolean r0 = android.text.TextUtils.isEmpty(r16)     // Catch:{ all -> 0x01db }
            if (r0 != 0) goto L_0x0156
            char[] r0 = r16.toCharArray()     // Catch:{ all -> 0x01db }
            r2.f = r0     // Catch:{ all -> 0x01db }
        L_0x0156:
            java.lang.String r0 = r3.getWillTopic()     // Catch:{ all -> 0x01db }
            boolean r4 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x01db }
            if (r4 == 0) goto L_0x0166
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x01db }
            if (r4 != 0) goto L_0x0191
        L_0x0166:
            byte[] r4 = r14.getBytes()     // Catch:{ Exception -> 0x0176 }
            int r5 = r3.getQos()     // Catch:{ Exception -> 0x0176 }
            boolean r6 = r3.isRetained()     // Catch:{ Exception -> 0x0176 }
            r2.b(r0, r4, r5, r6)     // Catch:{ Exception -> 0x0176 }
            goto L_0x0191
        L_0x0176:
            r0 = move-exception
            java.lang.String r4 = "MqttModel"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01db }
            r5.<init>()     // Catch:{ all -> 0x01db }
            java.lang.String r6 = "Exception Occured"
            r5.append(r6)     // Catch:{ all -> 0x01db }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x01db }
            r5.append(r0)     // Catch:{ all -> 0x01db }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x01db }
            com.tuya.smart.android.common.utils.L.e(r4, r0)     // Catch:{ all -> 0x01db }
        L_0x0191:
            e.b.a.a.a.i r0 = r1.O00000o0     // Catch:{ all -> 0x01db }
            r4 = r18
            r4.setCallback(r0)     // Catch:{ all -> 0x01db }
            com.tuya.smart.common.o0oo0oooo r0 = r1.O00000Oo     // Catch:{ all -> 0x01db }
            com.tuya.smart.mqtt.MqttTraceHandler r0 = r0.O0000O0o()     // Catch:{ all -> 0x01db }
            r4.setTraceCallback(r0)     // Catch:{ all -> 0x01db }
            com.tuya.sdk.mqttmanager.model.Connection r0 = r1.O00000o     // Catch:{ all -> 0x01db }
            r0.O000000o((e.b.a.a.a.l) r2)     // Catch:{ all -> 0x01db }
            boolean r0 = r3.isDebug()     // Catch:{ all -> 0x01db }
            if (r0 == 0) goto L_0x01b0
            r20.O00000oo()     // Catch:{ all -> 0x01db }
            goto L_0x01b3
        L_0x01b0:
            r20.O0000O0o()     // Catch:{ all -> 0x01db }
        L_0x01b3:
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.O00000oO     // Catch:{ all -> 0x01db }
            r0.set(r13)     // Catch:{ all -> 0x01db }
            monitor-exit(r20)
            return
        L_0x01ba:
            r4 = r18
            r5 = r0[r12]     // Catch:{ all -> 0x01db }
            e.b.a.a.a.l.c(r5)     // Catch:{ all -> 0x01db }
            int r12 = r12 + 1
            r18 = r4
            goto L_0x0129
        L_0x01c7:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x01db }
            r0.<init>()     // Catch:{ all -> 0x01db }
            throw r0     // Catch:{ all -> 0x01db }
        L_0x01cd:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x01db }
            r0.<init>()     // Catch:{ all -> 0x01db }
            throw r0     // Catch:{ all -> 0x01db }
        L_0x01d3:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x01db }
            r0.<init>()     // Catch:{ all -> 0x01db }
            throw r0     // Catch:{ all -> 0x01db }
        L_0x01d9:
            monitor-exit(r20)
            return
        L_0x01db:
            r0 = move-exception
            monitor-exit(r20)
            goto L_0x01df
        L_0x01de:
            throw r0
        L_0x01df:
            goto L_0x01de
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.o0ooo000o.O00000o():void");
    }

    private void O00000oO() {
        StringBuilder sb;
        String str;
        if (this.O00000oO.get() && O00000o0()) {
            try {
                this.O00000o.O000000o(Connection.ConnectionStatus.DISCONNECTED);
                this.O00000o.O0000O0o().disconnect((Object) null, new c() {
                    public void onFailure(g gVar, Throwable th) {
                        L.mqtt(o0ooo000o.O000000o, "disconnect failure");
                    }

                    public void onSuccess(g gVar) {
                        L.mqtt(o0ooo000o.O000000o, "disconnect success");
                    }
                });
                return;
            } catch (n e2) {
                sb = a.n("Failed to disconnect the client with the handle: ");
                str = e2.getMessage();
            } catch (Exception e3) {
                sb = a.n("disconnect exception: ");
                str = e3.getMessage();
            }
        } else {
            return;
        }
        sb.append(str);
        L.e(O000000o, sb.toString());
    }

    private void O00000oo() {
        try {
            LogManager.getLogManager().readConfiguration(this.O00000Oo.O000000o().getResources().getAssets().open("jsr47android.properties"));
            this.O00000o.O0000O0o().setTraceEnabled(true);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void O0000O0o() {
        LogManager.getLogManager().reset();
        this.O00000o.O0000O0o().setTraceEnabled(false);
    }

    public void O000000o() {
        o0oo0o0oo o0oo0o0oo;
        if (!this.O00000oO.get()) {
            O00000o();
        }
        if (!this.O00000oO.get()) {
            return;
        }
        if (!O00000o0() || (o0oo0o0oo = this.O00000oo) == null) {
            this.O00000o.O000000o(Connection.ConnectionStatus.CONNECTING);
            try {
                this.O00000o.O0000O0o().connect(this.O00000o.O0000OOo(), (Object) null, new c() {
                    public void onFailure(g gVar, Throwable th) {
                        String str;
                        if (o0ooo000o.this.O00000oO.get()) {
                            o0ooo000o.this.O00000o.O000000o(Connection.ConnectionStatus.DISCONNECTED);
                            if (o0ooo000o.this.O00000oo != null) {
                                if (th != null) {
                                    th.printStackTrace();
                                    str = th.toString();
                                } else {
                                    str = "";
                                }
                                o0ooo000o.this.O00000oo.O000000o("F005", str);
                            }
                            if (o0ooo000o.this.O0000OOo != null) {
                                o0ooo000o.this.O0000OOo.onFailure(gVar, th);
                            }
                        }
                    }

                    public void onSuccess(g gVar) {
                        if (o0ooo000o.this.O00000oO.get()) {
                            o0ooo000o.this.O00000o.O000000o(Connection.ConnectionStatus.CONNECTED);
                            if (o0ooo000o.this.O0000OOo != null) {
                                o0ooo000o.this.O0000OOo.onSuccess(gVar);
                            }
                            if (o0ooo000o.this.O00000oo != null) {
                                o0ooo000o.this.O00000oo.O00000o();
                            }
                        }
                    }
                });
            } catch (n e2) {
                StringBuilder n = a.n("Failed to connect the client with the handle: ");
                n.append(e2.getMessage());
                L.e(O000000o, n.toString());
            }
        } else {
            o0oo0o0oo.O00000o();
        }
    }

    public void O000000o(String str, int i, o0oo0ooo0 o0oo0ooo0) {
        O000000o(new String[]{str}, new int[]{i}, o0oo0ooo0);
    }

    public void O000000o(String str, final o0oo0ooo0 o0oo0ooo0) {
        try {
            if (O00000o0()) {
                this.O00000o.O0000O0o().unsubscribe(str, (Object) null, (c) new c() {
                    public void onFailure(g gVar, Throwable th) {
                        StringBuilder n = a.n("unSubscribe error: ");
                        n.append(th == null ? "" : th.getMessage());
                        L.mqtt(o0ooo000o.O000000o, n.toString());
                        o0oo0ooo0 o0oo0ooo0 = o0oo0ooo0;
                        if (o0oo0ooo0 != null) {
                            o0oo0ooo0.O000000o(o0ooo0000.O00000o, "null");
                        }
                    }

                    public void onSuccess(g gVar) {
                        L.mqtt(o0ooo000o.O000000o, "unSubscribe success");
                        o0oo0ooo0 o0oo0ooo0 = o0oo0ooo0;
                        if (o0oo0ooo0 != null) {
                            o0oo0ooo0.O000000o();
                        }
                    }
                });
            } else if (o0oo0ooo0 != null) {
                o0oo0ooo0.O000000o("F004", "mqtt not connect");
            }
        } catch (s e2) {
            StringBuilder n = a.n("Failed to unSubscribe: ");
            n.append(e2.getMessage());
            L.e(O000000o, n.toString());
            if (o0oo0ooo0 == null) {
                return;
            }
            o0oo0ooo0.O000000o(o0ooo0000.O00000o, "null");
        } catch (n e3) {
            StringBuilder n2 = a.n("Failed to unSubscribe: ");
            n2.append(e3.getMessage());
            L.e(O000000o, n2.toString());
            if (o0oo0ooo0 == null) {
                return;
            }
            o0oo0ooo0.O000000o(o0ooo0000.O00000o, "null");
        }
    }

    public void O000000o(String str, byte[] bArr, int i, boolean z, final o0oo0ooo0 o0oo0ooo0) {
        if (this.O00000oO.get() && O00000o0()) {
            try {
                this.O00000o.O0000O0o().publish(str, bArr, i, z, (Object) null, new c() {
                    public void onFailure(g gVar, Throwable th) {
                        try {
                            if (o0oo0ooo0 != null) {
                                o0oo0ooo0.O000000o(String.valueOf(gVar.getMessageId()), th.getMessage());
                            }
                        } catch (Exception unused) {
                            o0oo0ooo0.O000000o("null", "Null Exception");
                        }
                    }

                    public void onSuccess(g gVar) {
                        L.mqtt(o0ooo000o.O000000o, "publish success");
                        o0oo0ooo0 o0oo0ooo0 = o0oo0ooo0;
                        if (o0oo0ooo0 != null) {
                            o0oo0ooo0.O000000o();
                        }
                    }
                });
            } catch (n e2) {
                if (o0oo0ooo0 != null) {
                    o0oo0ooo0.O000000o("11005", e2.getMessage());
                }
                StringBuilder n = a.n("Failed to publish a messged: ");
                n.append(e2.getMessage());
                L.e(O000000o, n.toString());
            }
        } else if (o0oo0ooo0 != null) {
            o0oo0ooo0.O000000o("Network Error", "network error");
        }
    }

    public void O000000o(final String[] strArr, int[] iArr, final o0oo0ooo0 o0oo0ooo0) {
        try {
            if (O00000o0()) {
                if (L.getLogStatus()) {
                    L.d(O000000o, "subscribe topics: " + Arrays.toString(strArr));
                }
                this.O00000o.O0000O0o().subscribe(strArr, iArr, (Object) null, (c) new c() {
                    public void onFailure(g gVar, Throwable th) {
                        o0oo0ooo0 o0oo0ooo0 = o0oo0ooo0;
                        if (o0oo0ooo0 != null) {
                            o0oo0ooo0.O000000o(o0ooo0000.O00000oO, "");
                        }
                    }

                    public void onSuccess(g gVar) {
                        o0oo0ooo0 o0oo0ooo0 = o0oo0ooo0;
                        if (o0oo0ooo0 != null) {
                            o0oo0ooo0.O000000o();
                        }
                        if (L.getLogStatus()) {
                            StringBuilder n = a.n("subscribe success: ");
                            n.append(Arrays.toString(strArr));
                            L.d(o0ooo000o.O000000o, n.toString());
                        }
                    }
                });
            } else if (o0oo0ooo0 != null) {
                o0oo0ooo0.O000000o("F004", "mqtt not connect");
            }
        } catch (s e2) {
            e = e2;
            StringBuilder n = a.n("Failed to subscribe: ");
            n.append(e.getMessage());
            L.e(O000000o, n.toString());
            if (o0oo0ooo0 == null) {
                return;
            }
            o0oo0ooo0.O000000o(o0ooo0000.O00000oO, e.getMessage());
        } catch (n e3) {
            e = e3;
            StringBuilder n2 = a.n("Failed to subscribe: ");
            n2.append(e.getMessage());
            L.e(O000000o, n2.toString());
            if (o0oo0ooo0 == null) {
                return;
            }
            o0oo0ooo0.O000000o(o0ooo0000.O00000oO, e.getMessage());
        }
    }

    public void O00000Oo() {
        O00000oO();
        this.O00000oO.set(false);
    }

    public boolean O00000o0() {
        return this.O00000oO.get() && this.O00000o.O0000O0o().isConnected();
    }
}
