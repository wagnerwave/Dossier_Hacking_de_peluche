package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;

public class EnumSerializer implements ObjectSerializer {
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) {
        SerializeWriter serializeWriter = jSONSerializer.out;
        Enum enumR = (Enum) obj;
        if ((serializeWriter.features & SerializerFeature.WriteEnumUsingToString.mask) != 0) {
            String str = enumR.toString();
            if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
                serializeWriter.writeStringWithSingleQuote(str);
            } else {
                serializeWriter.writeStringWithDoubleQuote(str, 0, false);
            }
        } else {
            serializeWriter.writeInt(enumR.ordinal());
        }
    }
}
