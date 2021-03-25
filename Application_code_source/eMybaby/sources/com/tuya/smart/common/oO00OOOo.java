package com.tuya.smart.common;

import com.tuya.smart.android.hardware.bean.HgwBean;
import com.tuya.smart.interior.enums.ActiveEnum;
import com.tuya.smart.sdk.bean.DeviceBean;

public class oO00OOOo implements o0o0o0o000 {
    public static final String O000000o = "TuyaDeviceOperate";
    public static final oO00OOOo O00000Oo = new oO00OOOo();

    public static o0o0o0o000 O000000o() {
        return O00000Oo;
    }

    public Boolean O000000o(DeviceBean deviceBean, Boolean bool) {
        boolean z = true;
        if (deviceBean.isBleMesh()) {
            o0o000oooo o0o000oooo = (o0o000oooo) Oo0.O000000o(o0o000oooo.class);
            if (o0o000oooo == null || !o0o000oooo.O00000o().getMeshDeviceLocalStatus(deviceBean.getMeshId(), deviceBean.getNodeId())) {
                z = false;
            }
            return Boolean.valueOf(z);
        } else if (deviceBean.isZigBeeSubDev()) {
            if (!bool.booleanValue()) {
                return Boolean.FALSE;
            }
            DeviceBean O00000Oo2 = oO00O0o0.O000000o().O00000Oo(deviceBean.getMeshId());
            if (O00000Oo2 == null || !O00000Oo2.getIsLocalOnline().booleanValue()) {
                z = false;
            }
            return Boolean.valueOf(z);
        } else if (!deviceBean.isInfraredSubDev() && !deviceBean.is433SubDev()) {
            o0o00o0o00 o0o00o0o00 = (o0o00o0o00) Oo0.O000000o(o0o00o0o00.class);
            HgwBean hgwBean = null;
            if (o0o00o0o00 != null) {
                hgwBean = o0o00o0o00.O000000o().O00000Oo(deviceBean.getDevId());
            }
            if (hgwBean == null || ActiveEnum.ACTIVED.getType() != hgwBean.getActive()) {
                z = false;
            }
            return Boolean.valueOf(z);
        } else if (!bool.booleanValue()) {
            return Boolean.FALSE;
        } else {
            DeviceBean O00000Oo3 = oO00O0o0.O000000o().O00000Oo(deviceBean.getMeshId());
            if (O00000Oo3 == null || !O00000Oo3.getIsLocalOnline().booleanValue()) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    public boolean O000000o(DeviceBean deviceBean) {
        o0o000oooo o0o000oooo = (o0o000oooo) Oo0.O000000o(o0o000oooo.class);
        return o0o000oooo != null && o0o000oooo.O00000o().getMeshDeviceCloudStatus(deviceBean.getMeshId(), deviceBean.getDevId());
    }

    public boolean O00000Oo(DeviceBean deviceBean, Boolean bool) {
        if (deviceBean.getIsLocalOnline().booleanValue() && !deviceBean.isBleMeshWifi()) {
            return true;
        }
        if (deviceBean.isZigBeeWifi()) {
            return deviceBean.isCloudOnline();
        }
        if (deviceBean.isBleMesh()) {
            return deviceBean.isBleMeshWifi() ? deviceBean.isCloudOnline() : O000000o(deviceBean);
        }
        if (!bool.booleanValue()) {
            return false;
        }
        if (deviceBean.isZigBeeSubDev() || deviceBean.is433SubDev()) {
            if (deviceBean.isVirtual()) {
                return true;
            }
            DeviceBean O00000Oo2 = oO00O0o0.O000000o().O00000Oo(deviceBean.getMeshId());
            return O00000Oo2 != null && O00000Oo2.getIsOnline().booleanValue();
        } else if (!deviceBean.isInfraredSubDev()) {
            return true;
        } else {
            DeviceBean O00000Oo3 = oO00O0o0.O000000o().O00000Oo(deviceBean.getMeshId());
            return O00000Oo3 != null && O00000Oo3.getIsOnline().booleanValue();
        }
    }
}
