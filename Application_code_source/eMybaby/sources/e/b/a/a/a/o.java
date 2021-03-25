package e.b.a.a.a;

public class o {
    public boolean dup = false;
    public int messageId;
    public boolean mutable = true;
    public byte[] payload;
    public int qos = 1;
    public boolean retained = false;

    public o() {
        setPayload(new byte[0]);
    }

    public o(byte[] bArr) {
        setPayload(bArr);
    }

    public static void validateQos(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException();
        }
    }

    public void checkMutable() {
        if (!this.mutable) {
            throw new IllegalStateException();
        }
    }

    public void clearPayload() {
        checkMutable();
        this.payload = new byte[0];
    }

    public int getId() {
        return this.messageId;
    }

    public byte[] getPayload() {
        return this.payload;
    }

    public int getQos() {
        return this.qos;
    }

    public boolean isDuplicate() {
        return this.dup;
    }

    public boolean isRetained() {
        return this.retained;
    }

    public void setDuplicate(boolean z) {
        this.dup = z;
    }

    public void setId(int i) {
        this.messageId = i;
    }

    public void setMutable(boolean z) {
        this.mutable = z;
    }

    public void setPayload(byte[] bArr) {
        checkMutable();
        if (bArr != null) {
            this.payload = bArr;
            return;
        }
        throw null;
    }

    public void setQos(int i) {
        checkMutable();
        validateQos(i);
        this.qos = i;
    }

    public void setRetained(boolean z) {
        checkMutable();
        this.retained = z;
    }

    public String toString() {
        return new String(this.payload);
    }
}
