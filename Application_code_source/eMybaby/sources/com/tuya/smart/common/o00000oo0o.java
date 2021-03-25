package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.tuya.sdk.sigmesh.bean.AccessMessage;
import com.tuya.sdk.sigmesh.transport.ConfigStatusMessage;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class o00000oo0o extends ConfigStatusMessage implements Parcelable {
    public static final String O00000oO = o00000oo0o.class.getSimpleName();
    public static final int O00000oo = 32830;
    public static final int O0000O0o = 12;
    public static final int O0000OOo = 14;
    public static final Parcelable.Creator<o00000oo0o> O0000Oo0 = new Parcelable.Creator<o00000oo0o>() {
        /* renamed from: O000000o */
        public o00000oo0o createFromParcel(Parcel parcel) {
            return new o00000oo0o((AccessMessage) parcel.readValue(AccessMessage.class.getClassLoader()));
        }

        /* renamed from: O000000o */
        public o00000oo0o[] newArray(int i) {
            return new o00000oo0o[i];
        }
    };
    public int O0000Oo;
    public byte[] O0000OoO;
    public int O0000Ooo;
    public int O0000o;
    public int O0000o0;
    public boolean O0000o00;
    public int O0000o0O;
    public int O0000o0o;
    public int O0000oO;
    public int O0000oO0;

    public o00000oo0o(@NonNull AccessMessage accessMessage) {
        super(accessMessage);
        this.O00000o = accessMessage.getParameters();
        O000000o();
    }

    public void O000000o() {
        byte[] bArr;
        ByteBuffer.wrap(((AccessMessage) this.O00000o0).getParameters()).order(ByteOrder.LITTLE_ENDIAN);
        byte b2 = this.O00000o[0];
        this.O000000o = b2;
        this.O00000Oo = O000000o(b2);
        byte[] bArr2 = this.O00000o;
        byte[] bArr3 = {bArr2[2], bArr2[1]};
        this.O0000Oo = ByteBuffer.wrap(bArr3).order(ByteOrder.BIG_ENDIAN).getShort();
        byte[] bArr4 = this.O00000o;
        this.O0000OoO = new byte[]{bArr4[4], bArr4[3]};
        byte[] bArr5 = {(byte) (bArr4[6] & 15), bArr4[5]};
        this.O0000Ooo = ByteBuffer.wrap(bArr5).order(ByteOrder.BIG_ENDIAN).getShort();
        this.O0000o00 = ((this.O00000o[6] & 240) >> 4) == 1;
        byte[] bArr6 = this.O00000o;
        this.O0000o0 = bArr6[7];
        byte b3 = bArr6[8];
        this.O0000o0O = b3 >> 6;
        this.O0000o0o = b3 & 3;
        this.O0000o = bArr6[9] >> 5;
        this.O0000oO0 = bArr6[9] & 31;
        if (bArr6.length == 12) {
            bArr = new byte[]{bArr6[11], bArr6[10]};
            this.O0000oO = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).getShort();
        } else {
            byte[] bArr7 = {bArr6[11], bArr6[10], bArr6[13], bArr6[12]};
            this.O0000oO = ByteBuffer.wrap(bArr7).order(ByteOrder.BIG_ENDIAN).getInt();
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
        a.z(this.O0000OoO, false, a.n("Publish Address: "), O00000oO);
        a.z(bArr5, false, a.n("App key index: "), O00000oO);
        String str3 = O00000oO;
        StringBuilder n3 = a.n("Credential Flag: ");
        n3.append(this.O0000o00);
        o00oo0oo00.O00000o(str3, n3.toString());
        String str4 = O00000oO;
        StringBuilder n4 = a.n("Publish TTL: ");
        n4.append(this.O0000o0);
        o00oo0oo00.O00000o(str4, n4.toString());
        String str5 = O00000oO;
        o00oo0oo00.O00000o(str5, "Publish Period: " + b3);
        String str6 = O00000oO;
        StringBuilder n5 = a.n("Publish Retransmit Count: ");
        n5.append(this.O0000o);
        o00oo0oo00.O00000o(str6, n5.toString());
        String str7 = O00000oO;
        StringBuilder n6 = a.n("Publish Publish Interval Steps: ");
        n6.append(this.O0000oO0);
        o00oo0oo00.O00000o(str7, n6.toString());
        a.z(bArr, false, a.n("Model Identifier: "), O00000oO);
    }

    public int O00000Oo() {
        return 32830;
    }

    public boolean O00000oO() {
        return this.O000000o == 0;
    }

    public byte[] O00000oo() {
        return this.O0000OoO;
    }

    public boolean O0000O0o() {
        return this.O0000o00;
    }

    public int O0000OOo() {
        return this.O0000o0;
    }

    public int O0000Oo() {
        return this.O0000o0o;
    }

    public int O0000Oo0() {
        return this.O0000o0O;
    }

    public int O0000OoO() {
        return this.O0000o;
    }

    public int O0000Ooo() {
        return this.O0000oO0;
    }

    public int O0000o00() {
        return this.O0000oO;
    }

    public int describeContents() {
        return 0;
    }

    public int k_() {
        return this.O0000Oo;
    }

    public final int l_() {
        return this.O0000Ooo;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.O00000o0);
    }
}
