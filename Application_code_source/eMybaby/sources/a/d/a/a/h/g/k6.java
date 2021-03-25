package a.d.a.a.h.g;

public enum k6 {
    VOID(Void.class, Void.class, (Class<?>) null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.FALSE),
    STRING(String.class, String.class, ""),
    BYTE_STRING(w4.class, w4.class, w4.f2000b),
    ENUM(Integer.TYPE, Integer.class, (Class<?>) null),
    MESSAGE(Object.class, Object.class, (Class<?>) null);
    

    /* renamed from: a  reason: collision with root package name */
    public final Class<?> f1774a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f1775b;

    /* access modifiers changed from: public */
    k6(Class<?> cls, Class<?> cls2, Object obj) {
        this.f1774a = cls2;
        this.f1775b = obj;
    }
}
