package com.cuatroochenta.miniland.model;

import a.c.d.r.j;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
import org.json.JSONObject;

public class Contraction implements Parcelable, Comparable<Contraction> {
    public static final Parcelable.Creator<Contraction> CREATOR = new Parcelable.Creator<Contraction>() {
        public Contraction createFromParcel(Parcel parcel) {
            return new Contraction(parcel);
        }

        public Contraction[] newArray(int i) {
            return new Contraction[i];
        }
    };
    public Date date;
    public int duration;
    public String id;

    public Contraction(Parcel parcel) {
        this.id = parcel.readString();
        long readLong = parcel.readLong();
        this.date = readLong == -1 ? null : new Date(readLong);
        this.duration = parcel.readInt();
    }

    public Contraction(JSONObject jSONObject) {
        this.id = jSONObject.getString("id");
        this.date = j.j.parse(jSONObject.getString("date"));
        this.duration = jSONObject.getInt("seconds");
    }

    public int compareTo(Contraction contraction) {
        if (getDate() == null || contraction.getDate() == null) {
            return 0;
        }
        return contraction.getDate().compareTo(getDate());
    }

    public int describeContents() {
        return 0;
    }

    public Date getDate() {
        return this.date;
    }

    public String getDateFormatted() {
        return j.k.format(this.date);
    }

    public int getDuration() {
        return this.duration;
    }

    public String getId() {
        return this.id;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        Date date2 = this.date;
        parcel.writeLong(date2 != null ? date2.getTime() : -1);
        parcel.writeInt(this.duration);
    }
}
