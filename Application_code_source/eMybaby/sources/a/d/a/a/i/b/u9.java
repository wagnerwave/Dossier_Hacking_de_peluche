package a.d.a.a.i.b;

import a.c.a.f.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.internal.zzkw;

public final class u9 implements Parcelable.Creator<zzkw> {
    public final Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int A0 = b.A0(parcel);
        String str = null;
        Long l = null;
        Float f = null;
        String str2 = null;
        String str3 = null;
        Double d2 = null;
        long j = 0;
        int i = 0;
        while (parcel.dataPosition() < A0) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = b.b0(parcel2, readInt);
                    break;
                case 2:
                    str = b.t(parcel2, readInt);
                    break;
                case 3:
                    j = b.c0(parcel2, readInt);
                    break;
                case 4:
                    int d0 = b.d0(parcel2, readInt);
                    if (d0 != 0) {
                        b.q1(parcel2, d0, 8);
                        l = Long.valueOf(parcel.readLong());
                        break;
                    } else {
                        l = null;
                        break;
                    }
                case 5:
                    int d02 = b.d0(parcel2, readInt);
                    if (d02 != 0) {
                        b.q1(parcel2, d02, 4);
                        f = Float.valueOf(parcel.readFloat());
                        break;
                    } else {
                        f = null;
                        break;
                    }
                case 6:
                    str2 = b.t(parcel2, readInt);
                    break;
                case 7:
                    str3 = b.t(parcel2, readInt);
                    break;
                case 8:
                    int d03 = b.d0(parcel2, readInt);
                    if (d03 != 0) {
                        b.q1(parcel2, d03, 8);
                        d2 = Double.valueOf(parcel.readDouble());
                        break;
                    } else {
                        d2 = null;
                        break;
                    }
                default:
                    b.v0(parcel2, readInt);
                    break;
            }
        }
        b.A(parcel2, A0);
        return new zzkw(i, str, j, l, f, str2, str3, d2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzkw[i];
    }
}
