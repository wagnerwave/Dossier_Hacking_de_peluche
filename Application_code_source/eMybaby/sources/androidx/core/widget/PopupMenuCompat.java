package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.PopupMenu;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class PopupMenuCompat {
    @Nullable
    public static View.OnTouchListener getDragToOpenListener(@NonNull Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            return ((PopupMenu) obj).getDragToOpenListener();
        }
        return null;
    }
}
