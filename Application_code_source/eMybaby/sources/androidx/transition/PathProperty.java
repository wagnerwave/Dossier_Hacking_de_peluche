package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

public class PathProperty<T> extends Property<T, Float> {
    public float mCurrentFraction;
    public final float mPathLength;
    public final PathMeasure mPathMeasure;
    public final PointF mPointF = new PointF();
    public final float[] mPosition = new float[2];
    public final Property<T, PointF> mProperty;

    public PathProperty(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.mProperty = property;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.mPathMeasure = pathMeasure;
        this.mPathLength = pathMeasure.getLength();
    }

    public Float get(T t) {
        return Float.valueOf(this.mCurrentFraction);
    }

    public void set(T t, Float f) {
        this.mCurrentFraction = f.floatValue();
        this.mPathMeasure.getPosTan(f.floatValue() * this.mPathLength, this.mPosition, (float[]) null);
        PointF pointF = this.mPointF;
        float[] fArr = this.mPosition;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.mProperty.set(t, pointF);
    }
}
