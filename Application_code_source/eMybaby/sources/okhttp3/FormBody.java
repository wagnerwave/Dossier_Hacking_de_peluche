package okhttp3;

import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;

public final class FormBody extends RequestBody {
    public static final MediaType CONTENT_TYPE = MediaType.parse("application/x-www-form-urlencoded");
    public final List<String> encodedNames;
    public final List<String> encodedValues;

    public static final class Builder {
        public final List<String> names = new ArrayList();
        public final List<String> values = new ArrayList();

        public Builder add(String str, String str2) {
            this.names.add(HttpUrl.canonicalize(str, HttpUrl.FORM_ENCODE_SET, false, false, true, true));
            this.values.add(HttpUrl.canonicalize(str2, HttpUrl.FORM_ENCODE_SET, false, false, true, true));
            return this;
        }

        public Builder addEncoded(String str, String str2) {
            this.names.add(HttpUrl.canonicalize(str, HttpUrl.FORM_ENCODE_SET, true, false, true, true));
            this.values.add(HttpUrl.canonicalize(str2, HttpUrl.FORM_ENCODE_SET, true, false, true, true));
            return this;
        }

        public FormBody build() {
            return new FormBody(this.names, this.values);
        }
    }

    public FormBody(List<String> list, List<String> list2) {
        this.encodedNames = Util.immutableList(list);
        this.encodedValues = Util.immutableList(list2);
    }

    private long writeOrCountBytes(BufferedSink bufferedSink, boolean z) {
        Buffer buffer = z ? new Buffer() : bufferedSink.buffer();
        int size = this.encodedNames.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                buffer.writeByte(38);
            }
            buffer.writeUtf8(this.encodedNames.get(i));
            buffer.writeByte(61);
            buffer.writeUtf8(this.encodedValues.get(i));
        }
        if (!z) {
            return 0;
        }
        long size2 = buffer.size();
        buffer.clear();
        return size2;
    }

    public long contentLength() {
        return writeOrCountBytes((BufferedSink) null, true);
    }

    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    public String encodedName(int i) {
        return this.encodedNames.get(i);
    }

    public String encodedValue(int i) {
        return this.encodedValues.get(i);
    }

    public String name(int i) {
        return HttpUrl.percentDecode(encodedName(i), true);
    }

    public int size() {
        return this.encodedNames.size();
    }

    public String value(int i) {
        return HttpUrl.percentDecode(encodedValue(i), true);
    }

    public void writeTo(BufferedSink bufferedSink) {
        writeOrCountBytes(bufferedSink, false);
    }
}
