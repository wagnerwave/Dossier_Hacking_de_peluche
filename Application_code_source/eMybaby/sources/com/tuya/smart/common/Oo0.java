package com.tuya.smart.common;

import android.app.Application;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class Oo0 {
    public static String[] O000000o = {"com.tuya.sdk.mqtt.MqttBusinessPlugin", "com.tuya.sdk.home.HomePlugin", "com.tuya.sdk.device.DevicePlugin", "com.tuya.sdk.user.UserPlugin", "com.tuya.sdk.timer.TimerPlugin", "com.tuya.sdk.hardware.HardwareBusinessPlugin", "com.tuya.sdk.scene.ScenePlugin", "com.tuya.sdk.personal.PersonalPlugin", "com.tuya.sdk.config.ActivatorPlugin", "com.tuya.sdk.bluemesh.BlueMeshPlugin", "com.tuya.sdk.camera.CameraPlugin", "com.tuya.sdk.log.LogPlugin", "com.tuya.sdk.sweeper.SweeperPlugin"};
    public static final HashMap<Class, Object> O00000Oo = new HashMap<>(O000000o.length);

    public static abstract class O000000o {
        public static void registerService(Class cls, Object obj) {
            Oo0.O00000Oo.put(cls, obj);
        }

        public abstract void configure();

        public abstract void dependency();

        public <T> void dependsOn(T t) {
        }

        public abstract void execute();

        public abstract void initApplication(Application application);
    }

    static {
        O00000o0();
    }

    @Nullable
    public static <T> T O000000o(Class<T> cls) {
        return O00000Oo.get(cls);
    }

    public static void O000000o() {
        for (Map.Entry<Class, Object> value : O00000Oo.entrySet()) {
            ((O000000o) value.getValue()).execute();
        }
    }

    public static void O000000o(Application application) {
        for (String cls : O000000o) {
            try {
                ((O000000o) Class.forName(cls).newInstance()).initApplication(application);
                Log.d("TAGRouter", "loadRouter");
            } catch (ClassNotFoundException unused) {
            } catch (InstantiationException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public static void O00000o0() {
        for (String cls : O000000o) {
            try {
                ((O000000o) Class.forName(cls).newInstance()).configure();
            } catch (ClassNotFoundException unused) {
            } catch (InstantiationException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }
}
