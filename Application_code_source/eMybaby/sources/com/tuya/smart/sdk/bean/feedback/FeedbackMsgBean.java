package com.tuya.smart.sdk.bean.feedback;

import android.os.Parcel;
import android.os.Parcelable;

public class FeedbackMsgBean implements Parcelable {
    public static final Parcelable.Creator<FeedbackMsgBean> CREATOR = new Parcelable.Creator<FeedbackMsgBean>() {
        public FeedbackMsgBean createFromParcel(Parcel parcel) {
            FeedbackMsgBean feedbackMsgBean = new FeedbackMsgBean();
            int unused = feedbackMsgBean.id = parcel.readInt();
            String unused2 = feedbackMsgBean.content = parcel.readString();
            int unused3 = feedbackMsgBean.ctime = parcel.readInt();
            int unused4 = feedbackMsgBean.type = parcel.readInt();
            String unused5 = feedbackMsgBean.hdId = parcel.readString();
            int unused6 = feedbackMsgBean.hdType = parcel.readInt();
            return feedbackMsgBean;
        }

        public FeedbackMsgBean[] newArray(int i) {
            return new FeedbackMsgBean[0];
        }
    };
    public String content;
    public int ctime;
    public String hdId;
    public int hdType;
    public int id;
    public int type;

    public int describeContents() {
        return 0;
    }

    public String getContent() {
        return this.content;
    }

    public int getCtime() {
        return this.ctime;
    }

    public String getHdId() {
        return this.hdId;
    }

    public int getHdType() {
        return this.hdType;
    }

    public int getId() {
        return this.id;
    }

    public int getType() {
        return this.type;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCtime(int i) {
        this.ctime = i;
    }

    public void setHdId(String str) {
        this.hdId = str;
    }

    public void setHdType(int i) {
        this.hdType = i;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.content);
        parcel.writeInt(this.ctime);
        parcel.writeInt(this.type);
    }
}
