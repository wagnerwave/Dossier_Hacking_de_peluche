package okhttp3.internal.tls;

import a.a.a.a.a;
import com.tuya.smart.common.o00o0000o0;
import javax.security.auth.x500.X500Principal;

public final class DistinguishedNameParser {
    public int beg;
    public char[] chars;
    public int cur;
    public final String dn;
    public int end;
    public final int length;
    public int pos;

    public DistinguishedNameParser(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.dn = name;
        this.length = name.length();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0097, code lost:
        r1 = r8.chars;
        r2 = r8.beg;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a3, code lost:
        return new java.lang.String(r1, r2, r8.cur - r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String escapedAV() {
        /*
            r8 = this;
            int r0 = r8.pos
            r8.beg = r0
            r8.end = r0
        L_0x0006:
            int r0 = r8.pos
            int r1 = r8.length
            if (r0 < r1) goto L_0x0019
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.chars
            int r2 = r8.beg
            int r3 = r8.end
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L_0x0019:
            char[] r1 = r8.chars
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L_0x005c
            if (r2 == r5) goto L_0x004f
            r5 = 92
            if (r2 == r5) goto L_0x003c
            if (r2 == r4) goto L_0x004f
            if (r2 == r3) goto L_0x004f
            int r2 = r8.end
            int r3 = r2 + 1
            r8.end = r3
            char r3 = r1[r0]
            r1[r2] = r3
            goto L_0x004a
        L_0x003c:
            int r0 = r8.end
            int r2 = r0 + 1
            r8.end = r2
            char r2 = r8.getEscaped()
            r1[r0] = r2
            int r0 = r8.pos
        L_0x004a:
            int r0 = r0 + 1
            r8.pos = r0
            goto L_0x0006
        L_0x004f:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.chars
            int r2 = r8.beg
            int r3 = r8.end
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L_0x005c:
            int r2 = r8.end
            r8.cur = r2
            int r0 = r0 + 1
            r8.pos = r0
            int r0 = r2 + 1
            r8.end = r0
            r1[r2] = r6
        L_0x006a:
            int r0 = r8.pos
            int r1 = r8.length
            if (r0 >= r1) goto L_0x0083
            char[] r1 = r8.chars
            char r2 = r1[r0]
            if (r2 != r6) goto L_0x0083
            int r2 = r8.end
            int r7 = r2 + 1
            r8.end = r7
            r1[r2] = r6
            int r0 = r0 + 1
            r8.pos = r0
            goto L_0x006a
        L_0x0083:
            int r0 = r8.pos
            int r1 = r8.length
            if (r0 == r1) goto L_0x0097
            char[] r1 = r8.chars
            char r2 = r1[r0]
            if (r2 == r3) goto L_0x0097
            char r2 = r1[r0]
            if (r2 == r4) goto L_0x0097
            char r0 = r1[r0]
            if (r0 != r5) goto L_0x0006
        L_0x0097:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.chars
            int r2 = r8.beg
            int r3 = r8.cur
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.tls.DistinguishedNameParser.escapedAV():java.lang.String");
    }

    private int getByte(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 < this.length) {
            char c2 = this.chars[i];
            if (c2 >= '0' && c2 <= '9') {
                i2 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i2 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                StringBuilder n = a.n("Malformed DN: ");
                n.append(this.dn);
                throw new IllegalStateException(n.toString());
            } else {
                i2 = c2 - '7';
            }
            char c3 = this.chars[i4];
            if (c3 >= '0' && c3 <= '9') {
                i3 = c3 - '0';
            } else if (c3 >= 'a' && c3 <= 'f') {
                i3 = c3 - 'W';
            } else if (c3 < 'A' || c3 > 'F') {
                StringBuilder n2 = a.n("Malformed DN: ");
                n2.append(this.dn);
                throw new IllegalStateException(n2.toString());
            } else {
                i3 = c3 - '7';
            }
            return (i2 << 4) + i3;
        }
        StringBuilder n3 = a.n("Malformed DN: ");
        n3.append(this.dn);
        throw new IllegalStateException(n3.toString());
    }

    private char getEscaped() {
        int i = this.pos + 1;
        this.pos = i;
        if (i != this.length) {
            char c2 = this.chars[i];
            if (!(c2 == ' ' || c2 == '%' || c2 == '\\' || c2 == '_' || c2 == '\"' || c2 == '#')) {
                switch (c2) {
                    case '*':
                    case '+':
                    case ',':
                        break;
                    default:
                        switch (c2) {
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                                break;
                            default:
                                return getUTF8();
                        }
                }
            }
            return this.chars[this.pos];
        }
        StringBuilder n = a.n("Unexpected end of DN: ");
        n.append(this.dn);
        throw new IllegalStateException(n.toString());
    }

    private char getUTF8() {
        int i;
        int i2;
        int i3 = getByte(this.pos);
        this.pos++;
        if (i3 < 128) {
            return (char) i3;
        }
        if (i3 < 192 || i3 > 247) {
            return '?';
        }
        if (i3 <= 223) {
            i2 = i3 & 31;
            i = 1;
        } else if (i3 <= 239) {
            i = 2;
            i2 = i3 & 15;
        } else {
            i = 3;
            i2 = i3 & 7;
        }
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = this.pos + 1;
            this.pos = i5;
            if (i5 == this.length || this.chars[i5] != '\\') {
                return '?';
            }
            int i6 = i5 + 1;
            this.pos = i6;
            int i7 = getByte(i6);
            this.pos++;
            if ((i7 & o00o0000o0.O00000Oo) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (i7 & 63);
        }
        return (char) i2;
    }

    private String hexAV() {
        int i = this.pos;
        if (i + 4 < this.length) {
            this.beg = i;
            while (true) {
                this.pos = i + 1;
                int i2 = this.pos;
                if (i2 == this.length) {
                    break;
                }
                char[] cArr = this.chars;
                if (cArr[i2] == '+' || cArr[i2] == ',' || cArr[i2] == ';') {
                    break;
                } else if (cArr[i2] == ' ') {
                    this.end = i2;
                    do {
                        this.pos = i2 + 1;
                        i2 = this.pos;
                        if (i2 >= this.length) {
                            break;
                        }
                    } while (this.chars[i2] != ' ');
                } else {
                    if (cArr[i2] >= 'A' && cArr[i2] <= 'F') {
                        cArr[i2] = (char) (cArr[i2] + ' ');
                    }
                    i = this.pos;
                }
            }
            this.end = this.pos;
            int i3 = this.end;
            int i4 = this.beg;
            int i5 = i3 - i4;
            if (i5 < 5 || (i5 & 1) == 0) {
                StringBuilder n = a.n("Unexpected end of DN: ");
                n.append(this.dn);
                throw new IllegalStateException(n.toString());
            }
            int i6 = i5 / 2;
            byte[] bArr = new byte[i6];
            int i7 = i4 + 1;
            for (int i8 = 0; i8 < i6; i8++) {
                bArr[i8] = (byte) getByte(i7);
                i7 += 2;
            }
            return new String(this.chars, this.beg, i5);
        }
        StringBuilder n2 = a.n("Unexpected end of DN: ");
        n2.append(this.dn);
        throw new IllegalStateException(n2.toString());
    }

    private String nextAT() {
        char[] cArr;
        while (true) {
            int i = this.pos;
            if (i >= this.length || this.chars[i] != ' ') {
                int i2 = this.pos;
            } else {
                this.pos = i + 1;
            }
        }
        int i22 = this.pos;
        if (i22 == this.length) {
            return null;
        }
        this.beg = i22;
        do {
            this.pos = i22 + 1;
            i22 = this.pos;
            if (i22 >= this.length) {
                break;
            }
            cArr = this.chars;
            if (cArr[i22] == '=') {
                break;
            }
        } while (cArr[i22] == ' ');
        int i3 = this.pos;
        if (i3 < this.length) {
            this.end = i3;
            if (this.chars[i3] == ' ') {
                while (true) {
                    int i4 = this.pos;
                    if (i4 >= this.length) {
                        break;
                    }
                    char[] cArr2 = this.chars;
                    if (cArr2[i4] == '=' || cArr2[i4] != ' ') {
                        break;
                    }
                    this.pos = i4 + 1;
                }
                char[] cArr3 = this.chars;
                int i5 = this.pos;
                if (cArr3[i5] != '=' || i5 == this.length) {
                    StringBuilder n = a.n("Unexpected end of DN: ");
                    n.append(this.dn);
                    throw new IllegalStateException(n.toString());
                }
            }
            int i6 = this.pos;
            do {
                this.pos = i6 + 1;
                i6 = this.pos;
                if (i6 >= this.length || this.chars[i6] != ' ') {
                    int i7 = this.end;
                    int i8 = this.beg;
                }
                this.pos = i6 + 1;
                i6 = this.pos;
                break;
            } while (this.chars[i6] != ' ');
            int i72 = this.end;
            int i82 = this.beg;
            if (i72 - i82 > 4) {
                char[] cArr4 = this.chars;
                if (cArr4[i82 + 3] == '.' && (cArr4[i82] == 'O' || cArr4[i82] == 'o')) {
                    char[] cArr5 = this.chars;
                    int i9 = this.beg;
                    if (cArr5[i9 + 1] == 'I' || cArr5[i9 + 1] == 'i') {
                        char[] cArr6 = this.chars;
                        int i10 = this.beg;
                        if (cArr6[i10 + 2] == 'D' || cArr6[i10 + 2] == 'd') {
                            this.beg += 4;
                        }
                    }
                }
            }
            char[] cArr7 = this.chars;
            int i11 = this.beg;
            return new String(cArr7, i11, this.end - i11);
        }
        StringBuilder n2 = a.n("Unexpected end of DN: ");
        n2.append(this.dn);
        throw new IllegalStateException(n2.toString());
    }

    private String quotedAV() {
        int i = this.pos + 1;
        this.pos = i;
        this.beg = i;
        while (true) {
            this.end = i;
            int i2 = this.pos;
            if (i2 != this.length) {
                char[] cArr = this.chars;
                if (cArr[i2] == '\"') {
                    do {
                        this.pos = i2 + 1;
                        i2 = this.pos;
                        if (i2 >= this.length || this.chars[i2] != ' ') {
                            char[] cArr2 = this.chars;
                            int i3 = this.beg;
                        }
                        this.pos = i2 + 1;
                        i2 = this.pos;
                        break;
                    } while (this.chars[i2] != ' ');
                    char[] cArr22 = this.chars;
                    int i32 = this.beg;
                    return new String(cArr22, i32, this.end - i32);
                }
                if (cArr[i2] == '\\') {
                    cArr[this.end] = getEscaped();
                } else {
                    cArr[this.end] = cArr[i2];
                }
                this.pos++;
                i = this.end + 1;
            } else {
                StringBuilder n = a.n("Unexpected end of DN: ");
                n.append(this.dn);
                throw new IllegalStateException(n.toString());
            }
        }
    }

    public String findMostSpecific(String str) {
        this.pos = 0;
        this.beg = 0;
        this.end = 0;
        this.cur = 0;
        this.chars = this.dn.toCharArray();
        String nextAT = nextAT();
        if (nextAT == null) {
            return null;
        }
        do {
            int i = this.pos;
            if (i == this.length) {
                return null;
            }
            char c2 = this.chars[i];
            String escapedAV = c2 != '\"' ? c2 != '#' ? (c2 == '+' || c2 == ',' || c2 == ';') ? "" : escapedAV() : hexAV() : quotedAV();
            if (str.equalsIgnoreCase(nextAT)) {
                return escapedAV;
            }
            int i2 = this.pos;
            if (i2 >= this.length) {
                return null;
            }
            char[] cArr = this.chars;
            if (cArr[i2] == ',' || cArr[i2] == ';' || cArr[i2] == '+') {
                this.pos++;
                nextAT = nextAT();
            } else {
                StringBuilder n = a.n("Malformed DN: ");
                n.append(this.dn);
                throw new IllegalStateException(n.toString());
            }
        } while (nextAT != null);
        StringBuilder n2 = a.n("Malformed DN: ");
        n2.append(this.dn);
        throw new IllegalStateException(n2.toString());
    }
}
