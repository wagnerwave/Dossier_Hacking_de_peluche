package com.tuya.smart.home.sdk.api;

import com.tuya.smart.home.sdk.bean.scene.SceneBean;
import com.tuya.smart.home.sdk.callback.ITuyaResultCallback;
import com.tuya.smart.sdk.api.IResultCallback;

public interface ITuyaHomeScene {
    void deleteScene(IResultCallback iResultCallback);

    void disableScene(String str, IResultCallback iResultCallback);

    void enableScene(String str, IResultCallback iResultCallback);

    void executeScene(IResultCallback iResultCallback);

    void modifyScene(SceneBean sceneBean, ITuyaResultCallback<SceneBean> iTuyaResultCallback);

    void onDestroy();
}
