package com.tuya.smart.common;

import android.os.Parcel;
import android.os.Parcelable;

public final class o000o0o0o0 implements Parcelable {
    public static final Parcelable.Creator<o000o0o0o0> CREATOR = new Parcelable.Creator<o000o0o0o0>() {
        /* renamed from: O000000o */
        public o000o0o0o0 createFromParcel(Parcel parcel) {
            return new o000o0o0o0(parcel);
        }

        /* renamed from: O000000o */
        public o000o0o0o0[] newArray(int i) {
            return new o000o0o0o0[i];
        }
    };
    public int O000000o;
    public String O00000Oo;
    public String O00000o = "Application Key";
    public int O00000o0;
    public int O00000oO = 0;
    public byte[] O00000oo;
    public byte[] O0000O0o;

    public o000o0o0o0(int i, byte[] bArr) {
        this.O00000oo = bArr;
        this.O00000o0 = i;
    }

    public o000o0o0o0(Parcel parcel) {
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readInt();
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readInt();
        this.O00000oo = parcel.createByteArray();
        this.O0000O0o = parcel.createByteArray();
    }

    public int O000000o() {
        return this.O000000o;
    }

    public void O000000o(int i) {
        this.O000000o = i;
    }

    public void O000000o(String str) {
        this.O00000Oo = str;
    }

    public void O000000o(byte[] bArr) {
        this.O00000oo = bArr;
    }

    public String O00000Oo() {
        return this.O00000Oo;
    }

    public void O00000Oo(int i) {
        this.O00000o0 = i;
    }

    public void O00000Oo(String str) {
        this.O00000o = str;
    }

    public void O00000Oo(byte[] bArr) {
        this.O0000O0o = bArr;
    }

    public byte[] O00000o() {
        return this.O00000oo;
    }

    public String O00000o0() {
        return this.O00000o;
    }

    public void O00000o0(int i) {
        this.O00000oO = i;
    }

    public int O00000oO() {
        return this.O00000o0;
    }

    public int O00000oo() {
        return this.O00000oO;
    }

    public byte[] O0000O0o() {
        return this.O0000O0o;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.O00000Oo);
        parcel.writeInt(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeInt(this.O00000oO);
        parcel.writeByteArray(this.O00000oo);
        parcel.writeByteArray(this.O0000O0o);
    }
}
