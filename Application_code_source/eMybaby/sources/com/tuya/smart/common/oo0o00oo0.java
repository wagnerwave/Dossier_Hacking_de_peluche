package com.tuya.smart.common;

import a.a.a.a.a;
import android.util.Log;
import com.tuya.smart.android.mvp.presenter.BasePresenter;
import com.tuya.smart.home.sdk.api.ITuyaZigBeeConfigLocalSceneCallback;
import com.tuya.smart.home.sdk.api.ITuyaZigBeeLocalScene;
import com.tuya.smart.home.sdk.bean.scene.SceneIdBean;
import com.tuya.smart.home.sdk.bean.scene.SceneTask;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.IResultCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class oo0o00oo0 extends BasePresenter implements ITuyaZigBeeLocalScene {
    public final List<SceneTask> O000000o;
    public final List<SceneTask> O00000Oo;
    public final oo0o0o000 O00000o;
    public final oo0o0o000 O00000o0;
    public ITuyaZigBeeConfigLocalSceneCallback O00000oO;
    public final List<SceneTask> O00000oo;
    public volatile boolean O0000O0o = false;
    public Map<String, Integer> O0000OOo;

    public oo0o00oo0(List<SceneTask> list, List<SceneTask> list2) {
        this.O000000o = list;
        this.O00000Oo = list2;
        this.O00000oo = new ArrayList();
        this.O0000OOo = new HashMap();
        this.O00000o0 = new oo0o0o000(this.O000000o, 0);
        this.O00000o = new oo0o0o000(this.O00000Oo, 1);
    }

    private void O000000o() {
        Log.i("HHHHHH", "dealTasks.....");
        if (this.O0000O0o) {
            if (this.O00000Oo.size() > 0) {
                Log.i("HHHHHH", "deleteTask start.....");
                this.O00000o.O000000o((ITuyaZigBeeConfigLocalSceneCallback) new ITuyaZigBeeConfigLocalSceneCallback() {
                    public void onLocalSceneConfigSuccess(List<SceneTask> list, Map<String, Integer> map) {
                        StringBuilder n = a.n("deleteTask finish.....");
                        n.append(list.size());
                        Log.i("HHHHHH", n.toString());
                        oo0o00oo0.this.O00000oo.addAll(list);
                        Log.i("HHHHHH", "deleteTask suc size....." + oo0o00oo0.this.O00000oo.size());
                        oo0o00oo0.this.O00000Oo();
                    }
                });
                return;
            }
            O00000Oo();
        }
    }

    /* access modifiers changed from: private */
    public void O000000o(List<SceneTask> list) {
        if (list.size() > 0) {
            this.O00000o0.O000000o(list, (ITuyaZigBeeConfigLocalSceneCallback) new ITuyaZigBeeConfigLocalSceneCallback() {
                public void onLocalSceneConfigSuccess(List<SceneTask> list, Map<String, Integer> map) {
                    oo0o00oo0.this.O00000oo.addAll(list);
                    Map unused = oo0o00oo0.this.O0000OOo = map;
                    oo0o00oo0.this.O00000o0();
                }
            });
        } else {
            O00000o0();
        }
    }

    /* access modifiers changed from: private */
    public void O00000Oo() {
        if (this.O000000o.size() > 0) {
            Log.i("HHHHHH", "addTask start.....");
            this.O00000o0.O000000o((ITuyaZigBeeConfigLocalSceneCallback) new ITuyaZigBeeConfigLocalSceneCallback() {
                public void onLocalSceneConfigSuccess(List<SceneTask> list, Map<String, Integer> map) {
                    StringBuilder n = a.n("addTask finish.....");
                    n.append(list.size());
                    Log.i("HHHHHH", n.toString());
                    oo0o00oo0.this.O00000oo.addAll(list);
                    Map unused = oo0o00oo0.this.O0000OOo = map;
                    Log.i("HHHHHH", "addTask suc size....." + oo0o00oo0.this.O00000oo.size());
                    oo0o00oo0.this.O00000o0();
                }
            });
            return;
        }
        O00000o0();
    }

    /* access modifiers changed from: private */
    public void O00000o0() {
        if (this.O00000oO != null) {
            StringBuilder n = a.n("return.....");
            n.append(this.O00000oo.size());
            n.append("erroCode");
            n.append(this.O0000OOo.size());
            Log.i("HHHHHH", n.toString());
            this.O00000oO.onLocalSceneConfigSuccess(this.O00000oo, this.O0000OOo);
        }
    }

    public void executeLocalScene(List<SceneTask> list, IResultCallback iResultCallback) {
        ArrayList arrayList = new ArrayList();
        for (SceneTask sceneIdBean : list) {
            SceneIdBean sceneIdBean2 = sceneIdBean.getSceneIdBean();
            if (sceneIdBean2 != null && !arrayList.contains(sceneIdBean2)) {
                arrayList.add(sceneIdBean2);
            }
        }
        if (arrayList.size() != 0) {
            o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
            if (o0o00o00o0 != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    SceneIdBean sceneIdBean3 = (SceneIdBean) it.next();
                    o0o00o00o0.O000000o(TuyaSdk.getApplication(), sceneIdBean3.getGwId()).localSceneExecute(sceneIdBean3.getGid(), sceneIdBean3.getSid(), iResultCallback);
                }
            }
        } else if (iResultCallback != null) {
            iResultCallback.onError("121342", "only local scene support it");
        }
    }

    public void executeNewLocalScene(String str, String str2, IResultCallback iResultCallback) {
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        if (o0o00o00o0 != null) {
            o0o00o00o0.O000000o(TuyaSdk.getApplication(), str).localSceneExecuteNew(str2, iResultCallback);
        }
    }

    public void executeSceneOnline(String str, String str2, IResultCallback iResultCallback) {
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        if (o0o00o00o0 != null) {
            o0o00o00o0.O000000o(TuyaSdk.getApplication(), str).sceneExecuteMqtt(str2, iResultCallback);
        }
    }

    public void retrySendCommandTask(List<SceneTask> list, ITuyaZigBeeConfigLocalSceneCallback iTuyaZigBeeConfigLocalSceneCallback) {
        this.O00000oO = iTuyaZigBeeConfigLocalSceneCallback;
        ArrayList arrayList = new ArrayList();
        for (SceneTask next : list) {
            if (this.O00000Oo.contains(next)) {
                arrayList.add(next);
            }
        }
        final ArrayList arrayList2 = new ArrayList();
        for (SceneTask next2 : list) {
            if (this.O000000o.contains(next2)) {
                arrayList2.add(next2);
            }
        }
        if (arrayList.size() > 0) {
            this.O00000o.O000000o((List<SceneTask>) arrayList, (ITuyaZigBeeConfigLocalSceneCallback) new ITuyaZigBeeConfigLocalSceneCallback() {
                public void onLocalSceneConfigSuccess(List<SceneTask> list, Map<String, Integer> map) {
                    oo0o00oo0.this.O00000oo.addAll(list);
                    oo0o00oo0.this.O000000o((List<SceneTask>) arrayList2);
                }
            });
        } else {
            O000000o((List<SceneTask>) arrayList2);
        }
    }

    public void startConfigLocalScene(ITuyaZigBeeConfigLocalSceneCallback iTuyaZigBeeConfigLocalSceneCallback) {
        this.O00000oO = iTuyaZigBeeConfigLocalSceneCallback;
        if (!this.O0000O0o) {
            this.O0000O0o = true;
            if (this.O000000o.size() != 0 || this.O00000Oo.size() != 0) {
                O000000o();
            } else if (iTuyaZigBeeConfigLocalSceneCallback != null) {
                iTuyaZigBeeConfigLocalSceneCallback.onLocalSceneConfigSuccess(new ArrayList(), new HashMap());
            }
        }
    }

    public void stopConfigLocalScene() {
        this.O0000O0o = false;
        this.O00000o.onDestroy();
        this.O00000o0.onDestroy();
    }
}
