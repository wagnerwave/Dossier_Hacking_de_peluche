package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MapDeserializer implements ObjectDeserializer {
    public static MapDeserializer instance = new MapDeserializer();

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0061, code lost:
        r15.nextTokenWithChar(':');
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0066, code lost:
        if (r15.token != 4) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0068, code lost:
        r12 = r15.stringVal();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0072, code lost:
        if ("..".equals(r12) == false) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0074, code lost:
        r12 = r3.parent;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007d, code lost:
        if ("$".equals(r12) == false) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007f, code lost:
        r12 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0082, code lost:
        if (r12.parent == null) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0084, code lost:
        r12 = r12.parent;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0087, code lost:
        r12 = r12.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008a, code lost:
        r11.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r3, r12));
        r11.resolveStatus = 1;
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0095, code lost:
        r15.nextToken(13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009a, code lost:
        if (r15.token != 13) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009c, code lost:
        r15.nextToken(16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a1, code lost:
        r11.setContext(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a4, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ac, code lost:
        throw new com.alibaba.fastjson.JSONException("illegal ref");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c7, code lost:
        throw new com.alibaba.fastjson.JSONException("illegal ref, " + com.alibaba.fastjson.parser.JSONToken.name(r4));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object parseMap(com.alibaba.fastjson.parser.DefaultJSONParser r11, java.util.Map<java.lang.Object, java.lang.Object> r12, java.lang.reflect.Type r13, java.lang.reflect.Type r14, java.lang.Object r15) {
        /*
            com.alibaba.fastjson.parser.JSONLexer r15 = r11.lexer
            int r0 = r15.token
            r1 = 16
            r2 = 12
            if (r0 == r2) goto L_0x0024
            if (r0 != r1) goto L_0x000d
            goto L_0x0024
        L_0x000d:
            com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException
            java.lang.String r12 = "syntax error, expect {, actual "
            java.lang.StringBuilder r12 = a.a.a.a.a.n(r12)
            java.lang.String r13 = com.alibaba.fastjson.parser.JSONToken.name(r0)
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x0024:
            com.alibaba.fastjson.parser.ParserConfig r0 = r11.config
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r0 = r0.getDeserializer(r13)
            com.alibaba.fastjson.parser.ParserConfig r2 = r11.config
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r2 = r2.getDeserializer(r14)
            r15.nextToken()
            com.alibaba.fastjson.parser.ParseContext r3 = r11.contex
        L_0x0035:
            int r4 = r15.token     // Catch:{ all -> 0x013c }
            r5 = 13
            if (r4 != r5) goto L_0x0042
            r15.nextToken(r1)     // Catch:{ all -> 0x013c }
            r11.setContext(r3)
            return r12
        L_0x0042:
            r1 = 58
            r6 = 1
            r7 = 4
            if (r4 != r7) goto L_0x00c8
            int r8 = r15.sp     // Catch:{ all -> 0x013c }
            if (r8 != r7) goto L_0x00c8
            java.lang.String r8 = r15.text     // Catch:{ all -> 0x013c }
            java.lang.String r9 = "$ref"
            int r10 = r15.np     // Catch:{ all -> 0x013c }
            int r10 = r10 + r6
            boolean r8 = r8.startsWith(r9, r10)     // Catch:{ all -> 0x013c }
            if (r8 == 0) goto L_0x00c8
            com.alibaba.fastjson.parser.Feature r8 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect     // Catch:{ all -> 0x013c }
            boolean r8 = r15.isEnabled(r8)     // Catch:{ all -> 0x013c }
            if (r8 != 0) goto L_0x00c8
            r15.nextTokenWithChar(r1)     // Catch:{ all -> 0x013c }
            int r12 = r15.token     // Catch:{ all -> 0x013c }
            if (r12 != r7) goto L_0x00ad
            java.lang.String r12 = r15.stringVal()     // Catch:{ all -> 0x013c }
            java.lang.String r13 = ".."
            boolean r13 = r13.equals(r12)     // Catch:{ all -> 0x013c }
            if (r13 == 0) goto L_0x0077
            com.alibaba.fastjson.parser.ParseContext r12 = r3.parent     // Catch:{ all -> 0x013c }
            goto L_0x0087
        L_0x0077:
            java.lang.String r13 = "$"
            boolean r13 = r13.equals(r12)     // Catch:{ all -> 0x013c }
            if (r13 == 0) goto L_0x008a
            r12 = r3
        L_0x0080:
            com.alibaba.fastjson.parser.ParseContext r13 = r12.parent     // Catch:{ all -> 0x013c }
            if (r13 == 0) goto L_0x0087
            com.alibaba.fastjson.parser.ParseContext r12 = r12.parent     // Catch:{ all -> 0x013c }
            goto L_0x0080
        L_0x0087:
            java.lang.Object r12 = r12.object     // Catch:{ all -> 0x013c }
            goto L_0x0095
        L_0x008a:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r13 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x013c }
            r13.<init>(r3, r12)     // Catch:{ all -> 0x013c }
            r11.addResolveTask(r13)     // Catch:{ all -> 0x013c }
            r11.resolveStatus = r6     // Catch:{ all -> 0x013c }
            r12 = 0
        L_0x0095:
            r15.nextToken(r5)     // Catch:{ all -> 0x013c }
            int r13 = r15.token     // Catch:{ all -> 0x013c }
            if (r13 != r5) goto L_0x00a5
            r13 = 16
            r15.nextToken(r13)     // Catch:{ all -> 0x013c }
            r11.setContext(r3)
            return r12
        L_0x00a5:
            com.alibaba.fastjson.JSONException r12 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x013c }
            java.lang.String r13 = "illegal ref"
            r12.<init>(r13)     // Catch:{ all -> 0x013c }
            throw r12     // Catch:{ all -> 0x013c }
        L_0x00ad:
            com.alibaba.fastjson.JSONException r12 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x013c }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x013c }
            r13.<init>()     // Catch:{ all -> 0x013c }
            java.lang.String r14 = "illegal ref, "
            r13.append(r14)     // Catch:{ all -> 0x013c }
            java.lang.String r14 = com.alibaba.fastjson.parser.JSONToken.name(r4)     // Catch:{ all -> 0x013c }
            r13.append(r14)     // Catch:{ all -> 0x013c }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x013c }
            r12.<init>(r13)     // Catch:{ all -> 0x013c }
            throw r12     // Catch:{ all -> 0x013c }
        L_0x00c8:
            int r8 = r12.size()     // Catch:{ all -> 0x013c }
            if (r8 != 0) goto L_0x00fa
            if (r4 != r7) goto L_0x00fa
            java.lang.String r4 = "@type"
            java.lang.String r7 = r15.stringVal()     // Catch:{ all -> 0x013c }
            boolean r4 = r4.equals(r7)     // Catch:{ all -> 0x013c }
            if (r4 == 0) goto L_0x00fa
            com.alibaba.fastjson.parser.Feature r4 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect     // Catch:{ all -> 0x013c }
            boolean r4 = r15.isEnabled(r4)     // Catch:{ all -> 0x013c }
            if (r4 != 0) goto L_0x00fa
            r15.nextTokenWithChar(r1)     // Catch:{ all -> 0x013c }
            r1 = 16
            r15.nextToken(r1)     // Catch:{ all -> 0x013c }
            int r1 = r15.token     // Catch:{ all -> 0x013c }
            if (r1 != r5) goto L_0x00f7
            r15.nextToken()     // Catch:{ all -> 0x013c }
            r11.setContext(r3)
            return r12
        L_0x00f7:
            r15.nextToken()     // Catch:{ all -> 0x013c }
        L_0x00fa:
            r1 = 0
            java.lang.Object r1 = r0.deserialze(r11, r13, r1)     // Catch:{ all -> 0x013c }
            int r4 = r15.token     // Catch:{ all -> 0x013c }
            r5 = 17
            if (r4 != r5) goto L_0x0123
            r15.nextToken()     // Catch:{ all -> 0x013c }
            java.lang.Object r4 = r2.deserialze(r11, r14, r1)     // Catch:{ all -> 0x013c }
            int r5 = r11.resolveStatus     // Catch:{ all -> 0x013c }
            if (r5 != r6) goto L_0x0113
            r11.checkMapResolve(r12, r1)     // Catch:{ all -> 0x013c }
        L_0x0113:
            r12.put(r1, r4)     // Catch:{ all -> 0x013c }
            int r1 = r15.token     // Catch:{ all -> 0x013c }
            r4 = 16
            if (r1 != r4) goto L_0x011f
            r15.nextToken()     // Catch:{ all -> 0x013c }
        L_0x011f:
            r1 = 16
            goto L_0x0035
        L_0x0123:
            com.alibaba.fastjson.JSONException r12 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x013c }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x013c }
            r13.<init>()     // Catch:{ all -> 0x013c }
            java.lang.String r14 = "syntax error, expect :, actual "
            r13.append(r14)     // Catch:{ all -> 0x013c }
            int r14 = r15.token     // Catch:{ all -> 0x013c }
            r13.append(r14)     // Catch:{ all -> 0x013c }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x013c }
            r12.<init>(r13)     // Catch:{ all -> 0x013c }
            throw r12     // Catch:{ all -> 0x013c }
        L_0x013c:
            r12 = move-exception
            r11.setContext(r3)
            goto L_0x0142
        L_0x0141:
            throw r12
        L_0x0142:
            goto L_0x0141
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.MapDeserializer.parseMap(com.alibaba.fastjson.parser.DefaultJSONParser, java.util.Map, java.lang.reflect.Type, java.lang.reflect.Type, java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r10 = r9.config.getDeserializer(r2);
        r0.nextToken(16);
        r9.resolveStatus = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d6, code lost:
        if (r1 == null) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00da, code lost:
        if ((r12 instanceof java.lang.Integer) != false) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00dc, code lost:
        r9.popContext();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00df, code lost:
        r10 = (java.util.Map) r10.deserialze(r9, r2, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00e5, code lost:
        r9.setContext(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e8, code lost:
        return r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map parseMap(com.alibaba.fastjson.parser.DefaultJSONParser r9, java.util.Map<java.lang.String, java.lang.Object> r10, java.lang.reflect.Type r11, java.lang.Object r12) {
        /*
            com.alibaba.fastjson.parser.JSONLexer r0 = r9.lexer
            int r1 = r0.token
            r2 = 12
            if (r1 != r2) goto L_0x0149
            com.alibaba.fastjson.parser.ParseContext r1 = r9.contex
        L_0x000a:
            r0.skipWhitespace()     // Catch:{ all -> 0x0144 }
            char r2 = r0.ch     // Catch:{ all -> 0x0144 }
            r3 = 44
            if (r2 != r3) goto L_0x0017
            r0.next()     // Catch:{ all -> 0x0144 }
            goto L_0x000a
        L_0x0017:
            java.lang.String r3 = "syntax error, "
            r4 = 0
            r5 = 58
            r6 = 34
            r7 = 16
            if (r2 != r6) goto L_0x0049
            com.alibaba.fastjson.parser.SymbolTable r2 = r9.symbolTable     // Catch:{ all -> 0x0144 }
            java.lang.String r2 = r0.scanSymbol(r2, r6)     // Catch:{ all -> 0x0144 }
            r0.skipWhitespace()     // Catch:{ all -> 0x0144 }
            char r8 = r0.ch     // Catch:{ all -> 0x0144 }
            if (r8 != r5) goto L_0x0030
            goto L_0x0091
        L_0x0030:
            com.alibaba.fastjson.JSONException r10 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0144 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0144 }
            r11.<init>()     // Catch:{ all -> 0x0144 }
            r11.append(r3)     // Catch:{ all -> 0x0144 }
            java.lang.String r12 = r0.info()     // Catch:{ all -> 0x0144 }
            r11.append(r12)     // Catch:{ all -> 0x0144 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0144 }
            r10.<init>(r11)     // Catch:{ all -> 0x0144 }
            throw r10     // Catch:{ all -> 0x0144 }
        L_0x0049:
            r8 = 125(0x7d, float:1.75E-43)
            if (r2 != r8) goto L_0x0059
            r0.next()     // Catch:{ all -> 0x0144 }
            r0.sp = r4     // Catch:{ all -> 0x0144 }
            r0.nextToken(r7)     // Catch:{ all -> 0x0144 }
            r9.setContext(r1)
            return r10
        L_0x0059:
            r8 = 39
            if (r2 != r8) goto L_0x0084
            com.alibaba.fastjson.parser.SymbolTable r2 = r9.symbolTable     // Catch:{ all -> 0x0144 }
            java.lang.String r2 = r0.scanSymbol(r2, r8)     // Catch:{ all -> 0x0144 }
            r0.skipWhitespace()     // Catch:{ all -> 0x0144 }
            char r8 = r0.ch     // Catch:{ all -> 0x0144 }
            if (r8 != r5) goto L_0x006b
            goto L_0x0091
        L_0x006b:
            com.alibaba.fastjson.JSONException r10 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0144 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0144 }
            r11.<init>()     // Catch:{ all -> 0x0144 }
            r11.append(r3)     // Catch:{ all -> 0x0144 }
            java.lang.String r12 = r0.info()     // Catch:{ all -> 0x0144 }
            r11.append(r12)     // Catch:{ all -> 0x0144 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0144 }
            r10.<init>(r11)     // Catch:{ all -> 0x0144 }
            throw r10     // Catch:{ all -> 0x0144 }
        L_0x0084:
            com.alibaba.fastjson.parser.SymbolTable r2 = r9.symbolTable     // Catch:{ all -> 0x0144 }
            java.lang.String r2 = r0.scanSymbolUnQuoted(r2)     // Catch:{ all -> 0x0144 }
            r0.skipWhitespace()     // Catch:{ all -> 0x0144 }
            char r3 = r0.ch     // Catch:{ all -> 0x0144 }
            if (r3 != r5) goto L_0x0123
        L_0x0091:
            r0.next()     // Catch:{ all -> 0x0144 }
            r0.skipWhitespace()     // Catch:{ all -> 0x0144 }
            r0.sp = r4     // Catch:{ all -> 0x0144 }
            java.lang.String r3 = "@type"
            r4 = 13
            r5 = 0
            if (r2 != r3) goto L_0x00e9
            com.alibaba.fastjson.parser.Feature r3 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect     // Catch:{ all -> 0x0144 }
            boolean r3 = r0.isEnabled(r3)     // Catch:{ all -> 0x0144 }
            if (r3 != 0) goto L_0x00e9
            com.alibaba.fastjson.parser.SymbolTable r2 = r9.symbolTable     // Catch:{ all -> 0x0144 }
            java.lang.String r2 = r0.scanSymbol(r2, r6)     // Catch:{ all -> 0x0144 }
            com.alibaba.fastjson.parser.ParserConfig r3 = r9.config     // Catch:{ all -> 0x0144 }
            int r6 = r0.features     // Catch:{ all -> 0x0144 }
            java.lang.Class r2 = r3.checkAutoType(r2, r5, r6)     // Catch:{ all -> 0x0144 }
            java.lang.Class r3 = r10.getClass()     // Catch:{ all -> 0x0144 }
            if (r2 != r3) goto L_0x00ca
            r0.nextToken(r7)     // Catch:{ all -> 0x0144 }
            int r2 = r0.token     // Catch:{ all -> 0x0144 }
            if (r2 != r4) goto L_0x000a
            r0.nextToken(r7)     // Catch:{ all -> 0x0144 }
            r9.setContext(r1)
            return r10
        L_0x00ca:
            com.alibaba.fastjson.parser.ParserConfig r10 = r9.config     // Catch:{ all -> 0x0144 }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r10 = r10.getDeserializer(r2)     // Catch:{ all -> 0x0144 }
            r0.nextToken(r7)     // Catch:{ all -> 0x0144 }
            r11 = 2
            r9.resolveStatus = r11     // Catch:{ all -> 0x0144 }
            if (r1 == 0) goto L_0x00df
            boolean r11 = r12 instanceof java.lang.Integer     // Catch:{ all -> 0x0144 }
            if (r11 != 0) goto L_0x00df
            r9.popContext()     // Catch:{ all -> 0x0144 }
        L_0x00df:
            java.lang.Object r10 = r10.deserialze(r9, r2, r12)     // Catch:{ all -> 0x0144 }
            java.util.Map r10 = (java.util.Map) r10     // Catch:{ all -> 0x0144 }
            r9.setContext(r1)
            return r10
        L_0x00e9:
            r0.nextToken()     // Catch:{ all -> 0x0144 }
            r9.setContext(r1)     // Catch:{ all -> 0x0144 }
            int r3 = r0.token     // Catch:{ all -> 0x0144 }
            r6 = 8
            if (r3 != r6) goto L_0x00f9
            r0.nextToken()     // Catch:{ all -> 0x0144 }
            goto L_0x00fd
        L_0x00f9:
            java.lang.Object r5 = r9.parseObject((java.lang.reflect.Type) r11, (java.lang.Object) r2)     // Catch:{ all -> 0x0144 }
        L_0x00fd:
            r10.put(r2, r5)     // Catch:{ all -> 0x0144 }
            int r3 = r9.resolveStatus     // Catch:{ all -> 0x0144 }
            r6 = 1
            if (r3 != r6) goto L_0x0108
            r9.checkMapResolve(r10, r2)     // Catch:{ all -> 0x0144 }
        L_0x0108:
            r9.setContext(r1, r5, r2)     // Catch:{ all -> 0x0144 }
            int r2 = r0.token     // Catch:{ all -> 0x0144 }
            r3 = 20
            if (r2 == r3) goto L_0x011f
            r3 = 15
            if (r2 != r3) goto L_0x0116
            goto L_0x011f
        L_0x0116:
            if (r2 != r4) goto L_0x000a
            r0.nextToken()     // Catch:{ all -> 0x0144 }
            r9.setContext(r1)
            return r10
        L_0x011f:
            r9.setContext(r1)
            return r10
        L_0x0123:
            com.alibaba.fastjson.JSONException r10 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0144 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0144 }
            r11.<init>()     // Catch:{ all -> 0x0144 }
            java.lang.String r12 = "expect ':' at "
            r11.append(r12)     // Catch:{ all -> 0x0144 }
            int r12 = r0.pos     // Catch:{ all -> 0x0144 }
            r11.append(r12)     // Catch:{ all -> 0x0144 }
            java.lang.String r12 = ", actual "
            r11.append(r12)     // Catch:{ all -> 0x0144 }
            r11.append(r3)     // Catch:{ all -> 0x0144 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0144 }
            r10.<init>(r11)     // Catch:{ all -> 0x0144 }
            throw r10     // Catch:{ all -> 0x0144 }
        L_0x0144:
            r10 = move-exception
            r9.setContext(r1)
            throw r10
        L_0x0149:
            com.alibaba.fastjson.JSONException r9 = new com.alibaba.fastjson.JSONException
            java.lang.String r10 = "syntax error, expect {, actual "
            java.lang.StringBuilder r10 = a.a.a.a.a.n(r10)
            int r11 = r0.token
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            goto L_0x015f
        L_0x015e:
            throw r9
        L_0x015f:
            goto L_0x015e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.MapDeserializer.parseMap(com.alibaba.fastjson.parser.DefaultJSONParser, java.util.Map, java.lang.reflect.Type, java.lang.Object):java.util.Map");
    }

    public Map<?, ?> createMap(Type type) {
        if (type == Properties.class) {
            return new Properties();
        }
        if (type == Hashtable.class) {
            return new Hashtable();
        }
        if (type == IdentityHashMap.class) {
            return new IdentityHashMap();
        }
        if (type == SortedMap.class || type == TreeMap.class) {
            return new TreeMap();
        }
        if (type == ConcurrentMap.class || type == ConcurrentHashMap.class) {
            return new ConcurrentHashMap();
        }
        if (type == Map.class || type == HashMap.class) {
            return new HashMap();
        }
        if (type == LinkedHashMap.class) {
            return new LinkedHashMap();
        }
        if (type == JSONObject.class) {
            return new JSONObject();
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            return EnumMap.class.equals(rawType) ? new EnumMap((Class) parameterizedType.getActualTypeArguments()[0]) : createMap(rawType);
        }
        Class cls = (Class) type;
        if (!cls.isInterface()) {
            try {
                return (Map) cls.newInstance();
            } catch (Exception e2) {
                throw new JSONException("unsupport type " + type, e2);
            }
        } else {
            throw new JSONException("unsupport type " + type);
        }
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        if (type == JSONObject.class && defaultJSONParser.fieldTypeResolver == null) {
            return defaultJSONParser.parseObject();
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        Map<?, ?> createMap = createMap(type);
        ParseContext parseContext = defaultJSONParser.contex;
        try {
            defaultJSONParser.setContext(parseContext, createMap, obj);
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type type2 = parameterizedType.getActualTypeArguments()[0];
                Type type3 = parameterizedType.getActualTypeArguments()[1];
                if (String.class == type2) {
                    return parseMap(defaultJSONParser, createMap, type3, obj);
                }
                T parseMap = parseMap(defaultJSONParser, createMap, type2, type3, obj);
                defaultJSONParser.setContext(parseContext);
                return parseMap;
            }
            T parseObject = defaultJSONParser.parseObject((Map) createMap, obj);
            defaultJSONParser.setContext(parseContext);
            return parseObject;
        } finally {
            defaultJSONParser.setContext(parseContext);
        }
    }
}
