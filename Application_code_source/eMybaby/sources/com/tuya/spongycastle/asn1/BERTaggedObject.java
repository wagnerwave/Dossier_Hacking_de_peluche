package com.tuya.spongycastle.asn1;

import a.a.a.a.a;
import androidx.drawerlayout.widget.DrawerLayout;
import java.util.Enumeration;

public class BERTaggedObject extends ASN1TaggedObject {
    public BERTaggedObject(int i) {
        super(false, i, new BERSequence());
    }

    public BERTaggedObject(int i, ASN1Encodable aSN1Encodable) {
        super(true, i, aSN1Encodable);
    }

    public BERTaggedObject(boolean z, int i, ASN1Encodable aSN1Encodable) {
        super(z, i, aSN1Encodable);
    }

    public void encode(ASN1OutputStream aSN1OutputStream) {
        Enumeration enumeration;
        aSN1OutputStream.writeTag(DrawerLayout.PEEK_DELAY, this.tagNo);
        aSN1OutputStream.write(128);
        if (!this.empty) {
            if (!this.explicit) {
                ASN1Encodable aSN1Encodable = this.obj;
                if (aSN1Encodable instanceof ASN1OctetString) {
                    enumeration = aSN1Encodable instanceof BEROctetString ? ((BEROctetString) aSN1Encodable).getObjects() : new BEROctetString(((ASN1OctetString) aSN1Encodable).getOctets()).getObjects();
                } else if (aSN1Encodable instanceof ASN1Sequence) {
                    enumeration = ((ASN1Sequence) aSN1Encodable).getObjects();
                } else if (aSN1Encodable instanceof ASN1Set) {
                    enumeration = ((ASN1Set) aSN1Encodable).getObjects();
                } else {
                    StringBuilder n = a.n("not implemented: ");
                    n.append(this.obj.getClass().getName());
                    throw new ASN1Exception(n.toString());
                }
                while (enumeration.hasMoreElements()) {
                    aSN1OutputStream.writeObject((ASN1Encodable) enumeration.nextElement());
                }
            } else {
                aSN1OutputStream.writeObject(this.obj);
            }
        }
        aSN1OutputStream.write(0);
        aSN1OutputStream.write(0);
    }

    public int encodedLength() {
        if (this.empty) {
            return StreamUtil.calculateTagLength(this.tagNo) + 1;
        }
        int encodedLength = this.obj.toASN1Primitive().encodedLength();
        if (this.explicit) {
            return StreamUtil.calculateBodyLength(encodedLength) + StreamUtil.calculateTagLength(this.tagNo) + encodedLength;
        }
        return StreamUtil.calculateTagLength(this.tagNo) + (encodedLength - 1);
    }

    public boolean isConstructed() {
        if (this.empty || this.explicit) {
            return true;
        }
        return this.obj.toASN1Primitive().toDERObject().isConstructed();
    }
}
