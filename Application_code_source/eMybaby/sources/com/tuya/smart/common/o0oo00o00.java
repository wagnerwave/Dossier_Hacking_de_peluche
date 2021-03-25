package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.tuya.sdk.mqttmanager.bean.MqttConfigBean;
import com.tuya.smart.android.base.TuyaSmartSdk;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.LogUtils;
import com.tuya.smart.android.common.utils.MD5Util;
import com.tuya.smart.android.common.utils.PhoneUtil;
import com.tuya.smart.android.common.utils.TuyaConcurrentList;
import com.tuya.smart.android.network.TuyaApiParams;
import com.tuya.smart.android.network.TuyaSmartNetWork;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.android.user.bean.User;
import com.tuya.smart.mqtt.MqttServiceConstants;
import com.tuya.smart.mqtt.MqttTraceHandler;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.ITuyaUser;
import com.tuya.smart.sdk.constant.ServiceNotification;
import e.b.a.a.a.f;
import e.b.a.a.a.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class o0oo00o00 implements o0oo0oo000, f {
    public static final String O000000o = "smart/mb/out/";
    public static final String O00000Oo = "MqttServerManager";
    public static o0oo00o00 O0000Oo = null;
    public static final String O0000OoO = "m/m/i/";
    public MqttConfigBean O00000o;
    public o0oo00000 O00000o0;
    public volatile boolean O00000oO;
    public TuyaConcurrentList<o0oo0ooo0o> O00000oo = new TuyaConcurrentList<>();
    public TuyaConcurrentList<o0oo0ooo00> O0000O0o = new TuyaConcurrentList<>();
    public HashMap<String, Boolean> O0000OOo = new HashMap<>();
    public ReentrantReadWriteLock O0000Oo0;

    public o0oo00o00() {
        O00000oO();
        this.O0000Oo0 = new ReentrantReadWriteLock(true);
    }

    public static o0oo00o00 O000000o() {
        if (O0000Oo == null) {
            synchronized (o0oo00o00.class) {
                if (O0000Oo == null) {
                    O0000Oo = new o0oo00o00();
                }
            }
        }
        return O0000Oo;
    }

    /* access modifiers changed from: private */
    public HashMap<String, Object> O000000o(String str, String str2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("ssl", Boolean.valueOf(this.O00000o.isSsl()));
        hashMap.put("host", this.O00000o.getServerUrl());
        hashMap.put("port", Integer.valueOf(this.O00000o.getPort()));
        hashMap.put(TuyaApiParams.KEY_APP_ID, this.O00000o.getClientId());
        hashMap.put(MqttServiceConstants.TRACE_ERROR, str2);
        hashMap.put(BusinessResponse.KEY_ERRCODE, str);
        return hashMap;
    }

    private HashMap<String, Object> O000000o(String str, String str2, String[] strArr) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(BusinessResponse.KEY_ERRCODE, str);
        hashMap.put(MqttServiceConstants.TRACE_ERROR, str2);
        hashMap.put("devIds", Arrays.toString(strArr));
        return hashMap;
    }

    private void O000000o(User user) {
        this.O00000o = new MqttConfigBean();
        String[] mqttUrl = TuyaSmartNetWork.getMqttUrl();
        boolean z = mqttUrl[1] != null;
        String str = mqttUrl[mqttUrl[1] != null ? (char) 1 : 0];
        String sid = user.getSid();
        StringBuilder p = a.p(PhoneUtil.getDeviceID(TuyaSdk.getApplication()), "_");
        p.append(MD5Util.md5AsBase64(sid + "sdkfasodifca"));
        String sb = p.toString();
        String format = String.format("%s_mb_%s", new Object[]{TuyaSmartSdk.getApplication().getPackageName(), sb});
        int i = z ? o0oo0000o.O0000oOo : 1883;
        this.O00000o.setCleanSession(true);
        this.O00000o.setDebug(TuyaSmartSdk.DEBUG);
        this.O00000o.setQos(1);
        this.O00000o.setKeepAlive(60);
        this.O00000o.setMaxInflight(o0oo0000o.O0000oo0);
        this.O00000o.setWillTopic("tuya/smart/will");
        this.O00000o.setUserName(sb);
        this.O00000o.setTimeOut(15);
        this.O00000o.setRetained(false);
        this.O00000o.setClientId(format);
        this.O00000o.setPort(i);
        this.O00000o.setSsl(z);
        this.O00000o.setSslKey("");
        this.O00000o.setSslPassword("");
        this.O00000o.setServerUrl(str);
    }

    private void O000000o(final String str, final o oVar) {
        TuyaConcurrentList.QueryListCallback queryListCallback;
        TuyaConcurrentList tuyaConcurrentList;
        if (!str.startsWith("m/m/i/")) {
            tuyaConcurrentList = this.O00000oo;
            queryListCallback = new TuyaConcurrentList.QueryListCallback<o0oo0ooo0o>() {
                /* renamed from: O000000o */
                public void query(final o0oo0ooo0o o0oo0ooo0o) {
                    try {
                        o0oooo0oo o0oooo0oo = new o0oooo0oo();
                        o0oooo0oo.O00000Oo(str).O000000o((o0ooo0o0o) new o0ooo0o0o() {
                            public boolean O000000o(String str, int i, int i2) {
                                return o0oo0ooo0o.O000000o(str, i, i2);
                            }
                        }).O000000o(o0oo0ooo0o.O00000Oo()).O000000o((o0ooo0ooo) new o0ooo0ooo() {
                            public String O000000o(String str) {
                                return o0oo0ooo0o.O000000o(str);
                            }
                        });
                        o0oooo0oo.O000000o(oVar.getPayload());
                        o0oooo0oo.O0000O0o().O000000o(new o0ooooo00() {
                            public void O000000o(int i, JSONObject jSONObject) {
                                o0oo0ooo0o.O000000o(str, i, jSONObject);
                            }

                            public void O000000o(String str, String str2) {
                                o0oo0ooo0o.O000000o(str, str, str2);
                            }
                        });
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            };
        } else {
            tuyaConcurrentList = this.O0000O0o;
            queryListCallback = new TuyaConcurrentList.QueryListCallback<o0oo0ooo00>() {
                /* renamed from: O000000o */
                public void query(o0oo0ooo00 o0oo0ooo00) {
                    String O000000o2 = o0oo0ooo00.O000000o(str.replace("m/m/i/", ""));
                    if (!TextUtils.isEmpty(O000000o2)) {
                        o0oo0ooo00.O000000o(str, o0oo00oo0.O000000o(O000000o2, oVar.getPayload()));
                    }
                }
            };
        }
        tuyaConcurrentList.query(queryListCallback);
    }

    private void O00000oO() {
        ITuyaUser O000000o2;
        User user;
        if (!this.O00000oO && (O000000o2 = ((o0o00oo0oo) Oo0.O000000o(o0o00oo0oo.class)).O000000o()) != null && (user = O000000o2.getUser()) != null) {
            this.O00000oO = true;
            O000000o(user);
            O00000oo();
        }
    }

    private void O00000oo() {
        final o0oo0oo00 o0oo00ooo = TuyaSmartNetWork.mSdk ? new o0oo00ooo() : new o0oo0o000();
        o0oo000o0 o0oo000o0 = new o0oo000o0(TuyaSmartSdk.getApplication(), o0oo00ooo, this.O00000o, ServiceNotification.getInstance().getNotification(), ServiceNotification.getInstance().getNotificationId(), new MqttTraceHandler() {
            public void traceDebug(String str, String str2) {
                L.d(str, str2);
            }

            public void traceError(String str, String str2) {
                L.e(str, str2);
            }

            public void traceException(String str, String str2, Exception exc) {
                L.e(str, str2);
                exc.printStackTrace();
            }
        }, this);
        this.O00000o0 = o0oo000o0;
        o0oo000o0.O000000o(new o0oo0oo00o() {
            /* JADX INFO: finally extract failed */
            public void O000000o() {
                o0oo00o00.this.O0000OOo.put(o0oo00ooo.O000000o(), Boolean.FALSE);
                o0oo00o00.this.O00000Oo(o0oo00ooo.O000000o(), (IResultCallback) null);
                final ArrayList arrayList = new ArrayList();
                try {
                    o0oo00o00.this.O0000Oo0.writeLock().lock();
                    for (Map.Entry key : o0oo00o00.this.O0000OOo.entrySet()) {
                        String str = (String) key.getKey();
                        if (!TextUtils.equals(o0oo00ooo.O000000o(), str)) {
                            o0oo00o00.this.O0000OOo.put(str, Boolean.FALSE);
                            arrayList.add(str);
                        }
                    }
                    o0oo00o00.this.O0000Oo0.writeLock().unlock();
                    o0oo00o00.this.O000000o((String[]) arrayList.toArray(new String[0]), (IResultCallback) new IResultCallback() {
                        public void onError(String str, String str2) {
                            for (String O00000Oo2 : arrayList) {
                                o0oo00o00.this.O00000Oo(O00000Oo2, (IResultCallback) null);
                            }
                        }

                        public void onSuccess() {
                        }
                    });
                } catch (Throwable th) {
                    o0oo00o00.this.O0000Oo0.writeLock().unlock();
                    throw th;
                }
            }

            public void O000000o(String str, String str2) {
                LogUtils.logServer("mqtt_connect_failure", o0oo00o00.this.O000000o(str, str2));
                L.e(o0oo00o00.O00000Oo, "errorCode: " + str + " error: " + str2);
            }
        });
    }

    public void O000000o(o0oo0oo00o o0oo0oo00o) {
        O00000oO();
        o0oo00000 o0oo00000 = this.O00000o0;
        if (o0oo00000 != null) {
            o0oo00000.O000000o(o0oo0oo00o);
        }
    }

    public void O000000o(final o0oo0oo0o0 o0oo0oo0o0, final IResultCallback iResultCallback) {
        new o0oooo0o0().O000000o(o0oo0oo0o0.O00000Oo()).O00000o0(o0oo0oo0o0.O00000oO()).O00000oO(o0oo0oo0o0.O0000OOo()).O00000Oo(o0oo0oo0o0.O00000oo()).O00000Oo(o0oo0oo0o0.O00000o0()).O00000o(o0oo0oo0o0.O0000Oo0()).O000000o(o0oo0oo0o0.O00000o()).O00000o0(o0oo0oo0o0.O0000O0o()).O000000o(o0oo0oo0o0.O000000o()).O0000Oo().O000000o(new o0ooo0oo0() {
            public void O000000o(String str, String str2) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(str, str2);
                }
            }

            public void O000000o(byte[] bArr) {
                o0oo00o00 o0oo00o00 = o0oo00o00.this;
                StringBuilder n = a.n("smart/mb/out/");
                n.append(o0oo0oo0o0.O000000o());
                o0oo00o00.O000000o(n.toString(), bArr, iResultCallback);
            }
        });
    }

    public void O000000o(o0oo0ooo00 o0oo0ooo00) {
        this.O0000O0o.add(o0oo0ooo00);
    }

    public void O000000o(o0oo0ooo0o o0oo0ooo0o) {
        this.O00000oo.add(o0oo0ooo0o);
    }

    public void O000000o(String str, int i, IResultCallback iResultCallback) {
        O000000o(new String[]{str}, new int[]{i}, iResultCallback);
    }

    /* JADX INFO: finally extract failed */
    public void O000000o(String str, final IResultCallback iResultCallback) {
        try {
            this.O0000Oo0.writeLock().lock();
            this.O0000OOo.remove(str);
            this.O0000Oo0.writeLock().unlock();
            o0oo00000 o0oo00000 = this.O00000o0;
            if (o0oo00000 != null) {
                o0oo00000.O000000o(str, new o0oo0ooo0() {
                    public void O000000o() {
                        IResultCallback iResultCallback = iResultCallback;
                        if (iResultCallback != null) {
                            iResultCallback.onSuccess();
                        }
                    }

                    public void O000000o(String str, String str2) {
                        IResultCallback iResultCallback = iResultCallback;
                        if (iResultCallback != null) {
                            iResultCallback.onError(str, str2);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            this.O0000Oo0.writeLock().unlock();
            throw th;
        }
    }

    public void O000000o(String str, byte[] bArr, int i, boolean z, final IResultCallback iResultCallback) {
        O00000oO();
        o0oo00000 o0oo00000 = this.O00000o0;
        if (o0oo00000 != null) {
            o0oo00000.O000000o(str, bArr, i, z, new o0oo0ooo0() {
                public void O000000o() {
                    IResultCallback iResultCallback = iResultCallback;
                    if (iResultCallback != null) {
                        iResultCallback.onSuccess();
                    }
                }

                public void O000000o(String str, String str2) {
                    IResultCallback iResultCallback = iResultCallback;
                    if (iResultCallback != null) {
                        iResultCallback.onError(str, str2);
                    }
                }
            });
        }
    }

    public void O000000o(String str, byte[] bArr, IResultCallback iResultCallback) {
        O000000o(str, bArr, 1, false, iResultCallback);
    }

    public void O000000o(String[] strArr, IResultCallback iResultCallback) {
        int[] iArr = new int[strArr.length];
        Arrays.fill(iArr, 1);
        O000000o(strArr, iArr, iResultCallback);
    }

    /* JADX INFO: finally extract failed */
    public void O000000o(final String[] strArr, int[] iArr, final IResultCallback iResultCallback) {
        final ArrayList arrayList = new ArrayList();
        try {
            this.O0000Oo0.writeLock().lock();
            for (String str : strArr) {
                Boolean bool = this.O0000OOo.get(str);
                if (bool == null || !bool.booleanValue()) {
                    this.O0000OOo.put(str, Boolean.FALSE);
                    arrayList.add(str);
                }
            }
            this.O0000Oo0.writeLock().unlock();
            if (!arrayList.isEmpty()) {
                o0oo00000 o0oo00000 = this.O00000o0;
                if (o0oo00000 != null) {
                    o0oo00000.O000000o((String[]) arrayList.toArray(new String[0]), iArr, (o0oo0ooo0) new o0oo0ooo0() {
                        /* JADX INFO: finally extract failed */
                        public void O000000o() {
                            StringBuilder n = a.n("subscribe: success");
                            n.append(Arrays.toString(strArr));
                            L.d(o0oo00o00.O00000Oo, n.toString());
                            try {
                                o0oo00o00.this.O0000Oo0.writeLock().lock();
                                for (String put : arrayList) {
                                    o0oo00o00.this.O0000OOo.put(put, Boolean.TRUE);
                                }
                                o0oo00o00.this.O0000Oo0.writeLock().unlock();
                                IResultCallback iResultCallback = iResultCallback;
                                if (iResultCallback != null) {
                                    iResultCallback.onSuccess();
                                }
                            } catch (Throwable th) {
                                o0oo00o00.this.O0000Oo0.writeLock().unlock();
                                throw th;
                            }
                        }

                        public void O000000o(String str, String str2) {
                            StringBuilder n = a.n("subscribe: failure");
                            n.append(Arrays.toString(strArr));
                            L.e(o0oo00o00.O00000Oo, n.toString());
                            IResultCallback iResultCallback = iResultCallback;
                            if (iResultCallback != null) {
                                iResultCallback.onError(str, str2);
                            }
                        }
                    });
                }
            } else if (iResultCallback != null) {
                iResultCallback.onSuccess();
            }
        } catch (Throwable th) {
            this.O0000Oo0.writeLock().unlock();
            throw th;
        }
    }

    public void O00000Oo() {
        o0oo00o0o.O000000o().O00000o0();
        O00000oO();
        o0oo00000 o0oo00000 = this.O00000o0;
        if (o0oo00000 != null) {
            o0oo00000.O000000o();
        }
    }

    public void O00000Oo(o0oo0oo00o o0oo0oo00o) {
        o0oo00000 o0oo00000 = this.O00000o0;
        if (o0oo00000 != null) {
            o0oo00000.O00000Oo(o0oo0oo00o);
        }
    }

    public void O00000Oo(o0oo0ooo00 o0oo0ooo00) {
        this.O0000O0o.remove(o0oo0ooo00);
    }

    public void O00000Oo(o0oo0ooo0o o0oo0ooo0o) {
        this.O00000oo.remove(o0oo0ooo0o);
    }

    public void O00000Oo(String str, IResultCallback iResultCallback) {
        O000000o(new String[]{str}, iResultCallback);
    }

    public boolean O00000o() {
        O00000oO();
        o0oo00000 o0oo00000 = this.O00000o0;
        return o0oo00000 != null && o0oo00000.O00000o0();
    }

    /* JADX INFO: finally extract failed */
    public void O00000o0() {
        this.O00000oo.clear();
        this.O0000O0o.clear();
        o0oo00000 o0oo00000 = this.O00000o0;
        if (o0oo00000 != null) {
            o0oo00000.O00000Oo();
        }
        try {
            this.O0000Oo0.writeLock().lock();
            this.O0000OOo.clear();
            this.O0000Oo0.writeLock().unlock();
            O0000Oo = null;
        } catch (Throwable th) {
            this.O0000Oo0.writeLock().unlock();
            throw th;
        }
    }

    public void messageArrived(String str, o oVar) {
        O000000o(str, oVar);
    }
}
