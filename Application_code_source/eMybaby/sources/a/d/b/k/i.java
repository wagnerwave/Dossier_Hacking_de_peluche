package a.d.b.k;

import androidx.annotation.Nullable;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public static final long f2800a = TimeUnit.HOURS.toSeconds(1);

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f2801b = Pattern.compile("\\AA[\\w-]{38}\\z");

    public static boolean b(@Nullable String str) {
        return str.contains(":");
    }

    public long a() {
        return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }
}
