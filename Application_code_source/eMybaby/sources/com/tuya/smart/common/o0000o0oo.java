package com.tuya.smart.common;

import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import com.tuya.smart.sdk.api.ITuyaFeedbackManager;
import com.tuya.smart.sdk.bean.feedback.FeedbackBean;
import com.tuya.smart.sdk.bean.feedback.FeedbackMsgBean;
import com.tuya.smart.sdk.bean.feedback.FeedbackTypeRespBean;
import java.util.ArrayList;
import java.util.List;

public class o0000o0oo implements ITuyaFeedbackManager {
    public static volatile o0000o0oo O000000o;
    public oo00o0o00 O00000Oo = new oo00o0o00();

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
    public static synchronized com.tuya.smart.common.o0000o0oo O000000o() {
        /*
            java.lang.Class<com.tuya.smart.common.o0000o0oo> r0 = com.tuya.smart.common.o0000o0oo.class
            monitor-enter(r0)
            com.tuya.smart.common.o0000o0oo r1 = O000000o     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x0018
            monitor-enter(r0)     // Catch:{ all -> 0x001c }
            com.tuya.smart.common.o0000o0oo r1 = O000000o     // Catch:{ all -> 0x0015 }
            if (r1 != 0) goto L_0x0013
            com.tuya.smart.common.o0000o0oo r1 = new com.tuya.smart.common.o0000o0oo     // Catch:{ all -> 0x0015 }
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
            com.tuya.smart.common.o0000o0oo r1 = O000000o     // Catch:{ all -> 0x001c }
            monitor-exit(r0)
            return r1
        L_0x001c:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.o0000o0oo.O000000o():com.tuya.smart.common.o0000o0oo");
    }

    public void addFeedback(final String str, String str2, String str3, int i, final ITuyaDataCallback<FeedbackMsgBean> iTuyaDataCallback) {
        this.O00000Oo.O000000o(str, str2, str3, i, (Business.ResultListener<FeedbackMsgBean>) new Business.ResultListener<FeedbackMsgBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, FeedbackMsgBean feedbackMsgBean, String str) {
                iTuyaDataCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, FeedbackMsgBean feedbackMsgBean, String str) {
                feedbackMsgBean.setContent(str);
                iTuyaDataCallback.onSuccess(feedbackMsgBean);
            }
        });
    }

    public void getFeedbackList(final ITuyaDataCallback<List<FeedbackBean>> iTuyaDataCallback) {
        this.O00000Oo.O00000Oo(new Business.ResultListener<ArrayList<FeedbackBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<FeedbackBean> arrayList, String str) {
                iTuyaDataCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<FeedbackBean> arrayList, String str) {
                iTuyaDataCallback.onSuccess(arrayList);
            }
        });
    }

    public void getFeedbackType(final ITuyaDataCallback<List<FeedbackTypeRespBean>> iTuyaDataCallback) {
        this.O00000Oo.O000000o(new Business.ResultListener<ArrayList<FeedbackTypeRespBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<FeedbackTypeRespBean> arrayList, String str) {
                iTuyaDataCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<FeedbackTypeRespBean> arrayList, String str) {
                iTuyaDataCallback.onSuccess(arrayList);
            }
        });
    }
}
