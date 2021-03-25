package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class oooooo0o0 extends o000o0oooo {
    public static final Parcelable.Creator<oooooo0o0> CREATOR = new Parcelable.Creator<oooooo0o0>() {
        /* renamed from: O000000o */
        public oooooo0o0 createFromParcel(Parcel parcel) {
            return new oooooo0o0(parcel);
        }

        /* renamed from: O000000o */
        public oooooo0o0[] newArray(int i) {
            return new oooooo0o0[i];
        }
    };
    public static final String O000000o = oooooo0o0.class.getSimpleName();
    public final short O0000OOo;
    public final String O0000Oo0;

    public oooooo0o0(int i) {
        super(i);
        ByteBuffer order = ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN);
        order.putInt(i);
        short s = order.getShort(0);
        this.O0000OOo = s;
        this.O0000Oo0 = o000oo0ooo.O000000o(s);
        String str = O000000o;
        StringBuilder n = a.n("Company name: ");
        n.append(this.O0000Oo0);
        Log.v(str, n.toString());
    }

    public oooooo0o0(Parcel parcel) {
        super(parcel);
        ByteBuffer order = ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN);
        order.putInt(this.O00000oo);
        short s = order.getShort(0);
        this.O0000OOo = s;
        this.O0000Oo0 = o000oo0ooo.O000000o(s);
    }

    public int O000000o() {
        return this.O00000oo;
    }

    public String O00000Oo() {
        return "Vendor Model";
    }

    public String O00000o() {
        return this.O0000Oo0;
    }

    public int O00000o0() {
        return this.O0000OOo;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.O000000o(parcel, i);
    }
}
