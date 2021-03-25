package a.d.a.a.h.g;

import a.d.a.a.f.a;
import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.internal.measurement.zzae;
import java.util.Map;

public interface nd extends IInterface {
    void beginAdUnitExposure(String str, long j);

    void clearConditionalUserProperty(String str, String str2, Bundle bundle);

    void clearMeasurementEnabled(long j);

    void endAdUnitExposure(String str, long j);

    void generateEventId(od odVar);

    void getAppInstanceId(od odVar);

    void getCachedAppInstanceId(od odVar);

    void getConditionalUserProperties(String str, String str2, od odVar);

    void getCurrentScreenClass(od odVar);

    void getCurrentScreenName(od odVar);

    void getGmpAppId(od odVar);

    void getMaxUserProperties(String str, od odVar);

    void getTestFlag(od odVar, int i);

    void getUserProperties(String str, String str2, boolean z, od odVar);

    void initForTests(Map map);

    void initialize(a aVar, zzae zzae, long j);

    void isDataCollectionEnabled(od odVar);

    void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j);

    void logEventAndBundle(String str, String str2, Bundle bundle, od odVar, long j);

    void logHealthData(int i, String str, a aVar, a aVar2, a aVar3);

    void onActivityCreated(a aVar, Bundle bundle, long j);

    void onActivityDestroyed(a aVar, long j);

    void onActivityPaused(a aVar, long j);

    void onActivityResumed(a aVar, long j);

    void onActivitySaveInstanceState(a aVar, od odVar, long j);

    void onActivityStarted(a aVar, long j);

    void onActivityStopped(a aVar, long j);

    void performAction(Bundle bundle, od odVar, long j);

    void registerOnMeasurementEventListener(b bVar);

    void resetAnalyticsData(long j);

    void setConditionalUserProperty(Bundle bundle, long j);

    void setConsent(Bundle bundle, long j);

    void setCurrentScreen(a aVar, String str, String str2, long j);

    void setDataCollectionEnabled(boolean z);

    void setDefaultEventParameters(Bundle bundle);

    void setEventInterceptor(b bVar);

    void setInstanceIdProvider(c cVar);

    void setMeasurementEnabled(boolean z, long j);

    void setMinimumSessionDuration(long j);

    void setSessionTimeoutDuration(long j);

    void setUserId(String str, long j);

    void setUserProperty(String str, String str2, a aVar, boolean z, long j);

    void unregisterOnMeasurementEventListener(b bVar);
}
