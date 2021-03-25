package com.wnafee.vector.compat;

import a.a.a.a.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.view.ViewCompat;
import com.wnafee.vector.R;
import com.wnafee.vector.compat.DrawableCompat;
import com.wnafee.vector.compat.PathParser;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class VectorDrawable extends DrawableCompat implements Tintable {
    public static final boolean DBG_VECTOR_DRAWABLE = false;
    public static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    public static final int LINECAP_BUTT = 0;
    public static final int LINECAP_ROUND = 1;
    public static final int LINECAP_SQUARE = 2;
    public static final int LINEJOIN_BEVEL = 2;
    public static final int LINEJOIN_MITER = 0;
    public static final int LINEJOIN_ROUND = 1;
    public static final String LOGTAG = VectorDrawable.class.getSimpleName();
    public static final String SHAPE_CLIP_PATH = "clip-path";
    public static final String SHAPE_GROUP = "group";
    public static final String SHAPE_PATH = "path";
    public static final String SHAPE_VECTOR = "vector";
    public boolean mAllowCaching;
    public ColorFilter mColorFilter;
    public boolean mMutated;
    public PorterDuffColorFilter mTintFilter;
    public VectorDrawableState mVectorState;

    public static class VClipPath extends VPath {
        public VClipPath() {
        }

        public VClipPath(VClipPath vClipPath) {
            super(vClipPath);
        }

        private void updateStateFromTypedArray(TypedArray typedArray) {
            this.mChangingConfigurations |= VectorDrawable.getChangingConfigurations(typedArray);
            String string = typedArray.getString(R.styleable.VectorDrawableClipPath_android_name);
            if (string != null) {
                this.mPathName = string;
            }
            String string2 = typedArray.getString(R.styleable.VectorDrawableClipPath_vc_pathData);
            if (string2 != null) {
                this.mNodes = PathParser.createNodesFromPathData(string2);
            }
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme) {
            TypedArray obtainAttributes = DrawableCompat.obtainAttributes(resources, theme, attributeSet, R.styleable.VectorDrawableClipPath);
            updateStateFromTypedArray(obtainAttributes);
            obtainAttributes.recycle();
        }

        public boolean isClipPath() {
            return true;
        }
    }

    public static class VFullPath extends VPath {
        public float mFillAlpha = 1.0f;
        public int mFillColor = 0;
        public int mFillRule;
        public float mStrokeAlpha = 1.0f;
        public int mStrokeColor = 0;
        public Paint.Cap mStrokeLineCap = Paint.Cap.BUTT;
        public Paint.Join mStrokeLineJoin = Paint.Join.MITER;
        public float mStrokeMiterlimit = 4.0f;
        public float mStrokeWidth = 0.0f;
        public int[] mThemeAttrs;
        public float mTrimPathEnd = 1.0f;
        public float mTrimPathOffset = 0.0f;
        public float mTrimPathStart = 0.0f;

        public VFullPath() {
        }

        public VFullPath(VFullPath vFullPath) {
            super(vFullPath);
            this.mThemeAttrs = vFullPath.mThemeAttrs;
            this.mStrokeColor = vFullPath.mStrokeColor;
            this.mStrokeWidth = vFullPath.mStrokeWidth;
            this.mStrokeAlpha = vFullPath.mStrokeAlpha;
            this.mFillColor = vFullPath.mFillColor;
            this.mFillRule = vFullPath.mFillRule;
            this.mFillAlpha = vFullPath.mFillAlpha;
            this.mTrimPathStart = vFullPath.mTrimPathStart;
            this.mTrimPathEnd = vFullPath.mTrimPathEnd;
            this.mTrimPathOffset = vFullPath.mTrimPathOffset;
            this.mStrokeLineCap = vFullPath.mStrokeLineCap;
            this.mStrokeLineJoin = vFullPath.mStrokeLineJoin;
            this.mStrokeMiterlimit = vFullPath.mStrokeMiterlimit;
        }

        private Paint.Cap getStrokeLineCap(int i, Paint.Cap cap) {
            return i != 0 ? i != 1 ? i != 2 ? cap : Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }

        private Paint.Join getStrokeLineJoin(int i, Paint.Join join) {
            return i != 0 ? i != 1 ? i != 2 ? join : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER;
        }

        private void updateStateFromTypedArray(TypedArray typedArray) {
            this.mChangingConfigurations |= VectorDrawable.getChangingConfigurations(typedArray);
            String string = typedArray.getString(R.styleable.VectorDrawablePath_android_name);
            if (string != null) {
                this.mPathName = string;
            }
            String string2 = typedArray.getString(R.styleable.VectorDrawablePath_vc_pathData);
            if (string2 != null) {
                this.mNodes = PathParser.createNodesFromPathData(string2);
            }
            this.mFillColor = typedArray.getColor(R.styleable.VectorDrawablePath_vc_fillColor, this.mFillColor);
            this.mFillAlpha = typedArray.getFloat(R.styleable.VectorDrawablePath_vc_fillAlpha, this.mFillAlpha);
            this.mStrokeLineCap = getStrokeLineCap(typedArray.getInt(R.styleable.VectorDrawablePath_vc_strokeLineCap, -1), this.mStrokeLineCap);
            this.mStrokeLineJoin = getStrokeLineJoin(typedArray.getInt(R.styleable.VectorDrawablePath_vc_strokeLineJoin, -1), this.mStrokeLineJoin);
            this.mStrokeMiterlimit = typedArray.getFloat(R.styleable.VectorDrawablePath_vc_strokeMiterLimit, this.mStrokeMiterlimit);
            this.mStrokeColor = typedArray.getColor(R.styleable.VectorDrawablePath_vc_strokeColor, this.mStrokeColor);
            this.mStrokeAlpha = typedArray.getFloat(R.styleable.VectorDrawablePath_vc_strokeAlpha, this.mStrokeAlpha);
            this.mStrokeWidth = typedArray.getFloat(R.styleable.VectorDrawablePath_vc_strokeWidth, this.mStrokeWidth);
            this.mTrimPathEnd = typedArray.getFloat(R.styleable.VectorDrawablePath_vc_trimPathEnd, this.mTrimPathEnd);
            this.mTrimPathOffset = typedArray.getFloat(R.styleable.VectorDrawablePath_vc_trimPathOffset, this.mTrimPathOffset);
            this.mTrimPathStart = typedArray.getFloat(R.styleable.VectorDrawablePath_vc_trimPathStart, this.mTrimPathStart);
        }

        public void applyTheme(Resources.Theme theme) {
            int[] iArr = this.mThemeAttrs;
        }

        public boolean canApplyTheme() {
            return this.mThemeAttrs != null;
        }

        public float getFillAlpha() {
            return this.mFillAlpha;
        }

        public int getFillColor() {
            return this.mFillColor;
        }

        public float getStrokeAlpha() {
            return this.mStrokeAlpha;
        }

        public int getStrokeColor() {
            return this.mStrokeColor;
        }

        public float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        public float getTrimPathEnd() {
            return this.mTrimPathEnd;
        }

        public float getTrimPathOffset() {
            return this.mTrimPathOffset;
        }

        public float getTrimPathStart() {
            return this.mTrimPathStart;
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme) {
            TypedArray obtainAttributes = DrawableCompat.obtainAttributes(resources, theme, attributeSet, R.styleable.VectorDrawablePath);
            updateStateFromTypedArray(obtainAttributes);
            obtainAttributes.recycle();
        }

        public void setFillAlpha(float f) {
            this.mFillAlpha = f;
        }

        public void setFillColor(int i) {
            this.mFillColor = i;
        }

        public void setStrokeAlpha(float f) {
            this.mStrokeAlpha = f;
        }

        public void setStrokeColor(int i) {
            this.mStrokeColor = i;
        }

        public void setStrokeWidth(float f) {
            this.mStrokeWidth = f;
        }

        public void setTrimPathEnd(float f) {
            this.mTrimPathEnd = f;
        }

        public void setTrimPathOffset(float f) {
            this.mTrimPathOffset = f;
        }

        public void setTrimPathStart(float f) {
            this.mTrimPathStart = f;
        }
    }

    public static class VGroup {
        public int mChangingConfigurations;
        public final ArrayList<Object> mChildren = new ArrayList<>();
        public String mGroupName = null;
        public final Matrix mLocalMatrix = new Matrix();
        public float mPivotX = 0.0f;
        public float mPivotY = 0.0f;
        public float mRotate = 0.0f;
        public float mScaleX = 1.0f;
        public float mScaleY = 1.0f;
        public final Matrix mStackedMatrix = new Matrix();
        public int[] mThemeAttrs;
        public float mTranslateX = 0.0f;
        public float mTranslateY = 0.0f;

        public VGroup() {
        }

        public VGroup(VGroup vGroup, ArrayMap<String, Object> arrayMap) {
            VPath vPath;
            this.mRotate = vGroup.mRotate;
            this.mPivotX = vGroup.mPivotX;
            this.mPivotY = vGroup.mPivotY;
            this.mScaleX = vGroup.mScaleX;
            this.mScaleY = vGroup.mScaleY;
            this.mTranslateX = vGroup.mTranslateX;
            this.mTranslateY = vGroup.mTranslateY;
            this.mThemeAttrs = vGroup.mThemeAttrs;
            String str = vGroup.mGroupName;
            this.mGroupName = str;
            this.mChangingConfigurations = vGroup.mChangingConfigurations;
            if (str != null) {
                arrayMap.put(str, this);
            }
            this.mLocalMatrix.set(vGroup.mLocalMatrix);
            ArrayList<Object> arrayList = vGroup.mChildren;
            for (int i = 0; i < arrayList.size(); i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof VGroup) {
                    this.mChildren.add(new VGroup((VGroup) obj, arrayMap));
                } else {
                    if (obj instanceof VFullPath) {
                        vPath = new VFullPath((VFullPath) obj);
                    } else if (obj instanceof VClipPath) {
                        vPath = new VClipPath((VClipPath) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.mChildren.add(vPath);
                    String str2 = vPath.mPathName;
                    if (str2 != null) {
                        arrayMap.put(str2, vPath);
                    }
                }
            }
        }

        private void updateLocalMatrix() {
            this.mLocalMatrix.reset();
            this.mLocalMatrix.postTranslate(-this.mPivotX, -this.mPivotY);
            this.mLocalMatrix.postScale(this.mScaleX, this.mScaleY);
            this.mLocalMatrix.postRotate(this.mRotate, 0.0f, 0.0f);
            this.mLocalMatrix.postTranslate(this.mTranslateX + this.mPivotX, this.mTranslateY + this.mPivotY);
        }

        private void updateStateFromTypedArray(TypedArray typedArray) {
            this.mChangingConfigurations |= VectorDrawable.getChangingConfigurations(typedArray);
            this.mRotate = typedArray.getFloat(R.styleable.VectorDrawableGroup_android_rotation, this.mRotate);
            this.mPivotX = typedArray.getFloat(R.styleable.VectorDrawableGroup_android_pivotX, this.mPivotX);
            this.mPivotY = typedArray.getFloat(R.styleable.VectorDrawableGroup_android_pivotY, this.mPivotY);
            this.mScaleX = typedArray.getFloat(R.styleable.VectorDrawableGroup_android_scaleX, this.mScaleX);
            this.mScaleY = typedArray.getFloat(R.styleable.VectorDrawableGroup_android_scaleY, this.mScaleY);
            this.mTranslateX = typedArray.getFloat(R.styleable.VectorDrawableGroup_vc_translateX, this.mTranslateX);
            this.mTranslateY = typedArray.getFloat(R.styleable.VectorDrawableGroup_vc_translateY, this.mTranslateY);
            String string = typedArray.getString(R.styleable.VectorDrawableGroup_android_name);
            if (string != null) {
                this.mGroupName = string;
            }
            updateLocalMatrix();
        }

        public void applyTheme(Resources.Theme theme) {
            int[] iArr = this.mThemeAttrs;
        }

        public boolean canApplyTheme() {
            return this.mThemeAttrs != null;
        }

        public String getGroupName() {
            return this.mGroupName;
        }

        public Matrix getLocalMatrix() {
            return this.mLocalMatrix;
        }

        public float getPivotX() {
            return this.mPivotX;
        }

        public float getPivotY() {
            return this.mPivotY;
        }

        public float getRotation() {
            return this.mRotate;
        }

        public float getScaleX() {
            return this.mScaleX;
        }

        public float getScaleY() {
            return this.mScaleY;
        }

        public float getTranslateX() {
            return this.mTranslateX;
        }

        public float getTranslateY() {
            return this.mTranslateY;
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme) {
            TypedArray obtainAttributes = DrawableCompat.obtainAttributes(resources, theme, attributeSet, R.styleable.VectorDrawableGroup);
            updateStateFromTypedArray(obtainAttributes);
            obtainAttributes.recycle();
        }

        public void setPivotX(float f) {
            if (f != this.mPivotX) {
                this.mPivotX = f;
                updateLocalMatrix();
            }
        }

        public void setPivotY(float f) {
            if (f != this.mPivotY) {
                this.mPivotY = f;
                updateLocalMatrix();
            }
        }

        public void setRotation(float f) {
            if (f != this.mRotate) {
                this.mRotate = f;
                updateLocalMatrix();
            }
        }

        public void setScaleX(float f) {
            if (f != this.mScaleX) {
                this.mScaleX = f;
                updateLocalMatrix();
            }
        }

        public void setScaleY(float f) {
            if (f != this.mScaleY) {
                this.mScaleY = f;
                updateLocalMatrix();
            }
        }

        public void setTranslateX(float f) {
            if (f != this.mTranslateX) {
                this.mTranslateX = f;
                updateLocalMatrix();
            }
        }

        public void setTranslateY(float f) {
            if (f != this.mTranslateY) {
                this.mTranslateY = f;
                updateLocalMatrix();
            }
        }
    }

    public static class VPath {
        public int mChangingConfigurations;
        public PathParser.PathDataNode[] mNodes = null;
        public String mPathName;

        public VPath() {
        }

        public VPath(VPath vPath) {
            this.mPathName = vPath.mPathName;
            this.mChangingConfigurations = vPath.mChangingConfigurations;
            this.mNodes = PathParser.deepCopyNodes(vPath.mNodes);
        }

        public void applyTheme(Resources.Theme theme) {
        }

        public boolean canApplyTheme() {
            return false;
        }

        public PathParser.PathDataNode[] getPathData() {
            return this.mNodes;
        }

        public String getPathName() {
            return this.mPathName;
        }

        public boolean isClipPath() {
            return false;
        }

        public void setPathData(PathParser.PathDataNode[] pathDataNodeArr) {
            if (!PathParser.canMorph(this.mNodes, pathDataNodeArr)) {
                this.mNodes = PathParser.deepCopyNodes(pathDataNodeArr);
            } else {
                PathParser.updateNodes(this.mNodes, pathDataNodeArr);
            }
        }

        public void toPath(Path path) {
            path.reset();
            PathParser.PathDataNode[] pathDataNodeArr = this.mNodes;
            if (pathDataNodeArr != null) {
                PathParser.PathDataNode.nodesToPath(pathDataNodeArr, path);
            }
        }
    }

    public static class VPathRenderer {
        public static final Matrix IDENTITY_MATRIX = new Matrix();
        public float mBaseHeight;
        public float mBaseWidth;
        public int mChangingConfigurations;
        public Paint mFillPaint;
        public final Matrix mFinalPathMatrix;
        public final Path mPath;
        public PathMeasure mPathMeasure;
        public final Path mRenderPath;
        public int mRootAlpha;
        public final VGroup mRootGroup;
        public String mRootName;
        public Paint mStrokePaint;
        public final ArrayMap<String, Object> mVGTargetsMap;
        public float mViewportHeight;
        public float mViewportWidth;

        public VPathRenderer() {
            this.mFinalPathMatrix = new Matrix();
            this.mBaseWidth = 0.0f;
            this.mBaseHeight = 0.0f;
            this.mViewportWidth = 0.0f;
            this.mViewportHeight = 0.0f;
            this.mRootAlpha = 255;
            this.mRootName = null;
            this.mVGTargetsMap = new ArrayMap<>();
            this.mRootGroup = new VGroup();
            this.mPath = new Path();
            this.mRenderPath = new Path();
        }

        public VPathRenderer(VPathRenderer vPathRenderer) {
            this.mFinalPathMatrix = new Matrix();
            this.mBaseWidth = 0.0f;
            this.mBaseHeight = 0.0f;
            this.mViewportWidth = 0.0f;
            this.mViewportHeight = 0.0f;
            this.mRootAlpha = 255;
            this.mRootName = null;
            ArrayMap<String, Object> arrayMap = new ArrayMap<>();
            this.mVGTargetsMap = arrayMap;
            this.mRootGroup = new VGroup(vPathRenderer.mRootGroup, arrayMap);
            this.mPath = new Path(vPathRenderer.mPath);
            this.mRenderPath = new Path(vPathRenderer.mRenderPath);
            this.mBaseWidth = vPathRenderer.mBaseWidth;
            this.mBaseHeight = vPathRenderer.mBaseHeight;
            this.mViewportWidth = vPathRenderer.mViewportWidth;
            this.mViewportHeight = vPathRenderer.mViewportHeight;
            this.mChangingConfigurations = vPathRenderer.mChangingConfigurations;
            this.mRootAlpha = vPathRenderer.mRootAlpha;
            this.mRootName = vPathRenderer.mRootName;
            String str = vPathRenderer.mRootName;
            if (str != null) {
                this.mVGTargetsMap.put(str, this);
            }
        }

        private void drawGroupTree(VGroup vGroup, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            vGroup.mStackedMatrix.set(matrix);
            vGroup.mStackedMatrix.preConcat(vGroup.mLocalMatrix);
            for (int i3 = 0; i3 < vGroup.mChildren.size(); i3++) {
                Object obj = vGroup.mChildren.get(i3);
                if (obj instanceof VGroup) {
                    drawGroupTree((VGroup) obj, vGroup.mStackedMatrix, canvas, i, i2, colorFilter);
                } else if (obj instanceof VPath) {
                    drawPath(vGroup, (VPath) obj, canvas, i, i2, colorFilter);
                }
            }
        }

        private void drawPath(VGroup vGroup, VPath vPath, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = ((float) i) / this.mViewportWidth;
            float f2 = ((float) i2) / this.mViewportHeight;
            float min = Math.min(f, f2);
            this.mFinalPathMatrix.set(vGroup.mStackedMatrix);
            this.mFinalPathMatrix.postScale(f, f2);
            vPath.toPath(this.mPath);
            Path path = this.mPath;
            this.mRenderPath.reset();
            if (vPath.isClipPath()) {
                this.mRenderPath.addPath(path, this.mFinalPathMatrix);
                canvas.clipPath(this.mRenderPath, Region.Op.REPLACE);
                return;
            }
            VFullPath vFullPath = (VFullPath) vPath;
            if (!(vFullPath.mTrimPathStart == 0.0f && vFullPath.mTrimPathEnd == 1.0f)) {
                float f3 = vFullPath.mTrimPathStart;
                float f4 = vFullPath.mTrimPathOffset;
                float f5 = (f3 + f4) % 1.0f;
                float f6 = (vFullPath.mTrimPathEnd + f4) % 1.0f;
                if (this.mPathMeasure == null) {
                    this.mPathMeasure = new PathMeasure();
                }
                this.mPathMeasure.setPath(this.mPath, false);
                float length = this.mPathMeasure.getLength();
                float f7 = f5 * length;
                float f8 = f6 * length;
                path.reset();
                if (f7 > f8) {
                    this.mPathMeasure.getSegment(f7, length, path, true);
                    this.mPathMeasure.getSegment(0.0f, f8, path, true);
                } else {
                    this.mPathMeasure.getSegment(f7, f8, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.mRenderPath.addPath(path, this.mFinalPathMatrix);
            if (vFullPath.mFillColor != 0) {
                if (this.mFillPaint == null) {
                    Paint paint = new Paint();
                    this.mFillPaint = paint;
                    paint.setStyle(Paint.Style.FILL);
                    this.mFillPaint.setAntiAlias(true);
                }
                Paint paint2 = this.mFillPaint;
                paint2.setColor(VectorDrawable.applyAlpha(vFullPath.mFillColor, vFullPath.mFillAlpha));
                paint2.setColorFilter(colorFilter);
                canvas.drawPath(this.mRenderPath, paint2);
            }
            if (vFullPath.mStrokeColor != 0) {
                if (this.mStrokePaint == null) {
                    Paint paint3 = new Paint();
                    this.mStrokePaint = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                    this.mStrokePaint.setAntiAlias(true);
                }
                Paint paint4 = this.mStrokePaint;
                Paint.Join join = vFullPath.mStrokeLineJoin;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = vFullPath.mStrokeLineCap;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(vFullPath.mStrokeMiterlimit);
                paint4.setColor(VectorDrawable.applyAlpha(vFullPath.mStrokeColor, vFullPath.mStrokeAlpha));
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(vFullPath.mStrokeWidth * min);
                canvas.drawPath(this.mRenderPath, paint4);
            }
        }

        private void recursiveApplyTheme(VGroup vGroup, Resources.Theme theme) {
            ArrayList<Object> arrayList = vGroup.mChildren;
            for (int i = 0; i < arrayList.size(); i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof VGroup) {
                    VGroup vGroup2 = (VGroup) obj;
                    if (vGroup2.canApplyTheme()) {
                        vGroup2.applyTheme(theme);
                    }
                    recursiveApplyTheme(vGroup2, theme);
                } else if (obj instanceof VPath) {
                    VPath vPath = (VPath) obj;
                    if (vPath.canApplyTheme()) {
                        vPath.applyTheme(theme);
                    }
                }
            }
        }

        private boolean recursiveCanApplyTheme(VGroup vGroup) {
            ArrayList<Object> arrayList = vGroup.mChildren;
            for (int i = 0; i < arrayList.size(); i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof VGroup) {
                    VGroup vGroup2 = (VGroup) obj;
                    if (vGroup2.canApplyTheme() || recursiveCanApplyTheme(vGroup2)) {
                        return true;
                    }
                } else if ((obj instanceof VPath) && ((VPath) obj).canApplyTheme()) {
                    return true;
                }
            }
            return false;
        }

        public void applyTheme(Resources.Theme theme) {
            recursiveApplyTheme(this.mRootGroup, theme);
        }

        public boolean canApplyTheme() {
            return recursiveCanApplyTheme(this.mRootGroup);
        }

        public void draw(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            drawGroupTree(this.mRootGroup, IDENTITY_MATRIX, canvas, i, i2, colorFilter);
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public int getRootAlpha() {
            return this.mRootAlpha;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public void setRootAlpha(int i) {
            this.mRootAlpha = i;
        }
    }

    public static class VectorDrawableState extends DrawableCompat.ConstantStateCompat {
        public boolean mAutoMirrored;
        public boolean mCacheDirty;
        public boolean mCachedAutoMirrored;
        public Bitmap mCachedBitmap;
        public int mCachedRootAlpha;
        public int[] mCachedThemeAttrs;
        public ColorStateList mCachedTint;
        public PorterDuff.Mode mCachedTintMode;
        public int mChangingConfigurations;
        public Paint mTempPaint;
        public int[] mThemeAttrs;
        public ColorStateList mTint;
        public PorterDuff.Mode mTintMode;
        public VPathRenderer mVPathRenderer;

        public VectorDrawableState() {
            this.mTint = null;
            this.mTintMode = VectorDrawable.DEFAULT_TINT_MODE;
            this.mVPathRenderer = new VPathRenderer();
        }

        public VectorDrawableState(VectorDrawableState vectorDrawableState) {
            this.mTint = null;
            this.mTintMode = VectorDrawable.DEFAULT_TINT_MODE;
            if (vectorDrawableState != null) {
                this.mThemeAttrs = vectorDrawableState.mThemeAttrs;
                this.mChangingConfigurations = vectorDrawableState.mChangingConfigurations;
                this.mVPathRenderer = new VPathRenderer(vectorDrawableState.mVPathRenderer);
                if (vectorDrawableState.mVPathRenderer.mFillPaint != null) {
                    Paint unused = this.mVPathRenderer.mFillPaint = new Paint(vectorDrawableState.mVPathRenderer.mFillPaint);
                }
                if (vectorDrawableState.mVPathRenderer.mStrokePaint != null) {
                    Paint unused2 = this.mVPathRenderer.mStrokePaint = new Paint(vectorDrawableState.mVPathRenderer.mStrokePaint);
                }
                this.mTint = vectorDrawableState.mTint;
                this.mTintMode = vectorDrawableState.mTintMode;
                this.mAutoMirrored = vectorDrawableState.mAutoMirrored;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
            r0 = r1.mVPathRenderer;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean canApplyTheme() {
            /*
                r1 = this;
                boolean r0 = super.canApplyTheme()
                if (r0 != 0) goto L_0x0017
                int[] r0 = r1.mThemeAttrs
                if (r0 != 0) goto L_0x0017
                com.wnafee.vector.compat.VectorDrawable$VPathRenderer r0 = r1.mVPathRenderer
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
            throw new UnsupportedOperationException("Method not decompiled: com.wnafee.vector.compat.VectorDrawable.VectorDrawableState.canApplyTheme():boolean");
        }

        public boolean canReuseBitmap(int i, int i2) {
            return i == this.mCachedBitmap.getWidth() && i2 == this.mCachedBitmap.getHeight();
        }

        public boolean canReuseCache() {
            return !this.mCacheDirty && this.mCachedThemeAttrs == this.mThemeAttrs && this.mCachedTint == this.mTint && this.mCachedTintMode == this.mTintMode && this.mCachedAutoMirrored == this.mAutoMirrored && this.mCachedRootAlpha == this.mVPathRenderer.getRootAlpha();
        }

        public void createCachedBitmapIfNeeded(Rect rect) {
            if (this.mCachedBitmap == null || !canReuseBitmap(rect.width(), rect.height())) {
                this.mCachedBitmap = Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.ARGB_8888);
                this.mCacheDirty = true;
            }
        }

        public void drawCachedBitmapWithRootAlpha(Canvas canvas, ColorFilter colorFilter) {
            canvas.drawBitmap(this.mCachedBitmap, 0.0f, 0.0f, getPaint(colorFilter));
        }

        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        public Paint getPaint(ColorFilter colorFilter) {
            if (!hasTranslucentRoot() && colorFilter == null) {
                return null;
            }
            if (this.mTempPaint == null) {
                Paint paint = new Paint();
                this.mTempPaint = paint;
                paint.setFilterBitmap(true);
            }
            this.mTempPaint.setAlpha(this.mVPathRenderer.getRootAlpha());
            this.mTempPaint.setColorFilter(colorFilter);
            return this.mTempPaint;
        }

        public boolean hasTranslucentRoot() {
            return this.mVPathRenderer.getRootAlpha() < 255;
        }

        public Drawable newDrawable() {
            return new VectorDrawable(this, (Resources) null, (Resources.Theme) null);
        }

        public Drawable newDrawable(Resources resources) {
            return new VectorDrawable(this, resources, (Resources.Theme) null);
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            return new VectorDrawable(this, resources, theme);
        }

        public void updateCacheStates() {
            this.mCachedThemeAttrs = this.mThemeAttrs;
            this.mCachedTint = this.mTint;
            this.mCachedTintMode = this.mTintMode;
            this.mCachedRootAlpha = this.mVPathRenderer.getRootAlpha();
            this.mCachedAutoMirrored = this.mAutoMirrored;
            this.mCacheDirty = false;
        }

        public void updateCachedBitmap(Rect rect) {
            this.mCachedBitmap.eraseColor(0);
            this.mVPathRenderer.draw(new Canvas(this.mCachedBitmap), rect.width(), rect.height(), (ColorFilter) null);
        }
    }

    public VectorDrawable() {
        this.mAllowCaching = true;
        this.mVectorState = new VectorDrawableState();
    }

    public VectorDrawable(VectorDrawableState vectorDrawableState, Resources resources, Resources.Theme theme) {
        this.mAllowCaching = true;
        if (theme == null || !vectorDrawableState.canApplyTheme()) {
            this.mVectorState = vectorDrawableState;
        } else {
            this.mVectorState = new VectorDrawableState(vectorDrawableState);
            applyTheme(theme);
        }
        this.mTintFilter = updateTintFilter(this.mTintFilter, vectorDrawableState.mTint, vectorDrawableState.mTintMode);
    }

    public static int applyAlpha(int i, float f) {
        return (i & ViewCompat.MEASURED_SIZE_MASK) | (((int) (((float) Color.alpha(i)) * f)) << 24);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0035 A[Catch:{ IOException | XmlPullParserException -> 0x003d }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0018 A[Catch:{ IOException | XmlPullParserException -> 0x003d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.wnafee.vector.compat.VectorDrawable create(android.content.res.Resources r6, int r7) {
        /*
            java.lang.String r0 = "parser error"
            r1 = 0
            android.content.res.XmlResourceParser r7 = r6.getXml(r7)     // Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r7)     // Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }
        L_0x000b:
            int r3 = r7.next()     // Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }
            r4 = 2
            if (r3 == r4) goto L_0x0016
            r5 = 1
            if (r3 == r5) goto L_0x0016
            goto L_0x000b
        L_0x0016:
            if (r3 != r4) goto L_0x0035
            java.lang.String r3 = "vector"
            java.lang.String r4 = r7.getName()     // Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }
            boolean r3 = r3.equals(r4)     // Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }
            if (r3 == 0) goto L_0x002d
            com.wnafee.vector.compat.VectorDrawable r3 = new com.wnafee.vector.compat.VectorDrawable     // Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }
            r3.<init>()     // Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }
            r3.inflate(r6, r7, r2, r1)     // Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }
            return r3
        L_0x002d:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException     // Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }
            java.lang.String r7 = "root node must start with: vector"
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }
            throw r6     // Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }
        L_0x0035:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }
            throw r6     // Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }
        L_0x003d:
            r6 = move-exception
            goto L_0x0040
        L_0x003f:
            r6 = move-exception
        L_0x0040:
            java.lang.String r7 = LOGTAG
            android.util.Log.e(r7, r0, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wnafee.vector.compat.VectorDrawable.create(android.content.res.Resources, int):com.wnafee.vector.compat.VectorDrawable");
    }

    public static int getChangingConfigurations(TypedArray typedArray) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getChangingConfigurations();
        }
        return 0;
    }

    public static VectorDrawable getDrawable(Context context, int i) {
        return create(context.getResources(), i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: com.wnafee.vector.compat.VectorDrawable$VClipPath} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: com.wnafee.vector.compat.VectorDrawable$VFullPath} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: com.wnafee.vector.compat.VectorDrawable$VClipPath} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: com.wnafee.vector.compat.VectorDrawable$VClipPath} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: com.wnafee.vector.compat.VectorDrawable$VClipPath} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void inflateInternal(android.content.res.Resources r10, org.xmlpull.v1.XmlPullParser r11, android.util.AttributeSet r12, android.content.res.Resources.Theme r13) {
        /*
            r9 = this;
            com.wnafee.vector.compat.VectorDrawable$VectorDrawableState r0 = r9.mVectorState
            com.wnafee.vector.compat.VectorDrawable$VPathRenderer r1 = r0.mVPathRenderer
            java.util.Stack r2 = new java.util.Stack
            r2.<init>()
            com.wnafee.vector.compat.VectorDrawable$VGroup r3 = r1.mRootGroup
            r2.push(r3)
            int r3 = r11.getEventType()
            r4 = 1
            r5 = 1
        L_0x0016:
            java.lang.String r6 = "path"
            if (r3 == r4) goto L_0x00bb
            r7 = 2
            java.lang.String r8 = "group"
            if (r3 != r7) goto L_0x00a5
            java.lang.String r3 = r11.getName()
            java.lang.Object r7 = r2.peek()
            com.wnafee.vector.compat.VectorDrawable$VGroup r7 = (com.wnafee.vector.compat.VectorDrawable.VGroup) r7
            boolean r6 = r6.equals(r3)
            if (r6 == 0) goto L_0x004d
            com.wnafee.vector.compat.VectorDrawable$VFullPath r3 = new com.wnafee.vector.compat.VectorDrawable$VFullPath
            r3.<init>()
            r3.inflate(r10, r12, r13)
            java.util.ArrayList<java.lang.Object> r5 = r7.mChildren
            r5.add(r3)
            java.lang.String r5 = r3.getPathName()
            if (r5 == 0) goto L_0x004b
            androidx.collection.ArrayMap<java.lang.String, java.lang.Object> r5 = r1.mVGTargetsMap
            java.lang.String r6 = r3.getPathName()
            r5.put(r6, r3)
        L_0x004b:
            r5 = 0
            goto L_0x0071
        L_0x004d:
            java.lang.String r6 = "clip-path"
            boolean r6 = r6.equals(r3)
            if (r6 == 0) goto L_0x0079
            com.wnafee.vector.compat.VectorDrawable$VClipPath r3 = new com.wnafee.vector.compat.VectorDrawable$VClipPath
            r3.<init>()
            r3.inflate(r10, r12, r13)
            java.util.ArrayList<java.lang.Object> r6 = r7.mChildren
            r6.add(r3)
            java.lang.String r6 = r3.getPathName()
            if (r6 == 0) goto L_0x0071
            androidx.collection.ArrayMap<java.lang.String, java.lang.Object> r6 = r1.mVGTargetsMap
            java.lang.String r7 = r3.getPathName()
            r6.put(r7, r3)
        L_0x0071:
            int r6 = r0.mChangingConfigurations
            int r3 = r3.mChangingConfigurations
        L_0x0075:
            r3 = r3 | r6
            r0.mChangingConfigurations = r3
            goto L_0x00b5
        L_0x0079:
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x00b5
            com.wnafee.vector.compat.VectorDrawable$VGroup r3 = new com.wnafee.vector.compat.VectorDrawable$VGroup
            r3.<init>()
            r3.inflate(r10, r12, r13)
            java.util.ArrayList<java.lang.Object> r6 = r7.mChildren
            r6.add(r3)
            r2.push(r3)
            java.lang.String r6 = r3.getGroupName()
            if (r6 == 0) goto L_0x009e
            androidx.collection.ArrayMap<java.lang.String, java.lang.Object> r6 = r1.mVGTargetsMap
            java.lang.String r7 = r3.getGroupName()
            r6.put(r7, r3)
        L_0x009e:
            int r6 = r0.mChangingConfigurations
            int r3 = r3.mChangingConfigurations
            goto L_0x0075
        L_0x00a5:
            r6 = 3
            if (r3 != r6) goto L_0x00b5
            java.lang.String r3 = r11.getName()
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x00b5
            r2.pop()
        L_0x00b5:
            int r3 = r11.next()
            goto L_0x0016
        L_0x00bb:
            if (r5 == 0) goto L_0x00ec
            java.lang.StringBuffer r10 = new java.lang.StringBuffer
            r10.<init>()
            int r11 = r10.length()
            if (r11 <= 0) goto L_0x00cd
            java.lang.String r11 = " or "
            r10.append(r11)
        L_0x00cd:
            r10.append(r6)
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "no "
            r12.append(r13)
            r12.append(r10)
            java.lang.String r10 = " defined"
            r12.append(r10)
            java.lang.String r10 = r12.toString()
            r11.<init>(r10)
            throw r11
        L_0x00ec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wnafee.vector.compat.VectorDrawable.inflateInternal(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    private boolean needMirroring() {
        return isAutoMirrored() && getLayoutDirection() == 1;
    }

    private void printGroupTree(VGroup vGroup, int i) {
        String str = "";
        for (int i2 = 0; i2 < i; i2++) {
            str = a.k(str, "    ");
        }
        String str2 = LOGTAG;
        StringBuilder p = a.p(str, "current group is :");
        p.append(vGroup.getGroupName());
        p.append(" rotation is ");
        p.append(vGroup.mRotate);
        Log.v(str2, p.toString());
        String str3 = LOGTAG;
        StringBuilder p2 = a.p(str, "matrix is :");
        p2.append(vGroup.getLocalMatrix().toString());
        Log.v(str3, p2.toString());
        for (int i3 = 0; i3 < vGroup.mChildren.size(); i3++) {
            Object obj = vGroup.mChildren.get(i3);
            if (obj instanceof VGroup) {
                printGroupTree((VGroup) obj, i + 1);
            }
        }
    }

    private void updateStateFromTypedArray(TypedArray typedArray) {
        VectorDrawableState vectorDrawableState = this.mVectorState;
        VPathRenderer vPathRenderer = vectorDrawableState.mVPathRenderer;
        vectorDrawableState.mChangingConfigurations |= getChangingConfigurations(typedArray);
        int i = typedArray.getInt(R.styleable.VectorDrawable_vc_tintMode, -1);
        if (i != -1) {
            vectorDrawableState.mTintMode = DrawableCompat.parseTintMode(i, PorterDuff.Mode.SRC_IN);
        }
        ColorStateList colorStateList = typedArray.getColorStateList(R.styleable.VectorDrawable_vc_tint);
        if (colorStateList != null) {
            vectorDrawableState.mTint = colorStateList;
        }
        vectorDrawableState.mAutoMirrored = typedArray.getBoolean(R.styleable.VectorDrawable_vc_autoMirrored, vectorDrawableState.mAutoMirrored);
        vPathRenderer.mViewportWidth = typedArray.getFloat(R.styleable.VectorDrawable_vc_viewportWidth, vPathRenderer.mViewportWidth);
        float f = typedArray.getFloat(R.styleable.VectorDrawable_vc_viewportHeight, vPathRenderer.mViewportHeight);
        vPathRenderer.mViewportHeight = f;
        if (vPathRenderer.mViewportWidth <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<menu_vector> tag requires viewportWidth > 0");
        } else if (f > 0.0f) {
            vPathRenderer.mBaseWidth = typedArray.getDimension(R.styleable.VectorDrawable_android_width, vPathRenderer.mBaseWidth);
            float dimension = typedArray.getDimension(R.styleable.VectorDrawable_android_height, vPathRenderer.mBaseHeight);
            vPathRenderer.mBaseHeight = dimension;
            if (vPathRenderer.mBaseWidth <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<menu_vector> tag requires width > 0");
            } else if (dimension > 0.0f) {
                vPathRenderer.setAlpha(typedArray.getFloat(R.styleable.VectorDrawable_android_alpha, vPathRenderer.getAlpha()));
                String string = typedArray.getString(R.styleable.VectorDrawable_android_name);
                if (string != null) {
                    vPathRenderer.mRootName = string;
                    vPathRenderer.mVGTargetsMap.put(string, vPathRenderer);
                }
            } else {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<menu_vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<menu_vector> tag requires viewportHeight > 0");
        }
    }

    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        VectorDrawableState vectorDrawableState = this.mVectorState;
        if (vectorDrawableState == null || vectorDrawableState.mThemeAttrs == null) {
            VPathRenderer vPathRenderer = vectorDrawableState.mVPathRenderer;
            if (vPathRenderer != null && vPathRenderer.canApplyTheme()) {
                vPathRenderer.applyTheme(theme);
                return;
            }
            return;
        }
        try {
            vectorDrawableState.mCacheDirty = true;
            updateStateFromTypedArray((TypedArray) null);
            throw null;
        } catch (XmlPullParserException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.mVectorState;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean canApplyTheme() {
        /*
            r1 = this;
            boolean r0 = super.canApplyTheme()
            if (r0 != 0) goto L_0x0013
            com.wnafee.vector.compat.VectorDrawable$VectorDrawableState r0 = r1.mVectorState
            if (r0 == 0) goto L_0x0011
            boolean r0 = r0.canApplyTheme()
            if (r0 == 0) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            r0 = 0
            goto L_0x0014
        L_0x0013:
            r0 = 1
        L_0x0014:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wnafee.vector.compat.VectorDrawable.canApplyTheme():boolean");
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.width() != 0 && bounds.height() != 0) {
            int save = canvas.save();
            boolean needMirroring = needMirroring();
            canvas.translate((float) bounds.left, (float) bounds.top);
            if (needMirroring) {
                canvas.translate((float) bounds.width(), 0.0f);
                canvas.scale(-1.0f, 1.0f);
            }
            ColorFilter colorFilter = this.mColorFilter;
            if (colorFilter == null) {
                colorFilter = this.mTintFilter;
            }
            if (this.mAllowCaching) {
                this.mVectorState.createCachedBitmapIfNeeded(bounds);
                if (!this.mVectorState.canReuseCache()) {
                    this.mVectorState.updateCachedBitmap(bounds);
                    this.mVectorState.updateCacheStates();
                }
            } else if (!this.mVectorState.hasTranslucentRoot()) {
                this.mVectorState.mVPathRenderer.draw(canvas, bounds.width(), bounds.height(), colorFilter);
                canvas.restoreToCount(save);
            } else {
                this.mVectorState.createCachedBitmapIfNeeded(bounds);
                this.mVectorState.updateCachedBitmap(bounds);
            }
            this.mVectorState.drawCachedBitmapWithRootAlpha(canvas, colorFilter);
            canvas.restoreToCount(save);
        }
    }

    public int getAlpha() {
        return this.mVectorState.mVPathRenderer.getRootAlpha();
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.mVectorState.mChangingConfigurations;
    }

    public Drawable.ConstantState getConstantState() {
        this.mVectorState.mChangingConfigurations = getChangingConfigurations();
        return this.mVectorState;
    }

    public int getIntrinsicHeight() {
        return (int) this.mVectorState.mVPathRenderer.mBaseHeight;
    }

    public int getIntrinsicWidth() {
        return (int) this.mVectorState.mVPathRenderer.mBaseWidth;
    }

    public int getOpacity() {
        return -3;
    }

    public float getPixelSize() {
        VectorDrawableState vectorDrawableState = this.mVectorState;
        if (vectorDrawableState == null && vectorDrawableState.mVPathRenderer == null) {
            return 1.0f;
        }
        VPathRenderer vPathRenderer = this.mVectorState.mVPathRenderer;
        float f = vPathRenderer.mBaseWidth;
        if (f == 0.0f) {
            return 1.0f;
        }
        float f2 = vPathRenderer.mBaseHeight;
        if (f2 == 0.0f) {
            return 1.0f;
        }
        float f3 = vPathRenderer.mViewportHeight;
        if (f3 == 0.0f) {
            return 1.0f;
        }
        float f4 = vPathRenderer.mViewportWidth;
        if (f4 == 0.0f) {
            return 1.0f;
        }
        return Math.min(f4 / f, f3 / f2);
    }

    public Object getTargetByName(String str) {
        return this.mVectorState.mVPathRenderer.mVGTargetsMap.get(str);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        VectorDrawableState vectorDrawableState = this.mVectorState;
        vectorDrawableState.mVPathRenderer = new VPathRenderer();
        TypedArray obtainAttributes = DrawableCompat.obtainAttributes(resources, theme, attributeSet, R.styleable.VectorDrawable);
        updateStateFromTypedArray(obtainAttributes);
        obtainAttributes.recycle();
        vectorDrawableState.mCacheDirty = true;
        inflateInternal(resources, xmlPullParser, attributeSet, theme);
        this.mTintFilter = updateTintFilter(this.mTintFilter, vectorDrawableState.mTint, vectorDrawableState.mTintMode);
    }

    public boolean isAutoMirrored() {
        return this.mVectorState.mAutoMirrored;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = (r0 = r1.mVectorState).mTint;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            boolean r0 = super.isStateful()
            if (r0 != 0) goto L_0x0017
            com.wnafee.vector.compat.VectorDrawable$VectorDrawableState r0 = r1.mVectorState
            if (r0 == 0) goto L_0x0015
            android.content.res.ColorStateList r0 = r0.mTint
            if (r0 == 0) goto L_0x0015
            boolean r0 = r0.isStateful()
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
        throw new UnsupportedOperationException("Method not decompiled: com.wnafee.vector.compat.VectorDrawable.isStateful():boolean");
    }

    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mVectorState = new VectorDrawableState(this.mVectorState);
            this.mMutated = true;
        }
        return this;
    }

    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        VectorDrawableState vectorDrawableState = this.mVectorState;
        ColorStateList colorStateList = vectorDrawableState.mTint;
        if (colorStateList == null || (mode = vectorDrawableState.mTintMode) == null) {
            return false;
        }
        this.mTintFilter = updateTintFilter(this.mTintFilter, colorStateList, mode);
        invalidateSelf();
        return true;
    }

    public void setAllowCaching(boolean z) {
        this.mAllowCaching = z;
    }

    public void setAlpha(int i) {
        if (this.mVectorState.mVPathRenderer.getRootAlpha() != i) {
            this.mVectorState.mVPathRenderer.setRootAlpha(i);
            invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean z) {
        VectorDrawableState vectorDrawableState = this.mVectorState;
        if (vectorDrawableState.mAutoMirrored != z) {
            vectorDrawableState.mAutoMirrored = z;
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        invalidateSelf();
    }

    public void setTintList(ColorStateList colorStateList) {
        VectorDrawableState vectorDrawableState = this.mVectorState;
        if (vectorDrawableState.mTint != colorStateList) {
            vectorDrawableState.mTint = colorStateList;
            this.mTintFilter = updateTintFilter(this.mTintFilter, colorStateList, vectorDrawableState.mTintMode);
            invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        VectorDrawableState vectorDrawableState = this.mVectorState;
        if (vectorDrawableState.mTintMode != mode) {
            vectorDrawableState.mTintMode = mode;
            this.mTintFilter = updateTintFilter(this.mTintFilter, vectorDrawableState.mTint, mode);
            invalidateSelf();
        }
    }
}
