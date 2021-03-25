package com.google.android.gms.measurement.internal;

import a.d.a.a.h.g.c;
import a.d.a.a.h.g.md;
import a.d.a.a.h.g.od;
import a.d.a.a.h.g.u9;
import a.d.a.a.i.b.a6;
import a.d.a.a.i.b.a7;
import a.d.a.a.i.b.c5;
import a.d.a.a.i.b.d6;
import a.d.a.a.i.b.d7;
import a.d.a.a.i.b.e;
import a.d.a.a.i.b.e6;
import a.d.a.a.i.b.e7;
import a.d.a.a.i.b.f6;
import a.d.a.a.i.b.i6;
import a.d.a.a.i.b.k6;
import a.d.a.a.i.b.l6;
import a.d.a.a.i.b.l7;
import a.d.a.a.i.b.m6;
import a.d.a.a.i.b.m7;
import a.d.a.a.i.b.p6;
import a.d.a.a.i.b.q;
import a.d.a.a.i.b.r6;
import a.d.a.a.i.b.t6;
import a.d.a.a.i.b.v9;
import a.d.a.a.i.b.w6;
import a.d.a.a.i.b.x6;
import a.d.a.a.i.b.y6;
import a.d.a.a.i.b.y7;
import a.d.a.a.i.b.y9;
import a.d.a.a.i.b.z3;
import a.d.a.a.i.b.z6;
import a.d.a.a.i.b.z8;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.appcompat.widget.TooltipCompatHandler;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.measurement.zzae;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@DynamiteApi
public class AppMeasurementDynamiteService extends md {

    /* renamed from: a  reason: collision with root package name */
    public c5 f4269a = null;

    /* renamed from: b  reason: collision with root package name */
    public Map<Integer, d6> f4270b = new ArrayMap();

    public class a implements d6 {

        /* renamed from: a  reason: collision with root package name */
        public a.d.a.a.h.g.b f4271a;

        public a(a.d.a.a.h.g.b bVar) {
            this.f4271a = bVar;
        }

        public final void a(String str, String str2, Bundle bundle, long j) {
            try {
                this.f4271a.q(str, str2, bundle, j);
            } catch (RemoteException e2) {
                AppMeasurementDynamiteService.this.f4269a.i().i.b("Event listener threw exception", e2);
            }
        }
    }

    public class b implements e6 {

        /* renamed from: a  reason: collision with root package name */
        public a.d.a.a.h.g.b f4273a;

        public b(a.d.a.a.h.g.b bVar) {
            this.f4273a = bVar;
        }
    }

    public void beginAdUnitExposure(String str, long j) {
        g();
        this.f4269a.A().w(str, j);
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        g();
        this.f4269a.s().T((String) null, str, str2, bundle);
    }

    public void clearMeasurementEnabled(long j) {
        g();
        f6 s = this.f4269a.s();
        s.u();
        s.f().v(new y6(s, (Boolean) null));
    }

    public void endAdUnitExposure(String str, long j) {
        g();
        this.f4269a.A().z(str, j);
    }

