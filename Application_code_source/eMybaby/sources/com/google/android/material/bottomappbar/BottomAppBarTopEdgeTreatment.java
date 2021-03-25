package com.google.android.material.bottomappbar;

import a.a.a.a.a;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {
    public static final int ANGLE_LEFT = 180;
    public static final int ANGLE_UP = 270;
    public static final int ARC_HALF = 180;
    public static final int ARC_QUARTER = 90;
    public float cradleVerticalOffset;
    public float fabDiameter;
    public float fabMargin;
    public float horizontalOffset = 0.0f;
    public float roundedCornerRadius;

    public BottomAppBarTopEdgeTreatment(float f, float f2, float f3) {
        this.fabMargin = f;
        this.roundedCornerRadius = f2;
        setCradleVerticalOffset(f3);
    }

    public float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    public void getEdgePath(float f, float f2, float f3, @NonNull ShapePath shapePath) {
        float f4 = f;
        float f5 = f3;
        ShapePath shapePath2 = shapePath;
        float f6 = this.fabDiameter;
        if (f6 == 0.0f) {
            shapePath2.lineTo(f4, 0.0f);
            return;
        }
        float f7 = ((this.fabMargin * 2.0f) + f6) / 2.0f;
        float f8 = f5 * this.roundedCornerRadius;
        float f9 = f2 + this.horizontalOffset;
        float a2 = a.a(1.0f, f5, f7, this.cradleVerticalOffset * f5);
        if (a2 / f7 >= 1.0f) {
            shapePath2.lineTo(f4, 0.0f);
            return;
        }
        float f10 = f7 + f8;
        float f11 = a2 + f8;
        float sqrt = (float) Math.sqrt((double) ((f10 * f10) - (f11 * f11)));
        float f12 = f9 - sqrt;
        float f13 = f9 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan((double) (sqrt / f11)));
        float f14 = 90.0f - degrees;
        shapePath2.lineTo(f12, 0.0f);
        float f15 = f8 * 2.0f;
        float f16 = degrees;
        shapePath.addArc(f12 - f8, 0.0f, f12 + f8, f15, 270.0f, degrees);
        shapePath.addArc(f9 - f7, (-f7) - a2, f9 + f7, f7 - a2, 180.0f - f14, (f14 * 2.0f) - 180.0f);
        shapePath.addArc(f13 - f8, 0.0f, f13 + f8, f15, 270.0f - f16, f16);
        shapePath2.lineTo(f4, 0.0f);
    }

    public float getFabCradleMargin() {
        return this.fabMargin;
    }

    public float getFabCradleRoundedCornerRadius() {
        return this.roundedCornerRadius;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getFabDiameter() {
        return this.fabDiameter;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getHorizontalOffset() {
        return this.horizontalOffset;
    }

    public void setCradleVerticalOffset(@FloatRange(from = 0.0d) float f) {
        if (f >= 0.0f) {
            this.cradleVerticalOffset = f;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    public void setFabCradleMargin(float f) {
        this.fabMargin = f;
    }

    public void setFabCradleRoundedCornerRadius(float f) {
        this.roundedCornerRadius = f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setFabDiameter(float f) {
        this.fabDiameter = f;
    }

    public void setHorizontalOffset(float f) {
        this.horizontalOffset = f;
    }
}
