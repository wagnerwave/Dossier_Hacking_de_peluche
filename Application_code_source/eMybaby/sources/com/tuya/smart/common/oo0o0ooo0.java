package com.tuya.smart.common;

import android.os.Parcel;
import android.os.Parcelable;

public class oo0o0ooo0 implements Parcelable {
    public static final Parcelable.Creator<oo0o0ooo0> CREATOR = new Parcelable.Creator<oo0o0ooo0>() {
        /* renamed from: O000000o */
        public oo0o0ooo0 createFromParcel(Parcel parcel) {
            return new oo0o0ooo0(parcel);
        }

        /* renamed from: O000000o */
        public oo0o0ooo0[] newArray(int i) {
            return new oo0o0ooo0[i];
        }
    };
    public static final int O000000o = 0;
    public static final int O00000Oo = 1;
    public static final int O00000o0 = 2;
    public int O00000o;
    public int O00000oO;
    public int O00000oo;
    public int O0000O0o;

    public oo0o0ooo0(int i, int i2, int i3, int i4) {
        this.O00000o = i;
        this.O00000oO = i2;
        this.O00000oo = i3;
        this.O0000O0o = i4;
    }

    public oo0o0ooo0(Parcel parcel) {
        this.O00000o = parcel.readInt();
        this.O00000oO = parcel.readInt();
        this.O00000oo = parcel.readInt();
        this.O0000O0o = parcel.readInt();
    }

    public int O000000o() {
        return this.O00000o;
    }

    public void O000000o(int i) {
        this.O00000o = i;
    }

    public int O00000Oo() {
        return this.O00000oO;
    }

    public void O00000Oo(int i) {
        this.O00000oO = i;
    }

    public int O00000o() {
        return this.O0000O0o;
    }

    public void O00000o(int i) {
        this.O0000O0o = i;
    }

    public int O00000o0() {
        return this.O00000oo;
    }

    public void O00000o0(int i) {
        this.O00000oo = i;
    }

    public boolean O00000oO() {
        return this.O00000o != 2;
    }

    public boolean O00000oo() {
        return this.O0000O0o != 2;
    }

    public boolean O0000O0o() {
        return this.O00000oo != 2;
    }

    public boolean O0000OOo() {
        return this.O00000oO != 2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.O00000o);
        parcel.writeInt(this.O00000oO);
        parcel.writeInt(this.O00000oo);
        parcel.writeInt(this.O0000O0o);
    }
}
