package a.d.a.a.c.a.d;

import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public final class e implements Parcelable.Creator<GoogleSignInAccount> {
    /* JADX WARNING: type inference failed for: r2v3, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object createFromParcel(android.os.Parcel r21) {
        /*
            r20 = this;
            r0 = r21
            int r1 = a.c.a.f.b.A0(r21)
            r2 = 0
            r3 = 0
            r4 = 0
            r8 = r2
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r16 = r13
            r17 = r16
            r18 = r17
            r19 = r18
            r14 = r4
            r7 = 0
        L_0x001a:
            int r2 = r21.dataPosition()
            if (r2 >= r1) goto L_0x0072
            int r2 = r21.readInt()
            r3 = 65535(0xffff, float:9.1834E-41)
            r3 = r3 & r2
            switch(r3) {
                case 1: goto L_0x006d;
                case 2: goto L_0x0068;
                case 3: goto L_0x0063;
                case 4: goto L_0x005e;
                case 5: goto L_0x0059;
                case 6: goto L_0x004f;
                case 7: goto L_0x004a;
                case 8: goto L_0x0045;
                case 9: goto L_0x0040;
                case 10: goto L_0x0039;
                case 11: goto L_0x0034;
                case 12: goto L_0x002f;
                default: goto L_0x002b;
            }
        L_0x002b:
            a.c.a.f.b.v0(r0, r2)
            goto L_0x001a
        L_0x002f:
            java.lang.String r19 = a.c.a.f.b.t(r0, r2)
            goto L_0x001a
        L_0x0034:
            java.lang.String r18 = a.c.a.f.b.t(r0, r2)
            goto L_0x001a
        L_0x0039:
            android.os.Parcelable$Creator<com.google.android.gms.common.api.Scope> r3 = com.google.android.gms.common.api.Scope.CREATOR
            java.util.ArrayList r17 = a.c.a.f.b.w(r0, r2, r3)
            goto L_0x001a
        L_0x0040:
            java.lang.String r16 = a.c.a.f.b.t(r0, r2)
            goto L_0x001a
        L_0x0045:
            long r14 = a.c.a.f.b.c0(r0, r2)
            goto L_0x001a
        L_0x004a:
            java.lang.String r13 = a.c.a.f.b.t(r0, r2)
            goto L_0x001a
        L_0x004f:
            android.os.Parcelable$Creator r3 = android.net.Uri.CREATOR
            android.os.Parcelable r2 = a.c.a.f.b.s(r0, r2, r3)
            r12 = r2
            android.net.Uri r12 = (android.net.Uri) r12
            goto L_0x001a
        L_0x0059:
            java.lang.String r11 = a.c.a.f.b.t(r0, r2)
            goto L_0x001a
        L_0x005e:
            java.lang.String r10 = a.c.a.f.b.t(r0, r2)
            goto L_0x001a
        L_0x0063:
            java.lang.String r9 = a.c.a.f.b.t(r0, r2)
            goto L_0x001a
        L_0x0068:
            java.lang.String r8 = a.c.a.f.b.t(r0, r2)
            goto L_0x001a
        L_0x006d:
            int r7 = a.c.a.f.b.b0(r0, r2)
            goto L_0x001a
        L_0x0072:
            a.c.a.f.b.A(r0, r1)
            com.google.android.gms.auth.api.signin.GoogleSignInAccount r0 = new com.google.android.gms.auth.api.signin.GoogleSignInAccount
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r16, r17, r18, r19)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.c.a.d.e.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
