package okhttp3.internal.cache;

import okio.Sink;

public interface CacheRequest {
    void abort();

    Sink body();
}
