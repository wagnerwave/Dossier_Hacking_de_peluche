package com.wnafee.vector.compat;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.wnafee.vector.R;
import com.wnafee.vector.compat.VectorDrawable;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class AnimatedVectorDrawable extends DrawableCompat implements Animatable, Tintable {
    public static final String ANIMATED_VECTOR = "animated-vector";
    public static final boolean DBG_ANIMATION_VECTOR_DRAWABLE = false;
    public static final String LOGTAG = AnimatedVectorDrawable.class.getSimpleName();
    public static final String TARGET = "target";
    public AnimatedVectorDrawableState mAnimatedVectorState;
    public boolean mMutated;

    public static class AnimatedVectorDrawableState extends Drawable.ConstantState {
        public ArrayList<Animator> mAnimators;
        public int mChangingConfigurations;
        public ArrayMap<Animator, String> mTargetNameMap;
        public VectorDrawable mVectorDrawable;

        public AnimatedVectorDrawableState(AnimatedVectorDrawableState animatedVectorDrawableState) {
            if (animatedVectorDrawableState != null) {
                this.mChangingConfigurations = animatedVectorDrawableState.mChangingConfigurations;
                VectorDrawable vectorDrawable = animatedVectorDrawableState.mVectorDrawable;
                if (vectorDrawable != null) {
                    VectorDrawable vectorDrawable2 = (VectorDrawable) vectorDrawable.getConstantState().newDrawable();
                    this.mVectorDrawable = vectorDrawable2;
                    vectorDrawable2.mutate();
                    this.mVectorDrawable.setAllowCaching(false);
                    this.mVectorDrawable.setBounds(animatedVectorDrawableState.mVectorDrawable.getBounds());
                }
                ArrayList<Animator> arrayList = animatedVectorDrawableState.mAnimators;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.mAnimators = new ArrayList<>(size);
                    this.mTargetNameMap = new ArrayMap<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = animatedVectorDrawableState.mAnimators.get(i);
                        Animator clone = animator.clone();
                        String str = animatedVectorDrawableState.mTargetNameMap.get(animator);
                        clone.setTarget(this.mVectorDrawable.getTargetByName(str));
                        this.mAnimators.add(clone);
                        this.mTargetNameMap.put(clone, str);
                    }
                    return;
                }
                return;
            }
            this.mVectorDrawable = new VectorDrawable();
        }

        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        public Drawable newDrawable() {
            return new AnimatedVectorDrawable(this, (Resources) null, (Resources.Theme) null);
        }

        public Drawable newDrawable(Resources resources) {
            return new AnimatedVectorDrawable(this, resources, (Resources.Theme) null);
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            return new AnimatedVectorDrawable(this, resources, theme);
        }
    }

    public AnimatedVectorDrawable() {
        this.mAnimatedVectorState = new AnimatedVectorDrawableState((AnimatedVectorDrawableState) null);
    }

    public AnimatedVectorDrawable(AnimatedVectorDrawableState animatedVectorDrawableState, Resources resources, Resources.Theme theme) {
        this.mAnimatedVectorState = new AnimatedVectorDrawableState(animatedVectorDrawableState);
        if (theme != null && canApplyTheme()) {
            applyTheme(theme);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000f A[LOOP:0: B:3:0x000f->B:6:0x001f, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean canReverse(android.animation.Animator r2) {
        /*
            boolean r0 = r2 instanceof android.animation.AnimatorSet
            r1 = 0
            if (r0 == 0) goto L_0x0022
            android.animation.AnimatorSet r2 = (android.animation.AnimatorSet) r2
            java.util.ArrayList r2 = r2.getChildAnimations()
            java.util.Iterator r2 = r2.iterator()
        L_0x000f:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r2.next()
            android.animation.Animator r0 = (android.animation.Animator) r0
            boolean r0 = canReverse(r0)
            if (r0 != 0) goto L_0x000f
            return r1
        L_0x0022:
            boolean r2 = r2 instanceof android.animation.ValueAnimator
            if (r2 == 0) goto L_0x0028
            r2 = 1
            return r2
        L_0x0028:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wnafee.vector.compat.AnimatedVectorDrawable.canReverse(android.animation.Animator):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038 A[Catch:{ IOException | XmlPullParserException -> 0x0040 }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017 A[Catch:{ IOException | XmlPullParserException -> 0x0040 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.wnafee.vector.compat.AnimatedVectorDrawable create(android.content.Context r7, android.content.res.Resources r8, int r9) {
        /*
            java.lang.String r0 = "parser error"
            android.content.res.XmlResourceParser r4 = r8.getXml(r9)     // Catch:{ XmlPullParserException -> 0x0042, IOException -> 0x0040 }
            android.util.AttributeSet r5 = android.util.Xml.asAttributeSet(r4)     // Catch:{ XmlPullParserException -> 0x0042, IOException -> 0x0040 }
        L_0x000a:
            int r9 = r4.next()     // Catch:{ XmlPullParserException -> 0x0042, IOException -> 0x0040 }
            r1 = 2
            if (r9 == r1) goto L_0x0015
            r2 = 1
            if (r9 == r2) goto L_0x0015
            goto L_0x000a
        L_0x0015:
            if (r9 != r1) goto L_0x0038
            java.lang.String r9 = "animated-vector"
            java.lang.String r1 = r4.getName()     // Catch:{ XmlPullParserException -> 0x0042, IOException -> 0x0040 }
            boolean r9 = r9.equals(r1)     // Catch:{ XmlPullParserException -> 0x0042, IOException -> 0x0040 }
            if (r9 == 0) goto L_0x0030
            com.wnafee.vector.compat.AnimatedVectorDrawable r9 = new com.wnafee.vector.compat.AnimatedVectorDrawable     // Catch:{ XmlPullParserException -> 0x0042, IOException -> 0x0040 }
            r9.<init>()     // Catch:{ XmlPullParserException -> 0x0042, IOException -> 0x0040 }
            r6 = 0
            r1 = r9
            r2 = r7
            r3 = r8
            r1.inflate(r2, r3, r4, r5, r6)     // Catch:{ XmlPullParserException -> 0x0042, IOException -> 0x0040 }
            return r9
        L_0x0030:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException     // Catch:{ XmlPullParserException -> 0x0042, IOException -> 0x0040 }
            java.lang.String r8 = "root node must start with: animated-vector"
            r7.<init>(r8)     // Catch:{ XmlPullParserException -> 0x0042, IOException -> 0x0040 }
            throw r7     // Catch:{ XmlPullParserException -> 0x0042, IOException -> 0x0040 }
        L_0x0038:
            org.xmlpull.v1.XmlPullParserException r7 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0042, IOException -> 0x0040 }
            java.lang.String r8 = "No start tag found"
            r7.<init>(r8)     // Catch:{ XmlPullParserException -> 0x0042, IOException -> 0x0040 }
            throw r7     // Catch:{ XmlPullParserException -> 0x0042, IOException -> 0x0040 }
        L_0x0040:
            r7 = move-exception
            goto L_0x0043
        L_0x0042:
            r7 = move-exception
        L_0x0043:
            java.lang.String r8 = LOGTAG
            android.util.Log.e(r8, r0, r7)
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wnafee.vector.compat.AnimatedVectorDrawable.create(android.content.Context, android.content.res.Resources, int):com.wnafee.vector.compat.AnimatedVectorDrawable");
    }

    public static AnimatedVectorDrawable getDrawable(Context context, int i) {
        return create(context, context.getResources(), i);
    }

    private boolean isStarted() {
        ArrayList<Animator> arrayList = this.mAnimatedVectorState.mAnimators;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).isStarted()) {
                return true;
            }
        }
        return false;
    }

    private void reverse(Animator animator) {
        if (animator instanceof AnimatorSet) {
            Iterator<Animator> it = ((AnimatorSet) animator).getChildAnimations().iterator();
            while (it.hasNext()) {
                reverse(it.next());
            }
        } else if (animator instanceof ValueAnimator) {
            ((ValueAnimator) animator).reverse();
        }
    }

    private void setupAnimatorsForTarget(String str, Animator animator) {
        animator.setTarget(this.mAnimatedVectorState.mVectorDrawable.getTargetByName(str));
        AnimatedVectorDrawableState animatedVectorDrawableState = this.mAnimatedVectorState;
        if (animatedVectorDrawableState.mAnimators == null) {
            animatedVectorDrawableState.mAnimators = new ArrayList<>();
            this.mAnimatedVectorState.mTargetNameMap = new ArrayMap<>();
        }
        this.mAnimatedVectorState.mAnimators.add(animator);
        this.mAnimatedVectorState.mTargetNameMap.put(animator, str);
    }

    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        VectorDrawable vectorDrawable = this.mAnimatedVectorState.mVectorDrawable;
        if (vectorDrawable != null && vectorDrawable.canApplyTheme()) {
            vectorDrawable.applyTheme(theme);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = (r0 = r1.mAnimatedVectorState).mVectorDrawable;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean canApplyTheme() {
        /*
            r1 = this;
            boolean r0 = super.canApplyTheme()
            if (r0 != 0) goto L_0x0017
            com.wnafee.vector.compat.AnimatedVectorDrawable$AnimatedVectorDrawableState r0 = r1.mAnimatedVectorState
            if (r0 == 0) goto L_0x0015
            com.wnafee.vector.compat.VectorDrawable r0 = r0.mVectorDrawable
            if (r0 == 0) goto L_0x0015
            boolean r0 = r0.canApplyTheme()
            if (r0 == 0) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r0 = 0
            goto L_0x0018
        L_0x0017:
            r0 = 1
        L_0x0018:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wnafee.vector.compat.AnimatedVectorDrawable.canApplyTheme():boolean");
    }

    public boolean canReverse() {
        ArrayList<Animator> arrayList = this.mAnimatedVectorState.mAnimators;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (!canReverse(arrayList.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void draw(Canvas canvas) {
        this.mAnimatedVectorState.mVectorDrawable.draw(canvas);
        if (isStarted()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.mAnimatedVectorState.mVectorDrawable.getAlpha();
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.mAnimatedVectorState.mChangingConfigurations;
    }

    public Drawable.ConstantState getConstantState() {
        this.mAnimatedVectorState.mChangingConfigurations = getChangingConfigurations();
        return this.mAnimatedVectorState;
    }

    public int getIntrinsicHeight() {
        return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicWidth();
    }

    public int getOpacity() {
        return this.mAnimatedVectorState.mVectorDrawable.getOpacity();
    }

    public void getOutline(@NonNull Outline outline) {
        this.mAnimatedVectorState.mVectorDrawable.getOutline(outline);
    }

    public Animator getPathAnimator(Context context, Resources resources, Resources.Theme theme, int i, float f) {
        return PathAnimatorInflater.loadAnimator(context, resources, theme, i, f);
    }

    public void inflate(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray obtainAttributes;
        int eventType = xmlPullParser.getEventType();
        float f = 1.0f;
        while (eventType != 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    obtainAttributes = DrawableCompat.obtainAttributes(resources, theme, attributeSet, R.styleable.AnimatedVectorDrawable);
                    int resourceId = obtainAttributes.getResourceId(R.styleable.AnimatedVectorDrawable_android_drawable, 0);
                    if (resourceId != 0) {
                        VectorDrawable vectorDrawable = (VectorDrawable) VectorDrawable.create(resources, resourceId).mutate();
                        vectorDrawable.setAllowCaching(false);
                        f = vectorDrawable.getPixelSize();
                        this.mAnimatedVectorState.mVectorDrawable = vectorDrawable;
                    }
                } else if ("target".equals(name)) {
                    obtainAttributes = DrawableCompat.obtainAttributes(resources, theme, attributeSet, R.styleable.AnimatedVectorDrawableTarget);
                    String string = obtainAttributes.getString(R.styleable.AnimatedVectorDrawableTarget_android_name);
                    int resourceId2 = obtainAttributes.getResourceId(R.styleable.AnimatedVectorDrawableTarget_android_animation, 0);
                    if (resourceId2 != 0) {
                        setupAnimatorsForTarget(string, isPath(string) ? getPathAnimator(context, resources, theme, resourceId2, f) : AnimatorInflater.loadAnimator(context, resourceId2));
                    }
                }
                obtainAttributes.recycle();
            }
            eventType = xmlPullParser.next();
        }
    }

    public boolean isPath(String str) {
        return this.mAnimatedVectorState.mVectorDrawable.getTargetByName(str) instanceof VectorDrawable.VFullPath;
    }

    public boolean isRunning() {
        ArrayList<Animator> arrayList = this.mAnimatedVectorState.mAnimators;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).isRunning()) {
                return true;
            }
        }
        return false;
    }

    public boolean isStateful() {
        return this.mAnimatedVectorState.mVectorDrawable.isStateful();
    }

    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mAnimatedVectorState.mVectorDrawable.mutate();
            this.mMutated = true;
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        this.mAnimatedVectorState.mVectorDrawable.setBounds(rect);
    }

    public boolean onLevelChange(int i) {
        return this.mAnimatedVectorState.mVectorDrawable.setLevel(i);
    }

    public boolean onStateChange(int[] iArr) {
        return this.mAnimatedVectorState.mVectorDrawable.setState(iArr);
    }

    public void reverse() {
        ArrayList<Animator> arrayList = this.mAnimatedVectorState.mAnimators;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animator animator = arrayList.get(i);
            if (canReverse(animator)) {
                reverse(animator);
            } else {
                Log.w(LOGTAG, "AnimatedVectorDrawable can't reverse()");
            }
        }
    }

    public void setAlpha(int i) {
        this.mAnimatedVectorState.mVectorDrawable.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mAnimatedVectorState.mVectorDrawable.setColorFilter(colorFilter);
    }

    public void setHotspot(float f, float f2) {
        this.mAnimatedVectorState.mVectorDrawable.setHotspot(f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.mAnimatedVectorState.mVectorDrawable.setHotspotBounds(i, i2, i3, i4);
    }

    public void setLayoutDirection(int i) {
        this.mAnimatedVectorState.mVectorDrawable.setLayoutDirection(i);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.mAnimatedVectorState.mVectorDrawable.setTintList(colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.mAnimatedVectorState.mVectorDrawable.setTintMode(mode);
    }

    public boolean setVisible(boolean z, boolean z2) {
        this.mAnimatedVectorState.mVectorDrawable.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public void start() {
        ArrayList<Animator> arrayList = this.mAnimatedVectorState.mAnimators;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animator animator = arrayList.get(i);
            if (!animator.isStarted()) {
                animator.start();
            }
        }
        invalidateSelf();
    }

    public void stop() {
        ArrayList<Animator> arrayList = this.mAnimatedVectorState.mAnimators;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.get(i).end();
        }
    }
}
