package androidx.transition;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

public interface ViewOverlayImpl {
    void add(@NonNull Drawable drawable);

    void remove(@NonNull Drawable drawable);
}
