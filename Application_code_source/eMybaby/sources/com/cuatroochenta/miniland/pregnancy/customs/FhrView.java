package com.cuatroochenta.miniland.pregnancy.customs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import com.cuatroochenta.miniland.model.TimeData;
import com.sozpic.miniland.R;
import java.math.BigDecimal;
import java.util.LinkedList;

public class FhrView extends View {

    /* renamed from: a  reason: collision with root package name */
    public int f3994a;

    /* renamed from: b  reason: collision with root package name */
    public int f3995b;

    /* renamed from: c  reason: collision with root package name */
    public float f3996c;

    /* renamed from: d  reason: collision with root package name */
    public float f3997d;

    /* renamed from: e  reason: collision with root package name */
    public float f3998e;
    public float f;
    public Paint g;
    public Paint h;
    public Paint i;
    public Paint j;
    public Paint k;
    public Paint l;
    public Paint m;
    public Paint n;
    public int o = 0;
    public LinkedList<TimeData> p;
    public LinkedList<TimeData> q;
    public boolean r;
    public float s;
    public float t;
    public Rect u = new Rect();

    public FhrView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        float dimension = context.getResources().getDimension(R.dimen.line_width);
        float dimension2 = context.getResources().getDimension(R.dimen.axis_width);
        float dimension3 = context.getResources().getDimension(R.dimen.axis_main_width);
        this.p = new LinkedList<>();
        Paint paint = new Paint(1);
        this.g = paint;
        paint.setColor(context.getResources().getColor(R.color.pregnancy_graph_line));
        this.g.setStrokeWidth(dimension);
        Paint paint2 = new Paint(1);
        this.h = paint2;
        paint2.setColor(context.getResources().getColor(R.color.pregnancy_graph_axis));
        this.h.setStrokeWidth(dimension3);
        Paint paint3 = new Paint(1);
        this.i = paint3;
        paint3.setColor(context.getResources().getColor(R.color.pregnancy_graph_axis));
        this.i.setStrokeWidth(dimension2);
        Paint paint4 = new Paint(1);
        this.j = paint4;
        paint4.setColor(context.getResources().getColor(R.color.pregnancy_graph_progress));
        this.j.setStrokeWidth(dimension);
        Paint paint5 = new Paint(1);
        this.n = paint5;
        paint5.setColor(context.getResources().getColor(R.color.pregnancy_graph_fm));
        this.n.setStrokeWidth(dimension);
        this.k = new Paint();
        this.k.setTextSize((float) getResources().getDimensionPixelSize(R.dimen.pregnancy_fhrview_textsize));
        this.k.setColor(context.getResources().getColor(R.color.pregnancy_graph_axis));
        this.k.setTextAlign(Paint.Align.CENTER);
        this.k.setStrokeWidth(1.0f);
        Paint paint6 = new Paint(1);
        this.l = paint6;
        paint6.setColor(-1);
        Paint paint7 = new Paint(1);
        this.m = paint7;
        paint7.setColor(context.getResources().getColor(R.color.pregnancy_graph_background));
    }

    public void a(TimeData timeData, boolean z) {
        if (timeData.getSecondsElapsed() > 180.0f) {
            this.o++;
        }
        this.p.add(timeData);
        if (this.r) {
            if (this.s == 0.0f) {
                this.s = timeData.getSecondsElapsed();
            }
            this.q.add(new TimeData(timeData.getHeartRate(), timeData.getSecondsElapsed() - this.s));
        }
        if (z) {
            postInvalidate();
        }
    }

    public final float b(int i2) {
        return (this.f * ((float) (210 - i2))) + this.f3997d;
    }

    public final float c(float f2) {
        return (f2 - this.t) * this.f3996c;
    }

    public LinkedList<TimeData> getRecordingDataList() {
        return this.q;
    }

    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        int i2;
        Paint paint;
        float f2;
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        int i3 = this.o;
        if (i3 > 0) {
            float secondsElapsed = this.p.get(i3).getSecondsElapsed();
            this.t = secondsElapsed;
            double d2 = (double) secondsElapsed;
            Double.isNaN(d2);
            i2 = (int) Math.ceil(d2 / 60.0d);
        } else {
            this.t = 0.0f;
            i2 = 1;
        }
        int i4 = 110;
        int i5 = DrawerLayout.PEEK_DELAY;
        canvas.drawRect(0.0f, b(110), (float) this.f3994a, b(DrawerLayout.PEEK_DELAY), this.m);
        for (int i6 = 50; i6 <= 210; i6 += 10) {
            float b2 = b(i6);
            if (i6 % 30 == 0) {
                f2 = (float) this.f3994a;
                paint = this.h;
            } else {
                f2 = (float) this.f3994a;
                paint = this.i;
            }
            canvas.drawLine(0.0f, b2, f2, b2, paint);
        }
        int i7 = 0;
        for (int i8 = 3; i7 < i8; i8 = 3) {
            float c2 = c((float) (i2 * 60));
            canvas2.drawText(String.valueOf(i2) + "'", c2, (float) this.f3995b, this.k);
            float f3 = c2;
            canvas.drawLine(c2, this.f3998e, c2, this.f3997d, this.h);
            int i9 = 60;
            while (i9 <= 210) {
                String valueOf = String.valueOf(i9);
                this.k.getTextBounds(valueOf, 0, valueOf.length(), this.u);
                Rect rect = this.u;
                float b3 = b(i9);
                float f4 = (float) ((rect.right - rect.left) / 2);
                float f5 = (f3 - f4) - 5.0f;
                float f6 = (float) ((rect.top - rect.bottom) / 2);
                int i10 = i9;
                canvas.drawRect(f5, (b3 - f6) + 5.0f, f4 + f3 + 5.0f, (b3 + f6) - 5.0f, (i9 < i4 || i9 > i5) ? this.l : this.m);
                canvas2.drawText(valueOf, f3, b(i10) - f6, this.k);
                i9 = i10 + 30;
                i4 = 110;
                i5 = DrawerLayout.PEEK_DELAY;
            }
            i2++;
            i7++;
            i4 = 110;
            i5 = DrawerLayout.PEEK_DELAY;
        }
        int size = this.p.size();
        if (size > 0) {
            int i11 = size - 1;
            canvas.drawLine(c(this.p.get(i11).getSecondsElapsed()), this.f3998e, c(this.p.get(i11).getSecondsElapsed()), this.f3997d, this.j);
        }
        for (int i12 = this.o + 1; i12 < size; i12++) {
            int i13 = i12 - 1;
            int heartRate = this.p.get(i13).getHeartRate();
            int heartRate2 = this.p.get(i12).getHeartRate();
            float secondsElapsed2 = this.p.get(i13).getSecondsElapsed();
            float secondsElapsed3 = this.p.get(i12).getSecondsElapsed();
            float c3 = c(secondsElapsed2);
            float c4 = c(secondsElapsed3);
            float b4 = b(heartRate);
            float b5 = b(heartRate2);
            if (new BigDecimal(heartRate - heartRate2).abs().intValue() <= 400) {
                canvas.drawLine(c3, b4, c4, b5, this.g);
            } else {
                canvas2.drawPoint(c4, b5, this.g);
            }
            if (this.p.get(i12).isFetalMovement()) {
                canvas2.drawCircle(c4, b(200), 5.0f, this.n);
            }
        }
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            this.f3995b = i5 - i3;
            int i6 = i4 - i2;
            this.f3994a = i6;
            this.f3996c = (float) (i6 / 180);
            this.f3997d = 20.0f;
            this.k.getTextBounds("1", 0, 1, this.u);
            int i7 = this.f3995b;
            Rect rect = this.u;
            float f2 = (float) (((rect.top - rect.bottom) + i7) - 10);
            this.f3998e = f2;
            this.f = (f2 - this.f3997d) / 160.0f;
        }
    }

    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3));
    }

    public void setRecordingMode(boolean z) {
        this.r = z;
        if (z) {
            LinkedList<TimeData> linkedList = this.q;
            if (linkedList == null) {
                this.q = new LinkedList<>();
            } else {
                linkedList.clear();
            }
            this.s = 0.0f;
        }
    }
}
