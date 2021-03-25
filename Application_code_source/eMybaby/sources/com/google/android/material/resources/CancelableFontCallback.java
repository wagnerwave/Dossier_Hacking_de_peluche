package com.google.android.material.resources;

import android.graphics.Typeface;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class CancelableFontCallback extends TextAppearanceFontCallback {
    public final ApplyFont applyFont;
    public boolean cancelled;
    public final Typeface fallbackFont;

    public interface ApplyFont {
        void apply(Typeface typeface);
    }

    public CancelableFontCallback(ApplyFont applyFont2, Typeface typeface) {
        this.fallbackFont = typeface;
        this.applyFont = applyFont2;
    }

    private void updateIfNotCancelled(Typeface typeface) {
        if (!this.cancelled) {
            this.applyFont.apply(typeface);
        }
    }

    public void cancel() {
        this.cancelled = true;
    }

    public void onFontRetrievalFailed(int i) {
        updateIfNotCancelled(this.fallbackFont);
    }

    public void onFontRetrieved(Typeface typeface, boolean z) {
        updateIfNotCancelled(typeface);
    }
}
