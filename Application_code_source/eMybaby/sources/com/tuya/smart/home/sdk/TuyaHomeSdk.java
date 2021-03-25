package com.tuya.smart.home.sdk;

import android.app.Application;
import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshClient;
import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshConfig;
import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshDevice;
import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshGroup;
import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshOta;
import com.tuya.smart.android.blemesh.api.ITuyaSigMeshClient;
import com.tuya.smart.android.blemesh.builder.TuyaBlueMeshOtaBuilder;
import com.tuya.smart.android.camera.api.ITuyaHomeCamera;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.mqtt.ITuyaMqttChannel;
import com.tuya.smart.android.network.TuyaSmartNetWork;
import com.tuya.smart.android.sweeper.ITuyaSweeper;
import com.tuya.smart.common.Oo0;
import com.tuya.smart.common.o0o000oooo;
import com.tuya.smart.common.o0o00o0000;
import com.tuya.smart.common.o0o00o000o;
import com.tuya.smart.common.o0o00o00o0;
import com.tuya.smart.common.o0o00o0o0o;
import com.tuya.smart.common.o0o00o0ooo;
import com.tuya.smart.common.o0o00oo000;
import com.tuya.smart.common.o0o00oo00o;
import com.tuya.smart.common.o0o00oo0oo;
import com.tuya.smart.home.sdk.api.ITuyaDeviceActivator;
import com.tuya.smart.home.sdk.api.ITuyaHome;
import com.tuya.smart.home.sdk.api.ITuyaHomeDataManager;
import com.tuya.smart.home.sdk.api.ITuyaHomeDeviceShare;
import com.tuya.smart.home.sdk.api.ITuyaHomeManager;
import com.tuya.smart.home.sdk.api.ITuyaHomeMember;
import com.tuya.smart.home.sdk.api.ITuyaHomeScene;
import com.tuya.smart.home.sdk.api.ITuyaHomeSceneManager;
import com.tuya.smart.home.sdk.api.ITuyaHomeSpeech;
import com.tuya.smart.home.sdk.api.ITuyaRoom;
import com.tuya.smart.home.sdk.api.ITuyaServer;
import com.tuya.smart.home.sdk.callback.ITuyaSingleTransfer;
import com.tuya.smart.home.sdk.callback.ITuyaVoiceTransfer;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.INeedLoginListener;
import com.tuya.smart.sdk.api.ITuyaDevice;
import com.tuya.smart.sdk.api.ITuyaFeedback;
import com.tuya.smart.sdk.api.ITuyaGateway;
import com.tuya.smart.sdk.api.ITuyaGroup;
import com.tuya.smart.sdk.api.ITuyaMessage;
import com.tuya.smart.sdk.api.ITuyaOta;
import com.tuya.smart.sdk.api.ITuyaPush;
import com.tuya.smart.sdk.api.ITuyaSmartRequest;
import com.tuya.smart.sdk.api.ITuyaTimer;
import com.tuya.smart.sdk.api.ITuyaUser;
import com.tuya.smart.sdk.api.ITuyaZigbeeGroup;
import com.tuya.smart.sdk.api.bluemesh.IBlueMeshManager;
import com.tuya.smart.sdk.api.bluemesh.ISigMeshManager;

