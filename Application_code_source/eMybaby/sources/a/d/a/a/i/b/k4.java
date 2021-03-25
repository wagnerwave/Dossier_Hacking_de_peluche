package a.d.a.a.i.b;

import android.content.SharedPreferences;
import android.util.Pair;
import androidx.annotation.WorkerThread;

public final class k4 extends y5 {
    public static final Pair<String, Long> D = new Pair<>("", 0L);
    public final q4 A = new q4(this, "deferred_attribution_cache");
    public final o4 B = new o4(this, "deferred_attribution_cache_timestamp", 0);
    public final l4 C = new l4(this, "default_event_parameters");

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences f2315c;

    /* renamed from: d  reason: collision with root package name */
    public n4 f2316d;

    /* renamed from: e  reason: collision with root package name */
    public final o4 f2317e = new o4(this, "last_upload", 0);
    public final o4 f = new o4(this, "last_upload_attempt", 0);
    public final o4 g = new o4(this, "backoff", 0);
    public final o4 h = new o4(this, "last_delete_stale", 0);
    public final o4 i = new o4(this, "midnight_offset", 0);
    public final o4 j = new o4(this, "first_open_time", 0);
    public final o4 k = new o4(this, "app_install_time", 0);
    public final q4 l = new q4(this, "app_instance_id");
    public String m;
    public boolean n;
    public long o;
    public final o4 p = new o4(this, "time_before_start", 10000);
    public final o4 q = new o4(this, "session_timeout", 1800000);
    public final m4 r = new m4(this, "start_new_session", true);
    public final q4 s = new q4(this, "non_personalized_ads");
    public final m4 t = new m4(this, "allow_remote_dynamite", false);
    public final o4 u = new o4(this, "last_pause_time", 0);
    public boolean v;
    public m4 w = new m4(this, "app_backgrounded", false);
    public m4 x = new m4(this, "deep_link_retrieval_complete", false);
    public o4 y = new o4(this, "deep_link_retrieval_attempts", 0);
    public final q4 z = new q4(this, "firebase_feature_rollouts");

    public k4(c5 c5Var) {
        super(c5Var);
    }

    @WorkerThread
    public final void l() {
        SharedPreferences sharedPreferences = this.f2563a.f2123a.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f2315c = sharedPreferences;
        boolean z2 = sharedPreferences.getBoolean("has_been_opened", false);
        this.v = z2;
        if (!z2) {
            SharedPreferences.Editor edit = this.f2315c.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.f2316d = new n4(this, "health_monitor", Math.max(0, q.f2468c.a(null).longValue()), (j4) null);
    }

    public final boolean q() {
        return true;
    }

    @WorkerThread
    public final void s(Boolean bool) {
        b();
        SharedPreferences.Editor edit = v().edit();
        if (bool != null) {
            edit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            edit.remove("measurement_enabled");
        }
        edit.apply();
    }

    public final boolean t(long j2) {
        return j2 - this.q.a() > this.u.a();
    }

    @WorkerThread
    public final void u(boolean z2) {
        b();
        i().n.b("App measurement setting deferred collection", Boolean.valueOf(z2));
        SharedPreferences.Editor edit = v().edit();
        edit.putBoolean("deferred_analytics_collection", z2);
        edit.apply();
    }

    @WorkerThread
    public final SharedPreferences v() {
        b();
        n();
        return this.f2315c;
    }

    @WorkerThread
    public final Boolean w() {
        b();
        if (v().contains("measurement_enabled")) {
            return Boolean.valueOf(v().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    @WorkerThread
    public final e x() {
        b();
        return e.b(v().getString("consent_settings", "G1"));
    }
}
