package com.tuya.smart.common;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tuya.sdk.scene.bean.LocalSceneResBean;
import com.tuya.smart.android.base.TuyaSmartSdk;
import com.tuya.smart.android.base.utils.PreferencesUtil;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.mvp.model.BaseModel;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.home.sdk.bean.scene.ActRespBean;
import com.tuya.smart.home.sdk.bean.scene.ActionBean;
import com.tuya.smart.home.sdk.bean.scene.ConditionActionBean;
import com.tuya.smart.home.sdk.bean.scene.ConditionAllBean;
import com.tuya.smart.home.sdk.bean.scene.ConditionRespBean;
import com.tuya.smart.home.sdk.bean.scene.FunctionListBean;
import com.tuya.smart.home.sdk.bean.scene.LocalSceneBean;
import com.tuya.smart.home.sdk.bean.scene.PlaceFacadeBean;
import com.tuya.smart.home.sdk.bean.scene.SceneBean;
import com.tuya.smart.home.sdk.bean.scene.SceneTask;
import com.tuya.smart.home.sdk.bean.scene.SceneTaskGroupDevice;
import com.tuya.smart.home.sdk.bean.scene.condition.ConditionListBean;
import com.tuya.smart.home.sdk.bean.scene.dev.TaskListBean;
import com.tuya.smart.home.sdk.callback.ITuyaResultCallback;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.GroupBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class oo0o0000o extends BaseModel {
    public static final String O000000o = "scene_data";
    public oo0o00000 O00000Oo = new oo0o00000();

    public oo0o0000o() {
        super(TuyaSmartSdk.getApplication());
    }

    public static ArrayList<TaskListBean> O00000o(ArrayList<ActRespBean> arrayList) {
        ArrayList<TaskListBean> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            Iterator<ActRespBean> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new TaskListBean(new ActionBean(it.next())));
            }
        }
        return arrayList2;
    }

    public static ArrayList<ConditionListBean> O00000oO(ArrayList<ConditionRespBean> arrayList) {
        ArrayList<ConditionListBean> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            Iterator<ConditionRespBean> it = arrayList.iterator();
            while (it.hasNext()) {
                ConditionActionBean conditionActionBean = new ConditionActionBean(it.next());
                ConditionListBean conditionListBean = new ConditionListBean(conditionActionBean);
                conditionListBean.setOperators(conditionActionBean.getOperators());
                conditionListBean.setId(conditionActionBean.getId());
                conditionListBean.setNewIcon(conditionActionBean.getNewIcon());
                conditionListBean.setEntityName(conditionActionBean.getEntityName());
                conditionListBean.setEntityType(conditionActionBean.getEntityType());
                arrayList2.add(conditionListBean);
            }
        }
        return arrayList2;
    }

    public static ArrayList<TaskListBean> O00000oo(ArrayList<ConditionRespBean> arrayList) {
        ArrayList<TaskListBean> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            Iterator<ConditionRespBean> it = arrayList.iterator();
            while (it.hasNext()) {
                ConditionActionBean conditionActionBean = new ConditionActionBean(it.next());
                TaskListBean taskListBean = new TaskListBean(conditionActionBean);
                taskListBean.setEntityType(conditionActionBean.getEntityType());
                arrayList2.add(taskListBean);
            }
        }
        return arrayList2;
    }

    private ArrayList<SceneBean> O0000O0o(ArrayList<SceneBean> arrayList) {
        DeviceBean deviceBean;
        ArrayList<SceneBean> arrayList2 = new ArrayList<>();
        Iterator<SceneBean> it = arrayList.iterator();
        while (it.hasNext()) {
            SceneBean next = it.next();
            if (next.getCode() == null || TextUtils.isEmpty(next.getCode())) {
                List<SceneTask> actions = next.getActions();
                if (actions != null) {
                    ArrayList arrayList3 = new ArrayList();
                    for (SceneTask next2 : actions) {
                        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
                        if (!(o0o00o00o0 == null || (deviceBean = o0o00o00o0.O0000OOo().getDeviceBean(next2.getEntityId())) == null)) {
                            next2.setDevOnline(deviceBean.getIsOnline().booleanValue());
                            next2.setDevIcon(deviceBean.getIconUrl());
                            arrayList3.add(next2);
                        }
                    }
                    next.setActions(arrayList3);
                }
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    public void O000000o(long j, int i, final ITuyaResultCallback<List<DeviceBean>> iTuyaResultCallback) {
        this.O00000Oo.O000000o(j, i, (Business.ResultListener<ArrayList<String>>) new Business.ResultListener<ArrayList<String>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<String> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<String> arrayList, String str) {
                ArrayList arrayList2 = new ArrayList();
                o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
                if (o0o00o00o0 != null) {
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        DeviceBean deviceBean = o0o00o00o0.O0000OOo().getDeviceBean(it.next());
                        if (deviceBean != null) {
                            arrayList2.add(deviceBean);
                        }
                    }
                }
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(arrayList2);
                }
            }
        });
    }

    public void O000000o(long j, SceneBean sceneBean, final ITuyaResultCallback<SceneBean> iTuyaResultCallback) {
        this.O00000Oo.O000000o(j, sceneBean, (Business.ResultListener<SceneBean>) new Business.ResultListener<SceneBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, SceneBean sceneBean, String str) {
                L.d("Tuya SDK: createScene", "Failure");
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, SceneBean sceneBean, String str) {
                L.d("Tuya SDK: createScene ", "createScene Success");
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(sceneBean);
                }
            }
        });
    }

    public void O000000o(long j, final ITuyaResultCallback<List<SceneBean>> iTuyaResultCallback) {
        this.O00000Oo.O000000o(j, (Business.ResultListener<ArrayList<SceneBean>>) new Business.ResultListener<ArrayList<SceneBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<SceneBean> arrayList, String str) {
                if (iTuyaResultCallback != null) {
                    String string = PreferencesUtil.getString(oo0o0000o.O000000o);
                    if (!TextUtils.isEmpty(string)) {
                        try {
                            iTuyaResultCallback.onSuccess(JSON.parseArray(string, SceneBean.class));
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<SceneBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(arrayList);
                    if (arrayList != null) {
                        try {
                            PreferencesUtil.set(oo0o0000o.O000000o, JSON.toJSONString(arrayList));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    public void O000000o(long j, String str, final ITuyaResultCallback<List<DeviceBean>> iTuyaResultCallback) {
        this.O00000Oo.O000000o(j, str, (Business.ResultListener<ArrayList<String>>) new Business.ResultListener<ArrayList<String>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<String> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<String> arrayList, String str) {
                ArrayList arrayList2 = new ArrayList();
                o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
                if (o0o00o00o0 != null) {
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        DeviceBean deviceBean = o0o00o00o0.O0000OOo().getDeviceBean(it.next());
                        if (deviceBean != null) {
                            arrayList2.add(deviceBean);
                        }
                    }
                }
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(arrayList2);
                }
            }
        });
    }

    public void O000000o(long j, List<String> list, final IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(j, list, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O000000o(long j, boolean z, final ITuyaResultCallback<List<ConditionListBean>> iTuyaResultCallback) {
        this.O00000Oo.O000000o(j, z, (Business.ResultListener<ConditionAllBean>) new Business.ResultListener<ConditionAllBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ConditionAllBean conditionAllBean, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ConditionAllBean conditionAllBean, String str) {
                ArrayList O00000o0 = oo0o0000o.O00000oO((ArrayList) conditionAllBean.getEnvConds());
                if (conditionAllBean.getDevConds() != null) {
                    O00000o0.addAll(oo0o0000o.O00000oO((ArrayList) conditionAllBean.getDevConds()));
                }
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(O00000o0);
                }
            }
        });
    }

    public void O000000o(SceneBean sceneBean, final ITuyaResultCallback<SceneBean> iTuyaResultCallback) {
        this.O00000Oo.O000000o(sceneBean, (Business.ResultListener<SceneBean>) new Business.ResultListener<SceneBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, SceneBean sceneBean, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, SceneBean sceneBean, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(sceneBean);
                }
            }
        });
    }

    public void O000000o(final ITuyaResultCallback<ArrayList<String>> iTuyaResultCallback) {
        this.O00000Oo.O000000o(new Business.ResultListener<ArrayList<String>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<String> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<String> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(arrayList);
                }
            }
        });
    }

    public void O000000o(String str, long j, final IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(str, j, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O000000o(String str, long j, String str2, String str3, String str4, final IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(str, j, str2, str3, str4, new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O000000o(String str, final ITuyaResultCallback<List<TaskListBean>> iTuyaResultCallback) {
        this.O00000Oo.O000000o(str, (Business.ResultListener<ArrayList<ActRespBean>>) new Business.ResultListener<ArrayList<ActRespBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<ActRespBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<ActRespBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(oo0o0000o.O00000o(arrayList));
                }
            }
        });
    }

    public void O000000o(String str, final IResultCallback iResultCallback) {
        this.O00000Oo.O00000oO(str, new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O000000o(String str, String str2, final ITuyaResultCallback<PlaceFacadeBean> iTuyaResultCallback) {
        this.O00000Oo.O000000o(str, str2, (Business.ResultListener<PlaceFacadeBean>) new Business.ResultListener<PlaceFacadeBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, PlaceFacadeBean placeFacadeBean, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, PlaceFacadeBean placeFacadeBean, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(placeFacadeBean);
                }
            }
        });
    }

    public void O000000o(boolean z, final ITuyaResultCallback<List<ConditionListBean>> iTuyaResultCallback) {
        this.O00000Oo.O000000o(z, (Business.ResultListener<ArrayList<ConditionRespBean>>) new Business.ResultListener<ArrayList<ConditionRespBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<ConditionRespBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<ConditionRespBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(oo0o0000o.O00000oO(arrayList));
                }
            }
        });
    }

    public void O000000o(boolean z, String str, final IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(z, str, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O00000Oo(long j, final ITuyaResultCallback<List<SceneBean>> iTuyaResultCallback) {
        this.O00000Oo.O00000Oo(j, (Business.ResultListener<ArrayList<SceneBean>>) new Business.ResultListener<ArrayList<SceneBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<SceneBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<SceneBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(arrayList);
                }
            }
        });
    }

    public void O00000Oo(String str, final ITuyaResultCallback<List<TaskListBean>> iTuyaResultCallback) {
        this.O00000Oo.O00000Oo(str, (Business.ResultListener<ArrayList<ActRespBean>>) new Business.ResultListener<ArrayList<ActRespBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<ActRespBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<ActRespBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(oo0o0000o.O00000o(arrayList));
                }
            }
        });
    }

    public void O00000Oo(String str, final IResultCallback iResultCallback) {
        this.O00000Oo.O00000oo(str, new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O00000o(long j, ITuyaResultCallback<List<DeviceBean>> iTuyaResultCallback) {
        O000000o(j, "action", iTuyaResultCallback);
    }

    public void O00000o(String str, final ITuyaResultCallback<List<FunctionListBean>> iTuyaResultCallback) {
        this.O00000Oo.O00000o(str, (Business.ResultListener<ArrayList<FunctionListBean>>) new Business.ResultListener<ArrayList<FunctionListBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<FunctionListBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<FunctionListBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(arrayList);
                }
            }
        });
    }

    public void O00000o0(long j, ITuyaResultCallback<List<DeviceBean>> iTuyaResultCallback) {
        O000000o(j, "condition", iTuyaResultCallback);
    }

    public void O00000o0(String str, final ITuyaResultCallback<List<FunctionListBean>> iTuyaResultCallback) {
        this.O00000Oo.O00000o0(str, (Business.ResultListener<ArrayList<FunctionListBean>>) new Business.ResultListener<ArrayList<FunctionListBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<FunctionListBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<FunctionListBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(arrayList);
                }
            }
        });
    }

    public void O00000oO(long j, final ITuyaResultCallback<SceneTaskGroupDevice> iTuyaResultCallback) {
        this.O00000Oo.O00000o0(j, (Business.ResultListener<JSONObject>) new Business.ResultListener<JSONObject>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, JSONObject jSONObject, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, JSONObject jSONObject, String str) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                SceneTaskGroupDevice sceneTaskGroupDevice = new SceneTaskGroupDevice();
                o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
                if (jSONObject != null) {
                    JSONArray jSONArray = jSONObject.getJSONArray("deviceIds");
                    JSONArray jSONArray2 = jSONObject.getJSONArray("groupIds");
                    Map map = (Map) jSONObject.get("exts");
                    if (o0o00o00o0 != null) {
                        if (jSONArray != null) {
                            Iterator<Object> it = jSONArray.iterator();
                            while (it.hasNext()) {
                                DeviceBean deviceBean = o0o00o00o0.O0000OOo().getDeviceBean((String) it.next());
                                if (deviceBean != null) {
                                    arrayList.add(deviceBean);
                                }
                            }
                        }
                        if (jSONArray2 != null) {
                            Iterator<Object> it2 = jSONArray2.iterator();
                            while (it2.hasNext()) {
                                GroupBean groupBean = o0o00o00o0.O0000OOo().getGroupBean((long) ((Integer) it2.next()).intValue());
                                if (groupBean != null) {
                                    arrayList2.add(groupBean);
                                }
                            }
                        }
                        sceneTaskGroupDevice.setDevices(arrayList);
                        sceneTaskGroupDevice.setGoups(arrayList2);
                        sceneTaskGroupDevice.setExts(map);
                    }
                }
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(sceneTaskGroupDevice);
                }
            }
        });
    }

    public void O00000oO(String str, final ITuyaResultCallback<SceneBean> iTuyaResultCallback) {
        this.O00000Oo.O0000O0o(str, new Business.ResultListener<SceneBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, SceneBean sceneBean, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, SceneBean sceneBean, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(sceneBean);
                }
            }
        });
    }

    public void O00000oo(long j, final ITuyaResultCallback<PlaceFacadeBean> iTuyaResultCallback) {
        this.O00000Oo.O00000o(j, (Business.ResultListener<PlaceFacadeBean>) new Business.ResultListener<PlaceFacadeBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, PlaceFacadeBean placeFacadeBean, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, PlaceFacadeBean placeFacadeBean, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(placeFacadeBean);
                }
            }
        });
    }

    public void O00000oo(String str, final ITuyaResultCallback<List<TaskListBean>> iTuyaResultCallback) {
        this.O00000Oo.O0000OOo(str, new Business.ResultListener<ArrayList<ConditionRespBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<ConditionRespBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<ConditionRespBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(oo0o0000o.O00000oo(arrayList));
                }
            }
        });
    }

    public void O0000O0o(String str, final ITuyaResultCallback<List<PlaceFacadeBean>> iTuyaResultCallback) {
        this.O00000Oo.O0000Oo0(str, new Business.ResultListener<ArrayList<PlaceFacadeBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<PlaceFacadeBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<PlaceFacadeBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(arrayList);
                }
            }
        });
    }

    public void O0000OOo(String str, final ITuyaResultCallback<List<LocalSceneBean>> iTuyaResultCallback) {
        this.O00000Oo.O0000Oo(str, new Business.ResultListener<ArrayList<LocalSceneResBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<LocalSceneResBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<LocalSceneResBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(oo0o0o0o0.O000000o(arrayList));
                }
            }
        });
    }

    public void O0000Oo0(String str, final ITuyaResultCallback<List<SceneBean>> iTuyaResultCallback) {
        this.O00000Oo.O0000OoO(str, new Business.ResultListener<ArrayList<SceneBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<SceneBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<SceneBean> arrayList, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(arrayList);
                }
            }
        });
    }

    public void onDestroy() {
        oo0o00000 oo0o00000 = this.O00000Oo;
        if (oo0o00000 != null) {
            oo0o00000.onDestroy();
            this.O00000Oo = null;
        }
    }
}
