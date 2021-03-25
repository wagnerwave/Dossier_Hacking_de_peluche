package com.tuya.smart.common;

import android.os.Parcel;
import android.os.Parcelable;

public class o000oo0o00 implements Parcelable {
    public static final Parcelable.Creator<o000oo0o00> CREATOR = new Parcelable.Creator<o000oo0o00>() {
        /* renamed from: O000000o */
        public o000oo0o00 createFromParcel(Parcel parcel) {
            return new o000oo0o00(parcel);
        }

        /* renamed from: O000000o */
        public o000oo0o00[] newArray(int i) {
            return new o000oo0o00[i];
        }
    };
    public final byte[] O000000o;

    public o000oo0o00(byte b2, byte b3) {
        byte[] bArr = new byte[2];
        this.O000000o = bArr;
        bArr[0] = b2;
        bArr[1] = b3;
    }

    public o000oo0o00(Parcel parcel) {
        this.O000000o = new byte[2];
        byte[] createByteArray = parcel.createByteArray();
        if (createByteArray != null) {
            byte[] bArr = this.O000000o;
            bArr[0] = createByteArray[0];
            bArr[1] = createByteArray[1];
        }
    }

    public byte[] O000000o() {
        return this.O000000o;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.O000000o);
    }
}
