package a.i.a;

import a.i.a.t;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;

public final class u extends BitmapDrawable {
    public static final Paint h = new Paint();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f3671a;

    /* renamed from: b  reason: collision with root package name */
    public final float f3672b;

    /* renamed from: c  reason: collision with root package name */
    public final t.d f3673c;

    /* renamed from: d  reason: collision with root package name */
    public Drawable f3674d;

    /* renamed from: e  reason: collision with root package name */
    public long f3675e;
    public boolean f;
    public int g = 255;

    public u(Context context, Bitmap bitmap, Drawable drawable, t.d dVar, boolean z, boolean z2) {
        super(context.getResources(), bitmap);
        this.f3671a = z2;
        this.f3672b = context.getResources().getDisplayMetrics().density;
        this.f3673c = dVar;
        if (dVar != t.d.MEMORY && !z) {
            this.f3674d = drawable;
            this.f = true;
            this.f3675e = SystemClock.uptimeMillis();
        }
    }

    public static Path a(Point point, int i) {
        Point point2 = new Point(point.x + i, point.y);
        Point point3 = new Point(point.x, point.y + i);
        Path path = new Path();
        path.moveTo((float) point.x, (float) point.y);
        path.lineTo((float) point2.x, (float) point2.y);
        path.lineTo((float) point3.x, (float) point3.y);
        return path;
    }

    public static void b(ImageView imageView, Context context, Bitmap bitmap, t.d dVar, boolean z, boolean z2) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
        imageView.setImageDrawable(new u(context, bitmap, drawable, dVar, z, z2));
    }

    public static void c(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable((Drawable) null);
        if (imageView.getDrawable() instanceof AnimationDrawable) {
            ((AnimationDrawable) imageView.getDrawable()).start();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r7) {
        /*
            r6 = this;
            boolean r0 = r6.f
            r1 = 0
            if (r0 != 0) goto L_0x0009
        L_0x0005:
            super.draw(r7)
            goto L_0x0038
        L_0x0009:
            long r2 = android.os.SystemClock.uptimeMillis()
            long r4 = r6.f3675e
            long r2 = r2 - r4
            float r0 = (float) r2
            r2 = 1128792064(0x43480000, float:200.0)
            float r0 = r0 / r2
            r2 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0020
            r6.f = r1
            r0 = 0
            r6.f3674d = r0
            goto L_0x0005
        L_0x0020:
            android.graphics.drawable.Drawable r2 = r6.f3674d
            if (r2 == 0) goto L_0x0027
            r2.draw(r7)
        L_0x0027:
            int r2 = r6.g
            float r2 = (float) r2
            float r2 = r2 * r0
            int r0 = (int) r2
            super.setAlpha(r0)
            super.draw(r7)
            int r0 = r6.g
            super.setAlpha(r0)
        L_0x0038:
            boolean r0 = r6.f3671a
            if (r0 == 0) goto L_0x0075
            android.graphics.Paint r0 = h
            r2 = -1
            r0.setColor(r2)
            android.graphics.Point r0 = new android.graphics.Point
            r0.<init>(r1, r1)
            float r2 = r6.f3672b
            r3 = 1098907648(0x41800000, float:16.0)
            float r2 = r2 * r3
            int r2 = (int) r2
            android.graphics.Path r0 = a(r0, r2)
            android.graphics.Paint r2 = h
            r7.drawPath(r0, r2)
            android.graphics.Paint r0 = h
            a.i.a.t$d r2 = r6.f3673c
            int r2 = r2.f3665a
            r0.setColor(r2)
            android.graphics.Point r0 = new android.graphics.Point
            r0.<init>(r1, r1)
            float r1 = r6.f3672b
            r2 = 1097859072(0x41700000, float:15.0)
            float r1 = r1 * r2
            int r1 = (int) r1
            android.graphics.Path r0 = a(r0, r1)
            android.graphics.Paint r1 = h
            r7.drawPath(r0, r1)
        L_0x0075:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.i.a.u.draw(android.graphics.Canvas):void");
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f3674d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    public void setAlpha(int i) {
        this.g = i;
        Drawable drawable = this.f3674d;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
        super.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f3674d;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }
}
