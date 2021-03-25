package com.tuya.spongycastle.asn1;

import androidx.drawerlayout.widget.DrawerLayout;

public class DLTaggedObject extends ASN1TaggedObject {
    public static final byte[] ZERO_BYTES = new byte[0];

    public DLTaggedObject(boolean z, int i, ASN1Encodable aSN1Encodable) {
        super(z, i, aSN1Encodable);
    }

    public void encode(ASN1OutputStream aSN1OutputStream) {
        boolean z = this.empty;
        int i = DrawerLayout.PEEK_DELAY;
        if (!z) {
            ASN1Primitive dLObject = this.obj.toASN1Primitive().toDLObject();
            if (this.explicit) {
                aSN1OutputStream.writeTag(DrawerLayout.PEEK_DELAY, this.tagNo);
                aSN1OutputStream.writeLength(dLObject.encodedLength());
                aSN1OutputStream.writeObject(dLObject);
                return;
            }
            if (!dLObject.isConstructed()) {
                i = 128;
            }
            aSN1OutputStream.writeTag(i, this.tagNo);
            aSN1OutputStream.writeImplicitObject(dLObject);
            return;
        }
        aSN1OutputStream.writeEncoded(DrawerLayout.PEEK_DELAY, this.tagNo, ZERO_BYTES);
    }

    public int encodedLength() {
        if (this.empty) {
            return StreamUtil.calculateTagLength(this.tagNo) + 1;
        }
        int encodedLength = this.obj.toASN1Primitive().toDLObject().encodedLength();
        if (this.explicit) {
            return StreamUtil.calculateBodyLength(encodedLength) + StreamUtil.calculateTagLength(this.tagNo) + encodedLength;
        }
        return StreamUtil.calculateTagLength(this.tagNo) + (encodedLength - 1);
    }

    public boolean isConstructed() {
        if (this.empty || this.explicit) {
            return true;
        }
        return this.obj.toASN1Primitive().toDLObject().isConstructed();
    }
}
