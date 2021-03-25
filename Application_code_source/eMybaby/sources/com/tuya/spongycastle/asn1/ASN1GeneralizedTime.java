package com.tuya.spongycastle.asn1;

import a.a.a.a.a;
import com.google.android.material.badge.BadgeDrawable;
import com.tuya.smart.common.oOO0O0O0;
import com.tuya.spongycastle.util.Arrays;
import com.tuya.spongycastle.util.Strings;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class ASN1GeneralizedTime extends ASN1Primitive {
    public byte[] time;

    public ASN1GeneralizedTime(String str) {
        this.time = Strings.toByteArray(str);
        try {
            getDate();
        } catch (ParseException e2) {
            StringBuilder n = a.n("invalid date string: ");
            n.append(e2.getMessage());
            throw new IllegalArgumentException(n.toString());
        }
    }

    public ASN1GeneralizedTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = Strings.toByteArray(simpleDateFormat.format(date));
    }

    public ASN1GeneralizedTime(Date date, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss'Z'", locale);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = Strings.toByteArray(simpleDateFormat.format(date));
    }

    public ASN1GeneralizedTime(byte[] bArr) {
        this.time = bArr;
    }

    private String calculateGMTOffset() {
        String str;
        TimeZone timeZone = TimeZone.getDefault();
        int rawOffset = timeZone.getRawOffset();
        if (rawOffset < 0) {
            rawOffset = -rawOffset;
            str = "-";
        } else {
            str = BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX;
        }
        int i = rawOffset / 3600000;
        int i2 = (rawOffset - (((i * 60) * 60) * 1000)) / 60000;
        try {
            if (timeZone.useDaylightTime() && timeZone.inDaylightTime(getDate())) {
                i += str.equals(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX) ? 1 : -1;
            }
        } catch (ParseException unused) {
        }
        StringBuilder p = a.p("GMT", str);
        p.append(convert(i));
        p.append(":");
        p.append(convert(i2));
        return p.toString();
    }

    private String convert(int i) {
        return i < 10 ? a.h(oOO0O0O0.O0000oO0, i) : Integer.toString(i);
    }

    public static ASN1GeneralizedTime getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        return (z || (object instanceof ASN1GeneralizedTime)) ? getInstance(object) : new ASN1GeneralizedTime(((ASN1OctetString) object).getOctets());
    }

    public static ASN1GeneralizedTime getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1GeneralizedTime)) {
            return (ASN1GeneralizedTime) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (ASN1GeneralizedTime) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (Exception e2) {
                throw new IllegalArgumentException(a.f(e2, a.n("encoding error in getInstance: ")));
            }
        } else {
            throw new IllegalArgumentException(a.g(obj, a.n("illegal object in getInstance: ")));
        }
    }

    private boolean hasFractionalSeconds() {
        int i = 0;
        while (true) {
            byte[] bArr = this.time;
            if (i == bArr.length) {
                return false;
            }
            if (bArr[i] == 46 && i == 14) {
                return true;
            }
            i++;
        }
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1GeneralizedTime)) {
            return false;
        }
        return Arrays.areEqual(this.time, ((ASN1GeneralizedTime) aSN1Primitive).time);
    }

    public void encode(ASN1OutputStream aSN1OutputStream) {
        aSN1OutputStream.writeEncoded(24, this.time);
    }

    public int encodedLength() {
        int length = this.time.length;
        return StreamUtil.calculateBodyLength(length) + 1 + length;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Date getDate() {
        /*
            r9 = this;
            byte[] r0 = r9.time
            java.lang.String r0 = com.tuya.spongycastle.util.Strings.fromByteArray(r0)
            java.lang.String r1 = "Z"
            boolean r2 = r0.endsWith(r1)
            r3 = 0
            if (r2 == 0) goto L_0x002d
            boolean r2 = r9.hasFractionalSeconds()
            if (r2 == 0) goto L_0x001d
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.lang.String r4 = "yyyyMMddHHmmss.SSS'Z'"
            r2.<init>(r4)
            goto L_0x0024
        L_0x001d:
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.lang.String r4 = "yyyyMMddHHmmss'Z'"
            r2.<init>(r4)
        L_0x0024:
            java.util.SimpleTimeZone r4 = new java.util.SimpleTimeZone
            r4.<init>(r3, r1)
        L_0x0029:
            r2.setTimeZone(r4)
            goto L_0x0084
        L_0x002d:
            r2 = 45
            int r2 = r0.indexOf(r2)
            if (r2 > 0) goto L_0x0065
            r2 = 43
            int r2 = r0.indexOf(r2)
            if (r2 <= 0) goto L_0x003e
            goto L_0x0065
        L_0x003e:
            boolean r1 = r9.hasFractionalSeconds()
            if (r1 == 0) goto L_0x004c
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat
            java.lang.String r2 = "yyyyMMddHHmmss.SSS"
            r1.<init>(r2)
            goto L_0x0053
        L_0x004c:
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat
            java.lang.String r2 = "yyyyMMddHHmmss"
            r1.<init>(r2)
        L_0x0053:
            r2 = r1
            java.util.SimpleTimeZone r1 = new java.util.SimpleTimeZone
            java.util.TimeZone r4 = java.util.TimeZone.getDefault()
            java.lang.String r4 = r4.getID()
            r1.<init>(r3, r4)
            r2.setTimeZone(r1)
            goto L_0x0084
        L_0x0065:
            java.lang.String r0 = r9.getTime()
            boolean r2 = r9.hasFractionalSeconds()
            if (r2 == 0) goto L_0x0077
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.lang.String r4 = "yyyyMMddHHmmss.SSSz"
            r2.<init>(r4)
            goto L_0x007e
        L_0x0077:
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.lang.String r4 = "yyyyMMddHHmmssz"
            r2.<init>(r4)
        L_0x007e:
            java.util.SimpleTimeZone r4 = new java.util.SimpleTimeZone
            r4.<init>(r3, r1)
            goto L_0x0029
        L_0x0084:
            boolean r1 = r9.hasFractionalSeconds()
            if (r1 == 0) goto L_0x0122
            r1 = 14
            java.lang.String r4 = r0.substring(r1)
            r5 = 1
            r6 = 1
        L_0x0092:
            int r7 = r4.length()
            if (r6 >= r7) goto L_0x00a8
            char r7 = r4.charAt(r6)
            r8 = 48
            if (r8 > r7) goto L_0x00a8
            r8 = 57
            if (r7 <= r8) goto L_0x00a5
            goto L_0x00a8
        L_0x00a5:
            int r6 = r6 + 1
            goto L_0x0092
        L_0x00a8:
            int r7 = r6 + -1
            r8 = 3
            if (r7 <= r8) goto L_0x00d9
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r7 = 4
            java.lang.String r7 = r4.substring(r3, r7)
            r5.append(r7)
            java.lang.String r4 = r4.substring(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
        L_0x00ca:
            java.lang.String r0 = r0.substring(r3, r1)
            r5.append(r0)
            r5.append(r4)
            java.lang.String r0 = r5.toString()
            goto L_0x0122
        L_0x00d9:
            if (r7 != r5) goto L_0x00fd
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = r4.substring(r3, r6)
            r5.append(r7)
            java.lang.String r7 = "00"
            r5.append(r7)
            java.lang.String r4 = r4.substring(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            goto L_0x00ca
        L_0x00fd:
            r5 = 2
            if (r7 != r5) goto L_0x0122
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = r4.substring(r3, r6)
            r5.append(r7)
            java.lang.String r7 = "0"
            r5.append(r7)
            java.lang.String r4 = r4.substring(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            goto L_0x00ca
        L_0x0122:
            java.util.Date r0 = r2.parse(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.spongycastle.asn1.ASN1GeneralizedTime.getDate():java.util.Date");
    }

    public String getTime() {
        String fromByteArray = Strings.fromByteArray(this.time);
        if (fromByteArray.charAt(fromByteArray.length() - 1) == 'Z') {
            return fromByteArray.substring(0, fromByteArray.length() - 1) + "GMT+00:00";
        }
        int length = fromByteArray.length() - 5;
        char charAt = fromByteArray.charAt(length);
        if (charAt == '-' || charAt == '+') {
            StringBuilder sb = new StringBuilder();
            sb.append(fromByteArray.substring(0, length));
            sb.append("GMT");
            int i = length + 3;
            sb.append(fromByteArray.substring(length, i));
            sb.append(":");
            sb.append(fromByteArray.substring(i));
            return sb.toString();
        }
        int length2 = fromByteArray.length() - 3;
        char charAt2 = fromByteArray.charAt(length2);
        if (charAt2 == '-' || charAt2 == '+') {
            return fromByteArray.substring(0, length2) + "GMT" + fromByteArray.substring(length2) + ":00";
        }
        StringBuilder n = a.n(fromByteArray);
        n.append(calculateGMTOffset());
        return n.toString();
    }

    public String getTimeString() {
        return Strings.fromByteArray(this.time);
    }

    public int hashCode() {
        return Arrays.hashCode(this.time);
    }

    public boolean isConstructed() {
        return false;
    }
}
