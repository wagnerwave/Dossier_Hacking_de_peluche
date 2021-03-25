package com.cuatroochenta.genericviewflow;

import android.content.Context;
import android.content.res.Configuration;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Scroller;
import java.util.EnumSet;
import java.util.LinkedList;

public class ViewFlow extends AdapterView<Adapter> {

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<View> f3788a;

    /* renamed from: b  reason: collision with root package name */
    public LinkedList<View> f3789b;

    /* renamed from: c  reason: collision with root package name */
    public int f3790c;

    /* renamed from: d  reason: collision with root package name */
    public int f3791d;

    /* renamed from: e  reason: collision with root package name */
    public int f3792e = 2;
    public Scroller f;
    public VelocityTracker g;
    public int h = 0;
    public float i;
    public int j;
    public int k;
    public int l;
    public int m = -1;
    public boolean n = true;
    public e o;
    public d p;
    public EnumSet<c> q = EnumSet.allOf(c.class);
    public Adapter r;
    public int s;
    public b t;
    public a.c.b.a u;
    public int v = -1;
    public ViewTreeObserver.OnGlobalLayoutListener w = new a();

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        public void onGlobalLayout() {
            ViewFlow.this.getViewTreeObserver().removeGlobalOnLayoutListener(ViewFlow.this.w);
            ViewFlow viewFlow = ViewFlow.this;
            viewFlow.setSelection(viewFlow.f3791d);
        }
    }

    public class b extends DataSetObserver {
        public b() {
        }

        public void onChanged() {
            ViewFlow viewFlow = ViewFlow.this;
            View childAt = viewFlow.getChildAt(viewFlow.f3790c);
            if (childAt != null) {
                int i = 0;
                while (true) {
                    if (i >= ViewFlow.this.r.getCount()) {
                        break;
                    } else if (childAt.equals(ViewFlow.this.r.getItem(i))) {
                        ViewFlow.this.f3791d = i;
                        break;
                    } else {
                        i++;
                    }
                }
            }
            ViewFlow viewFlow2 = ViewFlow.this;
            viewFlow2.d();
            viewFlow2.removeAllViewsInLayout();
            viewFlow2.q.addAll(EnumSet.allOf(c.class));
            for (int max = Math.max(0, viewFlow2.f3791d - viewFlow2.f3792e); max < Math.min(viewFlow2.r.getCount(), viewFlow2.f3791d + viewFlow2.f3792e + 1); max++) {
                viewFlow2.f3788a.addLast(viewFlow2.b(max, true));
                if (max == viewFlow2.f3791d) {
                    viewFlow2.f3790c = viewFlow2.f3788a.size() - 1;
                    d dVar = viewFlow2.p;
                    if (dVar != null) {
                        dVar.a(viewFlow2.f3788a.getLast(), viewFlow2.f3791d);
                    }
                }
            }
            viewFlow2.requestLayout();
        }

        public void onInvalidated() {
        }
    }

    public enum c {
        LEFT,
        RIGHT
    }

    public interface d {
        void a(View view, int i);
    }

    public interface e {
    }

    public ViewFlow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3792e = context.obtainStyledAttributes(attributeSet, a.c.b.b.ViewFlow).getInt(a.c.b.b.ViewFlow_sidebuffer, 3);
        this.f3788a = new LinkedList<>();
        this.f3789b = new LinkedList<>();
        this.f = new Scroller(getContext());
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.j = viewConfiguration.getScaledTouchSlop();
        this.k = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public final void a(float f2) {
        c cVar = c.RIGHT;
        c cVar2 = c.LEFT;
        if (f2 > 0.0f) {
            if (this.q.contains(cVar)) {
                this.q.remove(cVar);
                if (this.f3790c + 1 < this.f3788a.size()) {
                    this.p.a(this.f3788a.get(this.f3790c + 1), this.f3791d + 1);
                }
            }
        } else if (this.q.contains(cVar2)) {
            this.q.remove(cVar2);
            int i2 = this.f3790c;
            if (i2 > 0) {
                this.p.a(this.f3788a.get(i2 - 1), this.f3791d - 1);
            }
        }
    }

    public final View b(int i2, boolean z) {
        View recycledView = getRecycledView();
        View view = this.r.getView(i2, recycledView, this);
        if (view != recycledView) {
            this.f3789b.add(recycledView);
        }
        int i3 = 0;
        boolean z2 = view == recycledView;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -2, 0);
        }
        if (z2) {
            if (z) {
                i3 = -1;
            }
            attachViewToParent(view, i3, layoutParams);
        } else {
            if (z) {
                i3 = -1;
            }
            addViewInLayout(view, i3, layoutParams, true);
        }
        return view;
    }

    public void c(View view) {
        if (view != null) {
            this.f3789b.add(view);
            detachViewFromParent(view);
        }
    }

    public void computeScroll() {
        if (this.f.computeScrollOffset()) {
            scrollTo(this.f.getCurrX(), this.f.getCurrY());
            postInvalidate();
            return;
        }
        int i2 = this.m;
        if (i2 != -1) {
            this.l = Math.max(0, Math.min(i2, getChildCount() - 1));
            this.m = -1;
            int i3 = this.s;
            c cVar = c.RIGHT;
            c cVar2 = c.LEFT;
            if (i3 != 0) {
                if (i3 > 0) {
                    this.f3791d++;
                    this.f3790c++;
                    this.q.remove(cVar2);
                    this.q.add(cVar);
                    if (this.f3791d > this.f3792e) {
                        c(this.f3788a.removeFirst());
                        this.f3790c--;
                    }
                    int i4 = this.f3791d + this.f3792e;
                    if (i4 < this.r.getCount()) {
                        this.f3788a.addLast(b(i4, true));
                    }
                } else {
                    this.f3791d--;
                    this.f3790c--;
                    this.q.add(cVar2);
                    this.q.remove(cVar);
                    if ((this.r.getCount() - 1) - this.f3791d > this.f3792e) {
                        c(this.f3788a.removeLast());
                    }
                    int i5 = this.f3791d - this.f3792e;
                    if (i5 > -1) {
                        this.f3788a.addFirst(b(i5, false));
                        if (this.f3790c < this.r.getCount() - 1) {
                            this.f3790c++;
                        }
                    }
                }
                requestLayout();
                e(this.f3790c, true);
                if (this.u != null && this.f3790c < this.f3788a.size()) {
                    a.c.b.a aVar = this.u;
                    View view = this.f3788a.get(this.f3790c);
                    if (((CircleFlowIndicator) aVar) != null) {
                        e eVar = this.o;
                        if (eVar != null) {
                            View view2 = this.f3788a.get(this.f3790c);
                            CircleFlowIndicator circleFlowIndicator = (CircleFlowIndicator) eVar;
                            return;
                        }
                        return;
                    }
                    throw null;
                }
            }
        }
    }

    public void d() {
        while (!this.f3788a.isEmpty()) {
            c(this.f3788a.remove());
        }
    }

    public final void e(int i2, boolean z) {
        int max = Math.max(0, Math.min(i2, getChildCount() - 1));
        this.l = max;
        int width = (getWidth() * max) - this.f.getCurrX();
        Scroller scroller = this.f;
        scroller.startScroll(scroller.getCurrX(), this.f.getCurrY(), width, 0, 0);
        if (width == 0) {
            onScrollChanged(this.f.getCurrX() + width, this.f.getCurrY(), this.f.getCurrX() + width, this.f.getCurrY());
        }
        if (z) {
            invalidate();
        } else {
            postInvalidate();
        }
    }

    public final void f() {
        int width = getWidth();
        g(((width / 2) + getScrollX()) / width);
    }

    public final void g(int i2) {
        this.s = i2 - this.l;
        if (this.f.isFinished()) {
            int max = Math.max(0, Math.min(i2, getChildCount() - 1));
            this.m = max;
            int width = (getWidth() * max) - getScrollX();
            this.f.startScroll(getScrollX(), 0, width, 0, Math.abs(width) * 2);
            invalidate();
        }
    }

    public Adapter getAdapter() {
        return this.r;
    }

    public View getRecycledView() {
        if (this.f3789b.isEmpty()) {
            return null;
        }
        return this.f3789b.remove(0);
    }

    public int getSelectedItemPosition() {
        return this.f3791d;
    }

    public View getSelectedView() {
        if (this.f3790c < this.f3788a.size()) {
            return this.f3788a.get(this.f3790c);
        }
        return null;
    }

    public int getViewsCount() {
        Adapter adapter = this.r;
        if (adapter == null) {
            return 0;
        }
        return adapter.getCount();
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i2 = configuration.orientation;
        if (i2 != this.v) {
            this.v = i2;
            getViewTreeObserver().addOnGlobalLayoutListener(this.w);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        if (r0 != 3) goto L_0x00d8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r5.getChildCount()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            android.view.VelocityTracker r0 = r5.g
            if (r0 != 0) goto L_0x0012
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r5.g = r0
        L_0x0012:
            android.view.VelocityTracker r0 = r5.g
            r0.addMovement(r6)
            int r0 = r6.getAction()
            float r6 = r6.getX()
            r2 = 1
            if (r0 == 0) goto L_0x00c0
            if (r0 == r2) goto L_0x007f
            r3 = 2
            if (r0 == r3) goto L_0x0030
            r6 = 3
            if (r0 == r6) goto L_0x002c
            goto L_0x00d8
        L_0x002c:
            r5.h = r1
            goto L_0x00d8
        L_0x0030:
            float r0 = r5.i
            float r0 = r0 - r6
            int r0 = (int) r0
            int r3 = java.lang.Math.abs(r0)
            int r4 = r5.j
            if (r3 <= r4) goto L_0x003e
            r3 = 1
            goto L_0x003f
        L_0x003e:
            r3 = 0
        L_0x003f:
            if (r3 == 0) goto L_0x004b
            r5.h = r2
            com.cuatroochenta.genericviewflow.ViewFlow$d r3 = r5.p
            if (r3 == 0) goto L_0x004b
            float r3 = (float) r0
            r5.a(r3)
        L_0x004b:
            int r3 = r5.h
            if (r3 != r2) goto L_0x00d8
            r5.i = r6
            int r6 = r5.getScrollX()
            if (r0 >= 0) goto L_0x0062
            if (r6 <= 0) goto L_0x007e
            int r6 = -r6
            int r6 = java.lang.Math.max(r6, r0)
        L_0x005e:
            r5.scrollBy(r6, r1)
            goto L_0x007e
        L_0x0062:
            if (r0 <= 0) goto L_0x007e
            int r3 = r5.getChildCount()
            int r3 = r3 - r2
            android.view.View r3 = r5.getChildAt(r3)
            int r3 = r3.getRight()
            int r3 = r3 - r6
            int r6 = r5.getWidth()
            int r3 = r3 - r6
            if (r3 <= 0) goto L_0x007e
            int r6 = java.lang.Math.min(r3, r0)
            goto L_0x005e
        L_0x007e:
            return r2
        L_0x007f:
            int r6 = r5.h
            if (r6 != r2) goto L_0x002c
            android.view.VelocityTracker r6 = r5.g
            int r0 = r5.k
            float r0 = (float) r0
            r3 = 1000(0x3e8, float:1.401E-42)
            r6.computeCurrentVelocity(r3, r0)
            float r6 = r6.getXVelocity()
            int r6 = (int) r6
            if (r6 <= r3) goto L_0x009d
            int r0 = r5.l
            if (r0 <= 0) goto L_0x009d
            int r0 = r0 - r2
            r5.g(r0)
            goto L_0x00b4
        L_0x009d:
            r0 = -1000(0xfffffffffffffc18, float:NaN)
            if (r6 >= r0) goto L_0x00b1
            int r6 = r5.l
            int r0 = r5.getChildCount()
            int r0 = r0 - r2
            if (r6 >= r0) goto L_0x00b1
            int r6 = r5.l
            int r6 = r6 + r2
            r5.g(r6)
            goto L_0x00b4
        L_0x00b1:
            r5.f()
        L_0x00b4:
            android.view.VelocityTracker r6 = r5.g
            if (r6 == 0) goto L_0x002c
            r6.recycle()
            r6 = 0
            r5.g = r6
            goto L_0x002c
        L_0x00c0:
            android.widget.Scroller r0 = r5.f
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x00cd
            android.widget.Scroller r0 = r5.f
            r0.abortAnimation()
        L_0x00cd:
            r5.i = r6
            android.widget.Scroller r6 = r5.f
            boolean r6 = r6.isFinished()
            r6 = r6 ^ r2
            r5.h = r6
        L_0x00d8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cuatroochenta.genericviewflow.ViewFlow.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth() + i6;
                childAt.layout(i6, 0, measuredWidth, childAt.getMeasuredHeight());
                i6 = measuredWidth;
            }
        }
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        if (View.MeasureSpec.getMode(i2) == 1073741824 || isInEditMode()) {
            if (View.MeasureSpec.getMode(i3) != 1073741824) {
                isInEditMode();
            }
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                getChildAt(i4).measure(i2, i3);
            }
            if (this.n) {
                this.f.startScroll(0, 0, this.l * size, 0, 0);
                this.n = false;
                return;
            }
            return;
        }
        throw new IllegalStateException("ViewFlow can only be used in EXACTLY mode.");
    }

    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        if (this.u != null) {
            int width = (getWidth() * (this.f3791d - this.f3790c)) + i2;
            CircleFlowIndicator circleFlowIndicator = (CircleFlowIndicator) this.u;
            circleFlowIndicator.setVisibility(0);
            circleFlowIndicator.a();
            circleFlowIndicator.g = width;
            circleFlowIndicator.h = circleFlowIndicator.f.getWidth();
            circleFlowIndicator.invalidate();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i2;
        int right;
        int min;
        if (getChildCount() == 0) {
            return false;
        }
        if (this.g == null) {
            this.g = VelocityTracker.obtain();
        }
        this.g.addMovement(motionEvent);
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int i3 = (int) (this.i - x);
                    if (Math.abs(i3) > this.j) {
                        this.h = 1;
                        if (this.p != null) {
                            a((float) i3);
                        }
                    }
                    if (this.h == 1) {
                        this.i = x;
                        int scrollX = getScrollX();
                        if (i3 < 0) {
                            if (scrollX > 0) {
                                min = Math.max(-scrollX, i3);
                            }
                            return true;
                        }
                        if (i3 > 0 && (right = (getChildAt(getChildCount() - 1).getRight() - scrollX) - getWidth()) > 0) {
                            min = Math.min(right, i3);
                        }
                        return true;
                        scrollBy(min, 0);
                        return true;
                    }
                } else if (action == 3) {
                    f();
                }
            } else if (this.h == 1) {
                VelocityTracker velocityTracker = this.g;
                velocityTracker.computeCurrentVelocity(1000, (float) this.k);
                int xVelocity = (int) velocityTracker.getXVelocity();
                if (xVelocity > 1000 && (i2 = this.l) > 0) {
                    g(i2 - 1);
                } else if (xVelocity >= -1000 || this.l >= getChildCount() - 1) {
                    f();
                } else {
                    g(this.l + 1);
                }
                VelocityTracker velocityTracker2 = this.g;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.g = null;
                }
            }
            this.h = 0;
        } else {
            if (!this.f.isFinished()) {
                this.f.abortAnimation();
            }
            this.i = x;
            this.h = this.f.isFinished() ^ true ? 1 : 0;
        }
        return true;
    }

    public void setAdapter(Adapter adapter) {
        Adapter adapter2 = this.r;
        if (adapter2 != null) {
            adapter2.unregisterDataSetObserver(this.t);
        }
        this.r = adapter;
        if (adapter != null) {
            b bVar = new b();
            this.t = bVar;
            this.r.registerDataSetObserver(bVar);
        }
        Adapter adapter3 = this.r;
        if (adapter3 != null && adapter3.getCount() != 0) {
            setSelection(0);
        }
    }

    public void setFlowIndicator(a.c.b.a aVar) {
        this.u = aVar;
        if (aVar != null) {
            aVar.setViewFlow(this);
        }
    }

    public void setOnViewLazyInitializeListener(d dVar) {
        this.p = dVar;
    }

    public void setOnViewSwitchListener(e eVar) {
        this.o = eVar;
    }

    public void setSelection(int i2) {
        this.m = -1;
        this.f.forceFinished(true);
        if (this.r != null) {
            int min = Math.min(Math.max(i2, 0), this.r.getCount() - 1);
            d();
            View b2 = b(min, true);
            this.f3788a.addLast(b2);
            d dVar = this.p;
            if (dVar != null) {
                dVar.a(b2, min);
            }
            for (int i3 = 1; this.f3792e - i3 >= 0; i3++) {
                int i4 = min - i3;
                int i5 = min + i3;
                if (i4 >= 0) {
                    this.f3788a.addFirst(b(i4, false));
                }
                if (i5 < this.r.getCount()) {
                    this.f3788a.addLast(b(i5, true));
                }
            }
            this.f3790c = this.f3788a.indexOf(b2);
            this.f3791d = min;
            requestLayout();
            e(this.f3790c, false);
            a.c.b.a aVar = this.u;
            if (aVar == null || ((CircleFlowIndicator) aVar) != null) {
                e eVar = this.o;
                if (eVar != null && ((CircleFlowIndicator) eVar) == null) {
                    throw null;
                }
                return;
            }
            throw null;
        }
    }
}
