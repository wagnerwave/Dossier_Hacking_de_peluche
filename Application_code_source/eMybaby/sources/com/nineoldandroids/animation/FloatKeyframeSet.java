package com.nineoldandroids.animation;

import a.a.a.a.a;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Keyframe;
import java.util.ArrayList;

public class FloatKeyframeSet extends KeyframeSet {
    public float deltaValue;
    public boolean firstTime = true;
    public float firstValue;
    public float lastValue;

    public FloatKeyframeSet(Keyframe.FloatKeyframe... floatKeyframeArr) {
        super(floatKeyframeArr);
    }

    public FloatKeyframeSet clone() {
        ArrayList<Keyframe> arrayList = this.mKeyframes;
        int size = arrayList.size();
        Keyframe.FloatKeyframe[] floatKeyframeArr = new Keyframe.FloatKeyframe[size];
        for (int i = 0; i < size; i++) {
            floatKeyframeArr[i] = (Keyframe.FloatKeyframe) arrayList.get(i).clone();
        }
        return new FloatKeyframeSet(floatKeyframeArr);
    }

    public float getFloatValue(float f) {
        int i = this.mNumKeyframes;
        if (i == 2) {
            if (this.firstTime) {
                this.firstTime = false;
                this.firstValue = ((Keyframe.FloatKeyframe) this.mKeyframes.get(0)).getFloatValue();
                float floatValue = ((Keyframe.FloatKeyframe) this.mKeyframes.get(1)).getFloatValue();
                this.lastValue = floatValue;
                this.deltaValue = floatValue - this.firstValue;
            }
            Interpolator interpolator = this.mInterpolator;
            if (interpolator != null) {
                f = interpolator.getInterpolation(f);
            }
            TypeEvaluator typeEvaluator = this.mEvaluator;
            if (typeEvaluator != null) {
                return ((Number) typeEvaluator.evaluate(f, Float.valueOf(this.firstValue), Float.valueOf(this.lastValue))).floatValue();
            }
            return (f * this.deltaValue) + this.firstValue;
        } else if (f <= 0.0f) {
            Keyframe.FloatKeyframe floatKeyframe = (Keyframe.FloatKeyframe) this.mKeyframes.get(0);
            Keyframe.FloatKeyframe floatKeyframe2 = (Keyframe.FloatKeyframe) this.mKeyframes.get(1);
            float floatValue2 = floatKeyframe.getFloatValue();
            float floatValue3 = floatKeyframe2.getFloatValue();
            float fraction = floatKeyframe.getFraction();
            float fraction2 = floatKeyframe2.getFraction();
            Interpolator interpolator2 = floatKeyframe2.getInterpolator();
            if (interpolator2 != null) {
                f = interpolator2.getInterpolation(f);
            }
            float f2 = (f - fraction) / (fraction2 - fraction);
            TypeEvaluator typeEvaluator2 = this.mEvaluator;
            return typeEvaluator2 == null ? a.a(floatValue3, floatValue2, f2, floatValue2) : ((Number) typeEvaluator2.evaluate(f2, Float.valueOf(floatValue2), Float.valueOf(floatValue3))).floatValue();
        } else if (f >= 1.0f) {
            Keyframe.FloatKeyframe floatKeyframe3 = (Keyframe.FloatKeyframe) this.mKeyframes.get(i - 2);
            Keyframe.FloatKeyframe floatKeyframe4 = (Keyframe.FloatKeyframe) this.mKeyframes.get(this.mNumKeyframes - 1);
            float floatValue4 = floatKeyframe3.getFloatValue();
            float floatValue5 = floatKeyframe4.getFloatValue();
            float fraction3 = floatKeyframe3.getFraction();
            float fraction4 = floatKeyframe4.getFraction();
            Interpolator interpolator3 = floatKeyframe4.getInterpolator();
            if (interpolator3 != null) {
                f = interpolator3.getInterpolation(f);
            }
            float f3 = (f - fraction3) / (fraction4 - fraction3);
            TypeEvaluator typeEvaluator3 = this.mEvaluator;
            return typeEvaluator3 == null ? a.a(floatValue5, floatValue4, f3, floatValue4) : ((Number) typeEvaluator3.evaluate(f3, Float.valueOf(floatValue4), Float.valueOf(floatValue5))).floatValue();
        } else {
            Keyframe.FloatKeyframe floatKeyframe5 = (Keyframe.FloatKeyframe) this.mKeyframes.get(0);
            int i2 = 1;
            while (true) {
                int i3 = this.mNumKeyframes;
                if (i2 >= i3) {
                    return ((Number) this.mKeyframes.get(i3 - 1).getValue()).floatValue();
                }
                Keyframe.FloatKeyframe floatKeyframe6 = (Keyframe.FloatKeyframe) this.mKeyframes.get(i2);
                if (f < floatKeyframe6.getFraction()) {
                    Interpolator interpolator4 = floatKeyframe6.getInterpolator();
                    if (interpolator4 != null) {
                        f = interpolator4.getInterpolation(f);
                    }
                    float fraction5 = (f - floatKeyframe5.getFraction()) / (floatKeyframe6.getFraction() - floatKeyframe5.getFraction());
                    float floatValue6 = floatKeyframe5.getFloatValue();
                    float floatValue7 = floatKeyframe6.getFloatValue();
                    TypeEvaluator typeEvaluator4 = this.mEvaluator;
                    return typeEvaluator4 == null ? a.a(floatValue7, floatValue6, fraction5, floatValue6) : ((Number) typeEvaluator4.evaluate(fraction5, Float.valueOf(floatValue6), Float.valueOf(floatValue7))).floatValue();
                }
                i2++;
                floatKeyframe5 = floatKeyframe6;
            }
        }
    }

    public Object getValue(float f) {
        return Float.valueOf(getFloatValue(f));
    }
}
