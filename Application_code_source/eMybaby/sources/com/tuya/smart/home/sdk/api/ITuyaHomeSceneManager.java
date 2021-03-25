package com.tuya.smart.home.sdk.api;

import androidx.annotation.NonNull;
import com.tuya.smart.home.sdk.bean.scene.FunctionListBean;
import com.tuya.smart.home.sdk.bean.scene.LocalSceneBean;
import com.tuya.smart.home.sdk.bean.scene.PlaceFacadeBean;
import com.tuya.smart.home.sdk.bean.scene.PreCondition;
import com.tuya.smart.home.sdk.bean.scene.SceneBean;
import com.tuya.smart.home.sdk.bean.scene.SceneCondition;
import com.tuya.smart.home.sdk.bean.scene.SceneTask;
import com.tuya.smart.home.sdk.bean.scene.SceneTaskGroupDevice;
import com.tuya.smart.home.sdk.bean.scene.condition.ConditionListBean;
import com.tuya.smart.home.sdk.bean.scene.dev.TaskListBean;
import com.tuya.smart.home.sdk.callback.ITuyaResultCallback;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.ISmartUpdateListener;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface ITuyaHomeSceneManager {
    void bindLocalScene(String str, long j, String str2, String str3, String str4, IResultCallback iResultCallback);

    SceneTask createDelayTask(int i, int i2);

    SceneTask createDpGroupTask(@NonNull long j, HashMap<String, Object> hashMap);

    SceneTask createDpTask(@NonNull String str, HashMap<String, Object> hashMap);

    SceneTask createPushMessage();

    void createScene(long j, String str, String str2, List<SceneCondition> list, List<SceneTask> list2, int i, ITuyaResultCallback<SceneBean> iTuyaResultCallback);

    void createScene(long j, String str, boolean z, String str2, List<SceneCondition> list, List<SceneTask> list2, int i, ITuyaResultCallback<SceneBean> iTuyaResultCallback);

    void createScene(long j, String str, boolean z, String str2, List<SceneCondition> list, List<SceneTask> list2, List<PreCondition> list3, int i, ITuyaResultCallback<SceneBean> iTuyaResultCallback);

    SceneTask createSceneTask(SceneBean sceneBean);

    void getAvailableBindSceneList(String str, ITuyaResultCallback<List<SceneBean>> iTuyaResultCallback);

    void getCityByCityIndex(long j, ITuyaResultCallback<PlaceFacadeBean> iTuyaResultCallback);

    void getCityByLatLng(String str, String str2, ITuyaResultCallback<PlaceFacadeBean> iTuyaResultCallback);

    void getCityListByCountryCode(String str, ITuyaResultCallback<List<PlaceFacadeBean>> iTuyaResultCallback);

    void getConditionDevList(long j, ITuyaResultCallback<List<DeviceBean>> iTuyaResultCallback);

    void getConditionList(boolean z, ITuyaResultCallback<List<ConditionListBean>> iTuyaResultCallback);

    void getConditionListAll(long j, boolean z, ITuyaResultCallback<List<ConditionListBean>> iTuyaResultCallback);

    void getDeviceConditionOperationList(String str, ITuyaResultCallback<List<TaskListBean>> iTuyaResultCallback);

    void getDeviceTaskFunctionList(String str, ITuyaResultCallback<List<FunctionListBean>> iTuyaResultCallback);

    void getDeviceTaskFunctionListByGoup(String str, ITuyaResultCallback<List<FunctionListBean>> iTuyaResultCallback);

    void getDeviceTaskOperationList(String str, ITuyaResultCallback<List<TaskListBean>> iTuyaResultCallback);

    void getDeviceTaskOperationListByGroup(String str, ITuyaResultCallback<List<TaskListBean>> iTuyaResultCallback);

    void getSceneBgs(ITuyaResultCallback<ArrayList<String>> iTuyaResultCallback);

    void getSceneConditionDevList(long j, int i, ITuyaResultCallback<List<DeviceBean>> iTuyaResultCallback);

    void getSceneDetail(String str, ITuyaResultCallback<SceneBean> iTuyaResultCallback);

    void getSceneList(long j, ITuyaResultCallback<List<SceneBean>> iTuyaResultCallback);

    void getScenePanelBoundList(String str, ITuyaResultCallback<List<LocalSceneBean>> iTuyaResultCallback);

    void getSimpleSceneList(long j, ITuyaResultCallback<List<SceneBean>> iTuyaResultCallback);

    void getTaskDevAndGoupList(long j, ITuyaResultCallback<SceneTaskGroupDevice> iTuyaResultCallback);

    void getTaskDevList(long j, ITuyaResultCallback<List<DeviceBean>> iTuyaResultCallback);

    ITuyaZigBeeLocalScene newTuyaZigBeeLocalScene(List<SceneTask> list, List<SceneTask> list2);

    void onDestroy();

    void registerSmartUpdateListener(ISmartUpdateListener iSmartUpdateListener);

    void sortSceneList(long j, List<String> list, IResultCallback iResultCallback);

    void unRegisterSmartUpdateListener(ISmartUpdateListener iSmartUpdateListener);

    void unbindLocalScene(String str, long j, IResultCallback iResultCallback);
}
