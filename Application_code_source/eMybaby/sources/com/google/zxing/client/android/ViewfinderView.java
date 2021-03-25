package com.google.zxing.client.android;

import a.d.c.n;
import a.d.c.q.a.l;
import a.d.c.q.a.t.c;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import com.tuya.smart.common.o00o0000o0;
import java.util.ArrayList;
import java.util.List;

public final class ViewfinderView extends View {
    public static final int[] l = {0, 64, 128, o00o0000o0.O00000Oo, 255, o00o0000o0.O00000Oo, 128, 64};

    /* renamed from: a  reason: collision with root package name */
    public c f4312a;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f4313b = new Paint(1);

    /* renamed from: c  reason: collision with root package name */
    public Bitmap f4314c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4315d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4316e;
    public final int f;
    public final int g;
    public final int h;
    public int i;
    public List<n> j;
    public List<n> k;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = getResources();
        this.f4315d = resources.getColor(l.viewfinder_mask);
        this.f4316e = resources.getColor(l.result_view);
        this.f = resources.getColor(l.viewfinder_frame);
        this.g = resources.getColor(l.viewfinder_laser);
        this.h = resources.getColor(l.possible_result_points);
        this.i = 0;
        this.j = new ArrayList(5);
        this.k = null;
    }

    public void onDraw(Canvas canvas) {
        Rect a2 = this.f4312a.a();
        if (a2 != null) {
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            this.f4313b.setColor(this.f4314c != null ? this.f4316e : this.f4315d);
            float f2 = (float) width;
            canvas.drawRect(0.0f, 0.0f, f2, (float) a2.top, this.f4313b);
            canvas.drawRect(0.0f, (float) a2.top, (float) a2.left, (float) (a2.bottom + 1), this.f4313b);
            float f3 = f2;
            canvas.drawRect((float) (a2.right + 1), (float) a2.top, f3, (float) (a2.bottom + 1), this.f4313b);
            canvas.drawRect(0.0f, (float) (a2.bottom + 1), f3, (float) height, this.f4313b);
            if (this.f4314c != null) {
                this.f4313b.setAlpha(DrawerLayout.PEEK_DELAY);
                canvas.drawBitmap(this.f4314c, (Rect) null, a2, this.f4313b);
                return;
            }
            this.f4313b.setColor(this.f);
            float f4 = (float) a2.left;
            int i2 = a2.top;
            canvas.drawRect(f4, (float) i2, (float) (a2.right + 1), (float) (i2 + 2), this.f4313b);
            int i3 = a2.left;
            canvas.drawRect((float) i3, (float) (a2.top + 2), (float) (i3 + 2), (float) (a2.bottom - 1), this.f4313b);
            int i4 = a2.right;
            canvas.drawRect((float) (i4 - 1), (float) a2.top, (float) (i4 + 1), (float) (a2.bottom - 1), this.f4313b);
            float f5 = (float) a2.left;
            int i5 = a2.bottom;
            canvas.drawRect(f5, (float) (i5 - 1), (float) (a2.right + 1), (float) (i5 + 1), this.f4313b);
            this.f4313b.setColor(this.g);
            this.f4313b.setAlpha(l[this.i]);
            this.i = (this.i + 1) % l.length;
            int height2 = (a2.height() / 2) + a2.top;
            canvas.drawRect((float) (a2.left + 2), (float) (height2 - 1), (float) (a2.right - 1), (float) (height2 + 2), this.f4313b);
            Rect b2 = this.f4312a.b();
            float width2 = ((float) a2.width()) / ((float) b2.width());
            float height3 = ((float) a2.height()) / ((float) b2.height());
            List<n> list = this.j;
            List<n> list2 = this.k;
            int i6 = a2.left;
            int i7 = a2.top;
            if (list.isEmpty()) {
                this.k = null;
            } else {
                this.j = new ArrayList(5);
                this.k = list;
                this.f4313b.setAlpha(DrawerLayout.PEEK_DELAY);
                this.f4313b.setColor(this.h);
                synchronized (list) {
                    for (n next : list) {
                        canvas.drawCircle((float) (((int) (next.f2885a * width2)) + i6), (float) (((int) (next.f2886b * height3)) + i7), 6.0f, this.f4313b);
                    }
                }
            }
            if (list2 != null) {
                this.f4313b.setAlpha(80);
                this.f4313b.setColor(this.h);
                synchronized (list2) {
                    for (n next2 : list2) {
                        canvas.drawCircle((float) (((int) (next2.f2885a * width2)) + i6), (float) (((int) (next2.f2886b * height3)) + i7), 3.0f, this.f4313b);
                    }
                }
            }
            postInvalidateDelayed(80, a2.left - 6, a2.top - 6, a2.right + 6, a2.bottom + 6);
        }
    }

    public void setCameraManager(c cVar) {
        this.f4312a = cVar;
    }
}
