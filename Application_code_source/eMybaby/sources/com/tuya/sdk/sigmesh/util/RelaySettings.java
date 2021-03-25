package com.tuya.sdk.sigmesh.util;

import android.os.Parcel;
import android.os.Parcelable;

public class RelaySettings implements Parcelable {
    public static final Parcelable.Creator<RelaySettings> CREATOR = new Parcelable.Creator<RelaySettings>() {
        /* renamed from: O000000o */
        public RelaySettings createFromParcel(Parcel parcel) {
            return new RelaySettings(parcel);
        }

        /* renamed from: O000000o */
        public RelaySettings[] newArray(int i) {
            return new RelaySettings[i];
        }
    };
    public static final int O000000o = 0;
    public static final int O00000Oo = 1;
    public static final int O00000o0 = 2;
    public final int O00000o;
    public final int O00000oO;

    public enum Color {
        RELAY_FEATURE_DISABLED,
        RELAY_FEATURE_ENABLED,
        RELAY_FEATURE_NOT_SUPPORTED
    }

    public @interface O000000o {
    }

    public RelaySettings(int i, int i2) {
        this.O00000o = i;
        this.O00000oO = i2;
    }

    public RelaySettings(Parcel parcel) {
        this.O00000o = parcel.readInt();
        this.O00000oO = parcel.readInt();
    }

    public static boolean O000000o(@O000000o int i) {
        return i == 0 || i == 1;
    }

    public int O000000o() {
        return this.O00000o;
    }

    public int O00000Oo() {
        return this.O00000o + 1;
    }

    public int O00000o() {
        return (this.O00000oO + 1) * 10;
    }

    public int O00000o0() {
        return this.O00000oO;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.O00000o);
        parcel.writeInt(this.O00000oO);
    }
}
