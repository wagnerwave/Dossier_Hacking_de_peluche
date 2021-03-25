package e.b.a.a.a.u.t;

import com.tuya.smart.common.oOO0O0O0;
import e.b.a.a.a.n;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class o extends h {

    /* renamed from: e  reason: collision with root package name */
    public e.b.a.a.a.o f5333e;
    public String f;
    public byte[] g = null;

    public o(byte b2, byte[] bArr) {
        super((byte) 3);
        p pVar = new p();
        this.f5333e = pVar;
        pVar.setQos(3 & (b2 >> 1));
        if ((b2 & 1) == 1) {
            this.f5333e.setRetained(true);
        }
        if ((b2 & 8) == 8) {
            ((p) this.f5333e).setDuplicate(true);
        }
        a aVar = new a(new ByteArrayInputStream(bArr));
        DataInputStream dataInputStream = new DataInputStream(aVar);
        this.f = h(dataInputStream);
        if (this.f5333e.getQos() > 0) {
            this.f5339b = dataInputStream.readUnsignedShort();
        }
        byte[] bArr2 = new byte[(bArr.length - aVar.f5321b)];
        dataInputStream.readFully(bArr2);
        dataInputStream.close();
        this.f5333e.setPayload(bArr2);
    }

    public o(String str, e.b.a.a.a.o oVar) {
        super((byte) 3);
        this.f = str;
        this.f5333e = oVar;
    }

    public int a() {
        try {
            return o().length;
        } catch (n unused) {
            return 0;
        }
    }

    public byte n() {
        byte qos = (byte) (this.f5333e.getQos() << 1);
        if (this.f5333e.isRetained()) {
            qos = (byte) (qos | 1);
        }
        return (this.f5333e.isDuplicate() || this.f5340c) ? (byte) (qos | 8) : qos;
    }

    public byte[] o() {
        if (this.g == null) {
            this.g = this.f5333e.getPayload();
        }
        return this.g;
    }

    public byte[] p() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            k(dataOutputStream, this.f);
            if (this.f5333e.getQos() > 0) {
                dataOutputStream.writeShort(this.f5339b);
            }
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new n((Throwable) e2);
        }
    }

    public boolean q() {
        return true;
    }

    public void s(int i) {
        this.f5339b = i;
        e.b.a.a.a.o oVar = this.f5333e;
        if (oVar instanceof p) {
            ((p) oVar).a(i);
        }
    }

    public String toString() {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        byte[] payload = this.f5333e.getPayload();
        int min = Math.min(payload.length, 20);
        for (int i = 0; i < min; i++) {
            String hexString = Integer.toHexString(payload[i]);
            if (hexString.length() == 1) {
                hexString = oOO0O0O0.O0000oO0 + hexString;
            }
            stringBuffer.append(hexString);
        }
        try {
            str = new String(payload, 0, min, "UTF-8");
        } catch (Exception unused) {
            str = "?";
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(super.toString());
        stringBuffer2.append(" qos:");
        stringBuffer2.append(this.f5333e.getQos());
        if (this.f5333e.getQos() > 0) {
            stringBuffer2.append(" msgId:");
            stringBuffer2.append(this.f5339b);
        }
        stringBuffer2.append(" retained:");
        stringBuffer2.append(this.f5333e.isRetained());
        stringBuffer2.append(" dup:");
        stringBuffer2.append(this.f5340c);
        stringBuffer2.append(" topic:\"");
        stringBuffer2.append(this.f);
        stringBuffer2.append("\"");
        stringBuffer2.append(" payload:[hex:");
        stringBuffer2.append(stringBuffer);
        stringBuffer2.append(" utf8:\"");
        stringBuffer2.append(str);
        stringBuffer2.append("\"");
        stringBuffer2.append(" length:");
        stringBuffer2.append(payload.length);
        stringBuffer2.append("]");
        return stringBuffer2.toString();
    }
}
