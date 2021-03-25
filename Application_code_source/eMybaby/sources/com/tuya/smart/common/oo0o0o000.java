package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Message;
import android.util.Log;
import com.tuya.sdk.scene.bean.LocalSceneResultBean;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.mvp.presenter.BasePresenter;
import com.tuya.smart.home.sdk.api.ITuyaZigBeeConfigLocalSceneCallback;
import com.tuya.smart.home.sdk.bean.scene.SceneIdBean;
import com.tuya.smart.home.sdk.bean.scene.SceneTask;
import com.tuya.smart.home.sdk.callback.ITuyaResultCallback;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class oo0o0o000 extends BasePresenter {
    public static final String O00000Oo = "TuyaZigBeeLocalSceneTask";
    public static final int O00000o0 = 2;
    public static final int O00000oO = 1;
    public final HashMap<String, SceneTask> O000000o = new HashMap<>();
    public final oo0o00ooo O00000o;
    public final List<SceneTask> O00000oo;
    public final int O0000O0o;
    public final List<SceneTask> O0000OOo;
    public List<String> O0000Oo;
    public final HashMap<String, SceneIdBean> O0000Oo0;
    public HashMap<String, ArrayList<String>> O0000OoO;
    public oo0o0o00o O0000Ooo;
    public oo0o00o0o O0000o;
    public CountDownLatch O0000o0;
    public Thread O0000o00;
    public boolean O0000o0O;
    public ITuyaZigBeeConfigLocalSceneCallback O0000o0o;
    public Map<String, Integer> O0000oO;
    public ArrayList<SceneIdBean> O0000oO0;

    public oo0o0o000(List<SceneTask> list, int i) {
        ArrayList arrayList = new ArrayList();
        this.O00000oo = arrayList;
        arrayList.addAll(list);
        this.O0000O0o = i;
        this.O0000OOo = new ArrayList();
        this.O0000Oo = new ArrayList();
        this.O0000OoO = new HashMap<>();
        this.O0000oO = new HashMap();
        O000000o(this.O00000oo);
        this.O0000Oo0 = new HashMap<>();
        this.O00000o = new oo0o00ooo(this.mHandler);
        O000000o();
    }

    private void O000000o() {
        ArrayList arrayList;
        this.O0000oO0 = new ArrayList<>();
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        if (o0o00o00o0 != null) {
            for (SceneTask next : this.O00000oo) {
                DeviceBean deviceBean = o0o00o00o0.O0000OOo().getDeviceBean(next.getEntityId());
                if (this.O0000OoO.get(deviceBean.getMeshId()) == null) {
                    arrayList = new ArrayList();
                    this.O0000Oo.add(deviceBean.getMeshId());
                } else {
                    arrayList = this.O0000OoO.get(deviceBean.getMeshId());
                }
                if (!arrayList.contains(deviceBean.getNodeId())) {
                    arrayList.add(deviceBean.getNodeId());
                }
                this.O000000o.put(deviceBean.getNodeId(), next);
                this.O0000OoO.put(deviceBean.getMeshId(), arrayList);
            }
        }
        for (SceneTask next2 : this.O00000oo) {
            SceneIdBean sceneIdBean = next2.getSceneIdBean();
            if (sceneIdBean != null) {
                this.O0000Oo0.put(sceneIdBean.getGwId(), next2.getSceneIdBean());
            }
        }
        this.O0000oO0.addAll(this.O0000Oo0.values());
        this.O00000o.O000000o(this.O0000Oo0);
    }

    private void O000000o(final ArrayList<SceneIdBean> arrayList) {
        StringBuilder n = a.n("sendGidAndSid:");
        n.append(arrayList.size());
        Log.i("HHHHHH", n.toString());
        Thread thread = new Thread(new Runnable() {
            public void run() {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    final SceneIdBean sceneIdBean = (SceneIdBean) it.next();
                    StringBuilder n = a.n("sendGidAndSid: enter foreach");
                    n.append(oo0o0o000.this.O0000o0O);
                    n.append("sceneIdBean:");
                    n.append(sceneIdBean.getGid());
                    n.append(":");
                    n.append(sceneIdBean.getSid());
                    Log.i("HHHHHH", n.toString());
                    if (oo0o0o000.this.O0000o0O) {
                        break;
                    }
                    CountDownLatch unused = oo0o0o000.this.O0000o0 = new CountDownLatch(1);
                    Log.i("HHHHHH", "sendGidAndSid: handler post start");
                    oo0o0o000.this.mHandler.post(new Runnable() {
                        public void run() {
                            oo0o00o0o unused = oo0o0o000.this.O0000o = new oo0o00o0o();
                            oo0o0o000.this.O0000o.O000000o(oo0o0o000.this.O00000oo.size());
                            Log.i("HHHHHH", "sendGidAndSid: sendCommand...");
                            oo0o00o0o O00000o0 = oo0o0o000.this.O0000o;
                            SceneIdBean sceneIdBean = sceneIdBean;
                            O00000o0.O000000o(sceneIdBean, sceneIdBean.getGwId(), (List) oo0o0o000.this.O0000OoO.get(sceneIdBean.getGwId()), oo0o0o000.this.O0000O0o, new ITuyaResultCallback<LocalSceneResultBean>() {
                                /* renamed from: O000000o */
                                public void onSuccess(LocalSceneResultBean localSceneResultBean) {
                                    Integer num;
                                    ArrayList arrayList = new ArrayList();
                                    if (localSceneResultBean.getSuccess() != null) {
                                        for (String str : localSceneResultBean.getSuccess()) {
                                            SceneTask sceneTask = oo0o0o000.this.O000000o.get(str);
                                            if (sceneTask != null) {
                                                Map<String, Object> extraProperty = sceneTask.getExtraProperty();
                                                if (extraProperty == null || extraProperty.isEmpty()) {
                                                    sceneTask.setSceneId(sceneIdBean);
                                                }
                                                StringBuilder n = a.n("sendGidAndSid suc:");
                                                n.append(sceneTask.getEntityName());
                                                Log.i("HHHHHH", n.toString());
                                                for (SceneTask sceneTask2 : oo0o0o000.this.O00000oo) {
                                                    if (sceneTask2.getEntityId().equals(sceneTask.getEntityId())) {
                                                        if (sceneTask2.getExtraProperty() == null || sceneTask2.getExtraProperty().isEmpty()) {
                                                            sceneTask2.setSceneId(sceneIdBean);
                                                        }
                                                        arrayList.add(sceneTask2);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    List<String> failure = localSceneResultBean.getFailure();
                                    Map<String, Integer> errorCode = localSceneResultBean.getErrorCode();
                                    if (failure != null) {
                                        for (String next : failure) {
                                            SceneTask sceneTask3 = oo0o0o000.this.O000000o.get(next);
                                            if (!(errorCode == null || (num = errorCode.get(next)) == null)) {
                                                oo0o0o000.this.O0000oO.put(sceneTask3.getEntityId(), num);
                                            }
                                        }
                                    }
                                    oo0o0o000.this.O0000OOo.addAll(arrayList);
                                    oo0o0o000.this.O0000o0.countDown();
                                }

                                public void onError(String str, String str2) {
                                }
                            });
                        }
                    });
                    try {
                        oo0o0o000.this.O0000o0.await();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                oo0o0o000.this.mHandler.sendEmptyMessage(2);
            }
        });
        this.O0000o00 = thread;
        thread.start();
    }

    private void O000000o(List<SceneTask> list) {
        Iterator<SceneTask> it = list.iterator();
        while (it.hasNext()) {
            SceneTask next = it.next();
            if (!O000000o(next)) {
                it.remove();
                this.O0000OOo.add(next);
            }
        }
    }

    private boolean O000000o(SceneTask sceneTask) {
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        if (o0o00o00o0 != null) {
            DeviceBean deviceBean = o0o00o00o0.O0000OOo().getDeviceBean(sceneTask.getEntityId());
            return deviceBean != null && deviceBean.isZigBeeSubDev();
        }
        L.d(O00000Oo, "mTuyaDevicePlugin == null");
        return false;
    }

    private void O00000Oo(List<SceneTask> list) {
        oo0o0o00o oo0o0o00o = new oo0o0o00o(list);
        this.O0000Ooo = oo0o0o00o;
        oo0o0o00o.O000000o((ITuyaZigBeeConfigLocalSceneCallback) new ITuyaZigBeeConfigLocalSceneCallback() {
            public void onLocalSceneConfigSuccess(List<SceneTask> list, Map<String, Integer> map) {
                Message obtain = Message.obtain();
                obtain.obj = list;
                obtain.what = 1;
                oo0o0o000.this.mHandler.sendMessage(obtain);
            }
        });
    }

    public void O000000o(ITuyaZigBeeConfigLocalSceneCallback iTuyaZigBeeConfigLocalSceneCallback) {
        this.O0000o0O = false;
        this.O0000o0o = iTuyaZigBeeConfigLocalSceneCallback;
        if (this.O00000oo.size() == 0) {
            ITuyaZigBeeConfigLocalSceneCallback iTuyaZigBeeConfigLocalSceneCallback2 = this.O0000o0o;
            if (iTuyaZigBeeConfigLocalSceneCallback2 != null) {
                iTuyaZigBeeConfigLocalSceneCallback2.onLocalSceneConfigSuccess(this.O0000OOo, this.O0000oO);
            }
        } else if (this.O0000O0o == 1) {
            O000000o(this.O0000oO0);
        } else {
            O00000Oo(this.O00000oo);
        }
    }

    public void O000000o(List<SceneTask> list, ITuyaZigBeeConfigLocalSceneCallback iTuyaZigBeeConfigLocalSceneCallback) {
        this.O00000oo.clear();
        this.O00000oo.addAll(list);
        O000000o();
        O000000o(iTuyaZigBeeConfigLocalSceneCallback);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
        if (r0 != null) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleMessage(android.os.Message r4) {
        /*
            r3 = this;
            int r0 = r4.what
            r1 = 1
            if (r0 == r1) goto L_0x003a
            r1 = 2
            if (r0 == r1) goto L_0x0035
            r1 = 242(0xf2, float:3.39E-43)
            java.lang.String r2 = "HHHHH"
            if (r0 == r1) goto L_0x0026
            r1 = 243(0xf3, float:3.4E-43)
            if (r0 == r1) goto L_0x0013
            goto L_0x0041
        L_0x0013:
            java.lang.String r0 = "WHAT_ALLOC_SCENEID_SUCCESS:"
            android.util.Log.i(r2, r0)
            java.lang.Object r0 = r4.obj
            com.tuya.smart.android.mvp.bean.Result r0 = (com.tuya.smart.android.mvp.bean.Result) r0
            java.lang.Object r0 = r0.getObj()
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            r3.O000000o((java.util.ArrayList<com.tuya.smart.home.sdk.bean.scene.SceneIdBean>) r0)
            goto L_0x0041
        L_0x0026:
            java.lang.String r0 = "WHAT_ALLOC_SCENEID_FAILURE:"
            android.util.Log.i(r2, r0)
            com.tuya.smart.home.sdk.api.ITuyaZigBeeConfigLocalSceneCallback r0 = r3.O0000o0o
        L_0x002d:
            java.util.List<com.tuya.smart.home.sdk.bean.scene.SceneTask> r1 = r3.O0000OOo
            java.util.Map<java.lang.String, java.lang.Integer> r2 = r3.O0000oO
            r0.onLocalSceneConfigSuccess(r1, r2)
            goto L_0x0041
        L_0x0035:
            com.tuya.smart.home.sdk.api.ITuyaZigBeeConfigLocalSceneCallback r0 = r3.O0000o0o
            if (r0 == 0) goto L_0x0041
            goto L_0x002d
        L_0x003a:
            com.tuya.smart.common.oo0o00ooo r0 = r3.O00000o
            java.util.List<java.lang.String> r1 = r3.O0000Oo
            r0.O000000o((java.util.List<java.lang.String>) r1)
        L_0x0041:
            boolean r4 = super.handleMessage(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.oo0o0o000.handleMessage(android.os.Message):boolean");
    }

    public void onDestroy() {
        this.O00000oo.clear();
        this.O0000OoO.clear();
        this.O0000Oo.clear();
        this.O0000OOo.clear();
        this.O000000o.clear();
        oo0o0o00o oo0o0o00o = this.O0000Ooo;
        if (oo0o0o00o != null) {
            oo0o0o00o.O000000o();
        }
        CountDownLatch countDownLatch = this.O0000o0;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
        Thread thread = this.O0000o00;
        if (thread != null) {
            thread.interrupt();
        }
        oo0o00o0o oo0o00o0o = this.O0000o;
        if (oo0o00o0o != null) {
            oo0o00o0o.O000000o();
        }
    }
}
