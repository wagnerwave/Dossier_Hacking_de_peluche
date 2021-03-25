package com.tuya.smart.common;

import com.tuya.smart.home.sdk.api.ITuyaZigBeeConfigLocalSceneCallback;
import com.tuya.smart.home.sdk.bean.scene.SceneTask;
import com.tuya.smart.sdk.api.IResultCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class oo0o0o00o {
    public CountDownLatch O000000o;
    public final List<SceneTask> O00000Oo;
    public List<SceneTask> O00000o;
    public ITuyaZigBeeConfigLocalSceneCallback O00000o0;
    public oo0o000o0 O00000oO;
    public Thread O00000oo;
    public volatile boolean O0000O0o;

    public oo0o0o00o(List<SceneTask> list) {
        this.O00000Oo = list;
    }

    public void O000000o() {
        this.O0000O0o = true;
        Thread thread = this.O00000oo;
        if (thread != null) {
            thread.interrupt();
        }
        CountDownLatch countDownLatch = this.O000000o;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    public void O000000o(ITuyaZigBeeConfigLocalSceneCallback iTuyaZigBeeConfigLocalSceneCallback) {
        this.O00000o = new ArrayList();
        this.O00000o0 = iTuyaZigBeeConfigLocalSceneCallback;
        this.O00000oO = new oo0o000o0();
        Thread thread = new Thread(new Runnable() {
            public void run() {
                for (final SceneTask sceneTask : oo0o0o00o.this.O00000Oo) {
                    if (oo0o0o00o.this.O0000O0o) {
                        break;
                    }
                    oo0o0o00o.this.O000000o = new CountDownLatch(1);
                    oo0o0o00o.this.O00000oO.O000000o(sceneTask.getEntityId(), sceneTask.getExecutorProperty(), new IResultCallback() {
                        public void onError(String str, String str2) {
                            oo0o0o00o.this.O000000o.countDown();
                        }

                        public void onSuccess() {
                            oo0o0o00o.this.O000000o.countDown();
                            oo0o0o00o.this.O00000o.add(sceneTask);
                        }
                    });
                    try {
                        oo0o0o00o.this.O000000o.await();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                oo0o0o00o.this.O00000o0.onLocalSceneConfigSuccess(oo0o0o00o.this.O00000o, new HashMap());
            }
        });
        this.O00000oo = thread;
        thread.start();
    }
}
