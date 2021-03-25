package com.alibaba.fastjson.util;

import a.a.a.a.a;
import androidx.core.graphics.PaintCompat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.tuya.smart.common.oOO0O0O0;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TypeUtils {
    public static boolean compatibleWithJavaBean = false;
    public static volatile Map<Class, String[]> kotlinIgnores = null;
    public static volatile boolean kotlinIgnores_error = false;
    public static volatile boolean kotlin_class_klass_error = false;
    public static volatile boolean kotlin_error = false;
    public static volatile Constructor kotlin_kclass_constructor = null;
    public static volatile Method kotlin_kclass_getConstructors = null;
    public static volatile Method kotlin_kfunction_getParameters = null;
    public static volatile Method kotlin_kparameter_getName = null;
    public static volatile Class kotlin_metadata = null;
    public static volatile boolean kotlin_metadata_error = false;
    public static final ConcurrentMap<String, Class<?>> mappings;
    public static boolean setAccessibleEnable = true;

    static {
        Class<char[]> cls = char[].class;
        Class<boolean[]> cls2 = boolean[].class;
        Class<double[]> cls3 = double[].class;
        Class<float[]> cls4 = float[].class;
        Class<long[]> cls5 = long[].class;
        Class<int[]> cls6 = int[].class;
        Class<short[]> cls7 = short[].class;
        Class<byte[]> cls8 = byte[].class;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(36, 0.75f, 1);
        mappings = concurrentHashMap;
        concurrentHashMap.put("byte", Byte.TYPE);
        mappings.put("short", Short.TYPE);
        mappings.put("int", Integer.TYPE);
        mappings.put("long", Long.TYPE);
        mappings.put("float", Float.TYPE);
        mappings.put("double", Double.TYPE);
        mappings.put("boolean", Boolean.TYPE);
        mappings.put("char", Character.TYPE);
        mappings.put("[byte", cls8);
        mappings.put("[short", cls7);
        mappings.put("[int", cls6);
        mappings.put("[long", cls5);
        mappings.put("[float", cls4);
        mappings.put("[double", cls3);
        mappings.put("[boolean", cls2);
        mappings.put("[char", cls);
        mappings.put("[B", cls8);
        mappings.put("[S", cls7);
        mappings.put("[I", cls6);
        mappings.put("[J", cls5);
        mappings.put("[F", cls4);
        mappings.put("[D", cls3);
        mappings.put("[C", cls);
        mappings.put("[Z", cls2);
        mappings.put("java.util.HashMap", HashMap.class);
        mappings.put("java.util.TreeMap", TreeMap.class);
        mappings.put("java.util.Date", Date.class);
        mappings.put("com.alibaba.fastjson.JSONObject", JSONObject.class);
        mappings.put("java.util.concurrent.ConcurrentHashMap", ConcurrentHashMap.class);
        mappings.put("java.text.SimpleDateFormat", SimpleDateFormat.class);
        mappings.put("java.lang.StackTraceElement", StackTraceElement.class);
        mappings.put("java.lang.RuntimeException", RuntimeException.class);
    }

    public static final <T> T cast(Object obj, Class<T> cls, ParserConfig parserConfig) {
        return cast(obj, cls, parserConfig, 0);
    }

    public static final <T> T cast(Object obj, Class<T> cls, ParserConfig parserConfig, int i) {
        T t;
        if (obj == null) {
            return null;
        }
        if (cls == null) {
            throw new IllegalArgumentException("clazz is null");
        } else if (cls == obj.getClass()) {
            return obj;
        } else {
            if (!(obj instanceof Map)) {
                int i2 = 0;
                if (cls.isArray()) {
                    if (obj instanceof Collection) {
                        Collection<Object> collection = (Collection) obj;
                        T newInstance = Array.newInstance(cls.getComponentType(), collection.size());
                        for (Object cast : collection) {
                            Array.set(newInstance, i2, cast(cast, cls.getComponentType(), parserConfig));
                            i2++;
                        }
                        return newInstance;
                    } else if (cls == byte[].class) {
                        return castToBytes(obj);
                    }
                }
                if (cls.isAssignableFrom(obj.getClass())) {
                    return obj;
                }
                if (cls == Boolean.TYPE || cls == Boolean.class) {
                    return castToBoolean(obj);
                }
                if (cls == Byte.TYPE || cls == Byte.class) {
                    return castToByte(obj);
                }
                if ((cls == Character.TYPE || cls == Character.class) && (obj instanceof String)) {
                    String str = (String) obj;
                    if (str.length() == 1) {
                        return Character.valueOf(str.charAt(0));
                    }
                }
                if (cls == Short.TYPE || cls == Short.class) {
                    return castToShort(obj);
                }
                if (cls == Integer.TYPE || cls == Integer.class) {
                    return castToInt(obj);
                }
                if (cls == Long.TYPE || cls == Long.class) {
                    return castToLong(obj);
                }
                if (cls == Float.TYPE || cls == Float.class) {
                    return castToFloat(obj);
                }
                if (cls == Double.TYPE || cls == Double.class) {
                    return castToDouble(obj);
                }
                if (cls == String.class) {
                    return castToString(obj);
                }
                if (cls == BigDecimal.class) {
                    return castToBigDecimal(obj);
                }
                if (cls == BigInteger.class) {
                    return castToBigInteger(obj);
                }
                if (cls == Date.class) {
                    return castToDate(obj);
                }
                if (cls.isEnum()) {
                    return castToEnum(obj, cls, parserConfig);
                }
                if (Calendar.class.isAssignableFrom(cls)) {
                    Date castToDate = castToDate(obj);
                    if (cls == Calendar.class) {
                        t = Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
                    } else {
                        try {
                            t = (Calendar) cls.newInstance();
                        } catch (Exception e2) {
                            StringBuilder n = a.n("can not cast to : ");
                            n.append(cls.getName());
                            throw new JSONException(n.toString(), e2);
                        }
                    }
                    t.setTime(castToDate);
                    return t;
                }
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (str2.length() == 0 || "null".equals(str2)) {
                        return null;
                    }
                    if (cls == Currency.class) {
                        return Currency.getInstance(str2);
                    }
                }
                StringBuilder n2 = a.n("can not cast to : ");
                n2.append(cls.getName());
                throw new JSONException(n2.toString());
            } else if (cls == Map.class) {
                return obj;
            } else {
                Map map = (Map) obj;
                return (cls != Object.class || map.containsKey(JSON.DEFAULT_TYPE_KEY)) ? castToJavaBean(map, cls, parserConfig, i) : obj;
            }
        }
    }

    public static final <T> T cast(Object obj, ParameterizedType parameterizedType, ParserConfig parserConfig) {
        Type rawType = parameterizedType.getRawType();
        if (rawType == Set.class || rawType == HashSet.class || rawType == TreeSet.class || rawType == List.class || rawType == ArrayList.class) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof Iterable) {
                T hashSet = (rawType == Set.class || rawType == HashSet.class) ? new HashSet() : rawType == TreeSet.class ? new TreeSet() : new ArrayList();
                for (Object cast : (Iterable) obj) {
                    hashSet.add(cast(cast, type, parserConfig));
                }
                return hashSet;
            }
        }
        if (rawType == Map.class || rawType == HashMap.class) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            Type type3 = parameterizedType.getActualTypeArguments()[1];
            if (obj instanceof Map) {
                T hashMap = new HashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    hashMap.put(cast(entry.getKey(), type2, parserConfig), cast(entry.getValue(), type3, parserConfig));
                }
                return hashMap;
            }
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
        }
        if (parameterizedType.getActualTypeArguments().length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
            return cast(obj, rawType, parserConfig);
        }
        throw new JSONException("can not cast to : " + parameterizedType);
    }

    public static final <T> T cast(Object obj, Type type, ParserConfig parserConfig) {
        if (obj == null) {
            return null;
        }
        if (type instanceof Class) {
            return cast(obj, (Class) type, parserConfig);
        }
        if (type instanceof ParameterizedType) {
            return cast(obj, (ParameterizedType) type, parserConfig);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
        }
        if (type instanceof TypeVariable) {
            return obj;
        }
        throw new JSONException("can not cast to : " + type);
    }

    public static final BigDecimal castToBigDecimal(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        if (obj instanceof BigInteger) {
            return new BigDecimal((BigInteger) obj);
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0 || "null".equals(obj2)) {
            return null;
        }
        return new BigDecimal(obj2);
    }

    public static final BigInteger castToBigInteger(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return BigInteger.valueOf(((Number) obj).longValue());
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0 || "null".equals(obj2)) {
            return null;
        }
        return new BigInteger(obj2);
    }

    public static final Boolean castToBoolean(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof Number) {
            boolean z = true;
            if (((Number) obj).intValue() != 1) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            if ("true".equalsIgnoreCase(str) || "1".equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(str) || oOO0O0O0.O0000oO0.equals(str)) {
                return Boolean.FALSE;
            }
        }
        throw new JSONException("can not cast to int, value : " + obj);
    }

    public static final Byte castToByte(Object obj) {
        byte parseByte;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            parseByte = ((Number) obj).byteValue();
        } else if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            parseByte = Byte.parseByte(str);
        } else {
            throw new JSONException("can not cast to byte, value : " + obj);
        }
        return Byte.valueOf(parseByte);
    }

    public static final byte[] castToBytes(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            return JSONLexer.decodeFast(str, 0, str.length());
        }
        throw new JSONException("can not cast to int, value : " + obj);
    }

    public static final Character castToChar(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return (Character) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            if (str.length() == 1) {
                return Character.valueOf(str.charAt(0));
            }
            throw new JSONException("can not cast to byte, value : " + obj);
        }
        throw new JSONException("can not cast to byte, value : " + obj);
    }

    public static final Date castToDate(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        long j = -1;
        if (obj instanceof Number) {
            j = ((Number) obj).longValue();
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.indexOf(45) != -1) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str.length() == JSON.DEFFAULT_DATE_FORMAT.length() ? JSON.DEFFAULT_DATE_FORMAT : str.length() == 10 ? "yyyy-MM-dd" : str.length() == 19 ? "yyyy-MM-dd HH:mm:ss" : (str.length() == 29 && str.charAt(26) == ':' && str.charAt(28) == '0') ? "yyyy-MM-dd'T'HH:mm:ss.SSSXXX" : "yyyy-MM-dd HH:mm:ss.SSS", JSON.defaultLocale);
                simpleDateFormat.setTimeZone(JSON.defaultTimeZone);
                try {
                    return simpleDateFormat.parse(str);
                } catch (ParseException unused) {
                    throw new JSONException(a.k("can not cast to Date, value : ", str));
                }
            } else if (str.length() == 0 || "null".equals(str)) {
                return null;
            } else {
                j = Long.parseLong(str);
            }
        }
        if (j >= 0) {
            return new Date(j);
        }
        throw new JSONException("can not cast to Date, value : " + obj);
    }

    public static final Double castToDouble(Object obj) {
        double parseDouble;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            parseDouble = ((Number) obj).doubleValue();
        } else if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.length() == 0 || "null".equals(obj2)) {
                return null;
            }
            parseDouble = Double.parseDouble(obj2);
        } else {
            throw new JSONException("can not cast to double, value : " + obj);
        }
        return Double.valueOf(parseDouble);
    }

    public static final <T> T castToEnum(Object obj, Class<T> cls, ParserConfig parserConfig) {
        try {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0) {
                    return null;
                }
                return Enum.valueOf(cls, str);
            }
            if (obj instanceof Number) {
                int intValue = ((Number) obj).intValue();
                T[] enumConstants = cls.getEnumConstants();
                if (intValue < enumConstants.length) {
                    return enumConstants[intValue];
                }
            }
            StringBuilder n = a.n("can not cast to : ");
            n.append(cls.getName());
            throw new JSONException(n.toString());
        } catch (Exception e2) {
            StringBuilder n2 = a.n("can not cast to : ");
            n2.append(cls.getName());
            throw new JSONException(n2.toString(), e2);
        }
    }

    public static final Float castToFloat(Object obj) {
        float parseFloat;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            parseFloat = ((Number) obj).floatValue();
        } else if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.length() == 0 || "null".equals(obj2)) {
                return null;
            }
            parseFloat = Float.parseFloat(obj2);
        } else {
            throw new JSONException("can not cast to float, value : " + obj);
        }
        return Float.valueOf(parseFloat);
    }

    public static final Integer castToInt(Object obj) {
        int parseInt;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            parseInt = ((Number) obj).intValue();
        } else if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            parseInt = Integer.parseInt(str);
        } else {
            throw new JSONException("can not cast to int, value : " + obj);
        }
        return Integer.valueOf(parseInt);
    }

    public static final <T> T castToJavaBean(Object obj, Class<T> cls) {
        return cast(obj, cls, ParserConfig.global);
    }

    public static final <T> T castToJavaBean(Map<String, Object> map, Class<T> cls, ParserConfig parserConfig) {
        return castToJavaBean(map, cls, parserConfig, 0);
    }

    /* JADX WARNING: type inference failed for: r5v1, types: [com.alibaba.fastjson.parser.deserializer.ObjectDeserializer] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T castToJavaBean(java.util.Map<java.lang.String, java.lang.Object> r4, java.lang.Class<T> r5, com.alibaba.fastjson.parser.ParserConfig r6, int r7) {
        /*
            java.lang.Class<java.lang.StackTraceElement> r0 = java.lang.StackTraceElement.class
            r1 = 0
            if (r5 != r0) goto L_0x0032
            java.lang.String r5 = "className"
            java.lang.Object r5 = r4.get(r5)     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r6 = "methodName"
            java.lang.Object r6 = r4.get(r6)     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r7 = "fileName"
            java.lang.Object r7 = r4.get(r7)     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r0 = "lineNumber"
            java.lang.Object r4 = r4.get(r0)     // Catch:{ Exception -> 0x00d0 }
            java.lang.Number r4 = (java.lang.Number) r4     // Catch:{ Exception -> 0x00d0 }
            if (r4 != 0) goto L_0x0028
            goto L_0x002c
        L_0x0028:
            int r1 = r4.intValue()     // Catch:{ Exception -> 0x00d0 }
        L_0x002c:
            java.lang.StackTraceElement r4 = new java.lang.StackTraceElement     // Catch:{ Exception -> 0x00d0 }
            r4.<init>(r5, r6, r7, r1)     // Catch:{ Exception -> 0x00d0 }
            return r4
        L_0x0032:
            java.lang.String r0 = "@type"
            java.lang.Object r0 = r4.get(r0)     // Catch:{ Exception -> 0x00d0 }
            boolean r2 = r0 instanceof java.lang.String     // Catch:{ Exception -> 0x00d0 }
            r3 = 0
            if (r2 == 0) goto L_0x006b
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x00d0 }
            if (r6 != 0) goto L_0x0043
            com.alibaba.fastjson.parser.ParserConfig r6 = com.alibaba.fastjson.parser.ParserConfig.global     // Catch:{ Exception -> 0x00d0 }
        L_0x0043:
            java.lang.Class r2 = r6.checkAutoType(r0, r3, r7)     // Catch:{ Exception -> 0x00d0 }
            if (r2 == 0) goto L_0x0054
            boolean r0 = r2.equals(r5)     // Catch:{ Exception -> 0x00d0 }
            if (r0 != 0) goto L_0x006b
            java.lang.Object r4 = castToJavaBean(r4, r2, r6, r7)     // Catch:{ Exception -> 0x00d0 }
            return r4
        L_0x0054:
            java.lang.ClassNotFoundException r4 = new java.lang.ClassNotFoundException     // Catch:{ Exception -> 0x00d0 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d0 }
            r5.<init>()     // Catch:{ Exception -> 0x00d0 }
            r5.append(r0)     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r6 = " not found"
            r5.append(r6)     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00d0 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x00d0 }
            throw r4     // Catch:{ Exception -> 0x00d0 }
        L_0x006b:
            boolean r7 = r5.isInterface()     // Catch:{ Exception -> 0x00d0 }
            if (r7 == 0) goto L_0x00a5
            boolean r7 = r4 instanceof com.alibaba.fastjson.JSONObject     // Catch:{ Exception -> 0x00d0 }
            if (r7 == 0) goto L_0x0078
            com.alibaba.fastjson.JSONObject r4 = (com.alibaba.fastjson.JSONObject) r4     // Catch:{ Exception -> 0x00d0 }
            goto L_0x007e
        L_0x0078:
            com.alibaba.fastjson.JSONObject r7 = new com.alibaba.fastjson.JSONObject     // Catch:{ Exception -> 0x00d0 }
            r7.<init>((java.util.Map<java.lang.String, java.lang.Object>) r4)     // Catch:{ Exception -> 0x00d0 }
            r4 = r7
        L_0x007e:
            if (r6 != 0) goto L_0x0084
            com.alibaba.fastjson.parser.ParserConfig r6 = com.alibaba.fastjson.parser.ParserConfig.getGlobalInstance()     // Catch:{ Exception -> 0x00d0 }
        L_0x0084:
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r6 = r6.getDeserializer(r5)     // Catch:{ Exception -> 0x00d0 }
            if (r6 == 0) goto L_0x0093
            java.lang.String r4 = com.alibaba.fastjson.JSON.toJSONString(r4)     // Catch:{ Exception -> 0x00d0 }
            java.lang.Object r4 = com.alibaba.fastjson.JSON.parseObject((java.lang.String) r4, r5)     // Catch:{ Exception -> 0x00d0 }
            return r4
        L_0x0093:
            java.lang.Thread r6 = java.lang.Thread.currentThread()     // Catch:{ Exception -> 0x00d0 }
            java.lang.ClassLoader r6 = r6.getContextClassLoader()     // Catch:{ Exception -> 0x00d0 }
            r7 = 1
            java.lang.Class[] r7 = new java.lang.Class[r7]     // Catch:{ Exception -> 0x00d0 }
            r7[r1] = r5     // Catch:{ Exception -> 0x00d0 }
            java.lang.Object r4 = java.lang.reflect.Proxy.newProxyInstance(r6, r7, r4)     // Catch:{ Exception -> 0x00d0 }
            return r4
        L_0x00a5:
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            if (r5 != r7) goto L_0x00b2
            boolean r7 = r4 instanceof com.alibaba.fastjson.JSONObject     // Catch:{ Exception -> 0x00d0 }
            if (r7 == 0) goto L_0x00b2
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00d0 }
            return r4
        L_0x00b2:
            if (r6 != 0) goto L_0x00b6
            com.alibaba.fastjson.parser.ParserConfig r6 = com.alibaba.fastjson.parser.ParserConfig.global     // Catch:{ Exception -> 0x00d0 }
        L_0x00b6:
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r5 = r6.getDeserializer(r5)     // Catch:{ Exception -> 0x00d0 }
            boolean r7 = r5 instanceof com.alibaba.fastjson.parser.JavaBeanDeserializer     // Catch:{ Exception -> 0x00d0 }
            if (r7 == 0) goto L_0x00c1
            r3 = r5
            com.alibaba.fastjson.parser.JavaBeanDeserializer r3 = (com.alibaba.fastjson.parser.JavaBeanDeserializer) r3     // Catch:{ Exception -> 0x00d0 }
        L_0x00c1:
            if (r3 == 0) goto L_0x00c8
            java.lang.Object r4 = r3.createInstance((java.util.Map<java.lang.String, java.lang.Object>) r4, (com.alibaba.fastjson.parser.ParserConfig) r6)     // Catch:{ Exception -> 0x00d0 }
            return r4
        L_0x00c8:
            com.alibaba.fastjson.JSONException r4 = new com.alibaba.fastjson.JSONException     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r5 = "can not get javaBeanDeserializer"
            r4.<init>(r5)     // Catch:{ Exception -> 0x00d0 }
            throw r4     // Catch:{ Exception -> 0x00d0 }
        L_0x00d0:
            r4 = move-exception
            com.alibaba.fastjson.JSONException r5 = new com.alibaba.fastjson.JSONException
            java.lang.String r6 = r4.getMessage()
            r5.<init>(r6, r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.castToJavaBean(java.util.Map, java.lang.Class, com.alibaba.fastjson.parser.ParserConfig, int):java.lang.Object");
    }

    public static final Long castToLong(Object obj) {
        long timeInMillis;
        Calendar calendar = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            timeInMillis = ((Number) obj).longValue();
        } else {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0 || "null".equals(str)) {
                    return null;
                }
                try {
                    return Long.valueOf(Long.parseLong(str));
                } catch (NumberFormatException unused) {
                    JSONLexer jSONLexer = new JSONLexer(str);
                    if (jSONLexer.scanISO8601DateIfMatch(false)) {
                        calendar = jSONLexer.calendar;
                    }
                    jSONLexer.close();
                    if (calendar != null) {
                        timeInMillis = calendar.getTimeInMillis();
                    }
                }
            }
            throw new JSONException("can not cast to long, value : " + obj);
        }
        return Long.valueOf(timeInMillis);
    }

    public static final Short castToShort(Object obj) {
        short parseShort;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            parseShort = ((Number) obj).shortValue();
        } else if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            parseShort = Short.parseShort(str);
        } else {
            throw new JSONException("can not cast to short, value : " + obj);
        }
        return Short.valueOf(parseShort);
    }

    public static final String castToString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: java.lang.Class<? super java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Class<? super java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Class<? super java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: java.lang.Class<? super ? super java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: java.lang.Class<? super java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: java.lang.Class<? super java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: java.lang.Class<? super java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: java.lang.Class<? super java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: java.lang.Class<? super java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v64, resolved type: java.lang.Class<? super ? super java.lang.Object>} */
    /* JADX WARNING: type inference failed for: r18v15, types: [java.lang.annotation.Annotation[][]] */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x02ad, code lost:
        if (java.lang.Character.isUpperCase(r5.charAt(4)) != false) goto L_0x026b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x02f7, code lost:
        if (r0 == null) goto L_0x0316;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x041f, code lost:
        if (r0 == null) goto L_0x044a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b1, code lost:
        if (r6.getReturnType().getName().equals("groovy.lang.MetaClass") != false) goto L_0x00d3;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x02b7  */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x05bc  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x05ce  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.alibaba.fastjson.util.FieldInfo> computeGetters(java.lang.Class<?> r42, int r43, boolean r44, com.alibaba.fastjson.annotation.JSONType r45, java.util.Map<java.lang.String, java.lang.String> r46, boolean r47, boolean r48, boolean r49, com.alibaba.fastjson.PropertyNamingStrategy r50) {
        /*
            r11 = r42
            r12 = r43
            r13 = r45
            r14 = r46
            r15 = r50
            java.lang.Class<java.lang.Object> r10 = java.lang.Object.class
            java.util.LinkedHashMap r9 = new java.util.LinkedHashMap
            r9.<init>()
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            java.lang.reflect.Field[] r7 = r42.getDeclaredFields()
            r16 = 0
            if (r44 != 0) goto L_0x0491
            boolean r17 = isKotlin(r42)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = r11
        L_0x0028:
            if (r1 == 0) goto L_0x007f
            if (r1 == r10) goto L_0x007f
            java.lang.reflect.Method[] r2 = r1.getDeclaredMethods()
            int r3 = r2.length
            r4 = 0
        L_0x0032:
            if (r4 >= r3) goto L_0x007a
            r5 = r2[r4]
            int r6 = r5.getModifiers()
            r20 = r6 & 8
            if (r20 != 0) goto L_0x0073
            r20 = r6 & 2
            if (r20 != 0) goto L_0x0073
            r44 = r2
            r2 = r6 & 256(0x100, float:3.59E-43)
            if (r2 != 0) goto L_0x0075
            r2 = r6 & 4
            if (r2 == 0) goto L_0x004d
            goto L_0x0075
        L_0x004d:
            java.lang.Class r2 = r5.getReturnType()
            java.lang.Class r6 = java.lang.Void.TYPE
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L_0x0075
            java.lang.Class[] r2 = r5.getParameterTypes()
            int r2 = r2.length
            if (r2 != 0) goto L_0x0075
            java.lang.Class r2 = r5.getReturnType()
            java.lang.Class<java.lang.ClassLoader> r6 = java.lang.ClassLoader.class
            if (r2 == r6) goto L_0x0075
            java.lang.Class r2 = r5.getDeclaringClass()
            if (r2 != r10) goto L_0x006f
            goto L_0x0075
        L_0x006f:
            r0.add(r5)
            goto L_0x0075
        L_0x0073:
            r44 = r2
        L_0x0075:
            int r4 = r4 + 1
            r2 = r44
            goto L_0x0032
        L_0x007a:
            java.lang.Class r1 = r1.getSuperclass()
            goto L_0x0028
        L_0x007f:
            java.util.Iterator r20 = r0.iterator()
            r0 = r16
            r1 = r0
            r2 = r1
            r3 = r2
        L_0x0088:
            boolean r4 = r20.hasNext()
            if (r4 == 0) goto L_0x0491
            java.lang.Object r4 = r20.next()
            r6 = r4
            java.lang.reflect.Method r6 = (java.lang.reflect.Method) r6
            java.lang.String r5 = r6.getName()
            java.lang.String r4 = "getMetaClass"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x00b4
            java.lang.Class r4 = r6.getReturnType()
            java.lang.String r4 = r4.getName()
            r44 = r1
            java.lang.String r1 = "groovy.lang.MetaClass"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x00b6
            goto L_0x00d3
        L_0x00b4:
            r44 = r1
        L_0x00b6:
            if (r48 == 0) goto L_0x00c1
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r1 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r1 = r6.getAnnotation(r1)
            com.alibaba.fastjson.annotation.JSONField r1 = (com.alibaba.fastjson.annotation.JSONField) r1
            goto L_0x00c3
        L_0x00c1:
            r1 = r16
        L_0x00c3:
            if (r1 != 0) goto L_0x00cb
            if (r48 == 0) goto L_0x00cb
            com.alibaba.fastjson.annotation.JSONField r1 = getSupperMethodAnnotation(r11, r6)
        L_0x00cb:
            if (r17 == 0) goto L_0x00d6
            boolean r4 = isKotlinIgnore(r11, r5)
            if (r4 == 0) goto L_0x00d6
        L_0x00d3:
            r1 = r44
            goto L_0x0088
        L_0x00d6:
            java.lang.String r4 = "get"
            r21 = r10
            if (r1 != 0) goto L_0x01a0
            if (r17 == 0) goto L_0x01a0
            if (r0 != 0) goto L_0x012f
            java.lang.reflect.Constructor[] r0 = r42.getDeclaredConstructors()
            int r10 = r0.length
            r23 = r3
            r3 = 1
            if (r10 != r3) goto L_0x0126
            r10 = 0
            r18 = r0[r10]
            java.lang.annotation.Annotation[][] r18 = r18.getParameterAnnotations()
            java.lang.String[] r3 = getKoltinConstructorParameters(r42)
            if (r3 == 0) goto L_0x011e
            int r2 = r3.length
            java.lang.String[] r2 = new java.lang.String[r2]
            r24 = r0
            int r0 = r3.length
            java.lang.System.arraycopy(r3, r10, r2, r10, r0)
            java.util.Arrays.sort(r2)
            int r0 = r3.length
            short[] r0 = new short[r0]
            r26 = r1
        L_0x0108:
            int r1 = r3.length
            if (r10 >= r1) goto L_0x0117
            r1 = r3[r10]
            int r1 = java.util.Arrays.binarySearch(r2, r1)
            r0[r1] = r10
            int r10 = r10 + 1
            short r10 = (short) r10
            goto L_0x0108
        L_0x0117:
            r1 = r2
            r3 = r18
            r2 = r0
            r0 = r24
            goto L_0x0135
        L_0x011e:
            r24 = r0
            r26 = r1
            r1 = r3
            r3 = r18
            goto L_0x0135
        L_0x0126:
            r24 = r0
            r26 = r1
            r1 = r44
            r3 = r23
            goto L_0x0135
        L_0x012f:
            r26 = r1
            r23 = r3
            r1 = r44
        L_0x0135:
            if (r1 == 0) goto L_0x0191
            if (r2 == 0) goto L_0x0191
            boolean r10 = r5.startsWith(r4)
            if (r10 == 0) goto L_0x0191
            r10 = 3
            java.lang.String r18 = r5.substring(r10)
            java.lang.String r10 = decapitalize(r18)
            int r18 = java.util.Arrays.binarySearch(r1, r10)
            r44 = r0
            r24 = r7
            if (r18 >= 0) goto L_0x0164
            r0 = 0
        L_0x0153:
            int r7 = r1.length
            if (r0 >= r7) goto L_0x0164
            r7 = r1[r0]
            boolean r7 = r10.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x0161
            r18 = r0
            goto L_0x0164
        L_0x0161:
            int r0 = r0 + 1
            goto L_0x0153
        L_0x0164:
            if (r18 < 0) goto L_0x018e
            short r0 = r2[r18]
            r0 = r3[r0]
            if (r0 == 0) goto L_0x018e
            int r7 = r0.length
            r10 = 0
        L_0x016e:
            if (r10 >= r7) goto L_0x018e
            r18 = r1
            r1 = r0[r10]
            r23 = r0
            boolean r0 = r1 instanceof com.alibaba.fastjson.annotation.JSONField
            if (r0 == 0) goto L_0x0187
            com.alibaba.fastjson.annotation.JSONField r1 = (com.alibaba.fastjson.annotation.JSONField) r1
            r28 = r1
            r26 = r2
            r27 = r3
            r23 = r18
            r18 = r44
            goto L_0x01b0
        L_0x0187:
            int r10 = r10 + 1
            r1 = r18
            r0 = r23
            goto L_0x016e
        L_0x018e:
            r18 = r1
            goto L_0x0197
        L_0x0191:
            r44 = r0
            r18 = r1
            r24 = r7
        L_0x0197:
            r27 = r3
            r23 = r18
            r28 = r26
            r18 = r44
            goto L_0x01ae
        L_0x01a0:
            r26 = r1
            r23 = r3
            r24 = r7
            r18 = r0
            r27 = r23
            r28 = r26
            r23 = r44
        L_0x01ae:
            r26 = r2
        L_0x01b0:
            if (r28 == 0) goto L_0x0230
            boolean r0 = r28.serialize()
            if (r0 != 0) goto L_0x01c7
        L_0x01b8:
            r37 = r8
            r10 = r9
            r13 = r12
            r15 = r14
            r35 = r21
            r14 = r24
            r19 = 0
            r25 = 1
            goto L_0x0479
        L_0x01c7:
            int r7 = r28.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r0 = r28.serialzeFeatures()
            int r10 = com.alibaba.fastjson.serializer.SerializerFeature.of(r0)
            java.lang.String r0 = r28.name()
            int r0 = r0.length()
            if (r0 == 0) goto L_0x0226
            java.lang.String r0 = r28.name()
            if (r14 == 0) goto L_0x01ec
            java.lang.Object r0 = r14.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x01ec
            goto L_0x01b8
        L_0x01ec:
            r5 = r0
            setAccessible(r11, r6, r12)
            com.alibaba.fastjson.util.FieldInfo r4 = new com.alibaba.fastjson.util.FieldInfo
            r3 = 0
            r22 = 0
            r29 = 0
            r30 = 1
            r0 = r4
            r1 = r5
            r2 = r6
            r6 = 1
            r31 = r4
            r4 = r42
            r32 = r5
            r19 = 0
            r5 = r22
            r25 = 1
            r6 = r7
            r33 = r24
            r7 = r10
            r10 = r8
            r8 = r28
            r34 = r9
            r9 = r29
            r12 = r10
            r35 = r21
            r10 = r30
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r1 = r31
            r0 = r32
            r9 = r34
            r9.put(r0, r1)
            goto L_0x0254
        L_0x0226:
            r12 = r8
            r35 = r21
            r33 = r24
            r19 = 0
            r25 = 1
            goto L_0x023b
        L_0x0230:
            r12 = r8
            r35 = r21
            r33 = r24
            r19 = 0
            r25 = 1
            r7 = 0
            r10 = 0
        L_0x023b:
            boolean r0 = r5.startsWith(r4)
            r8 = 102(0x66, float:1.43E-43)
            r4 = 95
            if (r0 == 0) goto L_0x0365
            int r0 = r5.length()
            r1 = 4
            if (r0 < r1) goto L_0x035a
            java.lang.String r0 = "getClass"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x025c
        L_0x0254:
            r13 = r43
            r10 = r9
            r37 = r12
            r15 = r14
            goto L_0x0361
        L_0x025c:
            r3 = 3
            char r0 = r5.charAt(r3)
            boolean r2 = java.lang.Character.isUpperCase(r0)
            if (r2 == 0) goto L_0x0290
            boolean r0 = compatibleWithJavaBean
            if (r0 == 0) goto L_0x0274
        L_0x026b:
            java.lang.String r0 = r5.substring(r3)
            java.lang.String r0 = decapitalize(r0)
            goto L_0x02b0
        L_0x0274:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            char r2 = r5.charAt(r3)
            char r2 = java.lang.Character.toLowerCase(r2)
            r0.append(r2)
            java.lang.String r1 = r5.substring(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x02b0
        L_0x0290:
            if (r0 != r4) goto L_0x0297
            java.lang.String r0 = r5.substring(r1)
            goto L_0x02b0
        L_0x0297:
            if (r0 != r8) goto L_0x029e
            java.lang.String r0 = r5.substring(r3)
            goto L_0x02b0
        L_0x029e:
            int r0 = r5.length()
            r2 = 5
            if (r0 < r2) goto L_0x035a
            char r0 = r5.charAt(r1)
            boolean r0 = java.lang.Character.isUpperCase(r0)
            if (r0 == 0) goto L_0x035a
            goto L_0x026b
        L_0x02b0:
            boolean r1 = isJSONTypeIgnore(r11, r13, r0)
            if (r1 == 0) goto L_0x02b7
            goto L_0x0254
        L_0x02b7:
            r2 = r33
            java.lang.reflect.Field r1 = getField(r11, r0, r2, r12)
            if (r1 == 0) goto L_0x0300
            if (r48 == 0) goto L_0x02ca
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r3 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r3 = r1.getAnnotation(r3)
            com.alibaba.fastjson.annotation.JSONField r3 = (com.alibaba.fastjson.annotation.JSONField) r3
            goto L_0x02cc
        L_0x02ca:
            r3 = r16
        L_0x02cc:
            if (r3 == 0) goto L_0x02fa
            boolean r7 = r3.serialize()
            if (r7 != 0) goto L_0x02d5
            goto L_0x0316
        L_0x02d5:
            int r7 = r3.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r10 = r3.serialzeFeatures()
            int r10 = com.alibaba.fastjson.serializer.SerializerFeature.of(r10)
            java.lang.String r21 = r3.name()
            int r21 = r21.length()
            if (r21 == 0) goto L_0x02fa
            java.lang.String r0 = r3.name()
            if (r14 == 0) goto L_0x02fa
            java.lang.Object r0 = r14.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x02fa
            goto L_0x0316
        L_0x02fa:
            r21 = r7
            r24 = r10
            r10 = r3
            goto L_0x0306
        L_0x0300:
            r21 = r7
            r24 = r10
            r10 = r16
        L_0x0306:
            if (r15 == 0) goto L_0x030c
            java.lang.String r0 = r15.translate(r0)
        L_0x030c:
            if (r14 == 0) goto L_0x031f
            java.lang.Object r0 = r14.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x031f
        L_0x0316:
            r13 = r43
            r10 = r9
            r37 = r12
            r15 = r14
            r14 = r2
            goto L_0x0479
        L_0x031f:
            r7 = r43
            r3 = r12
            r12 = r0
            setAccessible(r11, r6, r7)
            com.alibaba.fastjson.util.FieldInfo r0 = new com.alibaba.fastjson.util.FieldInfo
            r29 = 0
            r44 = r0
            r30 = r1
            r1 = r12
            r36 = r2
            r2 = r6
            r37 = r3
            r22 = 3
            r3 = r30
            r15 = 95
            r4 = r42
            r15 = r5
            r5 = r29
            r38 = r6
            r6 = r21
            r7 = r24
            r8 = r28
            r39 = r9
            r9 = r10
            r14 = 3
            r10 = r49
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r9 = r39
            r9.put(r12, r0)
            r7 = r21
            r10 = r24
            goto L_0x036d
        L_0x035a:
            r13 = r43
            r15 = r46
            r10 = r9
            r37 = r12
        L_0x0361:
            r14 = r33
            goto L_0x0479
        L_0x0365:
            r15 = r5
            r38 = r6
            r37 = r12
            r36 = r33
            r14 = 3
        L_0x036d:
            java.lang.String r0 = "is"
            boolean r0 = r15.startsWith(r0)
            if (r0 == 0) goto L_0x037b
            int r0 = r15.length()
            if (r0 >= r14) goto L_0x0384
        L_0x037b:
            r13 = r43
            r15 = r46
            r10 = r9
            r14 = r36
            goto L_0x0479
        L_0x0384:
            r0 = 2
            char r1 = r15.charAt(r0)
            boolean r2 = java.lang.Character.isUpperCase(r1)
            if (r2 == 0) goto L_0x03b8
            boolean r1 = compatibleWithJavaBean
            if (r1 == 0) goto L_0x039c
            java.lang.String r0 = r15.substring(r0)
            java.lang.String r0 = decapitalize(r0)
            goto L_0x03c9
        L_0x039c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            char r0 = r15.charAt(r0)
            char r0 = java.lang.Character.toLowerCase(r0)
            r1.append(r0)
            java.lang.String r0 = r15.substring(r14)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x03c9
        L_0x03b8:
            r2 = 95
            if (r1 != r2) goto L_0x03c1
            java.lang.String r0 = r15.substring(r14)
            goto L_0x03c9
        L_0x03c1:
            r2 = 102(0x66, float:1.43E-43)
            if (r1 != r2) goto L_0x037b
            java.lang.String r0 = r15.substring(r0)
        L_0x03c9:
            boolean r1 = isJSONTypeIgnore(r11, r13, r0)
            if (r1 == 0) goto L_0x03d0
            goto L_0x037b
        L_0x03d0:
            r14 = r36
            r12 = r37
            java.lang.reflect.Field r1 = getField(r11, r0, r14, r12)
            if (r1 != 0) goto L_0x03de
            java.lang.reflect.Field r1 = getField(r11, r15, r14, r12)
        L_0x03de:
            r3 = r1
            if (r3 == 0) goto L_0x0432
            if (r48 == 0) goto L_0x03ec
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r1 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r1 = r3.getAnnotation(r1)
            com.alibaba.fastjson.annotation.JSONField r1 = (com.alibaba.fastjson.annotation.JSONField) r1
            goto L_0x03ee
        L_0x03ec:
            r1 = r16
        L_0x03ee:
            if (r1 == 0) goto L_0x042a
            boolean r2 = r1.serialize()
            if (r2 != 0) goto L_0x03fb
            r13 = r43
            r15 = r46
            goto L_0x044c
        L_0x03fb:
            int r2 = r1.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r4 = r1.serialzeFeatures()
            int r4 = com.alibaba.fastjson.serializer.SerializerFeature.of(r4)
            java.lang.String r5 = r1.name()
            int r5 = r5.length()
            if (r5 == 0) goto L_0x0422
            java.lang.String r0 = r1.name()
            r15 = r46
            if (r15 == 0) goto L_0x0424
            java.lang.Object r0 = r15.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0424
            goto L_0x044a
        L_0x0422:
            r15 = r46
        L_0x0424:
            r8 = r50
            r10 = r1
            r6 = r2
            r7 = r4
            goto L_0x043a
        L_0x042a:
            r15 = r46
            r8 = r50
            r6 = r7
            r7 = r10
            r10 = r1
            goto L_0x043a
        L_0x0432:
            r15 = r46
            r8 = r50
            r6 = r7
            r7 = r10
            r10 = r16
        L_0x043a:
            if (r8 == 0) goto L_0x0440
            java.lang.String r0 = r8.translate(r0)
        L_0x0440:
            if (r15 == 0) goto L_0x0450
            java.lang.Object r0 = r15.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0450
        L_0x044a:
            r13 = r43
        L_0x044c:
            r10 = r9
            r37 = r12
            goto L_0x0479
        L_0x0450:
            r4 = r43
            r5 = r0
            setAccessible(r11, r3, r4)
            r2 = r38
            setAccessible(r11, r2, r4)
            com.alibaba.fastjson.util.FieldInfo r1 = new com.alibaba.fastjson.util.FieldInfo
            r21 = 0
            r0 = r1
            r37 = r12
            r12 = r1
            r1 = r5
            r13 = r4
            r4 = r42
            r11 = r5
            r5 = r21
            r8 = r28
            r40 = r9
            r9 = r10
            r10 = r49
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r10 = r40
            r10.put(r11, r12)
        L_0x0479:
            r11 = r42
            r9 = r10
            r12 = r13
            r7 = r14
            r14 = r15
            r0 = r18
            r1 = r23
            r2 = r26
            r3 = r27
            r10 = r35
            r8 = r37
            r13 = r45
            r15 = r50
            goto L_0x0088
        L_0x0491:
            r35 = r10
            r13 = r12
            r15 = r14
            r19 = 0
            r25 = 1
            r14 = r7
            r10 = r9
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r14.length
            r0.<init>(r1)
            int r1 = r14.length
            r5 = 0
        L_0x04a3:
            if (r5 >= r1) goto L_0x04cb
            r2 = r14[r5]
            int r3 = r2.getModifiers()
            r3 = r3 & 8
            if (r3 == 0) goto L_0x04b0
            goto L_0x04c8
        L_0x04b0:
            java.lang.String r3 = r2.getName()
            java.lang.String r4 = "this$0"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x04bd
            goto L_0x04c8
        L_0x04bd:
            int r3 = r2.getModifiers()
            r3 = r3 & 1
            if (r3 == 0) goto L_0x04c8
            r0.add(r2)
        L_0x04c8:
            int r5 = r5 + 1
            goto L_0x04a3
        L_0x04cb:
            java.lang.Class r1 = r42.getSuperclass()
        L_0x04cf:
            if (r1 == 0) goto L_0x04fd
            r2 = r35
            if (r1 == r2) goto L_0x04fd
            java.lang.reflect.Field[] r3 = r1.getDeclaredFields()
            int r4 = r3.length
            r5 = 0
        L_0x04db:
            if (r5 >= r4) goto L_0x04f6
            r6 = r3[r5]
            int r7 = r6.getModifiers()
            r7 = r7 & 8
            if (r7 == 0) goto L_0x04e8
            goto L_0x04f3
        L_0x04e8:
            int r7 = r6.getModifiers()
            r7 = r7 & 1
            if (r7 == 0) goto L_0x04f3
            r0.add(r6)
        L_0x04f3:
            int r5 = r5 + 1
            goto L_0x04db
        L_0x04f6:
            java.lang.Class r1 = r1.getSuperclass()
            r35 = r2
            goto L_0x04cf
        L_0x04fd:
            java.util.Iterator r11 = r0.iterator()
        L_0x0501:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x058e
            java.lang.Object r0 = r11.next()
            r3 = r0
            java.lang.reflect.Field r3 = (java.lang.reflect.Field) r3
            if (r48 == 0) goto L_0x051a
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r0 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r0 = r3.getAnnotation(r0)
            com.alibaba.fastjson.annotation.JSONField r0 = (com.alibaba.fastjson.annotation.JSONField) r0
            r9 = r0
            goto L_0x051c
        L_0x051a:
            r9 = r16
        L_0x051c:
            java.lang.String r0 = r3.getName()
            if (r9 == 0) goto L_0x0546
            boolean r1 = r9.serialize()
            if (r1 != 0) goto L_0x0529
            goto L_0x0501
        L_0x0529:
            int r1 = r9.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r2 = r9.serialzeFeatures()
            int r2 = com.alibaba.fastjson.serializer.SerializerFeature.of(r2)
            java.lang.String r4 = r9.name()
            int r4 = r4.length()
            if (r4 == 0) goto L_0x0543
            java.lang.String r0 = r9.name()
        L_0x0543:
            r6 = r1
            r7 = r2
            goto L_0x0548
        L_0x0546:
            r6 = 0
            r7 = 0
        L_0x0548:
            if (r15 == 0) goto L_0x0553
            java.lang.Object r0 = r15.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0553
            goto L_0x0501
        L_0x0553:
            r12 = r50
            if (r12 == 0) goto L_0x055b
            java.lang.String r0 = r12.translate(r0)
        L_0x055b:
            r14 = r0
            boolean r0 = r10.containsKey(r14)
            if (r0 != 0) goto L_0x0586
            r8 = r42
            setAccessible(r8, r3, r13)
            com.alibaba.fastjson.util.FieldInfo r5 = new com.alibaba.fastjson.util.FieldInfo
            r2 = 0
            r17 = 0
            r18 = 0
            r0 = r5
            r1 = r14
            r4 = r42
            r41 = r5
            r5 = r17
            r8 = r18
            r44 = r11
            r11 = r10
            r10 = r49
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = r41
            r11.put(r14, r0)
            goto L_0x0589
        L_0x0586:
            r44 = r11
            r11 = r10
        L_0x0589:
            r10 = r11
            r11 = r44
            goto L_0x0501
        L_0x058e:
            r11 = r10
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r45 == 0) goto L_0x05b7
            java.lang.String[] r1 = r45.orders()
            if (r1 == 0) goto L_0x05b9
            int r2 = r1.length
            int r3 = r11.size()
            if (r2 != r3) goto L_0x05b9
            int r2 = r1.length
            r5 = 0
        L_0x05a5:
            if (r5 >= r2) goto L_0x05b4
            r3 = r1[r5]
            boolean r3 = r11.containsKey(r3)
            if (r3 != 0) goto L_0x05b1
            r6 = 0
            goto L_0x05b5
        L_0x05b1:
            int r5 = r5 + 1
            goto L_0x05a5
        L_0x05b4:
            r6 = 1
        L_0x05b5:
            r5 = r6
            goto L_0x05ba
        L_0x05b7:
            r1 = r16
        L_0x05b9:
            r5 = 0
        L_0x05ba:
            if (r5 == 0) goto L_0x05ce
            int r2 = r1.length
            r5 = 0
        L_0x05be:
            if (r5 >= r2) goto L_0x05eb
            r3 = r1[r5]
            java.lang.Object r3 = r11.get(r3)
            com.alibaba.fastjson.util.FieldInfo r3 = (com.alibaba.fastjson.util.FieldInfo) r3
            r0.add(r3)
            int r5 = r5 + 1
            goto L_0x05be
        L_0x05ce:
            java.util.Collection r1 = r11.values()
            java.util.Iterator r1 = r1.iterator()
        L_0x05d6:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x05e6
            java.lang.Object r2 = r1.next()
            com.alibaba.fastjson.util.FieldInfo r2 = (com.alibaba.fastjson.util.FieldInfo) r2
            r0.add(r2)
            goto L_0x05d6
        L_0x05e6:
            if (r47 == 0) goto L_0x05eb
            java.util.Collections.sort(r0)
        L_0x05eb:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.computeGetters(java.lang.Class, int, boolean, com.alibaba.fastjson.annotation.JSONType, java.util.Map, boolean, boolean, boolean, com.alibaba.fastjson.PropertyNamingStrategy):java.util.List");
    }

    public static String decapitalize(String str) {
        if (str == null || str.length() == 0 || (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0)))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    public static Object defaultValue(Class<?> cls) {
        if (cls == Byte.TYPE) {
            return (byte) 0;
        }
        if (cls == Short.TYPE) {
            return (short) 0;
        }
        if (cls == Integer.TYPE) {
            return 0;
        }
        if (cls == Long.TYPE) {
            return 0L;
        }
        return cls == Float.TYPE ? Float.valueOf(0.0f) : cls == Double.TYPE ? Double.valueOf(0.0d) : cls == Boolean.TYPE ? Boolean.FALSE : cls == Character.TYPE ? '0' : null;
    }

    public static long fnv_64_lower(String str) {
        long j = -3750763034362895579L;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!(charAt == '_' || charAt == '-')) {
                if (charAt >= 'A' && charAt <= 'Z') {
                    charAt = (char) (charAt + ' ');
                }
                j = (j ^ ((long) charAt)) * 1099511628211L;
            }
        }
        return j;
    }

    public static boolean getArgument(Type[] typeArr, TypeVariable[] typeVariableArr, Type[] typeArr2) {
        if (typeArr2 == null || typeVariableArr.length == 0) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < typeArr.length; i++) {
            ParameterizedType parameterizedType = typeArr[i];
            if (parameterizedType instanceof ParameterizedType) {
                ParameterizedType parameterizedType2 = parameterizedType;
                Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
                if (getArgument(actualTypeArguments, typeVariableArr, typeArr2)) {
                    typeArr[i] = new ParameterizedTypeImpl(actualTypeArguments, parameterizedType2.getOwnerType(), parameterizedType2.getRawType());
                    z = true;
                }
            } else if (parameterizedType instanceof TypeVariable) {
                for (int i2 = 0; i2 < typeVariableArr.length; i2++) {
                    if (parameterizedType.equals(typeVariableArr[i2])) {
                        typeArr[i] = typeArr2[i2];
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public static Class<?> getClass(Type type) {
        if (type.getClass() == Class.class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return getClass(((ParameterizedType) type).getRawType());
        }
        if (type instanceof TypeVariable) {
            return (Class) ((TypeVariable) type).getBounds()[0];
        }
        if (!(type instanceof WildcardType)) {
            return Object.class;
        }
        Type[] upperBounds = ((WildcardType) type).getUpperBounds();
        return upperBounds.length == 1 ? getClass(upperBounds[0]) : Object.class;
    }

    public static Class<?> getClassFromMapping(String str) {
        return (Class) mappings.get(str);
    }

    public static Type getCollectionItemType(Type type) {
        Type type2;
        if (type instanceof ParameterizedType) {
            type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof WildcardType) {
                Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
                if (upperBounds.length == 1) {
                    type2 = upperBounds[0];
                }
            }
        } else {
            if (type instanceof Class) {
                Class cls = (Class) type;
                if (!cls.getName().startsWith("java.")) {
                    type2 = getCollectionItemType(cls.getGenericSuperclass());
                }
            }
            type2 = null;
        }
        return type2 == null ? Object.class : type2;
    }

    public static Field getField(Class<?> cls, String str, Field[] fieldArr) {
        return getField(cls, str, fieldArr, (Map<Class<?>, Field[]>) null);
    }

    public static Field getField(Class<?> cls, String str, Field[] fieldArr, Map<Class<?>, Field[]> map) {
        Field field0 = getField0(cls, str, fieldArr, map);
        if (field0 == null) {
            field0 = getField0(cls, a.k("_", str), fieldArr, map);
        }
        if (field0 == null) {
            field0 = getField0(cls, a.k("m_", str), fieldArr, map);
        }
        if (field0 != null) {
            return field0;
        }
        StringBuilder n = a.n(PaintCompat.EM_STRING);
        n.append(str.substring(0, 1).toUpperCase());
        n.append(str.substring(1));
        return getField0(cls, n.toString(), fieldArr, map);
    }

    public static Field getField0(Class<?> cls, String str, Field[] fieldArr, Map<Class<?>, Field[]> map) {
        char charAt;
        char charAt2;
        for (Field field : fieldArr) {
            String name = field.getName();
            if (str.equals(name)) {
                return field;
            }
            if (str.length() > 2 && (charAt = str.charAt(0)) >= 'a' && charAt <= 'z' && (charAt2 = str.charAt(1)) >= 'A' && charAt2 <= 'Z' && str.equalsIgnoreCase(name)) {
                return field;
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        Field[] fieldArr2 = null;
        if (superclass == null || superclass == Object.class) {
            return null;
        }
        if (map != null) {
            fieldArr2 = map.get(superclass);
        }
        if (fieldArr2 == null) {
            fieldArr2 = superclass.getDeclaredFields();
            if (map != null) {
                map.put(superclass, fieldArr2);
            }
        }
        return getField(superclass, str, fieldArr2, map);
    }

    public static Type getGenericParamType(Type type) {
        return type instanceof Class ? getGenericParamType(((Class) type).getGenericSuperclass()) : type;
    }

    public static String[] getKoltinConstructorParameters(Class cls) {
        if (kotlin_kclass_constructor == null && !kotlin_class_klass_error) {
            try {
                Class<?> cls2 = Class.forName("kotlin.reflect.jvm.internal.KClassImpl");
                kotlin_kclass_constructor = cls2.getConstructor(new Class[]{Class.class});
                kotlin_kclass_getConstructors = cls2.getMethod("getConstructors", new Class[0]);
                kotlin_kfunction_getParameters = Class.forName("kotlin.reflect.KFunction").getMethod("getParameters", new Class[0]);
                kotlin_kparameter_getName = Class.forName("kotlin.reflect.KParameter").getMethod("getName", new Class[0]);
            } catch (Throwable unused) {
                kotlin_class_klass_error = true;
            }
        }
        if (kotlin_kclass_constructor == null || kotlin_error) {
            return null;
        }
        try {
            Iterator it = ((Iterable) kotlin_kclass_getConstructors.invoke(kotlin_kclass_constructor.newInstance(new Object[]{cls}), new Object[0])).iterator();
            Object obj = null;
            while (it.hasNext()) {
                Object next = it.next();
                List list = (List) kotlin_kfunction_getParameters.invoke(next, new Object[0]);
                if (obj == null || list.size() != 0) {
                    obj = next;
                }
                it.hasNext();
            }
            List list2 = (List) kotlin_kfunction_getParameters.invoke(obj, new Object[0]);
            String[] strArr = new String[list2.size()];
            for (int i = 0; i < list2.size(); i++) {
                strArr[i] = (String) kotlin_kparameter_getName.invoke(list2.get(i), new Object[0]);
            }
            return strArr;
        } catch (Throwable unused2) {
            kotlin_error = true;
            return null;
        }
    }

    public static JSONField getSupperMethodAnnotation(Class<?> cls, Method method) {
        boolean z;
        JSONField jSONField;
        boolean z2;
        JSONField jSONField2;
        for (Class methods : cls.getInterfaces()) {
            for (Method method2 : methods.getMethods()) {
                if (method2.getName().equals(method.getName())) {
                    Class[] parameterTypes = method2.getParameterTypes();
                    Class[] parameterTypes2 = method.getParameterTypes();
                    if (parameterTypes.length != parameterTypes2.length) {
                        continue;
                    } else {
                        int i = 0;
                        while (true) {
                            if (i >= parameterTypes.length) {
                                z2 = true;
                                break;
                            } else if (!parameterTypes[i].equals(parameterTypes2[i])) {
                                z2 = false;
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (z2 && (jSONField2 = (JSONField) method2.getAnnotation(JSONField.class)) != null) {
                            return jSONField2;
                        }
                    }
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && Modifier.isAbstract(superclass.getModifiers())) {
            Class[] parameterTypes3 = method.getParameterTypes();
            for (Method method3 : superclass.getMethods()) {
                Class[] parameterTypes4 = method3.getParameterTypes();
                if (parameterTypes4.length == parameterTypes3.length && method3.getName().equals(method.getName())) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= parameterTypes3.length) {
                            z = true;
                            break;
                        } else if (!parameterTypes4[i2].equals(parameterTypes3[i2])) {
                            z = false;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (z && (jSONField = (JSONField) method3.getAnnotation(JSONField.class)) != null) {
                        return jSONField;
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000b, code lost:
        r3 = ((java.lang.Class) r3).getGenericSuperclass();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isGenericParamType(java.lang.reflect.Type r3) {
        /*
            boolean r0 = r3 instanceof java.lang.reflect.ParameterizedType
            r1 = 1
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r0 = r3 instanceof java.lang.Class
            r2 = 0
            if (r0 == 0) goto L_0x001e
            java.lang.Class r3 = (java.lang.Class) r3
            java.lang.reflect.Type r3 = r3.getGenericSuperclass()
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            if (r3 == r0) goto L_0x001c
            boolean r3 = isGenericParamType(r3)
            if (r3 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r1 = 0
        L_0x001d:
            return r1
        L_0x001e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.isGenericParamType(java.lang.reflect.Type):boolean");
    }

    public static boolean isJSONTypeIgnore(Class<?> cls, JSONType jSONType, String str) {
        if (!(jSONType == null || jSONType.ignores() == null)) {
            for (String equalsIgnoreCase : jSONType.ignores()) {
                if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                    return true;
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        return (superclass == Object.class || superclass == null || !isJSONTypeIgnore(superclass, (JSONType) superclass.getAnnotation(JSONType.class), str)) ? false : true;
    }

    public static boolean isKotlin(Class cls) {
        if (kotlin_metadata == null && !kotlin_metadata_error) {
            try {
                kotlin_metadata = Class.forName("kotlin.Metadata");
            } catch (Throwable unused) {
                kotlin_metadata_error = true;
            }
        }
        if (kotlin_metadata == null) {
            return false;
        }
        return cls.isAnnotationPresent(kotlin_metadata);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0069, code lost:
        r8 = kotlinIgnores.get(r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isKotlinIgnore(java.lang.Class r8, java.lang.String r9) {
        /*
            java.lang.String r0 = "isEmpty"
            java.lang.String r1 = "getEndInclusive"
            java.util.Map<java.lang.Class, java.lang.String[]> r2 = kotlinIgnores
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L_0x0064
            boolean r2 = kotlinIgnores_error
            if (r2 != 0) goto L_0x0064
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0062 }
            r2.<init>()     // Catch:{ all -> 0x0062 }
            java.lang.String r5 = "kotlin.ranges.CharRange"
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x0062 }
            r6 = 2
            java.lang.String[] r7 = new java.lang.String[r6]     // Catch:{ all -> 0x0062 }
            r7[r4] = r1     // Catch:{ all -> 0x0062 }
            r7[r3] = r0     // Catch:{ all -> 0x0062 }
            r2.put(r5, r7)     // Catch:{ all -> 0x0062 }
            java.lang.String r5 = "kotlin.ranges.IntRange"
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x0062 }
            java.lang.String[] r7 = new java.lang.String[r6]     // Catch:{ all -> 0x0062 }
            r7[r4] = r1     // Catch:{ all -> 0x0062 }
            r7[r3] = r0     // Catch:{ all -> 0x0062 }
            r2.put(r5, r7)     // Catch:{ all -> 0x0062 }
            java.lang.String r5 = "kotlin.ranges.LongRange"
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x0062 }
            java.lang.String[] r7 = new java.lang.String[r6]     // Catch:{ all -> 0x0062 }
            r7[r4] = r1     // Catch:{ all -> 0x0062 }
            r7[r3] = r0     // Catch:{ all -> 0x0062 }
            r2.put(r5, r7)     // Catch:{ all -> 0x0062 }
            java.lang.String r5 = "kotlin.ranges.ClosedFloatRange"
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x0062 }
            java.lang.String[] r7 = new java.lang.String[r6]     // Catch:{ all -> 0x0062 }
            r7[r4] = r1     // Catch:{ all -> 0x0062 }
            r7[r3] = r0     // Catch:{ all -> 0x0062 }
            r2.put(r5, r7)     // Catch:{ all -> 0x0062 }
            java.lang.String r5 = "kotlin.ranges.ClosedDoubleRange"
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x0062 }
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ all -> 0x0062 }
            r6[r4] = r1     // Catch:{ all -> 0x0062 }
            r6[r3] = r0     // Catch:{ all -> 0x0062 }
            r2.put(r5, r6)     // Catch:{ all -> 0x0062 }
            kotlinIgnores = r2     // Catch:{ all -> 0x0062 }
            goto L_0x0064
        L_0x0062:
            kotlinIgnores_error = r3
        L_0x0064:
            java.util.Map<java.lang.Class, java.lang.String[]> r0 = kotlinIgnores
            if (r0 != 0) goto L_0x0069
            return r4
        L_0x0069:
            java.util.Map<java.lang.Class, java.lang.String[]> r0 = kotlinIgnores
            java.lang.Object r8 = r0.get(r8)
            java.lang.String[] r8 = (java.lang.String[]) r8
            if (r8 != 0) goto L_0x0074
            return r4
        L_0x0074:
            int r8 = java.util.Arrays.binarySearch(r8, r9)
            if (r8 < 0) goto L_0x007b
            goto L_0x007c
        L_0x007b:
            r3 = 0
        L_0x007c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.isKotlinIgnore(java.lang.Class, java.lang.String):boolean");
    }

    public static Class<?> loadClass(String str, ClassLoader classLoader) {
        return loadClass(str, classLoader, true);
    }

    public static Class<?> loadClass(String str, ClassLoader classLoader, boolean z) {
        Exception e2;
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.length() < 256) {
            Class<?> cls = (Class) mappings.get(str);
            if (cls != null) {
                return cls;
            }
            if (str.charAt(0) == '[') {
                return Array.newInstance(loadClass(str.substring(1), classLoader), 0).getClass();
            }
            if (str.startsWith("L") && str.endsWith(";")) {
                return loadClass(str.substring(1, str.length() - 1), classLoader);
            }
            if (classLoader != null) {
                try {
                    Class<?> loadClass = classLoader.loadClass(str);
                    if (z) {
                        mappings.put(str, loadClass);
                    }
                    return loadClass;
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            try {
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                if (!(contextClassLoader == null || contextClassLoader == classLoader)) {
                    Class<?> loadClass2 = contextClassLoader.loadClass(str);
                    if (z) {
                        try {
                            mappings.put(str, loadClass2);
                        } catch (Exception e4) {
                            e2 = e4;
                            cls = loadClass2;
                        }
                    }
                    return loadClass2;
                }
            } catch (Exception e5) {
                e2 = e5;
                e2.printStackTrace();
                cls = Class.forName(str);
                mappings.put(str, cls);
                return cls;
            }
            try {
                cls = Class.forName(str);
                mappings.put(str, cls);
                return cls;
            } catch (Exception e6) {
                e6.printStackTrace();
                return cls;
            }
        } else {
            throw new JSONException(a.k("className too long. ", str));
        }
    }

    public static boolean setAccessible(Class<?> cls, Member member, int i) {
        if (member != null && setAccessibleEnable) {
            Class<? super Object> superclass = cls.getSuperclass();
            if ((superclass == null || superclass == Object.class) && (member.getModifiers() & 1) != 0 && (i & 1) != 0) {
                return false;
            }
            try {
                ((AccessibleObject) member).setAccessible(true);
                return true;
            } catch (AccessControlException unused) {
                setAccessibleEnable = false;
            }
        }
        return false;
    }
}
