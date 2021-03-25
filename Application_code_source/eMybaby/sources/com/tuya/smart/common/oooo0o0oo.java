package com.tuya.smart.common;

import a.a.a.a.a;
import android.util.Log;
import com.tuya.sdk.sigmesh.control.TransportControlMessage;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

public class oooo0o0oo extends TransportControlMessage {
    public static final String O000000o = "oooo0o0oo";

    public oooo0o0oo(byte[] bArr) {
    }

    public static int O000000o(int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i + 1; i3++) {
            i2 |= 1 << i3;
        }
        return i2;
    }

    public static Integer O000000o(Integer num, int i) {
        int intValue;
        String str;
        StringBuilder sb;
        if (num == null) {
            intValue = (1 << i) | 0;
            str = O000000o;
            sb = new StringBuilder();
        } else {
            intValue = num.intValue() | (1 << i);
            str = O000000o;
            sb = new StringBuilder();
        }
        sb.append("Block ack value: ");
        sb.append(intValue);
        Log.v(str, sb.toString());
        return Integer.valueOf(intValue);
    }

    public static ArrayList<Integer> O000000o(byte[] bArr, int i) {
        String str;
        StringBuilder sb;
        String str2;
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i2 = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).getInt();
        for (int i3 = 0; i3 < i; i3++) {
            if (((i2 >> i3) & 1) == 1) {
                str2 = O000000o;
                sb = a.o("Segment ", i3, " of ");
                sb.append(i - 1);
                str = " received by peer";
            } else {
                arrayList.add(Integer.valueOf(i3));
                str2 = O000000o;
                sb = a.o("Segment ", i3, " of ");
                sb.append(i - 1);
                str = " not received by peer";
            }
            sb.append(str);
            o00oo0oo00.O00000o(str2, sb.toString());
        }
        return arrayList;
    }

    public static boolean O00000Oo(Integer num, int i) {
        if (num == null) {
            return false;
        }
        String str = O000000o;
        Log.v(str, "Block ack: " + num);
        int intValue = num.intValue();
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (((intValue >> i3) & 1) == 1) {
                i2++;
            }
        }
        String str2 = O000000o;
        Log.v(str2, "bit count: " + i2);
        return i2 == i + 1;
    }

    public TransportControlMessage.TransportControlMessageState O000000o() {
        return TransportControlMessage.TransportControlMessageState.LOWER_TRANSPORT_BLOCK_ACKNOWLEDGEMENT;
    }
}
