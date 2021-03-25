package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Keyframe;
import java.util.ArrayList;

public class IntKeyframeSet extends KeyframeSet {
    public int deltaValue;
    public boolean firstTime = true;
    public int firstValue;
    public int lastValue;

    public IntKeyframeSet(Keyframe.IntKeyframe... intKeyframeArr) {
        super(intKeyframeArr);
    }

    public IntKeyframeSet clone() {
        ArrayList<Keyframe> arrayList = this.mKeyframes;
        int size = arrayList.size();
        Keyframe.IntKeyframe[] intKeyframeArr = new Keyframe.IntKeyframe[size];
        for (int i = 0; i < size; i++) {
            intKeyframeArr[i] = (Keyframe.IntKeyframe) arrayList.get(i).clone();
        }
        return new IntKeyframeSet(intKeyframeArr);
    }

    public int getIntValue(float f) {
        Object value;
        int i = this.mNumKeyframes;
        if (i != 2) {
            if (f > 0.0f) {
                if (f < 1.0f) {
                    Keyframe.IntKeyframe intKeyframe = (Keyframe.IntKeyframe) this.mKeyframes.get(0);
                    int i2 = 1;
                    while (true) {
                        int i3 = this.mNumKeyframes;
                        if (i2 >= i3) {
                            value = this.mKeyframes.get(i3 - 1).getValue();
                            break;
                        }
                        Keyframe.IntKeyframe intKeyframe2 = (Keyframe.IntKeyframe) this.mKeyframes.get(i2);
                        if (f < intKeyframe2.getFraction()) {
                            Interpolator interpolator = intKeyframe2.getInterpolator();
                            if (interpolator != null) {
                                f = interpolator.getInterpolation(f);
                            }
                            float fraction = (f - intKeyframe.getFraction()) / (intKeyframe2.getFraction() - intKeyframe.getFraction());
                            int intValue = intKeyframe.getIntValue();
                            int intValue2 = intKeyframe2.getIntValue();
                            TypeEvaluator typeEvaluator = this.mEvaluator;
                            return typeEvaluator == null ? intValue + ((int) (fraction * ((float) (intValue2 - intValue)))) : ((Number) typeEvaluator.evaluate(fraction, Integer.valueOf(intValue), Integer.valueOf(intValue2))).intValue();
                        }
                        i2++;
                        intKeyframe = intKeyframe2;
                    }
                } else {
                    Keyframe.IntKeyframe intKeyframe3 = (Keyframe.IntKeyframe) this.mKeyframes.get(i - 2);
                    Keyframe.IntKeyframe intKeyframe4 = (Keyframe.IntKeyframe) this.mKeyframes.get(this.mNumKeyframes - 1);
                    int intValue3 = intKeyframe3.getIntValue();
                    int intValue4 = intKeyframe4.getIntValue();
                    float fraction2 = intKeyframe3.getFraction();
                    float fraction3 = intKeyframe4.getFraction();
                    Interpolator interpolator2 = intKeyframe4.getInterpolator();
                    if (interpolator2 != null) {
                        f = interpolator2.getInterpolation(f);
                    }
                    float f2 = (f - fraction2) / (fraction3 - fraction2);
                    TypeEvaluator typeEvaluator2 = this.mEvaluator;
                    return typeEvaluator2 == null ? intValue3 + ((int) (f2 * ((float) (intValue4 - intValue3)))) : ((Number) typeEvaluator2.evaluate(f2, Integer.valueOf(intValue3), Integer.valueOf(intValue4))).intValue();
                }
            } else {
                Keyframe.IntKeyframe intKeyframe5 = (Keyframe.IntKeyframe) this.mKeyframes.get(0);
                Keyframe.IntKeyframe intKeyframe6 = (Keyframe.IntKeyframe) this.mKeyframes.get(1);
                int intValue5 = intKeyframe5.getIntValue();
                int intValue6 = intKeyframe6.getIntValue();
                float fraction4 = intKeyframe5.getFraction();
                float fraction5 = intKeyframe6.getFraction();
                Interpolator interpolator3 = intKeyframe6.getInterpolator();
                if (interpolator3 != null) {
                    f = interpolator3.getInterpolation(f);
                }
                float f3 = (f - fraction4) / (fraction5 - fraction4);
                TypeEvaluator typeEvaluator3 = this.mEvaluator;
                return typeEvaluator3 == null ? intValue5 + ((int) (f3 * ((float) (intValue6 - intValue5)))) : ((Number) typeEvaluator3.evaluate(f3, Integer.valueOf(intValue5), Integer.valueOf(intValue6))).intValue();
            }
        } else {
            if (this.firstTime) {
                this.firstTime = false;
                this.firstValue = ((Keyframe.IntKeyframe) this.mKeyframes.get(0)).getIntValue();
                int intValue7 = ((Keyframe.IntKeyframe) this.mKeyframes.get(1)).getIntValue();
                this.lastValue = intValue7;
                this.deltaValue = intValue7 - this.firstValue;
            }
            Interpolator interpolator4 = this.mInterpolator;
            if (interpolator4 != null) {
                f = interpolator4.getInterpolation(f);
            }
            TypeEvaluator typeEvaluator4 = this.mEvaluator;
            if (typeEvaluator4 == null) {
                return this.firstValue + ((int) (f * ((float) this.deltaValue)));
            }
            value = typeEvaluator4.evaluate(f, Integer.valueOf(this.firstValue), Integer.valueOf(this.lastValue));
        }
        return ((Number) value).intValue();
    }

    public Object getValue(float f) {
        return Integer.valueOf(getIntValue(f));
    }
}
