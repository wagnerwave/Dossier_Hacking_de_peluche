package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public class ListTypeFieldDeserializer extends FieldDeserializer {
    public final boolean array;
    public ObjectDeserializer deserializer;
    public final Type itemType;

    public ListTypeFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) {
        super(cls, fieldInfo, 14);
        boolean z;
        Type type = fieldInfo.fieldType;
        Class<?> cls2 = fieldInfo.fieldClass;
        if (cls2.isArray()) {
            this.itemType = cls2.getComponentType();
            z = true;
        } else {
            this.itemType = TypeUtils.getCollectionItemType(type);
            z = false;
        }
        this.array = z;
    }

    /* JADX WARNING: type inference failed for: r4v10, types: [java.lang.reflect.Type] */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0184 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0178 A[EDGE_INSN: B:109:0x0178->B:71:0x0178 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01a4  */
    public final void parseArray(com.alibaba.fastjson.parser.DefaultJSONParser r13, java.lang.reflect.Type r14, java.util.Collection r15) {
        /*
            r12 = this;
            java.lang.reflect.Type r0 = r12.itemType
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r1 = r12.deserializer
            boolean r2 = r14 instanceof java.lang.reflect.ParameterizedType
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x00c3
            boolean r2 = r0 instanceof java.lang.reflect.TypeVariable
            r5 = 0
            r6 = -1
            if (r2 == 0) goto L_0x005f
            r2 = r0
            java.lang.reflect.TypeVariable r2 = (java.lang.reflect.TypeVariable) r2
            r3 = r14
            java.lang.reflect.ParameterizedType r3 = (java.lang.reflect.ParameterizedType) r3
            java.lang.reflect.Type r4 = r3.getRawType()
            boolean r4 = r4 instanceof java.lang.Class
            if (r4 == 0) goto L_0x0025
            java.lang.reflect.Type r4 = r3.getRawType()
            r5 = r4
            java.lang.Class r5 = (java.lang.Class) r5
        L_0x0025:
            if (r5 == 0) goto L_0x0047
            java.lang.reflect.TypeVariable[] r4 = r5.getTypeParameters()
            int r4 = r4.length
            r7 = 0
        L_0x002d:
            if (r7 >= r4) goto L_0x0047
            java.lang.reflect.TypeVariable[] r8 = r5.getTypeParameters()
            r8 = r8[r7]
            java.lang.String r8 = r8.getName()
            java.lang.String r9 = r2.getName()
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x0044
            goto L_0x0048
        L_0x0044:
            int r7 = r7 + 1
            goto L_0x002d
        L_0x0047:
            r7 = -1
        L_0x0048:
            if (r7 == r6) goto L_0x00c3
            java.lang.reflect.Type[] r0 = r3.getActualTypeArguments()
            r0 = r0[r7]
            java.lang.reflect.Type r2 = r12.itemType
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x00c3
            com.alibaba.fastjson.parser.ParserConfig r1 = r13.config
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r1 = r1.getDeserializer(r0)
            goto L_0x00c3
        L_0x005f:
            boolean r2 = r0 instanceof java.lang.reflect.ParameterizedType
            if (r2 == 0) goto L_0x00c3
            r2 = r0
            java.lang.reflect.ParameterizedType r2 = (java.lang.reflect.ParameterizedType) r2
            java.lang.reflect.Type[] r7 = r2.getActualTypeArguments()
            int r8 = r7.length
            if (r8 != r4) goto L_0x00c3
            r4 = r7[r3]
            boolean r4 = r4 instanceof java.lang.reflect.TypeVariable
            if (r4 == 0) goto L_0x00c3
            r3 = r7[r3]
            java.lang.reflect.TypeVariable r3 = (java.lang.reflect.TypeVariable) r3
            r4 = r14
            java.lang.reflect.ParameterizedType r4 = (java.lang.reflect.ParameterizedType) r4
            java.lang.reflect.Type r8 = r4.getRawType()
            boolean r8 = r8 instanceof java.lang.Class
            if (r8 == 0) goto L_0x0088
            java.lang.reflect.Type r5 = r4.getRawType()
            java.lang.Class r5 = (java.lang.Class) r5
        L_0x0088:
            if (r5 == 0) goto L_0x00aa
            java.lang.reflect.TypeVariable[] r8 = r5.getTypeParameters()
            int r8 = r8.length
            r9 = 0
        L_0x0090:
            if (r9 >= r8) goto L_0x00aa
            java.lang.reflect.TypeVariable[] r10 = r5.getTypeParameters()
            r10 = r10[r9]
            java.lang.String r10 = r10.getName()
            java.lang.String r11 = r3.getName()
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L_0x00a7
            goto L_0x00ab
        L_0x00a7:
            int r9 = r9 + 1
            goto L_0x0090
        L_0x00aa:
            r9 = -1
        L_0x00ab:
            if (r9 == r6) goto L_0x00c3
            java.lang.reflect.Type[] r0 = r4.getActualTypeArguments()
            r0 = r0[r9]
            r3 = 0
            r7[r3] = r0
            com.alibaba.fastjson.util.ParameterizedTypeImpl r0 = new com.alibaba.fastjson.util.ParameterizedTypeImpl
            java.lang.reflect.Type r3 = r2.getOwnerType()
            java.lang.reflect.Type r2 = r2.getRawType()
            r0.<init>(r7, r3, r2)
        L_0x00c3:
            com.alibaba.fastjson.parser.JSONLexer r2 = r13.lexer
            if (r1 != 0) goto L_0x00cf
            com.alibaba.fastjson.parser.ParserConfig r1 = r13.config
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r1 = r1.getDeserializer(r0)
            r12.deserializer = r1
        L_0x00cf:
            int r3 = r2.token
            r4 = 12
            r5 = 14
            if (r3 == r5) goto L_0x0115
            if (r3 != r4) goto L_0x00e6
            r14 = 0
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            java.lang.Object r13 = r1.deserialze(r13, r0, r14)
            r15.add(r13)
            return
        L_0x00e6:
            java.lang.String r13 = "exepct '[', but "
            java.lang.StringBuilder r13 = a.a.a.a.a.n(r13)
            int r15 = r2.token
            java.lang.String r15 = com.alibaba.fastjson.parser.JSONToken.name(r15)
            r13.append(r15)
            java.lang.String r13 = r13.toString()
            if (r14 == 0) goto L_0x010f
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r13)
            java.lang.String r13 = ", type : "
            r15.append(r13)
            r15.append(r14)
            java.lang.String r13 = r15.toString()
        L_0x010f:
            com.alibaba.fastjson.JSONException r14 = new com.alibaba.fastjson.JSONException
            r14.<init>(r13)
            throw r14
        L_0x0115:
            r14 = 0
            char r3 = r2.ch
            r6 = 15
            r7 = 34
            r8 = 123(0x7b, float:1.72E-43)
            r9 = 91
            r10 = 26
            if (r3 != r9) goto L_0x013c
            int r3 = r2.bp
            int r3 = r3 + 1
            r2.bp = r3
            int r11 = r2.len
            if (r3 < r11) goto L_0x0131
            r3 = 26
            goto L_0x0137
        L_0x0131:
            java.lang.String r11 = r2.text
            char r3 = r11.charAt(r3)
        L_0x0137:
            r2.ch = r3
            r2.token = r5
            goto L_0x017b
        L_0x013c:
            if (r3 != r8) goto L_0x0156
            int r3 = r2.bp
            int r3 = r3 + 1
            r2.bp = r3
            int r11 = r2.len
            if (r3 < r11) goto L_0x014b
            r3 = 26
            goto L_0x0151
        L_0x014b:
            java.lang.String r11 = r2.text
            char r3 = r11.charAt(r3)
        L_0x0151:
            r2.ch = r3
            r2.token = r4
            goto L_0x017b
        L_0x0156:
            if (r3 != r7) goto L_0x015c
            r2.scanString()
            goto L_0x017b
        L_0x015c:
            r11 = 93
            if (r3 != r11) goto L_0x0178
            int r3 = r2.bp
            int r3 = r3 + 1
            r2.bp = r3
            int r11 = r2.len
            if (r3 < r11) goto L_0x016d
            r3 = 26
            goto L_0x0173
        L_0x016d:
            java.lang.String r11 = r2.text
            char r3 = r11.charAt(r3)
        L_0x0173:
            r2.ch = r3
            r2.token = r6
            goto L_0x017b
        L_0x0178:
            r2.nextToken()
        L_0x017b:
            int r3 = r2.token
            r11 = 16
            if (r3 != r11) goto L_0x0182
            goto L_0x0178
        L_0x0182:
            if (r3 != r6) goto L_0x01a4
            char r13 = r2.ch
            r14 = 44
            if (r13 != r14) goto L_0x01a0
            int r13 = r2.bp
            int r13 = r13 + 1
            r2.bp = r13
            int r14 = r2.len
            if (r13 < r14) goto L_0x0195
            goto L_0x019b
        L_0x0195:
            java.lang.String r14 = r2.text
            char r10 = r14.charAt(r13)
        L_0x019b:
            r2.ch = r10
            r2.token = r11
            goto L_0x01a3
        L_0x01a0:
            r2.nextToken()
        L_0x01a3:
            return
        L_0x01a4:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r14)
            java.lang.Object r3 = r1.deserialze(r13, r0, r3)
            r15.add(r3)
            int r3 = r13.resolveStatus
            r6 = 1
            if (r3 != r6) goto L_0x01b7
            r13.checkListResolve(r15)
        L_0x01b7:
            int r3 = r2.token
            if (r3 != r11) goto L_0x01f9
            char r3 = r2.ch
            if (r3 != r9) goto L_0x01d6
            int r3 = r2.bp
            int r3 = r3 + r6
            r2.bp = r3
            int r6 = r2.len
            if (r3 < r6) goto L_0x01cb
            r3 = 26
            goto L_0x01d1
        L_0x01cb:
            java.lang.String r6 = r2.text
            char r3 = r6.charAt(r3)
        L_0x01d1:
            r2.ch = r3
            r2.token = r5
            goto L_0x01f9
        L_0x01d6:
            if (r3 != r8) goto L_0x01f0
            int r3 = r2.bp
            int r3 = r3 + 1
            r2.bp = r3
            int r6 = r2.len
            if (r3 < r6) goto L_0x01e5
            r3 = 26
            goto L_0x01eb
        L_0x01e5:
            java.lang.String r6 = r2.text
            char r3 = r6.charAt(r3)
        L_0x01eb:
            r2.ch = r3
            r2.token = r4
            goto L_0x01f9
        L_0x01f0:
            if (r3 != r7) goto L_0x01f6
            r2.scanString()
            goto L_0x01f9
        L_0x01f6:
            r2.nextToken()
        L_0x01f9:
            int r14 = r14 + 1
            r6 = 15
            goto L_0x017b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.ListTypeFieldDeserializer.parseArray(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.util.Collection):void");
    }

    public void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
        ArrayList arrayList;
        JSONArray jSONArray;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        if (i == 8 || (i == 4 && jSONLexer.stringVal().length() == 0)) {
            setValue(obj, (Object) null);
            defaultJSONParser.lexer.nextToken();
            return;
        }
        if (this.array) {
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.setComponentType(this.itemType);
            jSONArray = jSONArray2;
            arrayList = jSONArray2;
        } else {
            arrayList = new ArrayList();
            jSONArray = null;
        }
        ParseContext parseContext = defaultJSONParser.contex;
        defaultJSONParser.setContext(parseContext, obj, this.fieldInfo.name);
        parseArray(defaultJSONParser, type, arrayList);
        defaultJSONParser.setContext(parseContext);
        Object obj2 = arrayList;
        if (this.array) {
            Object array2 = arrayList.toArray((Object[]) Array.newInstance((Class) this.itemType, arrayList.size()));
            jSONArray.setRelatedArray(array2);
            obj2 = array2;
        }
        if (obj == null) {
            map.put(this.fieldInfo.name, obj2);
        } else {
            setValue(obj, obj2);
        }
    }
}
