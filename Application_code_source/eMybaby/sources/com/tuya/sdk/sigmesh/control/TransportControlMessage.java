package com.tuya.sdk.sigmesh.control;

public abstract class TransportControlMessage {
    public static final String O000000o = "TransportControlMessage";

    public enum TransportControlMessageState {
        LOWER_TRANSPORT_BLOCK_ACKNOWLEDGEMENT(0);
        
        public int state;

        /* access modifiers changed from: public */
        TransportControlMessageState(int i) {
            this.state = i;
        }

        public int getState() {
            return this.state;
        }
    }

    public abstract TransportControlMessageState O000000o();
}
