package com.cuatroochenta.miniland.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TimeData implements Parcelable {
    public static final Parcelable.Creator<TimeData> CREATOR = new Parcelable.Creator<TimeData>() {
        public TimeData createFromParcel(Parcel parcel) {
            return new TimeData(parcel);
        }

        public TimeData[] newArray(int i) {
            return new TimeData[i];
        }
    };
    public boolean fetalMovement;
    public int heartRate;
    public float secondsElapsed;

    public TimeData(int i, float f) {
        this.heartRate = i;
        this.secondsElapsed = f;
    }

    public TimeData(Parcel parcel) {
        this.heartRate = parcel.readInt();
        this.secondsElapsed = parcel.readFloat();
        this.fetalMovement = parcel.readByte() != 0;
    }

    public int describeContents() {
        return 0;
    }

    public int getHeartRate() {
        return this.heartRate;
    }

    public float getSecondsElapsed() {
        return this.secondsElapsed;
    }

    public boolean isFetalMovement() {
        return this.fetalMovement;
    }

    public void setFetalMovement(boolean z) {
        this.fetalMovement = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.heartRate);
        parcel.writeFloat(this.secondsElapsed);
        parcel.writeByte(this.fetalMovement ? (byte) 1 : 0);
    }
}
