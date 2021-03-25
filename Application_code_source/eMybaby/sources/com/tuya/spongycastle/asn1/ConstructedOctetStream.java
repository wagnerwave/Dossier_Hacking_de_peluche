package com.tuya.spongycastle.asn1;

import java.io.InputStream;

public class ConstructedOctetStream extends InputStream {
    public InputStream _currentStream;
    public boolean _first = true;
    public final ASN1StreamParser _parser;

    public ConstructedOctetStream(ASN1StreamParser aSN1StreamParser) {
        this._parser = aSN1StreamParser;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read() {
        /*
            r3 = this;
            java.io.InputStream r0 = r3._currentStream
            r1 = -1
            if (r0 != 0) goto L_0x0019
            boolean r0 = r3._first
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            com.tuya.spongycastle.asn1.ASN1StreamParser r0 = r3._parser
            com.tuya.spongycastle.asn1.ASN1Encodable r0 = r0.readObject()
            com.tuya.spongycastle.asn1.ASN1OctetStringParser r0 = (com.tuya.spongycastle.asn1.ASN1OctetStringParser) r0
            if (r0 != 0) goto L_0x0015
            return r1
        L_0x0015:
            r2 = 0
            r3._first = r2
            goto L_0x0030
        L_0x0019:
            java.io.InputStream r0 = r3._currentStream
            int r0 = r0.read()
            if (r0 < 0) goto L_0x0022
            return r0
        L_0x0022:
            com.tuya.spongycastle.asn1.ASN1StreamParser r0 = r3._parser
            com.tuya.spongycastle.asn1.ASN1Encodable r0 = r0.readObject()
            com.tuya.spongycastle.asn1.ASN1OctetStringParser r0 = (com.tuya.spongycastle.asn1.ASN1OctetStringParser) r0
            if (r0 != 0) goto L_0x0030
            r0 = 0
            r3._currentStream = r0
            return r1
        L_0x0030:
            java.io.InputStream r0 = r0.getOctetStream()
            r3._currentStream = r0
            goto L_0x0019
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.spongycastle.asn1.ConstructedOctetStream.read():int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002e A[EDGE_INSN: B:20:0x002e->B:15:0x002e ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002d A[SYNTHETIC] */
    public int read(byte[] r6, int r7, int r8) {
        /*
            r5 = this;
            java.io.InputStream r0 = r5._currentStream
            r1 = 0
            r2 = -1
            if (r0 != 0) goto L_0x001e
            boolean r0 = r5._first
            if (r0 != 0) goto L_0x000b
            return r2
        L_0x000b:
            com.tuya.spongycastle.asn1.ASN1StreamParser r0 = r5._parser
            com.tuya.spongycastle.asn1.ASN1Encodable r0 = r0.readObject()
            com.tuya.spongycastle.asn1.ASN1OctetStringParser r0 = (com.tuya.spongycastle.asn1.ASN1OctetStringParser) r0
            if (r0 != 0) goto L_0x0016
            return r2
        L_0x0016:
            r5._first = r1
        L_0x0018:
            java.io.InputStream r0 = r0.getOctetStream()
            r5._currentStream = r0
        L_0x001e:
            java.io.InputStream r0 = r5._currentStream
            int r3 = r7 + r1
            int r4 = r8 - r1
            int r0 = r0.read(r6, r3, r4)
            if (r0 < 0) goto L_0x002e
            int r1 = r1 + r0
            if (r1 != r8) goto L_0x001e
            return r1
        L_0x002e:
            com.tuya.spongycastle.asn1.ASN1StreamParser r0 = r5._parser
            com.tuya.spongycastle.asn1.ASN1Encodable r0 = r0.readObject()
            com.tuya.spongycastle.asn1.ASN1OctetStringParser r0 = (com.tuya.spongycastle.asn1.ASN1OctetStringParser) r0
            if (r0 != 0) goto L_0x0018
            r6 = 0
            r5._currentStream = r6
            r6 = 1
            if (r1 >= r6) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r2 = r1
        L_0x0040:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.spongycastle.asn1.ConstructedOctetStream.read(byte[], int, int):int");
    }
}
