package com.tuya.smart.common;

import a.a.a.a.a;
import android.util.SparseBooleanArray;
import com.alibaba.fastjson.JSONObject;
import com.tuya.sdk.timer.bean.DpTimerBean;
import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshActivatorListener;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.android.blemesh.bean.SigMeshSearchDeviceBean;
import com.tuya.smart.android.blemesh.builder.TuyaSigMeshActivatorBuilder;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.common.O00000o0;
import com.tuya.smart.common.O00Ooo00;
import com.tuya.smart.sdk.api.bluemesh.IAddSubDevCallback;
import com.tuya.smart.sdk.api.bluemesh.ITuyaBlueMesh;
import com.tuya.smart.sdk.api.bluemesh.ITuyaBlueMeshActivator;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.SigMeshBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class oooooo00o implements O0O00o0, ITuyaBlueMeshActivator {
    public static final String O0000OoO = "TuyaBlueMeshActivatorImpl";
    public O00Oo0 O000000o;
    public TuyaSigMeshActivatorBuilder O00000Oo;
    public O0OOo O00000o;
    public SigMeshBean O00000o0;
    public SparseBooleanArray O00000oO;
    public final ITuyaBlueMesh O00000oo;
    public final ITuyaBlueMeshActivatorListener O0000O0o;
    public Map<String, DeviceBean> O0000OOo = new HashMap();
    public O00Oo00o O0000Oo = new O00Oo00o() {
        public void O000000o() {
            ITuyaBlueMeshActivatorListener iTuyaBlueMeshActivatorListener = oooooo00o.this.O0000O0o;
            if (iTuyaBlueMeshActivatorListener != null) {
                iTuyaBlueMeshActivatorListener.onFinish();
            }
            oooooo00o.this.stopActivator();
        }

        public void O000000o(SearchDeviceBean searchDeviceBean) {
            if (oooooo00o.this.O0000O0o != null) {
                StringBuilder n = a.n("success:");
                n.append(searchDeviceBean.getMacAdress());
                L.d("TuyaBlueMeshActivatorImpl", n.toString());
                oooooo00o.this.O0000Oo0.put(BusinessResponse.KEY_RESULT, "success");
                oooooo00o.this.O0000Oo0.put("endTime", Long.valueOf(System.currentTimeMillis() / 1000));
                OO00Oo0.O000000o(O00000o0.O000000o.O00000o, oooooo00o.this.O0000Oo0);
                oooooo00o.this.O0000O0o.onSuccess(searchDeviceBean.getMacAdress(), oooooo00o.this.O0000OOo.get(searchDeviceBean.getMacAdress()));
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0051  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void O000000o(com.tuya.smart.android.blemesh.bean.SearchDeviceBean r5, java.lang.String r6) {
            /*
                r4 = this;
                int r0 = r6.hashCode()
                r1 = 47653717(0x2d72355, float:3.161169E-37)
                r2 = 1
                if (r0 == r1) goto L_0x001a
                r1 = 1478187778(0x581b5b02, float:6.8326071E14)
                if (r0 == r1) goto L_0x0010
                goto L_0x0024
            L_0x0010:
                java.lang.String r0 = "210025"
                boolean r6 = r6.equals(r0)
                if (r6 == 0) goto L_0x0024
                r6 = 1
                goto L_0x0025
            L_0x001a:
                java.lang.String r0 = "20014"
                boolean r6 = r6.equals(r0)
                if (r6 == 0) goto L_0x0024
                r6 = 0
                goto L_0x0025
            L_0x0024:
                r6 = -1
            L_0x0025:
                if (r6 == 0) goto L_0x0051
                if (r6 == r2) goto L_0x002a
                goto L_0x005c
            L_0x002a:
                com.tuya.smart.common.oooooo00o r5 = com.tuya.smart.common.oooooo00o.this
                java.util.HashMap r5 = r5.O0000Oo0
                r5.clear()
                com.tuya.smart.common.oooooo00o r5 = com.tuya.smart.common.oooooo00o.this
                java.util.HashMap r5 = r5.O0000Oo0
                java.lang.String r6 = "type"
                java.lang.String r0 = "ble_config_sigmesh"
                r5.put(r6, r0)
                com.tuya.smart.common.oooooo00o r5 = com.tuya.smart.common.oooooo00o.this
                java.util.HashMap r5 = r5.O0000Oo0
                long r0 = java.lang.System.currentTimeMillis()
                r2 = 1000(0x3e8, double:4.94E-321)
                long r0 = r0 / r2
                java.lang.Long r6 = java.lang.Long.valueOf(r0)
                java.lang.String r0 = "beginTime"
                r5.put(r0, r6)
                goto L_0x005c
            L_0x0051:
                com.tuya.smart.common.oooooo00o r6 = com.tuya.smart.common.oooooo00o.this
                android.util.SparseBooleanArray r6 = r6.O00000oO
                int r5 = r5.getMeshAddress()
                r6.put(r5, r2)
            L_0x005c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.oooooo00o.AnonymousClass1.O000000o(com.tuya.smart.android.blemesh.bean.SearchDeviceBean, java.lang.String):void");
        }

        public void O000000o(SearchDeviceBean searchDeviceBean, String str, String str2) {
            oooooo00o.this.O000000o(searchDeviceBean, str, str2);
            ITuyaBlueMeshActivatorListener iTuyaBlueMeshActivatorListener = oooooo00o.this.O0000O0o;
            if (iTuyaBlueMeshActivatorListener != null) {
                iTuyaBlueMeshActivatorListener.onError(searchDeviceBean != null ? searchDeviceBean.getMacAdress() : "", str, str2);
            }
            if (str.hashCode() == 47653717) {
                boolean equals = str.equals(O00OOo.O00000oO);
            }
        }
    };
    public HashMap O0000Oo0 = new HashMap();

    public oooooo00o(TuyaSigMeshActivatorBuilder tuyaSigMeshActivatorBuilder) {
        this.O00000Oo = tuyaSigMeshActivatorBuilder;
        this.O00000o0 = tuyaSigMeshActivatorBuilder.getSigMeshBean();
        this.O0000O0o = tuyaSigMeshActivatorBuilder.getTuyaBlueMeshActivatorListener();
        O000000o();
        this.O00000o = new O0OOo();
        this.O00000oo = new O000OO00(this.O00000o0.getMeshId());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void O000000o(com.tuya.smart.android.blemesh.bean.SearchDeviceBean r5, java.lang.String r6, java.lang.String r7) {
        /*
            r4 = this;
            int r5 = r6.hashCode()
            switch(r5) {
                case 47653722: goto L_0x00ad;
                case 47683475: goto L_0x00a3;
                case 47683477: goto L_0x0099;
                case 47683479: goto L_0x008f;
                case 47683481: goto L_0x0085;
                case 1478187742: goto L_0x007b;
                case 1478187746: goto L_0x0071;
                case 1478187748: goto L_0x0067;
                case 1478187750: goto L_0x005c;
                case 1478187773: goto L_0x0051;
                case 1478187775: goto L_0x0045;
                case 1478187777: goto L_0x0039;
                case 1478187779: goto L_0x002d;
                case 1478187780: goto L_0x0021;
                case 1478187808: goto L_0x0015;
                case 1478187809: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x00b7
        L_0x0009:
            java.lang.String r5 = "210035"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x00b7
            r5 = 15
            goto L_0x00b8
        L_0x0015:
            java.lang.String r5 = "210034"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x00b7
            r5 = 14
            goto L_0x00b8
        L_0x0021:
            java.lang.String r5 = "210027"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x00b7
            r5 = 13
            goto L_0x00b8
        L_0x002d:
            java.lang.String r5 = "210026"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x00b7
            r5 = 12
            goto L_0x00b8
        L_0x0039:
            java.lang.String r5 = "210024"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x00b7
            r5 = 11
            goto L_0x00b8
        L_0x0045:
            java.lang.String r5 = "210022"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x00b7
            r5 = 10
            goto L_0x00b8
        L_0x0051:
            java.lang.String r5 = "210020"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x00b7
            r5 = 9
            goto L_0x00b8
        L_0x005c:
            java.lang.String r5 = "210018"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x00b7
            r5 = 8
            goto L_0x00b8
        L_0x0067:
            java.lang.String r5 = "210016"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x00b7
            r5 = 7
            goto L_0x00b8
        L_0x0071:
            java.lang.String r5 = "210014"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x00b7
            r5 = 6
            goto L_0x00b8
        L_0x007b:
            java.lang.String r5 = "210010"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x00b7
            r5 = 5
            goto L_0x00b8
        L_0x0085:
            java.lang.String r5 = "21008"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x00b7
            r5 = 4
            goto L_0x00b8
        L_0x008f:
            java.lang.String r5 = "21006"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x00b7
            r5 = 3
            goto L_0x00b8
        L_0x0099:
            java.lang.String r5 = "21004"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x00b7
            r5 = 2
            goto L_0x00b8
        L_0x00a3:
            java.lang.String r5 = "21002"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x00b7
            r5 = 1
            goto L_0x00b8
        L_0x00ad:
            java.lang.String r5 = "20019"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x00b7
            r5 = 0
            goto L_0x00b8
        L_0x00b7:
            r5 = -1
        L_0x00b8:
            switch(r5) {
                case 0: goto L_0x00eb;
                case 1: goto L_0x00e8;
                case 2: goto L_0x00e5;
                case 3: goto L_0x00e2;
                case 4: goto L_0x00df;
                case 5: goto L_0x00dc;
                case 6: goto L_0x00d9;
                case 7: goto L_0x00d6;
                case 8: goto L_0x00d3;
                case 9: goto L_0x00d0;
                case 10: goto L_0x00cd;
                case 11: goto L_0x00ca;
                case 12: goto L_0x00c7;
                case 13: goto L_0x00c4;
                case 14: goto L_0x00c1;
                case 15: goto L_0x00be;
                default: goto L_0x00bb;
            }
        L_0x00bb:
            java.lang.String r5 = ""
            goto L_0x00ed
        L_0x00be:
            java.lang.String r5 = "mesh_connect_break"
            goto L_0x00ed
        L_0x00c1:
            java.lang.String r5 = "mesh_notify"
            goto L_0x00ed
        L_0x00c4:
            java.lang.String r5 = "mesh_node_id_get"
            goto L_0x00ed
        L_0x00c7:
            java.lang.String r5 = "mesh_register"
            goto L_0x00ed
        L_0x00ca:
            java.lang.String r5 = "mesh_network_transmit"
            goto L_0x00ed
        L_0x00cd:
            java.lang.String r5 = "mesh_publication_model"
            goto L_0x00ed
        L_0x00d0:
            java.lang.String r5 = "mesh_bind_model"
            goto L_0x00ed
        L_0x00d3:
            java.lang.String r5 = "mesh_add_appkey"
            goto L_0x00ed
        L_0x00d6:
            java.lang.String r5 = "mesh_config_composition_data"
            goto L_0x00ed
        L_0x00d9:
            java.lang.String r5 = "mesh_send_data_provision"
            goto L_0x00ed
        L_0x00dc:
            java.lang.String r5 = "mesh_random_confirm"
            goto L_0x00ed
        L_0x00df:
            java.lang.String r5 = "mesh_confirm_provision"
            goto L_0x00ed
        L_0x00e2:
            java.lang.String r5 = "mesh_send_public_key"
            goto L_0x00ed
        L_0x00e5:
            java.lang.String r5 = "mesh_start_provision"
            goto L_0x00ed
        L_0x00e8:
            java.lang.String r5 = "mesh_invite"
            goto L_0x00ed
        L_0x00eb:
            java.lang.String r5 = "ble_connect"
        L_0x00ed:
            java.util.HashMap r6 = r4.O0000Oo0
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 / r2
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            java.lang.String r1 = "endTime"
            r6.put(r1, r0)
            java.util.HashMap r6 = r4.O0000Oo0
            java.lang.String r0 = "result"
            java.lang.String r1 = "failure"
            r6.put(r0, r1)
            java.util.HashMap r6 = r4.O0000Oo0
            java.lang.String r0 = "step"
            r6.put(r0, r5)
            java.util.HashMap r5 = r4.O0000Oo0
            java.lang.String r6 = "errorMsg"
            r5.put(r6, r7)
            java.util.HashMap r5 = r4.O0000Oo0
            java.lang.String r6 = "e6b5236772babeeddbe2f95e5b760eae"
            com.tuya.smart.common.OO00Oo0.O000000o(r6, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.oooooo00o.O000000o(com.tuya.smart.android.blemesh.bean.SearchDeviceBean, java.lang.String, java.lang.String):void");
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
        this.O000000o = O00Oo00.O000000o(new oooo00o00().O000000o(this.O00000Oo.getSearchDeviceBeans()).O000000o(this.O00000o0.getName()).O000000o(new String[]{this.O00000o0.getMeshkey()}).O000000o(this.O00000Oo.getTimeOut()).O000000o(this.O0000Oo));
    }

    public void O000000o(SearchDeviceBean searchDeviceBean, O00Ooo00.O000000o o000000o, ooooooo ooooooo) {
    }

    public void O000000o(SearchDeviceBean searchDeviceBean, O00Ooo00.O000000o o000000o, String str, O0O000o o0O000o) {
        final SearchDeviceBean searchDeviceBean2 = searchDeviceBean;
        SigMeshSearchDeviceBean sigMeshSearchDeviceBean = (SigMeshSearchDeviceBean) searchDeviceBean2;
        boolean z = true;
        String format = String.format("%04x", new Object[]{Integer.valueOf(sigMeshSearchDeviceBean.getMeshAddress())});
        String O00000Oo2 = o00oo00ooo.O00000Oo(sigMeshSearchDeviceBean.getMacAdress());
        String O000000o2 = o00o0000oo.O000000o(sigMeshSearchDeviceBean.getProvisionedMeshNode().getDeviceKey(), false);
        int productIdentifier = sigMeshSearchDeviceBean.getProductIdentifier();
        String a2 = a.e.a.a.r.a.a(sigMeshSearchDeviceBean.getProductId());
        int versionIdentifier = sigMeshSearchDeviceBean.getVersionIdentifier();
        String str2 = a.e.a.a.r.a.a(new byte[]{(byte) (versionIdentifier & 255)}) + "." + a.e.a.a.r.a.a(new byte[]{(byte) ((versionIdentifier >> 8) & 255)});
        L.d("TuyaBlueMeshActivatorImpl", String.format("registCustomCodeForFinale: nodeId:%s mac:%s devcieKey:%s productKey:%s productIdentifier:%d   version:%s", new Object[]{format, O00000Oo2, O000000o2, a2, Integer.valueOf(productIdentifier), str2}));
        if ((productIdentifier & 256) != 256) {
            z = false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("isFK", Boolean.valueOf(z));
        JSONObject jSONObject = new JSONObject((Map<String, Object>) hashMap);
        final O0O000o o0O000o2 = o0O000o;
        this.O00000oo.addSubDev(O00000Oo2, format, a2, str2, O000000o2, O00000Oo2, jSONObject.toJSONString(), new IAddSubDevCallback() {
            public void onError(String str, String str2) {
                L.d("TuyaBlueMeshActivatorImpl", "addNodeIdToCloud onError:" + str + DpTimerBean.FILL + str2);
                o0O000o2.O000000o(O00OOo.O000OOoo, str);
            }

            public void onSuccess(DeviceBean deviceBean) {
                L.d("TuyaBlueMeshActivatorImpl", "addNodeIdToCloud onSuccess devBean:" + deviceBean + "  mac:" + searchDeviceBean2.getMacAdress());
                oooooo00o.this.O0000OOo.put(searchDeviceBean2.getMacAdress(), deviceBean);
                new O0OOo().O000000o(deviceBean.getDevId());
                o0O000o2.O000000o();
            }
        });
    }

    public void O000000o(final SearchDeviceBean searchDeviceBean, final O0O00oO o0O00oO) {
        this.O00000o.O00000Oo(this.O00000o0.getMeshId(), "1", new Business.ResultListener<Integer>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Integer num, String str) {
                if ("NO_AVAILABLE_NODE_ID".equals(businessResponse.getErrorCode())) {
                    int O000000o2 = oooooo00o.this.O00000Oo();
                    if (O000000o2 == -1) {
                        o0O00oO.O000000o(O00OOo.O000Oo00, "mesh address already full");
                    } else {
                        o0O00oO.O000000o(O000000o2);
                    }
                } else {
                    o0O00oO.O000000o(O00OOo.O000Oo00, businessResponse.getErrorCode());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Integer num, String str) {
                StringBuilder n = a.n("meshAddress: ");
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
                this.O00000oO.put(a.e.a.a.r.a.c(nodeId.getNodeId()), true);
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
        this.O00000o.onDestroy();
    }
}
