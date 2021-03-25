package com.tuya.smart.sdk.bean.message;

public class MessageBean {
    public static final int MSG_TYPE_NEW_DEVICE = 1;
    public static final int MSG_TYPE_NEW_FRIEND = 2;
    public static final int MSG_TYPE_PRD_WARN = 4;
    public static final int MSG_TYPE_SYSTEM = 0;
    public String actionURL;
    public int alarmType;
    public String attachPics;
    public boolean choose;
    public String dateTime;
    public String encryptKey;
    public boolean hasNotRead;
    public String icon;
    public String id;
    public MessageAttach messageAttach;
    public String msgContent;
    public String msgSrcId;
    public int msgType;
    public String msgTypeContent;
    public long time;

    public String getActionURL() {
        return this.actionURL;
    }

    public int getAlarmType() {
        return this.alarmType;
    }

    public String getAttachPics() {
        return this.attachPics;
    }

    public String getDateTime() {
        return this.dateTime;
    }

    public String getEncryptKey() {
        return this.encryptKey;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getId() {
        return this.id;
    }

    public MessageAttach getMessageAttach() {
        return this.messageAttach;
    }

    public String getMsgContent() {
        return this.msgContent;
    }

    public String getMsgSrcId() {
        return this.msgSrcId;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public String getMsgTypeContent() {
        return this.msgTypeContent;
    }

    public long getTime() {
        return this.time;
    }

    public boolean isChoose() {
        return this.choose;
    }

    public boolean isHasNotRead() {
        return this.hasNotRead;
    }

    public void setActionURL(String str) {
        this.actionURL = str;
    }

    public void setAlarmType(int i) {
        this.alarmType = i;
    }

    public void setAttachPics(String str) {
        this.attachPics = str;
    }

    public void setChoose(boolean z) {
        this.choose = z;
    }

    public void setDateTime(String str) {
        this.dateTime = str;
    }

    public void setEncryptKey(String str) {
        this.encryptKey = str;
    }

    public void setHasNotRead(boolean z) {
        this.hasNotRead = z;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMessageAttach(MessageAttach messageAttach2) {
        this.messageAttach = messageAttach2;
    }

    public void setMsgContent(String str) {
        this.msgContent = str;
    }

    public void setMsgSrcId(String str) {
        this.msgSrcId = str;
    }

    public void setMsgType(int i) {
        this.msgType = i;
    }

    public void setMsgTypeContent(String str) {
        this.msgTypeContent = str;
    }

    public void setTime(long j) {
        this.time = j;
    }
}
