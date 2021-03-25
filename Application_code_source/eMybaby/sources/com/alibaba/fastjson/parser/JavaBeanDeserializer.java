package com.alibaba.fastjson.parser;

import a.a.a.a.a;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessable;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.nineoldandroids.util.ReflectiveProperty;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class JavaBeanDeserializer implements ObjectDeserializer {
    public final Map<String, FieldDeserializer> alterNameFieldDeserializers;
    public final JavaBeanInfo beanInfo;
    public final Class<?> clazz;
    public ConcurrentMap<String, Object> extraFieldDeserializers;
    public final FieldDeserializer[] fieldDeserializers;
    public transient long[] smartMatchHashArray;
    public transient int[] smartMatchHashArrayMapping;
    public final FieldDeserializer[] sortedFieldDeserializers;

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type) {
        this(parserConfig, cls, type, JavaBeanInfo.build(cls, cls.getModifiers(), type, false, true, true, true, parserConfig.propertyNamingStrategy));
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type, JavaBeanInfo javaBeanInfo) {
        this.clazz = cls;
        this.beanInfo = javaBeanInfo;
        FieldInfo[] fieldInfoArr = javaBeanInfo.sortedFields;
        this.sortedFieldDeserializers = new FieldDeserializer[fieldInfoArr.length];
        int length = fieldInfoArr.length;
        HashMap hashMap = null;
        for (int i = 0; i < length; i++) {
            FieldInfo fieldInfo = javaBeanInfo.sortedFields[i];
            FieldDeserializer createFieldDeserializer = parserConfig.createFieldDeserializer(parserConfig, cls, fieldInfo);
            this.sortedFieldDeserializers[i] = createFieldDeserializer;
            for (String str : fieldInfo.alternateNames) {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(str, createFieldDeserializer);
            }
        }
        this.alterNameFieldDeserializers = hashMap;
        FieldInfo[] fieldInfoArr2 = javaBeanInfo.fields;
        this.fieldDeserializers = new FieldDeserializer[fieldInfoArr2.length];
        int length2 = fieldInfoArr2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            this.fieldDeserializers[i2] = getFieldDeserializer(javaBeanInfo.fields[i2].name);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0148, code lost:
        if (r14.matchStat == -2) goto L_0x014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x02de, code lost:
        if (r0 == 16) goto L_0x02e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:?, code lost:
        r14.nextTokenWithChar(':');
        r0 = r14.token;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x02fc, code lost:
        if (r0 != 4) goto L_0x0399;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x02fe, code lost:
        r0 = r14.stringVal();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x0308, code lost:
        if ("@".equals(r0) == false) goto L_0x0316;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x030a, code lost:
        r1 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x030e, code lost:
        r2 = r1.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x0310, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x0311, code lost:
        r11 = r1;
        r10 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x0316, code lost:
        r1 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x031e, code lost:
        if ("..".equals(r0) == false) goto L_0x0339;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:?, code lost:
        r2 = r1.parent;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x0324, code lost:
        if (r2.object == null) goto L_0x032b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x0326, code lost:
        r0 = r2.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x0328, code lost:
        r21 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x032b, code lost:
        r8.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r2, r0));
        r0 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x0334, code lost:
        r8.resolveStatus = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:266:0x0336, code lost:
        r2 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x033f, code lost:
        if ("$".equals(r0) == false) goto L_0x035a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x0341, code lost:
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x0344, code lost:
        if (r2.parent == null) goto L_0x0349;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x0346, code lost:
        r2 = r2.parent;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x034b, code lost:
        if (r2.object == null) goto L_0x0350;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x034d, code lost:
        r0 = r2.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:279:0x0350, code lost:
        r8.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r2, r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:0x0358, code lost:
        r0 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:282:?, code lost:
        r8.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r1, r0));
        r8.resolveStatus = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:?, code lost:
        r14.nextToken(13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x036d, code lost:
        if (r14.token != 13) goto L_0x0381;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x036f, code lost:
        r14.nextToken(16);
        r8.setContext(r1, r2, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x0377, code lost:
        r3 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x0379, code lost:
        if (r3 == null) goto L_0x037d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:290:0x037b, code lost:
        r3.object = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x037d, code lost:
        r8.setContext(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:292:0x0380, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x0381, code lost:
        r3 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x038a, code lost:
        throw new com.alibaba.fastjson.JSONException("illegal ref");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x038b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:298:0x038d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x038e, code lost:
        r3 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:300:0x0390, code lost:
        r11 = r1;
        r10 = r2;
        r6 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:301:0x0395, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x0396, code lost:
        r3 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x0399, code lost:
        r1 = r22;
        r3 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:306:0x03b7, code lost:
        throw new com.alibaba.fastjson.JSONException("illegal ref, " + com.alibaba.fastjson.parser.JSONToken.name(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x03b8, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x03b9, code lost:
        r11 = r1;
        r6 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:309:0x03bb, code lost:
        r10 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:317:0x03d2, code lost:
        if (r0.equals(r4) == false) goto L_0x03dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:336:0x040f, code lost:
        r14 = r26;
        r6 = r40;
        r11 = r41;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:340:?, code lost:
        r3 = getSeeAlso(r8.config, r7.beanInfo, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:341:0x0431, code lost:
        if (r3 != null) goto L_0x0460;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:343:?, code lost:
        r3 = r8.config.checkAutoType(r1, r7.clazz, r14.features);
        r2 = com.alibaba.fastjson.util.TypeUtils.getClass(r46);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:344:0x0441, code lost:
        if (r2 == null) goto L_0x0454;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:345:0x0443, code lost:
        if (r3 == null) goto L_0x044c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:347:0x0449, code lost:
        if (r2.isAssignableFrom(r3) == false) goto L_0x044c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:350:0x0453, code lost:
        throw new com.alibaba.fastjson.JSONException("type not match");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:352:0x045a, code lost:
        r42 = r3;
        r3 = r8.config.getDeserializer(r3);
        r2 = r42;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:353:0x0460, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:356:0x0463, code lost:
        if ((r3 instanceof com.alibaba.fastjson.parser.JavaBeanDeserializer) == false) goto L_0x0476;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:358:?, code lost:
        r3 = (com.alibaba.fastjson.parser.JavaBeanDeserializer) r3;
        r2 = r3.deserialze(r8, r2, r9, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:0x046c, code lost:
        if (r0 == null) goto L_0x047a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:360:0x046e, code lost:
        r3.getFieldDeserializer(r0).setValue((java.lang.Object) r2, (java.lang.Object) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:362:?, code lost:
        r2 = r3.deserialze(r8, r2, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:363:0x047a, code lost:
        r1 = r40;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:364:0x047c, code lost:
        if (r1 == null) goto L_0x0482;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:0x047e, code lost:
        r1.object = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:366:0x0482, code lost:
        r8.setContext(r41);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:367:0x0487, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:506:0x069e, code lost:
        r21 = r25;
        r6 = r40;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:507:0x06a2, code lost:
        if (r21 != null) goto L_0x077a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:508:0x06a4, code lost:
        if (r14 != null) goto L_0x06bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:510:?, code lost:
        r1 = createInstance(r45, r46);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:511:0x06aa, code lost:
        if (r6 != null) goto L_0x06b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:513:?, code lost:
        r6 = r8.setContext(r11, r1, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:514:0x06b1, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:515:0x06b2, code lost:
        r10 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:516:0x06b5, code lost:
        if (r6 == null) goto L_0x06b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:517:0x06b7, code lost:
        r6.object = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:518:0x06b9, code lost:
        r8.setContext(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:519:0x06bc, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:521:?, code lost:
        r0 = r7.beanInfo.creatorConstructorParameters;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:522:0x06c1, code lost:
        if (r0 == null) goto L_0x06c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:523:0x06c3, code lost:
        r1 = r0.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:524:0x06c5, code lost:
        r1 = r7.fieldDeserializers.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:525:0x06c8, code lost:
        r2 = new java.lang.Object[r1];
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:526:0x06cb, code lost:
        if (r3 >= r1) goto L_0x06ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:527:0x06cd, code lost:
        r4 = r7.fieldDeserializers[r3].fieldInfo;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:528:0x06d3, code lost:
        if (r0 == null) goto L_0x06dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:529:0x06d5, code lost:
        r5 = r14.remove(r4.name);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:530:0x06dc, code lost:
        r5 = r14.get(r4.name);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:531:0x06e2, code lost:
        if (r5 != null) goto L_0x06ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:532:0x06e4, code lost:
        r5 = com.alibaba.fastjson.util.TypeUtils.defaultValue(r4.fieldClass);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:533:0x06ea, code lost:
        r2[r3] = r5;
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:535:0x06f3, code lost:
        if (r7.beanInfo.creatorConstructor == null) goto L_0x0747;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:537:?, code lost:
        r1 = r7.beanInfo.creatorConstructor.newInstance(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:538:0x06fd, code lost:
        if (r0 == null) goto L_0x077c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:540:?, code lost:
        r0 = r14.entrySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:542:0x070b, code lost:
        if (r0.hasNext() == false) goto L_0x077c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:543:0x070d, code lost:
        r2 = (java.util.Map.Entry) r0.next();
        r3 = getFieldDeserializer((java.lang.String) r2.getKey());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:544:0x071d, code lost:
        if (r3 == null) goto L_0x0707;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:545:0x071f, code lost:
        r3.setValue(r1, r2.getValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:546:0x0727, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:549:0x0746, code lost:
        throw new com.alibaba.fastjson.JSONException("create instance error, " + r7.beanInfo.creatorConstructor.toGenericString(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:551:0x074b, code lost:
        if (r7.beanInfo.factoryMethod == null) goto L_0x077a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:553:?, code lost:
        r21 = r7.beanInfo.factoryMethod.invoke((java.lang.Object) null, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:554:0x0757, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:557:0x0776, code lost:
        throw new com.alibaba.fastjson.JSONException("create factory method error, " + r7.beanInfo.factoryMethod.toString(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:558:0x0777, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:559:0x077a, code lost:
        r1 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:560:0x077c, code lost:
        if (r6 == null) goto L_0x0780;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:561:0x077e, code lost:
        r6.object = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:562:0x0780, code lost:
        r8.setContext(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:563:0x0783, code lost:
        return r1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:509:0x06a6, B:536:0x06f5, B:552:0x074d] */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x02bd  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067 A[Catch:{ all -> 0x0048 }] */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x04c5  */
    /* JADX WARNING: Removed duplicated region for block: B:382:0x04d7 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:402:0x0517  */
    /* JADX WARNING: Removed duplicated region for block: B:489:0x064d  */
    /* JADX WARNING: Removed duplicated region for block: B:502:0x0695 A[Catch:{ all -> 0x07d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:503:0x0697 A[Catch:{ all -> 0x07d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:581:0x07de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r45, java.lang.reflect.Type r46, java.lang.Object r47, java.lang.Object r48) {
        /*
            r44 = this;
            r7 = r44
            r8 = r45
            r0 = r46
            r9 = r47
            java.lang.Class<java.lang.Double> r10 = java.lang.Double.class
            java.lang.Class<java.lang.Float> r11 = java.lang.Float.class
            java.lang.Class<java.lang.Long> r12 = java.lang.Long.class
            java.lang.Class<java.lang.Integer> r13 = java.lang.Integer.class
            java.lang.Class<com.alibaba.fastjson.JSON> r1 = com.alibaba.fastjson.JSON.class
            if (r0 == r1) goto L_0x07e4
            java.lang.Class<com.alibaba.fastjson.JSONObject> r1 = com.alibaba.fastjson.JSONObject.class
            if (r0 != r1) goto L_0x001a
            goto L_0x07e4
        L_0x001a:
            com.alibaba.fastjson.parser.JSONLexer r14 = r8.lexer
            int r1 = r14.token
            r2 = 8
            r15 = 16
            r6 = 0
            if (r1 != r2) goto L_0x0029
            r14.nextToken(r15)
            return r6
        L_0x0029:
            boolean r5 = r14.disableCircularReferenceDetect
            com.alibaba.fastjson.parser.ParseContext r2 = r8.contex
            if (r48 == 0) goto L_0x0033
            if (r2 == 0) goto L_0x0033
            com.alibaba.fastjson.parser.ParseContext r2 = r2.parent
        L_0x0033:
            r4 = r2
            r3 = 13
            if (r1 != r3) goto L_0x004e
            r14.nextToken(r15)     // Catch:{ all -> 0x0048 }
            if (r48 != 0) goto L_0x0042
            java.lang.Object r0 = r44.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r45, (java.lang.reflect.Type) r46)     // Catch:{ all -> 0x0048 }
            goto L_0x0044
        L_0x0042:
            r0 = r48
        L_0x0044:
            r8.setContext(r4)
            return r0
        L_0x0048:
            r0 = move-exception
            r10 = r48
        L_0x004b:
            r11 = r4
            goto L_0x07dc
        L_0x004e:
            r2 = 14
            if (r1 != r2) goto L_0x006f
            com.alibaba.fastjson.parser.JavaBeanInfo r2 = r7.beanInfo     // Catch:{ all -> 0x0048 }
            boolean r2 = r2.supportBeanToArray     // Catch:{ all -> 0x0048 }
            if (r2 != 0) goto L_0x0064
            int r2 = r14.features     // Catch:{ all -> 0x0048 }
            com.alibaba.fastjson.parser.Feature r3 = com.alibaba.fastjson.parser.Feature.SupportArrayToBean     // Catch:{ all -> 0x0048 }
            int r3 = r3.mask     // Catch:{ all -> 0x0048 }
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0062
            goto L_0x0064
        L_0x0062:
            r2 = 0
            goto L_0x0065
        L_0x0064:
            r2 = 1
        L_0x0065:
            if (r2 == 0) goto L_0x006f
            java.lang.Object r0 = r44.deserialzeArrayMapping(r45, r46, r47, r48)     // Catch:{ all -> 0x0048 }
            r8.setContext(r4)
            return r0
        L_0x006f:
            r2 = 12
            r3 = 4
            if (r1 == r2) goto L_0x00ba
            if (r1 == r15) goto L_0x00ba
            boolean r0 = r14.isBlankInput()     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x0080
            r8.setContext(r4)
            return r6
        L_0x0080:
            if (r1 != r3) goto L_0x0093
            java.lang.String r0 = r14.stringVal()     // Catch:{ all -> 0x0048 }
            int r0 = r0.length()     // Catch:{ all -> 0x0048 }
            if (r0 != 0) goto L_0x0093
            r14.nextToken()     // Catch:{ all -> 0x0048 }
            r8.setContext(r4)
            return r6
        L_0x0093:
            java.lang.StringBuffer r0 = new java.lang.StringBuffer     // Catch:{ all -> 0x0048 }
            r0.<init>()     // Catch:{ all -> 0x0048 }
            java.lang.String r1 = "syntax error, expect {, actual "
            r0.append(r1)     // Catch:{ all -> 0x0048 }
            java.lang.String r1 = r14.info()     // Catch:{ all -> 0x0048 }
            r0.append(r1)     // Catch:{ all -> 0x0048 }
            boolean r1 = r9 instanceof java.lang.String     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x00b0
            java.lang.String r1 = ", fieldName "
            r0.append(r1)     // Catch:{ all -> 0x0048 }
            r0.append(r9)     // Catch:{ all -> 0x0048 }
        L_0x00b0:
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0048 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0048 }
            r1.<init>(r0)     // Catch:{ all -> 0x0048 }
            throw r1     // Catch:{ all -> 0x0048 }
        L_0x00ba:
            int r1 = r8.resolveStatus     // Catch:{ all -> 0x07d7 }
            r2 = 2
            if (r1 != r2) goto L_0x00c3
            r2 = 0
            r8.resolveStatus = r2     // Catch:{ all -> 0x0048 }
            goto L_0x00c4
        L_0x00c3:
            r2 = 0
        L_0x00c4:
            com.alibaba.fastjson.parser.JavaBeanInfo r1 = r7.beanInfo     // Catch:{ all -> 0x07d7 }
            java.lang.String r1 = r1.typeKey     // Catch:{ all -> 0x07d7 }
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r2 = r7.sortedFieldDeserializers     // Catch:{ all -> 0x07d7 }
            int r2 = r2.length     // Catch:{ all -> 0x07d7 }
            r19 = 0
            r21 = r48
            r22 = r4
            r25 = r6
            r26 = r25
            r3 = r19
            r6 = 0
        L_0x00d8:
            int r27 = (r3 > r19 ? 1 : (r3 == r19 ? 0 : -1))
            if (r27 == 0) goto L_0x00f5
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r3 = r7.getFieldDeserializerByHash(r3)     // Catch:{ all -> 0x00ec }
            if (r3 == 0) goto L_0x00e7
            com.alibaba.fastjson.util.FieldInfo r4 = r3.fieldInfo     // Catch:{ all -> 0x00ec }
            java.lang.Class<?> r15 = r4.fieldClass     // Catch:{ all -> 0x00ec }
            goto L_0x00e9
        L_0x00e7:
            r4 = 0
            r15 = 0
        L_0x00e9:
            r28 = r19
            goto L_0x00fa
        L_0x00ec:
            r0 = move-exception
            r10 = r21
            r11 = r22
        L_0x00f1:
            r6 = r25
            goto L_0x07dc
        L_0x00f5:
            r28 = r3
            r3 = 0
            r4 = 0
            r15 = 0
        L_0x00fa:
            if (r3 != 0) goto L_0x0108
            if (r6 >= r2) goto L_0x0106
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r3 = r7.sortedFieldDeserializers     // Catch:{ all -> 0x00ec }
            r3 = r3[r6]     // Catch:{ all -> 0x00ec }
            com.alibaba.fastjson.util.FieldInfo r4 = r3.fieldInfo     // Catch:{ all -> 0x00ec }
            java.lang.Class<?> r15 = r4.fieldClass     // Catch:{ all -> 0x00ec }
        L_0x0106:
            int r6 = r6 + 1
        L_0x0108:
            r42 = r15
            r15 = r6
            r6 = r42
            r30 = 0
            r31 = 0
            if (r3 == 0) goto L_0x02a9
            r33 = r1
            long r0 = r4.nameHashCode     // Catch:{ all -> 0x00ec }
            r34 = r2
            java.lang.Class r2 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00ec }
            r48 = r15
            r15 = -2
            if (r6 == r2) goto L_0x0281
            if (r6 != r13) goto L_0x0124
            goto L_0x0281
        L_0x0124:
            java.lang.Class r2 = java.lang.Long.TYPE     // Catch:{ all -> 0x00ec }
            if (r6 == r2) goto L_0x0261
            if (r6 != r12) goto L_0x012c
            goto L_0x0261
        L_0x012c:
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            if (r6 != r2) goto L_0x0151
            java.lang.String r0 = r14.scanFieldString(r0)     // Catch:{ all -> 0x00ec }
            int r1 = r14.matchStat     // Catch:{ all -> 0x00ec }
            if (r1 <= 0) goto L_0x0146
        L_0x0138:
            r2 = 1
            r15 = 1
        L_0x013a:
            r35 = 0
            r36 = 0
        L_0x013e:
            r42 = r31
            r32 = r0
            r30 = r19
            goto L_0x0275
        L_0x0146:
            int r1 = r14.matchStat     // Catch:{ all -> 0x00ec }
            if (r1 != r15) goto L_0x014e
        L_0x014a:
            long r3 = r14.fieldHash     // Catch:{ all -> 0x00ec }
            goto L_0x0298
        L_0x014e:
            r2 = 0
            r15 = 0
            goto L_0x013a
        L_0x0151:
            java.lang.Class<java.util.Date> r2 = java.util.Date.class
            if (r6 != r2) goto L_0x0163
            java.util.Date r0 = r14.scanFieldDate(r0)     // Catch:{ all -> 0x00ec }
            int r1 = r14.matchStat     // Catch:{ all -> 0x00ec }
            if (r1 <= 0) goto L_0x015e
            goto L_0x0138
        L_0x015e:
            int r1 = r14.matchStat     // Catch:{ all -> 0x00ec }
            if (r1 != r15) goto L_0x014e
            goto L_0x014a
        L_0x0163:
            java.lang.Class r2 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x00ec }
            if (r6 == r2) goto L_0x024d
            java.lang.Class<java.lang.Boolean> r2 = java.lang.Boolean.class
            if (r6 != r2) goto L_0x016d
            goto L_0x024d
        L_0x016d:
            java.lang.Class r2 = java.lang.Float.TYPE     // Catch:{ all -> 0x00ec }
            if (r6 == r2) goto L_0x022c
            if (r6 != r11) goto L_0x0175
            goto L_0x022c
        L_0x0175:
            java.lang.Class r2 = java.lang.Double.TYPE     // Catch:{ all -> 0x00ec }
            if (r6 == r2) goto L_0x0218
            if (r6 != r10) goto L_0x017d
            goto L_0x0218
        L_0x017d:
            boolean r2 = r4.isEnum     // Catch:{ all -> 0x00ec }
            if (r2 == 0) goto L_0x01a9
            com.alibaba.fastjson.parser.ParserConfig r2 = r8.config     // Catch:{ all -> 0x00ec }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r2 = r2.getDeserializer(r6)     // Catch:{ all -> 0x00ec }
            boolean r2 = r2 instanceof com.alibaba.fastjson.parser.EnumDeserializer     // Catch:{ all -> 0x00ec }
            if (r2 == 0) goto L_0x01a9
            long r0 = r14.scanFieldSymbol(r0)     // Catch:{ all -> 0x00ec }
            int r2 = r14.matchStat     // Catch:{ all -> 0x00ec }
            if (r2 <= 0) goto L_0x019a
            java.lang.Enum r0 = r3.getEnumByHashCode(r0)     // Catch:{ all -> 0x00ec }
            r1 = 1
            r2 = 1
            goto L_0x01a2
        L_0x019a:
            int r0 = r14.matchStat     // Catch:{ all -> 0x00ec }
            if (r0 != r15) goto L_0x019f
            goto L_0x014a
        L_0x019f:
            r0 = 0
            r1 = 0
            r2 = 0
        L_0x01a2:
            r15 = r2
            r35 = 0
            r36 = 0
            r2 = r1
            goto L_0x013e
        L_0x01a9:
            java.lang.Class<int[]> r2 = int[].class
            if (r6 != r2) goto L_0x01bb
            int[] r0 = r14.scanFieldIntArray(r0)     // Catch:{ all -> 0x00ec }
            int r1 = r14.matchStat     // Catch:{ all -> 0x00ec }
            if (r1 <= 0) goto L_0x01b6
            goto L_0x0138
        L_0x01b6:
            int r1 = r14.matchStat     // Catch:{ all -> 0x00ec }
            if (r1 != r15) goto L_0x014e
            goto L_0x014a
        L_0x01bb:
            java.lang.Class<float[]> r2 = float[].class
            if (r6 != r2) goto L_0x01cf
            float[] r0 = r14.scanFieldFloatArray(r0)     // Catch:{ all -> 0x00ec }
            int r1 = r14.matchStat     // Catch:{ all -> 0x00ec }
            if (r1 <= 0) goto L_0x01c9
            goto L_0x0138
        L_0x01c9:
            int r1 = r14.matchStat     // Catch:{ all -> 0x00ec }
            if (r1 != r15) goto L_0x014e
            goto L_0x014a
        L_0x01cf:
            java.lang.Class<double[]> r2 = double[].class
            if (r6 != r2) goto L_0x01e3
            double[] r0 = r14.scanFieldDoubleArray(r0)     // Catch:{ all -> 0x00ec }
            int r1 = r14.matchStat     // Catch:{ all -> 0x00ec }
            if (r1 <= 0) goto L_0x01dd
            goto L_0x0138
        L_0x01dd:
            int r1 = r14.matchStat     // Catch:{ all -> 0x00ec }
            if (r1 != r15) goto L_0x014e
            goto L_0x014a
        L_0x01e3:
            java.lang.Class<float[][]> r2 = float[][].class
            if (r6 != r2) goto L_0x01f7
            float[][] r0 = r14.scanFieldFloatArray2(r0)     // Catch:{ all -> 0x00ec }
            int r1 = r14.matchStat     // Catch:{ all -> 0x00ec }
            if (r1 <= 0) goto L_0x01f1
            goto L_0x0138
        L_0x01f1:
            int r1 = r14.matchStat     // Catch:{ all -> 0x00ec }
            if (r1 != r15) goto L_0x014e
            goto L_0x014a
        L_0x01f7:
            java.lang.Class<double[][]> r2 = double[][].class
            if (r6 != r2) goto L_0x020b
            double[][] r0 = r14.scanFieldDoubleArray2(r0)     // Catch:{ all -> 0x00ec }
            int r1 = r14.matchStat     // Catch:{ all -> 0x00ec }
            if (r1 <= 0) goto L_0x0205
            goto L_0x0138
        L_0x0205:
            int r1 = r14.matchStat     // Catch:{ all -> 0x00ec }
            if (r1 != r15) goto L_0x014e
            goto L_0x014a
        L_0x020b:
            long r0 = r4.nameHashCode     // Catch:{ all -> 0x00ec }
            boolean r0 = r14.matchField(r0)     // Catch:{ all -> 0x00ec }
            if (r0 == 0) goto L_0x02e0
            r0 = r31
            r2 = 1
            goto L_0x02b2
        L_0x0218:
            double r31 = r14.scanFieldDouble(r0)     // Catch:{ all -> 0x00ec }
            int r0 = r14.matchStat     // Catch:{ all -> 0x00ec }
            if (r0 <= 0) goto L_0x0226
            r0 = r31
            r2 = 1
            r15 = 1
            goto L_0x02b3
        L_0x0226:
            int r0 = r14.matchStat     // Catch:{ all -> 0x00ec }
            if (r0 != r15) goto L_0x02af
            goto L_0x014a
        L_0x022c:
            float r30 = r14.scanFieldFloat(r0)     // Catch:{ all -> 0x00ec }
            int r0 = r14.matchStat     // Catch:{ all -> 0x00ec }
            if (r0 <= 0) goto L_0x0240
            r36 = r30
            r0 = r31
            r2 = 1
            r15 = 1
        L_0x023a:
            r32 = 0
            r35 = 0
            goto L_0x02b9
        L_0x0240:
            int r0 = r14.matchStat     // Catch:{ all -> 0x00ec }
            if (r0 != r15) goto L_0x0246
            goto L_0x014a
        L_0x0246:
            r36 = r30
            r0 = r31
            r2 = 0
            r15 = 0
            goto L_0x023a
        L_0x024d:
            boolean r0 = r14.scanFieldBoolean(r0)     // Catch:{ all -> 0x00ec }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x00ec }
            int r1 = r14.matchStat     // Catch:{ all -> 0x00ec }
            if (r1 <= 0) goto L_0x025b
            goto L_0x0138
        L_0x025b:
            int r1 = r14.matchStat     // Catch:{ all -> 0x00ec }
            if (r1 != r15) goto L_0x014e
            goto L_0x014a
        L_0x0261:
            long r0 = r14.scanFieldLong(r0)     // Catch:{ all -> 0x00ec }
            int r2 = r14.matchStat     // Catch:{ all -> 0x00ec }
            if (r2 <= 0) goto L_0x0278
            r2 = 1
            r15 = 1
        L_0x026b:
            r35 = 0
            r36 = 0
            r42 = r31
            r32 = 0
            r30 = r0
        L_0x0275:
            r0 = r42
            goto L_0x02bb
        L_0x0278:
            int r2 = r14.matchStat     // Catch:{ all -> 0x00ec }
            if (r2 != r15) goto L_0x027e
            goto L_0x014a
        L_0x027e:
            r2 = 0
            r15 = 0
            goto L_0x026b
        L_0x0281:
            int r0 = r14.scanFieldInt(r0)     // Catch:{ all -> 0x00ec }
            int r1 = r14.matchStat     // Catch:{ all -> 0x00ec }
            if (r1 <= 0) goto L_0x0292
            r35 = r0
            r0 = r31
            r2 = 1
            r15 = 1
        L_0x028f:
            r32 = 0
            goto L_0x02b7
        L_0x0292:
            int r1 = r14.matchStat     // Catch:{ all -> 0x00ec }
            if (r1 != r15) goto L_0x02a2
            goto L_0x014a
        L_0x0298:
            r0 = r46
            r6 = r48
            r1 = r33
            r2 = r34
            goto L_0x0425
        L_0x02a2:
            r35 = r0
            r0 = r31
            r2 = 0
            r15 = 0
            goto L_0x028f
        L_0x02a9:
            r33 = r1
            r34 = r2
            r48 = r15
        L_0x02af:
            r0 = r31
            r2 = 0
        L_0x02b2:
            r15 = 0
        L_0x02b3:
            r32 = 0
            r35 = 0
        L_0x02b7:
            r36 = 0
        L_0x02b9:
            r30 = r19
        L_0x02bb:
            if (r2 != 0) goto L_0x04c5
            r37 = r4
            com.alibaba.fastjson.parser.SymbolTable r4 = r8.symbolTable     // Catch:{ all -> 0x04bb }
            java.lang.String r4 = r14.scanSymbol(r4)     // Catch:{ all -> 0x04bb }
            if (r4 != 0) goto L_0x02ec
            r38 = r0
            int r0 = r14.token     // Catch:{ all -> 0x00ec }
            r1 = 13
            if (r0 != r1) goto L_0x02dc
            r1 = 16
            r14.nextToken(r1)     // Catch:{ all -> 0x00ec }
            r2 = r46
            r41 = r22
            r40 = r25
            goto L_0x040f
        L_0x02dc:
            r1 = 16
            if (r0 != r1) goto L_0x02ee
        L_0x02e0:
            r2 = r46
            r41 = r22
            r40 = r25
            r0 = r33
            r3 = 13
            goto L_0x0419
        L_0x02ec:
            r38 = r0
        L_0x02ee:
            java.lang.String r0 = "$ref"
            r1 = 58
            if (r0 != r4) goto L_0x03c5
            if (r22 == 0) goto L_0x03c5
            r14.nextTokenWithChar(r1)     // Catch:{ all -> 0x03bf }
            int r0 = r14.token     // Catch:{ all -> 0x03bf }
            r1 = 4
            if (r0 != r1) goto L_0x0399
            java.lang.String r0 = r14.stringVal()     // Catch:{ all -> 0x03bf }
            java.lang.String r1 = "@"
            boolean r1 = r1.equals(r0)     // Catch:{ all -> 0x03bf }
            if (r1 == 0) goto L_0x0316
            r1 = r22
            java.lang.Object r0 = r1.object     // Catch:{ all -> 0x0310 }
            r2 = r0
            goto L_0x0366
        L_0x0310:
            r0 = move-exception
            r11 = r1
            r10 = r21
            goto L_0x00f1
        L_0x0316:
            r1 = r22
            java.lang.String r2 = ".."
            boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x0395 }
            if (r2 == 0) goto L_0x0339
            com.alibaba.fastjson.parser.ParseContext r2 = r1.parent     // Catch:{ all -> 0x0310 }
            java.lang.Object r3 = r2.object     // Catch:{ all -> 0x0310 }
            if (r3 == 0) goto L_0x032b
            java.lang.Object r0 = r2.object     // Catch:{ all -> 0x0310 }
        L_0x0328:
            r21 = r0
            goto L_0x0336
        L_0x032b:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r3 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x0310 }
            r3.<init>(r2, r0)     // Catch:{ all -> 0x0310 }
            r8.addResolveTask(r3)     // Catch:{ all -> 0x0310 }
            r0 = 1
        L_0x0334:
            r8.resolveStatus = r0     // Catch:{ all -> 0x0310 }
        L_0x0336:
            r2 = r21
            goto L_0x0366
        L_0x0339:
            java.lang.String r2 = "$"
            boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x0395 }
            if (r2 == 0) goto L_0x035a
            r2 = r1
        L_0x0342:
            com.alibaba.fastjson.parser.ParseContext r3 = r2.parent     // Catch:{ all -> 0x0310 }
            if (r3 == 0) goto L_0x0349
            com.alibaba.fastjson.parser.ParseContext r2 = r2.parent     // Catch:{ all -> 0x0310 }
            goto L_0x0342
        L_0x0349:
            java.lang.Object r3 = r2.object     // Catch:{ all -> 0x0310 }
            if (r3 == 0) goto L_0x0350
            java.lang.Object r0 = r2.object     // Catch:{ all -> 0x0310 }
            goto L_0x0328
        L_0x0350:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r3 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x0310 }
            r3.<init>(r2, r0)     // Catch:{ all -> 0x0310 }
            r8.addResolveTask(r3)     // Catch:{ all -> 0x0310 }
            r0 = 1
            goto L_0x0334
        L_0x035a:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r2 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x0395 }
            r2.<init>(r1, r0)     // Catch:{ all -> 0x0395 }
            r8.addResolveTask(r2)     // Catch:{ all -> 0x0395 }
            r0 = 1
            r8.resolveStatus = r0     // Catch:{ all -> 0x0395 }
            goto L_0x0336
        L_0x0366:
            r0 = 13
            r14.nextToken(r0)     // Catch:{ all -> 0x038d }
            int r3 = r14.token     // Catch:{ all -> 0x038d }
            if (r3 != r0) goto L_0x0381
            r0 = 16
            r14.nextToken(r0)     // Catch:{ all -> 0x038d }
            r8.setContext(r1, r2, r9)     // Catch:{ all -> 0x038d }
            r3 = r25
            if (r3 == 0) goto L_0x037d
            r3.object = r2
        L_0x037d:
            r8.setContext(r1)
            return r2
        L_0x0381:
            r3 = r25
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x038b }
            java.lang.String r4 = "illegal ref"
            r0.<init>(r4)     // Catch:{ all -> 0x038b }
            throw r0     // Catch:{ all -> 0x038b }
        L_0x038b:
            r0 = move-exception
            goto L_0x0390
        L_0x038d:
            r0 = move-exception
            r3 = r25
        L_0x0390:
            r11 = r1
            r10 = r2
            r6 = r3
            goto L_0x07dc
        L_0x0395:
            r0 = move-exception
            r3 = r25
            goto L_0x03b9
        L_0x0399:
            r1 = r22
            r3 = r25
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x03b8 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x03b8 }
            r4.<init>()     // Catch:{ all -> 0x03b8 }
            java.lang.String r5 = "illegal ref, "
            r4.append(r5)     // Catch:{ all -> 0x03b8 }
            java.lang.String r0 = com.alibaba.fastjson.parser.JSONToken.name(r0)     // Catch:{ all -> 0x03b8 }
            r4.append(r0)     // Catch:{ all -> 0x03b8 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x03b8 }
            r2.<init>(r0)     // Catch:{ all -> 0x03b8 }
            throw r2     // Catch:{ all -> 0x03b8 }
        L_0x03b8:
            r0 = move-exception
        L_0x03b9:
            r11 = r1
            r6 = r3
        L_0x03bb:
            r10 = r21
            goto L_0x07dc
        L_0x03bf:
            r0 = move-exception
            r3 = r25
            r6 = r3
            goto L_0x04bf
        L_0x03c5:
            r41 = r22
            r40 = r25
            r0 = 1
            if (r33 == 0) goto L_0x03da
            r0 = r33
            boolean r22 = r0.equals(r4)     // Catch:{ all -> 0x03d5 }
            if (r22 != 0) goto L_0x03e2
            goto L_0x03dc
        L_0x03d5:
            r0 = move-exception
            r10 = r21
            goto L_0x0647
        L_0x03da:
            r0 = r33
        L_0x03dc:
            java.lang.String r1 = "@type"
            if (r1 != r4) goto L_0x04a4
            r1 = 58
        L_0x03e2:
            r14.nextTokenWithChar(r1)     // Catch:{ all -> 0x049b }
            int r1 = r14.token     // Catch:{ all -> 0x049b }
            r2 = 4
            if (r1 != r2) goto L_0x0488
            java.lang.String r1 = r14.stringVal()     // Catch:{ all -> 0x049b }
            r2 = 16
            r14.nextToken(r2)     // Catch:{ all -> 0x049b }
            r2 = r46
            boolean r3 = r2 instanceof java.lang.Class     // Catch:{ all -> 0x049b }
            if (r3 == 0) goto L_0x0429
            r3 = r2
            java.lang.Class r3 = (java.lang.Class) r3     // Catch:{ all -> 0x03d5 }
            java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x03d5 }
            boolean r3 = r1.equals(r3)     // Catch:{ all -> 0x03d5 }
            if (r3 == 0) goto L_0x0429
            int r1 = r14.token     // Catch:{ all -> 0x03d5 }
            r3 = 13
            if (r1 != r3) goto L_0x0419
            r14.nextToken()     // Catch:{ all -> 0x03d5 }
        L_0x040f:
            r14 = r26
            r6 = r40
            r11 = r41
            r18 = 0
            goto L_0x06a2
        L_0x0419:
            r6 = r48
            r1 = r0
            r0 = r2
            r3 = r28
            r2 = r34
            r25 = r40
            r22 = r41
        L_0x0425:
            r15 = 16
            goto L_0x00d8
        L_0x0429:
            com.alibaba.fastjson.parser.ParserConfig r3 = r8.config     // Catch:{ all -> 0x049b }
            com.alibaba.fastjson.parser.JavaBeanInfo r4 = r7.beanInfo     // Catch:{ all -> 0x049b }
            com.alibaba.fastjson.parser.JavaBeanDeserializer r3 = r7.getSeeAlso(r3, r4, r1)     // Catch:{ all -> 0x049b }
            if (r3 != 0) goto L_0x0460
            com.alibaba.fastjson.parser.ParserConfig r3 = r8.config     // Catch:{ all -> 0x03d5 }
            java.lang.Class<?> r4 = r7.clazz     // Catch:{ all -> 0x03d5 }
            int r5 = r14.features     // Catch:{ all -> 0x03d5 }
            java.lang.Class r3 = r3.checkAutoType(r1, r4, r5)     // Catch:{ all -> 0x03d5 }
            java.lang.Class r2 = com.alibaba.fastjson.util.TypeUtils.getClass(r46)     // Catch:{ all -> 0x03d5 }
            if (r2 == 0) goto L_0x0454
            if (r3 == 0) goto L_0x044c
            boolean r2 = r2.isAssignableFrom(r3)     // Catch:{ all -> 0x03d5 }
            if (r2 == 0) goto L_0x044c
            goto L_0x0454
        L_0x044c:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x03d5 }
            java.lang.String r1 = "type not match"
            r0.<init>(r1)     // Catch:{ all -> 0x03d5 }
            throw r0     // Catch:{ all -> 0x03d5 }
        L_0x0454:
            com.alibaba.fastjson.parser.ParserConfig r2 = r8.config     // Catch:{ all -> 0x03d5 }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r2 = r2.getDeserializer(r3)     // Catch:{ all -> 0x03d5 }
            r42 = r3
            r3 = r2
            r2 = r42
            goto L_0x0461
        L_0x0460:
            r2 = 0
        L_0x0461:
            boolean r4 = r3 instanceof com.alibaba.fastjson.parser.JavaBeanDeserializer     // Catch:{ all -> 0x049b }
            if (r4 == 0) goto L_0x0476
            com.alibaba.fastjson.parser.JavaBeanDeserializer r3 = (com.alibaba.fastjson.parser.JavaBeanDeserializer) r3     // Catch:{ all -> 0x03d5 }
            r4 = 0
            java.lang.Object r2 = r3.deserialze(r8, r2, r9, r4)     // Catch:{ all -> 0x03d5 }
            if (r0 == 0) goto L_0x047a
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r0 = r3.getFieldDeserializer(r0)     // Catch:{ all -> 0x03d5 }
            r0.setValue((java.lang.Object) r2, (java.lang.Object) r1)     // Catch:{ all -> 0x03d5 }
            goto L_0x047a
        L_0x0476:
            java.lang.Object r2 = r3.deserialze(r8, r2, r9)     // Catch:{ all -> 0x049b }
        L_0x047a:
            r1 = r40
            if (r1 == 0) goto L_0x0482
            r3 = r21
            r1.object = r3
        L_0x0482:
            r4 = r41
            r8.setContext(r4)
            return r2
        L_0x0488:
            r3 = r21
            r1 = r40
            r4 = r41
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0496 }
            java.lang.String r2 = "syntax error"
            r0.<init>(r2)     // Catch:{ all -> 0x0496 }
            throw r0     // Catch:{ all -> 0x0496 }
        L_0x0496:
            r0 = move-exception
            r6 = r1
            r10 = r3
            goto L_0x004b
        L_0x049b:
            r0 = move-exception
            r3 = r21
            r1 = r40
            r6 = r1
            r10 = r3
            goto L_0x0649
        L_0x04a4:
            r33 = r0
            r16 = r4
            r1 = r40
            r4 = r41
            r22 = 13
            r24 = 0
            r0 = r46
            goto L_0x04d5
        L_0x04b3:
            r0 = move-exception
            r1 = r40
            r6 = r1
            r10 = r21
            goto L_0x0649
        L_0x04bb:
            r0 = move-exception
            r1 = r25
            r6 = r1
        L_0x04bf:
            r10 = r21
            r11 = r22
            goto L_0x07dc
        L_0x04c5:
            r38 = r0
            r37 = r4
            r4 = r22
            r1 = r25
            r22 = 13
            r24 = 0
            r0 = r46
            r16 = r24
        L_0x04d5:
            if (r21 != 0) goto L_0x050b
            if (r26 != 0) goto L_0x050b
            r40 = r1
            java.lang.Object r1 = r44.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r45, (java.lang.reflect.Type) r46)     // Catch:{ all -> 0x0505 }
            if (r1 != 0) goto L_0x04f3
            r25 = r14
            java.util.HashMap r14 = new java.util.HashMap     // Catch:{ all -> 0x04f0 }
            r41 = r10
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r10 = r7.fieldDeserializers     // Catch:{ all -> 0x04f0 }
            int r10 = r10.length     // Catch:{ all -> 0x04f0 }
            r14.<init>(r10)     // Catch:{ all -> 0x04f0 }
            r26 = r14
            goto L_0x04f7
        L_0x04f0:
            r0 = move-exception
            r10 = r1
            goto L_0x0534
        L_0x04f3:
            r41 = r10
            r25 = r14
        L_0x04f7:
            if (r5 != 0) goto L_0x0503
            com.alibaba.fastjson.parser.ParseContext r10 = r8.setContext(r4, r1, r9)     // Catch:{ all -> 0x04f0 }
            r40 = r10
            r14 = r26
            r10 = r1
            goto L_0x0515
        L_0x0503:
            r10 = r1
            goto L_0x0513
        L_0x0505:
            r0 = move-exception
            r11 = r4
            r10 = r21
            goto L_0x07d4
        L_0x050b:
            r40 = r1
            r41 = r10
            r25 = r14
            r10 = r21
        L_0x0513:
            r14 = r26
        L_0x0515:
            if (r2 == 0) goto L_0x064d
            if (r15 != 0) goto L_0x0537
            r3.parseField(r8, r10, r0, r14)     // Catch:{ all -> 0x0533 }
            r21 = r5
            r16 = r11
            r0 = r25
            r23 = r33
            r17 = r34
            r15 = r41
            r18 = 0
            r22 = 4
            r11 = r4
            r25 = r10
            r10 = 13
            goto L_0x068f
        L_0x0533:
            r0 = move-exception
        L_0x0534:
            r11 = r4
            goto L_0x07d4
        L_0x0537:
            if (r10 != 0) goto L_0x0586
            java.lang.Class r1 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0533 }
            if (r6 == r1) goto L_0x0573
            if (r6 != r13) goto L_0x0540
            goto L_0x0573
        L_0x0540:
            java.lang.Class r1 = java.lang.Long.TYPE     // Catch:{ all -> 0x0533 }
            if (r6 == r1) goto L_0x056c
            if (r6 != r12) goto L_0x0547
            goto L_0x056c
        L_0x0547:
            java.lang.Class r1 = java.lang.Float.TYPE     // Catch:{ all -> 0x0533 }
            if (r6 == r1) goto L_0x0562
            if (r6 != r11) goto L_0x054e
            goto L_0x0562
        L_0x054e:
            java.lang.Class r1 = java.lang.Double.TYPE     // Catch:{ all -> 0x0533 }
            r15 = r41
            if (r6 == r1) goto L_0x055a
            if (r6 != r15) goto L_0x0557
            goto L_0x055a
        L_0x0557:
            r1 = r32
            goto L_0x0579
        L_0x055a:
            java.lang.Double r1 = new java.lang.Double     // Catch:{ all -> 0x0533 }
            r2 = r38
            r1.<init>(r2)     // Catch:{ all -> 0x0533 }
            goto L_0x0579
        L_0x0562:
            r15 = r41
            java.lang.Float r1 = new java.lang.Float     // Catch:{ all -> 0x0533 }
            r2 = r36
            r1.<init>(r2)     // Catch:{ all -> 0x0533 }
            goto L_0x0579
        L_0x056c:
            r15 = r41
            java.lang.Long r1 = java.lang.Long.valueOf(r30)     // Catch:{ all -> 0x0533 }
            goto L_0x0579
        L_0x0573:
            r15 = r41
            java.lang.Integer r1 = java.lang.Integer.valueOf(r35)     // Catch:{ all -> 0x0533 }
        L_0x0579:
            r2 = r37
            java.lang.String r2 = r2.name     // Catch:{ all -> 0x0533 }
            r14.put(r2, r1)     // Catch:{ all -> 0x0533 }
            r41 = r4
            r21 = r5
            goto L_0x0628
        L_0x0586:
            r21 = r5
            r2 = r36
            r1 = r37
            r15 = r41
            r41 = r4
            r4 = r38
            if (r32 != 0) goto L_0x0623
            java.lang.Class r0 = java.lang.Integer.TYPE     // Catch:{ IllegalAccessException -> 0x0609 }
            if (r6 == r0) goto L_0x05f4
            if (r6 != r13) goto L_0x059b
            goto L_0x05f4
        L_0x059b:
            java.lang.Class r0 = java.lang.Long.TYPE     // Catch:{ IllegalAccessException -> 0x0609 }
            if (r6 == r0) goto L_0x05df
            if (r6 != r12) goto L_0x05a2
            goto L_0x05df
        L_0x05a2:
            java.lang.Class r0 = java.lang.Float.TYPE     // Catch:{ IllegalAccessException -> 0x0609 }
            if (r6 == r0) goto L_0x05cd
            if (r6 != r11) goto L_0x05a9
            goto L_0x05cd
        L_0x05a9:
            java.lang.Class r0 = java.lang.Double.TYPE     // Catch:{ IllegalAccessException -> 0x0609 }
            if (r6 == r0) goto L_0x05b7
            if (r6 != r15) goto L_0x05b0
            goto L_0x05b7
        L_0x05b0:
            r0 = r32
            r3.setValue((java.lang.Object) r10, (java.lang.Object) r0)     // Catch:{ IllegalAccessException -> 0x0609 }
            goto L_0x0628
        L_0x05b7:
            boolean r0 = r1.fieldAccess     // Catch:{ IllegalAccessException -> 0x0609 }
            if (r0 == 0) goto L_0x05c4
            java.lang.Class r0 = java.lang.Double.TYPE     // Catch:{ IllegalAccessException -> 0x0609 }
            if (r6 != r0) goto L_0x05c4
            r3.setValue((java.lang.Object) r10, (double) r4)     // Catch:{ IllegalAccessException -> 0x0609 }
            goto L_0x0628
        L_0x05c4:
            java.lang.Double r0 = new java.lang.Double     // Catch:{ IllegalAccessException -> 0x0609 }
            r0.<init>(r4)     // Catch:{ IllegalAccessException -> 0x0609 }
        L_0x05c9:
            r3.setValue((java.lang.Object) r10, (java.lang.Object) r0)     // Catch:{ IllegalAccessException -> 0x0609 }
            goto L_0x0628
        L_0x05cd:
            boolean r0 = r1.fieldAccess     // Catch:{ IllegalAccessException -> 0x0609 }
            if (r0 == 0) goto L_0x05d9
            java.lang.Class r0 = java.lang.Float.TYPE     // Catch:{ IllegalAccessException -> 0x0609 }
            if (r6 != r0) goto L_0x05d9
            r3.setValue((java.lang.Object) r10, (float) r2)     // Catch:{ IllegalAccessException -> 0x0609 }
            goto L_0x0628
        L_0x05d9:
            java.lang.Float r0 = new java.lang.Float     // Catch:{ IllegalAccessException -> 0x0609 }
            r0.<init>(r2)     // Catch:{ IllegalAccessException -> 0x0609 }
            goto L_0x05c9
        L_0x05df:
            boolean r0 = r1.fieldAccess     // Catch:{ IllegalAccessException -> 0x0609 }
            if (r0 == 0) goto L_0x05ed
            java.lang.Class r0 = java.lang.Long.TYPE     // Catch:{ IllegalAccessException -> 0x0609 }
            if (r6 != r0) goto L_0x05ed
            r4 = r30
            r3.setValue((java.lang.Object) r10, (long) r4)     // Catch:{ IllegalAccessException -> 0x0609 }
            goto L_0x0628
        L_0x05ed:
            r4 = r30
            java.lang.Long r0 = java.lang.Long.valueOf(r4)     // Catch:{ IllegalAccessException -> 0x0609 }
            goto L_0x05c9
        L_0x05f4:
            boolean r0 = r1.fieldAccess     // Catch:{ IllegalAccessException -> 0x0609 }
            if (r0 == 0) goto L_0x0602
            java.lang.Class r0 = java.lang.Integer.TYPE     // Catch:{ IllegalAccessException -> 0x0609 }
            if (r6 != r0) goto L_0x0602
            r0 = r35
            r3.setValue((java.lang.Object) r10, (int) r0)     // Catch:{ IllegalAccessException -> 0x0609 }
            goto L_0x0628
        L_0x0602:
            r0 = r35
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ IllegalAccessException -> 0x0609 }
            goto L_0x05c9
        L_0x0609:
            r0 = move-exception
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0646 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0646 }
            r3.<init>()     // Catch:{ all -> 0x0646 }
            java.lang.String r4 = "set property error, "
            r3.append(r4)     // Catch:{ all -> 0x0646 }
            java.lang.String r1 = r1.name     // Catch:{ all -> 0x0646 }
            r3.append(r1)     // Catch:{ all -> 0x0646 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0646 }
            r2.<init>(r1, r0)     // Catch:{ all -> 0x0646 }
            throw r2     // Catch:{ all -> 0x0646 }
        L_0x0623:
            r0 = r32
            r3.setValue((java.lang.Object) r10, (java.lang.Object) r0)     // Catch:{ all -> 0x0646 }
        L_0x0628:
            r0 = r25
            int r1 = r0.matchStat     // Catch:{ all -> 0x0646 }
            r3 = 4
            r25 = r10
            if (r1 != r3) goto L_0x0637
            r11 = r41
            r18 = 0
            goto L_0x069e
        L_0x0637:
            r16 = r11
            r23 = r33
            r17 = r34
            r11 = r41
            r10 = 13
            r18 = 0
            r22 = 4
            goto L_0x068f
        L_0x0646:
            r0 = move-exception
        L_0x0647:
            r6 = r40
        L_0x0649:
            r11 = r41
            goto L_0x07dc
        L_0x064d:
            r21 = r5
            r0 = r25
            r23 = r33
            r15 = r41
            r3 = 4
            r41 = r4
            r1 = r44
            r17 = r34
            r4 = 0
            r2 = r45
            r5 = 1
            r6 = 13
            r18 = 0
            r22 = 4
            r3 = r16
            r16 = r11
            r11 = r41
            r4 = r10
            r25 = r10
            r10 = 1
            r5 = r46
            r10 = 13
            r6 = r14
            boolean r1 = r1.parseField(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x07d1 }
            if (r1 != 0) goto L_0x0689
            int r1 = r0.token     // Catch:{ all -> 0x07d1 }
            if (r1 != r10) goto L_0x0683
            r0.nextToken()     // Catch:{ all -> 0x07d1 }
            goto L_0x069e
        L_0x0683:
            r1 = 0
            r2 = 16
        L_0x0686:
            r4 = 1
            goto L_0x0790
        L_0x0689:
            int r1 = r0.token     // Catch:{ all -> 0x07d1 }
            r2 = 17
            if (r1 == r2) goto L_0x07c9
        L_0x068f:
            int r1 = r0.token     // Catch:{ all -> 0x07d1 }
            r2 = 16
            if (r1 != r2) goto L_0x0697
            r1 = 0
            goto L_0x0686
        L_0x0697:
            int r1 = r0.token     // Catch:{ all -> 0x07d1 }
            if (r1 != r10) goto L_0x0784
            r0.nextToken(r2)     // Catch:{ all -> 0x07d1 }
        L_0x069e:
            r21 = r25
            r6 = r40
        L_0x06a2:
            if (r21 != 0) goto L_0x077a
            if (r14 != 0) goto L_0x06bd
            java.lang.Object r1 = r44.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r45, (java.lang.reflect.Type) r46)     // Catch:{ all -> 0x0777 }
            if (r6 != 0) goto L_0x06b5
            com.alibaba.fastjson.parser.ParseContext r6 = r8.setContext(r11, r1, r9)     // Catch:{ all -> 0x06b1 }
            goto L_0x06b5
        L_0x06b1:
            r0 = move-exception
            r10 = r1
            goto L_0x07dc
        L_0x06b5:
            if (r6 == 0) goto L_0x06b9
            r6.object = r1
        L_0x06b9:
            r8.setContext(r11)
            return r1
        L_0x06bd:
            com.alibaba.fastjson.parser.JavaBeanInfo r0 = r7.beanInfo     // Catch:{ all -> 0x0777 }
            java.lang.String[] r0 = r0.creatorConstructorParameters     // Catch:{ all -> 0x0777 }
            if (r0 == 0) goto L_0x06c5
            int r1 = r0.length     // Catch:{ all -> 0x0777 }
            goto L_0x06c8
        L_0x06c5:
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r1 = r7.fieldDeserializers     // Catch:{ all -> 0x0777 }
            int r1 = r1.length     // Catch:{ all -> 0x0777 }
        L_0x06c8:
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ all -> 0x0777 }
            r3 = 0
        L_0x06cb:
            if (r3 >= r1) goto L_0x06ef
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r4 = r7.fieldDeserializers     // Catch:{ all -> 0x0777 }
            r4 = r4[r3]     // Catch:{ all -> 0x0777 }
            com.alibaba.fastjson.util.FieldInfo r4 = r4.fieldInfo     // Catch:{ all -> 0x0777 }
            if (r0 == 0) goto L_0x06dc
            java.lang.String r5 = r4.name     // Catch:{ all -> 0x0777 }
            java.lang.Object r5 = r14.remove(r5)     // Catch:{ all -> 0x0777 }
            goto L_0x06e2
        L_0x06dc:
            java.lang.String r5 = r4.name     // Catch:{ all -> 0x0777 }
            java.lang.Object r5 = r14.get(r5)     // Catch:{ all -> 0x0777 }
        L_0x06e2:
            if (r5 != 0) goto L_0x06ea
            java.lang.Class<?> r4 = r4.fieldClass     // Catch:{ all -> 0x0777 }
            java.lang.Object r5 = com.alibaba.fastjson.util.TypeUtils.defaultValue(r4)     // Catch:{ all -> 0x0777 }
        L_0x06ea:
            r2[r3] = r5     // Catch:{ all -> 0x0777 }
            int r3 = r3 + 1
            goto L_0x06cb
        L_0x06ef:
            com.alibaba.fastjson.parser.JavaBeanInfo r1 = r7.beanInfo     // Catch:{ all -> 0x0777 }
            java.lang.reflect.Constructor<?> r1 = r1.creatorConstructor     // Catch:{ all -> 0x0777 }
            if (r1 == 0) goto L_0x0747
            com.alibaba.fastjson.parser.JavaBeanInfo r1 = r7.beanInfo     // Catch:{ Exception -> 0x0727 }
            java.lang.reflect.Constructor<?> r1 = r1.creatorConstructor     // Catch:{ Exception -> 0x0727 }
            java.lang.Object r1 = r1.newInstance(r2)     // Catch:{ Exception -> 0x0727 }
            if (r0 == 0) goto L_0x077c
            java.util.Set r0 = r14.entrySet()     // Catch:{ all -> 0x06b1 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x06b1 }
        L_0x0707:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x06b1 }
            if (r2 == 0) goto L_0x077c
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x06b1 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x06b1 }
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x06b1 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x06b1 }
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r3 = r7.getFieldDeserializer(r3)     // Catch:{ all -> 0x06b1 }
            if (r3 == 0) goto L_0x0707
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x06b1 }
            r3.setValue((java.lang.Object) r1, (java.lang.Object) r2)     // Catch:{ all -> 0x06b1 }
            goto L_0x0707
        L_0x0727:
            r0 = move-exception
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0777 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0777 }
            r2.<init>()     // Catch:{ all -> 0x0777 }
            java.lang.String r3 = "create instance error, "
            r2.append(r3)     // Catch:{ all -> 0x0777 }
            com.alibaba.fastjson.parser.JavaBeanInfo r3 = r7.beanInfo     // Catch:{ all -> 0x0777 }
            java.lang.reflect.Constructor<?> r3 = r3.creatorConstructor     // Catch:{ all -> 0x0777 }
            java.lang.String r3 = r3.toGenericString()     // Catch:{ all -> 0x0777 }
            r2.append(r3)     // Catch:{ all -> 0x0777 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0777 }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x0777 }
            throw r1     // Catch:{ all -> 0x0777 }
        L_0x0747:
            com.alibaba.fastjson.parser.JavaBeanInfo r0 = r7.beanInfo     // Catch:{ all -> 0x0777 }
            java.lang.reflect.Method r0 = r0.factoryMethod     // Catch:{ all -> 0x0777 }
            if (r0 == 0) goto L_0x077a
            com.alibaba.fastjson.parser.JavaBeanInfo r0 = r7.beanInfo     // Catch:{ Exception -> 0x0757 }
            java.lang.reflect.Method r0 = r0.factoryMethod     // Catch:{ Exception -> 0x0757 }
            r1 = 0
            java.lang.Object r21 = r0.invoke(r1, r2)     // Catch:{ Exception -> 0x0757 }
            goto L_0x077a
        L_0x0757:
            r0 = move-exception
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0777 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0777 }
            r2.<init>()     // Catch:{ all -> 0x0777 }
            java.lang.String r3 = "create factory method error, "
            r2.append(r3)     // Catch:{ all -> 0x0777 }
            com.alibaba.fastjson.parser.JavaBeanInfo r3 = r7.beanInfo     // Catch:{ all -> 0x0777 }
            java.lang.reflect.Method r3 = r3.factoryMethod     // Catch:{ all -> 0x0777 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0777 }
            r2.append(r3)     // Catch:{ all -> 0x0777 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0777 }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x0777 }
            throw r1     // Catch:{ all -> 0x0777 }
        L_0x0777:
            r0 = move-exception
            goto L_0x03bb
        L_0x077a:
            r1 = r21
        L_0x077c:
            if (r6 == 0) goto L_0x0780
            r6.object = r1
        L_0x0780:
            r8.setContext(r11)
            return r1
        L_0x0784:
            r1 = 0
            int r3 = r0.token     // Catch:{ all -> 0x07d1 }
            r4 = 18
            if (r3 == r4) goto L_0x07ac
            int r3 = r0.token     // Catch:{ all -> 0x07d1 }
            r4 = 1
            if (r3 == r4) goto L_0x07ac
        L_0x0790:
            r6 = r48
            r22 = r11
            r26 = r14
            r10 = r15
            r11 = r16
            r2 = r17
            r5 = r21
            r1 = r23
            r21 = r25
            r3 = r28
            r25 = r40
            r15 = 16
            r14 = r0
            r0 = r46
            goto L_0x00d8
        L_0x07ac:
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x07d1 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x07d1 }
            r2.<init>()     // Catch:{ all -> 0x07d1 }
            java.lang.String r3 = "syntax error, unexpect token "
            r2.append(r3)     // Catch:{ all -> 0x07d1 }
            int r0 = r0.token     // Catch:{ all -> 0x07d1 }
            java.lang.String r0 = com.alibaba.fastjson.parser.JSONToken.name(r0)     // Catch:{ all -> 0x07d1 }
            r2.append(r0)     // Catch:{ all -> 0x07d1 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x07d1 }
            r1.<init>(r0)     // Catch:{ all -> 0x07d1 }
            throw r1     // Catch:{ all -> 0x07d1 }
        L_0x07c9:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x07d1 }
            java.lang.String r1 = "syntax error, unexpect token ':'"
            r0.<init>(r1)     // Catch:{ all -> 0x07d1 }
            throw r0     // Catch:{ all -> 0x07d1 }
        L_0x07d1:
            r0 = move-exception
            r10 = r25
        L_0x07d4:
            r6 = r40
            goto L_0x07dc
        L_0x07d7:
            r0 = move-exception
            r11 = r4
            r1 = r6
            r10 = r48
        L_0x07dc:
            if (r6 == 0) goto L_0x07e0
            r6.object = r10
        L_0x07e0:
            r8.setContext(r11)
            throw r0
        L_0x07e4:
            java.lang.Object r0 = r45.parse()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JavaBeanDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0113, code lost:
        throw new com.alibaba.fastjson.JSONException("not match string. feild : " + r19);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T> T deserialzeArrayMapping(com.alibaba.fastjson.parser.DefaultJSONParser r17, java.lang.reflect.Type r18, java.lang.Object r19, java.lang.Object r20) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            com.alibaba.fastjson.parser.JSONLexer r2 = r0.lexer
            java.lang.Object r3 = r16.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r17, (java.lang.reflect.Type) r18)
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r4 = r1.sortedFieldDeserializers
            int r4 = r4.length
            r5 = 0
        L_0x000e:
            r6 = 16
            r7 = 44
            if (r5 >= r4) goto L_0x030c
            int r8 = r4 + -1
            r9 = 93
            if (r5 != r8) goto L_0x001d
            r8 = 93
            goto L_0x001f
        L_0x001d:
            r8 = 44
        L_0x001f:
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r10 = r1.sortedFieldDeserializers
            r10 = r10[r5]
            com.alibaba.fastjson.util.FieldInfo r11 = r10.fieldInfo
            java.lang.Class<?> r12 = r11.fieldClass
            java.lang.Class r13 = java.lang.Integer.TYPE     // Catch:{ IllegalAccessException -> 0x02f7 }
            r14 = 15
            if (r12 != r13) goto L_0x007a
            long r12 = r2.scanLongValue()     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r8 = (int) r12     // Catch:{ IllegalAccessException -> 0x02f7 }
            boolean r12 = r11.fieldAccess     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r12 == 0) goto L_0x003c
            java.lang.reflect.Field r10 = r11.field     // Catch:{ IllegalAccessException -> 0x02f7 }
            r10.setInt(r3, r8)     // Catch:{ IllegalAccessException -> 0x02f7 }
            goto L_0x0044
        L_0x003c:
            java.lang.Integer r12 = new java.lang.Integer     // Catch:{ IllegalAccessException -> 0x02f7 }
            r12.<init>(r8)     // Catch:{ IllegalAccessException -> 0x02f7 }
            r10.setValue((java.lang.Object) r3, (java.lang.Object) r12)     // Catch:{ IllegalAccessException -> 0x02f7 }
        L_0x0044:
            char r8 = r2.ch     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r8 != r7) goto L_0x005f
            int r7 = r2.bp     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r7 = r7 + 1
            r2.bp = r7     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r8 = r2.len     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r7 < r8) goto L_0x0055
            r7 = 26
            goto L_0x005b
        L_0x0055:
            java.lang.String r8 = r2.text     // Catch:{ IllegalAccessException -> 0x02f7 }
            char r7 = r8.charAt(r7)     // Catch:{ IllegalAccessException -> 0x02f7 }
        L_0x005b:
            r2.ch = r7     // Catch:{ IllegalAccessException -> 0x02f7 }
            goto L_0x00d6
        L_0x005f:
            char r6 = r2.ch     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r6 != r9) goto L_0x00f4
            int r6 = r2.bp     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r6 = r6 + 1
            r2.bp = r6     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r7 = r2.len     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r6 < r7) goto L_0x0070
            r6 = 26
            goto L_0x0076
        L_0x0070:
            java.lang.String r7 = r2.text     // Catch:{ IllegalAccessException -> 0x02f7 }
            char r6 = r7.charAt(r6)     // Catch:{ IllegalAccessException -> 0x02f7 }
        L_0x0076:
            r2.ch = r6     // Catch:{ IllegalAccessException -> 0x02f7 }
            goto L_0x00f1
        L_0x007a:
            java.lang.Class<java.lang.String> r13 = java.lang.String.class
            r15 = 34
            if (r12 != r13) goto L_0x0114
            char r8 = r2.ch     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r8 != r15) goto L_0x0089
            java.lang.String r8 = r2.scanStringValue(r15)     // Catch:{ IllegalAccessException -> 0x02f7 }
            goto L_0x00b1
        L_0x0089:
            char r8 = r2.ch     // Catch:{ IllegalAccessException -> 0x02f7 }
            r12 = 110(0x6e, float:1.54E-43)
            if (r8 != r12) goto L_0x00fb
            java.lang.String r8 = r2.text     // Catch:{ IllegalAccessException -> 0x02f7 }
            java.lang.String r12 = "null"
            int r13 = r2.bp     // Catch:{ IllegalAccessException -> 0x02f7 }
            boolean r8 = r8.startsWith(r12, r13)     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r8 == 0) goto L_0x00fb
            int r8 = r2.bp     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r8 = r8 + 4
            r2.bp = r8     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r12 = r2.len     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r8 < r12) goto L_0x00a8
            r8 = 26
            goto L_0x00ae
        L_0x00a8:
            java.lang.String r12 = r2.text     // Catch:{ IllegalAccessException -> 0x02f7 }
            char r8 = r12.charAt(r8)     // Catch:{ IllegalAccessException -> 0x02f7 }
        L_0x00ae:
            r2.ch = r8     // Catch:{ IllegalAccessException -> 0x02f7 }
            r8 = 0
        L_0x00b1:
            boolean r12 = r11.fieldAccess     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r12 == 0) goto L_0x00bb
            java.lang.reflect.Field r10 = r11.field     // Catch:{ IllegalAccessException -> 0x02f7 }
            r10.set(r3, r8)     // Catch:{ IllegalAccessException -> 0x02f7 }
            goto L_0x00be
        L_0x00bb:
            r10.setValue((java.lang.Object) r3, (java.lang.Object) r8)     // Catch:{ IllegalAccessException -> 0x02f7 }
        L_0x00be:
            char r8 = r2.ch     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r8 != r7) goto L_0x00d9
            int r7 = r2.bp     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r7 = r7 + 1
            r2.bp = r7     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r8 = r2.len     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r7 < r8) goto L_0x00cf
            r7 = 26
            goto L_0x005b
        L_0x00cf:
            java.lang.String r8 = r2.text     // Catch:{ IllegalAccessException -> 0x02f7 }
            char r7 = r8.charAt(r7)     // Catch:{ IllegalAccessException -> 0x02f7 }
            goto L_0x005b
        L_0x00d6:
            r2.token = r6     // Catch:{ IllegalAccessException -> 0x02f7 }
            goto L_0x00f7
        L_0x00d9:
            char r6 = r2.ch     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r6 != r9) goto L_0x00f4
            int r6 = r2.bp     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r6 = r6 + 1
            r2.bp = r6     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r7 = r2.len     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r6 < r7) goto L_0x00ea
            r6 = 26
            goto L_0x0076
        L_0x00ea:
            java.lang.String r7 = r2.text     // Catch:{ IllegalAccessException -> 0x02f7 }
            char r6 = r7.charAt(r6)     // Catch:{ IllegalAccessException -> 0x02f7 }
            goto L_0x0076
        L_0x00f1:
            r2.token = r14     // Catch:{ IllegalAccessException -> 0x02f7 }
            goto L_0x00f7
        L_0x00f4:
            r2.nextToken()     // Catch:{ IllegalAccessException -> 0x02f7 }
        L_0x00f7:
            r13 = r19
            goto L_0x02f3
        L_0x00fb:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ IllegalAccessException -> 0x02f7 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IllegalAccessException -> 0x02f7 }
            r2.<init>()     // Catch:{ IllegalAccessException -> 0x02f7 }
            java.lang.String r3 = "not match string. feild : "
            r2.append(r3)     // Catch:{ IllegalAccessException -> 0x02f7 }
            r13 = r19
            r2.append(r13)     // Catch:{ IllegalAccessException -> 0x02f7 }
            java.lang.String r2 = r2.toString()     // Catch:{ IllegalAccessException -> 0x02f7 }
            r0.<init>(r2)     // Catch:{ IllegalAccessException -> 0x02f7 }
            throw r0     // Catch:{ IllegalAccessException -> 0x02f7 }
        L_0x0114:
            r13 = r19
            java.lang.Class r15 = java.lang.Long.TYPE     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r12 != r15) goto L_0x0168
            long r14 = r2.scanLongValue()     // Catch:{ IllegalAccessException -> 0x02f7 }
            boolean r8 = r11.fieldAccess     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r8 == 0) goto L_0x0128
            java.lang.reflect.Field r8 = r11.field     // Catch:{ IllegalAccessException -> 0x02f7 }
            r8.setLong(r3, r14)     // Catch:{ IllegalAccessException -> 0x02f7 }
            goto L_0x0130
        L_0x0128:
            java.lang.Long r8 = new java.lang.Long     // Catch:{ IllegalAccessException -> 0x02f7 }
            r8.<init>(r14)     // Catch:{ IllegalAccessException -> 0x02f7 }
            r10.setValue((java.lang.Object) r3, (java.lang.Object) r8)     // Catch:{ IllegalAccessException -> 0x02f7 }
        L_0x0130:
            char r8 = r2.ch     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r8 != r7) goto L_0x014b
            int r7 = r2.bp     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r7 = r7 + 1
            r2.bp = r7     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r8 = r2.len     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r7 < r8) goto L_0x0141
            r7 = 26
            goto L_0x0147
        L_0x0141:
            java.lang.String r8 = r2.text     // Catch:{ IllegalAccessException -> 0x02f7 }
            char r7 = r8.charAt(r7)     // Catch:{ IllegalAccessException -> 0x02f7 }
        L_0x0147:
            r2.ch = r7     // Catch:{ IllegalAccessException -> 0x02f7 }
            goto L_0x026a
        L_0x014b:
            char r6 = r2.ch     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r6 != r9) goto L_0x0288
            int r6 = r2.bp     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r6 = r6 + 1
            r2.bp = r6     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r7 = r2.len     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r6 < r7) goto L_0x015c
            r6 = 26
            goto L_0x0162
        L_0x015c:
            java.lang.String r7 = r2.text     // Catch:{ IllegalAccessException -> 0x02f7 }
            char r6 = r7.charAt(r6)     // Catch:{ IllegalAccessException -> 0x02f7 }
        L_0x0162:
            r2.ch = r6     // Catch:{ IllegalAccessException -> 0x02f7 }
            r6 = 15
            goto L_0x026a
        L_0x0168:
            java.lang.Class r14 = java.lang.Boolean.TYPE     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r12 != r14) goto L_0x01b1
            boolean r8 = r2.scanBoolean()     // Catch:{ IllegalAccessException -> 0x02f7 }
            boolean r12 = r11.fieldAccess     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r12 == 0) goto L_0x017a
            java.lang.reflect.Field r10 = r11.field     // Catch:{ IllegalAccessException -> 0x02f7 }
            r10.setBoolean(r3, r8)     // Catch:{ IllegalAccessException -> 0x02f7 }
            goto L_0x0181
        L_0x017a:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch:{ IllegalAccessException -> 0x02f7 }
            r10.setValue((java.lang.Object) r3, (java.lang.Object) r8)     // Catch:{ IllegalAccessException -> 0x02f7 }
        L_0x0181:
            char r8 = r2.ch     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r8 != r7) goto L_0x0199
            int r7 = r2.bp     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r7 = r7 + 1
            r2.bp = r7     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r8 = r2.len     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r7 < r8) goto L_0x0192
            r7 = 26
            goto L_0x0147
        L_0x0192:
            java.lang.String r8 = r2.text     // Catch:{ IllegalAccessException -> 0x02f7 }
            char r7 = r8.charAt(r7)     // Catch:{ IllegalAccessException -> 0x02f7 }
            goto L_0x0147
        L_0x0199:
            char r6 = r2.ch     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r6 != r9) goto L_0x0288
            int r6 = r2.bp     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r6 = r6 + 1
            r2.bp = r6     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r7 = r2.len     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r6 < r7) goto L_0x01aa
            r6 = 26
            goto L_0x0162
        L_0x01aa:
            java.lang.String r7 = r2.text     // Catch:{ IllegalAccessException -> 0x02f7 }
            char r6 = r7.charAt(r6)     // Catch:{ IllegalAccessException -> 0x02f7 }
            goto L_0x0162
        L_0x01b1:
            boolean r14 = r12.isEnum()     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r14 == 0) goto L_0x023a
            char r8 = r2.ch     // Catch:{ IllegalAccessException -> 0x02f7 }
            r14 = 34
            if (r8 != r14) goto L_0x01cc
            com.alibaba.fastjson.parser.SymbolTable r8 = r0.symbolTable     // Catch:{ IllegalAccessException -> 0x02f7 }
            java.lang.String r8 = r2.scanSymbol(r8)     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r8 != 0) goto L_0x01c7
            r8 = 0
            goto L_0x01e8
        L_0x01c7:
            java.lang.Enum r8 = java.lang.Enum.valueOf(r12, r8)     // Catch:{ IllegalAccessException -> 0x02f7 }
            goto L_0x01e8
        L_0x01cc:
            r12 = 48
            if (r8 < r12) goto L_0x021f
            r12 = 57
            if (r8 > r12) goto L_0x021f
            long r14 = r2.scanLongValue()     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r8 = (int) r14     // Catch:{ IllegalAccessException -> 0x02f7 }
            r12 = r10
            com.alibaba.fastjson.parser.DefaultFieldDeserializer r12 = (com.alibaba.fastjson.parser.DefaultFieldDeserializer) r12     // Catch:{ IllegalAccessException -> 0x02f7 }
            com.alibaba.fastjson.parser.ParserConfig r14 = r0.config     // Catch:{ IllegalAccessException -> 0x02f7 }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r12 = r12.getFieldValueDeserilizer(r14)     // Catch:{ IllegalAccessException -> 0x02f7 }
            com.alibaba.fastjson.parser.EnumDeserializer r12 = (com.alibaba.fastjson.parser.EnumDeserializer) r12     // Catch:{ IllegalAccessException -> 0x02f7 }
            java.lang.Enum[] r12 = r12.ordinalEnums     // Catch:{ IllegalAccessException -> 0x02f7 }
            r8 = r12[r8]     // Catch:{ IllegalAccessException -> 0x02f7 }
        L_0x01e8:
            r10.setValue((java.lang.Object) r3, (java.lang.Object) r8)     // Catch:{ IllegalAccessException -> 0x02f7 }
            char r8 = r2.ch     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r8 != r7) goto L_0x0205
            int r7 = r2.bp     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r7 = r7 + 1
            r2.bp = r7     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r8 = r2.len     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r7 < r8) goto L_0x01fd
            r7 = 26
            goto L_0x0147
        L_0x01fd:
            java.lang.String r8 = r2.text     // Catch:{ IllegalAccessException -> 0x02f7 }
            char r7 = r8.charAt(r7)     // Catch:{ IllegalAccessException -> 0x02f7 }
            goto L_0x0147
        L_0x0205:
            char r6 = r2.ch     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r6 != r9) goto L_0x0288
            int r6 = r2.bp     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r6 = r6 + 1
            r2.bp = r6     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r7 = r2.len     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r6 < r7) goto L_0x0217
            r6 = 26
            goto L_0x0162
        L_0x0217:
            java.lang.String r7 = r2.text     // Catch:{ IllegalAccessException -> 0x02f7 }
            char r6 = r7.charAt(r6)     // Catch:{ IllegalAccessException -> 0x02f7 }
            goto L_0x0162
        L_0x021f:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ IllegalAccessException -> 0x02f7 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IllegalAccessException -> 0x02f7 }
            r3.<init>()     // Catch:{ IllegalAccessException -> 0x02f7 }
            java.lang.String r4 = "illegal enum."
            r3.append(r4)     // Catch:{ IllegalAccessException -> 0x02f7 }
            java.lang.String r2 = r2.info()     // Catch:{ IllegalAccessException -> 0x02f7 }
            r3.append(r2)     // Catch:{ IllegalAccessException -> 0x02f7 }
            java.lang.String r2 = r3.toString()     // Catch:{ IllegalAccessException -> 0x02f7 }
            r0.<init>(r2)     // Catch:{ IllegalAccessException -> 0x02f7 }
            throw r0     // Catch:{ IllegalAccessException -> 0x02f7 }
        L_0x023a:
            java.lang.Class<java.util.Date> r14 = java.util.Date.class
            if (r12 != r14) goto L_0x028c
            char r12 = r2.ch     // Catch:{ IllegalAccessException -> 0x02f7 }
            r14 = 49
            if (r12 != r14) goto L_0x028c
            long r14 = r2.scanLongValue()     // Catch:{ IllegalAccessException -> 0x02f7 }
            java.util.Date r8 = new java.util.Date     // Catch:{ IllegalAccessException -> 0x02f7 }
            r8.<init>(r14)     // Catch:{ IllegalAccessException -> 0x02f7 }
            r10.setValue((java.lang.Object) r3, (java.lang.Object) r8)     // Catch:{ IllegalAccessException -> 0x02f7 }
            char r8 = r2.ch     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r8 != r7) goto L_0x026e
            int r7 = r2.bp     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r7 = r7 + 1
            r2.bp = r7     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r8 = r2.len     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r7 < r8) goto L_0x0262
            r7 = 26
            goto L_0x0147
        L_0x0262:
            java.lang.String r8 = r2.text     // Catch:{ IllegalAccessException -> 0x02f7 }
            char r7 = r8.charAt(r7)     // Catch:{ IllegalAccessException -> 0x02f7 }
            goto L_0x0147
        L_0x026a:
            r2.token = r6     // Catch:{ IllegalAccessException -> 0x02f7 }
            goto L_0x02f3
        L_0x026e:
            char r6 = r2.ch     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r6 != r9) goto L_0x0288
            int r6 = r2.bp     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r6 = r6 + 1
            r2.bp = r6     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r7 = r2.len     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r6 < r7) goto L_0x0280
            r6 = 26
            goto L_0x0162
        L_0x0280:
            java.lang.String r7 = r2.text     // Catch:{ IllegalAccessException -> 0x02f7 }
            char r6 = r7.charAt(r6)     // Catch:{ IllegalAccessException -> 0x02f7 }
            goto L_0x0162
        L_0x0288:
            r2.nextToken()     // Catch:{ IllegalAccessException -> 0x02f7 }
            goto L_0x02f3
        L_0x028c:
            char r12 = r2.ch     // Catch:{ IllegalAccessException -> 0x02f7 }
            r14 = 91
            if (r12 != r14) goto L_0x02ac
            int r12 = r2.bp     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r12 = r12 + 1
            r2.bp = r12     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r14 = r2.len     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r12 < r14) goto L_0x029f
            r12 = 26
            goto L_0x02a5
        L_0x029f:
            java.lang.String r14 = r2.text     // Catch:{ IllegalAccessException -> 0x02f7 }
            char r12 = r14.charAt(r12)     // Catch:{ IllegalAccessException -> 0x02f7 }
        L_0x02a5:
            r2.ch = r12     // Catch:{ IllegalAccessException -> 0x02f7 }
            r12 = 14
            r2.token = r12     // Catch:{ IllegalAccessException -> 0x02f7 }
            goto L_0x02cf
        L_0x02ac:
            char r12 = r2.ch     // Catch:{ IllegalAccessException -> 0x02f7 }
            r14 = 123(0x7b, float:1.72E-43)
            if (r12 != r14) goto L_0x02cc
            int r12 = r2.bp     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r12 = r12 + 1
            r2.bp = r12     // Catch:{ IllegalAccessException -> 0x02f7 }
            int r14 = r2.len     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r12 < r14) goto L_0x02bf
            r12 = 26
            goto L_0x02c5
        L_0x02bf:
            java.lang.String r14 = r2.text     // Catch:{ IllegalAccessException -> 0x02f7 }
            char r12 = r14.charAt(r12)     // Catch:{ IllegalAccessException -> 0x02f7 }
        L_0x02c5:
            r2.ch = r12     // Catch:{ IllegalAccessException -> 0x02f7 }
            r12 = 12
            r2.token = r12     // Catch:{ IllegalAccessException -> 0x02f7 }
            goto L_0x02cf
        L_0x02cc:
            r2.nextToken()     // Catch:{ IllegalAccessException -> 0x02f7 }
        L_0x02cf:
            java.lang.reflect.Type r12 = r11.fieldType     // Catch:{ IllegalAccessException -> 0x02f7 }
            r14 = 0
            r10.parseField(r0, r3, r12, r14)     // Catch:{ IllegalAccessException -> 0x02f7 }
            java.lang.String r10 = "syntax error"
            if (r8 != r9) goto L_0x02e6
            int r6 = r2.token     // Catch:{ IllegalAccessException -> 0x02f7 }
            r7 = 15
            if (r6 != r7) goto L_0x02e0
            goto L_0x02f3
        L_0x02e0:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ IllegalAccessException -> 0x02f7 }
            r0.<init>(r10)     // Catch:{ IllegalAccessException -> 0x02f7 }
            throw r0     // Catch:{ IllegalAccessException -> 0x02f7 }
        L_0x02e6:
            if (r8 != r7) goto L_0x02f3
            int r7 = r2.token     // Catch:{ IllegalAccessException -> 0x02f7 }
            if (r7 != r6) goto L_0x02ed
            goto L_0x02f3
        L_0x02ed:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ IllegalAccessException -> 0x02f7 }
            r0.<init>(r10)     // Catch:{ IllegalAccessException -> 0x02f7 }
            throw r0     // Catch:{ IllegalAccessException -> 0x02f7 }
        L_0x02f3:
            int r5 = r5 + 1
            goto L_0x000e
        L_0x02f7:
            r0 = move-exception
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            java.lang.String r3 = "set "
            java.lang.StringBuilder r3 = a.a.a.a.a.n(r3)
            java.lang.String r4 = r11.name
            java.lang.String r5 = "error"
            java.lang.String r3 = a.a.a.a.a.m(r3, r4, r5)
            r2.<init>(r3, r0)
            throw r2
        L_0x030c:
            char r0 = r2.ch
            if (r0 != r7) goto L_0x0328
            int r0 = r2.bp
            int r0 = r0 + 1
            r2.bp = r0
            int r4 = r2.len
            if (r0 < r4) goto L_0x031d
            r0 = 26
            goto L_0x0323
        L_0x031d:
            java.lang.String r4 = r2.text
            char r0 = r4.charAt(r0)
        L_0x0323:
            r2.ch = r0
            r2.token = r6
            goto L_0x032b
        L_0x0328:
            r2.nextToken()
        L_0x032b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JavaBeanDeserializer.deserialzeArrayMapping(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    private boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map) {
        boolean z;
        DefaultJSONParser defaultJSONParser2 = defaultJSONParser;
        String str2 = str;
        Object obj2 = obj;
        JSONLexer jSONLexer = defaultJSONParser2.lexer;
        FieldDeserializer fieldDeserializer = getFieldDeserializer(str2);
        if (fieldDeserializer == null) {
            long fnv_64_lower = TypeUtils.fnv_64_lower(str);
            if (this.smartMatchHashArray == null) {
                long[] jArr = new long[this.sortedFieldDeserializers.length];
                int i = 0;
                while (true) {
                    FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                    if (i >= fieldDeserializerArr.length) {
                        break;
                    }
                    jArr[i] = TypeUtils.fnv_64_lower(fieldDeserializerArr[i].fieldInfo.name);
                    i++;
                }
                Arrays.sort(jArr);
                this.smartMatchHashArray = jArr;
            }
            int binarySearch = Arrays.binarySearch(this.smartMatchHashArray, fnv_64_lower);
            if (binarySearch < 0) {
                z = str2.startsWith(ReflectiveProperty.PREFIX_IS);
                if (z) {
                    binarySearch = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv_64_lower(str2.substring(2)));
                }
            } else {
                z = false;
            }
            if (binarySearch >= 0) {
                if (this.smartMatchHashArrayMapping == null) {
                    int[] iArr = new int[this.smartMatchHashArray.length];
                    Arrays.fill(iArr, -1);
                    int i2 = 0;
                    while (true) {
                        FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                        if (i2 >= fieldDeserializerArr2.length) {
                            break;
                        }
                        int binarySearch2 = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv_64_lower(fieldDeserializerArr2[i2].fieldInfo.name));
                        if (binarySearch2 >= 0) {
                            iArr[binarySearch2] = i2;
                        }
                        i2++;
                    }
                    this.smartMatchHashArrayMapping = iArr;
                }
                int i3 = this.smartMatchHashArrayMapping[binarySearch];
                if (i3 != -1) {
                    fieldDeserializer = this.sortedFieldDeserializers[i3];
                    Class<?> cls = fieldDeserializer.fieldInfo.fieldClass;
                    if (!(!z || cls == Boolean.TYPE || cls == Boolean.class)) {
                        fieldDeserializer = null;
                    }
                }
            }
        }
        int i4 = Feature.SupportNonPublicField.mask;
        if (fieldDeserializer == null && !((defaultJSONParser2.lexer.features & i4) == 0 && (i4 & this.beanInfo.parserFeatures) == 0)) {
            if (this.extraFieldDeserializers == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(1, 0.75f, 1);
                Class cls2 = this.clazz;
                while (cls2 != null && cls2 != Object.class) {
                    for (Field field : cls2.getDeclaredFields()) {
                        String name = field.getName();
                        if (getFieldDeserializer(name) == null) {
                            int modifiers = field.getModifiers();
                            if ((modifiers & 16) == 0 && (modifiers & 8) == 0) {
                                concurrentHashMap.put(name, field);
                            }
                        }
                    }
                    cls2 = cls2.getSuperclass();
                }
                this.extraFieldDeserializers = concurrentHashMap;
            }
            Object obj3 = this.extraFieldDeserializers.get(str2);
            if (obj3 != null) {
                if (obj3 instanceof FieldDeserializer) {
                    fieldDeserializer = (FieldDeserializer) obj3;
                } else {
                    Field field2 = (Field) obj3;
                    field2.setAccessible(true);
                    fieldDeserializer = new DefaultFieldDeserializer(defaultJSONParser2.config, this.clazz, new FieldInfo(str, field2.getDeclaringClass(), field2.getType(), field2.getGenericType(), field2, 0, 0));
                    this.extraFieldDeserializers.put(str2, fieldDeserializer);
                }
            }
        }
        if (fieldDeserializer == null) {
            parseExtra(defaultJSONParser2, obj2, str2);
            return false;
        }
        jSONLexer.nextTokenWithChar(':');
        fieldDeserializer.parseField(defaultJSONParser2, obj2, type, map);
        return true;
    }

    public Object createInstance(DefaultJSONParser defaultJSONParser, Type type) {
        if (!(type instanceof Class) || !this.clazz.isInterface()) {
            JavaBeanInfo javaBeanInfo = this.beanInfo;
            if (javaBeanInfo.defaultConstructor == null && javaBeanInfo.factoryMethod == null) {
                return null;
            }
            JavaBeanInfo javaBeanInfo2 = this.beanInfo;
            if (javaBeanInfo2.factoryMethod != null && javaBeanInfo2.defaultConstructorParameterSize > 0) {
                return null;
            }
            try {
                Constructor<?> constructor = this.beanInfo.defaultConstructor;
                Object newInstance = this.beanInfo.defaultConstructorParameterSize == 0 ? constructor != null ? constructor.newInstance(new Object[0]) : this.beanInfo.factoryMethod.invoke((Object) null, new Object[0]) : constructor.newInstance(new Object[]{defaultJSONParser.contex.object});
                if (!(defaultJSONParser == null || (defaultJSONParser.lexer.features & Feature.InitStringFieldAsEmpty.mask) == 0)) {
                    for (FieldInfo fieldInfo : this.beanInfo.fields) {
                        if (fieldInfo.fieldClass == String.class) {
                            fieldInfo.set(newInstance, "");
                        }
                    }
                }
                return newInstance;
            } catch (Exception e2) {
                StringBuilder n = a.n("create instance error, class ");
                n.append(this.clazz.getName());
                throw new JSONException(n.toString(), e2);
            }
        } else {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new JSONObject((defaultJSONParser.lexer.features & Feature.OrderedField.mask) != 0));
        }
    }

    public Object createInstance(Map<String, Object> map, ParserConfig parserConfig) {
        JavaBeanInfo javaBeanInfo = this.beanInfo;
        if (javaBeanInfo.creatorConstructor == null) {
            Object createInstance = createInstance((DefaultJSONParser) null, (Type) this.clazz);
            for (Map.Entry next : map.entrySet()) {
                FieldDeserializer fieldDeserializer = getFieldDeserializer((String) next.getKey());
                if (fieldDeserializer != null) {
                    Object value = next.getValue();
                    FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                    Method method = fieldInfo.method;
                    if (method != null) {
                        method.invoke(createInstance, new Object[]{TypeUtils.cast(value, method.getGenericParameterTypes()[0], parserConfig)});
                    } else {
                        fieldInfo.field.set(createInstance, TypeUtils.cast(value, fieldInfo.fieldType, parserConfig));
                    }
                }
            }
            return createInstance;
        }
        FieldInfo[] fieldInfoArr = javaBeanInfo.fields;
        int length = fieldInfoArr.length;
        Object[] objArr = new Object[length];
        for (int i = 0; i < length; i++) {
            FieldInfo fieldInfo2 = fieldInfoArr[i];
            Object obj = map.get(fieldInfo2.name);
            if (obj == null) {
                obj = TypeUtils.defaultValue(fieldInfo2.fieldClass);
            }
            objArr[i] = obj;
        }
        Constructor<?> constructor = this.beanInfo.creatorConstructor;
        if (constructor == null) {
            return null;
        }
        try {
            return constructor.newInstance(objArr);
        } catch (Exception e2) {
            StringBuilder n = a.n("create instance error, ");
            n.append(this.beanInfo.creatorConstructor.toGenericString());
            throw new JSONException(n.toString(), e2);
        }
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return deserialze(defaultJSONParser, type, obj, (Object) null);
    }

    public FieldDeserializer getFieldDeserializer(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        if (this.beanInfo.ordered) {
            while (true) {
                FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                if (i >= fieldDeserializerArr.length) {
                    return null;
                }
                FieldDeserializer fieldDeserializer = fieldDeserializerArr[i];
                if (fieldDeserializer.fieldInfo.name.equalsIgnoreCase(str)) {
                    return fieldDeserializer;
                }
                i++;
            }
        } else {
            int length = this.sortedFieldDeserializers.length - 1;
            while (i <= length) {
                int i2 = (i + length) >>> 1;
                int compareTo = this.sortedFieldDeserializers[i2].fieldInfo.name.compareTo(str);
                if (compareTo < 0) {
                    i = i2 + 1;
                } else if (compareTo <= 0) {
                    return this.sortedFieldDeserializers[i2];
                } else {
                    length = i2 - 1;
                }
            }
            Map<String, FieldDeserializer> map = this.alterNameFieldDeserializers;
            if (map != null) {
                return map.get(str);
            }
            return null;
        }
    }

    public FieldDeserializer getFieldDeserializerByHash(long j) {
        int i = 0;
        while (true) {
            FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
            if (i >= fieldDeserializerArr.length) {
                return null;
            }
            FieldDeserializer fieldDeserializer = fieldDeserializerArr[i];
            if (fieldDeserializer.fieldInfo.nameHashCode == j) {
                return fieldDeserializer;
            }
            i++;
        }
    }

    public JavaBeanDeserializer getSeeAlso(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, String str) {
        JSONType jSONType = javaBeanInfo.jsonType;
        if (jSONType == null) {
            return null;
        }
        for (Class deserializer : jSONType.seeAlso()) {
            ObjectDeserializer deserializer2 = parserConfig.getDeserializer(deserializer);
            if (deserializer2 instanceof JavaBeanDeserializer) {
                JavaBeanDeserializer javaBeanDeserializer = (JavaBeanDeserializer) deserializer2;
                JavaBeanInfo javaBeanInfo2 = javaBeanDeserializer.beanInfo;
                if (javaBeanInfo2.typeName.equals(str)) {
                    return javaBeanDeserializer;
                }
                JavaBeanDeserializer seeAlso = getSeeAlso(parserConfig, javaBeanInfo2, str);
                if (seeAlso != null) {
                    return seeAlso;
                }
            }
        }
        return null;
    }

    public void parseExtra(DefaultJSONParser defaultJSONParser, Object obj, String str) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if ((jSONLexer.features & Feature.IgnoreNotMatch.mask) != 0) {
            jSONLexer.nextTokenWithChar(':');
            Type type = null;
            List<ExtraTypeProvider> list = defaultJSONParser.extraTypeProviders;
            if (list != null) {
                for (ExtraTypeProvider extraType : list) {
                    type = extraType.getExtraType(obj, str);
                }
            }
            Object parse = type == null ? defaultJSONParser.parse() : defaultJSONParser.parseObject(type);
            if (obj instanceof ExtraProcessable) {
                ((ExtraProcessable) obj).processExtra(str, parse);
                return;
            }
            List<ExtraProcessor> list2 = defaultJSONParser.extraProcessors;
            if (list2 != null) {
                for (ExtraProcessor processExtra : list2) {
                    processExtra.processExtra(obj, str, parse);
                }
                return;
            }
            return;
        }
        StringBuilder n = a.n("setter not found, class ");
        n.append(this.clazz.getName());
        n.append(", property ");
        n.append(str);
        throw new JSONException(n.toString());
    }
}
