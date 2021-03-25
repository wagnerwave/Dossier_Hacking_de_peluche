package com.nineoldandroids.animation;

import a.a.a.a.a;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.nineoldandroids.animation.Animator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ValueAnimator extends Animator {
    public static final int ANIMATION_FRAME = 1;
    public static final int ANIMATION_START = 0;
    public static final long DEFAULT_FRAME_DELAY = 10;
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    public static final int RUNNING = 1;
    public static final int SEEKED = 2;
    public static final int STOPPED = 0;
    public static ThreadLocal<AnimationHandler> sAnimationHandler = new ThreadLocal<>();
    public static final ThreadLocal<ArrayList<ValueAnimator>> sAnimations = new ThreadLocal<ArrayList<ValueAnimator>>() {
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    };
    public static final Interpolator sDefaultInterpolator = new AccelerateDecelerateInterpolator();
    public static final ThreadLocal<ArrayList<ValueAnimator>> sDelayedAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    };
    public static final ThreadLocal<ArrayList<ValueAnimator>> sEndingAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    };
    public static final TypeEvaluator sFloatEvaluator = new FloatEvaluator();
    public static long sFrameDelay = 10;
    public static final TypeEvaluator sIntEvaluator = new IntEvaluator();
    public static final ThreadLocal<ArrayList<ValueAnimator>> sPendingAnimations = new ThreadLocal<ArrayList<ValueAnimator>>() {
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    };
    public static final ThreadLocal<ArrayList<ValueAnimator>> sReadyAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    };
    public float mCurrentFraction = 0.0f;
    public int mCurrentIteration = 0;
    public long mDelayStartTime;
    public long mDuration = 300;
    public boolean mInitialized = false;
    public Interpolator mInterpolator = sDefaultInterpolator;
    public boolean mPlayingBackwards = false;
    public int mPlayingState = 0;
    public int mRepeatCount = 0;
    public int mRepeatMode = 1;
    public boolean mRunning = false;
    public long mSeekTime = -1;
    public long mStartDelay = 0;
    public long mStartTime;
    public boolean mStarted = false;
    public boolean mStartedDelay = false;
    public ArrayList<AnimatorUpdateListener> mUpdateListeners = null;
    public PropertyValuesHolder[] mValues;
    public HashMap<String, PropertyValuesHolder> mValuesMap;

    public static class AnimationHandler extends Handler {
        public AnimationHandler() {
        }

        public void handleMessage(Message message) {
            boolean z;
            ArrayList arrayList = (ArrayList) ValueAnimator.sAnimations.get();
            ArrayList arrayList2 = (ArrayList) ValueAnimator.sDelayedAnims.get();
            int i = message.what;
            if (i == 0) {
                ArrayList arrayList3 = (ArrayList) ValueAnimator.sPendingAnimations.get();
                z = arrayList.size() <= 0 && arrayList2.size() <= 0;
                while (arrayList3.size() > 0) {
                    ArrayList arrayList4 = (ArrayList) arrayList3.clone();
                    arrayList3.clear();
                    int size = arrayList4.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ValueAnimator valueAnimator = (ValueAnimator) arrayList4.get(i2);
                        if (valueAnimator.mStartDelay == 0) {
                            valueAnimator.startAnimation();
                        } else {
                            arrayList2.add(valueAnimator);
                        }
                    }
                }
            } else if (i == 1) {
                z = true;
            } else {
                return;
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            ArrayList arrayList5 = (ArrayList) ValueAnimator.sReadyAnims.get();
            ArrayList arrayList6 = (ArrayList) ValueAnimator.sEndingAnims.get();
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ValueAnimator valueAnimator2 = (ValueAnimator) arrayList2.get(i3);
                if (valueAnimator2.delayedAnimationFrame(currentAnimationTimeMillis)) {
                    arrayList5.add(valueAnimator2);
                }
            }
            int size3 = arrayList5.size();
            if (size3 > 0) {
                for (int i4 = 0; i4 < size3; i4++) {
                    ValueAnimator valueAnimator3 = (ValueAnimator) arrayList5.get(i4);
                    valueAnimator3.startAnimation();
                    boolean unused = valueAnimator3.mRunning = true;
                    arrayList2.remove(valueAnimator3);
                }
                arrayList5.clear();
            }
            int size4 = arrayList.size();
            int i5 = 0;
            while (i5 < size4) {
                ValueAnimator valueAnimator4 = (ValueAnimator) arrayList.get(i5);
                if (valueAnimator4.animationFrame(currentAnimationTimeMillis)) {
                    arrayList6.add(valueAnimator4);
                }
                if (arrayList.size() == size4) {
                    i5++;
                } else {
                    size4--;
                    arrayList6.remove(valueAnimator4);
                }
            }
            if (arrayList6.size() > 0) {
                for (int i6 = 0; i6 < arrayList6.size(); i6++) {
                    ((ValueAnimator) arrayList6.get(i6)).endAnimation();
                }
                arrayList6.clear();
            }
            if (!z) {
                return;
            }
            if (!arrayList.isEmpty() || !arrayList2.isEmpty()) {
                sendEmptyMessageDelayed(1, Math.max(0, ValueAnimator.sFrameDelay - (AnimationUtils.currentAnimationTimeMillis() - currentAnimationTimeMillis)));
            }
        }
    }

    public interface AnimatorUpdateListener {
        void onAnimationUpdate(ValueAnimator valueAnimator);
    }

    public static void clearAllAnimations() {
        sAnimations.get().clear();
        sPendingAnimations.get().clear();
        sDelayedAnims.get().clear();
    }

    /* access modifiers changed from: private */
    public boolean delayedAnimationFrame(long j) {
        if (!this.mStartedDelay) {
            this.mStartedDelay = true;
            this.mDelayStartTime = j;
            return false;
        }
        long j2 = j - this.mDelayStartTime;
        long j3 = this.mStartDelay;
        if (j2 <= j3) {
            return false;
        }
        this.mStartTime = j - (j2 - j3);
        this.mPlayingState = 1;
        return true;
    }

    /* access modifiers changed from: private */
    public void endAnimation() {
        ArrayList<Animator.AnimatorListener> arrayList;
        sAnimations.get().remove(this);
        sPendingAnimations.get().remove(this);
        sDelayedAnims.get().remove(this);
        this.mPlayingState = 0;
        if (this.mRunning && (arrayList = this.mListeners) != null) {
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                ((Animator.AnimatorListener) arrayList2.get(i)).onAnimationEnd(this);
            }
        }
        this.mRunning = false;
        this.mStarted = false;
    }

    public static int getCurrentAnimationsCount() {
        return sAnimations.get().size();
    }

    public static long getFrameDelay() {
        return sFrameDelay;
    }

    public static ValueAnimator ofFloat(float... fArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(fArr);
        return valueAnimator;
    }

    public static ValueAnimator ofInt(int... iArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iArr);
        return valueAnimator;
    }

    public static ValueAnimator ofObject(TypeEvaluator typeEvaluator, Object... objArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setObjectValues(objArr);
        valueAnimator.setEvaluator(typeEvaluator);
        return valueAnimator;
    }

    public static ValueAnimator ofPropertyValuesHolder(PropertyValuesHolder... propertyValuesHolderArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setValues(propertyValuesHolderArr);
        return valueAnimator;
    }

    public static void setFrameDelay(long j) {
        sFrameDelay = j;
    }

    private void start(boolean z) {
        if (Looper.myLooper() != null) {
            this.mPlayingBackwards = z;
            this.mCurrentIteration = 0;
            this.mPlayingState = 0;
            this.mStarted = true;
            this.mStartedDelay = false;
            sPendingAnimations.get().add(this);
            if (this.mStartDelay == 0) {
                setCurrentPlayTime(getCurrentPlayTime());
                this.mPlayingState = 0;
                this.mRunning = true;
                ArrayList<Animator.AnimatorListener> arrayList = this.mListeners;
                if (arrayList != null) {
                    ArrayList arrayList2 = (ArrayList) arrayList.clone();
                    int size = arrayList2.size();
                    for (int i = 0; i < size; i++) {
                        ((Animator.AnimatorListener) arrayList2.get(i)).onAnimationStart(this);
                    }
                }
            }
            AnimationHandler animationHandler = sAnimationHandler.get();
            if (animationHandler == null) {
                animationHandler = new AnimationHandler();
                sAnimationHandler.set(animationHandler);
            }
            animationHandler.sendEmptyMessage(0);
            return;
        }
        throw new AndroidRuntimeException("Animators may only be run on Looper threads");
    }

    /* access modifiers changed from: private */
    public void startAnimation() {
        ArrayList<Animator.AnimatorListener> arrayList;
        initAnimation();
        sAnimations.get().add(this);
        if (this.mStartDelay > 0 && (arrayList = this.mListeners) != null) {
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                ((Animator.AnimatorListener) arrayList2.get(i)).onAnimationStart(this);
            }
        }
    }

    public void addUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        if (this.mUpdateListeners == null) {
            this.mUpdateListeners = new ArrayList<>();
        }
        this.mUpdateListeners.add(animatorUpdateListener);
    }

    public void animateValue(float f) {
        float interpolation = this.mInterpolator.getInterpolation(f);
        this.mCurrentFraction = interpolation;
        for (PropertyValuesHolder calculateValue : this.mValues) {
            calculateValue.calculateValue(interpolation);
        }
        ArrayList<AnimatorUpdateListener> arrayList = this.mUpdateListeners;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.mUpdateListeners.get(i).onAnimationUpdate(this);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean animationFrame(long r10) {
        /*
            r9 = this;
            int r0 = r9.mPlayingState
            r1 = 0
            r3 = 1
            if (r0 != 0) goto L_0x001a
            r9.mPlayingState = r3
            long r4 = r9.mSeekTime
            int r0 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0012
            r9.mStartTime = r10
            goto L_0x001a
        L_0x0012:
            long r4 = r10 - r4
            r9.mStartTime = r4
            r4 = -1
            r9.mSeekTime = r4
        L_0x001a:
            int r0 = r9.mPlayingState
            r4 = 2
            r5 = 0
            if (r0 == r3) goto L_0x0023
            if (r0 == r4) goto L_0x0023
            goto L_0x0082
        L_0x0023:
            long r6 = r9.mDuration
            r0 = 1065353216(0x3f800000, float:1.0)
            int r8 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r8 <= 0) goto L_0x0032
            long r1 = r9.mStartTime
            long r10 = r10 - r1
            float r10 = (float) r10
            float r11 = (float) r6
            float r10 = r10 / r11
            goto L_0x0034
        L_0x0032:
            r10 = 1065353216(0x3f800000, float:1.0)
        L_0x0034:
            int r11 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r11 < 0) goto L_0x0077
            int r11 = r9.mCurrentIteration
            int r1 = r9.mRepeatCount
            if (r11 < r1) goto L_0x0047
            r11 = -1
            if (r1 != r11) goto L_0x0042
            goto L_0x0047
        L_0x0042:
            float r10 = java.lang.Math.min(r10, r0)
            goto L_0x0078
        L_0x0047:
            java.util.ArrayList<com.nineoldandroids.animation.Animator$AnimatorListener> r11 = r9.mListeners
            if (r11 == 0) goto L_0x0060
            int r11 = r11.size()
            r1 = 0
        L_0x0050:
            if (r1 >= r11) goto L_0x0060
            java.util.ArrayList<com.nineoldandroids.animation.Animator$AnimatorListener> r2 = r9.mListeners
            java.lang.Object r2 = r2.get(r1)
            com.nineoldandroids.animation.Animator$AnimatorListener r2 = (com.nineoldandroids.animation.Animator.AnimatorListener) r2
            r2.onAnimationRepeat(r9)
            int r1 = r1 + 1
            goto L_0x0050
        L_0x0060:
            int r11 = r9.mRepeatMode
            if (r11 != r4) goto L_0x0069
            boolean r11 = r9.mPlayingBackwards
            r11 = r11 ^ r3
            r9.mPlayingBackwards = r11
        L_0x0069:
            int r11 = r9.mCurrentIteration
            int r1 = (int) r10
            int r11 = r11 + r1
            r9.mCurrentIteration = r11
            float r10 = r10 % r0
            long r1 = r9.mStartTime
            long r3 = r9.mDuration
            long r1 = r1 + r3
            r9.mStartTime = r1
        L_0x0077:
            r3 = 0
        L_0x0078:
            boolean r11 = r9.mPlayingBackwards
            if (r11 == 0) goto L_0x007e
            float r10 = r0 - r10
        L_0x007e:
            r9.animateValue(r10)
            r5 = r3
        L_0x0082:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nineoldandroids.animation.ValueAnimator.animationFrame(long):boolean");
    }

    public void cancel() {
        ArrayList<Animator.AnimatorListener> arrayList;
        if (this.mPlayingState != 0 || sPendingAnimations.get().contains(this) || sDelayedAnims.get().contains(this)) {
            if (this.mRunning && (arrayList = this.mListeners) != null) {
                Iterator it = ((ArrayList) arrayList.clone()).iterator();
                while (it.hasNext()) {
                    ((Animator.AnimatorListener) it.next()).onAnimationCancel(this);
                }
            }
            endAnimation();
        }
    }

    public ValueAnimator clone() {
        ValueAnimator valueAnimator = (ValueAnimator) super.clone();
        ArrayList<AnimatorUpdateListener> arrayList = this.mUpdateListeners;
        if (arrayList != null) {
            valueAnimator.mUpdateListeners = new ArrayList<>();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                valueAnimator.mUpdateListeners.add(arrayList.get(i));
            }
        }
        valueAnimator.mSeekTime = -1;
        valueAnimator.mPlayingBackwards = false;
        valueAnimator.mCurrentIteration = 0;
        valueAnimator.mInitialized = false;
        valueAnimator.mPlayingState = 0;
        valueAnimator.mStartedDelay = false;
        PropertyValuesHolder[] propertyValuesHolderArr = this.mValues;
        if (propertyValuesHolderArr != null) {
            int length = propertyValuesHolderArr.length;
            valueAnimator.mValues = new PropertyValuesHolder[length];
            valueAnimator.mValuesMap = new HashMap<>(length);
            for (int i2 = 0; i2 < length; i2++) {
                PropertyValuesHolder clone = propertyValuesHolderArr[i2].clone();
                valueAnimator.mValues[i2] = clone;
                valueAnimator.mValuesMap.put(clone.getPropertyName(), clone);
            }
        }
        return valueAnimator;
    }

    public void end() {
        if (!sAnimations.get().contains(this) && !sPendingAnimations.get().contains(this)) {
            this.mStartedDelay = false;
            startAnimation();
        } else if (!this.mInitialized) {
            initAnimation();
        }
        int i = this.mRepeatCount;
        animateValue((i <= 0 || (i & 1) != 1) ? 1.0f : 0.0f);
        endAnimation();
    }

    public float getAnimatedFraction() {
        return this.mCurrentFraction;
    }

    public Object getAnimatedValue() {
        PropertyValuesHolder[] propertyValuesHolderArr = this.mValues;
        if (propertyValuesHolderArr == null || propertyValuesHolderArr.length <= 0) {
            return null;
        }
        return propertyValuesHolderArr[0].getAnimatedValue();
    }

    public Object getAnimatedValue(String str) {
        PropertyValuesHolder propertyValuesHolder = this.mValuesMap.get(str);
        if (propertyValuesHolder != null) {
            return propertyValuesHolder.getAnimatedValue();
        }
        return null;
    }

    public long getCurrentPlayTime() {
        if (!this.mInitialized || this.mPlayingState == 0) {
            return 0;
        }
        return AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public int getRepeatCount() {
        return this.mRepeatCount;
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public PropertyValuesHolder[] getValues() {
        return this.mValues;
    }

    public void initAnimation() {
        if (!this.mInitialized) {
            for (PropertyValuesHolder init : this.mValues) {
                init.init();
            }
            this.mInitialized = true;
        }
    }

    public boolean isRunning() {
        return this.mPlayingState == 1 || this.mRunning;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    public void removeAllUpdateListeners() {
        ArrayList<AnimatorUpdateListener> arrayList = this.mUpdateListeners;
        if (arrayList != null) {
            arrayList.clear();
            this.mUpdateListeners = null;
        }
    }

    public void removeUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        ArrayList<AnimatorUpdateListener> arrayList = this.mUpdateListeners;
        if (arrayList != null) {
            arrayList.remove(animatorUpdateListener);
            if (this.mUpdateListeners.size() == 0) {
                this.mUpdateListeners = null;
            }
        }
    }

    public void reverse() {
        this.mPlayingBackwards = !this.mPlayingBackwards;
        if (this.mPlayingState == 1) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.mStartTime = currentAnimationTimeMillis - (this.mDuration - (currentAnimationTimeMillis - this.mStartTime));
            return;
        }
        start(true);
    }

    public void setCurrentPlayTime(long j) {
        initAnimation();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.mPlayingState != 1) {
            this.mSeekTime = j;
            this.mPlayingState = 2;
        }
        this.mStartTime = currentAnimationTimeMillis - j;
        animationFrame(currentAnimationTimeMillis);
    }

    public ValueAnimator setDuration(long j) {
        if (j >= 0) {
            this.mDuration = j;
            return this;
        }
        throw new IllegalArgumentException(a.i("Animators cannot have negative duration: ", j));
    }

    public void setEvaluator(TypeEvaluator typeEvaluator) {
        PropertyValuesHolder[] propertyValuesHolderArr;
        if (typeEvaluator != null && (propertyValuesHolderArr = this.mValues) != null && propertyValuesHolderArr.length > 0) {
            propertyValuesHolderArr[0].setEvaluator(typeEvaluator);
        }
    }

    public void setFloatValues(float... fArr) {
        if (fArr != null && fArr.length != 0) {
            PropertyValuesHolder[] propertyValuesHolderArr = this.mValues;
            if (propertyValuesHolderArr == null || propertyValuesHolderArr.length == 0) {
                setValues(PropertyValuesHolder.ofFloat("", fArr));
            } else {
                propertyValuesHolderArr[0].setFloatValues(fArr);
            }
            this.mInitialized = false;
        }
    }

    public void setIntValues(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            PropertyValuesHolder[] propertyValuesHolderArr = this.mValues;
            if (propertyValuesHolderArr == null || propertyValuesHolderArr.length == 0) {
                setValues(PropertyValuesHolder.ofInt("", iArr));
            } else {
                propertyValuesHolderArr[0].setIntValues(iArr);
            }
            this.mInitialized = false;
        }
    }

    public void setInterpolator(Interpolator interpolator) {
        if (interpolator == null) {
            interpolator = new LinearInterpolator();
        }
        this.mInterpolator = interpolator;
    }

    public void setObjectValues(Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            PropertyValuesHolder[] propertyValuesHolderArr = this.mValues;
            if (propertyValuesHolderArr == null || propertyValuesHolderArr.length == 0) {
                setValues(PropertyValuesHolder.ofObject("", (TypeEvaluator) null, objArr));
            } else {
                propertyValuesHolderArr[0].setObjectValues(objArr);
            }
            this.mInitialized = false;
        }
    }

    public void setRepeatCount(int i) {
        this.mRepeatCount = i;
    }

    public void setRepeatMode(int i) {
        this.mRepeatMode = i;
    }

    public void setStartDelay(long j) {
        this.mStartDelay = j;
    }

    public void setValues(PropertyValuesHolder... propertyValuesHolderArr) {
        this.mValues = propertyValuesHolderArr;
        this.mValuesMap = new HashMap<>(r0);
        for (PropertyValuesHolder propertyValuesHolder : propertyValuesHolderArr) {
            this.mValuesMap.put(propertyValuesHolder.getPropertyName(), propertyValuesHolder);
        }
        this.mInitialized = false;
    }

    public void start() {
        start(false);
    }

    public String toString() {
        StringBuilder n = a.n("ValueAnimator@");
        n.append(Integer.toHexString(hashCode()));
        String sb = n.toString();
        if (this.mValues != null) {
            for (PropertyValuesHolder propertyValuesHolder : this.mValues) {
                StringBuilder p = a.p(sb, "\n    ");
                p.append(propertyValuesHolder.toString());
                sb = p.toString();
            }
        }
        return sb;
    }
}
