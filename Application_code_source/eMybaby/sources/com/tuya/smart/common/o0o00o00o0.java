package com.tuya.smart.common;

import android.app.Notification;
import android.content.Context;
import com.tuya.smart.android.mqtt.ITuyaMqttChannel;
import com.tuya.smart.home.sdk.api.IDevModel;
import com.tuya.smart.home.sdk.api.ITuyaHomeDataManager;
import com.tuya.smart.home.sdk.api.ITuyaHomeSpeech;
import com.tuya.smart.home.sdk.api.ITuyaServer;
import com.tuya.smart.home.sdk.callback.ITuyaSingleTransfer;
import com.tuya.smart.home.sdk.callback.ITuyaVoiceTransfer;
import com.tuya.smart.sdk.api.ITuyaDevice;
import com.tuya.smart.sdk.api.ITuyaDeviceListManager;
import com.tuya.smart.sdk.api.ITuyaGateway;
import com.tuya.smart.sdk.api.ITuyaGroup;
import com.tuya.smart.sdk.api.ITuyaOta;
import com.tuya.smart.sdk.api.ITuyaSmartRequest;
import com.tuya.smart.sdk.api.ITuyaTimer;
import com.tuya.smart.sdk.api.ITuyaZigbeeGroup;

public interface o0o00o00o0 {
    o0o0o0o000 O000000o();

    IDevModel O000000o(Context context, String str);

    ITuyaDevice O000000o(String str);

    ITuyaGroup O000000o(long j);

    ITuyaOta O000000o(String str, String str2, String str3);

    ITuyaOta O00000Oo(String str);

    ITuyaZigbeeGroup O00000Oo(long j);

    void O00000Oo();

    ITuyaTimer O00000o();

    ITuyaGateway O00000o0(String str);

    void O00000o0();

    ITuyaSingleTransfer O00000oO();

    ITuyaServer O00000oo();

    ITuyaSmartRequest O0000O0o();

    ITuyaHomeDataManager O0000OOo();

    ITuyaVoiceTransfer O0000Oo();

    ITuyaHomeSpeech O0000Oo0();

    o0o0o0000o O0000OoO();

    o0o0o000oo O0000Ooo();

    Notification O0000o0();

    ITuyaDeviceListManager O0000o00();

    o0o00oooo0 O0000o0O();

    ITuyaMqttChannel O0000o0o();
}
