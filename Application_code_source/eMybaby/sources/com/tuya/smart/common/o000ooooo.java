package com.tuya.smart.common;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tuya.sdk.hardware.bean.HResponse;
import com.tuya.sdk.hardware.enums.FrameTypeEnum;
import com.tuya.sdk.hardwareprotocol.bean.HDpResponse;
import com.tuya.sdk.hardwareprotocol.bean.HRequest;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.TuyaUtil;
import com.tuya.smart.android.device.TuyaNetworkApi;
import com.tuya.smart.android.hardware.bean.HgwBean;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.constant.ServiceNotification;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class o000ooooo implements o0000oooo, o000o0000, o000o000o, o0oo0o000o {
    public static final String O000000o = "TuyaHardwareManager";
    public o0oo00oo0o O00000Oo;
    public o0oo00o0oo O00000o;
    public o0oo00ooo0 O00000o0;
    public ReentrantReadWriteLock O00000oO;
    public List<o0oo00oo00> O00000oo;
    public volatile boolean O0000O0o;

    /* renamed from: com.tuya.smart.common.o000ooooo$6  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        public static final /* synthetic */ int[] O000000o;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.tuya.sdk.hardware.enums.FrameTypeEnum[] r0 = com.tuya.sdk.hardware.enums.FrameTypeEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                O000000o = r0
                com.tuya.sdk.hardware.enums.FrameTypeEnum r1 = com.tuya.sdk.hardware.enums.FrameTypeEnum.STATUS     // Catch:{ NoSuchFieldError -> 0x0010 }
                r1 = 8
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                int[] r0 = O000000o     // Catch:{ NoSuchFieldError -> 0x0019 }
                com.tuya.sdk.hardware.enums.FrameTypeEnum r1 = com.tuya.sdk.hardware.enums.FrameTypeEnum.DP_QUERY_NEW     // Catch:{ NoSuchFieldError -> 0x0019 }
                r1 = 15
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                int[] r0 = O000000o     // Catch:{ NoSuchFieldError -> 0x0022 }
                com.tuya.sdk.hardware.enums.FrameTypeEnum r1 = com.tuya.sdk.hardware.enums.FrameTypeEnum.DP_QUERY     // Catch:{ NoSuchFieldError -> 0x0022 }
                r1 = 10
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                int[] r0 = O000000o     // Catch:{ NoSuchFieldError -> 0x002b }
                com.tuya.sdk.hardware.enums.FrameTypeEnum r1 = com.tuya.sdk.hardware.enums.FrameTypeEnum.HEART_BEAT     // Catch:{ NoSuchFieldError -> 0x002b }
                r1 = 9
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.o000ooooo.AnonymousClass6.<clinit>():void");
        }
    }

    public static class O000000o {
        public static final o000ooooo O000000o = new o000ooooo();
    }

    public o000ooooo() {
        this.O0000O0o = false;
        this.O00000oO = new ReentrantReadWriteLock(true);
        this.O00000oo = new ArrayList();
    }

    private void O00000Oo(final HResponse hResponse) {
        final o0oo00oo0o o0oo00oo0o = this.O00000Oo;
        if (o0oo00oo0o != null) {
            if (hResponse.getCode() != 0) {
                o0oo00oo0o.O000000o(hResponse.getDevId(), "11005", "hResponse return code != 0");
            } else {
                new o00oo0000().O000000o(hResponse.getDataBinary()).O00000o0(hResponse.getDevId()).O000000o(hResponse.getVersion()).O00000Oo(o0oo00oo0o.O00000Oo(hResponse.getDevId())).O000000o((o00o0o00o) new o00o0o00o() {
                    public boolean O000000o(String str, int i) {
                        return o0oo00oo0o.O000000o(str, i);
                    }

                    public boolean O000000o(String str, int i, int i2) {
                        return o0oo00oo0o.O000000o(str, i, i2);
                    }
                }).O00000oo().O000000o(new o00o0o000() {
                    public void O000000o(HDpResponse hDpResponse) {
                        if (hDpResponse.getCtype() == 2) {
                            String mbid = hDpResponse.getMbid();
                            if (!TextUtils.isEmpty(mbid)) {
                                o0oo00oo0o.O00000Oo(mbid, hDpResponse.getDps());
                            }
                        } else if (TextUtils.equals(hDpResponse.getCid(), hResponse.getDevId()) || TextUtils.isEmpty(hDpResponse.getCid())) {
                            o0oo00oo0o.O000000o(hResponse.getDevId(), hDpResponse.getDps());
                        } else {
                            o0oo00oo0o.O000000o(hResponse.getDevId(), hDpResponse.getCid(), hDpResponse.getCtype(), hDpResponse.getDps());
                        }
                    }

                    public void O000000o(String str, String str2) {
                        o0oo00oo0o.O000000o(hResponse.getDevId(), str, str2);
                    }
                });
            }
        }
    }

    private void O00000o(Context context) {
        o00o00000.O000000o().O00000Oo();
        o000o0o00.O000000o().O00000Oo(context);
        o000o0o00.O000000o().O00000Oo((o000o0000) this);
        o000o0o00.O000000o().O00000Oo((o0000oooo) this);
        o000o0o00.O000000o().O00000Oo((o000o000o) this);
        this.O0000O0o = false;
        if (!this.O00000oo.isEmpty()) {
            try {
                this.O00000oO.writeLock().lock();
                this.O00000oo.clear();
            } finally {
                this.O00000oO.writeLock().unlock();
            }
        }
        this.O00000Oo = null;
        this.O00000o = null;
    }

    public static o0oo0o000o O00000o0() {
        return O000000o.O000000o;
    }

    private void O00000o0(Context context) {
        o000oo000.O000000o().O000000o(ServiceNotification.getInstance().getNotificationId(), ServiceNotification.getInstance().getNotification());
        o000o0o00.O000000o().O000000o(context);
        O00000oO();
    }

    private void O00000oO() {
        if (!this.O0000O0o) {
            o000o0o00.O000000o().O000000o((o000o0000) this);
            o000o0o00.O000000o().O000000o((o0000oooo) this);
            o000o0o00.O000000o().O000000o((o000o000o) this);
            this.O0000O0o = true;
        }
    }

    public void O000000o() {
    }

    public void O000000o(Context context) {
        O00000o0(context);
    }

    public void O000000o(HResponse hResponse) {
        o0oo00oo0o o0oo00oo0o;
        String devId;
        String dps;
        o0oo00oo0o o0oo00oo0o2;
        String devId2;
        String cid;
        int ctype;
        String dps2;
        Type type = HDpResponse.class;
        try {
            FrameTypeEnum frameTypeEnum = FrameTypeEnum.to(hResponse.getType());
            int i = AnonymousClass6.O000000o[frameTypeEnum.ordinal()];
            boolean z = true;
            if (i == 1) {
                O00000Oo(hResponse);
            } else if (i == 2 || i == 3) {
                if (hResponse.getCode() != 0) {
                    if (this.O00000Oo != null) {
                        this.O00000Oo.O000000o(hResponse.getDevId(), "11005", "hResponse return code != 0");
                    }
                } else if (this.O00000Oo != null) {
                    if (TuyaUtil.checkHgwVersion(this.O00000Oo.O00000o0(hResponse.getDevId()), 3.3f)) {
                        byte[] parseAesData = TuyaNetworkApi.parseAesData(hResponse.getDataBinary(), this.O00000Oo.O00000Oo(hResponse.getDevId()));
                        if (frameTypeEnum == FrameTypeEnum.DP_QUERY_NEW) {
                            HDpResponse hDpResponse = (HDpResponse) JSON.parseObject(parseAesData, type, new Feature[0]);
                            if (hDpResponse != null && !TextUtils.equals(hDpResponse.getCid(), hResponse.getDevId()) && !TextUtils.isEmpty(hDpResponse.getCid())) {
                                L.d(O000000o, "code: 0: " + hDpResponse.getDps());
                                o0oo00oo0o2 = this.O00000Oo;
                                devId2 = hResponse.getDevId();
                                cid = hDpResponse.getCid();
                                ctype = hDpResponse.getCtype();
                                dps2 = hDpResponse.getDps();
                            } else if (hDpResponse != null) {
                                L.d(O000000o, "code: 0: " + hDpResponse.getDps());
                                o0oo00oo0o = this.O00000Oo;
                                devId = hResponse.getDevId();
                                dps = hDpResponse.getDps();
                            } else {
                                return;
                            }
                        } else {
                            HDpResponse hDpResponse2 = (HDpResponse) JSON.parseObject(parseAesData, type, new Feature[0]);
                            if (hDpResponse2 != null) {
                                L.d(O000000o, "code: 0: " + hDpResponse2.getDps());
                                o0oo00oo0o = this.O00000Oo;
                                devId = hResponse.getDevId();
                                dps = hDpResponse2.getDps();
                            } else {
                                return;
                            }
                        }
                        o0oo00oo0o.O000000o(devId, dps);
                        return;
                    }
                    HDpResponse hDpResponse3 = (HDpResponse) JSON.parseObject(hResponse.getDataBinary(), type, new Feature[0]);
                    if (hDpResponse3 != null) {
                        L.d(O000000o, "code: 0: " + hDpResponse3.getDps());
                        if (TextUtils.equals(hDpResponse3.getCid(), hResponse.getDevId()) || TextUtils.isEmpty(hDpResponse3.getCid())) {
                            o0oo00oo0o = this.O00000Oo;
                            devId = hResponse.getDevId();
                            dps = hDpResponse3.getDps();
                            o0oo00oo0o.O000000o(devId, dps);
                            return;
                        }
                        o0oo00oo0o2 = this.O00000Oo;
                        devId2 = hResponse.getDevId();
                        cid = hDpResponse3.getCid();
                        ctype = hDpResponse3.getCtype();
                        dps2 = hDpResponse3.getDps();
                    } else {
                        return;
                    }
                    o0oo00oo0o2.O000000o(devId2, cid, ctype, dps2);
                }
            } else if (i != 4 && this.O00000o != null) {
                if (TuyaUtil.checkHgwVersion(hResponse.getVersion(), 3.3f)) {
                    byte[] parseAesData2 = TuyaNetworkApi.parseAesData(hResponse.getDataBinary(), this.O00000Oo.O00000Oo(hResponse.getDevId()));
                    o0oo00o0oo o0oo00o0oo = this.O00000o;
                    String devId3 = hResponse.getDevId();
                    int type2 = hResponse.getType();
                    if (hResponse.getCode() != 0) {
                        z = false;
                    }
                    o0oo00o0oo.O000000o(devId3, type2, z, parseAesData2);
                    return;
                }
                o0oo00o0oo o0oo00o0oo2 = this.O00000o;
                String devId4 = hResponse.getDevId();
                int type3 = hResponse.getType();
                if (hResponse.getCode() != 0) {
                    z = false;
                }
                o0oo00o0oo2.O000000o(devId4, type3, z, hResponse.getDataBinary());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void O000000o(HgwBean hgwBean) {
        o000o0o00.O000000o().O000000o(hgwBean);
    }

    public void O000000o(HgwBean hgwBean, boolean z) {
        o0oo00ooo0 o0oo00ooo0 = this.O00000o0;
        if (o0oo00ooo0 != null) {
            o0oo00ooo0.O000000o(hgwBean, z);
        }
    }

    public void O000000o(o0oo00o0oo o0oo00o0oo) {
        this.O00000o = o0oo00o0oo;
    }

    public void O000000o(o0oo00oo00 o0oo00oo00) {
        if (o0oo00oo00 != null && !this.O00000oo.contains(o0oo00oo00)) {
            try {
                this.O00000oO.writeLock().lock();
                this.O00000oo.add(o0oo00oo00);
            } finally {
                this.O00000oO.writeLock().unlock();
            }
        }
    }

    public void O000000o(o0oo00oo0o o0oo00oo0o) {
        this.O00000Oo = o0oo00oo0o;
    }

    public void O000000o(o0oo00ooo0 o0oo00ooo0) {
        this.O00000o0 = o0oo00ooo0;
    }

    public void O000000o(final o0oo0o00oo o0oo0o00oo, final IResultCallback iResultCallback) {
        new o00o0ooo0().O000000o(o0oo0o00oo.O00000o0()).O000000o(o0oo0o00oo.O00000Oo()).O000000o(o0oo0o00oo.O000000o()).O00000o0(o0oo0o00oo.O00000oO()).O00000Oo(o0oo0o00oo.O00000o()).O00000Oo(o0oo0o00oo.O0000O0o()).O00000o0(o0oo0o00oo.O0000OOo()).O0000OOo().O000000o(new o00o0o0o0<HRequest>() {
            public void O000000o(HRequest hRequest) {
                if (L.getLogStatus()) {
                    L.d(o000ooooo.O000000o, new String(hRequest.getData()));
                }
                o000ooooo.this.O000000o(o0oo0o00oo.O00000Oo(), o0oo0o00oo.O000000o(), hRequest.getData(), iResultCallback);
            }

            public void O000000o(String str, String str2) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(str, str2);
                }
            }
        });
    }

    public void O000000o(final o0oo0o0o00 o0oo0o0o00, final IResultCallback iResultCallback) {
        String jSONString = JSON.toJSONString(o0oo0o0o00.O00000o0(), SerializerFeature.WriteMapNullValue);
        L.d(O000000o, jSONString);
        new o00o0oooo().O000000o(TuyaUtil.checkHgwVersion(o0oo0o0o00.O00000oO(), 3.3f) ? TuyaNetworkApi.encryptAesData(jSONString, o0oo0o0o00.O00000o()) : jSONString.getBytes()).O000000o(o0oo0o0o00.O00000Oo()).O000000o(o0oo0o0o00.O000000o()).O00000o().O000000o(new o00o0o0o0<HRequest>() {
            public void O000000o(HRequest hRequest) {
                o000ooooo.this.O000000o(o0oo0o0o00.O00000Oo(), o0oo0o0o00.O000000o(), hRequest.getData(), iResultCallback);
            }

            public void O000000o(String str, String str2) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(str, str2);
                }
            }
        });
    }

    public void O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            L.e(O000000o, "devId: ==null");
        } else {
            o000o0o00.O000000o().O000000o(str);
        }
    }

    public void O000000o(String str, int i, byte[] bArr, final IResultCallback iResultCallback) {
        o000o0o00.O000000o().O000000o(str, i, bArr, new o000o00o0() {
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

    public void O000000o(String str, HgwBean hgwBean) {
        o00o00000.O000000o().O000000o(str, hgwBean);
    }

    public void O000000o(List<HgwBean> list) {
        if (!this.O00000oo.isEmpty()) {
            try {
                this.O00000oO.readLock().lock();
                for (o0oo00oo00 O000000o2 : this.O00000oo) {
                    O000000o2.O000000o(list);
                }
            } finally {
                this.O00000oO.readLock().unlock();
            }
        }
    }

    public HgwBean O00000Oo(String str) {
        return o00o00000.O000000o().O000000o(str);
    }

    public void O00000Oo() {
        o00o00000.O000000o().O00000Oo();
    }

    public void O00000Oo(Context context) {
        O00000o(context);
    }

    public void O00000Oo(o0oo00oo00 o0oo00oo00) {
        if (o0oo00oo00 != null && this.O00000oo.contains(o0oo00oo00)) {
            try {
                this.O00000oO.writeLock().lock();
                this.O00000oo.remove(o0oo00oo00);
            } finally {
                this.O00000oO.writeLock().unlock();
            }
        }
    }

    public List<HgwBean> O00000o() {
        return o000o0o00.O000000o().O000000o();
    }

    public void O00000o0(String str) {
        o00o00000.O000000o().O00000Oo(str);
    }
}
