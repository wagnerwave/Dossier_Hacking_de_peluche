package a.d.a.a.h.g;

import android.annotation.TargetApi;
import androidx.annotation.Nullable;
import java.lang.reflect.Method;

@TargetApi(24)
public final class f5 {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public static final Method f1699a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public static final Method f1700b;

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
            f1699a = r0
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
            f1700b = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.f5.<clinit>():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(android.content.Context r4, android.app.job.JobInfo r5, java.lang.String r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "jobscheduler"
            java.lang.Object r0 = r4.getSystemService(r0)
            android.app.job.JobScheduler r0 = (android.app.job.JobScheduler) r0
            java.lang.reflect.Method r1 = f1699a
            if (r1 == 0) goto L_0x0068
            java.lang.String r1 = "android.permission.UPDATE_DEVICE_STATS"
            int r4 = r4.checkSelfPermission(r1)
            if (r4 == 0) goto L_0x0015
            goto L_0x0068
        L_0x0015:
            java.lang.reflect.Method r4 = f1700b
            r1 = 0
            if (r4 == 0) goto L_0x0039
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ IllegalAccessException -> 0x002a, InvocationTargetException -> 0x0028 }
            java.lang.Object r4 = r4.invoke(r2, r3)     // Catch:{ IllegalAccessException -> 0x002a, InvocationTargetException -> 0x0028 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ IllegalAccessException -> 0x002a, InvocationTargetException -> 0x0028 }
            int r4 = r4.intValue()     // Catch:{ IllegalAccessException -> 0x002a, InvocationTargetException -> 0x0028 }
            goto L_0x003a
        L_0x0028:
            r4 = move-exception
            goto L_0x002b
        L_0x002a:
            r4 = move-exception
        L_0x002b:
            r2 = 6
            java.lang.String r3 = "JobSchedulerCompat"
            boolean r2 = android.util.Log.isLoggable(r3, r2)
            if (r2 == 0) goto L_0x0039
            java.lang.String r2 = "myUserId invocation illegal"
            android.util.Log.e(r3, r2, r4)
        L_0x0039:
            r4 = 0
        L_0x003a:
            java.lang.reflect.Method r2 = f1699a
            if (r2 == 0) goto L_0x0063
            r3 = 4
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ IllegalAccessException -> 0x005d, InvocationTargetException -> 0x005b }
            r3[r1] = r5     // Catch:{ IllegalAccessException -> 0x005d, InvocationTargetException -> 0x005b }
            r1 = 1
            r3[r1] = r6     // Catch:{ IllegalAccessException -> 0x005d, InvocationTargetException -> 0x005b }
            r6 = 2
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ IllegalAccessException -> 0x005d, InvocationTargetException -> 0x005b }
            r3[r6] = r4     // Catch:{ IllegalAccessException -> 0x005d, InvocationTargetException -> 0x005b }
            r4 = 3
            r3[r4] = r7     // Catch:{ IllegalAccessException -> 0x005d, InvocationTargetException -> 0x005b }
            java.lang.Object r4 = r2.invoke(r0, r3)     // Catch:{ IllegalAccessException -> 0x005d, InvocationTargetException -> 0x005b }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ IllegalAccessException -> 0x005d, InvocationTargetException -> 0x005b }
            int r4 = r4.intValue()     // Catch:{ IllegalAccessException -> 0x005d, InvocationTargetException -> 0x005b }
            goto L_0x0067
        L_0x005b:
            r4 = move-exception
            goto L_0x005e
        L_0x005d:
            r4 = move-exception
        L_0x005e:
            java.lang.String r6 = "error calling scheduleAsPackage"
            android.util.Log.e(r7, r6, r4)
        L_0x0063:
            int r4 = r0.schedule(r5)
        L_0x0067:
            return r4
        L_0x0068:
            int r4 = r0.schedule(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.f5.a(android.content.Context, android.app.job.JobInfo, java.lang.String, java.lang.String):int");
    }
}
