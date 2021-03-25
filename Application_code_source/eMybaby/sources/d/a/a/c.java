package d.a.a;

import android.content.Context;
import android.content.DialogInterface;
import android.preference.PreferenceManager;
import java.lang.ref.WeakReference;

public final class c implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WeakReference f4818a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f4819b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f4820c;

    public c(WeakReference weakReference, f fVar, boolean z) {
        this.f4818a = weakReference;
        this.f4819b = fVar;
        this.f4820c = z;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        WeakReference weakReference = this.f4818a;
        Context context = weakReference != null ? (Context) weakReference.get() : null;
        if (context != null) {
            PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("always_send_crash_reports", true).commit();
            e.g(this.f4818a, this.f4819b, this.f4820c);
        }
    }
}
