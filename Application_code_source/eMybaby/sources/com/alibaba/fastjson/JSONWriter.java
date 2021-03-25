package com.alibaba.fastjson;

import a.a.a.a.a;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.Closeable;
import java.io.Flushable;
import java.io.Writer;

public class JSONWriter implements Closeable, Flushable {
    public JSONStreamContext context;
    public JSONSerializer serializer;
    public SerializeWriter writer;

    public JSONWriter(Writer writer2) {
        SerializeWriter serializeWriter = new SerializeWriter(writer2);
        this.writer = serializeWriter;
        this.serializer = new JSONSerializer(serializeWriter);
    }

    private void afterWriter() {
        int i;
        JSONStreamContext jSONStreamContext = this.context;
        if (jSONStreamContext != null) {
            switch (jSONStreamContext.state) {
                case 1001:
                case 1003:
                    i = 1002;
                    break;
                case 1002:
                    i = 1003;
                    break;
                case 1004:
                    i = 1005;
                    break;
                default:
                    i = -1;
                    break;
            }
            if (i != -1) {
                this.context.state = i;
            }
        }
    }

    private void beforeWrite() {
        JSONStreamContext jSONStreamContext = this.context;
        if (jSONStreamContext != null) {
            int i = jSONStreamContext.state;
            if (i == 1002) {
                this.writer.write(58);
            } else if (i == 1003 || i == 1005) {
                this.writer.write(44);
            }
        }
    }

    private void beginStructure() {
        int i;
        SerializeWriter serializeWriter;
        int i2 = this.context.state;
        switch (i2) {
            case 1001:
            case 1004:
                return;
            case 1002:
                serializeWriter = this.writer;
                i = 58;
                break;
            case 1005:
                serializeWriter = this.writer;
                i = 44;
                break;
            default:
                throw new JSONException(a.h("illegal state : ", i2));
        }
        serializeWriter.write(i);
    }

    private void endStructure() {
        JSONStreamContext jSONStreamContext = this.context.parent;
        this.context = jSONStreamContext;
        if (jSONStreamContext != null) {
            int i = jSONStreamContext.state;
            int i2 = 1002;
            if (i != 1001) {
                i2 = i != 1002 ? i != 1004 ? -1 : 1005 : 1003;
            }
            if (i2 != -1) {
                this.context.state = i2;
            }
        }
    }

    public void close() {
        this.writer.close();
    }

    public void config(SerializerFeature serializerFeature, boolean z) {
        this.writer.config(serializerFeature, z);
    }

    public void endArray() {
        this.writer.write(93);
        endStructure();
    }

    public void endObject() {
        this.writer.write(125);
        endStructure();
    }

    public void flush() {
        this.writer.flush();
    }

    public void startArray() {
        if (this.context != null) {
            beginStructure();
        }
        this.context = new JSONStreamContext(this.context, 1004);
        this.writer.write(91);
    }

    public void startObject() {
        if (this.context != null) {
            beginStructure();
        }
        this.context = new JSONStreamContext(this.context, 1001);
        this.writer.write(123);
    }

    public void writeKey(String str) {
        writeObject(str);
    }

    public void writeObject(Object obj) {
        beforeWrite();
        this.serializer.write(obj);
        afterWriter();
    }

    public void writeObject(String str) {
        beforeWrite();
        this.serializer.write(str);
        afterWriter();
    }

    public void writeValue(Object obj) {
        writeObject(obj);
    }
}
