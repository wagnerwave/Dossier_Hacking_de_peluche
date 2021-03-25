package com.cuatroochenta.genericviewflow;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class CircleFlowIndicator extends View implements a.c.b.a, Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    public float f3780a = 4.0f;

    /* renamed from: b  reason: collision with root package name */
    public float f3781b = 4.0f;

    /* renamed from: c  reason: collision with root package name */
    public int f3782c = 0;

    /* renamed from: d  reason: collision with root package name */
    public final Paint f3783d = new Paint(1);

    /* renamed from: e  reason: collision with root package name */
    public final Paint f3784e = new Paint(1);
    public ViewFlow f;
    public int g = 0;
    public int h = 0;
    public b i;
    public Animation.AnimationListener j = this;
    public Animation k;
    public int l = 3;
    public int m = -1;

    public class b extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public int f3785a = 0;

        /* renamed from: b  reason: collision with root package name */
        public boolean f3786b = true;

        public b(a aVar) {
        }

        public Object doInBackground(Object[] objArr) {
            Void[] voidArr = (Void[]) objArr;
            while (this.f3786b) {
                try {
                    Thread.sleep(1);
                    int i = this.f3785a + 1;
                    this.f3785a = i;
                    if (i == CircleFlowIndicator.this.f3782c) {
                        this.f3786b = false;
                    }
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }

        public void onPostExecute(Object obj) {
            Void voidR = (Void) obj;
            CircleFlowIndicator circleFlowIndicator = CircleFlowIndicator.this;
            circleFlowIndicator.k = AnimationUtils.loadAnimation(circleFlowIndicator.getContext(), 17432577);
            CircleFlowIndicator circleFlowIndicator2 = CircleFlowIndicator.this;
            circleFlowIndicator2.k.setAnimationListener(circleFlowIndicator2.j);
            CircleFlowIndicator circleFlowIndicator3 = CircleFlowIndicator.this;
            circleFlowIndicator3.startAnimation(circleFlowIndicator3.k);
        }
    }

    public CircleFlowIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.b.b.CircleFlowIndicator);
        int i2 = obtainStyledAttributes.getInt(a.c.b.b.CircleFlowIndicator_activeType, 1);
        int color = obtainStyledAttributes.getColor(a.c.b.b.CircleFlowIndicator_activeColor, -1);
        int i3 = obtainStyledAttributes.getInt(a.c.b.b.CircleFlowIndicator_inactiveType, 0);
        int color2 = obtainStyledAttributes.getColor(a.c.b.b.CircleFlowIndicator_inactiveColor, 1157627903);
        this.f3780a = obtainStyledAttributes.getDimension(a.c.b.b.CircleFlowIndicator_radius, 4.0f);
        this.f3781b = obtainStyledAttributes.getDimension(a.c.b.b.CircleFlowIndicator_spacing, 4.0f);
        this.f3782c = obtainStyledAttributes.getInt(a.c.b.b.CircleFlowIndicator_fadeOut, 0);
        obtainStyledAttributes.getBoolean(a.c.b.b.CircleFlowIndicator_centered, false);
        this.f3783d.setStyle(i3 != 1 ? Paint.Style.STROKE : Paint.Style.FILL);
        this.f3783d.setColor(color2);
        this.f3784e.setStyle(i2 != 0 ? Paint.Style.FILL : Paint.Style.STROKE);
        this.f3784e.setColor(color);
    }

    public final void a() {
        if (this.f3782c > 0) {
            b bVar = this.i;
            if (bVar == null || !bVar.f3786b) {
                b bVar2 = new b((a) null);
                this.i = bVar2;
                bVar2.execute(new Void[0]);
                return;
            }
            bVar.f3785a = 0;
        }
    }

    public int getItemsCount() {
        return this.l;
    }

    public int getSelectedItem() {
        return this.m;
    }

    public void onAnimationEnd(Animation animation) {
        setVisibility(8);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onDraw(Canvas canvas) {
        float f2;
        Paint paint;
        float f3;
        float f4;
        float f5;
        super.onDraw(canvas);
        ViewFlow viewFlow = this.f;
        if (viewFlow != null) {
            this.l = viewFlow.getViewsCount();
        }
        float f6 = (this.f3780a * 2.0f) + this.f3781b;
        int paddingLeft = getPaddingLeft();
        for (int i2 = 0; i2 < this.l; i2++) {
            if (this.f == null && i2 == getSelectedItem()) {
                f3 = (((float) i2) * f6) + ((float) paddingLeft) + this.f3780a + 0.0f;
                f4 = this.f3780a;
                f5 = ((float) getPaddingTop()) + f4;
                paint = this.f3784e;
            } else {
                f3 = (((float) i2) * f6) + ((float) paddingLeft) + this.f3780a + 0.0f;
                f4 = this.f3780a;
                f5 = ((float) getPaddingTop()) + f4;
                paint = this.f3783d;
            }
            canvas.drawCircle(f3, f5, f4, paint);
        }
        int i3 = this.h;
        if (i3 != 0) {
            f2 = (((this.f3780a * 2.0f) + this.f3781b) * ((float) this.g)) / ((float) i3);
        } else {
            f2 = 0.0f;
        }
        if (this.f != null) {
            float f7 = this.f3780a;
            canvas.drawCircle(((float) paddingLeft) + this.f3780a + f2 + 0.0f, ((float) getPaddingTop()) + f7, f7, this.f3784e);
        }
    }

    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        ViewFlow viewFlow = this.f;
        if (viewFlow != null) {
            this.l = viewFlow.getViewsCount();
        }
        float paddingRight = (float) (getPaddingRight() + getPaddingLeft());
        int i4 = this.l;
        int i5 = (int) ((((float) (i4 - 1)) * this.f3781b) + (((float) (i4 * 2)) * this.f3780a) + paddingRight + 1.0f);
        if (mode == Integer.MIN_VALUE) {
            i5 = Math.min(i5, size);
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode2 != 1073741824) {
            int paddingTop = (int) ((this.f3780a * 2.0f) + ((float) getPaddingTop()) + ((float) getPaddingBottom()) + 1.0f);
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(paddingTop, size2) : paddingTop;
        }
        setMeasuredDimension(i5, size2);
    }

    public void setFillColor(int i2) {
        this.f3784e.setColor(i2);
        invalidate();
    }

    public void setItemsCount(int i2) {
        this.l = i2;
    }

    public void setSelectedItem(int i2) {
        if (i2 < this.l) {
            this.m = i2;
            invalidate();
            return;
        }
        this.m = -1;
    }

    public void setStrokeColor(int i2) {
        this.f3783d.setColor(i2);
        invalidate();
    }

    public void setViewFlow(ViewFlow viewFlow) {
        a();
        this.f = viewFlow;
        this.h = viewFlow.getWidth();
        invalidate();
    }
}
