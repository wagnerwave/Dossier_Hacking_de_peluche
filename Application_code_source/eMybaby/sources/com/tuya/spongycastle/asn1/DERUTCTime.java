package com.tuya.spongycastle.asn1;

import java.util.Date;

public class DERUTCTime extends ASN1UTCTime {
    public DERUTCTime(String str) {
        super(str);
    }

    public DERUTCTime(Date date) {
        super(date);
    }

    public DERUTCTime(byte[] bArr) {
        super(bArr);
    }
}
