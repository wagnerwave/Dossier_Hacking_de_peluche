package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.PropertyNamingStrategy;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class JavaBeanSerializer implements ObjectSerializer {
    public static final char[] false_chars = {'f', 'a', 'l', 's', 'e'};
    public static final char[] true_chars = {'t', 'r', 'u', 'e'};
    public int features;
    public final FieldSerializer[] getters;
    public final FieldSerializer[] sortedGetters;
    public final String typeKey;
    public final String typeName;

    public JavaBeanSerializer(Class<?> cls) {
        this(cls, (PropertyNamingStrategy) null);
    }

    /* JADX WARNING: type inference failed for: r15v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A[LOOP:2: B:29:0x00a1->B:31:0x00a7, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x010f  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public JavaBeanSerializer(java.lang.Class<?> r15, int r16, java.util.Map<java.lang.String, java.lang.String> r17, boolean r18, boolean r19, boolean r20, boolean r21, com.alibaba.fastjson.PropertyNamingStrategy r22) {
        /*
            r14 = this;
            r0 = r14
            r14.<init>()
            r1 = 0
            r0.features = r1
            r2 = 0
            if (r19 == 0) goto L_0x0014
            java.lang.Class<com.alibaba.fastjson.annotation.JSONType> r3 = com.alibaba.fastjson.annotation.JSONType.class
            r13 = r15
            java.lang.annotation.Annotation r3 = r15.getAnnotation(r3)
            com.alibaba.fastjson.annotation.JSONType r3 = (com.alibaba.fastjson.annotation.JSONType) r3
            goto L_0x0016
        L_0x0014:
            r13 = r15
            r3 = r2
        L_0x0016:
            if (r3 == 0) goto L_0x007f
            com.alibaba.fastjson.serializer.SerializerFeature[] r4 = r3.serialzeFeatures()
            int r4 = com.alibaba.fastjson.serializer.SerializerFeature.of(r4)
            r0.features = r4
            java.lang.String r4 = r3.typeName()
            int r5 = r4.length()
            if (r5 != 0) goto L_0x002d
            goto L_0x007f
        L_0x002d:
            java.lang.Class r5 = r15.getSuperclass()
            r6 = r2
        L_0x0032:
            if (r5 == 0) goto L_0x0053
            java.lang.Class<java.lang.Object> r7 = java.lang.Object.class
            if (r5 == r7) goto L_0x0053
            java.lang.Class<com.alibaba.fastjson.annotation.JSONType> r7 = com.alibaba.fastjson.annotation.JSONType.class
            java.lang.annotation.Annotation r7 = r5.getAnnotation(r7)
            com.alibaba.fastjson.annotation.JSONType r7 = (com.alibaba.fastjson.annotation.JSONType) r7
            if (r7 != 0) goto L_0x0043
            goto L_0x0053
        L_0x0043:
            java.lang.String r6 = r7.typeKey()
            int r7 = r6.length()
            if (r7 == 0) goto L_0x004e
            goto L_0x0053
        L_0x004e:
            java.lang.Class r5 = r5.getSuperclass()
            goto L_0x0032
        L_0x0053:
            java.lang.Class[] r5 = r15.getInterfaces()
            int r7 = r5.length
            r8 = 0
        L_0x0059:
            if (r8 >= r7) goto L_0x0075
            r9 = r5[r8]
            java.lang.Class<com.alibaba.fastjson.annotation.JSONType> r10 = com.alibaba.fastjson.annotation.JSONType.class
            java.lang.annotation.Annotation r9 = r9.getAnnotation(r10)
            com.alibaba.fastjson.annotation.JSONType r9 = (com.alibaba.fastjson.annotation.JSONType) r9
            if (r9 == 0) goto L_0x0072
            java.lang.String r6 = r9.typeKey()
            int r9 = r6.length()
            if (r9 == 0) goto L_0x0072
            goto L_0x0075
        L_0x0072:
            int r8 = r8 + 1
            goto L_0x0059
        L_0x0075:
            if (r6 == 0) goto L_0x0081
            int r5 = r6.length()
            if (r5 != 0) goto L_0x0081
            r6 = r2
            goto L_0x0081
        L_0x007f:
            r4 = r2
            r6 = r4
        L_0x0081:
            r0.typeName = r4
            r0.typeKey = r6
            r9 = 0
            r4 = r15
            r5 = r16
            r6 = r18
            r7 = r3
            r8 = r17
            r10 = r20
            r11 = r21
            r12 = r22
            java.util.List r4 = com.alibaba.fastjson.util.TypeUtils.computeGetters(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Iterator r4 = r4.iterator()
        L_0x00a1:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x00b6
            java.lang.Object r6 = r4.next()
            com.alibaba.fastjson.util.FieldInfo r6 = (com.alibaba.fastjson.util.FieldInfo) r6
            com.alibaba.fastjson.serializer.FieldSerializer r7 = new com.alibaba.fastjson.serializer.FieldSerializer
            r7.<init>(r6)
            r5.add(r7)
            goto L_0x00a1
        L_0x00b6:
            int r4 = r5.size()
            com.alibaba.fastjson.serializer.FieldSerializer[] r4 = new com.alibaba.fastjson.serializer.FieldSerializer[r4]
            java.lang.Object[] r4 = r5.toArray(r4)
            com.alibaba.fastjson.serializer.FieldSerializer[] r4 = (com.alibaba.fastjson.serializer.FieldSerializer[]) r4
            r0.getters = r4
            if (r3 == 0) goto L_0x00ca
            java.lang.String[] r2 = r3.orders()
        L_0x00ca:
            if (r2 == 0) goto L_0x010f
            int r2 = r2.length
            if (r2 == 0) goto L_0x010f
            r9 = 1
            r4 = r15
            r5 = r16
            r6 = r18
            r7 = r3
            r8 = r17
            r10 = r20
            r11 = r21
            r12 = r22
            java.util.List r1 = com.alibaba.fastjson.util.TypeUtils.computeGetters(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r1 = r1.iterator()
        L_0x00eb:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0100
            java.lang.Object r3 = r1.next()
            com.alibaba.fastjson.util.FieldInfo r3 = (com.alibaba.fastjson.util.FieldInfo) r3
            com.alibaba.fastjson.serializer.FieldSerializer r4 = new com.alibaba.fastjson.serializer.FieldSerializer
            r4.<init>(r3)
            r2.add(r4)
            goto L_0x00eb
        L_0x0100:
            int r1 = r2.size()
            com.alibaba.fastjson.serializer.FieldSerializer[] r1 = new com.alibaba.fastjson.serializer.FieldSerializer[r1]
            java.lang.Object[] r1 = r2.toArray(r1)
            com.alibaba.fastjson.serializer.FieldSerializer[] r1 = (com.alibaba.fastjson.serializer.FieldSerializer[]) r1
            r0.sortedGetters = r1
            goto L_0x012a
        L_0x010f:
            com.alibaba.fastjson.serializer.FieldSerializer[] r2 = r0.getters
            int r3 = r2.length
            com.alibaba.fastjson.serializer.FieldSerializer[] r3 = new com.alibaba.fastjson.serializer.FieldSerializer[r3]
            int r4 = r2.length
            java.lang.System.arraycopy(r2, r1, r3, r1, r4)
            java.util.Arrays.sort(r3)
            com.alibaba.fastjson.serializer.FieldSerializer[] r1 = r0.getters
            boolean r1 = java.util.Arrays.equals(r3, r1)
            if (r1 == 0) goto L_0x0128
            com.alibaba.fastjson.serializer.FieldSerializer[] r1 = r0.getters
            r0.sortedGetters = r1
            goto L_0x012a
        L_0x0128:
            r0.sortedGetters = r3
        L_0x012a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JavaBeanSerializer.<init>(java.lang.Class, int, java.util.Map, boolean, boolean, boolean, boolean, com.alibaba.fastjson.PropertyNamingStrategy):void");
    }

    public JavaBeanSerializer(Class<?> cls, PropertyNamingStrategy propertyNamingStrategy) {
        this(cls, cls.getModifiers(), (Map<String, String>) null, false, true, true, true, propertyNamingStrategy);
    }

    public JavaBeanSerializer(Class<?> cls, String... strArr) {
        this(cls, cls.getModifiers(), map(strArr), false, true, true, true, (PropertyNamingStrategy) null);
    }

    public static Map<String, String> map(String... strArr) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            hashMap.put(str, str);
        }
        return hashMap;
    }

    public Map<String, Object> getFieldValuesMap(Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
        }
        return linkedHashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:256:0x0343, code lost:
        if (((java.lang.Boolean) r11).booleanValue() == false) goto L_0x0345;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0140 A[SYNTHETIC, Splitter:B:105:0x0140] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0155 A[Catch:{ Exception -> 0x055d, all -> 0x0559 }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0157 A[Catch:{ Exception -> 0x055d, all -> 0x0559 }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0161 A[Catch:{ Exception -> 0x055d, all -> 0x0559 }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0163 A[Catch:{ Exception -> 0x055d, all -> 0x0559 }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0176 A[SYNTHETIC, Splitter:B:125:0x0176] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01cc A[Catch:{ Exception -> 0x04ed, all -> 0x04e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0221 A[Catch:{ Exception -> 0x04ed, all -> 0x04e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0262 A[Catch:{ Exception -> 0x04ed, all -> 0x04e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0264 A[Catch:{ Exception -> 0x04ed, all -> 0x04e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x0420 A[Catch:{ Exception -> 0x04ed, all -> 0x04e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:363:0x04fc  */
    /* JADX WARNING: Removed duplicated region for block: B:375:0x051e A[SYNTHETIC, Splitter:B:375:0x051e] */
    /* JADX WARNING: Removed duplicated region for block: B:382:0x0536 A[SYNTHETIC, Splitter:B:382:0x0536] */
    /* JADX WARNING: Removed duplicated region for block: B:405:0x0566 A[SYNTHETIC, Splitter:B:405:0x0566] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00ef A[Catch:{ Exception -> 0x009d, all -> 0x0098 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x011b A[SYNTHETIC, Splitter:B:93:0x011b] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0134  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer r35, java.lang.Object r36, java.lang.Object r37, java.lang.reflect.Type r38) {
        /*
            r34 = this;
            r1 = r34
            r2 = r35
            r3 = r36
            r4 = r37
            r5 = r38
            com.alibaba.fastjson.serializer.SerializeWriter r6 = r2.out
            if (r3 != 0) goto L_0x0012
            r6.writeNull()
            return
        L_0x0012:
            com.alibaba.fastjson.serializer.SerialContext r7 = r2.context
            if (r7 == 0) goto L_0x001f
            int r7 = r7.features
            com.alibaba.fastjson.serializer.SerializerFeature r8 = com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect
            int r8 = r8.mask
            r7 = r7 & r8
            if (r7 != 0) goto L_0x002d
        L_0x001f:
            java.util.IdentityHashMap<java.lang.Object, com.alibaba.fastjson.serializer.SerialContext> r7 = r2.references
            if (r7 == 0) goto L_0x002d
            boolean r7 = r7.containsKey(r3)
            if (r7 == 0) goto L_0x002d
            r35.writeReference(r36)
            return
        L_0x002d:
            int r7 = r6.features
            com.alibaba.fastjson.serializer.SerializerFeature r8 = com.alibaba.fastjson.serializer.SerializerFeature.SortField
            int r8 = r8.mask
            r7 = r7 & r8
            if (r7 == 0) goto L_0x0039
            com.alibaba.fastjson.serializer.FieldSerializer[] r7 = r1.sortedGetters
            goto L_0x003b
        L_0x0039:
            com.alibaba.fastjson.serializer.FieldSerializer[] r7 = r1.getters
        L_0x003b:
            com.alibaba.fastjson.serializer.SerialContext r8 = r2.context
            int r9 = r6.features
            com.alibaba.fastjson.serializer.SerializerFeature r10 = com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect
            int r10 = r10.mask
            r9 = r9 & r10
            if (r9 != 0) goto L_0x0061
            com.alibaba.fastjson.serializer.SerialContext r9 = new com.alibaba.fastjson.serializer.SerialContext
            int r10 = r1.features
            r9.<init>(r8, r3, r4, r10)
            r2.context = r9
            java.util.IdentityHashMap<java.lang.Object, com.alibaba.fastjson.serializer.SerialContext> r9 = r2.references
            if (r9 != 0) goto L_0x005a
            java.util.IdentityHashMap r9 = new java.util.IdentityHashMap
            r9.<init>()
            r2.references = r9
        L_0x005a:
            java.util.IdentityHashMap<java.lang.Object, com.alibaba.fastjson.serializer.SerialContext> r9 = r2.references
            com.alibaba.fastjson.serializer.SerialContext r10 = r2.context
            r9.put(r3, r10)
        L_0x0061:
            int r9 = r1.features
            com.alibaba.fastjson.serializer.SerializerFeature r10 = com.alibaba.fastjson.serializer.SerializerFeature.BeanToArray
            int r10 = r10.mask
            r9 = r9 & r10
            r11 = 0
            r12 = 1
            if (r9 != 0) goto L_0x0074
            int r9 = r6.features
            r9 = r9 & r10
            if (r9 == 0) goto L_0x0072
            goto L_0x0074
        L_0x0072:
            r9 = 0
            goto L_0x0075
        L_0x0074:
            r9 = 1
        L_0x0075:
            if (r9 == 0) goto L_0x007a
            r10 = 91
            goto L_0x007c
        L_0x007a:
            r10 = 123(0x7b, float:1.72E-43)
        L_0x007c:
            if (r9 == 0) goto L_0x0081
            r13 = 93
            goto L_0x0083
        L_0x0081:
            r13 = 125(0x7d, float:1.75E-43)
        L_0x0083:
            int r14 = r6.count     // Catch:{ Exception -> 0x055d, all -> 0x0559 }
            int r14 = r14 + r12
            char[] r15 = r6.buf     // Catch:{ Exception -> 0x055d, all -> 0x0559 }
            int r15 = r15.length     // Catch:{ Exception -> 0x055d, all -> 0x0559 }
            if (r14 <= r15) goto L_0x00a2
            java.io.Writer r15 = r6.writer     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            if (r15 != 0) goto L_0x0093
            r6.expandCapacity(r14)     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            goto L_0x00a2
        L_0x0093:
            r6.flush()     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            r14 = 1
            goto L_0x00a2
        L_0x0098:
            r0 = move-exception
            r3 = r0
            r1 = r8
            goto L_0x0582
        L_0x009d:
            r0 = move-exception
            r3 = r0
            r1 = r8
            goto L_0x0560
        L_0x00a2:
            char[] r15 = r6.buf     // Catch:{ Exception -> 0x055d, all -> 0x0559 }
            int r12 = r6.count     // Catch:{ Exception -> 0x055d, all -> 0x0559 }
            r15[r12] = r10     // Catch:{ Exception -> 0x055d, all -> 0x0559 }
            r6.count = r14     // Catch:{ Exception -> 0x055d, all -> 0x0559 }
            int r10 = r7.length     // Catch:{ Exception -> 0x055d, all -> 0x0559 }
            if (r10 <= 0) goto L_0x00bc
            int r10 = r6.features     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            com.alibaba.fastjson.serializer.SerializerFeature r12 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            int r12 = r12.mask     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            r10 = r10 & r12
            if (r10 == 0) goto L_0x00bc
            r35.incrementIndent()     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            r35.println()     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
        L_0x00bc:
            int r10 = r1.features     // Catch:{ Exception -> 0x055d, all -> 0x0559 }
            com.alibaba.fastjson.serializer.SerializerFeature r12 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName     // Catch:{ Exception -> 0x055d, all -> 0x0559 }
            int r12 = r12.mask     // Catch:{ Exception -> 0x055d, all -> 0x0559 }
            r10 = r10 & r12
            if (r10 != 0) goto L_0x00e6
            int r10 = r6.features     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            com.alibaba.fastjson.serializer.SerializerFeature r12 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            int r12 = r12.mask     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            r10 = r10 & r12
            if (r10 == 0) goto L_0x00e4
            if (r5 != 0) goto L_0x00e6
            int r10 = r6.features     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            com.alibaba.fastjson.serializer.SerializerFeature r12 = com.alibaba.fastjson.serializer.SerializerFeature.NotWriteRootClassName     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            int r12 = r12.mask     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            r10 = r10 & r12
            if (r10 == 0) goto L_0x00e6
            com.alibaba.fastjson.serializer.SerialContext r10 = r2.context     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            if (r10 == 0) goto L_0x00e4
            com.alibaba.fastjson.serializer.SerialContext r10 = r2.context     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            com.alibaba.fastjson.serializer.SerialContext r10 = r10.parent     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            if (r10 == 0) goto L_0x00e4
            goto L_0x00e6
        L_0x00e4:
            r10 = 0
            goto L_0x00e7
        L_0x00e6:
            r10 = 1
        L_0x00e7:
            if (r10 == 0) goto L_0x010e
            java.lang.Class r10 = r36.getClass()     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            if (r10 == r5) goto L_0x010e
            java.lang.String r5 = r1.typeKey     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            if (r5 == 0) goto L_0x00f6
            java.lang.String r5 = r1.typeKey     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            goto L_0x00fa
        L_0x00f6:
            com.alibaba.fastjson.serializer.SerializeConfig r5 = r2.config     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            java.lang.String r5 = r5.typeKey     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
        L_0x00fa:
            r6.writeFieldName(r5, r11)     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            java.lang.String r5 = r1.typeName     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            if (r5 != 0) goto L_0x0109
            java.lang.Class r5 = r36.getClass()     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            java.lang.String r5 = r5.getName()     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
        L_0x0109:
            r2.write((java.lang.String) r5)     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            r5 = 1
            goto L_0x010f
        L_0x010e:
            r5 = 0
        L_0x010f:
            r10 = 44
            if (r5 == 0) goto L_0x0116
            r5 = 44
            goto L_0x0117
        L_0x0116:
            r5 = 0
        L_0x0117:
            java.util.List<com.alibaba.fastjson.serializer.BeforeFilter> r12 = r2.beforeFilters     // Catch:{ Exception -> 0x055d, all -> 0x0559 }
            if (r12 == 0) goto L_0x0132
            java.util.List<com.alibaba.fastjson.serializer.BeforeFilter> r12 = r2.beforeFilters     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
        L_0x0121:
            boolean r14 = r12.hasNext()     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            if (r14 == 0) goto L_0x0132
            java.lang.Object r14 = r12.next()     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            com.alibaba.fastjson.serializer.BeforeFilter r14 = (com.alibaba.fastjson.serializer.BeforeFilter) r14     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            char r5 = r14.writeBefore(r2, r3, r5)     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            goto L_0x0121
        L_0x0132:
            if (r5 != r10) goto L_0x0136
            r5 = 1
            goto L_0x0137
        L_0x0136:
            r5 = 0
        L_0x0137:
            int r12 = r6.features     // Catch:{ Exception -> 0x055d, all -> 0x0559 }
            com.alibaba.fastjson.serializer.SerializerFeature r14 = com.alibaba.fastjson.serializer.SerializerFeature.QuoteFieldNames     // Catch:{ Exception -> 0x055d, all -> 0x0559 }
            int r14 = r14.mask     // Catch:{ Exception -> 0x055d, all -> 0x0559 }
            r12 = r12 & r14
            if (r12 == 0) goto L_0x014b
            int r12 = r6.features     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            com.alibaba.fastjson.serializer.SerializerFeature r14 = com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            int r14 = r14.mask     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            r12 = r12 & r14
            if (r12 != 0) goto L_0x014b
            r12 = 1
            goto L_0x014c
        L_0x014b:
            r12 = 0
        L_0x014c:
            int r14 = r6.features     // Catch:{ Exception -> 0x055d, all -> 0x0559 }
            com.alibaba.fastjson.serializer.SerializerFeature r15 = com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes     // Catch:{ Exception -> 0x055d, all -> 0x0559 }
            int r15 = r15.mask     // Catch:{ Exception -> 0x055d, all -> 0x0559 }
            r14 = r14 & r15
            if (r14 == 0) goto L_0x0157
            r14 = 1
            goto L_0x0158
        L_0x0157:
            r14 = 0
        L_0x0158:
            int r15 = r6.features     // Catch:{ Exception -> 0x055d, all -> 0x0559 }
            com.alibaba.fastjson.serializer.SerializerFeature r11 = com.alibaba.fastjson.serializer.SerializerFeature.NotWriteDefaultValue     // Catch:{ Exception -> 0x055d, all -> 0x0559 }
            int r11 = r11.mask     // Catch:{ Exception -> 0x055d, all -> 0x0559 }
            r11 = r11 & r15
            if (r11 == 0) goto L_0x0163
            r11 = 1
            goto L_0x0164
        L_0x0163:
            r11 = 0
        L_0x0164:
            java.util.List<com.alibaba.fastjson.serializer.PropertyFilter> r15 = r2.propertyFilters     // Catch:{ Exception -> 0x055d, all -> 0x0559 }
            java.util.List<com.alibaba.fastjson.serializer.NameFilter> r10 = r2.nameFilters     // Catch:{ Exception -> 0x055d, all -> 0x0559 }
            r16 = r5
            java.util.List<com.alibaba.fastjson.serializer.ValueFilter> r5 = r2.valueFilters     // Catch:{ Exception -> 0x055d, all -> 0x0559 }
            java.util.List<com.alibaba.fastjson.serializer.PropertyPreFilter> r4 = r2.propertyPreFilters     // Catch:{ Exception -> 0x055d, all -> 0x0559 }
            r17 = r8
            r18 = r13
            r8 = 0
        L_0x0173:
            int r13 = r7.length     // Catch:{ Exception -> 0x0555, all -> 0x0551 }
            if (r8 >= r13) goto L_0x04f3
            r13 = r7[r8]     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r19 = r7
            com.alibaba.fastjson.util.FieldInfo r7 = r13.fieldInfo     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r20 = r8
            java.lang.Class<?> r8 = r7.fieldClass     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r21 = r14
            java.lang.String r14 = r7.name     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r22 = r12
            int r12 = r6.features     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r23 = r11
            com.alibaba.fastjson.serializer.SerializerFeature r11 = com.alibaba.fastjson.serializer.SerializerFeature.SkipTransientField     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            int r11 = r11.mask     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r11 = r11 & r12
            if (r11 == 0) goto L_0x019a
            java.lang.reflect.Field r11 = r7.field     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r11 == 0) goto L_0x019a
            boolean r11 = r7.fieldTransient     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r11 == 0) goto L_0x019a
            goto L_0x01c4
        L_0x019a:
            java.lang.String r11 = r1.typeKey     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r11 == 0) goto L_0x01a7
            java.lang.String r11 = r1.typeKey     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            boolean r11 = r11.equals(r14)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r11 == 0) goto L_0x01a7
            goto L_0x01c4
        L_0x01a7:
            if (r4 == 0) goto L_0x01c1
            java.util.Iterator r11 = r4.iterator()     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
        L_0x01ad:
            boolean r12 = r11.hasNext()     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r12 == 0) goto L_0x01c1
            java.lang.Object r12 = r11.next()     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            com.alibaba.fastjson.serializer.PropertyPreFilter r12 = (com.alibaba.fastjson.serializer.PropertyPreFilter) r12     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            boolean r12 = r12.apply(r2, r3, r14)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r12 != 0) goto L_0x01ad
            r11 = 0
            goto L_0x01c2
        L_0x01c1:
            r11 = 1
        L_0x01c2:
            if (r11 != 0) goto L_0x01cc
        L_0x01c4:
            r29 = r4
            r30 = r5
            r31 = r10
            goto L_0x0345
        L_0x01cc:
            r11 = 0
            r24 = 0
            boolean r12 = r7.fieldAccess     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r12 == 0) goto L_0x0212
            java.lang.Class r12 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r8 != r12) goto L_0x01e7
            java.lang.reflect.Field r12 = r7.field     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            int r12 = r12.getInt(r3)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r27 = r24
            r24 = 0
            r26 = 0
            r25 = r12
            r12 = 1
            goto L_0x021f
        L_0x01e7:
            java.lang.Class r12 = java.lang.Long.TYPE     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r8 != r12) goto L_0x01f7
            java.lang.reflect.Field r12 = r7.field     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            long r24 = r12.getLong(r3)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r27 = r24
            r12 = 1
            r24 = 0
            goto L_0x021b
        L_0x01f7:
            java.lang.Class r12 = java.lang.Boolean.TYPE     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r8 != r12) goto L_0x020b
            java.lang.reflect.Field r12 = r7.field     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            boolean r12 = r12.getBoolean(r3)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r26 = r12
            r27 = r24
            r12 = 1
            r24 = 0
            r25 = 0
            goto L_0x021f
        L_0x020b:
            java.lang.reflect.Field r11 = r7.field     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            java.lang.Object r11 = r11.get(r3)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            goto L_0x0216
        L_0x0212:
            java.lang.Object r11 = r13.getPropertyValue(r3)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
        L_0x0216:
            r27 = r24
            r12 = 0
            r24 = 1
        L_0x021b:
            r25 = 0
            r26 = 0
        L_0x021f:
            if (r15 == 0) goto L_0x025f
            if (r12 == 0) goto L_0x0240
            java.lang.Class r1 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r8 != r1) goto L_0x022e
            java.lang.Integer r11 = java.lang.Integer.valueOf(r25)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
        L_0x022b:
            r24 = 1
            goto L_0x0240
        L_0x022e:
            java.lang.Class r1 = java.lang.Long.TYPE     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r8 != r1) goto L_0x0237
            java.lang.Long r11 = java.lang.Long.valueOf(r27)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            goto L_0x022b
        L_0x0237:
            java.lang.Class r1 = java.lang.Boolean.TYPE     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r8 != r1) goto L_0x0240
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r26)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            goto L_0x022b
        L_0x0240:
            java.util.Iterator r1 = r15.iterator()     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
        L_0x0244:
            boolean r29 = r1.hasNext()     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r29 == 0) goto L_0x025f
            java.lang.Object r29 = r1.next()     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r30 = r1
            r1 = r29
            com.alibaba.fastjson.serializer.PropertyFilter r1 = (com.alibaba.fastjson.serializer.PropertyFilter) r1     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            boolean r1 = r1.apply(r3, r14, r11)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r1 != 0) goto L_0x025c
            r1 = 0
            goto L_0x0260
        L_0x025c:
            r1 = r30
            goto L_0x0244
        L_0x025f:
            r1 = 1
        L_0x0260:
            if (r1 != 0) goto L_0x0264
            goto L_0x01c4
        L_0x0264:
            if (r10 == 0) goto L_0x02a6
            if (r12 == 0) goto L_0x0288
            if (r24 != 0) goto L_0x0288
            java.lang.Class r1 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r8 != r1) goto L_0x0276
            java.lang.Integer r1 = java.lang.Integer.valueOf(r25)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
        L_0x0272:
            r11 = r1
            r24 = 1
            goto L_0x0288
        L_0x0276:
            java.lang.Class r1 = java.lang.Long.TYPE     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r8 != r1) goto L_0x027f
            java.lang.Long r1 = java.lang.Long.valueOf(r27)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            goto L_0x0272
        L_0x027f:
            java.lang.Class r1 = java.lang.Boolean.TYPE     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r8 != r1) goto L_0x0288
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r26)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            goto L_0x0272
        L_0x0288:
            java.util.Iterator r1 = r10.iterator()     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r29 = r4
            r4 = r14
        L_0x028f:
            boolean r30 = r1.hasNext()     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r30 == 0) goto L_0x02a9
            java.lang.Object r30 = r1.next()     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r31 = r1
            r1 = r30
            com.alibaba.fastjson.serializer.NameFilter r1 = (com.alibaba.fastjson.serializer.NameFilter) r1     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            java.lang.String r4 = r1.process(r3, r4, r11)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r1 = r31
            goto L_0x028f
        L_0x02a6:
            r29 = r4
            r4 = r14
        L_0x02a9:
            if (r5 == 0) goto L_0x02ed
            if (r12 == 0) goto L_0x02cc
            if (r24 != 0) goto L_0x02cc
            java.lang.Class r1 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r8 != r1) goto L_0x02ba
            java.lang.Integer r11 = java.lang.Integer.valueOf(r25)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
        L_0x02b7:
            r24 = 1
            goto L_0x02cc
        L_0x02ba:
            java.lang.Class r1 = java.lang.Long.TYPE     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r8 != r1) goto L_0x02c3
            java.lang.Long r11 = java.lang.Long.valueOf(r27)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            goto L_0x02b7
        L_0x02c3:
            java.lang.Class r1 = java.lang.Boolean.TYPE     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r8 != r1) goto L_0x02cc
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r26)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            goto L_0x02b7
        L_0x02cc:
            java.util.Iterator r1 = r5.iterator()     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r30 = r5
            r5 = r11
        L_0x02d3:
            boolean r31 = r1.hasNext()     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r31 == 0) goto L_0x02ea
            java.lang.Object r31 = r1.next()     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r32 = r1
            r1 = r31
            com.alibaba.fastjson.serializer.ValueFilter r1 = (com.alibaba.fastjson.serializer.ValueFilter) r1     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            java.lang.Object r5 = r1.process(r3, r14, r5)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r1 = r32
            goto L_0x02d3
        L_0x02ea:
            r1 = r11
            r11 = r5
            goto L_0x02f0
        L_0x02ed:
            r30 = r5
            r1 = r11
        L_0x02f0:
            if (r24 == 0) goto L_0x0306
            if (r11 != 0) goto L_0x0306
            if (r9 != 0) goto L_0x0306
            boolean r5 = r13.writeNull     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r5 != 0) goto L_0x0306
            int r5 = r6.features     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r31 = r10
            com.alibaba.fastjson.serializer.SerializerFeature r10 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            int r10 = r10.mask     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r5 = r5 & r10
            if (r5 != 0) goto L_0x0308
            goto L_0x0345
        L_0x0306:
            r31 = r10
        L_0x0308:
            if (r24 == 0) goto L_0x034c
            if (r11 == 0) goto L_0x034c
            if (r23 == 0) goto L_0x034c
            java.lang.Class r5 = java.lang.Byte.TYPE     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r8 == r5) goto L_0x0326
            java.lang.Class r5 = java.lang.Short.TYPE     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r8 == r5) goto L_0x0326
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r8 == r5) goto L_0x0326
            java.lang.Class r5 = java.lang.Long.TYPE     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r8 == r5) goto L_0x0326
            java.lang.Class r5 = java.lang.Float.TYPE     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r8 == r5) goto L_0x0326
            java.lang.Class r5 = java.lang.Double.TYPE     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r8 != r5) goto L_0x0334
        L_0x0326:
            boolean r5 = r11 instanceof java.lang.Number     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r5 == 0) goto L_0x0334
            r5 = r11
            java.lang.Number r5 = (java.lang.Number) r5     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            byte r5 = r5.byteValue()     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r5 != 0) goto L_0x0334
            goto L_0x0345
        L_0x0334:
            java.lang.Class r5 = java.lang.Boolean.TYPE     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r8 != r5) goto L_0x034c
            boolean r5 = r11 instanceof java.lang.Boolean     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r5 == 0) goto L_0x034c
            r5 = r11
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            boolean r5 = r5.booleanValue()     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r5 != 0) goto L_0x034c
        L_0x0345:
            r32 = r15
            r4 = 0
            r33 = 44
            goto L_0x04d1
        L_0x034c:
            if (r16 == 0) goto L_0x037c
            int r5 = r6.count     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r10 = 1
            int r5 = r5 + r10
            char[] r10 = r6.buf     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            int r10 = r10.length     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r5 <= r10) goto L_0x0363
            java.io.Writer r10 = r6.writer     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r10 != 0) goto L_0x035f
            r6.expandCapacity(r5)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            goto L_0x0363
        L_0x035f:
            r6.flush()     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r5 = 1
        L_0x0363:
            char[] r10 = r6.buf     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r32 = r15
            int r15 = r6.count     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r33 = 44
            r10[r15] = r33     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r6.count = r5     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            int r5 = r6.features     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            com.alibaba.fastjson.serializer.SerializerFeature r10 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            int r10 = r10.mask     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r5 = r5 & r10
            if (r5 == 0) goto L_0x0380
            r35.println()     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            goto L_0x0380
        L_0x037c:
            r32 = r15
            r33 = 44
        L_0x0380:
            if (r4 == r14) goto L_0x038e
            if (r9 != 0) goto L_0x0388
            r1 = 1
            r6.writeFieldName(r4, r1)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
        L_0x0388:
            r2.write((java.lang.Object) r11)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
        L_0x038b:
            r4 = 0
            goto L_0x04cf
        L_0x038e:
            if (r1 == r11) goto L_0x0396
            if (r9 != 0) goto L_0x0388
            r13.writePrefix(r2)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            goto L_0x0388
        L_0x0396:
            if (r9 != 0) goto L_0x03db
            if (r22 == 0) goto L_0x03d8
            char[] r1 = r13.name_chars     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            int r4 = r1.length     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            int r5 = r6.count     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            int r5 = r5 + r4
            char[] r10 = r6.buf     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            int r10 = r10.length     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r5 <= r10) goto L_0x03cd
            java.io.Writer r10 = r6.writer     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r10 != 0) goto L_0x03ad
            r6.expandCapacity(r5)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            goto L_0x03cd
        L_0x03ad:
            r5 = 0
        L_0x03ae:
            char[] r10 = r6.buf     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            int r10 = r10.length     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            int r14 = r6.count     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            int r10 = r10 - r14
            char[] r14 = r6.buf     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            int r15 = r6.count     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            java.lang.System.arraycopy(r1, r5, r14, r15, r10)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            char[] r14 = r6.buf     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            int r14 = r14.length     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r6.count = r14     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r6.flush()     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            int r4 = r4 - r10
            int r5 = r5 + r10
            char[] r10 = r6.buf     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            int r10 = r10.length     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r4 > r10) goto L_0x03ae
            r10 = r5
            r5 = r4
            goto L_0x03ce
        L_0x03cd:
            r10 = 0
        L_0x03ce:
            char[] r14 = r6.buf     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            int r15 = r6.count     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            java.lang.System.arraycopy(r1, r10, r14, r15, r4)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r6.count = r5     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            goto L_0x03db
        L_0x03d8:
            r13.writePrefix(r2)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
        L_0x03db:
            if (r12 == 0) goto L_0x0457
            if (r24 != 0) goto L_0x0457
            java.lang.Class r1 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r8 != r1) goto L_0x042a
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r12 = r25
            if (r12 != r1) goto L_0x03ef
            java.lang.String r1 = "-2147483648"
            r6.write((java.lang.String) r1)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            goto L_0x038b
        L_0x03ef:
            if (r12 >= 0) goto L_0x03f3
            int r1 = -r12
            goto L_0x03f4
        L_0x03f3:
            r1 = r12
        L_0x03f4:
            r4 = 0
        L_0x03f5:
            int[] r5 = com.alibaba.fastjson.serializer.SerializeWriter.sizeTable     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r5 = r5[r4]     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            int r4 = r4 + 1
            if (r1 > r5) goto L_0x03f5
            if (r12 >= 0) goto L_0x0401
            int r4 = r4 + 1
        L_0x0401:
            int r1 = r6.count     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            int r1 = r1 + r4
            char[] r5 = r6.buf     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            int r5 = r5.length     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r1 <= r5) goto L_0x041d
            java.io.Writer r5 = r6.writer     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r5 != 0) goto L_0x0411
            r6.expandCapacity(r1)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            goto L_0x041d
        L_0x0411:
            char[] r5 = new char[r4]     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            long r7 = (long) r12     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            com.alibaba.fastjson.serializer.SerializeWriter.getChars(r7, r4, r5)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r7 = 0
            r6.write((char[]) r5, (int) r7, (int) r4)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r4 = 1
            goto L_0x041e
        L_0x041d:
            r4 = 0
        L_0x041e:
            if (r4 != 0) goto L_0x038b
            long r4 = (long) r12     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            char[] r7 = r6.buf     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            com.alibaba.fastjson.serializer.SerializeWriter.getChars(r4, r1, r7)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r6.count = r1     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            goto L_0x038b
        L_0x042a:
            java.lang.Class r1 = java.lang.Long.TYPE     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r8 != r1) goto L_0x0437
            com.alibaba.fastjson.serializer.SerializeWriter r1 = r2.out     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r4 = r27
            r1.writeLong(r4)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            goto L_0x038b
        L_0x0437:
            java.lang.Class r1 = java.lang.Boolean.TYPE     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r8 != r1) goto L_0x038b
            if (r26 == 0) goto L_0x044a
            com.alibaba.fastjson.serializer.SerializeWriter r1 = r2.out     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            char[] r4 = true_chars     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            char[] r5 = true_chars     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            int r5 = r5.length     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r7 = 0
            r1.write((char[]) r4, (int) r7, (int) r5)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            goto L_0x038b
        L_0x044a:
            com.alibaba.fastjson.serializer.SerializeWriter r1 = r2.out     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            char[] r4 = false_chars     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            char[] r5 = false_chars     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            int r5 = r5.length     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r7 = 0
            r1.write((char[]) r4, (int) r7, (int) r5)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            goto L_0x038b
        L_0x0457:
            if (r9 != 0) goto L_0x04cb
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            if (r8 != r1) goto L_0x048e
            if (r11 != 0) goto L_0x047e
            int r1 = r6.features     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            int r4 = r4.mask     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r1 = r1 & r4
            if (r1 != 0) goto L_0x0477
            int r1 = r13.features     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            int r4 = r4.mask     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r1 = r1 & r4
            if (r1 == 0) goto L_0x0472
            goto L_0x0477
        L_0x0472:
            r6.writeNull()     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            goto L_0x038b
        L_0x0477:
            java.lang.String r1 = ""
            r6.writeString(r1)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            goto L_0x038b
        L_0x047e:
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r21 == 0) goto L_0x0487
            r6.writeStringWithSingleQuote(r11)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            goto L_0x038b
        L_0x0487:
            r1 = 0
            r4 = 1
            r6.writeStringWithDoubleQuote(r11, r1, r4)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            goto L_0x038b
        L_0x048e:
            boolean r1 = r7.isEnum     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r1 == 0) goto L_0x04cb
            if (r11 == 0) goto L_0x04c6
            int r1 = r6.features     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteEnumUsingToString     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            int r4 = r4.mask     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r1 = r1 & r4
            if (r1 == 0) goto L_0x04bb
            java.lang.Enum r11 = (java.lang.Enum) r11     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            java.lang.String r1 = r11.toString()     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            int r4 = r6.features     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            int r5 = r5.mask     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r4 = r4 & r5
            if (r4 == 0) goto L_0x04ae
            r10 = 1
            goto L_0x04af
        L_0x04ae:
            r10 = 0
        L_0x04af:
            if (r10 == 0) goto L_0x04b6
            r6.writeStringWithSingleQuote(r1)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            goto L_0x038b
        L_0x04b6:
            r4 = 0
            r6.writeStringWithDoubleQuote(r1, r4, r4)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            goto L_0x04cf
        L_0x04bb:
            r4 = 0
            java.lang.Enum r11 = (java.lang.Enum) r11     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            int r1 = r11.ordinal()     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r6.writeInt(r1)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            goto L_0x04cf
        L_0x04c6:
            r4 = 0
            r6.writeNull()     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            goto L_0x04cf
        L_0x04cb:
            r4 = 0
            r13.writeValue(r2, r11)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
        L_0x04cf:
            r16 = 1
        L_0x04d1:
            int r8 = r20 + 1
            r1 = r34
            r7 = r19
            r14 = r21
            r12 = r22
            r11 = r23
            r4 = r29
            r5 = r30
            r10 = r31
            r15 = r32
            goto L_0x0173
        L_0x04e7:
            r0 = move-exception
            r3 = r0
            r1 = r17
            goto L_0x0582
        L_0x04ed:
            r0 = move-exception
            r3 = r0
            r1 = r17
            goto L_0x0560
        L_0x04f3:
            r19 = r7
            r4 = 0
            r33 = 44
            java.util.List<com.alibaba.fastjson.serializer.AfterFilter> r1 = r2.afterFilters     // Catch:{ Exception -> 0x0555, all -> 0x0551 }
            if (r1 == 0) goto L_0x0519
            if (r16 == 0) goto L_0x0501
            r11 = 44
            goto L_0x0502
        L_0x0501:
            r11 = 0
        L_0x0502:
            java.util.List<com.alibaba.fastjson.serializer.AfterFilter> r1 = r2.afterFilters     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
        L_0x0508:
            boolean r4 = r1.hasNext()     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r4 == 0) goto L_0x0519
            java.lang.Object r4 = r1.next()     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            com.alibaba.fastjson.serializer.AfterFilter r4 = (com.alibaba.fastjson.serializer.AfterFilter) r4     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            char r11 = r4.writeAfter(r2, r3, r11)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            goto L_0x0508
        L_0x0519:
            r7 = r19
            int r1 = r7.length     // Catch:{ Exception -> 0x0555, all -> 0x0551 }
            if (r1 <= 0) goto L_0x052d
            int r1 = r6.features     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            com.alibaba.fastjson.serializer.SerializerFeature r3 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            int r3 = r3.mask     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r1 = r1 & r3
            if (r1 == 0) goto L_0x052d
            r35.decrementIdent()     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r35.println()     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
        L_0x052d:
            int r1 = r6.count     // Catch:{ Exception -> 0x0555, all -> 0x0551 }
            r3 = 1
            int r1 = r1 + r3
            char[] r4 = r6.buf     // Catch:{ Exception -> 0x0555, all -> 0x0551 }
            int r4 = r4.length     // Catch:{ Exception -> 0x0555, all -> 0x0551 }
            if (r1 <= r4) goto L_0x0543
            java.io.Writer r4 = r6.writer     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            if (r4 != 0) goto L_0x053e
            r6.expandCapacity(r1)     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            goto L_0x0543
        L_0x053e:
            r6.flush()     // Catch:{ Exception -> 0x04ed, all -> 0x04e7 }
            r12 = 1
            goto L_0x0544
        L_0x0543:
            r12 = r1
        L_0x0544:
            char[] r1 = r6.buf     // Catch:{ Exception -> 0x0555, all -> 0x0551 }
            int r3 = r6.count     // Catch:{ Exception -> 0x0555, all -> 0x0551 }
            r1[r3] = r18     // Catch:{ Exception -> 0x0555, all -> 0x0551 }
            r6.count = r12     // Catch:{ Exception -> 0x0555, all -> 0x0551 }
            r1 = r17
            r2.context = r1
            return
        L_0x0551:
            r0 = move-exception
            r1 = r17
            goto L_0x055b
        L_0x0555:
            r0 = move-exception
            r1 = r17
            goto L_0x055f
        L_0x0559:
            r0 = move-exception
            r1 = r8
        L_0x055b:
            r3 = r0
            goto L_0x0582
        L_0x055d:
            r0 = move-exception
            r1 = r8
        L_0x055f:
            r3 = r0
        L_0x0560:
            java.lang.String r4 = "write javaBean error, fastjson version 1.1.67"
            r5 = r37
            if (r5 == 0) goto L_0x057a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0580 }
            r6.<init>()     // Catch:{ all -> 0x0580 }
            r6.append(r4)     // Catch:{ all -> 0x0580 }
            java.lang.String r4 = ", fieldName : "
            r6.append(r4)     // Catch:{ all -> 0x0580 }
            r6.append(r5)     // Catch:{ all -> 0x0580 }
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x0580 }
        L_0x057a:
            com.alibaba.fastjson.JSONException r5 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0580 }
            r5.<init>(r4, r3)     // Catch:{ all -> 0x0580 }
            throw r5     // Catch:{ all -> 0x0580 }
        L_0x0580:
            r0 = move-exception
            goto L_0x055b
        L_0x0582:
            r2.context = r1
            goto L_0x0586
        L_0x0585:
            throw r3
        L_0x0586:
            goto L_0x0585
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JavaBeanSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type):void");
    }
}
