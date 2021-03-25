package a.d.a.a.h.g;

import a.d.a.a.f.a;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzae;
import java.util.Map;

public final class pd extends a implements nd {
    public pd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public final void beginAdUnitExposure(String str, long j) {
        Parcel e2 = e();
        e2.writeString(str);
        e2.writeLong(j);
        h(23, e2);
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        Parcel e2 = e();
        e2.writeString(str);
        e2.writeString(str2);
        u.c(e2, bundle);
        h(9, e2);
    }

    public final void clearMeasurementEnabled(long j) {
        Parcel e2 = e();
        e2.writeLong(j);
        h(43, e2);
    }

    public final void endAdUnitExposure(String str, long j) {
        Parcel e2 = e();
        e2.writeString(str);
        e2.writeLong(j);
        h(24, e2);
    }

    public final void generateEventId(od odVar) {
        Parcel e2 = e();
        u.b(e2, odVar);
        h(22, e2);
    }

    public final void getAppInstanceId(od odVar) {
        Parcel e2 = e();
        u.b(e2, odVar);
        h(20, e2);
    }

    public final void getCachedAppInstanceId(od odVar) {
        Parcel e2 = e();
        u.b(e2, odVar);
        h(19, e2);
    }

    public final void getConditionalUserProperties(String str, String str2, od odVar) {
        Parcel e2 = e();
        e2.writeString(str);
        e2.writeString(str2);
        u.b(e2, odVar);
        h(10, e2);
    }

    public final void getCurrentScreenClass(od odVar) {
        Parcel e2 = e();
        u.b(e2, odVar);
        h(17, e2);
    }

    public final void getCurrentScreenName(od odVar) {
        Parcel e2 = e();
        u.b(e2, odVar);
        h(16, e2);
    }

    public final void getGmpAppId(od odVar) {
        Parcel e2 = e();
        u.b(e2, odVar);
        h(21, e2);
    }

    public final void getMaxUserProperties(String str, od odVar) {
        Parcel e2 = e();
        e2.writeString(str);
        u.b(e2, odVar);
        h(6, e2);
    }

    public final void getTestFlag(od odVar, int i) {
        Parcel e2 = e();
        u.b(e2, odVar);
        e2.writeInt(i);
        h(38, e2);
    }

    public final void getUserProperties(String str, String str2, boolean z, od odVar) {
        Parcel e2 = e();
        e2.writeString(str);
        e2.writeString(str2);
        u.d(e2, z);
        u.b(e2, odVar);
        h(5, e2);
    }

    public final void initForTests(Map map) {
        Parcel e2 = e();
        e2.writeMap(map);
        h(37, e2);
    }

    public final void initialize(a aVar, zzae zzae, long j) {
        Parcel e2 = e();
        u.b(e2, aVar);
        u.c(e2, zzae);
        e2.writeLong(j);
        h(1, e2);
    }

