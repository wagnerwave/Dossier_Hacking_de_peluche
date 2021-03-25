package com.tuya.smart.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.tuya.sdk.sigmesh.bean.AccessMessage;
import com.tuya.sdk.sigmesh.transport.ConfigStatusMessage;

public final class o0000o0000 extends ConfigStatusMessage implements Parcelable {
    public static final String O00000oO = o0000o0000.class.getSimpleName();
    public static final int O00000oo = 32805;
    public static final Parcelable.Creator<o0000o0000> O0000O0o = new Parcelable.Creator<o0000o0000>() {
        /* renamed from: O000000o */
        public o0000o0000 createFromParcel(Parcel parcel) {
            return new o0000o0000((AccessMessage) parcel.readValue(AccessMessage.class.getClassLoader()));
        }

        /* renamed from: O000000o */
        public o0000o0000[] newArray(int i) {
            return new o0000o0000[i];
        }
    };
    public int O0000OOo;
    public int O0000Oo0;

    public o0000o0000(@NonNull AccessMessage accessMessage) {
        super(accessMessage);
        this.O00000o = accessMessage.getParameters();
        O000000o();
    }

    public void O000000o() {
        byte[] accessPdu = ((AccessMessage) this.O00000o0).getAccessPdu();
        this.O0000OOo = accessPdu[2] & 7;
        this.O0000Oo0 = (accessPdu[2] >> 3) & 31;
    }

    public int O00000Oo() {
        return 32805;
    }

    public int describeContents() {
        return 0;
    }

    public int o_() {
        return this.O0000OOo;
    }

    public int p_() {
        return this.O0000Oo0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.O00000o0);
    }
}
