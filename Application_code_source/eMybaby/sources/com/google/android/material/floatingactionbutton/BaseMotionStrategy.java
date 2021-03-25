package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionSpec;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseMotionStrategy implements MotionStrategy {
    public final Context context;
    @Nullable
    public MotionSpec defaultMotionSpec;
    @NonNull
    public final ExtendedFloatingActionButton fab;
    public final ArrayList<Animator.AnimatorListener> listeners = new ArrayList<>();
    @Nullable
    public MotionSpec motionSpec;
    public final AnimatorTracker tracker;

    public BaseMotionStrategy(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton, AnimatorTracker animatorTracker) {
        this.fab = extendedFloatingActionButton;
        this.context = extendedFloatingActionButton.getContext();
        this.tracker = animatorTracker;
    }

    public final void addAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.listeners.add(animatorListener);
    }

    public AnimatorSet createAnimator() {
        return createAnimator(getCurrentMotionSpec());
    }

    @NonNull
    public AnimatorSet createAnimator(@NonNull MotionSpec motionSpec2) {
        ArrayList arrayList = new ArrayList();
        if (motionSpec2.hasPropertyValues("opacity")) {
            arrayList.add(motionSpec2.getAnimator("opacity", this.fab, View.ALPHA));
        }
        if (motionSpec2.hasPropertyValues("scale")) {
            arrayList.add(motionSpec2.getAnimator("scale", this.fab, View.SCALE_Y));
            arrayList.add(motionSpec2.getAnimator("scale", this.fab, View.SCALE_X));
        }
        if (motionSpec2.hasPropertyValues("width")) {
            arrayList.add(motionSpec2.getAnimator("width", this.fab, ExtendedFloatingActionButton.WIDTH));
        }
        if (motionSpec2.hasPropertyValues("height")) {
            arrayList.add(motionSpec2.getAnimator("height", this.fab, ExtendedFloatingActionButton.HEIGHT));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    public final MotionSpec getCurrentMotionSpec() {
        MotionSpec motionSpec2 = this.motionSpec;
        if (motionSpec2 != null) {
            return motionSpec2;
        }
        if (this.defaultMotionSpec == null) {
            this.defaultMotionSpec = MotionSpec.createFromResource(this.context, getDefaultMotionSpecResource());
        }
        return (MotionSpec) Preconditions.checkNotNull(this.defaultMotionSpec);
    }

    @NonNull
    public final List<Animator.AnimatorListener> getListeners() {
        return this.listeners;
    }

    @Nullable
    public MotionSpec getMotionSpec() {
        return this.motionSpec;
    }

    @CallSuper
    public void onAnimationCancel() {
        this.tracker.clear();
    }

    @CallSuper
    public void onAnimationEnd() {
        this.tracker.clear();
    }

    @CallSuper
    public void onAnimationStart(Animator animator) {
        this.tracker.onNextAnimationStart(animator);
    }

    public final void removeAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.listeners.remove(animatorListener);
    }

    public final void setMotionSpec(@Nullable MotionSpec motionSpec2) {
        this.motionSpec = motionSpec2;
    }
}
