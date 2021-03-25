package com.tuya.smart.common;

import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.TuyaCache;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.TuyaSmartNetWork;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.home.sdk.api.ITuyaDeviceActivator;
import com.tuya.smart.home.sdk.api.ITuyaGwActivator;
import com.tuya.smart.home.sdk.builder.ActivatorBuilder;
import com.tuya.smart.home.sdk.builder.TuyaAutoConfigActivatorBuilder;
import com.tuya.smart.home.sdk.builder.TuyaCameraActivatorBuilder;
import com.tuya.smart.home.sdk.builder.TuyaGwActivatorBuilder;
import com.tuya.smart.home.sdk.builder.TuyaGwSubDevActivatorBuilder;
import com.tuya.smart.home.sdk.builder.TuyaQRCodeActivatorBuilder;
import com.tuya.smart.interior.config.bean.ActiveTokenBean;
import com.tuya.smart.sdk.api.ITuyaActivator;
import com.tuya.smart.sdk.api.ITuyaActivatorCreateToken;
import com.tuya.smart.sdk.api.ITuyaActivatorGetToken;
import com.tuya.smart.sdk.api.ITuyaCameraDevActivator;

public class OOOO0OO implements ITuyaDeviceActivator {
    public static volatile OOOO0OO O000000o;

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static synchronized com.tuya.smart.home.sdk.api.ITuyaDeviceActivator O000000o() {
        /*
            java.lang.Class<com.tuya.smart.common.OOOO0OO> r0 = com.tuya.smart.common.OOOO0OO.class
            monitor-enter(r0)
            com.tuya.smart.common.OOOO0OO r1 = O000000o     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x0018
            monitor-enter(r0)     // Catch:{ all -> 0x001c }
            com.tuya.smart.common.OOOO0OO r1 = O000000o     // Catch:{ all -> 0x0015 }
            if (r1 != 0) goto L_0x0013
            com.tuya.smart.common.OOOO0OO r1 = new com.tuya.smart.common.OOOO0OO     // Catch:{ all -> 0x0015 }
            r1.<init>()     // Catch:{ all -> 0x0015 }
            O000000o = r1     // Catch:{ all -> 0x0015 }
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            goto L_0x0018
        L_0x0015:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            throw r1     // Catch:{ all -> 0x001c }
        L_0x0018:
            com.tuya.smart.common.OOOO0OO r1 = O000000o     // Catch:{ all -> 0x001c }
            monitor-exit(r0)
            return r1
        L_0x001c:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.OOOO0OO.O000000o():com.tuya.smart.home.sdk.api.ITuyaDeviceActivator");
    }

    public void getActivatorToken(final long j, final ITuyaActivatorGetToken iTuyaActivatorGetToken) {
        new oOo00().O000000o(j, (Business.ResultListener<ActiveTokenBean>) new Business.ResultListener<ActiveTokenBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ActiveTokenBean activeTokenBean, String str) {
                iTuyaActivatorGetToken.onFailure(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ActiveTokenBean activeTokenBean, String str) {
                String str2 = TuyaSmartNetWork.getRegion() + activeTokenBean.getToken() + activeTokenBean.getSecret();
                L.d("getActivatorToken", "token: " + str2);
                TuyaCache.getInstance().putKey(str2, Long.valueOf(j));
                iTuyaActivatorGetToken.onSuccess(str2);
            }
        });
    }

    public void getActivatorToken(final long j, String str, final ITuyaActivatorGetToken iTuyaActivatorGetToken) {
        new oOo00().O000000o(j, str, (Business.ResultListener<ActiveTokenBean>) new Business.ResultListener<ActiveTokenBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ActiveTokenBean activeTokenBean, String str) {
                iTuyaActivatorGetToken.onFailure(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ActiveTokenBean activeTokenBean, String str) {
                String str2 = TuyaSmartNetWork.getRegion() + activeTokenBean.getToken() + activeTokenBean.getSecret();
                L.d("getActivatorToken", "token: " + str2);
                TuyaCache.getInstance().putKey(str2, Long.valueOf(j));
                iTuyaActivatorGetToken.onSuccess(str2);
            }
        });
    }

    public void getActivatorToken(final ITuyaActivatorCreateToken iTuyaActivatorCreateToken) {
        new oOo00().O000000o((Business.ResultListener<ActiveTokenBean>) new Business.ResultListener<ActiveTokenBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ActiveTokenBean activeTokenBean, String str) {
                iTuyaActivatorCreateToken.onFailure(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ActiveTokenBean activeTokenBean, String str) {
                iTuyaActivatorCreateToken.onSuccess(TuyaSmartNetWork.getRegion() + activeTokenBean.getToken() + activeTokenBean.getSecret());
            }
        });
    }

    public void getMeshToken(long j, String str, ITuyaActivatorGetToken iTuyaActivatorGetToken) {
    }

    public ITuyaActivator newActivator(ActivatorBuilder activatorBuilder) {
        return new OOOOO00(activatorBuilder);
    }

    public ITuyaActivator newAutoConfigDevActivator(TuyaAutoConfigActivatorBuilder tuyaAutoConfigActivatorBuilder) {
        return new OOOo(tuyaAutoConfigActivatorBuilder);
    }

    public ITuyaCameraDevActivator newCameraDevActivator(TuyaCameraActivatorBuilder tuyaCameraActivatorBuilder) {
        return new OOOO0o0(tuyaCameraActivatorBuilder);
    }

    public ITuyaActivator newEZWifiConfigDevActivator(ActivatorBuilder activatorBuilder) {
        return new OOO0o00(activatorBuilder);
    }

    public ITuyaActivator newGatewayRouterDevActivator(TuyaAutoConfigActivatorBuilder tuyaAutoConfigActivatorBuilder) {
        return new OOOOO0o(tuyaAutoConfigActivatorBuilder);
    }

    public ITuyaActivator newGwActivator(TuyaGwActivatorBuilder tuyaGwActivatorBuilder) {
        return new OOOo000(tuyaGwActivatorBuilder);
    }

    public ITuyaActivator newGwSubDevActivator(TuyaGwSubDevActivatorBuilder tuyaGwSubDevActivatorBuilder) {
        return new Oo000(tuyaGwSubDevActivatorBuilder);
    }

    public ITuyaActivator newMultiActivator(ActivatorBuilder activatorBuilder) {
        return new o0ooo0OO(activatorBuilder);
    }

    public ITuyaActivator newQRCodeDevActivator(TuyaQRCodeActivatorBuilder tuyaQRCodeActivatorBuilder) {
        return new OOo0000(tuyaQRCodeActivatorBuilder);
    }

    public ITuyaGwActivator newTuyaGwActivator() {
        return new OOOOOo0();
    }
}
