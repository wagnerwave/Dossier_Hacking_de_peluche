package com.cuatroochenta.commons.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.media.ThumbnailUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class CircularImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    public int f3775a;

    /* renamed from: b  reason: collision with root package name */
    public int f3776b;

    /* renamed from: c  reason: collision with root package name */
    public Bitmap f3777c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f3778d;

    /* renamed from: e  reason: collision with root package name */
    public Paint f3779e;
    public BitmapShader f;
    public boolean g = true;

    public CircularImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f3778d = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f3779e = paint2;
        paint2.setAntiAlias(true);
        this.f3779e.setStyle(Paint.Style.STROKE);
        this.f3779e.setColor(-1);
        this.f3779e.setStrokeWidth(4.0f);
    }

    public final int a(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            size = this.f3776b;
        }
        return size + 2;
    }

    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getDrawable();
        if (bitmapDrawable != null) {
            this.f3777c = bitmapDrawable.getBitmap();
        }
        if (this.f3777c != null) {
            Bitmap extractThumbnail = ThumbnailUtils.extractThumbnail(this.f3777c, this.f3775a, this.f3776b);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(extractThumbnail, tileMode, tileMode);
            this.f = bitmapShader;
            this.f3778d.setShader(bitmapShader);
            boolean z = this.g;
            float f2 = (float) (this.f3775a / 2);
            if (z) {
                float f3 = f2 - 4.0f;
                canvas.drawCircle(f2, f2, f3, this.f3778d);
                canvas.drawCircle(f2, f2, f3, this.f3779e);
                return;
            }
            canvas.drawCircle(f2, f2, f2, this.f3778d);
        }
    }

    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            size = this.f3775a;
        }
        this.f3775a = size;
        int a2 = a(i2);
        this.f3776b = a2;
        setMeasuredDimension(this.f3775a, a2);
    }

    public synchronized void setBorder(boolean z) {
        this.g = z;
        invalidate();
    }

    public synchronized void setBorderColor(int i) {
        this.f3779e.setColor(i);
        invalidate();
    }
}
