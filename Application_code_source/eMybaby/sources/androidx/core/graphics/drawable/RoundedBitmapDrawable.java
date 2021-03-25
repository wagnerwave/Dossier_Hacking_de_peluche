package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;

public abstract class RoundedBitmapDrawable extends Drawable {
    public static final int DEFAULT_PAINT_FLAGS = 3;
    public boolean mApplyGravity = true;
    public final Bitmap mBitmap;
    public int mBitmapHeight;
    public final BitmapShader mBitmapShader;
    public int mBitmapWidth;
    public float mCornerRadius;
    public final Rect mDstRect = new Rect();
    public final RectF mDstRectF = new RectF();
    public int mGravity = 119;
    public boolean mIsCircular;
    public final Paint mPaint = new Paint(3);
    public final Matrix mShaderMatrix = new Matrix();
    public int mTargetDensity = DrawerLayout.PEEK_DELAY;

    public RoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
        BitmapShader bitmapShader;
        if (resources != null) {
            this.mTargetDensity = resources.getDisplayMetrics().densityDpi;
        }
        this.mBitmap = bitmap;
        if (bitmap != null) {
            computeBitmapSize();
            Bitmap bitmap2 = this.mBitmap;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            bitmapShader = new BitmapShader(bitmap2, tileMode, tileMode);
        } else {
            this.mBitmapHeight = -1;
            this.mBitmapWidth = -1;
            bitmapShader = null;
        }
        this.mBitmapShader = bitmapShader;
    }

    private void computeBitmapSize() {
        this.mBitmapWidth = this.mBitmap.getScaledWidth(this.mTargetDensity);
        this.mBitmapHeight = this.mBitmap.getScaledHeight(this.mTargetDensity);
    }

    public static boolean isGreaterThanZero(float f) {
        return f > 0.05f;
    }

    private void updateCircularCornerRadius() {
        this.mCornerRadius = (float) (Math.min(this.mBitmapHeight, this.mBitmapWidth) / 2);
    }

    public void draw(@NonNull Canvas canvas) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            updateDstRect();
            if (this.mPaint.getShader() == null) {
                canvas.drawBitmap(bitmap, (Rect) null, this.mDstRect, this.mPaint);
                return;
            }
            RectF rectF = this.mDstRectF;
            float f = this.mCornerRadius;
            canvas.drawRoundRect(rectF, f, f, this.mPaint);
        }
    }

    public int getAlpha() {
        return this.mPaint.getAlpha();
    }

    @Nullable
    public final Bitmap getBitmap() {
        return this.mBitmap;
    }

    public ColorFilter getColorFilter() {
        return this.mPaint.getColorFilter();
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    public int getGravity() {
        return this.mGravity;
    }

    public int getIntrinsicHeight() {
        return this.mBitmapHeight;
    }

    public int getIntrinsicWidth() {
        return this.mBitmapWidth;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r0 = r3.mBitmap;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getOpacity() {
        /*
            r3 = this;
            int r0 = r3.mGravity
            r1 = -3
            r2 = 119(0x77, float:1.67E-43)
            if (r0 != r2) goto L_0x002a
            boolean r0 = r3.mIsCircular
            if (r0 == 0) goto L_0x000c
            goto L_0x002a
        L_0x000c:
            android.graphics.Bitmap r0 = r3.mBitmap
            if (r0 == 0) goto L_0x002a
            boolean r0 = r0.hasAlpha()
            if (r0 != 0) goto L_0x002a
            android.graphics.Paint r0 = r3.mPaint
            int r0 = r0.getAlpha()
            r2 = 255(0xff, float:3.57E-43)
            if (r0 < r2) goto L_0x002a
            float r0 = r3.mCornerRadius
            boolean r0 = isGreaterThanZero(r0)
            if (r0 == 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r1 = -1
        L_0x002a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.RoundedBitmapDrawable.getOpacity():int");
    }

    @NonNull
    public final Paint getPaint() {
        return this.mPaint;
    }

    public void gravityCompatApply(int i, int i2, int i3, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    public boolean hasAntiAlias() {
        return this.mPaint.isAntiAlias();
    }

    public boolean hasMipMap() {
        throw new UnsupportedOperationException();
    }

    public boolean isCircular() {
        return this.mIsCircular;
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.mIsCircular) {
            updateCircularCornerRadius();
        }
        this.mApplyGravity = true;
    }

    public void setAlpha(int i) {
        if (i != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setAntiAlias(boolean z) {
        this.mPaint.setAntiAlias(z);
        invalidateSelf();
    }

    public void setCircular(boolean z) {
        this.mIsCircular = z;
        this.mApplyGravity = true;
        if (z) {
            updateCircularCornerRadius();
            this.mPaint.setShader(this.mBitmapShader);
            invalidateSelf();
            return;
        }
        setCornerRadius(0.0f);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setCornerRadius(float f) {
        BitmapShader bitmapShader;
        Paint paint;
        if (this.mCornerRadius != f) {
            this.mIsCircular = false;
            if (isGreaterThanZero(f)) {
                paint = this.mPaint;
                bitmapShader = this.mBitmapShader;
            } else {
                paint = this.mPaint;
                bitmapShader = null;
            }
            paint.setShader(bitmapShader);
            this.mCornerRadius = f;
            invalidateSelf();
        }
    }

    public void setDither(boolean z) {
        this.mPaint.setDither(z);
        invalidateSelf();
    }

    public void setFilterBitmap(boolean z) {
        this.mPaint.setFilterBitmap(z);
        invalidateSelf();
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            this.mGravity = i;
            this.mApplyGravity = true;
            invalidateSelf();
        }
    }

    public void setMipMap(boolean z) {
        throw new UnsupportedOperationException();
    }

    public void setTargetDensity(int i) {
        if (this.mTargetDensity != i) {
            if (i == 0) {
                i = DrawerLayout.PEEK_DELAY;
            }
            this.mTargetDensity = i;
            if (this.mBitmap != null) {
                computeBitmapSize();
            }
            invalidateSelf();
        }
    }

    public void setTargetDensity(@NonNull Canvas canvas) {
        setTargetDensity(canvas.getDensity());
    }

    public void setTargetDensity(@NonNull DisplayMetrics displayMetrics) {
        setTargetDensity(displayMetrics.densityDpi);
    }

    public void updateDstRect() {
        if (this.mApplyGravity) {
            if (this.mIsCircular) {
                int min = Math.min(this.mBitmapWidth, this.mBitmapHeight);
                gravityCompatApply(this.mGravity, min, min, getBounds(), this.mDstRect);
                int min2 = Math.min(this.mDstRect.width(), this.mDstRect.height());
                this.mDstRect.inset(Math.max(0, (this.mDstRect.width() - min2) / 2), Math.max(0, (this.mDstRect.height() - min2) / 2));
                this.mCornerRadius = ((float) min2) * 0.5f;
            } else {
                gravityCompatApply(this.mGravity, this.mBitmapWidth, this.mBitmapHeight, getBounds(), this.mDstRect);
            }
            this.mDstRectF.set(this.mDstRect);
            if (this.mBitmapShader != null) {
                Matrix matrix = this.mShaderMatrix;
                RectF rectF = this.mDstRectF;
                matrix.setTranslate(rectF.left, rectF.top);
                this.mShaderMatrix.preScale(this.mDstRectF.width() / ((float) this.mBitmap.getWidth()), this.mDstRectF.height() / ((float) this.mBitmap.getHeight()));
                this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
                this.mPaint.setShader(this.mBitmapShader);
            }
            this.mApplyGravity = false;
        }
    }
}
