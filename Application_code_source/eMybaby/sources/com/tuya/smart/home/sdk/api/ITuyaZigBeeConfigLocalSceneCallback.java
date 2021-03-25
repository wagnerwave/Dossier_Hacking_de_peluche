package com.tuya.smart.home.sdk.api;

import com.tuya.smart.home.sdk.bean.scene.SceneTask;
import java.util.List;
import java.util.Map;

public interface ITuyaZigBeeConfigLocalSceneCallback {
    void onLocalSceneConfigSuccess(List<SceneTask> list, Map<String, Integer> map);
}
