package com.alibaba.fastjson.serializer;

import a.a.a.a.a;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.JSONLexer;
import com.tutk.IOTC.AVFrame;
import com.tuya.spongycastle.math.ec.Tnaf;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;

public final class SerializeWriter extends Writer {
    public static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final char[] DigitOnes = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public static final char[] DigitTens = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
    public static final char[] ascii_chars = {'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
    public static final ThreadLocal<char[]> bufLocal = new ThreadLocal<>();
    public static final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public static final char[] replaceChars = new char[93];
    public static final int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
    public static final byte[] specicalFlags_doubleQuotes;
    public static final byte[] specicalFlags_singleQuotes;
    public char[] buf;
    public int count;
    public int features;
    public final Writer writer;

    static {
        byte[] bArr = new byte[161];
        specicalFlags_doubleQuotes = bArr;
        byte[] bArr2 = new byte[161];
        specicalFlags_singleQuotes = bArr2;
        bArr[0] = 4;
        bArr[1] = 4;
        bArr[2] = 4;
        bArr[3] = 4;
        bArr[4] = 4;
        bArr[5] = 4;
        bArr[6] = 4;
        bArr[7] = 4;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 4;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[34] = 1;
        bArr[92] = 1;
        bArr2[0] = 4;
        bArr2[1] = 4;
        bArr2[2] = 4;
        bArr2[3] = 4;
        bArr2[4] = 4;
        bArr2[5] = 4;
        bArr2[6] = 4;
        bArr2[7] = 4;
        bArr2[8] = 1;
        bArr2[9] = 1;
        bArr2[10] = 1;
        bArr2[11] = 4;
        bArr2[12] = 1;
        bArr2[13] = 1;
        bArr2[92] = 1;
        bArr2[39] = 1;
        for (int i = 14; i <= 31; i++) {
            specicalFlags_doubleQuotes[i] = 4;
            specicalFlags_singleQuotes[i] = 4;
        }
        for (int i2 = 127; i2 < 160; i2++) {
            specicalFlags_doubleQuotes[i2] = 4;
            specicalFlags_singleQuotes[i2] = 4;
        }
        char[] cArr = replaceChars;
        cArr[0] = '0';
        cArr[1] = '1';
        cArr[2] = '2';
        cArr[3] = '3';
        cArr[4] = '4';
        cArr[5] = '5';
        cArr[6] = '6';
        cArr[7] = '7';
        cArr[8] = 'b';
        cArr[9] = 't';
        cArr[10] = 'n';
        cArr[11] = 'v';
        cArr[12] = 'f';
        cArr[13] = 'r';
        cArr[34] = '\"';
        cArr[39] = '\'';
        cArr[47] = '/';
        cArr[92] = '\\';
    }

    public SerializeWriter() {
        this((Writer) null);
    }

    public SerializeWriter(int i) {
        this((Writer) null, i);
    }

    public SerializeWriter(Writer writer2) {
        this.writer = writer2;
        this.features = JSON.DEFAULT_GENERATE_FEATURE;
        this.buf = bufLocal.get();
        ThreadLocal<char[]> threadLocal = bufLocal;
        if (threadLocal != null) {
            threadLocal.set((Object) null);
        }
        if (this.buf == null) {
            this.buf = new char[1024];
        }
    }

    public SerializeWriter(Writer writer2, int i) {
        this.writer = writer2;
        if (i > 0) {
            this.buf = new char[i];
            return;
        }
        throw new IllegalArgumentException(a.h("Negative initial size: ", i));
    }

    public SerializeWriter(Writer writer2, int i, SerializerFeature[] serializerFeatureArr) {
        this.writer = writer2;
        char[] cArr = bufLocal.get();
        this.buf = cArr;
        if (cArr != null) {
            bufLocal.set((Object) null);
        }
        if (this.buf == null) {
            this.buf = new char[1024];
        }
        for (SerializerFeature serializerFeature : serializerFeatureArr) {
            i |= serializerFeature.mask;
        }
        this.features = i;
    }

    public SerializeWriter(SerializerFeature... serializerFeatureArr) {
        this((Writer) null, 0, serializerFeatureArr);
    }

    public static void getChars(long j, int i, char[] cArr) {
        char c2;
        if (j < 0) {
            c2 = '-';
            j = -j;
        } else {
            c2 = 0;
        }
        while (j > 2147483647L) {
            long j2 = j / 100;
            int i2 = (int) (j - (((j2 << 6) + (j2 << 5)) + (j2 << 2)));
            int i3 = i - 1;
            cArr[i3] = DigitOnes[i2];
            i = i3 - 1;
            cArr[i] = DigitTens[i2];
            j = j2;
        }
        int i4 = (int) j;
        while (i4 >= 65536) {
            int i5 = i4 / 100;
            int i6 = i4 - (((i5 << 6) + (i5 << 5)) + (i5 << 2));
            int i7 = i - 1;
            cArr[i7] = DigitOnes[i6];
            i = i7 - 1;
            cArr[i] = DigitTens[i6];
            i4 = i5;
        }
        while (true) {
            int i8 = (52429 * i4) >>> 19;
            i--;
            cArr[i] = digits[i4 - ((i8 << 3) + (i8 << 1))];
            if (i8 == 0) {
                break;
            }
            i4 = i8;
        }
        if (c2 != 0) {
            cArr[i - 1] = c2;
        }
    }

    private void writeKeyWithDoubleQuoteIfHasSpecial(String str) {
        int length = str.length();
        boolean z = true;
        int i = this.count + length + 1;
        if (i > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i);
            } else if (length == 0) {
                write(34);
                write(34);
                write(58);
                return;
            } else {
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = false;
                        break;
                    }
                    char charAt = str.charAt(i2);
                    byte[] bArr = specicalFlags_doubleQuotes;
                    if (charAt < bArr.length && bArr[charAt] != 0) {
                        break;
                    }
                    i2++;
                }
                if (z) {
                    write(34);
                }
                for (int i3 = 0; i3 < length; i3++) {
                    char charAt2 = str.charAt(i3);
                    byte[] bArr2 = specicalFlags_doubleQuotes;
                    if (charAt2 < bArr2.length && bArr2[charAt2] != 0) {
                        write(92);
                        charAt2 = replaceChars[charAt2];
                    }
                    write((int) charAt2);
                }
                if (z) {
                    write(34);
                }
                write(58);
                return;
            }
        }
        if (length == 0) {
            int i4 = this.count;
            if (i4 + 3 > this.buf.length) {
                expandCapacity(i4 + 3);
            }
            char[] cArr = this.buf;
            int i5 = this.count;
            int i6 = i5 + 1;
            this.count = i6;
            cArr[i5] = '\"';
            int i7 = i6 + 1;
            this.count = i7;
            cArr[i6] = '\"';
            this.count = i7 + 1;
            cArr[i7] = ':';
            return;
        }
        int i8 = this.count;
        int i9 = i8 + length;
        str.getChars(0, length, this.buf, i8);
        this.count = i;
        int i10 = i8;
        boolean z2 = false;
        while (i10 < i9) {
            char[] cArr2 = this.buf;
            char c2 = cArr2[i10];
            byte[] bArr3 = specicalFlags_doubleQuotes;
            if (c2 < bArr3.length && bArr3[c2] != 0) {
                if (!z2) {
                    i += 3;
                    if (i > cArr2.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    char[] cArr3 = this.buf;
                    int i11 = i10 + 1;
                    System.arraycopy(cArr3, i11, cArr3, i10 + 3, (i9 - i10) - 1);
                    char[] cArr4 = this.buf;
                    System.arraycopy(cArr4, 0, cArr4, 1, i10);
                    char[] cArr5 = this.buf;
                    cArr5[i8] = '\"';
                    cArr5[i11] = '\\';
                    int i12 = i11 + 1;
                    cArr5[i12] = replaceChars[c2];
                    i9 += 2;
                    cArr5[this.count - 2] = '\"';
                    i10 = i12;
                    z2 = true;
                } else {
                    i++;
                    if (i > cArr2.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    char[] cArr6 = this.buf;
                    int i13 = i10 + 1;
                    System.arraycopy(cArr6, i13, cArr6, i10 + 2, i9 - i10);
                    char[] cArr7 = this.buf;
                    cArr7[i10] = '\\';
                    cArr7[i13] = replaceChars[c2];
                    i9++;
                    i10 = i13;
                }
            }
            i10++;
        }
        this.buf[this.count - 1] = ':';
    }

    private void writeKeyWithSingleQuoteIfHasSpecial(String str) {
        int length = str.length();
        boolean z = true;
        int i = this.count + length + 1;
        if (i > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i);
            } else if (length == 0) {
                write(39);
                write(39);
                write(58);
                return;
            } else {
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = false;
                        break;
                    }
                    char charAt = str.charAt(i2);
                    byte[] bArr = specicalFlags_singleQuotes;
                    if (charAt < bArr.length && bArr[charAt] != 0) {
                        break;
                    }
                    i2++;
                }
                if (z) {
                    write(39);
                }
                for (int i3 = 0; i3 < length; i3++) {
                    char charAt2 = str.charAt(i3);
                    byte[] bArr2 = specicalFlags_singleQuotes;
                    if (charAt2 < bArr2.length && bArr2[charAt2] != 0) {
                        write(92);
                        charAt2 = replaceChars[charAt2];
                    }
                    write((int) charAt2);
                }
                if (z) {
                    write(39);
                }
                write(58);
                return;
            }
        }
        if (length == 0) {
            int i4 = this.count;
            if (i4 + 3 > this.buf.length) {
                expandCapacity(i4 + 3);
            }
            char[] cArr = this.buf;
            int i5 = this.count;
            int i6 = i5 + 1;
            this.count = i6;
            cArr[i5] = '\'';
            int i7 = i6 + 1;
            this.count = i7;
            cArr[i6] = '\'';
            this.count = i7 + 1;
            cArr[i7] = ':';
            return;
        }
        int i8 = this.count;
        int i9 = i8 + length;
        str.getChars(0, length, this.buf, i8);
        this.count = i;
        int i10 = i8;
        boolean z2 = false;
        while (i10 < i9) {
            char[] cArr2 = this.buf;
            char c2 = cArr2[i10];
            byte[] bArr3 = specicalFlags_singleQuotes;
            if (c2 < bArr3.length && bArr3[c2] != 0) {
                if (!z2) {
                    i += 3;
                    if (i > cArr2.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    char[] cArr3 = this.buf;
                    int i11 = i10 + 1;
                    System.arraycopy(cArr3, i11, cArr3, i10 + 3, (i9 - i10) - 1);
                    char[] cArr4 = this.buf;
                    System.arraycopy(cArr4, 0, cArr4, 1, i10);
                    char[] cArr5 = this.buf;
                    cArr5[i8] = '\'';
                    cArr5[i11] = '\\';
                    int i12 = i11 + 1;
                    cArr5[i12] = replaceChars[c2];
                    i9 += 2;
                    cArr5[this.count - 2] = '\'';
                    i10 = i12;
                    z2 = true;
                } else {
                    i++;
                    if (i > cArr2.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    char[] cArr6 = this.buf;
                    int i13 = i10 + 1;
                    System.arraycopy(cArr6, i13, cArr6, i10 + 2, i9 - i10);
                    char[] cArr7 = this.buf;
                    cArr7[i10] = '\\';
                    cArr7[i13] = replaceChars[c2];
                    i9++;
                    i10 = i13;
                }
            }
            i10++;
        }
        this.buf[i - 1] = ':';
    }

    public SerializeWriter append(char c2) {
        write((int) c2);
        return this;
    }

    public SerializeWriter append(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "null" : charSequence.toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    public SerializeWriter append(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            charSequence = "null";
        }
        String charSequence2 = charSequence.subSequence(i, i2).toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    public void close() {
        if (this.writer != null && this.count > 0) {
            flush();
        }
        char[] cArr = this.buf;
        if (cArr.length <= 8192) {
            bufLocal.set(cArr);
        }
        this.buf = null;
    }

    public void config(SerializerFeature serializerFeature, boolean z) {
        int i;
        if (z) {
            i = serializerFeature.mask | this.features;
        } else {
            i = (serializerFeature.mask ^ -1) & this.features;
        }
        this.features = i;
    }

    public void expandCapacity(int i) {
        int length = ((this.buf.length * 3) / 2) + 1;
        if (length >= i) {
            i = length;
        }
        char[] cArr = new char[i];
        System.arraycopy(this.buf, 0, cArr, 0, this.count);
        this.buf = cArr;
    }

    public void flush() {
        Writer writer2 = this.writer;
        if (writer2 != null) {
            try {
                writer2.write(this.buf, 0, this.count);
                this.writer.flush();
                this.count = 0;
            } catch (IOException e2) {
                throw new JSONException(e2.getMessage(), e2);
            }
        }
    }

    public boolean isEnabled(SerializerFeature serializerFeature) {
        return (serializerFeature.mask & this.features) != 0;
    }

    public byte[] toBytes(String str) {
        if (this.writer == null) {
            if (str == null) {
                str = "UTF-8";
            }
            try {
                return new String(this.buf, 0, this.count).getBytes(str);
            } catch (UnsupportedEncodingException e2) {
                throw new JSONException("toBytes error", e2);
            }
        } else {
            throw new UnsupportedOperationException("writer not null");
        }
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }

    public void write(int i) {
        int i2 = 1;
        int i3 = this.count + 1;
        if (i3 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i3);
            } else {
                flush();
                this.buf[this.count] = (char) i;
                this.count = i2;
            }
        }
        i2 = i3;
        this.buf[this.count] = (char) i;
        this.count = i2;
    }

    public void write(String str) {
        if (str == null) {
            writeNull();
        } else {
            write(str, 0, str.length());
        }
    }

    public void write(String str, int i, int i2) {
        int i3;
        int i4 = this.count + i2;
        if (i4 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i4);
            } else {
                while (true) {
                    char[] cArr = this.buf;
                    int length = cArr.length;
                    int i5 = this.count;
                    int i6 = length - i5;
                    i3 = i + i6;
                    str.getChars(i, i3, cArr, i5);
                    this.count = this.buf.length;
                    flush();
                    i2 -= i6;
                    if (i2 <= this.buf.length) {
                        break;
                    }
                    i = i3;
                }
                i4 = i2;
                i = i3;
            }
        }
        str.getChars(i, i2 + i, this.buf, this.count);
        this.count = i4;
    }

    public void write(boolean z) {
        write(z ? "true" : "false");
    }

    public void write(char[] cArr, int i, int i2) {
        int i3;
        if (i < 0 || i > cArr.length || i2 < 0 || (i3 = i + i2) > cArr.length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i2 != 0) {
            int i4 = this.count + i2;
            if (i4 > this.buf.length) {
                if (this.writer == null) {
                    expandCapacity(i4);
                } else {
                    do {
                        char[] cArr2 = this.buf;
                        int length = cArr2.length;
                        int i5 = this.count;
                        int i6 = length - i5;
                        System.arraycopy(cArr, i, cArr2, i5, i6);
                        this.count = this.buf.length;
                        flush();
                        i2 -= i6;
                        i += i6;
                    } while (i2 > this.buf.length);
                    i4 = i2;
                }
            }
            System.arraycopy(cArr, i, this.buf, this.count, i2);
            this.count = i4;
        }
    }

    public void writeByteArray(byte[] bArr) {
        byte[] bArr2 = bArr;
        int length = bArr2.length;
        int i = 0;
        boolean z = (this.features & SerializerFeature.UseSingleQuotes.mask) != 0;
        char c2 = z ? '\'' : '\"';
        if (length == 0) {
            write(z ? "''" : "\"\"");
            return;
        }
        char[] cArr = JSONLexer.CA;
        int i2 = (length / 3) * 3;
        int i3 = length - 1;
        int i4 = this.count;
        int i5 = (((i3 / 3) + 1) << 2) + i4 + 2;
        if (i5 > this.buf.length) {
            if (this.writer != null) {
                write((int) c2);
                int i6 = 0;
                while (i6 < i2) {
                    int i7 = i6 + 1;
                    int i8 = i7 + 1;
                    byte b2 = ((bArr2[i6] & AVFrame.FRM_STATE_UNKOWN) << Tnaf.POW_2_WIDTH) | ((bArr2[i7] & AVFrame.FRM_STATE_UNKOWN) << 8) | (bArr2[i8] & AVFrame.FRM_STATE_UNKOWN);
                    write((int) cArr[(b2 >>> 18) & 63]);
                    write((int) cArr[(b2 >>> 12) & 63]);
                    write((int) cArr[(b2 >>> 6) & 63]);
                    write((int) cArr[b2 & 63]);
                    i6 = i8 + 1;
                }
                int i9 = length - i2;
                if (i9 > 0) {
                    int i10 = (bArr2[i2] & AVFrame.FRM_STATE_UNKOWN) << 10;
                    if (i9 == 2) {
                        i = (bArr2[i3] & AVFrame.FRM_STATE_UNKOWN) << 2;
                    }
                    int i11 = i10 | i;
                    write((int) cArr[i11 >> 12]);
                    write((int) cArr[(i11 >>> 6) & 63]);
                    write((int) i9 == 2 ? cArr[i11 & 63] : '=');
                    write(61);
                }
                write((int) c2);
                return;
            }
            expandCapacity(i5);
        }
        this.count = i5;
        int i12 = i4 + 1;
        this.buf[i4] = c2;
        int i13 = 0;
        while (i13 < i2) {
            int i14 = i13 + 1;
            int i15 = i14 + 1;
            byte b3 = ((bArr2[i13] & AVFrame.FRM_STATE_UNKOWN) << Tnaf.POW_2_WIDTH) | ((bArr2[i14] & AVFrame.FRM_STATE_UNKOWN) << 8);
            int i16 = i15 + 1;
            byte b4 = b3 | (bArr2[i15] & AVFrame.FRM_STATE_UNKOWN);
            char[] cArr2 = this.buf;
            int i17 = i12 + 1;
            cArr2[i12] = cArr[(b4 >>> 18) & 63];
            int i18 = i17 + 1;
            cArr2[i17] = cArr[(b4 >>> 12) & 63];
            int i19 = i18 + 1;
            cArr2[i18] = cArr[(b4 >>> 6) & 63];
            i12 = i19 + 1;
            cArr2[i19] = cArr[b4 & 63];
            i13 = i16;
        }
        int i20 = length - i2;
        if (i20 > 0) {
            int i21 = (bArr2[i2] & AVFrame.FRM_STATE_UNKOWN) << 10;
            if (i20 == 2) {
                i = (bArr2[i3] & AVFrame.FRM_STATE_UNKOWN) << 2;
            }
            int i22 = i21 | i;
            char[] cArr3 = this.buf;
            cArr3[i5 - 5] = cArr[i22 >> 12];
            cArr3[i5 - 4] = cArr[(i22 >>> 6) & 63];
            cArr3[i5 - 3] = i20 == 2 ? cArr[i22 & 63] : '=';
            this.buf[i5 - 2] = '=';
        }
        this.buf[i5 - 1] = c2;
    }

    public void writeFieldName(String str, boolean z) {
        int i = this.features;
        if ((SerializerFeature.UseSingleQuotes.mask & i) != 0) {
            if ((SerializerFeature.QuoteFieldNames.mask & i) != 0) {
                writeStringWithSingleQuote(str);
                write(58);
                return;
            }
            writeKeyWithSingleQuoteIfHasSpecial(str);
        } else if ((i & SerializerFeature.QuoteFieldNames.mask) != 0) {
            writeStringWithDoubleQuote(str, ':', z);
        } else {
            writeKeyWithDoubleQuoteIfHasSpecial(str);
        }
    }

    public void writeInt(int i) {
        int i2;
        if (i == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int i3 = i < 0 ? -i : i;
        int i4 = 0;
        do {
            i2 = sizeTable[i4];
            i4++;
        } while (i3 > i2);
        if (i < 0) {
            i4++;
        }
        int i5 = this.count + i4;
        if (i5 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i5);
            } else {
                char[] cArr = new char[i4];
                getChars((long) i, i4, cArr);
                write(cArr, 0, i4);
                return;
            }
        }
        getChars((long) i, i5, this.buf);
        this.count = i5;
    }

    public void writeLong(long j) {
        int i;
        if (j == Long.MIN_VALUE) {
            write("-9223372036854775808");
            return;
        }
        long j2 = j < 0 ? -j : j;
        int i2 = 1;
        long j3 = 10;
        while (true) {
            i = 19;
            if (i2 >= 19) {
                i2 = 0;
                break;
            } else if (j2 < j3) {
                break;
            } else {
                j3 *= 10;
                i2++;
            }
        }
        if (i2 != 0) {
            i = i2;
        }
        if (j < 0) {
            i++;
        }
        int i3 = this.count + i;
        if (i3 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i3);
            } else {
                char[] cArr = new char[i];
                getChars(j, i, cArr);
                write(cArr, 0, i);
                return;
            }
        }
        getChars(j, i3, this.buf);
        this.count = i3;
    }

    public void writeNull() {
        write("null");
    }

    public void writeString(String str) {
        if ((this.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
            writeStringWithSingleQuote(str);
        } else {
            writeStringWithDoubleQuote(str, 0, true);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008e, code lost:
        if (r14 == -1) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00bc, code lost:
        if ((com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial.mask & r0.features) != 0) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00c4, code lost:
        if (r3 != '\\') goto L_0x00b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00cd, code lost:
        if (r3 != '\"') goto L_0x00b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00e0, code lost:
        if (r14 == -1) goto L_0x0090;
     */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x00e3 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00d2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeStringWithDoubleQuote(java.lang.String r18, char r19, boolean r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            if (r1 != 0) goto L_0x0011
            r17.writeNull()
            if (r2 == 0) goto L_0x0010
            r0.write((int) r2)
        L_0x0010:
            return
        L_0x0011:
            int r3 = r18.length()
            int r4 = r0.count
            int r4 = r4 + r3
            int r4 = r4 + 2
            if (r2 == 0) goto L_0x001e
            int r4 = r4 + 1
        L_0x001e:
            char[] r5 = r0.buf
            int r5 = r5.length
            r6 = 47
            r7 = 34
            r8 = 0
            r9 = 92
            if (r4 <= r5) goto L_0x0068
            java.io.Writer r5 = r0.writer
            if (r5 == 0) goto L_0x0065
            r0.write((int) r7)
        L_0x0031:
            int r3 = r18.length()
            if (r8 >= r3) goto L_0x005c
            char r3 = r1.charAt(r8)
            byte[] r4 = specicalFlags_doubleQuotes
            int r5 = r4.length
            if (r3 >= r5) goto L_0x0044
            byte r4 = r4[r3]
            if (r4 != 0) goto L_0x004f
        L_0x0044:
            if (r3 != r6) goto L_0x0056
            int r4 = r0.features
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial
            int r5 = r5.mask
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0056
        L_0x004f:
            r0.write((int) r9)
            char[] r4 = replaceChars
            char r3 = r4[r3]
        L_0x0056:
            r0.write((int) r3)
            int r8 = r8 + 1
            goto L_0x0031
        L_0x005c:
            r0.write((int) r7)
            if (r2 == 0) goto L_0x0064
            r0.write((int) r2)
        L_0x0064:
            return
        L_0x0065:
            r0.expandCapacity(r4)
        L_0x0068:
            int r5 = r0.count
            int r10 = r5 + 1
            int r11 = r10 + r3
            char[] r12 = r0.buf
            r12[r5] = r7
            r1.getChars(r8, r3, r12, r10)
            r0.count = r4
            if (r20 == 0) goto L_0x022c
            r5 = -1
            r12 = r10
            r13 = 0
            r14 = -1
            r15 = 0
            r16 = -1
        L_0x0080:
            r8 = 8232(0x2028, float:1.1535E-41)
            if (r12 >= r11) goto L_0x00e8
            char[] r3 = r0.buf
            char r3 = r3[r12]
            if (r3 != r8) goto L_0x0099
            int r13 = r13 + 1
            int r4 = r4 + 4
            if (r14 != r5) goto L_0x0095
        L_0x0090:
            r15 = r3
            r14 = r12
            r16 = r14
            goto L_0x00e3
        L_0x0095:
            r15 = r3
            r16 = r12
            goto L_0x00e3
        L_0x0099:
            r8 = 93
            if (r3 < r8) goto L_0x00ad
            r8 = 127(0x7f, float:1.78E-43)
            if (r3 < r8) goto L_0x00e3
            r8 = 160(0xa0, float:2.24E-43)
            if (r3 >= r8) goto L_0x00e3
            if (r14 != r5) goto L_0x00a8
            r14 = r12
        L_0x00a8:
            int r13 = r13 + 1
            int r4 = r4 + 4
            goto L_0x0095
        L_0x00ad:
            r8 = 32
            if (r3 != r8) goto L_0x00b3
        L_0x00b1:
            r6 = 0
            goto L_0x00d0
        L_0x00b3:
            if (r3 != r6) goto L_0x00c0
            int r8 = r0.features
            com.alibaba.fastjson.serializer.SerializerFeature r6 = com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial
            int r6 = r6.mask
            r6 = r6 & r8
            if (r6 == 0) goto L_0x00c0
        L_0x00be:
            r6 = 1
            goto L_0x00d0
        L_0x00c0:
            r6 = 35
            if (r3 <= r6) goto L_0x00c7
            if (r3 == r9) goto L_0x00c7
            goto L_0x00b1
        L_0x00c7:
            r6 = 31
            if (r3 <= r6) goto L_0x00be
            if (r3 == r9) goto L_0x00be
            if (r3 != r7) goto L_0x00b1
            goto L_0x00be
        L_0x00d0:
            if (r6 == 0) goto L_0x00e3
            int r13 = r13 + 1
            byte[] r6 = specicalFlags_doubleQuotes
            int r8 = r6.length
            if (r3 >= r8) goto L_0x00e0
            byte r6 = r6[r3]
            r8 = 4
            if (r6 != r8) goto L_0x00e0
            int r4 = r4 + 4
        L_0x00e0:
            if (r14 != r5) goto L_0x0095
            goto L_0x0090
        L_0x00e3:
            int r12 = r12 + 1
            r6 = 47
            goto L_0x0080
        L_0x00e8:
            if (r13 <= 0) goto L_0x022c
            int r4 = r4 + r13
            char[] r3 = r0.buf
            int r3 = r3.length
            if (r4 <= r3) goto L_0x00f3
            r0.expandCapacity(r4)
        L_0x00f3:
            r0.count = r4
            r3 = 117(0x75, float:1.64E-43)
            r4 = 1
            if (r13 != r4) goto L_0x0183
            if (r15 != r8) goto L_0x0122
            int r1 = r16 + 1
            int r5 = r16 + 6
            int r11 = r11 - r16
            int r11 = r11 - r4
            char[] r6 = r0.buf
            java.lang.System.arraycopy(r6, r1, r6, r5, r11)
            char[] r5 = r0.buf
            r5[r16] = r9
            r5[r1] = r3
            int r1 = r1 + r4
            r3 = 50
            r5[r1] = r3
            int r1 = r1 + r4
            r6 = 48
            r5[r1] = r6
            int r1 = r1 + r4
            r5[r1] = r3
            int r1 = r1 + r4
            r3 = 56
            r5[r1] = r3
            goto L_0x022c
        L_0x0122:
            byte[] r1 = specicalFlags_doubleQuotes
            int r4 = r1.length
            if (r15 >= r4) goto L_0x016a
            byte r1 = r1[r15]
            r4 = 4
            if (r1 != r4) goto L_0x016a
            int r1 = r16 + 1
            int r4 = r16 + 6
            int r11 = r11 - r16
            r5 = 1
            int r11 = r11 - r5
            char[] r5 = r0.buf
            java.lang.System.arraycopy(r5, r1, r5, r4, r11)
            char[] r4 = r0.buf
            r4[r16] = r9
            int r5 = r1 + 1
            r4[r1] = r3
            int r1 = r5 + 1
            char[] r3 = DIGITS
            int r6 = r15 >>> 12
            r6 = r6 & 15
            char r6 = r3[r6]
            r4[r5] = r6
            int r5 = r1 + 1
            int r6 = r15 >>> 8
            r6 = r6 & 15
            char r6 = r3[r6]
            r4[r1] = r6
            int r1 = r5 + 1
            int r6 = r15 >>> 4
            r6 = r6 & 15
            char r6 = r3[r6]
            r4[r5] = r6
            r5 = r15 & 15
            char r3 = r3[r5]
            r4[r1] = r3
            r4 = 1
            goto L_0x022c
        L_0x016a:
            int r1 = r16 + 1
            int r3 = r16 + 2
            int r11 = r11 - r16
            r4 = 1
            int r11 = r11 - r4
            char[] r5 = r0.buf
            java.lang.System.arraycopy(r5, r1, r5, r3, r11)
            char[] r3 = r0.buf
            r3[r16] = r9
            char[] r5 = replaceChars
            char r5 = r5[r15]
            r3[r1] = r5
            goto L_0x022c
        L_0x0183:
            if (r13 <= r4) goto L_0x022c
            int r4 = r14 - r10
        L_0x0187:
            int r5 = r18.length()
            if (r4 >= r5) goto L_0x022c
            char r5 = r1.charAt(r4)
            byte[] r6 = specicalFlags_doubleQuotes
            int r10 = r6.length
            if (r5 >= r10) goto L_0x019e
            byte r6 = r6[r5]
            if (r6 != 0) goto L_0x019b
            goto L_0x019e
        L_0x019b:
            r6 = 47
            goto L_0x01ab
        L_0x019e:
            r6 = 47
            if (r5 != r6) goto L_0x01ee
            int r10 = r0.features
            com.alibaba.fastjson.serializer.SerializerFeature r11 = com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial
            int r11 = r11.mask
            r10 = r10 & r11
            if (r10 == 0) goto L_0x01ee
        L_0x01ab:
            char[] r10 = r0.buf
            int r11 = r14 + 1
            r10[r14] = r9
            byte[] r12 = specicalFlags_doubleQuotes
            byte r12 = r12[r5]
            r13 = 4
            if (r12 != r13) goto L_0x01e5
            int r12 = r11 + 1
            r10[r11] = r3
            int r11 = r12 + 1
            char[] r14 = DIGITS
            int r15 = r5 >>> 12
            r15 = r15 & 15
            char r15 = r14[r15]
            r10[r12] = r15
            int r12 = r11 + 1
            int r15 = r5 >>> 8
            r15 = r15 & 15
            char r15 = r14[r15]
            r10[r11] = r15
            int r11 = r12 + 1
            int r15 = r5 >>> 4
            r15 = r15 & 15
            char r15 = r14[r15]
            r10[r12] = r15
            int r12 = r11 + 1
            r5 = r5 & 15
            char r5 = r14[r5]
            r10[r11] = r5
            goto L_0x0223
        L_0x01e5:
            int r12 = r11 + 1
            char[] r14 = replaceChars
            char r5 = r14[r5]
            r10[r11] = r5
            goto L_0x0223
        L_0x01ee:
            r13 = 4
            char[] r10 = r0.buf
            int r11 = r14 + 1
            if (r5 != r8) goto L_0x0225
            r10[r14] = r9
            int r12 = r11 + 1
            r10[r11] = r3
            int r11 = r12 + 1
            char[] r14 = DIGITS
            int r15 = r5 >>> 12
            r15 = r15 & 15
            char r15 = r14[r15]
            r10[r12] = r15
            int r12 = r11 + 1
            int r15 = r5 >>> 8
            r15 = r15 & 15
            char r15 = r14[r15]
            r10[r11] = r15
            int r11 = r12 + 1
            int r15 = r5 >>> 4
            r15 = r15 & 15
            char r15 = r14[r15]
            r10[r12] = r15
            int r12 = r11 + 1
            r5 = r5 & 15
            char r5 = r14[r5]
            r10[r11] = r5
        L_0x0223:
            r14 = r12
            goto L_0x0228
        L_0x0225:
            r10[r14] = r5
            r14 = r11
        L_0x0228:
            int r4 = r4 + 1
            goto L_0x0187
        L_0x022c:
            if (r2 == 0) goto L_0x023b
            char[] r1 = r0.buf
            int r3 = r0.count
            int r4 = r3 + -2
            r1[r4] = r7
            r4 = 1
            int r3 = r3 - r4
            r1[r3] = r2
            goto L_0x0243
        L_0x023b:
            r4 = 1
            char[] r1 = r0.buf
            int r2 = r0.count
            int r2 = r2 - r4
            r1[r2] = r7
        L_0x0243:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.writeStringWithDoubleQuote(java.lang.String, char, boolean):void");
    }

    public void writeStringWithSingleQuote(String str) {
        int i = 0;
        if (str == null) {
            int i2 = this.count + 4;
            if (i2 > this.buf.length) {
                expandCapacity(i2);
            }
            "null".getChars(0, 4, this.buf, this.count);
            this.count = i2;
            return;
        }
        int length = str.length();
        int i3 = this.count + length + 2;
        if (i3 > this.buf.length) {
            if (this.writer != null) {
                write(39);
                while (i < str.length()) {
                    char charAt = str.charAt(i);
                    if (charAt <= 13 || charAt == '\\' || charAt == '\'' || (charAt == '/' && (this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                        write(92);
                        charAt = replaceChars[charAt];
                    }
                    write((int) charAt);
                    i++;
                }
                write(39);
                return;
            }
            expandCapacity(i3);
        }
        int i4 = this.count;
        int i5 = i4 + 1;
        int i6 = i5 + length;
        char[] cArr = this.buf;
        cArr[i4] = '\'';
        str.getChars(0, length, cArr, i5);
        this.count = i3;
        int i7 = -1;
        char c2 = 0;
        for (int i8 = i5; i8 < i6; i8++) {
            char c3 = this.buf[i8];
            if (c3 <= 13 || c3 == '\\' || c3 == '\'' || (c3 == '/' && (this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                i++;
                i7 = i8;
                c2 = c3;
            }
        }
        int i9 = i3 + i;
        if (i9 > this.buf.length) {
            expandCapacity(i9);
        }
        this.count = i9;
        if (i == 1) {
            char[] cArr2 = this.buf;
            int i10 = i7 + 1;
            System.arraycopy(cArr2, i10, cArr2, i7 + 2, (i6 - i7) - 1);
            char[] cArr3 = this.buf;
            cArr3[i7] = '\\';
            cArr3[i10] = replaceChars[c2];
        } else if (i > 1) {
            char[] cArr4 = this.buf;
            int i11 = i7 + 1;
            System.arraycopy(cArr4, i11, cArr4, i7 + 2, (i6 - i7) - 1);
            char[] cArr5 = this.buf;
            cArr5[i7] = '\\';
            cArr5[i11] = replaceChars[c2];
            int i12 = i6 + 1;
            for (int i13 = i11 - 2; i13 >= i5; i13--) {
                char c4 = this.buf[i13];
                if (c4 <= 13 || c4 == '\\' || c4 == '\'' || (c4 == '/' && (this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                    char[] cArr6 = this.buf;
                    int i14 = i13 + 1;
                    System.arraycopy(cArr6, i14, cArr6, i13 + 2, (i12 - i13) - 1);
                    char[] cArr7 = this.buf;
                    cArr7[i13] = '\\';
                    cArr7[i14] = replaceChars[c4];
                    i12++;
                }
            }
        }
        this.buf[this.count - 1] = '\'';
    }

    public void writeTo(OutputStream outputStream, String str) {
        writeTo(outputStream, Charset.forName(str));
    }

    public void writeTo(OutputStream outputStream, Charset charset) {
        if (this.writer == null) {
            outputStream.write(new String(this.buf, 0, this.count).getBytes(charset.name()));
            return;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public void writeTo(Writer writer2) {
        if (this.writer == null) {
            writer2.write(this.buf, 0, this.count);
            return;
        }
        throw new UnsupportedOperationException("writer not null");
    }
}
