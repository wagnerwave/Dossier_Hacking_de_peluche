package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(18)
public class ViewOverlayApi18 implements ViewOverlayImpl {
    public final ViewOverlay mViewOverlay;

    public ViewOverlayApi18(@NonNull View view) {
        this.mViewOverlay = view.getOverlay();
    }

    public void add(@NonNull Drawable drawable) {
        this.mViewOverlay.add(drawable);
    }

    public void remove(@NonNull Drawable drawable) {
        this.mViewOverlay.remove(drawable);
    }
}
