package com.cuatroochenta.miniland.humidificador.base.widget.circleprogress;

import a.c.a.f.b;
import a.c.d.j.b.h.a.c;
import a.c.d.j.b.h.a.d;
import a.c.d.j.b.h.a.e;
import a.c.d.j.b.h.a.f;
import a.h.a.g0;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.Typeface;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment;
import com.tuya.smart.common.oOO0O0O0;
import java.text.DecimalFormat;

public class CircleProgressView extends View {
    public int A = 0;
    public int B = -1434201911;
    public int C = ViewCompat.MEASURED_STATE_MASK;
    public int D = ViewCompat.MEASURED_STATE_MASK;
    public boolean E = false;
    public int[] F = {-16738680};
    public Paint.Cap G;
    public Paint.Cap H;
    public Paint I;
    public Paint J;
    public Paint K;
    public Paint L;
    public Paint M;
    public Paint N;
    public Paint O;
    public RectF P;
    public RectF Q;
    public PointF R;
    public RectF S;
    public RectF T;
    public RectF U;
    public RectF V;
    public RectF W;

    /* renamed from: a  reason: collision with root package name */
    public float f3892a = 42.0f;
    public String a0;

    /* renamed from: b  reason: collision with root package name */
    public float f3893b = 0.0f;
    public int b0;

    /* renamed from: c  reason: collision with root package name */
    public float f3894c = 0.0f;
    public String c0;

    /* renamed from: d  reason: collision with root package name */
    public float f3895d = 100.0f;
    public f d0;

    /* renamed from: e  reason: collision with root package name */
    public float f3896e = 0.0f;
    public e e0;
    public float f = 42.0f;
    public boolean f0;
    public float g = 0.0f;
    public boolean g0;
    public float h = 2.8f;
    public Bitmap h0;
    public double i = 900.0d;
    public Paint i0;
    public int j = 10;
    public float j0;
    public boolean k;
    public boolean k0;
    public a.c.d.j.b.h.a.a l = new a.c.d.j.b.h.a.a(this);
    public boolean l0;
    public c m = c.IDLE;
    public boolean m0;
    public d n;
    public int n0;
    public int o = 0;
    public float o0;
    public int p = 0;
    public float p0;
    public int q = 40;
    public float q0;
    public int r = 40;
    public int r0;
    public int s = BottomAppBarTopEdgeTreatment.ANGLE_UP;
    public a s0;
    public float t = 1.0f;
    public float t0;
    public int u = 10;
    public DecimalFormat u0;
    public int v = 10;
    public Typeface v0;
    public float w = 1.0f;
    public Typeface w0;
    public float x = 1.0f;
    public int y = -1442840576;
    public int z = -16738680;

