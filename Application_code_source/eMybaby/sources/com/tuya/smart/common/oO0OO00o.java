package com.tuya.smart.common;

import com.tuya.smart.android.common.utils.SHA256Util;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.home.sdk.api.ITuyaHomeSpeech;
import com.tuya.smart.home.sdk.bean.SpeechGuideBean;
import com.tuya.smart.home.sdk.bean.SpeechPhraseBean;
import com.tuya.smart.home.sdk.bean.VoiceCommandBean;
import com.tuya.smart.home.sdk.callback.ITuyaResultCallback;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import java.util.ArrayList;

public class oO0OO00o implements ITuyaHomeSpeech {
    public static final String O000000o = "wav";
    public static final String O00000Oo = "16000";
    public static final String O00000o = "2";
    public static final String O00000o0 = "1";
    public static final String O00000oO = "asr";
    public static final String O00000oo = "appHelper";
    public static volatile oO0OO00o O0000O0o;
    public final o0O00000 O0000OOo = new o0O00000();

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
    public static synchronized com.tuya.smart.common.oO0OO00o O000000o() {
        /*
            java.lang.Class<com.tuya.smart.common.oO0OO00o> r0 = com.tuya.smart.common.oO0OO00o.class
            monitor-enter(r0)
            com.tuya.smart.common.oO0OO00o r1 = O0000O0o     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x0018
            monitor-enter(r0)     // Catch:{ all -> 0x001c }
            com.tuya.smart.common.oO0OO00o r1 = O0000O0o     // Catch:{ all -> 0x0015 }
            if (r1 != 0) goto L_0x0013
            com.tuya.smart.common.oO0OO00o r1 = new com.tuya.smart.common.oO0OO00o     // Catch:{ all -> 0x0015 }
            r1.<init>()     // Catch:{ all -> 0x0015 }
            O0000O0o = r1     // Catch:{ all -> 0x0015 }
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            goto L_0x0018
        L_0x0015:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            throw r1     // Catch:{ all -> 0x001c }
        L_0x0018:
            com.tuya.smart.common.oO0OO00o r1 = O0000O0o     // Catch:{ all -> 0x001c }
            monitor-exit(r0)
            return r1
        L_0x001c:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.oO0OO00o.O000000o():com.tuya.smart.common.oO0OO00o");
    }

    public void O000000o(String str, final ITuyaDataCallback<String> iTuyaDataCallback) {
        this.O0000OOo.O000000o(str, new Business.ResultListener<String>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, String str, String str2) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onError(str, str2);
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, String str, String str2) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onSuccess(str);
                }
            }
        });
    }

    public void convertToTextWithAudioData(byte[] bArr, String str, String str2, long j, ITuyaResultCallback<String> iTuyaResultCallback) {
        final ITuyaResultCallback<String> iTuyaResultCallback2 = iTuyaResultCallback;
        this.O0000OOo.O000000o(j, str2, str, "1", "2", bArr, O00000oO, O00000oo, SHA256Util.sha256(bArr), new Business.ResultListener<String>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, String str, String str2) {
                iTuyaResultCallback2.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, String str, String str2) {
                iTuyaResultCallback2.onSuccess(businessResponse.getResult());
            }
        });
    }

    public void executeCommandWithSpeechText(String str, long j, final ITuyaDataCallback<VoiceCommandBean> iTuyaDataCallback) {
        this.O0000OOo.O000000o(j, str, new Business.ResultListener<VoiceCommandBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, VoiceCommandBean voiceCommandBean, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, VoiceCommandBean voiceCommandBean, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onSuccess(voiceCommandBean);
                }
            }
        });
    }

    public void getVoiceGuideTipList(final ITuyaDataCallback<SpeechGuideBean> iTuyaDataCallback) {
        this.O0000OOo.O00000Oo(new Business.ResultListener<SpeechGuideBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, SpeechGuideBean speechGuideBean, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, SpeechGuideBean speechGuideBean, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onSuccess(speechGuideBean);
                }
            }
        });
    }

    public void getVoicePhraseTipList(final ITuyaDataCallback<ArrayList<SpeechPhraseBean>> iTuyaDataCallback) {
        this.O0000OOo.O000000o(new Business.ResultListener<ArrayList<SpeechPhraseBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<SpeechPhraseBean> arrayList, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<SpeechPhraseBean> arrayList, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onSuccess(arrayList);
                }
            }
        });
    }
}
