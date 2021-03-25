package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class JavaBeanInfo {
    public final Constructor<?> creatorConstructor;
    public final String[] creatorConstructorParameters;
    public final Constructor<?> defaultConstructor;
    public final int defaultConstructorParameterSize;
    public final Method factoryMethod;
    public final FieldInfo[] fields;
    public final JSONType jsonType;
    public boolean ordered = false;
    public final int parserFeatures;
    public final FieldInfo[] sortedFields;
    public final boolean supportBeanToArray;
    public final String typeKey;
    public final String typeName;

    public JavaBeanInfo(Class<?> cls, Constructor<?> constructor, Constructor<?> constructor2, Method method, FieldInfo[] fieldInfoArr, FieldInfo[] fieldInfoArr2, JSONType jSONType, String[] strArr) {
        int i;
        boolean z;
        int i2 = 0;
        this.defaultConstructor = constructor;
        this.creatorConstructor = constructor2;
        this.factoryMethod = method;
        this.fields = fieldInfoArr;
        this.jsonType = jSONType;
        String str = null;
        if (strArr == null || strArr.length != fieldInfoArr.length) {
            this.creatorConstructorParameters = strArr;
        } else {
            this.creatorConstructorParameters = null;
        }
        if (jSONType != null) {
            String typeName2 = jSONType.typeName();
            this.typeName = typeName2.length() <= 0 ? cls.getName() : typeName2;
            String typeKey2 = jSONType.typeKey();
            this.typeKey = typeKey2.length() > 0 ? typeKey2 : str;
            i = 0;
            for (Feature feature : jSONType.parseFeatures()) {
                i |= feature.mask;
            }
        } else {
            this.typeName = cls.getName();
            this.typeKey = null;
            i = 0;
        }
        this.parserFeatures = i;
        if (jSONType != null) {
            z = false;
            for (Feature feature2 : jSONType.parseFeatures()) {
                if (feature2 == Feature.SupportArrayToBean) {
                    z = true;
                }
            }
        } else {
            z = false;
        }
        this.supportBeanToArray = z;
        FieldInfo[] computeSortedFields = computeSortedFields(fieldInfoArr, fieldInfoArr2);
        this.sortedFields = !Arrays.equals(fieldInfoArr, computeSortedFields) ? computeSortedFields : fieldInfoArr;
        if (constructor != null) {
            i2 = constructor.getParameterTypes().length;
        } else if (method != null) {
            i2 = method.getParameterTypes().length;
        }
        this.defaultConstructorParameterSize = i2;
    }

    public static boolean addField(List<FieldInfo> list, FieldInfo fieldInfo, boolean z) {
        if (!z) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                FieldInfo fieldInfo2 = list.get(i);
                if (fieldInfo2.name.equals(fieldInfo.name) && (!fieldInfo2.getOnly || fieldInfo.getOnly)) {
                    return false;
                }
            }
        }
        list.add(fieldInfo);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: java.lang.Class<? super java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Class<? super java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Class<? super java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: java.lang.Class<? super ? super java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v56, resolved type: java.lang.Class<? super java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v57, resolved type: java.lang.Class<? super java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v60, resolved type: java.lang.Class<? super ? super java.lang.Object>} */
    /* JADX WARNING: type inference failed for: r1v55, types: [java.lang.annotation.Annotation] */
    /* JADX WARNING: type inference failed for: r0v71, types: [java.lang.reflect.Type[]] */
    /* JADX WARNING: type inference failed for: r0v86, types: [java.lang.reflect.Type[]] */
    /* JADX WARNING: type inference failed for: r0v102, types: [java.lang.reflect.Type[]] */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x0529, code lost:
        if (java.lang.Character.isUpperCase(r1.charAt(4)) != false) goto L_0x04df;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0561  */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x05c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.alibaba.fastjson.parser.JavaBeanInfo build(java.lang.Class<?> r35, int r36, java.lang.reflect.Type r37, boolean r38, boolean r39, boolean r40, boolean r41, com.alibaba.fastjson.PropertyNamingStrategy r42) {
        /*
            r11 = r35
            r12 = r36
            r13 = r38
            r14 = r42
            java.lang.Class<java.lang.Object> r15 = java.lang.Object.class
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            java.lang.reflect.Constructor[] r0 = r35.getDeclaredConstructors()
            boolean r1 = com.alibaba.fastjson.util.TypeUtils.isKotlin(r35)
            r2 = r12 & 1024(0x400, float:1.435E-42)
            r16 = 0
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L_0x0067
            int r5 = r0.length
            if (r5 == r3) goto L_0x0029
            if (r1 != 0) goto L_0x0067
        L_0x0029:
            java.lang.Class[] r4 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x0030 }
            java.lang.reflect.Constructor r4 = r11.getDeclaredConstructor(r4)     // Catch:{ Exception -> 0x0030 }
            goto L_0x0032
        L_0x0030:
            r4 = r16
        L_0x0032:
            if (r4 != 0) goto L_0x0062
            boolean r5 = r35.isMemberClass()
            if (r5 == 0) goto L_0x0062
            r5 = r12 & 8
            if (r5 != 0) goto L_0x0062
            int r5 = r0.length
            r6 = 0
        L_0x0040:
            if (r6 >= r5) goto L_0x0062
            r7 = r0[r6]
            java.lang.Class[] r8 = r7.getParameterTypes()
            r17 = r4
            int r4 = r8.length
            r18 = 0
            if (r4 != r3) goto L_0x005d
            r4 = r8[r18]
            java.lang.Class r8 = r35.getDeclaringClass()
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x005d
            r8 = r7
            goto L_0x0069
        L_0x005d:
            int r6 = r6 + 1
            r4 = r17
            goto L_0x0040
        L_0x0062:
            r17 = r4
            r8 = r17
            goto L_0x0069
        L_0x0067:
            r8 = r16
        L_0x0069:
            r17 = 0
            if (r13 == 0) goto L_0x0074
            r18 = r15
            r7 = r16
            r15 = r7
            goto L_0x00e2
        L_0x0074:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r4 = r11
            r5 = r16
        L_0x007c:
            if (r4 == 0) goto L_0x00d5
            if (r4 == r15) goto L_0x00d5
            java.lang.reflect.Method[] r6 = r4.getDeclaredMethods()
            int r7 = r6.length
            r18 = 0
            r18 = r15
            r15 = 0
        L_0x008a:
            if (r15 >= r7) goto L_0x00cc
            r19 = r7
            r7 = r6[r15]
            r20 = r6
            int r6 = r7.getModifiers()
            r21 = r6 & 8
            if (r21 == 0) goto L_0x00ae
            java.lang.Class<com.alibaba.fastjson.annotation.JSONCreator> r6 = com.alibaba.fastjson.annotation.JSONCreator.class
            boolean r6 = r7.isAnnotationPresent(r6)
            if (r6 == 0) goto L_0x00c1
            if (r5 != 0) goto L_0x00a6
            r5 = r7
            goto L_0x00c5
        L_0x00a6:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.String r1 = "multi-json creator"
            r0.<init>(r1)
            throw r0
        L_0x00ae:
            r21 = r6 & 2
            if (r21 != 0) goto L_0x00c1
            r21 = r5
            r5 = r6 & 256(0x100, float:3.59E-43)
            if (r5 != 0) goto L_0x00c3
            r5 = r6 & 4
            if (r5 == 0) goto L_0x00bd
            goto L_0x00c3
        L_0x00bd:
            r3.add(r7)
            goto L_0x00c3
        L_0x00c1:
            r21 = r5
        L_0x00c3:
            r5 = r21
        L_0x00c5:
            int r15 = r15 + 1
            r7 = r19
            r6 = r20
            goto L_0x008a
        L_0x00cc:
            r21 = r5
            java.lang.Class r4 = r4.getSuperclass()
            r15 = r18
            goto L_0x007c
        L_0x00d5:
            r18 = r15
            int r4 = r3.size()
            java.lang.reflect.Method[] r4 = new java.lang.reflect.Method[r4]
            r3.toArray(r4)
            r15 = r4
            r7 = r5
        L_0x00e2:
            java.lang.reflect.Field[] r6 = r35.getDeclaredFields()
            boolean r3 = r35.isInterface()
            if (r3 != 0) goto L_0x00f1
            if (r2 == 0) goto L_0x00ef
            goto L_0x00f1
        L_0x00ef:
            r2 = 0
            goto L_0x00f2
        L_0x00f1:
            r2 = 1
        L_0x00f2:
            if (r8 == 0) goto L_0x0102
            if (r2 == 0) goto L_0x00f7
            goto L_0x0102
        L_0x00f7:
            r14 = r6
            r25 = r7
            r21 = r8
            r27 = r15
            r20 = r16
            goto L_0x03ee
        L_0x0102:
            int r3 = r0.length
            r4 = 0
        L_0x0104:
            if (r4 >= r3) goto L_0x011a
            r5 = r0[r4]
            r19 = r3
            java.lang.Class<com.alibaba.fastjson.annotation.JSONCreator> r3 = com.alibaba.fastjson.annotation.JSONCreator.class
            java.lang.annotation.Annotation r3 = r5.getAnnotation(r3)
            com.alibaba.fastjson.annotation.JSONCreator r3 = (com.alibaba.fastjson.annotation.JSONCreator) r3
            if (r3 == 0) goto L_0x0115
            goto L_0x011c
        L_0x0115:
            int r4 = r4 + 1
            r3 = r19
            goto L_0x0104
        L_0x011a:
            r5 = r16
        L_0x011c:
            java.lang.String r4 = "illegal json creator"
            if (r5 == 0) goto L_0x01f8
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r11, r5, r12)
            java.lang.Class[] r3 = r5.getParameterTypes()
            if (r41 == 0) goto L_0x0130
            java.lang.reflect.Type[] r0 = r5.getGenericParameterTypes()
            r17 = r0
            goto L_0x0132
        L_0x0130:
            r17 = r3
        L_0x0132:
            java.lang.annotation.Annotation[][] r19 = r5.getParameterAnnotations()
            r0 = 0
            r2 = 0
        L_0x0138:
            int r0 = r3.length
            if (r2 >= r0) goto L_0x01bd
            r0 = r19[r2]
            int r1 = r0.length
            r20 = 0
            r21 = r4
            r4 = 0
        L_0x0143:
            if (r4 >= r1) goto L_0x0159
            r20 = r1
            r1 = r0[r4]
            r22 = r0
            boolean r0 = r1 instanceof com.alibaba.fastjson.annotation.JSONField
            if (r0 == 0) goto L_0x0152
            com.alibaba.fastjson.annotation.JSONField r1 = (com.alibaba.fastjson.annotation.JSONField) r1
            goto L_0x015b
        L_0x0152:
            int r4 = r4 + 1
            r1 = r20
            r0 = r22
            goto L_0x0143
        L_0x0159:
            r1 = r16
        L_0x015b:
            if (r1 == 0) goto L_0x01b5
            r4 = r3[r2]
            r20 = r17[r2]
            java.lang.String r0 = r1.name()
            java.lang.reflect.Field r0 = com.alibaba.fastjson.util.TypeUtils.getField(r11, r0, r6, r9)
            if (r0 == 0) goto L_0x016e
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r11, r0, r12)
        L_0x016e:
            int r22 = r1.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r23 = r1.serialzeFeatures()
            int r23 = com.alibaba.fastjson.serializer.SerializerFeature.of(r23)
            com.alibaba.fastjson.util.FieldInfo r14 = new com.alibaba.fastjson.util.FieldInfo
            java.lang.String r1 = r1.name()
            r24 = r0
            r0 = r14
            r25 = r2
            r2 = r35
            r26 = r3
            r3 = r4
            r27 = r15
            r15 = r21
            r4 = r20
            r20 = r5
            r5 = r24
            r21 = r8
            r8 = r6
            r6 = r22
            r22 = r8
            r8 = r7
            r7 = r23
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            addField(r10, r14, r13)
            int r2 = r25 + 1
            r14 = r42
            r7 = r8
            r4 = r15
            r5 = r20
            r8 = r21
            r6 = r22
            r3 = r26
            r15 = r27
            goto L_0x0138
        L_0x01b5:
            r15 = r21
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            r0.<init>(r15)
            throw r0
        L_0x01bd:
            r20 = r5
            r22 = r6
            r21 = r8
            r27 = r15
            r8 = r7
            r0 = 0
            int r1 = r10.size()
            com.alibaba.fastjson.util.FieldInfo[] r2 = new com.alibaba.fastjson.util.FieldInfo[r1]
            r10.toArray(r2)
            com.alibaba.fastjson.util.FieldInfo[] r3 = new com.alibaba.fastjson.util.FieldInfo[r1]
            java.lang.System.arraycopy(r2, r0, r3, r0, r1)
            java.util.Arrays.sort(r3)
            if (r39 == 0) goto L_0x01e2
            java.lang.Class<com.alibaba.fastjson.annotation.JSONType> r0 = com.alibaba.fastjson.annotation.JSONType.class
            java.lang.annotation.Annotation r0 = r11.getAnnotation(r0)
            com.alibaba.fastjson.annotation.JSONType r0 = (com.alibaba.fastjson.annotation.JSONType) r0
        L_0x01e2:
            java.lang.String[] r0 = new java.lang.String[r1]
            r3 = 0
        L_0x01e5:
            if (r3 >= r1) goto L_0x01f0
            r4 = r2[r3]
            java.lang.String r4 = r4.name
            r0[r3] = r4
            int r3 = r3 + 1
            goto L_0x01e5
        L_0x01f0:
            r17 = r0
            r25 = r8
            r14 = r22
            goto L_0x03ee
        L_0x01f8:
            r20 = r5
            r22 = r6
            r21 = r8
            r27 = r15
            r15 = r4
            r8 = r7
            if (r8 == 0) goto L_0x02ba
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r11, r8, r12)
            java.lang.Class[] r14 = r8.getParameterTypes()
            int r0 = r14.length
            if (r0 <= 0) goto L_0x02b6
            if (r41 == 0) goto L_0x0216
            java.lang.reflect.Type[] r0 = r8.getGenericParameterTypes()
            r12 = r0
            goto L_0x0217
        L_0x0216:
            r12 = r14
        L_0x0217:
            java.lang.annotation.Annotation[][] r18 = r8.getParameterAnnotations()
            r0 = 0
            r7 = 0
        L_0x021d:
            int r0 = r14.length
            if (r7 >= r0) goto L_0x027f
            r0 = r18[r7]
            int r1 = r0.length
            r2 = 0
        L_0x0224:
            if (r2 >= r1) goto L_0x0232
            r3 = r0[r2]
            boolean r4 = r3 instanceof com.alibaba.fastjson.annotation.JSONField
            if (r4 == 0) goto L_0x022f
            com.alibaba.fastjson.annotation.JSONField r3 = (com.alibaba.fastjson.annotation.JSONField) r3
            goto L_0x0234
        L_0x022f:
            int r2 = r2 + 1
            goto L_0x0224
        L_0x0232:
            r3 = r16
        L_0x0234:
            if (r3 == 0) goto L_0x0279
            r4 = r14[r7]
            r5 = r12[r7]
            java.lang.String r0 = r3.name()
            r6 = r22
            java.lang.reflect.Field r19 = com.alibaba.fastjson.util.TypeUtils.getField(r11, r0, r6, r9)
            int r20 = r3.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r0 = r3.serialzeFeatures()
            int r21 = com.alibaba.fastjson.serializer.SerializerFeature.of(r0)
            com.alibaba.fastjson.util.FieldInfo r2 = new com.alibaba.fastjson.util.FieldInfo
            java.lang.String r1 = r3.name()
            r0 = r2
            r3 = r2
            r2 = r35
            r36 = r12
            r12 = r3
            r3 = r4
            r4 = r5
            r5 = r19
            r19 = r14
            r14 = r6
            r6 = r20
            r20 = r7
            r7 = r21
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            addField(r10, r12, r13)
            int r7 = r20 + 1
            r12 = r36
            r22 = r14
            r14 = r19
            goto L_0x021d
        L_0x0279:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            r0.<init>(r15)
            throw r0
        L_0x027f:
            int r0 = r10.size()
            com.alibaba.fastjson.util.FieldInfo[] r5 = new com.alibaba.fastjson.util.FieldInfo[r0]
            r10.toArray(r5)
            com.alibaba.fastjson.util.FieldInfo[] r1 = new com.alibaba.fastjson.util.FieldInfo[r0]
            r2 = 0
            java.lang.System.arraycopy(r5, r2, r1, r2, r0)
            java.util.Arrays.sort(r1)
            boolean r0 = java.util.Arrays.equals(r5, r1)
            if (r0 == 0) goto L_0x0299
            r6 = r5
            goto L_0x029a
        L_0x0299:
            r6 = r1
        L_0x029a:
            if (r39 == 0) goto L_0x02a6
            java.lang.Class<com.alibaba.fastjson.annotation.JSONType> r0 = com.alibaba.fastjson.annotation.JSONType.class
            java.lang.annotation.Annotation r0 = r11.getAnnotation(r0)
            com.alibaba.fastjson.annotation.JSONType r0 = (com.alibaba.fastjson.annotation.JSONType) r0
            r7 = r0
            goto L_0x02a8
        L_0x02a6:
            r7 = r16
        L_0x02a8:
            com.alibaba.fastjson.parser.JavaBeanInfo r9 = new com.alibaba.fastjson.parser.JavaBeanInfo
            r2 = 0
            r3 = 0
            r0 = r9
            r1 = r35
            r4 = r8
            r8 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        L_0x02b6:
            r14 = r22
            goto L_0x03e8
        L_0x02ba:
            r14 = r22
            if (r2 != 0) goto L_0x03e8
            java.lang.String r2 = "default constructor not found. "
            if (r1 == 0) goto L_0x03d3
            int r1 = r0.length
            if (r1 <= 0) goto L_0x03d3
            java.lang.String[] r15 = com.alibaba.fastjson.util.TypeUtils.getKoltinConstructorParameters(r35)
            if (r15 == 0) goto L_0x03be
            int r1 = r0.length
            r2 = 0
            r7 = r20
        L_0x02cf:
            if (r2 >= r1) goto L_0x02fb
            r3 = r0[r2]
            java.lang.Class[] r4 = r3.getParameterTypes()
            int r5 = r4.length
            if (r5 <= 0) goto L_0x02ec
            int r5 = r4.length
            int r5 = r5 + -1
            r5 = r4[r5]
            java.lang.String r5 = r5.getName()
            java.lang.String r6 = "kotlin.jvm.internal.DefaultConstructorMarker"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x02ec
            goto L_0x02f8
        L_0x02ec:
            if (r7 == 0) goto L_0x02f7
            java.lang.Class[] r5 = r7.getParameterTypes()
            int r5 = r5.length
            int r4 = r4.length
            if (r5 < r4) goto L_0x02f7
            goto L_0x02f8
        L_0x02f7:
            r7 = r3
        L_0x02f8:
            int r2 = r2 + 1
            goto L_0x02cf
        L_0x02fb:
            r0 = 1
            r7.setAccessible(r0)
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r11, r7, r12)
            java.lang.Class[] r6 = r7.getParameterTypes()
            if (r41 == 0) goto L_0x030f
            java.lang.reflect.Type[] r0 = r7.getGenericParameterTypes()
            r17 = r0
            goto L_0x0311
        L_0x030f:
            r17 = r6
        L_0x0311:
            java.lang.annotation.Annotation[][] r19 = r7.getParameterAnnotations()
            r0 = 0
            r5 = 0
        L_0x0317:
            int r0 = r6.length
            if (r5 >= r0) goto L_0x0396
            r0 = r15[r5]
            r1 = r19[r5]
            int r2 = r1.length
            r3 = 0
        L_0x0320:
            if (r3 >= r2) goto L_0x0332
            r4 = r1[r3]
            r20 = r1
            boolean r1 = r4 instanceof com.alibaba.fastjson.annotation.JSONField
            if (r1 == 0) goto L_0x032d
            com.alibaba.fastjson.annotation.JSONField r4 = (com.alibaba.fastjson.annotation.JSONField) r4
            goto L_0x0334
        L_0x032d:
            int r3 = r3 + 1
            r1 = r20
            goto L_0x0320
        L_0x0332:
            r4 = r16
        L_0x0334:
            r3 = r6[r5]
            r20 = r17[r5]
            java.lang.reflect.Field r2 = com.alibaba.fastjson.util.TypeUtils.getField(r11, r0, r14, r9)
            if (r2 == 0) goto L_0x0349
            if (r4 != 0) goto L_0x0349
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r1 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r1 = r2.getAnnotation(r1)
            r4 = r1
            com.alibaba.fastjson.annotation.JSONField r4 = (com.alibaba.fastjson.annotation.JSONField) r4
        L_0x0349:
            if (r4 == 0) goto L_0x0368
            int r1 = r4.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r22 = r4.serialzeFeatures()
            int r22 = com.alibaba.fastjson.serializer.SerializerFeature.of(r22)
            java.lang.String r4 = r4.name()
            int r23 = r4.length()
            if (r23 == 0) goto L_0x0362
            r0 = r4
        L_0x0362:
            r23 = r22
            r22 = r1
            r1 = r0
            goto L_0x036f
        L_0x0368:
            r1 = 0
            r4 = 0
            r1 = r0
            r22 = 0
            r23 = 0
        L_0x036f:
            com.alibaba.fastjson.util.FieldInfo r4 = new com.alibaba.fastjson.util.FieldInfo
            r0 = r4
            r24 = r2
            r2 = r35
            r25 = r8
            r8 = r4
            r4 = r20
            r20 = r5
            r5 = r24
            r24 = r6
            r6 = r22
            r22 = r7
            r7 = r23
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            addField(r10, r8, r13)
            int r5 = r20 + 1
            r7 = r22
            r6 = r24
            r8 = r25
            goto L_0x0317
        L_0x0396:
            r22 = r7
            r25 = r8
            int r0 = r10.size()
            com.alibaba.fastjson.util.FieldInfo[] r1 = new com.alibaba.fastjson.util.FieldInfo[r0]
            r10.toArray(r1)
            com.alibaba.fastjson.util.FieldInfo[] r2 = new com.alibaba.fastjson.util.FieldInfo[r0]
            r3 = 0
            java.lang.System.arraycopy(r1, r3, r2, r3, r0)
            java.util.Arrays.sort(r2)
            java.lang.String[] r2 = new java.lang.String[r0]
        L_0x03ae:
            if (r3 >= r0) goto L_0x03b9
            r4 = r1[r3]
            java.lang.String r4 = r4.name
            r2[r3] = r4
            int r3 = r3 + 1
            goto L_0x03ae
        L_0x03b9:
            r17 = r2
            r5 = r22
            goto L_0x03ec
        L_0x03be:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            r1.append(r11)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x03d3:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            r1.append(r11)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x03e8:
            r25 = r8
            r5 = r20
        L_0x03ec:
            r20 = r5
        L_0x03ee:
            r8 = r21
            if (r21 == 0) goto L_0x03f5
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r11, r8, r12)
        L_0x03f5:
            r0 = 4
            if (r13 != 0) goto L_0x0603
            r15 = r27
            int r7 = r15.length
            r1 = 0
            r6 = 0
        L_0x03fd:
            if (r6 >= r7) goto L_0x05f9
            r5 = r15[r6]
            java.lang.String r1 = r5.getName()
            int r2 = r1.length()
            if (r2 >= r0) goto L_0x040c
            goto L_0x0442
        L_0x040c:
            java.lang.Class r0 = r5.getReturnType()
            java.lang.Class r2 = java.lang.Void.TYPE
            if (r0 == r2) goto L_0x041a
            java.lang.Class r2 = r5.getDeclaringClass()
            if (r0 != r2) goto L_0x0442
        L_0x041a:
            java.lang.Class[] r0 = r5.getParameterTypes()
            int r0 = r0.length
            r2 = 1
            if (r0 == r2) goto L_0x0423
            goto L_0x0442
        L_0x0423:
            if (r40 == 0) goto L_0x042e
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r0 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r0 = r5.getAnnotation(r0)
            com.alibaba.fastjson.annotation.JSONField r0 = (com.alibaba.fastjson.annotation.JSONField) r0
            goto L_0x0430
        L_0x042e:
            r0 = r16
        L_0x0430:
            if (r0 != 0) goto L_0x0438
            if (r40 == 0) goto L_0x0438
            com.alibaba.fastjson.annotation.JSONField r0 = com.alibaba.fastjson.util.TypeUtils.getSupperMethodAnnotation(r11, r5)
        L_0x0438:
            r19 = r0
            if (r19 == 0) goto L_0x04b0
            boolean r0 = r19.deserialize()
            if (r0 != 0) goto L_0x0453
        L_0x0442:
            r24 = r6
            r26 = r7
            r29 = r9
            r30 = r14
            r23 = r15
            r27 = r25
            r25 = r8
            r15 = r10
            goto L_0x05e7
        L_0x0453:
            int r21 = r19.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r0 = r19.serialzeFeatures()
            int r22 = com.alibaba.fastjson.serializer.SerializerFeature.of(r0)
            java.lang.String r0 = r19.name()
            int r0 = r0.length()
            if (r0 == 0) goto L_0x04a1
            java.lang.String r1 = r19.name()
            com.alibaba.fastjson.util.FieldInfo r4 = new com.alibaba.fastjson.util.FieldInfo
            r3 = 0
            r23 = 0
            r0 = r4
            r2 = r5
            r28 = r4
            r4 = r35
            r29 = r5
            r5 = r37
            r24 = r6
            r6 = r21
            r26 = r7
            r7 = r22
            r27 = r25
            r25 = r8
            r8 = r19
            r30 = r9
            r9 = r23
            r23 = r15
            r15 = r10
            r10 = r41
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = r28
            addField(r15, r0, r13)
            r10 = r29
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r11, r10, r12)
            goto L_0x04ca
        L_0x04a1:
            r24 = r6
            r26 = r7
            r30 = r9
            r23 = r15
            r27 = r25
            r25 = r8
            r15 = r10
            r10 = r5
            goto L_0x04c2
        L_0x04b0:
            r24 = r6
            r26 = r7
            r30 = r9
            r23 = r15
            r27 = r25
            r25 = r8
            r15 = r10
            r10 = r5
            r21 = 0
            r22 = 0
        L_0x04c2:
            java.lang.String r0 = "set"
            boolean r0 = r1.startsWith(r0)
            if (r0 != 0) goto L_0x04d0
        L_0x04ca:
            r29 = r30
            r30 = r14
            goto L_0x05e7
        L_0x04d0:
            r0 = 3
            char r2 = r1.charAt(r0)
            boolean r3 = java.lang.Character.isUpperCase(r2)
            if (r3 == 0) goto L_0x0507
            boolean r2 = com.alibaba.fastjson.util.TypeUtils.compatibleWithJavaBean
            if (r2 == 0) goto L_0x04ea
        L_0x04df:
            java.lang.String r0 = r1.substring(r0)
            java.lang.String r0 = com.alibaba.fastjson.util.TypeUtils.decapitalize(r0)
        L_0x04e7:
            r9 = r30
            goto L_0x052c
        L_0x04ea:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            char r0 = r1.charAt(r0)
            char r0 = java.lang.Character.toLowerCase(r0)
            r2.append(r0)
            r0 = 4
            java.lang.String r0 = r1.substring(r0)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            goto L_0x04e7
        L_0x0507:
            r3 = 4
            r4 = 95
            if (r2 != r4) goto L_0x0511
            java.lang.String r0 = r1.substring(r3)
            goto L_0x04e7
        L_0x0511:
            r4 = 102(0x66, float:1.43E-43)
            if (r2 != r4) goto L_0x051a
            java.lang.String r0 = r1.substring(r0)
            goto L_0x04e7
        L_0x051a:
            int r2 = r1.length()
            r4 = 5
            if (r2 < r4) goto L_0x04ca
            char r2 = r1.charAt(r3)
            boolean r2 = java.lang.Character.isUpperCase(r2)
            if (r2 == 0) goto L_0x04ca
            goto L_0x04df
        L_0x052c:
            java.lang.reflect.Field r1 = com.alibaba.fastjson.util.TypeUtils.getField(r11, r0, r14, r9)
            if (r1 != 0) goto L_0x055e
            java.lang.Class[] r2 = r10.getParameterTypes()
            r3 = 0
            r2 = r2[r3]
            java.lang.Class r4 = java.lang.Boolean.TYPE
            if (r2 != r4) goto L_0x055e
            java.lang.String r1 = "is"
            java.lang.StringBuilder r1 = a.a.a.a.a.n(r1)
            char r2 = r0.charAt(r3)
            char r2 = java.lang.Character.toUpperCase(r2)
            r1.append(r2)
            r2 = 1
            java.lang.String r2 = r0.substring(r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.reflect.Field r1 = com.alibaba.fastjson.util.TypeUtils.getField(r11, r1, r14, r9)
        L_0x055e:
            r3 = r1
            if (r3 == 0) goto L_0x05b7
            if (r40 == 0) goto L_0x056e
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r1 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r1 = r3.getAnnotation(r1)
            com.alibaba.fastjson.annotation.JSONField r1 = (com.alibaba.fastjson.annotation.JSONField) r1
            r28 = r1
            goto L_0x0570
        L_0x056e:
            r28 = r16
        L_0x0570:
            if (r28 == 0) goto L_0x05b7
            int r6 = r28.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r1 = r28.serialzeFeatures()
            int r7 = com.alibaba.fastjson.serializer.SerializerFeature.of(r1)
            java.lang.String r1 = r28.name()
            int r1 = r1.length()
            if (r1 == 0) goto L_0x05a7
            java.lang.String r1 = r28.name()
            com.alibaba.fastjson.util.FieldInfo r8 = new com.alibaba.fastjson.util.FieldInfo
            r0 = r8
            r2 = r10
            r4 = r35
            r5 = r37
            r10 = r8
            r8 = r19
            r29 = r9
            r9 = r28
            r30 = r14
            r14 = r10
            r10 = r41
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            addField(r15, r14, r13)
            goto L_0x05e7
        L_0x05a7:
            r29 = r9
            r30 = r14
            if (r19 != 0) goto L_0x05b2
            r14 = r42
            r8 = r28
            goto L_0x05c3
        L_0x05b2:
            r21 = r6
            r22 = r7
            goto L_0x05bb
        L_0x05b7:
            r29 = r9
            r30 = r14
        L_0x05bb:
            r14 = r42
            r8 = r19
            r6 = r21
            r7 = r22
        L_0x05c3:
            if (r14 == 0) goto L_0x05c9
            java.lang.String r0 = r14.translate(r0)
        L_0x05c9:
            r1 = r0
            com.alibaba.fastjson.util.FieldInfo r9 = new com.alibaba.fastjson.util.FieldInfo
            r3 = 0
            r19 = 0
            r0 = r9
            r2 = r10
            r4 = r35
            r5 = r37
            r31 = r9
            r9 = r19
            r14 = r10
            r10 = r41
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = r31
            addField(r15, r0, r13)
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r11, r14, r12)
        L_0x05e7:
            int r6 = r24 + 1
            r0 = 4
            r10 = r15
            r15 = r23
            r8 = r25
            r7 = r26
            r25 = r27
            r9 = r29
            r14 = r30
            goto L_0x03fd
        L_0x05f9:
            r30 = r14
            r23 = r15
            r27 = r25
            r25 = r8
            r15 = r10
            goto L_0x060c
        L_0x0603:
            r15 = r10
            r30 = r14
            r23 = r27
            r27 = r25
            r25 = r8
        L_0x060c:
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = r30
            int r2 = r1.length
            r0.<init>(r2)
            int r2 = r1.length
            r3 = 0
        L_0x0616:
            if (r3 >= r2) goto L_0x0650
            r4 = r1[r3]
            int r5 = r4.getModifiers()
            r6 = r5 & 8
            if (r6 == 0) goto L_0x0623
            goto L_0x064d
        L_0x0623:
            r5 = r5 & 16
            if (r5 == 0) goto L_0x0642
            java.lang.Class r5 = r4.getType()
            java.lang.Class<java.util.Map> r6 = java.util.Map.class
            boolean r6 = r6.isAssignableFrom(r5)
            if (r6 != 0) goto L_0x063e
            java.lang.Class<java.util.Collection> r6 = java.util.Collection.class
            boolean r5 = r6.isAssignableFrom(r5)
            if (r5 == 0) goto L_0x063c
            goto L_0x063e
        L_0x063c:
            r5 = 0
            goto L_0x063f
        L_0x063e:
            r5 = 1
        L_0x063f:
            if (r5 != 0) goto L_0x0642
            goto L_0x064d
        L_0x0642:
            int r5 = r4.getModifiers()
            r5 = r5 & 1
            if (r5 == 0) goto L_0x064d
            r0.add(r4)
        L_0x064d:
            int r3 = r3 + 1
            goto L_0x0616
        L_0x0650:
            java.lang.Class r1 = r35.getSuperclass()
        L_0x0654:
            if (r1 == 0) goto L_0x069d
            r2 = r18
            if (r1 == r2) goto L_0x069d
            java.lang.reflect.Field[] r3 = r1.getDeclaredFields()
            int r4 = r3.length
            r5 = 0
        L_0x0660:
            if (r5 >= r4) goto L_0x0696
            r6 = r3[r5]
            int r7 = r6.getModifiers()
            r8 = r7 & 8
            if (r8 == 0) goto L_0x066d
            goto L_0x0693
        L_0x066d:
            r8 = r7 & 16
            if (r8 == 0) goto L_0x068c
            java.lang.Class r8 = r6.getType()
            java.lang.Class<java.util.Map> r9 = java.util.Map.class
            boolean r9 = r9.isAssignableFrom(r8)
            if (r9 != 0) goto L_0x0688
            java.lang.Class<java.util.Collection> r9 = java.util.Collection.class
            boolean r8 = r9.isAssignableFrom(r8)
            if (r8 == 0) goto L_0x0686
            goto L_0x0688
        L_0x0686:
            r8 = 0
            goto L_0x0689
        L_0x0688:
            r8 = 1
        L_0x0689:
            if (r8 != 0) goto L_0x068c
            goto L_0x0693
        L_0x068c:
            r7 = r7 & 1
            if (r7 == 0) goto L_0x0693
            r0.add(r6)
        L_0x0693:
            int r5 = r5 + 1
            goto L_0x0660
        L_0x0696:
            java.lang.Class r1 = r1.getSuperclass()
            r18 = r2
            goto L_0x0654
        L_0x069d:
            java.util.Iterator r14 = r0.iterator()
        L_0x06a1:
            boolean r0 = r14.hasNext()
            if (r0 == 0) goto L_0x0728
            java.lang.Object r0 = r14.next()
            r3 = r0
            java.lang.reflect.Field r3 = (java.lang.reflect.Field) r3
            java.lang.String r0 = r3.getName()
            int r1 = r15.size()
            r2 = 0
            r4 = 0
        L_0x06b8:
            if (r2 >= r1) goto L_0x06cc
            java.lang.Object r5 = r15.get(r2)
            com.alibaba.fastjson.util.FieldInfo r5 = (com.alibaba.fastjson.util.FieldInfo) r5
            java.lang.String r5 = r5.name
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x06c9
            r4 = 1
        L_0x06c9:
            int r2 = r2 + 1
            goto L_0x06b8
        L_0x06cc:
            if (r4 == 0) goto L_0x06cf
            goto L_0x06a1
        L_0x06cf:
            if (r40 == 0) goto L_0x06db
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r1 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r1 = r3.getAnnotation(r1)
            com.alibaba.fastjson.annotation.JSONField r1 = (com.alibaba.fastjson.annotation.JSONField) r1
            r9 = r1
            goto L_0x06dd
        L_0x06db:
            r9 = r16
        L_0x06dd:
            if (r9 == 0) goto L_0x06fe
            int r1 = r9.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r2 = r9.serialzeFeatures()
            int r2 = com.alibaba.fastjson.serializer.SerializerFeature.of(r2)
            java.lang.String r4 = r9.name()
            int r4 = r4.length()
            if (r4 == 0) goto L_0x06f9
            java.lang.String r0 = r9.name()
        L_0x06f9:
            r10 = r42
            r6 = r1
            r7 = r2
            goto L_0x0704
        L_0x06fe:
            r1 = 0
            r2 = 0
            r10 = r42
            r6 = 0
            r7 = 0
        L_0x0704:
            if (r10 == 0) goto L_0x070a
            java.lang.String r0 = r10.translate(r0)
        L_0x070a:
            r1 = r0
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r11, r3, r12)
            com.alibaba.fastjson.util.FieldInfo r8 = new com.alibaba.fastjson.util.FieldInfo
            r2 = 0
            r18 = 0
            r0 = r8
            r4 = r35
            r5 = r37
            r32 = r8
            r8 = r18
            r10 = r41
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = r32
            addField(r15, r0, r13)
            goto L_0x06a1
        L_0x0728:
            if (r13 != 0) goto L_0x07df
            r14 = r23
            int r10 = r14.length
            r0 = 0
            r9 = 0
        L_0x072f:
            if (r9 >= r10) goto L_0x07df
            r8 = r14[r9]
            java.lang.String r0 = r8.getName()
            int r1 = r0.length()
            r2 = 4
            if (r1 >= r2) goto L_0x0740
            goto L_0x07d5
        L_0x0740:
            java.lang.String r1 = "get"
            boolean r1 = r0.startsWith(r1)
            if (r1 == 0) goto L_0x07d5
            r1 = 3
            char r3 = r0.charAt(r1)
            boolean r3 = java.lang.Character.isUpperCase(r3)
            if (r3 == 0) goto L_0x07d5
            java.lang.Class[] r3 = r8.getParameterTypes()
            int r3 = r3.length
            if (r3 == 0) goto L_0x075c
            goto L_0x07d5
        L_0x075c:
            java.lang.Class r3 = r8.getReturnType()
            java.lang.Class<java.util.Collection> r4 = java.util.Collection.class
            boolean r4 = r4.isAssignableFrom(r3)
            if (r4 != 0) goto L_0x0770
            java.lang.Class<java.util.Map> r4 = java.util.Map.class
            boolean r3 = r4.isAssignableFrom(r3)
            if (r3 == 0) goto L_0x07d5
        L_0x0770:
            if (r40 == 0) goto L_0x077d
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r3 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r3 = r8.getAnnotation(r3)
            com.alibaba.fastjson.annotation.JSONField r3 = (com.alibaba.fastjson.annotation.JSONField) r3
            r18 = r3
            goto L_0x077f
        L_0x077d:
            r18 = r16
        L_0x077f:
            if (r18 == 0) goto L_0x078d
            java.lang.String r3 = r18.name()
            int r4 = r3.length()
            if (r4 <= 0) goto L_0x078d
            r1 = r3
            goto L_0x07a9
        L_0x078d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            char r1 = r0.charAt(r1)
            char r1 = java.lang.Character.toLowerCase(r1)
            r3.append(r1)
            java.lang.String r0 = r0.substring(r2)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r1 = r0
        L_0x07a9:
            com.alibaba.fastjson.util.FieldInfo r7 = new com.alibaba.fastjson.util.FieldInfo
            r3 = 0
            r6 = 0
            r19 = 0
            r21 = 0
            r0 = r7
            r2 = r8
            r4 = r35
            r5 = r37
            r33 = r7
            r7 = r19
            r34 = r8
            r8 = r18
            r18 = r9
            r9 = r21
            r19 = r10
            r10 = r41
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = r33
            addField(r15, r0, r13)
            r0 = r34
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r11, r0, r12)
            goto L_0x07d9
        L_0x07d5:
            r18 = r9
            r19 = r10
        L_0x07d9:
            int r9 = r18 + 1
            r10 = r19
            goto L_0x072f
        L_0x07df:
            int r0 = r15.size()
            com.alibaba.fastjson.util.FieldInfo[] r5 = new com.alibaba.fastjson.util.FieldInfo[r0]
            r15.toArray(r5)
            com.alibaba.fastjson.util.FieldInfo[] r6 = new com.alibaba.fastjson.util.FieldInfo[r0]
            r1 = 0
            java.lang.System.arraycopy(r5, r1, r6, r1, r0)
            java.util.Arrays.sort(r6)
            if (r39 == 0) goto L_0x07fd
            java.lang.Class<com.alibaba.fastjson.annotation.JSONType> r0 = com.alibaba.fastjson.annotation.JSONType.class
            java.lang.annotation.Annotation r0 = r11.getAnnotation(r0)
            com.alibaba.fastjson.annotation.JSONType r0 = (com.alibaba.fastjson.annotation.JSONType) r0
            r7 = r0
            goto L_0x07ff
        L_0x07fd:
            r7 = r16
        L_0x07ff:
            com.alibaba.fastjson.parser.JavaBeanInfo r9 = new com.alibaba.fastjson.parser.JavaBeanInfo
            r0 = r9
            r1 = r35
            r2 = r25
            r3 = r20
            r4 = r27
            r8 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JavaBeanInfo.build(java.lang.Class, int, java.lang.reflect.Type, boolean, boolean, boolean, boolean, com.alibaba.fastjson.PropertyNamingStrategy):com.alibaba.fastjson.parser.JavaBeanInfo");
    }

    private FieldInfo[] computeSortedFields(FieldInfo[] fieldInfoArr, FieldInfo[] fieldInfoArr2) {
        String[] orders;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        JSONType jSONType = this.jsonType;
        if (!(jSONType == null || (orders = jSONType.orders()) == null || orders.length == 0)) {
            int i = 0;
            while (true) {
                if (i >= orders.length) {
                    z = true;
                    break;
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= fieldInfoArr2.length) {
                        z4 = false;
                        break;
                    } else if (fieldInfoArr2[i2].name.equals(orders[i])) {
                        z4 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (!z4) {
                    z = false;
                    break;
                }
                i++;
            }
            if (!z) {
                return fieldInfoArr2;
            }
            if (orders.length == fieldInfoArr.length) {
                int i3 = 0;
                while (true) {
                    if (i3 >= orders.length) {
                        z3 = true;
                        break;
                    } else if (!fieldInfoArr2[i3].name.equals(orders[i3])) {
                        z3 = false;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (z3) {
                    return fieldInfoArr2;
                }
                FieldInfo[] fieldInfoArr3 = new FieldInfo[fieldInfoArr2.length];
                for (int i4 = 0; i4 < orders.length; i4++) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= fieldInfoArr2.length) {
                            break;
                        } else if (fieldInfoArr2[i5].name.equals(orders[i4])) {
                            fieldInfoArr3[i4] = fieldInfoArr2[i5];
                            break;
                        } else {
                            i5++;
                        }
                    }
                }
                this.ordered = true;
                return fieldInfoArr3;
            }
            int length = fieldInfoArr2.length;
            FieldInfo[] fieldInfoArr4 = new FieldInfo[length];
            for (int i6 = 0; i6 < orders.length; i6++) {
                int i7 = 0;
                while (true) {
                    if (i7 >= fieldInfoArr2.length) {
                        break;
                    } else if (fieldInfoArr2[i7].name.equals(orders[i6])) {
                        fieldInfoArr4[i6] = fieldInfoArr2[i7];
                        break;
                    } else {
                        i7++;
                    }
                }
            }
            int length2 = orders.length;
            for (int i8 = 0; i8 < fieldInfoArr2.length; i8++) {
                int i9 = 0;
                while (true) {
                    if (i9 >= length || i9 >= length2) {
                        z2 = false;
                    } else if (fieldInfoArr4[i8].equals(fieldInfoArr2[i9])) {
                        z2 = true;
                        break;
                    } else {
                        i9++;
                    }
                }
                z2 = false;
                if (!z2) {
                    fieldInfoArr4[length2] = fieldInfoArr2[i8];
                    length2++;
                }
            }
            this.ordered = true;
        }
        return fieldInfoArr2;
    }
}
