package com.alibaba.fastjson.parser;

public class ThrowableDeserializer extends JavaBeanDeserializer {
    public ThrowableDeserializer(ParserConfig parserConfig, Class<?> cls) {
        super(parserConfig, cls, cls);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: java.lang.StackTraceElement[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: java.lang.reflect.Type} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v18, resolved type: java.lang.reflect.Constructor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v19, resolved type: java.lang.reflect.Constructor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: java.lang.reflect.Constructor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v20, resolved type: java.lang.reflect.Constructor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v21, resolved type: java.lang.reflect.Constructor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: java.lang.reflect.Constructor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: java.lang.reflect.Constructor} */
    /* JADX WARNING: type inference failed for: r0v6, types: [com.alibaba.fastjson.parser.deserializer.ObjectDeserializer] */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0125, code lost:
        r10 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0125, code lost:
        r10 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (java.lang.Throwable.class.isAssignableFrom(r2) != false) goto L_0x0036;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0155 A[Catch:{ Exception -> 0x01a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0186  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r19, java.lang.reflect.Type r20, java.lang.Object r21) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            r2 = r20
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            com.alibaba.fastjson.parser.JSONLexer r4 = r0.lexer
            int r5 = r4.token
            r6 = 8
            r7 = 0
            if (r5 != r6) goto L_0x0015
            r4.nextToken()
            return r7
        L_0x0015:
            int r8 = r0.resolveStatus
            java.lang.String r9 = "syntax error"
            r10 = 2
            r11 = 0
            if (r8 != r10) goto L_0x0020
            r0.resolveStatus = r11
            goto L_0x0024
        L_0x0020:
            r8 = 12
            if (r5 != r8) goto L_0x01ad
        L_0x0024:
            if (r2 == 0) goto L_0x0035
            boolean r5 = r2 instanceof java.lang.Class
            if (r5 == 0) goto L_0x0035
            java.lang.Class r2 = (java.lang.Class) r2
            java.lang.Class<java.lang.Throwable> r5 = java.lang.Throwable.class
            boolean r5 = r5.isAssignableFrom(r2)
            if (r5 == 0) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            r2 = r7
        L_0x0036:
            r5 = r7
            r8 = r5
            r12 = r8
            r13 = r12
        L_0x003a:
            com.alibaba.fastjson.parser.SymbolTable r14 = r0.symbolTable
            java.lang.String r14 = r4.scanSymbol(r14)
            r15 = 13
            r10 = 16
            if (r14 != 0) goto L_0x0054
            int r11 = r4.token
            if (r11 != r15) goto L_0x004f
        L_0x004a:
            r4.nextToken(r10)
            goto L_0x00d2
        L_0x004f:
            if (r11 != r10) goto L_0x0054
        L_0x0051:
            r10 = 2
            r11 = 0
            goto L_0x003a
        L_0x0054:
            r11 = 58
            r4.nextTokenWithChar(r11)
            java.lang.String r11 = "@type"
            boolean r11 = r11.equals(r14)
            r15 = 4
            if (r11 == 0) goto L_0x007c
            int r2 = r4.token
            if (r2 != r15) goto L_0x0076
            java.lang.String r2 = r4.stringVal()
            com.alibaba.fastjson.parser.ParserConfig r11 = r0.config
            java.lang.ClassLoader r11 = r11.defaultClassLoader
            java.lang.Class r2 = com.alibaba.fastjson.util.TypeUtils.loadClass(r2, r11)
            r4.nextToken(r10)
            goto L_0x00ca
        L_0x0076:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            r0.<init>(r9)
            throw r0
        L_0x007c:
            java.lang.String r11 = "message"
            boolean r11 = r11.equals(r14)
            if (r11 == 0) goto L_0x009b
            int r11 = r4.token
            if (r11 != r6) goto L_0x008a
            r12 = r7
            goto L_0x0091
        L_0x008a:
            if (r11 != r15) goto L_0x0095
            java.lang.String r11 = r4.stringVal()
            r12 = r11
        L_0x0091:
            r4.nextToken()
            goto L_0x00ca
        L_0x0095:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            r0.<init>(r9)
            throw r0
        L_0x009b:
            java.lang.String r11 = "cause"
            boolean r15 = r11.equals(r14)
            if (r15 == 0) goto L_0x00aa
            java.lang.Object r8 = r1.deserialze(r0, r7, r11)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            goto L_0x00ca
        L_0x00aa:
            java.lang.String r11 = "stackTrace"
            boolean r11 = r11.equals(r14)
            if (r11 == 0) goto L_0x00bc
            java.lang.Class<java.lang.StackTraceElement[]> r11 = java.lang.StackTraceElement[].class
            java.lang.Object r11 = r0.parseObject(r11)
            r13 = r11
            java.lang.StackTraceElement[] r13 = (java.lang.StackTraceElement[]) r13
            goto L_0x00ca
        L_0x00bc:
            if (r5 != 0) goto L_0x00c3
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
        L_0x00c3:
            java.lang.Object r11 = r19.parse()
            r5.put(r14, r11)
        L_0x00ca:
            int r11 = r4.token
            r14 = 13
            if (r11 != r14) goto L_0x01aa
            goto L_0x004a
        L_0x00d2:
            if (r2 != 0) goto L_0x00db
            java.lang.Exception r3 = new java.lang.Exception
            r3.<init>(r12, r8)
            goto L_0x015a
        L_0x00db:
            java.lang.reflect.Constructor[] r4 = r2.getConstructors()     // Catch:{ Exception -> 0x01a1 }
            int r6 = r4.length     // Catch:{ Exception -> 0x01a1 }
            r10 = r7
            r11 = r10
            r14 = r11
            r9 = 0
        L_0x00e4:
            r15 = 1
            if (r9 >= r6) goto L_0x0129
            r17 = r4[r9]     // Catch:{ Exception -> 0x01a1 }
            java.lang.Class[] r7 = r17.getParameterTypes()     // Catch:{ Exception -> 0x01a1 }
            int r7 = r7.length     // Catch:{ Exception -> 0x01a1 }
            if (r7 != 0) goto L_0x00f3
            r14 = r17
            goto L_0x0125
        L_0x00f3:
            java.lang.Class[] r7 = r17.getParameterTypes()     // Catch:{ Exception -> 0x01a1 }
            int r7 = r7.length     // Catch:{ Exception -> 0x01a1 }
            if (r7 != r15) goto L_0x0107
            java.lang.Class[] r7 = r17.getParameterTypes()     // Catch:{ Exception -> 0x01a1 }
            r16 = 0
            r7 = r7[r16]     // Catch:{ Exception -> 0x01a1 }
            if (r7 != r3) goto L_0x0107
            r11 = r17
            goto L_0x0125
        L_0x0107:
            java.lang.Class[] r7 = r17.getParameterTypes()     // Catch:{ Exception -> 0x01a1 }
            int r7 = r7.length     // Catch:{ Exception -> 0x01a1 }
            r15 = 2
            if (r7 != r15) goto L_0x0125
            java.lang.Class[] r7 = r17.getParameterTypes()     // Catch:{ Exception -> 0x01a1 }
            r15 = 0
            r7 = r7[r15]     // Catch:{ Exception -> 0x01a1 }
            if (r7 != r3) goto L_0x0125
            java.lang.Class[] r7 = r17.getParameterTypes()     // Catch:{ Exception -> 0x01a1 }
            r15 = 1
            r7 = r7[r15]     // Catch:{ Exception -> 0x01a1 }
            java.lang.Class<java.lang.Throwable> r15 = java.lang.Throwable.class
            if (r7 != r15) goto L_0x0125
            r10 = r17
        L_0x0125:
            int r9 = r9 + 1
            r7 = 0
            goto L_0x00e4
        L_0x0129:
            if (r10 == 0) goto L_0x013b
            r7 = 2
            java.lang.Object[] r3 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x01a1 }
            r4 = 0
            r3[r4] = r12     // Catch:{ Exception -> 0x01a1 }
            r4 = 1
            r3[r4] = r8     // Catch:{ Exception -> 0x01a1 }
            java.lang.Object r3 = r10.newInstance(r3)     // Catch:{ Exception -> 0x01a1 }
        L_0x0138:
            java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch:{ Exception -> 0x01a1 }
            goto L_0x0153
        L_0x013b:
            if (r11 == 0) goto L_0x0148
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01a1 }
            r4 = 0
            r3[r4] = r12     // Catch:{ Exception -> 0x01a1 }
            java.lang.Object r3 = r11.newInstance(r3)     // Catch:{ Exception -> 0x01a1 }
            goto L_0x0138
        L_0x0148:
            if (r14 == 0) goto L_0x0152
            r10 = 0
            java.lang.Object[] r3 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x01a1 }
            java.lang.Object r3 = r14.newInstance(r3)     // Catch:{ Exception -> 0x01a1 }
            goto L_0x0138
        L_0x0152:
            r3 = 0
        L_0x0153:
            if (r3 != 0) goto L_0x015a
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ Exception -> 0x01a1 }
            r3.<init>(r12, r8)     // Catch:{ Exception -> 0x01a1 }
        L_0x015a:
            if (r13 == 0) goto L_0x015f
            r3.setStackTrace(r13)
        L_0x015f:
            if (r5 == 0) goto L_0x01a0
            if (r2 == 0) goto L_0x0177
            java.lang.Class<?> r4 = r1.clazz
            if (r2 != r4) goto L_0x0169
            r7 = r1
            goto L_0x0178
        L_0x0169:
            com.alibaba.fastjson.parser.ParserConfig r0 = r0.config
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r0 = r0.getDeserializer(r2)
            boolean r2 = r0 instanceof com.alibaba.fastjson.parser.JavaBeanDeserializer
            if (r2 == 0) goto L_0x0177
            r7 = r0
            com.alibaba.fastjson.parser.JavaBeanDeserializer r7 = (com.alibaba.fastjson.parser.JavaBeanDeserializer) r7
            goto L_0x0178
        L_0x0177:
            r7 = 0
        L_0x0178:
            java.util.Set r0 = r5.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0180:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x01a0
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r4 = r2.getKey()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r2 = r2.getValue()
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r4 = r7.getFieldDeserializer(r4)
            if (r4 == 0) goto L_0x0180
            r4.setValue((java.lang.Object) r3, (java.lang.Object) r2)
            goto L_0x0180
        L_0x01a0:
            return r3
        L_0x01a1:
            r0 = move-exception
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            java.lang.String r3 = "create instance error"
            r2.<init>(r3, r0)
            throw r2
        L_0x01aa:
            r7 = 0
            goto L_0x0051
        L_0x01ad:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            r0.<init>(r9)
            goto L_0x01b4
        L_0x01b3:
            throw r0
        L_0x01b4:
            goto L_0x01b3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.ThrowableDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object):java.lang.Object");
    }
}
