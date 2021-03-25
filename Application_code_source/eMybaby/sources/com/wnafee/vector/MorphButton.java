package com.wnafee.vector;

import a.a.a.a.a;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.wnafee.vector.compat.DrawableCompat;
import com.wnafee.vector.compat.ResourcesCompat;
import com.wnafee.vector.compat.Tintable;

public class MorphButton extends CompoundButton {
    public static final String TAG = MorphButton.class.getSimpleName();
    public static final Matrix.ScaleToFit[] sS2FArray = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    public boolean mAdjustViewBounds;
    public boolean mAdjustViewBoundsCompat;
    public TintInfo mBackgroundTint;
    public boolean mCropToPadding;
    public Drawable mCurrentDrawable;
    public int mCurrentDrawableHeight;
    public int mCurrentDrawableWidth;
    public Matrix mDrawMatrix;
    public boolean mEndCanMorph;
    public Drawable mEndDrawable;
    public int mEndDrawableHeight;
    public int mEndDrawableWidth;
    public TintInfo mForegroundTint;
    public boolean mHasStarted;
    public boolean mHaveFrame;
    public boolean mIsToggling;
    public Matrix mMatrix;
    public ScaleType mScaleType;
    public boolean mStartCanMorph;
    public Drawable mStartDrawable;
    public int mStartDrawableHeight;
    public int mStartDrawableWidth;
    public MorphState mState;
    public OnStateChangedListener mStateListener;
    public RectF mTempDst;
    public RectF mTempSrc;

    public enum MorphState {
        START,
        END
    }

