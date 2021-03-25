package com.tuya.smart.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.tuya.sdk.sigmesh.bean.AccessMessage;
import com.tuya.sdk.sigmesh.bean.DpCommandBean;
import com.tuya.smart.android.device.bean.BitmapSchemaBean;
import com.tuya.smart.android.device.bean.StringSchemaBean;
import java.util.ArrayList;

public class o000o00ooo extends o000o0o000 implements Parcelable {
    public static final int O000000o = 205;
    public static final String O00000Oo = "TuyaVendorModelStatus";
    public int O00000oO;
    public int O00000oo;
    public int O0000O0o;
    public byte[] O0000OOo;
    public ArrayList<DpCommandBean> O0000Oo;
    public int O0000Oo0;

    public o000o00ooo(@NonNull AccessMessage accessMessage, int i) {
        super(accessMessage, i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: byte} */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4, types: [int] */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object O000000o(byte[] r7, int r8) {
        /*
            r6 = this;
            r0 = 0
            if (r7 == 0) goto L_0x005d
            int r1 = r7.length
            if (r1 != 0) goto L_0x0007
            goto L_0x005d
        L_0x0007:
            if (r8 == 0) goto L_0x0059
            r1 = 0
            r2 = 1
            if (r8 == r2) goto L_0x004f
            r3 = 2
            r4 = 4
            if (r8 == r3) goto L_0x0046
            r5 = 3
            if (r8 == r5) goto L_0x0040
            if (r8 == r4) goto L_0x0039
            r5 = 5
            if (r8 == r5) goto L_0x001a
            goto L_0x005d
        L_0x001a:
            int r8 = r7.length
            if (r8 == r2) goto L_0x0024
            int r8 = r7.length
            if (r8 == r3) goto L_0x0024
            int r8 = r7.length
            if (r8 == r4) goto L_0x0024
            return r0
        L_0x0024:
            r8 = 0
        L_0x0025:
            int r0 = r7.length
            if (r1 >= r0) goto L_0x0034
            int r0 = r7.length
            int r0 = r0 - r2
            int r0 = r0 - r1
            byte r0 = r7[r0]
            int r3 = r1 * 8
            int r0 = r0 << r3
            int r8 = r8 + r0
            int r1 = r1 + 1
            goto L_0x0025
        L_0x0034:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r8)
            goto L_0x005d
        L_0x0039:
            byte r7 = r7[r1]
        L_0x003b:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r7)
            goto L_0x005d
        L_0x0040:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r7)
            goto L_0x005d
        L_0x0046:
            int r8 = r7.length
            if (r8 == r4) goto L_0x004a
            return r0
        L_0x004a:
            int r7 = com.tuya.smart.common.o00o0000oo.O0000oO(r7)
            goto L_0x003b
        L_0x004f:
            byte r7 = r7[r1]
            if (r7 == 0) goto L_0x0054
            r1 = 1
        L_0x0054:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            goto L_0x005d
        L_0x0059:
            java.lang.String r0 = com.tuya.smart.common.o00oo0o0oo.O000000o((byte[]) r7)
        L_0x005d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.o000o00ooo.O000000o(byte[], int):java.lang.Object");
    }

    public ArrayList<DpCommandBean> C_() {
        return this.O0000Oo;
    }

    public String O000000o(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "undefined" : BitmapSchemaBean.type : "enum" : StringSchemaBean.type : "value" : "bool" : "raw";
    }

    public void O000000o() {
        try {
            super.O000000o();
            this.O0000Oo = new ArrayList<>();
            this.O00000oO = this.O00000o[0];
            this.O00000oo = this.O00000o[1];
            int i = (this.O00000o[2] << 8) + this.O00000o[3];
            this.O0000O0o = i;
            byte[] bArr = new byte[i];
            this.O0000OOo = bArr;
            System.arraycopy(this.O00000o, 4, bArr, 0, i);
            this.O0000Oo0 = this.O00000o[this.O0000O0o + 4];
            o00oo0oo00.O000000o(O00000Oo, String.format("parameters length: %d ,version: %d , commandType: %d , dataLength: %d , checkSum: %d", new Object[]{Integer.valueOf(this.O00000o.length), Integer.valueOf(this.O00000oO), Integer.valueOf(this.O00000oo), Integer.valueOf(this.O0000O0o), Integer.valueOf(this.O0000Oo0)}));
            boolean z = false;
            int i2 = 0;
            while (!z) {
                byte b2 = this.O0000OOo[i2];
                byte b3 = this.O0000OOo[i2 + 1];
                int i3 = (this.O0000OOo[i2 + 2] << 8) + this.O0000OOo[i2 + 3];
                byte[] bArr2 = new byte[i3];
                int i4 = i2 + 4;
                System.arraycopy(this.O0000OOo, i4, bArr2, 0, i3);
                DpCommandBean dpCommandBean = new DpCommandBean();
                dpCommandBean.setDpId(String.valueOf(b2));
                dpCommandBean.setDpValue(O000000o(bArr2, b3));
                dpCommandBean.setDpType(O000000o(b3));
                this.O0000Oo.add(dpCommandBean);
                i2 = i4 + i3;
                if (i2 >= this.O0000OOo.length) {
                    z = true;
                }
            }
            o00oo0oo00.O000000o(O00000Oo, "dpData:" + this.O0000Oo.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
            o00oo0oo00.O00000Oo(O00000Oo, "parse vendor data exception !!");
        }
    }

    public int O00000Oo() {
        return 205;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.O00000o0);
    }
}
