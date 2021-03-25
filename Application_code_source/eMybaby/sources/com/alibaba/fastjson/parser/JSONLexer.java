package com.alibaba.fastjson.parser;

import a.a.a.a.a;
import androidx.core.util.TimeUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public final class JSONLexer {
    public static final char[] CA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    public static final int END = 4;
    public static final char EOI = '\u001a';
    public static final int[] IA;
    public static final int NOT_MATCH = -1;
    public static final int NOT_MATCH_NAME = -2;
    public static final int UNKNOWN = 0;
    public static boolean V6 = false;
    public static final int VALUE = 3;
    public static final int[] digits = new int[103];
    public static final boolean[] firstIdentifierFlags = new boolean[256];
    public static final boolean[] identifierFlags = new boolean[256];
    public static final ThreadLocal<char[]> sbufLocal = new ThreadLocal<>();
    public int bp;
    public Calendar calendar;
    public char ch;
    public boolean disableCircularReferenceDetect;
    public int eofPos;
    public boolean exp;
    public int features;
    public long fieldHash;
    public boolean hasSpecial;
    public boolean isDouble;
    public final int len;
    public Locale locale;
    public int matchStat;
    public int np;
    public int pos;
    public char[] sbuf;
    public int sp;
    public String stringDefaultValue;
    public final String text;
    public TimeZone timeZone;
    public int token;

    static {
        int i;
        try {
            i = Class.forName("android.os.Build$VERSION").getField("SDK_INT").getInt((Object) null);
        } catch (Exception unused) {
            i = -1;
        }
        char c2 = 0;
        V6 = i >= 23;
        for (int i2 = 48; i2 <= 57; i2++) {
            digits[i2] = i2 - 48;
        }
        for (int i3 = 97; i3 <= 102; i3++) {
            digits[i3] = (i3 - 97) + 10;
        }
        for (int i4 = 65; i4 <= 70; i4++) {
            digits[i4] = (i4 - 65) + 10;
        }
        int[] iArr = new int[256];
        IA = iArr;
        Arrays.fill(iArr, -1);
        int length = CA.length;
        for (int i5 = 0; i5 < length; i5++) {
            IA[CA[i5]] = i5;
        }
        IA[61] = 0;
        char c3 = 0;
        while (true) {
            boolean[] zArr = firstIdentifierFlags;
            if (c3 >= zArr.length) {
                break;
            }
            if (c3 >= 'A' && c3 <= 'Z') {
                zArr[c3] = true;
            } else if (c3 >= 'a' && c3 <= 'z') {
                firstIdentifierFlags[c3] = true;
            } else if (c3 == '_') {
                firstIdentifierFlags[c3] = true;
            }
            c3 = (char) (c3 + 1);
        }
        while (true) {
            boolean[] zArr2 = identifierFlags;
            if (c2 < zArr2.length) {
                if (c2 >= 'A' && c2 <= 'Z') {
                    zArr2[c2] = true;
                } else if (c2 >= 'a' && c2 <= 'z') {
                    identifierFlags[c2] = true;
                } else if (c2 == '_') {
                    identifierFlags[c2] = true;
                } else if (c2 >= '0' && c2 <= '9') {
                    identifierFlags[c2] = true;
                }
                c2 = (char) (c2 + 1);
            } else {
                return;
            }
        }
    }

    public JSONLexer(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONLexer(String str, int i) {
        this.features = JSON.DEFAULT_PARSER_FEATURE;
        boolean z = false;
        this.exp = false;
        this.isDouble = false;
        this.timeZone = JSON.defaultTimeZone;
        this.locale = JSON.defaultLocale;
        String str2 = null;
        this.calendar = null;
        this.matchStat = 0;
        char[] cArr = sbufLocal.get();
        this.sbuf = cArr;
        if (cArr == null) {
            this.sbuf = new char[512];
        }
        this.features = i;
        this.text = str;
        int length = str.length();
        this.len = length;
        this.bp = -1;
        int i2 = -1 + 1;
        this.bp = i2;
        char charAt = i2 >= length ? EOI : this.text.charAt(i2);
        this.ch = charAt;
        if (charAt == 65279) {
            next();
        }
        this.stringDefaultValue = (Feature.InitStringFieldAsEmpty.mask & i) != 0 ? "" : str2;
        this.disableCircularReferenceDetect = (Feature.DisableCircularReferenceDetect.mask & i) != 0 ? true : z;
    }

    public JSONLexer(char[] cArr, int i) {
        this(cArr, i, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONLexer(char[] cArr, int i, int i2) {
        this(new String(cArr, 0, i), i2);
    }

    public static boolean checkDate(char c2, char c3, char c4, char c5, char c6, char c7, int i, int i2) {
        if (c2 >= '1' && c2 <= '3' && c3 >= '0' && c3 <= '9' && c4 >= '0' && c4 <= '9' && c5 >= '0' && c5 <= '9') {
            if (c6 == '0') {
                if (c7 < '1' || c7 > '9') {
                    return false;
                }
            } else if (!(c6 == '1' && (c7 == '0' || c7 == '1' || c7 == '2'))) {
                return false;
            }
            return i == 48 ? i2 >= 49 && i2 <= 57 : (i == 49 || i == 50) ? i2 >= 48 && i2 <= 57 : i == 51 && (i2 == 48 || i2 == 49);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001d, code lost:
        if (r5 <= '4') goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean checkTime(char r4, char r5, char r6, char r7, char r8, char r9) {
        /*
            r0 = 57
            r1 = 0
            r2 = 48
            if (r4 != r2) goto L_0x000c
            if (r5 < r2) goto L_0x000b
            if (r5 <= r0) goto L_0x0020
        L_0x000b:
            return r1
        L_0x000c:
            r3 = 49
            if (r4 != r3) goto L_0x0015
            if (r5 < r2) goto L_0x0014
            if (r5 <= r0) goto L_0x0020
        L_0x0014:
            return r1
        L_0x0015:
            r3 = 50
            if (r4 != r3) goto L_0x0042
            if (r5 < r2) goto L_0x0042
            r4 = 52
            if (r5 <= r4) goto L_0x0020
            goto L_0x0042
        L_0x0020:
            r4 = 53
            r5 = 54
            if (r6 < r2) goto L_0x002d
            if (r6 > r4) goto L_0x002d
            if (r7 < r2) goto L_0x002c
            if (r7 <= r0) goto L_0x0032
        L_0x002c:
            return r1
        L_0x002d:
            if (r6 != r5) goto L_0x0042
            if (r7 == r2) goto L_0x0032
            return r1
        L_0x0032:
            if (r8 < r2) goto L_0x003b
            if (r8 > r4) goto L_0x003b
            if (r9 < r2) goto L_0x003a
            if (r9 <= r0) goto L_0x0040
        L_0x003a:
            return r1
        L_0x003b:
            if (r8 != r5) goto L_0x0042
            if (r9 == r2) goto L_0x0040
            return r1
        L_0x0040:
            r4 = 1
            return r4
        L_0x0042:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.checkTime(char, char, char, char, char, char):boolean");
    }

    public static final byte[] decodeFast(String str, int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 == 0) {
            return new byte[0];
        }
        int i5 = (i + i2) - 1;
        while (r13 < i5 && IA[str.charAt(r13)] < 0) {
            i = r13 + 1;
        }
        while (i5 > 0 && IA[str.charAt(i5)] < 0) {
            i5--;
        }
        int i6 = str.charAt(i5) == '=' ? str.charAt(i5 + -1) == '=' ? 2 : 1 : 0;
        int i7 = (i5 - r13) + 1;
        if (i2 > 76) {
            i3 = (str.charAt(76) == 13 ? i7 / 78 : 0) << 1;
        } else {
            i3 = 0;
        }
        int i8 = (((i7 - i3) * 6) >> 3) - i6;
        byte[] bArr = new byte[i8];
        int i9 = (i8 / 3) * 3;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i9) {
            int i12 = r13 + 1;
            int i13 = i12 + 1;
            int i14 = i13 + 1;
            int i15 = i14 + 1;
            int i16 = (IA[str.charAt(r13)] << 18) | (IA[str.charAt(i12)] << 12) | (IA[str.charAt(i13)] << 6) | IA[str.charAt(i14)];
            int i17 = i10 + 1;
            bArr[i10] = (byte) (i16 >> 16);
            int i18 = i17 + 1;
            bArr[i17] = (byte) (i16 >> 8);
            int i19 = i18 + 1;
            bArr[i18] = (byte) i16;
            if (i3 <= 0 || (i11 = i11 + 1) != 19) {
                r13 = i15;
            } else {
                r13 = i15 + 2;
                i11 = 0;
            }
            i10 = i19;
        }
        if (i10 < i8) {
            int i20 = 0;
            while (r13 <= i5 - i6) {
                i4 |= IA[str.charAt(r13)] << (18 - (i20 * 6));
                i20++;
                r13++;
            }
            int i21 = 16;
            while (i10 < i8) {
                bArr[i10] = (byte) (i4 >> i21);
                i21 -= 8;
                i10++;
            }
        }
        return bArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002d, code lost:
        r3 = r3 + ((r4 - r0.bp) - r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0033, code lost:
        r14 = 1099511628211L * (((long) r12) ^ r14);
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        if (r14 == r17) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        r0.fieldHash = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0048, code lost:
        r3 = r3 + 1;
        r1 = r0.bp + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
        if (r1 < r0.len) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        r1 = EOI;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0053, code lost:
        r1 = r0.text.charAt(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005b, code lost:
        if (r1 != ':') goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005e, code lost:
        return r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005f, code lost:
        if (r1 > ' ') goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0061, code lost:
        if (r1 == ' ') goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0063, code lost:
        if (r1 == 10) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0065, code lost:
        if (r1 == 13) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0067, code lost:
        if (r1 == 9) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006b, code lost:
        if (r1 == 12) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x006f, code lost:
        if (r1 != 8) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0071, code lost:
        r4 = r3 + 1;
        r1 = r0.bp + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0078, code lost:
        if (r1 < r0.len) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x007a, code lost:
        r1 = EOI;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x007d, code lost:
        r1 = r0.text.charAt(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0083, code lost:
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x008c, code lost:
        throw new com.alibaba.fastjson.JSONException("match feild error expect ':'");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
        r14 = -3750763034362895579L;
        r4 = r0.bp + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0023, code lost:
        if (r4 >= r0.len) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0025, code lost:
        r12 = r0.text.charAt(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002b, code lost:
        if (r12 != r1) goto L_0x0033;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int matchFieldHash(long r17) {
        /*
            r16 = this;
            r0 = r16
            char r1 = r0.ch
            r2 = 1
            r3 = 1
        L_0x0006:
            r4 = 34
            r7 = 0
            r8 = -2
            r9 = 9
            r10 = 13
            r11 = 10
            r13 = 32
            if (r1 != r4) goto L_0x0015
            goto L_0x0019
        L_0x0015:
            r4 = 39
            if (r1 != r4) goto L_0x008d
        L_0x0019:
            r14 = -3750763034362895579(0xcbf29ce484222325, double:-7.302176725335867E57)
            int r4 = r0.bp
            int r4 = r4 + r3
        L_0x0021:
            int r12 = r0.len
            if (r4 >= r12) goto L_0x003f
            java.lang.String r12 = r0.text
            char r12 = r12.charAt(r4)
            if (r12 != r1) goto L_0x0033
            int r1 = r0.bp
            int r4 = r4 - r1
            int r4 = r4 - r3
            int r3 = r3 + r4
            goto L_0x003f
        L_0x0033:
            long r5 = (long) r12
            long r5 = r5 ^ r14
            r14 = 1099511628211(0x100000001b3, double:5.43230922702E-312)
            long r14 = r14 * r5
            int r4 = r4 + 1
            goto L_0x0021
        L_0x003f:
            int r1 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r1 == 0) goto L_0x0048
            r0.fieldHash = r14
        L_0x0045:
            r0.matchStat = r8
            return r7
        L_0x0048:
            int r1 = r0.bp
            int r3 = r3 + r2
            int r1 = r1 + r3
            int r4 = r0.len
            if (r1 < r4) goto L_0x0053
            r1 = 26
            goto L_0x0059
        L_0x0053:
            java.lang.String r4 = r0.text
            char r1 = r4.charAt(r1)
        L_0x0059:
            r4 = 58
            if (r1 != r4) goto L_0x005f
            int r3 = r3 + r2
            return r3
        L_0x005f:
            if (r1 > r13) goto L_0x0085
            if (r1 == r13) goto L_0x0071
            if (r1 == r11) goto L_0x0071
            if (r1 == r10) goto L_0x0071
            if (r1 == r9) goto L_0x0071
            r4 = 12
            if (r1 == r4) goto L_0x0071
            r4 = 8
            if (r1 != r4) goto L_0x0085
        L_0x0071:
            int r1 = r0.bp
            int r4 = r3 + 1
            int r1 = r1 + r3
            int r3 = r0.len
            if (r1 < r3) goto L_0x007d
            r1 = 26
            goto L_0x0083
        L_0x007d:
            java.lang.String r3 = r0.text
            char r1 = r3.charAt(r1)
        L_0x0083:
            r3 = r4
            goto L_0x0059
        L_0x0085:
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException
            java.lang.String r2 = "match feild error expect ':'"
            r1.<init>(r2)
            throw r1
        L_0x008d:
            if (r1 == r13) goto L_0x00a3
            if (r1 == r11) goto L_0x00a3
            if (r1 == r10) goto L_0x00a3
            if (r1 == r9) goto L_0x00a3
            r4 = 12
            if (r1 == r4) goto L_0x00a3
            r4 = 8
            if (r1 != r4) goto L_0x009e
            goto L_0x00a3
        L_0x009e:
            r1 = 0
            r0.fieldHash = r1
            goto L_0x0045
        L_0x00a3:
            int r1 = r0.bp
            int r4 = r3 + 1
            int r1 = r1 + r3
            int r3 = r0.len
            if (r1 < r3) goto L_0x00af
            r1 = 26
            goto L_0x00b5
        L_0x00af:
            java.lang.String r3 = r0.text
            char r1 = r3.charAt(r1)
        L_0x00b5:
            r3 = r4
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.matchFieldHash(long):int");
    }

    public static String readString(char[] cArr, int i) {
        int i2;
        int i3;
        char[] cArr2 = new char[i];
        int i4 = 0;
        int i5 = 0;
        while (i2 < i) {
            char c2 = cArr[i2];
            if (c2 != '\\') {
                cArr2[i5] = c2;
                i5++;
            } else {
                i2++;
                char c3 = cArr[i2];
                if (c3 == '\"') {
                    i3 = i5 + 1;
                    cArr2[i5] = '\"';
                } else if (c3 != '\'') {
                    if (c3 != 'F') {
                        if (c3 == '\\') {
                            i3 = i5 + 1;
                            cArr2[i5] = '\\';
                        } else if (c3 == 'b') {
                            i3 = i5 + 1;
                            cArr2[i5] = 8;
                        } else if (c3 != 'f') {
                            if (c3 == 'n') {
                                i3 = i5 + 1;
                                cArr2[i5] = 10;
                            } else if (c3 == 'r') {
                                i3 = i5 + 1;
                                cArr2[i5] = 13;
                            } else if (c3 != 'x') {
                                switch (c3) {
                                    case '/':
                                        i3 = i5 + 1;
                                        cArr2[i5] = '/';
                                        break;
                                    case '0':
                                        i3 = i5 + 1;
                                        cArr2[i5] = 0;
                                        break;
                                    case '1':
                                        i3 = i5 + 1;
                                        cArr2[i5] = 1;
                                        break;
                                    case '2':
                                        i3 = i5 + 1;
                                        cArr2[i5] = 2;
                                        break;
                                    case '3':
                                        i3 = i5 + 1;
                                        cArr2[i5] = 3;
                                        break;
                                    case '4':
                                        i3 = i5 + 1;
                                        cArr2[i5] = 4;
                                        break;
                                    case '5':
                                        i3 = i5 + 1;
                                        cArr2[i5] = 5;
                                        break;
                                    case '6':
                                        i3 = i5 + 1;
                                        cArr2[i5] = 6;
                                        break;
                                    case '7':
                                        i3 = i5 + 1;
                                        cArr2[i5] = 7;
                                        break;
                                    default:
                                        switch (c3) {
                                            case 't':
                                                i3 = i5 + 1;
                                                cArr2[i5] = 9;
                                                break;
                                            case 'u':
                                                i3 = i5 + 1;
                                                int i6 = i2 + 1;
                                                int i7 = i6 + 1;
                                                int i8 = i7 + 1;
                                                i2 = i8 + 1;
                                                cArr2[i5] = (char) Integer.parseInt(new String(new char[]{cArr[i6], cArr[i7], cArr[i8], cArr[i2]}), 16);
                                                break;
                                            case 'v':
                                                i3 = i5 + 1;
                                                cArr2[i5] = 11;
                                                break;
                                            default:
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                }
                            } else {
                                i3 = i5 + 1;
                                int[] iArr = digits;
                                int i9 = i2 + 1;
                                i2 = i9 + 1;
                                cArr2[i5] = (char) ((iArr[cArr[i9]] * 16) + iArr[cArr[i2]]);
                            }
                        }
                    }
                    i3 = i5 + 1;
                    cArr2[i5] = 12;
                } else {
                    i3 = i5 + 1;
                    cArr2[i5] = '\'';
                }
                i5 = i3;
            }
            i4 = i2 + 1;
        }
        return new String(cArr2, 0, i5);
    }

    private void scanIdent() {
        this.np = this.bp - 1;
        this.hasSpecial = false;
        do {
            this.sp++;
            next();
        } while (Character.isLetterOrDigit(this.ch));
        String stringVal = stringVal();
        this.token = stringVal.equals("null") ? 8 : stringVal.equals("true") ? 6 : stringVal.equals("false") ? 7 : stringVal.equals("new") ? 9 : stringVal.equals("undefined") ? 23 : stringVal.equals("Set") ? 21 : stringVal.equals("TreeSet") ? 22 : 18;
    }

    private void setCalendar(char c2, char c3, char c4, char c5, char c6, char c7, char c8, char c9) {
        Calendar instance = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar = instance;
        int i = c5 - '0';
        instance.set(1, i + ((c4 - '0') * 10) + ((c3 - '0') * 100) + ((c2 - '0') * 1000));
        this.calendar.set(2, ((c7 - '0') + ((c6 - '0') * 10)) - 1);
        this.calendar.set(5, (c9 - '0') + ((c8 - '0') * 10));
    }

    private final String subString(int i, int i2) {
        char[] cArr = this.sbuf;
        if (i2 < cArr.length) {
            this.text.getChars(i, i + i2, cArr, 0);
            return new String(this.sbuf, 0, i2);
        }
        char[] cArr2 = new char[i2];
        this.text.getChars(i, i2 + i, cArr2, 0);
        return new String(cArr2);
    }

    public byte[] bytesValue() {
        return decodeFast(this.text, this.np + 1, this.sp);
    }

    public char charAt(int i) {
        return i >= this.len ? EOI : this.text.charAt(i);
    }

    public void close() {
        char[] cArr = this.sbuf;
        if (cArr.length <= 8196) {
            sbufLocal.set(cArr);
        }
        this.sbuf = null;
    }

    public final void config(Feature feature, boolean z) {
        int i = this.features;
        int i2 = feature.mask;
        this.features = z ? i | i2 : i & (i2 ^ -1);
        if (feature == Feature.InitStringFieldAsEmpty) {
            this.stringDefaultValue = z ? "" : null;
        }
        this.disableCircularReferenceDetect = (this.features & Feature.DisableCircularReferenceDetect.mask) != 0;
    }

    public final Number decimalValue(boolean z) {
        char[] cArr;
        boolean z2;
        int i = (this.np + this.sp) - 1;
        char charAt = i >= this.len ? EOI : this.text.charAt(i);
        if (charAt == 'F') {
            try {
                return Float.valueOf(Float.parseFloat(numberString()));
            } catch (NumberFormatException e2) {
                throw new JSONException(e2.getMessage() + ", " + info());
            }
        } else if (charAt == 'D') {
            return Double.valueOf(Double.parseDouble(numberString()));
        } else {
            if (z) {
                return decimalValue();
            }
            char charAt2 = this.text.charAt((this.np + this.sp) - 1);
            int i2 = this.sp;
            if (charAt2 == 'L' || charAt2 == 'S' || charAt2 == 'B' || charAt2 == 'F' || charAt2 == 'D') {
                i2--;
            }
            int i3 = this.np;
            int i4 = 0;
            if (i2 < this.sbuf.length) {
                this.text.getChars(i3, i3 + i2, this.sbuf, 0);
                cArr = this.sbuf;
            } else {
                char[] cArr2 = new char[i2];
                this.text.getChars(i3, i3 + i2, cArr2, 0);
                cArr = cArr2;
            }
            if (i2 > 9 || this.exp) {
                return Double.valueOf(Double.parseDouble(new String(cArr, 0, i2)));
            }
            char c2 = cArr[0];
            int i5 = 2;
            if (c2 == '-') {
                c2 = cArr[1];
                z2 = true;
            } else if (c2 == '+') {
                c2 = cArr[1];
                z2 = false;
            } else {
                z2 = false;
                i5 = 1;
            }
            int i6 = c2 - '0';
            while (i5 < i2) {
                char c3 = cArr[i5];
                if (c3 == '.') {
                    i4 = 1;
                } else {
                    i6 = (i6 * 10) + (c3 - '0');
                    if (i4 != 0) {
                        i4 *= 10;
                    }
                }
                i5++;
            }
            double d2 = (double) i6;
            double d3 = (double) i4;
            Double.isNaN(d2);
            Double.isNaN(d3);
            double d4 = d2 / d3;
            if (z2) {
                d4 = -d4;
            }
            return Double.valueOf(d4);
        }
    }

    public final BigDecimal decimalValue() {
        char charAt = this.text.charAt((this.np + this.sp) - 1);
        int i = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i--;
        }
        int i2 = this.np;
        char[] cArr = this.sbuf;
        if (i < cArr.length) {
            this.text.getChars(i2, i2 + i, cArr, 0);
            return new BigDecimal(this.sbuf, 0, i);
        }
        char[] cArr2 = new char[i];
        this.text.getChars(i2, i + i2, cArr2, 0);
        return new BigDecimal(cArr2);
    }

    public String info() {
        StringBuilder n = a.n("pos ");
        n.append(this.bp);
        n.append(", json : ");
        n.append(this.len < 65536 ? this.text : this.text.substring(0, 65536));
        return n.toString();
    }

    public final int intValue() {
        boolean z;
        int i;
        int i2 = this.np;
        int i3 = this.sp + i2;
        int i4 = 0;
        if ((i2 >= this.len ? EOI : this.text.charAt(i2)) == '-') {
            i = Integer.MIN_VALUE;
            i2++;
            z = true;
        } else {
            i = -2147483647;
            z = false;
        }
        if (i2 < i3) {
            i4 = -((i2 >= this.len ? EOI : this.text.charAt(i2)) - '0');
            i2++;
        }
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int i5 = i2 + 1;
            char charAt = i2 >= this.len ? EOI : this.text.charAt(i2);
            if (charAt == 'L' || charAt == 'S' || charAt == 'B') {
                i2 = i5;
            } else {
                int i6 = charAt - '0';
                if (i4 >= -214748364) {
                    int i7 = i4 * 10;
                    if (i7 >= i + i6) {
                        i4 = i7 - i6;
                        i2 = i5;
                    } else {
                        throw new NumberFormatException(numberString());
                    }
                } else {
                    throw new NumberFormatException(numberString());
                }
            }
        }
        if (!z) {
            return -i4;
        }
        if (i2 > this.np + 1) {
            return i4;
        }
        throw new NumberFormatException(numberString());
    }

    public final Number integerValue() {
        char c2;
        boolean z;
        long j;
        long j2;
        int i = this.np;
        int i2 = this.sp + i;
        int i3 = i2 - 1;
        char charAt = i3 >= this.len ? EOI : this.text.charAt(i3);
        if (charAt == 'B') {
            i2--;
            c2 = 'B';
        } else if (charAt == 'L') {
            i2--;
            c2 = 'L';
        } else if (charAt != 'S') {
            c2 = ' ';
        } else {
            i2--;
            c2 = 'S';
        }
        int i4 = this.np;
        if ((i4 >= this.len ? EOI : this.text.charAt(i4)) == '-') {
            j = Long.MIN_VALUE;
            i++;
            z = true;
        } else {
            j = -9223372036854775807L;
            z = false;
        }
        if (i < i2) {
            j2 = (long) (-((i >= this.len ? EOI : this.text.charAt(i)) - '0'));
            i++;
        } else {
            j2 = 0;
        }
        while (i < i2) {
            int i5 = i + 1;
            int charAt2 = (i >= this.len ? EOI : this.text.charAt(i)) - '0';
            if (j2 < -922337203685477580L) {
                return new BigInteger(numberString());
            }
            long j3 = j2 * 10;
            long j4 = (long) charAt2;
            if (j3 < j + j4) {
                return new BigInteger(numberString());
            }
            j2 = j3 - j4;
            i = i5;
        }
        if (!z) {
            long j5 = -j2;
            if (j5 > 2147483647L || c2 == 'L') {
                return Long.valueOf(j5);
            }
            int i6 = (int) j5;
            return c2 == 'S' ? Short.valueOf((short) i6) : c2 == 'B' ? Byte.valueOf((byte) i6) : Integer.valueOf(i6);
        } else if (i <= this.np + 1) {
            throw new NumberFormatException(numberString());
        } else if (j2 < -2147483648L || c2 == 'L') {
            return Long.valueOf(j2);
        } else {
            if (c2 == 'S') {
                return Short.valueOf((short) ((int) j2));
            }
            int i7 = (int) j2;
            return c2 == 'B' ? Byte.valueOf((byte) i7) : Integer.valueOf(i7);
        }
    }

    public final boolean isBlankInput() {
        int i = 0;
        while (true) {
            char charAt = charAt(i);
            boolean z = true;
            if (charAt == 26) {
                return true;
            }
            if (charAt > ' ' || !(charAt == ' ' || charAt == 10 || charAt == 13 || charAt == 9 || charAt == 12 || charAt == 8)) {
                z = false;
            }
            if (!z) {
                return false;
            }
            i++;
        }
    }

    public final boolean isEnabled(Feature feature) {
        return (feature.mask & this.features) != 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long longValue() {
        /*
            r13 = this;
            int r0 = r13.np
            int r1 = r13.sp
            int r1 = r1 + r0
            char r2 = r13.charAt(r0)
            r3 = 1
            r4 = 45
            if (r2 != r4) goto L_0x0014
            r4 = -9223372036854775808
            int r0 = r0 + 1
            r2 = 1
            goto L_0x001a
        L_0x0014:
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r2 = 0
        L_0x001a:
            if (r0 >= r1) goto L_0x0028
            int r6 = r0 + 1
            char r0 = r13.charAt(r0)
            int r0 = r0 + -48
            int r0 = -r0
            long r7 = (long) r0
        L_0x0026:
            r0 = r6
            goto L_0x002a
        L_0x0028:
            r7 = 0
        L_0x002a:
            if (r0 >= r1) goto L_0x0075
            int r6 = r0 + 1
            int r9 = r13.len
            if (r0 < r9) goto L_0x0035
            r0 = 26
            goto L_0x003b
        L_0x0035:
            java.lang.String r9 = r13.text
            char r0 = r9.charAt(r0)
        L_0x003b:
            r9 = 76
            if (r0 == r9) goto L_0x0074
            r9 = 83
            if (r0 == r9) goto L_0x0074
            r9 = 66
            if (r0 != r9) goto L_0x0048
            goto L_0x0074
        L_0x0048:
            int r0 = r0 + -48
            r9 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 < 0) goto L_0x006a
            r9 = 10
            long r7 = r7 * r9
            long r9 = (long) r0
            long r11 = r4 + r9
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 < 0) goto L_0x0060
            long r7 = r7 - r9
            goto L_0x0026
        L_0x0060:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r13.numberString()
            r0.<init>(r1)
            throw r0
        L_0x006a:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r13.numberString()
            r0.<init>(r1)
            throw r0
        L_0x0074:
            r0 = r6
        L_0x0075:
            if (r2 == 0) goto L_0x0087
            int r1 = r13.np
            int r1 = r1 + r3
            if (r0 <= r1) goto L_0x007d
            return r7
        L_0x007d:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r13.numberString()
            r0.<init>(r1)
            throw r0
        L_0x0087:
            long r0 = -r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.longValue():long");
    }

    public boolean matchField(long j) {
        char c2 = this.ch;
        int i = this.bp + 1;
        int i2 = 1;
        while (c2 != '\"' && c2 != '\'') {
            if (c2 > ' ' || !(c2 == ' ' || c2 == 10 || c2 == 13 || c2 == 9 || c2 == 12 || c2 == 8)) {
                this.fieldHash = 0;
                this.matchStat = -2;
                return false;
            }
            int i3 = i2 + 1;
            int i4 = this.bp + i2;
            c2 = i4 >= this.len ? EOI : this.text.charAt(i4);
            i2 = i3;
        }
        int i5 = i;
        long j2 = -3750763034362895579L;
        while (true) {
            if (i5 >= this.len) {
                break;
            }
            char charAt = this.text.charAt(i5);
            if (charAt == c2) {
                i2 += (i5 - i) + 1;
                break;
            }
            j2 = 1099511628211L * (((long) charAt) ^ j2);
            i5++;
        }
        if (j2 != j) {
            this.matchStat = -2;
            this.fieldHash = j2;
            return false;
        }
        int i6 = i2 + 1;
        int i7 = this.bp + i2;
        char charAt2 = i7 >= this.len ? EOI : this.text.charAt(i7);
        while (charAt2 != ':') {
            if (charAt2 > ' ' || !(charAt2 == ' ' || charAt2 == 10 || charAt2 == 13 || charAt2 == 9 || charAt2 == 12 || charAt2 == 8)) {
                throw new JSONException("match feild error expect ':'");
            }
            int i8 = i6 + 1;
            int i9 = this.bp + i6;
            charAt2 = i9 >= this.len ? EOI : this.text.charAt(i9);
            i6 = i8;
        }
        int i10 = this.bp + i6;
        char charAt3 = i10 >= this.len ? EOI : this.text.charAt(i10);
        if (charAt3 == '{') {
            int i11 = i10 + 1;
            this.bp = i11;
            this.ch = i11 >= this.len ? EOI : this.text.charAt(i11);
            this.token = 12;
        } else if (charAt3 == '[') {
            int i12 = i10 + 1;
            this.bp = i12;
            this.ch = i12 >= this.len ? EOI : this.text.charAt(i12);
            this.token = 14;
        } else {
            this.bp = i10;
            this.ch = i10 >= this.len ? EOI : this.text.charAt(i10);
            nextToken();
        }
        return true;
    }

    public char next() {
        int i = this.bp + 1;
        this.bp = i;
        char charAt = i >= this.len ? EOI : this.text.charAt(i);
        this.ch = charAt;
        return charAt;
    }

    public final void nextIdent() {
        while (true) {
            char c2 = this.ch;
            if (!(c2 <= ' ' && (c2 == ' ' || c2 == 10 || c2 == 13 || c2 == 9 || c2 == 12 || c2 == 8))) {
                break;
            }
            next();
        }
        char c3 = this.ch;
        if (c3 == '_' || Character.isLetter(c3)) {
            scanIdent();
        } else {
            nextToken();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0027, code lost:
        scanNumber();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void nextToken() {
        /*
            r15 = this;
            r0 = 0
            r15.sp = r0
        L_0x0003:
            int r1 = r15.bp
            r15.pos = r1
            char r1 = r15.ch
            r2 = 47
            if (r1 != r2) goto L_0x0011
            r15.skipComment()
            goto L_0x0003
        L_0x0011:
            r2 = 34
            if (r1 != r2) goto L_0x0019
            r15.scanString()
            return
        L_0x0019:
            r2 = 48
            if (r1 < r2) goto L_0x0021
            r2 = 57
            if (r1 <= r2) goto L_0x0027
        L_0x0021:
            char r1 = r15.ch
            r2 = 45
            if (r1 != r2) goto L_0x002b
        L_0x0027:
            r15.scanNumber()
            return
        L_0x002b:
            r2 = 44
            if (r1 != r2) goto L_0x0037
            r15.next()
            r0 = 16
            r15.token = r0
            return
        L_0x0037:
            r3 = 12
            if (r1 == r3) goto L_0x01e6
            r4 = 13
            if (r1 == r4) goto L_0x01e6
            r5 = 32
            if (r1 == r5) goto L_0x01e6
            r6 = 58
            if (r1 == r6) goto L_0x01de
            r7 = 91
            r8 = 1
            r9 = 26
            if (r1 == r7) goto L_0x01c7
            r7 = 93
            if (r1 == r7) goto L_0x01bf
            r10 = 102(0x66, float:1.43E-43)
            r11 = 9
            r12 = 8
            r13 = 10
            r14 = 125(0x7d, float:1.75E-43)
            if (r1 == r10) goto L_0x0185
            r10 = 110(0x6e, float:1.54E-43)
            if (r1 == r10) goto L_0x0133
            r10 = 123(0x7b, float:1.72E-43)
            if (r1 == r10) goto L_0x011e
            if (r1 == r14) goto L_0x0109
            r10 = 83
            if (r1 == r10) goto L_0x0105
            r10 = 84
            if (r1 == r10) goto L_0x0105
            r10 = 116(0x74, float:1.63E-43)
            if (r1 == r10) goto L_0x00cb
            r2 = 117(0x75, float:1.64E-43)
            if (r1 == r2) goto L_0x0105
            switch(r1) {
                case 8: goto L_0x01e6;
                case 9: goto L_0x01e6;
                case 10: goto L_0x01e6;
                default: goto L_0x007b;
            }
        L_0x007b:
            switch(r1) {
                case 39: goto L_0x00c7;
                case 40: goto L_0x00c1;
                case 41: goto L_0x00b9;
                default: goto L_0x007e;
            }
        L_0x007e:
            int r2 = r15.bp
            int r3 = r15.len
            if (r2 == r3) goto L_0x008d
            if (r1 != r9) goto L_0x008b
            int r2 = r2 + 1
            if (r2 != r3) goto L_0x008b
            goto L_0x008d
        L_0x008b:
            r1 = 0
            goto L_0x008e
        L_0x008d:
            r1 = 1
        L_0x008e:
            if (r1 == 0) goto L_0x00a7
            int r0 = r15.token
            r1 = 20
            if (r0 == r1) goto L_0x009f
            r15.token = r1
            int r0 = r15.eofPos
            r15.bp = r0
            r15.pos = r0
            goto L_0x00b8
        L_0x009f:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.String r1 = "EOF error"
            r0.<init>(r1)
            throw r0
        L_0x00a7:
            char r1 = r15.ch
            r2 = 31
            if (r1 <= r2) goto L_0x01e6
            r2 = 127(0x7f, float:1.78E-43)
            if (r1 != r2) goto L_0x00b3
            goto L_0x01e6
        L_0x00b3:
            r15.token = r8
            r15.next()
        L_0x00b8:
            return
        L_0x00b9:
            r15.next()
            r0 = 11
            r15.token = r0
            return
        L_0x00c1:
            r15.next()
            r15.token = r13
            return
        L_0x00c7:
            r15.scanString()
            return
        L_0x00cb:
            java.lang.String r0 = r15.text
            int r1 = r15.bp
            java.lang.String r8 = "true"
            boolean r0 = r0.startsWith(r8, r1)
            if (r0 == 0) goto L_0x00fd
            int r0 = r15.bp
            int r0 = r0 + 4
            r15.bp = r0
            char r0 = r15.charAt(r0)
            r15.ch = r0
            if (r0 == r5) goto L_0x00f9
            if (r0 == r2) goto L_0x00f9
            if (r0 == r14) goto L_0x00f9
            if (r0 == r7) goto L_0x00f9
            if (r0 == r13) goto L_0x00f9
            if (r0 == r4) goto L_0x00f9
            if (r0 == r11) goto L_0x00f9
            if (r0 == r9) goto L_0x00f9
            if (r0 == r3) goto L_0x00f9
            if (r0 == r12) goto L_0x00f9
            if (r0 != r6) goto L_0x00fd
        L_0x00f9:
            r0 = 6
            r15.token = r0
            return
        L_0x00fd:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.String r1 = "scan true error"
            r0.<init>(r1)
            throw r0
        L_0x0105:
            r15.scanIdent()
            return
        L_0x0109:
            int r0 = r15.bp
            int r0 = r0 + r8
            r15.bp = r0
            int r1 = r15.len
            if (r0 < r1) goto L_0x0113
            goto L_0x0119
        L_0x0113:
            java.lang.String r1 = r15.text
            char r9 = r1.charAt(r0)
        L_0x0119:
            r15.ch = r9
            r15.token = r4
            return
        L_0x011e:
            int r0 = r15.bp
            int r0 = r0 + r8
            r15.bp = r0
            int r1 = r15.len
            if (r0 < r1) goto L_0x0128
            goto L_0x012e
        L_0x0128:
            java.lang.String r1 = r15.text
            char r9 = r1.charAt(r0)
        L_0x012e:
            r15.ch = r9
            r15.token = r3
            return
        L_0x0133:
            java.lang.String r1 = r15.text
            int r6 = r15.bp
            java.lang.String r8 = "null"
            boolean r1 = r1.startsWith(r8, r6)
            if (r1 == 0) goto L_0x0148
            int r0 = r15.bp
            int r0 = r0 + 4
            r15.bp = r0
            r0 = 8
            goto L_0x015c
        L_0x0148:
            java.lang.String r1 = r15.text
            int r6 = r15.bp
            java.lang.String r8 = "new"
            boolean r1 = r1.startsWith(r8, r6)
            if (r1 == 0) goto L_0x015c
            int r0 = r15.bp
            int r0 = r0 + 3
            r15.bp = r0
            r0 = 9
        L_0x015c:
            if (r0 == 0) goto L_0x017d
            int r1 = r15.bp
            char r1 = r15.charAt(r1)
            r15.ch = r1
            if (r1 == r5) goto L_0x017a
            if (r1 == r2) goto L_0x017a
            if (r1 == r14) goto L_0x017a
            if (r1 == r7) goto L_0x017a
            if (r1 == r13) goto L_0x017a
            if (r1 == r4) goto L_0x017a
            if (r1 == r11) goto L_0x017a
            if (r1 == r9) goto L_0x017a
            if (r1 == r3) goto L_0x017a
            if (r1 != r12) goto L_0x017d
        L_0x017a:
            r15.token = r0
            return
        L_0x017d:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.String r1 = "scan null/new error"
            r0.<init>(r1)
            throw r0
        L_0x0185:
            java.lang.String r0 = r15.text
            int r1 = r15.bp
            java.lang.String r8 = "false"
            boolean r0 = r0.startsWith(r8, r1)
            if (r0 == 0) goto L_0x01b7
            int r0 = r15.bp
            int r0 = r0 + 5
            r15.bp = r0
            char r0 = r15.charAt(r0)
            r15.ch = r0
            if (r0 == r5) goto L_0x01b3
            if (r0 == r2) goto L_0x01b3
            if (r0 == r14) goto L_0x01b3
            if (r0 == r7) goto L_0x01b3
            if (r0 == r13) goto L_0x01b3
            if (r0 == r4) goto L_0x01b3
            if (r0 == r11) goto L_0x01b3
            if (r0 == r9) goto L_0x01b3
            if (r0 == r3) goto L_0x01b3
            if (r0 == r12) goto L_0x01b3
            if (r0 != r6) goto L_0x01b7
        L_0x01b3:
            r0 = 7
            r15.token = r0
            return
        L_0x01b7:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.String r1 = "scan false error"
            r0.<init>(r1)
            throw r0
        L_0x01bf:
            r15.next()
            r0 = 15
            r15.token = r0
            return
        L_0x01c7:
            int r0 = r15.bp
            int r0 = r0 + r8
            r15.bp = r0
            int r1 = r15.len
            if (r0 < r1) goto L_0x01d1
            goto L_0x01d7
        L_0x01d1:
            java.lang.String r1 = r15.text
            char r9 = r1.charAt(r0)
        L_0x01d7:
            r15.ch = r9
            r0 = 14
            r15.token = r0
            return
        L_0x01de:
            r15.next()
            r0 = 17
            r15.token = r0
            return
        L_0x01e6:
            r15.next()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.nextToken():void");
    }

    public final void nextToken(int i) {
        this.sp = 0;
        while (true) {
            if (i != 2) {
                char c2 = EOI;
                if (i == 4) {
                    char c3 = this.ch;
                    if (c3 == '\"') {
                        this.pos = this.bp;
                        scanString();
                        return;
                    } else if (c3 >= '0' && c3 <= '9') {
                        this.pos = this.bp;
                        scanNumber();
                        return;
                    } else if (this.ch == '{') {
                        this.token = 12;
                        int i2 = this.bp + 1;
                        this.bp = i2;
                        if (i2 < this.len) {
                            c2 = this.text.charAt(i2);
                        }
                        this.ch = c2;
                        return;
                    }
                } else if (i == 12) {
                    char c4 = this.ch;
                    if (c4 == '{') {
                        this.token = 12;
                        int i3 = this.bp + 1;
                        this.bp = i3;
                        if (i3 < this.len) {
                            c2 = this.text.charAt(i3);
                        }
                        this.ch = c2;
                        return;
                    } else if (c4 == '[') {
                        this.token = 14;
                        int i4 = this.bp + 1;
                        this.bp = i4;
                        if (i4 < this.len) {
                            c2 = this.text.charAt(i4);
                        }
                        this.ch = c2;
                        return;
                    }
                } else if (i != 18) {
                    if (i != 20) {
                        switch (i) {
                            case 14:
                                char c5 = this.ch;
                                if (c5 == '[') {
                                    this.token = 14;
                                    next();
                                    return;
                                } else if (c5 == '{') {
                                    this.token = 12;
                                    next();
                                    return;
                                }
                                break;
                            case 15:
                                if (this.ch == ']') {
                                    this.token = 15;
                                    next();
                                    return;
                                }
                                break;
                            case 16:
                                char c6 = this.ch;
                                if (c6 == ',') {
                                    this.token = 16;
                                    int i5 = this.bp + 1;
                                    this.bp = i5;
                                    if (i5 < this.len) {
                                        c2 = this.text.charAt(i5);
                                    }
                                    this.ch = c2;
                                    return;
                                } else if (c6 == '}') {
                                    this.token = 13;
                                    int i6 = this.bp + 1;
                                    this.bp = i6;
                                    if (i6 < this.len) {
                                        c2 = this.text.charAt(i6);
                                    }
                                    this.ch = c2;
                                    return;
                                } else if (c6 == ']') {
                                    this.token = 15;
                                    int i7 = this.bp + 1;
                                    this.bp = i7;
                                    if (i7 < this.len) {
                                        c2 = this.text.charAt(i7);
                                    }
                                    this.ch = c2;
                                    return;
                                } else if (c6 == 26) {
                                    this.token = 20;
                                    return;
                                }
                                break;
                        }
                    }
                    if (this.ch == 26) {
                        this.token = 20;
                        return;
                    }
                } else {
                    nextIdent();
                    return;
                }
            } else {
                char c7 = this.ch;
                if (c7 < '0' || c7 > '9') {
                    char c8 = this.ch;
                    if (c8 == '\"') {
                        this.pos = this.bp;
                        scanString();
                        return;
                    } else if (c8 == '[') {
                        this.token = 14;
                        next();
                        return;
                    } else if (c8 == '{') {
                        this.token = 12;
                        next();
                        return;
                    }
                } else {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                }
            }
            char c9 = this.ch;
            if (c9 == ' ' || c9 == 10 || c9 == 13 || c9 == 9 || c9 == 12 || c9 == 8) {
                next();
            } else {
                nextToken();
                return;
            }
        }
    }

    public final void nextTokenWithChar(char c2) {
        this.sp = 0;
        while (true) {
            char c3 = this.ch;
            if (c3 == c2) {
                int i = this.bp + 1;
                this.bp = i;
                this.ch = i >= this.len ? EOI : this.text.charAt(i);
                nextToken();
                return;
            } else if (c3 == ' ' || c3 == 10 || c3 == 13 || c3 == 9 || c3 == 12 || c3 == 8) {
                next();
            } else {
                throw new JSONException("not match " + c2 + " - " + this.ch);
            }
        }
    }

    public final String numberString() {
        char charAt = this.text.charAt((this.np + this.sp) - 1);
        int i = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i--;
        }
        return subString(this.np, i);
    }

    public boolean scanBoolean() {
        boolean z = false;
        int i = 1;
        if (this.text.startsWith("false", this.bp)) {
            i = 5;
        } else if (this.text.startsWith("true", this.bp)) {
            z = true;
            i = 4;
        } else {
            char c2 = this.ch;
            if (c2 == '1') {
                z = true;
            } else if (c2 != '0') {
                this.matchStat = -1;
                return false;
            }
        }
        int i2 = this.bp + i;
        this.bp = i2;
        this.ch = charAt(i2);
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x010b, code lost:
        if (r3 >= r12.len) goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x012a, code lost:
        if (r3 >= r12.len) goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x013c, code lost:
        if (r3 >= r12.len) goto L_0x0114;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean scanFieldBoolean(long r13) {
        /*
            r12 = this;
            r0 = 0
            r12.matchStat = r0
            int r13 = r12.matchFieldHash(r13)
            if (r13 != 0) goto L_0x000a
            return r0
        L_0x000a:
            java.lang.String r14 = r12.text
            int r1 = r12.bp
            int r1 = r1 + r13
            java.lang.String r2 = "false"
            boolean r14 = r14.startsWith(r2, r1)
            r1 = 4
            r2 = -1
            r3 = 3
            r4 = 1
            if (r14 == 0) goto L_0x0020
            int r13 = r13 + 5
        L_0x001d:
            r14 = 0
            goto L_0x008c
        L_0x0020:
            java.lang.String r14 = r12.text
            int r5 = r12.bp
            int r5 = r5 + r13
            java.lang.String r6 = "true"
            boolean r14 = r14.startsWith(r6, r5)
            if (r14 == 0) goto L_0x0030
            int r13 = r13 + r1
        L_0x002e:
            r14 = 1
            goto L_0x008c
        L_0x0030:
            java.lang.String r14 = r12.text
            int r5 = r12.bp
            int r5 = r5 + r13
            java.lang.String r6 = "\"false\""
            boolean r14 = r14.startsWith(r6, r5)
            if (r14 == 0) goto L_0x0040
            int r13 = r13 + 7
            goto L_0x001d
        L_0x0040:
            java.lang.String r14 = r12.text
            int r5 = r12.bp
            int r5 = r5 + r13
            java.lang.String r6 = "\"true\""
            boolean r14 = r14.startsWith(r6, r5)
            if (r14 == 0) goto L_0x0050
            int r13 = r13 + 6
            goto L_0x002e
        L_0x0050:
            java.lang.String r14 = r12.text
            int r5 = r12.bp
            int r5 = r5 + r13
            char r14 = r14.charAt(r5)
            r5 = 49
            if (r14 != r5) goto L_0x005f
            int r13 = r13 + r4
            goto L_0x002e
        L_0x005f:
            java.lang.String r14 = r12.text
            int r5 = r12.bp
            int r5 = r5 + r13
            char r14 = r14.charAt(r5)
            r5 = 48
            if (r14 != r5) goto L_0x006e
            int r13 = r13 + r4
            goto L_0x001d
        L_0x006e:
            java.lang.String r14 = r12.text
            int r5 = r12.bp
            int r5 = r5 + r13
            java.lang.String r6 = "\"1\""
            boolean r14 = r14.startsWith(r6, r5)
            if (r14 == 0) goto L_0x007d
            int r13 = r13 + r3
            goto L_0x002e
        L_0x007d:
            java.lang.String r14 = r12.text
            int r5 = r12.bp
            int r5 = r5 + r13
            java.lang.String r6 = "\"0\""
            boolean r14 = r14.startsWith(r6, r5)
            if (r14 == 0) goto L_0x0155
            int r13 = r13 + r3
            goto L_0x001d
        L_0x008c:
            int r5 = r12.bp
            int r6 = r13 + 1
            int r5 = r5 + r13
            int r13 = r12.len
            r7 = 26
            if (r5 < r13) goto L_0x009a
            r13 = 26
            goto L_0x00a0
        L_0x009a:
            java.lang.String r13 = r12.text
            char r13 = r13.charAt(r5)
        L_0x00a0:
            r5 = 16
            r8 = 44
            if (r13 != r8) goto L_0x00c1
            int r13 = r12.bp
            int r6 = r6 - r4
            int r6 = r6 + r13
            r12.bp = r6
            int r6 = r6 + r4
            r12.bp = r6
            int r13 = r12.len
            if (r6 < r13) goto L_0x00b4
            goto L_0x00ba
        L_0x00b4:
            java.lang.String r13 = r12.text
            char r7 = r13.charAt(r6)
        L_0x00ba:
            r12.ch = r7
            r12.matchStat = r3
            r12.token = r5
            return r14
        L_0x00c1:
            r9 = 13
            r10 = 125(0x7d, float:1.75E-43)
            if (r13 == r10) goto L_0x00f1
            r11 = 32
            if (r13 == r11) goto L_0x00dd
            r11 = 10
            if (r13 == r11) goto L_0x00dd
            if (r13 == r9) goto L_0x00dd
            r11 = 9
            if (r13 == r11) goto L_0x00dd
            r11 = 12
            if (r13 == r11) goto L_0x00dd
            r11 = 8
            if (r13 != r11) goto L_0x00f1
        L_0x00dd:
            int r13 = r12.bp
            int r5 = r6 + 1
            int r13 = r13 + r6
            int r6 = r12.len
            if (r13 < r6) goto L_0x00e9
            r13 = 26
            goto L_0x00ef
        L_0x00e9:
            java.lang.String r6 = r12.text
            char r13 = r6.charAt(r13)
        L_0x00ef:
            r6 = r5
            goto L_0x00a0
        L_0x00f1:
            if (r13 != r10) goto L_0x0152
            int r13 = r12.bp
            int r3 = r6 + 1
            int r13 = r13 + r6
            char r13 = r12.charAt(r13)
            if (r13 != r8) goto L_0x0117
            r12.token = r5
            int r13 = r12.bp
            int r3 = r3 - r4
            int r3 = r3 + r13
            r12.bp = r3
            int r3 = r3 + r4
            r12.bp = r3
            int r13 = r12.len
            if (r3 < r13) goto L_0x010e
            goto L_0x0114
        L_0x010e:
            java.lang.String r13 = r12.text
            char r7 = r13.charAt(r3)
        L_0x0114:
            r12.ch = r7
            goto L_0x014c
        L_0x0117:
            r5 = 93
            if (r13 != r5) goto L_0x012d
            r13 = 15
            r12.token = r13
            int r13 = r12.bp
            int r3 = r3 - r4
            int r3 = r3 + r13
            r12.bp = r3
            int r3 = r3 + r4
            r12.bp = r3
            int r13 = r12.len
            if (r3 < r13) goto L_0x010e
            goto L_0x0114
        L_0x012d:
            if (r13 != r10) goto L_0x013f
            r12.token = r9
            int r13 = r12.bp
            int r3 = r3 - r4
            int r3 = r3 + r13
            r12.bp = r3
            int r3 = r3 + r4
            r12.bp = r3
            int r13 = r12.len
            if (r3 < r13) goto L_0x010e
            goto L_0x0114
        L_0x013f:
            if (r13 != r7) goto L_0x014f
            r13 = 20
            r12.token = r13
            int r13 = r12.bp
            int r3 = r3 - r4
            int r3 = r3 + r13
            r12.bp = r3
            goto L_0x0114
        L_0x014c:
            r12.matchStat = r1
            return r14
        L_0x014f:
            r12.matchStat = r2
            return r0
        L_0x0152:
            r12.matchStat = r2
            return r0
        L_0x0155:
            r12.matchStat = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldBoolean(long):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0102, code lost:
        if (r7 >= r11.len) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0123, code lost:
        if (r7 >= r11.len) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0139, code lost:
        if (r7 >= r11.len) goto L_0x010b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Date scanFieldDate(long r12) {
        /*
            r11 = this;
            r0 = 0
            r11.matchStat = r0
            int r12 = r11.matchFieldHash(r12)
            r13 = 0
            if (r12 != 0) goto L_0x000b
            return r13
        L_0x000b:
            int r1 = r11.bp
            int r2 = r12 + 1
            int r12 = r12 + r1
            int r3 = r11.len
            r4 = 26
            if (r12 < r3) goto L_0x0019
            r12 = 26
            goto L_0x001f
        L_0x0019:
            java.lang.String r3 = r11.text
            char r12 = r3.charAt(r12)
        L_0x001f:
            r3 = 34
            r5 = -1
            if (r12 != r3) goto L_0x0068
            int r12 = r11.bp
            int r6 = r12 + r2
            int r7 = r2 + 1
            int r12 = r12 + r2
            int r2 = r11.len
            if (r12 < r2) goto L_0x0030
            goto L_0x0035
        L_0x0030:
            java.lang.String r2 = r11.text
            r2.charAt(r12)
        L_0x0035:
            java.lang.String r12 = r11.text
            int r2 = r11.bp
            int r2 = r2 + r7
            int r12 = r12.indexOf(r3, r2)
            if (r12 == r5) goto L_0x0060
            int r12 = r12 - r6
            r11.bp = r6
            boolean r0 = r11.scanISO8601DateIfMatch(r0, r12)
            if (r0 == 0) goto L_0x005b
            java.util.Calendar r0 = r11.calendar
            java.util.Date r0 = r0.getTime()
            int r7 = r7 + r12
            int r12 = r7 + 1
            int r7 = r7 + r1
            char r2 = r11.charAt(r7)
            r11.bp = r1
            goto L_0x00c0
        L_0x005b:
            r11.bp = r1
            r11.matchStat = r5
            return r13
        L_0x0060:
            com.alibaba.fastjson.JSONException r12 = new com.alibaba.fastjson.JSONException
            java.lang.String r13 = "unclosed str"
            r12.<init>(r13)
            throw r12
        L_0x0068:
            r0 = 48
            if (r12 < r0) goto L_0x0154
            r1 = 57
            if (r12 > r1) goto L_0x0154
            int r12 = r12 - r0
            long r6 = (long) r12
        L_0x0072:
            int r12 = r11.bp
            int r8 = r2 + 1
            int r12 = r12 + r2
            int r2 = r11.len
            if (r12 < r2) goto L_0x007e
            r12 = 26
            goto L_0x0084
        L_0x007e:
            java.lang.String r2 = r11.text
            char r12 = r2.charAt(r12)
        L_0x0084:
            if (r12 < r0) goto L_0x0092
            if (r12 > r1) goto L_0x0092
            r9 = 10
            long r6 = r6 * r9
            int r12 = r12 + -48
            long r9 = (long) r12
            long r6 = r6 + r9
            r2 = r8
            goto L_0x0072
        L_0x0092:
            r0 = 46
            if (r12 != r0) goto L_0x0099
            r11.matchStat = r5
            return r13
        L_0x0099:
            if (r12 != r3) goto L_0x00b0
            int r12 = r11.bp
            int r0 = r8 + 1
            int r12 = r12 + r8
            int r1 = r11.len
            if (r12 < r1) goto L_0x00a7
            r12 = 26
            goto L_0x00ad
        L_0x00a7:
            java.lang.String r1 = r11.text
            char r12 = r1.charAt(r12)
        L_0x00ad:
            r2 = r12
            r12 = r0
            goto L_0x00b2
        L_0x00b0:
            r2 = r12
            r12 = r8
        L_0x00b2:
            r0 = 0
            int r3 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r3 >= 0) goto L_0x00bb
            r11.matchStat = r5
            return r13
        L_0x00bb:
            java.util.Date r0 = new java.util.Date
            r0.<init>(r6)
        L_0x00c0:
            r1 = 16
            r3 = 44
            if (r2 != r3) goto L_0x00e4
            int r13 = r11.bp
            int r12 = r12 + -1
            int r12 = r12 + r13
            r11.bp = r12
            int r12 = r12 + 1
            r11.bp = r12
            int r13 = r11.len
            if (r12 < r13) goto L_0x00d6
            goto L_0x00dc
        L_0x00d6:
            java.lang.String r13 = r11.text
            char r4 = r13.charAt(r12)
        L_0x00dc:
            r11.ch = r4
            r12 = 3
            r11.matchStat = r12
            r11.token = r1
            return r0
        L_0x00e4:
            r6 = 125(0x7d, float:1.75E-43)
            if (r2 != r6) goto L_0x0151
            int r2 = r11.bp
            int r7 = r12 + 1
            int r2 = r2 + r12
            char r12 = r11.charAt(r2)
            if (r12 != r3) goto L_0x010e
            r11.token = r1
            int r12 = r11.bp
            int r7 = r7 + -1
            int r7 = r7 + r12
            r11.bp = r7
            int r7 = r7 + 1
            r11.bp = r7
            int r12 = r11.len
            if (r7 < r12) goto L_0x0105
            goto L_0x010b
        L_0x0105:
            java.lang.String r12 = r11.text
            char r4 = r12.charAt(r7)
        L_0x010b:
            r11.ch = r4
            goto L_0x014a
        L_0x010e:
            r1 = 93
            if (r12 != r1) goto L_0x0126
            r12 = 15
            r11.token = r12
            int r12 = r11.bp
            int r7 = r7 + -1
            int r7 = r7 + r12
            r11.bp = r7
            int r7 = r7 + 1
            r11.bp = r7
            int r12 = r11.len
            if (r7 < r12) goto L_0x0105
            goto L_0x010b
        L_0x0126:
            if (r12 != r6) goto L_0x013c
            r12 = 13
            r11.token = r12
            int r12 = r11.bp
            int r7 = r7 + -1
            int r7 = r7 + r12
            r11.bp = r7
            int r7 = r7 + 1
            r11.bp = r7
            int r12 = r11.len
            if (r7 < r12) goto L_0x0105
            goto L_0x010b
        L_0x013c:
            if (r12 != r4) goto L_0x014e
            r12 = 20
            r11.token = r12
            int r12 = r11.bp
            int r7 = r7 + -1
            int r7 = r7 + r12
            r11.bp = r7
            goto L_0x010b
        L_0x014a:
            r12 = 4
            r11.matchStat = r12
            return r0
        L_0x014e:
            r11.matchStat = r5
            return r13
        L_0x0151:
            r11.matchStat = r5
            return r13
        L_0x0154:
            r11.matchStat = r5
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldDate(long):java.util.Date");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final double scanFieldDouble(long r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = 0
            r0.matchStat = r1
            int r2 = r18.matchFieldHash(r19)
            r3 = 0
            if (r2 != 0) goto L_0x000e
            return r3
        L_0x000e:
            int r5 = r0.bp
            int r6 = r2 + 1
            int r5 = r5 + r2
            char r2 = r0.charAt(r5)
            int r5 = r0.bp
            int r5 = r5 + r6
            r7 = 1
            int r5 = r5 - r7
            r8 = 45
            if (r2 != r8) goto L_0x0022
            r9 = 1
            goto L_0x0023
        L_0x0022:
            r9 = 0
        L_0x0023:
            if (r9 == 0) goto L_0x002f
            int r2 = r0.bp
            int r10 = r6 + 1
            int r2 = r2 + r6
            char r2 = r0.charAt(r2)
            r6 = r10
        L_0x002f:
            r10 = -1
            r11 = 48
            if (r2 < r11) goto L_0x013b
            r12 = 57
            if (r2 > r12) goto L_0x013b
            int r2 = r2 - r11
        L_0x0039:
            int r13 = r0.bp
            int r14 = r6 + 1
            int r13 = r13 + r6
            char r6 = r0.charAt(r13)
            if (r6 < r11) goto L_0x004d
            if (r6 > r12) goto L_0x004d
            int r2 = r2 * 10
            int r6 = r6 + -48
            int r2 = r2 + r6
            r6 = r14
            goto L_0x0039
        L_0x004d:
            r13 = 46
            if (r6 != r13) goto L_0x0053
            r13 = 1
            goto L_0x0054
        L_0x0053:
            r13 = 0
        L_0x0054:
            r15 = 10
            if (r13 == 0) goto L_0x008e
            int r6 = r0.bp
            int r13 = r14 + 1
            int r6 = r6 + r14
            char r6 = r0.charAt(r6)
            if (r6 < r11) goto L_0x008b
            if (r6 > r12) goto L_0x008b
            int r2 = r2 * 10
            int r6 = r6 - r11
            int r6 = r6 + r2
            r2 = r6
            r6 = 10
        L_0x006c:
            int r14 = r0.bp
            int r16 = r13 + 1
            int r14 = r14 + r13
            char r13 = r0.charAt(r14)
            if (r13 < r11) goto L_0x0083
            if (r13 > r12) goto L_0x0083
            int r2 = r2 * 10
            int r13 = r13 + -48
            int r2 = r2 + r13
            int r6 = r6 * 10
            r13 = r16
            goto L_0x006c
        L_0x0083:
            r14 = r16
            r17 = r13
            r13 = r6
            r6 = r17
            goto L_0x008f
        L_0x008b:
            r0.matchStat = r10
            return r3
        L_0x008e:
            r13 = 1
        L_0x008f:
            r1 = 101(0x65, float:1.42E-43)
            if (r6 == r1) goto L_0x009a
            r1 = 69
            if (r6 != r1) goto L_0x0098
            goto L_0x009a
        L_0x0098:
            r1 = 0
            goto L_0x009b
        L_0x009a:
            r1 = 1
        L_0x009b:
            if (r1 == 0) goto L_0x00c5
            int r6 = r0.bp
            int r16 = r14 + 1
            int r6 = r6 + r14
            char r6 = r0.charAt(r6)
            r14 = 43
            if (r6 == r14) goto L_0x00b0
            if (r6 != r8) goto L_0x00ad
            goto L_0x00b0
        L_0x00ad:
            r14 = r16
            goto L_0x00bb
        L_0x00b0:
            int r6 = r0.bp
            int r8 = r16 + 1
            int r6 = r6 + r16
        L_0x00b6:
            char r6 = r0.charAt(r6)
            r14 = r8
        L_0x00bb:
            if (r6 < r11) goto L_0x00c5
            if (r6 > r12) goto L_0x00c5
            int r6 = r0.bp
            int r8 = r14 + 1
            int r6 = r6 + r14
            goto L_0x00b6
        L_0x00c5:
            int r8 = r0.bp
            int r8 = r8 + r14
            int r8 = r8 - r5
            int r8 = r8 - r7
            if (r1 != 0) goto L_0x00db
            if (r8 >= r15) goto L_0x00db
            double r1 = (double) r2
            double r11 = (double) r13
            java.lang.Double.isNaN(r1)
            java.lang.Double.isNaN(r11)
            double r1 = r1 / r11
            if (r9 == 0) goto L_0x00e3
            double r1 = -r1
            goto L_0x00e3
        L_0x00db:
            java.lang.String r1 = r0.subString(r5, r8)
            double r1 = java.lang.Double.parseDouble(r1)
        L_0x00e3:
            r5 = 16
            r8 = 44
            if (r6 != r8) goto L_0x00f8
            int r3 = r0.bp
            int r14 = r14 - r7
            int r14 = r14 + r3
            r0.bp = r14
            r18.next()
            r3 = 3
            r0.matchStat = r3
            r0.token = r5
            return r1
        L_0x00f8:
            r9 = 125(0x7d, float:1.75E-43)
            if (r6 != r9) goto L_0x0138
            int r6 = r0.bp
            int r11 = r14 + 1
            int r6 = r6 + r14
            char r6 = r0.charAt(r6)
            if (r6 != r8) goto L_0x0113
            r0.token = r5
        L_0x0109:
            int r3 = r0.bp
            int r11 = r11 - r7
            int r11 = r11 + r3
            r0.bp = r11
            r18.next()
            goto L_0x0131
        L_0x0113:
            r5 = 93
            if (r6 != r5) goto L_0x011c
            r3 = 15
        L_0x0119:
            r0.token = r3
            goto L_0x0109
        L_0x011c:
            if (r6 != r9) goto L_0x0121
            r3 = 13
            goto L_0x0119
        L_0x0121:
            r5 = 26
            if (r6 != r5) goto L_0x0135
            int r3 = r0.bp
            int r11 = r11 - r7
            int r11 = r11 + r3
            r0.bp = r11
            r3 = 20
            r0.token = r3
            r0.ch = r5
        L_0x0131:
            r3 = 4
            r0.matchStat = r3
            return r1
        L_0x0135:
            r0.matchStat = r10
            return r3
        L_0x0138:
            r0.matchStat = r10
            return r3
        L_0x013b:
            r0.matchStat = r10
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldDouble(long):double");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00d3, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0109, code lost:
        if (r3 >= r0.len) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x010e, code lost:
        r3 = r0.text.charAt(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0123, code lost:
        if (r3 < r0.len) goto L_0x010e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final double[] scanFieldDoubleArray(long r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = 0
            r0.matchStat = r1
            int r2 = r18.matchFieldHash(r19)
            r3 = 0
            if (r2 != 0) goto L_0x000d
            return r3
        L_0x000d:
            int r4 = r0.bp
            int r5 = r2 + 1
            int r4 = r4 + r2
            int r2 = r0.len
            if (r4 < r2) goto L_0x0019
            r2 = 26
            goto L_0x001f
        L_0x0019:
            java.lang.String r2 = r0.text
            char r2 = r2.charAt(r4)
        L_0x001f:
            r4 = 91
            r7 = -1
            if (r2 == r4) goto L_0x0027
            r0.matchStat = r7
            return r3
        L_0x0027:
            int r2 = r0.bp
            int r4 = r5 + 1
            int r2 = r2 + r5
            int r5 = r0.len
            if (r2 < r5) goto L_0x0033
            r2 = 26
            goto L_0x0039
        L_0x0033:
            java.lang.String r5 = r0.text
            char r2 = r5.charAt(r2)
        L_0x0039:
            r5 = 16
            double[] r8 = new double[r5]
            r9 = 0
        L_0x003e:
            int r10 = r0.bp
            int r10 = r10 + r4
            r11 = 1
            int r10 = r10 - r11
            r12 = 45
            if (r2 != r12) goto L_0x0049
            r13 = 1
            goto L_0x004a
        L_0x0049:
            r13 = 0
        L_0x004a:
            if (r13 == 0) goto L_0x005f
            int r2 = r0.bp
            int r14 = r4 + 1
            int r2 = r2 + r4
            int r4 = r0.len
            if (r2 < r4) goto L_0x0058
            r2 = 26
            goto L_0x005e
        L_0x0058:
            java.lang.String r4 = r0.text
            char r2 = r4.charAt(r2)
        L_0x005e:
            r4 = r14
        L_0x005f:
            r14 = 48
            if (r2 < r14) goto L_0x0203
            r15 = 57
            if (r2 > r15) goto L_0x0203
            int r2 = r2 + -48
        L_0x0069:
            int r6 = r0.bp
            int r16 = r4 + 1
            int r6 = r6 + r4
            int r4 = r0.len
            if (r6 < r4) goto L_0x0075
            r4 = 26
            goto L_0x007b
        L_0x0075:
            java.lang.String r4 = r0.text
            char r4 = r4.charAt(r6)
        L_0x007b:
            if (r4 < r14) goto L_0x0087
            if (r4 > r15) goto L_0x0087
            int r2 = r2 * 10
            int r4 = r4 + -48
            int r2 = r2 + r4
            r4 = r16
            goto L_0x0069
        L_0x0087:
            r6 = 46
            if (r4 != r6) goto L_0x008d
            r6 = 1
            goto L_0x008e
        L_0x008d:
            r6 = 0
        L_0x008e:
            r5 = 10
            if (r6 == 0) goto L_0x00d4
            int r4 = r0.bp
            int r6 = r16 + 1
            int r4 = r4 + r16
            int r1 = r0.len
            if (r4 < r1) goto L_0x009f
            r1 = 26
            goto L_0x00a5
        L_0x009f:
            java.lang.String r1 = r0.text
            char r1 = r1.charAt(r4)
        L_0x00a5:
            if (r1 < r14) goto L_0x00d1
            if (r1 > r15) goto L_0x00d1
            int r2 = r2 * 10
            int r1 = r1 + -48
            int r1 = r1 + r2
            r2 = r1
            r1 = 10
        L_0x00b1:
            int r4 = r0.bp
            int r16 = r6 + 1
            int r4 = r4 + r6
            int r6 = r0.len
            if (r4 < r6) goto L_0x00bd
            r4 = 26
            goto L_0x00c3
        L_0x00bd:
            java.lang.String r6 = r0.text
            char r4 = r6.charAt(r4)
        L_0x00c3:
            if (r4 < r14) goto L_0x00d5
            if (r4 > r15) goto L_0x00d5
            int r2 = r2 * 10
            int r4 = r4 + -48
            int r2 = r2 + r4
            int r1 = r1 * 10
            r6 = r16
            goto L_0x00b1
        L_0x00d1:
            r0.matchStat = r7
            return r3
        L_0x00d4:
            r1 = 1
        L_0x00d5:
            r6 = 101(0x65, float:1.42E-43)
            if (r4 == r6) goto L_0x00e0
            r6 = 69
            if (r4 != r6) goto L_0x00de
            goto L_0x00e0
        L_0x00de:
            r6 = 0
            goto L_0x00e1
        L_0x00e0:
            r6 = 1
        L_0x00e1:
            if (r6 == 0) goto L_0x0126
            int r4 = r0.bp
            int r17 = r16 + 1
            int r4 = r4 + r16
            int r3 = r0.len
            if (r4 < r3) goto L_0x00f0
            r3 = 26
            goto L_0x00f6
        L_0x00f0:
            java.lang.String r3 = r0.text
            char r3 = r3.charAt(r4)
        L_0x00f6:
            r4 = 43
            if (r3 == r4) goto L_0x0101
            if (r3 != r12) goto L_0x00fd
            goto L_0x0101
        L_0x00fd:
            r4 = r3
            r16 = r17
            goto L_0x0117
        L_0x0101:
            int r3 = r0.bp
            int r4 = r17 + 1
            int r3 = r3 + r17
            int r12 = r0.len
            if (r3 < r12) goto L_0x010e
        L_0x010b:
            r3 = 26
            goto L_0x0114
        L_0x010e:
            java.lang.String r12 = r0.text
            char r3 = r12.charAt(r3)
        L_0x0114:
            r16 = r4
            r4 = r3
        L_0x0117:
            if (r4 < r14) goto L_0x0126
            if (r4 > r15) goto L_0x0126
            int r3 = r0.bp
            int r4 = r16 + 1
            int r3 = r3 + r16
            int r12 = r0.len
            if (r3 < r12) goto L_0x010e
            goto L_0x010b
        L_0x0126:
            int r3 = r0.bp
            int r3 = r3 + r16
            int r3 = r3 - r10
            int r3 = r3 - r11
            if (r6 != 0) goto L_0x013d
            if (r3 >= r5) goto L_0x013d
            double r2 = (double) r2
            double r5 = (double) r1
            java.lang.Double.isNaN(r2)
            java.lang.Double.isNaN(r5)
            double r2 = r2 / r5
            if (r13 == 0) goto L_0x0145
            double r2 = -r2
            goto L_0x0145
        L_0x013d:
            java.lang.String r1 = r0.subString(r10, r3)
            double r2 = java.lang.Double.parseDouble(r1)
        L_0x0145:
            int r1 = r8.length
            r5 = 3
            if (r9 < r1) goto L_0x0155
            int r1 = r8.length
            int r1 = r1 * 3
            int r1 = r1 / 2
            double[] r1 = new double[r1]
            r6 = 0
            java.lang.System.arraycopy(r8, r6, r1, r6, r9)
            r8 = r1
        L_0x0155:
            int r6 = r9 + 1
            r8[r9] = r2
            r1 = 44
            if (r4 != r1) goto L_0x0175
            int r1 = r0.bp
            int r2 = r16 + 1
            int r1 = r1 + r16
            int r3 = r0.len
            if (r1 < r3) goto L_0x016a
            r1 = 26
            goto L_0x0170
        L_0x016a:
            java.lang.String r3 = r0.text
            char r1 = r3.charAt(r1)
        L_0x0170:
            r4 = r1
            r16 = r2
            goto L_0x01f4
        L_0x0175:
            r2 = 93
            if (r4 != r2) goto L_0x01f4
            int r3 = r0.bp
            int r4 = r16 + 1
            int r3 = r3 + r16
            int r9 = r0.len
            if (r3 < r9) goto L_0x0186
            r3 = 26
            goto L_0x018c
        L_0x0186:
            java.lang.String r9 = r0.text
            char r3 = r9.charAt(r3)
        L_0x018c:
            int r9 = r8.length
            if (r6 == r9) goto L_0x0196
            double[] r9 = new double[r6]
            r10 = 0
            java.lang.System.arraycopy(r8, r10, r9, r10, r6)
            r8 = r9
        L_0x0196:
            if (r3 != r1) goto L_0x01a8
            int r1 = r0.bp
            int r4 = r4 - r11
            int r4 = r4 + r1
            r0.bp = r4
            r18.next()
            r0.matchStat = r5
            r1 = 16
            r0.token = r1
            return r8
        L_0x01a8:
            r5 = 125(0x7d, float:1.75E-43)
            if (r3 != r5) goto L_0x01f0
            int r3 = r0.bp
            int r6 = r4 + 1
            int r3 = r3 + r4
            int r4 = r0.len
            if (r3 < r4) goto L_0x01b8
            r3 = 26
            goto L_0x01be
        L_0x01b8:
            java.lang.String r4 = r0.text
            char r3 = r4.charAt(r3)
        L_0x01be:
            if (r3 != r1) goto L_0x01ce
            r1 = 16
        L_0x01c2:
            r0.token = r1
            int r1 = r0.bp
            int r6 = r6 - r11
            int r6 = r6 + r1
            r0.bp = r6
            r18.next()
            goto L_0x01e8
        L_0x01ce:
            if (r3 != r2) goto L_0x01d3
            r1 = 15
            goto L_0x01c2
        L_0x01d3:
            if (r3 != r5) goto L_0x01d8
            r1 = 13
            goto L_0x01c2
        L_0x01d8:
            r2 = 26
            if (r3 != r2) goto L_0x01ec
            int r1 = r0.bp
            int r6 = r6 - r11
            int r6 = r6 + r1
            r0.bp = r6
            r1 = 20
            r0.token = r1
            r0.ch = r2
        L_0x01e8:
            r1 = 4
            r0.matchStat = r1
            return r8
        L_0x01ec:
            r0.matchStat = r7
            r3 = 0
            return r3
        L_0x01f0:
            r3 = 0
            r0.matchStat = r7
            return r3
        L_0x01f4:
            r1 = 16
            r2 = 26
            r3 = 0
            r10 = 0
            r2 = r4
            r9 = r6
            r4 = r16
            r1 = 0
            r5 = 16
            goto L_0x003e
        L_0x0203:
            r0.matchStat = r7
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldDoubleArray(long):double[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:162:0x027f, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x011c, code lost:
        if (r3 >= r0.len) goto L_0x011e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0121, code lost:
        r3 = r0.text.charAt(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0136, code lost:
        if (r3 < r0.len) goto L_0x0121;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final double[][] scanFieldDoubleArray2(long r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = 0
            r0.matchStat = r1
            int r2 = r20.matchFieldHash(r21)
            r3 = 0
            if (r2 != 0) goto L_0x000d
            return r3
        L_0x000d:
            int r4 = r0.bp
            int r5 = r2 + 1
            int r4 = r4 + r2
            int r2 = r0.len
            if (r4 < r2) goto L_0x0019
            r2 = 26
            goto L_0x001f
        L_0x0019:
            java.lang.String r2 = r0.text
            char r2 = r2.charAt(r4)
        L_0x001f:
            r4 = 91
            r7 = -1
            if (r2 == r4) goto L_0x0027
            r0.matchStat = r7
            return r3
        L_0x0027:
            int r2 = r0.bp
            int r8 = r5 + 1
            int r2 = r2 + r5
            int r5 = r0.len
            if (r2 < r5) goto L_0x0033
            r2 = 26
            goto L_0x0039
        L_0x0033:
            java.lang.String r5 = r0.text
            char r2 = r5.charAt(r2)
        L_0x0039:
            r5 = 16
            double[][] r9 = new double[r5][]
            r10 = 0
        L_0x003e:
            if (r2 != r4) goto L_0x0280
            int r2 = r0.bp
            int r11 = r8 + 1
            int r2 = r2 + r8
            int r8 = r0.len
            if (r2 < r8) goto L_0x004c
            r2 = 26
            goto L_0x0052
        L_0x004c:
            java.lang.String r8 = r0.text
            char r2 = r8.charAt(r2)
        L_0x0052:
            double[] r8 = new double[r5]
            r12 = 0
        L_0x0055:
            int r13 = r0.bp
            int r13 = r13 + r11
            r14 = 1
            int r13 = r13 - r14
            r15 = 45
            if (r2 != r15) goto L_0x0061
            r16 = 1
            goto L_0x0063
        L_0x0061:
            r16 = 0
        L_0x0063:
            if (r16 == 0) goto L_0x0079
            int r2 = r0.bp
            int r17 = r11 + 1
            int r2 = r2 + r11
            int r11 = r0.len
            if (r2 < r11) goto L_0x0071
            r2 = 26
            goto L_0x0077
        L_0x0071:
            java.lang.String r11 = r0.text
            char r2 = r11.charAt(r2)
        L_0x0077:
            r11 = r17
        L_0x0079:
            r4 = 48
            if (r2 < r4) goto L_0x027c
            r6 = 57
            if (r2 > r6) goto L_0x027c
            int r2 = r2 + -48
        L_0x0083:
            int r5 = r0.bp
            int r18 = r11 + 1
            int r5 = r5 + r11
            int r11 = r0.len
            if (r5 < r11) goto L_0x008f
            r5 = 26
            goto L_0x0095
        L_0x008f:
            java.lang.String r11 = r0.text
            char r5 = r11.charAt(r5)
        L_0x0095:
            if (r5 < r4) goto L_0x00a1
            if (r5 > r6) goto L_0x00a1
            int r2 = r2 * 10
            int r5 = r5 + -48
            int r2 = r2 + r5
            r11 = r18
            goto L_0x0083
        L_0x00a1:
            r11 = 46
            if (r5 != r11) goto L_0x00e7
            int r5 = r0.bp
            int r11 = r18 + 1
            int r5 = r5 + r18
            int r1 = r0.len
            if (r5 < r1) goto L_0x00b2
            r1 = 26
            goto L_0x00b8
        L_0x00b2:
            java.lang.String r1 = r0.text
            char r1 = r1.charAt(r5)
        L_0x00b8:
            if (r1 < r4) goto L_0x00e4
            if (r1 > r6) goto L_0x00e4
            int r2 = r2 * 10
            int r1 = r1 + -48
            int r1 = r1 + r2
            r2 = r1
            r1 = 10
        L_0x00c4:
            int r5 = r0.bp
            int r18 = r11 + 1
            int r5 = r5 + r11
            int r11 = r0.len
            if (r5 < r11) goto L_0x00d0
            r5 = 26
            goto L_0x00d6
        L_0x00d0:
            java.lang.String r11 = r0.text
            char r5 = r11.charAt(r5)
        L_0x00d6:
            if (r5 < r4) goto L_0x00e8
            if (r5 > r6) goto L_0x00e8
            int r2 = r2 * 10
            int r5 = r5 + -48
            int r2 = r2 + r5
            int r1 = r1 * 10
            r11 = r18
            goto L_0x00c4
        L_0x00e4:
            r0.matchStat = r7
            return r3
        L_0x00e7:
            r1 = 1
        L_0x00e8:
            r11 = 101(0x65, float:1.42E-43)
            if (r5 == r11) goto L_0x00f3
            r11 = 69
            if (r5 != r11) goto L_0x00f1
            goto L_0x00f3
        L_0x00f1:
            r11 = 0
            goto L_0x00f4
        L_0x00f3:
            r11 = 1
        L_0x00f4:
            if (r11 == 0) goto L_0x0139
            int r5 = r0.bp
            int r19 = r18 + 1
            int r5 = r5 + r18
            int r3 = r0.len
            if (r5 < r3) goto L_0x0103
            r3 = 26
            goto L_0x0109
        L_0x0103:
            java.lang.String r3 = r0.text
            char r3 = r3.charAt(r5)
        L_0x0109:
            r5 = 43
            if (r3 == r5) goto L_0x0114
            if (r3 != r15) goto L_0x0110
            goto L_0x0114
        L_0x0110:
            r5 = r3
            r18 = r19
            goto L_0x012a
        L_0x0114:
            int r3 = r0.bp
            int r5 = r19 + 1
            int r3 = r3 + r19
            int r15 = r0.len
            if (r3 < r15) goto L_0x0121
        L_0x011e:
            r3 = 26
            goto L_0x0127
        L_0x0121:
            java.lang.String r15 = r0.text
            char r3 = r15.charAt(r3)
        L_0x0127:
            r18 = r5
            r5 = r3
        L_0x012a:
            if (r5 < r4) goto L_0x0139
            if (r5 > r6) goto L_0x0139
            int r3 = r0.bp
            int r5 = r18 + 1
            int r3 = r3 + r18
            int r15 = r0.len
            if (r3 < r15) goto L_0x0121
            goto L_0x011e
        L_0x0139:
            int r3 = r0.bp
            int r3 = r3 + r18
            int r3 = r3 - r13
            int r3 = r3 - r14
            if (r11 != 0) goto L_0x0152
            r4 = 10
            if (r3 >= r4) goto L_0x0152
            double r2 = (double) r2
            double r14 = (double) r1
            java.lang.Double.isNaN(r2)
            java.lang.Double.isNaN(r14)
            double r2 = r2 / r14
            if (r16 == 0) goto L_0x015a
            double r2 = -r2
            goto L_0x015a
        L_0x0152:
            java.lang.String r1 = r0.subString(r13, r3)
            double r2 = java.lang.Double.parseDouble(r1)
        L_0x015a:
            int r1 = r8.length
            r6 = 3
            if (r12 < r1) goto L_0x016a
            int r1 = r8.length
            int r1 = r1 * 3
            int r1 = r1 / 2
            double[] r1 = new double[r1]
            r11 = 0
            java.lang.System.arraycopy(r8, r11, r1, r11, r12)
            r8 = r1
        L_0x016a:
            int r1 = r12 + 1
            r8[r12] = r2
            r2 = 44
            if (r5 != r2) goto L_0x018e
            int r2 = r0.bp
            int r3 = r18 + 1
            int r2 = r2 + r18
            int r4 = r0.len
            if (r2 < r4) goto L_0x017f
            r2 = 26
            goto L_0x0185
        L_0x017f:
            java.lang.String r4 = r0.text
            char r2 = r4.charAt(r2)
        L_0x0185:
            r11 = r3
            r3 = 26
            r4 = 0
            r6 = 16
            r12 = 0
            goto L_0x0273
        L_0x018e:
            r3 = 93
            if (r5 != r3) goto L_0x026a
            int r5 = r0.bp
            int r11 = r18 + 1
            int r5 = r5 + r18
            int r12 = r0.len
            if (r5 < r12) goto L_0x019f
            r5 = 26
            goto L_0x01a5
        L_0x019f:
            java.lang.String r12 = r0.text
            char r5 = r12.charAt(r5)
        L_0x01a5:
            int r12 = r8.length
            if (r1 == r12) goto L_0x01b0
            double[] r12 = new double[r1]
            r13 = 0
            java.lang.System.arraycopy(r8, r13, r12, r13, r1)
            r8 = r12
            goto L_0x01b1
        L_0x01b0:
            r13 = 0
        L_0x01b1:
            int r12 = r9.length
            if (r10 < r12) goto L_0x01be
            int r9 = r9.length
            int r9 = r9 * 3
            int r9 = r9 / 2
            double[][] r9 = new double[r9][]
            java.lang.System.arraycopy(r8, r13, r9, r13, r1)
        L_0x01be:
            int r1 = r10 + 1
            r9[r10] = r8
            if (r5 != r2) goto L_0x01df
            int r2 = r0.bp
            int r3 = r11 + 1
            int r2 = r2 + r11
            int r4 = r0.len
            if (r2 < r4) goto L_0x01d0
            r2 = 26
            goto L_0x01d6
        L_0x01d0:
            java.lang.String r4 = r0.text
            char r2 = r4.charAt(r2)
        L_0x01d6:
            r8 = r3
            r3 = 26
            r4 = 0
            r6 = 16
            r12 = 0
            goto L_0x0261
        L_0x01df:
            if (r5 != r3) goto L_0x0259
            int r5 = r0.bp
            int r8 = r11 + 1
            int r5 = r5 + r11
            int r10 = r0.len
            if (r5 < r10) goto L_0x01ed
            r5 = 26
            goto L_0x01f3
        L_0x01ed:
            java.lang.String r10 = r0.text
            char r5 = r10.charAt(r5)
        L_0x01f3:
            int r10 = r9.length
            if (r1 == r10) goto L_0x01fd
            double[][] r10 = new double[r1][]
            r12 = 0
            java.lang.System.arraycopy(r9, r12, r10, r12, r1)
            r9 = r10
        L_0x01fd:
            if (r5 != r2) goto L_0x0210
            int r1 = r0.bp
            r2 = 1
            int r8 = r8 - r2
            int r8 = r8 + r1
            r0.bp = r8
            r20.next()
            r0.matchStat = r6
            r6 = 16
            r0.token = r6
            return r9
        L_0x0210:
            r6 = 16
            r1 = 125(0x7d, float:1.75E-43)
            if (r5 != r1) goto L_0x0255
            int r5 = r0.bp
            int r10 = r8 + 1
            int r5 = r5 + r8
            char r5 = r0.charAt(r5)
            if (r5 != r2) goto L_0x022e
            r0.token = r6
            int r1 = r0.bp
            r2 = 1
        L_0x0226:
            int r10 = r10 - r2
            int r10 = r10 + r1
            r0.bp = r10
            r20.next()
            goto L_0x024d
        L_0x022e:
            r2 = 1
            if (r5 != r3) goto L_0x0238
            r1 = 15
        L_0x0233:
            r0.token = r1
            int r1 = r0.bp
            goto L_0x0226
        L_0x0238:
            if (r5 != r1) goto L_0x023d
            r1 = 13
            goto L_0x0233
        L_0x023d:
            r3 = 26
            if (r5 != r3) goto L_0x0251
            int r1 = r0.bp
            int r10 = r10 - r2
            int r10 = r10 + r1
            r0.bp = r10
            r1 = 20
            r0.token = r1
            r0.ch = r3
        L_0x024d:
            r1 = 4
            r0.matchStat = r1
            return r9
        L_0x0251:
            r0.matchStat = r7
            r4 = 0
            return r4
        L_0x0255:
            r4 = 0
            r0.matchStat = r7
            return r4
        L_0x0259:
            r3 = 26
            r4 = 0
            r6 = 16
            r12 = 0
            r2 = r5
            r8 = r11
        L_0x0261:
            r10 = r1
            r3 = r4
            r1 = 0
            r4 = 91
            r5 = 16
            goto L_0x003e
        L_0x026a:
            r3 = 26
            r4 = 0
            r6 = 16
            r12 = 0
            r2 = r5
            r11 = r18
        L_0x0273:
            r12 = r1
            r3 = r4
            r1 = 0
            r4 = 91
            r5 = 16
            goto L_0x0055
        L_0x027c:
            r4 = r3
            r0.matchStat = r7
            return r4
        L_0x0280:
            r4 = r3
            r3 = 26
            r3 = r4
            r4 = 91
            goto L_0x003e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldDoubleArray2(long):double[][]");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final float scanFieldFloat(long r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = 0
            r0.matchStat = r1
            int r2 = r17.matchFieldHash(r18)
            r3 = 0
            if (r2 != 0) goto L_0x000d
            return r3
        L_0x000d:
            int r4 = r0.bp
            int r5 = r2 + 1
            int r4 = r4 + r2
            char r2 = r0.charAt(r4)
            int r4 = r0.bp
            int r4 = r4 + r5
            r6 = 1
            int r4 = r4 - r6
            r7 = 45
            if (r2 != r7) goto L_0x0021
            r8 = 1
            goto L_0x0022
        L_0x0021:
            r8 = 0
        L_0x0022:
            if (r8 == 0) goto L_0x002e
            int r2 = r0.bp
            int r9 = r5 + 1
            int r2 = r2 + r5
            char r2 = r0.charAt(r2)
            r5 = r9
        L_0x002e:
            r9 = -1
            r10 = 48
            if (r2 < r10) goto L_0x012b
            r11 = 57
            if (r2 > r11) goto L_0x012b
            int r2 = r2 - r10
        L_0x0038:
            int r12 = r0.bp
            int r13 = r5 + 1
            int r12 = r12 + r5
            char r5 = r0.charAt(r12)
            if (r5 < r10) goto L_0x004c
            if (r5 > r11) goto L_0x004c
            int r2 = r2 * 10
            int r5 = r5 + -48
            int r2 = r2 + r5
            r5 = r13
            goto L_0x0038
        L_0x004c:
            r12 = 46
            if (r5 != r12) goto L_0x0052
            r12 = 1
            goto L_0x0053
        L_0x0052:
            r12 = 0
        L_0x0053:
            r14 = 10
            if (r12 == 0) goto L_0x008b
            int r5 = r0.bp
            int r12 = r13 + 1
            int r5 = r5 + r13
            char r5 = r0.charAt(r5)
            if (r5 < r10) goto L_0x0088
            if (r5 > r11) goto L_0x0088
            int r2 = r2 * 10
            int r5 = r5 - r10
            int r5 = r5 + r2
            r2 = r5
            r5 = 10
        L_0x006b:
            int r13 = r0.bp
            int r15 = r12 + 1
            int r13 = r13 + r12
            char r12 = r0.charAt(r13)
            if (r12 < r10) goto L_0x0081
            if (r12 > r11) goto L_0x0081
            int r2 = r2 * 10
            int r12 = r12 + -48
            int r2 = r2 + r12
            int r5 = r5 * 10
            r12 = r15
            goto L_0x006b
        L_0x0081:
            r13 = r15
            r16 = r12
            r12 = r5
            r5 = r16
            goto L_0x008c
        L_0x0088:
            r0.matchStat = r9
            return r3
        L_0x008b:
            r12 = 1
        L_0x008c:
            r15 = 101(0x65, float:1.42E-43)
            if (r5 == r15) goto L_0x0094
            r15 = 69
            if (r5 != r15) goto L_0x0095
        L_0x0094:
            r1 = 1
        L_0x0095:
            if (r1 == 0) goto L_0x00bd
            int r5 = r0.bp
            int r15 = r13 + 1
            int r5 = r5 + r13
            char r5 = r0.charAt(r5)
            r13 = 43
            if (r5 == r13) goto L_0x00a9
            if (r5 != r7) goto L_0x00a7
            goto L_0x00a9
        L_0x00a7:
            r13 = r15
            goto L_0x00b3
        L_0x00a9:
            int r5 = r0.bp
            int r7 = r15 + 1
            int r5 = r5 + r15
        L_0x00ae:
            char r5 = r0.charAt(r5)
            r13 = r7
        L_0x00b3:
            if (r5 < r10) goto L_0x00bd
            if (r5 > r11) goto L_0x00bd
            int r5 = r0.bp
            int r7 = r13 + 1
            int r5 = r5 + r13
            goto L_0x00ae
        L_0x00bd:
            int r7 = r0.bp
            int r7 = r7 + r13
            int r7 = r7 - r4
            int r7 = r7 - r6
            if (r1 != 0) goto L_0x00cd
            if (r7 >= r14) goto L_0x00cd
            float r1 = (float) r2
            float r2 = (float) r12
            float r1 = r1 / r2
            if (r8 == 0) goto L_0x00d5
            float r1 = -r1
            goto L_0x00d5
        L_0x00cd:
            java.lang.String r1 = r0.subString(r4, r7)
            float r1 = java.lang.Float.parseFloat(r1)
        L_0x00d5:
            r2 = 16
            r4 = 44
            if (r5 != r4) goto L_0x00ea
            int r3 = r0.bp
            int r13 = r13 - r6
            int r13 = r13 + r3
            r0.bp = r13
            r17.next()
            r3 = 3
            r0.matchStat = r3
            r0.token = r2
            return r1
        L_0x00ea:
            r7 = 125(0x7d, float:1.75E-43)
            if (r5 != r7) goto L_0x0128
            int r5 = r0.bp
            int r8 = r13 + 1
            int r5 = r5 + r13
            char r5 = r0.charAt(r5)
            if (r5 != r4) goto L_0x0105
        L_0x00f9:
            r0.token = r2
            int r2 = r0.bp
            int r8 = r8 - r6
            int r8 = r8 + r2
            r0.bp = r8
            r17.next()
            goto L_0x0121
        L_0x0105:
            r2 = 93
            if (r5 != r2) goto L_0x010c
            r2 = 15
            goto L_0x00f9
        L_0x010c:
            if (r5 != r7) goto L_0x0111
            r2 = 13
            goto L_0x00f9
        L_0x0111:
            r2 = 26
            if (r5 != r2) goto L_0x0125
            int r3 = r0.bp
            int r8 = r8 - r6
            int r8 = r8 + r3
            r0.bp = r8
            r3 = 20
            r0.token = r3
            r0.ch = r2
        L_0x0121:
            r2 = 4
            r0.matchStat = r2
            return r1
        L_0x0125:
            r0.matchStat = r9
            return r3
        L_0x0128:
            r0.matchStat = r9
            return r3
        L_0x012b:
            r0.matchStat = r9
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldFloat(long):float");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00d3, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0109, code lost:
        if (r3 >= r0.len) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x010e, code lost:
        r3 = r0.text.charAt(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0123, code lost:
        if (r3 < r0.len) goto L_0x010e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final float[] scanFieldFloatArray(long r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = 0
            r0.matchStat = r1
            int r2 = r18.matchFieldHash(r19)
            r3 = 0
            if (r2 != 0) goto L_0x000d
            return r3
        L_0x000d:
            int r4 = r0.bp
            int r5 = r2 + 1
            int r4 = r4 + r2
            int r2 = r0.len
            if (r4 < r2) goto L_0x0019
            r2 = 26
            goto L_0x001f
        L_0x0019:
            java.lang.String r2 = r0.text
            char r2 = r2.charAt(r4)
        L_0x001f:
            r4 = 91
            r7 = -1
            if (r2 == r4) goto L_0x0027
            r0.matchStat = r7
            return r3
        L_0x0027:
            int r2 = r0.bp
            int r4 = r5 + 1
            int r2 = r2 + r5
            int r5 = r0.len
            if (r2 < r5) goto L_0x0033
            r2 = 26
            goto L_0x0039
        L_0x0033:
            java.lang.String r5 = r0.text
            char r2 = r5.charAt(r2)
        L_0x0039:
            r5 = 16
            float[] r8 = new float[r5]
            r9 = 0
        L_0x003e:
            int r10 = r0.bp
            int r10 = r10 + r4
            r11 = 1
            int r10 = r10 - r11
            r12 = 45
            if (r2 != r12) goto L_0x0049
            r13 = 1
            goto L_0x004a
        L_0x0049:
            r13 = 0
        L_0x004a:
            if (r13 == 0) goto L_0x005f
            int r2 = r0.bp
            int r14 = r4 + 1
            int r2 = r2 + r4
            int r4 = r0.len
            if (r2 < r4) goto L_0x0058
            r2 = 26
            goto L_0x005e
        L_0x0058:
            java.lang.String r4 = r0.text
            char r2 = r4.charAt(r2)
        L_0x005e:
            r4 = r14
        L_0x005f:
            r14 = 48
            if (r2 < r14) goto L_0x01fd
            r15 = 57
            if (r2 > r15) goto L_0x01fd
            int r2 = r2 + -48
        L_0x0069:
            int r6 = r0.bp
            int r16 = r4 + 1
            int r6 = r6 + r4
            int r4 = r0.len
            if (r6 < r4) goto L_0x0075
            r4 = 26
            goto L_0x007b
        L_0x0075:
            java.lang.String r4 = r0.text
            char r4 = r4.charAt(r6)
        L_0x007b:
            if (r4 < r14) goto L_0x0087
            if (r4 > r15) goto L_0x0087
            int r2 = r2 * 10
            int r4 = r4 + -48
            int r2 = r2 + r4
            r4 = r16
            goto L_0x0069
        L_0x0087:
            r6 = 46
            if (r4 != r6) goto L_0x008d
            r6 = 1
            goto L_0x008e
        L_0x008d:
            r6 = 0
        L_0x008e:
            r5 = 10
            if (r6 == 0) goto L_0x00d4
            int r4 = r0.bp
            int r6 = r16 + 1
            int r4 = r4 + r16
            int r1 = r0.len
            if (r4 < r1) goto L_0x009f
            r1 = 26
            goto L_0x00a5
        L_0x009f:
            java.lang.String r1 = r0.text
            char r1 = r1.charAt(r4)
        L_0x00a5:
            if (r1 < r14) goto L_0x00d1
            if (r1 > r15) goto L_0x00d1
            int r2 = r2 * 10
            int r1 = r1 + -48
            int r1 = r1 + r2
            r2 = r1
            r1 = 10
        L_0x00b1:
            int r4 = r0.bp
            int r16 = r6 + 1
            int r4 = r4 + r6
            int r6 = r0.len
            if (r4 < r6) goto L_0x00bd
            r4 = 26
            goto L_0x00c3
        L_0x00bd:
            java.lang.String r6 = r0.text
            char r4 = r6.charAt(r4)
        L_0x00c3:
            if (r4 < r14) goto L_0x00d5
            if (r4 > r15) goto L_0x00d5
            int r2 = r2 * 10
            int r4 = r4 + -48
            int r2 = r2 + r4
            int r1 = r1 * 10
            r6 = r16
            goto L_0x00b1
        L_0x00d1:
            r0.matchStat = r7
            return r3
        L_0x00d4:
            r1 = 1
        L_0x00d5:
            r6 = 101(0x65, float:1.42E-43)
            if (r4 == r6) goto L_0x00e0
            r6 = 69
            if (r4 != r6) goto L_0x00de
            goto L_0x00e0
        L_0x00de:
            r6 = 0
            goto L_0x00e1
        L_0x00e0:
            r6 = 1
        L_0x00e1:
            if (r6 == 0) goto L_0x0126
            int r4 = r0.bp
            int r17 = r16 + 1
            int r4 = r4 + r16
            int r3 = r0.len
            if (r4 < r3) goto L_0x00f0
            r3 = 26
            goto L_0x00f6
        L_0x00f0:
            java.lang.String r3 = r0.text
            char r3 = r3.charAt(r4)
        L_0x00f6:
            r4 = 43
            if (r3 == r4) goto L_0x0101
            if (r3 != r12) goto L_0x00fd
            goto L_0x0101
        L_0x00fd:
            r4 = r3
            r16 = r17
            goto L_0x0117
        L_0x0101:
            int r3 = r0.bp
            int r4 = r17 + 1
            int r3 = r3 + r17
            int r12 = r0.len
            if (r3 < r12) goto L_0x010e
        L_0x010b:
            r3 = 26
            goto L_0x0114
        L_0x010e:
            java.lang.String r12 = r0.text
            char r3 = r12.charAt(r3)
        L_0x0114:
            r16 = r4
            r4 = r3
        L_0x0117:
            if (r4 < r14) goto L_0x0126
            if (r4 > r15) goto L_0x0126
            int r3 = r0.bp
            int r4 = r16 + 1
            int r3 = r3 + r16
            int r12 = r0.len
            if (r3 < r12) goto L_0x010e
            goto L_0x010b
        L_0x0126:
            int r3 = r0.bp
            int r3 = r3 + r16
            int r3 = r3 - r10
            int r3 = r3 - r11
            if (r6 != 0) goto L_0x0137
            if (r3 >= r5) goto L_0x0137
            float r2 = (float) r2
            float r1 = (float) r1
            float r2 = r2 / r1
            if (r13 == 0) goto L_0x013f
            float r2 = -r2
            goto L_0x013f
        L_0x0137:
            java.lang.String r1 = r0.subString(r10, r3)
            float r2 = java.lang.Float.parseFloat(r1)
        L_0x013f:
            int r1 = r8.length
            r3 = 3
            if (r9 < r1) goto L_0x014f
            int r1 = r8.length
            int r1 = r1 * 3
            int r1 = r1 / 2
            float[] r1 = new float[r1]
            r5 = 0
            java.lang.System.arraycopy(r8, r5, r1, r5, r9)
            r8 = r1
        L_0x014f:
            int r5 = r9 + 1
            r8[r9] = r2
            r1 = 44
            if (r4 != r1) goto L_0x016f
            int r1 = r0.bp
            int r2 = r16 + 1
            int r1 = r1 + r16
            int r3 = r0.len
            if (r1 < r3) goto L_0x0164
            r1 = 26
            goto L_0x016a
        L_0x0164:
            java.lang.String r3 = r0.text
            char r1 = r3.charAt(r1)
        L_0x016a:
            r4 = r1
            r16 = r2
            goto L_0x01ee
        L_0x016f:
            r2 = 93
            if (r4 != r2) goto L_0x01ee
            int r4 = r0.bp
            int r6 = r16 + 1
            int r4 = r4 + r16
            int r9 = r0.len
            if (r4 < r9) goto L_0x0180
            r4 = 26
            goto L_0x0186
        L_0x0180:
            java.lang.String r9 = r0.text
            char r4 = r9.charAt(r4)
        L_0x0186:
            int r9 = r8.length
            if (r5 == r9) goto L_0x0190
            float[] r9 = new float[r5]
            r10 = 0
            java.lang.System.arraycopy(r8, r10, r9, r10, r5)
            r8 = r9
        L_0x0190:
            if (r4 != r1) goto L_0x01a2
            int r1 = r0.bp
            int r6 = r6 - r11
            int r6 = r6 + r1
            r0.bp = r6
            r18.next()
            r0.matchStat = r3
            r1 = 16
            r0.token = r1
            return r8
        L_0x01a2:
            r3 = 125(0x7d, float:1.75E-43)
            if (r4 != r3) goto L_0x01ea
            int r4 = r0.bp
            int r5 = r6 + 1
            int r4 = r4 + r6
            int r6 = r0.len
            if (r4 < r6) goto L_0x01b2
            r4 = 26
            goto L_0x01b8
        L_0x01b2:
            java.lang.String r6 = r0.text
            char r4 = r6.charAt(r4)
        L_0x01b8:
            if (r4 != r1) goto L_0x01c8
            r1 = 16
        L_0x01bc:
            r0.token = r1
            int r1 = r0.bp
            int r5 = r5 - r11
            int r5 = r5 + r1
            r0.bp = r5
            r18.next()
            goto L_0x01e2
        L_0x01c8:
            if (r4 != r2) goto L_0x01cd
            r1 = 15
            goto L_0x01bc
        L_0x01cd:
            if (r4 != r3) goto L_0x01d2
            r1 = 13
            goto L_0x01bc
        L_0x01d2:
            r2 = 26
            if (r4 != r2) goto L_0x01e6
            int r1 = r0.bp
            int r5 = r5 - r11
            int r5 = r5 + r1
            r0.bp = r5
            r1 = 20
            r0.token = r1
            r0.ch = r2
        L_0x01e2:
            r1 = 4
            r0.matchStat = r1
            return r8
        L_0x01e6:
            r0.matchStat = r7
            r3 = 0
            return r3
        L_0x01ea:
            r3 = 0
            r0.matchStat = r7
            return r3
        L_0x01ee:
            r1 = 16
            r2 = 26
            r3 = 0
            r10 = 0
            r2 = r4
            r9 = r5
            r4 = r16
            r1 = 0
            r5 = 16
            goto L_0x003e
        L_0x01fd:
            r0.matchStat = r7
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldFloatArray(long):float[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0275, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x011c, code lost:
        if (r3 >= r0.len) goto L_0x011e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0121, code lost:
        r3 = r0.text.charAt(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0136, code lost:
        if (r3 < r0.len) goto L_0x0121;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final float[][] scanFieldFloatArray2(long r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = 0
            r0.matchStat = r1
            int r2 = r20.matchFieldHash(r21)
            r3 = 0
            if (r2 != 0) goto L_0x000d
            return r3
        L_0x000d:
            int r4 = r0.bp
            int r5 = r2 + 1
            int r4 = r4 + r2
            int r2 = r0.len
            if (r4 < r2) goto L_0x0019
            r2 = 26
            goto L_0x001f
        L_0x0019:
            java.lang.String r2 = r0.text
            char r2 = r2.charAt(r4)
        L_0x001f:
            r4 = 91
            r7 = -1
            if (r2 == r4) goto L_0x0027
            r0.matchStat = r7
            return r3
        L_0x0027:
            int r2 = r0.bp
            int r8 = r5 + 1
            int r2 = r2 + r5
            int r5 = r0.len
            if (r2 < r5) goto L_0x0033
            r2 = 26
            goto L_0x0039
        L_0x0033:
            java.lang.String r5 = r0.text
            char r2 = r5.charAt(r2)
        L_0x0039:
            r5 = 16
            float[][] r9 = new float[r5][]
            r10 = 0
        L_0x003e:
            if (r2 != r4) goto L_0x0276
            int r2 = r0.bp
            int r11 = r8 + 1
            int r2 = r2 + r8
            int r8 = r0.len
            if (r2 < r8) goto L_0x004c
            r2 = 26
            goto L_0x0052
        L_0x004c:
            java.lang.String r8 = r0.text
            char r2 = r8.charAt(r2)
        L_0x0052:
            float[] r8 = new float[r5]
            r12 = 0
        L_0x0055:
            int r13 = r0.bp
            int r13 = r13 + r11
            r14 = 1
            int r13 = r13 - r14
            r15 = 45
            if (r2 != r15) goto L_0x0061
            r16 = 1
            goto L_0x0063
        L_0x0061:
            r16 = 0
        L_0x0063:
            if (r16 == 0) goto L_0x0079
            int r2 = r0.bp
            int r17 = r11 + 1
            int r2 = r2 + r11
            int r11 = r0.len
            if (r2 < r11) goto L_0x0071
            r2 = 26
            goto L_0x0077
        L_0x0071:
            java.lang.String r11 = r0.text
            char r2 = r11.charAt(r2)
        L_0x0077:
            r11 = r17
        L_0x0079:
            r4 = 48
            if (r2 < r4) goto L_0x0272
            r6 = 57
            if (r2 > r6) goto L_0x0272
            int r2 = r2 + -48
        L_0x0083:
            int r5 = r0.bp
            int r18 = r11 + 1
            int r5 = r5 + r11
            int r11 = r0.len
            if (r5 < r11) goto L_0x008f
            r5 = 26
            goto L_0x0095
        L_0x008f:
            java.lang.String r11 = r0.text
            char r5 = r11.charAt(r5)
        L_0x0095:
            if (r5 < r4) goto L_0x00a1
            if (r5 > r6) goto L_0x00a1
            int r2 = r2 * 10
            int r5 = r5 + -48
            int r2 = r2 + r5
            r11 = r18
            goto L_0x0083
        L_0x00a1:
            r11 = 46
            if (r5 != r11) goto L_0x00e7
            int r5 = r0.bp
            int r11 = r18 + 1
            int r5 = r5 + r18
            int r1 = r0.len
            if (r5 < r1) goto L_0x00b2
            r1 = 26
            goto L_0x00b8
        L_0x00b2:
            java.lang.String r1 = r0.text
            char r1 = r1.charAt(r5)
        L_0x00b8:
            if (r1 < r4) goto L_0x00e4
            if (r1 > r6) goto L_0x00e4
            int r2 = r2 * 10
            int r1 = r1 + -48
            int r1 = r1 + r2
            r2 = r1
            r1 = 10
        L_0x00c4:
            int r5 = r0.bp
            int r18 = r11 + 1
            int r5 = r5 + r11
            int r11 = r0.len
            if (r5 < r11) goto L_0x00d0
            r5 = 26
            goto L_0x00d6
        L_0x00d0:
            java.lang.String r11 = r0.text
            char r5 = r11.charAt(r5)
        L_0x00d6:
            if (r5 < r4) goto L_0x00e8
            if (r5 > r6) goto L_0x00e8
            int r2 = r2 * 10
            int r5 = r5 + -48
            int r2 = r2 + r5
            int r1 = r1 * 10
            r11 = r18
            goto L_0x00c4
        L_0x00e4:
            r0.matchStat = r7
            return r3
        L_0x00e7:
            r1 = 1
        L_0x00e8:
            r11 = 101(0x65, float:1.42E-43)
            if (r5 == r11) goto L_0x00f3
            r11 = 69
            if (r5 != r11) goto L_0x00f1
            goto L_0x00f3
        L_0x00f1:
            r11 = 0
            goto L_0x00f4
        L_0x00f3:
            r11 = 1
        L_0x00f4:
            if (r11 == 0) goto L_0x0139
            int r5 = r0.bp
            int r19 = r18 + 1
            int r5 = r5 + r18
            int r3 = r0.len
            if (r5 < r3) goto L_0x0103
            r3 = 26
            goto L_0x0109
        L_0x0103:
            java.lang.String r3 = r0.text
            char r3 = r3.charAt(r5)
        L_0x0109:
            r5 = 43
            if (r3 == r5) goto L_0x0114
            if (r3 != r15) goto L_0x0110
            goto L_0x0114
        L_0x0110:
            r5 = r3
            r18 = r19
            goto L_0x012a
        L_0x0114:
            int r3 = r0.bp
            int r5 = r19 + 1
            int r3 = r3 + r19
            int r15 = r0.len
            if (r3 < r15) goto L_0x0121
        L_0x011e:
            r3 = 26
            goto L_0x0127
        L_0x0121:
            java.lang.String r15 = r0.text
            char r3 = r15.charAt(r3)
        L_0x0127:
            r18 = r5
            r5 = r3
        L_0x012a:
            if (r5 < r4) goto L_0x0139
            if (r5 > r6) goto L_0x0139
            int r3 = r0.bp
            int r5 = r18 + 1
            int r3 = r3 + r18
            int r15 = r0.len
            if (r3 < r15) goto L_0x0121
            goto L_0x011e
        L_0x0139:
            int r3 = r0.bp
            int r3 = r3 + r18
            int r3 = r3 - r13
            int r3 = r3 - r14
            if (r11 != 0) goto L_0x014c
            r4 = 10
            if (r3 >= r4) goto L_0x014c
            float r2 = (float) r2
            float r1 = (float) r1
            float r2 = r2 / r1
            if (r16 == 0) goto L_0x0154
            float r2 = -r2
            goto L_0x0154
        L_0x014c:
            java.lang.String r1 = r0.subString(r13, r3)
            float r2 = java.lang.Float.parseFloat(r1)
        L_0x0154:
            int r1 = r8.length
            r3 = 3
            if (r12 < r1) goto L_0x0164
            int r1 = r8.length
            int r1 = r1 * 3
            int r1 = r1 / 2
            float[] r1 = new float[r1]
            r4 = 0
            java.lang.System.arraycopy(r8, r4, r1, r4, r12)
            r8 = r1
        L_0x0164:
            int r1 = r12 + 1
            r8[r12] = r2
            r2 = 44
            if (r5 != r2) goto L_0x0189
            int r2 = r0.bp
            int r3 = r18 + 1
            int r2 = r2 + r18
            int r4 = r0.len
            if (r2 < r4) goto L_0x0179
            r2 = 26
            goto L_0x017f
        L_0x0179:
            java.lang.String r4 = r0.text
            char r2 = r4.charAt(r2)
        L_0x017f:
            r18 = r3
            r3 = 16
            r4 = 26
            r11 = 0
            r12 = 0
            goto L_0x0267
        L_0x0189:
            r4 = 93
            if (r5 != r4) goto L_0x0260
            int r5 = r0.bp
            int r6 = r18 + 1
            int r5 = r5 + r18
            int r11 = r0.len
            if (r5 < r11) goto L_0x019a
            r5 = 26
            goto L_0x01a0
        L_0x019a:
            java.lang.String r11 = r0.text
            char r5 = r11.charAt(r5)
        L_0x01a0:
            int r11 = r8.length
            if (r1 == r11) goto L_0x01ab
            float[] r11 = new float[r1]
            r12 = 0
            java.lang.System.arraycopy(r8, r12, r11, r12, r1)
            r8 = r11
            goto L_0x01ac
        L_0x01ab:
            r12 = 0
        L_0x01ac:
            int r11 = r9.length
            if (r10 < r11) goto L_0x01b9
            int r9 = r9.length
            int r9 = r9 * 3
            int r9 = r9 / 2
            float[][] r9 = new float[r9][]
            java.lang.System.arraycopy(r8, r12, r9, r12, r1)
        L_0x01b9:
            int r1 = r10 + 1
            r9[r10] = r8
            if (r5 != r2) goto L_0x01da
            int r2 = r0.bp
            int r3 = r6 + 1
            int r2 = r2 + r6
            int r4 = r0.len
            if (r2 < r4) goto L_0x01cb
            r2 = 26
            goto L_0x01d1
        L_0x01cb:
            java.lang.String r4 = r0.text
            char r2 = r4.charAt(r2)
        L_0x01d1:
            r8 = r3
            r3 = 16
            r4 = 26
            r11 = 0
            r12 = 0
            goto L_0x0257
        L_0x01da:
            if (r5 != r4) goto L_0x024f
            int r5 = r0.bp
            int r8 = r6 + 1
            int r5 = r5 + r6
            int r6 = r0.len
            if (r5 < r6) goto L_0x01e8
            r5 = 26
            goto L_0x01ee
        L_0x01e8:
            java.lang.String r6 = r0.text
            char r5 = r6.charAt(r5)
        L_0x01ee:
            int r6 = r9.length
            if (r1 == r6) goto L_0x01f8
            float[][] r6 = new float[r1][]
            r11 = 0
            java.lang.System.arraycopy(r9, r11, r6, r11, r1)
            r9 = r6
        L_0x01f8:
            if (r5 != r2) goto L_0x020a
            int r1 = r0.bp
            int r8 = r8 - r14
            int r8 = r8 + r1
            r0.bp = r8
            r20.next()
            r0.matchStat = r3
            r3 = 16
            r0.token = r3
            return r9
        L_0x020a:
            r3 = 16
            r1 = 125(0x7d, float:1.75E-43)
            if (r5 != r1) goto L_0x024b
            int r5 = r0.bp
            int r6 = r8 + 1
            int r5 = r5 + r8
            char r5 = r0.charAt(r5)
            if (r5 != r2) goto L_0x0227
            r0.token = r3
        L_0x021d:
            int r1 = r0.bp
            int r6 = r6 - r14
            int r6 = r6 + r1
            r0.bp = r6
            r20.next()
            goto L_0x0243
        L_0x0227:
            if (r5 != r4) goto L_0x022e
            r1 = 15
        L_0x022b:
            r0.token = r1
            goto L_0x021d
        L_0x022e:
            if (r5 != r1) goto L_0x0233
            r1 = 13
            goto L_0x022b
        L_0x0233:
            r4 = 26
            if (r5 != r4) goto L_0x0247
            int r1 = r0.bp
            int r6 = r6 - r14
            int r6 = r6 + r1
            r0.bp = r6
            r1 = 20
            r0.token = r1
            r0.ch = r4
        L_0x0243:
            r1 = 4
            r0.matchStat = r1
            return r9
        L_0x0247:
            r0.matchStat = r7
            r12 = 0
            return r12
        L_0x024b:
            r12 = 0
            r0.matchStat = r7
            return r12
        L_0x024f:
            r3 = 16
            r4 = 26
            r11 = 0
            r12 = 0
            r2 = r5
            r8 = r6
        L_0x0257:
            r10 = r1
            r3 = r12
            r1 = 0
            r4 = 91
            r5 = 16
            goto L_0x003e
        L_0x0260:
            r3 = 16
            r4 = 26
            r11 = 0
            r12 = 0
            r2 = r5
        L_0x0267:
            r3 = r12
            r11 = r18
            r4 = 91
            r5 = 16
            r12 = r1
            r1 = 0
            goto L_0x0055
        L_0x0272:
            r12 = r3
            r0.matchStat = r7
            return r12
        L_0x0276:
            r12 = r3
            goto L_0x003e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldFloatArray2(long):float[][]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0116, code lost:
        if (r9 >= r11.len) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0135, code lost:
        if (r9 >= r11.len) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0147, code lost:
        if (r9 >= r11.len) goto L_0x011f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x015c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int scanFieldInt(long r12) {
        /*
            r11 = this;
            r0 = 0
            r11.matchStat = r0
            int r12 = r11.matchFieldHash(r12)
            if (r12 != 0) goto L_0x000a
            return r0
        L_0x000a:
            int r13 = r11.bp
            int r1 = r12 + 1
            int r13 = r13 + r12
            int r12 = r11.len
            r2 = 26
            if (r13 < r12) goto L_0x0018
            r12 = 26
            goto L_0x001e
        L_0x0018:
            java.lang.String r12 = r11.text
            char r12 = r12.charAt(r13)
        L_0x001e:
            r13 = 34
            r3 = 1
            if (r12 != r13) goto L_0x0025
            r4 = 1
            goto L_0x0026
        L_0x0025:
            r4 = 0
        L_0x0026:
            if (r4 == 0) goto L_0x003c
            int r12 = r11.bp
            int r4 = r1 + 1
            int r12 = r12 + r1
            int r1 = r11.len
            if (r12 < r1) goto L_0x0034
            r12 = 26
            goto L_0x003a
        L_0x0034:
            java.lang.String r1 = r11.text
            char r12 = r1.charAt(r12)
        L_0x003a:
            r1 = r4
            r4 = 1
        L_0x003c:
            r5 = 45
            if (r12 != r5) goto L_0x0042
            r5 = 1
            goto L_0x0043
        L_0x0042:
            r5 = 0
        L_0x0043:
            if (r5 == 0) goto L_0x0058
            int r12 = r11.bp
            int r6 = r1 + 1
            int r12 = r12 + r1
            int r1 = r11.len
            if (r12 < r1) goto L_0x0051
            r12 = 26
            goto L_0x0057
        L_0x0051:
            java.lang.String r1 = r11.text
            char r12 = r1.charAt(r12)
        L_0x0057:
            r1 = r6
        L_0x0058:
            r6 = 48
            r7 = -1
            if (r12 < r6) goto L_0x0164
            r8 = 57
            if (r12 > r8) goto L_0x0164
            int r12 = r12 - r6
        L_0x0062:
            int r9 = r11.bp
            int r10 = r1 + 1
            int r9 = r9 + r1
            int r1 = r11.len
            if (r9 < r1) goto L_0x006e
            r1 = 26
            goto L_0x0074
        L_0x006e:
            java.lang.String r1 = r11.text
            char r1 = r1.charAt(r9)
        L_0x0074:
            if (r1 < r6) goto L_0x007f
            if (r1 > r8) goto L_0x007f
            int r12 = r12 * 10
            int r1 = r1 + -48
            int r12 = r12 + r1
            r1 = r10
            goto L_0x0062
        L_0x007f:
            r6 = 46
            if (r1 != r6) goto L_0x0086
            r11.matchStat = r7
            return r0
        L_0x0086:
            if (r1 != r13) goto L_0x00a1
            if (r4 != 0) goto L_0x008d
            r11.matchStat = r7
            return r0
        L_0x008d:
            int r13 = r11.bp
            int r1 = r10 + 1
            int r13 = r13 + r10
            int r4 = r11.len
            if (r13 < r4) goto L_0x0099
            r13 = 26
            goto L_0x009f
        L_0x0099:
            java.lang.String r4 = r11.text
            char r13 = r4.charAt(r13)
        L_0x009f:
            r10 = r1
            r1 = r13
        L_0x00a1:
            if (r12 >= 0) goto L_0x00a6
            r11.matchStat = r7
            return r0
        L_0x00a6:
            r13 = 16
            r4 = 44
            if (r1 != r4) goto L_0x00cb
            int r0 = r11.bp
            int r10 = r10 - r3
            int r10 = r10 + r0
            r11.bp = r10
            int r10 = r10 + r3
            r11.bp = r10
            int r0 = r11.len
            if (r10 < r0) goto L_0x00ba
            goto L_0x00c0
        L_0x00ba:
            java.lang.String r0 = r11.text
            char r2 = r0.charAt(r10)
        L_0x00c0:
            r11.ch = r2
            r0 = 3
            r11.matchStat = r0
            r11.token = r13
            if (r5 == 0) goto L_0x00ca
            int r12 = -r12
        L_0x00ca:
            return r12
        L_0x00cb:
            r6 = 13
            r8 = 32
            if (r1 > r8) goto L_0x00fa
            if (r1 == r8) goto L_0x00e5
            r8 = 10
            if (r1 == r8) goto L_0x00e5
            if (r1 == r6) goto L_0x00e5
            r8 = 9
            if (r1 == r8) goto L_0x00e5
            r8 = 12
            if (r1 == r8) goto L_0x00e5
            r8 = 8
            if (r1 != r8) goto L_0x00fa
        L_0x00e5:
            int r13 = r11.bp
            int r1 = r10 + 1
            int r13 = r13 + r10
            int r4 = r11.len
            if (r13 < r4) goto L_0x00f1
            r13 = 26
            goto L_0x00f7
        L_0x00f1:
            java.lang.String r4 = r11.text
            char r13 = r4.charAt(r13)
        L_0x00f7:
            r10 = r1
            r1 = r13
            goto L_0x00a6
        L_0x00fa:
            r8 = 125(0x7d, float:1.75E-43)
            if (r1 != r8) goto L_0x0161
            int r1 = r11.bp
            int r9 = r10 + 1
            int r1 = r1 + r10
            char r1 = r11.charAt(r1)
            if (r1 != r4) goto L_0x0122
            r11.token = r13
            int r13 = r11.bp
            int r9 = r9 - r3
            int r9 = r9 + r13
            r11.bp = r9
            int r9 = r9 + r3
            r11.bp = r9
            int r13 = r11.len
            if (r9 < r13) goto L_0x0119
            goto L_0x011f
        L_0x0119:
            java.lang.String r13 = r11.text
            char r2 = r13.charAt(r9)
        L_0x011f:
            r11.ch = r2
            goto L_0x0157
        L_0x0122:
            r13 = 93
            if (r1 != r13) goto L_0x0138
            r13 = 15
            r11.token = r13
            int r13 = r11.bp
            int r9 = r9 - r3
            int r9 = r9 + r13
            r11.bp = r9
            int r9 = r9 + r3
            r11.bp = r9
            int r13 = r11.len
            if (r9 < r13) goto L_0x0119
            goto L_0x011f
        L_0x0138:
            if (r1 != r8) goto L_0x014a
            r11.token = r6
            int r13 = r11.bp
            int r9 = r9 - r3
            int r9 = r9 + r13
            r11.bp = r9
            int r9 = r9 + r3
            r11.bp = r9
            int r13 = r11.len
            if (r9 < r13) goto L_0x0119
            goto L_0x011f
        L_0x014a:
            if (r1 != r2) goto L_0x015e
            r13 = 20
            r11.token = r13
            int r13 = r11.bp
            int r9 = r9 - r3
            int r9 = r9 + r13
            r11.bp = r9
            goto L_0x011f
        L_0x0157:
            r13 = 4
            r11.matchStat = r13
            if (r5 == 0) goto L_0x015d
            int r12 = -r12
        L_0x015d:
            return r12
        L_0x015e:
            r11.matchStat = r7
            return r0
        L_0x0161:
            r11.matchStat = r7
            return r0
        L_0x0164:
            r11.matchStat = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldInt(long):int");
    }

    public final int[] scanFieldIntArray(long j) {
        int i;
        int i2;
        char c2;
        int i3;
        boolean z;
        int[] iArr;
        int i4;
        int i5;
        char charAt;
        int[] iArr2;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j);
        int[] iArr3 = null;
        if (matchFieldHash == 0) {
            return null;
        }
        int i6 = matchFieldHash + 1;
        int i7 = this.bp + matchFieldHash;
        if ((i7 >= this.len ? EOI : this.text.charAt(i7)) != '[') {
            this.matchStat = -1;
            return null;
        }
        int i8 = i6 + 1;
        int i9 = this.bp + i6;
        char charAt2 = i9 >= this.len ? EOI : this.text.charAt(i9);
        int[] iArr4 = new int[16];
        if (charAt2 == ']') {
            i = i8 + 1;
            int i10 = this.bp + i8;
            c2 = i10 >= this.len ? EOI : this.text.charAt(i10);
            i2 = 0;
        } else {
            int i11 = 0;
            while (true) {
                if (charAt2 == '-') {
                    int i12 = i8 + 1;
                    int i13 = this.bp + i8;
                    charAt2 = i13 >= this.len ? EOI : this.text.charAt(i13);
                    i8 = i12;
                    z = true;
                } else {
                    z = false;
                }
                if (charAt2 >= '0') {
                    if (charAt2 > '9') {
                        i4 = -1;
                        iArr = null;
                        break;
                    }
                    int i14 = charAt2 - '0';
                    while (true) {
                        i5 = i8 + 1;
                        int i15 = this.bp + i8;
                        charAt = i15 >= this.len ? EOI : this.text.charAt(i15);
                        if (charAt >= '0' && charAt <= '9') {
                            i14 = (i14 * 10) + (charAt - '0');
                            i8 = i5;
                        }
                    }
                    if (i11 >= iArr4.length) {
                        int[] iArr5 = new int[((iArr4.length * 3) / 2)];
                        System.arraycopy(iArr4, 0, iArr5, 0, i11);
                        iArr4 = iArr5;
                    }
                    i2 = i11 + 1;
                    if (z) {
                        i14 = -i14;
                    }
                    iArr4[i11] = i14;
                    if (charAt == ',') {
                        int i16 = i5 + 1;
                        int i17 = this.bp + i5;
                        i5 = i16;
                        iArr2 = null;
                        charAt = i17 >= this.len ? EOI : this.text.charAt(i17);
                    } else if (charAt == ']') {
                        i = i5 + 1;
                        int i18 = this.bp + i5;
                        c2 = i18 >= this.len ? EOI : this.text.charAt(i18);
                    } else {
                        iArr2 = null;
                    }
                    i11 = i2;
                    charAt2 = charAt;
                    iArr3 = iArr2;
                    i8 = i5;
                } else {
                    iArr = iArr3;
                    i4 = -1;
                    break;
                }
            }
            this.matchStat = i4;
            return iArr;
        }
        if (i2 != iArr4.length) {
            int[] iArr6 = new int[i2];
            System.arraycopy(iArr4, 0, iArr6, 0, i2);
            iArr4 = iArr6;
        }
        if (c2 == ',') {
            this.bp = (i - 1) + this.bp;
            next();
            this.matchStat = 3;
            this.token = 16;
            return iArr4;
        } else if (c2 == '}') {
            int i19 = i + 1;
            char charAt3 = charAt(this.bp + i);
            if (charAt3 == ',') {
                this.token = 16;
            } else {
                if (charAt3 == ']') {
                    i3 = 15;
                } else if (charAt3 == '}') {
                    i3 = 13;
                } else if (charAt3 == 26) {
                    this.bp = (i19 - 1) + this.bp;
                    this.token = 20;
                    this.ch = EOI;
                    this.matchStat = 4;
                    return iArr4;
                } else {
                    this.matchStat = -1;
                    return null;
                }
                this.token = i3;
            }
            this.bp = (i19 - 1) + this.bp;
            next();
            this.matchStat = 4;
            return iArr4;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00ee, code lost:
        if (r8 >= r0.len) goto L_0x00f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00f3, code lost:
        r7 = r0.text.charAt(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0110, code lost:
        if (r8 >= r0.len) goto L_0x00f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0125, code lost:
        if (r8 >= r0.len) goto L_0x00f0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long scanFieldLong(long r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = 0
            r0.matchStat = r1
            int r2 = r18.matchFieldHash(r19)
            r3 = 0
            if (r2 != 0) goto L_0x000e
            return r3
        L_0x000e:
            int r5 = r0.bp
            int r6 = r2 + 1
            int r5 = r5 + r2
            int r2 = r0.len
            if (r5 < r2) goto L_0x001a
            r2 = 26
            goto L_0x0020
        L_0x001a:
            java.lang.String r2 = r0.text
            char r2 = r2.charAt(r5)
        L_0x0020:
            r5 = 34
            if (r2 != r5) goto L_0x0026
            r9 = 1
            goto L_0x0027
        L_0x0026:
            r9 = 0
        L_0x0027:
            if (r9 == 0) goto L_0x003c
            int r2 = r0.bp
            int r10 = r6 + 1
            int r2 = r2 + r6
            int r6 = r0.len
            if (r2 < r6) goto L_0x0035
            r2 = 26
            goto L_0x003b
        L_0x0035:
            java.lang.String r6 = r0.text
            char r2 = r6.charAt(r2)
        L_0x003b:
            r6 = r10
        L_0x003c:
            r10 = 45
            if (r2 != r10) goto L_0x0041
            r1 = 1
        L_0x0041:
            if (r1 == 0) goto L_0x0056
            int r2 = r0.bp
            int r10 = r6 + 1
            int r2 = r2 + r6
            int r6 = r0.len
            if (r2 < r6) goto L_0x004f
            r2 = 26
            goto L_0x0055
        L_0x004f:
            java.lang.String r6 = r0.text
            char r2 = r6.charAt(r2)
        L_0x0055:
            r6 = r10
        L_0x0056:
            r10 = 48
            r11 = -1
            if (r2 < r10) goto L_0x0146
            r12 = 57
            if (r2 > r12) goto L_0x0146
            int r2 = r2 - r10
            long r13 = (long) r2
        L_0x0061:
            int r2 = r0.bp
            int r15 = r6 + 1
            int r2 = r2 + r6
            int r6 = r0.len
            if (r2 < r6) goto L_0x006d
            r2 = 26
            goto L_0x0073
        L_0x006d:
            java.lang.String r6 = r0.text
            char r2 = r6.charAt(r2)
        L_0x0073:
            if (r2 < r10) goto L_0x0081
            if (r2 > r12) goto L_0x0081
            r16 = 10
            long r13 = r13 * r16
            int r2 = r2 + -48
            long r7 = (long) r2
            long r13 = r13 + r7
            r6 = r15
            goto L_0x0061
        L_0x0081:
            r6 = 46
            if (r2 != r6) goto L_0x0088
            r0.matchStat = r11
            return r3
        L_0x0088:
            if (r2 != r5) goto L_0x00a2
            if (r9 != 0) goto L_0x008f
            r0.matchStat = r11
            return r3
        L_0x008f:
            int r2 = r0.bp
            int r5 = r15 + 1
            int r2 = r2 + r15
            int r6 = r0.len
            if (r2 < r6) goto L_0x009b
            r2 = 26
            goto L_0x00a1
        L_0x009b:
            java.lang.String r6 = r0.text
            char r2 = r6.charAt(r2)
        L_0x00a1:
            r15 = r5
        L_0x00a2:
            int r5 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x00a9
            r0.matchStat = r11
            return r3
        L_0x00a9:
            r5 = 16
            r6 = 44
            if (r2 != r6) goto L_0x00d1
            int r2 = r0.bp
            r3 = 1
            int r15 = r15 - r3
            int r15 = r15 + r2
            r0.bp = r15
            int r15 = r15 + r3
            r0.bp = r15
            int r2 = r0.len
            if (r15 < r2) goto L_0x00c0
            r7 = 26
            goto L_0x00c6
        L_0x00c0:
            java.lang.String r2 = r0.text
            char r7 = r2.charAt(r15)
        L_0x00c6:
            r0.ch = r7
            r2 = 3
            r0.matchStat = r2
            r0.token = r5
            if (r1 == 0) goto L_0x00d0
            long r13 = -r13
        L_0x00d0:
            return r13
        L_0x00d1:
            r7 = 125(0x7d, float:1.75E-43)
            if (r2 != r7) goto L_0x0143
            int r2 = r0.bp
            int r8 = r15 + 1
            int r2 = r2 + r15
            char r2 = r0.charAt(r2)
            if (r2 != r6) goto L_0x00fc
            r0.token = r5
            int r2 = r0.bp
            r3 = 1
            int r8 = r8 - r3
            int r8 = r8 + r2
            r0.bp = r8
            int r8 = r8 + r3
            r0.bp = r8
            int r2 = r0.len
            if (r8 < r2) goto L_0x00f3
        L_0x00f0:
            r7 = 26
            goto L_0x00f9
        L_0x00f3:
            java.lang.String r2 = r0.text
            char r7 = r2.charAt(r8)
        L_0x00f9:
            r0.ch = r7
            goto L_0x0139
        L_0x00fc:
            r5 = 93
            if (r2 != r5) goto L_0x0113
            r2 = 15
            r0.token = r2
            int r2 = r0.bp
            r3 = 1
            int r8 = r8 - r3
            int r8 = r8 + r2
            r0.bp = r8
            int r8 = r8 + r3
            r0.bp = r8
            int r2 = r0.len
            if (r8 < r2) goto L_0x00f3
            goto L_0x00f0
        L_0x0113:
            if (r2 != r7) goto L_0x0128
            r2 = 13
            r0.token = r2
            int r2 = r0.bp
            r3 = 1
            int r8 = r8 - r3
            int r8 = r8 + r2
            r0.bp = r8
            int r8 = r8 + r3
            r0.bp = r8
            int r2 = r0.len
            if (r8 < r2) goto L_0x00f3
            goto L_0x00f0
        L_0x0128:
            r5 = 26
            if (r2 != r5) goto L_0x0140
            r2 = 20
            r0.token = r2
            int r2 = r0.bp
            r3 = 1
            int r8 = r8 - r3
            int r8 = r8 + r2
            r0.bp = r8
            r0.ch = r5
        L_0x0139:
            r2 = 4
            r0.matchStat = r2
            if (r1 == 0) goto L_0x013f
            long r13 = -r13
        L_0x013f:
            return r13
        L_0x0140:
            r0.matchStat = r11
            return r3
        L_0x0143:
            r0.matchStat = r11
            return r3
        L_0x0146:
            r0.matchStat = r11
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldLong(long):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007d, code lost:
        if (r2.indexOf(92) != -1) goto L_0x007f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String scanFieldString(long r10) {
        /*
            r9 = this;
            r0 = 0
            r9.matchStat = r0
            int r10 = r9.matchFieldHash(r10)
            if (r10 != 0) goto L_0x000b
            r10 = 0
            return r10
        L_0x000b:
            int r11 = r9.bp
            int r1 = r10 + 1
            int r11 = r11 + r10
            int r10 = r9.len
            java.lang.String r2 = "unclosed str, "
            if (r11 >= r10) goto L_0x0110
            java.lang.String r10 = r9.text
            char r10 = r10.charAt(r11)
            r11 = 34
            r3 = -1
            if (r10 == r11) goto L_0x0023
            goto L_0x00f6
        L_0x0023:
            int r10 = r9.bp
            int r10 = r10 + r1
            java.lang.String r4 = r9.text
            int r4 = r4.indexOf(r11, r10)
            if (r4 == r3) goto L_0x00fb
            boolean r2 = V6
            if (r2 == 0) goto L_0x0039
            java.lang.String r2 = r9.text
            java.lang.String r2 = r2.substring(r10, r4)
            goto L_0x0048
        L_0x0039:
            int r2 = r4 - r10
            int r5 = r9.bp
            int r5 = r5 + r1
            char[] r5 = r9.sub_chars(r5, r2)
            java.lang.String r6 = new java.lang.String
            r6.<init>(r5, r0, r2)
            r2 = r6
        L_0x0048:
            r5 = 92
            int r6 = r2.indexOf(r5)
            if (r6 == r3) goto L_0x008d
            r2 = 0
        L_0x0051:
            int r6 = r4 + -1
            r7 = 0
        L_0x0054:
            if (r6 < 0) goto L_0x0064
            java.lang.String r8 = r9.text
            char r8 = r8.charAt(r6)
            if (r8 != r5) goto L_0x0064
            int r7 = r7 + 1
            int r6 = r6 + -1
            r2 = 1
            goto L_0x0054
        L_0x0064:
            int r7 = r7 % 2
            if (r7 != 0) goto L_0x0084
            int r10 = r4 - r10
            int r11 = r9.bp
            int r11 = r11 + r1
            char[] r11 = r9.sub_chars(r11, r10)
            if (r2 == 0) goto L_0x0074
            goto L_0x007f
        L_0x0074:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r11, r0, r10)
            int r0 = r2.indexOf(r5)
            if (r0 == r3) goto L_0x008d
        L_0x007f:
            java.lang.String r2 = readString(r11, r10)
            goto L_0x008d
        L_0x0084:
            java.lang.String r6 = r9.text
            int r4 = r4 + 1
            int r4 = r6.indexOf(r11, r4)
            goto L_0x0051
        L_0x008d:
            int r4 = r4 + 1
            int r10 = r9.len
            r11 = 26
            if (r4 < r10) goto L_0x0098
            r10 = 26
            goto L_0x009e
        L_0x0098:
            java.lang.String r10 = r9.text
            char r10 = r10.charAt(r4)
        L_0x009e:
            r0 = 16
            r1 = 44
            if (r10 != r1) goto L_0x00bd
            r9.bp = r4
            int r4 = r4 + 1
            r9.bp = r4
            int r10 = r9.len
            if (r4 < r10) goto L_0x00af
            goto L_0x00b5
        L_0x00af:
            java.lang.String r10 = r9.text
            char r11 = r10.charAt(r4)
        L_0x00b5:
            r9.ch = r11
            r10 = 3
            r9.matchStat = r10
            r9.token = r0
            return r2
        L_0x00bd:
            r5 = 125(0x7d, float:1.75E-43)
            if (r10 != r5) goto L_0x00f6
            int r4 = r4 + 1
            int r10 = r9.len
            if (r4 < r10) goto L_0x00ca
            r10 = 26
            goto L_0x00d0
        L_0x00ca:
            java.lang.String r10 = r9.text
            char r10 = r10.charAt(r4)
        L_0x00d0:
            if (r10 != r1) goto L_0x00d5
            r9.token = r0
            goto L_0x00e2
        L_0x00d5:
            r0 = 93
            if (r10 != r0) goto L_0x00dc
            r10 = 15
            goto L_0x00e0
        L_0x00dc:
            if (r10 != r5) goto L_0x00e8
            r10 = 13
        L_0x00e0:
            r9.token = r10
        L_0x00e2:
            r9.bp = r4
            r9.next()
            goto L_0x00f2
        L_0x00e8:
            if (r10 != r11) goto L_0x00f6
            r10 = 20
            r9.token = r10
            r9.bp = r4
            r9.ch = r11
        L_0x00f2:
            r10 = 4
            r9.matchStat = r10
            return r2
        L_0x00f6:
            r9.matchStat = r3
            java.lang.String r10 = r9.stringDefaultValue
            return r10
        L_0x00fb:
            com.alibaba.fastjson.JSONException r10 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r11 = a.a.a.a.a.n(r2)
            java.lang.String r0 = r9.info()
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x0110:
            com.alibaba.fastjson.JSONException r10 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r11 = a.a.a.a.a.n(r2)
            java.lang.String r0 = r9.info()
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            goto L_0x0126
        L_0x0125:
            throw r10
        L_0x0126:
            goto L_0x0125
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldString(long):java.lang.String");
    }

    public long scanFieldSymbol(long j) {
        int i;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j);
        if (matchFieldHash == 0) {
            return 0;
        }
        int i2 = matchFieldHash + 1;
        int i3 = this.bp + matchFieldHash;
        int i4 = this.len;
        char c2 = EOI;
        if ((i3 >= i4 ? EOI : this.text.charAt(i3)) != '\"') {
            this.matchStat = -1;
            return 0;
        }
        long j2 = -3750763034362895579L;
        while (true) {
            int i5 = i2 + 1;
            int i6 = this.bp + i2;
            char charAt = i6 >= this.len ? EOI : this.text.charAt(i6);
            if (charAt == '\"') {
                int i7 = i5 + 1;
                int i8 = this.bp + i5;
                char charAt2 = i8 >= this.len ? EOI : this.text.charAt(i8);
                if (charAt2 == ',') {
                    int i9 = (i7 - 1) + this.bp;
                    this.bp = i9;
                    int i10 = i9 + 1;
                    this.bp = i10;
                    if (i10 < this.len) {
                        c2 = this.text.charAt(i10);
                    }
                    this.ch = c2;
                    this.matchStat = 3;
                    return j2;
                } else if (charAt2 == '}') {
                    int i11 = i7 + 1;
                    int i12 = this.bp + i7;
                    char charAt3 = i12 >= this.len ? EOI : this.text.charAt(i12);
                    if (charAt3 == ',') {
                        i = 16;
                    } else if (charAt3 == ']') {
                        i = 15;
                    } else if (charAt3 == '}') {
                        i = 13;
                    } else if (charAt3 == 26) {
                        this.token = 20;
                        this.bp = (i11 - 1) + this.bp;
                        this.ch = EOI;
                        this.matchStat = 4;
                        return j2;
                    } else {
                        this.matchStat = -1;
                        return 0;
                    }
                    this.token = i;
                    this.bp = (i11 - 1) + this.bp;
                    next();
                    this.matchStat = 4;
                    return j2;
                } else {
                    this.matchStat = -1;
                    return 0;
                }
            } else {
                j2 = (j2 ^ ((long) charAt)) * 1099511628211L;
                if (charAt == '\\') {
                    this.matchStat = -1;
                    return 0;
                }
                i2 = i5;
            }
        }
    }

    public boolean scanISO8601DateIfMatch(boolean z) {
        return scanISO8601DateIfMatch(z, this.len - this.bp);
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x01ff A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0200  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean scanISO8601DateIfMatch(boolean r27, int r28) {
        /*
            r26 = this;
            r9 = r26
            r10 = r28
            r0 = 47
            r1 = 13
            r2 = 57
            r11 = 1
            r3 = 48
            r4 = 0
            if (r27 != 0) goto L_0x00a9
            if (r10 <= r1) goto L_0x00a9
            int r1 = r9.bp
            char r1 = r9.charAt(r1)
            int r5 = r9.bp
            int r5 = r5 + 1
            char r5 = r9.charAt(r5)
            int r6 = r9.bp
            int r6 = r6 + 2
            char r6 = r9.charAt(r6)
            int r7 = r9.bp
            int r7 = r7 + 3
            char r7 = r9.charAt(r7)
            int r8 = r9.bp
            int r8 = r8 + 4
            char r8 = r9.charAt(r8)
            int r12 = r9.bp
            int r12 = r12 + 5
            char r12 = r9.charAt(r12)
            int r13 = r9.bp
            int r13 = r13 + r10
            int r13 = r13 + -1
            char r13 = r9.charAt(r13)
            int r14 = r9.bp
            int r14 = r14 + r10
            int r14 = r14 + -2
            char r14 = r9.charAt(r14)
            if (r1 != r0) goto L_0x00a9
            r1 = 68
            if (r5 != r1) goto L_0x00a9
            r1 = 97
            if (r6 != r1) goto L_0x00a9
            r1 = 116(0x74, float:1.63E-43)
            if (r7 != r1) goto L_0x00a9
            r1 = 101(0x65, float:1.42E-43)
            if (r8 != r1) goto L_0x00a9
            r1 = 40
            if (r12 != r1) goto L_0x00a9
            if (r13 != r0) goto L_0x00a9
            r1 = 41
            if (r14 != r1) goto L_0x00a9
            r0 = -1
            r1 = 6
        L_0x0070:
            if (r1 >= r10) goto L_0x0087
            int r5 = r9.bp
            int r5 = r5 + r1
            char r5 = r9.charAt(r5)
            r6 = 43
            if (r5 != r6) goto L_0x007f
            r0 = r1
            goto L_0x0084
        L_0x007f:
            if (r5 < r3) goto L_0x0087
            if (r5 <= r2) goto L_0x0084
            goto L_0x0087
        L_0x0084:
            int r1 = r1 + 1
            goto L_0x0070
        L_0x0087:
            r1 = -1
            if (r0 != r1) goto L_0x008b
            return r4
        L_0x008b:
            int r1 = r9.bp
            int r1 = r1 + 6
            int r0 = r0 - r1
            java.lang.String r0 = r9.subString(r1, r0)
            long r0 = java.lang.Long.parseLong(r0)
            java.util.TimeZone r2 = r9.timeZone
            java.util.Locale r3 = r9.locale
            java.util.Calendar r2 = java.util.Calendar.getInstance(r2, r3)
            r9.calendar = r2
            r2.setTimeInMillis(r0)
            r0 = 5
            r9.token = r0
            return r11
        L_0x00a9:
            r1 = 84
            r2 = 16
            r3 = 8
            r5 = 9
            r6 = 14
            r7 = 45
            if (r10 == r3) goto L_0x049e
            if (r10 == r6) goto L_0x049e
            if (r10 != r2) goto L_0x00c9
            int r2 = r9.bp
            int r2 = r2 + 10
            char r2 = r9.charAt(r2)
            if (r2 == r1) goto L_0x049e
            r1 = 32
            if (r2 == r1) goto L_0x049e
        L_0x00c9:
            r1 = 17
            if (r10 != r1) goto L_0x00d9
            int r1 = r9.bp
            int r1 = r1 + 6
            char r1 = r9.charAt(r1)
            if (r1 == r7) goto L_0x00d9
            goto L_0x049e
        L_0x00d9:
            if (r10 >= r5) goto L_0x00dc
            return r4
        L_0x00dc:
            int r1 = r9.bp
            char r1 = r9.charAt(r1)
            int r2 = r9.bp
            int r2 = r2 + 1
            char r2 = r9.charAt(r2)
            int r4 = r9.bp
            int r4 = r4 + 2
            char r4 = r9.charAt(r4)
            int r6 = r9.bp
            int r6 = r6 + 3
            char r6 = r9.charAt(r6)
            int r8 = r9.bp
            int r8 = r8 + 4
            char r8 = r9.charAt(r8)
            int r12 = r9.bp
            int r12 = r12 + 5
            char r12 = r9.charAt(r12)
            int r13 = r9.bp
            int r13 = r13 + 6
            char r13 = r9.charAt(r13)
            int r14 = r9.bp
            int r14 = r14 + 7
            char r14 = r9.charAt(r14)
            int r15 = r9.bp
            int r15 = r15 + r3
            char r3 = r9.charAt(r15)
            int r15 = r9.bp
            int r15 = r15 + r5
            char r5 = r9.charAt(r15)
            r15 = 26085(0x65e5, float:3.6553E-41)
            if (r8 != r7) goto L_0x012e
            if (r14 == r7) goto L_0x0132
        L_0x012e:
            if (r8 != r0) goto L_0x0136
            if (r14 != r0) goto L_0x0136
        L_0x0132:
            r0 = 10
            goto L_0x01d5
        L_0x0136:
            if (r8 != r7) goto L_0x015f
            if (r13 != r7) goto L_0x015f
            r0 = 32
            if (r3 != r0) goto L_0x0150
            r0 = 48
            r3 = 48
            r5 = 8
            r3 = r4
            r4 = r6
            r6 = r12
            r8 = r14
            r5 = 48
            r7 = 48
            r12 = 8
            goto L_0x01e9
        L_0x0150:
            r0 = 48
            r5 = 9
            r8 = r3
            r3 = r4
            r4 = r6
            r6 = r12
            r7 = r14
            r5 = 48
            r12 = 9
            goto L_0x01e9
        L_0x015f:
            r0 = 46
            if (r4 != r0) goto L_0x0167
            r0 = 46
            if (r12 == r0) goto L_0x016b
        L_0x0167:
            if (r4 != r7) goto L_0x0178
            if (r12 != r7) goto L_0x0178
        L_0x016b:
            r0 = 10
            r7 = r1
            r4 = r5
            r5 = r6
            r6 = r8
            r1 = r13
            r12 = 10
            r8 = r2
            r2 = r14
            goto L_0x01e9
        L_0x0178:
            r0 = 24180(0x5e74, float:3.3883E-41)
            if (r8 == r0) goto L_0x0184
            r0 = 45380(0xb144, float:6.3591E-41)
            if (r8 != r0) goto L_0x0182
            goto L_0x0184
        L_0x0182:
            r0 = 0
            return r0
        L_0x0184:
            r0 = 26376(0x6708, float:3.696E-41)
            if (r14 == r0) goto L_0x01b4
            r0 = 50900(0xc6d4, float:7.1326E-41)
            if (r14 != r0) goto L_0x018e
            goto L_0x01b4
        L_0x018e:
            r0 = 26376(0x6708, float:3.696E-41)
            if (r13 == r0) goto L_0x019a
            r0 = 50900(0xc6d4, float:7.1326E-41)
            if (r13 != r0) goto L_0x0198
            goto L_0x019a
        L_0x0198:
            r0 = 0
            return r0
        L_0x019a:
            r0 = 0
            r7 = 51068(0xc77c, float:7.1562E-41)
            if (r3 == r15) goto L_0x01a9
            if (r3 != r7) goto L_0x01a3
            goto L_0x01a9
        L_0x01a3:
            if (r5 == r15) goto L_0x01ae
            if (r5 != r7) goto L_0x01a8
            goto L_0x01ae
        L_0x01a8:
            return r0
        L_0x01a9:
            r0 = 48
            r3 = r14
            r14 = 48
        L_0x01ae:
            r0 = 48
            r13 = r12
            r12 = 48
            goto L_0x01df
        L_0x01b4:
            r0 = 51068(0xc77c, float:7.1562E-41)
            if (r5 == r15) goto L_0x01dd
            if (r5 != r0) goto L_0x01bc
            goto L_0x01dd
        L_0x01bc:
            int r7 = r9.bp
            int r7 = r7 + 10
            char r7 = r9.charAt(r7)
            if (r7 == r15) goto L_0x01d3
            int r7 = r9.bp
            int r7 = r7 + 10
            char r7 = r9.charAt(r7)
            if (r7 != r0) goto L_0x01d1
            goto L_0x01d3
        L_0x01d1:
            r0 = 0
            return r0
        L_0x01d3:
            r0 = 11
        L_0x01d5:
            r7 = r3
            r3 = r4
            r8 = r5
            r4 = r6
            r5 = r12
            r6 = r13
            r12 = r0
            goto L_0x01e9
        L_0x01dd:
            r14 = 48
        L_0x01df:
            r5 = 10
            r8 = r3
            r3 = r4
            r4 = r6
            r5 = r12
            r6 = r13
            r7 = r14
            r12 = 10
        L_0x01e9:
            r15 = r1
            r16 = r2
            r17 = r3
            r18 = r4
            r19 = r5
            r20 = r6
            r21 = r7
            r22 = r8
            boolean r0 = checkDate(r15, r16, r17, r18, r19, r20, r21, r22)
            r13 = 0
            if (r0 != 0) goto L_0x0200
            return r13
        L_0x0200:
            r13 = 45
            r14 = 0
            r15 = 26085(0x65e5, float:3.6553E-41)
            r0 = 51068(0xc77c, float:7.1562E-41)
            r11 = 51068(0xc77c, float:7.1562E-41)
            r0 = r26
            r0.setCalendar(r1, r2, r3, r4, r5, r6, r7, r8)
            int r0 = r9.bp
            int r0 = r0 + r12
            char r7 = r9.charAt(r0)
            r0 = 84
            if (r7 == r0) goto L_0x02bf
            r0 = 32
            if (r7 != r0) goto L_0x0223
            if (r27 != 0) goto L_0x0223
            goto L_0x02bf
        L_0x0223:
            r0 = 34
            if (r7 == r0) goto L_0x0294
            r0 = 26
            if (r7 == r0) goto L_0x0294
            if (r7 == r15) goto L_0x0294
            if (r7 != r11) goto L_0x0230
            goto L_0x0294
        L_0x0230:
            r0 = 43
            if (r7 == r0) goto L_0x0238
            if (r7 != r13) goto L_0x0237
            goto L_0x0238
        L_0x0237:
            return r14
        L_0x0238:
            int r0 = r9.len
            int r1 = r12 + 6
            if (r0 != r1) goto L_0x0293
            int r0 = r9.bp
            int r0 = r0 + r12
            int r0 = r0 + 3
            char r0 = r9.charAt(r0)
            r1 = 58
            if (r0 != r1) goto L_0x0293
            int r0 = r9.bp
            int r0 = r0 + r12
            int r0 = r0 + 4
            char r0 = r9.charAt(r0)
            r1 = 48
            if (r0 != r1) goto L_0x0293
            int r0 = r9.bp
            int r0 = r0 + r12
            int r0 = r0 + 5
            char r0 = r9.charAt(r0)
            if (r0 == r1) goto L_0x0264
            goto L_0x0293
        L_0x0264:
            r1 = 48
            r2 = 48
            r3 = 48
            r4 = 48
            r5 = 48
            r6 = 48
            r0 = r26
            r0.setTime(r1, r2, r3, r4, r5, r6)
            java.util.Calendar r0 = r9.calendar
            r1 = 14
            r0.set(r1, r14)
            int r0 = r9.bp
            int r0 = r0 + r12
            int r0 = r0 + 1
            char r0 = r9.charAt(r0)
            int r1 = r9.bp
            int r1 = r1 + r12
            int r1 = r1 + 2
            char r1 = r9.charAt(r1)
            r9.setTimeZone(r7, r0, r1)
        L_0x0291:
            r0 = 1
            return r0
        L_0x0293:
            return r14
        L_0x0294:
            r0 = 5
            r1 = 14
            java.util.Calendar r2 = r9.calendar
            r3 = 11
            r2.set(r3, r14)
            java.util.Calendar r2 = r9.calendar
            r3 = 12
            r2.set(r3, r14)
            java.util.Calendar r2 = r9.calendar
            r3 = 13
            r2.set(r3, r14)
            java.util.Calendar r2 = r9.calendar
            r2.set(r1, r14)
            int r1 = r9.bp
            int r1 = r1 + r12
            r9.bp = r1
            char r1 = r9.charAt(r1)
            r9.ch = r1
        L_0x02bc:
            r9.token = r0
            goto L_0x0291
        L_0x02bf:
            r7 = 5
            r8 = 14
            int r11 = r12 + 9
            r13 = 45
            if (r10 >= r11) goto L_0x02c9
            return r14
        L_0x02c9:
            int r0 = r9.bp
            int r0 = r0 + r12
            int r0 = r0 + 3
            char r0 = r9.charAt(r0)
            r1 = 58
            if (r0 == r1) goto L_0x02d7
            return r14
        L_0x02d7:
            int r0 = r9.bp
            int r0 = r0 + r12
            int r0 = r0 + 6
            char r0 = r9.charAt(r0)
            if (r0 == r1) goto L_0x02e3
            return r14
        L_0x02e3:
            int r0 = r9.bp
            int r0 = r0 + r12
            int r0 = r0 + 1
            char r15 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + r12
            int r0 = r0 + 2
            char r17 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + r12
            int r0 = r0 + 4
            char r18 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + r12
            int r0 = r0 + r7
            char r19 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + r12
            int r0 = r0 + 7
            char r20 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + r12
            int r0 = r0 + 8
            char r21 = r9.charAt(r0)
            r1 = r15
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r21
            boolean r0 = checkTime(r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x032a
            return r14
        L_0x032a:
            r0 = r26
            r1 = r15
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r21
            r0.setTime(r1, r2, r3, r4, r5, r6)
            int r0 = r9.bp
            int r0 = r0 + r12
            int r0 = r0 + 9
            char r0 = r9.charAt(r0)
            r1 = 46
            if (r0 != r1) goto L_0x0468
            int r0 = r12 + 11
            if (r10 >= r0) goto L_0x034c
            return r14
        L_0x034c:
            int r1 = r9.bp
            int r1 = r1 + r12
            int r1 = r1 + 10
            char r1 = r9.charAt(r1)
            r2 = 48
            if (r1 < r2) goto L_0x0467
            r3 = 57
            if (r1 <= r3) goto L_0x035f
            goto L_0x0467
        L_0x035f:
            int r1 = r1 - r2
            if (r10 <= r0) goto L_0x0375
            int r0 = r9.bp
            int r0 = r0 + r12
            int r0 = r0 + 11
            char r0 = r9.charAt(r0)
            if (r0 < r2) goto L_0x0375
            if (r0 > r3) goto L_0x0375
            int r1 = r1 * 10
            int r0 = r0 - r2
            int r1 = r1 + r0
            r0 = 2
            goto L_0x0376
        L_0x0375:
            r0 = 1
        L_0x0376:
            r2 = 2
            if (r0 != r2) goto L_0x038f
            int r2 = r9.bp
            int r2 = r2 + r12
            int r2 = r2 + 12
            char r2 = r9.charAt(r2)
            r3 = 48
            if (r2 < r3) goto L_0x038f
            r4 = 57
            if (r2 > r4) goto L_0x038f
            int r1 = r1 * 10
            int r2 = r2 - r3
            int r1 = r1 + r2
            r0 = 3
        L_0x038f:
            java.util.Calendar r2 = r9.calendar
            r2.set(r8, r1)
            int r1 = r9.bp
            int r1 = r1 + r12
            int r1 = r1 + 10
            int r1 = r1 + r0
            char r1 = r9.charAt(r1)
            r2 = 43
            if (r1 == r2) goto L_0x03cd
            if (r1 != r13) goto L_0x03a5
            goto L_0x03cd
        L_0x03a5:
            r2 = 90
            if (r1 != r2) goto L_0x03ca
            java.util.Calendar r1 = r9.calendar
            java.util.TimeZone r1 = r1.getTimeZone()
            int r1 = r1.getRawOffset()
            if (r1 == 0) goto L_0x03c7
            java.lang.String[] r1 = java.util.TimeZone.getAvailableIDs(r14)
            int r2 = r1.length
            if (r2 <= 0) goto L_0x03c7
            r1 = r1[r14]
            java.util.TimeZone r1 = java.util.TimeZone.getTimeZone(r1)
            java.util.Calendar r2 = r9.calendar
            r2.setTimeZone(r1)
        L_0x03c7:
            r1 = 1
            goto L_0x0442
        L_0x03ca:
            r1 = 0
            goto L_0x0442
        L_0x03cd:
            int r2 = r9.bp
            int r2 = r2 + r12
            int r2 = r2 + 10
            int r2 = r2 + r0
            int r2 = r2 + 1
            char r2 = r9.charAt(r2)
            r3 = 48
            if (r2 < r3) goto L_0x0467
            r4 = 49
            if (r2 <= r4) goto L_0x03e3
            goto L_0x0467
        L_0x03e3:
            int r4 = r9.bp
            int r4 = r4 + r12
            int r4 = r4 + 10
            int r4 = r4 + r0
            int r4 = r4 + 2
            char r4 = r9.charAt(r4)
            if (r4 < r3) goto L_0x0467
            r3 = 57
            if (r4 <= r3) goto L_0x03f7
            goto L_0x0467
        L_0x03f7:
            int r3 = r9.bp
            int r3 = r3 + r12
            int r3 = r3 + 10
            int r3 = r3 + r0
            int r3 = r3 + 3
            char r3 = r9.charAt(r3)
            r5 = 58
            if (r3 != r5) goto L_0x0428
            int r3 = r9.bp
            int r3 = r3 + r12
            int r3 = r3 + 10
            int r3 = r3 + r0
            int r3 = r3 + 4
            char r3 = r9.charAt(r3)
            r5 = 48
            if (r3 == r5) goto L_0x0418
            return r14
        L_0x0418:
            int r3 = r9.bp
            int r3 = r3 + r12
            int r3 = r3 + 10
            int r3 = r3 + r0
            int r3 = r3 + r7
            char r3 = r9.charAt(r3)
            if (r3 == r5) goto L_0x0426
            return r14
        L_0x0426:
            r3 = 6
            goto L_0x043e
        L_0x0428:
            r5 = 48
            if (r3 != r5) goto L_0x043d
            int r3 = r9.bp
            int r3 = r3 + r12
            int r3 = r3 + 10
            int r3 = r3 + r0
            int r3 = r3 + 4
            char r3 = r9.charAt(r3)
            if (r3 == r5) goto L_0x043b
            return r14
        L_0x043b:
            r3 = 5
            goto L_0x043e
        L_0x043d:
            r3 = 3
        L_0x043e:
            r9.setTimeZone(r1, r2, r4)
            r1 = r3
        L_0x0442:
            int r2 = r9.bp
            r3 = 10
            int r0 = a.a.a.a.a.b(r12, r3, r0, r1)
            int r2 = r2 + r0
            char r1 = r9.charAt(r2)
            r2 = 26
            if (r1 == r2) goto L_0x0458
            r2 = 34
            if (r1 == r2) goto L_0x0458
            return r14
        L_0x0458:
            int r1 = r9.bp
            int r1 = r1 + r0
            r9.bp = r1
            char r0 = r9.charAt(r1)
            r9.ch = r0
            r9.token = r7
            goto L_0x0291
        L_0x0467:
            return r14
        L_0x0468:
            java.util.Calendar r1 = r9.calendar
            r1.set(r8, r14)
            int r1 = r9.bp
            int r1 = r1 + r11
            r9.bp = r1
            char r1 = r9.charAt(r1)
            r9.ch = r1
            r9.token = r7
            r1 = 90
            if (r0 != r1) goto L_0x049c
            java.util.Calendar r0 = r9.calendar
            java.util.TimeZone r0 = r0.getTimeZone()
            int r0 = r0.getRawOffset()
            if (r0 == 0) goto L_0x049c
            java.lang.String[] r0 = java.util.TimeZone.getAvailableIDs(r14)
            int r1 = r0.length
            if (r1 <= 0) goto L_0x049c
            r0 = r0[r14]
            java.util.TimeZone r0 = java.util.TimeZone.getTimeZone(r0)
            java.util.Calendar r1 = r9.calendar
            r1.setTimeZone(r0)
        L_0x049c:
            r0 = 1
            return r0
        L_0x049e:
            r0 = 45
            r1 = 0
            r11 = 16
            r12 = 11
            if (r27 == 0) goto L_0x04a8
            return r1
        L_0x04a8:
            int r2 = r9.bp
            char r2 = r9.charAt(r2)
            int r3 = r9.bp
            int r3 = r3 + 1
            char r3 = r9.charAt(r3)
            int r4 = r9.bp
            int r4 = r4 + 2
            char r4 = r9.charAt(r4)
            int r5 = r9.bp
            int r5 = r5 + 3
            char r5 = r9.charAt(r5)
            int r6 = r9.bp
            int r6 = r6 + 4
            char r6 = r9.charAt(r6)
            int r7 = r9.bp
            int r7 = r7 + 5
            char r7 = r9.charAt(r7)
            int r8 = r9.bp
            int r8 = r8 + 6
            char r8 = r9.charAt(r8)
            int r13 = r9.bp
            int r13 = r13 + 7
            char r13 = r9.charAt(r13)
            int r14 = r9.bp
            int r14 = r14 + 8
            char r14 = r9.charAt(r14)
            if (r6 != r0) goto L_0x04f4
            if (r13 != r0) goto L_0x04f4
            r0 = 1
            goto L_0x04f5
        L_0x04f4:
            r0 = 0
        L_0x04f5:
            if (r0 == 0) goto L_0x04fb
            if (r10 != r11) goto L_0x04fb
            r15 = 1
            goto L_0x04fc
        L_0x04fb:
            r15 = 0
        L_0x04fc:
            if (r0 == 0) goto L_0x0506
            r0 = 17
            if (r10 != r0) goto L_0x0506
            r0 = 1
            r25 = 1
            goto L_0x0509
        L_0x0506:
            r0 = 0
            r25 = 0
        L_0x0509:
            if (r25 != 0) goto L_0x050d
            if (r15 == 0) goto L_0x0519
        L_0x050d:
            int r0 = r9.bp
            int r0 = r0 + 9
            char r0 = r9.charAt(r0)
            r13 = r0
            r6 = r7
            r7 = r8
            r8 = r14
        L_0x0519:
            r17 = r2
            r18 = r3
            r19 = r4
            r20 = r5
            r21 = r6
            r22 = r7
            r23 = r8
            r24 = r13
            boolean r0 = checkDate(r17, r18, r19, r20, r21, r22, r23, r24)
            if (r0 != 0) goto L_0x0530
            return r1
        L_0x0530:
            r1 = 8
            r0 = r26
            r11 = 8
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r13
            r0.setCalendar(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r10 == r11) goto L_0x0613
            int r0 = r9.bp
            int r0 = r0 + 9
            char r0 = r9.charAt(r0)
            int r1 = r9.bp
            int r1 = r1 + 10
            char r1 = r9.charAt(r1)
            int r2 = r9.bp
            int r2 = r2 + r12
            char r2 = r9.charAt(r2)
            int r3 = r9.bp
            int r3 = r3 + 12
            char r3 = r9.charAt(r3)
            int r4 = r9.bp
            int r4 = r4 + 13
            char r4 = r9.charAt(r4)
            if (r25 == 0) goto L_0x0581
            r5 = 84
            if (r1 != r5) goto L_0x0581
            r5 = 58
            if (r4 != r5) goto L_0x0581
            int r5 = r9.bp
            r6 = 16
            int r5 = r5 + r6
            char r5 = r9.charAt(r5)
            r6 = 90
            if (r5 == r6) goto L_0x058f
        L_0x0581:
            if (r15 == 0) goto L_0x05a8
            r5 = 32
            if (r1 == r5) goto L_0x058b
            r5 = 84
            if (r1 != r5) goto L_0x05a8
        L_0x058b:
            r5 = 58
            if (r4 != r5) goto L_0x05a8
        L_0x058f:
            int r0 = r9.bp
            int r0 = r0 + 14
            char r1 = r9.charAt(r0)
            int r0 = r9.bp
            int r0 = r0 + 15
            char r0 = r9.charAt(r0)
            r4 = 48
            r5 = 48
            r14 = r2
            r2 = r0
            r0 = r3
            r3 = 48
        L_0x05a8:
            r18 = r14
            r19 = r0
            r20 = r1
            r21 = r2
            r22 = r3
            r23 = r4
            boolean r5 = checkTime(r18, r19, r20, r21, r22, r23)
            if (r5 != 0) goto L_0x05bc
            r0 = 0
            return r0
        L_0x05bc:
            r5 = 17
            if (r10 != r5) goto L_0x0600
            if (r25 != 0) goto L_0x0600
            int r5 = r9.bp
            int r5 = r5 + 14
            char r5 = r9.charAt(r5)
            int r6 = r9.bp
            int r6 = r6 + 15
            char r6 = r9.charAt(r6)
            int r7 = r9.bp
            r8 = 16
            int r7 = r7 + r8
            char r7 = r9.charAt(r7)
            r8 = 48
            if (r5 < r8) goto L_0x05fe
            r10 = 57
            if (r5 <= r10) goto L_0x05e4
            goto L_0x05fe
        L_0x05e4:
            if (r6 < r8) goto L_0x05fc
            if (r6 <= r10) goto L_0x05e9
            goto L_0x05fc
        L_0x05e9:
            if (r7 < r8) goto L_0x05fa
            if (r7 <= r10) goto L_0x05ee
            goto L_0x05fa
        L_0x05ee:
            int r5 = r5 - r8
            int r5 = r5 * 100
            int r6 = r6 - r8
            int r6 = r6 * 10
            int r6 = r6 + r5
            int r7 = r7 - r8
            int r7 = r7 + r6
            r5 = 48
            goto L_0x0603
        L_0x05fa:
            r0 = 0
            return r0
        L_0x05fc:
            r0 = 0
            return r0
        L_0x05fe:
            r0 = 0
            return r0
        L_0x0600:
            r5 = 48
            r7 = 0
        L_0x0603:
            int r14 = r14 - r5
            int r14 = r14 * 10
            int r0 = r0 - r5
            int r0 = r0 + r14
            int r1 = r1 - r5
            int r1 = r1 * 10
            int r2 = r2 - r5
            int r2 = r2 + r1
            int r3 = r3 - r5
            int r3 = r3 * 10
            int r4 = r4 - r5
            int r4 = r4 + r3
            goto L_0x0617
        L_0x0613:
            r7 = 0
            r2 = 0
            r4 = 0
            r0 = 0
        L_0x0617:
            java.util.Calendar r1 = r9.calendar
            r1.set(r12, r0)
            java.util.Calendar r0 = r9.calendar
            r1 = 12
            r0.set(r1, r2)
            java.util.Calendar r0 = r9.calendar
            r1 = 13
            r0.set(r1, r4)
            java.util.Calendar r0 = r9.calendar
            r1 = 14
            r0.set(r1, r7)
            r0 = 5
            goto L_0x02bc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanISO8601DateIfMatch(boolean, int):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long scanLongValue() {
        /*
            r12 = this;
            r0 = 0
            r12.np = r0
            char r1 = r12.ch
            r2 = 45
            if (r1 != r2) goto L_0x003d
            r0 = -9223372036854775808
            r2 = 0
            int r2 = r2 + 1
            r12.np = r2
            int r2 = r12.bp
            int r2 = r2 + 1
            r12.bp = r2
            int r3 = r12.len
            if (r2 >= r3) goto L_0x0026
            java.lang.String r3 = r12.text
            char r2 = r3.charAt(r2)
            r12.ch = r2
            r2 = 1
            r1 = r0
            r0 = 1
            goto L_0x0042
        L_0x0026:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.String r1 = "syntax error, "
            java.lang.StringBuilder r1 = a.a.a.a.a.n(r1)
            java.lang.String r2 = r12.info()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x003d:
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0042:
            r3 = 0
        L_0x0044:
            char r5 = r12.ch
            r6 = 48
            if (r5 < r6) goto L_0x00c3
            r6 = 57
            if (r5 > r6) goto L_0x00c3
            int r5 = r5 + -48
            r6 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            java.lang.String r8 = ", "
            java.lang.String r9 = "error long value, "
            int r10 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r10 < 0) goto L_0x00a4
            r6 = 10
            long r3 = r3 * r6
            long r5 = (long) r5
            long r10 = r1 + r5
            int r7 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r7 < 0) goto L_0x0085
            long r3 = r3 - r5
            int r5 = r12.np
            int r5 = r5 + 1
            r12.np = r5
            int r5 = r12.bp
            int r5 = r5 + 1
            r12.bp = r5
            int r6 = r12.len
            if (r5 < r6) goto L_0x007c
            r5 = 26
            goto L_0x0082
        L_0x007c:
            java.lang.String r6 = r12.text
            char r5 = r6.charAt(r5)
        L_0x0082:
            r12.ch = r5
            goto L_0x0044
        L_0x0085:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r9)
            r1.append(r3)
            r1.append(r8)
            java.lang.String r2 = r12.info()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00a4:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r9)
            r1.append(r3)
            r1.append(r8)
            java.lang.String r2 = r12.info()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00c3:
            if (r0 != 0) goto L_0x00c6
            long r3 = -r3
        L_0x00c6:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanLongValue():long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003d, code lost:
        if (r0 >= r9.len) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001a, code lost:
        if (r0 >= r9.len) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001c, code lost:
        r0 = EOI;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e5, code lost:
        if (r0 >= r9.len) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e7, code lost:
        r0 = EOI;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ea, code lost:
        r0 = r9.text.charAt(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00f0, code lost:
        r9.ch = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001f, code lost:
        r0 = r9.text.charAt(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0104, code lost:
        if (r0 >= r9.len) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0025, code lost:
        r9.ch = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void scanNumber() {
        /*
            r9 = this;
            int r0 = r9.bp
            r9.np = r0
            r1 = 0
            r9.exp = r1
            char r2 = r9.ch
            r3 = 45
            r4 = 26
            r5 = 1
            if (r2 != r3) goto L_0x0027
            int r2 = r9.sp
            int r2 = r2 + r5
            r9.sp = r2
            int r0 = r0 + r5
            r9.bp = r0
            int r2 = r9.len
            if (r0 < r2) goto L_0x001f
        L_0x001c:
            r0 = 26
            goto L_0x0025
        L_0x001f:
            java.lang.String r2 = r9.text
            char r0 = r2.charAt(r0)
        L_0x0025:
            r9.ch = r0
        L_0x0027:
            char r0 = r9.ch
            r2 = 57
            r6 = 48
            if (r0 < r6) goto L_0x0040
            if (r0 > r2) goto L_0x0040
            int r0 = r9.sp
            int r0 = r0 + r5
            r9.sp = r0
            int r0 = r9.bp
            int r0 = r0 + r5
            r9.bp = r0
            int r2 = r9.len
            if (r0 < r2) goto L_0x001f
            goto L_0x001c
        L_0x0040:
            r9.isDouble = r1
            char r0 = r9.ch
            r1 = 46
            if (r0 != r1) goto L_0x0083
            int r0 = r9.sp
            int r0 = r0 + r5
            r9.sp = r0
            int r0 = r9.bp
            int r0 = r0 + r5
            r9.bp = r0
            int r1 = r9.len
            if (r0 < r1) goto L_0x0059
            r0 = 26
            goto L_0x005f
        L_0x0059:
            java.lang.String r1 = r9.text
            char r0 = r1.charAt(r0)
        L_0x005f:
            r9.ch = r0
            r9.isDouble = r5
        L_0x0063:
            char r0 = r9.ch
            if (r0 < r6) goto L_0x0083
            if (r0 > r2) goto L_0x0083
            int r0 = r9.sp
            int r0 = r0 + r5
            r9.sp = r0
            int r0 = r9.bp
            int r0 = r0 + r5
            r9.bp = r0
            int r1 = r9.len
            if (r0 < r1) goto L_0x007a
            r0 = 26
            goto L_0x0080
        L_0x007a:
            java.lang.String r1 = r9.text
            char r0 = r1.charAt(r0)
        L_0x0080:
            r9.ch = r0
            goto L_0x0063
        L_0x0083:
            char r0 = r9.ch
            r1 = 76
            if (r0 != r1) goto L_0x0093
        L_0x0089:
            int r0 = r9.sp
            int r0 = r0 + r5
            r9.sp = r0
            r9.next()
            goto L_0x0118
        L_0x0093:
            r1 = 83
            if (r0 != r1) goto L_0x0098
            goto L_0x0089
        L_0x0098:
            r1 = 66
            if (r0 != r1) goto L_0x009d
            goto L_0x0089
        L_0x009d:
            r1 = 70
            if (r0 != r1) goto L_0x00ad
        L_0x00a1:
            int r0 = r9.sp
            int r0 = r0 + r5
            r9.sp = r0
            r9.next()
        L_0x00a9:
            r9.isDouble = r5
            goto L_0x0118
        L_0x00ad:
            r7 = 68
            if (r0 != r7) goto L_0x00b2
            goto L_0x00a1
        L_0x00b2:
            r8 = 101(0x65, float:1.42E-43)
            if (r0 == r8) goto L_0x00ba
            r8 = 69
            if (r0 != r8) goto L_0x0118
        L_0x00ba:
            int r0 = r9.sp
            int r0 = r0 + r5
            r9.sp = r0
            int r0 = r9.bp
            int r0 = r0 + r5
            r9.bp = r0
            int r8 = r9.len
            if (r0 < r8) goto L_0x00cb
            r0 = 26
            goto L_0x00d1
        L_0x00cb:
            java.lang.String r8 = r9.text
            char r0 = r8.charAt(r0)
        L_0x00d1:
            r9.ch = r0
            r8 = 43
            if (r0 == r8) goto L_0x00d9
            if (r0 != r3) goto L_0x00f2
        L_0x00d9:
            int r0 = r9.sp
            int r0 = r0 + r5
            r9.sp = r0
            int r0 = r9.bp
            int r0 = r0 + r5
            r9.bp = r0
            int r3 = r9.len
            if (r0 < r3) goto L_0x00ea
        L_0x00e7:
            r0 = 26
            goto L_0x00f0
        L_0x00ea:
            java.lang.String r3 = r9.text
            char r0 = r3.charAt(r0)
        L_0x00f0:
            r9.ch = r0
        L_0x00f2:
            char r0 = r9.ch
            if (r0 < r6) goto L_0x0107
            if (r0 > r2) goto L_0x0107
            int r0 = r9.sp
            int r0 = r0 + r5
            r9.sp = r0
            int r0 = r9.bp
            int r0 = r0 + r5
            r9.bp = r0
            int r3 = r9.len
            if (r0 < r3) goto L_0x00ea
            goto L_0x00e7
        L_0x0107:
            char r0 = r9.ch
            if (r0 == r7) goto L_0x010d
            if (r0 != r1) goto L_0x0115
        L_0x010d:
            int r0 = r9.sp
            int r0 = r0 + r5
            r9.sp = r0
            r9.next()
        L_0x0115:
            r9.exp = r5
            goto L_0x00a9
        L_0x0118:
            boolean r0 = r9.isDouble
            if (r0 == 0) goto L_0x011e
            r0 = 3
            goto L_0x011f
        L_0x011e:
            r0 = 2
        L_0x011f:
            r9.token = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanNumber():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0147, code lost:
        if (r2 >= r1.len) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0149, code lost:
        r2 = EOI;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x014c, code lost:
        r2 = r1.text.charAt(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0152, code lost:
        r1.ch = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0166, code lost:
        if (r2 >= r1.len) goto L_0x0149;
     */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0202 A[Catch:{ NumberFormatException -> 0x0250 }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x021a A[Catch:{ NumberFormatException -> 0x0250 }] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Number scanNumberValue() {
        /*
            r17 = this;
            r1 = r17
            int r0 = r1.bp
            r2 = 0
            r1.np = r2
            char r3 = r1.ch
            r4 = 45
            r6 = 1
            if (r3 != r4) goto L_0x0029
            r7 = -9223372036854775808
            r3 = 0
            int r3 = r3 + r6
            r1.np = r3
            int r3 = r0 + 1
            r1.bp = r3
            int r9 = r1.len
            if (r3 < r9) goto L_0x001f
            r3 = 26
            goto L_0x0025
        L_0x001f:
            java.lang.String r9 = r1.text
            char r3 = r9.charAt(r3)
        L_0x0025:
            r1.ch = r3
            r3 = 1
            goto L_0x002f
        L_0x0029:
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r3 = 0
        L_0x002f:
            r9 = 0
            r11 = 0
        L_0x0032:
            char r12 = r1.ch
            r13 = 57
            r14 = 48
            if (r12 < r14) goto L_0x006f
            if (r12 > r13) goto L_0x006f
            int r12 = r12 + -48
            r13 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r15 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r15 >= 0) goto L_0x0048
            r11 = 1
        L_0x0048:
            r13 = 10
            long r9 = r9 * r13
            long r12 = (long) r12
            long r14 = r7 + r12
            int r16 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
            if (r16 >= 0) goto L_0x0054
            r11 = 1
        L_0x0054:
            long r9 = r9 - r12
            int r12 = r1.np
            int r12 = r12 + r6
            r1.np = r12
            int r12 = r1.bp
            int r12 = r12 + r6
            r1.bp = r12
            int r13 = r1.len
            if (r12 < r13) goto L_0x0066
            r12 = 26
            goto L_0x006c
        L_0x0066:
            java.lang.String r13 = r1.text
            char r12 = r13.charAt(r12)
        L_0x006c:
            r1.ch = r12
            goto L_0x0032
        L_0x006f:
            if (r3 != 0) goto L_0x0072
            long r9 = -r9
        L_0x0072:
            char r7 = r1.ch
            r8 = 76
            r12 = 68
            r15 = 70
            if (r7 != r8) goto L_0x0089
            int r7 = r1.np
            int r7 = r7 + r6
            r1.np = r7
            r17.next()
            java.lang.Long r7 = java.lang.Long.valueOf(r9)
            goto L_0x00d0
        L_0x0089:
            r8 = 83
            if (r7 != r8) goto L_0x009c
            int r7 = r1.np
            int r7 = r7 + r6
            r1.np = r7
            r17.next()
            int r7 = (int) r9
            short r7 = (short) r7
            java.lang.Short r7 = java.lang.Short.valueOf(r7)
            goto L_0x00d0
        L_0x009c:
            r8 = 66
            if (r7 != r8) goto L_0x00af
            int r7 = r1.np
            int r7 = r7 + r6
            r1.np = r7
            r17.next()
            int r7 = (int) r9
            byte r7 = (byte) r7
            java.lang.Byte r7 = java.lang.Byte.valueOf(r7)
            goto L_0x00d0
        L_0x00af:
            if (r7 != r15) goto L_0x00bf
            int r7 = r1.np
            int r7 = r7 + r6
            r1.np = r7
            r17.next()
            float r7 = (float) r9
            java.lang.Float r7 = java.lang.Float.valueOf(r7)
            goto L_0x00d0
        L_0x00bf:
            if (r7 != r12) goto L_0x00cf
            int r7 = r1.np
            int r7 = r7 + r6
            r1.np = r7
            r17.next()
            double r7 = (double) r9
            java.lang.Double r7 = java.lang.Double.valueOf(r7)
            goto L_0x00d0
        L_0x00cf:
            r7 = 0
        L_0x00d0:
            char r8 = r1.ch
            r5 = 46
            if (r8 != r5) goto L_0x010d
            int r8 = r1.np
            int r8 = r8 + r6
            r1.np = r8
            int r8 = r1.bp
            int r8 = r8 + r6
            r1.bp = r8
            int r5 = r1.len
            if (r8 < r5) goto L_0x00e7
        L_0x00e4:
            r5 = 26
            goto L_0x00ed
        L_0x00e7:
            java.lang.String r5 = r1.text
            char r5 = r5.charAt(r8)
        L_0x00ed:
            r1.ch = r5
            char r5 = r1.ch
            if (r5 < r14) goto L_0x010b
            if (r5 > r13) goto L_0x010b
            int r5 = r1.np
            int r5 = r5 + r6
            r1.np = r5
            int r5 = r1.bp
            int r5 = r5 + r6
            r1.bp = r5
            int r8 = r1.len
            if (r5 < r8) goto L_0x0104
            goto L_0x00e4
        L_0x0104:
            java.lang.String r8 = r1.text
            char r5 = r8.charAt(r5)
            goto L_0x00ed
        L_0x010b:
            r5 = 1
            goto L_0x010e
        L_0x010d:
            r5 = 0
        L_0x010e:
            char r8 = r1.ch
            r2 = 101(0x65, float:1.42E-43)
            r15 = 43
            if (r8 == r2) goto L_0x011e
            r2 = 69
            if (r8 != r2) goto L_0x011b
            goto L_0x011e
        L_0x011b:
            r2 = 0
            r8 = 0
            goto L_0x017f
        L_0x011e:
            int r2 = r1.np
            int r2 = r2 + r6
            r1.np = r2
            int r2 = r1.bp
            int r2 = r2 + r6
            r1.bp = r2
            int r8 = r1.len
            if (r2 < r8) goto L_0x012f
            r2 = 26
            goto L_0x0135
        L_0x012f:
            java.lang.String r8 = r1.text
            char r2 = r8.charAt(r2)
        L_0x0135:
            r1.ch = r2
            if (r2 == r15) goto L_0x013b
            if (r2 != r4) goto L_0x0154
        L_0x013b:
            int r2 = r1.np
            int r2 = r2 + r6
            r1.np = r2
            int r2 = r1.bp
            int r2 = r2 + r6
            r1.bp = r2
            int r8 = r1.len
            if (r2 < r8) goto L_0x014c
        L_0x0149:
            r2 = 26
            goto L_0x0152
        L_0x014c:
            java.lang.String r8 = r1.text
            char r2 = r8.charAt(r2)
        L_0x0152:
            r1.ch = r2
        L_0x0154:
            char r2 = r1.ch
            if (r2 < r14) goto L_0x0169
            if (r2 > r13) goto L_0x0169
            int r2 = r1.np
            int r2 = r2 + r6
            r1.np = r2
            int r2 = r1.bp
            int r2 = r2 + r6
            r1.bp = r2
            int r8 = r1.len
            if (r2 < r8) goto L_0x014c
            goto L_0x0149
        L_0x0169:
            char r2 = r1.ch
            if (r2 == r12) goto L_0x0174
            r8 = 70
            if (r2 != r8) goto L_0x0172
            goto L_0x0174
        L_0x0172:
            r2 = 0
            goto L_0x017e
        L_0x0174:
            int r2 = r1.np
            int r2 = r2 + r6
            r1.np = r2
            char r2 = r1.ch
            r17.next()
        L_0x017e:
            r8 = 1
        L_0x017f:
            if (r5 != 0) goto L_0x01b6
            if (r8 != 0) goto L_0x01b6
            if (r11 == 0) goto L_0x019b
            int r2 = r1.bp
            int r3 = r2 - r0
            char[] r3 = new char[r3]
            java.lang.String r4 = r1.text
            r5 = 0
            r4.getChars(r0, r2, r3, r5)
            java.lang.String r0 = new java.lang.String
            r0.<init>(r3)
            java.math.BigInteger r7 = new java.math.BigInteger
            r7.<init>(r0)
        L_0x019b:
            if (r7 != 0) goto L_0x01b5
            r2 = -2147483648(0xffffffff80000000, double:NaN)
            int r0 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x01b1
            r2 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r0 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x01b1
            int r0 = (int) r9
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)
            goto L_0x01b5
        L_0x01b1:
            java.lang.Long r7 = java.lang.Long.valueOf(r9)
        L_0x01b5:
            return r7
        L_0x01b6:
            int r5 = r1.bp
            int r5 = r5 - r0
            if (r2 == 0) goto L_0x01bd
            int r5 = r5 + -1
        L_0x01bd:
            char[] r7 = r1.sbuf
            int r9 = r7.length
            if (r5 >= r9) goto L_0x01cd
            java.lang.String r9 = r1.text
            int r10 = r0 + r5
            r11 = 0
            r9.getChars(r0, r10, r7, r11)
            char[] r0 = r1.sbuf
            goto L_0x01d8
        L_0x01cd:
            r11 = 0
            char[] r7 = new char[r5]
            java.lang.String r9 = r1.text
            int r10 = r0 + r5
            r9.getChars(r0, r10, r7, r11)
            r0 = r7
        L_0x01d8:
            if (r8 != 0) goto L_0x01ea
            int r7 = r1.features
            com.alibaba.fastjson.parser.Feature r9 = com.alibaba.fastjson.parser.Feature.UseBigDecimal
            int r9 = r9.mask
            r7 = r7 & r9
            if (r7 == 0) goto L_0x01ea
            java.math.BigDecimal r2 = new java.math.BigDecimal
            r2.<init>(r0, r11, r5)
            goto L_0x024f
        L_0x01ea:
            r7 = 9
            if (r5 > r7) goto L_0x0236
            if (r8 != 0) goto L_0x0236
            char r7 = r0[r11]     // Catch:{ NumberFormatException -> 0x0250 }
            if (r7 == r4) goto L_0x01f9
            if (r7 != r15) goto L_0x01f7
            goto L_0x01f9
        L_0x01f7:
            r4 = 1
            goto L_0x01fc
        L_0x01f9:
            r4 = 2
            char r7 = r0[r6]     // Catch:{ NumberFormatException -> 0x0250 }
        L_0x01fc:
            int r7 = r7 - r14
            r8 = r7
            r7 = r4
            r4 = 0
        L_0x0200:
            if (r7 >= r5) goto L_0x0216
            char r9 = r0[r7]     // Catch:{ NumberFormatException -> 0x0250 }
            r10 = 46
            if (r9 != r10) goto L_0x020a
            r4 = 1
            goto L_0x0213
        L_0x020a:
            int r9 = r9 + -48
            int r8 = r8 * 10
            int r8 = r8 + r9
            if (r4 == 0) goto L_0x0213
            int r4 = r4 * 10
        L_0x0213:
            int r7 = r7 + 1
            goto L_0x0200
        L_0x0216:
            r0 = 70
            if (r2 != r0) goto L_0x0225
            float r0 = (float) r8     // Catch:{ NumberFormatException -> 0x0250 }
            float r2 = (float) r4     // Catch:{ NumberFormatException -> 0x0250 }
            float r0 = r0 / r2
            if (r3 == 0) goto L_0x0220
            float r0 = -r0
        L_0x0220:
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ NumberFormatException -> 0x0250 }
            return r0
        L_0x0225:
            double r5 = (double) r8
            double r7 = (double) r4
            java.lang.Double.isNaN(r5)
            java.lang.Double.isNaN(r7)
            double r5 = r5 / r7
            if (r3 == 0) goto L_0x0231
            double r5 = -r5
        L_0x0231:
            java.lang.Double r0 = java.lang.Double.valueOf(r5)     // Catch:{ NumberFormatException -> 0x0250 }
            return r0
        L_0x0236:
            java.lang.String r3 = new java.lang.String     // Catch:{ NumberFormatException -> 0x0250 }
            r4 = 0
            r3.<init>(r0, r4, r5)     // Catch:{ NumberFormatException -> 0x0250 }
            r0 = 70
            if (r2 != r0) goto L_0x0246
            java.lang.Float r0 = java.lang.Float.valueOf(r3)     // Catch:{ NumberFormatException -> 0x0250 }
        L_0x0244:
            r2 = r0
            goto L_0x024f
        L_0x0246:
            double r2 = java.lang.Double.parseDouble(r3)     // Catch:{ NumberFormatException -> 0x0250 }
            java.lang.Double r0 = java.lang.Double.valueOf(r2)     // Catch:{ NumberFormatException -> 0x0250 }
            goto L_0x0244
        L_0x024f:
            return r2
        L_0x0250:
            r0 = move-exception
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r0.getMessage()
            r3.append(r4)
            java.lang.String r4 = ", "
            r3.append(r4)
            java.lang.String r4 = r17.info()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3, r0)
            goto L_0x0274
        L_0x0273:
            throw r2
        L_0x0274:
            goto L_0x0273
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanNumberValue():java.lang.Number");
    }

    public final void scanString() {
        char c2 = this.ch;
        int i = this.bp + 1;
        int indexOf = this.text.indexOf(c2, i);
        if (indexOf != -1) {
            int i2 = indexOf - i;
            char[] sub_chars = sub_chars(this.bp + 1, i2);
            boolean z = false;
            while (i2 > 0 && sub_chars[i2 - 1] == '\\') {
                int i3 = i2 - 2;
                int i4 = 1;
                while (i3 >= 0 && sub_chars[i3] == '\\') {
                    i4++;
                    i3--;
                }
                if (i4 % 2 == 0) {
                    break;
                }
                int indexOf2 = this.text.indexOf(c2, indexOf + 1);
                int i5 = (indexOf2 - indexOf) + i2;
                if (i5 >= sub_chars.length) {
                    int length = (sub_chars.length * 3) / 2;
                    if (length < i5) {
                        length = i5;
                    }
                    char[] cArr = new char[length];
                    System.arraycopy(sub_chars, 0, cArr, 0, sub_chars.length);
                    sub_chars = cArr;
                }
                this.text.getChars(indexOf, indexOf2, sub_chars, i2);
                indexOf = indexOf2;
                i2 = i5;
                z = true;
            }
            if (!z) {
                for (int i6 = 0; i6 < i2; i6++) {
                    if (sub_chars[i6] == '\\') {
                        z = true;
                    }
                }
            }
            this.sbuf = sub_chars;
            this.sp = i2;
            this.np = this.bp;
            this.hasSpecial = z;
            int i7 = indexOf + 1;
            this.bp = i7;
            this.ch = i7 >= this.len ? EOI : this.text.charAt(i7);
            this.token = 4;
            return;
        }
        StringBuilder n = a.n("unclosed str, ");
        n.append(info());
        throw new JSONException(n.toString());
    }

    public String scanStringValue(char c2) {
        String str;
        int i = this.bp + 1;
        int indexOf = this.text.indexOf(c2, i);
        if (indexOf != -1) {
            if (V6) {
                str = this.text.substring(i, indexOf);
            } else {
                int i2 = indexOf - i;
                str = new String(sub_chars(this.bp + 1, i2), 0, i2);
            }
            if (str.indexOf(92) != -1) {
                while (true) {
                    int i3 = indexOf - 1;
                    int i4 = 0;
                    while (i3 >= 0 && this.text.charAt(i3) == '\\') {
                        i4++;
                        i3--;
                    }
                    if (i4 % 2 == 0) {
                        break;
                    }
                    indexOf = this.text.indexOf(c2, indexOf + 1);
                }
                int i5 = indexOf - i;
                str = readString(sub_chars(this.bp + 1, i5), i5);
            }
            int i6 = indexOf + 1;
            this.bp = i6;
            this.ch = i6 >= this.len ? EOI : this.text.charAt(i6);
            return str;
        }
        StringBuilder n = a.n("unclosed str, ");
        n.append(info());
        throw new JSONException(n.toString());
    }

    public final String scanSymbol(SymbolTable symbolTable) {
        char c2;
        while (true) {
            c2 = this.ch;
            if (c2 != ' ' && c2 != 10 && c2 != 13 && c2 != 9 && c2 != 12 && c2 != 8) {
                break;
            }
            next();
        }
        if (c2 == '\"') {
            return scanSymbol(symbolTable, '\"');
        }
        if (c2 == '\'') {
            return scanSymbol(symbolTable, '\'');
        }
        if (c2 == '}') {
            next();
            this.token = 13;
            return null;
        } else if (c2 == ',') {
            next();
            this.token = 16;
            return null;
        } else if (c2 != 26) {
            return scanSymbolUnQuoted(symbolTable);
        } else {
            this.token = 20;
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String scanSymbol(com.alibaba.fastjson.parser.SymbolTable r10, char r11) {
        /*
            r9 = this;
            int r0 = r9.bp
            int r0 = r0 + 1
            java.lang.String r1 = r9.text
            int r1 = r1.indexOf(r11, r0)
            r2 = -1
            if (r1 == r2) goto L_0x0098
            int r0 = r1 - r0
            int r2 = r9.bp
            int r2 = r2 + 1
            char[] r2 = r9.sub_chars(r2, r0)
            r3 = 0
            r4 = 0
        L_0x0019:
            r5 = 92
            if (r0 <= 0) goto L_0x005d
            int r6 = r0 + -1
            char r6 = r2[r6]
            if (r6 != r5) goto L_0x005d
            int r6 = r0 + -2
            r7 = 1
        L_0x0026:
            if (r6 < 0) goto L_0x0031
            char r8 = r2[r6]
            if (r8 != r5) goto L_0x0031
            int r7 = r7 + 1
            int r6 = r6 + -1
            goto L_0x0026
        L_0x0031:
            int r7 = r7 % 2
            if (r7 != 0) goto L_0x0036
            goto L_0x005d
        L_0x0036:
            java.lang.String r4 = r9.text
            int r5 = r1 + 1
            int r4 = r4.indexOf(r11, r5)
            int r5 = r4 - r1
            int r5 = r5 + r0
            int r6 = r2.length
            if (r5 < r6) goto L_0x0053
            int r6 = r2.length
            int r6 = r6 * 3
            int r6 = r6 / 2
            if (r6 >= r5) goto L_0x004c
            r6 = r5
        L_0x004c:
            char[] r6 = new char[r6]
            int r7 = r2.length
            java.lang.System.arraycopy(r2, r3, r6, r3, r7)
            r2 = r6
        L_0x0053:
            java.lang.String r6 = r9.text
            r6.getChars(r1, r4, r2, r0)
            r0 = 1
            r1 = r4
            r0 = r5
            r4 = 1
            goto L_0x0019
        L_0x005d:
            if (r4 != 0) goto L_0x0080
            r11 = 0
            r6 = 0
        L_0x0061:
            if (r11 >= r0) goto L_0x006e
            char r7 = r2[r11]
            int r6 = r6 * 31
            int r6 = r6 + r7
            if (r7 != r5) goto L_0x006b
            r4 = 1
        L_0x006b:
            int r11 = r11 + 1
            goto L_0x0061
        L_0x006e:
            if (r4 == 0) goto L_0x0071
            goto L_0x0080
        L_0x0071:
            r11 = 20
            if (r0 >= r11) goto L_0x007a
            java.lang.String r10 = r10.addSymbol((char[]) r2, (int) r3, (int) r0, (int) r6)
            goto L_0x0084
        L_0x007a:
            java.lang.String r10 = new java.lang.String
            r10.<init>(r2, r3, r0)
            goto L_0x0084
        L_0x0080:
            java.lang.String r10 = readString(r2, r0)
        L_0x0084:
            int r1 = r1 + 1
            r9.bp = r1
            int r11 = r9.len
            if (r1 < r11) goto L_0x008f
            r11 = 26
            goto L_0x0095
        L_0x008f:
            java.lang.String r11 = r9.text
            char r11 = r11.charAt(r1)
        L_0x0095:
            r9.ch = r11
            return r10
        L_0x0098:
            com.alibaba.fastjson.JSONException r10 = new com.alibaba.fastjson.JSONException
            java.lang.String r11 = "unclosed str, "
            java.lang.StringBuilder r11 = a.a.a.a.a.n(r11)
            java.lang.String r0 = r9.info()
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            goto L_0x00b0
        L_0x00af:
            throw r10
        L_0x00b0:
            goto L_0x00af
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanSymbol(com.alibaba.fastjson.parser.SymbolTable, char):java.lang.String");
    }

    public final String scanSymbolUnQuoted(SymbolTable symbolTable) {
        int i = this.ch;
        boolean[] zArr = firstIdentifierFlags;
        if (i >= zArr.length || zArr[i]) {
            this.np = this.bp;
            this.sp = 1;
            while (true) {
                char next = next();
                boolean[] zArr2 = identifierFlags;
                if (next < zArr2.length && !zArr2[next]) {
                    break;
                }
                i = (i * 31) + next;
                this.sp++;
            }
            this.ch = charAt(this.bp);
            this.token = 18;
            if (this.sp != 4 || !this.text.startsWith("null", this.np)) {
                return symbolTable.addSymbol(this.text, this.np, this.sp, i);
            }
            return null;
        }
        StringBuilder n = a.n("illegal identifier : ");
        n.append(this.ch);
        n.append(", ");
        n.append(info());
        throw new JSONException(n.toString());
    }

    public void setTime(char c2, char c3, char c4, char c5, char c6, char c7) {
        this.calendar.set(11, (c3 - '0') + ((c2 - '0') * 10));
        Calendar calendar2 = this.calendar;
        calendar2.set(12, (c5 - '0') + ((c4 - '0') * 10));
        Calendar calendar3 = this.calendar;
        calendar3.set(13, (c7 - '0') + ((c6 - '0') * 10));
    }

    public void setTimeZone(char c2, char c3, char c4) {
        int i = ((c4 - '0') + ((c3 - '0') * 10)) * TimeUtils.SECONDS_PER_HOUR * 1000;
        if (c2 == '-') {
            i = -i;
        }
        if (this.calendar.getTimeZone().getRawOffset() != i) {
            String[] availableIDs = TimeZone.getAvailableIDs(i);
            if (availableIDs.length > 0) {
                this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
            }
        }
    }

    public void skipComment() {
        next();
        char c2 = this.ch;
        if (c2 == '/') {
            do {
                next();
            } while (this.ch != 10);
            next();
            return;
        }
        if (c2 != '*') {
            throw new JSONException("invalid comment");
        }
        while (true) {
            next();
            while (true) {
                char c3 = this.ch;
                if (c3 == 26) {
                    return;
                }
                if (c3 == '*') {
                    next();
                    if (this.ch == '/') {
                        next();
                        return;
                    }
                }
            }
        }
    }

    public final void skipWhitespace() {
        while (true) {
            char c2 = this.ch;
            if (c2 > '/') {
                return;
            }
            if (c2 == ' ' || c2 == 13 || c2 == 10 || c2 == 9 || c2 == 12 || c2 == 8) {
                next();
            } else if (c2 == '/') {
                skipComment();
            } else {
                return;
            }
        }
    }

    public final String stringVal() {
        return this.hasSpecial ? readString(this.sbuf, this.sp) : subString(this.np + 1, this.sp);
    }

    public final char[] sub_chars(int i, int i2) {
        char[] cArr = this.sbuf;
        if (i2 < cArr.length) {
            this.text.getChars(i, i2 + i, cArr, 0);
            return this.sbuf;
        }
        char[] cArr2 = new char[i2];
        this.sbuf = cArr2;
        this.text.getChars(i, i2 + i, cArr2, 0);
        return cArr2;
    }

    public final int token() {
        return this.token;
    }
}
