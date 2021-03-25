package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.annotation.JSONField;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public class FieldInfo implements Comparable<FieldInfo> {
    public final String[] alternateNames;
    public final Class<?> declaringClass;
    public final Field field;
    public final boolean fieldAccess;
    public final JSONField fieldAnnotation;
    public final Class<?> fieldClass;
    public final boolean fieldTransient;
    public final Type fieldType;
    public final String format;
    public final boolean getOnly;
    public final boolean isEnum;
    public final Method method;
    public final JSONField methodAnnotation;
    public final String name;
    public final long nameHashCode;
    public int ordinal = 0;

    public FieldInfo(String str, Class<?> cls, Class<?> cls2, Type type, Field field2, int i, int i2) {
        this.name = str;
        this.declaringClass = cls;
        this.fieldClass = cls2;
        this.fieldType = type;
        this.method = null;
        this.field = field2;
        this.ordinal = i;
        boolean z = true;
        this.isEnum = cls2.isEnum() && !JSONAware.class.isAssignableFrom(cls2);
        this.fieldAnnotation = null;
        this.methodAnnotation = null;
        if (field2 != null) {
            int modifiers = field2.getModifiers();
            if ((modifiers & 1) == 0 && this.method != null) {
                z = false;
            }
            this.fieldAccess = z;
            this.fieldTransient = Modifier.isTransient(modifiers);
        } else {
            this.fieldAccess = false;
            this.fieldTransient = false;
        }
        this.getOnly = false;
        long j = -3750763034362895579L;
        for (int i3 = 0; i3 < str.length(); i3++) {
            j = (j ^ ((long) str.charAt(i3))) * 1099511628211L;
        }
        this.nameHashCode = j;
        this.format = null;
        this.alternateNames = new String[0];
    }

    /* JADX WARNING: type inference failed for: r21v0, types: [java.lang.reflect.Type] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FieldInfo(java.lang.String r17, java.lang.reflect.Method r18, java.lang.reflect.Field r19, java.lang.Class<?> r20, java.lang.reflect.Type r21, int r22, int r23, com.alibaba.fastjson.annotation.JSONField r24, com.alibaba.fastjson.annotation.JSONField r25, boolean r26) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r21
            java.lang.Class<com.alibaba.fastjson.JSONAware> r6 = com.alibaba.fastjson.JSONAware.class
            java.lang.Class<java.lang.Object> r7 = java.lang.Object.class
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            r16.<init>()
            r9 = 0
            r0.ordinal = r9
            r0.name = r1
            r0.method = r2
            r0.field = r3
            r10 = r22
            r0.ordinal = r10
            r10 = r24
            r0.methodAnnotation = r10
            r10 = r25
            r0.fieldAnnotation = r10
            com.alibaba.fastjson.annotation.JSONField r10 = r16.getAnnotation()
            r11 = 0
            if (r10 == 0) goto L_0x0047
            java.lang.String r12 = r10.format()
            java.lang.String r13 = r12.trim()
            int r13 = r13.length()
            if (r13 != 0) goto L_0x0040
            r12 = r11
        L_0x0040:
            java.lang.String[] r10 = r10.alternateNames()
            r0.alternateNames = r10
            goto L_0x004c
        L_0x0047:
            java.lang.String[] r10 = new java.lang.String[r9]
            r0.alternateNames = r10
            r12 = r11
        L_0x004c:
            r0.format = r12
            if (r3 == 0) goto L_0x0074
            int r12 = r19.getModifiers()
            if (r2 == 0) goto L_0x0067
            r13 = r12 & 1
            if (r13 == 0) goto L_0x0065
            java.lang.Class r13 = r18.getReturnType()
            java.lang.Class r14 = r19.getType()
            if (r13 != r14) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r13 = 0
            goto L_0x0068
        L_0x0067:
            r13 = 1
        L_0x0068:
            r0.fieldAccess = r13
            r12 = r12 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x0070
            r12 = 1
            goto L_0x0071
        L_0x0070:
            r12 = 0
        L_0x0071:
            r0.fieldTransient = r12
            goto L_0x0078
        L_0x0074:
            r0.fieldAccess = r9
            r0.fieldTransient = r9
        L_0x0078:
            r12 = -3750763034362895579(0xcbf29ce484222325, double:-7.302176725335867E57)
            r14 = 0
        L_0x007e:
            int r15 = r17.length()
            if (r14 >= r15) goto L_0x0095
            char r15 = r1.charAt(r14)
            long r9 = (long) r15
            long r9 = r9 ^ r12
            r12 = 1099511628211(0x100000001b3, double:5.43230922702E-312)
            long r12 = r12 * r9
            int r14 = r14 + 1
            r9 = 0
            goto L_0x007e
        L_0x0095:
            r0.nameHashCode = r12
            if (r2 == 0) goto L_0x00db
            java.lang.Class[] r1 = r18.getParameterTypes()
            int r3 = r1.length
            r9 = 1
            if (r3 != r9) goto L_0x00bf
            r9 = 0
            r1 = r1[r9]
            java.lang.Class<java.lang.Class> r3 = java.lang.Class.class
            if (r1 == r3) goto L_0x00ba
            if (r1 == r8) goto L_0x00ba
            boolean r3 = r1.isPrimitive()
            if (r3 == 0) goto L_0x00b1
            goto L_0x00ba
        L_0x00b1:
            if (r26 == 0) goto L_0x00ba
            java.lang.reflect.Type[] r3 = r18.getGenericParameterTypes()
            r3 = r3[r9]
            goto L_0x00bb
        L_0x00ba:
            r3 = r1
        L_0x00bb:
            r0.getOnly = r9
            r10 = 1
            goto L_0x00d4
        L_0x00bf:
            r9 = 0
            java.lang.Class r1 = r18.getReturnType()
            java.lang.Class<java.lang.Class> r3 = java.lang.Class.class
            if (r1 != r3) goto L_0x00cb
        L_0x00c8:
            r3 = r1
        L_0x00c9:
            r10 = 1
            goto L_0x00d2
        L_0x00cb:
            if (r26 == 0) goto L_0x00c8
            java.lang.reflect.Type r3 = r18.getGenericReturnType()
            goto L_0x00c9
        L_0x00d2:
            r0.getOnly = r10
        L_0x00d4:
            java.lang.Class r2 = r18.getDeclaringClass()
            r0.declaringClass = r2
            goto L_0x0109
        L_0x00db:
            r9 = 0
            r10 = 1
            java.lang.Class r1 = r19.getType()
            boolean r2 = r1.isPrimitive()
            if (r2 != 0) goto L_0x00f7
            if (r1 == r8) goto L_0x00f7
            boolean r2 = r1.isEnum()
            if (r2 == 0) goto L_0x00f0
            goto L_0x00f7
        L_0x00f0:
            if (r26 == 0) goto L_0x00f7
            java.lang.reflect.Type r2 = r19.getGenericType()
            goto L_0x00f8
        L_0x00f7:
            r2 = r1
        L_0x00f8:
            java.lang.Class r8 = r19.getDeclaringClass()
            r0.declaringClass = r8
            int r3 = r19.getModifiers()
            boolean r3 = java.lang.reflect.Modifier.isFinal(r3)
            r0.getOnly = r3
            r3 = r2
        L_0x0109:
            if (r4 == 0) goto L_0x0179
            if (r1 != r7) goto L_0x0179
            boolean r2 = r3 instanceof java.lang.reflect.TypeVariable
            if (r2 == 0) goto L_0x0179
            r2 = r3
            java.lang.reflect.TypeVariable r2 = (java.lang.reflect.TypeVariable) r2
            boolean r8 = r5 instanceof java.lang.reflect.ParameterizedType
            if (r8 == 0) goto L_0x0120
            r8 = r5
            java.lang.reflect.ParameterizedType r8 = (java.lang.reflect.ParameterizedType) r8
            java.lang.reflect.Type[] r8 = r8.getActualTypeArguments()
            goto L_0x0121
        L_0x0120:
            r8 = r11
        L_0x0121:
            r12 = r4
        L_0x0122:
            if (r12 == 0) goto L_0x0145
            if (r12 == r7) goto L_0x0145
            java.lang.Class<?> r13 = r0.declaringClass
            if (r12 == r13) goto L_0x0145
            java.lang.reflect.Type r13 = r12.getGenericSuperclass()
            boolean r14 = r13 instanceof java.lang.reflect.ParameterizedType
            if (r14 == 0) goto L_0x0140
            java.lang.reflect.ParameterizedType r13 = (java.lang.reflect.ParameterizedType) r13
            java.lang.reflect.Type[] r13 = r13.getActualTypeArguments()
            java.lang.reflect.TypeVariable[] r14 = r12.getTypeParameters()
            com.alibaba.fastjson.util.TypeUtils.getArgument(r13, r14, r8)
            r8 = r13
        L_0x0140:
            java.lang.Class r12 = r12.getSuperclass()
            goto L_0x0122
        L_0x0145:
            if (r8 == 0) goto L_0x015f
            java.lang.Class<?> r7 = r0.declaringClass
            java.lang.reflect.TypeVariable[] r7 = r7.getTypeParameters()
            r12 = 0
        L_0x014e:
            int r13 = r7.length
            if (r12 >= r13) goto L_0x015f
            r13 = r7[r12]
            boolean r13 = r2.equals(r13)
            if (r13 == 0) goto L_0x015c
            r11 = r8[r12]
            goto L_0x015f
        L_0x015c:
            int r12 = r12 + 1
            goto L_0x014e
        L_0x015f:
            if (r11 == 0) goto L_0x0179
            java.lang.Class r2 = com.alibaba.fastjson.util.TypeUtils.getClass(r11)
            r0.fieldClass = r2
            r0.fieldType = r11
            boolean r2 = r1.isEnum()
            if (r2 == 0) goto L_0x0176
            boolean r1 = r6.isAssignableFrom(r1)
            if (r1 != 0) goto L_0x0176
            r9 = 1
        L_0x0176:
            r0.isEnum = r9
            return
        L_0x0179:
            boolean r2 = r3 instanceof java.lang.Class
            if (r2 != 0) goto L_0x0196
            if (r5 == 0) goto L_0x0180
            goto L_0x0181
        L_0x0180:
            r5 = r4
        L_0x0181:
            java.lang.reflect.Type r2 = getFieldType(r4, r5, r3)
            if (r2 == r3) goto L_0x0195
            boolean r3 = r2 instanceof java.lang.reflect.ParameterizedType
            if (r3 == 0) goto L_0x0190
        L_0x018b:
            java.lang.Class r1 = com.alibaba.fastjson.util.TypeUtils.getClass(r2)
            goto L_0x0195
        L_0x0190:
            boolean r3 = r2 instanceof java.lang.Class
            if (r3 == 0) goto L_0x0195
            goto L_0x018b
        L_0x0195:
            r3 = r2
        L_0x0196:
            r0.fieldType = r3
            r0.fieldClass = r1
            boolean r2 = r1.isArray()
            if (r2 != 0) goto L_0x01ad
            boolean r2 = r1.isEnum()
            if (r2 == 0) goto L_0x01ad
            boolean r1 = r6.isAssignableFrom(r1)
            if (r1 != 0) goto L_0x01ad
            r9 = 1
        L_0x01ad:
            r0.isEnum = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.FieldInfo.<init>(java.lang.String, java.lang.reflect.Method, java.lang.reflect.Field, java.lang.Class, java.lang.reflect.Type, int, int, com.alibaba.fastjson.annotation.JSONField, com.alibaba.fastjson.annotation.JSONField, boolean):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c1 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.reflect.Type getFieldType(java.lang.Class<?> r10, java.lang.reflect.Type r11, java.lang.reflect.Type r12) {
        /*
            if (r10 == 0) goto L_0x00d4
            if (r11 != 0) goto L_0x0006
            goto L_0x00d4
        L_0x0006:
            boolean r0 = r12 instanceof java.lang.reflect.GenericArrayType
            r1 = 0
            if (r0 == 0) goto L_0x0026
            r0 = r12
            java.lang.reflect.GenericArrayType r0 = (java.lang.reflect.GenericArrayType) r0
            java.lang.reflect.Type r0 = r0.getGenericComponentType()
            java.lang.reflect.Type r10 = getFieldType(r10, r11, r0)
            if (r0 == r10) goto L_0x0025
            java.lang.Class r10 = com.alibaba.fastjson.util.TypeUtils.getClass(r10)
            java.lang.Object r10 = java.lang.reflect.Array.newInstance(r10, r1)
            java.lang.Class r10 = r10.getClass()
            return r10
        L_0x0025:
            return r12
        L_0x0026:
            boolean r0 = com.alibaba.fastjson.util.TypeUtils.isGenericParamType(r11)
            if (r0 != 0) goto L_0x002d
            return r12
        L_0x002d:
            boolean r0 = r12 instanceof java.lang.reflect.TypeVariable
            if (r0 == 0) goto L_0x0064
            java.lang.reflect.Type r0 = com.alibaba.fastjson.util.TypeUtils.getGenericParamType(r11)
            java.lang.reflect.ParameterizedType r0 = (java.lang.reflect.ParameterizedType) r0
            java.lang.Class r2 = com.alibaba.fastjson.util.TypeUtils.getClass(r0)
            r3 = r12
            java.lang.reflect.TypeVariable r3 = (java.lang.reflect.TypeVariable) r3
            r4 = 0
        L_0x003f:
            java.lang.reflect.TypeVariable[] r5 = r2.getTypeParameters()
            int r5 = r5.length
            if (r4 >= r5) goto L_0x0064
            java.lang.reflect.TypeVariable[] r5 = r2.getTypeParameters()
            r5 = r5[r4]
            java.lang.String r5 = r5.getName()
            java.lang.String r6 = r3.getName()
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0061
            java.lang.reflect.Type[] r10 = r0.getActualTypeArguments()
            r10 = r10[r4]
            return r10
        L_0x0061:
            int r4 = r4 + 1
            goto L_0x003f
        L_0x0064:
            boolean r0 = r12 instanceof java.lang.reflect.ParameterizedType
            if (r0 == 0) goto L_0x00d4
            r0 = r12
            java.lang.reflect.ParameterizedType r0 = (java.lang.reflect.ParameterizedType) r0
            java.lang.reflect.Type[] r2 = r0.getActualTypeArguments()
            boolean r3 = r11 instanceof java.lang.reflect.ParameterizedType
            r4 = 0
            if (r3 == 0) goto L_0x007b
            java.lang.reflect.ParameterizedType r11 = (java.lang.reflect.ParameterizedType) r11
        L_0x0076:
            java.lang.reflect.TypeVariable[] r10 = r10.getTypeParameters()
            goto L_0x0090
        L_0x007b:
            java.lang.reflect.Type r11 = r10.getGenericSuperclass()
            boolean r11 = r11 instanceof java.lang.reflect.ParameterizedType
            if (r11 == 0) goto L_0x008e
            java.lang.reflect.Type r11 = r10.getGenericSuperclass()
            java.lang.reflect.ParameterizedType r11 = (java.lang.reflect.ParameterizedType) r11
            java.lang.Class r10 = r10.getSuperclass()
            goto L_0x0076
        L_0x008e:
            r10 = r4
            r11 = r10
        L_0x0090:
            r3 = 0
            r5 = 0
        L_0x0092:
            int r6 = r2.length
            if (r3 >= r6) goto L_0x00c4
            if (r11 == 0) goto L_0x00c4
            r6 = r2[r3]
            boolean r7 = r6 instanceof java.lang.reflect.TypeVariable
            if (r7 == 0) goto L_0x00c1
            java.lang.reflect.TypeVariable r6 = (java.lang.reflect.TypeVariable) r6
            r7 = 0
        L_0x00a0:
            int r8 = r10.length
            if (r7 >= r8) goto L_0x00c1
            r8 = r10[r7]
            java.lang.String r8 = r8.getName()
            java.lang.String r9 = r6.getName()
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x00be
            if (r4 != 0) goto L_0x00b9
            java.lang.reflect.Type[] r4 = r11.getActualTypeArguments()
        L_0x00b9:
            r5 = r4[r7]
            r2[r3] = r5
            r5 = 1
        L_0x00be:
            int r7 = r7 + 1
            goto L_0x00a0
        L_0x00c1:
            int r3 = r3 + 1
            goto L_0x0092
        L_0x00c4:
            if (r5 == 0) goto L_0x00d4
            com.alibaba.fastjson.util.ParameterizedTypeImpl r10 = new com.alibaba.fastjson.util.ParameterizedTypeImpl
            java.lang.reflect.Type r11 = r0.getOwnerType()
            java.lang.reflect.Type r12 = r0.getRawType()
            r10.<init>(r2, r11, r12)
            return r10
        L_0x00d4:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.FieldInfo.getFieldType(java.lang.Class, java.lang.reflect.Type, java.lang.reflect.Type):java.lang.reflect.Type");
    }

    public int compareTo(FieldInfo fieldInfo) {
        int i = this.ordinal;
        int i2 = fieldInfo.ordinal;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        return this.name.compareTo(fieldInfo.name);
    }

    public boolean equals(FieldInfo fieldInfo) {
        return fieldInfo == this || compareTo(fieldInfo) == 0;
    }

    public Object get(Object obj) {
        return this.fieldAccess ? this.field.get(obj) : this.method.invoke(obj, new Object[0]);
    }

    public JSONField getAnnotation() {
        JSONField jSONField = this.fieldAnnotation;
        return jSONField != null ? jSONField : this.methodAnnotation;
    }

    public void set(Object obj, Object obj2) {
        Method method2 = this.method;
        if (method2 != null) {
            method2.invoke(obj, new Object[]{obj2});
            return;
        }
        this.field.set(obj, obj2);
    }

    public String toString() {
        return this.name;
    }
}
