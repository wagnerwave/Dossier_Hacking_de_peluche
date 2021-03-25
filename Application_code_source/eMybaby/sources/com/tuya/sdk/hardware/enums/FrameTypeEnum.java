package com.tuya.sdk.hardware.enums;

import com.tuya.smart.common.O0o00;
import com.tuya.smart.common.oo0o00ooo;

public enum FrameTypeEnum {
    UDP(0),
    AP_CONFIG(1),
    ACTIVE(2),
    BIND(3),
    RENAME_GW(4),
    RENAME_DEVICE(5),
    UNBIND(6),
    CONTROL(7),
    STATUS(8),
    HEART_BEAT(9),
    DP_QUERY(10),
    QUERY_WIFI(11),
    TOKEN_BIND(12),
    CONTROL_NEW(13),
    ENABLE_WIFI(14),
    DP_QUERY_NEW(16),
    SCENE_EXECUTE(17),
    AP_CONFIG_NEW(20),
    LAN_GW_ACTIVE(240),
    LAN_SUB_DEV_REQUEST(O0o00.O000000o),
    LAN_DELETE_SUB_DEV(oo0o00ooo.O000000o),
    LAN_REPORT_SUB_DEV(243),
    LAN_SCENE(O0o00.O00000o0),
    LAN_PUBLISH_CLOUD_CONFIG(O0o00.O00000o),
    LAN_PUBLISH_APP_CONFIG(O0o00.O00000oO),
    LAN_EXPORT_APP_CONFIG(247),
    LAN_PUBLISH_SCENE_PANEL(O0o00.O0000O0o),
    LAN_REMOVE_GW(249),
    LAN_CHECK_GW_UPDATE(250),
    LAN_GW_UPDATE(251),
    LAN_SET_GW_CHANNEL(252);
    
    public int type;

    /* access modifiers changed from: public */
    FrameTypeEnum(int i) {
        this.type = i;
    }

    public static FrameTypeEnum to(int i) {
        for (FrameTypeEnum frameTypeEnum : values()) {
            if (i == frameTypeEnum.type) {
                return frameTypeEnum;
            }
        }
        return null;
    }

    public int getType() {
        return this.type;
    }
}
