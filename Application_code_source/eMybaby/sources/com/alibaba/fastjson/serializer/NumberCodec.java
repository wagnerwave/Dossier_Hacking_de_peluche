package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.text.DecimalFormat;

public class NumberCodec implements ObjectSerializer, ObjectDeserializer {
    public static final NumberCodec instance = new NumberCodec();
    public DecimalFormat decimalFormat;

    public NumberCodec() {
        this.decimalFormat = null;
    }

    public NumberCodec(String str) {
        this(new DecimalFormat(str));
    }

    public NumberCodec(DecimalFormat decimalFormat2) {
        this.decimalFormat = null;
        this.decimalFormat = decimalFormat2;
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Class<Byte> cls = Byte.class;
        Class<Short> cls2 = Short.class;
        Class<Float> cls3 = Float.class;
        Class<Double> cls4 = Double.class;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        if (i == 2) {
            if (type == Double.TYPE || type == cls4) {
                String numberString = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return Double.valueOf(Double.parseDouble(numberString));
            } else if (type == Float.TYPE || type == cls3) {
                String numberString2 = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return Float.valueOf(Float.parseFloat(numberString2));
            } else {
                long longValue = jSONLexer.longValue();
                jSONLexer.nextToken(16);
                return (type == Short.TYPE || type == cls2) ? Short.valueOf((short) ((int) longValue)) : (type == Byte.TYPE || type == cls) ? Byte.valueOf((byte) ((int) longValue)) : (longValue < -2147483648L || longValue > 2147483647L) ? Long.valueOf(longValue) : Integer.valueOf((int) longValue);
            }
        } else if (i != 3) {
            Object parse = defaultJSONParser.parse();
            if (parse == null) {
                return null;
            }
            return (type == Double.TYPE || type == cls4) ? TypeUtils.castToDouble(parse) : (type == Float.TYPE || type == cls3) ? TypeUtils.castToFloat(parse) : (type == Short.TYPE || type == cls2) ? TypeUtils.castToShort(parse) : (type == Byte.TYPE || type == cls) ? TypeUtils.castToByte(parse) : TypeUtils.castToBigDecimal(parse);
        } else if (type == Double.TYPE || type == cls4) {
            String numberString3 = jSONLexer.numberString();
            jSONLexer.nextToken(16);
            return Double.valueOf(Double.parseDouble(numberString3));
        } else if (type == Float.TYPE || type == cls3) {
            String numberString4 = jSONLexer.numberString();
            jSONLexer.nextToken(16);
            return Float.valueOf(Float.parseFloat(numberString4));
        } else {
            T decimalValue = jSONLexer.decimalValue();
            jSONLexer.nextToken(16);
            return (type == Short.TYPE || type == cls2) ? Short.valueOf(decimalValue.shortValue()) : (type == Byte.TYPE || type == cls) ? Byte.valueOf(decimalValue.byteValue()) : decimalValue;
        }
    }

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) {
        String str;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            if ((serializeWriter.features & SerializerFeature.WriteNullNumberAsZero.mask) != 0) {
                serializeWriter.write(48);
            } else {
                serializeWriter.writeNull();
            }
        } else if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            if (!Float.isNaN(floatValue) && !Float.isInfinite(floatValue)) {
                String f = Float.toString(floatValue);
                if (f.endsWith(".0")) {
                    f = f.substring(0, f.length() - 2);
                }
                serializeWriter.write(f);
                if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) {
                    serializeWriter.write(70);
                    return;
                }
                return;
            }
            serializeWriter.writeNull();
        } else {
            double doubleValue = ((Double) obj).doubleValue();
            if (!Double.isNaN(doubleValue) && !Double.isInfinite(doubleValue)) {
                DecimalFormat decimalFormat2 = this.decimalFormat;
                if (decimalFormat2 == null) {
                    str = Double.toString(doubleValue);
                    if (str.endsWith(".0")) {
                        str = str.substring(0, str.length() - 2);
                    }
                } else {
                    str = decimalFormat2.format(doubleValue);
                }
                serializeWriter.append((CharSequence) str);
                if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) {
                    serializeWriter.write(68);
                    return;
                }
                return;
            }
            serializeWriter.writeNull();
        }
    }
}
