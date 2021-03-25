package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.math.BigDecimal;

public final class IntegerCodec implements ObjectSerializer, ObjectDeserializer {
    public static IntegerCodec instance = new IntegerCodec();

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        T t;
        Class<Long> cls = Long.class;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        if (i == 8) {
            jSONLexer.nextToken(16);
            return null;
        } else if (i == 2) {
            if (type == Long.TYPE || type == cls) {
                t = Long.valueOf(jSONLexer.longValue());
            } else {
                try {
                    t = Integer.valueOf(jSONLexer.intValue());
                } catch (NumberFormatException e2) {
                    throw new JSONException("int value overflow, field : " + obj, e2);
                }
            }
            jSONLexer.nextToken(16);
            return t;
        } else if (i == 3) {
            BigDecimal decimalValue = jSONLexer.decimalValue();
            jSONLexer.nextToken(16);
            return (type == Long.TYPE || type == cls) ? Long.valueOf(decimalValue.longValue()) : Integer.valueOf(decimalValue.intValue());
        } else {
            Object parse = defaultJSONParser.parse();
            try {
                if (type != Long.TYPE) {
                    if (type != cls) {
                        return TypeUtils.castToInt(parse);
                    }
                }
                return TypeUtils.castToLong(parse);
            } catch (Exception e3) {
                throw new JSONException("cast error, field : " + obj + ", value " + parse, e3);
            }
        }
    }

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) {
        int i;
        Class<Long> cls = Long.class;
        SerializeWriter serializeWriter = jSONSerializer.out;
        Number number = (Number) obj;
        if (number != null) {
            if (obj instanceof Long) {
                serializeWriter.writeLong(number.longValue());
            } else {
                serializeWriter.writeInt(number.intValue());
            }
            if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) {
                Class<?> cls2 = number.getClass();
                if (cls2 == Byte.class) {
                    i = 66;
                } else if (cls2 == Short.class) {
                    i = 83;
                } else if (cls2 == cls) {
                    long longValue = number.longValue();
                    if (longValue <= 2147483647L && longValue >= -2147483648L && type != cls) {
                        i = 76;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
                serializeWriter.write(i);
            }
        } else if ((serializeWriter.features & SerializerFeature.WriteNullNumberAsZero.mask) != 0) {
            serializeWriter.write(48);
        } else {
            serializeWriter.writeNull();
        }
    }
}
