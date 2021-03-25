package com.tuya.smart.common;

import androidx.annotation.NonNull;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.home.sdk.api.ITuyaHomeSceneManager;
import com.tuya.smart.home.sdk.api.ITuyaZigBeeLocalScene;
import com.tuya.smart.home.sdk.bean.scene.FunctionListBean;
import com.tuya.smart.home.sdk.bean.scene.LocalSceneBean;
import com.tuya.smart.home.sdk.bean.scene.PlaceFacadeBean;
import com.tuya.smart.home.sdk.bean.scene.PreCondition;
import com.tuya.smart.home.sdk.bean.scene.SceneBean;
import com.tuya.smart.home.sdk.bean.scene.SceneCondition;
import com.tuya.smart.home.sdk.bean.scene.SceneTask;
import com.tuya.smart.home.sdk.bean.scene.SceneTaskGroupDevice;
import com.tuya.smart.home.sdk.bean.scene.condition.ConditionListBean;
import com.tuya.smart.home.sdk.bean.scene.condition.rule.Rule;
import com.tuya.smart.home.sdk.bean.scene.dev.TaskListBean;
import com.tuya.smart.home.sdk.callback.ITuyaResultCallback;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.ISmartUpdateListener;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.GroupBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class oo0o00o00 implements o0o0o00000<o0o0oooo00>, ITuyaHomeSceneManager {
    public static volatile oo0o00o00 O00000Oo = null;
    public static final String O00000o0 = "TuyaHomeSceneManager";
    public o0o00o00o0 O000000o = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class));
    public oo0o0000o O00000o = new oo0o0000o();
    public List<ISmartUpdateListener> O00000oO = new ArrayList();
    public volatile boolean O00000oo;

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
    public static synchronized com.tuya.smart.common.oo0o00o00 O000000o() {
        /*
            java.lang.Class<com.tuya.smart.common.oo0o00o00> r0 = com.tuya.smart.common.oo0o00o00.class
            monitor-enter(r0)
            com.tuya.smart.common.oo0o00o00 r1 = O00000Oo     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x0018
            monitor-enter(r0)     // Catch:{ all -> 0x001c }
            com.tuya.smart.common.oo0o00o00 r1 = O00000Oo     // Catch:{ all -> 0x0015 }
            if (r1 != 0) goto L_0x0013
            com.tuya.smart.common.oo0o00o00 r1 = new com.tuya.smart.common.oo0o00o00     // Catch:{ all -> 0x0015 }
            r1.<init>()     // Catch:{ all -> 0x0015 }
            O00000Oo = r1     // Catch:{ all -> 0x0015 }
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            goto L_0x0018
        L_0x0015:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            throw r1     // Catch:{ all -> 0x001c }
        L_0x0018:
            com.tuya.smart.common.oo0o00o00 r1 = O00000Oo     // Catch:{ all -> 0x001c }
            monitor-exit(r0)
            return r1
        L_0x001c:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.oo0o00o00.O000000o():com.tuya.smart.common.oo0o00o00");
    }

    public static SceneCondition O000000o(PlaceFacadeBean placeFacadeBean, String str, Rule rule) {
        SceneCondition sceneCondition = new SceneCondition();
        sceneCondition.setEntityId(String.valueOf(placeFacadeBean.getCityId()));
        sceneCondition.setEntityName(placeFacadeBean.getCity());
        sceneCondition.setEntityType(3);
        sceneCondition.setEntitySubIds(str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(rule.getExpr());
        sceneCondition.setExpr(arrayList);
        return sceneCondition;
    }

    public static SceneCondition O000000o(DeviceBean deviceBean, String str, List<Rule> list) {
        SceneCondition sceneCondition = new SceneCondition();
        sceneCondition.setEntityId(deviceBean.getDevId());
        sceneCondition.setEntityName(deviceBean.getName());
        sceneCondition.setEntityType(1);
        sceneCondition.setEntitySubIds(str);
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Rule expr : list) {
                arrayList.add(expr.getExpr());
            }
            sceneCondition.setExpr(arrayList);
        }
        return sceneCondition;
    }

    public static SceneCondition O000000o(String str, String str2, String str3, Rule rule) {
        SceneCondition sceneCondition = new SceneCondition();
        sceneCondition.setEntityId("timer");
        sceneCondition.setEntityName(str2);
        sceneCondition.setExprDisplay(str);
        sceneCondition.setEntityType(6);
        sceneCondition.setEntitySubIds(str3);
        ArrayList arrayList = new ArrayList();
        arrayList.add(rule.getExpr());
        sceneCondition.setExpr(arrayList);
        return sceneCondition;
    }

    /* renamed from: O000000o */
    public void onResult(o0o0oooo00 o0o0oooo00) {
        List<ISmartUpdateListener> list = this.O00000oO;
        if (list != null) {
            for (ISmartUpdateListener onSmartUpdateListener : list) {
                onSmartUpdateListener.onSmartUpdateListener();
            }
        }
    }

    public SceneTask O00000Oo() {
        SceneTask sceneTask = new SceneTask();
        sceneTask.setActionExecutor("mobileVoiceSend");
        return sceneTask;
    }

    public void O00000o0() {
        L.d(O00000o0, "onStart");
        if (!this.O00000oo) {
            this.O00000oo = true;
            this.O000000o.O0000o00().registerDeviceMqttListener(o0o0oooo00.class, this);
        }
    }

    public void bindLocalScene(String str, long j, String str2, String str3, String str4, IResultCallback iResultCallback) {
        this.O00000o.O000000o(str, j, str2, str3, str4, iResultCallback);
    }

    public SceneTask createDelayTask(int i, int i2) {
        SceneTask sceneTask = new SceneTask();
        sceneTask.setActionExecutor("delay");
        HashMap hashMap = new HashMap();
        hashMap.put("minutes", i + "");
        hashMap.put("seconds", i2 + "");
        sceneTask.setExecutorProperty(hashMap);
        sceneTask.setEntityId("delay");
        return sceneTask;
    }

    public SceneTask createDpGroupTask(@NonNull long j, HashMap<String, Object> hashMap) {
        SceneTask sceneTask = new SceneTask();
        sceneTask.setActionExecutor("deviceGroupDpIssue");
        sceneTask.setEntityId(String.valueOf(j));
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        if (o0o00o00o0 != null) {
            GroupBean groupBean = o0o00o00o0.O0000OOo().getGroupBean(j);
            if (groupBean != null) {
                sceneTask.setDevIcon(groupBean.getIconUrl());
                sceneTask.setDevOnline(groupBean.getIsOnline());
                sceneTask.setEntityName(groupBean.getName());
            }
            if (hashMap == null || hashMap.size() == 0) {
                L.e("TuyaHomeScene", "task cannot be empty!");
                return null;
            }
        }
        sceneTask.setExecutorProperty(hashMap);
        return sceneTask;
    }

    public SceneTask createDpTask(@NonNull String str, HashMap<String, Object> hashMap) {
        SceneTask sceneTask = new SceneTask();
        sceneTask.setActionExecutor("dpIssue");
        sceneTask.setEntityId(str);
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        if (o0o00o00o0 != null) {
            DeviceBean deviceBean = o0o00o00o0.O0000OOo().getDeviceBean(sceneTask.getEntityId());
            if (deviceBean != null) {
                sceneTask.setDevIcon(deviceBean.getIconUrl());
                sceneTask.setDevOnline(deviceBean.getIsOnline().booleanValue());
                sceneTask.setEntityName(deviceBean.getName());
            }
            if (hashMap == null || hashMap.size() == 0) {
                L.e("TuyaHomeScene", "task cannot be empty!");
                return null;
            }
        }
        sceneTask.setExecutorProperty(hashMap);
        return sceneTask;
    }

    public SceneTask createPushMessage() {
        SceneTask sceneTask = new SceneTask();
        sceneTask.setActionExecutor("appPushTrigger");
        return sceneTask;
    }

    public void createScene(long j, String str, String str2, List<SceneCondition> list, List<SceneTask> list2, int i, ITuyaResultCallback<SceneBean> iTuyaResultCallback) {
        this.O00000o.O000000o(j, SceneBean.createSceneBean(str, str2, list, list2, i), iTuyaResultCallback);
    }

    public void createScene(long j, String str, boolean z, String str2, List<SceneCondition> list, List<SceneTask> list2, int i, ITuyaResultCallback<SceneBean> iTuyaResultCallback) {
        long j2 = j;
        this.O00000o.O000000o(j, SceneBean.createSceneBean(str, (String) null, z, str2, list, list2, i), iTuyaResultCallback);
    }

    public void createScene(long j, String str, boolean z, String str2, List<SceneCondition> list, List<SceneTask> list2, List<PreCondition> list3, int i, ITuyaResultCallback<SceneBean> iTuyaResultCallback) {
        long j2 = j;
        this.O00000o.O000000o(j, SceneBean.createSceneBean(str, (String) null, z, str2, list, list2, list3, i), iTuyaResultCallback);
    }

    public SceneTask createSceneTask(SceneBean sceneBean) {
        SceneTask sceneTask = new SceneTask();
        sceneTask.setActionExecutor((sceneBean.getConditions() == null || sceneBean.getConditions().size() < 1) ? "ruleTrigger" : sceneBean.isEnabled() ? "ruleEnable" : "ruleDisable");
        sceneTask.setEntityId(sceneBean.getId());
        return sceneTask;
    }

    public void getAvailableBindSceneList(String str, ITuyaResultCallback<List<SceneBean>> iTuyaResultCallback) {
        this.O00000o.O0000Oo0(str, iTuyaResultCallback);
    }

    public void getCityByCityIndex(long j, ITuyaResultCallback<PlaceFacadeBean> iTuyaResultCallback) {
        this.O00000o.O00000oo(j, iTuyaResultCallback);
    }

    public void getCityByLatLng(String str, String str2, ITuyaResultCallback<PlaceFacadeBean> iTuyaResultCallback) {
        this.O00000o.O000000o(str, str2, iTuyaResultCallback);
    }

    public void getCityListByCountryCode(String str, ITuyaResultCallback<List<PlaceFacadeBean>> iTuyaResultCallback) {
        this.O00000o.O0000O0o(str, iTuyaResultCallback);
    }

    public void getConditionDevList(long j, ITuyaResultCallback<List<DeviceBean>> iTuyaResultCallback) {
        this.O00000o.O00000o0(j, iTuyaResultCallback);
    }

    public void getConditionList(boolean z, ITuyaResultCallback<List<ConditionListBean>> iTuyaResultCallback) {
        this.O00000o.O000000o(z, iTuyaResultCallback);
    }

    public void getConditionListAll(long j, boolean z, ITuyaResultCallback<List<ConditionListBean>> iTuyaResultCallback) {
        this.O00000o.O000000o(j, z, iTuyaResultCallback);
    }

    public void getDeviceConditionOperationList(String str, ITuyaResultCallback<List<TaskListBean>> iTuyaResultCallback) {
        this.O00000o.O00000oo(str, iTuyaResultCallback);
    }

    public void getDeviceTaskFunctionList(String str, ITuyaResultCallback<List<FunctionListBean>> iTuyaResultCallback) {
        this.O00000o.O00000o0(str, iTuyaResultCallback);
    }

    public void getDeviceTaskFunctionListByGoup(String str, ITuyaResultCallback<List<FunctionListBean>> iTuyaResultCallback) {
        this.O00000o.O00000o(str, iTuyaResultCallback);
    }

    public void getDeviceTaskOperationList(String str, ITuyaResultCallback<List<TaskListBean>> iTuyaResultCallback) {
        this.O00000o.O000000o(str, iTuyaResultCallback);
    }

    public void getDeviceTaskOperationListByGroup(String str, ITuyaResultCallback<List<TaskListBean>> iTuyaResultCallback) {
        this.O00000o.O00000Oo(str, iTuyaResultCallback);
    }

    public void getSceneBgs(ITuyaResultCallback<ArrayList<String>> iTuyaResultCallback) {
        this.O00000o.O000000o(iTuyaResultCallback);
    }

    public void getSceneConditionDevList(long j, int i, ITuyaResultCallback<List<DeviceBean>> iTuyaResultCallback) {
        this.O00000o.O000000o(j, i, iTuyaResultCallback);
    }

    public void getSceneDetail(String str, ITuyaResultCallback<SceneBean> iTuyaResultCallback) {
        this.O00000o.O00000oO(str, iTuyaResultCallback);
    }

    public void getSceneList(long j, ITuyaResultCallback<List<SceneBean>> iTuyaResultCallback) {
        this.O00000o.O000000o(j, iTuyaResultCallback);
    }

    public void getScenePanelBoundList(String str, ITuyaResultCallback<List<LocalSceneBean>> iTuyaResultCallback) {
        this.O00000o.O0000OOo(str, iTuyaResultCallback);
    }

    public void getSimpleSceneList(long j, ITuyaResultCallback<List<SceneBean>> iTuyaResultCallback) {
        this.O00000o.O00000Oo(j, iTuyaResultCallback);
    }

    public void getTaskDevAndGoupList(long j, ITuyaResultCallback<SceneTaskGroupDevice> iTuyaResultCallback) {
        this.O00000o.O00000oO(j, iTuyaResultCallback);
    }

    public void getTaskDevList(long j, ITuyaResultCallback<List<DeviceBean>> iTuyaResultCallback) {
        this.O00000o.O00000o(j, iTuyaResultCallback);
    }

    public ITuyaZigBeeLocalScene newTuyaZigBeeLocalScene(List<SceneTask> list, List<SceneTask> list2) {
        return new oo0o00oo0(list, list2);
    }

    public void onDestroy() {
        L.d(O00000o0, "onDestroy");
        this.O00000oo = false;
        this.O000000o.O0000o00().unRegisterDeviceMqttListener(o0o0oooo00.class, this);
        this.O00000o.onDestroy();
        O00000Oo = null;
    }

    public void registerSmartUpdateListener(ISmartUpdateListener iSmartUpdateListener) {
        O00000o0();
        this.O00000oO.add(iSmartUpdateListener);
    }

    public void sortSceneList(long j, List<String> list, IResultCallback iResultCallback) {
        this.O00000o.O000000o(j, list, iResultCallback);
    }

    public void unRegisterSmartUpdateListener(ISmartUpdateListener iSmartUpdateListener) {
        List<ISmartUpdateListener> list = this.O00000oO;
        if (list != null && iSmartUpdateListener != null) {
            list.remove(iSmartUpdateListener);
        }
    }

    public void unbindLocalScene(String str, long j, IResultCallback iResultCallback) {
        this.O00000o.O000000o(str, j, iResultCallback);
    }
}
