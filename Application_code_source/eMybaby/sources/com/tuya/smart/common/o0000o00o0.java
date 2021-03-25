package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.tutk.IOTC.AVFrame;
import com.tuya.sdk.sigmesh.bean.AccessMessage;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class o0000o00o0 extends o000o0oo00 implements Parcelable {
    public static final String O000000o = o0000o00o0.class.getSimpleName();
    public static final int O00000Oo = 33284;
    public static final int O00000oO = 1;
    public static final Parcelable.Creator<o0000o00o0> O00000oo = new Parcelable.Creator<o0000o00o0>() {
        /* renamed from: O000000o */
        public o0000o00o0 createFromParcel(Parcel parcel) {
            return new o0000o00o0((AccessMessage) parcel.readValue(AccessMessage.class.getClassLoader()));
        }

        /* renamed from: O000000o */
        public o0000o00o0[] newArray(int i) {
            return new o0000o00o0[i];
        }
    };
    public boolean O0000O0o;
    public Boolean O0000OOo;
    public int O0000Oo;
    public int O0000Oo0;
    public int O0000OoO;

    public o0000o00o0(@NonNull AccessMessage accessMessage) {
        super(accessMessage);
        this.O00000o = accessMessage.getParameters();
        O000000o();
    }

    public void O000000o() {
        String str = O000000o;
        StringBuilder n = a.n("Received generic on off status from: ");
        boolean z = true;
        n.append(o00o0000oo.O000000o(this.O00000o0.getSrc(), true));
        n.append("  parameter: ");
        n.append(o00oo0o00o.O00000Oo(this.O00000o0.getParameters(), ","));
        o00oo0oo00.O00000o(str, n.toString());
        ByteBuffer order = ByteBuffer.wrap(this.O00000o).order(ByteOrder.LITTLE_ENDIAN);
        order.position(0);
        this.O0000O0o = order.get() == 1;
        String str2 = O000000o;
        StringBuilder n2 = a.n("Present on: ");
        n2.append(this.O0000O0o);
        o00oo0oo00.O00000o(str2, n2.toString());
        if (order.limit() > 1) {
            if (order.get() != 1) {
                z = false;
            }
            this.O0000OOo = Boolean.valueOf(z);
            byte b2 = order.get() & AVFrame.FRM_STATE_UNKOWN;
            this.O0000Oo0 = b2;
            this.O0000Oo = b2 & 63;
            this.O0000OoO = b2 >> 6;
            String str3 = O000000o;
            StringBuilder n3 = a.n("Target on: ");
            n3.append(this.O0000OOo);
            o00oo0oo00.O00000o(str3, n3.toString());
            String str4 = O000000o;
            StringBuilder n4 = a.n("Remaining time, transition number of steps: ");
            n4.append(this.O0000Oo);
            o00oo0oo00.O00000o(str4, n4.toString());
            String str5 = O000000o;
            StringBuilder n5 = a.n("Remaining time, transition number of step resolution: ");
            n5.append(this.O0000OoO);
            o00oo0oo00.O00000o(str5, n5.toString());
            String str6 = O000000o;
            StringBuilder n6 = a.n("Remaining time: ");
            n6.append(o00o0000oo.O00000o0(this.O0000Oo0));
            o00oo0oo00.O00000o(str6, n6.toString());
        }
    }

    public int O00000Oo() {
        return 33284;
    }

    public int O00000oO() {
        return this.O0000Oo;
    }

    public int O00000oo() {
        return this.O0000OoO;
    }

    public int describeContents() {
        return 0;
    }

    public final boolean q_() {
        return this.O0000O0o;
    }

    public final Boolean r_() {
        return this.O0000OOo;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.O00000o0);
    }
}
