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

public final class o0000ooooo extends o000o0oo00 implements Parcelable {
    public static final String O000000o = o0000ooooo.class.getSimpleName();
    public static final int O00000Oo = 6;
    public static final int O00000oO = 33400;
    public static final Parcelable.Creator<o0000ooooo> O00000oo = new Parcelable.Creator<o0000ooooo>() {
        /* renamed from: O000000o */
        public o0000ooooo createFromParcel(Parcel parcel) {
            return new o0000ooooo((AccessMessage) parcel.readValue(AccessMessage.class.getClassLoader()));
        }

        /* renamed from: O000000o */
        public o0000ooooo[] newArray(int i) {
            return new o0000ooooo[i];
        }
    };
    public int O0000O0o;
    public int O0000OOo;
    public int O0000Oo;
    public int O0000Oo0;
    public int O0000OoO;

    public o0000ooooo(@NonNull AccessMessage accessMessage) {
        super(accessMessage);
        this.O00000o0 = accessMessage;
        this.O00000o = accessMessage.getParameters();
        O000000o();
    }

    public void O000000o() {
        String str = O000000o;
        StringBuilder n = a.n("Received light hsl status from: ");
        n.append(o00o0000oo.O000000o(this.O00000o0.getSrc(), true));
        o00oo0oo00.O00000o(str, n.toString());
        ByteBuffer order = ByteBuffer.wrap(this.O00000o).order(ByteOrder.LITTLE_ENDIAN);
        this.O0000O0o = order.getShort() & 65535;
        this.O0000OOo = order.getShort() & 65535;
        this.O0000Oo0 = order.getShort() & 65535;
        String str2 = O000000o;
        StringBuilder n2 = a.n("Present lightness: ");
        n2.append(this.O0000O0o);
        n2.append(" Present hue: ");
        n2.append(this.O0000OOo);
        o00oo0oo00.O00000o(str2, n2.toString());
        String str3 = O000000o;
        StringBuilder n3 = a.n("Present saturation: ");
        n3.append(this.O0000Oo0);
        o00oo0oo00.O00000o(str3, n3.toString());
        if (order.limit() > 6) {
            byte b2 = order.get() & AVFrame.FRM_STATE_UNKOWN;
            this.O0000Oo = b2 & 63;
            this.O0000OoO = b2 >> 6;
            String str4 = O000000o;
            StringBuilder n4 = a.n("Remaining time, transition number of steps: ");
            n4.append(this.O0000Oo);
            Log.v(str4, n4.toString());
            String str5 = O000000o;
            StringBuilder n5 = a.n("Remaining time, transition number of step resolution: ");
            n5.append(this.O0000OoO);
            Log.v(str5, n5.toString());
            String str6 = O000000o;
            StringBuilder n6 = a.n("Remaining time: ");
            n6.append(o00o0000oo.O00000o0((int) b2));
            Log.v(str6, n6.toString());
        }
    }

    public int O00000Oo() {
        return 33400;
    }

    public final int O00000oO() {
        return this.O0000OOo;
    }

    public int O00000oo() {
        return this.O0000Oo;
    }

    public int O0000O0o() {
        return this.O0000OoO;
    }

    public int describeContents() {
        return 0;
    }

    public final int w_() {
        return this.O0000O0o;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.O00000o0);
    }

    public final int x_() {
        return this.O0000Oo0;
    }
}
