package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class JSONSerializer {
    public List<AfterFilter> afterFilters;
    public List<BeforeFilter> beforeFilters;
    public final SerializeConfig config;
    public SerialContext context;
    public DateFormat dateFormat;
    public String dateFormatPattern;
    public int indentCount;
    public Locale locale;
    public List<NameFilter> nameFilters;
    public final SerializeWriter out;
    public List<PropertyFilter> propertyFilters;
    public List<PropertyPreFilter> propertyPreFilters;
    public IdentityHashMap<Object, SerialContext> references;
    public TimeZone timeZone;
    public List<ValueFilter> valueFilters;

    public JSONSerializer() {
        this(new SerializeWriter((Writer) null, JSON.DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY), SerializeConfig.globalInstance);
    }

    public JSONSerializer(SerializeConfig serializeConfig) {
        this(new SerializeWriter((Writer) null, JSON.DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY), serializeConfig);
    }

    public JSONSerializer(SerializeWriter serializeWriter) {
        this(serializeWriter, SerializeConfig.globalInstance);
    }

    public JSONSerializer(SerializeWriter serializeWriter, SerializeConfig serializeConfig) {
        this.beforeFilters = null;
        this.afterFilters = null;
        this.propertyFilters = null;
        this.valueFilters = null;
        this.nameFilters = null;
        this.propertyPreFilters = null;
        this.indentCount = 0;
        this.references = null;
        this.timeZone = JSON.defaultTimeZone;
        this.locale = JSON.defaultLocale;
        this.out = serializeWriter;
        this.config = serializeConfig;
        this.timeZone = JSON.defaultTimeZone;
    }

    public static Object processValue(JSONSerializer jSONSerializer, Object obj, Object obj2, Object obj3) {
        List<ValueFilter> list = jSONSerializer.valueFilters;
        if (list != null) {
            if (obj2 != null && !(obj2 instanceof String)) {
                obj2 = JSON.toJSONString(obj2);
            }
            for (ValueFilter process : list) {
                obj3 = process.process(obj, (String) obj2, obj3);
            }
        }
        return obj3;
    }

    public static final void write(SerializeWriter serializeWriter, Object obj) {
        new JSONSerializer(serializeWriter, SerializeConfig.globalInstance).write(obj);
    }

    public static final void write(Writer writer, Object obj) {
        SerializeWriter serializeWriter = new SerializeWriter((Writer) null, JSON.DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY);
        try {
            new JSONSerializer(serializeWriter, SerializeConfig.globalInstance).write(obj);
            serializeWriter.writeTo(writer);
            serializeWriter.close();
        } catch (IOException e2) {
            throw new JSONException(e2.getMessage(), e2);
        } catch (Throwable th) {
            serializeWriter.close();
            throw th;
        }
    }

    public boolean apply(Object obj, Object obj2, Object obj3) {
        List<PropertyFilter> list = this.propertyFilters;
        if (list == null) {
            return true;
        }
        if (obj2 != null && !(obj2 instanceof String)) {
            obj2 = JSON.toJSONString(obj2);
        }
        for (PropertyFilter apply : list) {
            if (!apply.apply(obj, (String) obj2, obj3)) {
                return false;
            }
        }
        return true;
    }

    public boolean applyName(Object obj, Object obj2) {
        List<PropertyPreFilter> list = this.propertyPreFilters;
        if (list == null) {
            return true;
        }
        for (PropertyPreFilter next : list) {
            if (obj2 != null && !(obj2 instanceof String)) {
                obj2 = JSON.toJSONString(obj2);
            }
            if (!next.apply(this, obj, (String) obj2)) {
                return false;
            }
        }
        return true;
    }

    public void close() {
        this.out.close();
    }

    public void config(SerializerFeature serializerFeature, boolean z) {
        this.out.config(serializerFeature, z);
    }

    public void decrementIdent() {
        this.indentCount--;
    }

    public List<AfterFilter> getAfterFilters() {
        if (this.afterFilters == null) {
            this.afterFilters = new ArrayList();
        }
        return this.afterFilters;
    }

    public List<BeforeFilter> getBeforeFilters() {
        if (this.beforeFilters == null) {
            this.beforeFilters = new ArrayList();
        }
        return this.beforeFilters;
    }

    public SerialContext getContext() {
        return this.context;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat == null && this.dateFormatPattern != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormatPattern, this.locale);
            this.dateFormat = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.timeZone);
        }
        return this.dateFormat;
    }

    public String getDateFormatPattern() {
        DateFormat dateFormat2 = this.dateFormat;
        return dateFormat2 instanceof SimpleDateFormat ? ((SimpleDateFormat) dateFormat2).toPattern() : this.dateFormatPattern;
    }

    public List<NameFilter> getNameFilters() {
        if (this.nameFilters == null) {
            this.nameFilters = new ArrayList();
        }
        return this.nameFilters;
    }

    public List<PropertyFilter> getPropertyFilters() {
        if (this.propertyFilters == null) {
            this.propertyFilters = new ArrayList();
        }
        return this.propertyFilters;
    }

    public List<PropertyPreFilter> getPropertyPreFilters() {
        if (this.propertyPreFilters == null) {
            this.propertyPreFilters = new ArrayList();
        }
        return this.propertyPreFilters;
    }

    public List<ValueFilter> getValueFilters() {
        if (this.valueFilters == null) {
            this.valueFilters = new ArrayList();
        }
        return this.valueFilters;
    }

    public SerializeWriter getWriter() {
        return this.out;
    }

    public void incrementIndent() {
        this.indentCount++;
    }

    public void println() {
        this.out.write(10);
        for (int i = 0; i < this.indentCount; i++) {
            this.out.write(9);
        }
    }

    public Object processKey(Object obj, Object obj2, Object obj3) {
        List<NameFilter> list = this.nameFilters;
        if (list != null) {
            if (obj2 != null && !(obj2 instanceof String)) {
                obj2 = JSON.toJSONString(obj2);
            }
            for (NameFilter process : list) {
                obj2 = process.process(obj, (String) obj2, obj3);
            }
        }
        return obj2;
    }

    public void setContext(SerialContext serialContext, Object obj, Object obj2, int i) {
        if ((this.out.features & SerializerFeature.DisableCircularReferenceDetect.mask) == 0) {
            this.context = new SerialContext(serialContext, obj, obj2, i);
            if (this.references == null) {
                this.references = new IdentityHashMap<>();
            }
            this.references.put(obj, this.context);
        }
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        if (this.dateFormat != null) {
            this.dateFormat = null;
        }
    }

    public void setDateFormat(DateFormat dateFormat2) {
        this.dateFormat = dateFormat2;
        if (this.dateFormatPattern != null) {
            this.dateFormatPattern = null;
        }
    }

    public String toString() {
        return this.out.toString();
    }

    public final void write(Object obj) {
        if (obj == null) {
            this.out.writeNull();
            return;
        }
        try {
            this.config.get(obj.getClass()).write(this, obj, (Object) null, (Type) null);
        } catch (IOException e2) {
            throw new JSONException(e2.getMessage(), e2);
        }
    }

    public final void write(String str) {
        if (str == null) {
            SerializeWriter serializeWriter = this.out;
            if ((serializeWriter.features & SerializerFeature.WriteNullStringAsEmpty.mask) != 0) {
                serializeWriter.writeString("");
            } else {
                serializeWriter.writeNull();
            }
        } else {
            SerializeWriter serializeWriter2 = this.out;
            if ((serializeWriter2.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
                serializeWriter2.writeStringWithSingleQuote(str);
            } else {
                serializeWriter2.writeStringWithDoubleQuote(str, 0, true);
            }
        }
    }

    public final void writeKeyValue(char c2, String str, Object obj) {
        if (c2 != 0) {
            this.out.write((int) c2);
        }
        this.out.writeFieldName(str, true);
        write(obj);
    }

    public void writeReference(Object obj) {
        SerializeWriter serializeWriter;
        String str;
        SerialContext serialContext = this.context;
        if (obj == serialContext.object) {
            serializeWriter = this.out;
            str = "{\"$ref\":\"@\"}";
        } else {
            SerialContext serialContext2 = serialContext.parent;
            if (serialContext2 == null || obj != serialContext2.object) {
                while (true) {
                    SerialContext serialContext3 = serialContext.parent;
                    if (serialContext3 == null) {
                        break;
                    }
                    serialContext = serialContext3;
                }
                if (obj == serialContext.object) {
                    serializeWriter = this.out;
                    str = "{\"$ref\":\"$\"}";
                } else {
                    String serialContext4 = this.references.get(obj).toString();
                    this.out.write("{\"$ref\":\"");
                    this.out.write(serialContext4);
                    serializeWriter = this.out;
                    str = "\"}";
                }
            } else {
                serializeWriter = this.out;
                str = "{\"$ref\":\"..\"}";
            }
        }
        serializeWriter.write(str);
    }

    public final void writeWithFieldName(Object obj, Object obj2) {
        writeWithFieldName(obj, obj2, (Type) null, 0);
    }

    public final void writeWithFieldName(Object obj, Object obj2, Type type, int i) {
        if (obj == null) {
            try {
                this.out.writeNull();
            } catch (IOException e2) {
                throw new JSONException(e2.getMessage(), e2);
            }
        } else {
            this.config.get(obj.getClass()).write(this, obj, obj2, type);
        }
    }

    public final void writeWithFormat(Object obj, String str) {
        if (obj instanceof Date) {
            DateFormat dateFormat2 = getDateFormat();
            if (dateFormat2 == null) {
                dateFormat2 = new SimpleDateFormat(str, this.locale);
                dateFormat2.setTimeZone(this.timeZone);
            }
            this.out.writeString(dateFormat2.format((Date) obj));
            return;
        }
        write(obj);
    }
}
