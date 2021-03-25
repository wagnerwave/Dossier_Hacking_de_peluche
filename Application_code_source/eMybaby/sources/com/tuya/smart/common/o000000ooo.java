package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.tuya.sdk.sigmesh.bean.AccessMessage;
import com.tuya.sdk.sigmesh.transport.ConfigStatusMessage;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class o000000ooo extends ConfigStatusMessage implements Parcelable {
    public static final Parcelable.Creator<o000000ooo> CREATOR = new Parcelable.Creator<o000000ooo>() {
        /* renamed from: O000000o */
        public o000000ooo createFromParcel(Parcel parcel) {
            return new o000000ooo((AccessMessage) parcel.readValue(AccessMessage.class.getClassLoader()));
        }

        /* renamed from: O000000o */
        public o000000ooo[] newArray(int i) {
            return new o000000ooo[i];
        }
    };
    public static final String O00000oO = o000000ooo.class.getSimpleName();
    public static final int O00000oo = 32771;
    public int O0000O0o;
    public int O0000OOo;

    public o000000ooo(@NonNull AccessMessage accessMessage) {
        super(accessMessage);
        this.O00000o = accessMessage.getParameters();
        O000000o();
    }

    public final void O000000o() {
        byte b2 = this.O00000o[0];
        this.O000000o = b2;
        this.O00000Oo = O000000o(b2);
        byte[] bArr = this.O00000o;
        byte[] bArr2 = {(byte) (bArr[2] & 15), bArr[1]};
        this.O0000O0o = ByteBuffer.wrap(bArr2).order(ByteOrder.BIG_ENDIAN).getShort();
        byte[] bArr3 = this.O00000o;
        byte[] bArr4 = {(byte) ((bArr3[3] & 240) >> 4), (byte) (((bArr3[2] & 240) >> 4) | (bArr3[3] << 4))};
        this.O0000OOo = ByteBuffer.wrap(bArr4).order(ByteOrder.BIG_ENDIAN).getShort();
        String str = O00000oO;
        StringBuilder n = a.n("Status code: ");
        n.append(this.O000000o);
        o00oo0oo00.O00000o(str, n.toString());
        String str2 = O00000oO;
        StringBuilder n2 = a.n("Status message: ");
        n2.append(this.O00000Oo);
        o00oo0oo00.O00000o(str2, n2.toString());
        a.z(bArr2, false, a.n("Net key index: "), O00000oO);
        a.z(bArr4, false, a.n("App key index: "), O00000oO);
    }

    public final int O00000Oo() {
        return 32771;
    }

    public final int b_() {
        return this.O0000O0o;
    }

    public final int c_() {
        return this.O0000OOo;
    }

    public final boolean d_() {
        return this.O000000o == 0;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.O00000o0);
    }
}
