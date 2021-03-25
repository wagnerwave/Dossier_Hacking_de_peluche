package a.d.a.a.e.p;

import a.c.a.f.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.stats.WakeLockEvent;
import java.util.ArrayList;

public final class d implements Parcelable.Creator<WakeLockEvent> {
    public final Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int A0 = b.A0(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        String str = null;
        ArrayList<String> arrayList = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        boolean z = false;
        while (parcel.dataPosition() < A0) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = b.b0(parcel2, readInt);
                    break;
                case 2:
                    j = b.c0(parcel2, readInt);
                    break;
                case 4:
                    str = b.t(parcel2, readInt);
                    break;
                case 5:
                    i3 = b.b0(parcel2, readInt);
                    break;
                case 6:
                    arrayList = b.u(parcel2, readInt);
                    break;
                case 8:
                    j2 = b.c0(parcel2, readInt);
                    break;
                case 10:
                    str3 = b.t(parcel2, readInt);
                    break;
                case 11:
                    i2 = b.b0(parcel2, readInt);
                    break;
                case 12:
                    str2 = b.t(parcel2, readInt);
                    break;
                case 13:
                    str4 = b.t(parcel2, readInt);
                    break;
                case 14:
                    i4 = b.b0(parcel2, readInt);
                    break;
                case 15:
                    b.i1(parcel2, readInt, 4);
                    f = parcel.readFloat();
                    break;
                case 16:
                    j3 = b.c0(parcel2, readInt);
                    break;
                case 17:
                    str5 = b.t(parcel2, readInt);
                    break;
                case 18:
                    z = b.Z(parcel2, readInt);
                    break;
                default:
                    b.v0(parcel2, readInt);
                    break;
            }
        }
        b.A(parcel2, A0);
        return new WakeLockEvent(i, j, i2, str, i3, arrayList, str2, j2, i4, str3, str4, f, j3, str5, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new WakeLockEvent[i];
    }
}
