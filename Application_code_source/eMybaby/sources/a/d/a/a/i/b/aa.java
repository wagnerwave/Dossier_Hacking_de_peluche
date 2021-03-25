package a.d.a.a.i.b;

import a.c.a.f.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.internal.zzn;
import java.util.ArrayList;
import java.util.List;

public final class aa implements Parcelable.Creator<zzn> {
    public final Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int A0 = b.A0(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        Boolean bool = null;
        ArrayList<String> arrayList = null;
        String str8 = null;
        long j6 = -2147483648L;
        String str9 = "";
        boolean z = true;
        boolean z2 = false;
        int i = 0;
        boolean z3 = true;
        boolean z4 = true;
        boolean z5 = false;
        while (parcel.dataPosition() < A0) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str = b.t(parcel2, readInt);
                    break;
                case 3:
                    str2 = b.t(parcel2, readInt);
                    break;
                case 4:
                    str3 = b.t(parcel2, readInt);
                    break;
                case 5:
                    str4 = b.t(parcel2, readInt);
                    break;
                case 6:
                    j = b.c0(parcel2, readInt);
                    break;
                case 7:
                    j2 = b.c0(parcel2, readInt);
                    break;
                case 8:
                    str5 = b.t(parcel2, readInt);
                    break;
                case 9:
                    z = b.Z(parcel2, readInt);
                    break;
                case 10:
                    z2 = b.Z(parcel2, readInt);
                    break;
                case 11:
                    j6 = b.c0(parcel2, readInt);
                    break;
                case 12:
                    str6 = b.t(parcel2, readInt);
                    break;
                case 13:
                    j3 = b.c0(parcel2, readInt);
                    break;
                case 14:
                    j4 = b.c0(parcel2, readInt);
                    break;
                case 15:
                    i = b.b0(parcel2, readInt);
                    break;
                case 16:
                    z3 = b.Z(parcel2, readInt);
                    break;
                case 17:
                    z4 = b.Z(parcel2, readInt);
                    break;
                case 18:
                    z5 = b.Z(parcel2, readInt);
                    break;
                case 19:
                    str7 = b.t(parcel2, readInt);
                    break;
                case 21:
                    int d0 = b.d0(parcel2, readInt);
                    if (d0 != 0) {
                        b.q1(parcel2, d0, 4);
                        bool = Boolean.valueOf(parcel.readInt() != 0);
                        break;
                    } else {
                        bool = null;
                        break;
                    }
                case 22:
                    j5 = b.c0(parcel2, readInt);
                    break;
                case 23:
                    arrayList = b.u(parcel2, readInt);
                    break;
                case 24:
                    str8 = b.t(parcel2, readInt);
                    break;
                case 25:
                    str9 = b.t(parcel2, readInt);
                    break;
                default:
                    b.v0(parcel2, readInt);
                    break;
            }
        }
        b.A(parcel2, A0);
        return new zzn(str, str2, str3, str4, j, j2, str5, z, z2, j6, str6, j3, j4, i, z3, z4, z5, str7, bool, j5, (List<String>) arrayList, str8, str9);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzn[i];
    }
}