    public final void g() {
        if (this.f4269a == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    public void generateEventId(od odVar) {
        g();
        this.f4269a.t().K(odVar, this.f4269a.t().u0());
    }

    public void getAppInstanceId(od odVar) {
        g();
        this.f4269a.f().v(new a6(this, odVar));
    }

    public void getCachedAppInstanceId(od odVar) {
        g();
        this.f4269a.t().M(odVar, this.f4269a.s().g.get());
    }

    public void getConditionalUserProperties(String str, String str2, od odVar) {
        g();
        this.f4269a.f().v(new y9(this, odVar, str, str2));
    }

    public void getCurrentScreenClass(od odVar) {
        g();
        m7 m7Var = this.f4269a.s().f2563a.w().f2352c;
        this.f4269a.t().M(odVar, m7Var != null ? m7Var.f2377b : null);
    }

    public void getCurrentScreenName(od odVar) {
        g();
        m7 m7Var = this.f4269a.s().f2563a.w().f2352c;
        this.f4269a.t().M(odVar, m7Var != null ? m7Var.f2376a : null);
    }

    public void getGmpAppId(od odVar) {
        g();
        this.f4269a.t().M(odVar, this.f4269a.s().O());
    }

    public void getMaxUserProperties(String str, od odVar) {
        g();
        this.f4269a.s();
        a.c.a.f.b.h(str);
        this.f4269a.t().J(odVar, 25);
    }

    public void getTestFlag(od odVar, int i) {
        g();
        if (i == 0) {
            v9 t = this.f4269a.t();
            f6 s = this.f4269a.s();
            if (s != null) {
                AtomicReference atomicReference = new AtomicReference();
                t.M(odVar, (String) s.f().s(atomicReference, TooltipCompatHandler.HOVER_HIDE_TIMEOUT_MS, "String test flag value", new t6(s, atomicReference)));
                return;
            }
            throw null;
        } else if (i == 1) {
            v9 t2 = this.f4269a.t();
            f6 s2 = this.f4269a.s();
            if (s2 != null) {
                AtomicReference atomicReference2 = new AtomicReference();
                t2.K(odVar, ((Long) s2.f().s(atomicReference2, TooltipCompatHandler.HOVER_HIDE_TIMEOUT_MS, "long test flag value", new x6(s2, atomicReference2))).longValue());
                return;
            }
            throw null;
        } else if (i == 2) {
            v9 t3 = this.f4269a.t();
            f6 s3 = this.f4269a.s();
            if (s3 != null) {
                AtomicReference atomicReference3 = new AtomicReference();
                double doubleValue = ((Double) s3.f().s(atomicReference3, TooltipCompatHandler.HOVER_HIDE_TIMEOUT_MS, "double test flag value", new z6(s3, atomicReference3))).doubleValue();
                Bundle bundle = new Bundle();
                bundle.putDouble("r", doubleValue);
                try {
                    odVar.f(bundle);
                } catch (RemoteException e2) {
                    t3.f2563a.i().i.b("Error returning double value to wrapper", e2);
                }
            } else {
                throw null;
            }
        } else if (i == 3) {
            v9 t4 = this.f4269a.t();
            f6 s4 = this.f4269a.s();
            if (s4 != null) {
                AtomicReference atomicReference4 = new AtomicReference();
                t4.J(odVar, ((Integer) s4.f().s(atomicReference4, TooltipCompatHandler.HOVER_HIDE_TIMEOUT_MS, "int test flag value", new w6(s4, atomicReference4))).intValue());
                return;
            }
            throw null;
        } else if (i == 4) {
            v9 t5 = this.f4269a.t();
            f6 s5 = this.f4269a.s();
            if (s5 != null) {
                AtomicReference atomicReference5 = new AtomicReference();
                t5.O(odVar, ((Boolean) s5.f().s(atomicReference5, TooltipCompatHandler.HOVER_HIDE_TIMEOUT_MS, "boolean test flag value", new k6(s5, atomicReference5))).booleanValue());
                return;
            }
            throw null;
        }
    }

    public void getUserProperties(String str, String str2, boolean z, od odVar) {
        g();
        this.f4269a.f().v(new a7(this, odVar, str, str2, z));
    }

    public void initForTests(Map map) {
        g();
    }

    public void initialize(a.d.a.a.f.a aVar, zzae zzae, long j) {
        Context context = (Context) a.d.a.a.f.b.h(aVar);
        c5 c5Var = this.f4269a;
        if (c5Var == null) {
            this.f4269a = c5.a(context, zzae, Long.valueOf(j));
        } else {
            c5Var.i().i.a("Attempting to initialize multiple times");
        }
    }

    public void isDataCollectionEnabled(od odVar) {
        g();
        this.f4269a.f().v(new z8(this, odVar));
    }

    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        g();
        this.f4269a.s().I(str, str2, bundle, z, z2, j);
    }

    public void logEventAndBundle(String str, String str2, Bundle bundle, od odVar, long j) {
        Bundle bundle2;
        g();
        a.c.a.f.b.h(str2);
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        bundle2.putString("_o", "app");
        this.f4269a.f().v(new y7(this, odVar, new zzar(str2, new zzam(bundle), "app", j), str));
    }

    public void logHealthData(int i, String str, a.d.a.a.f.a aVar, a.d.a.a.f.a aVar2, a.d.a.a.f.a aVar3) {
        g();
        Object obj = null;
        Object h = aVar == null ? null : a.d.a.a.f.b.h(aVar);
        Object h2 = aVar2 == null ? null : a.d.a.a.f.b.h(aVar2);
        if (aVar3 != null) {
            obj = a.d.a.a.f.b.h(aVar3);
        }
        this.f4269a.i().w(i, true, false, str, h, h2, obj);
    }

    public void onActivityCreated(a.d.a.a.f.a aVar, Bundle bundle, long j) {
        g();
        d7 d7Var = this.f4269a.s().f2193c;
        if (d7Var != null) {
            this.f4269a.s().M();
            d7Var.onActivityCreated((Activity) a.d.a.a.f.b.h(aVar), bundle);
        }
    }

    public void onActivityDestroyed(a.d.a.a.f.a aVar, long j) {
        g();
        d7 d7Var = this.f4269a.s().f2193c;
        if (d7Var != null) {
            this.f4269a.s().M();
            d7Var.onActivityDestroyed((Activity) a.d.a.a.f.b.h(aVar));
        }
    }

    public void onActivityPaused(a.d.a.a.f.a aVar, long j) {
        g();
        d7 d7Var = this.f4269a.s().f2193c;
        if (d7Var != null) {
            this.f4269a.s().M();
            d7Var.onActivityPaused((Activity) a.d.a.a.f.b.h(aVar));
        }
    }

    public void onActivityResumed(a.d.a.a.f.a aVar, long j) {
        g();
        d7 d7Var = this.f4269a.s().f2193c;
        if (d7Var != null) {
            this.f4269a.s().M();
            d7Var.onActivityResumed((Activity) a.d.a.a.f.b.h(aVar));
        }
    }

    public void onActivitySaveInstanceState(a.d.a.a.f.a aVar, od odVar, long j) {
        g();
        d7 d7Var = this.f4269a.s().f2193c;
        Bundle bundle = new Bundle();
        if (d7Var != null) {
            this.f4269a.s().M();
            d7Var.onActivitySaveInstanceState((Activity) a.d.a.a.f.b.h(aVar), bundle);
        }
        try {
            odVar.f(bundle);
        } catch (RemoteException e2) {
            this.f4269a.i().i.b("Error returning bundle value to wrapper", e2);
        }
    }

    public void onActivityStarted(a.d.a.a.f.a aVar, long j) {
        g();
        if (this.f4269a.s().f2193c != null) {
            this.f4269a.s().M();
            Activity activity = (Activity) a.d.a.a.f.b.h(aVar);
        }
    }

    public void onActivityStopped(a.d.a.a.f.a aVar, long j) {
        g();
        if (this.f4269a.s().f2193c != null) {
            this.f4269a.s().M();
            Activity activity = (Activity) a.d.a.a.f.b.h(aVar);
        }
    }

    public void performAction(Bundle bundle, od odVar, long j) {
        g();
        odVar.f((Bundle) null);
    }

    public void registerOnMeasurementEventListener(a.d.a.a.h.g.b bVar) {
        g();
        Object obj = this.f4270b.get(Integer.valueOf(bVar.a()));
        if (obj == null) {
            obj = new a(bVar);
            this.f4270b.put(Integer.valueOf(bVar.a()), obj);
        }
        f6 s = this.f4269a.s();
        s.u();
        a.c.a.f.b.k(obj);
        if (!s.f2195e.add(obj)) {
            s.i().i.a("OnEventListener already registered");
        }
    }

    public void resetAnalyticsData(long j) {
        g();
        f6 s = this.f4269a.s();
        s.g.set((Object) null);
        s.f().v(new p6(s, j));
    }

    public void setConditionalUserProperty(Bundle bundle, long j) {
        g();
        if (bundle == null) {
            this.f4269a.i().f.a("Conditional user property must not be null");
        } else {
            this.f4269a.s().z(bundle, j);
        }
    }

    public void setConsent(Bundle bundle, long j) {
        g();
        f6 s = this.f4269a.s();
        if (u9.b()) {
            String str = null;
            if (s.f2563a.g.t((String) null, q.P0)) {
                s.u();
                String string = bundle.getString("ad_storage");
                if ((string != null && e.i(string) == null) || ((string = bundle.getString("analytics_storage")) != null && e.i(string) == null)) {
                    str = string;
                }
                if (str != null) {
                    s.i().k.b("Ignoring invalid consent setting", str);
                    s.i().k.a("Valid consent values are 'granted', 'denied'");
                }
                s.B(e.g(bundle), 10, j);
            }
        }
    }

    public void setCurrentScreen(a.d.a.a.f.a aVar, String str, String str2, long j) {
        z3 z3Var;
        Integer valueOf;
        String str3;
        z3 z3Var2;
        String str4;
        g();
        l7 w = this.f4269a.w();
        Activity activity = (Activity) a.d.a.a.f.b.h(aVar);
        if (!w.f2563a.g.y().booleanValue()) {
            z3Var2 = w.i().k;
            str4 = "setCurrentScreen cannot be called while screen reporting is disabled.";
        } else if (w.f2352c == null) {
            z3Var2 = w.i().k;
            str4 = "setCurrentScreen cannot be called while no activity active";
        } else if (w.f.get(activity) == null) {
            z3Var2 = w.i().k;
            str4 = "setCurrentScreen must be called with an activity in the activity lifecycle";
        } else {
            if (str2 == null) {
                str2 = l7.z(activity.getClass().getCanonicalName());
            }
            boolean r0 = v9.r0(w.f2352c.f2377b, str2);
            boolean r02 = v9.r0(w.f2352c.f2376a, str);
            if (!r0 || !r02) {
                if (str != null && (str.length() <= 0 || str.length() > 100)) {
                    z3Var = w.i().k;
                    valueOf = Integer.valueOf(str.length());
                    str3 = "Invalid screen name length in setCurrentScreen. Length";
                } else if (str2 == null || (str2.length() > 0 && str2.length() <= 100)) {
                    w.i().n.c("Setting current screen to name, class", str == null ? "null" : str, str2);
                    m7 m7Var = new m7(str, str2, w.e().u0());
                    w.f.put(activity, m7Var);
                    w.B(activity, m7Var, true);
                    return;
                } else {
                    z3Var = w.i().k;
                    valueOf = Integer.valueOf(str2.length());
                    str3 = "Invalid class name length in setCurrentScreen. Length";
                }
                z3Var.b(str3, valueOf);
                return;
            }
            z3Var2 = w.i().k;
            str4 = "setCurrentScreen cannot be called with the same class and name";
        }
        z3Var2.a(str4);
    }

    public void setDataCollectionEnabled(boolean z) {
        g();
        f6 s = this.f4269a.s();
        s.u();
        s.f().v(new e7(s, z));
    }

    public void setDefaultEventParameters(Bundle bundle) {
        g();
        f6 s = this.f4269a.s();
        s.f().v(new i6(s, bundle == null ? null : new Bundle(bundle)));
    }

    public void setEventInterceptor(a.d.a.a.h.g.b bVar) {
        g();
        f6 s = this.f4269a.s();
        b bVar2 = new b(bVar);
        s.u();
        s.f().v(new r6(s, bVar2));
    }

    public void setInstanceIdProvider(c cVar) {
        g();
    }

    public void setMeasurementEnabled(boolean z, long j) {
        g();
        f6 s = this.f4269a.s();
        Boolean valueOf = Boolean.valueOf(z);
        s.u();
        s.f().v(new y6(s, valueOf));
    }

    public void setMinimumSessionDuration(long j) {
        g();
        f6 s = this.f4269a.s();
        s.f().v(new m6(s, j));
    }

    public void setSessionTimeoutDuration(long j) {
        g();
        f6 s = this.f4269a.s();
        s.f().v(new l6(s, j));
    }

    public void setUserId(String str, long j) {
        g();
        this.f4269a.s().L((String) null, "_id", str, true, j);
    }

    public void setUserProperty(String str, String str2, a.d.a.a.f.a aVar, boolean z, long j) {
        g();
        this.f4269a.s().L(str, str2, a.d.a.a.f.b.h(aVar), z, j);
    }

    public void unregisterOnMeasurementEventListener(a.d.a.a.h.g.b bVar) {
        g();
        Object remove = this.f4270b.remove(Integer.valueOf(bVar.a()));
        if (remove == null) {
            remove = new a(bVar);
        }
        f6 s = this.f4269a.s();
        s.u();
        a.c.a.f.b.k(remove);
        if (!s.f2195e.remove(remove)) {
            s.i().i.a("OnEventListener had not been registered");
        }
    }
}
