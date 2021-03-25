package com.tuya.smart.common;

import android.app.Application;
import android.app.Notification;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.tuya.smart.android.base.TuyaSmartSdk;
import com.tuya.smart.android.common.utils.NotificationHelper;
import com.tuya.smart.android.common.utils.TuyaUtil;
import com.tuya.smart.android.mqtt.ITuyaMqttChannel;
import com.tuya.smart.home.sdk.api.IDevModel;
import com.tuya.smart.home.sdk.api.ITuyaHomeDataManager;
import com.tuya.smart.home.sdk.api.ITuyaHomeSpeech;
import com.tuya.smart.home.sdk.api.ITuyaServer;
import com.tuya.smart.home.sdk.callback.ITuyaSingleTransfer;
import com.tuya.smart.home.sdk.callback.ITuyaVoiceTransfer;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.ITuyaDevice;
import com.tuya.smart.sdk.api.ITuyaDeviceListManager;
import com.tuya.smart.sdk.api.ITuyaGateway;
import com.tuya.smart.sdk.api.ITuyaGroup;
import com.tuya.smart.sdk.api.ITuyaOta;
import com.tuya.smart.sdk.api.ITuyaSmartRequest;
import com.tuya.smart.sdk.api.ITuyaTimer;
import com.tuya.smart.sdk.api.ITuyaZigbeeGroup;

public class o0000000 implements o0o00o00o0 {
    public o0o0o0o000 O000000o() {
        return oO00OOOo.O000000o();
    }

    public IDevModel O000000o(Context context, String str) {
        return new oO000OOO(context, str);
    }

    public ITuyaDevice O000000o(String str) {
        return new oOo00OO0(str);
    }

    public ITuyaGroup O000000o(long j) {
        return new oOo00ooO(j);
    }

    public ITuyaOta O000000o(String str, String str2, String str3) {
        return new oO0O000o(TuyaSdk.getApplication(), str, str2, str3);
    }

    public ITuyaOta O00000Oo(String str) {
        return new oO0O000o(TuyaSdk.getApplication(), str);
    }

    public ITuyaZigbeeGroup O00000Oo(long j) {
        return new ooooO000(j);
    }

    public void O00000Oo() {
        oOo0oooO.O000000o();
    }

    public ITuyaTimer O00000o() {
        return o00o0o000o.O000000o();
    }

    public ITuyaGateway O00000o0(String str) {
        return new oO00Oo00(str);
    }

    public void O00000o0() {
        oOo0oooO.O000000o().onDestroy();
    }

    public ITuyaSingleTransfer O00000oO() {
        return oO0O0O00.O00000Oo();
    }

    public ITuyaServer O00000oo() {
        return oO0O00o0.O000000o();
    }

    public ITuyaSmartRequest O0000O0o() {
        return ooOOO0Oo.O000000o();
    }

    public ITuyaHomeDataManager O0000OOo() {
        return oO0OO000.O000000o();
    }

    public ITuyaVoiceTransfer O0000Oo() {
        return oOO00000.O000000o();
    }

    public ITuyaHomeSpeech O0000Oo0() {
        return oO0OO00o.O000000o();
    }

    public o0o0o0000o O0000OoO() {
        return oO00O0o0.O000000o();
    }

    public o0o0o000oo O0000Ooo() {
        return new oO0O0OoO();
    }

    public Notification O0000o0() {
        NotificationHelper.Builder autoCancel = new NotificationHelper.Builder(TuyaSmartSdk.getApplication()).setChannelId(NotificationCompat.CATEGORY_SERVICE).setSmallIconRes(TuyaUtil.getDrawableResId(TuyaSmartSdk.getApplication(), "ic_launcher", 17301651)).setAutoCancel(false);
        Application application = TuyaSmartSdk.getApplication();
        return autoCancel.setTitle(TuyaUtil.getString(application, "service_running_tips_title", TuyaUtil.getApplicationName(TuyaSmartSdk.getApplication()) + " is running")).setText(TuyaUtil.getString(TuyaSmartSdk.getApplication(), "service_running_tips_content", TuyaUtil.getApplicationName(TuyaSmartSdk.getApplication()))).build();
    }

    public ITuyaDeviceListManager O0000o00() {
        return oOo0oooO.O000000o();
    }

    public o0o00oooo0 O0000o0O() {
        return new oO0Ooooo();
    }

    public ITuyaMqttChannel O0000o0o() {
        return oOo000o0.O000000o();
    }
}
