package com.tuya.sdk.mqttmanager.model;

import android.content.Context;
import com.tuya.smart.mqtt.MqttAndroidClient;
import e.b.a.a.a.l;

public class Connection {
    public String O000000o = null;
    public String O00000Oo = null;
    public int O00000o = 0;
    public String O00000o0 = null;
    public ConnectionStatus O00000oO = ConnectionStatus.NONE;
    public MqttAndroidClient O00000oo = null;
    public Context O0000O0o = null;
    public l O0000OOo;
    public boolean O0000Oo0 = false;

    /* renamed from: com.tuya.sdk.mqttmanager.model.Connection$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] O000000o;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0025 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x002b */
        static {
            /*
                com.tuya.sdk.mqttmanager.model.Connection$ConnectionStatus[] r0 = com.tuya.sdk.mqttmanager.model.Connection.ConnectionStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                O000000o = r0
                com.tuya.sdk.mqttmanager.model.Connection$ConnectionStatus r1 = com.tuya.sdk.mqttmanager.model.Connection.ConnectionStatus.CONNECTED     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r0 = 2
                r1 = 3
                int[] r2 = O000000o     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.tuya.sdk.mqttmanager.model.Connection$ConnectionStatus r3 = com.tuya.sdk.mqttmanager.model.Connection.ConnectionStatus.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r2 = 5
                int[] r3 = O000000o     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tuya.sdk.mqttmanager.model.Connection$ConnectionStatus r4 = com.tuya.sdk.mqttmanager.model.Connection.ConnectionStatus.NONE     // Catch:{ NoSuchFieldError -> 0x001d }
                r3[r2] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r1 = 4
                int[] r3 = O000000o     // Catch:{ NoSuchFieldError -> 0x0025 }
                com.tuya.sdk.mqttmanager.model.Connection$ConnectionStatus r4 = com.tuya.sdk.mqttmanager.model.Connection.ConnectionStatus.CONNECTING     // Catch:{ NoSuchFieldError -> 0x0025 }
                r4 = 0
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0025 }
            L_0x0025:
                int[] r3 = O000000o     // Catch:{ NoSuchFieldError -> 0x002b }
                com.tuya.sdk.mqttmanager.model.Connection$ConnectionStatus r4 = com.tuya.sdk.mqttmanager.model.Connection.ConnectionStatus.DISCONNECTING     // Catch:{ NoSuchFieldError -> 0x002b }
                r3[r0] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                int[] r0 = O000000o     // Catch:{ NoSuchFieldError -> 0x0032 }
                com.tuya.sdk.mqttmanager.model.Connection$ConnectionStatus r2 = com.tuya.sdk.mqttmanager.model.Connection.ConnectionStatus.ERROR     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tuya.sdk.mqttmanager.model.Connection.AnonymousClass1.<clinit>():void");
        }
    }

    public enum ConnectionStatus {
        CONNECTING,
        CONNECTED,
        DISCONNECTING,
        DISCONNECTED,
        ERROR,
        NONE
    }

    public Connection(String str, String str2, String str3, int i, Context context, MqttAndroidClient mqttAndroidClient, boolean z) {
        this.O000000o = str;
        this.O00000Oo = str2;
        this.O00000o0 = str3;
        this.O00000o = i;
        this.O0000O0o = context;
        this.O00000oo = mqttAndroidClient;
        this.O0000Oo0 = z;
    }

    public String O000000o() {
        return this.O000000o;
    }

    public void O000000o(ConnectionStatus connectionStatus) {
        this.O00000oO = connectionStatus;
    }

    public void O000000o(l lVar) {
        this.O0000OOo = lVar;
    }

    public boolean O000000o(String str) {
        return this.O000000o.equals(str);
    }

    public boolean O00000Oo() {
        return this.O00000oO == ConnectionStatus.CONNECTED;
    }

    public String O00000o() {
        return this.O00000o0;
    }

    public String O00000o0() {
        return this.O00000Oo;
    }

    public boolean O00000oO() {
        ConnectionStatus connectionStatus = this.O00000oO;
        return connectionStatus == ConnectionStatus.CONNECTED || connectionStatus == ConnectionStatus.CONNECTING;
    }

    public boolean O00000oo() {
        return this.O00000oO != ConnectionStatus.ERROR;
    }

    public MqttAndroidClient O0000O0o() {
        return this.O00000oo;
    }

    public l O0000OOo() {
        return this.O0000OOo;
    }

    public int O0000Oo() {
        return this.O0000Oo0 ? 1 : 0;
    }

    public int O0000Oo0() {
        return this.O00000o;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Connection)) {
            return false;
        }
        return this.O000000o.equals(((Connection) obj).O000000o);
    }

    public String toString() {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.O00000Oo);
        stringBuffer.append("\n ");
        switch (AnonymousClass1.O000000o[this.O00000oO.ordinal()]) {
            case 1:
                str = "Connected to";
                break;
            case 2:
                str = "Disconnected from";
                break;
            case 3:
                str = "Unknown connection status to";
                break;
            case 4:
                str = "Connecting to";
                break;
            case 5:
                str = "Disconnecting from";
                break;
            case 6:
                str = "An error occurred connecting to";
                break;
            default:
                stringBuffer.append(" ");
                stringBuffer.append(this.O00000o0);
                return stringBuffer.toString();
        }
        stringBuffer.append(str);
        stringBuffer.append(" ");
        stringBuffer.append(this.O00000o0);
        return stringBuffer.toString();
    }
}
