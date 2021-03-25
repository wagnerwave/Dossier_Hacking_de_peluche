package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.ParcelUuid;
import android.util.SparseArray;
import com.tutk.IOTC.AVFrame;
import com.tuya.spongycastle.math.ec.Tnaf;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class o00o000000 {
    public static final ParcelUuid O000000o = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    public static final int O00000Oo = 2;
    public static final int O00000o = 16;
    public static final int O00000o0 = 4;
    public static final int O00000oO = 1;
    public static final int O00000oo = 2;
    public static final int O0000O0o = 3;
    public static final int O0000OOo = 4;
    public static final int O0000Oo = 6;
    public static final int O0000Oo0 = 5;
    public static final int O0000OoO = 7;
    public static final int O0000Ooo = 8;
    public static final int O0000o = 33;
    public static final int O0000o0 = 10;
    public static final int O0000o00 = 9;
    public static final int O0000o0O = 22;
    public static final int O0000o0o = 32;
    public static final String O0000oO = "ScanRecordUtil";
    public static final int O0000oO0 = 255;

    public static int O000000o(byte[] bArr, int i, int i2, int i3, List<ParcelUuid> list) {
        while (i2 > 0) {
            list.add(O00000Oo(O000000o(bArr, i, i3)));
            i2 -= i3;
            i += i3;
        }
        return i;
    }

    public static List<ParcelUuid> O000000o(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int i = 0;
        ArrayList arrayList = new ArrayList();
        SparseArray sparseArray = new SparseArray();
        HashMap hashMap = new HashMap();
        while (true) {
            try {
                if (i < bArr.length) {
                    int i2 = i + 1;
                    byte b2 = bArr[i] & AVFrame.FRM_STATE_UNKOWN;
                    if (b2 != 0) {
                        int i3 = b2 - 1;
                        int i4 = i2 + 1;
                        byte b3 = bArr[i2] & AVFrame.FRM_STATE_UNKOWN;
                        int i5 = 16;
                        if (b3 != 22) {
                            if (b3 != 255) {
                                if (!(b3 == 32 || b3 == 33)) {
                                    switch (b3) {
                                        case 1:
                                            byte b4 = bArr[i4];
                                            break;
                                        case 2:
                                        case 3:
                                            O000000o(bArr, i4, i3, 2, arrayList);
                                            break;
                                        case 4:
                                        case 5:
                                            O000000o(bArr, i4, i3, 4, arrayList);
                                            break;
                                        case 6:
                                        case 7:
                                            O000000o(bArr, i4, i3, 16, arrayList);
                                            break;
                                        case 8:
                                        case 9:
                                            new String(O000000o(bArr, i4, i3));
                                            break;
                                        case 10:
                                            byte b5 = bArr[i4];
                                            break;
                                    }
                                }
                            } else {
                                sparseArray.put(((bArr[i4 + 1] & AVFrame.FRM_STATE_UNKOWN) << 8) + (255 & bArr[i4]), O000000o(bArr, i4 + 2, i3 - 2));
                            }
                            i = i3 + i4;
                        }
                        if (b3 == 32) {
                            i5 = 4;
                        } else if (b3 != 33) {
                            i5 = 2;
                        }
                        hashMap.put(O00000Oo(O000000o(bArr, i4, i5)), O000000o(bArr, i4 + i5, i3 - i5));
                        i = i3 + i4;
                    }
                }
            } catch (Exception unused) {
                StringBuilder n = a.n("unable to parse scan record: ");
                n.append(Arrays.toString(bArr));
                o00oo0oo00.O00000Oo(O0000oO, n.toString());
                return null;
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public static byte[] O000000o(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static ParcelUuid O00000Oo(byte[] bArr) {
        long j;
        if (bArr != null) {
            int length = bArr.length;
            if (length != 2 && length != 4 && length != 16) {
                throw new IllegalArgumentException(a.h("uuidBytes length invalid - ", length));
            } else if (length == 16) {
                ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                return new ParcelUuid(new UUID(order.getLong(8), order.getLong(0)));
            } else {
                if (length == 2) {
                    j = ((long) (bArr[0] & AVFrame.FRM_STATE_UNKOWN)) + ((long) ((bArr[1] & AVFrame.FRM_STATE_UNKOWN) << 8));
                } else {
                    j = ((long) ((bArr[3] & AVFrame.FRM_STATE_UNKOWN) << 24)) + ((long) (bArr[0] & AVFrame.FRM_STATE_UNKOWN)) + ((long) ((bArr[1] & AVFrame.FRM_STATE_UNKOWN) << 8)) + ((long) ((bArr[2] & AVFrame.FRM_STATE_UNKOWN) << Tnaf.POW_2_WIDTH));
                }
                return new ParcelUuid(new UUID(O000000o.getUuid().getMostSignificantBits() + (j << 32), O000000o.getUuid().getLeastSignificantBits()));
            }
        } else {
            throw new IllegalArgumentException("uuidBytes cannot be null");
        }
    }
}
