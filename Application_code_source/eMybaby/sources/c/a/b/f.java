package c.a.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Scroller;
import kankan.wheel.widget.WheelView;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public c f3763a;

    /* renamed from: b  reason: collision with root package name */
    public Context f3764b;

    /* renamed from: c  reason: collision with root package name */
    public GestureDetector f3765c;

    /* renamed from: d  reason: collision with root package name */
    public Scroller f3766d;

    /* renamed from: e  reason: collision with root package name */
    public int f3767e;
    public float f;
    public boolean g;
    public GestureDetector.SimpleOnGestureListener h = new a();
    public Handler i = new b();

    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            f fVar = f.this;
            fVar.f3767e = 0;
            fVar.f3766d.fling(0, 0, 0, (int) (-f2), 0, 0, -2147483647, Integer.MAX_VALUE);
            f.this.c(0);
            return true;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return true;
        }
    }

    public class b extends Handler {
        public b() {
        }

        public void handleMessage(Message message) {
            f.this.f3766d.computeScrollOffset();
            int currY = f.this.f3766d.getCurrY();
            f fVar = f.this;
            int i = fVar.f3767e - currY;
            fVar.f3767e = currY;
            if (i != 0) {
                ((WheelView.a) fVar.f3763a).a(i);
            }
            if (Math.abs(currY - f.this.f3766d.getFinalY()) < 1) {
                f.this.f3766d.getFinalY();
                f.this.f3766d.forceFinished(true);
            }
            if (!f.this.f3766d.isFinished()) {
                f.this.i.sendEmptyMessage(message.what);
            } else if (message.what == 0) {
                f.this.a();
            } else {
                f fVar2 = f.this;
                if (fVar2.g) {
                    WheelView.a aVar = (WheelView.a) fVar2.f3763a;
                    WheelView wheelView = WheelView.this;
                    if (wheelView.i) {
                        for (d b2 : wheelView.q) {
                            b2.b(wheelView);
                        }
                        WheelView.this.i = false;
                    }
                    WheelView wheelView2 = WheelView.this;
                    wheelView2.j = 0;
                    wheelView2.invalidate();
                    fVar2.g = false;
                }
            }
        }
    }

    public interface c {
    }

    public f(Context context, c cVar) {
        GestureDetector gestureDetector = new GestureDetector(context, this.h);
        this.f3765c = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.f3766d = new Scroller(context);
        this.f3763a = cVar;
        this.f3764b = context;
    }

    public final void a() {
        WheelView.a aVar = (WheelView.a) this.f3763a;
        if (Math.abs(WheelView.this.j) > 1) {
            WheelView wheelView = WheelView.this;
            wheelView.h.b(wheelView.j, 0);
        }
        c(1);
    }

    public void b(int i2, int i3) {
        this.f3766d.forceFinished(true);
        this.f3767e = 0;
        this.f3766d.startScroll(0, 0, 0, i2, i3 != 0 ? i3 : 400);
        c(0);
        d();
    }

    public final void c(int i2) {
        this.i.removeMessages(0);
        this.i.removeMessages(1);
        this.i.sendEmptyMessage(i2);
    }

    public final void d() {
        if (!this.g) {
            this.g = true;
            WheelView wheelView = WheelView.this;
            wheelView.i = true;
            for (d a2 : wheelView.q) {
                a2.a(wheelView);
            }
        }
    }
}
