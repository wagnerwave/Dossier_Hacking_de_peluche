package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;

@RequiresApi(21)
public class FitModeResult {
    public final float currentEndHeight;
    public final float currentEndWidth;
    public final float currentStartHeight;
    public final float currentStartWidth;
    public final float endScale;
    public final float startScale;

    public FitModeResult(float f, float f2, float f3, float f4, float f5, float f6) {
        this.startScale = f;
        this.endScale = f2;
        this.currentStartWidth = f3;
        this.currentStartHeight = f4;
        this.currentEndWidth = f5;
        this.currentEndHeight = f6;
    }
}
