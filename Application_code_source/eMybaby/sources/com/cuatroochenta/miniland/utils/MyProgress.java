package com.cuatroochenta.miniland.utils;

import a.h.a.g0;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

public class MyProgress extends View {

    /* renamed from: a  reason: collision with root package name */
    public Paint f4087a;

    /* renamed from: b  reason: collision with root package name */
    public RectF f4088b;

    /* renamed from: c  reason: collision with root package name */
    public TextPaint f4089c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f4090d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4091e = false;
    public int f;
    public int g;
    public int h;
    public float i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;

    /* JADX INFO: finally extract failed */
    public MyProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, g0.MyProgress, 0, 0);
            try {
                this.f4091e = obtainStyledAttributes.getBoolean(5, false);
                this.g = obtainStyledAttributes.getColor(0, 17170432);
                this.f = obtainStyledAttributes.getColor(4, 17170432);
                this.j = obtainStyledAttributes.getInt(3, 0);
                this.h = obtainStyledAttributes.getDimensionPixelSize(7, 6);
                this.i = (float) obtainStyledAttributes.getDimensionPixelSize(6, 3);
                this.k = obtainStyledAttributes.getColor(8, 17170444);
                this.l = obtainStyledAttributes.getInt(1, 20);
                obtainStyledAttributes.getBoolean(2, true);
                obtainStyledAttributes.recycle();
                Paint paint = new Paint();
                this.f4090d = paint;
                paint.setAntiAlias(true);
                this.f4090d.setStyle(Paint.Style.STROKE);
                this.f4090d.setStrokeWidth(this.i);
                this.f4090d.setColor(this.g);
                Paint paint2 = new Paint();
                this.f4087a = paint2;
                paint2.setAntiAlias(true);
                this.f4087a.setStyle(Paint.Style.STROKE);
                this.f4087a.setStrokeWidth((float) this.h);
                this.f4087a.setStrokeCap(Paint.Cap.ROUND);
                this.f4087a.setColor(this.f);
                TextPaint textPaint = new TextPaint();
                this.f4089c = textPaint;
                textPaint.setColor(this.k);
                this.f4088b = new RectF();
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Must have to pass the attributes");
        }
    }

    public int getBackgroundColor() {
        return this.g;
    }

    public int getPrimaryCapSize() {
        return this.l;
    }

    public int getPrimaryProgressColor() {
        return this.f;
    }

    public int getProgress() {
        return this.j;
    }

    public float getmStrokeBackgroundWidth() {
        return this.i;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f4087a.setStyle(Paint.Style.STROKE);
        canvas.drawArc(this.f4088b, 0.0f, 360.0f, false, this.f4090d);
        canvas.drawArc(this.f4088b, 270.0f, (float) ((this.j * 360) / 100), false, this.f4087a);
        if (this.f4091e) {
            canvas.drawText(this.j + "%", (float) this.m, (float) this.n, this.f4089c);
        }
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f4088b.set((float) getPaddingLeft(), (float) getPaddingTop(), (float) (i2 - getPaddingRight()), (float) (i3 - getPaddingBottom()));
        this.f4089c.setTextSize((float) (i2 / 5));
        TextPaint textPaint = this.f4089c;
        this.m = (i2 / 2) - ((int) (textPaint.measureText(this.j + "%") / 2.0f));
        this.n = (int) (((float) (i3 / 2)) - ((this.f4089c.ascent() + this.f4089c.descent()) / 2.0f));
        invalidate();
    }

    public void setBackgroundColor(int i2) {
        this.g = i2;
        invalidate();
    }

    public void setDrawText(boolean z) {
        this.f4091e = z;
        invalidate();
    }

    public void setIsPrimaryCapVisible(boolean z) {
    }

    public void setPrimaryCapSize(int i2) {
        this.l = i2;
        invalidate();
    }

    public void setPrimaryProgressColor(int i2) {
        this.f = i2;
        invalidate();
    }

    public void setProgress(int i2) {
        this.j = i2;
        invalidate();
    }

    public void setStrokeWidth(int i2) {
        this.h = i2;
        invalidate();
    }

    public void setTextColor(int i2) {
        this.k = i2;
        invalidate();
    }

    public void setmStrokeBackgroundWidth(float f2) {
        this.i = f2;
    }
}
