package com.cuatroochenta.miniland.model;

import a.c.a.d.a;
import a.c.a.f.b;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompatJellybean;
import com.tuya.smart.home.sdk.bean.scene.ConditionExtraInfoBean;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class Song implements Parcelable {
    public static final Parcelable.Creator<Song> CREATOR = new Parcelable.Creator<Song>() {
        public Song createFromParcel(Parcel parcel) {
            return new Song(parcel);
        }

        public Song[] newArray(int i) {
            return new Song[i];
        }
    };
    public static int DEVICE_TYPE = 1;
    public static int SERVER_TYPE;
    public int duration;
    public boolean favourite;
    public long fileSize;
    public String id;
    public Uri source;
    public String title;
    public int type;
    public String urlFile;
    public String urlImage;

    public Song(int i, Uri uri) {
        this.type = i;
        this.source = uri;
        this.id = b.c(uri.toString());
    }

    public Song(Parcel parcel) {
        this.id = parcel.readString();
        this.title = parcel.readString();
        this.urlFile = parcel.readString();
        this.urlImage = parcel.readString();
        this.duration = parcel.readInt();
        this.type = parcel.readInt();
        this.source = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.fileSize = parcel.readLong();
        this.favourite = parcel.readByte() != 0;
    }

    public Song(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.id = jSONObject.getString("id");
            this.title = jSONObject.has(NotificationCompatJellybean.KEY_TITLE) ? jSONObject.getString(NotificationCompatJellybean.KEY_TITLE) : "";
            String str = null;
            this.urlFile = jSONObject.has("file") ? jSONObject.getString("file") : null;
            this.urlImage = jSONObject.has("icon") ? jSONObject.getString("icon") : str;
            boolean z = false;
            this.duration = jSONObject.has(ConditionExtraInfoBean.CAL_TYPE_DURATION) ? jSONObject.getInt(ConditionExtraInfoBean.CAL_TYPE_DURATION) : 0;
            this.fileSize = jSONObject.has("filesize") ? jSONObject.getLong("filesize") : 0;
            this.favourite = jSONObject.has("favorite") ? jSONObject.getBoolean("favorite") : z;
            setType(SERVER_TYPE);
            return;
        }
        throw new JSONException("Error while parsing Song Object. Source empty");
    }

    public int describeContents() {
        return 0;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getDurationFormatted() {
        return a.e(getDuration());
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getId() {
        return this.id;
    }

    public Uri getSource() {
        if (getType() == SERVER_TYPE && !a.j(getUrlFile())) {
            File b2 = a.c.c.b.c().b(getUrlFile());
            if (b2.exists()) {
                return Uri.fromFile(b2);
            }
        }
        return this.source;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String getUrlFile() {
        return this.urlFile;
    }

    public String getUrlImage() {
        return this.urlImage;
    }

    public boolean isFavourite() {
        return this.favourite;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setFavourite(boolean z) {
        this.favourite = z;
    }

    public void setFileSize(long j) {
        this.fileSize = j;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setSource(Uri uri) {
        this.source = uri;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUrlFile(String str) {
        this.urlFile = str;
    }

    public void setUrlImage(String str) {
        this.urlImage = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.urlFile);
        parcel.writeString(this.urlImage);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.type);
        parcel.writeParcelable(this.source, 0);
        parcel.writeLong(this.fileSize);
        parcel.writeByte(this.favourite ? (byte) 1 : 0);
    }
}
