package com.tuya.smart.common;

import a.j.a.b;
import com.tuya.smart.common.o00o0o0o0o;

public class o00o0oo000 extends o00o0o0o0o {
    public final boolean O000000o;
    public int O00000Oo;
    public int O00000o;
    public int O00000o0;
    public String O00000oO;
    public byte[] O00000oo;

    public o00o0oo000(o00oo00000 o00oo00000) {
        this.O00000o0 = o00oo00000.O00000o();
        this.O00000o = o00oo00000.O00000oo();
        this.O00000oO = o00oo00000.O000000o();
        this.O00000oo = o00oo00000.O00000Oo();
        this.O00000Oo = o00oo00000.O0000O0o();
        this.O000000o = o00oo00000.O00000o0();
    }

    public void O000000o(o00o0o0o0o.O000000o o000000o) {
        o00o0ooooo o00o0ooooo = new o00o0ooooo();
        int i = this.O00000Oo;
        o00o0ooooo.O00000Oo(new byte[]{1, (byte) (i & 255), (byte) ((i >> 8) & 255)}).O000000o(this.O00000o0).O000000o(b.BLE_GATT_OP_CTRL_D7.f()).O000000o(this.O00000oO).O000000o(this.O00000oo).O000000o(this.O000000o).O00000Oo(this.O00000o).O000000o(o000000o).O0000OOo().O000000o();
    }

    public byte[] O000000o() {
        o00o0ooooo o00o0ooooo = new o00o0ooooo();
        int i = this.O00000Oo;
        return o00o0ooooo.O00000Oo(new byte[]{1, (byte) (i & 255), (byte) ((i >> 8) & 255)}).O000000o(this.O00000o0).O000000o(b.BLE_GATT_OP_CTRL_D7.f()).O00000Oo(this.O00000o).O0000OOo().O00000o0();
    }

    public void O00000Oo(o00o0o0o0o.O000000o o000000o) {
        o00o0ooooo o00o0ooooo = new o00o0ooooo();
        int i = this.O00000Oo;
        o00o0ooooo.O00000Oo(new byte[]{0, (byte) (i & 255), (byte) ((i >> 8) & 255)}).O000000o(this.O00000o0).O000000o(b.BLE_GATT_OP_CTRL_D7.f()).O000000o(this.O00000oO).O000000o(this.O00000oo).O000000o(this.O000000o).O00000Oo(this.O00000o).O000000o(o000000o).O0000OOo().O000000o();
    }

    public byte[] O00000Oo() {
        o00o0ooooo o00o0ooooo = new o00o0ooooo();
        int i = this.O00000Oo;
        return o00o0ooooo.O00000Oo(new byte[]{0, (byte) (i & 255), (byte) ((i >> 8) & 255)}).O000000o(this.O00000o0).O000000o(b.BLE_GATT_OP_CTRL_D7.f()).O00000Oo(this.O00000o).O0000OOo().O00000o0();
    }
}
