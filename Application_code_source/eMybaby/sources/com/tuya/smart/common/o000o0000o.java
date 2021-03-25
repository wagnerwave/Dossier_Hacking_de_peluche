package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.tutk.IOTC.AVFrame;
import com.tuya.sdk.sigmesh.bean.AccessMessage;

public final class o000o0000o extends o000o0o000 implements Parcelable {
    public static final String O000000o = o000o0000o.class.getSimpleName();
    public static final int O00000Oo = 205;
    public static final Parcelable.Creator<o000o0000o> O00000oo = new Parcelable.Creator<o000o0000o>() {
        /* renamed from: O000000o */
        public o000o0000o createFromParcel(Parcel parcel) {
            return new o000o0000o((AccessMessage) parcel.readValue(AccessMessage.class.getClassLoader()), parcel.readInt());
        }

        /* renamed from: O000000o */
        public o000o0000o[] newArray(int i) {
            return new o000o0000o[i];
        }
    };
    public int O00000oO = -1;

    public o000o0000o(@NonNull AccessMessage accessMessage, int i) {
        super(accessMessage, i);
        this.O00000o = accessMessage.getParameters();
        O000000o();
    }

    public int A_() {
        return this.O00000oO;
    }

    public void O000000o() {
        byte[] bArr = this.O00000o;
        if (bArr.length > 0) {
            this.O00000oO = bArr[0] & AVFrame.FRM_STATE_UNKOWN;
        }
        String str = O000000o;
        StringBuilder n = a.n("receive mode : ");
        n.append(this.O00000oO);
        o00oo0oo00.O000000o(str, n.toString());
    }

    public void O000000o(int i) {
        this.O00000oO = i;
    }

    public int O00000Oo() {
        return 205;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.O00000o0);
    }
}
