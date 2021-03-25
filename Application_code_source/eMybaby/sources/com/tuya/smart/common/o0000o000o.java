package com.tuya.smart.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.tuya.sdk.sigmesh.bean.AccessMessage;
import com.tuya.sdk.sigmesh.transport.ConfigStatusMessage;

public class o0000o000o extends ConfigStatusMessage implements Parcelable {
    public static final String O00000oO = o0000o000o.class.getSimpleName();
    public static final int O00000oo = 32842;
    public static final Parcelable.Creator<o0000o000o> O0000O0o = new Parcelable.Creator<o0000o000o>() {
        /* renamed from: O000000o */
        public o0000o000o createFromParcel(Parcel parcel) {
            return new o0000o000o((AccessMessage) parcel.readValue(AccessMessage.class.getClassLoader()));
        }

        /* renamed from: O000000o */
        public o0000o000o[] newArray(int i) {
            return new o0000o000o[i];
        }
    };

    public o0000o000o(@NonNull AccessMessage accessMessage) {
        super(accessMessage);
        this.O00000o = accessMessage.getParameters();
        O000000o();
    }

    public final void O000000o() {
    }

    public int O00000Oo() {
        return 32842;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.O00000o0);
    }
}