    public final void isDataCollectionEnabled(od odVar) {
        Parcel e2 = e();
        u.b(e2, odVar);
        h(40, e2);
    }

    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        Parcel e2 = e();
        e2.writeString(str);
        e2.writeString(str2);
        u.c(e2, bundle);
        e2.writeInt(z ? 1 : 0);
        e2.writeInt(z2 ? 1 : 0);
        e2.writeLong(j);
        h(2, e2);
    }

    public final void logEventAndBundle(String str, String str2, Bundle bundle, od odVar, long j) {
        Parcel e2 = e();
        e2.writeString(str);
        e2.writeString(str2);
        u.c(e2, bundle);
        u.b(e2, odVar);
        e2.writeLong(j);
        h(3, e2);
    }

    public final void logHealthData(int i, String str, a aVar, a aVar2, a aVar3) {
        Parcel e2 = e();
        e2.writeInt(i);
        e2.writeString(str);
        u.b(e2, aVar);
        u.b(e2, aVar2);
        u.b(e2, aVar3);
        h(33, e2);
    }

    public final void onActivityCreated(a aVar, Bundle bundle, long j) {
        Parcel e2 = e();
        u.b(e2, aVar);
        u.c(e2, bundle);
        e2.writeLong(j);
        h(27, e2);
    }

    public final void onActivityDestroyed(a aVar, long j) {
        Parcel e2 = e();
        u.b(e2, aVar);
        e2.writeLong(j);
        h(28, e2);
    }

    public final void onActivityPaused(a aVar, long j) {
        Parcel e2 = e();
        u.b(e2, aVar);
        e2.writeLong(j);
        h(29, e2);
    }

    public final void onActivityResumed(a aVar, long j) {
        Parcel e2 = e();
        u.b(e2, aVar);
        e2.writeLong(j);
        h(30, e2);
    }

    public final void onActivitySaveInstanceState(a aVar, od odVar, long j) {
        Parcel e2 = e();
        u.b(e2, aVar);
        u.b(e2, odVar);
        e2.writeLong(j);
        h(31, e2);
    }

    public final void onActivityStarted(a aVar, long j) {
        Parcel e2 = e();
        u.b(e2, aVar);
        e2.writeLong(j);
        h(25, e2);
    }

    public final void onActivityStopped(a aVar, long j) {
        Parcel e2 = e();
        u.b(e2, aVar);
        e2.writeLong(j);
        h(26, e2);
    }

    public final void performAction(Bundle bundle, od odVar, long j) {
        Parcel e2 = e();
        u.c(e2, bundle);
        u.b(e2, odVar);
        e2.writeLong(j);
        h(32, e2);
    }

    public final void registerOnMeasurementEventListener(b bVar) {
        Parcel e2 = e();
        u.b(e2, bVar);
        h(35, e2);
    }

    public final void resetAnalyticsData(long j) {
        Parcel e2 = e();
        e2.writeLong(j);
        h(12, e2);
    }

    public final void setConditionalUserProperty(Bundle bundle, long j) {
        Parcel e2 = e();
        u.c(e2, bundle);
        e2.writeLong(j);
        h(8, e2);
    }

    public final void setConsent(Bundle bundle, long j) {
        Parcel e2 = e();
        u.c(e2, bundle);
        e2.writeLong(j);
        h(44, e2);
    }

    public final void setCurrentScreen(a aVar, String str, String str2, long j) {
        Parcel e2 = e();
        u.b(e2, aVar);
        e2.writeString(str);
        e2.writeString(str2);
        e2.writeLong(j);
        h(15, e2);
    }

    public final void setDataCollectionEnabled(boolean z) {
        Parcel e2 = e();
        u.d(e2, z);
        h(39, e2);
    }

    public final void setDefaultEventParameters(Bundle bundle) {
        Parcel e2 = e();
        u.c(e2, bundle);
        h(42, e2);
    }

    public final void setEventInterceptor(b bVar) {
        Parcel e2 = e();
        u.b(e2, bVar);
        h(34, e2);
    }

    public final void setInstanceIdProvider(c cVar) {
        Parcel e2 = e();
        u.b(e2, cVar);
        h(18, e2);
    }

    public final void setMeasurementEnabled(boolean z, long j) {
        Parcel e2 = e();
        u.d(e2, z);
        e2.writeLong(j);
        h(11, e2);
    }

    public final void setMinimumSessionDuration(long j) {
        Parcel e2 = e();
        e2.writeLong(j);
        h(13, e2);
    }

    public final void setSessionTimeoutDuration(long j) {
        Parcel e2 = e();
        e2.writeLong(j);
        h(14, e2);
    }

    public final void setUserId(String str, long j) {
        Parcel e2 = e();
        e2.writeString(str);
        e2.writeLong(j);
        h(7, e2);
    }

    public final void setUserProperty(String str, String str2, a aVar, boolean z, long j) {
        Parcel e2 = e();
        e2.writeString(str);
        e2.writeString(str2);
        u.b(e2, aVar);
        e2.writeInt(z ? 1 : 0);
        e2.writeLong(j);
        h(4, e2);
    }

    public final void unregisterOnMeasurementEventListener(b bVar) {
        Parcel e2 = e();
        u.b(e2, bVar);
        h(36, e2);
    }
}
