package com.google.android.gms.measurement;

import a.c.a.f.b;
import a.d.a.a.e.q.c;
import a.d.a.a.i.b.a;
import a.d.a.a.i.b.c5;
import a.d.a.a.i.b.f6;
import a.d.a.a.i.b.f7;
import a.d.a.a.i.b.m7;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Deprecated
public class AppMeasurement {

    /* renamed from: d  reason: collision with root package name */
    public static volatile AppMeasurement f4262d;

    /* renamed from: a  reason: collision with root package name */
    public final c5 f4263a;

    /* renamed from: b  reason: collision with root package name */
    public final f7 f4264b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f4265c;

    public static class ConditionalUserProperty {
        @Keep
        public boolean mActive;
        @Keep
        public String mAppId;
        @Keep
        public long mCreationTimestamp;
        @Keep
        public String mExpiredEventName;
        @Keep
        public Bundle mExpiredEventParams;
        @Keep
        public String mName;
        @Keep
        public String mOrigin;
        @Keep
        public long mTimeToLive;
        @Keep
        public String mTimedOutEventName;
        @Keep
        public Bundle mTimedOutEventParams;
        @Keep
        public String mTriggerEventName;
        @Keep
        public long mTriggerTimeout;
        @Keep
        public String mTriggeredEventName;
        @Keep
        public Bundle mTriggeredEventParams;
        @Keep
        public long mTriggeredTimestamp;
        @Keep
        public Object mValue;

        public ConditionalUserProperty() {
        }

