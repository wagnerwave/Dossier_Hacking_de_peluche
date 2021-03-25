package com.tuya.smart.common;

import java.nio.ByteBuffer;
import java.util.List;

public class ooo0ooo0o extends oooo00000 {
    public static int O0000OoO = 204;
    public static int O0000Ooo = 205;
    public static final int O0000o0 = 22868;
    public List<String> O0000o00;

    public ooo0ooo0o(List<String> list) {
        super(oooooo000.O0000Oo0, 22868, O0000OoO, O0000Ooo, (byte[]) null);
        this.O0000o00 = list;
    }

    public byte[] O00000oO() {
        this.O00000Oo = o00o00000o.O00000o0(this.O000000o);
        ByteBuffer allocate = ByteBuffer.allocate(this.O0000o00.size() + 5);
        allocate.put((byte) 0);
        allocate.put((byte) 1);
        allocate.put(new byte[]{(byte) ((this.O0000o00.size() >> 8) & 255), (byte) (this.O0000o00.size() & 255)});
        for (String parseInt : this.O0000o00) {
            allocate.put((byte) (Integer.parseInt(parseInt) & 255));
        }
        allocate.put((byte) (o00o0000oo.O0000o0o(allocate.array()) % 256));
        return allocate.array();
    }

    public int O0000O0o() {
        return O0000Ooo;
    }
}
