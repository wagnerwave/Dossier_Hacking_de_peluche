package com.tuya.smart.common;

import a.e.a.a.r.b;
import com.tutk.IOTC.AVFrame;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class o00oo00ooo {
    public static final int O000000o = 32769;
    public static final int O00000Oo = 33023;
    public static final int O00000o = 255;
    public static final int O00000o0 = 1;
    public static final String O00000oO = "123456789aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ+-*/<>/?!@#$%^&;'[]{}|,.";
    public static final O000000o O00000oo = new O000000o();
    public static int O0000O0o = 32769;
    public static int O0000OOo = 1;
    public static SecureRandom O0000Oo0;

    public static class O000000o implements Comparator<Integer> {
        public O000000o() {
        }

        /* renamed from: O000000o */
        public int compare(Integer num, Integer num2) {
            if (num.intValue() > num2.intValue()) {
                return 1;
            }
            return num.intValue() < num2.intValue() ? -1 : 0;
        }
    }

    public static int O000000o(byte b2) {
        return b2 & AVFrame.FRM_STATE_UNKOWN;
    }

    public static synchronized int O000000o(List<Integer> list) {
        int intValue;
        synchronized (o00oo00ooo.class) {
            if (list != null) {
                if (!list.isEmpty()) {
                    int size = list.size();
                    if (size > 254) {
                        return -1;
                    }
                    Collections.sort(list, O00000oo);
                    Integer num = list.get(size - 1);
                    if (num.intValue() + 1 > 33023) {
                        num = null;
                        int i = 0;
                        while (i < size) {
                            if (num == null) {
                                num = list.get(i);
                                i = 1;
                            } else {
                                Integer num2 = list.get(i);
                                if (num.intValue() + 1 == num2.intValue() || num.intValue() == 33023) {
                                    i++;
                                    if (i < size) {
                                        num = num2;
                                    } else if (num2.intValue() >= 33023) {
                                        O0000O0o = 32769;
                                        O0000O0o = 1 + 32769;
                                        return 32769;
                                    } else {
                                        intValue = num2.intValue();
                                        int i2 = intValue + 1;
                                        return i2;
                                    }
                                }
                            }
                        }
                        return -1;
                    }
                    intValue = num.intValue();
                    int i22 = intValue + 1;
                    return i22;
                }
            }
            O0000O0o = 32769;
            if (32769 + 1 > 33023) {
                return -1;
            }
            O0000O0o = 1 + 32769;
            return 32769;
        }
    }

    public static byte[] O000000o(int i) {
        byte[] bArr = new byte[i];
        synchronized (o00oo00ooo.class) {
            if (O0000Oo0 == null) {
                O0000Oo0 = new SecureRandom();
            }
        }
        O0000Oo0.nextBytes(bArr);
        return bArr;
    }

    public static byte[] O000000o(String str) {
        return O000000o(O00000o0(str));
    }

    public static byte[] O000000o(String str, int i) {
        return O000000o(O00000o0(str), i);
    }

    public static byte[] O000000o(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        bArr2[0] = bArr[0];
        bArr2[1] = bArr[1];
        bArr2[2] = bArr[2];
        return bArr2;
    }

    public static byte[] O000000o(byte[] bArr, int i) {
        byte[] bArr2 = new byte[8];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        bArr2[4] = 1;
        bArr2[5] = (byte) (i & 255);
        bArr2[6] = (byte) ((i >> 8) & 255);
        bArr2[7] = (byte) ((i >> 16) & 255);
        return bArr2;
    }

    public static byte[] O000000o(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        try {
            byte[] bArr6 = new byte[16];
            System.arraycopy(bArr4, 0, bArr6, 0, bArr4.length);
            byte[] bArr7 = new byte[16];
            for (int i = 0; i < 16; i++) {
                bArr7[i] = (byte) (bArr[i] ^ bArr2[i]);
            }
            byte[] l = b.l(bArr6, bArr7);
            byte[] bArr8 = new byte[16];
            System.arraycopy(bArr4, 0, bArr8, 0, bArr4.length);
            System.arraycopy(l, 8, bArr8, 8, 8);
            o00oo0o00o.O000000o(bArr8, 8, 15);
            if (!o00oo0o00o.O000000o(bArr8, bArr5)) {
                return null;
            }
            System.arraycopy(bArr3, 0, bArr6, 0, bArr3.length);
            System.arraycopy(bArr4, 0, bArr6, 8, bArr4.length);
            byte[] l2 = b.l(bArr7, bArr6);
            o00oo0o00o.O000000o(l2, 0, l2.length - 1);
            return l2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static synchronized int O00000Oo(List<Integer> list) {
        int intValue;
        synchronized (o00oo00ooo.class) {
            if (list != null) {
                if (!list.isEmpty()) {
                    int size = list.size();
                    if (size > 254) {
                        return -1;
                    }
                    Collections.sort(list, O00000oo);
                    Integer num = list.get(size - 1);
                    if (num.intValue() + 1 > 255) {
                        num = null;
                        int i = 0;
                        while (i < size) {
                            if (num == null) {
                                num = list.get(i);
                                i = 1;
                            } else {
                                Integer num2 = list.get(i);
                                if (num.intValue() + 1 == num2.intValue() || num.intValue() == 255) {
                                    i++;
                                    if (i < size) {
                                        num = num2;
                                    } else if (num2.intValue() >= 255) {
                                        O0000OOo = 1;
                                        O0000OOo = 1 + 1;
                                        return 1;
                                    } else {
                                        intValue = num2.intValue();
                                        int i2 = intValue + 1;
                                        return i2;
                                    }
                                }
                            }
                        }
                        return -1;
                    }
                    intValue = num.intValue();
                    int i22 = intValue + 1;
                    return i22;
                }
            }
            O0000OOo = 1;
            if (1 + 1 > 255) {
                return -1;
            }
            O0000OOo = 1 + 1;
            return 1;
        }
    }

    public static String O00000Oo(String str) {
        return str.replace(":", "").toLowerCase();
    }

    public static byte[] O00000Oo(int i) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            double random = Math.random();
            double d2 = (double) 84;
            Double.isNaN(d2);
            bArr[i2] = (byte) O00000oO.charAt((int) Math.round(random * d2));
        }
        return bArr;
    }

    public static byte[] O00000o0(String str) {
        o00oo0oo00.O000000o("getMacBytes", str);
        String[] split = str.split(":");
        int length = split.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) (Integer.parseInt(split[i], 16) & 255);
        }
        o00oo0o00o.O000000o(bArr, 0, length - 1);
        o00oo0oo00.O000000o("getMacBytes", o00oo0o00o.O00000Oo(bArr, ":"));
        return bArr;
    }
}
