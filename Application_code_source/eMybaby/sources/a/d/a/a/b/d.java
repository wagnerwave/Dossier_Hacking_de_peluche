package a.d.a.a.b;

import android.net.Uri;
import android.util.LogPrinter;

public final class d {
    static {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("uri");
        builder.authority("local");
        builder.build();
    }

    public d() {
        new LogPrinter(4, "GA/LogCatTransport");
    }
}
