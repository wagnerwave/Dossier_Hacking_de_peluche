package com.tuya.smart.common;

import android.text.TextUtils;
import com.tuya.sdk.sigmesh.bean.DpCommandBean;
import com.tuya.smart.android.device.bean.BitmapSchemaBean;
import com.tuya.smart.android.device.bean.StringSchemaBean;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ooo0oooo0 extends oooo00000 {
    public static int O0000OoO = 201;
    public static int O0000Ooo = 205;
    public static final int O0000o0 = 22868;
    public static final String O0000o00 = "LightModeSetAction";
    public List<DpCommandBean> O0000o0O;

    public ooo0oooo0(List<DpCommandBean> list) {
        super(oooooo000.O0000Oo0, 22868, O0000OOo(), O0000Ooo, (byte[]) null);
        this.O0000o0O = list;
    }

    public static int O0000OOo() {
        return O0000OoO;
    }

    public byte[] O00000oO() {
        byte[] bArr;
        byte[] bArr2;
        byte[] O00000o;
        this.O00000Oo = o00o00000o.O00000o0(this.O000000o);
        ArrayList arrayList = new ArrayList();
        Iterator<DpCommandBean> it = this.O0000o0O.iterator();
        while (true) {
            byte b2 = 5;
            int i = 0;
            if (!it.hasNext()) {
                break;
            }
            DpCommandBean next = it.next();
            byte parseInt = (byte) (Integer.parseInt(next.dpId) & 255);
            String dpType = next.getDpType();
            if (TextUtils.equals(dpType, "bool")) {
                bArr = new byte[]{((Boolean) next.getDpValue()).booleanValue() ? (byte) 1 : 0};
                bArr2 = new byte[]{0, 1};
                b2 = 1;
            } else if (TextUtils.equals(dpType, "value")) {
                bArr = o00o0000oo.O00000o(((Integer) next.getDpValue()).intValue());
                bArr2 = new byte[]{0, 4};
                b2 = 2;
            } else {
                if (TextUtils.equals(dpType, StringSchemaBean.type)) {
                    b2 = 3;
                    O00000o = ((String) next.getDpValue()).getBytes();
                    bArr2 = new byte[]{(byte) ((O00000o.length >> 8) & 255), (byte) (255 & O00000o.length)};
                } else if (TextUtils.equals(dpType, "enum")) {
                    bArr = new byte[]{(byte) (((Integer) next.getDpValue()).intValue() & 255)};
                    bArr2 = new byte[]{0, 1};
                    b2 = 4;
                } else {
                    boolean equals = TextUtils.equals(dpType, BitmapSchemaBean.type);
                    Object dpValue = next.getDpValue();
                    if (equals) {
                        int intValue = ((Integer) dpValue).intValue();
                        if (intValue <= 255) {
                            bArr = new byte[]{(byte) (intValue & 255)};
                            bArr2 = new byte[]{0, 1};
                        } else if (intValue <= 65535) {
                            bArr = new byte[]{(byte) (255 & (intValue >> 8)), (byte) (intValue & 255)};
                            bArr2 = new byte[]{0, 2};
                        } else {
                            bArr2 = new byte[]{0, 4};
                            O00000o = o00o0000oo.O00000o(intValue);
                        }
                    } else {
                        byte[] O00000oO = o00oo0o0oo.O00000oO((String) dpValue);
                        byte[] bArr3 = new byte[2];
                        if (O00000oO == null) {
                            // fill-array-data instruction
                            bArr3[0] = 0;
                            bArr3[1] = 0;
                        } else {
                            bArr3[0] = (byte) ((O00000oO.length >> 8) & 255);
                            bArr3[1] = (byte) (O00000oO.length & 255);
                        }
                        bArr = O00000oO;
                        bArr2 = bArr3;
                        b2 = 0;
                    }
                }
                bArr = O00000o;
            }
            if (bArr != null) {
                i = bArr.length;
            }
            ByteBuffer allocate = ByteBuffer.allocate(i + 4);
            allocate.put(parseInt);
            allocate.put(b2);
            allocate.put(bArr2);
            if (bArr != null) {
                allocate.put(bArr);
            }
            arrayList.add(allocate);
        }
        ByteBuffer allocate2 = ByteBuffer.allocate(0);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            byte[] array = ((ByteBuffer) it2.next()).array();
            byte[] array2 = allocate2.array();
            if (array2 == null || array2.length == 0) {
                allocate2 = ByteBuffer.allocate(array.length);
                allocate2.put(array);
            } else {
                ByteBuffer allocate3 = ByteBuffer.allocate(array.length + array2.length);
                allocate3.put(array2);
                allocate3.put(array);
                allocate2 = allocate3;
            }
        }
        byte[] array3 = allocate2.array();
        ByteBuffer allocate4 = ByteBuffer.allocate(array3.length + 5);
        allocate4.put((byte) 0);
        allocate4.put((byte) 1);
        allocate4.put(new byte[]{(byte) ((array3.length >> 8) & 255), (byte) (array3.length & 255)});
        allocate4.put(array3);
        allocate4.put((byte) (o00o0000oo.O0000o0o(allocate4.array()) % 256));
        return allocate4.array();
    }

    public int O0000O0o() {
        return O0000Ooo;
    }
}
