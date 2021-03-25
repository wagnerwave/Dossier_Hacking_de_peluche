package com.sozpic.miniland.utiles;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

public class ZoomableImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    public Matrix f4583a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    public int f4584b = 0;

    /* renamed from: c  reason: collision with root package name */
    public PointF f4585c = new PointF();

    /* renamed from: d  reason: collision with root package name */
    public PointF f4586d = new PointF();

    /* renamed from: e  reason: collision with root package name */
    public float f4587e = 1.0f;
    public float f = 4.0f;
    public float[] g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l = 1.0f;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public ScaleGestureDetector s;

    public class a implements View.OnTouchListener {
        public a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:42:0x00e2  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouch(android.view.View r10, android.view.MotionEvent r11) {
            /*
                r9 = this;
                com.sozpic.miniland.utiles.ZoomableImageView r10 = com.sozpic.miniland.utiles.ZoomableImageView.this
                android.view.ScaleGestureDetector r10 = r10.s
                r10.onTouchEvent(r11)
                com.sozpic.miniland.utiles.ZoomableImageView r10 = com.sozpic.miniland.utiles.ZoomableImageView.this
                android.graphics.Matrix r0 = r10.f4583a
                float[] r10 = r10.g
                r0.getValues(r10)
                com.sozpic.miniland.utiles.ZoomableImageView r10 = com.sozpic.miniland.utiles.ZoomableImageView.this
                float[] r10 = r10.g
                r0 = 2
                r1 = r10[r0]
                r2 = 5
                r10 = r10[r2]
                android.graphics.PointF r3 = new android.graphics.PointF
                float r4 = r11.getX()
                float r5 = r11.getY()
                r3.<init>(r4, r5)
                int r4 = r11.getAction()
                r5 = 1
                if (r4 == 0) goto L_0x0129
                r6 = 0
                if (r4 == r5) goto L_0x0100
                if (r4 == r0) goto L_0x005e
                if (r4 == r2) goto L_0x0040
                r10 = 6
                if (r4 == r10) goto L_0x003a
                goto L_0x0145
            L_0x003a:
                com.sozpic.miniland.utiles.ZoomableImageView r10 = com.sozpic.miniland.utiles.ZoomableImageView.this
                r10.f4584b = r6
                goto L_0x0145
            L_0x0040:
                com.sozpic.miniland.utiles.ZoomableImageView r10 = com.sozpic.miniland.utiles.ZoomableImageView.this
                android.graphics.PointF r10 = r10.f4585c
                float r1 = r11.getX()
                float r11 = r11.getY()
                r10.set(r1, r11)
                com.sozpic.miniland.utiles.ZoomableImageView r10 = com.sozpic.miniland.utiles.ZoomableImageView.this
                android.graphics.PointF r11 = r10.f4586d
                android.graphics.PointF r10 = r10.f4585c
                r11.set(r10)
                com.sozpic.miniland.utiles.ZoomableImageView r10 = com.sozpic.miniland.utiles.ZoomableImageView.this
                r10.f4584b = r0
                goto L_0x0145
            L_0x005e:
                com.sozpic.miniland.utiles.ZoomableImageView r11 = com.sozpic.miniland.utiles.ZoomableImageView.this
                int r2 = r11.f4584b
                if (r2 == r0) goto L_0x006e
                if (r2 != r5) goto L_0x0145
                float r0 = r11.l
                float r11 = r11.f4587e
                int r11 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
                if (r11 <= 0) goto L_0x0145
            L_0x006e:
                float r11 = r3.x
                com.sozpic.miniland.utiles.ZoomableImageView r0 = com.sozpic.miniland.utiles.ZoomableImageView.this
                android.graphics.PointF r2 = r0.f4585c
                float r4 = r2.x
                float r11 = r11 - r4
                float r4 = r3.y
                float r2 = r2.y
                float r4 = r4 - r2
                float r2 = r0.o
                float r0 = r0.l
                float r2 = r2 * r0
                int r0 = java.lang.Math.round(r2)
                float r0 = (float) r0
                com.sozpic.miniland.utiles.ZoomableImageView r2 = com.sozpic.miniland.utiles.ZoomableImageView.this
                float r6 = r2.p
                float r2 = r2.l
                float r6 = r6 * r2
                int r2 = java.lang.Math.round(r6)
                float r2 = (float) r2
                com.sozpic.miniland.utiles.ZoomableImageView r6 = com.sozpic.miniland.utiles.ZoomableImageView.this
                float r7 = r6.j
                r8 = 0
                int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
                if (r0 >= 0) goto L_0x00b0
                float r11 = r10 + r4
                int r0 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
                if (r0 <= 0) goto L_0x00a5
            L_0x00a3:
                float r4 = -r10
                goto L_0x00ae
            L_0x00a5:
                float r0 = r6.n
                float r1 = -r0
                int r11 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
                if (r11 >= 0) goto L_0x00ae
                float r10 = r10 + r0
                goto L_0x00a3
            L_0x00ae:
                r11 = 0
                goto L_0x00ed
            L_0x00b0:
                float r0 = r6.k
                int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r0 >= 0) goto L_0x00c9
                float r10 = r1 + r11
                int r0 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
                if (r0 <= 0) goto L_0x00be
            L_0x00bc:
                float r11 = -r1
                goto L_0x00c7
            L_0x00be:
                float r0 = r6.m
                float r2 = -r0
                int r10 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
                if (r10 >= 0) goto L_0x00c7
                float r1 = r1 + r0
                goto L_0x00bc
            L_0x00c7:
                r4 = 0
                goto L_0x00ed
            L_0x00c9:
                float r0 = r1 + r11
                int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
                if (r2 <= 0) goto L_0x00d1
            L_0x00cf:
                float r11 = -r1
                goto L_0x00da
            L_0x00d1:
                float r2 = r6.m
                float r6 = -r2
                int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
                if (r0 >= 0) goto L_0x00da
                float r1 = r1 + r2
                goto L_0x00cf
            L_0x00da:
                float r0 = r10 + r4
                int r1 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
                if (r1 <= 0) goto L_0x00e2
            L_0x00e0:
                float r4 = -r10
                goto L_0x00ed
            L_0x00e2:
                com.sozpic.miniland.utiles.ZoomableImageView r1 = com.sozpic.miniland.utiles.ZoomableImageView.this
                float r1 = r1.n
                float r2 = -r1
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 >= 0) goto L_0x00ed
                float r10 = r10 + r1
                goto L_0x00e0
            L_0x00ed:
                com.sozpic.miniland.utiles.ZoomableImageView r10 = com.sozpic.miniland.utiles.ZoomableImageView.this
                android.graphics.Matrix r10 = r10.f4583a
                r10.postTranslate(r11, r4)
                com.sozpic.miniland.utiles.ZoomableImageView r10 = com.sozpic.miniland.utiles.ZoomableImageView.this
                android.graphics.PointF r10 = r10.f4585c
                float r11 = r3.x
                float r0 = r3.y
                r10.set(r11, r0)
                goto L_0x0145
            L_0x0100:
                com.sozpic.miniland.utiles.ZoomableImageView r10 = com.sozpic.miniland.utiles.ZoomableImageView.this
                r10.f4584b = r6
                float r11 = r3.x
                android.graphics.PointF r10 = r10.f4586d
                float r10 = r10.x
                float r11 = r11 - r10
                float r10 = java.lang.Math.abs(r11)
                int r10 = (int) r10
                float r11 = r3.y
                com.sozpic.miniland.utiles.ZoomableImageView r0 = com.sozpic.miniland.utiles.ZoomableImageView.this
                android.graphics.PointF r0 = r0.f4586d
                float r0 = r0.y
                float r11 = r11 - r0
                float r11 = java.lang.Math.abs(r11)
                int r11 = (int) r11
                r0 = 3
                if (r10 >= r0) goto L_0x0145
                if (r11 >= r0) goto L_0x0145
                com.sozpic.miniland.utiles.ZoomableImageView r10 = com.sozpic.miniland.utiles.ZoomableImageView.this
                r10.performClick()
                goto L_0x0145
            L_0x0129:
                com.sozpic.miniland.utiles.ZoomableImageView r10 = com.sozpic.miniland.utiles.ZoomableImageView.this
                android.graphics.PointF r10 = r10.f4585c
                float r0 = r11.getX()
                float r11 = r11.getY()
                r10.set(r0, r11)
                com.sozpic.miniland.utiles.ZoomableImageView r10 = com.sozpic.miniland.utiles.ZoomableImageView.this
                android.graphics.PointF r11 = r10.f4586d
                android.graphics.PointF r10 = r10.f4585c
                r11.set(r10)
                com.sozpic.miniland.utiles.ZoomableImageView r10 = com.sozpic.miniland.utiles.ZoomableImageView.this
                r10.f4584b = r5
            L_0x0145:
                com.sozpic.miniland.utiles.ZoomableImageView r10 = com.sozpic.miniland.utiles.ZoomableImageView.this
                android.graphics.Matrix r11 = r10.f4583a
                r10.setImageMatrix(r11)
                com.sozpic.miniland.utiles.ZoomableImageView r10 = com.sozpic.miniland.utiles.ZoomableImageView.this
                r10.invalidate()
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sozpic.miniland.utiles.ZoomableImageView.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    public class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public b(a aVar) {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x001b, code lost:
            if (r3 < r4) goto L_0x0012;
         */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0097  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x00a0  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onScale(android.view.ScaleGestureDetector r12) {
            /*
                r11 = this;
                float r0 = r12.getScaleFactor()
                com.sozpic.miniland.utiles.ZoomableImageView r1 = com.sozpic.miniland.utiles.ZoomableImageView.this
                float r2 = r1.l
                float r3 = r2 * r0
                r1.l = r3
                float r4 = r1.f
                int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                if (r5 <= 0) goto L_0x0017
            L_0x0012:
                r1.l = r4
                float r0 = r4 / r2
                goto L_0x001e
            L_0x0017:
                float r4 = r1.f4587e
                int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                if (r3 >= 0) goto L_0x001e
                goto L_0x0012
            L_0x001e:
                com.sozpic.miniland.utiles.ZoomableImageView r1 = com.sozpic.miniland.utiles.ZoomableImageView.this
                float r2 = r1.j
                float r3 = r1.l
                float r4 = r2 * r3
                float r4 = r4 - r2
                float r5 = r1.h
                r6 = 1073741824(0x40000000, float:2.0)
                float r5 = r5 * r6
                float r5 = r5 * r3
                float r4 = r4 - r5
                r1.m = r4
                float r4 = r1.k
                float r5 = r4 * r3
                float r5 = r5 - r4
                float r7 = r1.i
                float r7 = r7 * r6
                float r7 = r7 * r3
                float r5 = r5 - r7
                r1.n = r5
                float r5 = r1.o
                float r5 = r5 * r3
                r7 = 5
                r8 = 2
                r9 = 1065353216(0x3f800000, float:1.0)
                r10 = 0
                int r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
                if (r2 <= 0) goto L_0x00a7
                float r2 = r1.p
                float r2 = r2 * r3
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 > 0) goto L_0x0056
                goto L_0x00a7
            L_0x0056:
                android.graphics.Matrix r1 = r1.f4583a
                float r2 = r12.getFocusX()
                float r12 = r12.getFocusY()
                r1.postScale(r0, r0, r2, r12)
                com.sozpic.miniland.utiles.ZoomableImageView r12 = com.sozpic.miniland.utiles.ZoomableImageView.this
                android.graphics.Matrix r1 = r12.f4583a
                float[] r12 = r12.g
                r1.getValues(r12)
                com.sozpic.miniland.utiles.ZoomableImageView r12 = com.sozpic.miniland.utiles.ZoomableImageView.this
                float[] r1 = r12.g
                r2 = r1[r8]
                r1 = r1[r7]
                int r0 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
                if (r0 >= 0) goto L_0x010f
                float r0 = r12.m
                float r3 = -r0
                int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                if (r3 >= 0) goto L_0x0087
                android.graphics.Matrix r12 = r12.f4583a
                float r2 = r2 + r0
            L_0x0082:
                float r0 = -r2
                r12.postTranslate(r0, r10)
                goto L_0x008e
            L_0x0087:
                int r0 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
                if (r0 <= 0) goto L_0x008e
                android.graphics.Matrix r12 = r12.f4583a
                goto L_0x0082
            L_0x008e:
                com.sozpic.miniland.utiles.ZoomableImageView r12 = com.sozpic.miniland.utiles.ZoomableImageView.this
                float r0 = r12.n
                float r2 = -r0
                int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
                if (r2 >= 0) goto L_0x00a0
                android.graphics.Matrix r12 = r12.f4583a
                float r1 = r1 + r0
            L_0x009a:
                float r0 = -r1
                r12.postTranslate(r10, r0)
                goto L_0x010f
            L_0x00a0:
                int r0 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
                if (r0 <= 0) goto L_0x010f
                android.graphics.Matrix r12 = r12.f4583a
                goto L_0x009a
            L_0x00a7:
                com.sozpic.miniland.utiles.ZoomableImageView r12 = com.sozpic.miniland.utiles.ZoomableImageView.this
                android.graphics.Matrix r1 = r12.f4583a
                float r2 = r12.j
                float r2 = r2 / r6
                float r12 = r12.k
                float r12 = r12 / r6
                r1.postScale(r0, r0, r2, r12)
                int r12 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
                if (r12 >= 0) goto L_0x010f
                com.sozpic.miniland.utiles.ZoomableImageView r12 = com.sozpic.miniland.utiles.ZoomableImageView.this
                android.graphics.Matrix r1 = r12.f4583a
                float[] r12 = r12.g
                r1.getValues(r12)
                com.sozpic.miniland.utiles.ZoomableImageView r12 = com.sozpic.miniland.utiles.ZoomableImageView.this
                float[] r1 = r12.g
                r2 = r1[r8]
                r1 = r1[r7]
                int r0 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
                if (r0 >= 0) goto L_0x010f
                float r0 = r12.o
                float r12 = r12.l
                float r0 = r0 * r12
                int r12 = java.lang.Math.round(r0)
                float r12 = (float) r12
                com.sozpic.miniland.utiles.ZoomableImageView r0 = com.sozpic.miniland.utiles.ZoomableImageView.this
                float r3 = r0.j
                int r12 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
                if (r12 >= 0) goto L_0x00f6
                float r12 = r0.n
                float r2 = -r12
                int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
                if (r2 >= 0) goto L_0x00ef
                android.graphics.Matrix r0 = r0.f4583a
                float r1 = r1 + r12
                float r12 = -r1
                r0.postTranslate(r10, r12)
                goto L_0x010f
            L_0x00ef:
                int r12 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
                if (r12 <= 0) goto L_0x010f
                android.graphics.Matrix r12 = r0.f4583a
                goto L_0x009a
            L_0x00f6:
                float r12 = r0.m
                float r1 = -r12
                int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
                if (r1 >= 0) goto L_0x0105
                android.graphics.Matrix r0 = r0.f4583a
                float r2 = r2 + r12
                float r12 = -r2
                r0.postTranslate(r12, r10)
                goto L_0x010f
            L_0x0105:
                int r12 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
                if (r12 <= 0) goto L_0x010f
                android.graphics.Matrix r12 = r0.f4583a
                float r0 = -r2
                r12.postTranslate(r0, r10)
            L_0x010f:
                r12 = 1
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sozpic.miniland.utiles.ZoomableImageView.b.onScale(android.view.ScaleGestureDetector):boolean");
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            ZoomableImageView.this.f4584b = 2;
            return true;
        }
    }

    public ZoomableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setClickable(true);
        this.s = new ScaleGestureDetector(context, new b((a) null));
        this.f4583a.setTranslate(1.0f, 1.0f);
        this.g = new float[9];
        setImageMatrix(this.f4583a);
        setScaleType(ImageView.ScaleType.MATRIX);
        setOnTouchListener(new a());
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.j = (float) View.MeasureSpec.getSize(i2);
        float size = (float) View.MeasureSpec.getSize(i3);
        this.k = size;
        float min = Math.min(this.j / this.q, size / this.r);
        this.f4583a.setScale(min, min);
        setImageMatrix(this.f4583a);
        this.l = 1.0f;
        float f2 = this.k - (this.r * min);
        this.i = f2;
        float f3 = this.j - (min * this.q);
        this.h = f3;
        float f4 = f2 / 2.0f;
        this.i = f4;
        float f5 = f3 / 2.0f;
        this.h = f5;
        this.f4583a.postTranslate(f5, f4);
        float f6 = this.j;
        float f7 = this.h;
        this.o = f6 - (f7 * 2.0f);
        float f8 = this.k;
        float f9 = this.i;
        this.p = f8 - (f9 * 2.0f);
        float f10 = this.l;
        this.m = ((f6 * f10) - f6) - ((f7 * 2.0f) * f10);
        this.n = ((f8 * f10) - f8) - ((f9 * 2.0f) * f10);
        setImageMatrix(this.f4583a);
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.q = (float) bitmap.getWidth();
        this.r = (float) bitmap.getHeight();
    }

    public void setMaxZoom(float f2) {
        this.f = f2;
    }
}
