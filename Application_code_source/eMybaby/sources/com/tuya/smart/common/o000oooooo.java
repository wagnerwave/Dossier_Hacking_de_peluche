package com.tuya.smart.common;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class o000oooooo implements Parcelable {
    public static final Parcelable.Creator<o000oooooo> CREATOR = new Parcelable.Creator<o000oooooo>() {
        /* renamed from: O000000o */
        public o000oooooo createFromParcel(Parcel parcel) {
            return new o000oooooo(parcel);
        }

        /* renamed from: O000000o */
        public o000oooooo[] newArray(int i) {
            return new o000oooooo[i];
        }
    };
    public static final int O000000o = 127;
    public static final int O00000Oo = 0;
    public static final int O00000o = 0;
    public static final int O00000o0 = 0;
    public static final int O00000oO = 0;
    public byte[] O00000oo;
    public int O0000O0o;
    public boolean O0000OOo;
    public int O0000Oo;
    public int O0000Oo0;
    public int O0000OoO;
    public int O0000Ooo;
    public int O0000o00;

    public o000oooooo() {
        this.O0000Oo0 = 127;
        this.O0000Oo = 0;
        this.O0000OoO = 0;
        this.O0000Ooo = 0;
        this.O0000o00 = 0;
    }

    public o000oooooo(Parcel parcel) {
        this.O0000Oo0 = 127;
        boolean z = false;
        this.O0000Oo = 0;
        this.O0000OoO = 0;
        this.O0000Ooo = 0;
        this.O0000o00 = 0;
        this.O00000oo = parcel.createByteArray();
        this.O0000O0o = parcel.readInt();
        this.O0000OOo = parcel.readInt() == 1 ? true : z;
        this.O0000Oo0 = parcel.readInt();
        this.O0000Oo = parcel.readInt();
        this.O0000OoO = parcel.readInt();
        this.O0000Ooo = parcel.readInt();
        this.O0000o00 = parcel.readInt();
    }

    public o000oooooo(byte[] bArr, int i, boolean z, int i2, int i3) {
        this(bArr, i, z, 127, 0, 0, 0, 0);
    }

    public o000oooooo(byte[] bArr, int i, boolean z, int i2, int i3, int i4, int i5, int i6) {
        this.O0000Oo0 = 127;
        this.O0000Oo = 0;
        this.O0000OoO = 0;
        this.O0000Ooo = 0;
        this.O0000o00 = 0;
        this.O00000oo = bArr;
        this.O0000O0o = i;
        this.O0000OOo = z;
        this.O0000Oo0 = i2;
        this.O0000Oo = i3;
        this.O0000OoO = i4;
        this.O0000Ooo = i5;
        this.O0000o00 = i6;
    }

    public o000oooooo(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5, int i6) {
        this.O0000Oo0 = 127;
        boolean z = false;
        this.O0000Oo = 0;
        this.O0000OoO = 0;
        this.O0000Ooo = 0;
        this.O0000o00 = 0;
        this.O00000oo = bArr;
        this.O0000O0o = ByteBuffer.wrap(bArr2).order(ByteOrder.BIG_ENDIAN).getShort();
        this.O0000OOo = i == 1 ? true : z;
        this.O0000Oo0 = i2;
        this.O0000Oo = i3;
        this.O0000OoO = i4;
        this.O0000Ooo = i5;
        this.O0000o00 = i6;
    }

    public void O000000o(int i) {
        this.O0000O0o = i;
    }

    public void O000000o(boolean z) {
        this.O0000OOo = z;
    }

    public void O000000o(byte[] bArr) {
        this.O00000oo = bArr;
    }

    public byte[] O000000o() {
        return this.O00000oo;
    }

    public int O00000Oo() {
        return this.O0000O0o;
    }

    public void O00000Oo(int i) {
        this.O0000Oo0 = i;
    }

    public int O00000o() {
        return this.O0000Oo0 & 255;
    }

    public void O00000o(int i) {
        this.O0000o00 = i;
    }

    public void O00000o0(int i) {
        this.O0000Ooo = i;
    }

    public boolean O00000o0() {
        return this.O0000OOo;
    }

    public int O00000oO() {
        return this.O0000Ooo;
    }

    public void O00000oO(int i) {
        this.O0000Oo = i;
    }

    public int O00000oo() {
        return this.O0000o00;
    }

    public void O00000oo(int i) {
        this.O0000OoO = i;
    }

    public int O0000O0o() {
        return this.O0000Oo;
    }

    public int O0000OOo() {
        return this.O0000OoO;
    }

    public int O0000Oo0() {
        return (this.O0000Oo << 6) | this.O0000OoO;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.O00000oo);
        parcel.writeInt(this.O0000O0o);
        parcel.writeInt(this.O0000OOo ? 1 : 0);
        parcel.writeInt(this.O0000Oo0);
        parcel.writeInt(this.O0000Oo);
        parcel.writeInt(this.O0000OoO);
        parcel.writeInt(this.O0000Ooo);
        parcel.writeInt(this.O0000o00);
    }
}
