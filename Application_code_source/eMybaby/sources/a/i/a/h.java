package a.i.a;

import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

public class h implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a  reason: collision with root package name */
    public final x f3608a;

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<ImageView> f3609b;

    /* renamed from: c  reason: collision with root package name */
    public e f3610c;

    public h(x xVar, ImageView imageView, e eVar) {
        this.f3608a = xVar;
        this.f3609b = new WeakReference<>(imageView);
        this.f3610c = eVar;
        imageView.getViewTreeObserver().addOnPreDrawListener(this);
    }

    public boolean onPreDraw() {
        ImageView imageView = (ImageView) this.f3609b.get();
        if (imageView == null) {
            return true;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        int width = imageView.getWidth();
        int height = imageView.getHeight();
        if (width > 0 && height > 0) {
            viewTreeObserver.removeOnPreDrawListener(this);
            x xVar = this.f3608a;
            xVar.f3689c = false;
            xVar.f3688b.a(width, height);
            xVar.b(imageView, this.f3610c);
        }
        return true;
    }
}
