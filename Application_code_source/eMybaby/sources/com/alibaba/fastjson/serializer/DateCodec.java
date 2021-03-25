package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class DateCodec implements ObjectSerializer, ObjectDeserializer {
    public static final DateCodec instance = new DateCodec();

    public <T> T cast(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, String str) {
        if (obj2 == null) {
            return null;
        }
        if (obj2 instanceof Date) {
            return obj2;
        }
        if (obj2 instanceof Number) {
            return new Date(((Number) obj2).longValue());
        }
        if (obj2 instanceof String) {
            String str2 = (String) obj2;
            if (str2.length() == 0) {
                return null;
            }
            JSONLexer jSONLexer = new JSONLexer(str2);
            try {
                if (jSONLexer.scanISO8601DateIfMatch(false)) {
                    T t = jSONLexer.calendar;
                    if (type == Calendar.class) {
                        return t;
                    }
                    T time = t.getTime();
                    jSONLexer.close();
                    return time;
                }
                jSONLexer.close();
                if ("0000-00-00".equals(str2) || "0000-00-00T00:00:00".equalsIgnoreCase(str2) || "0001-01-01T00:00:00+08:00".equalsIgnoreCase(str2)) {
                    return null;
                }
                try {
                    return (str != null ? new SimpleDateFormat(str) : defaultJSONParser.getDateFormat()).parse(str2);
                } catch (ParseException unused) {
                    return new Date(Long.parseLong(str2));
                }
            } finally {
                jSONLexer.close();
            }
        } else {
            throw new JSONException("parse error");
        }
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return deserialze(defaultJSONParser, type, obj, (String) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x010f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0110  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r11, java.lang.reflect.Type r12, java.lang.Object r13, java.lang.String r14) {
        /*
            r10 = this;
            com.alibaba.fastjson.parser.JSONLexer r0 = r11.lexer
            int r1 = r0.token()
            r2 = 0
            r3 = 2
            r4 = 16
            if (r1 != r3) goto L_0x0019
            long r5 = r0.longValue()
            java.lang.Long r1 = java.lang.Long.valueOf(r5)
            r0.nextToken(r4)
            goto L_0x00fd
        L_0x0019:
            r5 = 4
            if (r1 != r5) goto L_0x004b
            java.lang.String r1 = r0.stringVal()
            r0.nextToken(r4)
            int r3 = r0.features
            com.alibaba.fastjson.parser.Feature r4 = com.alibaba.fastjson.parser.Feature.AllowISO8601DateFormat
            int r4 = r4.mask
            r3 = r3 & r4
            if (r3 == 0) goto L_0x00fd
            com.alibaba.fastjson.parser.JSONLexer r3 = new com.alibaba.fastjson.parser.JSONLexer
            r3.<init>(r1)
            r4 = 1
            boolean r4 = r3.scanISO8601DateIfMatch(r4)
            if (r4 == 0) goto L_0x0046
            java.util.Calendar r1 = r3.calendar
            java.lang.Class<java.util.Calendar> r4 = java.util.Calendar.class
            if (r12 != r4) goto L_0x0042
            r3.close()
            return r1
        L_0x0042:
            java.util.Date r1 = r1.getTime()
        L_0x0046:
            r3.close()
            goto L_0x00fd
        L_0x004b:
            r6 = 8
            if (r1 != r6) goto L_0x0055
            r0.nextToken()
            r7 = r2
            goto L_0x00fe
        L_0x0055:
            r6 = 12
            r7 = 13
            r8 = 17
            java.lang.String r9 = "syntax error"
            if (r1 != r6) goto L_0x00c3
            r0.nextToken()
            int r1 = r0.token()
            if (r1 != r5) goto L_0x00bd
            java.lang.String r1 = r0.stringVal()
            java.lang.String r6 = "@type"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x008f
            r0.nextToken()
            r11.accept(r8)
            java.lang.String r1 = r0.stringVal()
            com.alibaba.fastjson.parser.ParserConfig r6 = r11.config
            int r8 = r0.features
            java.lang.Class r1 = r6.checkAutoType(r1, r2, r8)
            if (r1 == 0) goto L_0x0089
            r12 = r1
        L_0x0089:
            r11.accept(r5)
            r11.accept(r4)
        L_0x008f:
            r1 = 58
            r0.nextTokenWithChar(r1)
            int r1 = r0.token()
            if (r1 != r3) goto L_0x00a6
            long r3 = r0.longValue()
            r0.nextToken()
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            goto L_0x00e9
        L_0x00a6:
            com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException
            java.lang.String r12 = "syntax error : "
            java.lang.StringBuilder r12 = a.a.a.a.a.n(r12)
            java.lang.String r13 = com.alibaba.fastjson.parser.JSONToken.name(r1)
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x00bd:
            com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException
            r11.<init>(r9)
            throw r11
        L_0x00c3:
            int r1 = r11.resolveStatus
            if (r1 != r3) goto L_0x00f9
            r1 = 0
            r11.resolveStatus = r1
            r11.accept(r4)
            int r1 = r0.token()
            if (r1 != r5) goto L_0x00f3
            java.lang.String r1 = r0.stringVal()
            java.lang.String r3 = "val"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x00ed
            r0.nextToken()
            r11.accept(r8)
            java.lang.Object r1 = r11.parse()
        L_0x00e9:
            r11.accept(r7)
            goto L_0x00fd
        L_0x00ed:
            com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException
            r11.<init>(r9)
            throw r11
        L_0x00f3:
            com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException
            r11.<init>(r9)
            throw r11
        L_0x00f9:
            java.lang.Object r1 = r11.parse()
        L_0x00fd:
            r7 = r1
        L_0x00fe:
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            r8 = r14
            java.lang.Object r11 = r3.cast(r4, r5, r6, r7, r8)
            java.lang.Class<java.util.Calendar> r13 = java.util.Calendar.class
            if (r12 != r13) goto L_0x0121
            boolean r12 = r11 instanceof java.util.Calendar
            if (r12 == 0) goto L_0x0110
            return r11
        L_0x0110:
            java.util.Date r11 = (java.util.Date) r11
            if (r11 != 0) goto L_0x0115
            return r2
        L_0x0115:
            java.util.TimeZone r12 = r0.timeZone
            java.util.Locale r13 = r0.locale
            java.util.Calendar r12 = java.util.Calendar.getInstance(r12, r13)
            r12.setTime(r11)
            return r12
        L_0x0121:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.DateCodec.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object, java.lang.String):java.lang.Object");
    }

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) {
        char[] cArr;
        int i;
        JSONSerializer jSONSerializer2 = jSONSerializer;
        Object obj3 = obj;
        SerializeWriter serializeWriter = jSONSerializer2.out;
        if (obj3 == null) {
            serializeWriter.writeNull();
        } else if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) == 0 || obj.getClass() == type) {
            Date time = obj3 instanceof Calendar ? ((Calendar) obj3).getTime() : (Date) obj3;
            if ((serializeWriter.features & SerializerFeature.WriteDateUseDateFormat.mask) != 0) {
                DateFormat dateFormat = jSONSerializer.getDateFormat();
                if (dateFormat == null) {
                    dateFormat = new SimpleDateFormat(JSON.DEFFAULT_DATE_FORMAT, jSONSerializer2.locale);
                    dateFormat.setTimeZone(jSONSerializer2.timeZone);
                }
                serializeWriter.writeString(dateFormat.format(time));
                return;
            }
            long time2 = time.getTime();
            int i2 = serializeWriter.features;
            if ((SerializerFeature.UseISO8601DateFormat.mask & i2) != 0) {
                if ((i2 & SerializerFeature.UseSingleQuotes.mask) != 0) {
                    serializeWriter.write(39);
                } else {
                    serializeWriter.write(34);
                }
                Calendar instance2 = Calendar.getInstance(jSONSerializer2.timeZone, jSONSerializer2.locale);
                instance2.setTimeInMillis(time2);
                int i3 = instance2.get(1);
                int i4 = instance2.get(2) + 1;
                int i5 = instance2.get(5);
                int i6 = instance2.get(11);
                int i7 = instance2.get(12);
                int i8 = instance2.get(13);
                int i9 = instance2.get(14);
                if (i9 != 0) {
                    cArr = "0000-00-00T00:00:00.000".toCharArray();
                    SerializeWriter.getChars((long) i9, 23, cArr);
                    SerializeWriter.getChars((long) i8, 19, cArr);
                    SerializeWriter.getChars((long) i7, 16, cArr);
                    SerializeWriter.getChars((long) i6, 13, cArr);
                    SerializeWriter.getChars((long) i5, 10, cArr);
                    SerializeWriter.getChars((long) i4, 7, cArr);
                    SerializeWriter.getChars((long) i3, 4, cArr);
                } else if (i8 == 0 && i7 == 0 && i6 == 0) {
                    cArr = "0000-00-00".toCharArray();
                    SerializeWriter.getChars((long) i5, 10, cArr);
                    SerializeWriter.getChars((long) i4, 7, cArr);
                    SerializeWriter.getChars((long) i3, 4, cArr);
                } else {
                    cArr = "0000-00-00T00:00:00".toCharArray();
                    SerializeWriter.getChars((long) i8, 19, cArr);
                    SerializeWriter.getChars((long) i7, 16, cArr);
                    SerializeWriter.getChars((long) i6, 13, cArr);
                    SerializeWriter.getChars((long) i5, 10, cArr);
                    SerializeWriter.getChars((long) i4, 7, cArr);
                    SerializeWriter.getChars((long) i3, 4, cArr);
                }
                serializeWriter.write(cArr);
                if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
                    serializeWriter.write(39);
                } else {
                    serializeWriter.write(34);
                }
            } else {
                serializeWriter.writeLong(time2);
            }
        } else {
            if (obj.getClass() == Date.class) {
                serializeWriter.write("new Date(");
                serializeWriter.writeLong(((Date) obj3).getTime());
                i = 41;
            } else {
                serializeWriter.write(123);
                serializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY, false);
                jSONSerializer2.write(obj.getClass().getName());
                serializeWriter.write(44);
                serializeWriter.writeFieldName("val", false);
                serializeWriter.writeLong(((Date) obj3).getTime());
                i = 125;
            }
            serializeWriter.write(i);
        }
    }
}
