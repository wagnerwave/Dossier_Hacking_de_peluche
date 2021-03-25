package com.tuya.smart.android.device.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class AlarmTimerBean implements Parcelable {
    public static final Parcelable.Creator<AlarmTimerBean> CREATOR = new Parcelable.Creator<AlarmTimerBean>() {
        public AlarmTimerBean createFromParcel(Parcel parcel) {
            AlarmTimerBean alarmTimerBean = new AlarmTimerBean();
            String unused = alarmTimerBean.loops = parcel.readString();
            int unused2 = alarmTimerBean.status = parcel.readInt();
            long unused3 = alarmTimerBean.id = parcel.readLong();
            String unused4 = alarmTimerBean.time = parcel.readString();
            String unused5 = alarmTimerBean.value = parcel.readString();
            String unused6 = alarmTimerBean.groupId = parcel.readString();
            String unused7 = alarmTimerBean.timezoneId = parcel.readString();
            return alarmTimerBean;
        }

        public AlarmTimerBean[] newArray(int i) {
            return new AlarmTimerBean[i];
        }
    };
    public static final int ENABLED = 1;
    public static final String MODE_REPEAT_CUSTOM = "1011110";
    public static final String MODE_REPEAT_EVEVRYDAY = "1111111";
    public static final String MODE_REPEAT_ONCE = "0000000";
    public static final String MODE_REPEAT_WEEKDAY = "0111110";
    public static final String MODE_REPEAT_WEEKEND = "1000001";
    public static final int UNENABLED = 0;
    public static final boolean VALUE_ENABLED = true;
    public static final boolean VALUE_UNENABLED = false;
    public String groupId;
    public long id;
    public String loops = MODE_REPEAT_ONCE;
    public int status = 1;
    public String time = "08:00";
    public String timezoneId;
    public String value;

    public int describeContents() {
        return 0;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public long getId() {
        return this.id;
    }

    public String getLoops() {
        return this.loops;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTime() {
        return this.time;
    }

    public String getTimezoneId() {
        return this.timezoneId;
    }

    public String getValue() {
        return this.value;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setLoops(String str) {
        this.loops = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public void setTimezoneId(String str) {
        this.timezoneId = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.loops);
        parcel.writeInt(this.status);
        parcel.writeLong(this.id);
        parcel.writeString(this.time);
        parcel.writeString(this.value);
        parcel.writeString(this.groupId);
        parcel.writeString(this.timezoneId);
    }
}
