package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.tuya.sdk.sweeper.utils.TuyaCloudSignatureTools;
import com.tuya.sdk.sweeper.utils.TuyaRequestCloudTools;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.mqtt.ITuyaMqttRetainChannelListener;
import com.tuya.smart.android.mqtt.MqttMessageBean;
import com.tuya.smart.android.sweeper.ITuyaByteDataListener;
import com.tuya.smart.android.sweeper.ITuyaCloudConfigCallback;
import com.tuya.smart.android.sweeper.ITuyaDelHistoryCallback;
import com.tuya.smart.android.sweeper.ITuyaSweeper;
import com.tuya.smart.android.sweeper.ITuyaSweeperByteDataListener;
import com.tuya.smart.android.sweeper.ITuyaSweeperDataListener;
import com.tuya.smart.android.sweeper.bean.CloudConfigBean;
import com.tuya.smart.android.sweeper.bean.SweeperByteData;
import com.tuya.smart.android.sweeper.bean.SweeperDataBean;
import com.tuya.smart.android.sweeper.bean.SweeperHistory;
import com.tuya.smart.android.sweeper.bean.SweeperPathBean;
import com.tuya.smart.home.sdk.callback.ITuyaResultCallback;
import java.util.List;

public class o00o00oo0o implements ITuyaSweeper {
    public static final String O000000o = "please call initCloudConfig first";
    public static final int O00000o = 601;
    public static final String O00000o0 = "o00o00oo0o";
    public static volatile o00o00oo0o O0000Oo;
    public o0o00o00o0 O00000Oo = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class));
    public o00o00oo00 O00000oO = new o00o00oo00();
    public CloudConfigBean O00000oo;
    public String O0000O0o;
    public String O0000OOo;
    public TuyaRequestCloudTools O0000Oo0 = new TuyaRequestCloudTools();
    public ITuyaMqttRetainChannelListener O0000OoO;

    public static ITuyaSweeper O000000o() {
        if (O0000Oo == null) {
            synchronized (o00o00oo0o.class) {
                if (O0000Oo == null) {
                    O0000Oo = new o00o00oo0o();
                }
            }
        }
        return O0000Oo;
    }

    public void deleteAllHistoryData(String str, ITuyaDelHistoryCallback iTuyaDelHistoryCallback) {
        this.O00000oO.O000000o(str, iTuyaDelHistoryCallback);
    }

    public void deleteSweeperHistoryData(String str, List<String> list, ITuyaDelHistoryCallback iTuyaDelHistoryCallback) {
        this.O00000oO.O000000o(str, list, iTuyaDelHistoryCallback);
    }

    public String getCloudFileUrl(String str, String str2) {
        CloudConfigBean cloudConfigBean = this.O00000oo;
        if (cloudConfigBean == null) {
            return O000000o;
        }
        String generateSignedUrl = TuyaCloudSignatureTools.generateSignedUrl(str2, cloudConfigBean.getExpiration(), this.O00000oo.getRegion(), this.O00000oo.getToken(), this.O00000oo.getSk(), this.O00000oo.getProvider(), this.O00000oo.getEndpoint(), this.O00000oo.getAk(), str);
        return !generateSignedUrl.startsWith("http") ? a.k("https://", generateSignedUrl) : generateSignedUrl;
    }

    public void getSweeperByteData(String str, String str2, final ITuyaByteDataListener iTuyaByteDataListener) {
        if (this.O00000oo != null) {
            this.O0000Oo0.requestCloudBytes(getCloudFileUrl(str, str2), new TuyaRequestCloudTools.ByteArrayCallback() {
                public void onFailure(int i, String str) {
                    ITuyaByteDataListener iTuyaByteDataListener = iTuyaByteDataListener;
                    if (iTuyaByteDataListener != null) {
                        iTuyaByteDataListener.onFailure(i, str);
                    }
                }

                public void onSuccess(byte[] bArr) {
                    ITuyaByteDataListener iTuyaByteDataListener = iTuyaByteDataListener;
                    if (iTuyaByteDataListener != null) {
                        iTuyaByteDataListener.onSweeperByteData(bArr);
                    }
                }
            });
        } else if (iTuyaByteDataListener != null) {
            iTuyaByteDataListener.onFailure(-1001, O000000o);
        }
    }

    public void getSweeperCurrentPath(String str, ITuyaResultCallback<SweeperPathBean> iTuyaResultCallback) {
        CloudConfigBean cloudConfigBean = this.O00000oo;
        if (cloudConfigBean == null || cloudConfigBean.getPathConfig() == null) {
            this.O00000oO.O00000Oo(str, iTuyaResultCallback);
            return;
        }
        SweeperPathBean sweeperPathBean = new SweeperPathBean();
        sweeperPathBean.setMapPath(this.O00000oo.getPathConfig().getCommon() + o00o00o0o0.O00000oo);
        sweeperPathBean.setRoutePath(this.O00000oo.getPathConfig().getCommon() + o00o00o0o0.O00000oO);
        iTuyaResultCallback.onSuccess(sweeperPathBean);
    }

    public void getSweeperHistoryData(String str, int i, int i2, long j, long j2, ITuyaResultCallback<SweeperHistory> iTuyaResultCallback) {
        this.O00000oO.O000000o(str, i, i2, j, j2, iTuyaResultCallback);
    }

    public void getSweeperHistoryData(String str, int i, int i2, ITuyaResultCallback<SweeperHistory> iTuyaResultCallback) {
        getSweeperHistoryData(str, i, i2, -1, -1, iTuyaResultCallback);
    }

    public void initCloudConfig(String str, ITuyaCloudConfigCallback iTuyaCloudConfigCallback) {
        updateCloudConfig(str, iTuyaCloudConfigCallback);
    }

    public void onDestroy() {
        stopConnectSweeperDataChannel();
        this.O0000Oo0 = null;
        this.O0000O0o = null;
        this.O00000oo = null;
        this.O0000OOo = null;
        this.O00000oO.onDestroy();
        O0000Oo = null;
    }

    public void startConnectSweeperByteDataChannel(final ITuyaSweeperByteDataListener iTuyaSweeperByteDataListener) {
        startConnectSweeperDataChannel(new ITuyaSweeperDataListener() {
            public void onSweeperDataReceived(final SweeperDataBean sweeperDataBean) {
                String devId = sweeperDataBean.getDevId();
                if (TextUtils.isEmpty(devId) || !devId.equals(o00o00oo0o.this.O0000OOo)) {
                    String O00000Oo2 = o00o00oo0o.O00000o0;
                    StringBuilder q = a.q("TuyaSweeper onSweeperDataReceived devId=", devId, " init devId=");
                    q.append(o00o00oo0o.this.O0000OOo);
                    q.append(" not same ignore");
                    L.w(O00000Oo2, q.toString());
                    return;
                }
                o00o00oo0o o00o00oo0o = o00o00oo0o.this;
                o00o00oo0o.getSweeperByteData(o00o00oo0o.O0000O0o, sweeperDataBean.getMapPath(), new ITuyaByteDataListener() {
                    public void onFailure(int i, String str) {
                        ITuyaSweeperByteDataListener iTuyaSweeperByteDataListener = iTuyaSweeperByteDataListener;
                        if (iTuyaSweeperByteDataListener != null) {
                            iTuyaSweeperByteDataListener.onFailure(i, str);
                        }
                    }

                    public void onSweeperByteData(byte[] bArr) {
                        SweeperByteData sweeperByteData = new SweeperByteData();
                        sweeperByteData.setData(bArr);
                        sweeperByteData.setType(sweeperDataBean.getMapType());
                        sweeperByteData.setDevId(sweeperDataBean.getDevId());
                        String O00000Oo2 = o00o00oo0o.O00000o0;
                        StringBuilder n = a.n("TuyaSweeper onSweeperByteData dataSize=");
                        n.append(bArr.length);
                        n.append(" devId=");
                        n.append(sweeperByteData.getDevId());
                        n.append(" type=");
                        n.append(sweeperByteData.getType());
                        L.i(O00000Oo2, n.toString());
                        ITuyaSweeperByteDataListener iTuyaSweeperByteDataListener = iTuyaSweeperByteDataListener;
                        if (iTuyaSweeperByteDataListener != null) {
                            iTuyaSweeperByteDataListener.onSweeperByteData(sweeperByteData);
                        }
                    }
                });
            }
        });
    }

    public void startConnectSweeperDataChannel(final ITuyaSweeperDataListener iTuyaSweeperDataListener) {
        this.O0000OoO = new ITuyaMqttRetainChannelListener() {
            public void onMessageReceived(MqttMessageBean mqttMessageBean) {
                if (mqttMessageBean.getProtocol() == 601 && iTuyaSweeperDataListener != null) {
                    SweeperDataBean sweeperDataBean = (SweeperDataBean) JSON.toJavaObject(mqttMessageBean.getData().getJSONObject("data"), SweeperDataBean.class);
                    sweeperDataBean.setDevId(mqttMessageBean.getDataId());
                    String O00000Oo2 = o00o00oo0o.O00000o0;
                    StringBuilder n = a.n("TuyaSweeper onMessageReceived SweeperDataBean = ");
                    n.append(JSON.toJSONString(sweeperDataBean));
                    L.i(O00000Oo2, n.toString());
                    iTuyaSweeperDataListener.onSweeperDataReceived(sweeperDataBean);
                }
            }
        };
        L.d(O00000o0, "TuyaSweeper startConnectSweeperDataChannel  is called ");
        this.O00000Oo.O0000o0o().registerMqttRetainChannelListener(this.O0000OoO);
    }

    public void stopConnectSweeperByteDataChannel() {
        stopConnectSweeperDataChannel();
    }

    public void stopConnectSweeperDataChannel() {
        if (this.O0000OoO != null) {
            L.d(O00000o0, "TuyaSweeper stopConnectSweeperDataChannel  is called ");
            this.O00000Oo.O0000o0o().unRegisterMqttRetainChannelListener(this.O0000OoO);
            this.O0000OoO = null;
        }
    }

    public void updateCloudConfig(final String str, final ITuyaCloudConfigCallback iTuyaCloudConfigCallback) {
        this.O00000oO.O000000o(str, (ITuyaResultCallback<CloudConfigBean>) new ITuyaResultCallback<CloudConfigBean>() {
            /* renamed from: O000000o */
            public void onSuccess(CloudConfigBean cloudConfigBean) {
                CloudConfigBean unused = o00o00oo0o.this.O00000oo = cloudConfigBean;
                String unused2 = o00o00oo0o.this.O0000O0o = cloudConfigBean.getBucket();
                String unused3 = o00o00oo0o.this.O0000OOo = str;
                ITuyaCloudConfigCallback iTuyaCloudConfigCallback = iTuyaCloudConfigCallback;
                if (iTuyaCloudConfigCallback != null) {
                    iTuyaCloudConfigCallback.onConfigSuccess(cloudConfigBean.getBucket());
                }
            }

            public void onError(String str, String str2) {
                ITuyaCloudConfigCallback iTuyaCloudConfigCallback = iTuyaCloudConfigCallback;
                if (iTuyaCloudConfigCallback != null) {
                    iTuyaCloudConfigCallback.onConfigError(str, str2);
                }
            }
        });
    }
}
