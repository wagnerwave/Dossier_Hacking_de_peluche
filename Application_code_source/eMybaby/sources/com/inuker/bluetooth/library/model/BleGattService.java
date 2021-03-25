package com.inuker.bluetooth.library.model;

import a.e.a.a.r.b;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequiresApi(18)
public class BleGattService implements Parcelable, Comparable {
    public static final Parcelable.Creator<BleGattService> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public ParcelUuid f4333a;

    /* renamed from: b  reason: collision with root package name */
    public List<BleGattCharacter> f4334b;

    public static class a implements Parcelable.Creator<BleGattService> {
        public Object createFromParcel(Parcel parcel) {
            return new BleGattService(parcel);
        }

        public Object[] newArray(int i) {
            return new BleGattService[i];
        }
    }

    public BleGattService(Parcel parcel) {
        this.f4333a = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
        this.f4334b = parcel.createTypedArrayList(BleGattCharacter.CREATOR);
    }

    public BleGattService(UUID uuid, Map<UUID, BluetoothGattCharacteristic> map) {
        this.f4333a = new ParcelUuid(uuid);
        for (BluetoothGattCharacteristic bleGattCharacter : map.values()) {
            f().add(new BleGattCharacter(bleGattCharacter));
        }
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return 1;
        }
        return g().compareTo(((BleGattService) obj).g());
    }

    public int describeContents() {
        return 0;
    }

    public List<BleGattCharacter> f() {
        if (this.f4334b == null) {
            this.f4334b = new ArrayList();
        }
        return this.f4334b;
    }

    public UUID g() {
        return this.f4333a.getUuid();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(b.o("Service: %s\n", this.f4333a));
        List<BleGattCharacter> f = f();
        int size = f.size();
        for (int i = 0; i < size; i++) {
            sb.append(b.o(">>> Character: %s", f.get(i)));
            if (i != size - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f4333a, i);
        parcel.writeTypedList(this.f4334b);
    }
}
