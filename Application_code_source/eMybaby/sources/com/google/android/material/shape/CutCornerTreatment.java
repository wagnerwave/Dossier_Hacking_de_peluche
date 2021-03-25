package com.google.android.material.shape;

import androidx.annotation.NonNull;

public class CutCornerTreatment extends CornerTreatment {
    public float size = -1.0f;

    public CutCornerTreatment() {
    }

    @Deprecated
    public CutCornerTreatment(float f) {
        this.size = f;
    }

    public void getCornerPath(@NonNull ShapePath shapePath, float f, float f2, float f3) {
        shapePath.reset(0.0f, f3 * f2, 180.0f, 180.0f - f);
        double sin = Math.sin(Math.toRadians((double) f));
        double d2 = (double) f3;
        Double.isNaN(d2);
        double d3 = (double) f2;
        Double.isNaN(d3);
        double sin2 = Math.sin(Math.toRadians((double) (90.0f - f)));
        Double.isNaN(d2);
        Double.isNaN(d3);
        shapePath.lineTo((float) (sin * d2 * d3), (float) (sin2 * d2 * d3));
    }
}
