package com.tuya.smart.common;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.tuya.smart.android.base.event.NetWorkStatusEvent;
import com.tuya.smart.android.base.event.NetWorkStatusEventModel;
import com.tuya.smart.android.common.utils.NetworkUtil;
import com.tuya.smart.interior.device.bean.BlueMeshBatchReportBean;
import com.tuya.smart.interior.device.bean.DeviceRespBean;
import com.tuya.smart.interior.event.DevUpdateEvent;
import com.tuya.smart.interior.event.DevUpdateEventModel;
import com.tuya.smart.interior.event.DeviceUpdateEvent;
import com.tuya.smart.interior.event.ZigbeeSubDevDpUpdateEvent;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.bluemesh.IMeshDevListener;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class O0OOO0O implements NetWorkStatusEvent, O000o, O000o00, O00O000o, O00O00o0, O00O0O0o, O00O0Oo, O00O0o0, DevUpdateEvent, DeviceUpdateEvent, ZigbeeSubDevDpUpdateEvent {
    public static Map<String, O0OOO0O> O000000o = new HashMap();
    public String O00000Oo;
    public List<IMeshDevListener> O00000o0 = new ArrayList();

    public O0OOO0O(String str) {
        this.O00000Oo = str;
        TuyaSdk.getEventBus().register(this);
    }

    public static O0OOO0O O000000o(String str) {
        if (O000000o.containsKey(str)) {
            return O000000o.get(str);
        }
        O0OOO0O o0ooo0o = new O0OOO0O(str);
        O000000o.put(str, o0ooo0o);
        return o0ooo0o;
    }

    private void O000000o(String str, String str2, boolean z) {
        synchronized (this.O00000o0) {
            for (IMeshDevListener next : this.O00000o0) {
                if (next != null) {
                    next.onDpUpdate(str, str2, z);
                }
            }
        }
    }

    private void O000000o(String str, String[] strArr) {
        Class cls = o0o00o00o0.class;
        List<DeviceRespBean> devRespBeanList = ((o0o00o00o0) Oo0.O000000o(cls)).O0000OOo().getDevRespBeanList();
        ArrayList arrayList = new ArrayList();
        for (DeviceRespBean next : devRespBeanList) {
            DeviceBean deviceBean = ((o0o00o00o0) Oo0.O000000o(cls)).O0000OOo().getDeviceBean(next.getDevId());
            if (deviceBean != null && TextUtils.equals(deviceBean.getMeshId(), this.O00000Oo)) {
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str2 = strArr[i];
                    if (TextUtils.equals(next.getNodeId(), str2)) {
                        next.setMeshId(str);
                        arrayList.add(str2);
                        break;
                    }
                    i++;
                }
            }
        }
        if (arrayList.size() > 0) {
            O000000o((List<String>) arrayList, (List<String>) null, "");
        }
    }

    private void O000000o(List<String> list, List<String> list2, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (list != null) {
                for (String O000000o2 : list) {
                    OooOO.O000000o().O000000o(this.O00000Oo, str, O000000o2, true);
                }
            }
            if (list2 != null) {
                for (String O000000o3 : list2) {
                    OooOO.O000000o().O000000o(this.O00000Oo, str, O000000o3, false);
                }
            }
        }
        synchronized (this.O00000o0) {
            for (IMeshDevListener next : this.O00000o0) {
                if (next != null) {
                    next.onStatusChanged(list, list2, str);
                }
            }
        }
    }

    private void O000000o(boolean z) {
        synchronized (this.O00000o0) {
            for (IMeshDevListener next : this.O00000o0) {
                if (next != null) {
                    next.onNetworkStatusChanged(this.O00000Oo, z);
                }
            }
        }
    }

    private void O000000o(boolean z, boolean z2) {
        O000000o(O000OO0o.O000000o().getBlueMeshBean(this.O00000Oo) != null || (z && z2));
    }

    private void O000000o(byte[] bArr) {
        OO00OO.O000000o(this.O00000Oo, bArr);
        synchronized (this.O00000o0) {
            for (IMeshDevListener next : this.O00000o0) {
                if (next != null) {
                    next.onRawDataUpdate(bArr);
                }
            }
        }
    }

    private boolean O00000Oo() {
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        if (o0o00o00o0 != null) {
            return o0o00o00o0.O00000oo().isServerConnect();
        }
        return false;
    }

    private void O00000o0(String str) {
        synchronized (this.O00000o0) {
            for (IMeshDevListener next : this.O00000o0) {
                if (next != null) {
                    next.onDevInfoUpdate(str);
                }
            }
        }
    }

    public void O000000o() {
        TuyaSdk.getEventBus().unregister(this);
    }

    public void O000000o(IMeshDevListener iMeshDevListener) {
        if (iMeshDevListener != null) {
            this.O00000o0.add(iMeshDevListener);
        }
    }

    public void O00000Oo(IMeshDevListener iMeshDevListener) {
        if (iMeshDevListener != null) {
            this.O00000o0.remove(iMeshDevListener);
        }
    }

    public void O00000Oo(String str) {
        synchronized (this.O00000o0) {
            for (IMeshDevListener next : this.O00000o0) {
                if (next != null) {
                    next.onRemoved(str);
                }
            }
        }
    }

    public void onEvent(NetWorkStatusEventModel netWorkStatusEventModel) {
        O000000o(netWorkStatusEventModel.isAvailable(), O00000Oo());
    }

    public void onEvent(O00O00Oo o00O00Oo) {
        if (TextUtils.equals(this.O00000Oo, o00O00Oo.O000000o())) {
            O000000o(o00O00Oo.O00000Oo(), o00O00Oo.O00000o0(), "");
        }
    }

    public void onEvent(O00O0OOo o00O0OOo) {
        if (TextUtils.equals(this.O00000Oo, o00O0OOo.O00000Oo())) {
            O000000o(o00O0OOo.O000000o());
        }
    }

    public void onEventMainThread(O000o000 o000o000) {
        List<BlueMeshBatchReportBean> O000000o2;
        if (TextUtils.equals(o000o000.O00000Oo(), this.O00000Oo) && (O000000o2 = o000o000.O000000o()) != null) {
            for (BlueMeshBatchReportBean next : O000000o2) {
                O000000o(next.getCid(), JSON.toJSONString(next.getDps()), false);
            }
        }
    }

    public void onEventMainThread(O000o0 o000o0) {
        Class cls = o0o00o00o0.class;
        DeviceBean deviceBean = Oo0.O000000o(cls) != null ? ((o0o00o00o0) Oo0.O000000o(cls)).O0000OOo().getDeviceBean(o000o0.O000000o()) : null;
        String[] split = o000o0.O00000Oo().split(",");
        if (deviceBean != null) {
            if (!TextUtils.equals(this.O00000Oo, deviceBean.getParentId())) {
                return;
            }
        } else if (!TextUtils.equals(this.O00000Oo, o000o0.O000000o())) {
            return;
        }
        O000000o(o000o0.O000000o(), split);
    }

    public void onEventMainThread(O00O00o o00O00o) {
        Class cls = o0o00o00o0.class;
        DeviceBean deviceBean = Oo0.O000000o(cls) != null ? ((o0o00o00o0) Oo0.O000000o(cls)).O0000OOo().getDeviceBean(o00O00o.O000000o()) : null;
        if (deviceBean != null) {
            if (!TextUtils.equals(this.O00000Oo, deviceBean.getParentId())) {
                return;
            }
        } else if (!TextUtils.equals(this.O00000Oo, o00O00o.O000000o())) {
            return;
        }
        O000000o(o00O00o.O00000Oo(), o00O00o.O00000o0(), o00O00o.O00000o());
    }

    public void onEventMainThread(O00O0o o00O0o) {
        O000000o(NetworkUtil.isNetworkAvailable(TuyaSdk.getApplication()), o00O0o.O000000o());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0054, code lost:
        if (r6.O00000o0() == -2) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0039, code lost:
        if (r6.O00000o0() == -2) goto L_0x0058;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onEventMainThread(com.tuya.smart.common.oooOoO r6) {
        /*
            r5 = this;
            java.lang.Class<com.tuya.smart.common.o0o00o00o0> r0 = com.tuya.smart.common.o0o00o00o0.class
            java.lang.Object r1 = com.tuya.smart.common.Oo0.O000000o(r0)
            if (r1 == 0) goto L_0x001b
            java.lang.Object r0 = com.tuya.smart.common.Oo0.O000000o(r0)
            com.tuya.smart.common.o0o00o00o0 r0 = (com.tuya.smart.common.o0o00o00o0) r0
            com.tuya.smart.home.sdk.api.ITuyaHomeDataManager r0 = r0.O0000OOo()
            java.lang.String r1 = r6.O000000o()
            com.tuya.smart.sdk.bean.DeviceBean r0 = r0.getDeviceBean(r1)
            goto L_0x001c
        L_0x001b:
            r0 = 0
        L_0x001c:
            r1 = 1
            r2 = 0
            r3 = -2
            if (r0 == 0) goto L_0x003c
            java.lang.String r4 = r5.O00000Oo
            java.lang.String r0 = r0.getParentId()
            boolean r0 = android.text.TextUtils.equals(r4, r0)
            if (r0 == 0) goto L_0x005b
            java.lang.String r0 = r6.O00000Oo()
            java.lang.String r4 = r6.O00000o()
            int r6 = r6.O00000o0()
            if (r6 != r3) goto L_0x0057
            goto L_0x0058
        L_0x003c:
            java.lang.String r0 = r5.O00000Oo
            java.lang.String r4 = r6.O000000o()
            boolean r0 = android.text.TextUtils.equals(r0, r4)
            if (r0 == 0) goto L_0x005b
            java.lang.String r0 = r6.O00000Oo()
            java.lang.String r4 = r6.O00000o()
            int r6 = r6.O00000o0()
            if (r6 != r3) goto L_0x0057
            goto L_0x0058
        L_0x0057:
            r1 = 0
        L_0x0058:
            r5.O000000o((java.lang.String) r0, (java.lang.String) r4, (boolean) r1)
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.O0OOO0O.onEventMainThread(com.tuya.smart.common.oooOoO):void");
    }

    public void onEventMainThread(DevUpdateEventModel devUpdateEventModel) {
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        if (o0o00o00o0 != null) {
            DeviceBean deviceBean = o0o00o00o0.O0000OOo().getDeviceBean(devUpdateEventModel.getDevId());
            if (deviceBean != null && deviceBean.isBleMeshWifi() && TextUtils.equals(deviceBean.getMeshId(), this.O00000Oo)) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                boolean isCloudOnline = deviceBean.isCloudOnline();
                String nodeId = deviceBean.getNodeId();
                if (isCloudOnline) {
                    arrayList.add(nodeId);
                } else {
                    arrayList2.add(nodeId);
                }
                O000000o((List<String>) arrayList, (List<String>) arrayList2, devUpdateEventModel.getDevId());
            } else if (deviceBean != null && deviceBean.isBleMesh() && TextUtils.equals(deviceBean.getMeshId(), this.O00000Oo) && !deviceBean.getIsLocalOnline().booleanValue()) {
                O000000o(deviceBean.getNodeId(), JSON.toJSONString(deviceBean.getDps()), false);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0033, code lost:
        if (r7.getMode() == 2) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
        O00000o0(r7.getDevId());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0054, code lost:
        if (r7.getMode() == 2) goto L_0x0035;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onEventMainThread(com.tuya.smart.interior.event.DeviceUpdateEventModel r7) {
        /*
            r6 = this;
            java.lang.Class<com.tuya.smart.common.o0o00o00o0> r0 = com.tuya.smart.common.o0o00o00o0.class
            java.lang.Object r1 = com.tuya.smart.common.Oo0.O000000o(r0)
            r2 = 0
            if (r1 == 0) goto L_0x001c
            java.lang.Object r1 = com.tuya.smart.common.Oo0.O000000o(r0)
            com.tuya.smart.common.o0o00o00o0 r1 = (com.tuya.smart.common.o0o00o00o0) r1
            com.tuya.smart.home.sdk.api.ITuyaHomeDataManager r1 = r1.O0000OOo()
            java.lang.String r3 = r7.getMeshId()
            com.tuya.smart.sdk.bean.DeviceBean r1 = r1.getDeviceBean(r3)
            goto L_0x001d
        L_0x001c:
            r1 = r2
        L_0x001d:
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x003d
            int r1 = r7.getMode()
            if (r1 != r4) goto L_0x002f
        L_0x0027:
            java.lang.String r1 = r7.getDevId()
            r6.O00000Oo((java.lang.String) r1)
            goto L_0x0057
        L_0x002f:
            int r1 = r7.getMode()
            if (r1 != r3) goto L_0x0057
        L_0x0035:
            java.lang.String r1 = r7.getDevId()
            r6.O00000o0(r1)
            goto L_0x0057
        L_0x003d:
            java.lang.String r1 = r6.O00000Oo
            java.lang.String r5 = r7.getMeshId()
            boolean r1 = android.text.TextUtils.equals(r1, r5)
            if (r1 == 0) goto L_0x0057
            int r1 = r7.getMode()
            if (r1 != r4) goto L_0x0050
            goto L_0x0027
        L_0x0050:
            int r1 = r7.getMode()
            if (r1 != r3) goto L_0x0057
            goto L_0x0035
        L_0x0057:
            java.lang.String r1 = r7.getMeshId()
            java.lang.String r5 = r6.O00000Oo
            boolean r1 = android.text.TextUtils.equals(r1, r5)
            if (r1 == 0) goto L_0x00c7
            int r1 = r7.getMode()
            if (r1 != r4) goto L_0x00ba
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.Object r0 = com.tuya.smart.common.Oo0.O000000o(r0)
            com.tuya.smart.common.o0o00o00o0 r0 = (com.tuya.smart.common.o0o00o00o0) r0
            com.tuya.smart.home.sdk.api.ITuyaHomeDataManager r0 = r0.O0000OOo()
            java.util.List r0 = r0.getDevRespBeanList()
            java.util.Iterator r0 = r0.iterator()
        L_0x0080:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x00a7
            java.lang.Object r3 = r0.next()
            com.tuya.smart.interior.device.bean.DeviceRespBean r3 = (com.tuya.smart.interior.device.bean.DeviceRespBean) r3
            java.lang.String r4 = r3.getMeshId()
            java.lang.String r5 = r7.getDevId()
            boolean r4 = android.text.TextUtils.equals(r4, r5)
            if (r4 == 0) goto L_0x0080
            java.lang.String r4 = r6.O00000Oo
            r3.setMeshId(r4)
            java.lang.String r3 = r3.getNodeId()
            r1.add(r3)
            goto L_0x0080
        L_0x00a7:
            int r0 = r1.size()
            if (r0 <= 0) goto L_0x00b2
            java.lang.String r0 = ""
            r6.O000000o((java.util.List<java.lang.String>) r1, (java.util.List<java.lang.String>) r2, (java.lang.String) r0)
        L_0x00b2:
            java.lang.String r7 = r7.getDevId()
            r6.O00000Oo((java.lang.String) r7)
            goto L_0x00c7
        L_0x00ba:
            int r0 = r7.getMode()
            if (r0 != r3) goto L_0x00c7
            java.lang.String r7 = r7.getDevId()
            r6.O00000o0(r7)
        L_0x00c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.O0OOO0O.onEventMainThread(com.tuya.smart.interior.event.DeviceUpdateEventModel):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0054, code lost:
        if (r6.getType() == -2) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0039, code lost:
        if (r6.getType() == -2) goto L_0x0058;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onEventMainThread(com.tuya.smart.interior.event.ZigbeeSubDevDpUpdateEventModel r6) {
        /*
            r5 = this;
            java.lang.Class<com.tuya.smart.common.o0o00o00o0> r0 = com.tuya.smart.common.o0o00o00o0.class
            java.lang.Object r1 = com.tuya.smart.common.Oo0.O000000o(r0)
            if (r1 == 0) goto L_0x001b
            java.lang.Object r0 = com.tuya.smart.common.Oo0.O000000o(r0)
            com.tuya.smart.common.o0o00o00o0 r0 = (com.tuya.smart.common.o0o00o00o0) r0
            com.tuya.smart.home.sdk.api.ITuyaHomeDataManager r0 = r0.O0000OOo()
            java.lang.String r1 = r6.getMeshId()
            com.tuya.smart.sdk.bean.DeviceBean r0 = r0.getDeviceBean(r1)
            goto L_0x001c
        L_0x001b:
            r0 = 0
        L_0x001c:
            r1 = 1
            r2 = 0
            r3 = -2
            if (r0 == 0) goto L_0x003c
            java.lang.String r4 = r5.O00000Oo
            java.lang.String r0 = r0.getParentId()
            boolean r0 = android.text.TextUtils.equals(r4, r0)
            if (r0 == 0) goto L_0x005b
            java.lang.String r0 = r6.getCid()
            java.lang.String r4 = r6.getDps()
            int r6 = r6.getType()
            if (r6 != r3) goto L_0x0057
            goto L_0x0058
        L_0x003c:
            java.lang.String r0 = r5.O00000Oo
            java.lang.String r4 = r6.getMeshId()
            boolean r0 = android.text.TextUtils.equals(r0, r4)
            if (r0 == 0) goto L_0x005b
            java.lang.String r0 = r6.getCid()
            java.lang.String r4 = r6.getDps()
            int r6 = r6.getType()
            if (r6 != r3) goto L_0x0057
            goto L_0x0058
        L_0x0057:
            r1 = 0
        L_0x0058:
            r5.O000000o((java.lang.String) r0, (java.lang.String) r4, (boolean) r1)
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.O0OOO0O.onEventMainThread(com.tuya.smart.interior.event.ZigbeeSubDevDpUpdateEventModel):void");
    }
}
