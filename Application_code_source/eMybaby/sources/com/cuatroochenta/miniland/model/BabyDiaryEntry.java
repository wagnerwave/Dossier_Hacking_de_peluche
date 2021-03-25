package com.cuatroochenta.miniland.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONObject;

public class BabyDiaryEntry implements Parcelable, Comparable<BabyDiaryEntry> {
    public static final Parcelable.Creator<BabyDiaryEntry> CREATOR = new Parcelable.Creator<BabyDiaryEntry>() {
        public BabyDiaryEntry createFromParcel(Parcel parcel) {
            return new BabyDiaryEntry(parcel);
        }

        public BabyDiaryEntry[] newArray(int i) {
            return new BabyDiaryEntry[i];
        }
    };
    public String mBody;
    public Date mDate;
    public long mId;
    public String mPhotoPath;
    public String mTitle;
    public int mWeek;

    public BabyDiaryEntry() {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        this.mDate = instance.getTime();
    }

    public BabyDiaryEntry(Parcel parcel) {
        this.mTitle = parcel.readString();
        this.mDate = new Date(parcel.readLong());
        this.mWeek = parcel.readInt();
        this.mId = parcel.readLong();
        this.mBody = parcel.readString();
        this.mPhotoPath = parcel.readString();
    }

    public BabyDiaryEntry(JSONObject jSONObject) {
    }

    public int compareTo(@NonNull BabyDiaryEntry babyDiaryEntry) {
        if (getDate() == null || babyDiaryEntry.getDate() == null) {
            return 0;
        }
        return babyDiaryEntry.getDate().compareTo(getDate());
    }

    public int describeContents() {
        return 0;
    }

    public String getCommentary() {
        return this.mBody;
    }

    public Date getDate() {
        return this.mDate;
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

    public int getWeek() {
        return this.mWeek;
    }

    public void setBody(String str) {
        this.mBody = str;
    }

    public void setDate(Date date) {
        this.mDate = date;
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

    public void setWeek(int i) {
        this.mWeek = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mTitle);
        parcel.writeLong(this.mDate.getTime());
        parcel.writeInt(this.mWeek);
        parcel.writeLong(this.mId);
        parcel.writeString(this.mBody);
        parcel.writeString(this.mPhotoPath);
    }
}
