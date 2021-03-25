package com.tuya.smart.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tuya.sdk.hardware.enums.FrameTypeEnum;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.NetworkUtil;
import com.tuya.smart.android.common.utils.TuyaCache;
import com.tuya.smart.android.common.utils.TuyaUtil;
import com.tuya.smart.android.device.TuyaNetworkInterface;
import com.tuya.smart.android.hardware.bean.TuyaFrame;
import com.tuya.smart.config.bean.APConfigBeanUDP;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Timer;
import java.util.TimerTask;

public class o0o000o0o0 implements o0o0000ooo {
    public static final String O000000o = "TuyaAPConfig";
    public static volatile o0o000o0o0 O00000Oo;
    public volatile boolean O00000o;
    public TuyaFrame O00000o0;
    public Thread O00000oO;
    public byte[] O00000oo;
    public Timer O0000O0o;

    public class O000000o implements Runnable {
        public final Network O00000Oo;
        public final long O00000o0;

        public O000000o(Network network, long j) {
            this.O00000Oo = network;
            this.O00000o0 = j;
        }

        public void run() {
            while (!o0o000o0o0.this.O00000o) {
                L.d(o0o000o0o0.O000000o, "send msg");
                byte[] O000000o2 = o00o00oo0.O000000o(o0o000o0o0.this.O00000o0);
                try {
                    DatagramSocket datagramSocket = new DatagramSocket();
                    if (Build.VERSION.SDK_INT >= 22 && this.O00000Oo != null) {
                        this.O00000Oo.bindSocket(datagramSocket);
                    }
                    datagramSocket.send(new DatagramPacket(O000000o2, O000000o2.length, new InetSocketAddress("255.255.255.255", 6669)));
                    datagramSocket.setReuseAddress(true);
                    datagramSocket.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    Thread.sleep(this.O00000o0);
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public static int O000000o(Context context) {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) context.getSystemService(NetworkUtil.CONN_TYPE_WIFI);
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return -1;
        }
        return (connectionInfo.getIpAddress() >> 16) & 255;
    }

    /* access modifiers changed from: private */
    @SuppressLint({"TuyaThreadUsage"})
    public void O000000o(Network network) {
        Thread thread = new Thread(new O000000o(network, 2000));
        this.O00000oO = thread;
        thread.start();
    }

    /* access modifiers changed from: private */
    public void O000000o(APConfigBeanUDP aPConfigBeanUDP, Context context) {
        boolean z = true;
        String jSONString = JSON.toJSONString((Object) aPConfigBeanUDP, SerializerFeature.WriteMapNullValue);
        TuyaNetworkInterface.setSecurityContent(TuyaUtil.getAssetsData(context, "fixed_key.bmp", "woeijrweir".getBytes()));
        Object key = TuyaCache.getInstance().getKey("is_ap_config_bind_wlan");
        if (key != null) {
            z = ((Boolean) key).booleanValue();
        }
        TuyaNetworkInterface.SendBroadcast(jSONString.getBytes(), jSONString.getBytes().length, FrameTypeEnum.AP_CONFIG_NEW.type, z);
    }

    @SuppressLint({"TuyaThreadUsage"})
    private void O000000o(APConfigBeanUDP aPConfigBeanUDP, Context context, Network network) {
        String jSONString = JSON.toJSONString((Object) aPConfigBeanUDP, SerializerFeature.WriteMapNullValue);
        TuyaNetworkInterface.setSecurityContent(TuyaUtil.getAssetsData(context, "fixed_key.bmp", "woeijrweir".getBytes()));
        this.O00000oo = TuyaNetworkInterface.getInstance().encryptAesDataForUDP(jSONString);
        TuyaFrame O000000o2 = o00o00oo0.O000000o(FrameTypeEnum.AP_CONFIG_NEW.type, JSON.toJSONString((Object) aPConfigBeanUDP, SerializerFeature.WriteMapNullValue));
        this.O00000o0 = O000000o2;
        O000000o2.setData(this.O00000oo);
        Thread thread = new Thread(new O000000o(network, 500));
        this.O00000oO = thread;
        thread.start();
    }

    public static o0o000o0o0 O00000Oo() {
        if (O00000Oo == null) {
            synchronized (o0o000o0o0.class) {
                O00000Oo = new o0o000o0o0();
            }
        }
        return O00000Oo;
    }

    /* access modifiers changed from: private */
    public void O00000Oo(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            final ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            if (connectivityManager == null) {
                O000000o((Network) null);
                return;
            }
            builder.addTransportType(1);
            NetworkRequest build = builder.build();
            AnonymousClass2 r1 = new ConnectivityManager.NetworkCallback() {
                @TargetApi(23)
                public void onAvailable(Network network) {
                    super.onAvailable(network);
                    o0o000o0o0.this.O000000o(network);
                    connectivityManager.unregisterNetworkCallback(this);
                }

                public void onUnavailable() {
                    o0o000o0o0.this.O000000o((Network) null);
                }
            };
            connectivityManager.registerNetworkCallback(build, r1);
            connectivityManager.requestNetwork(build, r1);
            return;
        }
        O000000o((Network) null);
    }

    public void O000000o() {
        this.O00000o = true;
        Thread thread = this.O00000oO;
        if (thread != null) {
            thread.interrupt();
        }
        Timer timer = this.O0000O0o;
        if (timer != null) {
            timer.cancel();
            this.O0000O0o = null;
        }
        TuyaNetworkInterface.stopBroadcast();
    }

    public void O000000o(final Context context, String str, String str2, String str3) {
        final APConfigBeanUDP aPConfigBeanUDP = new APConfigBeanUDP();
        aPConfigBeanUDP.setSsid(str);
        aPConfigBeanUDP.setPasswd(str2);
        aPConfigBeanUDP.setToken(str3);
        this.O00000o0 = o00o00oo0.O000000o(FrameTypeEnum.AP_CONFIG.type, JSON.toJSONString((Object) aPConfigBeanUDP, SerializerFeature.WriteMapNullValue));
        this.O00000o = false;
        if (context != null) {
            Timer timer = new Timer();
            this.O0000O0o = timer;
            timer.schedule(new TimerTask() {
                public void run() {
                    int O000000o2 = o0o000o0o0.O000000o(context);
                    if (O000000o2 == 175) {
                        o0o000o0o0.this.O0000O0o.cancel();
                        Timer unused = o0o000o0o0.this.O0000O0o = null;
                        o0o000o0o0.this.O000000o(aPConfigBeanUDP, context);
                    } else if (O000000o2 != -1) {
                        o0o000o0o0.this.O0000O0o.cancel();
                        Timer unused2 = o0o000o0o0.this.O0000O0o = null;
                        boolean z = true;
                        Object key = TuyaCache.getInstance().getKey("is_ap_config_bind_wlan");
                        if (key != null) {
                            z = ((Boolean) key).booleanValue();
                        }
                        if (z) {
                            o0o000o0o0.this.O00000Oo(context);
                        } else {
                            o0o000o0o0.this.O000000o((Network) null);
                        }
                    }
                }
            }, 0, 1000);
            return;
        }
        O000000o((Network) null);
    }

    @Deprecated
    public void O000000o(String str, String str2, String str3) {
        O000000o((Context) null, str, str2, str3);
    }
}
