package com.wnafee.vector.compat;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.animation.AnimationUtils;
import com.wnafee.vector.R;
import com.wnafee.vector.compat.PathParser;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class PathAnimatorInflater {
    public static final boolean DBG_ANIMATOR_INFLATER = false;
    public static final int SEQUENTIALLY = 1;
    public static final String TAG = "PathAnimatorInflater";
    public static final int TOGETHER = 0;
    public static final int VALUE_TYPE_PATH = 2;

    public static class PathDataEvaluator implements TypeEvaluator<PathParser.PathDataNode[]> {
        public PathParser.PathDataNode[] mNodeArray;

        public PathDataEvaluator() {
        }

        public PathDataEvaluator(PathParser.PathDataNode[] pathDataNodeArr) {
            this.mNodeArray = pathDataNodeArr;
        }

        public PathParser.PathDataNode[] evaluate(float f, PathParser.PathDataNode[] pathDataNodeArr, PathParser.PathDataNode[] pathDataNodeArr2) {
            if (PathParser.canMorph(pathDataNodeArr, pathDataNodeArr2)) {
                PathParser.PathDataNode[] pathDataNodeArr3 = this.mNodeArray;
                if (pathDataNodeArr3 == null || !PathParser.canMorph(pathDataNodeArr3, pathDataNodeArr)) {
                    this.mNodeArray = PathParser.deepCopyNodes(pathDataNodeArr);
                }
                for (int i = 0; i < pathDataNodeArr.length; i++) {
                    this.mNodeArray[i].interpolatePathDataNode(pathDataNodeArr[i], pathDataNodeArr2[i], f);
                }
                return this.mNodeArray;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    public static Animator createAnimatorFromXml(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f) {
        return createAnimatorFromXml(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), (AnimatorSet) null, 0, f);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: android.animation.Animator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: android.animation.Animator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: android.animation.Animator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: android.animation.Animator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: android.animation.Animator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: android.animation.AnimatorSet} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: android.animation.Animator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: android.animation.Animator} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.animation.Animator createAnimatorFromXml(android.content.Context r16, android.content.res.Resources r17, android.content.res.Resources.Theme r18, org.xmlpull.v1.XmlPullParser r19, android.util.AttributeSet r20, android.animation.AnimatorSet r21, int r22, float r23) {
        /*
            r0 = r21
            int r1 = r19.getDepth()
            r2 = 0
            r3 = r2
        L_0x0008:
            int r4 = r19.next()
            r5 = 3
            if (r4 != r5) goto L_0x0015
            int r5 = r19.getDepth()
            if (r5 <= r1) goto L_0x009b
        L_0x0015:
            r5 = 1
            if (r4 == r5) goto L_0x009b
            r5 = 2
            if (r4 == r5) goto L_0x001c
            goto L_0x0008
        L_0x001c:
            java.lang.String r3 = r19.getName()
            java.lang.String r4 = "objectAnimator"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x0037
            r4 = r16
            r13 = r17
            r14 = r18
            r15 = r20
            r12 = r23
            android.animation.ObjectAnimator r3 = loadObjectAnimator(r4, r13, r14, r15, r12)
            goto L_0x0077
        L_0x0037:
            r4 = r16
            r13 = r17
            r14 = r18
            r15 = r20
            r12 = r23
            java.lang.String r5 = "animator"
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L_0x0059
            r9 = 0
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r20
            r10 = r23
            android.animation.ValueAnimator r3 = loadAnimator(r5, r6, r7, r8, r9, r10)
            goto L_0x0077
        L_0x0059:
            java.lang.String r5 = "set"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0084
            android.animation.AnimatorSet r3 = new android.animation.AnimatorSet
            r3.<init>()
            r11 = 0
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r19
            r9 = r20
            r10 = r3
            r12 = r23
            createAnimatorFromXml(r5, r6, r7, r8, r9, r10, r11, r12)
        L_0x0077:
            if (r0 == 0) goto L_0x0008
            if (r2 != 0) goto L_0x0080
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L_0x0080:
            r2.add(r3)
            goto L_0x0008
        L_0x0084:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "Unknown animator name: "
            java.lang.StringBuilder r1 = a.a.a.a.a.n(r1)
            java.lang.String r2 = r19.getName()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x009b:
            if (r0 == 0) goto L_0x00c5
            if (r2 == 0) goto L_0x00c5
            int r1 = r2.size()
            android.animation.Animator[] r1 = new android.animation.Animator[r1]
            r4 = 0
            java.util.Iterator r2 = r2.iterator()
        L_0x00aa:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x00bc
            java.lang.Object r5 = r2.next()
            android.animation.Animator r5 = (android.animation.Animator) r5
            int r6 = r4 + 1
            r1[r4] = r5
            r4 = r6
            goto L_0x00aa
        L_0x00bc:
            if (r22 != 0) goto L_0x00c2
            r0.playTogether(r1)
            goto L_0x00c5
        L_0x00c2:
            r0.playSequentially(r1)
        L_0x00c5:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wnafee.vector.compat.PathAnimatorInflater.createAnimatorFromXml(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.animation.AnimatorSet, int, float):android.animation.Animator");
    }

    public static Animator loadAnimator(Context context, Resources resources, Resources.Theme theme, int i, float f) {
        XmlResourceParser xmlResourceParser = null;
        try {
            XmlResourceParser animation = resources.getAnimation(i);
            Animator createAnimatorFromXml = createAnimatorFromXml(context, resources, theme, animation, f);
            if (animation != null) {
                animation.close();
            }
            return createAnimatorFromXml;
        } catch (XmlPullParserException e2) {
            Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
            notFoundException.initCause(e2);
            throw notFoundException;
        } catch (IOException e3) {
            Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
            notFoundException2.initCause(e3);
            throw notFoundException2;
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    public static ValueAnimator loadAnimator(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f) {
        int[] iArr = R.styleable.Animator;
        TypedArray obtainStyledAttributes = theme != null ? theme.obtainStyledAttributes(attributeSet, iArr, 0, 0) : resources.obtainAttributes(attributeSet, iArr);
        TypedArray obtainStyledAttributes2 = valueAnimator != null ? theme != null ? theme.obtainStyledAttributes(attributeSet, R.styleable.PropertyAnimator, 0, 0) : resources.obtainAttributes(attributeSet, R.styleable.PropertyAnimator) : null;
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        parseAnimatorFromTypeArray(valueAnimator, obtainStyledAttributes, obtainStyledAttributes2);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.Animator_android_interpolator, 0);
        if (resourceId > 0) {
            valueAnimator.setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
        }
        obtainStyledAttributes.recycle();
        if (obtainStyledAttributes2 != null) {
            obtainStyledAttributes2.recycle();
        }
        return valueAnimator;
    }

    public static ObjectAnimator loadObjectAnimator(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        loadAnimator(context, resources, theme, attributeSet, objectAnimator, f);
        return objectAnimator;
    }

    public static void parseAnimatorFromTypeArray(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2) {
        long j = (long) typedArray.getInt(R.styleable.Animator_android_duration, 300);
        long j2 = (long) typedArray.getInt(R.styleable.Animator_android_startOffset, 0);
        if (typedArray.getInt(R.styleable.Animator_vc_valueType, 0) == 2) {
            TypeEvaluator typeEvaluator = setupAnimatorForPath(valueAnimator, typedArray);
            valueAnimator.setDuration(j);
            valueAnimator.setStartDelay(j2);
            if (typedArray.hasValue(R.styleable.Animator_android_repeatCount)) {
                valueAnimator.setRepeatCount(typedArray.getInt(R.styleable.Animator_android_repeatCount, 0));
            }
            if (typedArray.hasValue(R.styleable.Animator_android_repeatMode)) {
                valueAnimator.setRepeatMode(typedArray.getInt(R.styleable.Animator_android_repeatMode, 1));
            }
            if (typeEvaluator != null) {
                valueAnimator.setEvaluator(typeEvaluator);
            }
            if (typedArray2 != null) {
                setupObjectAnimator(valueAnimator, typedArray2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("target is not a pathType target");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.animation.TypeEvaluator setupAnimatorForPath(android.animation.ValueAnimator r7, android.content.res.TypedArray r8) {
        /*
            int r0 = com.wnafee.vector.R.styleable.Animator_android_valueFrom
            java.lang.String r0 = r8.getString(r0)
            int r1 = com.wnafee.vector.R.styleable.Animator_android_valueTo
            java.lang.String r1 = r8.getString(r1)
            com.wnafee.vector.compat.PathParser$PathDataNode[] r2 = com.wnafee.vector.compat.PathParser.createNodesFromPathData(r0)
            com.wnafee.vector.compat.PathParser$PathDataNode[] r3 = com.wnafee.vector.compat.PathParser.createNodesFromPathData(r1)
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x0062
            if (r3 == 0) goto L_0x0051
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r4] = r2
            r6[r5] = r3
            r7.setObjectValues(r6)
            boolean r7 = com.wnafee.vector.compat.PathParser.canMorph(r2, r3)
            if (r7 == 0) goto L_0x002b
            goto L_0x0058
        L_0x002b:
            android.view.InflateException r7 = new android.view.InflateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r8 = r8.getPositionDescription()
            r2.append(r8)
            java.lang.String r8 = " Can't morph from "
            r2.append(r8)
            r2.append(r0)
            java.lang.String r8 = " to "
            r2.append(r8)
            r2.append(r1)
            java.lang.String r8 = r2.toString()
            r7.<init>(r8)
            throw r7
        L_0x0051:
            java.lang.Object[] r8 = new java.lang.Object[r5]
            r8[r4] = r2
            r7.setObjectValues(r8)
        L_0x0058:
            com.wnafee.vector.compat.PathAnimatorInflater$PathDataEvaluator r7 = new com.wnafee.vector.compat.PathAnimatorInflater$PathDataEvaluator
            com.wnafee.vector.compat.PathParser$PathDataNode[] r8 = com.wnafee.vector.compat.PathParser.deepCopyNodes(r2)
            r7.<init>(r8)
            goto L_0x0076
        L_0x0062:
            if (r3 == 0) goto L_0x0075
            java.lang.Object[] r8 = new java.lang.Object[r5]
            r8[r4] = r3
            r7.setObjectValues(r8)
            com.wnafee.vector.compat.PathAnimatorInflater$PathDataEvaluator r7 = new com.wnafee.vector.compat.PathAnimatorInflater$PathDataEvaluator
            com.wnafee.vector.compat.PathParser$PathDataNode[] r8 = com.wnafee.vector.compat.PathParser.deepCopyNodes(r3)
            r7.<init>(r8)
            goto L_0x0076
        L_0x0075:
            r7 = 0
        L_0x0076:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wnafee.vector.compat.PathAnimatorInflater.setupAnimatorForPath(android.animation.ValueAnimator, android.content.res.TypedArray):android.animation.TypeEvaluator");
    }

    public static void setupObjectAnimator(ValueAnimator valueAnimator, TypedArray typedArray) {
        ((ObjectAnimator) valueAnimator).setPropertyName(typedArray.getString(R.styleable.PropertyAnimator_android_propertyName));
    }
}
