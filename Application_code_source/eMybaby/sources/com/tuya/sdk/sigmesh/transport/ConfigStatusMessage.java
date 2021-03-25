package com.tuya.sdk.sigmesh.transport;

import com.tuya.sdk.sigmesh.bean.AccessMessage;
import com.tuya.smart.common.o000o0ooo0;

public abstract class ConfigStatusMessage extends o000o0ooo0 {
    public int O000000o;
    public String O00000Oo;

    /* renamed from: com.tuya.sdk.sigmesh.transport.ConfigStatusMessage$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] O000000o;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x0091 */
        static {
            /*
                com.tuya.sdk.sigmesh.transport.ConfigStatusMessage$StatusCodeNames[] r0 = com.tuya.sdk.sigmesh.transport.ConfigStatusMessage.StatusCodeNames.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                O000000o = r0
                r1 = 1
                com.tuya.sdk.sigmesh.transport.ConfigStatusMessage$StatusCodeNames r2 = com.tuya.sdk.sigmesh.transport.ConfigStatusMessage.StatusCodeNames.SUCCESS     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = O000000o     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.tuya.sdk.sigmesh.transport.ConfigStatusMessage$StatusCodeNames r3 = com.tuya.sdk.sigmesh.transport.ConfigStatusMessage.StatusCodeNames.INVALID_ADDRESS     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = O000000o     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tuya.sdk.sigmesh.transport.ConfigStatusMessage$StatusCodeNames r3 = com.tuya.sdk.sigmesh.transport.ConfigStatusMessage.StatusCodeNames.INVALID_MODEL     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r0 = 4
                int[] r2 = O000000o     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.tuya.sdk.sigmesh.transport.ConfigStatusMessage$StatusCodeNames r3 = com.tuya.sdk.sigmesh.transport.ConfigStatusMessage.StatusCodeNames.INVALID_APPKEY_INDEX     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                r1 = 5
                int[] r2 = O000000o     // Catch:{ NoSuchFieldError -> 0x002b }
                com.tuya.sdk.sigmesh.transport.ConfigStatusMessage$StatusCodeNames r3 = com.tuya.sdk.sigmesh.transport.ConfigStatusMessage.StatusCodeNames.INVALID_NETKEY_INDEX     // Catch:{ NoSuchFieldError -> 0x002b }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                r0 = 6
                int[] r2 = O000000o     // Catch:{ NoSuchFieldError -> 0x0032 }
                com.tuya.sdk.sigmesh.transport.ConfigStatusMessage$StatusCodeNames r3 = com.tuya.sdk.sigmesh.transport.ConfigStatusMessage.StatusCodeNames.INSUFFICIENT_RESOURCES     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                r1 = 7
                int[] r2 = O000000o     // Catch:{ NoSuchFieldError -> 0x0039 }
                com.tuya.sdk.sigmesh.transport.ConfigStatusMessage$StatusCodeNames r3 = com.tuya.sdk.sigmesh.transport.ConfigStatusMessage.StatusCodeNames.KEY_INDEX_ALREADY_STORED     // Catch:{ NoSuchFieldError -> 0x0039 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                r0 = 8
                int[] r2 = O000000o     // Catch:{ NoSuchFieldError -> 0x0041 }
                com.tuya.sdk.sigmesh.transport.ConfigStatusMessage$StatusCodeNames r3 = com.tuya.sdk.sigmesh.transport.ConfigStatusMessage.StatusCodeNames.INVALID_PUBLISH_PARAMETERS     // Catch:{ NoSuchFieldError -> 0x0041 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0041 }
            L_0x0041:
                r1 = 9
                int[] r2 = O000000o     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.tuya.sdk.sigmesh.transport.ConfigStatusMessage$StatusCodeNames r3 = com.tuya.sdk.sigmesh.transport.ConfigStatusMessage.StatusCodeNames.NOT_A_SUBSCRIBE_MODEL     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r0 = 10
                int[] r2 = O000000o     // Catch:{ NoSuchFieldError -> 0x0051 }
                com.tuya.sdk.sigmesh.transport.ConfigStatusMessage$StatusCodeNames r3 = com.tuya.sdk.sigmesh.transport.ConfigStatusMessage.StatusCodeNames.STORAGE_FAILURE     // Catch:{ NoSuchFieldError -> 0x0051 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0051 }
            L_0x0051:
                r1 = 11
                int[] r2 = O000000o     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.tuya.sdk.sigmesh.transport.ConfigStatusMessage$StatusCodeNames r3 = com.tuya.sdk.sigmesh.transport.ConfigStatusMessage.StatusCodeNames.FEATURE_NOT_SUPPORTED     // Catch:{ NoSuchFieldError -> 0x0059 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                r0 = 12
                int[] r2 = O000000o     // Catch:{ NoSuchFieldError -> 0x0061 }
                com.tuya.sdk.sigmesh.transport.ConfigStatusMessage$StatusCodeNames r3 = com.tuya.sdk.sigmesh.transport.ConfigStatusMessage.StatusCodeNames.CANNOT_UPDATE     // Catch:{ NoSuchFieldError -> 0x0061 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0061 }
            L_0x0061:
                r1 = 13
                int[] r2 = O000000o     // Catch:{ NoSuchFieldError -> 0x0069 }
                com.tuya.sdk.sigmesh.transport.ConfigStatusMessage$StatusCodeNames r3 = com.tuya.sdk.sigmesh.transport.ConfigStatusMessage.StatusCodeNames.CANNOT_REMOVE     // Catch:{ NoSuchFieldError -> 0x0069 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0069 }
            L_0x0069:
                r0 = 14
                int[] r2 = O000000o     // Catch:{ NoSuchFieldError -> 0x0071 }
                com.tuya.sdk.sigmesh.transport.ConfigStatusMessage$StatusCodeNames r3 = com.tuya.sdk.sigmesh.transport.ConfigStatusMessage.StatusCodeNames.CANNOT_BIND     // Catch:{ NoSuchFieldError -> 0x0071 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                r1 = 15
                int[] r2 = O000000o     // Catch:{ NoSuchFieldError -> 0x0079 }
                com.tuya.sdk.sigmesh.transport.ConfigStatusMessage$StatusCodeNames r3 = com.tuya.sdk.sigmesh.transport.ConfigStatusMessage.StatusCodeNames.TEMPORARILY_UNABLE_TO_CHANGE_STATE     // Catch:{ NoSuchFieldError -> 0x0079 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0079 }
            L_0x0079:
                r0 = 16
                int[] r2 = O000000o     // Catch:{ NoSuchFieldError -> 0x0081 }
                com.tuya.sdk.sigmesh.transport.ConfigStatusMessage$StatusCodeNames r3 = com.tuya.sdk.sigmesh.transport.ConfigStatusMessage.StatusCodeNames.CANNOT_SET     // Catch:{ NoSuchFieldError -> 0x0081 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0081 }
            L_0x0081:
                r1 = 17
                int[] r2 = O000000o     // Catch:{ NoSuchFieldError -> 0x0089 }
                com.tuya.sdk.sigmesh.transport.ConfigStatusMessage$StatusCodeNames r3 = com.tuya.sdk.sigmesh.transport.ConfigStatusMessage.StatusCodeNames.UNSPECIFIED_ERROR     // Catch:{ NoSuchFieldError -> 0x0089 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0089 }
            L_0x0089:
                r0 = 18
                int[] r2 = O000000o     // Catch:{ NoSuchFieldError -> 0x0091 }
                com.tuya.sdk.sigmesh.transport.ConfigStatusMessage$StatusCodeNames r3 = com.tuya.sdk.sigmesh.transport.ConfigStatusMessage.StatusCodeNames.INVALID_BINDING     // Catch:{ NoSuchFieldError -> 0x0091 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0091 }
            L_0x0091:
                int[] r1 = O000000o     // Catch:{ NoSuchFieldError -> 0x0099 }
                com.tuya.sdk.sigmesh.transport.ConfigStatusMessage$StatusCodeNames r2 = com.tuya.sdk.sigmesh.transport.ConfigStatusMessage.StatusCodeNames.RFU     // Catch:{ NoSuchFieldError -> 0x0099 }
                r2 = 19
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0099 }
            L_0x0099:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tuya.sdk.sigmesh.transport.ConfigStatusMessage.AnonymousClass1.<clinit>():void");
        }
    }

    public enum StatusCodeNames {
        SUCCESS(0),
        INVALID_ADDRESS(1),
        INVALID_MODEL(2),
        INVALID_APPKEY_INDEX(3),
        INVALID_NETKEY_INDEX(4),
        INSUFFICIENT_RESOURCES(5),
        KEY_INDEX_ALREADY_STORED(6),
        INVALID_PUBLISH_PARAMETERS(7),
        NOT_A_SUBSCRIBE_MODEL(8),
        STORAGE_FAILURE(9),
        FEATURE_NOT_SUPPORTED(10),
        CANNOT_UPDATE(11),
        CANNOT_REMOVE(12),
        CANNOT_BIND(13),
        TEMPORARILY_UNABLE_TO_CHANGE_STATE(14),
        CANNOT_SET(15),
        UNSPECIFIED_ERROR(16),
        INVALID_BINDING(17),
        RFU(18);
        
        public final int statusCode;

        /* access modifiers changed from: public */
        StatusCodeNames(int i) {
            this.statusCode = i;
        }

        public static StatusCodeNames fromStatusCode(int i) {
            for (StatusCodeNames statusCodeNames : values()) {
                if (statusCodeNames.getStatusCode() == i) {
                    return statusCodeNames;
                }
            }
            throw new IllegalArgumentException("Enum not found in StatusCodeNames");
        }

        public final int getStatusCode() {
            return this.statusCode;
        }
    }

