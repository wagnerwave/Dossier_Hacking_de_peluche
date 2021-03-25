package com.cuatroochenta.miniland.model;

import a.c.a.d.a;
import a.c.d.r.j;
import android.os.Parcel;
import android.os.Parcelable;
import com.sozpic.miniland.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;
import org.json.JSONObject;

public class MedicalAppointment implements Parcelable {
    public static final Parcelable.Creator<MedicalAppointment> CREATOR = new Parcelable.Creator<MedicalAppointment>() {
        public MedicalAppointment createFromParcel(Parcel parcel) {
            return new MedicalAppointment(parcel);
        }

        public MedicalAppointment[] newArray(int i) {
            return new MedicalAppointment[i];
        }
    };
    public static final int TYPE_ANALYTICS = 3;
    public static final int TYPE_BIRTH_PREPARATION = 4;
    public static final int TYPE_GYNECOLOGIST = 2;
    public static final int TYPE_MIDWIFE = 1;
    public static final int TYPE_MONITORS = 5;
    public static final int TYPE_OTHERS = 6;
    public Date mDate;
    public String mDoctor;
    public long mId;
    public String mObservation;
    public String mPlace;
    public int mType;
    public String typeString;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AppointmentType {
    }

    public MedicalAppointment() {
    }

    public MedicalAppointment(Parcel parcel) {
        this.mType = parcel.readInt();
        this.typeString = parcel.readString();
        this.mPlace = parcel.readString();
        long readLong = parcel.readLong();
        this.mDate = readLong == -1 ? null : new Date(readLong);
        this.mObservation = parcel.readString();
        this.mId = parcel.readLong();
        this.mDoctor = parcel.readString();
    }

    public MedicalAppointment(JSONObject jSONObject) {
        setId(jSONObject.optLong("id"));
        setDate(j.j.parse(jSONObject.optString("fecha")));
        setDoctor(jSONObject.optString("doctor"));
        setPlace(jSONObject.optString("lugar"));
        setObservation(jSONObject.optString("observaciones"));
        setTypeString(jSONObject.optString("tipo"));
    }

    public int describeContents() {
        return 0;
    }

    public Date getDate() {
        return this.mDate;
    }

    public String getDoctor() {
        return this.mDoctor;
    }

    public long getId() {
        return this.mId;
    }

    public String getObservation() {
        return this.mObservation;
    }

    public String getPlace() {
        return this.mPlace;
    }

    public int getType() {
        int i = this.mType;
        if (i < 1 || i > 6) {
            return 6;
        }
        return i;
    }

    public String getTypeAsString() {
        if (!a.j(this.typeString)) {
            return this.typeString;
        }
        int i = this.mType;
        return a.h(i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? R.string.TR_OTROS : R.string.TR_MONITORES : R.string.TR_CLASES_DE_PREPARACION_AL_PARTO : R.string.TR_ANALITICA : R.string.TR_GINECOLOGO : R.string.TR_MATRONA);
    }

    public void setDate(Date date) {
        this.mDate = date;
    }

    public void setDoctor(String str) {
        this.mDoctor = str;
    }

    public void setId(long j) {
        this.mId = j;
    }

    public void setObservation(String str) {
        this.mObservation = str;
    }

    public void setPlace(String str) {
        this.mPlace = str;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void setTypeString(String str) {
        this.typeString = str;
        setType(a.h(R.string.TR_ANALITICA).equals(str) ? 3 : a.h(R.string.TR_MATRONA).equals(str) ? 1 : a.h(R.string.TR_CLASES_DE_PREPARACION_AL_PARTO).equals(str) ? 4 : a.h(R.string.TR_GINECOLOGO).equals(str) ? 2 : a.h(R.string.TR_MONITORES).equals(str) ? 5 : 6);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mType);
        parcel.writeString(this.typeString);
        parcel.writeString(this.mPlace);
        Date date = this.mDate;
        parcel.writeLong(date != null ? date.getTime() : -1);
        parcel.writeString(this.mObservation);
        parcel.writeLong(this.mId);
        parcel.writeString(this.mDoctor);
    }
}
