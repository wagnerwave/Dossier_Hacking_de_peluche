package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;

public interface JSONSerializable {
    void write(JSONSerializer jSONSerializer, Object obj, Type type);
}
