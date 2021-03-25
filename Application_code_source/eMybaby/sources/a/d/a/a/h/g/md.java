package a.d.a.a.h.g;

import android.os.IBinder;
import android.os.IInterface;

public abstract class md extends p0 implements nd {
    public md() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static nd asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        return queryLocalInterface instanceof nd ? (nd) queryLocalInterface : new pd(iBinder);
    }

    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v5, types: [a.d.a.a.h.g.od] */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r4v9, types: [a.d.a.a.h.g.od] */
    /* JADX WARNING: type inference failed for: r4v14, types: [a.d.a.a.h.g.od] */
    /* JADX WARNING: type inference failed for: r4v18, types: [a.d.a.a.h.g.od] */
    /* JADX WARNING: type inference failed for: r4v24, types: [a.d.a.a.h.g.od] */
    /* JADX WARNING: type inference failed for: r4v28, types: [a.d.a.a.h.g.od] */
    /* JADX WARNING: type inference failed for: r4v32, types: [a.d.a.a.h.g.c] */
    /* JADX WARNING: type inference failed for: r4v36, types: [a.d.a.a.h.g.od] */
    /* JADX WARNING: type inference failed for: r4v40, types: [a.d.a.a.h.g.od] */
    /* JADX WARNING: type inference failed for: r4v44, types: [a.d.a.a.h.g.od] */
    /* JADX WARNING: type inference failed for: r4v48, types: [a.d.a.a.h.g.od] */
    /* JADX WARNING: type inference failed for: r4v52, types: [a.d.a.a.h.g.od] */
    /* JADX WARNING: type inference failed for: r4v57, types: [a.d.a.a.h.g.od] */
    /* JADX WARNING: type inference failed for: r4v64, types: [a.d.a.a.h.g.b] */
    /* JADX WARNING: type inference failed for: r4v68, types: [a.d.a.a.h.g.b] */
    /* JADX WARNING: type inference failed for: r4v72, types: [a.d.a.a.h.g.b] */
    /* JADX WARNING: type inference failed for: r4v76, types: [a.d.a.a.h.g.od] */
    /* JADX WARNING: type inference failed for: r4v80, types: [a.d.a.a.h.g.od] */
    /* JADX WARNING: type inference failed for: r4v84 */
    /* JADX WARNING: type inference failed for: r4v85 */
    /* JADX WARNING: type inference failed for: r4v86 */
    /* JADX WARNING: type inference failed for: r4v87 */
    /* JADX WARNING: type inference failed for: r4v88 */
    /* JADX WARNING: type inference failed for: r4v89 */
    /* JADX WARNING: type inference failed for: r4v90 */
    /* JADX WARNING: type inference failed for: r4v91 */
    /* JADX WARNING: type inference failed for: r4v92 */
    /* JADX WARNING: type inference failed for: r4v93 */
    /* JADX WARNING: type inference failed for: r4v94 */
    /* JADX WARNING: type inference failed for: r4v95 */
    /* JADX WARNING: type inference failed for: r4v96 */
    /* JADX WARNING: type inference failed for: r4v97 */
    /* JADX WARNING: type inference failed for: r4v98 */
    /* JADX WARNING: type inference failed for: r4v99 */
    /* JADX WARNING: type inference failed for: r4v100 */
    /* JADX WARNING: type inference failed for: r4v101 */
    /* JADX WARNING: type inference failed for: r4v102 */
    /* JADX WARNING: type inference failed for: r4v103 */
    /* JADX WARNING: type inference failed for: r4v104 */
    /* JADX WARNING: type inference failed for: r4v105 */
    /* JADX WARNING: type inference failed for: r4v106 */
    /* JADX WARNING: type inference failed for: r4v107 */
    /* JADX WARNING: type inference failed for: r4v108 */
    /* JADX WARNING: type inference failed for: r4v109 */
    /* JADX WARNING: type inference failed for: r4v110 */
    /* JADX WARNING: type inference failed for: r4v111 */
    /* JADX WARNING: type inference failed for: r4v112 */
    /* JADX WARNING: type inference failed for: r4v113 */
    /* JADX WARNING: type inference failed for: r4v114 */
    /* JADX WARNING: type inference failed for: r4v115 */
    /* JADX WARNING: type inference failed for: r4v116 */
    /* JADX WARNING: type inference failed for: r4v117 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean e(int r13, android.os.Parcel r14, android.os.Parcel r15, int r16) {
        /*
            r12 = this;
            r8 = r12
            r0 = r14
            java.lang.String r1 = "com.google.android.gms.measurement.api.internal.IEventHandlerProxy"
            r9 = 1
            r2 = 0
            java.lang.String r3 = "com.google.android.gms.measurement.api.internal.IBundleReceiver"
            r4 = 0
            switch(r13) {
                case 1: goto L_0x040f;
                case 2: goto L_0x03df;
                case 3: goto L_0x03ac;
                case 4: goto L_0x038e;
                case 5: goto L_0x0365;
                case 6: goto L_0x0344;
                case 7: goto L_0x0337;
                case 8: goto L_0x0326;
                case 9: goto L_0x0311;
                case 10: goto L_0x02ec;
                case 11: goto L_0x02df;
                case 12: goto L_0x02d6;
                case 13: goto L_0x02cd;
                case 14: goto L_0x02c4;
                case 15: goto L_0x02aa;
                case 16: goto L_0x028d;
                case 17: goto L_0x0270;
                case 18: goto L_0x0251;
                case 19: goto L_0x0234;
                case 20: goto L_0x0217;
                case 21: goto L_0x01fa;
                case 22: goto L_0x01dd;
                case 23: goto L_0x01d0;
                case 24: goto L_0x01c3;
                case 25: goto L_0x01b2;
                case 26: goto L_0x01a1;
                case 27: goto L_0x0188;
                case 28: goto L_0x0177;
                case 29: goto L_0x0166;
                case 30: goto L_0x0155;
                case 31: goto L_0x012c;
                case 32: goto L_0x0103;
                case 33: goto L_0x00dd;
                case 34: goto L_0x00c0;
                case 35: goto L_0x00a3;
                case 36: goto L_0x0086;
                case 37: goto L_0x007b;
                case 38: goto L_0x005a;
                case 39: goto L_0x0051;
                case 40: goto L_0x0034;
                case 41: goto L_0x000c;
                case 42: goto L_0x0027;
                case 43: goto L_0x001e;
                case 44: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            return r2
        L_0x000d:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = a.d.a.a.h.g.u.a(r14, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            long r2 = r14.readLong()
            r12.setConsent(r1, r2)
            goto L_0x0426
        L_0x001e:
            long r0 = r14.readLong()
            r12.clearMeasurementEnabled(r0)
            goto L_0x0426
        L_0x0027:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r0 = a.d.a.a.h.g.u.a(r14, r1)
            android.os.Bundle r0 = (android.os.Bundle) r0
            r12.setDefaultEventParameters(r0)
            goto L_0x0426
        L_0x0034:
            android.os.IBinder r0 = r14.readStrongBinder()
            if (r0 != 0) goto L_0x003b
            goto L_0x004c
        L_0x003b:
            android.os.IInterface r1 = r0.queryLocalInterface(r3)
            boolean r2 = r1 instanceof a.d.a.a.h.g.od
            if (r2 == 0) goto L_0x0047
            r4 = r1
            a.d.a.a.h.g.od r4 = (a.d.a.a.h.g.od) r4
            goto L_0x004c
        L_0x0047:
            a.d.a.a.h.g.qd r4 = new a.d.a.a.h.g.qd
            r4.<init>(r0)
        L_0x004c:
            r12.isDataCollectionEnabled(r4)
            goto L_0x0426
        L_0x0051:
            boolean r0 = a.d.a.a.h.g.u.e(r14)
            r12.setDataCollectionEnabled(r0)
            goto L_0x0426
        L_0x005a:
            android.os.IBinder r1 = r14.readStrongBinder()
            if (r1 != 0) goto L_0x0061
            goto L_0x0072
        L_0x0061:
            android.os.IInterface r2 = r1.queryLocalInterface(r3)
            boolean r3 = r2 instanceof a.d.a.a.h.g.od
            if (r3 == 0) goto L_0x006d
            r4 = r2
            a.d.a.a.h.g.od r4 = (a.d.a.a.h.g.od) r4
            goto L_0x0072
        L_0x006d:
            a.d.a.a.h.g.qd r4 = new a.d.a.a.h.g.qd
            r4.<init>(r1)
        L_0x0072:
            int r0 = r14.readInt()
            r12.getTestFlag(r4, r0)
            goto L_0x0426
        L_0x007b:
            java.lang.ClassLoader r1 = a.d.a.a.h.g.u.f1956a
            java.util.HashMap r0 = r14.readHashMap(r1)
            r12.initForTests(r0)
            goto L_0x0426
        L_0x0086:
            android.os.IBinder r0 = r14.readStrongBinder()
            if (r0 != 0) goto L_0x008d
            goto L_0x009e
        L_0x008d:
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof a.d.a.a.h.g.b
            if (r2 == 0) goto L_0x0099
            r4 = r1
            a.d.a.a.h.g.b r4 = (a.d.a.a.h.g.b) r4
            goto L_0x009e
        L_0x0099:
            a.d.a.a.h.g.d r4 = new a.d.a.a.h.g.d
            r4.<init>(r0)
        L_0x009e:
            r12.unregisterOnMeasurementEventListener(r4)
            goto L_0x0426
        L_0x00a3:
            android.os.IBinder r0 = r14.readStrongBinder()
            if (r0 != 0) goto L_0x00aa
            goto L_0x00bb
        L_0x00aa:
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof a.d.a.a.h.g.b
            if (r2 == 0) goto L_0x00b6
            r4 = r1
            a.d.a.a.h.g.b r4 = (a.d.a.a.h.g.b) r4
            goto L_0x00bb
        L_0x00b6:
            a.d.a.a.h.g.d r4 = new a.d.a.a.h.g.d
            r4.<init>(r0)
        L_0x00bb:
            r12.registerOnMeasurementEventListener(r4)
            goto L_0x0426
        L_0x00c0:
            android.os.IBinder r0 = r14.readStrongBinder()
            if (r0 != 0) goto L_0x00c7
            goto L_0x00d8
        L_0x00c7:
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof a.d.a.a.h.g.b
            if (r2 == 0) goto L_0x00d3
            r4 = r1
            a.d.a.a.h.g.b r4 = (a.d.a.a.h.g.b) r4
            goto L_0x00d8
        L_0x00d3:
            a.d.a.a.h.g.d r4 = new a.d.a.a.h.g.d
            r4.<init>(r0)
        L_0x00d8:
            r12.setEventInterceptor(r4)
            goto L_0x0426
        L_0x00dd:
            int r1 = r14.readInt()
            java.lang.String r2 = r14.readString()
            android.os.IBinder r3 = r14.readStrongBinder()
            a.d.a.a.f.a r3 = a.d.a.a.f.a.C0063a.g(r3)
            android.os.IBinder r4 = r14.readStrongBinder()
            a.d.a.a.f.a r4 = a.d.a.a.f.a.C0063a.g(r4)
            android.os.IBinder r0 = r14.readStrongBinder()
            a.d.a.a.f.a r5 = a.d.a.a.f.a.C0063a.g(r0)
            r0 = r12
            r0.logHealthData(r1, r2, r3, r4, r5)
            goto L_0x0426
        L_0x0103:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = a.d.a.a.h.g.u.a(r14, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            android.os.IBinder r2 = r14.readStrongBinder()
            if (r2 != 0) goto L_0x0112
            goto L_0x0123
        L_0x0112:
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r4 = r3 instanceof a.d.a.a.h.g.od
            if (r4 == 0) goto L_0x011e
            r4 = r3
            a.d.a.a.h.g.od r4 = (a.d.a.a.h.g.od) r4
            goto L_0x0123
        L_0x011e:
            a.d.a.a.h.g.qd r4 = new a.d.a.a.h.g.qd
            r4.<init>(r2)
        L_0x0123:
            long r2 = r14.readLong()
            r12.performAction(r1, r4, r2)
            goto L_0x0426
        L_0x012c:
            android.os.IBinder r1 = r14.readStrongBinder()
            a.d.a.a.f.a r1 = a.d.a.a.f.a.C0063a.g(r1)
            android.os.IBinder r2 = r14.readStrongBinder()
            if (r2 != 0) goto L_0x013b
            goto L_0x014c
        L_0x013b:
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r4 = r3 instanceof a.d.a.a.h.g.od
            if (r4 == 0) goto L_0x0147
            r4 = r3
            a.d.a.a.h.g.od r4 = (a.d.a.a.h.g.od) r4
            goto L_0x014c
        L_0x0147:
            a.d.a.a.h.g.qd r4 = new a.d.a.a.h.g.qd
            r4.<init>(r2)
        L_0x014c:
            long r2 = r14.readLong()
            r12.onActivitySaveInstanceState(r1, r4, r2)
            goto L_0x0426
        L_0x0155:
            android.os.IBinder r1 = r14.readStrongBinder()
            a.d.a.a.f.a r1 = a.d.a.a.f.a.C0063a.g(r1)
            long r2 = r14.readLong()
            r12.onActivityResumed(r1, r2)
            goto L_0x0426
        L_0x0166:
            android.os.IBinder r1 = r14.readStrongBinder()
            a.d.a.a.f.a r1 = a.d.a.a.f.a.C0063a.g(r1)
            long r2 = r14.readLong()
            r12.onActivityPaused(r1, r2)
            goto L_0x0426
        L_0x0177:
            android.os.IBinder r1 = r14.readStrongBinder()
            a.d.a.a.f.a r1 = a.d.a.a.f.a.C0063a.g(r1)
            long r2 = r14.readLong()
            r12.onActivityDestroyed(r1, r2)
            goto L_0x0426
        L_0x0188:
            android.os.IBinder r1 = r14.readStrongBinder()
            a.d.a.a.f.a r1 = a.d.a.a.f.a.C0063a.g(r1)
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            android.os.Parcelable r2 = a.d.a.a.h.g.u.a(r14, r2)
            android.os.Bundle r2 = (android.os.Bundle) r2
            long r3 = r14.readLong()
            r12.onActivityCreated(r1, r2, r3)
            goto L_0x0426
        L_0x01a1:
            android.os.IBinder r1 = r14.readStrongBinder()
            a.d.a.a.f.a r1 = a.d.a.a.f.a.C0063a.g(r1)
            long r2 = r14.readLong()
            r12.onActivityStopped(r1, r2)
            goto L_0x0426
        L_0x01b2:
            android.os.IBinder r1 = r14.readStrongBinder()
            a.d.a.a.f.a r1 = a.d.a.a.f.a.C0063a.g(r1)
            long r2 = r14.readLong()
            r12.onActivityStarted(r1, r2)
            goto L_0x0426
        L_0x01c3:
            java.lang.String r1 = r14.readString()
            long r2 = r14.readLong()
            r12.endAdUnitExposure(r1, r2)
            goto L_0x0426
        L_0x01d0:
            java.lang.String r1 = r14.readString()
            long r2 = r14.readLong()
            r12.beginAdUnitExposure(r1, r2)
            goto L_0x0426
        L_0x01dd:
            android.os.IBinder r0 = r14.readStrongBinder()
            if (r0 != 0) goto L_0x01e4
            goto L_0x01f5
        L_0x01e4:
            android.os.IInterface r1 = r0.queryLocalInterface(r3)
            boolean r2 = r1 instanceof a.d.a.a.h.g.od
            if (r2 == 0) goto L_0x01f0
            r4 = r1
            a.d.a.a.h.g.od r4 = (a.d.a.a.h.g.od) r4
            goto L_0x01f5
        L_0x01f0:
            a.d.a.a.h.g.qd r4 = new a.d.a.a.h.g.qd
            r4.<init>(r0)
        L_0x01f5:
            r12.generateEventId(r4)
            goto L_0x0426
        L_0x01fa:
            android.os.IBinder r0 = r14.readStrongBinder()
            if (r0 != 0) goto L_0x0201
            goto L_0x0212
        L_0x0201:
            android.os.IInterface r1 = r0.queryLocalInterface(r3)
            boolean r2 = r1 instanceof a.d.a.a.h.g.od
            if (r2 == 0) goto L_0x020d
            r4 = r1
            a.d.a.a.h.g.od r4 = (a.d.a.a.h.g.od) r4
            goto L_0x0212
        L_0x020d:
            a.d.a.a.h.g.qd r4 = new a.d.a.a.h.g.qd
            r4.<init>(r0)
        L_0x0212:
            r12.getGmpAppId(r4)
            goto L_0x0426
        L_0x0217:
            android.os.IBinder r0 = r14.readStrongBinder()
            if (r0 != 0) goto L_0x021e
            goto L_0x022f
        L_0x021e:
            android.os.IInterface r1 = r0.queryLocalInterface(r3)
            boolean r2 = r1 instanceof a.d.a.a.h.g.od
            if (r2 == 0) goto L_0x022a
            r4 = r1
            a.d.a.a.h.g.od r4 = (a.d.a.a.h.g.od) r4
            goto L_0x022f
        L_0x022a:
            a.d.a.a.h.g.qd r4 = new a.d.a.a.h.g.qd
            r4.<init>(r0)
        L_0x022f:
            r12.getAppInstanceId(r4)
            goto L_0x0426
        L_0x0234:
            android.os.IBinder r0 = r14.readStrongBinder()
            if (r0 != 0) goto L_0x023b
            goto L_0x024c
        L_0x023b:
            android.os.IInterface r1 = r0.queryLocalInterface(r3)
            boolean r2 = r1 instanceof a.d.a.a.h.g.od
            if (r2 == 0) goto L_0x0247
            r4 = r1
            a.d.a.a.h.g.od r4 = (a.d.a.a.h.g.od) r4
            goto L_0x024c
        L_0x0247:
            a.d.a.a.h.g.qd r4 = new a.d.a.a.h.g.qd
            r4.<init>(r0)
        L_0x024c:
            r12.getCachedAppInstanceId(r4)
            goto L_0x0426
        L_0x0251:
            android.os.IBinder r0 = r14.readStrongBinder()
            if (r0 != 0) goto L_0x0258
            goto L_0x026b
        L_0x0258:
            java.lang.String r1 = "com.google.android.gms.measurement.api.internal.IStringProvider"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof a.d.a.a.h.g.c
            if (r2 == 0) goto L_0x0266
            r4 = r1
            a.d.a.a.h.g.c r4 = (a.d.a.a.h.g.c) r4
            goto L_0x026b
        L_0x0266:
            a.d.a.a.h.g.e r4 = new a.d.a.a.h.g.e
            r4.<init>(r0)
        L_0x026b:
            r12.setInstanceIdProvider(r4)
            goto L_0x0426
        L_0x0270:
            android.os.IBinder r0 = r14.readStrongBinder()
            if (r0 != 0) goto L_0x0277
            goto L_0x0288
        L_0x0277:
            android.os.IInterface r1 = r0.queryLocalInterface(r3)
            boolean r2 = r1 instanceof a.d.a.a.h.g.od
            if (r2 == 0) goto L_0x0283
            r4 = r1
            a.d.a.a.h.g.od r4 = (a.d.a.a.h.g.od) r4
            goto L_0x0288
        L_0x0283:
            a.d.a.a.h.g.qd r4 = new a.d.a.a.h.g.qd
            r4.<init>(r0)
        L_0x0288:
            r12.getCurrentScreenClass(r4)
            goto L_0x0426
        L_0x028d:
            android.os.IBinder r0 = r14.readStrongBinder()
            if (r0 != 0) goto L_0x0294
            goto L_0x02a5
        L_0x0294:
            android.os.IInterface r1 = r0.queryLocalInterface(r3)
            boolean r2 = r1 instanceof a.d.a.a.h.g.od
            if (r2 == 0) goto L_0x02a0
            r4 = r1
            a.d.a.a.h.g.od r4 = (a.d.a.a.h.g.od) r4
            goto L_0x02a5
        L_0x02a0:
            a.d.a.a.h.g.qd r4 = new a.d.a.a.h.g.qd
            r4.<init>(r0)
        L_0x02a5:
            r12.getCurrentScreenName(r4)
            goto L_0x0426
        L_0x02aa:
            android.os.IBinder r1 = r14.readStrongBinder()
            a.d.a.a.f.a r1 = a.d.a.a.f.a.C0063a.g(r1)
            java.lang.String r2 = r14.readString()
            java.lang.String r3 = r14.readString()
            long r4 = r14.readLong()
            r0 = r12
            r0.setCurrentScreen(r1, r2, r3, r4)
            goto L_0x0426
        L_0x02c4:
            long r0 = r14.readLong()
            r12.setSessionTimeoutDuration(r0)
            goto L_0x0426
        L_0x02cd:
            long r0 = r14.readLong()
            r12.setMinimumSessionDuration(r0)
            goto L_0x0426
        L_0x02d6:
            long r0 = r14.readLong()
            r12.resetAnalyticsData(r0)
            goto L_0x0426
        L_0x02df:
            boolean r1 = a.d.a.a.h.g.u.e(r14)
            long r2 = r14.readLong()
            r12.setMeasurementEnabled(r1, r2)
            goto L_0x0426
        L_0x02ec:
            java.lang.String r1 = r14.readString()
            java.lang.String r2 = r14.readString()
            android.os.IBinder r0 = r14.readStrongBinder()
            if (r0 != 0) goto L_0x02fb
            goto L_0x030c
        L_0x02fb:
            android.os.IInterface r3 = r0.queryLocalInterface(r3)
            boolean r4 = r3 instanceof a.d.a.a.h.g.od
            if (r4 == 0) goto L_0x0307
            r4 = r3
            a.d.a.a.h.g.od r4 = (a.d.a.a.h.g.od) r4
            goto L_0x030c
        L_0x0307:
            a.d.a.a.h.g.qd r4 = new a.d.a.a.h.g.qd
            r4.<init>(r0)
        L_0x030c:
            r12.getConditionalUserProperties(r1, r2, r4)
            goto L_0x0426
        L_0x0311:
            java.lang.String r1 = r14.readString()
            java.lang.String r2 = r14.readString()
            android.os.Parcelable$Creator r3 = android.os.Bundle.CREATOR
            android.os.Parcelable r0 = a.d.a.a.h.g.u.a(r14, r3)
            android.os.Bundle r0 = (android.os.Bundle) r0
            r12.clearConditionalUserProperty(r1, r2, r0)
            goto L_0x0426
        L_0x0326:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = a.d.a.a.h.g.u.a(r14, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            long r2 = r14.readLong()
            r12.setConditionalUserProperty(r1, r2)
            goto L_0x0426
        L_0x0337:
            java.lang.String r1 = r14.readString()
            long r2 = r14.readLong()
            r12.setUserId(r1, r2)
            goto L_0x0426
        L_0x0344:
            java.lang.String r1 = r14.readString()
            android.os.IBinder r0 = r14.readStrongBinder()
            if (r0 != 0) goto L_0x034f
            goto L_0x0360
        L_0x034f:
            android.os.IInterface r2 = r0.queryLocalInterface(r3)
            boolean r3 = r2 instanceof a.d.a.a.h.g.od
            if (r3 == 0) goto L_0x035b
            r4 = r2
            a.d.a.a.h.g.od r4 = (a.d.a.a.h.g.od) r4
            goto L_0x0360
        L_0x035b:
            a.d.a.a.h.g.qd r4 = new a.d.a.a.h.g.qd
            r4.<init>(r0)
        L_0x0360:
            r12.getMaxUserProperties(r1, r4)
            goto L_0x0426
        L_0x0365:
            java.lang.String r1 = r14.readString()
            java.lang.String r2 = r14.readString()
            boolean r5 = a.d.a.a.h.g.u.e(r14)
            android.os.IBinder r0 = r14.readStrongBinder()
            if (r0 != 0) goto L_0x0378
            goto L_0x0389
        L_0x0378:
            android.os.IInterface r3 = r0.queryLocalInterface(r3)
            boolean r4 = r3 instanceof a.d.a.a.h.g.od
            if (r4 == 0) goto L_0x0384
            r4 = r3
            a.d.a.a.h.g.od r4 = (a.d.a.a.h.g.od) r4
            goto L_0x0389
        L_0x0384:
            a.d.a.a.h.g.qd r4 = new a.d.a.a.h.g.qd
            r4.<init>(r0)
        L_0x0389:
            r12.getUserProperties(r1, r2, r5, r4)
            goto L_0x0426
        L_0x038e:
            java.lang.String r1 = r14.readString()
            java.lang.String r2 = r14.readString()
            android.os.IBinder r3 = r14.readStrongBinder()
            a.d.a.a.f.a r3 = a.d.a.a.f.a.C0063a.g(r3)
            boolean r4 = a.d.a.a.h.g.u.e(r14)
            long r5 = r14.readLong()
            r0 = r12
            r0.setUserProperty(r1, r2, r3, r4, r5)
            goto L_0x0426
        L_0x03ac:
            java.lang.String r1 = r14.readString()
            java.lang.String r2 = r14.readString()
            android.os.Parcelable$Creator r5 = android.os.Bundle.CREATOR
            android.os.Parcelable r5 = a.d.a.a.h.g.u.a(r14, r5)
            android.os.Bundle r5 = (android.os.Bundle) r5
            android.os.IBinder r6 = r14.readStrongBinder()
            if (r6 != 0) goto L_0x03c3
            goto L_0x03d4
        L_0x03c3:
            android.os.IInterface r3 = r6.queryLocalInterface(r3)
            boolean r4 = r3 instanceof a.d.a.a.h.g.od
            if (r4 == 0) goto L_0x03ce
            a.d.a.a.h.g.od r3 = (a.d.a.a.h.g.od) r3
            goto L_0x03d3
        L_0x03ce:
            a.d.a.a.h.g.qd r3 = new a.d.a.a.h.g.qd
            r3.<init>(r6)
        L_0x03d3:
            r4 = r3
        L_0x03d4:
            long r6 = r14.readLong()
            r0 = r12
            r3 = r5
            r5 = r6
            r0.logEventAndBundle(r1, r2, r3, r4, r5)
            goto L_0x0426
        L_0x03df:
            java.lang.String r1 = r14.readString()
            java.lang.String r3 = r14.readString()
            android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
            android.os.Parcelable r4 = a.d.a.a.h.g.u.a(r14, r4)
            android.os.Bundle r4 = (android.os.Bundle) r4
            int r5 = r14.readInt()
            if (r5 == 0) goto L_0x03f7
            r5 = 1
            goto L_0x03f8
        L_0x03f7:
            r5 = 0
        L_0x03f8:
            int r6 = r14.readInt()
            if (r6 == 0) goto L_0x0400
            r6 = 1
            goto L_0x0401
        L_0x0400:
            r6 = 0
        L_0x0401:
            long r10 = r14.readLong()
            r0 = r12
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r10
            r0.logEvent(r1, r2, r3, r4, r5, r6)
            goto L_0x0426
        L_0x040f:
            android.os.IBinder r1 = r14.readStrongBinder()
            a.d.a.a.f.a r1 = a.d.a.a.f.a.C0063a.g(r1)
            android.os.Parcelable$Creator<com.google.android.gms.internal.measurement.zzae> r2 = com.google.android.gms.internal.measurement.zzae.CREATOR
            android.os.Parcelable r2 = a.d.a.a.h.g.u.a(r14, r2)
            com.google.android.gms.internal.measurement.zzae r2 = (com.google.android.gms.internal.measurement.zzae) r2
            long r3 = r14.readLong()
            r12.initialize(r1, r2, r3)
        L_0x0426:
            r15.writeNoException()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.md.e(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
