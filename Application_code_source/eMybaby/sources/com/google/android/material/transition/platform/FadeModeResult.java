package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;

@RequiresApi(21)
public class FadeModeResult {
    public final int endAlpha;
    public final boolean endOnTop;
    public final int startAlpha;

    public FadeModeResult(int i, int i2, boolean z) {
        this.startAlpha = i;
        this.endAlpha = i2;
        this.endOnTop = z;
    }

    public static FadeModeResult endOnTop(int i, int i2) {
        return new FadeModeResult(i, i2, true);
    }

    public static FadeModeResult startOnTop(int i, int i2) {
        return new FadeModeResult(i, i2, false);
    }
}
