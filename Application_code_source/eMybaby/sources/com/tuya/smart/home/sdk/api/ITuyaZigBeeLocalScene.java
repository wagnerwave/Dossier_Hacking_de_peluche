package com.tuya.smart.home.sdk.api;

import com.tuya.smart.home.sdk.bean.scene.SceneTask;
import com.tuya.smart.sdk.api.IResultCallback;
import java.util.List;

public interface ITuyaZigBeeLocalScene {
    void executeLocalScene(List<SceneTask> list, IResultCallback iResultCallback);

    void executeNewLocalScene(String str, String str2, IResultCallback iResultCallback);

    void executeSceneOnline(String str, String str2, IResultCallback iResultCallback);

    void retrySendCommandTask(List<SceneTask> list, ITuyaZigBeeConfigLocalSceneCallback iTuyaZigBeeConfigLocalSceneCallback);

    void startConfigLocalScene(ITuyaZigBeeConfigLocalSceneCallback iTuyaZigBeeConfigLocalSceneCallback);

    void stopConfigLocalScene();
}
