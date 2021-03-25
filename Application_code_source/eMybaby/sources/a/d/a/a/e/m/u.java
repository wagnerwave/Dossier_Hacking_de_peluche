package a.d.a.a.e.m;

import android.app.Activity;
import android.content.Intent;

public final class u extends e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Intent f1413a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f1414b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f1415c;

    public u(Intent intent, Activity activity, int i) {
        this.f1413a = intent;
        this.f1414b = activity;
        this.f1415c = i;
    }

    public final void a() {
        Intent intent = this.f1413a;
        if (intent != null) {
            this.f1414b.startActivityForResult(intent, this.f1415c);
        }
    }
}
