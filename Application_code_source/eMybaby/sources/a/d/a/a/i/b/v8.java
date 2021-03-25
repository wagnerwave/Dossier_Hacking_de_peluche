package a.d.a.a.i.b;

import android.app.job.JobParameters;

public final /* synthetic */ class v8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final t8 f2573a;

    /* renamed from: b  reason: collision with root package name */
    public final x3 f2574b;

    /* renamed from: c  reason: collision with root package name */
    public final JobParameters f2575c;

    public v8(t8 t8Var, x3 x3Var, JobParameters jobParameters) {
        this.f2573a = t8Var;
        this.f2574b = x3Var;
        this.f2575c = jobParameters;
    }

    public final void run() {
        t8 t8Var = this.f2573a;
        x3 x3Var = this.f2574b;
        JobParameters jobParameters = this.f2575c;
        if (t8Var != null) {
            x3Var.n.a("AppMeasurementJobService processed last upload request.");
            ((x8) t8Var.f2534a).a(jobParameters, false);
            return;
        }
        throw null;
    }
}
