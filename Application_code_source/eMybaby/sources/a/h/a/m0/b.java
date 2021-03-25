package a.h.a.m0;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.sozpic.miniland.galeria.TouchImageView;

public class b implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TouchImageView f3521a;

    public b(TouchImageView touchImageView) {
        this.f3521a = touchImageView;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f3521a.n.onTouchEvent(motionEvent);
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f3521a.f4579c.set(pointF);
            TouchImageView touchImageView = this.f3521a;
            touchImageView.f4580d.set(touchImageView.f4579c);
            this.f3521a.f4578b = 1;
        } else if (action == 1) {
            TouchImageView touchImageView2 = this.f3521a;
            touchImageView2.f4578b = 0;
            int abs = (int) Math.abs(pointF.x - touchImageView2.f4580d.x);
            int abs2 = (int) Math.abs(pointF.y - this.f3521a.f4580d.y);
            if (abs < 3 && abs2 < 3) {
                this.f3521a.performClick();
            }
        } else if (action == 2) {
            TouchImageView touchImageView3 = this.f3521a;
            if (touchImageView3.f4578b == 1) {
                float f = pointF.x;
                PointF pointF2 = touchImageView3.f4579c;
                float f2 = f - pointF2.x;
                float f3 = pointF.y - pointF2.y;
                if (touchImageView3.k * touchImageView3.j <= ((float) touchImageView3.h)) {
                    f2 = 0.0f;
                }
                TouchImageView touchImageView4 = this.f3521a;
                if (touchImageView4.l * touchImageView4.j <= ((float) touchImageView4.i)) {
                    f3 = 0.0f;
                }
                this.f3521a.f4577a.postTranslate(f2, f3);
                this.f3521a.a();
                this.f3521a.f4579c.set(pointF.x, pointF.y);
            }
        } else if (action == 6) {
            this.f3521a.f4578b = 0;
        }
        TouchImageView touchImageView5 = this.f3521a;
        touchImageView5.setImageMatrix(touchImageView5.f4577a);
        this.f3521a.invalidate();
        return true;
    }
}