    public ConfigStatusMessage(AccessMessage accessMessage) {
        this.O00000o0 = accessMessage;
    }

    public final int B_() {
        return this.O00000o0.getAid();
    }

    public final String O000000o(int i) {
        switch (AnonymousClass1.O000000o[StatusCodeNames.fromStatusCode(i).ordinal()]) {
            case 1:
                return "Success";
            case 2:
                return "Invalid Address";
            case 3:
                return "Invalid Model";
            case 4:
                return "Invalid ApplicationKey Index";
            case 5:
                return "Invalid NetKey Index";
            case 6:
                return "Insufficient Resources";
            case 7:
                return "Key Index Already Stored";
            case 8:
                return "Invalid Publish Parameters";
            case 9:
                return "Not a Subscribe Model";
            case 10:
                return "Storage Failure";
            case 11:
                return "Feature Not Supported";
            case 12:
                return "Cannot Update";
            case 13:
                return "Cannot Remove";
            case 14:
                return "Cannot Bind";
            case 15:
                return "Temporarily Unable to Change State";
            case 16:
                return "Cannot Set";
            case 17:
                return "Unspecified Error";
            case 18:
                return "Invalid Binding";
            default:
                return "RFU";
        }
    }

    public abstract void O000000o();

    public final int O00000o0() {
        return this.O00000o0.getAkf();
    }

    public final int O0000o0() {
        return this.O000000o;
    }

    public final String O0000o0O() {
        return this.O00000Oo;
    }

    public final byte[] j_() {
        return this.O00000o;
    }
}
