package com.alibaba.fastjson;

public class JSONStreamContext {
    public static final int ArrayValue = 1005;
    public static final int PropertyKey = 1002;
    public static final int PropertyValue = 1003;
    public static final int StartArray = 1004;
    public static final int StartObject = 1001;
    public final JSONStreamContext parent;
    public int state;

    public JSONStreamContext(JSONStreamContext jSONStreamContext, int i) {
        this.parent = jSONStreamContext;
        this.state = i;
    }
}
