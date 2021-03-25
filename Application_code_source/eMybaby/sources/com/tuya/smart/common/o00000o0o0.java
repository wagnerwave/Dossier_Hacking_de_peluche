package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.tuya.sdk.sigmesh.bean.AccessMessage;
import com.tuya.sdk.sigmesh.transport.ConfigStatusMessage;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class o00000o0o0 extends ConfigStatusMessage implements Parcelable {
    public static final String O00000oO = o00000o0o0.class.getSimpleName();
    public static final int O00000oo = 32830;
    public static final int O0000O0o = 7;
    public static final int O0000OOo = 9;
    public static final Parcelable.Creator<o00000o0o0> O0000Oo0 = new Parcelable.Creator<o00000o0o0>() {
        /* renamed from: O000000o */
        public o00000o0o0 createFromParcel(Parcel parcel) {
            return new o00000o0o0((AccessMessage) parcel.readValue(AccessMessage.class.getClassLoader()));
        }

        /* renamed from: O000000o */
        public o00000o0o0[] newArray(int i) {
            return new o00000o0o0[i];
        }
    };
    public int O0000Oo;
    public int O0000OoO;
    public int O0000Ooo;

    public o00000o0o0(@NonNull AccessMessage accessMessage) {
        super(accessMessage);
        this.O00000o = accessMessage.getParameters();
        O000000o();
    }

    public final void O000000o() {
        byte[] bArr;
        ByteBuffer order = ByteBuffer.wrap(((AccessMessage) this.O00000o0).getParameters()).order(ByteOrder.LITTLE_ENDIAN);
        order.position(0);
        byte b2 = order.get();
        this.O000000o = b2;
        this.O00000Oo = O000000o(b2);
        byte[] bArr2 = this.O00000o;
        byte[] bArr3 = {bArr2[2], bArr2[1]};
        this.O0000Oo = ByteBuffer.wrap(bArr3).order(ByteOrder.BIG_ENDIAN).getShort();
        byte[] bArr4 = this.O00000o;
        byte[] bArr5 = {(byte) (bArr4[4] & 15), bArr4[3]};
        this.O0000OoO = ByteBuffer.wrap(bArr5).order(ByteOrder.BIG_ENDIAN).getShort();
        byte[] bArr6 = this.O00000o;
        if (bArr6.length == 7) {
            bArr = new byte[]{bArr6[6], bArr6[5]};
            this.O0000Ooo = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).getShort();
        } else {
            byte[] bArr7 = {bArr6[6], bArr6[5], bArr6[8], bArr6[7]};
            this.O0000Ooo = ByteBuffer.wrap(bArr7).order(ByteOrder.BIG_ENDIAN).getInt();
            bArr = bArr7;
        }
        String str = O00000oO;
        StringBuilder n = a.n("Status code: ");
        n.append(this.O000000o);
        o00oo0oo00.O00000o(str, n.toString());
        String str2 = O00000oO;
        StringBuilder n2 = a.n("Status message: ");
        n2.append(this.O00000Oo);
        o00oo0oo00.O00000o(str2, n2.toString());
        a.z(bArr3, false, a.n("Element address: "), O00000oO);
        a.z(bArr5, false, a.n("App key index: "), O00000oO);
        a.z(bArr, false, a.n("Model identifier: "), O00000oO);
    }

    public int O00000Oo() {
        return 32830;
    }

    public final int O00000oO() {
        return this.O0000Ooo;
    }

    public boolean O00000oo() {
        return this.O000000o == 0;
    }

    public int describeContents() {
        return 0;
    }

    public int h_() {
        return this.O0000Oo;
    }

    public final int i_() {
        return this.O0000OoO;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.O00000o0);
    }
}
