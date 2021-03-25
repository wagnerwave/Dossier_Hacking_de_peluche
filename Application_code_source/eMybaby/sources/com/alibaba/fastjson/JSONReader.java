package com.alibaba.fastjson;

import a.a.a.a.a;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Map;

public class JSONReader implements Closeable {
    public JSONStreamContext context;
    public final DefaultJSONParser parser;
    public Reader reader;

    public JSONReader(DefaultJSONParser defaultJSONParser) {
        this.parser = defaultJSONParser;
    }

    public JSONReader(JSONLexer jSONLexer) {
        this(new DefaultJSONParser(jSONLexer));
    }

    public JSONReader(Reader reader2) {
        this(new JSONLexer(readAll(reader2)));
        this.reader = reader2;
    }

    private void endStructure() {
        int i;
        JSONStreamContext jSONStreamContext = this.context.parent;
        this.context = jSONStreamContext;
        if (jSONStreamContext != null) {
            switch (jSONStreamContext.state) {
                case 1001:
                case 1003:
                    i = 1002;
                    break;
                case 1002:
                    i = 1003;
                    break;
                case 1004:
                    i = 1005;
                    break;
                default:
                    i = -1;
                    break;
            }
            if (i != -1) {
                this.context.state = i;
            }
        }
    }

    private void readAfter() {
        int i = this.context.state;
        int i2 = 1002;
        switch (i) {
            case 1001:
            case 1003:
                break;
            case 1002:
                i2 = 1003;
                break;
            case 1004:
                i2 = 1005;
                break;
            case 1005:
                i2 = -1;
                break;
            default:
                throw new JSONException(a.h("illegal state : ", i));
        }
        if (i2 != -1) {
            this.context.state = i2;
        }
    }

    public static String readAll(Reader reader2) {
        StringBuilder sb = new StringBuilder();
        try {
            char[] cArr = new char[2048];
            while (true) {
                int read = reader2.read(cArr, 0, 2048);
                if (read < 0) {
                    return sb.toString();
                }
                sb.append(cArr, 0, read);
            }
        } catch (Exception e2) {
            throw new JSONException("read string from reader error", e2);
        }
    }

    private void readBefore() {
        int i;
        DefaultJSONParser defaultJSONParser;
        int i2 = this.context.state;
        switch (i2) {
            case 1001:
            case 1004:
                return;
            case 1002:
                defaultJSONParser = this.parser;
                i = 17;
                break;
            case 1003:
            case 1005:
                defaultJSONParser = this.parser;
                i = 16;
                break;
            default:
                throw new JSONException(a.h("illegal state : ", i2));
        }
        defaultJSONParser.accept(i);
    }

    private void startStructure() {
        int i;
        DefaultJSONParser defaultJSONParser;
        switch (this.context.state) {
            case 1001:
            case 1004:
                return;
            case 1002:
                defaultJSONParser = this.parser;
                i = 17;
                break;
            case 1003:
            case 1005:
                defaultJSONParser = this.parser;
                i = 16;
                break;
            default:
                StringBuilder n = a.n("illegal state : ");
                n.append(this.context.state);
                throw new JSONException(n.toString());
        }
        defaultJSONParser.accept(i);
    }

    public void close() {
        this.parser.lexer.close();
        Reader reader2 = this.reader;
        if (reader2 != null) {
            try {
                reader2.close();
            } catch (IOException e2) {
                throw new JSONException("closed reader error", e2);
            }
        }
    }

    public void config(Feature feature, boolean z) {
        this.parser.config(feature, z);
    }

    public void endArray() {
        this.parser.accept(15);
        endStructure();
    }

    public void endObject() {
        this.parser.accept(13);
        endStructure();
    }

    public boolean hasNext() {
        if (this.context != null) {
            int i = this.parser.lexer.token();
            int i2 = this.context.state;
            switch (i2) {
                case 1001:
                case 1003:
                    return i != 13;
                case 1004:
                case 1005:
                    return i != 15;
                default:
                    throw new JSONException(a.h("illegal state : ", i2));
            }
        } else {
            throw new JSONException("context is null");
        }
    }

    public int peek() {
        return this.parser.lexer.token();
    }

    public Integer readInteger() {
        Object obj;
        if (this.context == null) {
            obj = this.parser.parse();
        } else {
            readBefore();
            obj = this.parser.parse();
            readAfter();
        }
        return TypeUtils.castToInt(obj);
    }

    public Long readLong() {
        Object obj;
        if (this.context == null) {
            obj = this.parser.parse();
        } else {
            readBefore();
            obj = this.parser.parse();
            readAfter();
        }
        return TypeUtils.castToLong(obj);
    }

    public Object readObject() {
        if (this.context == null) {
            return this.parser.parse();
        }
        readBefore();
        Object parse = this.parser.parse();
        readAfter();
        return parse;
    }

    public <T> T readObject(TypeReference<T> typeReference) {
        return readObject(typeReference.type);
    }

    public <T> T readObject(Class<T> cls) {
        if (this.context == null) {
            return this.parser.parseObject(cls);
        }
        readBefore();
        T parseObject = this.parser.parseObject(cls);
        readAfter();
        return parseObject;
    }

    public <T> T readObject(Type type) {
        if (this.context == null) {
            return this.parser.parseObject(type);
        }
        readBefore();
        T parseObject = this.parser.parseObject(type);
        readAfter();
        return parseObject;
    }

    public Object readObject(Map map) {
        if (this.context == null) {
            return this.parser.parseObject(map);
        }
        readBefore();
        Object parseObject = this.parser.parseObject(map);
        readAfter();
        return parseObject;
    }

    public void readObject(Object obj) {
        if (this.context == null) {
            this.parser.parseObject(obj);
            return;
        }
        readBefore();
        this.parser.parseObject(obj);
        readAfter();
    }

    public String readString() {
        Object obj;
        if (this.context == null) {
            obj = this.parser.parse();
        } else {
            readBefore();
            obj = this.parser.parse();
            readAfter();
        }
        return TypeUtils.castToString(obj);
    }

    public void startArray() {
        JSONStreamContext jSONStreamContext;
        if (this.context == null) {
            jSONStreamContext = new JSONStreamContext((JSONStreamContext) null, 1004);
        } else {
            startStructure();
            jSONStreamContext = new JSONStreamContext(this.context, 1004);
        }
        this.context = jSONStreamContext;
        this.parser.accept(14);
    }

    public void startObject() {
        JSONStreamContext jSONStreamContext;
        if (this.context == null) {
            jSONStreamContext = new JSONStreamContext((JSONStreamContext) null, 1001);
        } else {
            startStructure();
            jSONStreamContext = new JSONStreamContext(this.context, 1001);
        }
        this.context = jSONStreamContext;
        this.parser.accept(12);
    }
}
