package d.a.a;

import android.content.DialogInterface;
import java.lang.ref.WeakReference;

public final class d implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WeakReference f4821a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f4822b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f4823c;

    public d(WeakReference weakReference, f fVar, boolean z) {
        this.f4821a = weakReference;
        this.f4822b = fVar;
        this.f4823c = z;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        e.g(this.f4821a, this.f4822b, this.f4823c);
    }
}
