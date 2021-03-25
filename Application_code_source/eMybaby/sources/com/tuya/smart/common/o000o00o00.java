package com.tuya.smart.common;

import a.a.a.a.a;
import com.tuya.sdk.sigmesh.bean.ProvisioningCapabilities;
import com.tuya.sdk.sigmesh.bean.UnprovisionedMeshNode;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.android.blemesh.bean.SigMeshSearchDeviceBean;
import com.tuya.smart.common.o00o0o0o0o;
import com.tuya.spongycastle.jce.ECNamedCurveTable;
import com.tuya.spongycastle.jce.interfaces.ECPrivateKey;
import com.tuya.spongycastle.jce.interfaces.ECPublicKey;
import com.tuya.spongycastle.jce.provider.BouncyCastleProvider;
import com.tuya.spongycastle.jce.spec.ECNamedCurveParameterSpec;
import com.tuya.spongycastle.jce.spec.ECPublicKeySpec;
import com.tuya.spongycastle.util.BigIntegers;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.KeyAgreement;

public class o000o00o00 {
    public static final String O00000Oo = "ProvisioningPublicKeyState";
    public SearchDeviceBean O000000o;
    public byte[] O00000o;
    public UnprovisionedMeshNode O00000o0;
    public ECPrivateKey O00000oO;
    public o0000oo000 O00000oo;
    public ooooo00o0 O0000O0o = new ooooo00o0() {
        public void O000000o(byte[] bArr) {
            if (bArr[1] == 3) {
                o000o00o00.this.O000000o(bArr);
                if (o000o00o00.this.O00000oo != null) {
                    o000o00o00.this.O00000oo.O000000o(o000o00o00.this.O000000o);
                }
            }
        }
    };

    public o000o00o00(o0000oo000 o0000oo000) {
        this.O00000oo = o0000oo000;
    }

    /* access modifiers changed from: private */
    public void O000000o(final SearchDeviceBean searchDeviceBean) {
        this.O00000o0 = ((SigMeshSearchDeviceBean) this.O000000o).getUnprovisionedMeshNode();
        ooo0o0000 ooo0o0000 = new ooo0o0000(searchDeviceBean.getMacAdress(), new o00o0o0o0o.O000000o() {
            public void O000000o(String str, String str2) {
                o000o00o00.this.O00000oo.O000000o(searchDeviceBean, O00OOo.O0000ooO, "send public key fail");
            }

            public void O00000Oo() {
            }
        });
        ooo0o0000.O000000o(this.O00000o0);
        this.O00000oO = ooo0o0000.O000000o();
    }

    /* access modifiers changed from: private */
    public void O000000o(byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length - 2);
        allocate.put(bArr, 2, allocate.limit());
        byte[] array = allocate.array();
        this.O00000o = array;
        this.O00000o0.setProvisioneePublicKeyXY(array);
        byte[] bArr2 = new byte[32];
        System.arraycopy(array, 0, bArr2, 0, 32);
        byte[] bArr3 = new byte[32];
        System.arraycopy(array, 32, bArr3, 0, 32);
        a.z(O000000o(bArr2, ByteOrder.LITTLE_ENDIAN), false, a.n("Provsionee X: "), O00000Oo);
        byte[] O000000o2 = O000000o(bArr3, ByteOrder.LITTLE_ENDIAN);
        StringBuilder n = a.n("Provsionee Y: ");
        n.append(o00o0000oo.O000000o(O000000o2, false));
        o00oo0oo00.O00000o(O00000Oo, n.toString());
        BigInteger fromUnsignedByteArray = BigIntegers.fromUnsignedByteArray(array, 0, 32);
        BigInteger fromUnsignedByteArray2 = BigIntegers.fromUnsignedByteArray(array, 32, 32);
        ECNamedCurveParameterSpec parameterSpec = ECNamedCurveTable.getParameterSpec("secp256r1");
        ECPublicKeySpec eCPublicKeySpec = new ECPublicKeySpec(parameterSpec.getCurve().validatePoint(fromUnsignedByteArray, fromUnsignedByteArray2), parameterSpec);
        try {
            KeyAgreement instance = KeyAgreement.getInstance("ECDH", BouncyCastleProvider.PROVIDER_NAME);
            instance.init(this.O00000oO);
            instance.doPhase((ECPublicKey) KeyFactory.getInstance("ECDH", BouncyCastleProvider.PROVIDER_NAME).generatePublic(eCPublicKeySpec), true);
            byte[] generateSecret = instance.generateSecret();
            this.O00000o0.setSharedECDHSecret(generateSecret);
            o00oo0oo00.O00000o(O00000Oo, "ECDH Secret: " + o00o0000oo.O000000o(generateSecret, false));
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        } catch (NoSuchProviderException e3) {
            e3.printStackTrace();
        } catch (InvalidKeySpecException e4) {
            e4.printStackTrace();
        } catch (InvalidKeyException e5) {
            e5.printStackTrace();
        }
    }

    private byte[] O000000o(byte[] bArr, ByteOrder byteOrder) {
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length);
        allocate.order(byteOrder);
        allocate.put(bArr);
        return allocate.array();
    }

    public ooooo00o0 O000000o() {
        return this.O0000O0o;
    }

    public void O000000o(final SearchDeviceBean searchDeviceBean, ProvisioningCapabilities provisioningCapabilities) {
        this.O000000o = searchDeviceBean;
        this.O00000oO = null;
        new ooo0o00oo(searchDeviceBean.getMacAdress(), new o00o0o0o0o.O000000o() {
            public void O000000o(String str, String str2) {
                if (o000o00o00.this.O00000oo != null) {
                    o0000oo000 O000000o2 = o000o00o00.this.O00000oo;
                    SearchDeviceBean searchDeviceBean = searchDeviceBean;
                    O000000o2.O000000o(searchDeviceBean, O00OOo.O0000oo0, "provisioning start  fail " + str);
                }
            }

            public void O00000Oo() {
                if (o000o00o00.this.O00000oo != null) {
                    o000o00o00.this.O00000oo.O000000o(searchDeviceBean, O00OOo.O0000oOo);
                }
                o000o00o00.this.O000000o(searchDeviceBean);
            }
        }).O000000o(provisioningCapabilities);
    }
}
