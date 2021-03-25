package androidx.core.database;

import android.database.CursorWindow;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class CursorWindowCompat {
    @NonNull
    public static CursorWindow create(@Nullable String str, long j) {
        return Build.VERSION.SDK_INT >= 28 ? new CursorWindow(str, j) : new CursorWindow(str);
    }
}
