package a.d.a.a.i.b;

import a.d.a.a.h.g.p0;

public abstract class o3 extends p0 implements p3 {
    public o3() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0103, code lost:
        r9.writeNoException();
        r9.writeTypedList(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x015d, code lost:
        r9.writeNoException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0160, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean e(int r7, android.os.Parcel r8, android.os.Parcel r9, int r10) {
        /*
            r6 = this;
            r10 = 1
            r0 = 0
            switch(r7) {
                case 1: goto L_0x014a;
                case 2: goto L_0x0136;
                case 3: goto L_0x0005;
                case 4: goto L_0x012a;
                case 5: goto L_0x0116;
                case 6: goto L_0x010a;
                case 7: goto L_0x00f0;
                case 8: goto L_0x0005;
                case 9: goto L_0x00d9;
                case 10: goto L_0x00c3;
                case 11: goto L_0x00af;
                case 12: goto L_0x009a;
                case 13: goto L_0x008d;
                case 14: goto L_0x0073;
                case 15: goto L_0x005d;
                case 16: goto L_0x0047;
                case 17: goto L_0x0035;
                case 18: goto L_0x0028;
                case 19: goto L_0x0013;
                case 20: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            return r0
        L_0x0006:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r7 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r7 = a.d.a.a.h.g.u.a(r8, r7)
            com.google.android.gms.measurement.internal.zzn r7 = (com.google.android.gms.measurement.internal.zzn) r7
            r6.n(r7)
            goto L_0x015d
        L_0x0013:
            android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR
            android.os.Parcelable r7 = a.d.a.a.h.g.u.a(r8, r7)
            android.os.Bundle r7 = (android.os.Bundle) r7
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r0 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r8 = a.d.a.a.h.g.u.a(r8, r0)
            com.google.android.gms.measurement.internal.zzn r8 = (com.google.android.gms.measurement.internal.zzn) r8
            r6.H(r7, r8)
            goto L_0x015d
        L_0x0028:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r7 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r7 = a.d.a.a.h.g.u.a(r8, r7)
            com.google.android.gms.measurement.internal.zzn r7 = (com.google.android.gms.measurement.internal.zzn) r7
            r6.P(r7)
            goto L_0x015d
        L_0x0035:
            java.lang.String r7 = r8.readString()
            java.lang.String r0 = r8.readString()
            java.lang.String r8 = r8.readString()
            java.util.List r7 = r6.Q(r7, r0, r8)
            goto L_0x0103
        L_0x0047:
            java.lang.String r7 = r8.readString()
            java.lang.String r0 = r8.readString()
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r1 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r8 = a.d.a.a.h.g.u.a(r8, r1)
            com.google.android.gms.measurement.internal.zzn r8 = (com.google.android.gms.measurement.internal.zzn) r8
            java.util.List r7 = r6.S(r7, r0, r8)
            goto L_0x0103
        L_0x005d:
            java.lang.String r7 = r8.readString()
            java.lang.String r0 = r8.readString()
            java.lang.String r1 = r8.readString()
            boolean r8 = a.d.a.a.h.g.u.e(r8)
            java.util.List r7 = r6.y(r7, r0, r1, r8)
            goto L_0x0103
        L_0x0073:
            java.lang.String r7 = r8.readString()
            java.lang.String r0 = r8.readString()
            boolean r1 = a.d.a.a.h.g.u.e(r8)
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r2 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r8 = a.d.a.a.h.g.u.a(r8, r2)
            com.google.android.gms.measurement.internal.zzn r8 = (com.google.android.gms.measurement.internal.zzn) r8
            java.util.List r7 = r6.j(r7, r0, r1, r8)
            goto L_0x0103
        L_0x008d:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzw> r7 = com.google.android.gms.measurement.internal.zzw.CREATOR
            android.os.Parcelable r7 = a.d.a.a.h.g.u.a(r8, r7)
            com.google.android.gms.measurement.internal.zzw r7 = (com.google.android.gms.measurement.internal.zzw) r7
            r6.r(r7)
            goto L_0x015d
        L_0x009a:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzw> r7 = com.google.android.gms.measurement.internal.zzw.CREATOR
            android.os.Parcelable r7 = a.d.a.a.h.g.u.a(r8, r7)
            com.google.android.gms.measurement.internal.zzw r7 = (com.google.android.gms.measurement.internal.zzw) r7
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r0 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r8 = a.d.a.a.h.g.u.a(r8, r0)
            com.google.android.gms.measurement.internal.zzn r8 = (com.google.android.gms.measurement.internal.zzn) r8
            r6.l(r7, r8)
            goto L_0x015d
        L_0x00af:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r7 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r7 = a.d.a.a.h.g.u.a(r8, r7)
            com.google.android.gms.measurement.internal.zzn r7 = (com.google.android.gms.measurement.internal.zzn) r7
            java.lang.String r7 = r6.G(r7)
            r9.writeNoException()
            r9.writeString(r7)
            goto L_0x0160
        L_0x00c3:
            long r1 = r8.readLong()
            java.lang.String r3 = r8.readString()
            java.lang.String r4 = r8.readString()
            java.lang.String r5 = r8.readString()
            r0 = r6
            r0.N(r1, r3, r4, r5)
            goto L_0x015d
        L_0x00d9:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzar> r7 = com.google.android.gms.measurement.internal.zzar.CREATOR
            android.os.Parcelable r7 = a.d.a.a.h.g.u.a(r8, r7)
            com.google.android.gms.measurement.internal.zzar r7 = (com.google.android.gms.measurement.internal.zzar) r7
            java.lang.String r8 = r8.readString()
            byte[] r7 = r6.z(r7, r8)
            r9.writeNoException()
            r9.writeByteArray(r7)
            goto L_0x0160
        L_0x00f0:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r7 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r7 = a.d.a.a.h.g.u.a(r8, r7)
            com.google.android.gms.measurement.internal.zzn r7 = (com.google.android.gms.measurement.internal.zzn) r7
            int r8 = r8.readInt()
            if (r8 == 0) goto L_0x00ff
            r0 = 1
        L_0x00ff:
            java.util.List r7 = r6.k(r7, r0)
        L_0x0103:
            r9.writeNoException()
            r9.writeTypedList(r7)
            goto L_0x0160
        L_0x010a:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r7 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r7 = a.d.a.a.h.g.u.a(r8, r7)
            com.google.android.gms.measurement.internal.zzn r7 = (com.google.android.gms.measurement.internal.zzn) r7
            r6.w(r7)
            goto L_0x015d
        L_0x0116:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzar> r7 = com.google.android.gms.measurement.internal.zzar.CREATOR
            android.os.Parcelable r7 = a.d.a.a.h.g.u.a(r8, r7)
            com.google.android.gms.measurement.internal.zzar r7 = (com.google.android.gms.measurement.internal.zzar) r7
            java.lang.String r0 = r8.readString()
            java.lang.String r8 = r8.readString()
            r6.R(r7, r0, r8)
            goto L_0x015d
        L_0x012a:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r7 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r7 = a.d.a.a.h.g.u.a(r8, r7)
            com.google.android.gms.measurement.internal.zzn r7 = (com.google.android.gms.measurement.internal.zzn) r7
            r6.m(r7)
            goto L_0x015d
        L_0x0136:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzkw> r7 = com.google.android.gms.measurement.internal.zzkw.CREATOR
            android.os.Parcelable r7 = a.d.a.a.h.g.u.a(r8, r7)
            com.google.android.gms.measurement.internal.zzkw r7 = (com.google.android.gms.measurement.internal.zzkw) r7
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r0 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r8 = a.d.a.a.h.g.u.a(r8, r0)
            com.google.android.gms.measurement.internal.zzn r8 = (com.google.android.gms.measurement.internal.zzn) r8
            r6.u(r7, r8)
            goto L_0x015d
        L_0x014a:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzar> r7 = com.google.android.gms.measurement.internal.zzar.CREATOR
            android.os.Parcelable r7 = a.d.a.a.h.g.u.a(r8, r7)
            com.google.android.gms.measurement.internal.zzar r7 = (com.google.android.gms.measurement.internal.zzar) r7
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r0 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r8 = a.d.a.a.h.g.u.a(r8, r0)
            com.google.android.gms.measurement.internal.zzn r8 = (com.google.android.gms.measurement.internal.zzn) r8
            r6.A(r7, r8)
        L_0x015d:
            r9.writeNoException()
        L_0x0160:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.o3.e(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
