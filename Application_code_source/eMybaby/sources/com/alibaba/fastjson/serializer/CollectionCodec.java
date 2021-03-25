package com.alibaba.fastjson.serializer;

import a.a.a.a.a;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import okhttp3.HttpUrl;

public class CollectionCodec implements ObjectSerializer, ObjectDeserializer {
    public static final CollectionCodec instance = new CollectionCodec();

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        T t;
        if (defaultJSONParser.lexer.token() == 8) {
            defaultJSONParser.lexer.nextToken(16);
            return null;
        } else if (type == JSONArray.class) {
            T jSONArray = new JSONArray();
            defaultJSONParser.parseArray((Collection) jSONArray);
            return jSONArray;
        } else {
            Type type2 = type;
            while (!(type2 instanceof Class)) {
                if (type2 instanceof ParameterizedType) {
                    type2 = ((ParameterizedType) type2).getRawType();
                } else {
                    throw new JSONException("TODO");
                }
            }
            Class<Collection> cls = (Class) type2;
            if (cls == AbstractCollection.class || cls == Collection.class) {
                t = new ArrayList();
            } else if (cls.isAssignableFrom(HashSet.class)) {
                t = new HashSet();
            } else if (cls.isAssignableFrom(LinkedHashSet.class)) {
                t = new LinkedHashSet();
            } else if (cls.isAssignableFrom(TreeSet.class)) {
                t = new TreeSet();
            } else if (cls.isAssignableFrom(ArrayList.class)) {
                t = new ArrayList();
            } else if (cls.isAssignableFrom(EnumSet.class)) {
                t = EnumSet.noneOf((Class) (type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class));
            } else {
                try {
                    t = (Collection) cls.newInstance();
                } catch (Exception unused) {
                    StringBuilder n = a.n("create instane error, class ");
                    n.append(cls.getName());
                    throw new JSONException(n.toString());
                }
            }
            defaultJSONParser.parseArray(TypeUtils.getCollectionItemType(type), t, obj);
            return t;
        }
    }

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) {
        String str;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj != null) {
            Type type2 = null;
            if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) {
                type2 = TypeUtils.getCollectionItemType(type);
            }
            Collection collection = (Collection) obj;
            SerialContext serialContext = jSONSerializer.context;
            int i = 0;
            jSONSerializer.setContext(serialContext, obj, obj2, 0);
            if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) {
                if (HashSet.class == collection.getClass()) {
                    str = "Set";
                } else if (TreeSet.class == collection.getClass()) {
                    str = "TreeSet";
                }
                serializeWriter.append((CharSequence) str);
            }
            try {
                serializeWriter.write(91);
                for (Object next : collection) {
                    int i2 = i + 1;
                    if (i != 0) {
                        serializeWriter.write(44);
                    }
                    if (next == null) {
                        serializeWriter.writeNull();
                    } else {
                        Class<?> cls = next.getClass();
                        if (cls == Integer.class) {
                            serializeWriter.writeInt(((Integer) next).intValue());
                        } else if (cls == Long.class) {
                            serializeWriter.writeLong(((Long) next).longValue());
                            if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) {
                                serializeWriter.write(76);
                            }
                        } else {
                            jSONSerializer.config.get(cls).write(jSONSerializer, next, Integer.valueOf(i2 - 1), type2);
                        }
                    }
                    i = i2;
                }
                serializeWriter.write(93);
            } finally {
                jSONSerializer.context = serialContext;
            }
        } else if ((serializeWriter.features & SerializerFeature.WriteNullListAsEmpty.mask) != 0) {
            serializeWriter.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        } else {
            serializeWriter.writeNull();
        }
    }
}
