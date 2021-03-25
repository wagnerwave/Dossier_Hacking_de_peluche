package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.tuya.sdk.sigmesh.bean.AccessMessage;
import com.tuya.sdk.sigmesh.transport.ConfigStatusMessage;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class o00000ooo0 extends ConfigStatusMessage implements Parcelable {
    public static final String O00000oO = o00000ooo0.class.getSimpleName();
    public static final int O00000oo = 32799;
    public static final int O0000O0o = 7;
    public static final int O0000OOo = 9;
    public static final Parcelable.Creator<o00000ooo0> O0000Oo0 = new Parcelable.Creator<o00000ooo0>() {
        /* renamed from: O000000o */
        public o00000ooo0 createFromParcel(Parcel parcel) {
            return new o00000ooo0((AccessMessage) parcel.readValue(AccessMessage.class.getClassLoader()));
        }

        /* renamed from: O000000o */
        public o00000ooo0[] newArray(int i) {
            return new o00000ooo0[i];
        }
    };
    public int O0000Oo;
    public int O0000OoO;
    public byte[] O0000Ooo;

    public o00000ooo0(@NonNull AccessMessage accessMessage) {
        super(accessMessage);
        this.O00000o = accessMessage.getParameters();
        O000000o();
    }

    public void O000000o() {
        byte[] bArr;
        AccessMessage accessMessage = (AccessMessage) this.O00000o0;
        byte b2 = this.O00000o[0];
        this.O000000o = b2;
        this.O00000Oo = O000000o(b2);
        byte[] bArr2 = this.O00000o;
        byte[] bArr3 = {bArr2[2], bArr2[1]};
        this.O0000Oo = ByteBuffer.wrap(bArr3).order(ByteOrder.BIG_ENDIAN).getShort();
        byte[] bArr4 = this.O00000o;
        this.O0000Ooo = new byte[]{bArr4[4], bArr4[3]};
        if (bArr4.length == 7) {
            bArr = new byte[]{bArr4[6], bArr4[5]};
            this.O0000OoO = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).getShort();
        } else {
            byte[] bArr5 = {bArr4[6], bArr4[5], bArr4[8], bArr4[7]};
            this.O0000OoO = ByteBuffer.wrap(bArr5).order(ByteOrder.BIG_ENDIAN).getInt();
            bArr = bArr5;
        }
        String str = O00000oO;
        StringBuilder n = a.n("Status code: ");
        n.append(this.O000000o);
        o00oo0oo00.O00000o(str, n.toString());
        String str2 = O00000oO;
        StringBuilder n2 = a.n("Status message: ");
        n2.append(this.O00000Oo);
        o00oo0oo00.O00000o(str2, n2.toString());
        a.z(bArr3, false, a.n("Element Address: "), O00000oO);
        String str3 = O00000oO;
        a.z(this.O0000Ooo, false, a.n("Subscription Address: "), str3);
        a.z(bArr, false, a.n("Model Identifier: "), O00000oO);
    }

    public int O00000Oo() {
        return 32799;
    }

    public final int O00000oO() {
        return this.O0000OoO;
    }

    public final boolean O00000oo() {
        return this.O000000o == 0;
    }

    public int describeContents() {
        return 0;
    }

    public int m_() {
        return this.O0000Oo;
    }

    public byte[] n_() {
        return this.O0000Ooo;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.O00000o0);
    }
}
