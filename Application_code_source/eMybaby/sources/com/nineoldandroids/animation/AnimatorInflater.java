package com.nineoldandroids.animation;

import a.a.a.a.a;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.animation.AnimationUtils;
import com.nineoldandroids.util.ReflectiveProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatorInflater {
    public static final int[] Animator = {16843073, 16843160, 16843198, 16843199, 16843200, 16843486, 16843487, 16843488};
    public static final int[] AnimatorSet = {16843490};
    public static final int AnimatorSet_ordering = 0;
    public static final int Animator_duration = 1;
    public static final int Animator_interpolator = 0;
    public static final int Animator_repeatCount = 3;
    public static final int Animator_repeatMode = 4;
    public static final int Animator_startOffset = 2;
    public static final int Animator_valueFrom = 5;
    public static final int Animator_valueTo = 6;
    public static final int Animator_valueType = 7;
    public static final int[] PropertyAnimator = {16843489};
    public static final int PropertyAnimator_propertyName = 0;
    public static final int TOGETHER = 0;
    public static final int VALUE_TYPE_FLOAT = 0;

    public static Animator createAnimatorFromXml(Context context, XmlPullParser xmlPullParser) {
        return createAnimatorFromXml(context, xmlPullParser, Xml.asAttributeSet(xmlPullParser), (AnimatorSet) null, 0);
    }

    public static Animator createAnimatorFromXml(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i) {
        int i2;
        Animator animator;
        ObjectAnimator objectAnimator;
        int depth = xmlPullParser.getDepth();
        ArrayList arrayList = null;
        Animator animator2 = null;
        while (true) {
            int next = xmlPullParser.next();
            i2 = 0;
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next != 2) {
                    animator = animator2;
                } else {
                    String name = xmlPullParser.getName();
                    if (name.equals("objectAnimator")) {
                        objectAnimator = loadObjectAnimator(context, attributeSet);
                    } else if (name.equals("animator")) {
                        objectAnimator = loadAnimator(context, attributeSet, (ValueAnimator) null);
                    } else if (name.equals(ReflectiveProperty.PREFIX_SET)) {
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AnimatorSet);
                        TypedValue typedValue = new TypedValue();
                        obtainStyledAttributes.getValue(0, typedValue);
                        if (typedValue.type == 16) {
                            i2 = typedValue.data;
                        }
                        createAnimatorFromXml(context, xmlPullParser, attributeSet, animatorSet2, i2);
                        obtainStyledAttributes.recycle();
                        objectAnimator = animatorSet2;
                    } else {
                        StringBuilder n = a.n("Unknown animator name: ");
                        n.append(xmlPullParser.getName());
                        throw new RuntimeException(n.toString());
                    }
                    if (animatorSet == null) {
                        animator = objectAnimator;
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(objectAnimator);
                        animator = objectAnimator;
                    }
                }
                animator2 = animator;
            }
        }
        if (!(animatorSet == null || arrayList == null)) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorArr[i2] = (Animator) it.next();
                i2++;
            }
            if (i == 0) {
                animatorSet.playTogether(animatorArr);
            } else {
                animatorSet.playSequentially(animatorArr);
            }
        }
        return animator2;
    }

    public static Animator loadAnimator(Context context, int i) {
        XmlResourceParser xmlResourceParser = null;
        try {
            XmlResourceParser animation = context.getResources().getAnimation(i);
            Animator createAnimatorFromXml = createAnimatorFromXml(context, animation);
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

    public static ValueAnimator loadAnimator(Context context, AttributeSet attributeSet, ValueAnimator valueAnimator) {
        int i;
        Context context2 = context;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, Animator);
        long j = (long) obtainStyledAttributes.getInt(1, 0);
        long j2 = (long) obtainStyledAttributes.getInt(2, 0);
        int i2 = obtainStyledAttributes.getInt(7, 0);
        ValueAnimator valueAnimator2 = valueAnimator == null ? new ValueAnimator() : valueAnimator;
        boolean z = i2 == 0;
        TypedValue peekValue = obtainStyledAttributes.peekValue(5);
        boolean z2 = peekValue != null;
        int i3 = z2 ? peekValue.type : 0;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(6);
        boolean z3 = peekValue2 != null;
        int i4 = z3 ? peekValue2.type : 0;
        if ((z2 && i3 >= 28 && i3 <= 31) || (z3 && i4 >= 28 && i4 <= 31)) {
            valueAnimator2.setEvaluator(new ArgbEvaluator());
            z = false;
        }
        if (!z) {
            i = 0;
            if (z2) {
                int dimension = i3 == 5 ? (int) obtainStyledAttributes.getDimension(5, 0.0f) : (i3 < 28 || i3 > 31) ? obtainStyledAttributes.getInt(5, 0) : obtainStyledAttributes.getColor(5, 0);
                if (z3) {
                    valueAnimator2.setIntValues(dimension, i4 == 5 ? (int) obtainStyledAttributes.getDimension(6, 0.0f) : (i4 < 28 || i4 > 31) ? obtainStyledAttributes.getInt(6, 0) : obtainStyledAttributes.getColor(6, 0));
                } else {
                    valueAnimator2.setIntValues(dimension);
                }
            } else if (z3) {
                valueAnimator2.setIntValues(i4 == 5 ? (int) obtainStyledAttributes.getDimension(6, 0.0f) : (i4 < 28 || i4 > 31) ? obtainStyledAttributes.getInt(6, 0) : obtainStyledAttributes.getColor(6, 0));
            }
        } else if (z2) {
            float dimension2 = i3 == 5 ? obtainStyledAttributes.getDimension(5, 0.0f) : obtainStyledAttributes.getFloat(5, 0.0f);
            if (z3) {
                i = 0;
                valueAnimator2.setFloatValues(dimension2, i4 == 5 ? obtainStyledAttributes.getDimension(6, 0.0f) : obtainStyledAttributes.getFloat(6, 0.0f));
            } else {
                i = 0;
                valueAnimator2.setFloatValues(dimension2);
            }
        } else {
            i = 0;
            valueAnimator2.setFloatValues(i4 == 5 ? obtainStyledAttributes.getDimension(6, 0.0f) : obtainStyledAttributes.getFloat(6, 0.0f));
        }
        valueAnimator2.setDuration(j);
        valueAnimator2.setStartDelay(j2);
        if (obtainStyledAttributes.hasValue(3)) {
            valueAnimator2.setRepeatCount(obtainStyledAttributes.getInt(3, i));
        }
        if (obtainStyledAttributes.hasValue(4)) {
            valueAnimator2.setRepeatMode(obtainStyledAttributes.getInt(4, 1));
        }
        int resourceId = obtainStyledAttributes.getResourceId(i, i);
        if (resourceId > 0) {
            valueAnimator2.setInterpolator(AnimationUtils.loadInterpolator(context2, resourceId));
        }
        obtainStyledAttributes.recycle();
        return valueAnimator2;
    }

    public static ObjectAnimator loadObjectAnimator(Context context, AttributeSet attributeSet) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        loadAnimator(context, attributeSet, objectAnimator);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, PropertyAnimator);
        objectAnimator.setPropertyName(obtainStyledAttributes.getString(0));
        obtainStyledAttributes.recycle();
        return objectAnimator;
    }
}
