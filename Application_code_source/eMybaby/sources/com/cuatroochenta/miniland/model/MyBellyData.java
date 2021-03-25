package com.cuatroochenta.miniland.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Calendar;
import java.util.Date;

public class MyBellyData implements Comparable<MyBellyData>, Parcelable {
    public static final Parcelable.Creator<MyBellyData> CREATOR = new Parcelable.Creator<MyBellyData>() {
        public MyBellyData createFromParcel(Parcel parcel) {
            return new MyBellyData(parcel);
        }

        public MyBellyData[] newArray(int i) {
            return new MyBellyData[i];
        }
    };
    public Date mDate = Calendar.getInstance().getTime();
    public String mDateString;
    public String mDescription;
    public Long mId;
    public String mImageUrl;
    public String mTitle;

    public MyBellyData(Parcel parcel) {
        this.mId = Long.valueOf(parcel.readLong());
        this.mDate = new Date(parcel.readLong());
        this.mTitle = parcel.readString();
        this.mDateString = parcel.readString();
        this.mImageUrl = parcel.readString();
        this.mDescription = parcel.readString();
    }

    public MyBellyData(Long l, String str, String str2, String str3, String str4) {
        this.mId = l;
        this.mTitle = str;
        this.mDateString = str3;
        this.mImageUrl = str4;
        this.mDescription = str2;
    }

    public int compareTo(MyBellyData myBellyData) {
        if (getId() == null || myBellyData.getId() == null) {
            return 0;
        }
        return myBellyData.getId().compareTo(getId());
    }

    public int describeContents() {
        return 0;
    }

    public Date getDate() {
        return this.mDate;
    }

    public String getDateString() {
        return this.mDateString;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public Long getId() {
        return this.mId;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setDate(Date date) {
        this.mDate = date;
    }

    public void setDateString(String str) {
        this.mDateString = str;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public void setId(Long l) {
        this.mId = l;
    }

    public void setImageUrl(String str) {
        this.mImageUrl = str;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mId.longValue());
        parcel.writeLong(this.mDate.getTime());
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mDateString);
        parcel.writeString(this.mImageUrl);
        parcel.writeString(this.mDescription);
    }
}
