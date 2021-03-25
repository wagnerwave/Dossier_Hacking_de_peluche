package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.interior.device.bean.BlueMeshBatchReportBean;
import com.tuya.smart.interior.event.DevUpdateEvent;
import com.tuya.smart.interior.event.DevUpdateEventModel;
import com.tuya.smart.interior.event.DeviceUpdateEvent;
import com.tuya.smart.interior.event.DeviceUpdateEventModel;
import com.tuya.smart.interior.event.ZigbeeSubDevDpUpdateEvent;
import com.tuya.smart.interior.event.ZigbeeSubDevDpUpdateEventModel;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.ISubDevListener;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class oO0o0000 implements o0o0o00000, DevUpdateEvent, DeviceUpdateEvent, ZigbeeSubDevDpUpdateEvent {
    public static final String O000000o = "TuyaSubDeviceMonitorManager";
    public final String O00000Oo;
    public final ISubDevListener O00000o0;

    public oO0o0000(String str, ISubDevListener iSubDevListener) {
        this.O00000Oo = str;
        this.O00000o0 = iSubDevListener;
        TuyaSdk.getEventBus().register(this);
        oOo0oooO.O000000o().registerDeviceMqttListener(o0o0ooo000.class, this);
        oOo0oooO.O000000o().registerDeviceMqttListener(o0o0oo0o00.class, this);
        oOo0oooO.O000000o().registerDeviceMqttListener(o0o0oooooo.class, this);
    }

    private void O000000o(o0o0oo0o00 o0o0oo0o00) {
        if (this.O00000o0 != null) {
            StringBuilder n = a.n("devId: ");
            n.append(this.O00000Oo);
            n.append(" meshId: ");
            n.append(o0o0oo0o00.O000000o());
            L.d(O000000o, n.toString());
            if (TextUtils.equals(this.O00000Oo, o0o0oo0o00.O000000o())) {
                ArrayList arrayList = new ArrayList();
                if (o0o0oo0o00.O00000o0() != null) {
                    arrayList.addAll(o0o0oo0o00.O00000o0());
                }
                if (o0o0oo0o00.O00000Oo() != null) {
                    arrayList.addAll(o0o0oo0o00.O00000Oo());
                }
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    DeviceBean subDeviceBeanByNodeId = oO0OO000.O000000o().getSubDeviceBeanByNodeId(this.O00000Oo, str);
                    if (subDeviceBeanByNodeId != null) {
                        if (subDeviceBeanByNodeId.getIsOnline().booleanValue()) {
                            arrayList2.add(str);
                        } else {
                            arrayList3.add(str);
                        }
                    }
                }
                this.O00000o0.onSubDevStatusChanged(arrayList2, arrayList3);
            }
        }
    }

    private void O000000o(o0o0ooo000 o0o0ooo000) {
        List<BlueMeshBatchReportBean> O000000o2;
        if (TextUtils.equals(o0o0ooo000.O00000Oo(), this.O00000Oo) && (O000000o2 = o0o0ooo000.O000000o()) != null) {
            for (BlueMeshBatchReportBean next : O000000o2) {
                ISubDevListener iSubDevListener = this.O00000o0;
                if (iSubDevListener != null) {
                    iSubDevListener.onSubDevDpUpdate(next.getCid(), JSON.toJSONString(next.getDps()));
                }
            }
        }
    }

    private void O000000o(o0o0oooooo o0o0oooooo) {
        ISubDevListener iSubDevListener;
        if (TextUtils.equals(this.O00000Oo, o0o0oooooo.O000000o()) && (iSubDevListener = this.O00000o0) != null) {
            iSubDevListener.onSubDevDpUpdate(o0o0oooooo.O00000Oo(), o0o0oooooo.O00000o());
        }
    }

    public void O000000o() {
        TuyaSdk.getEventBus().unregister(this);
        oOo0oooO.O000000o().unRegisterDeviceMqttListener(o0o0oo0o00.class, this);
        oOo0oooO.O000000o().unRegisterDeviceMqttListener(o0o0ooo000.class, this);
        oOo0oooO.O000000o().unRegisterDeviceMqttListener(o0o0oooooo.class, this);
    }

    public void onEventMainThread(DevUpdateEventModel devUpdateEventModel) {
        if (TextUtils.equals(devUpdateEventModel.getDevId(), this.O00000Oo)) {
            List<DeviceBean> subDeviceBean = oO0OO000.O000000o().getSubDeviceBean(this.O00000Oo);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (DeviceBean next : subDeviceBean) {
                boolean booleanValue = next.getIsOnline().booleanValue();
                String nodeId = next.getNodeId();
                if (booleanValue) {
                    arrayList.add(nodeId);
                } else {
                    arrayList2.add(nodeId);
                }
            }
            this.O00000o0.onSubDevStatusChanged(arrayList, arrayList2);
            return;
        }
        DeviceBean deviceBean = oO0OO000.O000000o().getDeviceBean(devUpdateEventModel.getDevId());
        if (deviceBean != null && TextUtils.equals(deviceBean.getMeshId(), this.O00000Oo)) {
            this.O00000o0.onSubDevDpUpdate(deviceBean.getNodeId(), JSON.toJSONString(deviceBean.getDps()));
        }
    }

    public void onEventMainThread(DeviceUpdateEventModel deviceUpdateEventModel) {
        ISubDevListener iSubDevListener;
        L.d(O000000o, "DeviceUpdateEventModel");
        if (!TextUtils.equals(this.O00000Oo, deviceUpdateEventModel.getMeshId())) {
            StringBuilder n = a.n("mMeshId=");
            n.append(this.O00000Oo);
            n.append("--mesdhId=");
            n.append(deviceUpdateEventModel.getMeshId());
            L.d(O000000o, n.toString());
            return;
        }
        int mode = deviceUpdateEventModel.getMode();
        if (mode == 0) {
            ISubDevListener iSubDevListener2 = this.O00000o0;
            if (iSubDevListener2 != null) {
                iSubDevListener2.onSubDevAdded(deviceUpdateEventModel.getDevId());
            }
        } else if (mode == 1) {
            ISubDevListener iSubDevListener3 = this.O00000o0;
            if (iSubDevListener3 != null) {
                iSubDevListener3.onSubDevRemoved(deviceUpdateEventModel.getDevId());
            }
        } else if (mode == 2 && (iSubDevListener = this.O00000o0) != null) {
            iSubDevListener.onSubDevInfoUpdate(deviceUpdateEventModel.getDevId());
        }
    }

    public void onEventMainThread(ZigbeeSubDevDpUpdateEventModel zigbeeSubDevDpUpdateEventModel) {
        ISubDevListener iSubDevListener;
        if (TextUtils.equals(this.O00000Oo, zigbeeSubDevDpUpdateEventModel.getMeshId()) && (iSubDevListener = this.O00000o0) != null) {
            iSubDevListener.onSubDevDpUpdate(zigbeeSubDevDpUpdateEventModel.getCid(), zigbeeSubDevDpUpdateEventModel.getDps());
        }
    }

    public void onResult(Object obj) {
        if (obj instanceof o0o0ooo000) {
            O000000o((o0o0ooo000) obj);
        } else if (obj instanceof o0o0oo0o00) {
            O000000o((o0o0oo0o00) obj);
        } else if (obj instanceof o0o0oooooo) {
            O000000o((o0o0oooooo) obj);
        }
    }
}
