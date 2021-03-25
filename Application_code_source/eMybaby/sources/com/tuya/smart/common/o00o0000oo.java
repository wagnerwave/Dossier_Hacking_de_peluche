package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.ParcelUuid;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.tutk.IOTC.AVFrame;
import com.tuya.sdk.security.EncryptionManager;
import com.tuya.sdk.sigmesh.bean.ProvisioningCapabilities;
import com.tuya.sdk.sigmesh.bean.ScanRecord;
import com.tuya.sdk.sigmesh.bean.SecureNetworkBeacon;
import com.tuya.sdk.sigmesh.bean.UnprovisionedBeacon;
import com.tuya.sdk.sigmesh.bean.UnprovisionedMeshNode;
import com.tuya.smart.android.blemesh.bean.MeshBeacon;
import com.tuya.spongycastle.math.ec.Tnaf;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class o00o0000oo {
    public static final int O000000o = 0;
    public static final int O00000Oo = 1;
    public static final int O00000o = 3;
    public static final int O00000o0 = 2;
    public static final String O00000oO = "SigMeshUtil";
    public static final char[] O00000oo = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final int O0000O0o = 8;
    public static final int O0000OOo = 1;
    public static final int O0000Oo = 1;
    public static final int O0000Oo0 = 8;
    public static final int O0000OoO = 8;
    public static final int O0000Ooo = 9;
    public static final int O0000o0 = 1;
    public static final int O0000o00 = 0;

    public static int O000000o(byte b2, byte b3) {
        return o00oo00ooo.O000000o(b2) + (o00oo00ooo.O000000o(b3) << 8);
    }

    public static int O000000o(byte[] bArr, int i) {
        if (i == 1) {
            return bArr[0];
        }
        if (i == 2) {
            return O000000o(bArr[1], bArr[0]);
        }
        if (i != 3) {
            return -1;
        }
        return ((byte) ((bArr[2] << Tnaf.POW_2_WIDTH) & 255)) | ((byte) (bArr[0] & AVFrame.FRM_STATE_UNKOWN)) | ((byte) ((bArr[1] << 8) & 255));
    }

    public static UnprovisionedMeshNode O000000o(UUID uuid, String str, String str2) {
        byte[] O000000o2 = O000000o(str2);
        if (O000000o2 != null || O000000o2.length == 16) {
            byte[] array = ByteBuffer.allocate(1).put((byte) 0).array();
            byte[] array2 = ByteBuffer.allocate(4).putInt(0).array();
            UnprovisionedMeshNode unprovisionedMeshNode = new UnprovisionedMeshNode(uuid);
            unprovisionedMeshNode.setNodeName(str);
            unprovisionedMeshNode.setNetworkKey(O000000o2);
            unprovisionedMeshNode.setKeyIndex(0);
            unprovisionedMeshNode.setFlags(array);
            unprovisionedMeshNode.setIvIndex(array2);
            unprovisionedMeshNode.setTtl(5);
            return unprovisionedMeshNode;
        }
        o00oo0oo00.O00000Oo(O00000oO, "Network key is error");
        return null;
    }

    public static MeshBeacon O000000o(byte[] bArr) {
        byte[] O00000Oo2;
        if (bArr == null || (O00000Oo2 = O00000Oo(bArr)) == null) {
            return null;
        }
        byte b2 = O00000Oo2[0];
        if (b2 == 0) {
            return new UnprovisionedBeacon(O00000Oo2);
        }
        if (b2 == 1) {
            return new SecureNetworkBeacon(O00000Oo2);
        }
        return null;
    }

    public static String O000000o(SparseArray<byte[]> sparseArray) {
        if (sparseArray == null) {
            return "null";
        }
        if (sparseArray.size() == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (int i = 0; i < sparseArray.size(); i++) {
            sb.append(sparseArray.keyAt(i));
            sb.append(o0ooo00oo.O0000Oo0);
            sb.append(Arrays.toString(sparseArray.valueAt(i)));
        }
        sb.append('}');
        return sb.toString();
    }

    public static <T> String O000000o(Map<T, byte[]> map) {
        if (map == null) {
            return "null";
        }
        if (map.isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        Iterator<Map.Entry<T, byte[]>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Object key = it.next().getKey();
            sb.append(key);
            sb.append(o0ooo00oo.O0000Oo0);
            sb.append(Arrays.toString(map.get(key)));
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public static String O000000o(byte[] bArr, int i, int i2, boolean z) {
        if (bArr == null || bArr.length <= i || i2 <= 0) {
            return "";
        }
        int min = Math.min(i2, bArr.length - i);
        char[] cArr = new char[(min * 2)];
        for (int i3 = 0; i3 < min; i3++) {
            byte b2 = bArr[i + i3] & AVFrame.FRM_STATE_UNKOWN;
            int i4 = i3 * 2;
            char[] cArr2 = O00000oo;
            cArr[i4] = cArr2[b2 >>> 4];
            cArr[i4 + 1] = cArr2[b2 & 15];
        }
        if (!z) {
            return new String(cArr);
        }
        StringBuilder n = a.n("0x");
        n.append(new String(cArr));
        return n.toString();
    }

    public static String O000000o(byte[] bArr, boolean z) {
        return bArr == null ? "" : O000000o(bArr, 0, bArr.length, z);
    }

    public static boolean O000000o(String str, byte[] bArr) {
        byte[] O0000oo0 = O0000oo0(bArr);
        byte[] O00000Oo2 = o00o00000o.O00000Oo(O000000o(str));
        if (O0000oo0 == null) {
            return false;
        }
        String upperCase = O000000o(O0000oo0, false).toUpperCase();
        String O000000o2 = O000000o(O00000Oo2, false);
        o00oo0oo00.O000000o(O00000oO, "networkIdMatches advertiseNetString:" + upperCase + "   networkIdString:" + O000000o2);
        return O000000o2.equals(upperCase);
    }

    public static boolean O000000o(String str, byte[] bArr, byte[] bArr2) {
        byte[] O0000ooO;
        byte[] O0000oo = O0000oo(bArr);
        if (O0000oo == null || (O0000ooO = O0000ooO(bArr)) == null) {
            return false;
        }
        return Arrays.equals(O0000oo, o00o00000o.O00000o0(o00o00000o.O00000o(O000000o(str)), O0000ooO, bArr2));
    }

    public static byte[] O000000o() {
        byte[] bArr = new byte[16];
        Random random = new Random();
        for (int i = 0; i < 16; i++) {
            bArr[i] = (byte) random.nextInt(255);
        }
        return bArr;
    }

    public static byte[] O000000o(int i) {
        if ((i & 12582912) == 12582912) {
            return new byte[]{(byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
        } else if ((16744448 & i) == 32768) {
            return new byte[]{(byte) ((i >> 8) & 255), (byte) (i & 255)};
        } else {
            return new byte[]{(byte) i};
        }
    }

    public static byte[] O000000o(int i, int i2) {
        if (i2 == 65535) {
            return null;
        }
        return new byte[]{(byte) ((i & 63) | o00o0000o0.O00000Oo), (byte) (i2 & 255), (byte) ((i2 >> 8) & 255)};
    }

    public static byte[] O000000o(ProvisioningCapabilities provisioningCapabilities) {
        return new byte[]{provisioningCapabilities.getNumberOfElements(), (byte) ((provisioningCapabilities.getSupportedAlgorithm() >> 8) & 255), (byte) (provisioningCapabilities.getSupportedAlgorithm() & 255), provisioningCapabilities.getPublicKeyType(), provisioningCapabilities.getStaticOOBType(), provisioningCapabilities.getOutputOOBSize(), (byte) ((provisioningCapabilities.getOutputOOBAction() >> 8) & 255), (byte) (provisioningCapabilities.getOutputOOBAction() & 255), provisioningCapabilities.getInputOOBSize(), (byte) ((provisioningCapabilities.getInputOOBAction() >> 8) & 255), (byte) (provisioningCapabilities.getInputOOBAction() & 255)};
    }

    public static byte[] O000000o(ScanRecord scanRecord, UUID uuid) {
        if (scanRecord != null) {
            return scanRecord.getServiceData(new ParcelUuid(uuid));
        }
        return null;
    }

    public static byte[] O000000o(Integer num) {
        return ByteBuffer.allocate(2).order(ByteOrder.BIG_ENDIAN).putShort((short) (num.intValue() & 4095)).array();
    }

    public static byte[] O000000o(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) (Character.digit(str.charAt(i + 1), 16) + (Character.digit(str.charAt(i), 16) << 4));
        }
        return bArr;
    }

    public static byte[] O000000o(List<byte[]> list) {
        if (list == null) {
            return null;
        }
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            i += list.get(i2).length;
        }
        byte[] bArr = new byte[i];
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            System.arraycopy(list.get(i4), 0, bArr, i3, list.get(i4).length);
            i3 += list.get(i4).length;
        }
        return bArr;
    }

    public static byte[] O000000o(byte[] bArr, int i, int i2) {
        if (bArr == null || i2 < 0) {
            return null;
        }
        if (i > bArr.length) {
            i = bArr.length;
        }
        int length = bArr.length - i;
        if (length <= i2) {
            i2 = length;
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static byte[] O000000o(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static byte[] O000000o(byte[] bArr, byte[] bArr2, ProvisioningCapabilities provisioningCapabilities, int i) {
        byte[] bArr3 = {(byte) i};
        byte[] O000000o2 = O000000o(provisioningCapabilities);
        byte[] O00000Oo2 = O00000Oo(provisioningCapabilities);
        ByteBuffer allocate = ByteBuffer.allocate(1 + O000000o2.length + O00000Oo2.length + bArr.length + bArr2.length);
        allocate.put(bArr3);
        allocate.put(O000000o2);
        allocate.put(O00000Oo2);
        allocate.put(bArr);
        allocate.put(bArr2);
        return allocate.array();
    }

    public static byte[] O000000o(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, EncryptionManager.O0000ooO);
            Cipher instance = Cipher.getInstance("AES/CBC/NoPadding");
            instance.init(1, secretKeySpec, ivParameterSpec);
            return instance.doFinal(bArr3);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean O00000Oo(Integer num) {
        boolean z = num != null && num.intValue() == (num.intValue() & ViewCompat.MEASURED_SIZE_MASK);
        if (num.intValue() == 16777215) {
            return false;
        }
        return z;
    }

    public static byte[] O00000Oo(int i) {
        if (!O00000Oo(Integer.valueOf(i))) {
            return null;
        }
        return new byte[]{(byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static byte[] O00000Oo(SparseArray<byte[]> sparseArray) {
        ByteBuffer allocate = ByteBuffer.allocate(O00000o0(sparseArray));
        allocate.order(ByteOrder.BIG_ENDIAN);
        for (int i = 0; i < sparseArray.size(); i++) {
            allocate.put(sparseArray.get(i));
        }
        return allocate.array();
    }

    public static byte[] O00000Oo(ProvisioningCapabilities provisioningCapabilities) {
        byte[] bArr = new byte[5];
        bArr[0] = o000oooo00.O00000Oo(provisioningCapabilities.getSupportedAlgorithm());
        bArr[1] = 0;
        short O00000o02 = (short) ((byte) o000ooo0oo.O00000o0(provisioningCapabilities.getOutputOOBAction()));
        if (O00000o02 == 0) {
            bArr[2] = 0;
            bArr[3] = 0;
            bArr[4] = 0;
        } else {
            bArr[2] = 2;
            bArr[3] = (byte) o000ooo0oo.O00000Oo(O00000o02);
            bArr[4] = provisioningCapabilities.getOutputOOBSize();
        }
        return bArr;
    }

    public static byte[] O00000Oo(String str) {
        o00oo0oo00.O000000o(O00000oO, "getSecretKey4() called");
        return TextUtils.isEmpty(str) ? new byte[0] : O0000o(O000000o(str));
    }

    public static byte[] O00000Oo(String str, byte[] bArr) {
        return (TextUtils.isEmpty(str) || bArr == null) ? new byte[0] : O0000o(O000000o(O000000o(str), bArr));
    }

    public static byte[] O00000Oo(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Advertisement data cannot be null");
        } else if (!O00000o0(bArr)) {
            return null;
        } else {
            int i = 0;
            while (i < bArr.length) {
                int O000000o2 = o00oo00ooo.O000000o(bArr[i]);
                if (o00oo00ooo.O000000o(bArr[i + 1]) == 43) {
                    byte[] bArr2 = new byte[O000000o2];
                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                    wrap.position(i + 2);
                    wrap.get(bArr2, 0, O000000o2);
                    return bArr2;
                }
                i = i + O000000o2 + 1;
            }
            return null;
        }
    }

    public static byte[] O00000Oo(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, EncryptionManager.O0000ooO);
            Cipher instance = Cipher.getInstance("AES/CBC/NoPadding");
            instance.init(2, secretKeySpec, ivParameterSpec);
            return instance.doFinal(bArr3);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[][] O00000Oo(List<byte[]> list) {
        if (list == null) {
            return new byte[0][];
        }
        byte[][] bArr = new byte[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            bArr[i] = list.get(i);
        }
        return bArr;
    }

    public static ProvisioningCapabilities O00000o(byte[] bArr) {
        ProvisioningCapabilities provisioningCapabilities = new ProvisioningCapabilities();
        provisioningCapabilities.setRawCapabilities(bArr);
        if (bArr[2] != 0) {
            byte b2 = bArr[2];
            o00oo0oo00.O000000o(O00000oO, "Number of elements: " + b2);
            provisioningCapabilities.setNumberOfElements(b2);
            short s = (short) (((bArr[3] & AVFrame.FRM_STATE_UNKOWN) << 8) | (bArr[4] & AVFrame.FRM_STATE_UNKOWN));
            StringBuilder n = a.n("Algorithm: ");
            n.append(o000oo0oo0.O000000o(s));
            o00oo0oo00.O000000o(O00000oO, n.toString());
            provisioningCapabilities.setSupportedAlgorithm(s);
            byte b3 = bArr[5];
            StringBuilder n2 = a.n("Public key type: ");
            n2.append(o000oooo0o.O000000o(b3));
            o00oo0oo00.O000000o(O00000oO, n2.toString());
            provisioningCapabilities.setPublicKeyType(b3);
            byte b4 = bArr[6];
            StringBuilder n3 = a.n("Static OOB type: ");
            n3.append(o000ooooo0.O000000o(b4));
            o00oo0oo00.O000000o(O00000oO, n3.toString());
            provisioningCapabilities.setStaticOOBType(b4);
            byte b5 = bArr[7];
            o00oo0oo00.O000000o(O00000oO, "Output OOB size: " + b5);
            provisioningCapabilities.setOutputOOBSize(b5);
            short s2 = (short) (((bArr[8] & AVFrame.FRM_STATE_UNKOWN) << 8) | (bArr[9] & AVFrame.FRM_STATE_UNKOWN));
            o000ooo0oo.O00000Oo((int) s2);
            provisioningCapabilities.setOutputOOBAction(s2);
            byte b6 = bArr[10];
            o00oo0oo00.O000000o(O00000oO, "Input OOB size: " + b6);
            provisioningCapabilities.setInputOOBSize(b6);
            short s3 = (short) ((bArr[12] & AVFrame.FRM_STATE_UNKOWN) | ((bArr[11] & AVFrame.FRM_STATE_UNKOWN) << 8));
            o000ooo0o0.O000000o((int) s3);
            provisioningCapabilities.setInputOOBAction(s3);
            return provisioningCapabilities;
        }
        throw new IllegalArgumentException("Number of elements cannot be zero");
    }

    public static byte[] O00000o(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static int O00000o0(SparseArray<byte[]> sparseArray) {
        int i = 0;
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            i += sparseArray.get(i2).length;
        }
        return i;
    }

    public static String O00000o0(int i) {
        StringBuilder sb;
        String str;
        StringBuilder sb2;
        int i2 = i >> 6;
        int i3 = i & 63;
        if (i2 != 0) {
            if (i2 == 1) {
                sb2 = new StringBuilder();
            } else if (i2 == 2) {
                sb2 = new StringBuilder();
                i3 *= 10;
            } else if (i2 != 3) {
                return "Unknown";
            } else {
                sb = new StringBuilder();
                sb.append(i3 * 10);
                str = " minutes";
            }
            sb2.append(i3);
            sb2.append(" seconds");
            return sb2.toString();
        }
        sb = new StringBuilder();
        sb.append(i3 * 100);
        str = " milliseconds";
        sb2.append(str);
        return sb2.toString();
    }

    public static boolean O00000o0(byte[] bArr) {
        int O000000o2;
        if (bArr != null) {
            int i = 0;
            while (i < bArr.length && (O000000o2 = o00oo00ooo.O000000o(bArr[i])) != 0) {
                if (o00oo00ooo.O000000o(bArr[i + 1]) == 43) {
                    return true;
                }
                i = i + O000000o2 + 1;
            }
            return false;
        }
        throw new IllegalArgumentException("Advertisement data cannot be null");
    }

    public static byte[] O00000o0(String str) {
        return str.getBytes(Charset.forName("UTF-8"));
    }

    public static UUID O00000oO(byte[] bArr) {
        if (bArr == null || bArr.length < 18) {
            throw new IllegalArgumentException("Service data cannot be null");
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        return new UUID(wrap.getLong(), wrap.getLong());
    }

    public static byte[] O00000oO(int i) {
        return new byte[]{(byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static int O00000oo(byte[] bArr) {
        return bArr[1] | (bArr[0] & 15);
    }

    public static int O0000O0o(byte[] bArr) {
        return (bArr[2] & AVFrame.FRM_STATE_UNKOWN) | ((bArr[1] & 31) << 8);
    }

    public static byte[] O0000OOo(byte[] bArr) {
        return ByteBuffer.allocate(2).put(bArr, 6, 2).array();
    }

    public static int O0000Oo(byte[] bArr) {
        return (bArr[5] & AVFrame.FRM_STATE_UNKOWN) | ((bArr[3] & AVFrame.FRM_STATE_UNKOWN) << Tnaf.POW_2_WIDTH) | ((bArr[4] & AVFrame.FRM_STATE_UNKOWN) << 8);
    }

    public static byte[] O0000Oo0(byte[] bArr) {
        return ByteBuffer.allocate(2).put(bArr, 8, 2).array();
    }

    public static int O0000OoO(byte[] bArr) {
        return (bArr[2] & AVFrame.FRM_STATE_UNKOWN) | ((bArr[0] & AVFrame.FRM_STATE_UNKOWN) << Tnaf.POW_2_WIDTH) | ((bArr[1] & AVFrame.FRM_STATE_UNKOWN) << 8);
    }

    public static boolean O0000Ooo(byte[] bArr) {
        if (bArr == null || bArr.length != 2) {
            return false;
        }
        return (bArr[0] >= 192 && bArr[0] <= 255 && bArr[0] != 255) || bArr[1] < 0 || bArr[1] > 251;
    }

    public static byte[] O0000o(byte[] bArr) {
        try {
            return O0000ooo(bArr);
        } catch (Exception e2) {
            e2.printStackTrace();
            return O000000o();
        }
    }

    public static boolean O0000o0(byte[] bArr) {
        return bArr != null && bArr[0] == 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r3 = (r3[1] & com.tutk.IOTC.AVFrame.FRM_STATE_UNKOWN) | ((r3[0] & com.tutk.IOTC.AVFrame.FRM_STATE_UNKOWN) << 8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean O0000o00(byte[] r3) {
        /*
            r0 = 0
            if (r3 == 0) goto L_0x001b
            int r1 = r3.length
            r2 = 2
            if (r1 == r2) goto L_0x0008
            goto L_0x001b
        L_0x0008:
            byte r1 = r3[r0]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << 8
            r2 = 1
            byte r3 = r3[r2]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r3 = r3 | r1
            if (r3 <= 0) goto L_0x001b
            r1 = 32767(0x7fff, float:4.5916E-41)
            if (r3 > r1) goto L_0x001b
            r0 = 1
        L_0x001b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.o00o0000oo.O0000o00(byte[]):boolean");
    }

    public static boolean O0000o0O(@Nullable byte[] bArr) {
        return bArr != null && bArr[0] == 1;
    }

    public static int O0000o0o(byte[] bArr) {
        int i = 0;
        for (byte b2 : bArr) {
            i += b2 & AVFrame.FRM_STATE_UNKOWN;
        }
        return i;
    }

    public static int O0000oO(byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            return 0;
        }
        return (bArr[3] & AVFrame.FRM_STATE_UNKOWN) | ((bArr[0] & AVFrame.FRM_STATE_UNKOWN) << 24) | ((bArr[1] & AVFrame.FRM_STATE_UNKOWN) << Tnaf.POW_2_WIDTH) | ((bArr[2] & AVFrame.FRM_STATE_UNKOWN) << 8);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] O0000oO0(byte[] r5) {
        /*
            r0 = 0
            r1 = 65535(0xffff, float:9.1834E-41)
            r2 = 0
        L_0x0005:
            int r3 = r5.length
            if (r2 >= r3) goto L_0x0022
            byte r3 = r5[r2]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r1 = r1 ^ r3
            r3 = 0
        L_0x000e:
            r4 = 8
            if (r3 >= r4) goto L_0x001f
            r4 = r1 & 1
            int r1 = r1 >> 1
            if (r4 == 0) goto L_0x001c
            r4 = 40961(0xa001, float:5.7399E-41)
            r1 = r1 ^ r4
        L_0x001c:
            int r3 = r3 + 1
            goto L_0x000e
        L_0x001f:
            int r2 = r2 + 1
            goto L_0x0005
        L_0x0022:
            byte[] r5 = O00000oO((int) r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.o00o0000oo.O0000oO0(byte[]):byte[]");
    }

    public static int O0000oOO(byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            return 0;
        }
        return (bArr[1] & AVFrame.FRM_STATE_UNKOWN) | ((bArr[0] & AVFrame.FRM_STATE_UNKOWN) << 8);
    }

    public static String O0000oOo(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new String(bArr, Charset.forName("UTF-8"));
    }

    public static byte[] O0000oo(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        ByteBuffer order = ByteBuffer.allocate(8).order(ByteOrder.BIG_ENDIAN);
        order.put(bArr, 1, 8);
        return order.array();
    }

    public static byte[] O0000oo0(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        ByteBuffer order = ByteBuffer.allocate(8).order(ByteOrder.BIG_ENDIAN);
        order.put(bArr, 1, 8);
        return order.array();
    }

    public static byte[] O0000ooO(byte[] bArr) {
        if (bArr == null || bArr.length <= 8) {
            return null;
        }
        ByteBuffer order = ByteBuffer.allocate(8).order(ByteOrder.BIG_ENDIAN);
        order.put(bArr, 9, 8);
        return order.array();
    }

    public static byte[] O0000ooo(byte[] bArr) {
        try {
            return MessageDigest.getInstance("MD5").digest(bArr);
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException(e2);
        }
    }
}
