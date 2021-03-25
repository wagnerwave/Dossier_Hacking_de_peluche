package com.tuya.smart.android.network.stat;

import com.tuya.smart.android.network.api.IApiEvent;
import java.util.ArrayList;

public class ApiEvent {
    public static volatile ArrayList<IApiEvent> apiEvents = new ArrayList<>();
    public static volatile ArrayList<IApiEvent> dnsStatEvents = new ArrayList<>();

    public static synchronized ArrayList<IApiEvent> getApiEvents() {
        ArrayList<IApiEvent> arrayList;
        synchronized (ApiEvent.class) {
            arrayList = apiEvents;
        }
        return arrayList;
    }

    public static synchronized ArrayList<IApiEvent> getDnsStatEvents() {
        ArrayList<IApiEvent> arrayList;
        synchronized (ApiEvent.class) {
            arrayList = dnsStatEvents;
        }
        return arrayList;
    }

    public static synchronized void registerApiEvent(IApiEvent iApiEvent) {
        synchronized (ApiEvent.class) {
            apiEvents.add(iApiEvent);
        }
    }

    public static synchronized void registerDNSStatEvent(IApiEvent iApiEvent) {
        synchronized (ApiEvent.class) {
            dnsStatEvents.add(iApiEvent);
        }
    }

    public static synchronized void unRegisterApiEvent(IApiEvent iApiEvent) {
        synchronized (ApiEvent.class) {
            apiEvents.remove(iApiEvent);
        }
    }

    public static synchronized void unRegisterDNSStatEvent(IApiEvent iApiEvent) {
        synchronized (ApiEvent.class) {
            dnsStatEvents.remove(iApiEvent);
        }
    }
}
