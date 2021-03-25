package com.cuatroochenta.miniland.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

public class MedicalDataEntry implements Parcelable {
    public static final Parcelable.Creator<MedicalDataEntry> CREATOR = new Parcelable.Creator<MedicalDataEntry>() {
        public MedicalDataEntry createFromParcel(Parcel parcel) {
            return new MedicalDataEntry(parcel);
        }

        public MedicalDataEntry[] newArray(int i) {
            return new MedicalDataEntry[i];
        }
    };
    public float mAC;
    public Date mDate;
    public int mEFW;
    public float mFL;
    public float mHC;
    public long mId;
    public String mTitle;

    public MedicalDataEntry() {
    }

    public MedicalDataEntry(Parcel parcel) {
        this.mTitle = parcel.readString();
        this.mDate = new Date(parcel.readLong());
        this.mId = parcel.readLong();
        this.mAC = parcel.readFloat();
        this.mEFW = parcel.readInt();
        this.mFL = parcel.readFloat();
        this.mHC = parcel.readFloat();
    }

    public int describeContents() {
        return 0;
    }

    public float getAC() {
        return this.mAC;
    }

    public Date getDate() {
        return this.mDate;
    }

    public int getEFW() {
        return this.mEFW;
    }

    public float getFL() {
        return this.mFL;
    }

    public float getHC() {
        return this.mHC;
    }

    public long getId() {
        return this.mId;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setAC(float f) {
        this.mAC = f;
    }

    public void setDate(Date date) {
        this.mDate = date;
    }

    public void setEFW(int i) {
        this.mEFW = i;
    }

    public void setFL(float f) {
        this.mFL = f;
    }

    public void setHC(float f) {
        this.mHC = f;
    }

    public void setId(long j) {
        this.mId = j;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mTitle);
        parcel.writeLong(this.mDate.getTime());
        parcel.writeLong(this.mId);
        parcel.writeFloat(this.mAC);
        parcel.writeInt(this.mEFW);
        parcel.writeFloat(this.mFL);
        parcel.writeFloat(this.mHC);
    }
}
