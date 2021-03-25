package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
public final class ScaleProvider implements VisibilityAnimatorProvider {
    public boolean growing;
    public float incomingEndScale;
    public float incomingStartScale;
    public float outgoingEndScale;
    public float outgoingStartScale;
    public boolean scaleOnDisappear;

    public ScaleProvider() {
        this(true);
    }

    public ScaleProvider(boolean z) {
        this.outgoingStartScale = 1.0f;
        this.outgoingEndScale = 1.1f;
        this.incomingStartScale = 0.8f;
        this.incomingEndScale = 1.0f;
        this.scaleOnDisappear = true;
        this.growing = z;
    }

    public static Animator createScaleAnimator(View view, float f, float f2) {
        return ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{f, f2}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{f, f2})});
    }

    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float f;
        float f2;
        if (this.growing) {
            f = this.incomingStartScale;
            f2 = this.incomingEndScale;
        } else {
            f = this.outgoingEndScale;
            f2 = this.outgoingStartScale;
        }
        return createScaleAnimator(view, f, f2);
    }

    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float f;
        float f2;
        if (!this.scaleOnDisappear) {
            return null;
        }
        if (this.growing) {
            f = this.outgoingStartScale;
            f2 = this.outgoingEndScale;
        } else {
            f = this.incomingEndScale;
            f2 = this.incomingStartScale;
        }
        return createScaleAnimator(view, f, f2);
    }

    public float getIncomingEndScale() {
        return this.incomingEndScale;
    }

    public float getIncomingStartScale() {
        return this.incomingStartScale;
    }

    public float getOutgoingEndScale() {
        return this.outgoingEndScale;
    }

    public float getOutgoingStartScale() {
        return this.outgoingStartScale;
    }

    public boolean isGrowing() {
        return this.growing;
    }

    public boolean isScaleOnDisappear() {
        return this.scaleOnDisappear;
    }

    public void setGrowing(boolean z) {
        this.growing = z;
    }

    public void setIncomingEndScale(float f) {
        this.incomingEndScale = f;
    }

    public void setIncomingStartScale(float f) {
        this.incomingStartScale = f;
    }

    public void setOutgoingEndScale(float f) {
        this.outgoingEndScale = f;
    }

    public void setOutgoingStartScale(float f) {
        this.outgoingStartScale = f;
    }

    public void setScaleOnDisappear(boolean z) {
        this.scaleOnDisappear = z;
    }
}
