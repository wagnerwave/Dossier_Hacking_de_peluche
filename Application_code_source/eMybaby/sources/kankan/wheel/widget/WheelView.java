package kankan.wheel.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;
import c.a.b.d;
import c.a.b.e;
import c.a.b.f;
import c.a.b.g.c;
import java.util.LinkedList;
import java.util.List;

public class WheelView extends View {
    public static final int[] w = {-15658735, 11184810, 11184810};

    /* renamed from: a  reason: collision with root package name */
    public int[] f5197a = null;

    /* renamed from: b  reason: collision with root package name */
    public int f5198b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f5199c = 5;

    /* renamed from: d  reason: collision with root package name */
    public int f5200d = 0;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f5201e;
    public GradientDrawable f;
    public GradientDrawable g;
    public f h;
    public boolean i;
    public int j;
    public boolean k = false;
    public LinearLayout l;
    public int m;
    public c n;
    public e o = new e(this);
    public List<c.a.b.b> p = new LinkedList();
    public List<d> q = new LinkedList();
    public List<c.a.b.c> r = new LinkedList();
    public boolean s = true;
    public int t = -1;
    public f.c u = new a();
    public DataSetObserver v = new b();

    public class a implements f.c {
        public a() {
        }

        public void a(int i) {
            WheelView.a(WheelView.this, i);
            int height = WheelView.this.getHeight();
            WheelView wheelView = WheelView.this;
            int i2 = wheelView.j;
            if (i2 > height || i2 < (height = -height)) {
                wheelView.j = height;
                wheelView.h.f3766d.forceFinished(true);
            }
        }
    }

    public class b extends DataSetObserver {
        public b() {
        }

        public void onChanged() {
            WheelView.this.e(false);
        }

        public void onInvalidated() {
            WheelView.this.e(true);
        }
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }

    public static void a(WheelView wheelView, int i2) {
        wheelView.j += i2;
        int itemHeight = wheelView.getItemHeight();
        int i3 = wheelView.j / itemHeight;
        int i4 = wheelView.f5198b - i3;
        int d2 = ((c.a.b.g.b) wheelView.n).d();
        int i5 = wheelView.j % itemHeight;
        if (Math.abs(i5) <= itemHeight / 2) {
            i5 = 0;
        }
        if (wheelView.k && d2 > 0) {
            if (i5 > 0) {
                i4--;
                i3++;
            } else if (i5 < 0) {
                i4++;
                i3--;
            }
            while (i4 < 0) {
                i4 += d2;
            }
            i4 %= d2;
        } else if (i4 < 0) {
            i3 = wheelView.f5198b;
            i4 = 0;
        } else if (i4 >= d2) {
            i3 = (wheelView.f5198b - d2) + 1;
            i4 = d2 - 1;
        } else if (i4 > 0 && i5 > 0) {
            i4--;
            i3++;
        } else if (i4 < d2 - 1 && i5 < 0) {
            i4++;
            i3--;
        }
        int i6 = wheelView.j;
        if (i4 != wheelView.f5198b) {
            wheelView.g(i4, false);
        } else {
            wheelView.invalidate();
        }
        int i7 = i6 - (i3 * itemHeight);
        wheelView.j = i7;
        if (i7 > wheelView.getHeight()) {
            wheelView.j = wheelView.getHeight() + (wheelView.j % wheelView.getHeight());
        }
    }

    private int getItemHeight() {
        int i2 = this.f5200d;
        if (i2 != 0) {
            return i2;
        }
        LinearLayout linearLayout = this.l;
        if (linearLayout == null || linearLayout.getChildAt(0) == null) {
            return getHeight() / this.f5199c;
        }
        int height = this.l.getChildAt(0).getHeight();
        this.f5200d = height;
        return height;
    }

