package androidx.versionedparcelable;

import a.a.a.a.a;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.versionedparcelable.VersionedParcel;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class VersionedParcelStream extends VersionedParcel {
    public static final int TYPE_BOOLEAN = 5;
    public static final int TYPE_BOOLEAN_ARRAY = 6;
    public static final int TYPE_DOUBLE = 7;
    public static final int TYPE_DOUBLE_ARRAY = 8;
    public static final int TYPE_FLOAT = 13;
    public static final int TYPE_FLOAT_ARRAY = 14;
    public static final int TYPE_INT = 9;
    public static final int TYPE_INT_ARRAY = 10;
    public static final int TYPE_LONG = 11;
    public static final int TYPE_LONG_ARRAY = 12;
    public static final int TYPE_NULL = 0;
    public static final int TYPE_STRING = 3;
    public static final int TYPE_STRING_ARRAY = 4;
    public static final int TYPE_SUB_BUNDLE = 1;
    public static final int TYPE_SUB_PERSISTABLE_BUNDLE = 2;
    public static final Charset UTF_16 = Charset.forName("UTF-16");
    public int mCount;
    public DataInputStream mCurrentInput;
    public DataOutputStream mCurrentOutput;
    public FieldBuffer mFieldBuffer;
    public int mFieldId;
    public int mFieldSize;
    public boolean mIgnoreParcelables;
    public final DataInputStream mMasterInput;
    public final DataOutputStream mMasterOutput;

    public static class FieldBuffer {
        public final DataOutputStream mDataStream = new DataOutputStream(this.mOutput);
        public final int mFieldId;
        public final ByteArrayOutputStream mOutput = new ByteArrayOutputStream();
        public final DataOutputStream mTarget;

        public FieldBuffer(int i, DataOutputStream dataOutputStream) {
            this.mFieldId = i;
            this.mTarget = dataOutputStream;
        }

        public void flushField() {
            this.mDataStream.flush();
            int size = this.mOutput.size();
            this.mTarget.writeInt((this.mFieldId << 16) | (size >= 65535 ? 65535 : size));
            if (size >= 65535) {
                this.mTarget.writeInt(size);
            }
            this.mOutput.writeTo(this.mTarget);
        }
    }

    public VersionedParcelStream(InputStream inputStream, OutputStream outputStream) {
        this(inputStream, outputStream, new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    public VersionedParcelStream(InputStream inputStream, OutputStream outputStream, ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.mCount = 0;
        this.mFieldId = -1;
        this.mFieldSize = -1;
        DataOutputStream dataOutputStream = null;
        this.mMasterInput = inputStream != null ? new DataInputStream(new FilterInputStream(inputStream) {
            public int read() {
                VersionedParcelStream versionedParcelStream = VersionedParcelStream.this;
                int i = versionedParcelStream.mFieldSize;
                if (i == -1 || versionedParcelStream.mCount < i) {
                    int read = super.read();
                    VersionedParcelStream.this.mCount++;
                    return read;
                }
                throw new IOException();
            }

            public int read(byte[] bArr, int i, int i2) {
                VersionedParcelStream versionedParcelStream = VersionedParcelStream.this;
                int i3 = versionedParcelStream.mFieldSize;
                if (i3 == -1 || versionedParcelStream.mCount < i3) {
                    int read = super.read(bArr, i, i2);
                    if (read > 0) {
                        VersionedParcelStream.this.mCount += read;
                    }
                    return read;
                }
                throw new IOException();
            }

            public long skip(long j) {
                VersionedParcelStream versionedParcelStream = VersionedParcelStream.this;
                int i = versionedParcelStream.mFieldSize;
                if (i == -1 || versionedParcelStream.mCount < i) {
                    long skip = super.skip(j);
                    if (skip > 0) {
                        VersionedParcelStream.this.mCount += (int) skip;
                    }
                    return skip;
                }
                throw new IOException();
            }
        }) : null;
        dataOutputStream = outputStream != null ? new DataOutputStream(outputStream) : dataOutputStream;
        this.mMasterOutput = dataOutputStream;
        this.mCurrentInput = this.mMasterInput;
        this.mCurrentOutput = dataOutputStream;
    }

    private void readObject(int i, String str, Bundle bundle) {
        switch (i) {
            case 0:
                bundle.putParcelable(str, (Parcelable) null);
                return;
            case 1:
            case 2:
                bundle.putBundle(str, readBundle());
                return;
            case 3:
                bundle.putString(str, readString());
                return;
            case 4:
                bundle.putStringArray(str, (String[]) readArray(new String[0]));
                return;
            case 5:
                bundle.putBoolean(str, readBoolean());
                return;
            case 6:
                bundle.putBooleanArray(str, readBooleanArray());
                return;
            case 7:
                bundle.putDouble(str, readDouble());
                return;
            case 8:
                bundle.putDoubleArray(str, readDoubleArray());
                return;
            case 9:
                bundle.putInt(str, readInt());
                return;
            case 10:
                bundle.putIntArray(str, readIntArray());
                return;
            case 11:
                bundle.putLong(str, readLong());
                return;
            case 12:
                bundle.putLongArray(str, readLongArray());
                return;
            case 13:
                bundle.putFloat(str, readFloat());
                return;
            case 14:
                bundle.putFloatArray(str, readFloatArray());
                return;
            default:
                throw new RuntimeException(a.h("Unknown type ", i));
        }
    }

    private void writeObject(Object obj) {
        int i;
        if (obj == null) {
            i = 0;
        } else if (obj instanceof Bundle) {
            writeInt(1);
            writeBundle((Bundle) obj);
            return;
        } else if (obj instanceof String) {
            writeInt(3);
            writeString((String) obj);
            return;
        } else if (obj instanceof String[]) {
            writeInt(4);
            writeArray((String[]) obj);
            return;
        } else if (obj instanceof Boolean) {
            writeInt(5);
            writeBoolean(((Boolean) obj).booleanValue());
            return;
        } else if (obj instanceof boolean[]) {
            writeInt(6);
            writeBooleanArray((boolean[]) obj);
            return;
        } else if (obj instanceof Double) {
            writeInt(7);
            writeDouble(((Double) obj).doubleValue());
            return;
        } else if (obj instanceof double[]) {
            writeInt(8);
            writeDoubleArray((double[]) obj);
            return;
        } else if (obj instanceof Integer) {
            writeInt(9);
            i = ((Integer) obj).intValue();
        } else if (obj instanceof int[]) {
            writeInt(10);
            writeIntArray((int[]) obj);
            return;
        } else if (obj instanceof Long) {
            writeInt(11);
            writeLong(((Long) obj).longValue());
            return;
        } else if (obj instanceof long[]) {
            writeInt(12);
            writeLongArray((long[]) obj);
            return;
        } else if (obj instanceof Float) {
            writeInt(13);
            writeFloat(((Float) obj).floatValue());
            return;
        } else if (obj instanceof float[]) {
            writeInt(14);
            writeFloatArray((float[]) obj);
            return;
        } else {
            StringBuilder n = a.n("Unsupported type ");
            n.append(obj.getClass());
            throw new IllegalArgumentException(n.toString());
        }
        writeInt(i);
    }

    public void closeField() {
        FieldBuffer fieldBuffer = this.mFieldBuffer;
        if (fieldBuffer != null) {
            try {
                if (fieldBuffer.mOutput.size() != 0) {
                    this.mFieldBuffer.flushField();
                }
                this.mFieldBuffer = null;
            } catch (IOException e2) {
                throw new VersionedParcel.ParcelException(e2);
            }
        }
    }

    public VersionedParcel createSubParcel() {
        return new VersionedParcelStream(this.mCurrentInput, this.mCurrentOutput, this.mReadCache, this.mWriteCache, this.mParcelizerCache);
    }

    public boolean isStream() {
        return true;
    }

    public boolean readBoolean() {
        try {
            return this.mCurrentInput.readBoolean();
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public Bundle readBundle() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (int i = 0; i < readInt; i++) {
            readObject(readInt(), readString(), bundle);
        }
        return bundle;
    }

    public byte[] readByteArray() {
        try {
            int readInt = this.mCurrentInput.readInt();
            if (readInt <= 0) {
                return null;
            }
            byte[] bArr = new byte[readInt];
            this.mCurrentInput.readFully(bArr);
            return bArr;
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public CharSequence readCharSequence() {
        return null;
    }

    public double readDouble() {
        try {
            return this.mCurrentInput.readDouble();
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public boolean readField(int i) {
        while (this.mFieldId != i) {
            try {
                if (String.valueOf(this.mFieldId).compareTo(String.valueOf(i)) > 0) {
                    return false;
                }
                if (this.mCount < this.mFieldSize) {
                    this.mMasterInput.skip((long) (this.mFieldSize - this.mCount));
                }
                this.mFieldSize = -1;
                int readInt = this.mMasterInput.readInt();
                this.mCount = 0;
                int i2 = readInt & 65535;
                if (i2 == 65535) {
                    i2 = this.mMasterInput.readInt();
                }
                this.mFieldId = (readInt >> 16) & 65535;
                this.mFieldSize = i2;
            } catch (IOException unused) {
                return false;
            }
        }
        return true;
    }

    public float readFloat() {
        try {
            return this.mCurrentInput.readFloat();
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public int readInt() {
        try {
            return this.mCurrentInput.readInt();
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public long readLong() {
        try {
            return this.mCurrentInput.readLong();
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public <T extends Parcelable> T readParcelable() {
        return null;
    }

    public String readString() {
        try {
            int readInt = this.mCurrentInput.readInt();
            if (readInt <= 0) {
                return null;
            }
            byte[] bArr = new byte[readInt];
            this.mCurrentInput.readFully(bArr);
            return new String(bArr, UTF_16);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public IBinder readStrongBinder() {
        return null;
    }

    public void setOutputField(int i) {
        closeField();
        FieldBuffer fieldBuffer = new FieldBuffer(i, this.mMasterOutput);
        this.mFieldBuffer = fieldBuffer;
        this.mCurrentOutput = fieldBuffer.mDataStream;
    }

    public void setSerializationFlags(boolean z, boolean z2) {
        if (z) {
            this.mIgnoreParcelables = z2;
            return;
        }
        throw new RuntimeException("Serialization of this object is not allowed");
    }

    public void writeBoolean(boolean z) {
        try {
            this.mCurrentOutput.writeBoolean(z);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public void writeBundle(Bundle bundle) {
        if (bundle != null) {
            try {
                Set<String> keySet = bundle.keySet();
                this.mCurrentOutput.writeInt(keySet.size());
                for (String str : keySet) {
                    writeString(str);
                    writeObject(bundle.get(str));
                }
            } catch (IOException e2) {
                throw new VersionedParcel.ParcelException(e2);
            }
        } else {
            this.mCurrentOutput.writeInt(-1);
        }
    }

    public void writeByteArray(byte[] bArr) {
        if (bArr != null) {
            try {
                this.mCurrentOutput.writeInt(bArr.length);
                this.mCurrentOutput.write(bArr);
            } catch (IOException e2) {
                throw new VersionedParcel.ParcelException(e2);
            }
        } else {
            this.mCurrentOutput.writeInt(-1);
        }
    }

    public void writeByteArray(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            try {
                this.mCurrentOutput.writeInt(i2);
                this.mCurrentOutput.write(bArr, i, i2);
            } catch (IOException e2) {
                throw new VersionedParcel.ParcelException(e2);
            }
        } else {
            this.mCurrentOutput.writeInt(-1);
        }
    }

    public void writeCharSequence(CharSequence charSequence) {
        if (!this.mIgnoreParcelables) {
            throw new RuntimeException("CharSequence cannot be written to an OutputStream");
        }
    }

    public void writeDouble(double d2) {
        try {
            this.mCurrentOutput.writeDouble(d2);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public void writeFloat(float f) {
        try {
            this.mCurrentOutput.writeFloat(f);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public void writeInt(int i) {
        try {
            this.mCurrentOutput.writeInt(i);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public void writeLong(long j) {
        try {
            this.mCurrentOutput.writeLong(j);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public void writeParcelable(Parcelable parcelable) {
        if (!this.mIgnoreParcelables) {
            throw new RuntimeException("Parcelables cannot be written to an OutputStream");
        }
    }

    public void writeString(String str) {
        if (str != null) {
            try {
                byte[] bytes = str.getBytes(UTF_16);
                this.mCurrentOutput.writeInt(bytes.length);
                this.mCurrentOutput.write(bytes);
            } catch (IOException e2) {
                throw new VersionedParcel.ParcelException(e2);
            }
        } else {
            this.mCurrentOutput.writeInt(-1);
        }
    }

    public void writeStrongBinder(IBinder iBinder) {
        if (!this.mIgnoreParcelables) {
            throw new RuntimeException("Binders cannot be written to an OutputStream");
        }
    }

    public void writeStrongInterface(IInterface iInterface) {
        if (!this.mIgnoreParcelables) {
            throw new RuntimeException("Binders cannot be written to an OutputStream");
        }
    }
}
