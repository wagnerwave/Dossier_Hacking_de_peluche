package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.recyclerview.widget.RecyclerView;
import com.tutk.IOTC.Camera;
import com.tuya.sdk.scene.bean.LocalSceneResultBean;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.home.sdk.api.IDevModel;
import com.tuya.smart.home.sdk.bean.scene.SceneIdBean;
import com.tuya.smart.home.sdk.callback.ITuyaResultCallback;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.IResultCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class oo0o00o0o implements o0o0o00000<o0o0oo00oo> {
    public static final int O000000o = 0;
    public static final int O00000Oo = 1;
    public static final int O00000o = 3;
    public static final int O00000o0 = 2;
    public static final int O00000oO = 4;
    public static final int O00000oo = 5;
    public static final int O0000O0o = 1001;
    public IDevModel O0000OOo;
    public int O0000Oo;
    public o0o00o00o0 O0000Oo0;
    public List<String> O0000OoO;
    public ITuyaResultCallback<LocalSceneResultBean> O0000Ooo;
    public Handler O0000o0 = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 1001) {
                return false;
            }
            L.i("HHHHH", "time out");
            oo0o00o0o.this.O000000o();
            LocalSceneResultBean localSceneResultBean = new LocalSceneResultBean();
            localSceneResultBean.setFailure(oo0o00o0o.this.O0000OoO);
            HashMap hashMap = new HashMap();
            for (String put : oo0o00o0o.this.O0000OoO) {
                hashMap.put(put, 6);
            }
            localSceneResultBean.setErrorCode(hashMap);
            if (oo0o00o0o.this.O0000Ooo == null) {
                return false;
            }
            oo0o00o0o.this.O0000Ooo.onSuccess(localSceneResultBean);
            return false;
        }
    });
    public int O0000o00 = 0;

    public void O000000o() {
        IDevModel iDevModel = this.O0000OOo;
        if (iDevModel != null) {
            iDevModel.onDestroy();
        }
        this.O0000o0.removeMessages(1001);
        L.i("HHHHH", "TuyaSdk.getEventBus().unregister...");
        this.O0000Oo0.O0000o00().unRegisterDeviceMqttListener(o0o0oo00oo.class, this);
    }

    public void O000000o(int i) {
        this.O0000o00 = i;
    }

    /* renamed from: O000000o */
    public void onResult(o0o0oo00oo o0o0oo00oo) {
        StringBuilder n = a.n("onEventMainThread....");
        n.append(o0o0oo00oo.O00000oO());
        n.append(":");
        n.append(o0o0oo00oo.O00000o());
        n.append(":cids:");
        n.append(o0o0oo00oo.O000000o());
        n.append(":res:");
        n.append(o0o0oo00oo.O00000oo());
        L.i("HHHHH", n.toString());
        if (this.O0000Oo == o0o0oo00oo.O00000o()) {
            List<String> O000000o2 = o0o0oo00oo.O000000o();
            List<Integer> O00000oo2 = o0o0oo00oo.O00000oo();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            HashMap hashMap = new HashMap();
            if (O00000oo2 == null) {
                L.e("HHHHH", "Time-consuming, no return value, may be the old version of the gateway, please check ...");
                for (String next : this.O0000OoO) {
                    if (O000000o2.contains(next)) {
                        arrayList.add(next);
                    }
                }
            } else if (O00000oo2.size() == this.O0000OoO.size()) {
                for (int i = 0; i < this.O0000OoO.size(); i++) {
                    String str = this.O0000OoO.get(i);
                    int intValue = O00000oo2.get(i).intValue();
                    if (intValue == 0) {
                        arrayList.add(str);
                    } else {
                        arrayList2.add(str);
                        hashMap.put(str, Integer.valueOf(intValue));
                    }
                }
            } else {
                L.e("HHHHH", "The number of hardware return status codes is inconsistent with the number of cids issued. Please check ...");
                for (String next2 : this.O0000OoO) {
                    if (O000000o2.contains(next2)) {
                        arrayList.add(next2);
                    }
                }
            }
            LocalSceneResultBean localSceneResultBean = new LocalSceneResultBean();
            localSceneResultBean.setSuccess(arrayList);
            localSceneResultBean.setFailure(arrayList2);
            localSceneResultBean.setErrorCode(hashMap);
            if (arrayList.size() > 0 || !hashMap.isEmpty()) {
                L.i("HHHHH", "WHAT_CONTROL_TIME_OUT...REMOVE...");
                this.O0000o0.removeMessages(1001);
                L.i("HHHHH", "onEventMainThread..SUC...." + localSceneResultBean.toString());
                ITuyaResultCallback<LocalSceneResultBean> iTuyaResultCallback = this.O0000Ooo;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(localSceneResultBean);
                }
                O000000o();
            }
        }
    }

    public void O000000o(SceneIdBean sceneIdBean, String str, List<String> list, int i, ITuyaResultCallback<LocalSceneResultBean> iTuyaResultCallback) {
        L.i("HHHHH", "TuyaSdk.getEventBus().register...");
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        this.O0000Oo0 = o0o00o00o0;
        if (o0o00o00o0 != null) {
            o0o00o00o0.O0000o00().registerDeviceMqttListener(o0o0oo00oo.class, this);
            this.O0000Oo = i;
            if (list != null) {
                this.O0000OoO = list;
            } else {
                this.O0000OoO = new ArrayList();
            }
            this.O0000OOo = this.O0000Oo0.O000000o(TuyaSdk.getApplication(), str);
            L.i("HHHHH", "cid:" + list + ":actionId:" + this.O0000Oo + "gid:" + sceneIdBean.getGid() + "sid:" + sceneIdBean.getSid());
            if (this.O0000Oo == 0) {
                L.i("HHHHH", "ActionAdd");
                this.O0000OOo.addZigBeeScene(list, sceneIdBean.getGid(), sceneIdBean.getSid(), new IResultCallback() {
                    public void onError(String str, String str2) {
                    }

                    public void onSuccess() {
                    }
                });
            } else {
                L.i("HHHHH", "Actionremove");
                this.O0000OOo.removeZigBeeScene(list, sceneIdBean.getGid(), sceneIdBean.getSid(), new IResultCallback() {
                    public void onError(String str, String str2) {
                    }

                    public void onSuccess() {
                    }
                });
            }
        }
        this.O0000o0.sendEmptyMessageDelayed(1001, (long) ((this.O0000o00 * RecyclerView.MAX_SCROLL_DURATION) + Camera.ThreadSendAudio.SAMPLE_RATE_IN_HZ));
        this.O0000Ooo = iTuyaResultCallback;
    }
}
