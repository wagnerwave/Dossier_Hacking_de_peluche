package com.inuker.bluetooth.library.model;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequiresApi(18)
public class BleGattProfile implements Parcelable {
    public static final Parcelable.Creator<BleGattProfile> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public List<BleGattService> f4332a;

    public static class a implements Parcelable.Creator<BleGattProfile> {
        public Object createFromParcel(Parcel parcel) {
            return new BleGattProfile(parcel);
        }

        public Object[] newArray(int i) {
            return new BleGattProfile[i];
        }
    }

    public BleGattProfile(Parcel parcel) {
        parcel.readTypedList(a(), BleGattService.CREATOR);
    }

    public BleGattProfile(Map<UUID, Map<UUID, BluetoothGattCharacteristic>> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : map.entrySet()) {
            BleGattService bleGattService = new BleGattService((UUID) next.getKey(), (Map) next.getValue());
            if (!arrayList.contains(bleGattService)) {
                arrayList.add(bleGattService);
            }
        }
        Collections.sort(arrayList);
        a().addAll(arrayList);
    }

    public List<BleGattService> a() {
        if (this.f4332a == null) {
            this.f4332a = new ArrayList();
        }
        return this.f4332a;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (BleGattService append : this.f4332a) {
            sb.append(append);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(a());
    }
}
