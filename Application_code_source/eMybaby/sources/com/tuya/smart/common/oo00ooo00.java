package com.tuya.smart.common;

import android.annotation.SuppressLint;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.android.user.api.IBooleanCallback;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import com.tuya.smart.sdk.api.ITuyaMessage;
import com.tuya.smart.sdk.bean.message.MessageAttach;
import com.tuya.smart.sdk.bean.message.MessageBean;
import com.tuya.smart.sdk.bean.message.MessageListBean;
import com.tuya.smart.sdk.bean.message.MessageType;
import java.util.ArrayList;
import java.util.List;

public class oo00ooo00 implements ITuyaMessage {
    public static volatile oo00ooo00 O000000o;
    @SuppressLint({"TuyaBusinessDestroy"})
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
    public static synchronized com.tuya.smart.common.oo00ooo00 O000000o() {
        /*
            java.lang.Class<com.tuya.smart.common.oo00ooo00> r0 = com.tuya.smart.common.oo00ooo00.class
            monitor-enter(r0)
            com.tuya.smart.common.oo00ooo00 r1 = O000000o     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x0018
            monitor-enter(r0)     // Catch:{ all -> 0x001c }
            com.tuya.smart.common.oo00ooo00 r1 = O000000o     // Catch:{ all -> 0x0015 }
            if (r1 != 0) goto L_0x0013
            com.tuya.smart.common.oo00ooo00 r1 = new com.tuya.smart.common.oo00ooo00     // Catch:{ all -> 0x0015 }
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
            com.tuya.smart.common.oo00ooo00 r1 = O000000o     // Catch:{ all -> 0x001c }
            monitor-exit(r0)
            return r1
        L_0x001c:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.oo00ooo00.O000000o():com.tuya.smart.common.oo00ooo00");
    }

    private MessageAttach O000000o(String str) {
        MessageAttach messageAttach = new MessageAttach();
        messageAttach.setUrl(str);
        if (str.endsWith(".mp4")) {
            messageAttach.setVideo(true);
            messageAttach.setThumbUrl(str.replace(".mp4", ".jpg"));
        }
        return messageAttach;
    }

    public void cancelAll() {
        oo00o0o00 oo00o0o00 = this.O00000Oo;
        if (oo00o0o00 != null) {
            oo00o0o00.cancelAll();
        }
    }

    public void deleteMessages(List<String> list, final IBooleanCallback iBooleanCallback) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append(list.get(i));
            if (i != size - 1) {
                sb.append(",");
            }
        }
        this.O00000Oo.O000000o(sb.toString(), new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                iBooleanCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                iBooleanCallback.onSuccess();
            }
        });
    }

    public void getMessageList(int i, int i2, long j, long j2, final ITuyaDataCallback<MessageListBean> iTuyaDataCallback) {
        this.O00000Oo.O000000o(i, i2, j, j2, (Business.ResultListener<MessageListBean>) new Business.ResultListener<MessageListBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, MessageListBean messageListBean, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, MessageListBean messageListBean, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onSuccess(messageListBean);
                }
            }
        });
    }

    public void getMessageList(int i, int i2, ITuyaDataCallback<MessageListBean> iTuyaDataCallback) {
        getMessageList(i, i2, 0, 0, iTuyaDataCallback);
    }

    public void getMessageList(final ITuyaDataCallback<List<MessageBean>> iTuyaDataCallback) {
        this.O00000Oo.O00000o0(new Business.ResultListener<ArrayList<MessageBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<MessageBean> arrayList, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<MessageBean> arrayList, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onSuccess(arrayList);
                }
            }
        });
    }

    public void getMessageListByMsgSrcId(int i, int i2, MessageType messageType, String str, final ITuyaDataCallback<MessageListBean> iTuyaDataCallback) {
        this.O00000Oo.O000000o(i, i2, messageType.getValue(), str, (Business.ResultListener<MessageListBean>) new Business.ResultListener<MessageListBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, MessageListBean messageListBean, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, MessageListBean messageListBean, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onSuccess(messageListBean);
                }
            }
        });
    }

    public void getMessageListByMsgSrcId(int i, int i2, MessageType messageType, String str, boolean z, final ITuyaDataCallback<MessageListBean> iTuyaDataCallback) {
        if (z) {
            this.O00000Oo.O00000Oo(i, i2, messageType.getValue(), str, new Business.ResultListener<MessageListBean>() {
                /* renamed from: O000000o */
                public void onFailure(BusinessResponse businessResponse, MessageListBean messageListBean, String str) {
                    ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                    if (iTuyaDataCallback != null) {
                        iTuyaDataCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                    }
                }

                /* renamed from: O00000Oo */
                public void onSuccess(BusinessResponse businessResponse, MessageListBean messageListBean, String str) {
                    ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                    if (iTuyaDataCallback != null) {
                        iTuyaDataCallback.onSuccess(messageListBean);
                    }
                }
            });
            return;
        }
        getMessageListByMsgSrcId(i, i2, messageType, str, iTuyaDataCallback);
    }

    public void getMessageListByMsgType(int i, int i2, MessageType messageType, final ITuyaDataCallback<MessageListBean> iTuyaDataCallback) {
        this.O00000Oo.O000000o(i, i2, messageType.getValue(), (Business.ResultListener<MessageListBean>) new Business.ResultListener<MessageListBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, MessageListBean messageListBean, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, MessageListBean messageListBean, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onSuccess(messageListBean);
                }
            }
        });
    }

    public void getMessageMaxTime(final ITuyaDataCallback<Integer> iTuyaDataCallback) {
        this.O00000Oo.O00000o(new Business.ResultListener<Integer>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Integer num, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Integer num, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onSuccess(num);
                }
            }
        });
    }
}
