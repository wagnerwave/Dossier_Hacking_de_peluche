package com.wnafee.vector.compat;

import android.graphics.Path;
import android.graphics.Rect;
import androidx.annotation.NonNull;

public final class Outline {
    public float mAlpha;
    public Path mPath;
    public float mRadius;
    public Rect mRect;

    public Outline() {
    }

    public Outline(@NonNull Outline outline) {
        set(outline);
    }

    public boolean canClip() {
        return !isEmpty() && this.mRect != null;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public boolean isEmpty() {
        return this.mRect == null && this.mPath == null;
    }

    public void set(@NonNull Outline outline) {
        if (outline.mPath != null) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            this.mPath.set(outline.mPath);
            this.mRect = null;
        }
        if (outline.mRect != null) {
            if (this.mRect == null) {
                this.mRect = new Rect();
            }
            this.mRect.set(outline.mRect);
        }
        this.mRadius = outline.mRadius;
        this.mAlpha = outline.mAlpha;
    }

    public void setAlpha(float f) {
        this.mAlpha = f;
    }

    public void setEmpty() {
        this.mPath = null;
        this.mRect = null;
        this.mRadius = 0.0f;
    }

    public void setRect(int i, int i2, int i3, int i4) {
        setRoundRect(i, i2, i3, i4, 0.0f);
    }

    public void setRect(@NonNull Rect rect) {
        setRect(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setRoundRect(int i, int i2, int i3, int i4, float f) {
        if (i >= i3 || i2 >= i4) {
            setEmpty();
            return;
        }
        if (this.mRect == null) {
            this.mRect = new Rect();
        }
        this.mRect.set(i, i2, i3, i4);
        this.mRadius = f;
        this.mPath = null;
    }

    public void setRoundRect(@NonNull Rect rect, float f) {
        setRoundRect(rect.left, rect.top, rect.right, rect.bottom, f);
    }
}
