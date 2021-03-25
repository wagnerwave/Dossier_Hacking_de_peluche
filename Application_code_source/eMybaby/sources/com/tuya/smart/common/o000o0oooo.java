package com.tuya.smart.common;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class o000o0oooo implements Parcelable {
    public final List<Integer> O00000Oo = new ArrayList();
    public final Map<Integer, o000o0o0o0> O00000o = new LinkedHashMap();
    public final Map<Integer, String> O00000o0 = new LinkedHashMap();
    public final List<byte[]> O00000oO = new ArrayList();
    public int O00000oo;
    public o000oooooo O0000O0o;

    public o000o0oooo() {
    }

    public o000o0oooo(int i) {
        this.O00000oo = i;
    }

    public o000o0oooo(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt >= -32768 && readInt <= 32767) {
            readInt = (short) readInt;
        }
        this.O00000oo = readInt;
        parcel.readList(this.O00000Oo, Integer.class.getClassLoader());
        O000000o((HashMap<Integer, o000o0o0o0>) parcel.readHashMap(o000o0o0o0.class.getClassLoader()));
        try {
            this.O0000O0o = (o000oooooo) parcel.readValue(o000oooooo.class.getClassLoader());
            parcel.readList(this.O00000oO, byte[].class.getClassLoader());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void O000000o(HashMap<Integer, o000o0o0o0> hashMap) {
        ArrayList arrayList = new ArrayList(hashMap.keySet());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            this.O00000o.put(Integer.valueOf(intValue), hashMap.get(Integer.valueOf(intValue)));
        }
    }

    private int O00000o(byte[] bArr) {
        int i = 0;
        for (byte[] equals : this.O00000oO) {
            if (Arrays.equals(equals, bArr)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private boolean O00000o0(byte[] bArr) {
        for (byte[] equals : this.O00000oO) {
            if (Arrays.equals(equals, bArr)) {
                return true;
            }
        }
        return false;
    }

    public abstract int O000000o();

    public void O000000o(int i) {
        if (this.O00000Oo.contains(Integer.valueOf(i))) {
            this.O00000Oo.remove(this.O00000Oo.indexOf(Integer.valueOf(i)));
        }
        this.O00000o.remove(Integer.valueOf(i));
    }

    public void O000000o(int i, o000o0o0o0 o000o0o0o0) {
        if (!this.O00000Oo.contains(Integer.valueOf(i))) {
            this.O00000Oo.add(Integer.valueOf(i));
        }
        this.O00000o.put(Integer.valueOf(i), o000o0o0o0);
    }

    public final void O000000o(Parcel parcel, int i) {
        parcel.writeInt(this.O00000oo);
        parcel.writeList(this.O00000Oo);
        parcel.writeMap(this.O00000o);
        parcel.writeValue(this.O0000O0o);
        parcel.writeList(this.O00000oO);
    }

    public void O000000o(byte[] bArr) {
        if (bArr != null && !O00000o0(bArr)) {
            this.O00000oO.add(bArr);
        }
    }

    public o000o0o0o0 O00000Oo(int i) {
        return this.O00000o.get(Integer.valueOf(i));
    }

    public abstract String O00000Oo();

    public void O00000Oo(byte[] bArr) {
        int O00000o2;
        if (bArr != null && (O00000o2 = O00000o(bArr)) > -1) {
            this.O00000oO.remove(O00000o2);
        }
    }

    public List<Integer> O00000oO() {
        return Collections.unmodifiableList(this.O00000Oo);
    }

    @Deprecated
    public Map<Integer, String> O00000oo() {
        return Collections.unmodifiableMap(this.O00000o0);
    }

    public Map<Integer, o000o0o0o0> O0000O0o() {
        return this.O00000o;
    }

    public List<byte[]> O0000OOo() {
        return Collections.unmodifiableList(this.O00000oO);
    }

    public List<byte[]> O0000Oo() {
        ArrayList arrayList = new ArrayList();
        for (byte[] next : this.O00000oO) {
            if (o00o0000oo.O0000Ooo(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public boolean O0000Oo0() {
        for (byte[] O0000Ooo : this.O00000oO) {
            if (o00o0000oo.O0000Ooo(O0000Ooo)) {
                return true;
            }
        }
        return false;
    }

    public List<byte[]> O0000OoO() {
        ArrayList arrayList = new ArrayList();
        for (byte[] next : this.O00000oO) {
            if (!o00o0000oo.O0000Ooo(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public o000oooooo O0000Ooo() {
        return this.O0000O0o;
    }
}
