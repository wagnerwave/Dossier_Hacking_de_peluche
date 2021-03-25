package com.tuya.smart.sdk.api;

import com.tuya.smart.android.user.api.IBooleanCallback;
import com.tuya.smart.sdk.bean.message.MessageBean;
import com.tuya.smart.sdk.bean.message.MessageListBean;
import com.tuya.smart.sdk.bean.message.MessageType;
import java.util.List;

public interface ITuyaMessage {
    void cancelAll();

    void deleteMessages(List<String> list, IBooleanCallback iBooleanCallback);

    void getMessageList(int i, int i2, long j, long j2, ITuyaDataCallback<MessageListBean> iTuyaDataCallback);

    void getMessageList(int i, int i2, ITuyaDataCallback<MessageListBean> iTuyaDataCallback);

    void getMessageList(ITuyaDataCallback<List<MessageBean>> iTuyaDataCallback);

    void getMessageListByMsgSrcId(int i, int i2, MessageType messageType, String str, ITuyaDataCallback<MessageListBean> iTuyaDataCallback);

    void getMessageListByMsgSrcId(int i, int i2, MessageType messageType, String str, boolean z, ITuyaDataCallback<MessageListBean> iTuyaDataCallback);

    void getMessageListByMsgType(int i, int i2, MessageType messageType, ITuyaDataCallback<MessageListBean> iTuyaDataCallback);

    void getMessageMaxTime(ITuyaDataCallback<Integer> iTuyaDataCallback);
}
