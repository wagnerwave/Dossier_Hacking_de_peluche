package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;

public final class BooleanCodec implements ObjectSerializer, ObjectDeserializer {
    public static final BooleanCodec instance = new BooleanCodec();

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
        if (r3 == 1) goto L_0x000e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r3, java.lang.reflect.Type r4, java.lang.Object r5) {
        /*
            r2 = this;
            com.alibaba.fastjson.parser.JSONLexer r4 = r3.lexer
            int r5 = r4.token()
            r0 = 16
            r1 = 6
            if (r5 != r1) goto L_0x0011
            r4.nextToken(r0)
        L_0x000e:
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            goto L_0x0034
        L_0x0011:
            r1 = 7
            if (r5 != r1) goto L_0x001a
            r4.nextToken(r0)
        L_0x0017:
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            goto L_0x0034
        L_0x001a:
            r1 = 2
            if (r5 != r1) goto L_0x0028
            int r3 = r4.intValue()
            r4.nextToken(r0)
            r4 = 1
            if (r3 != r4) goto L_0x0017
            goto L_0x000e
        L_0x0028:
            java.lang.Object r3 = r3.parse()
            if (r3 != 0) goto L_0x0030
            r3 = 0
            return r3
        L_0x0030:
            java.lang.Boolean r3 = com.alibaba.fastjson.util.TypeUtils.castToBoolean(r3)
        L_0x0034:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.BooleanCodec.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object):java.lang.Object");
    }

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) {
        SerializeWriter serializeWriter = jSONSerializer.out;
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            if ((serializeWriter.features & SerializerFeature.WriteNullBooleanAsFalse.mask) != 0) {
                serializeWriter.write("false");
            } else {
                serializeWriter.writeNull();
            }
        } else if (bool.booleanValue()) {
            serializeWriter.write("true");
        } else {
            serializeWriter.write("false");
        }
    }
}