    public interface a {
        void a(float f);
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint.Cap cap = Paint.Cap.BUTT;
        this.G = cap;
        this.H = cap;
        this.I = new Paint();
        this.J = new Paint();
        this.K = new Paint();
        this.L = new Paint();
        this.M = new Paint();
        this.N = new Paint();
        this.O = new Paint();
        this.P = new RectF();
        this.Q = new RectF();
        this.S = new RectF();
        this.T = new RectF();
        this.U = new RectF();
        this.V = new RectF();
        this.W = new RectF();
        this.a0 = "";
        this.c0 = "";
        this.d0 = f.RIGHT_TOP;
        this.e0 = e.PERCENT;
        this.g0 = false;
        this.j0 = 1.0f;
        this.k0 = false;
        this.l0 = false;
        this.m0 = false;
        this.n0 = 18;
        this.o0 = 0.9f;
        float f2 = (float) (360 / 18);
        this.p0 = f2;
        this.q0 = f2 * 0.9f;
        this.u0 = new DecimalFormat(oOO0O0O0.O0000oO0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g0.CircleProgressView);
        setBarWidth((int) obtainStyledAttributes.getDimension(6, (float) this.q));
        setRimWidth((int) obtainStyledAttributes.getDimension(15, (float) this.r));
        setSpinSpeed((float) ((int) obtainStyledAttributes.getFloat(21, this.h)));
        float f3 = obtainStyledAttributes.getFloat(36, this.f3892a);
        setValue(f3);
        this.f3892a = f3;
        if (obtainStyledAttributes.hasValue(2) && obtainStyledAttributes.hasValue(3) && obtainStyledAttributes.hasValue(4) && obtainStyledAttributes.hasValue(5)) {
            this.F = new int[]{obtainStyledAttributes.getColor(2, -16738680), obtainStyledAttributes.getColor(3, -16738680), obtainStyledAttributes.getColor(4, -16738680), obtainStyledAttributes.getColor(5, -16738680)};
        } else if (obtainStyledAttributes.hasValue(2) && obtainStyledAttributes.hasValue(3) && obtainStyledAttributes.hasValue(4)) {
            this.F = new int[]{obtainStyledAttributes.getColor(2, -16738680), obtainStyledAttributes.getColor(3, -16738680), obtainStyledAttributes.getColor(4, -16738680)};
        } else if (!obtainStyledAttributes.hasValue(2) || !obtainStyledAttributes.hasValue(3)) {
            this.F = new int[]{obtainStyledAttributes.getColor(2, -16738680), obtainStyledAttributes.getColor(2, -16738680)};
        } else {
            this.F = new int[]{obtainStyledAttributes.getColor(2, -16738680), obtainStyledAttributes.getColor(3, -16738680)};
        }
        setSpinBarColor(obtainStyledAttributes.getColor(20, this.z));
        setSpinningBarLength(obtainStyledAttributes.getFloat(19, this.f));
        if (obtainStyledAttributes.hasValue(27)) {
            setTextSize((int) obtainStyledAttributes.getDimension(27, (float) this.v));
        }
        if (obtainStyledAttributes.hasValue(33)) {
            setUnitSize((int) obtainStyledAttributes.getDimension(33, (float) this.u));
        }
        if (obtainStyledAttributes.hasValue(24)) {
            setTextColor(obtainStyledAttributes.getColor(24, this.C));
        }
        if (obtainStyledAttributes.hasValue(30)) {
            setUnitColor(obtainStyledAttributes.getColor(30, this.D));
        }
        if (obtainStyledAttributes.hasValue(0)) {
            setTextColorAuto(obtainStyledAttributes.getBoolean(0, this.E));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            setAutoTextSize(obtainStyledAttributes.getBoolean(1, this.f0));
        }
        if (obtainStyledAttributes.hasValue(25)) {
            setTextMode(e.values()[obtainStyledAttributes.getInt(25, 0)]);
        }
        if (obtainStyledAttributes.hasValue(31)) {
            setUnitPosition(f.values()[obtainStyledAttributes.getInt(31, 3)]);
        }
        if (obtainStyledAttributes.hasValue(23)) {
            setText(obtainStyledAttributes.getString(23));
        }
        setUnitToTextScale(obtainStyledAttributes.getFloat(34, 1.0f));
        setRimColor(obtainStyledAttributes.getColor(14, this.B));
        setFillCircleColor(obtainStyledAttributes.getColor(12, this.A));
        setContourColor(obtainStyledAttributes.getColor(9, this.y));
        setContourSize(obtainStyledAttributes.getDimension(10, this.t));
        setMaxValue(obtainStyledAttributes.getFloat(13, this.f3895d));
        setUnit(obtainStyledAttributes.getString(29));
        setUnitVisible(obtainStyledAttributes.getBoolean(18, this.g0));
        setTextScale(obtainStyledAttributes.getFloat(26, this.w));
        setUnitScale(obtainStyledAttributes.getFloat(32, this.x));
        setSeekModeEnabled(obtainStyledAttributes.getBoolean(16, this.k0));
        setStartAngle(obtainStyledAttributes.getInt(22, this.s));
        setShowTextWhileSpinning(obtainStyledAttributes.getBoolean(17, this.l0));
        if (obtainStyledAttributes.hasValue(7)) {
            setBlockCount(obtainStyledAttributes.getInt(7, 1));
            setBlockScale(obtainStyledAttributes.getFloat(8, 0.9f));
        }
        if (obtainStyledAttributes.hasValue(28)) {
            try {
                this.v0 = Typeface.createFromAsset(getContext().getAssets(), obtainStyledAttributes.getString(28));
            } catch (Exception unused) {
            }
        }
        if (obtainStyledAttributes.hasValue(35)) {
            try {
                this.w0 = Typeface.createFromAsset(getContext().getAssets(), obtainStyledAttributes.getString(35));
            } catch (Exception unused2) {
            }
        }
        if (obtainStyledAttributes.hasValue(11)) {
            try {
                String string = obtainStyledAttributes.getString(11);
                if (string != null) {
                    this.u0 = new DecimalFormat(string);
                }
            } catch (Exception e2) {
                Log.w("CircleView", e2.getMessage());
            }
        }
        obtainStyledAttributes.recycle();
        if (!isInEditMode()) {
            setLayerType(2, (Paint) null);
        }
        Paint paint = new Paint(1);
        this.i0 = paint;
        paint.setFilterBitmap(false);
        this.i0.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        l();
        this.J.setAntiAlias(true);
        this.J.setStrokeCap(this.H);
        this.J.setStyle(Paint.Style.STROKE);
        this.J.setStrokeWidth((float) this.q);
        this.J.setColor(this.z);
        this.O.setColor(this.y);
        this.O.setAntiAlias(true);
        this.O.setStyle(Paint.Style.STROKE);
        this.O.setStrokeWidth(this.t);
        this.N.setStyle(Paint.Style.FILL);
        this.N.setAntiAlias(true);
        Typeface typeface = this.w0;
        if (typeface != null) {
            this.N.setTypeface(typeface);
        }
        this.M.setSubpixelText(true);
        this.M.setLinearText(true);
        this.M.setTypeface(Typeface.MONOSPACE);
        this.M.setColor(this.C);
        this.M.setStyle(Paint.Style.FILL);
        this.M.setAntiAlias(true);
        this.M.setTextSize((float) this.v);
        Typeface typeface2 = this.v0;
        if (typeface2 != null) {
            this.M.setTypeface(typeface2);
        } else {
            this.M.setTypeface(Typeface.MONOSPACE);
        }
        this.K.setColor(this.A);
        this.K.setAntiAlias(true);
        this.K.setStyle(Paint.Style.FILL);
        this.L.setColor(this.B);
        this.L.setAntiAlias(true);
        this.L.setStyle(Paint.Style.STROKE);
        this.L.setStrokeWidth((float) this.r);
    }

    public static double a(PointF pointF, PointF pointF2) {
        double degrees = Math.toDegrees(Math.atan2((double) (pointF2.y - pointF.y), (double) (pointF2.x - pointF.x)));
        return degrees < 0.0d ? degrees + 360.0d : degrees;
    }

    public static float d(String str, Paint paint, RectF rectF) {
        Matrix matrix = new Matrix();
        Rect rect = new Rect();
        String replace = str.replace('1', '0');
        paint.getTextBounds(replace, 0, replace.length(), rect);
        matrix.setRectToRect(new RectF(rect), rectF, Matrix.ScaleToFit.CENTER);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return paint.getTextSize() * fArr[0];
    }

    public static float j(float f2) {
        return ((f2 % 360.0f) + 360.0f) % 360.0f;
    }

    private void setTextSizeAndTextBoundsWithFixedTextSize(String str) {
        this.M.setTextSize((float) this.v);
        this.T = b(str, this.M, this.P);
    }

