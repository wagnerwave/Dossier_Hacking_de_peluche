package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;
import okhttp3.HttpUrl;

public final class ArraySerializer implements ObjectSerializer {
    public final ObjectSerializer compObjectSerializer;
    public final Class<?> componentType;

    public ArraySerializer(Class<?> cls, ObjectSerializer objectSerializer) {
        this.componentType = cls;
        this.compObjectSerializer = objectSerializer;
    }

    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) {
        ObjectSerializer objectSerializer;
        Integer valueOf;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj != null) {
            int i = 0;
            if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                serializeWriter.write(91);
                while (i < zArr.length) {
                    if (i != 0) {
                        serializeWriter.write(44);
                    }
                    serializeWriter.write(zArr[i]);
                    i++;
                }
                serializeWriter.write(93);
            } else if (obj instanceof byte[]) {
                serializeWriter.writeByteArray((byte[]) obj);
            } else if (obj instanceof char[]) {
                serializeWriter.writeString(new String((char[]) obj));
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                int length = dArr.length - 1;
                if (length == -1) {
                    serializeWriter.append((CharSequence) HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                    return;
                }
                serializeWriter.write(91);
                while (i < length) {
                    double d2 = dArr[i];
                    if (Double.isNaN(d2)) {
                        serializeWriter.writeNull();
                    } else {
                        serializeWriter.append((CharSequence) Double.toString(d2));
                    }
                    serializeWriter.write(44);
                    i++;
                }
                double d3 = dArr[length];
                if (Double.isNaN(d3)) {
                    serializeWriter.writeNull();
                } else {
                    serializeWriter.append((CharSequence) Double.toString(d3));
                }
                serializeWriter.write(93);
            } else if (obj instanceof float[]) {
                float[] fArr = (float[]) obj;
                int length2 = fArr.length - 1;
                if (length2 == -1) {
                    serializeWriter.append((CharSequence) HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                    return;
                }
                serializeWriter.write(91);
                while (i < length2) {
                    float f = fArr[i];
                    if (Float.isNaN(f)) {
                        serializeWriter.writeNull();
                    } else {
                        serializeWriter.append((CharSequence) Float.toString(f));
                    }
                    serializeWriter.write(44);
                    i++;
                }
                float f2 = fArr[length2];
                if (Float.isNaN(f2)) {
                    serializeWriter.writeNull();
                } else {
                    serializeWriter.append((CharSequence) Float.toString(f2));
                }
                serializeWriter.write(93);
            } else if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                serializeWriter.write(91);
                while (i < iArr.length) {
                    if (i != 0) {
                        serializeWriter.write(44);
                    }
                    serializeWriter.writeInt(iArr[i]);
                    i++;
                }
                serializeWriter.write(93);
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                serializeWriter.write(91);
                while (i < jArr.length) {
                    if (i != 0) {
                        serializeWriter.write(44);
                    }
                    serializeWriter.writeLong(jArr[i]);
                    i++;
                }
                serializeWriter.write(93);
            } else if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                serializeWriter.write(91);
                while (i < sArr.length) {
                    if (i != 0) {
                        serializeWriter.write(44);
                    }
                    serializeWriter.writeInt(sArr[i]);
                    i++;
                }
                serializeWriter.write(93);
            } else {
                Object[] objArr = (Object[]) obj;
                int length3 = objArr.length;
                SerialContext serialContext = jSONSerializer.context;
                jSONSerializer.setContext(serialContext, obj, obj2, 0);
                try {
                    serializeWriter.write(91);
                    while (i < length3) {
                        if (i != 0) {
                            serializeWriter.write(44);
                        }
                        Object obj3 = objArr[i];
                        if (obj3 != null) {
                            if (obj3.getClass() == this.componentType) {
                                objectSerializer = this.compObjectSerializer;
                                valueOf = Integer.valueOf(i);
                            } else {
                                objectSerializer = jSONSerializer.config.get(obj3.getClass());
                                valueOf = Integer.valueOf(i);
                            }
                            objectSerializer.write(jSONSerializer, obj3, valueOf, (Type) null);
                        } else if (!serializeWriter.isEnabled(SerializerFeature.WriteNullStringAsEmpty) || !(obj instanceof String[])) {
                            serializeWriter.append((CharSequence) "null");
                        } else {
                            serializeWriter.writeString("");
                        }
                        i++;
                    }
                    serializeWriter.write(93);
                } finally {
                    jSONSerializer.context = serialContext;
                }
            }
        } else if ((serializeWriter.features & SerializerFeature.WriteNullListAsEmpty.mask) != 0) {
            serializeWriter.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        } else {
            serializeWriter.writeNull();
        }
    }
}
