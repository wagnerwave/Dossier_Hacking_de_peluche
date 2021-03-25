package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;

public class StringCodec implements ObjectSerializer, ObjectDeserializer {
    public static StringCodec instance = new StringCodec();

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return defaultJSONParser.parseString();
    }

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) {
        String str = (String) obj;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (str == null) {
            serializeWriter.writeNull();
        } else {
            serializeWriter.writeString(str);
        }
    }
}
