package a.d.a.a.h.f;

import androidx.core.util.TimeUtils;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.internal.ws.RealWebSocket;

public final class i0 {
    public static j0<Long> A = j0.b("analytics.monitoring.sample_period_millis", 86400000, 86400000);
    public static j0<Long> B = j0.b("analytics.initialization_warning_threshold", 5000, 5000);
    public static j0<Boolean> C = j0.d("analytics.gcm_task_service", false, false);

    /* renamed from: a  reason: collision with root package name */
    public static j0<Boolean> f1510a = j0.d("analytics.service_client_enabled", true, true);

    /* renamed from: b  reason: collision with root package name */
    public static j0<String> f1511b = j0.c("analytics.log_tag", "GAv4", "GAv4-SVC");

    /* renamed from: c  reason: collision with root package name */
    public static j0<Long> f1512c = j0.b("analytics.local_dispatch_millis", 1800000, 120000);

    /* renamed from: d  reason: collision with root package name */
    public static j0<Long> f1513d = j0.b("analytics.initial_local_dispatch_millis", 5000, 5000);

    /* renamed from: e  reason: collision with root package name */
    public static j0<Long> f1514e = j0.b("analytics.dispatch_alarm_millis", 7200000, 7200000);
    public static j0<Long> f = j0.b("analytics.max_dispatch_alarm_millis", 32400000, 32400000);
    public static j0<Integer> g = j0.a("analytics.max_hits_per_dispatch", 20, 20);
    public static j0<Integer> h = j0.a("analytics.max_hits_per_batch", 20, 20);
    public static j0<String> i = j0.c("analytics.insecure_host", "http://www.google-analytics.com", "http://www.google-analytics.com");
    public static j0<String> j = j0.c("analytics.secure_host", "https://ssl.google-analytics.com", "https://ssl.google-analytics.com");
    public static j0<String> k = j0.c("analytics.simple_endpoint", "/collect", "/collect");
    public static j0<String> l = j0.c("analytics.batching_endpoint", "/batch", "/batch");
    public static j0<Integer> m = j0.a("analytics.max_get_length", 2036, 2036);
    public static j0<String> n = j0.c("analytics.batching_strategy.k", "zzye", "zzye");
    public static j0<String> o = j0.c("analytics.compression_strategy.k", "zzyl", "zzyl");
    public static j0<Integer> p = j0.a("analytics.max_hit_length.k", 8192, 8192);
    public static j0<Integer> q = j0.a("analytics.max_post_length.k", 8192, 8192);
    public static j0<Integer> r = j0.a("analytics.max_batch_post_length", 8192, 8192);
    public static j0<String> s = j0.c("analytics.fallback_responses.k", "404,502", "404,502");
    public static j0<Integer> t = j0.a("analytics.batch_retry_interval.seconds.k", TimeUtils.SECONDS_PER_HOUR, TimeUtils.SECONDS_PER_HOUR);
    public static j0<Integer> u = j0.a("analytics.http_connection.connect_timeout_millis", 60000, 60000);
    public static j0<Integer> v = j0.a("analytics.http_connection.read_timeout_millis", 61000, 61000);
    public static j0<Boolean> w = j0.d("analytics.test.disable_receiver", false, false);
    public static j0<Long> x = j0.b("analytics.service_client.idle_disconnect_millis", 10000, 10000);
    public static j0<Long> y = j0.b("analytics.service_client.connect_timeout_millis", 5000, 5000);
    public static j0<Long> z = j0.b("analytics.service_client.reconnect_throttle_millis", 1800000, 1800000);

    static {
        j0.d("analytics.service_enabled", false, false);
        j0.b("analytics.max_tokens", 60, 60);
        j0.a("analytics.max_stored_hits", RecyclerView.MAX_SCROLL_DURATION, 20000);
        j0.a("analytics.max_stored_hits_per_app", RecyclerView.MAX_SCROLL_DURATION, RecyclerView.MAX_SCROLL_DURATION);
        j0.a("analytics.max_stored_properties_per_app", 100, 100);
        j0.b("analytics.min_local_dispatch_millis", 120000, 120000);
        j0.b("analytics.max_local_dispatch_millis", 7200000, 7200000);
        j0.a("analytics.max_hits_per_request.k", 20, 20);
        j0.b("analytics.service_monitor_interval", 86400000, 86400000);
        j0.b("analytics.campaigns.time_limit", 86400000, 86400000);
        j0.c("analytics.first_party_experiment_id", "", "");
        j0.a("analytics.first_party_experiment_variant", 0, 0);
        j0.b("analytics.service_client.second_connect_delay_millis", 5000, 5000);
        j0.b("analytics.service_client.unexpected_reconnect_millis", RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS, RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS);
    }
}
