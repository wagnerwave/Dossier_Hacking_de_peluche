package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.math.MathUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CircularRevealHelper {
    public static final int BITMAP_SHADER = 0;
    public static final int CLIP_PATH = 1;
    public static final boolean DEBUG = false;
    public static final int REVEAL_ANIMATOR = 2;
    public static final int STRATEGY;
    public boolean buildingCircularRevealCache;
    public Paint debugPaint;
    public final Delegate delegate;
    public boolean hasCircularRevealCache;
    @Nullable
    public Drawable overlayDrawable;
    @Nullable
    public CircularRevealWidget.RevealInfo revealInfo;
    @NonNull
    public final Paint revealPaint = new Paint(7);
    @NonNull
    public final Path revealPath = new Path();
    @NonNull
    public final Paint scrimPaint;
    @NonNull
    public final View view;

    public interface Delegate {
        void actualDraw(Canvas canvas);

        boolean actualIsOpaque();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Strategy {
    }

    static {
        int i = Build.VERSION.SDK_INT;
        STRATEGY = i >= 21 ? 2 : i >= 18 ? 1 : 0;
    }

    public CircularRevealHelper(Delegate delegate2) {
        this.delegate = delegate2;
        View view2 = (View) delegate2;
        this.view = view2;
        view2.setWillNotDraw(false);
        Paint paint = new Paint(1);
        this.scrimPaint = paint;
        paint.setColor(0);
    }

    private void drawDebugCircle(@NonNull Canvas canvas, int i, float f) {
        this.debugPaint.setColor(i);
        this.debugPaint.setStrokeWidth(f);
        CircularRevealWidget.RevealInfo revealInfo2 = this.revealInfo;
        canvas.drawCircle(revealInfo2.centerX, revealInfo2.centerY, revealInfo2.radius - (f / 2.0f), this.debugPaint);
    }

    private void drawDebugMode(@NonNull Canvas canvas) {
        this.delegate.actualDraw(canvas);
        if (shouldDrawScrim()) {
            CircularRevealWidget.RevealInfo revealInfo2 = this.revealInfo;
            canvas.drawCircle(revealInfo2.centerX, revealInfo2.centerY, revealInfo2.radius, this.scrimPaint);
        }
        if (shouldDrawCircularReveal()) {
            drawDebugCircle(canvas, ViewCompat.MEASURED_STATE_MASK, 10.0f);
            drawDebugCircle(canvas, SupportMenu.CATEGORY_MASK, 5.0f);
        }
        drawOverlayDrawable(canvas);
    }

    private void drawOverlayDrawable(@NonNull Canvas canvas) {
        if (shouldDrawOverlayDrawable()) {
            Rect bounds = this.overlayDrawable.getBounds();
            float width = this.revealInfo.centerX - (((float) bounds.width()) / 2.0f);
            float height = this.revealInfo.centerY - (((float) bounds.height()) / 2.0f);
            canvas.translate(width, height);
            this.overlayDrawable.draw(canvas);
            canvas.translate(-width, -height);
        }
    }

    private float getDistanceToFurthestCorner(@NonNull CircularRevealWidget.RevealInfo revealInfo2) {
        return MathUtils.distanceToFurthestCorner(revealInfo2.centerX, revealInfo2.centerY, 0.0f, 0.0f, (float) this.view.getWidth(), (float) this.view.getHeight());
    }

    private void invalidateRevealInfo() {
        if (STRATEGY == 1) {
            this.revealPath.rewind();
            CircularRevealWidget.RevealInfo revealInfo2 = this.revealInfo;
            if (revealInfo2 != null) {
                this.revealPath.addCircle(revealInfo2.centerX, revealInfo2.centerY, revealInfo2.radius, Path.Direction.CW);
            }
        }
        this.view.invalidate();
    }

    private boolean shouldDrawCircularReveal() {
        CircularRevealWidget.RevealInfo revealInfo2 = this.revealInfo;
        boolean z = revealInfo2 == null || revealInfo2.isInvalid();
        return STRATEGY == 0 ? !z && this.hasCircularRevealCache : !z;
    }

    private boolean shouldDrawOverlayDrawable() {
        return (this.buildingCircularRevealCache || this.overlayDrawable == null || this.revealInfo == null) ? false : true;
    }

    private boolean shouldDrawScrim() {
        return !this.buildingCircularRevealCache && Color.alpha(this.scrimPaint.getColor()) != 0;
    }

    public void buildCircularRevealCache() {
        if (STRATEGY == 0) {
            this.buildingCircularRevealCache = true;
            this.hasCircularRevealCache = false;
            this.view.buildDrawingCache();
            Bitmap drawingCache = this.view.getDrawingCache();
            if (!(drawingCache != null || this.view.getWidth() == 0 || this.view.getHeight() == 0)) {
                drawingCache = Bitmap.createBitmap(this.view.getWidth(), this.view.getHeight(), Bitmap.Config.ARGB_8888);
                this.view.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                Paint paint = this.revealPaint;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(drawingCache, tileMode, tileMode));
            }
            this.buildingCircularRevealCache = false;
            this.hasCircularRevealCache = true;
        }
    }

    public void destroyCircularRevealCache() {
        if (STRATEGY == 0) {
            this.hasCircularRevealCache = false;
            this.view.destroyDrawingCache();
            this.revealPaint.setShader((Shader) null);
            this.view.invalidate();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0089, code lost:
        if (shouldDrawScrim() != false) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        if (shouldDrawScrim() != false) goto L_0x008b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(@androidx.annotation.NonNull android.graphics.Canvas r9) {
        /*
            r8 = this;
            boolean r0 = r8.shouldDrawCircularReveal()
            if (r0 == 0) goto L_0x0080
            int r0 = STRATEGY
            if (r0 == 0) goto L_0x005f
            r1 = 1
            if (r0 == r1) goto L_0x0031
            r1 = 2
            if (r0 != r1) goto L_0x001c
            com.google.android.material.circularreveal.CircularRevealHelper$Delegate r0 = r8.delegate
            r0.actualDraw(r9)
            boolean r0 = r8.shouldDrawScrim()
            if (r0 == 0) goto L_0x00a1
            goto L_0x008b
        L_0x001c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "Unsupported strategy "
            java.lang.StringBuilder r0 = a.a.a.a.a.n(r0)
            int r1 = STRATEGY
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r9.<init>(r0)
            throw r9
        L_0x0031:
            int r0 = r9.save()
            android.graphics.Path r1 = r8.revealPath
            r9.clipPath(r1)
            com.google.android.material.circularreveal.CircularRevealHelper$Delegate r1 = r8.delegate
            r1.actualDraw(r9)
            boolean r1 = r8.shouldDrawScrim()
            if (r1 == 0) goto L_0x005b
            r3 = 0
            r4 = 0
            android.view.View r1 = r8.view
            int r1 = r1.getWidth()
            float r5 = (float) r1
            android.view.View r1 = r8.view
            int r1 = r1.getHeight()
            float r6 = (float) r1
            android.graphics.Paint r7 = r8.scrimPaint
            r2 = r9
            r2.drawRect(r3, r4, r5, r6, r7)
        L_0x005b:
            r9.restoreToCount(r0)
            goto L_0x00a1
        L_0x005f:
            com.google.android.material.circularreveal.CircularRevealWidget$RevealInfo r0 = r8.revealInfo
            float r1 = r0.centerX
            float r2 = r0.centerY
            float r0 = r0.radius
            android.graphics.Paint r3 = r8.revealPaint
            r9.drawCircle(r1, r2, r0, r3)
            boolean r0 = r8.shouldDrawScrim()
            if (r0 == 0) goto L_0x00a1
            com.google.android.material.circularreveal.CircularRevealWidget$RevealInfo r0 = r8.revealInfo
            float r1 = r0.centerX
            float r2 = r0.centerY
            float r0 = r0.radius
            android.graphics.Paint r3 = r8.scrimPaint
            r9.drawCircle(r1, r2, r0, r3)
            goto L_0x00a1
        L_0x0080:
            com.google.android.material.circularreveal.CircularRevealHelper$Delegate r0 = r8.delegate
            r0.actualDraw(r9)
            boolean r0 = r8.shouldDrawScrim()
            if (r0 == 0) goto L_0x00a1
        L_0x008b:
            r2 = 0
            r3 = 0
            android.view.View r0 = r8.view
            int r0 = r0.getWidth()
            float r4 = (float) r0
            android.view.View r0 = r8.view
            int r0 = r0.getHeight()
            float r5 = (float) r0
            android.graphics.Paint r6 = r8.scrimPaint
            r1 = r9
            r1.drawRect(r2, r3, r4, r5, r6)
        L_0x00a1:
            r8.drawOverlayDrawable(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.circularreveal.CircularRevealHelper.draw(android.graphics.Canvas):void");
    }

    @Nullable
    public Drawable getCircularRevealOverlayDrawable() {
        return this.overlayDrawable;
    }

    @ColorInt
    public int getCircularRevealScrimColor() {
        return this.scrimPaint.getColor();
    }

    @Nullable
    public CircularRevealWidget.RevealInfo getRevealInfo() {
        CircularRevealWidget.RevealInfo revealInfo2 = this.revealInfo;
        if (revealInfo2 == null) {
            return null;
        }
        CircularRevealWidget.RevealInfo revealInfo3 = new CircularRevealWidget.RevealInfo(revealInfo2);
        if (revealInfo3.isInvalid()) {
            revealInfo3.radius = getDistanceToFurthestCorner(revealInfo3);
        }
        return revealInfo3;
    }

    public boolean isOpaque() {
        return this.delegate.actualIsOpaque() && !shouldDrawCircularReveal();
    }

    public void setCircularRevealOverlayDrawable(@Nullable Drawable drawable) {
        this.overlayDrawable = drawable;
        this.view.invalidate();
    }

    public void setCircularRevealScrimColor(@ColorInt int i) {
        this.scrimPaint.setColor(i);
        this.view.invalidate();
    }

    public void setRevealInfo(@Nullable CircularRevealWidget.RevealInfo revealInfo2) {
        if (revealInfo2 == null) {
            this.revealInfo = null;
        } else {
            CircularRevealWidget.RevealInfo revealInfo3 = this.revealInfo;
            if (revealInfo3 == null) {
                this.revealInfo = new CircularRevealWidget.RevealInfo(revealInfo2);
            } else {
                revealInfo3.set(revealInfo2);
            }
            if (MathUtils.geq(revealInfo2.radius, getDistanceToFurthestCorner(revealInfo2), 1.0E-4f)) {
                this.revealInfo.radius = Float.MAX_VALUE;
            }
        }
        invalidateRevealInfo();
    }
}
