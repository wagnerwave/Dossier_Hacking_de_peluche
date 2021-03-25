package com.alibaba.fastjson.serializer;

public class SerialContext {
    public final int features;
    public final Object fieldName;
    public final Object object;
    public final SerialContext parent;

    public SerialContext(SerialContext serialContext, Object obj, Object obj2, int i) {
        this.parent = serialContext;
        this.object = obj;
        this.fieldName = obj2;
        this.features = i;
    }

    public String toString() {
        StringBuilder sb;
        if (this.parent == null) {
            return "$";
        }
        if (this.fieldName instanceof Integer) {
            sb = new StringBuilder();
            sb.append(this.parent.toString());
            sb.append("[");
            sb.append(this.fieldName);
            sb.append("]");
        } else {
            sb = new StringBuilder();
            sb.append(this.parent.toString());
            sb.append(".");
            sb.append(this.fieldName);
        }
        return sb.toString();
    }
}