    public interface OnStateChangedListener {
        void onStateChanged(MorphState morphState, boolean z);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public MorphState state;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.state = (MorphState) parcel.readValue((ClassLoader) null);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder n = a.n("MorphButton.SavedState{");
            n.append(Integer.toHexString(System.identityHashCode(this)));
            n.append(" state=");
            n.append(this.state);
            n.append("}");
            return n.toString();
        }

        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(this.state);
        }
    }

    public enum ScaleType {
        MATRIX(0),
        FIT_XY(1),
        FIT_START(2),
        FIT_CENTER(3),
        FIT_END(4),
        CENTER(5),
        CENTER_CROP(6),
        CENTER_INSIDE(7);
        
        public final int nativeInt;

        /* access modifiers changed from: public */
        ScaleType(int i) {
            this.nativeInt = i;
        }
    }

    public static class TintInfo {
        public boolean mHasTintList;
        public boolean mHasTintMode;
        public ColorStateList mTintList;
        public PorterDuff.Mode mTintMode;

        public TintInfo() {
        }
    }

    public MorphButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public MorphButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.morphButtonStyle);
    }

    @TargetApi(21)
    public MorphButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = MorphState.START;
        this.mStartDrawable = null;
        this.mEndDrawable = null;
        this.mStartCanMorph = false;
        this.mEndCanMorph = false;
        this.mIsToggling = false;
        this.mHasStarted = false;
        this.mCropToPadding = false;
        this.mAdjustViewBounds = false;
        this.mAdjustViewBoundsCompat = Build.VERSION.SDK_INT <= 17;
        this.mHaveFrame = false;
        this.mDrawMatrix = null;
        this.mTempSrc = new RectF();
        this.mTempDst = new RectF();
        initMorphButton();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.MorphButton, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.MorphButton_vc_startDrawable, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.MorphButton_vc_endDrawable, -1);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.MorphButton_vc_autoStartAnimation, false);
        int i2 = obtainStyledAttributes.getInt(R.styleable.MorphButton_android_scaleType, -1);
        if (i2 >= 0) {
            setScaleType(getScaleTypeFromInt(i2));
        }
        readTintAttributes(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        applyBackgroundTint();
        setClickable(true);
        setStartDrawable(resourceId, false);
        setEndDrawable(resourceId2, false);
        setState(this.mState);
        if (z) {
            this.mHasStarted = true;
            setState(MorphState.END, true);
        }
    }

    private void applyBackgroundTint() {
        applyTint(getBackground(), this.mBackgroundTint);
    }

    private void applyForegroundTint() {
        applyTint(this.mStartDrawable, this.mForegroundTint);
        applyTint(this.mEndDrawable, this.mForegroundTint);
    }

    private void applyForegroundTint(Drawable drawable) {
        applyTint(drawable, this.mForegroundTint);
    }

    @TargetApi(21)
    private void applyTint(Drawable drawable, TintInfo tintInfo) {
        if (drawable != null && tintInfo != null) {
            if (ResourcesCompat.LOLLIPOP) {
                if (tintInfo.mHasTintList || tintInfo.mHasTintMode) {
                    Drawable mutate = drawable.mutate();
                    if (tintInfo.mHasTintList) {
                        mutate.setTintList(tintInfo.mTintList);
                    }
                    if (tintInfo.mHasTintMode) {
                        mutate.setTintMode(tintInfo.mTintMode);
                    }
                }
            } else if (drawable instanceof Tintable) {
                if (tintInfo.mHasTintList || tintInfo.mHasTintMode) {
                    Tintable tintable = (Tintable) drawable.mutate();
                    if (tintInfo.mHasTintList) {
                        tintable.setTintList(tintInfo.mTintList);
                    }
                    if (tintInfo.mHasTintMode) {
                        tintable.setTintMode(tintInfo.mTintMode);
                    }
                }
            } else if (tintInfo.mHasTintList) {
                setDrawableColorFilter(drawable, tintInfo.mTintList.getColorForState(getDrawableState(), 0), PorterDuff.Mode.SRC_IN);
            }
        }
    }

    private boolean beginEndAnimation() {
        Drawable drawable = this.mEndDrawable;
        if (drawable == null || !this.mEndCanMorph) {
            return false;
        }
        ((Animatable) drawable).start();
        return true;
    }

    private boolean beginStartAnimation() {
        Drawable drawable = this.mStartDrawable;
        if (drawable == null || !this.mStartCanMorph) {
            return false;
        }
        ((Animatable) drawable).start();
        return true;
    }

    private void configureBounds() {
        configureBounds(this.mCurrentDrawable, this.mCurrentDrawableWidth, this.mCurrentDrawableHeight);
    }

    private void configureBounds(Drawable drawable, int i, int i2) {
        float f;
        float f2;
        if (drawable != null && this.mHaveFrame) {
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            boolean z = (i < 0 || width == i) && (i2 < 0 || height == i2);
            if (i <= 0 || i2 <= 0 || ScaleType.FIT_XY == this.mScaleType) {
                drawable.setBounds(0, 0, width, height);
            } else {
                drawable.setBounds(0, 0, i, i2);
                ScaleType scaleType = ScaleType.MATRIX;
                ScaleType scaleType2 = this.mScaleType;
                if (scaleType == scaleType2) {
                    if (!this.mMatrix.isIdentity()) {
                        this.mDrawMatrix = this.mMatrix;
                        return;
                    }
                } else if (!z) {
                    if (ScaleType.CENTER == scaleType2) {
                        Matrix matrix = this.mMatrix;
                        this.mDrawMatrix = matrix;
                        matrix.setTranslate((float) ((int) ((((float) (width - i)) * 0.5f) + 0.5f)), (float) ((int) ((((float) (height - i2)) * 0.5f) + 0.5f)));
                        return;
                    }
                    float f3 = 0.0f;
                    if (ScaleType.CENTER_CROP == scaleType2) {
                        this.mDrawMatrix = this.mMatrix;
                        if (i * height > width * i2) {
                            f2 = ((float) height) / ((float) i2);
                            f3 = (((float) width) - (((float) i) * f2)) * 0.5f;
                            f = 0.0f;
                        } else {
                            f2 = ((float) width) / ((float) i);
                            f = (((float) height) - (((float) i2) * f2)) * 0.5f;
                        }
                        this.mDrawMatrix.setScale(f2, f2);
                        this.mDrawMatrix.postTranslate((float) ((int) (f3 + 0.5f)), (float) ((int) (f + 0.5f)));
                        return;
                    } else if (ScaleType.CENTER_INSIDE == scaleType2) {
                        this.mDrawMatrix = this.mMatrix;
                        float min = (i > width || i2 > height) ? Math.min(((float) width) / ((float) i), ((float) height) / ((float) i2)) : 1.0f;
                        this.mDrawMatrix.setScale(min, min);
                        this.mDrawMatrix.postTranslate((float) ((int) (((((float) width) - (((float) i) * min)) * 0.5f) + 0.5f)), (float) ((int) (((((float) height) - (((float) i2) * min)) * 0.5f) + 0.5f)));
                        return;
                    } else {
                        this.mTempSrc.set(0.0f, 0.0f, (float) i, (float) i2);
                        this.mTempDst.set(0.0f, 0.0f, (float) width, (float) height);
                        Matrix matrix2 = this.mMatrix;
                        this.mDrawMatrix = matrix2;
                        matrix2.setRectToRect(this.mTempSrc, this.mTempDst, scaleTypeToScaleToFit(this.mScaleType));
                        return;
                    }
                }
            }
            this.mDrawMatrix = null;
        }
    }

    private boolean endEndAnimation() {
        Drawable drawable = this.mEndDrawable;
        if (drawable == null || !this.mEndCanMorph) {
            return false;
        }
        ((Animatable) drawable).stop();
        return true;
    }

    private boolean endStartAnimation() {
        Drawable drawable = this.mStartDrawable;
        if (drawable == null || !this.mStartCanMorph) {
            return false;
        }
        ((Animatable) drawable).stop();
        return true;
    }

    private ScaleType getScaleTypeFromInt(int i) {
        switch (i) {
            case 0:
                return ScaleType.MATRIX;
            case 1:
                return ScaleType.FIT_XY;
            case 2:
                return ScaleType.FIT_START;
            case 3:
                return ScaleType.FIT_CENTER;
            case 4:
                return ScaleType.FIT_END;
            case 5:
                return ScaleType.CENTER;
            case 6:
                return ScaleType.CENTER_CROP;
            case 7:
                return ScaleType.CENTER_INSIDE;
            default:
                return ScaleType.FIT_CENTER;
        }
    }

    private void initMorphButton() {
        this.mMatrix = new Matrix();
        this.mScaleType = ScaleType.FIT_CENTER;
    }

    private boolean isMorphable(Drawable drawable) {
        return drawable != null && (drawable instanceof Animatable);
    }

    private void readTintAttributes(TypedArray typedArray) {
        this.mBackgroundTint = new TintInfo();
        this.mForegroundTint = new TintInfo();
        this.mBackgroundTint.mTintList = typedArray.getColorStateList(R.styleable.MorphButton_vc_backgroundTint);
        TintInfo tintInfo = this.mBackgroundTint;
        boolean z = true;
        tintInfo.mHasTintList = tintInfo.mTintList != null;
        this.mBackgroundTint.mTintMode = DrawableCompat.parseTintMode(typedArray.getInt(R.styleable.MorphButton_vc_backgroundTintMode, -1), (PorterDuff.Mode) null);
        TintInfo tintInfo2 = this.mBackgroundTint;
        tintInfo2.mHasTintMode = tintInfo2.mTintMode != null;
        this.mForegroundTint.mTintList = typedArray.getColorStateList(R.styleable.MorphButton_vc_foregroundTint);
        TintInfo tintInfo3 = this.mForegroundTint;
        tintInfo3.mHasTintList = tintInfo3.mTintList != null;
        this.mForegroundTint.mTintMode = DrawableCompat.parseTintMode(typedArray.getInt(R.styleable.MorphButton_vc_foregroundTintMode, -1), (PorterDuff.Mode) null);
        TintInfo tintInfo4 = this.mForegroundTint;
        if (tintInfo4.mTintMode == null) {
            z = false;
        }
        tintInfo4.mHasTintMode = z;
    }

    private void refreshCurrentDrawable() {
        Drawable drawable = this.mCurrentDrawable;
        if (drawable != null) {
            drawable.setState(getDrawableState());
        }
    }

    private void resizeFromDrawable(MorphState morphState) {
        int i = morphState == MorphState.START ? this.mStartDrawableWidth : this.mEndDrawableWidth;
        int i2 = morphState == MorphState.START ? this.mStartDrawableHeight : this.mEndDrawableHeight;
        Drawable drawable = morphState == MorphState.START ? this.mStartDrawable : this.mEndDrawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (intrinsicWidth < 0) {
                intrinsicWidth = i;
            }
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicHeight < 0) {
                intrinsicHeight = i2;
            }
            if (intrinsicWidth != i || intrinsicHeight != i2) {
                if (morphState == MorphState.START) {
                    this.mStartDrawableWidth = intrinsicWidth;
                    this.mStartDrawableHeight = intrinsicHeight;
                } else {
                    this.mEndDrawableWidth = intrinsicWidth;
                    this.mEndDrawableHeight = intrinsicHeight;
                }
                requestLayout();
            }
        }
    }

    private int resolveAdjustedSize(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == Integer.MIN_VALUE) {
            i = Math.min(i, size);
        } else if (mode != 0) {
            return mode != 1073741824 ? i : size;
        }
        return Math.min(i, i2);
    }

    public static Matrix.ScaleToFit scaleTypeToScaleToFit(ScaleType scaleType) {
        return sS2FArray[scaleType.nativeInt - 1];
    }

    private void setCurrentDrawable(Drawable drawable, int i, int i2) {
        if (this.mCurrentDrawable != drawable) {
            this.mCurrentDrawable = drawable;
            Rect bounds = drawable.getBounds();
            int i3 = bounds.right - bounds.left;
            int i4 = bounds.bottom - bounds.top;
            if (!(this.mCurrentDrawableWidth == i && this.mCurrentDrawableHeight == i2 && i3 == i && i4 == i2)) {
                requestLayout();
            }
            this.mCurrentDrawableWidth = i;
            this.mCurrentDrawableHeight = i2;
        }
    }

    private void setDrawableColorFilter(Drawable drawable, int i, PorterDuff.Mode mode) {
        if (drawable != null) {
            drawable.setColorFilter(i, mode);
        }
    }

    private void setEndDrawable(int i, boolean z) {
        if (i > 0) {
            setEndDrawable(ResourcesCompat.getDrawable(getContext(), i), z);
        }
    }

    private void setEndDrawable(Drawable drawable, boolean z) {
        if (this.mEndDrawable != drawable) {
            updateDrawable(drawable, MorphState.END);
            if (z) {
                setState(this.mState);
            }
        }
    }

    private void setStartDrawable(int i, boolean z) {
        if (i > 0) {
            setStartDrawable(ResourcesCompat.getDrawable(getContext(), i), z);
        }
    }

    private void setStartDrawable(Drawable drawable, boolean z) {
        if (this.mStartDrawable != drawable) {
            updateDrawable(drawable, MorphState.START);
            if (z) {
                setState(this.mState);
            }
        }
    }

    private void updateDrawable(Drawable drawable, MorphState morphState) {
        int i;
        int i2;
        Drawable drawable2 = morphState == MorphState.START ? this.mStartDrawable : this.mEndDrawable;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
            unscheduleDrawable(drawable2);
        }
        if (morphState == MorphState.START) {
            this.mStartDrawable = drawable;
            this.mStartCanMorph = isMorphable(drawable);
        } else {
            this.mEndDrawable = drawable;
            this.mEndCanMorph = isMorphable(drawable);
        }
        if (drawable != null) {
            drawable.setCallback(this);
            if (drawable.isStateful()) {
                drawable.setState(getDrawableState());
            }
            drawable.setVisible(getVisibility() == 0, true);
            drawable.setLevel(0);
            if (morphState == MorphState.START) {
                i = drawable.getIntrinsicWidth();
                this.mStartDrawableWidth = i;
                i2 = drawable.getIntrinsicHeight();
                this.mStartDrawableHeight = i2;
            } else {
                i = drawable.getIntrinsicWidth();
                this.mEndDrawableWidth = i;
                i2 = drawable.getIntrinsicHeight();
                this.mEndDrawableHeight = i2;
            }
            applyForegroundTint(drawable);
            configureBounds(drawable, i, i2);
        } else if (morphState == MorphState.START) {
            this.mStartDrawableHeight = -1;
            this.mStartDrawableWidth = -1;
        } else {
            this.mEndDrawableHeight = -1;
            this.mEndDrawableWidth = -1;
        }
    }

    public ColorStateList getBackgroundTintList() {
        if (ResourcesCompat.LOLLIPOP) {
            return getBackgroundTintList();
        }
        TintInfo tintInfo = this.mBackgroundTint;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        if (ResourcesCompat.LOLLIPOP) {
            return getBackgroundTintMode();
        }
        TintInfo tintInfo = this.mBackgroundTint;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    public ColorStateList getForegroundTintList() {
        TintInfo tintInfo = this.mForegroundTint;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    public PorterDuff.Mode getForegroundTintMode() {
        TintInfo tintInfo = this.mForegroundTint;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    public ScaleType getScaleType() {
        return this.mScaleType;
    }

    public MorphState getState() {
        return this.mState;
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        if (drawable == this.mStartDrawable || drawable == this.mEndDrawable) {
            invalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mCurrentDrawable;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        if (this.mCurrentDrawable != null && this.mCurrentDrawableWidth != 0 && this.mCurrentDrawableHeight != 0) {
            int paddingTop = getPaddingTop();
            int paddingLeft = getPaddingLeft();
            int paddingBottom = getPaddingBottom();
            int paddingRight = getPaddingRight();
            int top = getTop();
            int bottom = getBottom();
            int left = getLeft();
            int right = getRight();
            if (this.mDrawMatrix == null && paddingTop == 0 && paddingLeft == 0) {
                this.mCurrentDrawable.draw(canvas);
                return;
            }
            int saveCount = canvas.getSaveCount();
            canvas.save();
            if (this.mCropToPadding) {
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                canvas.clipRect(scrollX + paddingLeft, scrollY + paddingTop, ((scrollX + right) - left) - paddingRight, ((scrollY + bottom) - top) - paddingBottom);
            }
            canvas.translate((float) paddingLeft, (float) paddingTop);
            Matrix matrix = this.mDrawMatrix;
            if (matrix != null) {
                canvas.concat(matrix);
            }
            this.mCurrentDrawable.draw(canvas);
            canvas.restoreToCount(saveCount);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r21, int r22) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            int r3 = android.view.View.MeasureSpec.getMode(r21)
            int r4 = android.view.View.MeasureSpec.getMode(r22)
            android.graphics.drawable.Drawable r5 = r0.mCurrentDrawable
            r6 = 0
            r8 = 0
            if (r5 != 0) goto L_0x001f
            r3 = -1
            r0.mCurrentDrawableWidth = r3
            r0.mCurrentDrawableHeight = r3
            r3 = 0
            r4 = 0
            r5 = 0
            r9 = 0
        L_0x001d:
            r10 = 0
            goto L_0x0040
        L_0x001f:
            int r5 = r0.mCurrentDrawableWidth
            int r9 = r0.mCurrentDrawableHeight
            if (r5 > 0) goto L_0x0026
            r5 = 1
        L_0x0026:
            if (r9 > 0) goto L_0x0029
            r9 = 1
        L_0x0029:
            boolean r10 = r0.mAdjustViewBounds
            if (r10 == 0) goto L_0x003d
            r10 = 1073741824(0x40000000, float:2.0)
            if (r3 == r10) goto L_0x0033
            r3 = 1
            goto L_0x0034
        L_0x0033:
            r3 = 0
        L_0x0034:
            if (r4 == r10) goto L_0x0038
            r4 = 1
            goto L_0x0039
        L_0x0038:
            r4 = 0
        L_0x0039:
            float r10 = (float) r5
            float r11 = (float) r9
            float r10 = r10 / r11
            goto L_0x0040
        L_0x003d:
            r3 = 0
            r4 = 0
            goto L_0x001d
        L_0x0040:
            int r11 = r20.getPaddingLeft()
            int r12 = r20.getPaddingRight()
            int r13 = r20.getPaddingTop()
            int r14 = r20.getPaddingBottom()
            if (r3 != 0) goto L_0x0073
            if (r4 == 0) goto L_0x0055
            goto L_0x0073
        L_0x0055:
            int r11 = r11 + r12
            int r11 = r11 + r5
            int r13 = r13 + r14
            int r13 = r13 + r9
            int r3 = r20.getSuggestedMinimumWidth()
            int r3 = java.lang.Math.max(r11, r3)
            int r4 = r20.getSuggestedMinimumHeight()
            int r4 = java.lang.Math.max(r13, r4)
            int r1 = android.widget.CompoundButton.resolveSizeAndState(r3, r1, r8)
            int r2 = android.widget.CompoundButton.resolveSizeAndState(r4, r2, r8)
            goto L_0x00df
        L_0x0073:
            int r5 = r5 + r11
            int r5 = r5 + r12
            r15 = 2147483647(0x7fffffff, float:NaN)
            int r5 = r0.resolveAdjustedSize(r5, r15, r1)
            int r9 = r9 + r13
            int r9 = r9 + r14
            int r9 = r0.resolveAdjustedSize(r9, r15, r2)
            int r6 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x00da
            int r6 = r5 - r11
            int r6 = r6 - r12
            float r6 = (float) r6
            int r16 = r9 - r13
            int r7 = r16 - r14
            float r7 = (float) r7
            float r6 = r6 / r7
            float r6 = r6 - r10
            float r6 = java.lang.Math.abs(r6)
            r17 = r9
            double r8 = (double) r6
            r18 = 4502148214488346440(0x3e7ad7f29abcaf48, double:1.0E-7)
            int r6 = (r8 > r18 ? 1 : (r8 == r18 ? 0 : -1))
            if (r6 <= 0) goto L_0x00dc
            if (r3 == 0) goto L_0x00b8
            float r7 = r7 * r10
            int r6 = (int) r7
            int r6 = r6 + r11
            int r6 = r6 + r12
            if (r4 != 0) goto L_0x00b3
            boolean r7 = r0.mAdjustViewBoundsCompat
            if (r7 != 0) goto L_0x00b3
            int r1 = r0.resolveAdjustedSize(r6, r15, r1)
            r5 = r1
        L_0x00b3:
            if (r6 > r5) goto L_0x00b8
            r5 = r6
            r7 = 1
            goto L_0x00b9
        L_0x00b8:
            r7 = 0
        L_0x00b9:
            if (r7 != 0) goto L_0x00dc
            if (r4 == 0) goto L_0x00dc
            int r1 = r5 - r11
            int r1 = r1 - r12
            float r1 = (float) r1
            float r1 = r1 / r10
            int r1 = (int) r1
            int r1 = r1 + r13
            int r1 = r1 + r14
            if (r3 != 0) goto L_0x00d0
            boolean r3 = r0.mAdjustViewBoundsCompat
            if (r3 != 0) goto L_0x00d0
            int r9 = r0.resolveAdjustedSize(r1, r15, r2)
            goto L_0x00d2
        L_0x00d0:
            r9 = r17
        L_0x00d2:
            if (r1 > r9) goto L_0x00d7
            r2 = r1
            r1 = r5
            goto L_0x00df
        L_0x00d7:
            r1 = r5
            r2 = r9
            goto L_0x00df
        L_0x00da:
            r17 = r9
        L_0x00dc:
            r1 = r5
            r2 = r17
        L_0x00df:
            r0.setMeasuredDimension(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wnafee.vector.MorphButton.onMeasure(int, int):void");
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setState(savedState.state, false);
        requestLayout();
    }

    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.state = getState();
        return savedState;
    }

    public void refreshDrawableState() {
        super.refreshDrawableState();
        refreshCurrentDrawable();
    }

    public void setBackgroundColorFilter(int i, PorterDuff.Mode mode) {
        setDrawableColorFilter(getBackground(), i, mode);
    }

    @TargetApi(21)
    public void setBackgroundDrawable(Drawable drawable) {
        if (ResourcesCompat.LOLLIPOP) {
            TintInfo tintInfo = this.mBackgroundTint;
            if (tintInfo != null) {
                if (tintInfo.mHasTintList) {
                    super.setBackgroundTintList(tintInfo.mTintList);
                }
                TintInfo tintInfo2 = this.mBackgroundTint;
                if (tintInfo2.mHasTintMode) {
                    super.setBackgroundTintMode(tintInfo2.mTintMode);
                }
            }
            super.setBackgroundDrawable(drawable);
            return;
        }
        super.setBackgroundDrawable(drawable);
        applyBackgroundTint();
    }

    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (ResourcesCompat.LOLLIPOP) {
            super.setBackgroundTintList(colorStateList);
        }
        if (this.mBackgroundTint == null) {
            this.mBackgroundTint = new TintInfo();
        }
        TintInfo tintInfo = this.mBackgroundTint;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = true;
        if (!ResourcesCompat.LOLLIPOP) {
            applyBackgroundTint();
        }
    }

    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (ResourcesCompat.LOLLIPOP) {
            super.setBackgroundTintMode(mode);
        }
        if (this.mBackgroundTint == null) {
            this.mBackgroundTint = new TintInfo();
        }
        TintInfo tintInfo = this.mBackgroundTint;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = true;
        if (!ResourcesCompat.LOLLIPOP) {
            applyBackgroundTint();
        }
    }

    public void setChecked(boolean z) {
        if (!this.mIsToggling) {
            setState(z ? MorphState.END : MorphState.START);
        }
    }

    public void setEndDrawable(int i) {
        setEndDrawable(i, true);
    }

    public void setEndDrawable(Drawable drawable) {
        setEndDrawable(drawable, true);
    }

    public void setForegroundColorFilter(int i, PorterDuff.Mode mode) {
        Drawable drawable = this.mStartDrawable;
        if (drawable != null) {
            drawable.setColorFilter(i, mode);
        }
        Drawable drawable2 = this.mEndDrawable;
        if (drawable2 != null) {
            drawable2.setColorFilter(i, mode);
        }
    }

    public void setForegroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.mForegroundTint == null) {
            this.mForegroundTint = new TintInfo();
        }
        TintInfo tintInfo = this.mForegroundTint;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = true;
        applyForegroundTint();
    }

    public void setForegroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.mForegroundTint == null) {
            this.mForegroundTint = new TintInfo();
        }
        TintInfo tintInfo = this.mForegroundTint;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = true;
        applyForegroundTint();
    }

    public boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        this.mHaveFrame = true;
        configureBounds();
        return frame;
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        if (onStateChangedListener != null && onStateChangedListener != this.mStateListener) {
            this.mStateListener = onStateChangedListener;
        }
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType == null) {
            throw null;
        } else if (this.mScaleType != scaleType) {
            this.mScaleType = scaleType;
            setWillNotCacheDrawing(scaleType == ScaleType.CENTER);
            requestLayout();
            invalidate();
        }
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
        resizeFromDrawable(this.mState);
    }

    public void setStartDrawable(int i) {
        setStartDrawable(i, true);
    }

    public void setStartDrawable(Drawable drawable) {
        setStartDrawable(drawable, true);
    }

    public void setState(MorphState morphState) {
        setState(morphState, false);
    }

    public void setState(MorphState morphState, boolean z) {
        boolean z2;
        if (morphState == MorphState.START) {
            z2 = false;
            setCurrentDrawable(this.mEndCanMorph ? this.mEndDrawable : this.mStartDrawable, this.mEndCanMorph ? this.mEndDrawableWidth : this.mStartDrawableWidth, this.mEndCanMorph ? this.mEndDrawableHeight : this.mStartDrawableHeight);
            beginEndAnimation();
            if (!z) {
                endEndAnimation();
            }
        } else {
            z2 = true;
            setCurrentDrawable(this.mStartCanMorph ? this.mStartDrawable : this.mEndDrawable, this.mStartCanMorph ? this.mStartDrawableWidth : this.mEndDrawableWidth, this.mStartCanMorph ? this.mStartDrawableHeight : this.mEndDrawableHeight);
            beginStartAnimation();
            if (!z) {
                endStartAnimation();
            }
        }
        if (this.mState != morphState || !this.mHasStarted) {
            super.setChecked(z2);
            this.mState = morphState;
            OnStateChangedListener onStateChangedListener = this.mStateListener;
            if (onStateChangedListener != null) {
                onStateChangedListener.onStateChanged(morphState, z);
            }
        }
    }

    public void toggle() {
        this.mHasStarted = true;
        this.mIsToggling = true;
        MorphState morphState = this.mState;
        MorphState morphState2 = MorphState.START;
        if (morphState == morphState2) {
            morphState2 = MorphState.END;
        }
        setState(morphState2, true);
        super.toggle();
        this.mIsToggling = false;
    }

    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.mStartDrawable || drawable == this.mEndDrawable || super.verifyDrawable(drawable);
    }
}
