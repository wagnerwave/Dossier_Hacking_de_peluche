package d.a.a;

import a.a.a.a.a;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import java.lang.ref.WeakReference;

public final class b implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f4815a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WeakReference f4816b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f4817c;

    public b(f fVar, WeakReference weakReference, boolean z) {
        this.f4815a = fVar;
        this.f4816b = weakReference;
        this.f4817c = z;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        f fVar = this.f4815a;
        if (fVar == null || fVar != null) {
            WeakReference weakReference = this.f4816b;
            String[] f = e.f();
            if (f != null && f.length > 0) {
                StringBuilder n = a.n("Found ");
                n.append(f.length);
                n.append(" stacktrace(s).");
                Log.d("HockeyApp", n.toString());
                for (int i2 = 0; i2 < f.length; i2++) {
                    if (weakReference != null) {
                        try {
                            Log.d("HockeyApp", "Delete stacktrace " + f[i2] + ".");
                            e.b(weakReference, f[i2]);
                            Context context = (Context) weakReference.get();
                            if (context != null) {
                                context.deleteFile(f[i2]);
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            e.e(this.f4816b, this.f4815a, this.f4817c);
            return;
        }
        throw null;
    }
}
