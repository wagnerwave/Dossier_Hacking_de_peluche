package com.cuatroochenta.miniland.model;

import a.c.a.d.a;
import a.c.c.b;
import a.c.d.r.j;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompatJellybean;
import com.tuya.smart.home.sdk.bean.scene.ConditionExtraInfoBean;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

public class HeartBeatSound implements Parcelable {
    public static final Parcelable.Creator<HeartBeatSound> CREATOR = new Parcelable.Creator<HeartBeatSound>() {
        public HeartBeatSound createFromParcel(Parcel parcel) {
            return new HeartBeatSound(parcel);
        }

        public HeartBeatSound[] newArray(int i) {
            return new HeartBeatSound[i];
        }
    };
    public Date captureDate;
    public int duration;
    public ArrayList<TimeData> fhrValues;
    public int fileSize;
    public String id;
    public int kicksCount;
    public String localFile;
    public String mp3UrlFile;
    public String title;
    public String urlFile;

    public HeartBeatSound(Parcel parcel) {
        this.id = parcel.readString();
        long readLong = parcel.readLong();
        this.captureDate = readLong == -1 ? null : new Date(readLong);
        this.localFile = parcel.readString();
        this.title = parcel.readString();
        this.duration = parcel.readInt();
        this.urlFile = parcel.readString();
        this.mp3UrlFile = parcel.readString();
        this.fileSize = parcel.readInt();
        this.fhrValues = parcel.createTypedArrayList(TimeData.CREATOR);
    }

    public HeartBeatSound(Date date, String str, String str2, int i) {
        this.captureDate = date;
        this.localFile = str;
        this.title = str2;
        this.duration = i;
    }

    public HeartBeatSound(JSONObject jSONObject) {
        this.id = jSONObject.getString("id");
        this.title = jSONObject.getString(NotificationCompatJellybean.KEY_TITLE);
        try {
            this.captureDate = j.j.parse(jSONObject.getString("date"));
        } catch (ParseException e2) {
            e2.printStackTrace();
            this.captureDate = null;
        }
        this.duration = jSONObject.getInt(ConditionExtraInfoBean.CAL_TYPE_DURATION);
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has("kicks")) {
            JSONArray jSONArray = new JSONArray(jSONObject.getString("kicks"));
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(Double.valueOf(jSONArray.getDouble(i)));
            }
        }
        this.kicksCount = arrayList.size();
        this.fhrValues = new ArrayList<>();
        if (jSONObject.has("fhrs")) {
            JSONArray jSONArray2 = new JSONArray(jSONObject.getString("fhrs"));
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONArray jSONArray3 = jSONArray2.getJSONArray(i2);
                Double valueOf = Double.valueOf(jSONArray3.getDouble(0));
                TimeData timeData = new TimeData(Integer.valueOf(jSONArray3.getInt(1)).intValue(), valueOf.floatValue());
                timeData.setFetalMovement(arrayList.contains(valueOf));
                this.fhrValues.add(timeData);
            }
        }
        this.fileSize = jSONObject.optInt("filesize");
        this.urlFile = jSONObject.getString("file");
        this.mp3UrlFile = jSONObject.optString("file_mp3");
    }

    public int describeContents() {
        return 0;
    }

    public Date getCaptureDate() {
        return this.captureDate;
    }

    public String getCaptureDateFormatted() {
        return this.captureDate != null ? j.i.format(getCaptureDate()) : "";
    }

    public int getDuration() {
        return this.duration;
    }

    public String getDurationFormatted() {
        return a.e(getDuration());
    }

    public ArrayList<TimeData> getFhrValues() {
        return this.fhrValues;
    }

    public int getFileSize() {
        return this.fileSize;
    }

    public String getId() {
        return this.id;
    }

    public int getKicksCount() {
        return this.kicksCount;
    }

    public File getLocalFile() {
        return !a.j(this.urlFile) ? b.c().b(this.urlFile) : new File(this.localFile);
    }

    public String getLocalFilePath() {
        return this.localFile;
    }

    public String getMp3UrlFile() {
        return !a.j(this.mp3UrlFile) ? this.mp3UrlFile : this.urlFile;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrlFile() {
        return this.urlFile;
    }

    public void setMp3UrlFile(String str) {
        this.mp3UrlFile = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        Date date = this.captureDate;
        parcel.writeLong(date != null ? date.getTime() : -1);
        parcel.writeString(this.localFile);
        parcel.writeString(this.title);
        parcel.writeInt(this.duration);
        parcel.writeString(this.urlFile);
        parcel.writeString(this.mp3UrlFile);
        parcel.writeInt(this.fileSize);
        parcel.writeTypedList(this.fhrValues);
    }
}
