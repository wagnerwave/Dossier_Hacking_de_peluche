package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import com.tutk.IOTC.AVFrame;
import com.tuya.sdk.sigmesh.bean.AccessMessage;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class o0000oooo0 extends o000o0oo00 implements Parcelable {
    public static final String O000000o = "LightCtlTemperatureStatus";
    public static final int O00000Oo = 4;
    public static final int O00000oO = 33382;
    public static final Parcelable.Creator<o0000oooo0> O00000oo = new Parcelable.Creator<o0000oooo0>() {
        /* renamed from: O000000o */
        public o0000oooo0 createFromParcel(Parcel parcel) {
            return new o0000oooo0((AccessMessage) parcel.readValue(AccessMessage.class.getClassLoader()));
        }

        /* renamed from: O000000o */
        public o0000oooo0[] newArray(int i) {
            return new o0000oooo0[i];
        }
    };
    public int O0000O0o;
    public int O0000OOo;
    public Integer O0000Oo;
    public Integer O0000Oo0;
    public int O0000OoO;
    public int O0000Ooo;

    public o0000oooo0(@NonNull AccessMessage accessMessage) {
        super(accessMessage);
        this.O00000o0 = accessMessage;
        this.O00000o = accessMessage.getParameters();
        O000000o();
    }

    public void O000000o() {
        StringBuilder n = a.n("Received light ctl status from: ");
        n.append(o00o0000oo.O000000o(this.O00000o0.getSrc(), true));
        o00oo0oo00.O00000o(O000000o, n.toString());
        ByteBuffer order = ByteBuffer.wrap(this.O00000o).order(ByteOrder.LITTLE_ENDIAN);
        this.O0000O0o = order.getShort() & 65535;
        this.O0000OOo = order.getShort() & 65535;
        StringBuilder n2 = a.n("Present deltaUv: ");
        n2.append(this.O0000OOo);
        o00oo0oo00.O00000o(O000000o, n2.toString());
        o00oo0oo00.O00000o(O000000o, "Present temperature: " + this.O0000O0o);
        if (order.limit() > 4) {
            this.O0000Oo0 = Integer.valueOf(order.getShort() & 65535);
            this.O0000Oo = Integer.valueOf(order.getShort() & 65535);
            byte b2 = order.get() & AVFrame.FRM_STATE_UNKOWN;
            this.O0000OoO = b2 & 63;
            this.O0000Ooo = b2 >> 6;
            StringBuilder n3 = a.n("Target temperature: ");
            n3.append(this.O0000Oo0);
            o00oo0oo00.O00000o(O000000o, n3.toString());
            o00oo0oo00.O00000o(O000000o, "Target deltaUv: " + this.O0000Oo);
            Log.v(O000000o, "Remaining time, transition number of steps: " + this.O0000OoO);
            Log.v(O000000o, "Remaining time, transition number of step resolution: " + this.O0000Ooo);
            Log.v(O000000o, "Remaining time: " + o00o0000oo.O00000o0((int) b2));
        }
    }

    public int O00000Oo() {
        return 33382;
    }

    public int O00000oO() {
        return this.O0000OoO;
    }

    public int O00000oo() {
        return this.O0000Ooo;
    }

    public int describeContents() {
        return 0;
    }

    public final int u_() {
        return this.O0000O0o;
    }

    public final Integer v_() {
        return this.O0000Oo0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.O00000o0);
    }
}
