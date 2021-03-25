package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.tuya.sdk.sigmesh.bean.AccessMessage;

public class o000o0o000 extends o000o0oo00 implements Parcelable {
    public static final Parcelable.Creator<o000o0o000> CREATOR = new Parcelable.Creator<o000o0o000>() {
        /* renamed from: O000000o */
        public o000o0o000 createFromParcel(Parcel parcel) {
            return new o000o0o000((AccessMessage) parcel.readValue(AccessMessage.class.getClassLoader()), parcel.readInt());
        }

        /* renamed from: O000000o */
        public o000o0o000[] newArray(int i) {
            return new o000o0o000[i];
        }
    };
    public static final String O000000o = o000o0o000.class.getSimpleName();
    public final int O00000Oo;

    public o000o0o000(@NonNull AccessMessage accessMessage, int i) {
        super(accessMessage);
        this.O00000o0 = accessMessage;
        this.O00000o = accessMessage.getParameters();
        this.O00000Oo = i;
        O000000o();
    }

    public void O000000o() {
        String str = O000000o;
        a.z(this.O00000o, false, a.n("Received Vendor model status: "), str);
    }

    public int O00000Oo() {
        return this.O00000o0.getOpCode();
    }

    public final byte[] O00000o() {
        return ((AccessMessage) this.O00000o0).getAccessPdu();
    }

    public int O00000oO() {
        return this.O00000Oo;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.O00000o0);
        parcel.writeInt(this.O00000Oo);
    }
}
