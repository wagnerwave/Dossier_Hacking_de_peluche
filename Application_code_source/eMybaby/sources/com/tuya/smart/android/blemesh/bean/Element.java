package com.tuya.smart.android.blemesh.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.tuya.smart.common.o000o0oooo;
import com.tuya.smart.common.ooooo0ooo;
import com.tuya.smart.common.oooooo0o0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class Element implements Parcelable {
    public static final Parcelable.Creator<Element> CREATOR = new Parcelable.Creator<Element>() {
        public Element createFromParcel(Parcel parcel) {
            return new Element(parcel);
        }

        public Element[] newArray(int i) {
            return new Element[i];
        }
    };
    public byte[] elementAddress;
    public final int locationDescriptor;
    public final Map<Integer, o000o0oooo> meshModels;

    public Element(int i, Map<Integer, o000o0oooo> map) {
        this.locationDescriptor = i;
        this.meshModels = map;
    }

    public Element(Parcel parcel) {
        this.elementAddress = parcel.createByteArray();
        this.locationDescriptor = parcel.readInt();
        this.meshModels = new LinkedHashMap();
        sortModels(parcel.readHashMap(o000o0oooo.class.getClassLoader()));
    }

    public Element(byte[] bArr, int i, Map<Integer, o000o0oooo> map) {
        this.elementAddress = bArr;
        this.locationDescriptor = i;
        this.meshModels = map;
    }

    private void sortModels(HashMap<Integer, o000o0oooo> hashMap) {
        ArrayList arrayList = new ArrayList(hashMap.keySet());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            this.meshModels.put(Integer.valueOf(intValue), hashMap.get(Integer.valueOf(intValue)));
        }
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getElementAddress() {
        return this.elementAddress;
    }

    public int getElementAddressInt() {
        return ByteBuffer.wrap(this.elementAddress).order(ByteOrder.BIG_ENDIAN).getShort();
    }

    public int getLocationDescriptor() {
        return this.locationDescriptor;
    }

    public Map<Integer, o000o0oooo> getMeshModels() {
        return Collections.unmodifiableMap(this.meshModels);
    }

    public int getSigModelCount() {
        int i = 0;
        for (Map.Entry<Integer, o000o0oooo> value : this.meshModels.entrySet()) {
            if (value.getValue() instanceof ooooo0ooo) {
                i++;
            }
        }
        return i;
    }

    public int getVendorModelCount() {
        int i = 0;
        for (Map.Entry<Integer, o000o0oooo> value : this.meshModels.entrySet()) {
            if (value.getValue() instanceof oooooo0o0) {
                i++;
            }
        }
        return i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.elementAddress);
        parcel.writeInt(this.locationDescriptor);
        parcel.writeMap(this.meshModels);
    }
}