        public ConditionalUserProperty(@NonNull Bundle bundle) {
            Class cls = Long.class;
            Class cls2 = String.class;
            b.k(bundle);
            this.mAppId = (String) b.W0(bundle, "app_id", cls2, null);
            this.mOrigin = (String) b.W0(bundle, "origin", cls2, null);
            this.mName = (String) b.W0(bundle, "name", cls2, null);
            this.mValue = b.W0(bundle, "value", Object.class, null);
            this.mTriggerEventName = (String) b.W0(bundle, "trigger_event_name", cls2, null);
            this.mTriggerTimeout = ((Long) b.W0(bundle, "trigger_timeout", cls, 0L)).longValue();
            this.mTimedOutEventName = (String) b.W0(bundle, "timed_out_event_name", cls2, null);
            this.mTimedOutEventParams = (Bundle) b.W0(bundle, "timed_out_event_params", Bundle.class, null);
            this.mTriggeredEventName = (String) b.W0(bundle, "triggered_event_name", cls2, null);
            this.mTriggeredEventParams = (Bundle) b.W0(bundle, "triggered_event_params", Bundle.class, null);
            this.mTimeToLive = ((Long) b.W0(bundle, "time_to_live", cls, 0L)).longValue();
            this.mExpiredEventName = (String) b.W0(bundle, "expired_event_name", cls2, null);
            this.mExpiredEventParams = (Bundle) b.W0(bundle, "expired_event_params", Bundle.class, null);
            this.mActive = ((Boolean) b.W0(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
            this.mCreationTimestamp = ((Long) b.W0(bundle, "creation_timestamp", cls, 0L)).longValue();
            this.mTriggeredTimestamp = ((Long) b.W0(bundle, "triggered_timestamp", cls, 0L)).longValue();
        }

        public final Bundle a() {
            Bundle bundle = new Bundle();
            String str = this.mAppId;
            if (str != null) {
                bundle.putString("app_id", str);
            }
            String str2 = this.mOrigin;
            if (str2 != null) {
                bundle.putString("origin", str2);
            }
            String str3 = this.mName;
            if (str3 != null) {
                bundle.putString("name", str3);
            }
            Object obj = this.mValue;
            if (obj != null) {
                b.h1(bundle, obj);
            }
            String str4 = this.mTriggerEventName;
            if (str4 != null) {
                bundle.putString("trigger_event_name", str4);
            }
            bundle.putLong("trigger_timeout", this.mTriggerTimeout);
            String str5 = this.mTimedOutEventName;
            if (str5 != null) {
                bundle.putString("timed_out_event_name", str5);
            }
            Bundle bundle2 = this.mTimedOutEventParams;
            if (bundle2 != null) {
                bundle.putBundle("timed_out_event_params", bundle2);
            }
            String str6 = this.mTriggeredEventName;
            if (str6 != null) {
                bundle.putString("triggered_event_name", str6);
            }
            Bundle bundle3 = this.mTriggeredEventParams;
            if (bundle3 != null) {
                bundle.putBundle("triggered_event_params", bundle3);
            }
            bundle.putLong("time_to_live", this.mTimeToLive);
            String str7 = this.mExpiredEventName;
            if (str7 != null) {
                bundle.putString("expired_event_name", str7);
            }
            Bundle bundle4 = this.mExpiredEventParams;
            if (bundle4 != null) {
                bundle.putBundle("expired_event_params", bundle4);
            }
            bundle.putLong("creation_timestamp", this.mCreationTimestamp);
            bundle.putBoolean("active", this.mActive);
            bundle.putLong("triggered_timestamp", this.mTriggeredTimestamp);
            return bundle;
        }
    }

    public AppMeasurement(c5 c5Var) {
        b.k(c5Var);
        this.f4263a = c5Var;
        this.f4264b = null;
        this.f4265c = false;
    }

    public AppMeasurement(f7 f7Var) {
        b.k(f7Var);
        this.f4264b = f7Var;
        this.f4263a = null;
        this.f4265c = true;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    @androidx.annotation.RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @java.lang.Deprecated
    @androidx.annotation.Keep
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.measurement.AppMeasurement getInstance(android.content.Context r13) {
        /*
            com.google.android.gms.measurement.AppMeasurement r0 = f4262d
            if (r0 != 0) goto L_0x005c
            java.lang.Class<com.google.android.gms.measurement.AppMeasurement> r0 = com.google.android.gms.measurement.AppMeasurement.class
            monitor-enter(r0)
            com.google.android.gms.measurement.AppMeasurement r1 = f4262d     // Catch:{ all -> 0x0059 }
            if (r1 != 0) goto L_0x0057
            r1 = 0
            java.lang.String r2 = "com.google.firebase.analytics.FirebaseAnalytics"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x0032 }
            java.lang.String r3 = "getScionFrontendApiImplementation"
            r4 = 2
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{  }
            java.lang.Class<android.content.Context> r6 = android.content.Context.class
            r7 = 0
            r5[r7] = r6     // Catch:{  }
            java.lang.Class<android.os.Bundle> r6 = android.os.Bundle.class
            r8 = 1
            r5[r8] = r6     // Catch:{  }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r3, r5)     // Catch:{  }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{  }
            r3[r7] = r13     // Catch:{  }
            r3[r8] = r1     // Catch:{  }
            java.lang.Object r2 = r2.invoke(r1, r3)     // Catch:{  }
            a.d.a.a.i.b.f7 r2 = (a.d.a.a.i.b.f7) r2     // Catch:{  }
            goto L_0x0033
        L_0x0032:
            r2 = r1
        L_0x0033:
            if (r2 == 0) goto L_0x003d
            com.google.android.gms.measurement.AppMeasurement r13 = new com.google.android.gms.measurement.AppMeasurement     // Catch:{ all -> 0x0059 }
            r13.<init>((a.d.a.a.i.b.f7) r2)     // Catch:{ all -> 0x0059 }
            f4262d = r13     // Catch:{ all -> 0x0059 }
            goto L_0x0057
        L_0x003d:
            com.google.android.gms.internal.measurement.zzae r12 = new com.google.android.gms.internal.measurement.zzae     // Catch:{ all -> 0x0059 }
            r3 = 0
            r5 = 0
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r2 = r12
            r2.<init>(r3, r5, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0059 }
            a.d.a.a.i.b.c5 r13 = a.d.a.a.i.b.c5.a(r13, r12, r1)     // Catch:{ all -> 0x0059 }
            com.google.android.gms.measurement.AppMeasurement r1 = new com.google.android.gms.measurement.AppMeasurement     // Catch:{ all -> 0x0059 }
            r1.<init>((a.d.a.a.i.b.c5) r13)     // Catch:{ all -> 0x0059 }
            f4262d = r1     // Catch:{ all -> 0x0059 }
        L_0x0057:
            monitor-exit(r0)     // Catch:{ all -> 0x0059 }
            goto L_0x005c
        L_0x0059:
            r13 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0059 }
            throw r13
        L_0x005c:
            com.google.android.gms.measurement.AppMeasurement r13 = f4262d
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.AppMeasurement.getInstance(android.content.Context):com.google.android.gms.measurement.AppMeasurement");
    }

    @Keep
    public void beginAdUnitExposure(@Size(min = 1) @NonNull String str) {
        if (this.f4265c) {
            this.f4264b.g(str);
            return;
        }
        a A = this.f4263a.A();
        if (((c) this.f4263a.n) != null) {
            A.w(str, SystemClock.elapsedRealtime());
            return;
        }
        throw null;
    }

    @Keep
    public void clearConditionalUserProperty(@Size(max = 24, min = 1) @NonNull String str, @Nullable String str2, @Nullable Bundle bundle) {
        if (this.f4265c) {
            this.f4264b.l(str, str2, bundle);
        } else {
            this.f4263a.s().T((String) null, str, str2, bundle);
        }
    }

    @Keep
    public void clearConditionalUserPropertyAs(@Size(min = 1) @NonNull String str, @Size(max = 24, min = 1) @NonNull String str2, @Nullable String str3, @Nullable Bundle bundle) {
        if (!this.f4265c) {
            f6 s = this.f4263a.s();
            if (s != null) {
                b.h(str);
                s.l();
                throw null;
            }
            throw null;
        }
        throw new IllegalStateException("Unexpected call on client side");
    }

    @Keep
    public void endAdUnitExposure(@Size(min = 1) @NonNull String str) {
        if (this.f4265c) {
            this.f4264b.j(str);
            return;
        }
        a A = this.f4263a.A();
        if (((c) this.f4263a.n) != null) {
            A.z(str, SystemClock.elapsedRealtime());
            return;
        }
        throw null;
    }

    @Keep
    public long generateEventId() {
        return this.f4265c ? this.f4264b.e() : this.f4263a.t().u0();
    }

    @Keep
    @Nullable
    public String getAppInstanceId() {
        return this.f4265c ? this.f4264b.c() : this.f4263a.s().g.get();
    }

    @WorkerThread
    @Keep
    public List<ConditionalUserProperty> getConditionalUserProperties(@Nullable String str, @Size(max = 23, min = 1) @Nullable String str2) {
        List<Bundle> h = this.f4265c ? this.f4264b.h(str, str2) : this.f4263a.s().Q((String) null, str, str2);
        ArrayList arrayList = new ArrayList(h == null ? 0 : h.size());
        for (Bundle conditionalUserProperty : h) {
            arrayList.add(new ConditionalUserProperty(conditionalUserProperty));
        }
        return arrayList;
    }

    @WorkerThread
    @Keep
    public List<ConditionalUserProperty> getConditionalUserPropertiesAs(@Size(min = 1) @NonNull String str, @Nullable String str2, @Size(max = 23, min = 1) @Nullable String str3) {
        if (!this.f4265c) {
            f6 s = this.f4263a.s();
            if (s != null) {
                b.h(str);
                s.l();
                throw null;
            }
            throw null;
        }
        throw new IllegalStateException("Unexpected call on client side");
    }

    @Keep
    @Nullable
    public String getCurrentScreenClass() {
        if (this.f4265c) {
            return this.f4264b.b();
        }
        m7 m7Var = this.f4263a.s().f2563a.w().f2352c;
        if (m7Var != null) {
            return m7Var.f2377b;
        }
        return null;
    }

    @Keep
    @Nullable
    public String getCurrentScreenName() {
        if (this.f4265c) {
            return this.f4264b.a();
        }
        m7 m7Var = this.f4263a.s().f2563a.w().f2352c;
        if (m7Var != null) {
            return m7Var.f2376a;
        }
        return null;
    }

    @Keep
    @Nullable
    public String getGmpAppId() {
        return this.f4265c ? this.f4264b.d() : this.f4263a.s().O();
    }

    @WorkerThread
    @Keep
    public int getMaxUserProperties(@Size(min = 1) @NonNull String str) {
        if (this.f4265c) {
            return this.f4264b.i(str);
        }
        this.f4263a.s();
        b.h(str);
        return 25;
    }

    @WorkerThread
    @Keep
    public Map<String, Object> getUserProperties(@Nullable String str, @Size(max = 24, min = 1) @Nullable String str2, boolean z) {
        return this.f4265c ? this.f4264b.k(str, str2, z) : this.f4263a.s().R((String) null, str, str2, z);
    }

    @WorkerThread
    @Keep
    public Map<String, Object> getUserPropertiesAs(@Size(min = 1) @NonNull String str, @Nullable String str2, @Size(max = 23, min = 1) @Nullable String str3, boolean z) {
        if (!this.f4265c) {
            f6 s = this.f4263a.s();
            if (s != null) {
                b.h(str);
                s.l();
                throw null;
            }
            throw null;
        }
        throw new IllegalStateException("Unexpected call on client side");
    }

    @Keep
    public void logEventInternal(String str, String str2, Bundle bundle) {
        if (this.f4265c) {
            this.f4264b.m(str, str2, bundle);
        } else {
            this.f4263a.s().H(str, str2, bundle);
        }
    }

    @Keep
    public void setConditionalUserProperty(@NonNull ConditionalUserProperty conditionalUserProperty) {
        b.k(conditionalUserProperty);
        if (this.f4265c) {
            this.f4264b.f(conditionalUserProperty.a());
            return;
        }
        f6 s = this.f4263a.s();
        Bundle a2 = conditionalUserProperty.a();
        if (((c) s.f2563a.n) != null) {
            s.z(a2, System.currentTimeMillis());
            return;
        }
        throw null;
    }

    @Keep
    public void setConditionalUserPropertyAs(@NonNull ConditionalUserProperty conditionalUserProperty) {
        b.k(conditionalUserProperty);
        if (!this.f4265c) {
            f6 s = this.f4263a.s();
            Bundle a2 = conditionalUserProperty.a();
            if (s != null) {
                b.k(a2);
                b.h(a2.getString("app_id"));
                s.l();
                throw null;
            }
            throw null;
        }
        throw new IllegalStateException("Unexpected call on client side");
    }
}
