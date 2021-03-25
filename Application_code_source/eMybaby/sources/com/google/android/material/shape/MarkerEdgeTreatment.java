package com.google.android.material.shape;

import androidx.annotation.NonNull;

public final class MarkerEdgeTreatment extends EdgeTreatment {
    public final float radius;

    public MarkerEdgeTreatment(float f) {
        this.radius = f - 0.001f;
    }

    public boolean forceIntersection() {
        return true;
    }

    public void getEdgePath(float f, float f2, float f3, @NonNull ShapePath shapePath) {
        double d2 = (double) this.radius;
        double sqrt = Math.sqrt(2.0d);
        Double.isNaN(d2);
        float f4 = (float) ((sqrt * d2) / 2.0d);
        float sqrt2 = (float) Math.sqrt(Math.pow((double) this.radius, 2.0d) - Math.pow((double) f4, 2.0d));
        double d3 = (double) this.radius;
        double sqrt3 = Math.sqrt(2.0d);
        Double.isNaN(d3);
        double d4 = sqrt3 * d3;
        double d5 = (double) this.radius;
        Double.isNaN(d5);
        shapePath.reset(f2 - f4, ((float) (-(d4 - d5))) + sqrt2);
        double d6 = (double) this.radius;
        double sqrt4 = Math.sqrt(2.0d);
        Double.isNaN(d6);
        double d7 = sqrt4 * d6;
        double d8 = (double) this.radius;
        Double.isNaN(d8);
        shapePath.lineTo(f2, (float) (-(d7 - d8)));
        double d9 = (double) this.radius;
        double sqrt5 = Math.sqrt(2.0d);
        Double.isNaN(d9);
        double d10 = sqrt5 * d9;
        double d11 = (double) this.radius;
        Double.isNaN(d11);
        shapePath.lineTo(f2 + f4, ((float) (-(d10 - d11))) + sqrt2);
    }
}
