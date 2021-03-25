package com.tuya.smart.common;

import com.tuya.sdk.sigmesh.bean.UnprovisionedMeshNode;
import com.tuya.sdk.tuyamesh.bean.CommandBean;
import com.tuya.smart.common.o00o0o0o0o;
import com.tuya.spongycastle.jce.ECNamedCurveTable;
import com.tuya.spongycastle.jce.interfaces.ECPrivateKey;
import com.tuya.spongycastle.jce.interfaces.ECPublicKey;
import com.tuya.spongycastle.jce.provider.BouncyCastleProvider;
import com.tuya.spongycastle.jce.spec.ECNamedCurveParameterSpec;
import com.tuya.spongycastle.math.ec.ECPoint;
import com.tuya.spongycastle.util.BigIntegers;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class ooo0o0000 extends ooo0oo000 {
    public static final String O000000o = "ProvisioningPublicKeyAction";
    public String O00000Oo;
    public ECPrivateKey O00000o;
    public o00o0o0o0o.O000000o O00000o0;
    public UnprovisionedMeshNode O00000oO;

    public ooo0o0000(String str, o00o0o0o0o.O000000o o000000o) {
        this.O00000Oo = str;
        this.O00000o0 = o000000o;
    }

    private void O00000Oo() {
        try {
            ECNamedCurveParameterSpec parameterSpec = ECNamedCurveTable.getParameterSpec("secp256r1");
            KeyPairGenerator instance = KeyPairGenerator.getInstance("ECDH", BouncyCastleProvider.PROVIDER_NAME);
            instance.initialize(parameterSpec);
            KeyPair generateKeyPair = instance.generateKeyPair();
            this.O00000o = (ECPrivateKey) generateKeyPair.getPrivate();
            ECPoint q = ((ECPublicKey) generateKeyPair.getPublic()).getQ();
            BigInteger bigInteger = q.getXCoord().toBigInteger();
            BigInteger bigInteger2 = q.getYCoord().toBigInteger();
            byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(32, bigInteger);
            byte[] asUnsignedByteArray2 = BigIntegers.asUnsignedByteArray(32, bigInteger2);
            o00oo0oo00.O000000o(O000000o, "X: length: " + asUnsignedByteArray.length + " " + o00o0000oo.O000000o(asUnsignedByteArray, false));
            o00oo0oo00.O000000o(O000000o, "Y: length: " + asUnsignedByteArray2.length + " " + o00o0000oo.O000000o(asUnsignedByteArray2, false));
            byte[] bArr = new byte[64];
            System.arraycopy(asUnsignedByteArray, 0, bArr, 0, asUnsignedByteArray.length);
            System.arraycopy(asUnsignedByteArray2, 0, bArr, asUnsignedByteArray2.length, asUnsignedByteArray2.length);
            this.O00000oO.setProvisionerPublicKeyXY(bArr);
            o00oo0oo00.O000000o(O000000o, "XY: " + o00o0000oo.O000000o(bArr, true));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private byte[] O00000o0() {
        byte[] provisionerPublicKeyXY = this.O00000oO.getProvisionerPublicKeyXY();
        ByteBuffer allocate = ByteBuffer.allocate(provisionerPublicKeyXY.length + 2);
        allocate.put((byte) 3);
        allocate.put((byte) 3);
        allocate.put(provisionerPublicKeyXY);
        return allocate.array();
    }

    public ECPrivateKey O000000o() {
        return this.O00000o;
    }

    public void O000000o(UnprovisionedMeshNode unprovisionedMeshNode) {
        this.O00000oO = unprovisionedMeshNode;
        O00000Oo();
        byte[] O00000o02 = O00000o0();
        o00oo0oo00.O000000o(O000000o, o00oo0o00o.O00000Oo(O00000o02, ":"));
        O000000o(O000000o(this.O00000Oo, O00000o02, CommandBean.CommandType.WRITE_NO_RESPONSE), oo0o0oooo.O000000o().O00000Oo(), this.O00000o0);
    }
}
