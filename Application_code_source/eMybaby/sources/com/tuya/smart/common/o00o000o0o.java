package com.tuya.smart.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;

public class o00o000o0o extends SparseIntArray implements Parcelable {
    public static Parcelable.Creator<o00o000o0o> O000000o = new Parcelable.Creator<o00o000o0o>() {
        /* renamed from: O000000o */
        public o00o000o0o createFromParcel(Parcel parcel) {
            o00o000o0o o00o000o0o = new o00o000o0o();
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            int[] iArr2 = new int[readInt];
            parcel.readIntArray(iArr);
            parcel.readIntArray(iArr2);
            for (int i = 0; i < readInt; i++) {
                o00o000o0o.put(iArr[i], iArr2[i]);
            }
            return o00o000o0o;
        }

        /* renamed from: O000000o */
        public o00o000o0o[] newArray(int i) {
            return new o00o000o0o[i];
        }
    };

    public o00o000o0o() {
    }

    public o00o000o0o(SparseIntArray sparseIntArray) {
        for (int i = 0; i < sparseIntArray.size(); i++) {
            put(sparseIntArray.keyAt(i), sparseIntArray.valueAt(i));
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int[] iArr = new int[size()];
        int[] iArr2 = new int[size()];
        for (int i2 = 0; i2 < size(); i2++) {
            iArr[i2] = keyAt(i2);
            iArr2[i2] = valueAt(i2);
        }
        parcel.writeInt(size());
        parcel.writeIntArray(iArr);
        parcel.writeIntArray(iArr2);
    }
}
