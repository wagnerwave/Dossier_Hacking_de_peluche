package com.tuya.smart.common;

import a.e.a.a.r.a;
import android.util.SparseBooleanArray;
import com.tuya.sdk.timer.bean.DpTimerBean;
import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshActivatorListener;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.android.blemesh.builder.TuyaBlueMeshActivatorBuilder;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.common.O00Ooo00;
import com.tuya.smart.sdk.api.bluemesh.IAddSubDevCallback;
import com.tuya.smart.sdk.api.bluemesh.ITuyaBlueMesh;
import com.tuya.smart.sdk.api.bluemesh.ITuyaBlueMeshActivator;
import com.tuya.smart.sdk.bean.BlueMeshBean;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class O0o0 implements O0O00o0, ITuyaBlueMeshActivator {
    public static final String O0000Oo = "TuyaBlueMeshActivatorImpl";
    public O00Oo0 O000000o;
    public TuyaBlueMeshActivatorBuilder O00000Oo;
    public O0OOo O00000o;
    public BlueMeshBean O00000o0;
    public SparseBooleanArray O00000oO;
    public final ITuyaBlueMesh O00000oo;
    public final ITuyaBlueMeshActivatorListener O0000O0o;
    public Map<String, DeviceBean> O0000OOo = new HashMap();
    public O00Oo00o O0000Oo0 = new O00Oo00o() {
        public void O000000o() {
            ITuyaBlueMeshActivatorListener iTuyaBlueMeshActivatorListener = O0o0.this.O0000O0o;
            if (iTuyaBlueMeshActivatorListener != null) {
                iTuyaBlueMeshActivatorListener.onFinish();
            }
            O0o0.this.stopActivator();
        }

        public void O000000o(SearchDeviceBean searchDeviceBean) {
            ITuyaBlueMeshActivatorListener iTuyaBlueMeshActivatorListener = O0o0.this.O0000O0o;
            if (iTuyaBlueMeshActivatorListener != null) {
                iTuyaBlueMeshActivatorListener.onSuccess(searchDeviceBean != null ? searchDeviceBean.getMacAdress() : "", O0o0.this.O0000OOo.get(searchDeviceBean.getMacAdress()));
            }
        }

        public void O000000o(SearchDeviceBean searchDeviceBean, String str) {
            if (((str.hashCode() == 47653717 && str.equals(O00OOo.O00000oO)) ? (char) 0 : 65535) == 0) {
                O0o0.this.O00000oO.put(searchDeviceBean.getMeshAddress(), true);
            }
        }

        public void O000000o(SearchDeviceBean searchDeviceBean, String str, String str2) {
            ITuyaBlueMeshActivatorListener iTuyaBlueMeshActivatorListener = O0o0.this.O0000O0o;
            if (iTuyaBlueMeshActivatorListener != null) {
                iTuyaBlueMeshActivatorListener.onError(searchDeviceBean != null ? searchDeviceBean.getMacAdress() : "", str, str2);
            }
        }
    };

    public O0o0(TuyaBlueMeshActivatorBuilder tuyaBlueMeshActivatorBuilder) {
        this.O00000Oo = tuyaBlueMeshActivatorBuilder;
        this.O00000o0 = tuyaBlueMeshActivatorBuilder.getBlueMeshBean();
        this.O0000O0o = tuyaBlueMeshActivatorBuilder.getTuyaBlueMeshActivatorListener();
        O000000o();
        this.O00000o = new O0OOo();
        this.O00000oo = new O000OO00(this.O00000o0.getMeshId());
    }

    /* access modifiers changed from: private */
    public int O00000Oo() {
        L.e("TuyaBlueMeshActivatorImpl", "getLocalDeviceAddress");
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i < 255; i++) {
            if (!this.O00000oO.get(i)) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        if (arrayList.size() == 0) {
            return -1;
        }
        double random = Math.random();
        double size = (double) arrayList.size();
        Double.isNaN(size);
        return ((Integer) arrayList.get((int) (random * size))).intValue();
    }

    public void O000000o() {
        this.O000000o = O00Oo00.O000000o(new O00o00().O000000o(this.O00000Oo.getMeshOriginName()).O00000Oo(this.O00000Oo.getMeshOriginPassword()).O00000o0(this.O00000o0.getName()).O00000o(this.O00000o0.getPassword()).O000000o(this.O00000Oo.getTimeOut()).O000000o(this.O00000Oo.getSearchDeviceBeans()).O000000o(this.O0000Oo0));
    }

    public void O000000o(SearchDeviceBean searchDeviceBean, O00Ooo00.O000000o o000000o, ooooooo ooooooo) {
    }

    public void O000000o(final SearchDeviceBean searchDeviceBean, O00Ooo00.O000000o o000000o, String str, final O0O000o o0O000o) {
        String version = searchDeviceBean.getVersion();
        String a2 = a.a(searchDeviceBean.getProductId());
        String d2 = a.d(searchDeviceBean.getMeshAddress());
        StringBuilder q = a.a.a.a.a.q("nodeId: ", d2, " md5:");
        q.append(o000000o.O00000Oo());
        L.d("TuyaBlueMeshActivatorImpl", q.toString());
        this.O00000oo.addSubDev(o000000o.O00000o0(), d2, o000000o.O00000Oo(), a2, version, new IAddSubDevCallback() {
            public void onError(String str, String str2) {
                L.d("TuyaBlueMeshActivatorImpl", "addNodeIdToCloud onError:" + str + DpTimerBean.FILL + str2);
                o0O000o.O000000o(str, str2);
            }

            public void onSuccess(DeviceBean deviceBean) {
                L.d("TuyaBlueMeshActivatorImpl", "addNodeIdToCloud onSuccess");
                O0o0.this.O0000OOo.put(searchDeviceBean.getMacAdress(), deviceBean);
                new O0OOo().O000000o(deviceBean.getDevId());
                o0O000o.O000000o();
            }
        });
    }

    public void O000000o(final SearchDeviceBean searchDeviceBean, final O0O00oO o0O00oO) {
        this.O00000o.O000000o(this.O00000o0.getMeshId(), new Business.ResultListener<Integer>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Integer num, String str) {
                if ("NO_AVAILABLE_NODE_ID".equals(businessResponse.getErrorCode())) {
                    int O000000o2 = O0o0.this.O00000Oo();
                    if (O000000o2 == -1) {
                        o0O00oO.O000000o("13005", "mesh address already full");
                    } else {
                        o0O00oO.O000000o(O000000o2);
                    }
                } else {
                    o0O00oO.O000000o(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Integer num, String str) {
                StringBuilder n = a.a.a.a.a.n("meshAddress: ");
                n.append(searchDeviceBean.getMacAdress());
                n.append("   deviceAddress:");
                n.append(num);
                L.d("TuyaBlueMeshActivatorImpl", n.toString());
                o0O00oO.O000000o(num.intValue());
            }
        });
    }

    public void O000000o(List<DeviceBean> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        int size = list.size();
        if (size < 10) {
            size = 10;
        }
        this.O00000oO = new SparseBooleanArray(size);
        for (DeviceBean nodeId : list) {
            try {
                this.O00000oO.put(a.c(nodeId.getNodeId()), true);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void startActivator() {
        if (this.O00000oO == null) {
            O000000o(((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O0000OOo().getMeshDeviceList(this.O00000o0.getMeshId()));
        }
        this.O0000OOo.clear();
        this.O000000o.O000000o(this);
    }

    public void stopActivator() {
        this.O000000o.O000000o();
    }
}
