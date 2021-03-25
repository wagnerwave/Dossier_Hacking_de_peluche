package com.tuya.smart.common;

import android.util.Log;
import com.tuya.sdk.eventbus.EventBusException;
import com.tuya.sdk.eventbus.ThreadMode;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class o00000000 {
    public static final String O000000o = "onEvent";
    public static final int O00000Oo = 64;
    public static final int O00000o = 5192;
    public static final int O00000o0 = 4096;
    public static final Map<String, List<oo000000>> O00000oO = new HashMap();
    public final Map<Class<?>, Class<?>> O00000oo = new ConcurrentHashMap();

    public o00000000(List<Class<?>> list) {
        if (list != null) {
            for (Class next : list) {
                this.O00000oo.put(next, next);
            }
        }
    }

    public static void O000000o() {
        synchronized (O00000oO) {
            O00000oO.clear();
        }
    }

    public List<oo000000> O000000o(Class<?> cls) {
        List<oo000000> list;
        ThreadMode threadMode;
        String name = cls.getName();
        synchronized (O00000oO) {
            list = O00000oO.get(name);
        }
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            String name2 = cls2.getName();
            if (name2.startsWith("java.") || name2.startsWith("javax.") || name2.startsWith("android.")) {
                break;
            }
            for (Method method : cls2.getDeclaredMethods()) {
                String name3 = method.getName();
                if (name3.startsWith(O000000o)) {
                    int modifiers = method.getModifiers();
                    if ((modifiers & 1) != 0 && (modifiers & O00000o) == 0) {
                        Class[] parameterTypes = method.getParameterTypes();
                        if (parameterTypes.length == 1) {
                            String substring = name3.substring(7);
                            if (substring.length() == 0) {
                                threadMode = ThreadMode.PostThread;
                            } else if (substring.equals("MainThread")) {
                                threadMode = ThreadMode.MainThread;
                            } else if (substring.equals("BackgroundThread")) {
                                threadMode = ThreadMode.BackgroundThread;
                            } else if (substring.equals("Async")) {
                                threadMode = ThreadMode.Async;
                            } else if (!this.O00000oo.containsKey(cls2)) {
                                throw new EventBusException("Illegal onEvent method, check for typos: " + method);
                            }
                            Class cls3 = parameterTypes[0];
                            sb.setLength(0);
                            sb.append(name3);
                            sb.append('>');
                            sb.append(cls3.getName());
                            if (hashSet.add(sb.toString())) {
                                arrayList.add(new oo000000(method, threadMode, cls3));
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.O00000oo.containsKey(cls2)) {
                        Log.d(oOOO00o0.O000000o, "Skipping method (not public, static or abstract): " + cls2 + "." + name3);
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            synchronized (O00000oO) {
                O00000oO.put(name, arrayList);
            }
            return arrayList;
        }
        throw new EventBusException("Subscriber " + cls + " has no public methods called " + O000000o);
    }
}