    public final RectF b(String str, Paint paint, RectF rectF) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        float width = (float) (rect.width() + rect.left);
        float height = (((float) rect.height()) * 0.93f) + ((float) rect.bottom);
        RectF rectF2 = new RectF();
        rectF2.left = ((rectF.width() - width) / 2.0f) + rectF.left;
        float height2 = ((rectF.height() - height) / 2.0f) + rectF.top;
        rectF2.top = height2;
        rectF2.right = rectF2.left + width;
        rectF2.bottom = height2 + height;
        return rectF2;
    }

    public final int c(double d2) {
        int[] iArr = this.F;
        if (iArr.length <= 1) {
            return iArr.length == 1 ? iArr[0] : ViewCompat.MEASURED_STATE_MASK;
        }
        double maxValue = (double) (1.0f / getMaxValue());
        Double.isNaN(maxValue);
        double d3 = maxValue * d2;
        double length = (double) (this.F.length - 1);
        Double.isNaN(length);
        int floor = (int) Math.floor(length * d3);
        int i2 = floor + 1;
        if (floor < 0) {
            floor = 0;
            i2 = 1;
        } else {
            int[] iArr2 = this.F;
            if (i2 >= iArr2.length) {
                floor = iArr2.length - 2;
                i2 = iArr2.length - 1;
            }
        }
        int[] iArr3 = this.F;
        int i3 = iArr3[floor];
        int i4 = iArr3[i2];
        double length2 = (double) (iArr3.length - 1);
        Double.isNaN(length2);
        float f2 = (float) (1.0d - ((length2 * d3) % 1.0d));
        int[] iArr4 = {b.K((float) Color.red(i3), (float) Color.red(i4), f2), b.K((float) Color.green(i3), (float) Color.green(i4), f2), b.K((float) Color.blue(i3), (float) Color.blue(i4), f2)};
        return Color.argb(255, iArr4[0], iArr4[1], iArr4[2]);
    }

    public final void e(Canvas canvas, float f2) {
        boolean z2 = this.m0;
        RectF rectF = this.P;
        if (!z2) {
            canvas.drawArc(rectF, (float) this.s, f2, false, this.I);
            return;
        }
        f(canvas, rectF, (float) this.s, f2, false, this.I);
    }

    public final void f(Canvas canvas, RectF rectF, float f2, float f3, boolean z2, Paint paint) {
        float f4 = 0.0f;
        while (f4 < f3) {
            Canvas canvas2 = canvas;
            RectF rectF2 = rectF;
            canvas2.drawArc(rectF2, f2 + f4, Math.min(this.q0, f3 - f4), z2, paint);
            f4 += this.p0;
        }
    }

    public final void g(Canvas canvas) {
        if (this.f3896e < 0.0f) {
            this.f3896e = 1.0f;
        }
        float f2 = this.f3896e;
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.P, (((float) this.s) + this.g) - f2, f2, false, this.J);
    }

    public int[] getBarColors() {
        return this.F;
    }

    public Paint.Cap getBarStrokeCap() {
        return this.G;
    }

    public int getBarWidth() {
        return this.q;
    }

    public int getBlockCount() {
        return this.n0;
    }

    public float getBlockScale() {
        return this.o0;
    }

    public int getContourColor() {
        return this.y;
    }

    public float getContourSize() {
        return this.t;
    }

    public DecimalFormat getDecimalFormat() {
        return this.u0;
    }

    public int getDelayMillis() {
        return this.j;
    }

    public int getFillColor() {
        return this.K.getColor();
    }

    public float getMaxValue() {
        return this.f3895d;
    }

    public float getRelativeUniteSize() {
        return this.j0;
    }

    public int getRimColor() {
        return this.B;
    }

    public Shader getRimShader() {
        return this.L.getShader();
    }

    public int getRimWidth() {
        return this.r;
    }

    public float getSpinSpeed() {
        return this.h;
    }

    public Paint.Cap getSpinnerStrokeCap() {
        return this.H;
    }

    public int getStartAngle() {
        return this.s;
    }

    public float getTextScale() {
        return this.w;
    }

    public int getTextSize() {
        return this.v;
    }

    public String getUnit() {
        return this.c0;
    }

    public float getUnitScale() {
        return this.x;
    }

    public int getUnitSize() {
        return this.u;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(android.graphics.Canvas r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            a.c.d.j.b.h.a.f r2 = r0.d0
            int r2 = r2.ordinal()
            r3 = 1
            if (r2 == 0) goto L_0x001a
            if (r2 == r3) goto L_0x001a
            r2 = 1057803469(0x3f0ccccd, float:0.55)
            float r4 = r0.j0
            float r2 = r2 * r4
            r5 = 1050253722(0x3e99999a, float:0.3)
            goto L_0x0023
        L_0x001a:
            r2 = 1048576000(0x3e800000, float:0.25)
            float r4 = r0.j0
            float r2 = r2 * r4
            r5 = 1053609165(0x3ecccccd, float:0.4)
        L_0x0023:
            float r4 = r4 * r5
            r5 = 1020054733(0x3ccccccd, float:0.025)
            r6 = 1028443341(0x3d4ccccd, float:0.05)
            android.graphics.RectF r7 = r0.S
            float r7 = r7.width()
            float r7 = r7 * r6
            r6 = 1073741824(0x40000000, float:2.0)
            float r7 = r7 / r6
            android.graphics.RectF r8 = r0.S
            float r8 = r8.width()
            float r8 = r8 * r4
            android.graphics.RectF r4 = r0.S
            float r4 = r4.height()
            float r4 = r4 * r5
            float r4 = r4 / r6
            android.graphics.RectF r5 = r0.S
            float r5 = r5.height()
            float r5 = r5 * r2
            r2 = 0
            boolean r9 = r0.E
            if (r9 == 0) goto L_0x0060
            android.graphics.Paint r9 = r0.M
            float r10 = r0.f3892a
            double r10 = (double) r10
            int r10 = r0.c(r10)
            r9.setColor(r10)
        L_0x0060:
            a.c.d.j.b.h.a.e r9 = r0.e0
            int r9 = r9.ordinal()
            java.lang.String r10 = "%"
            r11 = 2
            if (r9 == r3) goto L_0x007f
            if (r9 == r11) goto L_0x0075
            java.lang.String r9 = r0.a0
            if (r9 == 0) goto L_0x0072
            goto L_0x009e
        L_0x0072:
            java.lang.String r9 = ""
            goto L_0x009e
        L_0x0075:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.text.DecimalFormat r12 = r0.u0
            float r13 = r0.f3892a
            goto L_0x008f
        L_0x007f:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.text.DecimalFormat r12 = r0.u0
            r13 = 1120403456(0x42c80000, float:100.0)
            float r14 = r0.f3895d
            float r13 = r13 / r14
            float r14 = r0.f3892a
            float r13 = r13 * r14
        L_0x008f:
            double r13 = (double) r13
            java.lang.String r12 = r12.format(r13)
            r9.append(r12)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
        L_0x009e:
            int r10 = r0.b0
            int r12 = r9.length()
            r13 = 4
            if (r10 == r12) goto L_0x015d
            int r2 = r9.length()
            r0.b0 = r2
            if (r2 != r3) goto L_0x00dc
            android.graphics.RectF r2 = r0.P
            android.graphics.RectF r2 = r0.i(r2)
            r0.S = r2
            android.graphics.RectF r2 = new android.graphics.RectF
            android.graphics.RectF r10 = r0.S
            float r12 = r10.left
            float r10 = r10.width()
            r14 = 1036831949(0x3dcccccd, float:0.1)
            float r10 = r10 * r14
            float r10 = r10 + r12
            android.graphics.RectF r12 = r0.S
            float r15 = r12.top
            float r6 = r12.right
            float r12 = r12.width()
            float r12 = r12 * r14
            float r6 = r6 - r12
            android.graphics.RectF r12 = r0.S
            float r12 = r12.bottom
            r2.<init>(r10, r15, r6, r12)
            goto L_0x00e2
        L_0x00dc:
            android.graphics.RectF r2 = r0.P
            android.graphics.RectF r2 = r0.i(r2)
        L_0x00e2:
            r0.S = r2
            boolean r2 = r0.f0
            if (r2 == 0) goto L_0x0159
            android.graphics.RectF r2 = r0.S
            boolean r6 = r0.g0
            if (r6 == 0) goto L_0x0143
            a.c.d.j.b.h.a.f r2 = r0.d0
            int r2 = r2.ordinal()
            if (r2 == 0) goto L_0x0132
            if (r2 == r3) goto L_0x0120
            if (r2 == r11) goto L_0x010e
            if (r2 == r13) goto L_0x010e
            android.graphics.RectF r2 = new android.graphics.RectF
            android.graphics.RectF r6 = r0.S
            float r10 = r6.left
            float r12 = r6.top
            float r14 = r6.right
            float r14 = r14 - r8
            float r14 = r14 - r7
            float r6 = r6.bottom
            r2.<init>(r10, r12, r14, r6)
            goto L_0x0143
        L_0x010e:
            android.graphics.RectF r2 = new android.graphics.RectF
            android.graphics.RectF r6 = r0.S
            float r10 = r6.left
            float r10 = r10 + r8
            float r10 = r10 + r7
            float r12 = r6.top
            float r14 = r6.right
            float r6 = r6.bottom
            r2.<init>(r10, r12, r14, r6)
            goto L_0x0143
        L_0x0120:
            android.graphics.RectF r2 = new android.graphics.RectF
            android.graphics.RectF r6 = r0.S
            float r10 = r6.left
            float r12 = r6.top
            float r14 = r6.right
            float r6 = r6.bottom
            float r6 = r6 - r5
            float r6 = r6 - r4
            r2.<init>(r10, r12, r14, r6)
            goto L_0x0143
        L_0x0132:
            android.graphics.RectF r2 = new android.graphics.RectF
            android.graphics.RectF r6 = r0.S
            float r10 = r6.left
            float r12 = r6.top
            float r12 = r12 + r5
            float r12 = r12 + r4
            float r14 = r6.right
            float r6 = r6.bottom
            r2.<init>(r10, r12, r14, r6)
        L_0x0143:
            android.graphics.Paint r6 = r0.M
            float r10 = d(r9, r6, r2)
            float r12 = r0.w
            float r10 = r10 * r12
            r6.setTextSize(r10)
            android.graphics.Paint r6 = r0.M
            android.graphics.RectF r2 = r0.b(r9, r6, r2)
            r0.T = r2
            goto L_0x015c
        L_0x0159:
            r0.setTextSizeAndTextBoundsWithFixedTextSize(r9)
        L_0x015c:
            r2 = 1
        L_0x015d:
            android.graphics.RectF r6 = r0.T
            float r6 = r6.left
            android.graphics.Paint r10 = r0.M
            float r10 = r10.getTextSize()
            r12 = 1017370378(0x3ca3d70a, float:0.02)
            float r10 = r10 * r12
            float r6 = r6 - r10
            android.graphics.RectF r10 = r0.T
            float r10 = r10.bottom
            android.graphics.Paint r14 = r0.M
            r1.drawText(r9, r6, r10, r14)
            boolean r6 = r0.g0
            if (r6 == 0) goto L_0x02c3
            boolean r6 = r0.E
            if (r6 == 0) goto L_0x018a
            android.graphics.Paint r6 = r0.N
            float r9 = r0.f3892a
            double r9 = (double) r9
            int r9 = r0.c(r9)
            r6.setColor(r9)
        L_0x018a:
            if (r2 == 0) goto L_0x02ab
            boolean r2 = r0.f0
            r6 = 5
            r9 = 3
            r10 = 0
            if (r2 == 0) goto L_0x0226
            a.c.d.j.b.h.a.f r2 = r0.d0
            int r2 = r2.ordinal()
            if (r2 == 0) goto L_0x01d1
            if (r2 == r3) goto L_0x01c0
            if (r2 == r11) goto L_0x01b1
            if (r2 == r13) goto L_0x01b1
            android.graphics.RectF r2 = new android.graphics.RectF
            android.graphics.RectF r3 = r0.S
            float r4 = r3.right
            float r8 = r4 - r8
            float r8 = r8 + r7
            float r3 = r3.top
            float r5 = r5 + r3
            r2.<init>(r8, r3, r4, r5)
            goto L_0x01e0
        L_0x01b1:
            android.graphics.RectF r2 = new android.graphics.RectF
            android.graphics.RectF r3 = r0.S
            float r4 = r3.left
            float r3 = r3.top
            float r8 = r8 + r4
            float r8 = r8 - r7
            float r5 = r5 + r3
            r2.<init>(r4, r3, r8, r5)
            goto L_0x01e0
        L_0x01c0:
            android.graphics.RectF r2 = new android.graphics.RectF
            android.graphics.RectF r3 = r0.S
            float r7 = r3.left
            float r8 = r3.bottom
            float r5 = r8 - r5
            float r5 = r5 + r4
            float r3 = r3.right
            r2.<init>(r7, r5, r3, r8)
            goto L_0x01e0
        L_0x01d1:
            android.graphics.RectF r2 = new android.graphics.RectF
            android.graphics.RectF r3 = r0.S
            float r7 = r3.left
            float r8 = r3.top
            float r3 = r3.right
            float r5 = r5 + r8
            float r5 = r5 - r4
            r2.<init>(r7, r8, r3, r5)
        L_0x01e0:
            r0.U = r2
            android.graphics.Paint r2 = r0.N
            java.lang.String r3 = r0.c0
            android.graphics.RectF r4 = r0.U
            float r3 = d(r3, r2, r4)
            float r4 = r0.x
            float r3 = r3 * r4
            r2.setTextSize(r3)
            java.lang.String r2 = r0.c0
            android.graphics.Paint r3 = r0.N
            android.graphics.RectF r4 = r0.U
            android.graphics.RectF r2 = r0.b(r2, r3, r4)
            r0.U = r2
            a.c.d.j.b.h.a.f r2 = r0.d0
            int r2 = r2.ordinal()
            if (r2 == r11) goto L_0x0218
            if (r2 == r9) goto L_0x0218
            if (r2 == r13) goto L_0x020f
            if (r2 == r6) goto L_0x020f
            goto L_0x02ab
        L_0x020f:
            android.graphics.RectF r2 = r0.T
            float r2 = r2.bottom
            android.graphics.RectF r3 = r0.U
            float r4 = r3.bottom
            goto L_0x0220
        L_0x0218:
            android.graphics.RectF r2 = r0.T
            float r2 = r2.top
            android.graphics.RectF r3 = r0.U
            float r4 = r3.top
        L_0x0220:
            float r2 = r2 - r4
            r3.offset(r10, r2)
            goto L_0x02ab
        L_0x0226:
            r2 = 1073741824(0x40000000, float:2.0)
            float r7 = r7 * r2
            float r4 = r4 * r2
            android.graphics.Paint r2 = r0.N
            int r5 = r0.u
            float r5 = (float) r5
            r2.setTextSize(r5)
            java.lang.String r2 = r0.c0
            android.graphics.Paint r5 = r0.N
            android.graphics.RectF r8 = r0.S
            android.graphics.RectF r2 = r0.b(r2, r5, r8)
            r0.U = r2
            a.c.d.j.b.h.a.f r2 = r0.d0
            int r2 = r2.ordinal()
            if (r2 == 0) goto L_0x0276
            if (r2 == r3) goto L_0x026c
            if (r2 == r11) goto L_0x0258
            if (r2 == r13) goto L_0x0258
            android.graphics.RectF r2 = r0.U
            android.graphics.RectF r3 = r0.T
            float r3 = r3.right
            float r3 = r3 + r7
            float r4 = r2.top
            goto L_0x0268
        L_0x0258:
            android.graphics.RectF r2 = r0.U
            android.graphics.RectF r3 = r0.T
            float r3 = r3.left
            float r3 = r3 - r7
            float r4 = r2.width()
            float r3 = r3 - r4
            android.graphics.RectF r4 = r0.U
            float r4 = r4.top
        L_0x0268:
            r2.offsetTo(r3, r4)
            goto L_0x0287
        L_0x026c:
            android.graphics.RectF r2 = r0.U
            float r3 = r2.left
            android.graphics.RectF r5 = r0.T
            float r5 = r5.bottom
            float r5 = r5 + r4
            goto L_0x0284
        L_0x0276:
            android.graphics.RectF r2 = r0.U
            float r3 = r2.left
            android.graphics.RectF r5 = r0.T
            float r5 = r5.top
            float r5 = r5 - r4
            float r4 = r2.height()
            float r5 = r5 - r4
        L_0x0284:
            r2.offsetTo(r3, r5)
        L_0x0287:
            a.c.d.j.b.h.a.f r2 = r0.d0
            int r2 = r2.ordinal()
            if (r2 == r11) goto L_0x029f
            if (r2 == r9) goto L_0x029f
            if (r2 == r13) goto L_0x0296
            if (r2 == r6) goto L_0x0296
            goto L_0x02ab
        L_0x0296:
            android.graphics.RectF r2 = r0.T
            float r2 = r2.bottom
            android.graphics.RectF r3 = r0.U
            float r4 = r3.bottom
            goto L_0x02a7
        L_0x029f:
            android.graphics.RectF r2 = r0.T
            float r2 = r2.top
            android.graphics.RectF r3 = r0.U
            float r4 = r3.top
        L_0x02a7:
            float r2 = r2 - r4
            r3.offset(r10, r2)
        L_0x02ab:
            java.lang.String r2 = r0.c0
            android.graphics.RectF r3 = r0.U
            float r3 = r3.left
            android.graphics.Paint r4 = r0.N
            float r4 = r4.getTextSize()
            float r4 = r4 * r12
            float r3 = r3 - r4
            android.graphics.RectF r4 = r0.U
            float r4 = r4.bottom
            android.graphics.Paint r5 = r0.N
            r1.drawText(r2, r3, r4, r5)
        L_0x02c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cuatroochenta.miniland.humidificador.base.widget.circleprogress.CircleProgressView.h(android.graphics.Canvas):void");
    }

    public final RectF i(RectF rectF) {
        float f2;
        double width = (double) ((rectF.width() - ((float) Math.max(this.q, this.r))) - (this.t * 2.0f));
        Double.isNaN(width);
        float width2 = (rectF.width() - ((float) (Math.sqrt(2.0d) * (width / 2.0d)))) / 2.0f;
        float f3 = 1.0f;
        if (this.g0) {
            int ordinal = this.d0.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                f3 = 1.1f;
                f2 = 0.88f;
                float f4 = f3 * width2;
                float f5 = width2 * f2;
                return new RectF(rectF.left + f4, rectF.top + f5, rectF.right - f4, rectF.bottom - f5);
            } else if (ordinal == 2 || ordinal == 3 || ordinal == 4 || ordinal == 5) {
                f3 = 0.77f;
                f2 = 1.33f;
                float f42 = f3 * width2;
                float f52 = width2 * f2;
                return new RectF(rectF.left + f42, rectF.top + f52, rectF.right - f42, rectF.bottom - f52);
            }
        }
        f2 = 1.0f;
        float f422 = f3 * width2;
        float f522 = width2 * f2;
        return new RectF(rectF.left + f422, rectF.top + f522, rectF.right - f422, rectF.bottom - f522);
    }

    public void k(float f2, long j2) {
        float f3 = this.f3892a;
        this.i = (double) j2;
        Message message = new Message();
        message.what = 3;
        message.obj = new float[]{f3, f2};
        this.l.sendMessage(message);
        a aVar = this.s0;
        if (aVar != null && f2 != this.t0) {
            aVar.a(f2);
            this.t0 = f2;
        }
    }

    public final void l() {
        int[] iArr = this.F;
        if (iArr.length > 1) {
            this.I.setShader(new SweepGradient(this.P.centerX(), this.P.centerY(), this.F, (float[]) null));
            Matrix matrix = new Matrix();
            this.I.getShader().getLocalMatrix(matrix);
            matrix.postTranslate(-this.P.centerX(), -this.P.centerY());
            matrix.postRotate((float) this.s);
            matrix.postTranslate(this.P.centerX(), this.P.centerY());
            this.I.getShader().setLocalMatrix(matrix);
        } else {
            this.I.setColor(iArr[0]);
            this.I.setShader((Shader) null);
        }
        this.I.setAntiAlias(true);
        this.I.setStrokeCap(this.G);
        this.I.setStyle(Paint.Style.STROKE);
        this.I.setStrokeWidth((float) this.q);
    }

    public final void m() {
        this.b0 = -1;
        this.S = i(this.P);
        invalidate();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0076, code lost:
        if (r8.l0 != false) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0082, code lost:
        if (r8.l0 != false) goto L_0x0084;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r9) {
        /*
            r8 = this;
            super.onDraw(r9)
            float r0 = r8.f3895d
            r1 = 1135869952(0x43b40000, float:360.0)
            float r1 = r1 / r0
            float r0 = r8.f3892a
            float r7 = r1 * r0
            int r0 = r8.A
            if (r0 == 0) goto L_0x001d
            android.graphics.RectF r1 = r8.Q
            r2 = 1135869952(0x43b40000, float:360.0)
            r3 = 1135869952(0x43b40000, float:360.0)
            r4 = 0
            android.graphics.Paint r5 = r8.K
            r0 = r9
            r0.drawArc(r1, r2, r3, r4, r5)
        L_0x001d:
            int r0 = r8.r
            if (r0 <= 0) goto L_0x0042
            boolean r0 = r8.m0
            if (r0 != 0) goto L_0x0033
            android.graphics.RectF r1 = r8.P
            r2 = 1135869952(0x43b40000, float:360.0)
            r3 = 1135869952(0x43b40000, float:360.0)
            r4 = 0
            android.graphics.Paint r5 = r8.L
            r0 = r9
            r0.drawArc(r1, r2, r3, r4, r5)
            goto L_0x0042
        L_0x0033:
            android.graphics.RectF r2 = r8.P
            int r0 = r8.s
            float r3 = (float) r0
            r4 = 1135869952(0x43b40000, float:360.0)
            r5 = 0
            android.graphics.Paint r6 = r8.L
            r0 = r8
            r1 = r9
            r0.f(r1, r2, r3, r4, r5, r6)
        L_0x0042:
            float r0 = r8.t
            r6 = 0
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x005d
            android.graphics.RectF r1 = r8.V
            r2 = 1135869952(0x43b40000, float:360.0)
            r3 = 1135869952(0x43b40000, float:360.0)
            r4 = 0
            android.graphics.Paint r5 = r8.O
            r0 = r9
            r0.drawArc(r1, r2, r3, r4, r5)
            android.graphics.RectF r1 = r8.W
            android.graphics.Paint r5 = r8.O
            r0.drawArc(r1, r2, r3, r4, r5)
        L_0x005d:
            a.c.d.j.b.h.a.c r0 = r8.m
            a.c.d.j.b.h.a.c r1 = a.c.d.j.b.h.a.c.SPINNING
            if (r0 == r1) goto L_0x007d
            a.c.d.j.b.h.a.c r1 = a.c.d.j.b.h.a.c.END_SPINNING
            if (r0 != r1) goto L_0x0068
            goto L_0x007d
        L_0x0068:
            a.c.d.j.b.h.a.c r1 = a.c.d.j.b.h.a.c.END_SPINNING_START_ANIMATING
            if (r0 != r1) goto L_0x0079
            r8.g(r9)
            boolean r0 = r8.k
            if (r0 == 0) goto L_0x0074
            goto L_0x0079
        L_0x0074:
            boolean r0 = r8.l0
            if (r0 == 0) goto L_0x0087
            goto L_0x0084
        L_0x0079:
            r8.e(r9, r7)
            goto L_0x0084
        L_0x007d:
            r8.g(r9)
            boolean r0 = r8.l0
            if (r0 == 0) goto L_0x0087
        L_0x0084:
            r8.h(r9)
        L_0x0087:
            android.graphics.Bitmap r0 = r8.h0
            if (r0 == 0) goto L_0x0090
            android.graphics.Paint r1 = r8.i0
            r9.drawBitmap(r0, r6, r6, r1)
        L_0x0090:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cuatroochenta.miniland.humidificador.base.widget.circleprogress.CircleProgressView.onDraw(android.graphics.Canvas):void");
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (measuredHeight - getPaddingTop()) - getPaddingBottom();
        if (paddingLeft > paddingTop) {
            paddingLeft = paddingTop;
        }
        setMeasuredDimension(getPaddingRight() + getPaddingLeft() + paddingLeft, getPaddingBottom() + getPaddingTop() + paddingLeft);
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.p = i2;
        this.o = i3;
        int min = Math.min(i2, i3);
        int i6 = this.p - min;
        int i7 = (this.o - min) / 2;
        float paddingTop = (float) (getPaddingTop() + i7);
        float paddingBottom = (float) (getPaddingBottom() + i7);
        int i8 = i6 / 2;
        float paddingLeft = (float) (getPaddingLeft() + i8);
        float paddingRight = (float) (getPaddingRight() + i8);
        int width = getWidth();
        int height = getHeight();
        float f2 = ((float) this.q) / 2.0f;
        float f3 = (((float) this.r) / 2.0f) + this.t;
        if (f2 <= f3) {
            f2 = f3;
        }
        float f4 = ((float) width) - paddingRight;
        float f5 = ((float) height) - paddingBottom;
        this.P = new RectF(paddingLeft + f2, paddingTop + f2, f4 - f2, f5 - f2);
        float f6 = (float) this.q;
        this.Q = new RectF(paddingLeft + f6, paddingTop + f6, f4 - f6, f5 - f6);
        this.S = i(this.P);
        RectF rectF = this.P;
        float f7 = rectF.left;
        float f8 = ((float) this.r) / 2.0f;
        float f9 = this.t / 2.0f;
        this.W = new RectF(f7 + f8 + f9, rectF.top + f8 + f9, (rectF.right - f8) - f9, (rectF.bottom - f8) - f9);
        RectF rectF2 = this.P;
        float f10 = rectF2.left;
        float f11 = ((float) this.r) / 2.0f;
        float f12 = this.t / 2.0f;
        this.V = new RectF((f10 - f11) - f12, (rectF2.top - f11) - f12, rectF2.right + f11 + f12, f11 + rectF2.bottom + f12);
        this.R = new PointF(this.P.centerX(), this.P.centerY());
        l();
        Bitmap bitmap = this.h0;
        if (bitmap != null) {
            this.h0 = Bitmap.createScaledBitmap(bitmap, getWidth(), getHeight(), false);
        }
        invalidate();
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (!this.k0) {
            return super.onTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 || actionMasked == 1) {
            this.r0 = 0;
            double a2 = a(this.R, new PointF(motionEvent.getX(), motionEvent.getY()));
            double d2 = (double) this.s;
            Double.isNaN(d2);
            k((this.f3895d / 360.0f) * j((float) Math.round(a2 - d2)), 800);
            return true;
        } else if (actionMasked == 2) {
            int i2 = this.r0 + 1;
            this.r0 = i2;
            if (i2 <= 5) {
                return false;
            }
            double a3 = a(this.R, new PointF(motionEvent.getX(), motionEvent.getY()));
            double d3 = (double) this.s;
            Double.isNaN(d3);
            setValue((this.f3895d / 360.0f) * j((float) Math.round(a3 - d3)));
            return true;
        } else if (actionMasked != 3) {
            return super.onTouchEvent(motionEvent);
        } else {
            this.r0 = 0;
            return false;
        }
    }

    public void setAutoTextSize(boolean z2) {
        this.f0 = z2;
    }

    public void setBarColor(@ColorInt int... iArr) {
        this.F = iArr;
        if (iArr.length > 1) {
            this.I.setShader(new SweepGradient(this.P.centerX(), this.P.centerY(), iArr, (float[]) null));
            Matrix matrix = new Matrix();
            this.I.getShader().getLocalMatrix(matrix);
            matrix.postTranslate(-this.P.centerX(), -this.P.centerY());
            matrix.postRotate((float) this.s);
            matrix.postTranslate(this.P.centerX(), this.P.centerY());
            this.I.getShader().setLocalMatrix(matrix);
            this.I.setColor(iArr[0]);
            return;
        }
        if (iArr.length == 1) {
            this.I.setColor(iArr[0]);
        } else {
            this.I.setColor(-16738680);
        }
        this.I.setShader((Shader) null);
    }

    public void setBarStrokeCap(Paint.Cap cap) {
        this.G = cap;
        this.I.setStrokeCap(cap);
    }

    public void setBarWidth(@FloatRange(from = 0.0d) int i2) {
        this.q = i2;
        float f2 = (float) i2;
        this.I.setStrokeWidth(f2);
        this.J.setStrokeWidth(f2);
    }

    public void setBlockCount(int i2) {
        if (i2 > 1) {
            this.m0 = true;
            this.n0 = i2;
            float f2 = 360.0f / ((float) i2);
            this.p0 = f2;
            this.q0 = f2 * this.o0;
            return;
        }
        this.m0 = false;
    }

    public void setBlockScale(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.o0 = f2;
            this.q0 = this.p0 * f2;
        }
    }

    @TargetApi(11)
    public void setClippingBitmap(Bitmap bitmap) {
        if (getWidth() > 0 && getHeight() > 0) {
            bitmap = Bitmap.createScaledBitmap(bitmap, getWidth(), getHeight(), false);
        }
        this.h0 = bitmap;
        setLayerType(this.h0 == null ? 2 : 1, (Paint) null);
    }

    public void setContourColor(@ColorInt int i2) {
        this.y = i2;
        this.O.setColor(i2);
    }

    public void setContourSize(@FloatRange(from = 0.0d) float f2) {
        this.t = f2;
        this.O.setStrokeWidth(f2);
    }

    public void setDecimalFormat(DecimalFormat decimalFormat) {
        if (decimalFormat != null) {
            this.u0 = decimalFormat;
            return;
        }
        throw new IllegalArgumentException("decimalFormat must not be null!");
    }

    public void setDelayMillis(int i2) {
        this.j = i2;
    }

    public void setFillCircleColor(@ColorInt int i2) {
        this.A = i2;
        this.K.setColor(i2);
    }

    public void setLengthChangeInterpolator(TimeInterpolator timeInterpolator) {
        this.l.f206e = timeInterpolator;
    }

    public void setMaxValue(@FloatRange(from = 0.0d) float f2) {
        this.f3895d = f2;
    }

    public void setOnAnimationStateChangedListener(d dVar) {
        this.n = dVar;
    }

    public void setOnProgressChangedListener(a aVar) {
        this.s0 = aVar;
    }

    public void setRimColor(@ColorInt int i2) {
        this.B = i2;
        this.L.setColor(i2);
    }

    public void setRimShader(Shader shader) {
        this.L.setShader(shader);
    }

    public void setRimWidth(@IntRange(from = 0) int i2) {
        this.r = i2;
        this.L.setStrokeWidth((float) i2);
    }

    public void setSeekModeEnabled(boolean z2) {
        this.k0 = z2;
    }

    public void setShowBlock(boolean z2) {
        this.m0 = z2;
    }

    public void setShowTextWhileSpinning(boolean z2) {
        this.l0 = z2;
    }

    public void setSpinBarColor(@ColorInt int i2) {
        this.z = i2;
        this.J.setColor(i2);
    }

    public void setSpinSpeed(float f2) {
        this.h = f2;
    }

    public void setSpinnerStrokeCap(Paint.Cap cap) {
        this.H = cap;
        this.J.setStrokeCap(cap);
    }

    public void setSpinningBarLength(@FloatRange(from = 0.0d) float f2) {
        this.f = f2;
        this.f3896e = f2;
    }

    public void setStartAngle(int i2) {
        this.s = (int) j((float) i2);
    }

    public void setText(String str) {
        if (str == null) {
            str = "";
        }
        this.a0 = str;
        invalidate();
    }

    public void setTextColor(@ColorInt int i2) {
        this.C = i2;
        this.M.setColor(i2);
    }

    public void setTextColorAuto(boolean z2) {
        this.E = z2;
    }

    public void setTextMode(e eVar) {
        this.e0 = eVar;
    }

    public void setTextScale(@FloatRange(from = 0.0d) float f2) {
        this.w = f2;
    }

    public void setTextSize(@IntRange(from = 0) int i2) {
        this.M.setTextSize((float) i2);
        this.v = i2;
        this.f0 = false;
    }

    public void setTextTypeface(Typeface typeface) {
        this.M.setTypeface(typeface);
    }

    public void setUnit(String str) {
        if (str == null) {
            str = "";
        }
        this.c0 = str;
        invalidate();
    }

    public void setUnitColor(@ColorInt int i2) {
        this.D = i2;
        this.N.setColor(i2);
        this.E = false;
    }

    public void setUnitPosition(f fVar) {
        this.d0 = fVar;
        m();
    }

    public void setUnitScale(@FloatRange(from = 0.0d) float f2) {
        this.x = f2;
    }

    public void setUnitSize(@IntRange(from = 0) int i2) {
        this.u = i2;
        this.N.setTextSize((float) i2);
    }

    public void setUnitTextTypeface(Typeface typeface) {
        this.N.setTypeface(typeface);
    }

    public void setUnitToTextScale(@FloatRange(from = 0.0d) float f2) {
        this.j0 = f2;
        m();
    }

    public void setUnitVisible(boolean z2) {
        if (z2 != this.g0) {
            this.g0 = z2;
            m();
        }
    }

    public void setValue(float f2) {
        Message message = new Message();
        message.what = 2;
        message.obj = new float[]{f2, f2};
        this.l.sendMessage(message);
        a aVar = this.s0;
        if (aVar != null && f2 != this.t0) {
            aVar.a(f2);
            this.t0 = f2;
        }
    }

    public void setValueAnimated(float f2) {
        k(f2, 1200);
    }

    public void setValueInterpolator(TimeInterpolator timeInterpolator) {
        this.l.f = timeInterpolator;
    }
}
