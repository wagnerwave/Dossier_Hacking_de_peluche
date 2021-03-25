package com.tuya.smart.mqtt;

import e.b.a.a.a.o;
import java.util.Iterator;

public interface MessageStore {

    public interface StoredMessage {
        String getClientHandle();

        o getMessage();

        String getMessageId();

        String getTopic();
    }

    void clearArrivedMessages(String str);

    void close();

    boolean discardArrived(String str, String str2);

    Iterator<StoredMessage> getAllArrivedMessages(String str);

    String storeArrived(String str, String str2, o oVar);
}
