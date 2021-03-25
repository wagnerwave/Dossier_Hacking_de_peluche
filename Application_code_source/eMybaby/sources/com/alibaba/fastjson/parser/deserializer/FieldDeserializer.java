package com.alibaba.fastjson.parser.deserializer;

import a.a.a.a.a;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public abstract class FieldDeserializer {
    public final Class<?> clazz;
    public long[] enumNameHashCodes;
    public Enum[] enums;
    public final FieldInfo fieldInfo;

    public FieldDeserializer(Class<?> cls, FieldInfo fieldInfo2, int i) {
        this.clazz = cls;
        this.fieldInfo = fieldInfo2;
        if (fieldInfo2 != null) {
            Class<?> cls2 = fieldInfo2.fieldClass;
            if (cls2.isEnum()) {
                Enum[] enumArr = (Enum[]) cls2.getEnumConstants();
                int length = enumArr.length;
                long[] jArr = new long[length];
                this.enumNameHashCodes = new long[enumArr.length];
                for (int i2 = 0; i2 < enumArr.length; i2++) {
                    String name = enumArr[i2].name();
                    long j = -3750763034362895579L;
                    for (int i3 = 0; i3 < name.length(); i3++) {
                        j = (j ^ ((long) name.charAt(i3))) * 1099511628211L;
                    }
                    jArr[i2] = j;
                    this.enumNameHashCodes[i2] = j;
                }
                Arrays.sort(this.enumNameHashCodes);
                this.enums = new Enum[enumArr.length];
                for (int i4 = 0; i4 < this.enumNameHashCodes.length; i4++) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length) {
                            break;
                        } else if (this.enumNameHashCodes[i4] == jArr[i5]) {
                            this.enums[i4] = enumArr[i5];
                            break;
                        } else {
                            i5++;
                        }
                    }
                }
            }
        }
    }

    public Enum getEnumByHashCode(long j) {
        int binarySearch;
        if (this.enums != null && (binarySearch = Arrays.binarySearch(this.enumNameHashCodes, j)) >= 0) {
            return this.enums[binarySearch];
        }
        return null;
    }

    public abstract void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map);

    public void setValue(Object obj, double d2) {
        this.fieldInfo.field.setDouble(obj, d2);
    }

    public void setValue(Object obj, float f) {
        this.fieldInfo.field.setFloat(obj, f);
    }

    public void setValue(Object obj, int i) {
        this.fieldInfo.field.setInt(obj, i);
    }

    public void setValue(Object obj, long j) {
        this.fieldInfo.field.setLong(obj, j);
    }

    public void setValue(Object obj, Object obj2) {
        Collection collection;
        Map map;
        if (obj2 != null || !this.fieldInfo.fieldClass.isPrimitive()) {
            FieldInfo fieldInfo2 = this.fieldInfo;
            Field field = fieldInfo2.field;
            Method method = fieldInfo2.method;
            try {
                if (fieldInfo2.fieldAccess) {
                    if (!fieldInfo2.getOnly) {
                        field.set(obj, obj2);
                        return;
                    } else if (Map.class.isAssignableFrom(fieldInfo2.fieldClass)) {
                        map = (Map) field.get(obj);
                        if (map == null) {
                            return;
                        }
                    } else {
                        collection = (Collection) field.get(obj);
                        if (collection == null) {
                            return;
                        }
                        collection.addAll((Collection) obj2);
                        return;
                    }
                } else if (!fieldInfo2.getOnly) {
                    method.invoke(obj, new Object[]{obj2});
                    return;
                } else if (Map.class.isAssignableFrom(fieldInfo2.fieldClass)) {
                    map = (Map) method.invoke(obj, new Object[0]);
                    if (map == null) {
                        return;
                    }
                } else {
                    collection = (Collection) method.invoke(obj, new Object[0]);
                    if (collection != null) {
                        collection.addAll((Collection) obj2);
                        return;
                    }
                    return;
                }
                map.putAll((Map) obj2);
            } catch (Exception e2) {
                StringBuilder n = a.n("set property error, ");
                n.append(this.fieldInfo.name);
                throw new JSONException(n.toString(), e2);
            }
        }
    }
}
