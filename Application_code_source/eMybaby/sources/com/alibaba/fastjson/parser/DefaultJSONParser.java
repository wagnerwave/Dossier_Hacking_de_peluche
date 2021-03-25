package com.alibaba.fastjson.parser;

import a.a.a.a.a;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DefaultJSONParser implements Closeable {
    public static final int NONE = 0;
    public static final int NeedToResolve = 1;
    public static final int TypeNameRedirect = 2;
    public ParserConfig config;
    public ParseContext contex;
    public ParseContext[] contextArray;
    public int contextArrayIndex;
    public DateFormat dateFormat;
    public String dateFormatPattern;
    public List<ExtraProcessor> extraProcessors;
    public List<ExtraTypeProvider> extraTypeProviders;
    public FieldTypeResolver fieldTypeResolver;
    public final JSONLexer lexer;
    public int resolveStatus;
    public List<ResolveTask> resolveTaskList;
    public final SymbolTable symbolTable;

    public static class ResolveTask {
        public final ParseContext context;
        public FieldDeserializer fieldDeserializer;
        public ParseContext ownerContext;
        public final String referenceValue;

        public ResolveTask(ParseContext parseContext, String str) {
            this.context = parseContext;
            this.referenceValue = str;
        }
    }

    public DefaultJSONParser(JSONLexer jSONLexer) {
        this(jSONLexer, ParserConfig.global);
    }

    public DefaultJSONParser(JSONLexer jSONLexer, ParserConfig parserConfig) {
        int i;
        this.dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
        this.contextArrayIndex = 0;
        this.resolveStatus = 0;
        this.extraTypeProviders = null;
        this.extraProcessors = null;
        this.fieldTypeResolver = null;
        this.lexer = jSONLexer;
        this.config = parserConfig;
        this.symbolTable = parserConfig.symbolTable;
        char c2 = jSONLexer.ch;
        char c3 = JSONLexer.EOI;
        if (c2 == '{') {
            int i2 = jSONLexer.bp + 1;
            jSONLexer.bp = i2;
            jSONLexer.ch = i2 < jSONLexer.len ? jSONLexer.text.charAt(i2) : c3;
            i = 12;
        } else if (c2 == '[') {
            int i3 = jSONLexer.bp + 1;
            jSONLexer.bp = i3;
            jSONLexer.ch = i3 < jSONLexer.len ? jSONLexer.text.charAt(i3) : c3;
            i = 14;
        } else {
            jSONLexer.nextToken();
            return;
        }
        jSONLexer.token = i;
    }

    public DefaultJSONParser(String str) {
        this(str, ParserConfig.global, JSON.DEFAULT_PARSER_FEATURE);
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig) {
        this(new JSONLexer(str, JSON.DEFAULT_PARSER_FEATURE), parserConfig);
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig, int i) {
        this(new JSONLexer(str, i), parserConfig);
    }

    public DefaultJSONParser(char[] cArr, int i, ParserConfig parserConfig, int i2) {
        this(new JSONLexer(cArr, i, i2), parserConfig);
    }

    public final void accept(int i) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token == i) {
            jSONLexer.nextToken();
            return;
        }
        StringBuilder n = a.n("syntax error, expect ");
        n.append(JSONToken.name(i));
        n.append(", actual ");
        n.append(JSONToken.name(this.lexer.token));
        throw new JSONException(n.toString());
    }

    public void addResolveTask(ResolveTask resolveTask) {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        this.resolveTaskList.add(resolveTask);
    }

    public void checkListResolve(Collection collection) {
        ResolveFieldDeserializer resolveFieldDeserializer;
        ResolveTask resolveTask;
        if (collection instanceof List) {
            resolveTask = getLastResolveTask();
            resolveFieldDeserializer = new ResolveFieldDeserializer(this, (List) collection, collection.size() - 1);
        } else {
            resolveTask = getLastResolveTask();
            resolveFieldDeserializer = new ResolveFieldDeserializer(collection);
        }
        resolveTask.fieldDeserializer = resolveFieldDeserializer;
        resolveTask.ownerContext = this.contex;
        this.resolveStatus = 0;
    }

    public void checkMapResolve(Map map, Object obj) {
        ResolveFieldDeserializer resolveFieldDeserializer = new ResolveFieldDeserializer(map, obj);
        ResolveTask lastResolveTask = getLastResolveTask();
        lastResolveTask.fieldDeserializer = resolveFieldDeserializer;
        lastResolveTask.ownerContext = this.contex;
        this.resolveStatus = 0;
    }

    public void close() {
        try {
            if (this.lexer.token != 20) {
                throw new JSONException("not close json text, token : " + JSONToken.name(this.lexer.token));
            }
        } finally {
            this.lexer.close();
        }
    }

    public void config(Feature feature, boolean z) {
        this.lexer.config(feature, z);
    }

    public String getDateFomartPattern() {
        return this.dateFormatPattern;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormatPattern, this.lexer.locale);
            this.dateFormat = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.lexer.timeZone);
        }
        return this.dateFormat;
    }

    public List<ExtraProcessor> getExtraProcessors() {
        if (this.extraProcessors == null) {
            this.extraProcessors = new ArrayList(2);
        }
        return this.extraProcessors;
    }

    public List<ExtraTypeProvider> getExtraTypeProviders() {
        if (this.extraTypeProviders == null) {
            this.extraTypeProviders = new ArrayList(2);
        }
        return this.extraTypeProviders;
    }

    public ResolveTask getLastResolveTask() {
        List<ResolveTask> list = this.resolveTaskList;
        return list.get(list.size() - 1);
    }

    public void handleResovleTask(Object obj) {
        List<ResolveTask> list = this.resolveTaskList;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ResolveTask resolveTask = this.resolveTaskList.get(i);
                FieldDeserializer fieldDeserializer = resolveTask.fieldDeserializer;
                if (fieldDeserializer != null) {
                    ParseContext parseContext = resolveTask.ownerContext;
                    Object obj2 = null;
                    Object obj3 = parseContext != null ? parseContext.object : null;
                    String access$000 = resolveTask.referenceValue;
                    if (access$000.startsWith("$")) {
                        for (int i2 = 0; i2 < this.contextArrayIndex; i2++) {
                            if (access$000.equals(this.contextArray[i2].toString())) {
                                obj2 = this.contextArray[i2].object;
                            }
                        }
                    } else {
                        obj2 = resolveTask.context.object;
                    }
                    fieldDeserializer.setValue(obj3, obj2);
                }
            }
        }
    }

    public Object parse() {
        return parse((Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0086, code lost:
        r6.lexer.nextToken();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008b, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object parse(java.lang.Object r7) {
        /*
            r6 = this;
            com.alibaba.fastjson.parser.JSONLexer r0 = r6.lexer
            int r1 = r0.token
            r2 = 2
            if (r1 == r2) goto L_0x012d
            r3 = 3
            r4 = 1
            if (r1 == r3) goto L_0x0116
            r3 = 4
            r5 = 16
            if (r1 == r3) goto L_0x00e3
            r3 = 12
            if (r1 == r3) goto L_0x00c5
            r3 = 14
            if (r1 == r3) goto L_0x00bc
            r3 = 0
            java.lang.String r4 = "syntax error, "
            switch(r1) {
                case 6: goto L_0x0080;
                case 7: goto L_0x007a;
                case 8: goto L_0x0086;
                case 9: goto L_0x0038;
                default: goto L_0x001e;
            }
        L_0x001e:
            switch(r1) {
                case 20: goto L_0x009e;
                case 21: goto L_0x0095;
                case 22: goto L_0x008c;
                case 23: goto L_0x0086;
                default: goto L_0x0021;
            }
        L_0x0021:
            com.alibaba.fastjson.JSONException r7 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r0 = a.a.a.a.a.n(r4)
            com.alibaba.fastjson.parser.JSONLexer r1 = r6.lexer
            java.lang.String r1 = r1.info()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L_0x0038:
            r7 = 18
            r0.nextToken(r7)
            com.alibaba.fastjson.parser.JSONLexer r0 = r6.lexer
            int r1 = r0.token
            if (r1 != r7) goto L_0x0063
            r7 = 10
            r0.nextToken(r7)
            r6.accept(r7)
            com.alibaba.fastjson.parser.JSONLexer r7 = r6.lexer
            java.lang.Number r7 = r7.integerValue()
            long r0 = r7.longValue()
            r6.accept(r2)
            r7 = 11
            r6.accept(r7)
            java.util.Date r7 = new java.util.Date
            r7.<init>(r0)
            return r7
        L_0x0063:
            com.alibaba.fastjson.JSONException r7 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r0 = a.a.a.a.a.n(r4)
            com.alibaba.fastjson.parser.JSONLexer r1 = r6.lexer
            java.lang.String r1 = r1.info()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L_0x007a:
            r0.nextToken(r5)
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            return r7
        L_0x0080:
            r0.nextToken(r5)
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            return r7
        L_0x0086:
            com.alibaba.fastjson.parser.JSONLexer r7 = r6.lexer
            r7.nextToken()
            return r3
        L_0x008c:
            r0.nextToken()
            java.util.TreeSet r0 = new java.util.TreeSet
            r0.<init>()
            goto L_0x00c1
        L_0x0095:
            r0.nextToken()
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            goto L_0x00c1
        L_0x009e:
            boolean r7 = r0.isBlankInput()
            if (r7 == 0) goto L_0x00a5
            return r3
        L_0x00a5:
            com.alibaba.fastjson.JSONException r7 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r0 = a.a.a.a.a.n(r4)
            com.alibaba.fastjson.parser.JSONLexer r1 = r6.lexer
            java.lang.String r1 = r1.info()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L_0x00bc:
            com.alibaba.fastjson.JSONArray r0 = new com.alibaba.fastjson.JSONArray
            r0.<init>()
        L_0x00c1:
            r6.parseArray((java.util.Collection) r0, (java.lang.Object) r7)
            return r0
        L_0x00c5:
            int r0 = r0.features
            com.alibaba.fastjson.parser.Feature r1 = com.alibaba.fastjson.parser.Feature.OrderedField
            int r1 = r1.mask
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00d9
            com.alibaba.fastjson.JSONObject r0 = new com.alibaba.fastjson.JSONObject
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            r0.<init>((java.util.Map<java.lang.String, java.lang.Object>) r1)
            goto L_0x00de
        L_0x00d9:
            com.alibaba.fastjson.JSONObject r0 = new com.alibaba.fastjson.JSONObject
            r0.<init>()
        L_0x00de:
            java.lang.Object r7 = r6.parseObject((java.util.Map) r0, (java.lang.Object) r7)
            return r7
        L_0x00e3:
            java.lang.String r7 = r0.stringVal()
            com.alibaba.fastjson.parser.JSONLexer r0 = r6.lexer
            r0.nextToken(r5)
            com.alibaba.fastjson.parser.JSONLexer r0 = r6.lexer
            int r0 = r0.features
            com.alibaba.fastjson.parser.Feature r1 = com.alibaba.fastjson.parser.Feature.AllowISO8601DateFormat
            int r1 = r1.mask
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0115
            com.alibaba.fastjson.parser.JSONLexer r0 = new com.alibaba.fastjson.parser.JSONLexer
            r0.<init>(r7)
            boolean r1 = r0.scanISO8601DateIfMatch(r4)     // Catch:{ all -> 0x0110 }
            if (r1 == 0) goto L_0x010c
            java.util.Calendar r7 = r0.calendar     // Catch:{ all -> 0x0110 }
            java.util.Date r7 = r7.getTime()     // Catch:{ all -> 0x0110 }
            r0.close()
            return r7
        L_0x010c:
            r0.close()
            goto L_0x0115
        L_0x0110:
            r7 = move-exception
            r0.close()
            throw r7
        L_0x0115:
            return r7
        L_0x0116:
            int r7 = r0.features
            com.alibaba.fastjson.parser.Feature r0 = com.alibaba.fastjson.parser.Feature.UseBigDecimal
            int r0 = r0.mask
            r7 = r7 & r0
            if (r7 == 0) goto L_0x0120
            goto L_0x0121
        L_0x0120:
            r4 = 0
        L_0x0121:
            com.alibaba.fastjson.parser.JSONLexer r7 = r6.lexer
            java.lang.Number r7 = r7.decimalValue(r4)
            com.alibaba.fastjson.parser.JSONLexer r0 = r6.lexer
            r0.nextToken()
            return r7
        L_0x012d:
            java.lang.Number r7 = r0.integerValue()
            com.alibaba.fastjson.parser.JSONLexer r0 = r6.lexer
            r0.nextToken()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parse(java.lang.Object):java.lang.Object");
    }

    public <T> List<T> parseArray(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        parseArray((Class<?>) cls, (Collection) arrayList);
        return arrayList;
    }

    public void parseArray(Class<?> cls, Collection collection) {
        parseArray((Type) cls, collection);
    }

    public void parseArray(Type type, Collection collection) {
        parseArray(type, collection, (Object) null);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004d A[Catch:{ all -> 0x00c2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0053 A[Catch:{ all -> 0x00c2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ba A[Catch:{ all -> 0x00c2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parseArray(java.lang.reflect.Type r9, java.util.Collection r10, java.lang.Object r11) {
        /*
            r8 = this;
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            com.alibaba.fastjson.parser.JSONLexer r1 = r8.lexer
            int r1 = r1.token
            r2 = 21
            if (r1 == r2) goto L_0x000e
            r2 = 22
            if (r1 != r2) goto L_0x0013
        L_0x000e:
            com.alibaba.fastjson.parser.JSONLexer r1 = r8.lexer
            r1.nextToken()
        L_0x0013:
            com.alibaba.fastjson.parser.JSONLexer r1 = r8.lexer
            int r2 = r1.token
            r3 = 14
            if (r2 != r3) goto L_0x00c6
            java.lang.Class r2 = java.lang.Integer.TYPE
            r3 = 4
            if (r2 != r9) goto L_0x0024
            com.alibaba.fastjson.serializer.IntegerCodec r2 = com.alibaba.fastjson.serializer.IntegerCodec.instance
            r4 = 2
            goto L_0x0036
        L_0x0024:
            if (r0 != r9) goto L_0x002c
            com.alibaba.fastjson.serializer.StringCodec r2 = com.alibaba.fastjson.serializer.StringCodec.instance
            r1.nextToken(r3)
            goto L_0x0039
        L_0x002c:
            com.alibaba.fastjson.parser.ParserConfig r1 = r8.config
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r2 = r1.getDeserializer(r9)
            com.alibaba.fastjson.parser.JSONLexer r1 = r8.lexer
            r4 = 12
        L_0x0036:
            r1.nextToken(r4)
        L_0x0039:
            com.alibaba.fastjson.parser.ParseContext r1 = r8.contex
            com.alibaba.fastjson.parser.JSONLexer r4 = r8.lexer
            boolean r4 = r4.disableCircularReferenceDetect
            if (r4 != 0) goto L_0x0044
            r8.setContext(r1, r10, r11)
        L_0x0044:
            r11 = 0
        L_0x0045:
            com.alibaba.fastjson.parser.JSONLexer r4 = r8.lexer     // Catch:{ all -> 0x00c2 }
            int r4 = r4.token     // Catch:{ all -> 0x00c2 }
            r5 = 16
            if (r4 != r5) goto L_0x0053
            com.alibaba.fastjson.parser.JSONLexer r4 = r8.lexer     // Catch:{ all -> 0x00c2 }
            r4.nextToken()     // Catch:{ all -> 0x00c2 }
            goto L_0x0045
        L_0x0053:
            com.alibaba.fastjson.parser.JSONLexer r4 = r8.lexer     // Catch:{ all -> 0x00c2 }
            int r4 = r4.token     // Catch:{ all -> 0x00c2 }
            r6 = 15
            if (r4 != r6) goto L_0x0063
            r8.contex = r1
            com.alibaba.fastjson.parser.JSONLexer r9 = r8.lexer
            r9.nextToken(r5)
            return
        L_0x0063:
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00c2 }
            r6 = 0
            if (r4 != r9) goto L_0x006f
            com.alibaba.fastjson.serializer.IntegerCodec r4 = com.alibaba.fastjson.serializer.IntegerCodec.instance     // Catch:{ all -> 0x00c2 }
            java.lang.Object r4 = r4.deserialze(r8, r6, r6)     // Catch:{ all -> 0x00c2 }
            goto L_0x008f
        L_0x006f:
            if (r0 != r9) goto L_0x0093
            com.alibaba.fastjson.parser.JSONLexer r4 = r8.lexer     // Catch:{ all -> 0x00c2 }
            int r4 = r4.token     // Catch:{ all -> 0x00c2 }
            if (r4 != r3) goto L_0x0083
            com.alibaba.fastjson.parser.JSONLexer r4 = r8.lexer     // Catch:{ all -> 0x00c2 }
            java.lang.String r4 = r4.stringVal()     // Catch:{ all -> 0x00c2 }
            com.alibaba.fastjson.parser.JSONLexer r6 = r8.lexer     // Catch:{ all -> 0x00c2 }
            r6.nextToken(r5)     // Catch:{ all -> 0x00c2 }
            goto L_0x008f
        L_0x0083:
            java.lang.Object r4 = r8.parse()     // Catch:{ all -> 0x00c2 }
            if (r4 != 0) goto L_0x008a
            goto L_0x008e
        L_0x008a:
            java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x00c2 }
        L_0x008e:
            r4 = r6
        L_0x008f:
            r10.add(r4)     // Catch:{ all -> 0x00c2 }
            goto L_0x00b4
        L_0x0093:
            com.alibaba.fastjson.parser.JSONLexer r4 = r8.lexer     // Catch:{ all -> 0x00c2 }
            int r4 = r4.token     // Catch:{ all -> 0x00c2 }
            r7 = 8
            if (r4 != r7) goto L_0x00a1
            com.alibaba.fastjson.parser.JSONLexer r4 = r8.lexer     // Catch:{ all -> 0x00c2 }
            r4.nextToken()     // Catch:{ all -> 0x00c2 }
            goto L_0x00a9
        L_0x00a1:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x00c2 }
            java.lang.Object r6 = r2.deserialze(r8, r9, r4)     // Catch:{ all -> 0x00c2 }
        L_0x00a9:
            r10.add(r6)     // Catch:{ all -> 0x00c2 }
            int r4 = r8.resolveStatus     // Catch:{ all -> 0x00c2 }
            r6 = 1
            if (r4 != r6) goto L_0x00b4
            r8.checkListResolve(r10)     // Catch:{ all -> 0x00c2 }
        L_0x00b4:
            com.alibaba.fastjson.parser.JSONLexer r4 = r8.lexer     // Catch:{ all -> 0x00c2 }
            int r4 = r4.token     // Catch:{ all -> 0x00c2 }
            if (r4 != r5) goto L_0x00bf
            com.alibaba.fastjson.parser.JSONLexer r4 = r8.lexer     // Catch:{ all -> 0x00c2 }
            r4.nextToken()     // Catch:{ all -> 0x00c2 }
        L_0x00bf:
            int r11 = r11 + 1
            goto L_0x0045
        L_0x00c2:
            r9 = move-exception
            r8.contex = r1
            throw r9
        L_0x00c6:
            com.alibaba.fastjson.JSONException r9 = new com.alibaba.fastjson.JSONException
            java.lang.String r10 = "exepct '[', but "
            java.lang.StringBuilder r10 = a.a.a.a.a.n(r10)
            com.alibaba.fastjson.parser.JSONLexer r11 = r8.lexer
            int r11 = r11.token
            java.lang.String r11 = com.alibaba.fastjson.parser.JSONToken.name(r11)
            r10.append(r11)
            java.lang.String r11 = ", "
            r10.append(r11)
            com.alibaba.fastjson.parser.JSONLexer r11 = r8.lexer
            java.lang.String r11 = r11.info()
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            goto L_0x00f0
        L_0x00ef:
            throw r9
        L_0x00f0:
            goto L_0x00ef
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parseArray(java.lang.reflect.Type, java.util.Collection, java.lang.Object):void");
    }

    public final void parseArray(Collection collection) {
        parseArray(collection, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x01d6 A[Catch:{ all -> 0x024a }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01e7 A[Catch:{ all -> 0x024a }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01f0 A[Catch:{ all -> 0x024a }] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0244 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x010e A[EDGE_INSN: B:150:0x010e->B:62:0x010e ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009a A[Catch:{ all -> 0x024a }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cb A[Catch:{ all -> 0x024a }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0108 A[Catch:{ all -> 0x024a }, LOOP:1: B:59:0x0102->B:61:0x0108, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0112 A[Catch:{ all -> 0x024a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void parseArray(java.util.Collection r13, java.lang.Object r14) {
        /*
            r12 = this;
            com.alibaba.fastjson.parser.JSONLexer r0 = r12.lexer
            int r0 = r0.token
            r1 = 21
            if (r0 == r1) goto L_0x000c
            r1 = 22
            if (r0 != r1) goto L_0x0015
        L_0x000c:
            com.alibaba.fastjson.parser.JSONLexer r0 = r12.lexer
            r0.nextToken()
            com.alibaba.fastjson.parser.JSONLexer r0 = r12.lexer
            int r0 = r0.token
        L_0x0015:
            r1 = 14
            if (r0 != r1) goto L_0x0250
            com.alibaba.fastjson.parser.JSONLexer r0 = r12.lexer
            boolean r0 = r0.disableCircularReferenceDetect
            com.alibaba.fastjson.parser.ParseContext r1 = r12.contex
            if (r0 != 0) goto L_0x0024
            r12.setContext(r1, r13, r14)
        L_0x0024:
            com.alibaba.fastjson.parser.JSONLexer r14 = r12.lexer     // Catch:{ all -> 0x024a }
            char r14 = r14.ch     // Catch:{ all -> 0x024a }
            r2 = 123(0x7b, float:1.72E-43)
            r3 = 93
            r4 = 4
            r5 = 12
            r6 = 34
            r7 = 16
            r8 = 1
            if (r14 == r6) goto L_0x0070
            if (r14 != r3) goto L_0x0047
            com.alibaba.fastjson.parser.JSONLexer r13 = r12.lexer     // Catch:{ all -> 0x024a }
            r13.next()     // Catch:{ all -> 0x024a }
            com.alibaba.fastjson.parser.JSONLexer r13 = r12.lexer     // Catch:{ all -> 0x024a }
            r13.nextToken(r7)     // Catch:{ all -> 0x024a }
            if (r0 != 0) goto L_0x0046
            r12.contex = r1
        L_0x0046:
            return
        L_0x0047:
            if (r14 != r2) goto L_0x006a
            com.alibaba.fastjson.parser.JSONLexer r14 = r12.lexer     // Catch:{ all -> 0x024a }
            int r2 = r14.bp     // Catch:{ all -> 0x024a }
            int r2 = r2 + r8
            r14.bp = r2     // Catch:{ all -> 0x024a }
            com.alibaba.fastjson.parser.JSONLexer r14 = r12.lexer     // Catch:{ all -> 0x024a }
            com.alibaba.fastjson.parser.JSONLexer r9 = r12.lexer     // Catch:{ all -> 0x024a }
            int r9 = r9.len     // Catch:{ all -> 0x024a }
            if (r2 < r9) goto L_0x005b
            r2 = 26
            goto L_0x0063
        L_0x005b:
            com.alibaba.fastjson.parser.JSONLexer r9 = r12.lexer     // Catch:{ all -> 0x024a }
            java.lang.String r9 = r9.text     // Catch:{ all -> 0x024a }
            char r2 = r9.charAt(r2)     // Catch:{ all -> 0x024a }
        L_0x0063:
            r14.ch = r2     // Catch:{ all -> 0x024a }
            com.alibaba.fastjson.parser.JSONLexer r14 = r12.lexer     // Catch:{ all -> 0x024a }
            r14.token = r5     // Catch:{ all -> 0x024a }
            goto L_0x0082
        L_0x006a:
            com.alibaba.fastjson.parser.JSONLexer r14 = r12.lexer     // Catch:{ all -> 0x024a }
            r14.nextToken(r5)     // Catch:{ all -> 0x024a }
            goto L_0x0082
        L_0x0070:
            com.alibaba.fastjson.parser.JSONLexer r14 = r12.lexer     // Catch:{ all -> 0x024a }
            int r14 = r14.features     // Catch:{ all -> 0x024a }
            com.alibaba.fastjson.parser.Feature r2 = com.alibaba.fastjson.parser.Feature.AllowISO8601DateFormat     // Catch:{ all -> 0x024a }
            int r2 = r2.mask     // Catch:{ all -> 0x024a }
            r14 = r14 & r2
            if (r14 != 0) goto L_0x007d
            r14 = 1
            goto L_0x0083
        L_0x007d:
            com.alibaba.fastjson.parser.JSONLexer r14 = r12.lexer     // Catch:{ all -> 0x024a }
            r14.nextToken(r4)     // Catch:{ all -> 0x024a }
        L_0x0082:
            r14 = 0
        L_0x0083:
            r2 = 0
        L_0x0084:
            if (r14 == 0) goto L_0x0102
            com.alibaba.fastjson.parser.JSONLexer r9 = r12.lexer     // Catch:{ all -> 0x024a }
            char r9 = r9.ch     // Catch:{ all -> 0x024a }
            if (r9 != r6) goto L_0x0102
            com.alibaba.fastjson.parser.JSONLexer r9 = r12.lexer     // Catch:{ all -> 0x024a }
            java.lang.String r9 = r9.scanStringValue(r6)     // Catch:{ all -> 0x024a }
            com.alibaba.fastjson.parser.JSONLexer r10 = r12.lexer     // Catch:{ all -> 0x024a }
            char r10 = r10.ch     // Catch:{ all -> 0x024a }
            r11 = 44
            if (r10 != r11) goto L_0x00cb
            com.alibaba.fastjson.parser.JSONLexer r3 = r12.lexer     // Catch:{ all -> 0x024a }
            int r10 = r3.bp     // Catch:{ all -> 0x024a }
            int r10 = r10 + r8
            r3.bp = r10     // Catch:{ all -> 0x024a }
            com.alibaba.fastjson.parser.JSONLexer r3 = r12.lexer     // Catch:{ all -> 0x024a }
            com.alibaba.fastjson.parser.JSONLexer r11 = r12.lexer     // Catch:{ all -> 0x024a }
            int r11 = r11.len     // Catch:{ all -> 0x024a }
            if (r10 < r11) goto L_0x00ac
            r10 = 26
            goto L_0x00b4
        L_0x00ac:
            com.alibaba.fastjson.parser.JSONLexer r11 = r12.lexer     // Catch:{ all -> 0x024a }
            java.lang.String r11 = r11.text     // Catch:{ all -> 0x024a }
            char r10 = r11.charAt(r10)     // Catch:{ all -> 0x024a }
        L_0x00b4:
            r3.ch = r10     // Catch:{ all -> 0x024a }
            r13.add(r9)     // Catch:{ all -> 0x024a }
            int r3 = r12.resolveStatus     // Catch:{ all -> 0x024a }
            if (r3 != r8) goto L_0x00c0
            r12.checkListResolve(r13)     // Catch:{ all -> 0x024a }
        L_0x00c0:
            if (r10 != r6) goto L_0x00c4
            goto L_0x0244
        L_0x00c4:
            com.alibaba.fastjson.parser.JSONLexer r14 = r12.lexer     // Catch:{ all -> 0x024a }
            r14.nextToken()     // Catch:{ all -> 0x024a }
            r14 = 0
            goto L_0x0102
        L_0x00cb:
            if (r10 != r3) goto L_0x00fd
            com.alibaba.fastjson.parser.JSONLexer r14 = r12.lexer     // Catch:{ all -> 0x024a }
            int r2 = r14.bp     // Catch:{ all -> 0x024a }
            int r2 = r2 + r8
            r14.bp = r2     // Catch:{ all -> 0x024a }
            com.alibaba.fastjson.parser.JSONLexer r14 = r12.lexer     // Catch:{ all -> 0x024a }
            com.alibaba.fastjson.parser.JSONLexer r3 = r12.lexer     // Catch:{ all -> 0x024a }
            int r3 = r3.len     // Catch:{ all -> 0x024a }
            if (r2 < r3) goto L_0x00df
            r2 = 26
            goto L_0x00e7
        L_0x00df:
            com.alibaba.fastjson.parser.JSONLexer r3 = r12.lexer     // Catch:{ all -> 0x024a }
            java.lang.String r3 = r3.text     // Catch:{ all -> 0x024a }
            char r2 = r3.charAt(r2)     // Catch:{ all -> 0x024a }
        L_0x00e7:
            r14.ch = r2     // Catch:{ all -> 0x024a }
            r13.add(r9)     // Catch:{ all -> 0x024a }
            int r14 = r12.resolveStatus     // Catch:{ all -> 0x024a }
            if (r14 != r8) goto L_0x00f3
            r12.checkListResolve(r13)     // Catch:{ all -> 0x024a }
        L_0x00f3:
            com.alibaba.fastjson.parser.JSONLexer r13 = r12.lexer     // Catch:{ all -> 0x024a }
            r13.nextToken(r7)     // Catch:{ all -> 0x024a }
            if (r0 != 0) goto L_0x00fc
            r12.contex = r1
        L_0x00fc:
            return
        L_0x00fd:
            com.alibaba.fastjson.parser.JSONLexer r3 = r12.lexer     // Catch:{ all -> 0x024a }
            r3.nextToken()     // Catch:{ all -> 0x024a }
        L_0x0102:
            com.alibaba.fastjson.parser.JSONLexer r3 = r12.lexer     // Catch:{ all -> 0x024a }
            int r3 = r3.token     // Catch:{ all -> 0x024a }
            if (r3 != r7) goto L_0x010e
            com.alibaba.fastjson.parser.JSONLexer r3 = r12.lexer     // Catch:{ all -> 0x024a }
            r3.nextToken()     // Catch:{ all -> 0x024a }
            goto L_0x0102
        L_0x010e:
            r9 = 2
            r10 = 0
            if (r3 == r9) goto L_0x01d6
            r9 = 3
            if (r3 == r9) goto L_0x01bc
            if (r3 == r4) goto L_0x0190
            r9 = 6
            if (r3 == r9) goto L_0x0187
            r9 = 7
            if (r3 == r9) goto L_0x0184
            r9 = 8
            if (r3 == r9) goto L_0x0151
            if (r3 == r5) goto L_0x015c
            r9 = 20
            if (r3 == r9) goto L_0x0154
            r9 = 23
            if (r3 == r9) goto L_0x0151
            r9 = 14
            if (r3 == r9) goto L_0x0143
            r9 = 15
            if (r3 == r9) goto L_0x0139
            java.lang.Object r10 = r12.parse()     // Catch:{ all -> 0x024a }
            goto L_0x01e0
        L_0x0139:
            com.alibaba.fastjson.parser.JSONLexer r13 = r12.lexer     // Catch:{ all -> 0x024a }
            r13.nextToken(r7)     // Catch:{ all -> 0x024a }
            if (r0 != 0) goto L_0x0142
            r12.contex = r1
        L_0x0142:
            return
        L_0x0143:
            com.alibaba.fastjson.JSONArray r10 = new com.alibaba.fastjson.JSONArray     // Catch:{ all -> 0x024a }
            r10.<init>()     // Catch:{ all -> 0x024a }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x024a }
            r12.parseArray((java.util.Collection) r10, (java.lang.Object) r3)     // Catch:{ all -> 0x024a }
            goto L_0x01e0
        L_0x0151:
            com.alibaba.fastjson.parser.JSONLexer r3 = r12.lexer     // Catch:{ all -> 0x024a }
            goto L_0x0180
        L_0x0154:
            com.alibaba.fastjson.JSONException r13 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x024a }
            java.lang.String r14 = "unclosed jsonArray"
            r13.<init>(r14)     // Catch:{ all -> 0x024a }
            throw r13     // Catch:{ all -> 0x024a }
        L_0x015c:
            com.alibaba.fastjson.parser.JSONLexer r3 = r12.lexer     // Catch:{ all -> 0x024a }
            int r3 = r3.features     // Catch:{ all -> 0x024a }
            com.alibaba.fastjson.parser.Feature r9 = com.alibaba.fastjson.parser.Feature.OrderedField     // Catch:{ all -> 0x024a }
            int r9 = r9.mask     // Catch:{ all -> 0x024a }
            r3 = r3 & r9
            if (r3 == 0) goto L_0x0172
            com.alibaba.fastjson.JSONObject r3 = new com.alibaba.fastjson.JSONObject     // Catch:{ all -> 0x024a }
            java.util.LinkedHashMap r9 = new java.util.LinkedHashMap     // Catch:{ all -> 0x024a }
            r9.<init>()     // Catch:{ all -> 0x024a }
            r3.<init>((java.util.Map<java.lang.String, java.lang.Object>) r9)     // Catch:{ all -> 0x024a }
            goto L_0x0177
        L_0x0172:
            com.alibaba.fastjson.JSONObject r3 = new com.alibaba.fastjson.JSONObject     // Catch:{ all -> 0x024a }
            r3.<init>()     // Catch:{ all -> 0x024a }
        L_0x0177:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x024a }
            java.lang.Object r10 = r12.parseObject((java.util.Map) r3, (java.lang.Object) r9)     // Catch:{ all -> 0x024a }
            goto L_0x01e0
        L_0x0180:
            r3.nextToken(r4)     // Catch:{ all -> 0x024a }
            goto L_0x01e0
        L_0x0184:
            java.lang.Boolean r3 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x024a }
            goto L_0x0189
        L_0x0187:
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x024a }
        L_0x0189:
            com.alibaba.fastjson.parser.JSONLexer r9 = r12.lexer     // Catch:{ all -> 0x024a }
            r10 = r3
        L_0x018c:
            r9.nextToken(r7)     // Catch:{ all -> 0x024a }
            goto L_0x01e0
        L_0x0190:
            com.alibaba.fastjson.parser.JSONLexer r3 = r12.lexer     // Catch:{ all -> 0x024a }
            java.lang.String r10 = r3.stringVal()     // Catch:{ all -> 0x024a }
            com.alibaba.fastjson.parser.JSONLexer r3 = r12.lexer     // Catch:{ all -> 0x024a }
            r3.nextToken(r7)     // Catch:{ all -> 0x024a }
            com.alibaba.fastjson.parser.JSONLexer r3 = r12.lexer     // Catch:{ all -> 0x024a }
            int r3 = r3.features     // Catch:{ all -> 0x024a }
            com.alibaba.fastjson.parser.Feature r9 = com.alibaba.fastjson.parser.Feature.AllowISO8601DateFormat     // Catch:{ all -> 0x024a }
            int r9 = r9.mask     // Catch:{ all -> 0x024a }
            r3 = r3 & r9
            if (r3 == 0) goto L_0x01e0
            com.alibaba.fastjson.parser.JSONLexer r3 = new com.alibaba.fastjson.parser.JSONLexer     // Catch:{ all -> 0x024a }
            r3.<init>(r10)     // Catch:{ all -> 0x024a }
            boolean r9 = r3.scanISO8601DateIfMatch(r8)     // Catch:{ all -> 0x024a }
            if (r9 == 0) goto L_0x01b8
            java.util.Calendar r9 = r3.calendar     // Catch:{ all -> 0x024a }
            java.util.Date r9 = r9.getTime()     // Catch:{ all -> 0x024a }
            r10 = r9
        L_0x01b8:
            r3.close()     // Catch:{ all -> 0x024a }
            goto L_0x01e0
        L_0x01bc:
            com.alibaba.fastjson.parser.JSONLexer r3 = r12.lexer     // Catch:{ all -> 0x024a }
            int r3 = r3.features     // Catch:{ all -> 0x024a }
            com.alibaba.fastjson.parser.Feature r9 = com.alibaba.fastjson.parser.Feature.UseBigDecimal     // Catch:{ all -> 0x024a }
            int r9 = r9.mask     // Catch:{ all -> 0x024a }
            r3 = r3 & r9
            if (r3 == 0) goto L_0x01ce
            com.alibaba.fastjson.parser.JSONLexer r3 = r12.lexer     // Catch:{ all -> 0x024a }
            java.lang.Number r3 = r3.decimalValue(r8)     // Catch:{ all -> 0x024a }
            goto L_0x01dc
        L_0x01ce:
            com.alibaba.fastjson.parser.JSONLexer r3 = r12.lexer     // Catch:{ all -> 0x024a }
            r9 = 0
            java.lang.Number r3 = r3.decimalValue(r9)     // Catch:{ all -> 0x024a }
            goto L_0x01dc
        L_0x01d6:
            com.alibaba.fastjson.parser.JSONLexer r3 = r12.lexer     // Catch:{ all -> 0x024a }
            java.lang.Number r3 = r3.integerValue()     // Catch:{ all -> 0x024a }
        L_0x01dc:
            com.alibaba.fastjson.parser.JSONLexer r9 = r12.lexer     // Catch:{ all -> 0x024a }
            r10 = r3
            goto L_0x018c
        L_0x01e0:
            r13.add(r10)     // Catch:{ all -> 0x024a }
            int r3 = r12.resolveStatus     // Catch:{ all -> 0x024a }
            if (r3 != r8) goto L_0x01ea
            r12.checkListResolve(r13)     // Catch:{ all -> 0x024a }
        L_0x01ea:
            com.alibaba.fastjson.parser.JSONLexer r3 = r12.lexer     // Catch:{ all -> 0x024a }
            int r3 = r3.token     // Catch:{ all -> 0x024a }
            if (r3 != r7) goto L_0x0244
            com.alibaba.fastjson.parser.JSONLexer r3 = r12.lexer     // Catch:{ all -> 0x024a }
            char r3 = r3.ch     // Catch:{ all -> 0x024a }
            if (r3 != r6) goto L_0x0204
            com.alibaba.fastjson.parser.JSONLexer r3 = r12.lexer     // Catch:{ all -> 0x024a }
            com.alibaba.fastjson.parser.JSONLexer r9 = r12.lexer     // Catch:{ all -> 0x024a }
            int r9 = r9.bp     // Catch:{ all -> 0x024a }
            r3.pos = r9     // Catch:{ all -> 0x024a }
            com.alibaba.fastjson.parser.JSONLexer r3 = r12.lexer     // Catch:{ all -> 0x024a }
            r3.scanString()     // Catch:{ all -> 0x024a }
            goto L_0x0244
        L_0x0204:
            r9 = 48
            if (r3 < r9) goto L_0x021a
            r9 = 57
            if (r3 > r9) goto L_0x021a
            com.alibaba.fastjson.parser.JSONLexer r3 = r12.lexer     // Catch:{ all -> 0x024a }
            com.alibaba.fastjson.parser.JSONLexer r9 = r12.lexer     // Catch:{ all -> 0x024a }
            int r9 = r9.bp     // Catch:{ all -> 0x024a }
            r3.pos = r9     // Catch:{ all -> 0x024a }
            com.alibaba.fastjson.parser.JSONLexer r3 = r12.lexer     // Catch:{ all -> 0x024a }
            r3.scanNumber()     // Catch:{ all -> 0x024a }
            goto L_0x0244
        L_0x021a:
            r9 = 123(0x7b, float:1.72E-43)
            if (r3 != r9) goto L_0x023f
            com.alibaba.fastjson.parser.JSONLexer r3 = r12.lexer     // Catch:{ all -> 0x024a }
            r3.token = r5     // Catch:{ all -> 0x024a }
            com.alibaba.fastjson.parser.JSONLexer r3 = r12.lexer     // Catch:{ all -> 0x024a }
            int r9 = r3.bp     // Catch:{ all -> 0x024a }
            int r9 = r9 + r8
            r3.bp = r9     // Catch:{ all -> 0x024a }
            com.alibaba.fastjson.parser.JSONLexer r3 = r12.lexer     // Catch:{ all -> 0x024a }
            com.alibaba.fastjson.parser.JSONLexer r10 = r12.lexer     // Catch:{ all -> 0x024a }
            int r10 = r10.len     // Catch:{ all -> 0x024a }
            if (r9 < r10) goto L_0x0234
            r9 = 26
            goto L_0x023c
        L_0x0234:
            com.alibaba.fastjson.parser.JSONLexer r10 = r12.lexer     // Catch:{ all -> 0x024a }
            java.lang.String r10 = r10.text     // Catch:{ all -> 0x024a }
            char r9 = r10.charAt(r9)     // Catch:{ all -> 0x024a }
        L_0x023c:
            r3.ch = r9     // Catch:{ all -> 0x024a }
            goto L_0x0244
        L_0x023f:
            com.alibaba.fastjson.parser.JSONLexer r3 = r12.lexer     // Catch:{ all -> 0x024a }
            r3.nextToken()     // Catch:{ all -> 0x024a }
        L_0x0244:
            int r2 = r2 + 1
            r3 = 93
            goto L_0x0084
        L_0x024a:
            r13 = move-exception
            if (r0 != 0) goto L_0x024f
            r12.contex = r1
        L_0x024f:
            throw r13
        L_0x0250:
            com.alibaba.fastjson.JSONException r13 = new com.alibaba.fastjson.JSONException
            java.lang.String r14 = "syntax error, expect [, actual "
            java.lang.StringBuilder r14 = a.a.a.a.a.n(r14)
            java.lang.String r0 = com.alibaba.fastjson.parser.JSONToken.name(r0)
            r14.append(r0)
            java.lang.String r0 = ", pos "
            r14.append(r0)
            com.alibaba.fastjson.parser.JSONLexer r0 = r12.lexer
            int r0 = r0.pos
            r14.append(r0)
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            goto L_0x0274
        L_0x0273:
            throw r13
        L_0x0274:
            goto L_0x0273
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parseArray(java.util.Collection, java.lang.Object):void");
    }

    public Object[] parseArray(Type[] typeArr) {
        Object obj;
        boolean z;
        Class<?> cls;
        int i;
        JSONLexer jSONLexer = this.lexer;
        int i2 = jSONLexer.token;
        int i3 = 8;
        if (i2 == 8) {
            jSONLexer.nextToken(16);
            return null;
        } else if (i2 == 14) {
            Object[] objArr = new Object[typeArr.length];
            if (typeArr.length == 0) {
                jSONLexer.nextToken(15);
                JSONLexer jSONLexer2 = this.lexer;
                if (jSONLexer2.token == 15) {
                    jSONLexer2.nextToken(16);
                    return new Object[0];
                }
                StringBuilder n = a.n("syntax error, ");
                n.append(this.lexer.info());
                throw new JSONException(n.toString());
            }
            jSONLexer.nextToken(2);
            int i4 = 0;
            while (i4 < typeArr.length) {
                JSONLexer jSONLexer3 = this.lexer;
                int i5 = jSONLexer3.token;
                if (i5 == i3) {
                    jSONLexer3.nextToken(16);
                    obj = null;
                } else {
                    Class<String> cls2 = typeArr[i4];
                    if (cls2 == Integer.TYPE || cls2 == Integer.class) {
                        JSONLexer jSONLexer4 = this.lexer;
                        if (jSONLexer4.token == 2) {
                            obj = Integer.valueOf(jSONLexer4.intValue());
                        }
                        obj = TypeUtils.cast(parse(), (Type) cls2, this.config);
                    } else if (cls2 == String.class) {
                        if (i5 == 4) {
                            obj = jSONLexer3.stringVal();
                        }
                        obj = TypeUtils.cast(parse(), (Type) cls2, this.config);
                    } else {
                        if (i4 != typeArr.length - 1 || !(cls2 instanceof Class)) {
                            z = false;
                            cls = null;
                        } else {
                            Class cls3 = cls2;
                            z = cls3.isArray();
                            cls = cls3.getComponentType();
                        }
                        if (!z || this.lexer.token == 14) {
                            obj = this.config.getDeserializer(cls2).deserialze(this, cls2, (Object) null);
                        } else {
                            ArrayList arrayList = new ArrayList();
                            ObjectDeserializer deserializer = this.config.getDeserializer(cls);
                            if (this.lexer.token != 15) {
                                while (true) {
                                    arrayList.add(deserializer.deserialze(this, cls2, (Object) null));
                                    JSONLexer jSONLexer5 = this.lexer;
                                    i = jSONLexer5.token;
                                    if (i != 16) {
                                        break;
                                    }
                                    jSONLexer5.nextToken(12);
                                }
                                if (i != 15) {
                                    StringBuilder n2 = a.n("syntax error, ");
                                    n2.append(this.lexer.info());
                                    throw new JSONException(n2.toString());
                                }
                            }
                            obj = TypeUtils.cast((Object) arrayList, (Type) cls2, this.config);
                        }
                    }
                    this.lexer.nextToken(16);
                }
                objArr[i4] = obj;
                JSONLexer jSONLexer6 = this.lexer;
                int i6 = jSONLexer6.token;
                if (i6 == 15) {
                    break;
                } else if (i6 == 16) {
                    if (i4 == typeArr.length - 1) {
                        jSONLexer6.nextToken(15);
                    } else {
                        jSONLexer6.nextToken(2);
                    }
                    i4++;
                    i3 = 8;
                } else {
                    StringBuilder n3 = a.n("syntax error, ");
                    n3.append(this.lexer.info());
                    throw new JSONException(n3.toString());
                }
            }
            JSONLexer jSONLexer7 = this.lexer;
            if (jSONLexer7.token == 15) {
                jSONLexer7.nextToken(16);
                return objArr;
            }
            StringBuilder n4 = a.n("syntax error, ");
            n4.append(this.lexer.info());
            throw new JSONException(n4.toString());
        } else {
            StringBuilder n5 = a.n("syntax error, ");
            n5.append(this.lexer.info());
            throw new JSONException(n5.toString());
        }
    }

    public Object parseArrayWithType(Type type) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token == 8) {
            jSONLexer.nextToken();
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length == 1) {
            Type type2 = actualTypeArguments[0];
            if (type2 instanceof Class) {
                ArrayList arrayList = new ArrayList();
                parseArray((Class<?>) (Class) type2, (Collection) arrayList);
                return arrayList;
            } else if (type2 instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type2;
                Type type3 = wildcardType.getUpperBounds()[0];
                if (!Object.class.equals(type3)) {
                    ArrayList arrayList2 = new ArrayList();
                    parseArray((Class<?>) (Class) type3, (Collection) arrayList2);
                    return arrayList2;
                } else if (wildcardType.getLowerBounds().length == 0) {
                    return parse();
                } else {
                    throw new JSONException("not support type : " + type);
                }
            } else {
                if (type2 instanceof TypeVariable) {
                    TypeVariable typeVariable = (TypeVariable) type2;
                    Type[] bounds = typeVariable.getBounds();
                    if (bounds.length == 1) {
                        Type type4 = bounds[0];
                        if (type4 instanceof Class) {
                            ArrayList arrayList3 = new ArrayList();
                            parseArray((Class<?>) (Class) type4, (Collection) arrayList3);
                            return arrayList3;
                        }
                    } else {
                        throw new JSONException("not support : " + typeVariable);
                    }
                }
                if (type2 instanceof ParameterizedType) {
                    ArrayList arrayList4 = new ArrayList();
                    parseArray((Type) (ParameterizedType) type2, (Collection) arrayList4);
                    return arrayList4;
                }
                throw new JSONException("TODO : " + type);
            }
        } else {
            throw new JSONException("not support type " + type);
        }
    }

    public JSONObject parseObject() {
        return (JSONObject) parseObject((Map) (this.lexer.features & Feature.OrderedField.mask) != 0 ? new JSONObject((Map<String, Object>) new LinkedHashMap()) : new JSONObject(), (Object) null);
    }

    public <T> T parseObject(Class<T> cls) {
        return parseObject((Type) cls, (Object) null);
    }

    public <T> T parseObject(Type type) {
        return parseObject(type, (Object) null);
    }

    public <T> T parseObject(Type type, Object obj) {
        JSONLexer jSONLexer = this.lexer;
        int i = jSONLexer.token;
        if (i == 8) {
            jSONLexer.nextToken();
            return null;
        }
        if (i == 4) {
            if (type == byte[].class) {
                Object bytesValue = jSONLexer.bytesValue();
                this.lexer.nextToken();
                return bytesValue;
            } else if (type == char[].class) {
                String stringVal = jSONLexer.stringVal();
                this.lexer.nextToken();
                return stringVal.toCharArray();
            }
        }
        try {
            return this.config.getDeserializer(type).deserialze(this, type, obj);
        } catch (JSONException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new JSONException(e3.getMessage(), e3);
        }
    }

    public Object parseObject(Map map) {
        return parseObject(map, (Object) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v66, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v67, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v68, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v129, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v130, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v131, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v132, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v133, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v134, resolved type: java.util.Date} */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0259, code lost:
        r6.nextToken(16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0262, code lost:
        if (r6.token != 13) goto L_0x02ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0264, code lost:
        r6.nextToken(16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:?, code lost:
        r2 = r13.config.getDeserializer(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x026f, code lost:
        if ((r2 instanceof com.alibaba.fastjson.parser.JavaBeanDeserializer) == false) goto L_0x02a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0271, code lost:
        r2 = (com.alibaba.fastjson.parser.JavaBeanDeserializer) r2;
        r7 = r2.createInstance(r13, (java.lang.reflect.Type) r1);
        r3 = r3.entrySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0283, code lost:
        if (r3.hasNext() == false) goto L_0x02a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0285, code lost:
        r4 = (java.util.Map.Entry) r3.next();
        r5 = r4.getKey();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0291, code lost:
        if ((r5 instanceof java.lang.String) == false) goto L_0x027f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0293, code lost:
        r5 = r2.getFieldDeserializer((java.lang.String) r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0299, code lost:
        if (r5 == null) goto L_0x027f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x029b, code lost:
        r5.setValue((java.lang.Object) r7, r4.getValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x02a3, code lost:
        if (r7 != null) goto L_0x02c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x02a7, code lost:
        if (r1 != java.lang.Cloneable.class) goto L_0x02af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x02a9, code lost:
        r7 = new java.util.HashMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x02b5, code lost:
        if ("java.util.Collections$EmptyMap".equals(r0) == false) goto L_0x02bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x02b7, code lost:
        r7 = java.util.Collections.emptyMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x02bc, code lost:
        r7 = r1.newInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x02c0, code lost:
        if (r10 != false) goto L_0x02c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x02c2, code lost:
        r13.contex = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x02c4, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x02ce, code lost:
        r13.resolveStatus = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x02d3, code lost:
        if (r13.contex == null) goto L_0x02dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x02d7, code lost:
        if ((r4 instanceof java.lang.Integer) != false) goto L_0x02dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x02d9, code lost:
        r14.popContext();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x02e0, code lost:
        if (r3.size() <= 0) goto L_0x02f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x02e2, code lost:
        r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r2, r1, r13.config);
        r13.parseObject((java.lang.Object) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x02eb, code lost:
        if (r10 != false) goto L_0x02ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x02ed, code lost:
        r13.contex = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x02ef, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:?, code lost:
        r0 = r13.config.getDeserializer(r1).deserialze(r13, r1, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x02fa, code lost:
        if (r10 != false) goto L_0x02fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x02fc, code lost:
        r13.contex = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x02fe, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x030e, code lost:
        r6.nextToken(4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0313, code lost:
        if (r6.token != 4) goto L_0x03a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0315, code lost:
        r0 = r6.stringVal();
        r6.nextToken(13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0324, code lost:
        if ("@".equals(r0) == false) goto L_0x033c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0326, code lost:
        r0 = r13.contex;
        r1 = r0.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x032c, code lost:
        if ((r1 instanceof java.lang.Object[]) != false) goto L_0x037e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0330, code lost:
        if ((r1 instanceof java.util.Collection) == false) goto L_0x0333;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0335, code lost:
        if (r0.parent == null) goto L_0x037d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0337, code lost:
        r1 = r0.parent.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0342, code lost:
        if ("..".equals(r0) == false) goto L_0x0354;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0346, code lost:
        if (r11.object == null) goto L_0x034b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0348, code lost:
        r1 = r11.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x034b, code lost:
        r1 = new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r11, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0350, code lost:
        r13.addResolveTask(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x035a, code lost:
        if ("$".equals(r0) == false) goto L_0x0374;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x035c, code lost:
        r1 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x035f, code lost:
        if (r1.parent == null) goto L_0x0364;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x0361, code lost:
        r1 = r1.parent;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0366, code lost:
        if (r1.object == null) goto L_0x036b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x0368, code lost:
        r1 = r1.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x036b, code lost:
        r13.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r1, r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x0374, code lost:
        r1 = new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r11, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x037a, code lost:
        r13.resolveStatus = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x037d, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x0382, code lost:
        if (r6.token != 13) goto L_0x038e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x0384, code lost:
        r6.nextToken(16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0389, code lost:
        if (r10 != false) goto L_0x038d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x038b, code lost:
        r13.contex = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x038d, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x03a6, code lost:
        throw new com.alibaba.fastjson.JSONException("syntax error, " + r6.info());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x03c3, code lost:
        throw new com.alibaba.fastjson.JSONException("illegal ref, " + com.alibaba.fastjson.parser.JSONToken.name(r6.token));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:358:0x05c7, code lost:
        if (r0 != '}') goto L_0x0648;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:0x05c9, code lost:
        r0 = r6.bp + 1;
        r6.bp = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:360:0x05d1, code lost:
        if (r0 < r6.len) goto L_0x05d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:361:0x05d3, code lost:
        r0 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:362:0x05d6, code lost:
        r0 = r6.text.charAt(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:363:0x05dc, code lost:
        r6.ch = r0;
        r6.sp = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:364:0x05e3, code lost:
        if (r0 != ',') goto L_0x05fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:0x05e5, code lost:
        r0 = r6.bp + 1;
        r6.bp = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:366:0x05ed, code lost:
        if (r0 < r6.len) goto L_0x05f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:367:0x05ef, code lost:
        r0 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:368:0x05f2, code lost:
        r0 = r6.text.charAt(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:369:0x05f8, code lost:
        r6.ch = r0;
        r0 = 16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:371:0x05ff, code lost:
        if (r0 != '}') goto L_0x061b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:372:0x0601, code lost:
        r0 = r6.bp + 1;
        r6.bp = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:373:0x0609, code lost:
        if (r0 < r6.len) goto L_0x060e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:374:0x060b, code lost:
        r0 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:375:0x060e, code lost:
        r0 = r6.text.charAt(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:0x0614, code lost:
        r6.ch = r0;
        r0 = 13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:377:0x0618, code lost:
        r6.token = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:379:0x061d, code lost:
        if (r0 != ']') goto L_0x0639;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:380:0x061f, code lost:
        r0 = r6.bp + 1;
        r6.bp = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:381:0x0627, code lost:
        if (r0 < r6.len) goto L_0x062c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:382:0x0629, code lost:
        r0 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:383:0x062c, code lost:
        r0 = r6.text.charAt(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:384:0x0632, code lost:
        r6.ch = r0;
        r6.token = 15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:385:0x0639, code lost:
        r6.nextToken();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:386:0x063c, code lost:
        if (r10 != false) goto L_0x0643;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:387:0x063e, code lost:
        r13.setContext(r13.contex, r2, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:388:0x0643, code lost:
        if (r10 != false) goto L_0x0647;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:389:0x0645, code lost:
        r13.contex = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:390:0x0647, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:393:0x0660, code lost:
        throw new com.alibaba.fastjson.JSONException("syntax error, " + r6.info());
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01f3 A[Catch:{ Exception -> 0x02c5, NumberFormatException -> 0x018d, all -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0228 A[Catch:{ Exception -> 0x02c5, NumberFormatException -> 0x018d, all -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0231 A[SYNTHETIC, Splitter:B:127:0x0231] */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x03d9 A[Catch:{ Exception -> 0x02c5, NumberFormatException -> 0x018d, all -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x03fd A[Catch:{ Exception -> 0x02c5, NumberFormatException -> 0x018d, all -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x0451 A[Catch:{ Exception -> 0x02c5, NumberFormatException -> 0x018d, all -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x045e A[Catch:{ Exception -> 0x02c5, NumberFormatException -> 0x018d, all -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x0462 A[Catch:{ Exception -> 0x02c5, NumberFormatException -> 0x018d, all -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x0475  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009b A[SYNTHETIC, Splitter:B:27:0x009b] */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x0506 A[Catch:{ Exception -> 0x02c5, NumberFormatException -> 0x018d, all -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x0515 A[Catch:{ Exception -> 0x02c5, NumberFormatException -> 0x018d, all -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x051e A[Catch:{ Exception -> 0x02c5, NumberFormatException -> 0x018d, all -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x0522 A[Catch:{ Exception -> 0x02c5, NumberFormatException -> 0x018d, all -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x0527 A[Catch:{ Exception -> 0x02c5, NumberFormatException -> 0x018d, all -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:329:0x053e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:352:0x05ae A[Catch:{ Exception -> 0x02c5, NumberFormatException -> 0x018d, all -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:419:0x046b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:424:0x030e A[EDGE_INSN: B:424:0x030e->B:184:0x030e ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:426:0x0530 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:430:0x05c5 A[EDGE_INSN: B:430:0x05c5->B:357:0x05c5 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object parseObject(java.util.Map r20, java.lang.Object r21) {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            com.alibaba.fastjson.parser.JSONLexer r2 = r1.lexer
            int r3 = r2.token
            r4 = 8
            r5 = 0
            if (r3 != r4) goto L_0x0011
            r2.nextToken()
            return r5
        L_0x0011:
            r4 = 12
            r5 = 16
            if (r3 == r4) goto L_0x003d
            if (r3 != r5) goto L_0x001a
            goto L_0x003d
        L_0x001a:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.String r4 = "syntax error, expect {, actual "
            java.lang.StringBuilder r4 = a.a.a.a.a.n(r4)
            java.lang.String r3 = com.alibaba.fastjson.parser.JSONToken.name(r3)
            r4.append(r3)
            java.lang.String r3 = ", "
            r4.append(r3)
            java.lang.String r2 = r2.info()
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r0.<init>(r2)
            throw r0
        L_0x003d:
            boolean r3 = r0 instanceof com.alibaba.fastjson.JSONObject
            if (r3 == 0) goto L_0x004a
            r3 = r0
            com.alibaba.fastjson.JSONObject r3 = (com.alibaba.fastjson.JSONObject) r3
            java.util.Map r3 = r3.getInnerMap()
            r4 = 1
            goto L_0x004c
        L_0x004a:
            r4 = 0
            r3 = r0
        L_0x004c:
            int r5 = r2.features
            com.alibaba.fastjson.parser.Feature r6 = com.alibaba.fastjson.parser.Feature.AllowISO8601DateFormat
            int r6 = r6.mask
            r5 = r5 & r6
            if (r5 == 0) goto L_0x0057
            r5 = 1
            goto L_0x0058
        L_0x0057:
            r5 = 0
        L_0x0058:
            boolean r6 = r2.disableCircularReferenceDetect
            com.alibaba.fastjson.parser.ParseContext r7 = r1.contex
            r8 = 0
            r12 = r1
            r13 = r12
            r8 = r5
            r9 = r6
            r10 = r7
            r11 = 0
            r5 = r2
            r6 = r3
            r7 = r4
            r3 = r21
            r4 = r3
            r2 = r0
        L_0x006a:
            char r14 = r5.ch     // Catch:{ all -> 0x06ed }
            r15 = 125(0x7d, float:1.75E-43)
            r20 = r0
            r0 = 34
            if (r14 == r0) goto L_0x0088
            if (r14 == r15) goto L_0x0088
            r5.skipWhitespace()     // Catch:{ all -> 0x06ed }
            r14 = r13
            r13 = r12
            r12 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r20
            goto L_0x00a1
        L_0x0088:
            r15 = r14
            r14 = r13
            r13 = r12
            r12 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r20
        L_0x0097:
            r1 = 44
            if (r15 != r1) goto L_0x00aa
            r6.next()     // Catch:{ all -> 0x00a4 }
            r6.skipWhitespace()     // Catch:{ all -> 0x00a4 }
        L_0x00a1:
            char r15 = r6.ch     // Catch:{ all -> 0x00a4 }
            goto L_0x0097
        L_0x00a4:
            r0 = move-exception
            r9 = r10
            r10 = r11
            r12 = r13
            goto L_0x06ee
        L_0x00aa:
            java.lang.String r1 = "expect ':' at "
            r20 = r5
            java.lang.String r5 = "syntax error, "
            r16 = r7
            r7 = 26
            if (r15 != r0) goto L_0x00ea
            com.alibaba.fastjson.parser.SymbolTable r7 = r13.symbolTable     // Catch:{ all -> 0x00a4 }
            java.lang.String r0 = r6.scanSymbol(r7, r0)     // Catch:{ all -> 0x00a4 }
            char r7 = r6.ch     // Catch:{ all -> 0x00a4 }
            r15 = 58
            if (r7 == r15) goto L_0x01c6
            r6.skipWhitespace()     // Catch:{ all -> 0x00a4 }
            char r7 = r6.ch     // Catch:{ all -> 0x00a4 }
            if (r7 != r15) goto L_0x00cb
            goto L_0x01c6
        L_0x00cb:
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x00a4 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a4 }
            r3.<init>()     // Catch:{ all -> 0x00a4 }
            r3.append(r1)     // Catch:{ all -> 0x00a4 }
            int r1 = r6.pos     // Catch:{ all -> 0x00a4 }
            r3.append(r1)     // Catch:{ all -> 0x00a4 }
            java.lang.String r1 = ", name "
            r3.append(r1)     // Catch:{ all -> 0x00a4 }
            r3.append(r0)     // Catch:{ all -> 0x00a4 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00a4 }
            r2.<init>(r0)     // Catch:{ all -> 0x00a4 }
            throw r2     // Catch:{ all -> 0x00a4 }
        L_0x00ea:
            r0 = 125(0x7d, float:1.75E-43)
            if (r15 != r0) goto L_0x010e
            int r0 = r6.bp     // Catch:{ all -> 0x00a4 }
            int r0 = r0 + 1
            r6.bp = r0     // Catch:{ all -> 0x00a4 }
            int r1 = r6.len     // Catch:{ all -> 0x00a4 }
            if (r0 < r1) goto L_0x00f9
            goto L_0x00ff
        L_0x00f9:
            java.lang.String r1 = r6.text     // Catch:{ all -> 0x00a4 }
            char r7 = r1.charAt(r0)     // Catch:{ all -> 0x00a4 }
        L_0x00ff:
            r6.ch = r7     // Catch:{ all -> 0x00a4 }
            r0 = 0
            r6.sp = r0     // Catch:{ all -> 0x00a4 }
            r0 = 16
            r6.nextToken(r0)     // Catch:{ all -> 0x00a4 }
            if (r10 != 0) goto L_0x010d
            r13.contex = r11
        L_0x010d:
            return r2
        L_0x010e:
            r0 = 39
            if (r15 != r0) goto L_0x013e
            com.alibaba.fastjson.parser.SymbolTable r7 = r13.symbolTable     // Catch:{ all -> 0x00a4 }
            java.lang.String r0 = r6.scanSymbol(r7, r0)     // Catch:{ all -> 0x00a4 }
            char r7 = r6.ch     // Catch:{ all -> 0x00a4 }
            r15 = 58
            if (r7 == r15) goto L_0x0121
            r6.skipWhitespace()     // Catch:{ all -> 0x00a4 }
        L_0x0121:
            char r7 = r6.ch     // Catch:{ all -> 0x00a4 }
            if (r7 != r15) goto L_0x0127
            goto L_0x01c6
        L_0x0127:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x00a4 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a4 }
            r2.<init>()     // Catch:{ all -> 0x00a4 }
            r2.append(r1)     // Catch:{ all -> 0x00a4 }
            int r1 = r6.pos     // Catch:{ all -> 0x00a4 }
            r2.append(r1)     // Catch:{ all -> 0x00a4 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x00a4 }
            r0.<init>(r1)     // Catch:{ all -> 0x00a4 }
            throw r0     // Catch:{ all -> 0x00a4 }
        L_0x013e:
            if (r15 == r7) goto L_0x06d4
            r0 = 44
            if (r15 == r0) goto L_0x06bb
            r0 = 48
            if (r15 < r0) goto L_0x014c
            r0 = 57
            if (r15 <= r0) goto L_0x0150
        L_0x014c:
            r0 = 45
            if (r15 != r0) goto L_0x01a8
        L_0x0150:
            r0 = 0
            r6.sp = r0     // Catch:{ all -> 0x00a4 }
            r6.scanNumber()     // Catch:{ all -> 0x00a4 }
            int r0 = r6.token     // Catch:{ NumberFormatException -> 0x018d }
            r1 = 2
            if (r0 != r1) goto L_0x0160
            java.lang.Number r0 = r6.integerValue()     // Catch:{ NumberFormatException -> 0x018d }
            goto L_0x0165
        L_0x0160:
            r0 = 1
            java.lang.Number r0 = r6.decimalValue(r0)     // Catch:{ NumberFormatException -> 0x018d }
        L_0x0165:
            if (r8 == 0) goto L_0x016b
            java.lang.String r0 = r0.toString()     // Catch:{ NumberFormatException -> 0x018d }
        L_0x016b:
            char r1 = r6.ch     // Catch:{ all -> 0x00a4 }
            r7 = 58
            if (r1 != r7) goto L_0x0172
            goto L_0x01c6
        L_0x0172:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x00a4 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a4 }
            r1.<init>()     // Catch:{ all -> 0x00a4 }
            java.lang.String r2 = "parse number key error, "
            r1.append(r2)     // Catch:{ all -> 0x00a4 }
            java.lang.String r2 = r6.info()     // Catch:{ all -> 0x00a4 }
            r1.append(r2)     // Catch:{ all -> 0x00a4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a4 }
            r0.<init>(r1)     // Catch:{ all -> 0x00a4 }
            throw r0     // Catch:{ all -> 0x00a4 }
        L_0x018d:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x00a4 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a4 }
            r1.<init>()     // Catch:{ all -> 0x00a4 }
            java.lang.String r2 = "parse number key error, "
            r1.append(r2)     // Catch:{ all -> 0x00a4 }
            java.lang.String r2 = r6.info()     // Catch:{ all -> 0x00a4 }
            r1.append(r2)     // Catch:{ all -> 0x00a4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a4 }
            r0.<init>(r1)     // Catch:{ all -> 0x00a4 }
            throw r0     // Catch:{ all -> 0x00a4 }
        L_0x01a8:
            r0 = 123(0x7b, float:1.72E-43)
            if (r15 == r0) goto L_0x01e7
            r0 = 91
            if (r15 != r0) goto L_0x01b1
            goto L_0x01e7
        L_0x01b1:
            com.alibaba.fastjson.parser.SymbolTable r0 = r13.symbolTable     // Catch:{ all -> 0x00a4 }
            java.lang.String r0 = r6.scanSymbolUnQuoted(r0)     // Catch:{ all -> 0x00a4 }
            r6.skipWhitespace()     // Catch:{ all -> 0x00a4 }
            char r7 = r6.ch     // Catch:{ all -> 0x00a4 }
            r15 = 58
            if (r7 != r15) goto L_0x01c8
            if (r8 == 0) goto L_0x01c6
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00a4 }
        L_0x01c6:
            r1 = 0
            goto L_0x01ef
        L_0x01c8:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x00a4 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a4 }
            r2.<init>()     // Catch:{ all -> 0x00a4 }
            r2.append(r1)     // Catch:{ all -> 0x00a4 }
            int r1 = r6.bp     // Catch:{ all -> 0x00a4 }
            r2.append(r1)     // Catch:{ all -> 0x00a4 }
            java.lang.String r1 = ", actual "
            r2.append(r1)     // Catch:{ all -> 0x00a4 }
            r2.append(r7)     // Catch:{ all -> 0x00a4 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x00a4 }
            r0.<init>(r1)     // Catch:{ all -> 0x00a4 }
            throw r0     // Catch:{ all -> 0x00a4 }
        L_0x01e7:
            r6.nextToken()     // Catch:{ all -> 0x00a4 }
            java.lang.Object r0 = r14.parse()     // Catch:{ all -> 0x00a4 }
            r1 = 1
        L_0x01ef:
            r7 = 13
            if (r1 != 0) goto L_0x0228
            int r1 = r6.bp     // Catch:{ all -> 0x00a4 }
            int r1 = r1 + 1
            r6.bp = r1     // Catch:{ all -> 0x00a4 }
            int r15 = r6.len     // Catch:{ all -> 0x00a4 }
            if (r1 < r15) goto L_0x0200
            r1 = 26
            goto L_0x0206
        L_0x0200:
            java.lang.String r15 = r6.text     // Catch:{ all -> 0x00a4 }
            char r1 = r15.charAt(r1)     // Catch:{ all -> 0x00a4 }
        L_0x0206:
            r6.ch = r1     // Catch:{ all -> 0x00a4 }
        L_0x0208:
            r15 = 32
            if (r1 > r15) goto L_0x022a
            r15 = 32
            if (r1 == r15) goto L_0x0222
            r15 = 10
            if (r1 == r15) goto L_0x0222
            if (r1 == r7) goto L_0x0222
            r15 = 9
            if (r1 == r15) goto L_0x0222
            r15 = 12
            if (r1 == r15) goto L_0x0222
            r15 = 8
            if (r1 != r15) goto L_0x022a
        L_0x0222:
            r6.next()     // Catch:{ all -> 0x00a4 }
            char r1 = r6.ch     // Catch:{ all -> 0x00a4 }
            goto L_0x0208
        L_0x0228:
            char r1 = r6.ch     // Catch:{ all -> 0x00a4 }
        L_0x022a:
            r15 = 0
            r6.sp = r15     // Catch:{ all -> 0x00a4 }
            java.lang.String r15 = "@type"
            if (r0 != r15) goto L_0x02ff
            com.alibaba.fastjson.parser.Feature r7 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect     // Catch:{ all -> 0x00a4 }
            boolean r7 = r6.isEnabled(r7)     // Catch:{ all -> 0x00a4 }
            if (r7 != 0) goto L_0x02ff
            com.alibaba.fastjson.parser.SymbolTable r0 = r13.symbolTable     // Catch:{ all -> 0x00a4 }
            r1 = 34
            java.lang.String r0 = r6.scanSymbol(r0, r1)     // Catch:{ all -> 0x00a4 }
            com.alibaba.fastjson.parser.ParserConfig r1 = r13.config     // Catch:{ all -> 0x00a4 }
            int r5 = r6.features     // Catch:{ all -> 0x00a4 }
            r7 = 0
            java.lang.Class r1 = r1.checkAutoType(r0, r7, r5)     // Catch:{ all -> 0x00a4 }
            if (r1 != 0) goto L_0x0259
            r2.put(r15, r0)     // Catch:{ all -> 0x00a4 }
            r17 = r8
            r21 = r9
            r18 = r12
            r7 = r16
            goto L_0x068d
        L_0x0259:
            r5 = 16
            r6.nextToken(r5)     // Catch:{ all -> 0x00a4 }
            int r8 = r6.token     // Catch:{ all -> 0x00a4 }
            r9 = 13
            if (r8 != r9) goto L_0x02ce
            r6.nextToken(r5)     // Catch:{ all -> 0x00a4 }
            com.alibaba.fastjson.parser.ParserConfig r2 = r13.config     // Catch:{ Exception -> 0x02c5 }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r2 = r2.getDeserializer(r1)     // Catch:{ Exception -> 0x02c5 }
            boolean r4 = r2 instanceof com.alibaba.fastjson.parser.JavaBeanDeserializer     // Catch:{ Exception -> 0x02c5 }
            if (r4 == 0) goto L_0x02a3
            com.alibaba.fastjson.parser.JavaBeanDeserializer r2 = (com.alibaba.fastjson.parser.JavaBeanDeserializer) r2     // Catch:{ Exception -> 0x02c5 }
            java.lang.Object r7 = r2.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r13, (java.lang.reflect.Type) r1)     // Catch:{ Exception -> 0x02c5 }
            java.util.Set r3 = r3.entrySet()     // Catch:{ Exception -> 0x02c5 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x02c5 }
        L_0x027f:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x02c5 }
            if (r4 == 0) goto L_0x02a3
            java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x02c5 }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ Exception -> 0x02c5 }
            java.lang.Object r5 = r4.getKey()     // Catch:{ Exception -> 0x02c5 }
            boolean r6 = r5 instanceof java.lang.String     // Catch:{ Exception -> 0x02c5 }
            if (r6 == 0) goto L_0x027f
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x02c5 }
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r5 = r2.getFieldDeserializer(r5)     // Catch:{ Exception -> 0x02c5 }
            if (r5 == 0) goto L_0x027f
            java.lang.Object r4 = r4.getValue()     // Catch:{ Exception -> 0x02c5 }
            r5.setValue((java.lang.Object) r7, (java.lang.Object) r4)     // Catch:{ Exception -> 0x02c5 }
            goto L_0x027f
        L_0x02a3:
            if (r7 != 0) goto L_0x02c0
            java.lang.Class<java.lang.Cloneable> r2 = java.lang.Cloneable.class
            if (r1 != r2) goto L_0x02af
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ Exception -> 0x02c5 }
            r7.<init>()     // Catch:{ Exception -> 0x02c5 }
            goto L_0x02c0
        L_0x02af:
            java.lang.String r2 = "java.util.Collections$EmptyMap"
            boolean r0 = r2.equals(r0)     // Catch:{ Exception -> 0x02c5 }
            if (r0 == 0) goto L_0x02bc
            java.util.Map r7 = java.util.Collections.emptyMap()     // Catch:{ Exception -> 0x02c5 }
            goto L_0x02c0
        L_0x02bc:
            java.lang.Object r7 = r1.newInstance()     // Catch:{ Exception -> 0x02c5 }
        L_0x02c0:
            if (r10 != 0) goto L_0x02c4
            r13.contex = r11
        L_0x02c4:
            return r7
        L_0x02c5:
            r0 = move-exception
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x00a4 }
            java.lang.String r2 = "create instance error"
            r1.<init>(r2, r0)     // Catch:{ all -> 0x00a4 }
            throw r1     // Catch:{ all -> 0x00a4 }
        L_0x02ce:
            r0 = 2
            r13.resolveStatus = r0     // Catch:{ all -> 0x00a4 }
            com.alibaba.fastjson.parser.ParseContext r0 = r13.contex     // Catch:{ all -> 0x00a4 }
            if (r0 == 0) goto L_0x02dc
            boolean r0 = r4 instanceof java.lang.Integer     // Catch:{ all -> 0x00a4 }
            if (r0 != 0) goto L_0x02dc
            r14.popContext()     // Catch:{ all -> 0x00a4 }
        L_0x02dc:
            int r0 = r3.size()     // Catch:{ all -> 0x00a4 }
            if (r0 <= 0) goto L_0x02f0
            com.alibaba.fastjson.parser.ParserConfig r0 = r13.config     // Catch:{ all -> 0x00a4 }
            java.lang.Object r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r2, r1, (com.alibaba.fastjson.parser.ParserConfig) r0)     // Catch:{ all -> 0x00a4 }
            r13.parseObject((java.lang.Object) r0)     // Catch:{ all -> 0x00a4 }
            if (r10 != 0) goto L_0x02ef
            r13.contex = r11
        L_0x02ef:
            return r0
        L_0x02f0:
            com.alibaba.fastjson.parser.ParserConfig r0 = r13.config     // Catch:{ all -> 0x00a4 }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r0 = r0.getDeserializer(r1)     // Catch:{ all -> 0x00a4 }
            java.lang.Object r0 = r0.deserialze(r13, r1, r4)     // Catch:{ all -> 0x00a4 }
            if (r10 != 0) goto L_0x02fe
            r13.contex = r11
        L_0x02fe:
            return r0
        L_0x02ff:
            java.lang.String r7 = "$ref"
            r15 = 4
            if (r0 != r7) goto L_0x03c4
            if (r11 == 0) goto L_0x03c4
            com.alibaba.fastjson.parser.Feature r7 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect     // Catch:{ all -> 0x00a4 }
            boolean r7 = r6.isEnabled(r7)     // Catch:{ all -> 0x00a4 }
            if (r7 != 0) goto L_0x03c4
            r6.nextToken(r15)     // Catch:{ all -> 0x00a4 }
            int r0 = r6.token     // Catch:{ all -> 0x00a4 }
            if (r0 != r15) goto L_0x03a7
            java.lang.String r0 = r6.stringVal()     // Catch:{ all -> 0x00a4 }
            r1 = 13
            r6.nextToken(r1)     // Catch:{ all -> 0x00a4 }
            java.lang.String r1 = "@"
            boolean r1 = r1.equals(r0)     // Catch:{ all -> 0x00a4 }
            if (r1 == 0) goto L_0x033c
            com.alibaba.fastjson.parser.ParseContext r0 = r13.contex     // Catch:{ all -> 0x00a4 }
            java.lang.Object r1 = r0.object     // Catch:{ all -> 0x00a4 }
            boolean r2 = r1 instanceof java.lang.Object[]     // Catch:{ all -> 0x00a4 }
            if (r2 != 0) goto L_0x037e
            boolean r2 = r1 instanceof java.util.Collection     // Catch:{ all -> 0x00a4 }
            if (r2 == 0) goto L_0x0333
            goto L_0x037e
        L_0x0333:
            com.alibaba.fastjson.parser.ParseContext r1 = r0.parent     // Catch:{ all -> 0x00a4 }
            if (r1 == 0) goto L_0x037d
            com.alibaba.fastjson.parser.ParseContext r0 = r0.parent     // Catch:{ all -> 0x00a4 }
            java.lang.Object r1 = r0.object     // Catch:{ all -> 0x00a4 }
            goto L_0x037e
        L_0x033c:
            java.lang.String r1 = ".."
            boolean r1 = r1.equals(r0)     // Catch:{ all -> 0x00a4 }
            if (r1 == 0) goto L_0x0354
            java.lang.Object r1 = r11.object     // Catch:{ all -> 0x00a4 }
            if (r1 == 0) goto L_0x034b
            java.lang.Object r1 = r11.object     // Catch:{ all -> 0x00a4 }
            goto L_0x037e
        L_0x034b:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r1 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x00a4 }
            r1.<init>(r11, r0)     // Catch:{ all -> 0x00a4 }
        L_0x0350:
            r13.addResolveTask(r1)     // Catch:{ all -> 0x00a4 }
            goto L_0x037a
        L_0x0354:
            java.lang.String r1 = "$"
            boolean r1 = r1.equals(r0)     // Catch:{ all -> 0x00a4 }
            if (r1 == 0) goto L_0x0374
            r1 = r11
        L_0x035d:
            com.alibaba.fastjson.parser.ParseContext r2 = r1.parent     // Catch:{ all -> 0x00a4 }
            if (r2 == 0) goto L_0x0364
            com.alibaba.fastjson.parser.ParseContext r1 = r1.parent     // Catch:{ all -> 0x00a4 }
            goto L_0x035d
        L_0x0364:
            java.lang.Object r2 = r1.object     // Catch:{ all -> 0x00a4 }
            if (r2 == 0) goto L_0x036b
            java.lang.Object r1 = r1.object     // Catch:{ all -> 0x00a4 }
            goto L_0x037e
        L_0x036b:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r2 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x00a4 }
            r2.<init>(r1, r0)     // Catch:{ all -> 0x00a4 }
            r13.addResolveTask(r2)     // Catch:{ all -> 0x00a4 }
            goto L_0x037a
        L_0x0374:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r1 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x00a4 }
            r1.<init>(r11, r0)     // Catch:{ all -> 0x00a4 }
            goto L_0x0350
        L_0x037a:
            r0 = 1
            r13.resolveStatus = r0     // Catch:{ all -> 0x00a4 }
        L_0x037d:
            r1 = 0
        L_0x037e:
            int r0 = r6.token     // Catch:{ all -> 0x00a4 }
            r2 = 13
            if (r0 != r2) goto L_0x038e
            r0 = 16
            r6.nextToken(r0)     // Catch:{ all -> 0x00a4 }
            if (r10 != 0) goto L_0x038d
            r13.contex = r11
        L_0x038d:
            return r1
        L_0x038e:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x00a4 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a4 }
            r1.<init>()     // Catch:{ all -> 0x00a4 }
            r1.append(r5)     // Catch:{ all -> 0x00a4 }
            java.lang.String r2 = r6.info()     // Catch:{ all -> 0x00a4 }
            r1.append(r2)     // Catch:{ all -> 0x00a4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a4 }
            r0.<init>(r1)     // Catch:{ all -> 0x00a4 }
            throw r0     // Catch:{ all -> 0x00a4 }
        L_0x03a7:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x00a4 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a4 }
            r1.<init>()     // Catch:{ all -> 0x00a4 }
            java.lang.String r2 = "illegal ref, "
            r1.append(r2)     // Catch:{ all -> 0x00a4 }
            int r2 = r6.token     // Catch:{ all -> 0x00a4 }
            java.lang.String r2 = com.alibaba.fastjson.parser.JSONToken.name(r2)     // Catch:{ all -> 0x00a4 }
            r1.append(r2)     // Catch:{ all -> 0x00a4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a4 }
            r0.<init>(r1)     // Catch:{ all -> 0x00a4 }
            throw r0     // Catch:{ all -> 0x00a4 }
        L_0x03c4:
            if (r10 != 0) goto L_0x03d5
            if (r12 != 0) goto L_0x03d5
            com.alibaba.fastjson.parser.ParseContext r7 = r13.contex     // Catch:{ all -> 0x00a4 }
            com.alibaba.fastjson.parser.ParseContext r7 = r13.setContext(r7, r2, r4)     // Catch:{ all -> 0x00a4 }
            if (r11 != 0) goto L_0x03d1
            r11 = r7
        L_0x03d1:
            r7 = 34
            r12 = 1
            goto L_0x03d7
        L_0x03d5:
            r7 = 34
        L_0x03d7:
            if (r1 != r7) goto L_0x03fd
            java.lang.String r1 = r6.scanStringValue(r7)     // Catch:{ all -> 0x00a4 }
            if (r9 == 0) goto L_0x03f4
            com.alibaba.fastjson.parser.JSONLexer r7 = new com.alibaba.fastjson.parser.JSONLexer     // Catch:{ all -> 0x00a4 }
            r7.<init>(r1)     // Catch:{ all -> 0x00a4 }
            r15 = 1
            boolean r15 = r7.scanISO8601DateIfMatch(r15)     // Catch:{ all -> 0x00a4 }
            if (r15 == 0) goto L_0x03f1
            java.util.Calendar r1 = r7.calendar     // Catch:{ all -> 0x00a4 }
            java.util.Date r1 = r1.getTime()     // Catch:{ all -> 0x00a4 }
        L_0x03f1:
            r7.close()     // Catch:{ all -> 0x00a4 }
        L_0x03f4:
            if (r16 == 0) goto L_0x03f7
            goto L_0x040d
        L_0x03f7:
            r2.put(r0, r1)     // Catch:{ all -> 0x00a4 }
            r7 = r16
            goto L_0x0412
        L_0x03fd:
            r7 = 48
            if (r1 < r7) goto L_0x0405
            r7 = 57
            if (r1 <= r7) goto L_0x0409
        L_0x0405:
            r7 = 45
            if (r1 != r7) goto L_0x041a
        L_0x0409:
            java.lang.Number r1 = r6.scanNumberValue()     // Catch:{ all -> 0x00a4 }
        L_0x040d:
            r7 = r16
            r7.put(r0, r1)     // Catch:{ all -> 0x00a4 }
        L_0x0412:
            r17 = r8
            r21 = r9
            r18 = r12
            goto L_0x059b
        L_0x041a:
            r7 = r16
            r15 = 91
            if (r1 != r15) goto L_0x0498
            r1 = 14
            r6.token = r1     // Catch:{ all -> 0x00a4 }
            int r1 = r6.bp     // Catch:{ all -> 0x00a4 }
            int r1 = r1 + 1
            r6.bp = r1     // Catch:{ all -> 0x00a4 }
            int r15 = r6.len     // Catch:{ all -> 0x00a4 }
            if (r1 < r15) goto L_0x0431
            r1 = 26
            goto L_0x0437
        L_0x0431:
            java.lang.String r15 = r6.text     // Catch:{ all -> 0x00a4 }
            char r1 = r15.charAt(r1)     // Catch:{ all -> 0x00a4 }
        L_0x0437:
            r6.ch = r1     // Catch:{ all -> 0x00a4 }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00a4 }
            r1.<init>()     // Catch:{ all -> 0x00a4 }
            if (r4 == 0) goto L_0x044c
            java.lang.Class r15 = r20.getClass()     // Catch:{ all -> 0x00a4 }
            r17 = r8
            java.lang.Class<java.lang.Integer> r8 = java.lang.Integer.class
            if (r15 != r8) goto L_0x044e
            r8 = 1
            goto L_0x044f
        L_0x044c:
            r17 = r8
        L_0x044e:
            r8 = 0
        L_0x044f:
            if (r8 != 0) goto L_0x0454
            r13.setContext(r11)     // Catch:{ all -> 0x00a4 }
        L_0x0454:
            r13.parseArray((java.util.Collection) r1, (java.lang.Object) r0)     // Catch:{ all -> 0x00a4 }
            com.alibaba.fastjson.JSONArray r8 = new com.alibaba.fastjson.JSONArray     // Catch:{ all -> 0x00a4 }
            r8.<init>((java.util.List<java.lang.Object>) r1)     // Catch:{ all -> 0x00a4 }
            if (r7 == 0) goto L_0x0462
            r7.put(r0, r8)     // Catch:{ all -> 0x00a4 }
            goto L_0x0465
        L_0x0462:
            r2.put(r0, r8)     // Catch:{ all -> 0x00a4 }
        L_0x0465:
            int r0 = r6.token     // Catch:{ all -> 0x00a4 }
            r1 = 13
            if (r0 != r1) goto L_0x0475
            r0 = 16
            r6.nextToken(r0)     // Catch:{ all -> 0x00a4 }
            if (r10 != 0) goto L_0x0474
            r13.contex = r11
        L_0x0474:
            return r2
        L_0x0475:
            r1 = 16
            if (r0 != r1) goto L_0x047f
            r21 = r9
            r18 = r12
            goto L_0x068d
        L_0x047f:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x00a4 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a4 }
            r1.<init>()     // Catch:{ all -> 0x00a4 }
            r1.append(r5)     // Catch:{ all -> 0x00a4 }
            java.lang.String r2 = r6.info()     // Catch:{ all -> 0x00a4 }
            r1.append(r2)     // Catch:{ all -> 0x00a4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a4 }
            r0.<init>(r1)     // Catch:{ all -> 0x00a4 }
            throw r0     // Catch:{ all -> 0x00a4 }
        L_0x0498:
            r17 = r8
            r8 = 123(0x7b, float:1.72E-43)
            if (r1 != r8) goto L_0x055d
            int r1 = r6.bp     // Catch:{ all -> 0x00a4 }
            int r1 = r1 + 1
            r6.bp = r1     // Catch:{ all -> 0x00a4 }
            int r8 = r6.len     // Catch:{ all -> 0x00a4 }
            if (r1 < r8) goto L_0x04ab
            r1 = 26
            goto L_0x04b1
        L_0x04ab:
            java.lang.String r8 = r6.text     // Catch:{ all -> 0x00a4 }
            char r1 = r8.charAt(r1)     // Catch:{ all -> 0x00a4 }
        L_0x04b1:
            r6.ch = r1     // Catch:{ all -> 0x00a4 }
            r1 = 12
            r6.token = r1     // Catch:{ all -> 0x00a4 }
            boolean r1 = r4 instanceof java.lang.Integer     // Catch:{ all -> 0x00a4 }
            int r8 = r6.features     // Catch:{ all -> 0x00a4 }
            com.alibaba.fastjson.parser.Feature r15 = com.alibaba.fastjson.parser.Feature.OrderedField     // Catch:{ all -> 0x00a4 }
            int r15 = r15.mask     // Catch:{ all -> 0x00a4 }
            r8 = r8 & r15
            if (r8 == 0) goto L_0x04cd
            com.alibaba.fastjson.JSONObject r8 = new com.alibaba.fastjson.JSONObject     // Catch:{ all -> 0x00a4 }
            java.util.LinkedHashMap r15 = new java.util.LinkedHashMap     // Catch:{ all -> 0x00a4 }
            r15.<init>()     // Catch:{ all -> 0x00a4 }
            r8.<init>((java.util.Map<java.lang.String, java.lang.Object>) r15)     // Catch:{ all -> 0x00a4 }
            goto L_0x04d2
        L_0x04cd:
            com.alibaba.fastjson.JSONObject r8 = new com.alibaba.fastjson.JSONObject     // Catch:{ all -> 0x00a4 }
            r8.<init>()     // Catch:{ all -> 0x00a4 }
        L_0x04d2:
            if (r10 != 0) goto L_0x04db
            if (r1 != 0) goto L_0x04db
            com.alibaba.fastjson.parser.ParseContext r15 = r13.setContext(r11, r8, r0)     // Catch:{ all -> 0x00a4 }
            goto L_0x04dc
        L_0x04db:
            r15 = 0
        L_0x04dc:
            r21 = r9
            com.alibaba.fastjson.parser.deserializer.FieldTypeResolver r9 = r13.fieldTypeResolver     // Catch:{ all -> 0x00a4 }
            if (r9 == 0) goto L_0x0500
            if (r0 == 0) goto L_0x04e9
            java.lang.String r9 = r0.toString()     // Catch:{ all -> 0x00a4 }
            goto L_0x04ea
        L_0x04e9:
            r9 = 0
        L_0x04ea:
            r18 = r12
            com.alibaba.fastjson.parser.deserializer.FieldTypeResolver r12 = r13.fieldTypeResolver     // Catch:{ all -> 0x00a4 }
            java.lang.reflect.Type r9 = r12.resolve(r2, r9)     // Catch:{ all -> 0x00a4 }
            if (r9 == 0) goto L_0x0502
            com.alibaba.fastjson.parser.ParserConfig r12 = r13.config     // Catch:{ all -> 0x00a4 }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r12 = r12.getDeserializer(r9)     // Catch:{ all -> 0x00a4 }
            java.lang.Object r9 = r12.deserialze(r13, r9, r0)     // Catch:{ all -> 0x00a4 }
            r12 = 1
            goto L_0x0504
        L_0x0500:
            r18 = r12
        L_0x0502:
            r9 = 0
            r12 = 0
        L_0x0504:
            if (r12 != 0) goto L_0x050a
            java.lang.Object r9 = r13.parseObject((java.util.Map) r8, (java.lang.Object) r0)     // Catch:{ all -> 0x00a4 }
        L_0x050a:
            if (r15 == 0) goto L_0x0510
            if (r8 == r9) goto L_0x0510
            r15.object = r2     // Catch:{ all -> 0x00a4 }
        L_0x0510:
            int r8 = r13.resolveStatus     // Catch:{ all -> 0x00a4 }
            r12 = 1
            if (r8 != r12) goto L_0x051c
            java.lang.String r8 = r0.toString()     // Catch:{ all -> 0x00a4 }
            r13.checkMapResolve(r2, r8)     // Catch:{ all -> 0x00a4 }
        L_0x051c:
            if (r7 == 0) goto L_0x0522
            r7.put(r0, r9)     // Catch:{ all -> 0x00a4 }
            goto L_0x0525
        L_0x0522:
            r2.put(r0, r9)     // Catch:{ all -> 0x00a4 }
        L_0x0525:
            if (r1 == 0) goto L_0x052a
            r13.setContext(r11, r9, r0)     // Catch:{ all -> 0x00a4 }
        L_0x052a:
            int r0 = r6.token     // Catch:{ all -> 0x00a4 }
            r1 = 13
            if (r0 != r1) goto L_0x053e
            r0 = 16
            r6.nextToken(r0)     // Catch:{ all -> 0x00a4 }
            if (r10 != 0) goto L_0x0539
            r13.contex = r11     // Catch:{ all -> 0x00a4 }
        L_0x0539:
            if (r10 != 0) goto L_0x053d
            r13.contex = r11
        L_0x053d:
            return r2
        L_0x053e:
            r1 = 16
            if (r0 != r1) goto L_0x0544
            goto L_0x068d
        L_0x0544:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x00a4 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a4 }
            r1.<init>()     // Catch:{ all -> 0x00a4 }
            r1.append(r5)     // Catch:{ all -> 0x00a4 }
            java.lang.String r2 = r6.info()     // Catch:{ all -> 0x00a4 }
            r1.append(r2)     // Catch:{ all -> 0x00a4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a4 }
            r0.<init>(r1)     // Catch:{ all -> 0x00a4 }
            throw r0     // Catch:{ all -> 0x00a4 }
        L_0x055d:
            r21 = r9
            r18 = r12
            r8 = 116(0x74, float:1.63E-43)
            if (r1 != r8) goto L_0x057d
            java.lang.String r1 = r6.text     // Catch:{ all -> 0x00a4 }
            java.lang.String r8 = "true"
            int r9 = r6.bp     // Catch:{ all -> 0x00a4 }
            boolean r1 = r1.startsWith(r8, r9)     // Catch:{ all -> 0x00a4 }
            if (r1 == 0) goto L_0x059b
            int r1 = r6.bp     // Catch:{ all -> 0x00a4 }
            int r1 = r1 + 3
            r6.bp = r1     // Catch:{ all -> 0x00a4 }
            r6.next()     // Catch:{ all -> 0x00a4 }
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00a4 }
            goto L_0x0598
        L_0x057d:
            r8 = 102(0x66, float:1.43E-43)
            if (r1 != r8) goto L_0x0661
            java.lang.String r1 = r6.text     // Catch:{ all -> 0x00a4 }
            java.lang.String r8 = "false"
            int r9 = r6.bp     // Catch:{ all -> 0x00a4 }
            boolean r1 = r1.startsWith(r8, r9)     // Catch:{ all -> 0x00a4 }
            if (r1 == 0) goto L_0x059b
            int r1 = r6.bp     // Catch:{ all -> 0x00a4 }
            r8 = 4
            int r1 = r1 + r8
            r6.bp = r1     // Catch:{ all -> 0x00a4 }
            r6.next()     // Catch:{ all -> 0x00a4 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00a4 }
        L_0x0598:
            r2.put(r0, r1)     // Catch:{ all -> 0x00a4 }
        L_0x059b:
            char r0 = r6.ch     // Catch:{ all -> 0x00a4 }
            r1 = 44
            if (r0 == r1) goto L_0x05aa
            r1 = 125(0x7d, float:1.75E-43)
            if (r0 == r1) goto L_0x05aa
            r6.skipWhitespace()     // Catch:{ all -> 0x00a4 }
            char r0 = r6.ch     // Catch:{ all -> 0x00a4 }
        L_0x05aa:
            r1 = 44
            if (r0 != r1) goto L_0x05c5
            int r0 = r6.bp     // Catch:{ all -> 0x00a4 }
            int r0 = r0 + 1
            r6.bp = r0     // Catch:{ all -> 0x00a4 }
            int r1 = r6.len     // Catch:{ all -> 0x00a4 }
            if (r0 < r1) goto L_0x05bb
            r0 = 26
            goto L_0x05c1
        L_0x05bb:
            java.lang.String r1 = r6.text     // Catch:{ all -> 0x00a4 }
            char r0 = r1.charAt(r0)     // Catch:{ all -> 0x00a4 }
        L_0x05c1:
            r6.ch = r0     // Catch:{ all -> 0x00a4 }
            goto L_0x068d
        L_0x05c5:
            r1 = 125(0x7d, float:1.75E-43)
            if (r0 != r1) goto L_0x0648
            int r0 = r6.bp     // Catch:{ all -> 0x00a4 }
            int r0 = r0 + 1
            r6.bp = r0     // Catch:{ all -> 0x00a4 }
            int r1 = r6.len     // Catch:{ all -> 0x00a4 }
            if (r0 < r1) goto L_0x05d6
            r0 = 26
            goto L_0x05dc
        L_0x05d6:
            java.lang.String r1 = r6.text     // Catch:{ all -> 0x00a4 }
            char r0 = r1.charAt(r0)     // Catch:{ all -> 0x00a4 }
        L_0x05dc:
            r6.ch = r0     // Catch:{ all -> 0x00a4 }
            r1 = 0
            r6.sp = r1     // Catch:{ all -> 0x00a4 }
            r1 = 44
            if (r0 != r1) goto L_0x05fd
            int r0 = r6.bp     // Catch:{ all -> 0x00a4 }
            int r0 = r0 + 1
            r6.bp = r0     // Catch:{ all -> 0x00a4 }
            int r1 = r6.len     // Catch:{ all -> 0x00a4 }
            if (r0 < r1) goto L_0x05f2
            r0 = 26
            goto L_0x05f8
        L_0x05f2:
            java.lang.String r1 = r6.text     // Catch:{ all -> 0x00a4 }
            char r0 = r1.charAt(r0)     // Catch:{ all -> 0x00a4 }
        L_0x05f8:
            r6.ch = r0     // Catch:{ all -> 0x00a4 }
            r0 = 16
            goto L_0x0618
        L_0x05fd:
            r1 = 125(0x7d, float:1.75E-43)
            if (r0 != r1) goto L_0x061b
            int r0 = r6.bp     // Catch:{ all -> 0x00a4 }
            int r0 = r0 + 1
            r6.bp = r0     // Catch:{ all -> 0x00a4 }
            int r1 = r6.len     // Catch:{ all -> 0x00a4 }
            if (r0 < r1) goto L_0x060e
            r0 = 26
            goto L_0x0614
        L_0x060e:
            java.lang.String r1 = r6.text     // Catch:{ all -> 0x00a4 }
            char r0 = r1.charAt(r0)     // Catch:{ all -> 0x00a4 }
        L_0x0614:
            r6.ch = r0     // Catch:{ all -> 0x00a4 }
            r0 = 13
        L_0x0618:
            r6.token = r0     // Catch:{ all -> 0x00a4 }
            goto L_0x063c
        L_0x061b:
            r1 = 93
            if (r0 != r1) goto L_0x0639
            int r0 = r6.bp     // Catch:{ all -> 0x00a4 }
            int r0 = r0 + 1
            r6.bp = r0     // Catch:{ all -> 0x00a4 }
            int r1 = r6.len     // Catch:{ all -> 0x00a4 }
            if (r0 < r1) goto L_0x062c
            r0 = 26
            goto L_0x0632
        L_0x062c:
            java.lang.String r1 = r6.text     // Catch:{ all -> 0x00a4 }
            char r0 = r1.charAt(r0)     // Catch:{ all -> 0x00a4 }
        L_0x0632:
            r6.ch = r0     // Catch:{ all -> 0x00a4 }
            r0 = 15
            r6.token = r0     // Catch:{ all -> 0x00a4 }
            goto L_0x063c
        L_0x0639:
            r6.nextToken()     // Catch:{ all -> 0x00a4 }
        L_0x063c:
            if (r10 != 0) goto L_0x0643
            com.alibaba.fastjson.parser.ParseContext r0 = r13.contex     // Catch:{ all -> 0x00a4 }
            r13.setContext(r0, r2, r4)     // Catch:{ all -> 0x00a4 }
        L_0x0643:
            if (r10 != 0) goto L_0x0647
            r13.contex = r11
        L_0x0647:
            return r2
        L_0x0648:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x00a4 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a4 }
            r1.<init>()     // Catch:{ all -> 0x00a4 }
            r1.append(r5)     // Catch:{ all -> 0x00a4 }
            java.lang.String r2 = r6.info()     // Catch:{ all -> 0x00a4 }
            r1.append(r2)     // Catch:{ all -> 0x00a4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a4 }
            r0.<init>(r1)     // Catch:{ all -> 0x00a4 }
            throw r0     // Catch:{ all -> 0x00a4 }
        L_0x0661:
            r6.nextToken()     // Catch:{ all -> 0x00a4 }
            java.lang.Object r1 = r14.parse()     // Catch:{ all -> 0x00a4 }
            java.lang.Class r8 = r3.getClass()     // Catch:{ all -> 0x00a4 }
            java.lang.Class<com.alibaba.fastjson.JSONObject> r9 = com.alibaba.fastjson.JSONObject.class
            if (r8 != r9) goto L_0x0674
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00a4 }
        L_0x0674:
            r2.put(r0, r1)     // Catch:{ all -> 0x00a4 }
            int r0 = r6.token     // Catch:{ all -> 0x00a4 }
            r1 = 13
            if (r0 != r1) goto L_0x0687
            r0 = 16
            r6.nextToken(r0)     // Catch:{ all -> 0x00a4 }
            if (r10 != 0) goto L_0x0686
            r13.contex = r11
        L_0x0686:
            return r2
        L_0x0687:
            r0 = 16
            int r1 = r6.token     // Catch:{ all -> 0x00a4 }
            if (r1 != r0) goto L_0x06a2
        L_0x068d:
            r1 = r19
            r8 = r21
            r0 = r2
            r2 = r3
            r3 = r4
            r5 = r6
            r6 = r7
            r9 = r10
            r10 = r11
            r12 = r13
            r13 = r14
            r7 = r17
            r11 = r18
            r4 = r20
            goto L_0x006a
        L_0x06a2:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x00a4 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a4 }
            r1.<init>()     // Catch:{ all -> 0x00a4 }
            r1.append(r5)     // Catch:{ all -> 0x00a4 }
            java.lang.String r2 = r6.info()     // Catch:{ all -> 0x00a4 }
            r1.append(r2)     // Catch:{ all -> 0x00a4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a4 }
            r0.<init>(r1)     // Catch:{ all -> 0x00a4 }
            throw r0     // Catch:{ all -> 0x00a4 }
        L_0x06bb:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x00a4 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a4 }
            r1.<init>()     // Catch:{ all -> 0x00a4 }
            r1.append(r5)     // Catch:{ all -> 0x00a4 }
            java.lang.String r2 = r6.info()     // Catch:{ all -> 0x00a4 }
            r1.append(r2)     // Catch:{ all -> 0x00a4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a4 }
            r0.<init>(r1)     // Catch:{ all -> 0x00a4 }
            throw r0     // Catch:{ all -> 0x00a4 }
        L_0x06d4:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x00a4 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a4 }
            r1.<init>()     // Catch:{ all -> 0x00a4 }
            r1.append(r5)     // Catch:{ all -> 0x00a4 }
            java.lang.String r2 = r6.info()     // Catch:{ all -> 0x00a4 }
            r1.append(r2)     // Catch:{ all -> 0x00a4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a4 }
            r0.<init>(r1)     // Catch:{ all -> 0x00a4 }
            throw r0     // Catch:{ all -> 0x00a4 }
        L_0x06ed:
            r0 = move-exception
        L_0x06ee:
            if (r9 != 0) goto L_0x06f2
            r12.contex = r10
        L_0x06f2:
            goto L_0x06f4
        L_0x06f3:
            throw r0
        L_0x06f4:
            goto L_0x06f3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parseObject(java.util.Map, java.lang.Object):java.lang.Object");
    }

    public void parseObject(Object obj) {
        Object obj2;
        Class<?> cls = obj.getClass();
        ObjectDeserializer deserializer = this.config.getDeserializer(cls);
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        int i = this.lexer.token;
        if (i == 12 || i == 16) {
            while (true) {
                String scanSymbol = this.lexer.scanSymbol(this.symbolTable);
                if (scanSymbol == null) {
                    JSONLexer jSONLexer = this.lexer;
                    int i2 = jSONLexer.token;
                    if (i2 == 13) {
                        jSONLexer.nextToken(16);
                        return;
                    } else if (i2 == 16) {
                        continue;
                    }
                }
                FieldDeserializer fieldDeserializer = javaBeanDeserializer != null ? javaBeanDeserializer.getFieldDeserializer(scanSymbol) : null;
                if (fieldDeserializer == null) {
                    JSONLexer jSONLexer2 = this.lexer;
                    if ((jSONLexer2.features & Feature.IgnoreNotMatch.mask) != 0) {
                        jSONLexer2.nextTokenWithChar(':');
                        parse();
                        JSONLexer jSONLexer3 = this.lexer;
                        if (jSONLexer3.token == 13) {
                            jSONLexer3.nextToken();
                            return;
                        }
                    } else {
                        StringBuilder n = a.n("setter not found, class ");
                        n.append(cls.getName());
                        n.append(", property ");
                        n.append(scanSymbol);
                        throw new JSONException(n.toString());
                    }
                } else {
                    FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                    Class<?> cls2 = fieldInfo.fieldClass;
                    Type type = fieldInfo.fieldType;
                    if (cls2 != Integer.TYPE) {
                        if (cls2 == String.class) {
                            this.lexer.nextTokenWithChar(':');
                            obj2 = parseString();
                        } else if (cls2 != Long.TYPE) {
                            ObjectDeserializer deserializer2 = this.config.getDeserializer(cls2, type);
                            this.lexer.nextTokenWithChar(':');
                            obj2 = deserializer2.deserialze(this, type, (Object) null);
                        }
                        fieldDeserializer.setValue(obj, obj2);
                        JSONLexer jSONLexer4 = this.lexer;
                        int i3 = jSONLexer4.token;
                        if (i3 != 16 && i3 == 13) {
                            jSONLexer4.nextToken(16);
                            return;
                        }
                    }
                    this.lexer.nextTokenWithChar(':');
                    obj2 = IntegerCodec.instance.deserialze(this, type, (Object) null);
                    fieldDeserializer.setValue(obj, obj2);
                    JSONLexer jSONLexer42 = this.lexer;
                    int i32 = jSONLexer42.token;
                    jSONLexer42.nextToken(16);
                    return;
                }
            }
        } else {
            StringBuilder n2 = a.n("syntax error, expect {, actual ");
            n2.append(JSONToken.name(i));
            throw new JSONException(n2.toString());
        }
    }

    public String parseString() {
        JSONLexer jSONLexer;
        JSONLexer jSONLexer2 = this.lexer;
        int i = jSONLexer2.token;
        int i2 = 16;
        if (i == 4) {
            String stringVal = jSONLexer2.stringVal();
            JSONLexer jSONLexer3 = this.lexer;
            char c2 = jSONLexer3.ch;
            char c3 = JSONLexer.EOI;
            if (c2 == ',') {
                int i3 = jSONLexer3.bp + 1;
                jSONLexer3.bp = i3;
                if (i3 < jSONLexer3.len) {
                    c3 = jSONLexer3.text.charAt(i3);
                }
                jSONLexer3.ch = c3;
                jSONLexer = this.lexer;
            } else if (c2 == ']') {
                int i4 = jSONLexer3.bp + 1;
                jSONLexer3.bp = i4;
                if (i4 < jSONLexer3.len) {
                    c3 = jSONLexer3.text.charAt(i4);
                }
                jSONLexer3.ch = c3;
                jSONLexer = this.lexer;
                i2 = 15;
            } else if (c2 == '}') {
                int i5 = jSONLexer3.bp + 1;
                jSONLexer3.bp = i5;
                if (i5 < jSONLexer3.len) {
                    c3 = jSONLexer3.text.charAt(i5);
                }
                jSONLexer3.ch = c3;
                jSONLexer = this.lexer;
                i2 = 13;
            } else {
                jSONLexer3.nextToken();
                return stringVal;
            }
            jSONLexer.token = i2;
            return stringVal;
        } else if (i == 2) {
            String numberString = jSONLexer2.numberString();
            this.lexer.nextToken(16);
            return numberString;
        } else {
            Object parse = parse();
            if (parse == null) {
                return null;
            }
            return parse.toString();
        }
    }

    public void popContext() {
        this.contex = this.contex.parent;
        ParseContext[] parseContextArr = this.contextArray;
        int i = this.contextArrayIndex;
        parseContextArr[i - 1] = null;
        this.contextArrayIndex = i - 1;
    }

    public ParseContext setContext(ParseContext parseContext, Object obj, Object obj2) {
        if (this.lexer.disableCircularReferenceDetect) {
            return null;
        }
        this.contex = new ParseContext(parseContext, obj, obj2);
        int i = this.contextArrayIndex;
        this.contextArrayIndex = i + 1;
        ParseContext[] parseContextArr = this.contextArray;
        if (parseContextArr == null) {
            this.contextArray = new ParseContext[8];
        } else if (i >= parseContextArr.length) {
            ParseContext[] parseContextArr2 = new ParseContext[((parseContextArr.length * 3) / 2)];
            System.arraycopy(parseContextArr, 0, parseContextArr2, 0, parseContextArr.length);
            this.contextArray = parseContextArr2;
        }
        ParseContext[] parseContextArr3 = this.contextArray;
        ParseContext parseContext2 = this.contex;
        parseContextArr3[i] = parseContext2;
        return parseContext2;
    }

    public void setContext(ParseContext parseContext) {
        if (!this.lexer.disableCircularReferenceDetect) {
            this.contex = parseContext;
        }
    }

    public void setDateFomrat(DateFormat dateFormat2) {
        this.dateFormat = dateFormat2;
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        this.dateFormat = null;
    }
}
