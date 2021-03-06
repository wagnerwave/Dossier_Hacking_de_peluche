package com.nineoldandroids.util;

import a.a.a.a.a;

public abstract class Property<T, V> {
    public final String mName;
    public final Class<V> mType;

    public Property(Class<V> cls, String str) {
        this.mName = str;
        this.mType = cls;
    }

    public static <T, V> Property<T, V> of(Class<T> cls, Class<V> cls2, String str) {
        return new ReflectiveProperty(cls, cls2, str);
    }

    public abstract V get(T t);

    public String getName() {
        return this.mName;
    }

    public Class<V> getType() {
        return this.mType;
    }

    public boolean isReadOnly() {
        return false;
    }

    public void set(T t, V v) {
        StringBuilder n = a.n("Property ");
        n.append(getName());
        n.append(" is read-only");
        throw new UnsupportedOperationException(n.toString());
    }
}
