package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import java.util.Map;

public class ChangeBounds extends Transition {
    public static final Property<View, PointF> BOTTOM_RIGHT_ONLY_PROPERTY = new Property<View, PointF>(PointF.class, "bottomRight") {
        public PointF get(View view) {
            return null;
        }

        public void set(View view, PointF pointF) {
            ViewUtils.setLeftTopRightBottom(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    };
    public static final Property<ViewBounds, PointF> BOTTOM_RIGHT_PROPERTY = new Property<ViewBounds, PointF>(PointF.class, "bottomRight") {
        public PointF get(ViewBounds viewBounds) {
            return null;
        }

        public void set(ViewBounds viewBounds, PointF pointF) {
            viewBounds.setBottomRight(pointF);
        }
    };
    public static final Property<Drawable, PointF> DRAWABLE_ORIGIN_PROPERTY = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") {
        public Rect mBounds = new Rect();

        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.mBounds);
            Rect rect = this.mBounds;
            return new PointF((float) rect.left, (float) rect.top);
        }

        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.mBounds);
            this.mBounds.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.mBounds);
        }
    };
    public static final Property<View, PointF> POSITION_PROPERTY = new Property<View, PointF>(PointF.class, "position") {
        public PointF get(View view) {
            return null;
        }

        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            ViewUtils.setLeftTopRightBottom(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    };
    public static final String PROPNAME_BOUNDS = "android:changeBounds:bounds";
    public static final String PROPNAME_CLIP = "android:changeBounds:clip";
    public static final String PROPNAME_PARENT = "android:changeBounds:parent";
    public static final String PROPNAME_WINDOW_X = "android:changeBounds:windowX";
    public static final String PROPNAME_WINDOW_Y = "android:changeBounds:windowY";
    public static final Property<View, PointF> TOP_LEFT_ONLY_PROPERTY = new Property<View, PointF>(PointF.class, "topLeft") {
        public PointF get(View view) {
            return null;
        }

        public void set(View view, PointF pointF) {
            ViewUtils.setLeftTopRightBottom(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    };
    public static final Property<ViewBounds, PointF> TOP_LEFT_PROPERTY = new Property<ViewBounds, PointF>(PointF.class, "topLeft") {
        public PointF get(ViewBounds viewBounds) {
            return null;
        }

        public void set(ViewBounds viewBounds, PointF pointF) {
            viewBounds.setTopLeft(pointF);
        }
    };
    public static RectEvaluator sRectEvaluator = new RectEvaluator();
    public static final String[] sTransitionProperties = {PROPNAME_BOUNDS, PROPNAME_CLIP, PROPNAME_PARENT, PROPNAME_WINDOW_X, PROPNAME_WINDOW_Y};
    public boolean mReparent = false;
    public boolean mResizeClip = false;
    public int[] mTempLocation = new int[2];

    public static class ViewBounds {
        public int mBottom;
        public int mBottomRightCalls;
        public int mLeft;
        public int mRight;
        public int mTop;
        public int mTopLeftCalls;
        public View mView;

        public ViewBounds(View view) {
            this.mView = view;
        }

        private void setLeftTopRightBottom() {
            ViewUtils.setLeftTopRightBottom(this.mView, this.mLeft, this.mTop, this.mRight, this.mBottom);
            this.mTopLeftCalls = 0;
            this.mBottomRightCalls = 0;
        }

        public void setBottomRight(PointF pointF) {
            this.mRight = Math.round(pointF.x);
            this.mBottom = Math.round(pointF.y);
            int i = this.mBottomRightCalls + 1;
            this.mBottomRightCalls = i;
            if (this.mTopLeftCalls == i) {
                setLeftTopRightBottom();
            }
        }

        public void setTopLeft(PointF pointF) {
            this.mLeft = Math.round(pointF.x);
            this.mTop = Math.round(pointF.y);
            int i = this.mTopLeftCalls + 1;
            this.mTopLeftCalls = i;
            if (i == this.mBottomRightCalls) {
                setLeftTopRightBottom();
            }
        }
    }

    public ChangeBounds() {
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.CHANGE_BOUNDS);
        boolean namedBoolean = TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        setResizeClip(namedBoolean);
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (ViewCompat.isLaidOut(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            transitionValues.values.put(PROPNAME_BOUNDS, new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            transitionValues.values.put(PROPNAME_PARENT, transitionValues.view.getParent());
            if (this.mReparent) {
                transitionValues.view.getLocationInWindow(this.mTempLocation);
                transitionValues.values.put(PROPNAME_WINDOW_X, Integer.valueOf(this.mTempLocation[0]));
                transitionValues.values.put(PROPNAME_WINDOW_Y, Integer.valueOf(this.mTempLocation[1]));
            }
            if (this.mResizeClip) {
                transitionValues.values.put(PROPNAME_CLIP, ViewCompat.getClipBounds(view));
            }
        }
    }

    private boolean parentMatches(View view, View view2) {
        if (!this.mReparent) {
            return true;
        }
        TransitionValues matchedTransitionValues = getMatchedTransitionValues(view, true);
        if (matchedTransitionValues == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == matchedTransitionValues.view) {
            return true;
        }
        return false;
    }

    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        int i;
        View view;
        Animator animator;
        int i2;
        Rect rect;
        ObjectAnimator objectAnimator;
        Property<View, PointF> property;
        Path path;
        TransitionValues transitionValues3 = transitionValues;
        TransitionValues transitionValues4 = transitionValues2;
        if (transitionValues3 == null || transitionValues4 == null) {
            return null;
        }
        Map<String, Object> map = transitionValues3.values;
        Map<String, Object> map2 = transitionValues4.values;
        ViewGroup viewGroup2 = (ViewGroup) map.get(PROPNAME_PARENT);
        ViewGroup viewGroup3 = (ViewGroup) map2.get(PROPNAME_PARENT);
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = transitionValues4.view;
        if (parentMatches(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) transitionValues3.values.get(PROPNAME_BOUNDS);
            Rect rect3 = (Rect) transitionValues4.values.get(PROPNAME_BOUNDS);
            int i3 = rect2.left;
            int i4 = rect3.left;
            int i5 = rect2.top;
            int i6 = rect3.top;
            int i7 = rect2.right;
            int i8 = rect3.right;
            int i9 = rect2.bottom;
            int i10 = rect3.bottom;
            int i11 = i7 - i3;
            int i12 = i9 - i5;
            int i13 = i8 - i4;
            int i14 = i10 - i6;
            View view3 = view2;
            Rect rect4 = (Rect) transitionValues3.values.get(PROPNAME_CLIP);
            Rect rect5 = (Rect) transitionValues4.values.get(PROPNAME_CLIP);
            if ((i11 == 0 || i12 == 0) && (i13 == 0 || i14 == 0)) {
                i = 0;
            } else {
                i = (i3 == i4 && i5 == i6) ? 0 : 1;
                if (!(i7 == i8 && i9 == i10)) {
                    i++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i++;
            }
            if (i <= 0) {
                return null;
            }
            Rect rect6 = rect5;
            Rect rect7 = rect4;
            if (!this.mResizeClip) {
                view = view3;
                ViewUtils.setLeftTopRightBottom(view, i3, i5, i7, i9);
                if (i == 2) {
                    if (i11 == i13 && i12 == i14) {
                        path = getPathMotion().getPath((float) i3, (float) i5, (float) i4, (float) i6);
                        property = POSITION_PROPERTY;
                    } else {
                        final ViewBounds viewBounds = new ViewBounds(view);
                        ObjectAnimator ofPointF = ObjectAnimatorUtils.ofPointF(viewBounds, TOP_LEFT_PROPERTY, getPathMotion().getPath((float) i3, (float) i5, (float) i4, (float) i6));
                        ObjectAnimator ofPointF2 = ObjectAnimatorUtils.ofPointF(viewBounds, BOTTOM_RIGHT_PROPERTY, getPathMotion().getPath((float) i7, (float) i9, (float) i8, (float) i10));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(new Animator[]{ofPointF, ofPointF2});
                        animatorSet.addListener(new AnimatorListenerAdapter() {
                            public ViewBounds mViewBounds = viewBounds;
                        });
                        animator = animatorSet;
                    }
                } else if (i3 == i4 && i5 == i6) {
                    path = getPathMotion().getPath((float) i7, (float) i9, (float) i8, (float) i10);
                    property = BOTTOM_RIGHT_ONLY_PROPERTY;
                } else {
                    path = getPathMotion().getPath((float) i3, (float) i5, (float) i4, (float) i6);
                    property = TOP_LEFT_ONLY_PROPERTY;
                }
                animator = ObjectAnimatorUtils.ofPointF(view, property, path);
            } else {
                view = view3;
                ViewUtils.setLeftTopRightBottom(view, i3, i5, Math.max(i11, i13) + i3, Math.max(i12, i14) + i5);
                ObjectAnimator ofPointF3 = (i3 == i4 && i5 == i6) ? null : ObjectAnimatorUtils.ofPointF(view, POSITION_PROPERTY, getPathMotion().getPath((float) i3, (float) i5, (float) i4, (float) i6));
                if (rect7 == null) {
                    i2 = 0;
                    rect = new Rect(0, 0, i11, i12);
                } else {
                    i2 = 0;
                    rect = rect7;
                }
                Rect rect8 = rect6 == null ? new Rect(i2, i2, i13, i14) : rect6;
                if (!rect.equals(rect8)) {
                    ViewCompat.setClipBounds(view, rect);
                    RectEvaluator rectEvaluator = sRectEvaluator;
                    Object[] objArr = new Object[2];
                    objArr[i2] = rect;
                    objArr[1] = rect8;
                    ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", rectEvaluator, objArr);
                    final View view4 = view;
                    final Rect rect9 = rect6;
                    final int i15 = i4;
                    final int i16 = i6;
                    final int i17 = i8;
                    final int i18 = i10;
                    ofObject.addListener(new AnimatorListenerAdapter() {
                        public boolean mIsCanceled;

                        public void onAnimationCancel(Animator animator) {
                            this.mIsCanceled = true;
                        }

                        public void onAnimationEnd(Animator animator) {
                            if (!this.mIsCanceled) {
                                ViewCompat.setClipBounds(view4, rect9);
                                ViewUtils.setLeftTopRightBottom(view4, i15, i16, i17, i18);
                            }
                        }
                    });
                    objectAnimator = ofObject;
                } else {
                    objectAnimator = null;
                }
                animator = TransitionUtils.mergeAnimators(ofPointF3, objectAnimator);
            }
            if (view.getParent() instanceof ViewGroup) {
                final ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                ViewGroupUtils.suppressLayout(viewGroup4, true);
                addListener(new TransitionListenerAdapter() {
                    public boolean mCanceled = false;

                    public void onTransitionCancel(@NonNull Transition transition) {
                        ViewGroupUtils.suppressLayout(viewGroup4, false);
                        this.mCanceled = true;
                    }

                    public void onTransitionEnd(@NonNull Transition transition) {
                        if (!this.mCanceled) {
                            ViewGroupUtils.suppressLayout(viewGroup4, false);
                        }
                        transition.removeListener(this);
                    }

                    public void onTransitionPause(@NonNull Transition transition) {
                        ViewGroupUtils.suppressLayout(viewGroup4, false);
                    }

                    public void onTransitionResume(@NonNull Transition transition) {
                        ViewGroupUtils.suppressLayout(viewGroup4, true);
                    }
                });
            }
            return animator;
        }
        int intValue = ((Integer) transitionValues3.values.get(PROPNAME_WINDOW_X)).intValue();
        int intValue2 = ((Integer) transitionValues3.values.get(PROPNAME_WINDOW_Y)).intValue();
        int intValue3 = ((Integer) transitionValues4.values.get(PROPNAME_WINDOW_X)).intValue();
        int intValue4 = ((Integer) transitionValues4.values.get(PROPNAME_WINDOW_Y)).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.mTempLocation);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float transitionAlpha = ViewUtils.getTransitionAlpha(view2);
        ViewUtils.setTransitionAlpha(view2, 0.0f);
        ViewUtils.getOverlay(viewGroup).add(bitmapDrawable);
        PathMotion pathMotion = getPathMotion();
        int[] iArr = this.mTempLocation;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, new PropertyValuesHolder[]{PropertyValuesHolderUtils.ofPointF(DRAWABLE_ORIGIN_PROPERTY, pathMotion.getPath((float) (intValue - iArr[0]), (float) (intValue2 - iArr[1]), (float) (intValue3 - iArr[0]), (float) (intValue4 - iArr[1])))});
        final ViewGroup viewGroup5 = viewGroup;
        final BitmapDrawable bitmapDrawable2 = bitmapDrawable;
        final View view5 = view2;
        final float f = transitionAlpha;
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                ViewUtils.getOverlay(viewGroup5).remove(bitmapDrawable2);
                ViewUtils.setTransitionAlpha(view5, f);
            }
        });
        return ofPropertyValuesHolder;
    }

    public boolean getResizeClip() {
        return this.mResizeClip;
    }

    @Nullable
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public void setResizeClip(boolean z) {
        this.mResizeClip = z;
    }
}
