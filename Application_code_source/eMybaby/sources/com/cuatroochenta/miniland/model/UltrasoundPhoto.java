package com.cuatroochenta.miniland.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

public class UltrasoundPhoto implements Parcelable {
    public static final Parcelable.Creator<UltrasoundPhoto> CREATOR = new Parcelable.Creator<UltrasoundPhoto>() {
        public UltrasoundPhoto createFromParcel(Parcel parcel) {
            return new UltrasoundPhoto(parcel);
        }

        public UltrasoundPhoto[] newArray(int i) {
            return new UltrasoundPhoto[i];
        }
    };
    public Date mDate;
    public String mDescription;
    public long mId;
    public String mPhotoPath;
    public String mTitle;

    public UltrasoundPhoto() {
    }

    public UltrasoundPhoto(Parcel parcel) {
        this.mId = parcel.readLong();
        this.mPhotoPath = parcel.readString();
        this.mTitle = parcel.readString();
        this.mDescription = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public long getId() {
        return this.mId;
    }

    public String getPhotoPath() {
        return this.mPhotoPath;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setDate(Date date) {
        this.mDate = date;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public void setId(long j) {
        this.mId = j;
    }

    public void setPhotoPath(String str) {
        this.mPhotoPath = str;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mId);
        parcel.writeString(this.mPhotoPath);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mDescription);
    }
}
