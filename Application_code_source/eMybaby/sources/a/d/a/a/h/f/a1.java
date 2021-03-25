package a.d.a.a.h.f;

import android.app.job.JobParameters;

public final /* synthetic */ class a1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final y0 f1470a;

    /* renamed from: b  reason: collision with root package name */
    public final r0 f1471b;

    /* renamed from: c  reason: collision with root package name */
    public final JobParameters f1472c;

    public a1(y0 y0Var, r0 r0Var, JobParameters jobParameters) {
        this.f1470a = y0Var;
        this.f1471b = r0Var;
        this.f1472c = jobParameters;
    }

    public final void run() {
        y0 y0Var = this.f1470a;
        r0 r0Var = this.f1471b;
        JobParameters jobParameters = this.f1472c;
        if (y0Var != null) {
            r0Var.o("AnalyticsJobService processed last dispatch request");
            ((c1) y0Var.f1583b).a(jobParameters, false);
            return;
        }
        throw null;
    }
}