public class TuyaHomeSdk {
    public static final String TAG = "TuyaHomeSdk";
    public static final o0o000oooo mBlueMeshPlugin = ((o0o000oooo) Oo0.O000000o(o0o000oooo.class));
    public static final o0o00o000o mDeviceActivatorPlugin = ((o0o00o000o) Oo0.O000000o(o0o00o000o.class));
    public static final o0o00o00o0 mDeviceService = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class));
    public static final o0o00o0o0o mHomeService = ((o0o00o0o0o) Oo0.O000000o(o0o00o0o0o.class));
    public static final o0o00o0ooo mPersonalCenterService = ((o0o00o0ooo) Oo0.O000000o(o0o00o0ooo.class));
    public static final o0o00oo000 mScenePlugin = ((o0o00oo000) Oo0.O000000o(o0o00oo000.class));
    public static final o0o00o0000 mTuyaCameraPlugin = ((o0o00o0000) Oo0.O000000o(o0o00o0000.class));
    public static final o0o00oo00o mTuyaSweeperPlugin = ((o0o00oo00o) Oo0.O000000o(o0o00oo00o.class));
    public static final o0o00oo0oo mUserPlugin = ((o0o00oo0oo) Oo0.O000000o(o0o00oo0oo.class));

    public static ITuyaDeviceActivator getActivatorInstance() {
        o0o00o000o o0o00o000o = mDeviceActivatorPlugin;
        if (o0o00o000o == null) {
            return null;
        }
        return o0o00o000o.O000000o();
    }

    public static ITuyaHomeCamera getCameraInstance() {
        o0o00o0000 o0o00o0000 = mTuyaCameraPlugin;
        if (o0o00o0000 == null) {
            return null;
        }
        return o0o00o0000.O000000o();
    }

    public static ITuyaHomeDataManager getDataInstance() {
        o0o00o00o0 o0o00o00o0 = mDeviceService;
        if (o0o00o00o0 == null) {
            return null;
        }
        return o0o00o00o0.O0000OOo();
    }

    public static ITuyaHomeDeviceShare getDeviceShareInstance() {
        o0o00o0ooo o0o00o0ooo = mPersonalCenterService;
        if (o0o00o0ooo == null) {
            return null;
        }
        return o0o00o0ooo.O000000o();
    }

    public static ITuyaHomeManager getHomeManagerInstance() {
        o0o00o0o0o o0o00o0o0o = mHomeService;
        if (o0o00o0o0o == null) {
            return null;
        }
        return o0o00o0o0o.O000000o();
    }

    public static ITuyaHomeMember getMemberInstance() {
        o0o00o0o0o o0o00o0o0o = mHomeService;
        if (o0o00o0o0o == null) {
            return null;
        }
        return o0o00o0o0o.O00000Oo();
    }

    public static IBlueMeshManager getMeshInstance() {
        o0o000oooo o0o000oooo = mBlueMeshPlugin;
        if (o0o000oooo == null) {
            return null;
        }
        return o0o000oooo.O000000o();
    }

    public static ITuyaMessage getMessageInstance() {
        o0o00o0ooo o0o00o0ooo = mPersonalCenterService;
        if (o0o00o0ooo == null) {
            return null;
        }
        return o0o00o0ooo.O00000Oo();
    }

    public static ITuyaMqttChannel getMqttChannelInstance() {
        o0o00o00o0 o0o00o00o0 = mDeviceService;
        if (o0o00o00o0 == null) {
            return null;
        }
        return o0o00o00o0.O0000o0o();
    }

    public static ITuyaPush getPushInstance() {
        o0o00o0ooo o0o00o0ooo = mPersonalCenterService;
        if (o0o00o0ooo == null) {
            return null;
        }
        return o0o00o0ooo.O00000o0();
    }

    public static ITuyaSmartRequest getRequestInstance() {
        o0o00o00o0 o0o00o00o0 = mDeviceService;
        if (o0o00o00o0 == null) {
            return null;
        }
        return o0o00o00o0.O0000O0o();
    }

    public static ITuyaHomeSceneManager getSceneManagerInstance() {
        o0o00oo000 o0o00oo000 = mScenePlugin;
        if (o0o00oo000 == null) {
            return null;
        }
        return o0o00oo000.O000000o();
    }

    public static ITuyaServer getServerInstance() {
        o0o00o00o0 o0o00o00o0 = mDeviceService;
        if (o0o00o00o0 == null) {
            return null;
        }
        return o0o00o00o0.O00000oo();
    }

    public static ISigMeshManager getSigMeshInstance() {
        o0o000oooo o0o000oooo = mBlueMeshPlugin;
        if (o0o000oooo == null) {
            return null;
        }
        return o0o000oooo.O00000Oo();
    }

    public static ITuyaHomeSpeech getSpeechInstance() {
        o0o00o00o0 o0o00o00o0 = mDeviceService;
        if (o0o00o00o0 == null) {
            return null;
        }
        return o0o00o00o0.O0000Oo0();
    }

    public static ITuyaSweeper getSweeperInstance() {
        o0o00oo00o o0o00oo00o = mTuyaSweeperPlugin;
        if (o0o00oo00o == null) {
            return null;
        }
        return o0o00oo00o.O000000o();
    }

    public static ITuyaTimer getTimerManagerInstance() {
        o0o00o00o0 o0o00o00o0 = mDeviceService;
        if (o0o00o00o0 == null) {
            return null;
        }
        return o0o00o00o0.O00000o();
    }

    public static ITuyaSingleTransfer getTransferInstance() {
        o0o00o00o0 o0o00o00o0 = mDeviceService;
        if (o0o00o00o0 == null) {
            return null;
        }
        return o0o00o00o0.O00000oO();
    }

    public static ITuyaBlueMeshClient getTuyaBlueMeshClient() {
        o0o000oooo o0o000oooo = mBlueMeshPlugin;
        if (o0o000oooo == null) {
            return null;
        }
        return o0o000oooo.O00000oO();
    }

    public static ITuyaBlueMeshConfig getTuyaBlueMeshConfig() {
        o0o000oooo o0o000oooo = mBlueMeshPlugin;
        if (o0o000oooo == null) {
            return null;
        }
        return o0o000oooo.O0000O0o();
    }

    public static ITuyaFeedback getTuyaFeekback() {
        o0o00o0ooo o0o00o0ooo = mPersonalCenterService;
        if (o0o00o0ooo == null) {
            return null;
        }
        return o0o00o0ooo.O00000o();
    }

    public static ITuyaSigMeshClient getTuyaSigMeshClient() {
        o0o000oooo o0o000oooo = mBlueMeshPlugin;
        if (o0o000oooo == null) {
            return null;
        }
        return o0o000oooo.O00000oo();
    }

    public static ITuyaUser getUserInstance() {
        o0o00oo0oo o0o00oo0oo = mUserPlugin;
        if (o0o00oo0oo == null) {
            return null;
        }
        return o0o00oo0oo.O000000o();
    }

    public static ITuyaVoiceTransfer getVoiceTransferInstance() {
        o0o00o00o0 o0o00o00o0 = mDeviceService;
        if (o0o00o00o0 == null) {
            return null;
        }
        return o0o00o00o0.O0000Oo();
    }

    public static void init(Application application) {
        TuyaSdk.init(application);
    }

    public static void init(Application application, String str, String str2) {
        TuyaSdk.init(application, str, str2);
    }

    public static ITuyaBlueMeshDevice newBlueMeshDeviceInstance(String str) {
        o0o000oooo o0o000oooo = mBlueMeshPlugin;
        if (o0o000oooo == null) {
            return null;
        }
        return o0o000oooo.O000000o(str);
    }

    public static ITuyaBlueMeshGroup newBlueMeshGroupInstance(long j) {
        o0o000oooo o0o000oooo = mBlueMeshPlugin;
        if (o0o000oooo == null) {
            return null;
        }
        return o0o000oooo.O000000o(j);
    }

    public static ITuyaBlueMeshGroup newBlueMeshLocalGroupInstance(String str, String str2, String str3) {
        o0o000oooo o0o000oooo = mBlueMeshPlugin;
        if (o0o000oooo == null) {
            return null;
        }
        return o0o000oooo.O000000o(str, str2, str3);
    }

    public static ITuyaDevice newDeviceInstance(String str) {
        o0o00o00o0 o0o00o00o0 = mDeviceService;
        if (o0o00o00o0 == null) {
            return null;
        }
        return o0o00o00o0.O000000o(str);
    }

    public static ITuyaGateway newGatewayInstance(String str) {
        o0o00o00o0 o0o00o00o0 = mDeviceService;
        if (o0o00o00o0 == null) {
            return null;
        }
        return o0o00o00o0.O00000o0(str);
    }

    public static ITuyaGroup newGroupInstance(long j) {
        o0o00o00o0 o0o00o00o0 = mDeviceService;
        if (o0o00o00o0 == null) {
            return null;
        }
        return o0o00o00o0.O000000o(j);
    }

    public static ITuyaHome newHomeInstance(long j) {
        o0o00o0o0o o0o00o0o0o = mHomeService;
        if (o0o00o0o0o == null) {
            return null;
        }
        return o0o00o0o0o.O000000o(j);
    }

    public static ITuyaBlueMeshOta newMeshOtaManagerInstance(TuyaBlueMeshOtaBuilder tuyaBlueMeshOtaBuilder) {
        o0o000oooo o0o000oooo = mBlueMeshPlugin;
        if (o0o000oooo == null) {
            return null;
        }
        return o0o000oooo.O000000o(tuyaBlueMeshOtaBuilder);
    }

    public static ITuyaOta newOTAInstance(String str) {
        o0o00o00o0 o0o00o00o0 = mDeviceService;
        if (o0o00o00o0 == null) {
            return null;
        }
        return o0o00o00o0.O00000Oo(str);
    }

    public static ITuyaOta newOTAInstance(String str, String str2, String str3) {
        o0o00o00o0 o0o00o00o0 = mDeviceService;
        if (o0o00o00o0 == null) {
            return null;
        }
        return o0o00o00o0.O000000o(str, str2, str3);
    }

    public static ITuyaRoom newRoomInstance(long j) {
        o0o00o0o0o o0o00o0o0o = mHomeService;
        if (o0o00o0o0o == null) {
            return null;
        }
        return o0o00o0o0o.O00000Oo(j);
    }

    public static ITuyaHomeScene newSceneInstance(String str) {
        o0o00oo000 o0o00oo000 = mScenePlugin;
        if (o0o00oo000 == null) {
            return null;
        }
        return o0o00oo000.O000000o(str);
    }

    public static ITuyaBlueMeshDevice newSigMeshDeviceInstance(String str) {
        o0o000oooo o0o000oooo = mBlueMeshPlugin;
        if (o0o000oooo == null) {
            return null;
        }
        return o0o000oooo.O00000Oo(str);
    }

    public static ITuyaBlueMeshGroup newSigMeshGroupInstance(long j) {
        o0o000oooo o0o000oooo = mBlueMeshPlugin;
        if (o0o000oooo == null) {
            return null;
        }
        return o0o000oooo.O00000Oo(j);
    }

    public static ITuyaZigbeeGroup newZigbeeGroupInstance(long j) {
        o0o00o00o0 o0o00o00o0 = mDeviceService;
        if (o0o00o00o0 == null) {
            return null;
        }
        return o0o00o00o0.O00000Oo(j);
    }

    public static void onDestroy() {
        L.d(TAG, "onDestroy");
        o0o00o0o0o o0o00o0o0o = mHomeService;
        if (o0o00o0o0o != null) {
            o0o00o0o0o.O00000oo();
        }
        o0o00o00o0 o0o00o00o0 = mDeviceService;
        if (o0o00o00o0 != null) {
            o0o00o00o0.O00000o0();
        }
        o0o000oooo o0o000oooo = mBlueMeshPlugin;
        if (o0o000oooo != null) {
            o0o000oooo.O00000o0();
        }
        o0o00oo000 o0o00oo000 = mScenePlugin;
        if (o0o00oo000 != null) {
            o0o00oo000.O00000Oo();
        }
        ITuyaPush pushInstance = getPushInstance();
        if (pushInstance != null) {
            pushInstance.onDestroy();
        }
        o0o00oo00o o0o00oo00o = mTuyaSweeperPlugin;
        if (o0o00oo00o != null) {
            o0o00oo00o.O00000Oo();
        }
        TuyaSmartNetWork.cancelALlNetwork();
    }

    public static void setDebugMode(boolean z) {
        TuyaSdk.setDebugMode(z);
    }

    public static void setOnNeedLoginListener(INeedLoginListener iNeedLoginListener) {
        TuyaSdk.setOnNeedLoginListener(iNeedLoginListener);
    }
}
