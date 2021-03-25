package com.sozpic.miniland.galeria;

import a.h.a.m0.b;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

public class TouchImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    public Matrix f4577a;

    /* renamed from: b  reason: collision with root package name */
    public int f4578b = 0;

    /* renamed from: c  reason: collision with root package name */
    public PointF f4579c = new PointF();

    /* renamed from: d  reason: collision with root package name */
    public PointF f4580d = new PointF();

    /* renamed from: e  reason: collision with root package name */
    public float f4581e = 1.0f;
    public float f = 3.0f;
    public float[] g;
    public int h;
    public int i;
    public float j = 1.0f;
    public float k;
    public float l;
    public int m;
    public ScaleGestureDetector n;

    public class a extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public a(b bVar) {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x001b, code lost:
            if (r3 < r4) goto L_0x0012;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onScale(android.view.ScaleGestureDetector r7) {
            /*
                r6 = this;
                float r0 = r7.getScaleFactor()
                com.sozpic.miniland.galeria.TouchImageView r1 = com.sozpic.miniland.galeria.TouchImageView.this
                float r2 = r1.j
                float r3 = r2 * r0
                r1.j = r3
                float r4 = r1.f
                int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                if (r5 <= 0) goto L_0x0017
            L_0x0012:
                r1.j = r4
                float r0 = r4 / r2
                goto L_0x001e
            L_0x0017:
                float r4 = r1.f4581e
                int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                if (r3 >= 0) goto L_0x001e
                goto L_0x0012
            L_0x001e:
                com.sozpic.miniland.galeria.TouchImageView r1 = com.sozpic.miniland.galeria.TouchImageView.this
                float r2 = r1.k
                float r3 = r1.j
                float r2 = r2 * r3
                int r4 = r1.h
                float r4 = (float) r4
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 <= 0) goto L_0x0044
                float r2 = r1.l
                float r2 = r2 * r3
                int r3 = r1.i
                float r3 = (float) r3
                int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                if (r2 > 0) goto L_0x0039
                goto L_0x0044
            L_0x0039:
                android.graphics.Matrix r1 = r1.f4577a
                float r2 = r7.getFocusX()
                float r7 = r7.getFocusY()
                goto L_0x0052
            L_0x0044:
                com.sozpic.miniland.galeria.TouchImageView r7 = com.sozpic.miniland.galeria.TouchImageView.this
                android.graphics.Matrix r1 = r7.f4577a
                int r2 = r7.h
                int r2 = r2 / 2
                float r2 = (float) r2
                int r7 = r7.i
                int r7 = r7 / 2
                float r7 = (float) r7
            L_0x0052:
                r1.postScale(r0, r0, r2, r7)
                com.sozpic.miniland.galeria.TouchImageView r7 = com.sozpic.miniland.galeria.TouchImageView.this
                r7.a()
                r7 = 1
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sozpic.miniland.galeria.TouchImageView.a.onScale(android.view.ScaleGestureDetector):boolean");
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            TouchImageView.this.f4578b = 2;
            return true;
        }
    }

    public TouchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setClickable(true);
        this.n = new ScaleGestureDetector(context, new a((b) null));
        Matrix matrix = new Matrix();
        this.f4577a = matrix;
        this.g = new float[9];
        setImageMatrix(matrix);
        setScaleType(ImageView.ScaleType.MATRIX);
        setOnTouchListener(new b(this));
    }

    public void a() {
        this.f4577a.getValues(this.g);
        float[] fArr = this.g;
        float f2 = fArr[2];
        float f3 = fArr[5];
        float b2 = b(f2, (float) this.h, this.k * this.j);
        float b3 = b(f3, (float) this.i, this.l * this.j);
        if (b2 != 0.0f || b3 != 0.0f) {
            this.f4577a.postTranslate(b2, b3);
        }
    }

    public float b(float f2, float f3, float f4) {
        float f5;
        int i2 = (f4 > f3 ? 1 : (f4 == f3 ? 0 : -1));
        float f6 = f3 - f4;
        if (i2 <= 0) {
            f5 = f6;
            f6 = 0.0f;
        } else {
            f5 = 0.0f;
        }
        if (f2 < f6) {
            return (-f2) + f6;
        }
        if (f2 > f5) {
            return (-f2) + f5;
        }
        return 0.0f;
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        super.onMeasure(i2, i3);
        this.h = View.MeasureSpec.getSize(i2);
        int size = View.MeasureSpec.getSize(i3);
        this.i = size;
        int i5 = this.m;
        if ((i5 != this.h || i5 != size) && this.h != 0 && (i4 = this.i) != 0) {
            this.m = i4;
            if (this.j == 1.0f) {
                Drawable drawable = getDrawable();
                if (drawable != null && drawable.getIntrinsicWidth() != 0 && drawable.getIntrinsicHeight() != 0) {
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    int intrinsicHeight = drawable.getIntrinsicHeight();
                    Log.d("bmSize", "bmWidth: " + intrinsicWidth + " bmHeight : " + intrinsicHeight);
                    float f2 = (float) intrinsicWidth;
                    float f3 = (float) intrinsicHeight;
                    float min = Math.min(((float) this.h) / f2, ((float) this.i) / f3);
                    this.f4577a.setScale(min, min);
                    float f4 = (((float) this.i) - (f3 * min)) / 2.0f;
                    float f5 = (((float) this.h) - (min * f2)) / 2.0f;
                    this.f4577a.postTranslate(f5, f4);
                    this.k = ((float) this.h) - (f5 * 2.0f);
                    this.l = ((float) this.i) - (f4 * 2.0f);
                    setImageMatrix(this.f4577a);
                } else {
                    return;
                }
            }
            a();
        }
    }

    public void setMaxZoom(float f2) {
        this.f = f2;
    }
}
