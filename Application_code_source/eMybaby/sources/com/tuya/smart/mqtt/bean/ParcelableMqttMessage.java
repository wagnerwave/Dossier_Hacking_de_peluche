package com.tuya.smart.mqtt.bean;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.a.a.o;

public class ParcelableMqttMessage extends o implements Parcelable {
    public static final Parcelable.Creator<ParcelableMqttMessage> CREATOR = new Parcelable.Creator<ParcelableMqttMessage>() {
        public ParcelableMqttMessage createFromParcel(Parcel parcel) {
            return new ParcelableMqttMessage(parcel);
        }

        public ParcelableMqttMessage[] newArray(int i) {
            return new ParcelableMqttMessage[i];
        }
    };
    public String messageId = null;

    public ParcelableMqttMessage(Parcel parcel) {
        super(parcel.createByteArray());
        setQos(parcel.readInt());
        boolean[] createBooleanArray = parcel.createBooleanArray();
        setRetained(createBooleanArray[0]);
        setDuplicate(createBooleanArray[1]);
        this.messageId = parcel.readString();
    }

    public ParcelableMqttMessage(o oVar) {
        super(oVar.getPayload());
        setQos(oVar.getQos());
        setRetained(oVar.isRetained());
        setDuplicate(oVar.isDuplicate());
    }

    public int describeContents() {
        return 0;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(getPayload());
        parcel.writeInt(getQos());
        parcel.writeBooleanArray(new boolean[]{isRetained(), isDuplicate()});
        parcel.writeString(this.messageId);
    }
}
