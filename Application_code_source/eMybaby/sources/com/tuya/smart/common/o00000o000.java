package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.tuya.sdk.sigmesh.bean.AccessMessage;
import com.tuya.sdk.sigmesh.transport.ConfigStatusMessage;
import com.tuya.smart.android.blemesh.bean.Element;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class o00000o000 extends ConfigStatusMessage implements Parcelable {
    public static final String O00000oO = o00000o000.class.getSimpleName();
    public static final int O00000oo = 2;
    public static final int O0000O0o = 12;
    public static final Parcelable.Creator<o00000o000> O0000OOo = new Parcelable.Creator<o00000o000>() {
        /* renamed from: O000000o */
        public o00000o000 createFromParcel(Parcel parcel) {
            return new o00000o000((AccessMessage) parcel.readValue(AccessMessage.class.getClassLoader()));
        }

        /* renamed from: O000000o */
        public o00000o000[] newArray(int i) {
            return new o00000o000[i];
        }
    };
    public int O0000Oo;
    public int O0000Oo0;
    public int O0000OoO;
    public int O0000Ooo;
    public boolean O0000o;
    public boolean O0000o0;
    public int O0000o00;
    public boolean O0000o0O;
    public boolean O0000o0o;
    public Map<Integer, Element> O0000oO0 = new LinkedHashMap();

    public o00000o000(AccessMessage accessMessage) {
        super(accessMessage);
        this.O00000o = accessMessage.getParameters();
        O000000o();
    }

    private int O000000o(short s) {
        return ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN).putShort(s).getShort(0);
    }

    private void O000000o(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr;
        char c2 = 0;
        int i = 12;
        byte[] bArr4 = null;
        int i2 = 0;
        while (i < bArr3.length) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            byte b2 = (bArr3[i + 1] << 8) | bArr3[i];
            String str = O00000oO;
            StringBuilder n = a.n("Location identifier: ");
            Locale locale = Locale.US;
            Object[] objArr = new Object[1];
            objArr[c2] = Integer.valueOf(b2);
            n.append(String.format(locale, "%04X", objArr));
            o00oo0oo00.O00000o(str, n.toString());
            int i3 = i + 2;
            byte b3 = bArr3[i3];
            String str2 = O00000oO;
            StringBuilder n2 = a.n("Number of sig models: ");
            Locale locale2 = Locale.US;
            Object[] objArr2 = new Object[1];
            objArr2[c2] = Integer.valueOf(b3);
            n2.append(String.format(locale2, "%04X", objArr2));
            o00oo0oo00.O00000o(str2, n2.toString());
            int i4 = i3 + 1;
            byte b4 = bArr3[i4];
            String str3 = O00000oO;
            StringBuilder n3 = a.n("Number of vendor models: ");
            Locale locale3 = Locale.US;
            Object[] objArr3 = new Object[1];
            objArr3[c2] = Integer.valueOf(b4);
            n3.append(String.format(locale3, "%04X", objArr3));
            o00oo0oo00.O00000o(str3, n3.toString());
            i = i4 + 1;
            if (b3 > 0) {
                int i5 = 0;
                while (i5 < b3) {
                    int O000000o = o00o0000oo.O000000o(bArr3[i], bArr3[i + 1]);
                    linkedHashMap.put(Integer.valueOf(O000000o), oooooo000.O000000o(O000000o));
                    String str4 = O00000oO;
                    StringBuilder o = a.o("Sig model ID ", i5, " : ");
                    o.append(String.format(Locale.US, "%04X", new Object[]{Integer.valueOf(O000000o)}));
                    o00oo0oo00.O00000o(str4, o.toString());
                    i += 2;
                    i5++;
                    b3 = b3;
                }
            }
            if (b4 > 0) {
                for (int i6 = 0; i6 < b4; i6++) {
                    int O000000o2 = (o00o0000oo.O000000o(bArr3[i], bArr3[i + 1]) << 16) | o00o0000oo.O000000o(bArr3[i + 2], bArr3[i + 3]);
                    linkedHashMap.put(Integer.valueOf(O000000o2), new oooooo0o0(O000000o2));
                    String str5 = O00000oO;
                    StringBuilder o2 = a.o("Vendor - model ID ", i6, " : ");
                    o2.append(String.format(Locale.US, "%08X", new Object[]{Integer.valueOf(O000000o2)}));
                    o00oo0oo00.O00000o(str5, o2.toString());
                    i += 4;
                }
            }
            bArr4 = i2 == 0 ? bArr2 : o000oo0o0o.O000000o(bArr4);
            i2++;
            this.O0000oO0.put(Integer.valueOf(o000oo0o0o.O00000Oo(bArr4)), new Element(bArr4, b2, linkedHashMap));
            c2 = 0;
        }
    }

    private int O00000Oo(short s) {
        return ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN).putShort(s).getShort(0);
    }

    private int O00000o(short s) {
        return ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN).putShort(s).getShort(0);
    }

    private int O00000o0(short s) {
        return ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN).putShort(s).getShort(0);
    }

    private int O00000oO(short s) {
        return ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN).putShort(s).getShort(0);
    }

    private void O0000o00() {
        AccessMessage accessMessage = (AccessMessage) this.O00000o0;
        byte[] accessPdu = accessMessage.getAccessPdu();
        this.O0000Oo0 = o00o0000oo.O000000o(accessPdu[2], accessPdu[3]);
        String str = O00000oO;
        StringBuilder n = a.n("Company identifier: ");
        n.append(String.format(Locale.US, "%04X", new Object[]{Integer.valueOf(this.O0000Oo0)}));
        o00oo0oo00.O00000o(str, n.toString());
        this.O0000Oo = o00o0000oo.O000000o(accessPdu[4], accessPdu[5]);
        String str2 = O00000oO;
        StringBuilder n2 = a.n("Product identifier: ");
        n2.append(String.format(Locale.US, "%04X", new Object[]{Integer.valueOf(this.O0000Oo)}));
        o00oo0oo00.O00000o(str2, n2.toString());
        this.O0000OoO = o00o0000oo.O000000o(accessPdu[6], accessPdu[7]);
        String str3 = O00000oO;
        StringBuilder n3 = a.n("Version identifier: ");
        n3.append(String.format(Locale.US, "%04X", new Object[]{Integer.valueOf(this.O0000OoO)}));
        o00oo0oo00.O00000o(str3, n3.toString());
        this.O0000Ooo = o00o0000oo.O000000o(accessPdu[8], accessPdu[9]);
        String str4 = O00000oO;
        StringBuilder n4 = a.n("crpl: ");
        n4.append(String.format(Locale.US, "%04X", new Object[]{Integer.valueOf(this.O0000Ooo)}));
        o00oo0oo00.O00000o(str4, n4.toString());
        this.O0000o00 = o00o0000oo.O000000o(accessPdu[10], accessPdu[11]);
        String str5 = O00000oO;
        StringBuilder n5 = a.n("Features: ");
        n5.append(String.format(Locale.US, "%04X", new Object[]{Integer.valueOf(this.O0000o00)}));
        Log.v(str5, n5.toString());
        this.O0000o0 = o000ooo000.O000000o(this.O0000o00);
        String str6 = O00000oO;
        StringBuilder n6 = a.n("Relay feature: ");
        n6.append(this.O0000o0);
        Log.v(str6, n6.toString());
        this.O0000o0O = o000ooo000.O00000Oo(this.O0000o00);
        String str7 = O00000oO;
        StringBuilder n7 = a.n("Proxy feature: ");
        n7.append(this.O0000o0O);
        Log.v(str7, n7.toString());
        this.O0000o0o = o000ooo000.O00000o0(this.O0000o00);
        String str8 = O00000oO;
        StringBuilder n8 = a.n("Friend feature: ");
        n8.append(this.O0000o0o);
        Log.v(str8, n8.toString());
        this.O0000o = o000ooo000.O00000o(this.O0000o00);
        String str9 = O00000oO;
        StringBuilder n9 = a.n("Low power feature: ");
        n9.append(this.O0000o);
        Log.v(str9, n9.toString());
        O000000o(accessPdu, accessMessage.getSrc());
        String str10 = O00000oO;
        StringBuilder n10 = a.n("Number of elements: ");
        n10.append(this.O0000oO0.size());
        Log.v(str10, n10.toString());
    }

    public final void O000000o() {
        O0000o00();
    }

    public int O00000Oo() {
        return 2;
    }

    public int O00000oo() {
        return this.O0000Ooo;
    }

    public int O0000O0o() {
        return this.O0000o00;
    }

    public boolean O0000OOo() {
        return this.O0000o0;
    }

    public boolean O0000Oo() {
        return this.O0000o0o;
    }

    public boolean O0000Oo0() {
        return this.O0000o0O;
    }

    public boolean O0000OoO() {
        return this.O0000o;
    }

    public Map<Integer, Element> O0000Ooo() {
        return this.O0000oO0;
    }

    public int describeContents() {
        return 0;
    }

    public int e_() {
        return this.O0000Oo0;
    }

    public int f_() {
        return this.O0000Oo;
    }

    public int g_() {
        return this.O0000OoO;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.O00000o0);
    }
}