    private c.a.b.a getItemsRange() {
        if (getItemHeight() == 0) {
            return null;
        }
        int i2 = this.f5198b;
        int i3 = 1;
        while (getItemHeight() * i3 < getHeight()) {
            i2--;
            i3 += 2;
        }
        int i4 = this.j;
        if (i4 != 0) {
            if (i4 > 0) {
                i2--;
            }
            int itemHeight = this.j / getItemHeight();
            i2 -= itemHeight;
            double d2 = (double) (i3 + 1);
            double asin = Math.asin((double) itemHeight);
            Double.isNaN(d2);
            Double.isNaN(d2);
            i3 = (int) (asin + d2);
        }
        return new c.a.b.a(i2, i3);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008b A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(int r9, boolean r10) {
        /*
            r8 = this;
            c.a.b.g.c r0 = r8.n
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x00c2
            c.a.b.g.b r0 = (c.a.b.g.b) r0
            int r0 = r0.d()
            if (r0 != 0) goto L_0x0011
            goto L_0x00c2
        L_0x0011:
            c.a.b.g.c r0 = r8.n
            c.a.b.g.b r0 = (c.a.b.g.b) r0
            int r0 = r0.d()
            boolean r4 = r8.f(r9)
            if (r4 != 0) goto L_0x003c
            c.a.b.g.c r9 = r8.n
            c.a.b.e r0 = r8.o
            java.util.List<android.view.View> r4 = r0.f3761b
            android.view.View r0 = r0.a(r4)
            android.widget.LinearLayout r4 = r8.l
            c.a.b.g.a r9 = (c.a.b.g.a) r9
            if (r9 == 0) goto L_0x003b
            if (r0 != 0) goto L_0x0038
            android.view.View r9 = r9.c(r3, r4)
            r1 = r9
            goto L_0x00c2
        L_0x0038:
            r1 = r0
            goto L_0x00c2
        L_0x003b:
            throw r1
        L_0x003c:
            if (r9 >= 0) goto L_0x0040
            int r9 = r9 + r0
            goto L_0x003c
        L_0x0040:
            int r9 = r9 % r0
            c.a.b.g.c r0 = r8.n
            c.a.b.e r4 = r8.o
            java.util.List<android.view.View> r5 = r4.f3760a
            android.view.View r4 = r4.a(r5)
            android.widget.LinearLayout r5 = r8.l
            c.a.b.g.a r0 = (c.a.b.g.a) r0
            if (r0 == 0) goto L_0x00c1
            if (r9 < 0) goto L_0x00c2
            r6 = r0
            c.a.b.g.b r6 = (c.a.b.g.b) r6
            int r7 = r6.d()
            if (r9 >= r7) goto L_0x00c2
            if (r4 != 0) goto L_0x0064
            int r4 = r0.i
            android.view.View r4 = r0.c(r4, r5)
        L_0x0064:
            int r5 = r0.j
            if (r5 != 0) goto L_0x0070
            boolean r7 = r4 instanceof android.widget.TextView     // Catch:{ ClassCastException -> 0x006e }
            if (r7 == 0) goto L_0x0070
            r5 = r4
            goto L_0x0076
        L_0x006e:
            r9 = move-exception
            goto L_0x0079
        L_0x0070:
            if (r5 == 0) goto L_0x0088
            android.view.View r5 = r4.findViewById(r5)     // Catch:{ ClassCastException -> 0x006e }
        L_0x0076:
            android.widget.TextView r5 = (android.widget.TextView) r5     // Catch:{ ClassCastException -> 0x006e }
            goto L_0x0089
        L_0x0079:
            java.lang.String r10 = "AbstractWheelAdapter"
            java.lang.String r0 = "You must supply a resource ID for a TextView"
            android.util.Log.e(r10, r0)
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "AbstractWheelAdapter requires the resource ID to be a TextView"
            r10.<init>(r0, r9)
            throw r10
        L_0x0088:
            r5 = r1
        L_0x0089:
            if (r5 == 0) goto L_0x00bf
            if (r9 < 0) goto L_0x00ac
            int r7 = r6.d()
            if (r9 >= r7) goto L_0x00ac
            int r1 = r6.m
            int r1 = r1 + r9
            java.lang.String r9 = r6.o
            if (r9 == 0) goto L_0x00a7
            java.lang.Object[] r6 = new java.lang.Object[r2]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r6[r3] = r1
            java.lang.String r9 = java.lang.String.format(r9, r6)
            goto L_0x00ab
        L_0x00a7:
            java.lang.String r9 = java.lang.Integer.toString(r1)
        L_0x00ab:
            r1 = r9
        L_0x00ac:
            if (r1 != 0) goto L_0x00b0
            java.lang.String r1 = ""
        L_0x00b0:
            r5.setText(r1)
            int r9 = r0.i
            r6 = -1
            if (r9 != r6) goto L_0x00bf
            java.lang.String r9 = r1.toString()
            r0.b(r5, r9)
        L_0x00bf:
            r1 = r4
            goto L_0x00c2
        L_0x00c1:
            throw r1
        L_0x00c2:
            if (r1 == 0) goto L_0x00d0
            android.widget.LinearLayout r9 = r8.l
            if (r10 == 0) goto L_0x00cc
            r9.addView(r1, r3)
            goto L_0x00cf
        L_0x00cc:
            r9.addView(r1)
        L_0x00cf:
            return r2
        L_0x00d0:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kankan.wheel.widget.WheelView.b(int, boolean):boolean");
    }

    public final int c(int i2, int i3) {
        if (this.f5201e == null) {
            this.f5201e = getContext().getResources().getDrawable(c.a.a.wheel_val);
        }
        if (this.f == null) {
            int[] iArr = this.f5197a;
            this.f = (iArr == null || iArr.length <= 0) ? new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, w) : new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.f5197a);
        }
        if (this.g == null) {
            int[] iArr2 = this.f5197a;
            this.g = (iArr2 == null || iArr2.length <= 0) ? new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, w) : new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, this.f5197a);
        }
        int i4 = this.t;
        if (i4 == -1) {
            i4 = c.a.a.wheel_bg;
        }
        setBackgroundResource(i4);
        this.l.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.l.measure(View.MeasureSpec.makeMeasureSpec(i2, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = this.l.getMeasuredWidth();
        if (i3 != 1073741824) {
            int max = Math.max(measuredWidth + 20, getSuggestedMinimumWidth());
            if (i3 != Integer.MIN_VALUE || i2 >= max) {
                i2 = max;
            }
        }
        this.l.measure(View.MeasureSpec.makeMeasureSpec(i2 - 20, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        return i2;
    }

    public final void d() {
        this.h = new f(getContext(), this.u);
    }

    public void e(boolean z) {
        if (z) {
            e eVar = this.o;
            List<View> list = eVar.f3760a;
            if (list != null) {
                list.clear();
            }
            List<View> list2 = eVar.f3761b;
            if (list2 != null) {
                list2.clear();
            }
            LinearLayout linearLayout = this.l;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            this.j = 0;
        } else {
            LinearLayout linearLayout2 = this.l;
            if (linearLayout2 != null) {
                this.o.b(linearLayout2, this.m, new c.a.b.a());
            }
        }
        invalidate();
    }

    public final boolean f(int i2) {
        c cVar = this.n;
        return cVar != null && ((c.a.b.g.b) cVar).d() > 0 && (this.k || (i2 >= 0 && i2 < ((c.a.b.g.b) this.n).d()));
    }

    public void g(int i2, boolean z) {
        int min;
        c cVar = this.n;
        if (cVar != null && ((c.a.b.g.b) cVar).d() != 0) {
            int d2 = ((c.a.b.g.b) this.n).d();
            if (i2 < 0 || i2 >= d2) {
                if (this.k) {
                    while (i2 < 0) {
                        i2 += d2;
                    }
                    i2 %= d2;
                } else {
                    return;
                }
            }
            int i3 = this.f5198b;
            if (i2 == i3) {
                return;
            }
            if (z) {
                int i4 = i2 - i3;
                if (this.k && (min = (Math.min(i2, i3) + d2) - Math.max(i2, this.f5198b)) < Math.abs(i4)) {
                    i4 = i4 < 0 ? min : -min;
                }
                this.h.b((i4 * getItemHeight()) - this.j, 0);
                return;
            }
            this.j = 0;
            this.f5198b = i2;
            for (c.a.b.b a2 : this.p) {
                a2.a(this, i3, i2);
            }
            invalidate();
        }
    }

    public int getCurrentItem() {
        return this.f5198b;
    }

    public c getViewAdapter() {
        return this.n;
    }

    public int getVisibleItems() {
        return this.f5199c;
    }

    public void onDraw(Canvas canvas) {
        boolean z;
        super.onDraw(canvas);
        c cVar = this.n;
        if (cVar != null && ((c.a.b.g.b) cVar).d() > 0) {
            c.a.b.a itemsRange = getItemsRange();
            LinearLayout linearLayout = this.l;
            if (linearLayout != null) {
                int b2 = this.o.b(linearLayout, this.m, itemsRange);
                z = this.m != b2;
                this.m = b2;
            } else {
                if (linearLayout == null) {
                    LinearLayout linearLayout2 = new LinearLayout(getContext());
                    this.l = linearLayout2;
                    linearLayout2.setOrientation(1);
                }
                z = true;
            }
            if (!z) {
                z = (this.m == itemsRange.f3758a && this.l.getChildCount() == itemsRange.f3759b) ? false : true;
            }
            int i2 = this.m;
            int i3 = itemsRange.f3758a;
            if (i2 <= i3 || i2 > (i3 + itemsRange.f3759b) - 1) {
                this.m = itemsRange.f3758a;
            } else {
                int i4 = i2 - 1;
                while (i4 >= itemsRange.f3758a && b(i4, true)) {
                    this.m = i4;
                    i4--;
                }
            }
            int i5 = this.m;
            for (int childCount = this.l.getChildCount(); childCount < itemsRange.f3759b; childCount++) {
                if (!b(this.m + childCount, false) && this.l.getChildCount() == 0) {
                    i5++;
                }
            }
            this.m = i5;
            if (z) {
                c(getWidth(), 1073741824);
                this.l.layout(0, 0, getWidth() - 20, getHeight());
            }
            canvas.save();
            canvas.translate(10.0f, (float) ((-(((getItemHeight() - getHeight()) / 2) + ((this.f5198b - this.m) * getItemHeight()))) + this.j));
            this.l.draw(canvas);
            canvas.restore();
            int height = getHeight() / 2;
            double itemHeight = (double) (getItemHeight() / 2);
            Double.isNaN(itemHeight);
            Double.isNaN(itemHeight);
            int i6 = (int) (itemHeight * 1.2d);
            this.f5201e.setBounds(0, height - i6, getWidth(), height + i6);
            this.f5201e.draw(canvas);
        }
        if (this.s) {
            double itemHeight2 = (double) getItemHeight();
            Double.isNaN(itemHeight2);
            Double.isNaN(itemHeight2);
            int i7 = (int) (itemHeight2 * 1.5d);
            this.f.setBounds(0, 0, getWidth(), i7);
            this.f.draw(canvas);
            this.g.setBounds(0, getHeight() - i7, getWidth(), getHeight());
            this.g.draw(canvas);
        }
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        LinearLayout linearLayout = this.l;
        linearLayout.layout(0, 0, (i4 - i2) - 20, i5 - i3);
    }

    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        LinearLayout linearLayout = this.l;
        if (linearLayout != null) {
            this.o.b(linearLayout, this.m, new c.a.b.a());
        } else if (linearLayout == null) {
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            this.l = linearLayout2;
            linearLayout2.setOrientation(1);
        }
        int i4 = this.f5199c / 2;
        for (int i5 = this.f5198b + i4; i5 >= this.f5198b - i4; i5--) {
            if (b(i5, true)) {
                this.m = i5;
            }
        }
        int c2 = c(size, mode);
        if (mode2 != 1073741824) {
            LinearLayout linearLayout3 = this.l;
            if (!(linearLayout3 == null || linearLayout3.getChildAt(0) == null)) {
                this.f5200d = linearLayout3.getChildAt(0).getMeasuredHeight();
            }
            int i6 = this.f5200d;
            int max = Math.max((this.f5199c * i6) - ((i6 * 10) / 50), getSuggestedMinimumHeight());
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(max, size2) : max;
        }
        setMeasuredDimension(c2, size2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int y;
        if (!isEnabled() || getViewAdapter() == null) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2 && getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        } else if (!this.i) {
            int y2 = ((int) motionEvent.getY()) - (getHeight() / 2);
            int itemHeight = getItemHeight() / 2;
            int itemHeight2 = (y2 > 0 ? itemHeight + y2 : y2 - itemHeight) / getItemHeight();
            if (itemHeight2 != 0 && f(this.f5198b + itemHeight2)) {
                int i2 = this.f5198b + itemHeight2;
                for (c.a.b.c a2 : this.r) {
                    a2.a(this, i2);
                }
            }
        }
        f fVar = this.h;
        if (fVar != null) {
            int action2 = motionEvent.getAction();
            if (action2 == 0) {
                fVar.f = motionEvent.getY();
                fVar.f3766d.forceFinished(true);
                fVar.i.removeMessages(0);
                fVar.i.removeMessages(1);
            } else if (action2 == 2 && (y = (int) (motionEvent.getY() - fVar.f)) != 0) {
                fVar.d();
                ((a) fVar.f3763a).a(y);
                fVar.f = motionEvent.getY();
            }
            if (!fVar.f3765c.onTouchEvent(motionEvent) && motionEvent.getAction() == 1) {
                fVar.a();
            }
            return true;
        }
        throw null;
    }

    public void setCurrentItem(int i2) {
        g(i2, false);
    }

    public void setCustomBackgroundResource(int i2) {
        this.t = i2;
    }

    public void setCustomShadowColors(int[] iArr) {
        this.f5197a = new int[3];
        this.f5197a = iArr;
    }

    public void setCyclic(boolean z) {
        this.k = z;
        e(false);
    }

    public void setDrawShadows(boolean z) {
        this.s = z;
    }

    public void setInterpolator(Interpolator interpolator) {
        f fVar = this.h;
        fVar.f3766d.forceFinished(true);
        fVar.f3766d = new Scroller(fVar.f3764b, interpolator);
    }

    public void setViewAdapter(c cVar) {
        c cVar2 = this.n;
        if (cVar2 != null) {
            DataSetObserver dataSetObserver = this.v;
            List<DataSetObserver> list = ((c.a.b.g.a) cVar2).f3770a;
            if (list != null) {
                list.remove(dataSetObserver);
            }
        }
        this.n = cVar;
        if (cVar != null) {
            DataSetObserver dataSetObserver2 = this.v;
            c.a.b.g.a aVar = (c.a.b.g.a) cVar;
            if (aVar.f3770a == null) {
                aVar.f3770a = new LinkedList();
            }
            aVar.f3770a.add(dataSetObserver2);
        }
        e(true);
    }

    public void setVisibleItems(int i2) {
        this.f5199c = i2;
    }
}
