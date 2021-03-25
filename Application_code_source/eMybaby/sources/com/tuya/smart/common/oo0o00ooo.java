package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import android.util.Log;
import com.tuya.smart.android.common.utils.SafeHandler;
import com.tuya.smart.android.mvp.model.BaseModel;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.home.sdk.bean.scene.SceneIdBean;
import com.tuya.smart.sdk.TuyaSdk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class oo0o00ooo extends BaseModel {
    public static final int O000000o = 242;
    public static final int O00000Oo = 0;
    public static final int O00000o = 243;
    public static final int O00000o0 = 1;
    public final oo0o00000 O00000oO = new oo0o00000();
    public HashMap<String, SceneIdBean> O00000oo = new HashMap<>();

    public oo0o00ooo(SafeHandler safeHandler) {
        super(TuyaSdk.getApplication(), safeHandler);
    }

    public void O000000o(HashMap<String, SceneIdBean> hashMap) {
        this.O00000oo.putAll(hashMap);
    }

    public void O000000o(List<String> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        StringBuilder n = a.n("meshIds start:");
        n.append(arrayList.size());
        Log.i("HHHHH", n.toString());
        final ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (this.O00000oo.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                SceneIdBean sceneIdBean = this.O00000oo.get(str);
                if (sceneIdBean != null) {
                    arrayList2.add(sceneIdBean);
                    arrayList3.add(str);
                }
            }
        }
        arrayList.removeAll(arrayList3);
        Log.i("HHHHH", "meshIds filter:" + arrayList.size());
        this.O00000oO.O000000o((List<String>) arrayList, (Business.ResultListener<ArrayList<SceneIdBean>>) new Business.ResultListener<ArrayList<SceneIdBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<SceneIdBean> arrayList, String str) {
                StringBuilder n = a.n("allocSceneId onFailure:");
                n.append(arrayList == null ? "null" : Integer.valueOf(arrayList.size()));
                Log.i("HHHHH", n.toString());
                oo0o00ooo.this.resultError(oo0o00ooo.O000000o, businessResponse.getErrorCode(), businessResponse.getErrorMsg());
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<SceneIdBean> arrayList, String str) {
                Iterator<SceneIdBean> it = arrayList.iterator();
                while (it.hasNext()) {
                    SceneIdBean next = it.next();
                    oo0o00ooo.this.O00000oo.put(next.getGwId(), next);
                    boolean z = false;
                    Iterator it2 = arrayList2.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (TextUtils.equals(next.getGwId(), ((SceneIdBean) it2.next()).getGwId())) {
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (!z) {
                        arrayList2.add(next);
                    }
                }
                StringBuilder n = a.n("allocSceneId suc:");
                n.append(arrayList2.size());
                Log.i("HHHHH", n.toString());
                oo0o00ooo.this.resultSuccess(243, arrayList2);
            }
        });
    }

    public void onDestroy() {
        this.O00000oo.clear();
        this.O00000oO.onDestroy();
    }
}
