package a.d.a.a.h.f;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import androidx.annotation.Nullable;
import java.lang.reflect.Method;

@TargetApi(24)
public final class g1 {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public static final Method f1500a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public static final Method f1501b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile i1 f1502c = h1.f1508a;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    static {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            int r1 = android.os.Build.VERSION.SDK_INT
            java.lang.String r2 = "JobSchedulerCompat"
            r3 = 6
            r4 = 0
            r5 = 24
            if (r1 < r5) goto L_0x0034
            java.lang.Class<android.app.job.JobScheduler> r1 = android.app.job.JobScheduler.class
            java.lang.String r6 = "scheduleAsPackage"
            r7 = 4
            java.lang.Class[] r7 = new java.lang.Class[r7]     // Catch:{ NoSuchMethodException -> 0x0028 }
            r8 = 0
            java.lang.Class<android.app.job.JobInfo> r9 = android.app.job.JobInfo.class
            r7[r8] = r9     // Catch:{ NoSuchMethodException -> 0x0028 }
            r8 = 1
            r7[r8] = r0     // Catch:{ NoSuchMethodException -> 0x0028 }
            r8 = 2
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x0028 }
            r7[r8] = r9     // Catch:{ NoSuchMethodException -> 0x0028 }
            r8 = 3
            r7[r8] = r0     // Catch:{ NoSuchMethodException -> 0x0028 }
            java.lang.reflect.Method r0 = r1.getDeclaredMethod(r6, r7)     // Catch:{ NoSuchMethodException -> 0x0028 }
            goto L_0x0035
        L_0x0028:
            boolean r0 = android.util.Log.isLoggable(r2, r3)
            if (r0 == 0) goto L_0x0034
            java.lang.String r0 = "No scheduleAsPackage method available, falling back to schedule"
            android.util.Log.e(r2, r0)
        L_0x0034:
            r0 = r4
        L_0x0035:
            f1500a = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r5) goto L_0x0050
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            java.lang.String r1 = "myUserId"
            java.lang.reflect.Method r4 = r0.getDeclaredMethod(r1, r4)     // Catch:{ NoSuchMethodException -> 0x0044 }
            goto L_0x0050
        L_0x0044:
            boolean r0 = android.util.Log.isLoggable(r2, r3)
            if (r0 == 0) goto L_0x0050
            java.lang.String r0 = "No myUserId method available"
            android.util.Log.e(r2, r0)
        L_0x0050:
            f1501b = r4
            a.d.a.a.h.f.i1 r0 = a.d.a.a.h.f.h1.f1508a
            f1502c = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.f.g1.<clinit>():void");
    }

    public static int a(Context context, JobInfo jobInfo, String str, String str2) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (f1500a == null || ((h1) f1502c) != null) {
            return jobScheduler.schedule(jobInfo);
        }
        throw null;
    }
}
